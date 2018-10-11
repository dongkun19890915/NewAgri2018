package com.sinosoft.pms.core.coinsrate.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DateUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.coinsrate.dto.CoinsRateQueryConditionDto;
import com.sinosoft.pms.api.coinsrate.dto.CoinsRateReturnDto;
import com.sinosoft.pms.api.coinsrate.dto.CoinsRatesDto;
import com.sinosoft.pms.api.coinsrate.dto.PrpDcoinsRateDto;
import com.sinosoft.pms.core.coinsrate.dao.PrpDcoinsRateDao;
import com.sinosoft.pms.core.coinsrate.entity.PrpDcoinsRate;
import com.sinosoft.pms.core.coinsrate.entity.PrpDcoinsRateKey;
import com.sinosoft.pms.core.coinsrate.service.CoinsRateService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CoinsRateServiceImpl extends BaseServiceImpl implements CoinsRateService {

    private static Log LOGGER = LogFactory.getLog(CoinsRateServiceImpl.class);

    @Autowired
    private PrpDcoinsRateDao prpDcoinsRateDao;

    /**
     * @param prpDcoinsRateDto
     * @return PrpDcoinsRateDto
     * @description 共保体成员比例查询，此功能供核心系统出单使用，返回CoinsRateDto
     * @author yinqingzhu
     * @date 2016年9月17日
     */
    @Override
    public PrpDcoinsRateDto getCoinsRate(CoinsRateQueryConditionDto prpDcoinsRateDto) {
        PrpDcoinsRateDto coinsRateDto = new PrpDcoinsRateDto();
        List<PrpDcoinsRate> newcoinsRateList = prpDcoinsRateDao.findAll(geneQueryConditions(prpDcoinsRateDto));
        if (!newcoinsRateList.isEmpty()) {
            // 根据前端传入数据查询，一定会有一条数据
            coinsRateDto.setCoinsRate(newcoinsRateList.get(0).getCoinsRate());
        }
        return coinsRateDto;
    }

    /**
     * @param queryDto
     * @return CoinsRateDto
     * @throws Exception
     * @description 共保体成员比例有效数据列表查询，此功能供pms系统查询共保体成员比例使用
     * @author yinqingzhu
     * @date 2016年9月17日
     */
    @Override
    public List<PrpDcoinsRateDto> queryLateCoinsRate(CoinsRateQueryConditionDto queryDto) throws Exception {
        List<PrpDcoinsRateDto> dtoList = new ArrayList<PrpDcoinsRateDto>();
        List<PrpDcoinsRate> coinsRateList = prpDcoinsRateDao.findAll(Specifications.<PrpDcoinsRate>and()
                        .eq("invalidDate", DateUtils.strToDate("9999-09-09")).build(),
                new Sort(new Sort.Order(Sort.Direction.DESC, "coinsRate")));
        this.convertCollection(coinsRateList, dtoList, PrpDcoinsRateDto.class);
        return dtoList;
    }

    /**
     * @param queryDto
     * @return PageInfo<PrpDcoinsRateDto>
     * @throws Exception
     * @description 共保体成员比例列表查询，此功能供pms系统查询共保体成员比例使用
     * @author yinqingzhu
     * @date 2016年9月17日
     */
    @Override
    public PageInfo<PrpDcoinsRateDto> queryCoinsRateList(CoinsRateQueryConditionDto queryDto) throws Exception {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "versionNo"));
        orders.add(new Sort.Order(Sort.Direction.ASC, "coinsRate"));
        Pageable page = new PageRequest(queryDto.getPageNo(), queryDto.getPageSize(),
                new Sort(orders));
        Date issueDate = queryDto.getIssueDate();
        Date issueDateTime = null;
        //前端传入的日期，时间为08:00:00 在此处将时间去掉后即可与数据库匹配。
        if (issueDate != null) {
            String strIssueDate = DateUtils.dateToStr(issueDate);
            issueDateTime = DateUtils.strToDate(strIssueDate);
        }
        return queryPage(Specifications.<PrpDcoinsRate>and()
                .le(issueDateTime != null, "effectDate", issueDateTime)
                .ge(issueDateTime != null, "invalidDate", issueDateTime)
                .eq(StringUtils.isNotEmpty(queryDto.getComCode()), "comCode", queryDto.getComCode())
                .eq(StringUtils.isNotEmpty(queryDto.getVersionNo()), "versionNo", queryDto.getVersionNo()).build(), page);
    }

    /**
     * @param specification
     * @param page
     * @return
     * @description 分页查询
     * @author yinqingzhu
     * @date 2016年9月29日上午9:33:55
     */
    private PageInfo<PrpDcoinsRateDto> queryPage(Specification<PrpDcoinsRate> specification, Pageable page) {
        return this.convertPage(prpDcoinsRateDao.findAll(specification, page), PrpDcoinsRateDto.class);
    }

    /**
     * @param coinsRatesDto
     * @return CoinsRateReturnDto
     * @throws Exception
     * @description 保存共保比例
     * @author yinqingzhu
     * @date 2016年9月28日下午9:11:40
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CoinsRateReturnDto savePrpdCoinsRateList(CoinsRatesDto coinsRatesDto) throws Exception {
        CoinsRateReturnDto result = new CoinsRateReturnDto();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //前端传来的日期有时间，在这里去掉时间，只保留日期
        Date tempEffectDate = coinsRatesDto.getEffectDate();
        String strDate = sdf.format(tempEffectDate);
        Date newDate = sdf.parse(strDate);
        coinsRatesDto.setEffectDate(newDate);
        //根据失效日期查询出最新数据，获取版次号
        List<PrpDcoinsRate> queryDateCoinsRate = prpDcoinsRateDao.findAll(Specifications.<PrpDcoinsRate>and()
                .eq("invalidDate",DateUtils.strToDate("9999-09-09")).build());
        DecimalFormat df = new DecimalFormat("000");
        String versionNo = "";
        Date effectDate;
        if (queryDateCoinsRate != null && !queryDateCoinsRate.isEmpty()) {
            versionNo = df.format(Integer.parseInt(queryDateCoinsRate.get(0).getVersionNo().substring(1)) + 1);

            effectDate = coinsRatesDto.getEffectDate();//页面中用户录入的生效日期
        } else {
            versionNo = coinsRatesDto.getPrpDcoinsRateDtos().get(0).getVersionNo();
            effectDate = coinsRatesDto.getPrpDcoinsRateDtos().get(0).getEffectDate();
        }
        // 判断生效日期和版次号是否为空
        if (effectDate == null && StringUtils.isEmpty(versionNo)) {
            result.setResultCode("N");
            result.setResultMsg("生效日期和版次号不能为空");
            return result;
        }
        //页面录入的生效日期不能在数据库中最新数据的生效日期之前
        //如果数据库中查询出的List不为空，就可以直接拿第一条数据的生效日期进行比较
        if (queryDateCoinsRate != null && !queryDateCoinsRate.isEmpty()) {
            //数据库中最新一批数据的生效日期
            if (effectDate.before(queryDateCoinsRate.get(0).getEffectDate())) {
                result.setResultCode("N");
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                result.setResultMsg("新增版次不能早于上个版本的生效日期，上个版本生效日期为：" + sdf.format(queryDateCoinsRate.get(0).getEffectDate()));
                return result;
            }
        }
        // 判断版次号和生效日期是否重复
        if (isCoinsRateRepeat(versionNo, effectDate)) {
            for (PrpDcoinsRateDto coinsRateDto : coinsRatesDto.getPrpDcoinsRateDtos()) {
                // 更新和存入数据库对象，并将页面传入的Dto转换成PrpDcoinsRate对象
                PrpDcoinsRate coinsRate = this.convert(coinsRateDto,PrpDcoinsRate.class);
                // 将原数据失效日期设置成新数据生效日期的前一天
                coinsRate.setInvalidDate(DateUtils.getPreviousDate(effectDate));
                String userName = coinsRatesDto.getGlobalUserCode();
                if (StringUtils.isNotEmpty(userName)) {
                    //修改上一条数据的UpdateBy
                    coinsRate.setUpdateBy(userName);
                } else {
                    //下面要用user给CreateBy赋值，CreateBy不能为空，在此设置user，避免报错
                    userName = "非法登录，没有用户";
                }
                coinsRate.setUpdateTime(new Date());
                prpDcoinsRateDao.updateInvalidDate(coinsRate.getInvalidDate(),coinsRate.getUpdateTime(),
                        coinsRate.getUpdateBy(),coinsRate.getRiskCode(),coinsRate.getComCode());
                //更新完之后将UpdateBy 和 UpdateTime 置为null
                coinsRate.setUpdateBy(null);
                coinsRate.setUpdateTime(null);
                // 上面将失效日期设为新数据的前一天，在插入前，要将失效日期设置为9999-09-09
                coinsRate.setInvalidDate(DateUtils.strToDate("9999-09-09"));
                // 设置创建日期
                coinsRate.setCreateTime(new Date());
                //设置创建人
                coinsRate.setCreateBy(userName);
                //前端传入的versionNo在coinsRatesDto中，将前端传入的versionNo放入保存对象中
                coinsRate.setVersionNo(versionNo);
                //前端传入的eddectDate在coinsRatesDto中，将前端传入的eddectDate放入保存对象中
                coinsRate.setEffectDate(effectDate);
                //共保比例设置为百分比
                coinsRate.setCoinsRate(coinsRate.getCoinsRate());
                //设置产品代码
                //coinsRate.setRiskCode("EQ01");
                coinsRate.setRiskCode(coinsRateDto.getRiskCode());
                //riskName 在 coinsRatesDto 中
                coinsRate.setRiskName(coinsRatesDto.getRiskName());
                prpDcoinsRateDao.saveAndFlush(coinsRate);
            }
            result.setResultCode("Y");
            result.setResultMsg("数据新增成功，版次号：" + versionNo);
            return result;
        } else {
            result.setResultCode("N");
            result.setResultMsg("共保比例数据已存在");
            return result;
        }
    }

    /**
     * @param coinsRateDto
     * @return CoinsRateReturnDto
     * @description 刪除共保比例
     * @author yinqingzhu
     * @date 2016年9月17日
     */
    @Override
    public CoinsRateReturnDto deletePrpdCoinsRate(PrpDcoinsRateDto coinsRateDto) throws Exception {
        CoinsRateReturnDto returnDto = new CoinsRateReturnDto();
        PrpDcoinsRateKey key = new PrpDcoinsRateKey();
        if (StringUtils.isNotEmpty(coinsRateDto.getRiskCode())) {
            key.setRiskCode(coinsRateDto.getRiskCode());
        }
        if (StringUtils.isNotEmpty(coinsRateDto.getComCode())) {
            key.setComCode(coinsRateDto.getComCode());
        }
        if (StringUtils.isNotEmpty(coinsRateDto.getVersionNo())) {
            key.setVersionNo(coinsRateDto.getVersionNo());
        }
        prpDcoinsRateDao.delete(key);
        return returnDto;
    }

    /**
     * @param versionNo:版次号 effectDate：生效日期
     * @return Boolean
     * @description 版次号和生效日期重复性校验, 如果同意产品传入的生效日期和版次号和数据库中查询出的相同，则不允许插入
     * @author yinqingzhu
     * @date 2016年9月12日
     */
    private Boolean isCoinsRateRepeat(String versionNo, Date effectDate) {
        //根据生效日期和版次号查询,如果查不到数据，则表示不重复，可以插入新增数据
        List<PrpDcoinsRate> coinsRateList = prpDcoinsRateDao.findAll(Specifications.<PrpDcoinsRate>and()
        .eq("versionNo", versionNo).eq("effectDate",effectDate).build());
        if (coinsRateList == null || coinsRateList.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * @param prpDcoinsRateDto
     * @return Specification
     * @description 根据传入的对象，组装查询条件
     * @author yinqingzhu
     * @date 2016年9月29日上午10:53:19
     */
    private Specification<PrpDcoinsRate> geneQueryConditions(CoinsRateQueryConditionDto prpDcoinsRateDto) {
        return Specifications.<PrpDcoinsRate>and()
                .eq(StringUtils.isNotEmpty(prpDcoinsRateDto.getRiskCode()), "riskCode", prpDcoinsRateDto.getRiskCode())
                .eq(StringUtils.isNotEmpty(prpDcoinsRateDto.getComCode()), "comCode", prpDcoinsRateDto.getComCode())
                .eq(StringUtils.isNotEmpty(prpDcoinsRateDto.getVersionNo()), "versionNo", prpDcoinsRateDto.getVersionNo())
                .ge(prpDcoinsRateDto.getInvalidDate() != null, "effectDate", prpDcoinsRateDto.getInvalidDate())
                .le(prpDcoinsRateDto.getInvalidDate() != null, "invalidDate", prpDcoinsRateDto.getInvalidDate())
                .lt(prpDcoinsRateDto.getIssueDate() != null, "effectDate", prpDcoinsRateDto.getIssueDate()).build();
    }

}
