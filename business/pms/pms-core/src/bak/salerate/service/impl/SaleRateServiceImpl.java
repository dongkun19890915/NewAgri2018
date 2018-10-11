package com.sinosoft.pms.core.salerate.service.impl;

import com.sinosoft.dms.api.dict.CodeApi;
import com.sinosoft.dms.api.dict.dto.NewCodeQueryConditionDto;
import com.sinosoft.dms.api.dict.dto.PrpDNewCodeDto;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DateUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.salerate.dto.PrpdSalesRateDto;
import com.sinosoft.pms.api.salerate.dto.SaleRateQueryConditionDto;
import com.sinosoft.pms.api.salerate.dto.SaleRateReturnDto;
import com.sinosoft.pms.core.salerate.dao.PrpDsalesRateDao;
import com.sinosoft.pms.core.salerate.entity.PrpDsalesRate;
import com.sinosoft.pms.core.salerate.service.SaleRateService;
import org.apache.commons.lang3.StringUtils;
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
public class SaleRateServiceImpl extends BaseServiceImpl implements SaleRateService {
	@Autowired
	private PrpDsalesRateDao prpDsalesRateDao;

	@Autowired
    private CodeApi codeApi;
	
	
	
	/**
     *@description 销售费率查询，此功能供核心系统查询销售费率使用
    * @param  saleRateDto
    * @return PrpdSalesRateDto
    * @author yinqingzhu
    * @date 2016年9月14日
    */
	public PrpdSalesRateDto getSaleRate(SaleRateQueryConditionDto saleRateDto) throws Exception{
		PrpdSalesRateDto prpdSalesRateDto = new PrpdSalesRateDto();
		List<PrpDsalesRate> prpDsalesRates =prpDsalesRateDao.findAll(Specifications.<PrpDsalesRate>and()
				.eq(StringUtils.isNotEmpty(saleRateDto.getRiskCode()),"riskCode",saleRateDto.getRiskCode())
				.eq(StringUtils.isNotEmpty(saleRateDto.getBusinessNature()),"businessNatrue",saleRateDto.getBusinessNature())
				.le(saleRateDto.getIssueDate() != null ,"effectDate",saleRateDto.getIssueDate())
				.gt(saleRateDto.getIssueDate() != null, "invalidDate", saleRateDto.getIssueDate())
				.build());
		PrpDsalesRate prpDsalesRate = new PrpDsalesRate();
		if(!prpDsalesRates.isEmpty()){
			prpDsalesRate = prpDsalesRates.get(0);
			prpdSalesRateDto.setSalesRate(prpDsalesRate.getSalesRate());
		}
		return prpdSalesRateDto;
	}
	/**
	 * @description 销售费率列表查询，此功能供pms系统查询销售费率使用
	 * @param saleRatesDto
	 * @return PageInfo<PrpdSalesRateDto>
	 * @author yinqingzhu
	 * @date 2016年9月12日
	*/
	/* (non-Javadoc)
	 * @see SaleRateService#quereyPrpdSalesRateList(SaleRateQueryConditionDto)
	 */
	public PageInfo<PrpdSalesRateDto> quereyPrpdSalesRateList(SaleRateQueryConditionDto saleRatesDto) throws Exception{
			List<Sort.Order> orders = new ArrayList<Sort.Order>();
			orders.add(new Sort.Order(Sort.Direction.ASC,"businessNatrue"));
			orders.add(new Sort.Order(Sort.Direction.DESC,"versionNo"));
			orders.add(new Sort.Order(Sort.Direction.DESC,"salesRate"));
			Pageable page = new PageRequest(saleRatesDto.getPageNo(),saleRatesDto.getPageSize(),new Sort(orders));
			Date issueDate = saleRatesDto.getIssueDate();
			Date issueDateTime = null;
			//前端传入的日期，时间为08:00:00 在此处将时间去掉后即可与数据库匹配。
			if(issueDate!=null){
				String strIssueDate = DateUtils.dateToStr(issueDate);
				issueDateTime = DateUtils.strToDate(strIssueDate);
			}
			Specification<PrpDsalesRate> specification = Specifications.<PrpDsalesRate>and()
					.eq(StringUtils.isNotEmpty(saleRatesDto.getBusinessNature()),"businessNatrue")
					.eq(StringUtils.isNotEmpty(saleRatesDto.getRiskCode()),"riskCode",saleRatesDto.getRiskCode())
					.le(issueDateTime !=null,"effectDate",issueDateTime)
					.ge(issueDateTime != null,"invalidDate",issueDateTime)
					.build();
			//分页，如果没有传入参数，则默认第一页，每页十条
		    //如果业务来源和生效日期都没有填写，则查询出所有记录
			PageInfo<PrpdSalesRateDto> pageInfo = queryPage(specification, page);
			//业务类型转码
			List<PrpdSalesRateDto> salesRateDto = new ArrayList<PrpdSalesRateDto>();
			if(pageInfo.getContent()!=null&&!pageInfo.getContent().isEmpty()){
			    for (PrpdSalesRateDto prpdSalesRateDto : pageInfo.getContent()){
			        String businessNature = prpdSalesRateDto.getBusinessNature();
			        NewCodeQueryConditionDto newCodeConditionDto = new NewCodeQueryConditionDto();
			        newCodeConditionDto.setCodeType("BusinessNature");
			        //调用dms查询出所有codeType是BusinessNature的数据
			        List<PrpDNewCodeDto> prpDNewCodeDtoList = codeApi.queryNewcodeList(newCodeConditionDto);
			        //循环所有codeType为BusinessNature的数据，如果codeCode和businessNature相等，则将codeCname赋给prpdSalesRateDto
			        for (PrpDNewCodeDto prpDNewCodeDto : prpDNewCodeDtoList){
			            if(prpDNewCodeDto.getCodeCode().equals(businessNature)){
			                prpdSalesRateDto.setBusinessNature(prpDNewCodeDto.getCodeCName());
			            }
                    }
			        salesRateDto.add(prpdSalesRateDto);
			    }
			    pageInfo.setContent(salesRateDto);
			}
			return pageInfo;
	}
	/**
     * @description 保存销售费率相关数据
    * @param prpdSalesRateDto
    * @return SaleRateReturnDto
    * @author yinqingzhu
    * @date 2016年9月12日
     */
	@Transactional(propagation=Propagation.REQUIRED)
    public SaleRateReturnDto savePrpdSalesRate(PrpdSalesRateDto prpdSalesRateDto) throws Exception{
        SaleRateReturnDto result = new SaleRateReturnDto();
        String businessNature = prpdSalesRateDto.getBusinessNature();
        if(prpdSalesRateDto!=null){
            Date effectDate = prpdSalesRateDto.getEffectDate();//页面中客户录入的生效日期
            //根据失效日期，查询出数据库中最新的数据，获取版次号
            List<PrpDsalesRate> saleRateList = prpDsalesRateDao.findAll(Specifications.<PrpDsalesRate>and()
					.eq("invalidDate", DateUtils.strToDate("9999-09-09"))
					.eq("businessNatrue", businessNature)
					.build());
            DecimalFormat df = new DecimalFormat("000");
            String versionNo = null;
            //第一次插入数据设置版次号为001
            if(saleRateList!=null&&!saleRateList.isEmpty()){
                String selectVersion = saleRateList.get(0).getVersionNo();
               Integer temp = Integer.parseInt(selectVersion.substring(1));
               Integer subVersion = temp+1;
               versionNo = df.format(subVersion);
            }else{
               versionNo = "001";
            }
            
            //校验生效日期和版次号不能为空
            if(effectDate==null||StringUtils.isEmpty(versionNo)){
                result.setResultCode("N");
                result.setResultMsg("版次号和生效日期不能为空");
                return result;
            }
            //页面录入的生效日期不能在数据库中最新数据的生效日期之前
            //如果数据库中查询出的List不为空，就可以直接拿第一条数据的生效日期进行比较
            if(saleRateList!=null&&!saleRateList.isEmpty()){
                //数据库中最新一批数据的生效日期
                Date oldEffectDate = saleRateList.get(0).getEffectDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                if(effectDate.before(oldEffectDate)){
                    result.setResultCode("N");
                    result.setResultMsg("新增版次不能早于上个版本的生效日期，上个版本生效日期为："+sdf.format(oldEffectDate));
                   // result.setResultMsg("新增版次的生效日期应在"+(oldEffectDate)+"之后");
                    return result;
                }
            }
            //根据生效日期和版次号查询，如果存在则不插入
            if(isSaleRateRepeat(effectDate, versionNo,businessNature)){
                //更新和存入的对象
                PrpDsalesRate salesRate = this.convert(prpdSalesRateDto, PrpDsalesRate.class);
                //设置产品代码和产品名称
                // salesRate.setRiskCode("EQ01");
                salesRate.setRiskCode(prpdSalesRateDto.getRiskCode());
                salesRate.setRiskName(prpdSalesRateDto.getRiskName());
                //先将上条数据的失效日期更新为新数据生效日期的前一天
                salesRate.setInvalidDate(DateUtils.getPreviousDate(effectDate));
                salesRate.setBusinessNature(businessNature);
                String userName = "";
                if(StringUtils.isNotEmpty(userName)){
                    //修改上一条数据的UpdateBy
                    salesRate.setUpdateBy(userName);
                }else{
                  //下面要用user给CreateBy赋值，CreateBy不能为空，在此设置user，避免报错
                    userName = "非法登录，没有用户";
                }
                salesRate.setUpdateTime(new Date());
                prpDsalesRateDao.updateInvalidDate(salesRate.getInvalidDate(),salesRate.getUpdateTime(),
						salesRate.getUpdateBy(),salesRate.getBusinessNature(),salesRate.getRiskCode());
                //更新完上一条数据后，将updateBy和updateTime置为null
                salesRate.setUpdateBy(null);
                salesRate.setUpdateTime(null);
                //出入前应先将失效日期置为9999-09-09
                salesRate.setInvalidDate(DateUtils.strToDate("9999-09-09"));
                //设置创建时间
                salesRate.setCreateTime(new Date());
                //设置版次号
                salesRate.setVersionNo(versionNo);
                //将销售费率转换成百分比
                salesRate.setSalesRate(salesRate.getSalesRate());
                salesRate.setCreateBy(userName);
                //插入数据
                prpDsalesRateDao.saveAndFlush(salesRate);
                result.setResultCode("Y");
                result.setResultMsg("新增成功,版次号为："+versionNo);
            }else{
                result.setResultCode("N");
                result.setResultMsg("数据重复");
            }
        }
        return result;
       
    }
    
	/**
	 * @description 分页查询
	 * @param specification
	 * @param page
	 * @return
	 * @author yinqingzhu
	 * @date 2016年9月29日上午9:33:55
	 */
	private PageInfo<PrpdSalesRateDto> queryPage(Specification<PrpDsalesRate> specification, Pageable page) {
		return this.convertPage(prpDsalesRateDao.findAll(specification, page), PrpdSalesRateDto.class);
	}

	/**
	 * @description 版次号和生效日期重复性校验,如果同意产品传入的生效日期和版次号和数据库中查询出的相同，则不允许插入
	* @param effectDate versionNo businessNature
	* @return SalesRateDto
	* @author yinqingzhu
	* @date 2016年9月12日
	 */
	private Boolean isSaleRateRepeat(Date effectDate,String versionNo,String businessNature){
		//根据生效日期和版次号查询，如果查询不到值则新增数据不重复，可以插入
		List<PrpDsalesRate> salesRateList = prpDsalesRateDao.findAll(Specifications.<PrpDsalesRate>and()
				.eq("effectDate",effectDate).eq("versionNo",versionNo)
				.eq("businessNatrue",businessNature)
				.build());
		if(salesRateList==null||salesRateList.isEmpty()){
		    return true;
		}else{
		    return false;
		}
	}
}
