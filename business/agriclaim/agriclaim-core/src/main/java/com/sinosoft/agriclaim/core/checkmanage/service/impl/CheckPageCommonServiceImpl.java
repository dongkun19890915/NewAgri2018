package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDtoExt;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLcheckDtoExt;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossDtoExt;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathDtoExt;
import com.sinosoft.agriclaim.core.cetainmanage.dao.PrpLPropDao;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLProp;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLCheckDao;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLverifyLossDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheck;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLoss;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLossKey;
import com.sinosoft.agriclaim.core.checkmanage.service.CheckPageCommonService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistTextDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistKey;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistText;
import com.sinosoft.agriclaim.core.registmanage.service.PageInitCommonService;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleMainWfDao;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWf;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWfKey;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfPathDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPath;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.pms.api.kernel.PrpDkindAgriApi;
import com.sinosoft.pms.api.kernel.PrpDkindApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindAgriDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @description: 类功能简述：查勘页面初始化公共服务类
 * @author 安齐崇
 * @date 2017年11月16日下午9:26:08
 */
@Service
public class CheckPageCommonServiceImpl extends BaseServiceImpl implements CheckPageCommonService {
	private static final Logger logger = LoggerFactory.getLogger(CheckPageCommonServiceImpl.class);
	@Autowired
	private PrpLCheckDao prpLCheckDao;
	@Autowired
	private PrpLRegistDao prpLRegistDao;
	@Autowired
	private PrpLScheduleMainWfDao prpLScheduleMainWfDao;
	@Autowired
	private SwfPathDao swfPathDao;
	@Autowired
	private PrpLverifyLossDao prpLverifyLossDao;
	@Autowired
	private PrpLPropDao prpLPropDao;
	@Autowired
	private PrpLRegistTextDao prpLRegistTextDao;
	@Autowired
	private PageInitCommonService pageInitCommonService;
	@Autowired
	private PrpDkindApi prpDkindApi;
	@Autowired
	private PrpDkindAgriApi prpDkindAgriApi;
	@Override
	public PrpLcheckDtoExt prepareCommonHeadParam(String registNo) {
		logger.info("into CheckPageCommonServiceImpl.prepareCommonHeadParam 查询设置查勘定损头信息");
		/*判断是否已经查勘过*/
		PrpLcheckDtoExt prpLcheckDtoExt = null;
	    Specification<PrpLCheck> spec = Specifications.<PrpLCheck>and().eq("registNo", registNo).build();
		PrpLCheck prpLCheck = prpLCheckDao.findOne(spec);
		/*如果以前没有查勘过一些数据从报案表获取，通过属性拷贝*/
		PrpLRegist prpLregist = prpLRegistDao.findOne(new PrpLRegistKey(registNo));
		if(prpLCheck==null){
			prpLcheckDtoExt = this.convert(prpLregist, PrpLcheckDtoExt.class);
			/*查勘界面的查勘类型由调度表带出,*查勘界面的查勘地址由调度表带出 */
			PrpLScheduleMainWf mainWFDto = prpLScheduleMainWfDao.findOne(new PrpLScheduleMainWfKey(1, registNo));
			/*查勘类型标志*/
			prpLcheckDtoExt.setCheckType(mainWFDto.getFlag());
			/*查勘地点*/
			prpLcheckDtoExt.setCheckSite(mainWFDto.getCheckSite());
			//默认查勘日期
			prpLcheckDtoExt.setCheckDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY));
			/*赔付数量从prplregist获取*/
			prpLcheckDtoExt.setLossesNumber(prpLregist.getLossesNumber());
			prpLcheckDtoExt.setLossesUnitCode(prpLregist.getLossesUnitCode());
			/*设置查勘操作的状态为 新案件登记 (未处理任务)*/
			prpLcheckDtoExt.setStatus("1");
			prpLcheckDtoExt.setReferSerialNo(1);
			prpLcheckDtoExt.setCheckType(StringUtils.isEmpty(prpLregist.getLFlag())?"L":prpLregist.getLFlag());
		}else{
			prpLcheckDtoExt = this.convert(prpLCheck, PrpLcheckDtoExt.class);
			prpLcheckDtoExt.setLossesNumber(prpLregist.getLossesNumber());
			prpLcheckDtoExt.setLossesUnitCode(prpLregist.getLossesUnitCode());
			/*条款类型*/
			prpLcheckDtoExt.setClauseType(prpLregist.getClauseType());
			prpLcheckDtoExt.setDamageEndDate(prpLregist.getDamageEndDate());
			prpLcheckDtoExt.setInsuredName(prpLregist.getInsuredName());
		}
		pageInitCommonService.copyPropertiesIfNull(prpLregist, prpLcheckDtoExt);
		/*设置查勘报告*/
		List<PrpLRegistText> registTextList = prpLRegistTextDao.findAll(Specifications.<PrpLRegistText>and().eq("registNo", registNo).in("textType", "1","3").build(),new Sort("lineNo"));
		StringBuffer context = new StringBuffer();
		for (PrpLRegistText prpLRegistText : registTextList) {
			context.append("  ");
			context.append(prpLRegistText.getContext());
			context.append("\t");
		}
		prpLcheckDtoExt.setContext(context.toString());
		/*设置报损金额币别信息*/
		prpLcheckDtoExt.setEstiCurrency(prpLregist.getEsticurrency());
		prpLcheckDtoExt.setRegistEstiCurrency(prpLregist.getEsticurrency());
		prpLcheckDtoExt.setRegistEstimateLoss(prpLregist.getEstimateLoss() == null? 0:prpLregist.getEstimateLoss());
		/*操作用户等共性信息交由调用方设置*/
		return prpLcheckDtoExt;
	}
	@Override
	public SwfPathDtoExt getSubmitNodes(String modelNo, String nodeNo) {
		int nextNodeNo = 0;
		
		List<SwfPath> pathList = new ArrayList<SwfPath>();
		SwfPathDtoExt swfPathDto = new SwfPathDtoExt();
		if (modelNo != null && nodeNo != null) {
			pathList = swfPathDao.getNextSumbitNodes(Integer.parseInt(modelNo), Integer.parseInt(nodeNo));
			if (pathList.iterator().hasNext()) {
				SwfPath swfPathDtoTemp = new SwfPath();
				swfPathDtoTemp = (SwfPath) pathList.iterator().next();
				nextNodeNo = swfPathDtoTemp.getEndNodeNo();
				swfPathDto.setNextNodeNo(nextNodeNo);
			}
		}
		List<SwfPathDto> pathDtoList = new ArrayList<SwfPathDto>();
		this.convertCollection(pathList, pathDtoList, SwfPathDto.class);
		swfPathDto.setPathList(pathDtoList);
		return swfPathDto;
	}
	@Override
	public PrpLverifyLossDtoExt prepareCertainLossView(String registNo) throws Exception {
		/*lossItemCode 养殖险和种植险的lossItemCode=-2*/
		PrpLverifyLossDtoExt prpLverifyLossDtoExt = new PrpLverifyLossDtoExt();
		PrpLverifyLoss prpLverifyLoss = prpLverifyLossDao.findOne(new PrpLverifyLossKey(registNo, " "));
		//如果是已经存在的定损
		if(prpLverifyLoss!=null){
			prpLverifyLossDtoExt = this.convert(prpLverifyLoss, PrpLverifyLossDtoExt.class);
			List<PrpLProp> prplPropList = prpLPropDao.findAll(Specifications.<PrpLProp>and().eq("registNo", registNo).build(),new Sort("serialNo"));
			List<PrpLPropDtoExt> prplPropDtoList = new ArrayList<PrpLPropDtoExt>();
			this.convertCollection(prplPropList, prplPropDtoList, PrpLPropDtoExt.class);
			/*设置险别，标的名称信息*/
			for (PrpLPropDtoExt prpLPropDtoExt : prplPropDtoList) {
				Map<String,String> map=new HashMap<>();
				map.put("riskCode",prpLPropDtoExt.getRiskCode());
				map.put("kindCode",prpLPropDtoExt.getKindCode());
				PrpDkindAgriDto prpDkindAgriDto=prpDkindAgriApi.queryByPk(map);
				//PrpCitemKindDto itemKindDto = prpCitemKindApi.queryByPK(prpLPropDtoExt.getPolicyNo(), prpLPropDtoExt.getItemKindNo());
				/*险别名称*/
				prpLPropDtoExt.setKindName(prpDkindAgriDto==null?"":prpDkindAgriDto.getKindCName());
			}
			/*财产核定损明细清单表*/
			prpLverifyLossDtoExt.setPrpLpropDtoExtList(prplPropDtoList);
			
		}else{
			PrpLRegist prpLregist = prpLRegistDao.findOne(new PrpLRegistKey(registNo));
			prpLverifyLossDtoExt = this.convert(prpLregist, PrpLverifyLossDtoExt.class);
			prpLverifyLossDtoExt.setAffectEDarea(0.0d);
			prpLverifyLossDtoExt.setDamageInsured(0.0d);
			prpLverifyLossDtoExt.setDisasterArea(0.0d);
			prpLverifyLossDtoExt.setNoProductionArea(0.0d);
			prpLverifyLossDtoExt.setKillQuantity(0.0d);
			prpLverifyLossDtoExt.setDeathQuantity(0.0d);
			prpLverifyLossDtoExt.setLossEsnumBer(prpLregist.getLossesNumber());
		}
		return prpLverifyLossDtoExt;
	}
	
}
