package com.sinosoft.txnlist.core.insuremainlist.service.impl;


import com.sinosoft.agriprpall.api.endorsemanage.PrpPheadApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.insuremainlist.dto.EarNoCheckDto;
import com.sinosoft.txnlist.api.insuremainlist.dto.EarNoCheckResponseDto;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.insuremainlist.dto.RequestQueryPolicyDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainList;
import com.sinosoft.txnlist.core.insuremainlist.service.QueryPoilcyListService;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.HerdEndorChgDetailDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.HerdEndorHeadDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.HerdPolicyListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdEndorHead;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdPolicyList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* @Description: 根据清单信息查询保单Api接口
* @Author: 杨成程
* @Date: 2017/11/23 11:20
*/
@Service
public class QueryPoilcyListServiceImpl extends BaseServiceImpl implements QueryPoilcyListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryPoilcyListServiceImpl.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
	private InsureMainListDao insureMainListDao;
    @Autowired
	private HerdPolicyListDao herdPolicyListDao;
    @Autowired
	private PrpPheadApi prpPheadApi;
    @Autowired
	private HerdEndorChgDetailDao herdEndorChgDetailDao;
    @Autowired
	private HerdEndorHeadDao herdEndorHeadDao;

    /**
     * @description: 方法功能简述：根据农户姓名、耳标号等信息查询保单号
     * @author: 杨成程
     * @date: 2017/10/18 11:44
     * @param requestDto 
     * @return 
     * @throws Exception
     */
    @Override
    public  List<String> queryPoilcyNoList(RequestQueryPolicyDto requestDto) throws Exception{
    	if(requestDto == null){
            throw new DataVerifyException("入参信息不允许为空");
        }
        if (StringUtils.isEmpty(requestDto.getEditType())) {
            throw new DataVerifyException("编辑类型不能为空");
        }
		if (StringUtils.isEmpty(requestDto.getEarLabel()) 
			       && StringUtils.isEmpty(requestDto.getfName())) {
			throw new DataVerifyException("耳标号和农户姓名不能同时为空");
		}
        StringBuilder condition = new StringBuilder();
        Map<String,String> conditions = new HashMap<>();
        //拼接查询条件和参数
		this.getQueryParam(requestDto, condition, conditions);
		//获取执行sql
		StringBuilder dataHql = this.getQueryContion(requestDto, condition);
        javax.persistence.Query dataQuery = entityManager.createNativeQuery(dataHql.toString());
        //设置参数
        for (String key:conditions.keySet()) {
            dataQuery.setParameter(key,conditions.get(key));
        }
        List<String> dataList = dataQuery.getResultList();
        return dataList;
    }
    /**
     * @description: 获取查询sql
     * @author: 杨成程
     * @date: 2017/10/18 11:44
     * @param requestDto
     * @param condition 
     * @return 
     */
	private StringBuilder getQueryContion(RequestQueryPolicyDto requestDto, StringBuilder condition) {
		StringBuilder dataHql=null;
        if("RegistBeforeQuery".equals(requestDto.getEditType())){
    		//根据耳标号、农户姓名查询养殖险保单信息
    		if (StringUtils.isNotEmpty(requestDto.getEarLabel())) {
    			dataHql = new StringBuilder("SELECT distinct e.policyNo FROM HerdPolicyList d,InsureMainList e where d.inusrelistCode=e.inusreListCode and  e.validity in ('2') and d.validity in ('1') and e.policyNo is not null ");
    			dataHql.append(condition.toString());
    		//根据农户姓名查询保单信息
    		}else{
    			dataHql =new StringBuilder("SELECT e.policyNo FROM PlantingPolicyList d,InsureMainList e where d.inusreListCode=e.inusreListCode and  e.validity in ('2') and d.validity in ('1') and e.policyNo is not null  ");
    			dataHql.append(condition.toString());
    			dataHql.append(" union ");
    			dataHql.append("SELECT e.policyNo FROM Planting31PolicyList d,InsureMainList e where d.inusreListCode=e.inusreListCode and  e.validity in ('2') and d.VALIDITY in ('1') and e.policyNo is not null ");
    			dataHql.append(condition.toString());
    			dataHql.append(" union ");
    			dataHql.append("SELECT e.policyNo FROM HerdPolicyList d,InsureMainList e where d.inusrelistCode=e.inusreListCode and  e.validity in ('2') and d.VALIDITY in ('1') and e.policyNo is not null ");
    			dataHql.append(condition.toString());
    		}
        }else if("Show".equals(requestDto.getEditType())){
			if (StringUtils.isEmpty(requestDto.getEarLabel())) {
				dataHql = new StringBuilder(
						"SELECT e.policyNo FROM PlantingPolicyList d,InsureMainList e where d.inusrelistCode=e.inusreListCode and  e.validity in ('2') and d.validity in ('1') and e.policyNo is not null ");
				dataHql.append(condition.toString());
			} else {
				throw new BusinessException("报案任务查询：此方法只支持农户姓名查询，不允许传入耳标号");
			}
        }else{
        	throw new BusinessException("不存在此查询类型");
        }
	    return dataHql;
	}
    /**
     * @description: 拼接查询条件和参数
     * @author: 杨成程
     * @date: 2017/10/18 11:44
     * @param requestDto
     * @param condition 
     * @param conditions  
     * @return void
     */
	private void getQueryParam(RequestQueryPolicyDto requestDto, StringBuilder condition,
			Map<String, String> conditions) {
		if (StringUtils.isNotEmpty(requestDto.getEarLabel())) {
			condition.append(" AND d.earlAbel = :earlAbel");
			conditions.put("earlAbel", requestDto.getEarLabel());
		}
		if (StringUtils.isNotEmpty(requestDto.getfName())) {
			condition.append(" AND d.fName = :fName");
			conditions.put("fName", requestDto.getfName());
		}
		if (StringUtils.isNotEmpty(requestDto.getStartDate())) {			
			condition.append(" AND e.startTime >= to_date(:startTime, 'yyyy-mm-dd') ");
			conditions.put("startTime", requestDto.getStartDate());
		}
		if (StringUtils.isNotEmpty(requestDto.getEndDate())) {	
			condition.append(" AND e.endTime <= to_date(:endTime, 'yyyy-mm-dd') ");
			conditions.put("endTime", requestDto.getEndDate());
		}
	}
	/**
	 * 根据保单号和耳标号获取最新清单保额大于0的耳标出险时的清单信息
	 * 1.根据保单号查找投保清单头表的list放入结果集
	 * 2.根据投保清单号和耳标号查找保单清单最新数据表的list放入结果集
	 * @author 马俊玲
	 * @throws Exception
	 */
	@Override
	public EarNoCheckResponseDto queryEndorseHerdpolicylist(EarNoCheckDto earNoCheckDto) throws Exception {
		String msg="";
		EarNoCheckResponseDto earNoCheckResponseDto=new EarNoCheckResponseDto();
		String policyNo=earNoCheckDto.getPolicyNo();
		String earLabel=earNoCheckDto.getEarNo();
		String kindCode=earNoCheckDto.getKindCode();
		String damageStartDate=earNoCheckDto.getDamageStartDate();
		String damageStartHour=earNoCheckDto.getDamageStartHour();
		List<InsureMainListDto> insureMainListDtoList = null;
		List<HerdPolicyListDto> herdPolicyListDtoList = null;
		List<HerdPolicyListDto> herdEndorsePolicyListDtoList = null;
		if(StringUtils.isEmpty(policyNo) || StringUtils.isEmpty(earLabel) || StringUtils.isEmpty(kindCode)  || StringUtils.isEmpty(damageStartDate) || StringUtils.isEmpty(damageStartHour) )
		{
			throw new BusinessException("参数错误");
		}
		List<InsureMainList> insuremainlistList = null;
		InsureMainList insureMainList=null;
		insuremainlistList=insureMainListDao.findByPolicynoAndDate(policyNo);
		if(insuremainlistList != null && insuremainlistList.size() >1){
			msg="保单号:" + policyNo + "对应的清单主表记录数不唯一";
			if(LOGGER.isErrorEnabled()){
				LOGGER.error("查询清单>>>>>>>>>>>>>>>>>>>>{}",msg);
			}
			throw new DataVerifyException(msg);
		}
		if(insuremainlistList != null && insuremainlistList.size() == 1){
			insureMainListDtoList=new ArrayList<InsureMainListDto>();
			insureMainList = insuremainlistList.get(0);
			insureMainListDtoList.add(convert(insureMainList,InsureMainListDto.class));
			List<HerdPolicyList> herdPolicyListList=herdPolicyListDao.queryByConditon(earLabel, kindCode, insureMainList.getInusreListCode(), damageStartDate);
			if(herdPolicyListList == null || herdPolicyListList.size() ==0){
				throw new BusinessException("耳标号"+"【"+earLabel+"】"+"验证失败，请核对！");
			}
			if(herdPolicyListList != null && herdPolicyListList.size() >1){
				msg="保单号:" + policyNo + "对应的清单子表记录数不唯一";
				if(LOGGER.isErrorEnabled()){
					LOGGER.error("查询清单>>>>>>>>>>>>>>>>>>>>{}",msg);
				}
				throw new DataVerifyException(msg);
			}
			if(herdPolicyListList != null && herdPolicyListList.size() == 1){
				herdPolicyListDtoList=new ArrayList<HerdPolicyListDto>();
				herdEndorsePolicyListDtoList=new ArrayList<HerdPolicyListDto>();
				herdPolicyListDtoList.add(convert(herdPolicyListList.get(0),HerdPolicyListDto.class));
				HerdPolicyList herdpolicylist = queryByPolicyNoAndDamagerDate(herdPolicyListList.get(0),kindCode,policyNo,damageStartDate,damageStartHour);
				herdEndorsePolicyListDtoList.add(convert(herdpolicylist,HerdPolicyListDto.class));
			}
		}
		earNoCheckResponseDto.setInsureMainListDtoList(insureMainListDtoList);
		earNoCheckResponseDto.setHerdPolicyListDtoList(herdPolicyListDtoList);
		earNoCheckResponseDto.setHerdEndorsePolicyListDtoList(herdEndorsePolicyListDtoList);
		return earNoCheckResponseDto;
	}
	/**
	 *STUB-ONLY：针对出险保单的回倒
	 *@param
	 *@return    出险时有效的清单信息
	 *@author 马俊玲
	 * @throws Exception
	 */
	private HerdPolicyList queryByPolicyNoAndDamagerDate(HerdPolicyList herdpolicylist,String kindCode,String policyNo,String strDamageDate,String strDamageHour) throws Exception {
		Map<String,String> paramMap=new HashMap<String,String>();
		paramMap.put("policyNo",policyNo);
		paramMap.put("damageDate",strDamageDate);
		paramMap.put("damageHour",strDamageHour);
		List<PrpPheadDto> prpPheadDtoList=prpPheadApi.queryPrpPheadDtoByNoANDTime(paramMap);
		if (prpPheadDtoList == null || prpPheadDtoList.size() == 0){
			return herdpolicylist;
		}
		for(PrpPheadDto prpPheadDto:prpPheadDtoList){
			//找到后逐级回滚清单信息
			//开始批改头表
			List<HerdEndorHead> herdEndorHeadList=herdEndorHeadDao.findAll(Specifications.<HerdEndorHead>and()
					.eq(StringUtils.isEmpty(prpPheadDto.getEndorseNo()),"endorseNo", prpPheadDto.getEndorseNo())
					.eq("endorFlag","29").build());
			if (herdEndorHeadList == null || herdEndorHeadList.size() == 0){
				continue;
			}
			if (herdEndorHeadList.size() > 1){
				String msg="批单号:" + herdEndorHeadList.get(0).getEndorseNo() + "对应的批改头表记录数不唯一";
				throw new DataVerifyException(msg);
			}
			//开始批改变化量表
			List<HerdEndorChgDetail> HerdEndorChgDetailList=herdEndorChgDetailDao.findByConditions(herdEndorHeadList.get(0).getEndorseNo(),
					herdpolicylist.getEarlAbel(), herdpolicylist.getInusreListCode(), herdpolicylist.getKindCode(), strDamageDate);
			if (HerdEndorChgDetailList == null || HerdEndorChgDetailList.size() == 0){
				continue;
			}
			if (HerdEndorChgDetailList.size() > 1){
				String msg="批单号:" + HerdEndorChgDetailList.get(0).getEndorseNo() + "对应的批改变化量表记录数不唯一";
				throw new DataVerifyException(msg);
			}
			backWard(herdpolicylist,HerdEndorChgDetailList.get(0));
		}
		return herdpolicylist;
	}

	/**
	 *STUB-ONLY：
	 * @param herdpolicylist
	 *@param   ,
	 *@return 无
	 *@author 马俊玲
	 */
	private void backWard(HerdPolicyList herdpolicylist, HerdEndorChgDetail herdEndorChgDetail) {

		if("D".equals(herdEndorChgDetail.getFlag())){
			//删除操作，将回退结果置为有效
			herdpolicylist.setInsureNumber(herdpolicylist.getInsureNumber()-Integer.valueOf(herdEndorChgDetail.getChgInsureNumber()));
			herdpolicylist.setSumAmount(herdpolicylist.getSumAmount()-Double.valueOf(herdEndorChgDetail.getChgSumAmount()));
			herdpolicylist.setSumPremium(herdpolicylist.getSumPremium()-Double.valueOf(herdEndorChgDetail.getChgSumPremium()));
			herdpolicylist.setValidity("1");
		}else if("I".equals(herdEndorChgDetail.getFlag())){
			//新增操作，将回退结果置为无效
			herdpolicylist.setInsureNumber(herdpolicylist.getInsureNumber()-Integer.valueOf(herdEndorChgDetail.getChgInsureNumber()));
			herdpolicylist.setSumAmount(herdpolicylist.getSumAmount()-Double.valueOf(herdEndorChgDetail.getChgSumAmount()));
			herdpolicylist.setSumPremium(herdpolicylist.getSumPremium()-Double.valueOf(herdEndorChgDetail.getChgSumPremium()));
			herdpolicylist.setValidity("0");
		}else if("U".equals(herdEndorChgDetail.getFlag())){
			//修改操作，不修改金额，数量信息，不进行回退
		}else{
			throw new DataVerifyException();
		}

	}

	/**
	 * @param requestDto 入参Dto
	 * @return
	 * @throws
	 * @description: 方法功能简述：根据农户姓名、农户代码等信息查询保单号
	 * @author: 钱浩
	 * @date: 2017/10/18 11:44
	 */

	@Override
	public Map<String, String> queryPoilcyNo(RequestQueryPolicyDto requestDto) throws Exception {
		String fName = requestDto.getfName();
		String fCode = requestDto.getfCode();
		StringBuffer buffer = new StringBuffer();
		Map<String, String> conditions = new HashMap<String, String>();
		buffer.append("  select distinct i.policyNo from InsureMainList i where i.gisInsureListCode in (select distinct  g.insureListCode from  GisFarmerList g where ");
		if (StringUtils.isNotEmpty(fName) && StringUtils.isNotEmpty(fCode)) {
			buffer.append(" g.fName=:fName and g.fCode=:fCode ");
			conditions.put("fName", fName);
			conditions.put("fCode", fCode);
		} else if (StringUtils.isEmpty(fName) && StringUtils.isNotEmpty(fCode)) {
			buffer.append("  g.fCode=:fCode ");
			conditions.put("fCode", fCode);
		} else if (StringUtils.isNotEmpty(fName) && StringUtils.isEmpty(fCode)) {
			buffer.append(" g.fName=:fName  ");
			conditions.put("fName", fName);
		}
		buffer.append(" )");
		buffer.append(" and i.policyNo is not null ");
		Query query = entityManager.createQuery(buffer.toString());
		for (String key : conditions.keySet()) {
			query.setParameter(key, conditions.get(key));
		}
		List<String> policyNoList = query.getResultList();
		Map<String, String> map = new HashMap<String, String>();
		String strWhere = "";
		if (policyNoList != null && policyNoList.size() > 0) {
			for (String str : policyNoList) {
				strWhere += ("'" + str + "',");
			}
			strWhere = strWhere.substring(0, strWhere.length() - 1);
			map.put("policyWhere", strWhere);
		} else {
			map.put("policyWhere", null);
		}
		return map;
	}
}