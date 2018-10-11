package com.sinosoft.pms.core.arealimit.service.impl;


import com.sinosoft.framework.core.dao.support.PredicateBuilder;
import com.sinosoft.framework.core.dao.support.Specifications;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DateUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.arealimit.dto.AreaLimitQueryConditionDto;
import com.sinosoft.pms.api.arealimit.dto.AreaLimitReturnDto;
import com.sinosoft.pms.api.arealimit.dto.AreaLimitsDto;
import com.sinosoft.pms.api.arealimit.dto.PrpdAreaLimitDto;
import com.sinosoft.pms.core.arealimit.dao.PrpDareaLimitDao;
import com.sinosoft.pms.core.arealimit.entity.PrpDareaLimit;
import com.sinosoft.pms.core.arealimit.service.AreaLimitService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class AreaLimitServiceImpl extends BaseServiceImpl implements AreaLimitService {

    private static Log LOGGER = LogFactory.getLog(AreaLimitServiceImpl.class);
    @Autowired
    private PrpDareaLimitDao prpDareaLimitDao;

    /**
     * @param prpDareaLimitDto
     * @return PrpDareaLimit
     * @description 查询区域销售限额, 此功能供核心系统出单查询使用
     * @author yinqingzhu
     */
    @Override
    public PrpdAreaLimitDto getAreaLimit(AreaLimitQueryConditionDto prpDareaLimitDto) throws Exception {
        return this.convert(prpDareaLimitDao.findOne(Specifications.<PrpDareaLimit>and()
                .eq(StringUtils.isNotEmpty(prpDareaLimitDto.getRiskCode()), "riskCode", prpDareaLimitDto.getRiskCode())
                .eq(StringUtils.isNotEmpty(prpDareaLimitDto.getVersionNo()), "versionNo", prpDareaLimitDto.getVersionNo())
                //其他模塊可能不知道版次號，故根據前端傳入的時間來查詢，条件為大於等於生效日期，小於等於失效日期
                .ge(prpDareaLimitDto.getIssueDate() != null, "effectDate", prpDareaLimitDto.getIssueDate())
                .le(prpDareaLimitDto.getIssueDate() != null, "invalidDate", prpDareaLimitDto.getIssueDate())
                .build()), PrpdAreaLimitDto.class);
    }

    /**
     * @return PageInfo<PrpdAreaLimitDto>
     * @description 查询最近一次有效的版本信息
     * @author yinqingzhu
     * @date 2016年9月27日上午11:05:48
     */
    @Override
    public List<PrpdAreaLimitDto> queryLateAreaLimit() {
        Date invalidDate = null;
        try {
            invalidDate = new SimpleDateFormat("yyyy-MM-dd").parse("9999-09-09");
        } catch (Exception e) {
        }
        List<PrpDareaLimit> prpDareaLimuitList =
                prpDareaLimitDao.findAll(Specifications.<PrpDareaLimit>and()
                        .eq("invalidDate", invalidDate)
                        .build(), new Sort(new Sort.Order(Sort.Direction.DESC, "salesLimit")));
        List<PrpdAreaLimitDto> prpdAreaLimitDtoList = new ArrayList<PrpdAreaLimitDto>();
        this.convertCollection(prpDareaLimuitList, prpdAreaLimitDtoList, PrpdAreaLimitDto.class);
        return prpdAreaLimitDtoList;
    }

    /**
     * @param queryAreaLimitsDto
     * @return queryAreaLimitsDto
     * @description 查询区域销售限额列表, 此功能供pms系统查询使用
     * @author yinqingzhu
     */
    @Override
    public PageInfo<PrpdAreaLimitDto> queryAreaLimitList(AreaLimitQueryConditionDto queryAreaLimitsDto) {
        Date issueDate = queryAreaLimitsDto.getIssueDate();

        Date issueDateTime = null;
        //前端传入的日期，时间为08:00:00 在此处将时间去掉后即可与数据库匹配。
        if (issueDate != null) {
            String strIssueDate = DateUtils.dateToStr(issueDate);
            issueDateTime = DateUtils.strToDate(strIssueDate);
        }
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "versionNo"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "salesRate"));
        orders.add(new Sort.Order(Sort.Direction.ASC, "salesLimit"));
        Pageable page = new PageRequest(queryAreaLimitsDto.getPageNo(), queryAreaLimitsDto.getPageSize(), new Sort(orders));
        Specification<PrpDareaLimit> specification = getConditions(queryAreaLimitsDto)
                .le(issueDateTime != null, "effectDate",issueDateTime)
                .ge(issueDateTime != null, "invalidDate",issueDateTime).build();
       return queryPage(specification, page);
    }

    /**
     * @param queryAreaLimitsDto
     * @return queryAreaLimitsDto
     * @description 保存区域销售限额, 此功能供pms系统维护使用
     * @author yinqingzhu
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AreaLimitReturnDto saveAreaLimits(AreaLimitsDto queryAreaLimitsDto) throws Exception {
        AreaLimitReturnDto result = new AreaLimitReturnDto();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //前端传来的日期有时间，在这里去掉时间，只保留日期
        Date tempEffectDate = queryAreaLimitsDto.getEffectDate();
        String strDate = sdf.format(tempEffectDate);
        Date newDate = sdf.parse(strDate);
        queryAreaLimitsDto.setEffectDate(newDate);

        //根据失效日期查询出数据库中最新数据的版次号
        List<PrpDareaLimit> areaLimitList = prpDareaLimitDao.findAll(Specifications.<PrpDareaLimit>and()
                .eq("invalidDate",DateUtils.strToDate("9999-09-09")).build());
        DecimalFormat df = new DecimalFormat("000");
        String versionNo = "";
        Date effectDate;
        if (areaLimitList != null && !areaLimitList.isEmpty()) {
            versionNo = df.format(Integer.parseInt(areaLimitList.get(0).getVersionNo().substring(1)) + 1);
            effectDate = queryAreaLimitsDto.getEffectDate();//页面录入的生效日期
        } else {
            versionNo = queryAreaLimitsDto.getAreaLimits().get(0).getVersionNo();
            effectDate = queryAreaLimitsDto.getAreaLimits().get(0).getEffectDate();//页面录入的生效日期
        }

        //生效日期不允许为空
        if (StringUtils.isBlank(versionNo) || effectDate == null) {
            result.setResultCode("N");
            result.setResultMsg("生效日期不允许为空!");
            return result;
        }
        //页面录入的生效日期不能在数据库中最新数据的生效日期之前
        //如果数据库中查询出的List不为空，就可以直接拿第一条数据的生效日期进行比较
        if (areaLimitList != null && !areaLimitList.isEmpty()) {
            //数据库中最新一批数据的生效日期
            if (effectDate.before(areaLimitList.get(0).getEffectDate())) {
                result.setResultCode("N");
                result.setResultMsg("新增版次不能早于上个版本的生效日期，上个版本生效日期为：" + sdf.format(areaLimitList.get(0).getEffectDate()));
                return result;
            }
        }
        //判断销售区域限额是否已存在，同一批次的数据版次号和生效日期相同
        if (!isAreaLimitRepeat(versionNo, effectDate)) {
            for (PrpdAreaLimitDto areaLimitDto : queryAreaLimitsDto.getAreaLimits()) {
                //对象转换
                PrpDareaLimit areaLimit = this.convert(areaLimitDto, PrpDareaLimit.class);
                //前端传来的生效日期和创建人在AreaLimitsDto中所以要把生效日期和创建人放进areaLimit中
                /*
				areaLimit.setEffectDate(queryAreaLimitsDto.getEffectDate());
				areaLimit.setCreateBy(queryAreaLimitsDto.getCreateBy());
				*/
                // 1. 查询库中数据，根据areaCode和RiskCode是否一致，将历史数据失效日期置为传入日期的前一天
                areaLimit.setInvalidDate(DateUtils.getPreviousDate(effectDate));
                areaLimit.setVersionNo(versionNo);
                String userName = queryAreaLimitsDto.getGlobalUserCode();
                if (StringUtils.isNotEmpty(userName)) {
                    //修改上一条数据的UpdateBy
                    areaLimit.setUpdateBy(userName);
                } else {
                    //下面要用user给CreateBy赋值，CreateBy不能为空，在此设置user，避免报错
                    userName = "非法登录，没有用户";
                }
                areaLimit.setUpdateTime(new Date());
                prpDareaLimitDao.updateInvalidDate(areaLimit.getInvalidDate(),areaLimit.getUpdateTime(),areaLimit.getUpdateBy(),areaLimit.getRiskCode(),areaLimit.getAreaCode());
                //更新完之后将UpdateBy 和 UpdateTime置为null
                areaLimit.setUpdateBy(null);
                areaLimit.setUpdateTime(null);
                // 2. 重新插入一条数据
                areaLimit.setInvalidDate(DateUtils.strToDate("9999-09-09"));
                //设置创建时间
                areaLimit.setCreateTime(new Date());
                //设置创建人
                areaLimit.setCreateBy(userName);
                //前端传入的versionNo在coinsRatesDto中，将前端传入的versionNo放入保存对象中
                areaLimit.setVersionNo(versionNo);
                //前端传入的eddectDate在coinsRatesDto中，将前端传入的eddectDate放入保存对象中
                areaLimit.setEffectDate(effectDate);
                //设置产品代码
                //areaLimit.setRiskCode("EQ01");
                areaLimit.setRiskCode(areaLimitDto.getRiskCode());
                areaLimit.setRiskName(queryAreaLimitsDto.getRiskName());
                prpDareaLimitDao.saveAndFlush(areaLimit);
            }
        } else {
            result.setResultCode("N");
            result.setResultMsg("销售区域限额已存在!");
            return result;
        }
        result.setResultCode("Y");
        result.setResultMsg("数据新增成功，版次号为：" + versionNo);
        return result;
    }

    /**
     * @return boolean
     * @description 根据版次号，生效日期，校验区域销售限额是否重复
     * @author yinqingzhu
     * @date 2016年9月28日上午11:53:36
     */
    private boolean isAreaLimitRepeat(String versionnNo, Date effectDate) {
        List<PrpDareaLimit> list = prpDareaLimitDao.findAll(Specifications.<PrpDareaLimit>and()
                .eq("versionNo",versionnNo)
                .eq("effectDate",effectDate).build());
        // 如果没有查到数据返回false
        if (list == null || list.size() == 0) {
            return false;
        }
        return true;
    }

    /**
     * @param specification
     * @param page
     * @return
     * @description 分页查询
     * @author yinqingzhu
     * @date 2016年9月29日上午9:33:55
     */
    private PageInfo<PrpdAreaLimitDto> queryPage(Specification<PrpDareaLimit> specification, Pageable page) {
        Page<PrpDareaLimit> prpDareaLimitPage = prpDareaLimitDao.findAll(specification, page);
        return this.convertPage(prpDareaLimitPage, PrpdAreaLimitDto.class);
    }

    private PredicateBuilder<PrpDareaLimit> getConditions(AreaLimitQueryConditionDto queryAreaLimitsDto) {
        return Specifications.<PrpDareaLimit>and()
                .eq(StringUtils.isNotEmpty(queryAreaLimitsDto.getAreaCode()), "areaCode", queryAreaLimitsDto.getAreaCode())
                .eq(StringUtils.isNotEmpty(queryAreaLimitsDto.getRiskCode()), "riskCode", queryAreaLimitsDto.getRiskCode())
                .eq(StringUtils.isNotEmpty(queryAreaLimitsDto.getRiskName()), "riskName", queryAreaLimitsDto.getRiskName())
                .eq(StringUtils.isNotEmpty(queryAreaLimitsDto.getVersionNo()), "versionNo", queryAreaLimitsDto.getVersionNo());
    }
}
