package com.sinosoft.ciplatform.bl.action.custom;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sinosoft.ciplatform.dto.custom.AccidentInfor;
import com.sinosoft.ciplatform.dto.custom.CancelCase;
import com.sinosoft.ciplatform.dto.custom.CertaVerif;
import com.sinosoft.ciplatform.dto.custom.Certi;
import com.sinosoft.ciplatform.dto.custom.Check;
import com.sinosoft.ciplatform.dto.custom.Claim;
import com.sinosoft.ciplatform.dto.custom.CompensateVeric;
import com.sinosoft.ciplatform.dto.custom.EndCase;
import com.sinosoft.ciplatform.dto.custom.EndCaseAppSituation;
import com.sinosoft.ciplatform.dto.custom.EndCaseAppend;
import com.sinosoft.ciplatform.dto.custom.Paydata;
import com.sinosoft.ciplatform.dto.custom.Payinfor;
import com.sinosoft.ciplatform.dto.custom.PersonLoss;
import com.sinosoft.ciplatform.dto.custom.RecoveryConfirm;
import com.sinosoft.ciplatform.dto.custom.Regist;
import com.sinosoft.ciplatform.dto.custom.ThirdCar;
import com.sinosoft.ciplatform.dto.custom.Vehicle;
import com.sinosoft.ciplatform.dto.custom.ciPerson;
import com.sinosoft.ciplatform.dto.custom.ciProtect;
import com.sinosoft.ciplatform.util.CodeTransfer;
import com.sinosoft.claim.bl.action.custom.BLCompensateAction;
import com.sinosoft.claim.bl.action.domain.BLPrpCitemCarAction;
import com.sinosoft.claim.bl.action.domain.BLPrpDuserAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLFirstVeriOpinionAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLRegistRPolicyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcarLossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcertifyCollectAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcertifyDirectAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLchargeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcheckAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcompensateAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcomponentAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLdriverAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLltextAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLprepayAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpropAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistTextAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLrepairFeeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLsubrogationAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLthirdPartyAction;
import com.sinosoft.claim.bl.action.domain.BLPrplcheckreportAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogStoreAction;
import com.sinosoft.claim.bl.facade.BLPrpLRecoveryOrPayFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcarLossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLdriverFacade;
import com.sinosoft.claim.bl.facade.BLPrpLlossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLlossFacadeFG;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpersonLossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpersonLossFacadeFG;
import com.sinosoft.claim.bl.facade.BLPrpLpreChargeFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.bl.facade.BLPrpldiagnosisFacade;
import com.sinosoft.claim.bl.facade.BLPrplpersonfeeFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLFirstVeriOpinionDto;
import com.sinosoft.claim.dto.domain.PrpLRecoveryOrPayDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLcarLossDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLnodutyLossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.PrpLpreChargeDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrplcheckreportDto;
import com.sinosoft.claim.dto.domain.PrpldiagnosisDto;
import com.sinosoft.claim.dto.domain.PrplpersonfeeDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcharge;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLchargeFG;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLnodutyLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLnodutyLossFG;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimDemandAction;
import com.sinosoft.claimciplatform.dto.custom.ClaimCover;
import com.sinosoft.claimciplatform.dto.custom.ReCase;
import com.sinosoft.claimciplatform.dto.custom.RecoveryOrPay;
import com.sinosoft.claimciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.common_claim.dto.domain.CIPrpLfraudTypeDto;
import com.sinosoft.prpall.blsvr.lp.BLPrpLloss;
import com.sinosoft.prpall.blsvr.lp.BLPrpLpersonLoss;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.prpall.schema.PrpLlossSchema;
import com.sinosoft.prpall.schema.PrpLpersonLossSchema;
import com.sinosoft.sff.blsvr.BLPrpJpayRefRec;
import com.sinosoft.sff.schema.PrpJpayRefRecSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.string.Str;


public class BLCIClaimPlatFormInterfaceActionImplGuoyuan extends
		BLCIClaimSYXPlatFormInterfaceAction {
	/**
	 * 
	 * 报案2011
	 */
	protected Regist getRegist(DBManager dbManager, String registNo, String registType)
			throws SQLException, Exception {
		PrpLregistDto prpLregistDto = new BLPrpLregistAction()
				.findByPrimaryKey(dbManager, registNo);
		//String policyNo = getPolicyNo(dbManager, registNo,registType);
		String driverName="";
		String certiType = "";
		String certiCode = "";
		Date damageStartDate = new Date();
		String damageStartHour = "";
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
		}
		Date damageDate = new Date((damageStartDate.getYear() - 1900),
				(damageStartDate.getMonth() - 1), damageStartDate.getDate(),
				Integer.parseInt(damageStartHour.split(":")[0]), Integer
						.parseInt(damageStartHour.split(":")[1]));
		Date reportDate = new Date((prpLregistDto.getReportDate().getYear() - 1900),
				(prpLregistDto.getReportDate().getMonth() - 1), prpLregistDto.getReportDate().getDate(),
				Integer.parseInt(prpLregistDto.getReportHour().split(":")[0]), Integer
						.parseInt(prpLregistDto.getReportHour().split(":")[1]));
		
		PrpLdriverDto prpLdriverDto=new BLPrpLdriverFacade().findByPrimaryKey(prpLregistDto.getRegistNo(),1);
		if(prpLdriverDto!=null){
			driverName=prpLdriverDto.getDriverName();
			certiType = prpLdriverDto.getIdentifyType();
			certiCode = prpLdriverDto.getIdentifyNumber();
		}
		String handleUnit = prpLregistDto.getHandleUnit();
		if("".equals(handleUnit))handleUnit="99";
		Regist regist = new Regist();
		regist.setRegistNo(registNo);
		regist.setReportDate(reportDate);
		regist.setReportorName(prpLregistDto.getReportorName());
		regist.setDriverName(prpLregistDto.getDriverName());
		regist.setReportPhoneNumber(prpLregistDto.getReportorPhoneNumber());//来电号码
		regist.setCertiType(certiType);
		regist.setCertiCode(certiCode);
		regist.setDamageAddress(prpLregistDto.getDamageAddress());         //出险地点名称
		regist.setDamageDate(damageDate);
		regist.setDamageContext(getDamageContext(dbManager, registNo));
		regist.setHandleUnit(handleUnit);
		regist.setIndemnityDuty(prpLregistDto.getIndemnityDuty());
		regist.setSubrogateFlag(prpLregistDto.getSubrogateFlag());
		if("".equals(regist.getSubrogateFlag()))regist.setSubrogateFlag("0");
		regist.setLossCauseCode(prpLregistDto.getDamageCode());
		System.out.println("报案日期：reportDate="+reportDate);
        String Rconditions = "registNo='"+registNo+"'";
        String policyNo = "";
        ArrayList<PrpLRegistRPolicyDto> prpLRegistRPolicyList = (ArrayList<PrpLRegistRPolicyDto>) new BLPrpLRegistRPolicyFacade().findByConditions(Rconditions);
        for(PrpLRegistRPolicyDto prpLRegistRPolicyDto : prpLRegistRPolicyList){
            if("1".equals(prpLRegistRPolicyDto.getPolicyType()) && "1".equals(prpLRegistRPolicyDto.getValidStatus())){
          	  regist.setPolicyNO(prpLRegistRPolicyDto.getPolicyNo());
          	  policyNo = prpLRegistRPolicyDto.getPolicyNo();
            }
        }
        //获得保单标的车对象
		PrpCitemCarDto prpCitemCarDto = new BLPrpCitemCarAction()
				.findByPrimaryKey(dbManager, policyNo, 1);
		//出险标的车号牌号码
		String licenseNo = "";
		if (prpLregistDto != null) {
			licenseNo = prpLregistDto.getLicenseNo();
		}
		regist.setLicenseNo(licenseNo);
		//出险标的车号牌种类代码
		regist.setLicenseType(prpCitemCarDto.getLicenseKindCode());
		if("25".equals(prpCitemCarDto.getLicenseKindCode())){
			regist.setLicenseType("02");
		}
		if("".equals(prpCitemCarDto.getLicenseKindCode())){
			regist.setLicenseType("02");
		}
		return regist;
	}
	/***
	 * 
	 * 立案2011
	 */
	protected Claim getClaim(DBManager dbManager, String claimNo,String registType)
			throws SQLException, Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmm");
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(dbManager, claimNo);
		PrpLregistDto prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager, prpLclaimDto.getRegistNo());		
		DateTime reportDate = prpLregistDto.getReportDate();
		DateTime claimDate 	= prpLclaimDto.getClaimDate();
		String dateTime	= "";
		String strcondtion = "businessno='"+claimNo+"' and nodeType='claim'";
		ArrayList swfLogList = (ArrayList)new BLSwfLogFacade().findByConditions(strcondtion);
		String tableName ="";
		if(swfLogList!=null&&swfLogList.size()>0){
			
		}else{
			swfLogList = (ArrayList)new BLSwfLogStoreFacade().findByConditions(strcondtion);
		}
		dateTime = sdf1.format(sdf.parse(((SwfLogDto)swfLogList.get(0)).getSubmitTime()));
		Claim claim = new Claim();
		claim.setPolicyNO(getPolicyNo(dbManager, prpLclaimDto.getRegistNo(),registType));
		claim.setRegistNo(prpLclaimDto.getRegistNo());
		claim.setClaimNo(claimNo);
		claim.setCaseType(prpLclaimDto.getIndemnityDuty());
		claim.setIndemnityDuty(prpLclaimDto.getIndemnityDuty());
		claim.setClaimDate(dateTime);
		claim.setUnClaimAmount(prpLclaimDto.getSumClaim());
		claim.setSubrogateFlag(prpLregistDto.getSubrogateFlag());
		return claim;
	}
	
	/***
	 * 
	 * 查勘2012
	 */
	protected Check getCheck(DBManager dbManager, String registNo,String registType)
			throws SQLException, Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmm");
		String checkStartTime = "";
		String checkEndTime = "";
        String conditions = "registNo='"+registNo+"'";
		PrpLregistDto prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager, registNo);		
		DateTime reportDate = prpLregistDto.getReportDate();
		DateTime damageDate = prpLregistDto.getDamageStartDate();
		Check check = new Check();
		BLPrpDuserAction prpDuserAction = new BLPrpDuserAction();
		PrpDuserDto prpDuserDto = null;
		String checkIdentifyNumber = "";//查勘人员身份证号
		check.setDamageDate(damageDate); //获取出险时间
		check.setRegistNo(registNo);
		String strPrplcheckreportCon = " registNo='"+registNo+"' and reportcode='CRY052'";
		BLPrplcheckreportAction bLPrplcheckreportAction = new BLPrplcheckreportAction();
		ArrayList  AccidentList = (ArrayList)bLPrplcheckreportAction.findByConditions(dbManager, strPrplcheckreportCon);
		if(null!=AccidentList&&AccidentList.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)AccidentList.get(0);
			if("Y".equals(checkreportDto.getFlag())){
				check.setIndemnityDuty(checkreportDto.getReportvalue());
			}else{
				check.setIndemnityDuty("5");
			}
		}else{
			check.setIndemnityDuty("1");
		}
		check.setLossCauseCode(prpLregistDto.getDamageCode());
		check.setSubrogateFlag(prpLregistDto.getSubrogateFlag());
		check.setSubCertiType(prpLregistDto.getSubCertiType());
		check.setSubClaimFlag(prpLregistDto.getSubClaimFlag());
		ArrayList swfLogList = (ArrayList)new BLSwfLogFacade().findByConditions("registNo='"+registNo+"'");
		String tableName ="";
		if(swfLogList!=null&&swfLogList.size()>0){
			tableName ="Swflog";
		}else{
			tableName ="SwflogStore";
		}
		String fieldType = "";
		String isSingleAccident = "";
		String isPersonInjured = "";//是否包含人伤标志
		String isProtectLoss = "";//是否包含财损
		ArrayList  checkreportList = null;
		ArrayList  checkreportList1 = null;
		ArrayList  licenseNoList = null;
		ArrayList  indemnityDutyList = null;
		ArrayList  damageReasonList = null;
		String strreport = " registNo='"+registNo+"' and reportcode='CRY011'";//现场查勘类型
		String strreport1 = " registNo='"+registNo+"' and reportcode='CRY049'";//事故类型
		String strrobbery = " registNo='"+registNo+"' and reportcode='CRD011'";//查勘类型
		String strLicenseNo = " registNo='"+registNo+"' and reportcode='CRY065'";//出险车辆驾驶证号码
		String strLicenseNoR = " registNo='"+registNo+"' and reportcode='CRD063'";//出险车辆驾驶证号码
		String indemnityDuty = " registNo='"+registNo+"' and reportcode='CRY052'";//预估标的车事故责任
		String damageReason = " registNo='"+registNo+"' and reportcode='CRY068'";//出险原因
		String damageReasonRob = " registNo='"+registNo+"' and reportcode='CRD066'";
		if(prpLregistDto.getLossType().indexOf("3")>-1){
			checkreportList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strrobbery);
			checkreportList1 = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strreport1);
			licenseNoList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strLicenseNoR);
			damageReasonList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, damageReasonRob);
		}else{
			checkreportList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strreport);
			checkreportList1 = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strreport1);
			licenseNoList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strLicenseNo);
			indemnityDutyList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, indemnityDuty);
			damageReasonList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, damageReason);
		}
		if(null!=checkreportList&&checkreportList.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)checkreportList.get(0);
			if("Y".equals(checkreportDto.getFlag())){
				fieldType = CodeTransfer.FieldType.covrentPlatFormCode(checkreportDto.getReportvalue());
			}else{
				fieldType="1";
			}
		}else{
			fieldType="1";
		}
		if(null!=checkreportList1&&checkreportList1.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)checkreportList1.get(0);
			if("Y".equals(checkreportDto.getFlag())){
				isSingleAccident = checkreportDto.getReportvalue();
				if("01".equals(isSingleAccident)){
					isSingleAccident="1";
				}else{
					isSingleAccident="0";
				}
			}else{
				isSingleAccident="0";
			}
		}else{
			isSingleAccident="1";
		}
		String DriverLicenseNo = "";
		if(null!=licenseNoList&&licenseNoList.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)licenseNoList.get(0);
			DriverLicenseNo = checkreportDto.getReportvalue();
		}
		//一般案件的标的车事故责任取查勘报告中最新录入的事故责任
		if(null!=indemnityDutyList&&indemnityDutyList.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)indemnityDutyList.get(0);
			check.setIndemnityDuty(checkreportDto.getReportvalue());
		}
		//出险原因取查勘报告中录入的出险原因
		if(null!=damageReasonList&&damageReasonList.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)damageReasonList.get(0);
			check.setLossCauseCode(checkreportDto.getReportvalue());
		}
		//出险原因取查勘报告中录入的出险原因
		if(null!=checkreportList1&&checkreportList1.size()>0){
			check.setIsSingleAccident(isSingleAccident);
		}else{
			check.setIsSingleAccident(isSingleAccident);
		}
		ArrayList carLossList =  (ArrayList)new UICheckAction().findByCheckConditions(dbManager, registNo,tableName,true);
		//获取保单号
		String Rconditions = "registNo='"+registNo+"'";
		String policyNo = "";
        ArrayList<PrpLRegistRPolicyDto> prpLRegistRPolicyList = (ArrayList<PrpLRegistRPolicyDto>) new BLPrpLRegistRPolicyFacade().findByConditions(Rconditions);
        for(PrpLRegistRPolicyDto prpLRegistRPolicyDto : prpLRegistRPolicyList){
            if("1".equals(prpLRegistRPolicyDto.getPolicyType()) && "1".equals(prpLRegistRPolicyDto.getValidStatus())){
            	policyNo=prpLRegistRPolicyDto.getPolicyNo();
            }
        }
        String BrandName = "";//损失车辆厂牌型号
        String EngineNo = "";//损失车辆发动机号
        String vinNo = "";//损失车辆车架号
		ArrayList<PrpCitemCarDto> PrpCitemCarItem =
			(ArrayList<PrpCitemCarDto>)new com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitemCar(dbManager).findByConditions("policyNo ='"+policyNo+"'");
		//获取标的车厂牌型号和发动机号
		if(PrpCitemCarItem.size() > 0){
			BrandName = PrpCitemCarItem.get(0).getBrandName();
			EngineNo = PrpCitemCarItem.get(0).getEngineNo();
			vinNo = PrpCitemCarItem.get(0).getFrameNo();
		}
		//获取车辆信息和驾驶员信息
		ArrayList carlosslist = new ArrayList();
		ArrayList driverList = new ArrayList();
        carlosslist = (ArrayList)new BLPrpLcarLossAction().findByConditions(dbManager, "registNo='"+registNo+"' order by lossitemcode asc ");
		driverList = (ArrayList)new BLPrpLdriverAction().findByConditions(dbManager, "registNo='"+registNo+"' order by serialno asc ");
		//查勘地点
		String checkSite = "";
		PrpLcheckDto prpLcheckSite = new BLPrpLcheckAction().findByPrimaryKey(dbManager, registNo, 1);
		if(prpLcheckSite != null && !"".equals(prpLcheckSite)){
			checkSite = prpLcheckSite.getCheckSite();
		}
		//查勘情况说明
		String checRemark = "";
		String conditionsff = "registno='"+registNo+"' ";
		Collection checkTextList = new BLPrpLregistTextAction().findByConditions(dbManager, conditionsff);
		if(checkTextList!=null && checkTextList.size()>0){
			for(Iterator iter = checkTextList.iterator();iter.hasNext();){
				PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto)iter.next();
				checRemark = checRemark + prpLregistTextDto.getContext();
			}
		}
		ArrayList<Vehicle> carLossListTemp = new ArrayList<Vehicle>();
		for(int j=0;j<carlosslist.size();j++){
			PrpLcarLossDto prpLcarLossDto = (PrpLcarLossDto) carlosslist.get(j);
			PrpLdriverDto prpLdriverDto = (PrpLdriverDto)driverList.get(j);
		for(int i=0;i<carLossList.size();i++){
			if(prpLcarLossDto.getLossitemname().equals(((Vehicle)carLossList.get(i)).getLicensePlateNo())){
				Vehicle vehicle = new Vehicle();
				vehicle.setLicensePlateNo(((Vehicle)carLossList.get(i)).getLicensePlateNo());
				vehicle.setLicensePlateType(((Vehicle)carLossList.get(i)).getLicensePlateType());
			if("1".equals(((Vehicle)carLossList.get(i)).getVehicleProperty())){
				vehicle.setVehicleProperty("1");
				vehicle.setDriverName(prpLregistDto.getDriverName());
				vehicle.setDriverLicenseNo(DriverLicenseNo);
				vehicle.setEngineNo(EngineNo);
				vehicle.setModel(BrandName);
				vehicle.setVin(vinNo);
			}else{
				vehicle.setVehicleProperty("2");
				vehicle.setDriverName(prpLdriverDto.getDriverName());
				vehicle.setDriverLicenseNo(prpLdriverDto.getDrivingLicenseNo());
				vehicle.setEngineNo(prpLcarLossDto.getEngineno());
				vehicle.setModel(prpLcarLossDto.getCarmodel());
				vehicle.setVin(prpLcarLossDto.getVinno());
			}
			vehicle.setFieldType(fieldType);
			checkStartTime = sdf1.format(sdf.parse(((Vehicle)carLossList.get(i)).getCheckStartTime()));
			checkEndTime = sdf1.format(sdf.parse(((Vehicle)carLossList.get(i)).getCheckEndTime()));
			vehicle.setCheckStartTime(checkStartTime);
			vehicle.setCheckEndTime(checkEndTime);
			String FGDate = "2015-12-29";
			PubTools pubTools  = new PubTools();
			if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
				
			}else{
				vehicle.setVin("");
			}
			if("新车".equals(((Vehicle)carLossList.get(i)).getLicensePlateNo())){
				vehicle.setLicensePlateNo("临时牌照未上牌");
			}
			//获取查勘人员身份证号
			prpDuserDto = new PrpDuserDto();
			prpDuserDto = prpDuserAction.findByPrimaryKey(dbManager, ((Vehicle)carLossList.get(i)).getCheckerCode());
			vehicle.setCheckerCertiCode(prpDuserDto.getIdentifyNumber());
			vehicle.setCheckAddr(checkSite);
			vehicle.setCheckDesc(checRemark);
			vehicle.setCheckerCode(((Vehicle)carLossList.get(i)).getCheckerCode());
			vehicle.setCheckerName(((Vehicle)carLossList.get(i)).getCheckerName());
			//vehicle.setEstimatedLossAmount(prpLcarLossDto.getSumverifyloss());
			carLossListTemp.add(vehicle);
			}
		}	
		}
		check.setCarLossList(carLossListTemp);
		ArrayList protectList = (ArrayList)new UICheckAction().findByPropConditions(dbManager, registNo,tableName,true);
		if(null!=protectList&&protectList.size()>0){
			isProtectLoss = "1";
			check.setIsProtectLoss(isProtectLoss);
		}else{
			isProtectLoss = "0";
			check.setIsProtectLoss(isProtectLoss);
		}
		for(int i=0;i<protectList.size();i++){
		   if("-2".equals(((ciProtect)protectList.get(i)).getProtectProperty())){
			   ((ciProtect)protectList.get(i)).setProtectProperty("2");
		   }else{
			   ((ciProtect)protectList.get(i)).setProtectProperty("1");
		   }	
		   checkStartTime = sdf1.format(sdf.parse(((ciProtect)protectList.get(i)).getCheckStartTime()));
		   checkEndTime = sdf1.format(sdf.parse(((ciProtect)protectList.get(i)).getCheckEndTime()));
		   ((ciProtect)protectList.get(i)).setCheckStartTime(checkStartTime);
		   ((ciProtect)protectList.get(i)).setCheckEndTime(checkEndTime);
		   	//获取查勘人员身份证号
			prpDuserDto = new PrpDuserDto();
			prpDuserDto = prpDuserAction.findByPrimaryKey(dbManager, ((ciProtect)protectList.get(i)).getCheckerCode());
			((ciProtect)protectList.get(i)).setCheckerCertiCode(prpDuserDto.getIdentifyNumber());
			((ciProtect)protectList.get(i)).setCheckAddr(checkSite);
			((ciProtect)protectList.get(i)).setCheckDesc(checRemark);
			//损失数量
			ArrayList<PrpLpropDto> prpLpropList = (ArrayList<PrpLpropDto>)new BLPrpLpropAction().findByConditions(dbManager, " registNo = '"+registNo+"' and serialno = '"+String.valueOf(i+1)+"' ");
			int propNum = 0;
			for (int j = 0; j < prpLpropList.size(); j++) {
				PrpLpropDto prpLpropDtoNum = prpLpropList.get(j);
				propNum += prpLpropDtoNum.getLossQuantity();
			}
			((ciProtect)protectList.get(i)).setLossNum(String.valueOf(propNum));
			((ciProtect)protectList.get(i)).setEstimatedLossAmount(((ciProtect)protectList.get(i)).getEstimatedLossAmount());
		}
		check.setPropLossList(protectList);
		ArrayList personLossList = (ArrayList)new UICheckAction().findBySurveConditions(dbManager, registNo,tableName,true);
		if(null!=personLossList&&personLossList.size()>0){
			isPersonInjured = "1";
			check.setIsPersonInjured(isPersonInjured);
		}else{
			isPersonInjured = "0";
			check.setIsPersonInjured(isPersonInjured);
		}
		for(int i=0;i<personLossList.size();i++){
			if("2".equals(((ciPerson)personLossList.get(i)).getPersonPayType())){
			   ((ciPerson)personLossList.get(i)).setPersonPayType("2");
			}else{
			   ((ciPerson)personLossList.get(i)).setPersonPayType("1"); 
			}
			if("SZ".equals(((ciPerson)personLossList.get(i)).getPersonProperty())){
				((ciPerson)personLossList.get(i)).setPersonProperty("2");
			}else{
				((ciPerson)personLossList.get(i)).setPersonProperty("1");
			}
			((ciPerson)personLossList.get(i)).setTrafficType(CodeTransfer.TrafficType.covrentPlatFormCode(((ciPerson)personLossList.get(i)).getTrafficType()));
			checkStartTime = sdf1.format(sdf.parse(((ciPerson)personLossList.get(i)).getCheckStartTime()));
			checkEndTime = sdf1.format(sdf.parse(((ciPerson)personLossList.get(i)).getCheckEndTime()));
			((ciPerson)personLossList.get(i)).setCheckStartTime(checkStartTime);
			((ciPerson)personLossList.get(i)).setCheckEndTime(checkEndTime);
			//获取查勘人员身份证号
			prpDuserDto = new PrpDuserDto();
			prpDuserDto = prpDuserAction.findByPrimaryKey(dbManager, ((ciPerson)personLossList.get(i)).getCheckerCode());
			((ciPerson)personLossList.get(i)).setCheckerCertiCode(prpDuserDto.getIdentifyNumber());
			((ciPerson)personLossList.get(i)).setCheckAddr(checkSite);
			((ciPerson)personLossList.get(i)).setCheckDesc(checRemark);
			((ciPerson)personLossList.get(i)).setEstimatedLossAmount(((ciPerson)personLossList.get(i)).getEstimatedLossAmount());
		}
		check.setPersonLossList(personLossList);
		String subtr = "registNo = '"+registNo+"' and linkertype='1'";
		ArrayList subrogationList = (ArrayList)new BLPrpLsubrogationAction().findByConditions(dbManager, subtr);
		check.setSubrogationList(subrogationList);
    	check.setPolicyNO(policyNo);
		return check;
	}
	
	/***
	 * 
	 * 定核损2012
	 */
	protected CertaVerif getCertaVerif(DBManager dbManager, String registNo,String registType)
			throws SQLException, Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmm");
		String estimateStartTime = "";
		String underEndTime = "";
		double underTotalDefLoss = 0.0D;//核损总金额
		String isPersonInjured = "";//是否包含人伤标志
		String isProtectLoss = "";//是否包含财损
		PrpLregistDto prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager,registNo);
		DateTime damageDate = prpLregistDto.getDamageStartDate();
		CertaVerif certaVerif = new CertaVerif();
		
		BLPrpDuserAction prpDuserAction = new BLPrpDuserAction();
		PrpDuserDto prpDuserDto = null;
		BLPrpldiagnosisFacade blPrpldiagnosisFacade = new BLPrpldiagnosisFacade();
		
		certaVerif.setRegistNo(registNo);
		certaVerif.setAccidentType("");
		certaVerif.setSubrogationFlag(prpLregistDto.getSubrogateFlag());
		certaVerif.setDamageDate(damageDate);
		
		String strAcci = " registNo='"+registNo+"' and reportcode='CRY052'";
		BLPrplcheckreportAction bLPrplcheckreportAction = new BLPrplcheckreportAction();
		ArrayList  checkreportList = (ArrayList)bLPrplcheckreportAction.findByConditions(dbManager, strAcci);
		if(null!=checkreportList&&checkreportList.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)checkreportList.get(0);
			if("Y".equals(checkreportDto.getFlag())){
				certaVerif.setAccidentLiability(CodeTransfer.IndemnityDuty.covrentPlatFormCode(checkreportDto.getReportvalue()));
			}else{
				certaVerif.setAccidentLiability("1");
			}
		}else{
		   certaVerif.setAccidentLiability("1");
		}
		String fieldType = "";
		String certiType = "";
		String certiCode = "";
		String DriverLicenseNo = "";
		ArrayList  fieldTypeList =null;
		ArrayList  certiTypeList =null;
		ArrayList  certiCodeList =null;
		ArrayList  licenseNoList = null;
		ArrayList  checkreportList1 = null;
		ArrayList  checkreportList2 = null;
		ArrayList  checkreportList3 = null;
		String strreport1 = " registNo='"+registNo+"' and reportcode='CRY049'";//事故类型
		String strField = " registNo='"+registNo+"' and reportcode='CRY011'";
		String strFieldR = " registNo='"+registNo+"' and reportcode='CRD011'";
		String strCertiType = " registNo='"+registNo+"' and reportcode='CRY061'";
		String strCertiTypeR = " registNo='"+registNo+"' and reportcode='CRD059'";
		String strCertiCode= " registNo='"+registNo+"' and reportcode='CRY062'";
		String strCertiCodeR = " registNo='"+registNo+"' and reportcode='CRD060'";
		String strLicenseNo = " registNo='"+registNo+"' and reportcode='CRY065'";
		String strLicenseNoR = " registNo='"+registNo+"' and reportcode='CRD063'";
		String strHotAndWater = " registNo='"+registNo+"' and reportcode='CRY068'";//出险原因，包含火自爆、水淹
	//	String strWater = " registNo='"+registNo+"' and reportcode='YIBC1020'";//遭水淹
        if(prpLregistDto.getLossType().indexOf("3")>-1){//是否盗抢险
        	fieldTypeList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strFieldR);
			certiTypeList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strCertiTypeR);
			certiCodeList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strCertiCodeR);
			licenseNoList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strLicenseNoR);
			checkreportList1 = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strreport1);
		}else{
			fieldTypeList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strField);
        	certiTypeList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strCertiType);
        	certiCodeList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strCertiCode);
        	licenseNoList = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strLicenseNo);
        	checkreportList1 = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strreport1);
        	checkreportList2 = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strHotAndWater);
    //    	checkreportList3 = (ArrayList)new BLPrplcheckreportAction().findByConditions(dbManager, strWater);
		}
		if(null!=fieldTypeList&&fieldTypeList.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)fieldTypeList.get(0);
			if("Y".equals(checkreportDto.getFlag())){
				fieldType = CodeTransfer.FieldType.covrentPlatFormCode(checkreportDto.getReportvalue());
			}else{
				fieldType="1";
			}
		}else{
			fieldType="1";
		}
		String reportvalue = "";
		String isSingleAccident = "";
		String isHotSinceDetonation = "";
		String isWaterFlooded = "";
		String waterFloodedLevel = "";
		if(null!=checkreportList1&&checkreportList1.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)checkreportList1.get(0);
			if("Y".equals(checkreportDto.getFlag())){
				isSingleAccident = checkreportDto.getReportvalue();
				if("01".equals(isSingleAccident)){
					isSingleAccident="1";
				}else{
					isSingleAccident="0";
				}
			}else{
				isSingleAccident="0";
			}
		}else{
			isSingleAccident="1";
		}
		if(null!=checkreportList2&&checkreportList2.size()>0){//火自爆
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)checkreportList2.get(0);
			if("Y".equals(checkreportDto.getFlag())){
				reportvalue = checkreportDto.getReportvalue();
				if("201".equals(reportvalue) || "202".equals(reportvalue) || "253".equals(reportvalue)){
					isHotSinceDetonation = "1";
				}else{
					isHotSinceDetonation = "0";
				}
				if("108".equals(reportvalue)){
					isWaterFlooded = "1";
					waterFloodedLevel = checkreportDto.getAccidentLevel();
				}else{
					isWaterFlooded = "0";
				}
			}else{
				isHotSinceDetonation = "0";
				isWaterFlooded = "0";
			}
		}else{
			isHotSinceDetonation = "0";
			isWaterFlooded = "0";
		}
//		if(null!=checkreportList3&&checkreportList3.size()>0){//水淹
//			String reportvalue3 = "";
//			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)checkreportList3.get(0);
//			if("Y".equals(checkreportDto.getFlag())){
//				reportvalue3 = checkreportDto.getReportvalue();
//				
//			}
//		}
		if(null!=checkreportList1&&checkreportList1.size()>0){
			certaVerif.setIsSingleAccident(isSingleAccident);
		}else{
			certaVerif.setIsSingleAccident(isSingleAccident);
		}
		if(null!=certiTypeList&&certiTypeList.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)certiTypeList.get(0);
			certiType = CodeTransfer.CertiType.covrentPlatFormCode(checkreportDto.getReportvalue());
		}else{
			certiType="99";
		}
		if(null!=licenseNoList&&licenseNoList.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)licenseNoList.get(0);
			DriverLicenseNo = checkreportDto.getReportvalue();
		}
		if(null!=certiCodeList&&certiCodeList.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)certiCodeList.get(0);
			certiCode = checkreportDto.getReportvalue();//驾驶员证件号码
		}else{
			certiCode="342224198705070737";
		}
		String conditions = " registNo='"+registNo+"' and reportcode='CRY051'";
		checkreportList =(ArrayList)bLPrplcheckreportAction.findByConditions(dbManager, conditions);
		if(null!=checkreportList&&checkreportList.size()>0){
			PrplcheckreportDto checkreportDto = (PrplcheckreportDto)checkreportList.get(0);
			if("Y".equals(checkreportDto.getFlag())){
				certaVerif.setOptionType(CodeTransfer.OptionType.covrentPlatFormCode(checkreportDto.getReportvalue()));//事故处理部门
			}else{
				certaVerif.setOptionType("9");
			}
		}else{
		   certaVerif.setOptionType("9");
		}
		//互碰自赔标志
		if("2".equals(prpLregistDto.getClaimType())){
			certaVerif.setPaySelfFlag("1");
		}else{
			certaVerif.setPaySelfFlag("0"); 
		}
		ArrayList swfLogList = (ArrayList)new BLSwfLogFacade().findByConditions("registNo='"+registNo+"'");
		String tableName ="";
		if(swfLogList!=null&&swfLogList.size()>0){
			tableName ="Swflog";
		}else{
			tableName ="SwflogStore";
		}
		ArrayList carLossList = (ArrayList)new UICertainLossAction().findByCertaConditions(dbManager, registNo,tableName,true);

		String Rconditions = "registNo='"+registNo+"'";
		String policyNo = "";
        ArrayList<PrpLRegistRPolicyDto> prpLRegistRPolicyList = (ArrayList<PrpLRegistRPolicyDto>) new BLPrpLRegistRPolicyFacade().findByConditions(Rconditions);
        for(PrpLRegistRPolicyDto prpLRegistRPolicyDto : prpLRegistRPolicyList){
            if("1".equals(prpLRegistRPolicyDto.getPolicyType()) && "1".equals(prpLRegistRPolicyDto.getValidStatus())){
            	policyNo=prpLRegistRPolicyDto.getPolicyNo();
            }
        }
        //获得保单标的车对象
        String BrandName = "";
        String EngineNo = "";
		PrpCitemCarDto prpCitemCarDto = new BLPrpCitemCarAction()
				.findByPrimaryKey(dbManager, policyNo, 1);
		if(prpCitemCarDto != null){
				BrandName = prpCitemCarDto.getBrandName();
				EngineNo = prpCitemCarDto.getEngineNo();		
			}
		double sumCarLoss = 0.0D;
		String[] lossP = new String[30];
		ArrayList  lossPartList = null;
		for(int i=0;i<carLossList.size();i++){
			lossPartList = new ArrayList();
			if("1".equals(((Vehicle)carLossList.get(i)).getVehicleProperty())){
				((Vehicle)carLossList.get(i)).setVehicleProperty("1");
				((Vehicle)carLossList.get(i)).setDriverName(prpLregistDto.getDriverName());
				((Vehicle)carLossList.get(i)).setDriverLicenseNo(DriverLicenseNo);
				((Vehicle)carLossList.get(i)).setCertiType(certiType);
				((Vehicle)carLossList.get(i)).setCertiCode(certiCode);
				((Vehicle)carLossList.get(i)).setEngineNo(EngineNo);
				((Vehicle)carLossList.get(i)).setModel(BrandName);
			}else{
				((Vehicle)carLossList.get(i)).setVehicleProperty("2");
				if(((Vehicle)carLossList.get(i)).getCertiType()!=null&&!"".equals(((Vehicle)carLossList.get(i)).getCertiType())){
					certiType = CodeTransfer.CertiType.covrentPlatFormCode(((Vehicle)carLossList.get(i)).getCertiType());
				}else{
					certiType="99";
				}
				((Vehicle)carLossList.get(i)).setDriverLicenseNo(((Vehicle)carLossList.get(i)).getDriverLicenseNo());
				((Vehicle)carLossList.get(i)).setCertiType(certiType);
			}
			
			String FGDate = "2015-12-25";
			PubTools pubTools  = new PubTools();
			if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
				
			}else{
				((Vehicle)carLossList.get(i)).setVin("");
				((Vehicle)carLossList.get(i)).setDriverName("");
				((Vehicle)carLossList.get(i)).setCertiType("");
				((Vehicle)carLossList.get(i)).setCertiCode("");
				((Vehicle)carLossList.get(i)).setDriverLicenseNo("");
			}
			
			if("新车".equals(((Vehicle)carLossList.get(i)).getLicensePlateNo())){
				((Vehicle)carLossList.get(i)).setLicensePlateNo("临时牌照未上牌");
			}
			
			if(((Vehicle)carLossList.get(i)).getIsRobber().indexOf("G")>-1){
				((Vehicle)carLossList.get(i)).setIsRobber("1");
			}else{
				((Vehicle)carLossList.get(i)).setIsRobber("0");
			}
			((Vehicle)carLossList.get(i)).setFieldType(fieldType);
			estimateStartTime = sdf1.format(sdf.parse(((Vehicle)carLossList.get(i)).getEstimateStartTime()));
			underEndTime = sdf1.format(sdf.parse(((Vehicle)carLossList.get(i)).getUnderEndTime()));
			((Vehicle)carLossList.get(i)).setEstimateStartTime(estimateStartTime);
			((Vehicle)carLossList.get(i)).setUnderEndTime(underEndTime);
			sumCarLoss += ((Vehicle)carLossList.get(i)).getUnderDefLoss();//车辆核损金额
			if("0".equals(((Vehicle)carLossList.get(i)).getIsTotalLoss())){//本地理赔系统：0-是；1-否
				((Vehicle)carLossList.get(i)).setIsTotalLoss("1");//是全损
			}else{
				((Vehicle)carLossList.get(i)).setIsTotalLoss("0");//不是全损
			}
			((Vehicle)carLossList.get(i)).setIsHotSinceDetonation(isHotSinceDetonation);//火自爆
			((Vehicle)carLossList.get(i)).setIsWaterFlooded(isWaterFlooded);//水淹
			((Vehicle)carLossList.get(i)).setWaterFloodedLevel(waterFloodedLevel);//水淹等级
			lossP = ((Vehicle)carLossList.get(i)).getLossPart().split(",");
			for(int l=0;l<lossP.length;l++){
				if("".equals(lossP[l])){
					lossP[l]="03";
					lossPartList.add(lossP[l]);
				}else{
					lossPartList.add(lossP[l]);
				}
			}
			((Vehicle)carLossList.get(i)).setLossPartList(lossPartList);
			//定损人员身份证号码
			prpDuserDto = new PrpDuserDto();
			prpDuserDto = prpDuserAction.findByPrimaryKey(dbManager, ((Vehicle)carLossList.get(i)).getEstimateCode());
			((Vehicle)carLossList.get(i)).setEstimateCertiCode(prpDuserDto.getIdentifyNumber());
			
			String verifCertiCode = "";//核损人员身份证号码
			ArrayList swfLogListVerif= (ArrayList)new BLSwfLogAction().findByConditions(dbManager, " registNo = '"+registNo+"' and nodetype = 'verif' and  lossItemCode = '"+((Vehicle)carLossList.get(i)).getLossItemCode()+"' order by submittime desc");
			if(swfLogListVerif != null && swfLogListVerif.size() > 0){
				com.sinosoft.claim.dto.domain.SwfLogDto swfLogdto2 = (com.sinosoft.claim.dto.domain.SwfLogDto) swfLogListVerif.get(0);
				if(swfLogdto2.getHandlerCode() != null && !"".equals(swfLogdto2.getHandlerCode())){
					prpDuserDto = prpDuserAction.findByPrimaryKey(dbManager, swfLogdto2.getHandlerCode());
					verifCertiCode = prpDuserDto.getIdentifyNumber();
				}
				if(verifCertiCode == null || "".equals(verifCertiCode)){
					verifCertiCode = "310104198105070073";
				}
			}
			((Vehicle)carLossList.get(i)).setUnderWriteCertiCode(verifCertiCode);
			
			//配件总工时为空
			BigDecimal ManHour =new BigDecimal("0");
			String strSQL = "registno='"+registNo+"' and lossitemcode = '"+((Vehicle)carLossList.get(i)).getMainThird()+"' ";
			ArrayList<PrpLrepairFeeDto> prpLrepairFeeList= (ArrayList<PrpLrepairFeeDto>) new BLPrpLrepairFeeAction().findByConditions(dbManager, strSQL);
				for(Iterator itreapir = prpLrepairFeeList.iterator();itreapir.hasNext();){
					PrpLrepairFeeDto prpLrepairFeeDtoTemp = (PrpLrepairFeeDto)itreapir.next();
					ManHour=ManHour.add(new BigDecimal(Double.toString(prpLrepairFeeDtoTemp.getManHour())));
				}
				if(prpLrepairFeeList.size() > 0){
					((Vehicle)carLossList.get(i)).setFittingList(prpLrepairFeeList);
					((Vehicle)carLossList.get(i)).setIsChangeOrRepair("1");
				}else{
					((Vehicle)carLossList.get(i)).setIsChangeOrRepair("0");
				}
				((Vehicle)carLossList.get(i)).setTotalManHour(String.valueOf(ManHour));
			
			//换件项目清单
			String strSQL1 = "registno='"+registNo+"' and lossitemcode = '"+((Vehicle)carLossList.get(i)).getMainThird()+"' ";
			ArrayList<PrpLcomponentDto> PrpLcomponentList= (ArrayList<PrpLcomponentDto>) new BLPrpLcomponentAction().findByConditions(dbManager, strSQL1);
				if(PrpLcomponentList.size() > 0){
					((Vehicle)carLossList.get(i)).setComponentList(PrpLcomponentList);
					((Vehicle)carLossList.get(i)).setIsChangeOrRepair("1");
				}else{
					((Vehicle)carLossList.get(i)).setIsChangeOrRepair("0");
				}
			} 
		certaVerif.setCarLossList(carLossList);
		ArrayList propLossList = (ArrayList)new UICertainLossAction().findByPropcConditions(dbManager, registNo, tableName, true);
		double sumPropLoss = 0.0D;
		if(null!=propLossList&&propLossList.size()>0){
			isProtectLoss = "1";
			certaVerif.setIsProtectLoss(isProtectLoss);
		}else{
			isProtectLoss = "0";
			certaVerif.setIsProtectLoss(isProtectLoss);
		}
		for(int i=0;i<propLossList.size();i++){
			if("-1".equals(((ciProtect)propLossList.get(i)).getProtectProperty())){
				((ciProtect)propLossList.get(i)).setProtectProperty("1");
			}else{
				((ciProtect)propLossList.get(i)).setProtectProperty("2");
			}
			estimateStartTime = sdf1.format(sdf.parse(((ciProtect)propLossList.get(i)).getEstimateStartTime()));
			underEndTime = sdf1.format(sdf.parse(((ciProtect)propLossList.get(i)).getUnderEndTime()));
			((ciProtect)propLossList.get(i)).setEstimateStartTime(estimateStartTime);
			((ciProtect)propLossList.get(i)).setUnderEndTime(underEndTime);
			((ciProtect)propLossList.get(i)).setFieldType(fieldType);
			sumPropLoss += ((ciProtect)propLossList.get(i)).getUnderDefLoss();//财产核损金额
			
			//定损人员身份证号码
			prpDuserDto = new PrpDuserDto();
			prpDuserDto = prpDuserAction.findByPrimaryKey(dbManager, ((ciProtect)propLossList.get(i)).getEstimateCode());
			((ciProtect)propLossList.get(i)).setEstimateCertiCode(prpDuserDto.getIdentifyNumber());
			//核损人员身份证
			String propvcheckerCertiCode = "";
			ArrayList swfLogListSurveTemp= (ArrayList)new BLSwfLogAction().findByConditions(dbManager, " registNo = '"+registNo+"' and nodetype = 'propv' and lossItemCode ='"+((ciProtect)propLossList.get(i)).getLossitemcode()+"' order by submittime desc");
			if(swfLogListSurveTemp != null && swfLogListSurveTemp.size() > 0){
				com.sinosoft.claim.dto.domain.SwfLogDto swfLogdto6 = (com.sinosoft.claim.dto.domain.SwfLogDto) swfLogListSurveTemp.get(0);
				if(swfLogdto6.getHandlerCode() != null && !"".equals(swfLogdto6.getHandlerCode())){
					prpDuserDto = prpDuserAction.findByPrimaryKey(dbManager, swfLogdto6.getHandlerCode());
					propvcheckerCertiCode = prpDuserDto.getIdentifyNumber();
				}
			}
			((ciProtect)propLossList.get(i)).setUnderWriteCertiCode(propvcheckerCertiCode);
			//损失数量
			ArrayList<PrpLpropDto> prpLpropList = (ArrayList<PrpLpropDto>)new BLPrpLpropAction().findByConditions(dbManager, " registNo = '"+registNo+"' and serialno = '"+String.valueOf(i+1)+"' ");
			int propNum = 0;
			for (int j = 0; j < prpLpropList.size(); j++) {
				PrpLpropDto prpLpropDtoNum = prpLpropList.get(j);
				propNum += prpLpropDtoNum.getLossQuantity();
			}
			((ciProtect)propLossList.get(i)).setLossNum(String.valueOf(propNum));

		}
		certaVerif.setPropLossList(propLossList);
		ArrayList personLossList = (ArrayList)new UICertainLossAction().findByWoundConditions(dbManager, registNo,tableName,true);
		double sumPersonLoss = 0.0D;
		ArrayList hospitalInfoList = null;
		if(null!=personLossList&&personLossList.size()>0){
			isPersonInjured = "1";
			certaVerif.setIsPersonInjured(isPersonInjured);
		}else{
			isPersonInjured = "0";
			certaVerif.setIsPersonInjured(isPersonInjured);
		}
		for(int i=0;i<personLossList.size();i++){
			hospitalInfoList = new ArrayList();
			((ciPerson)personLossList.get(i)).setMedicalType(CodeTransfer.MedicalType.covrentPlatFormCode(((ciPerson)personLossList.get(i)).getMedicalType()));
			((ciPerson)personLossList.get(i)).setInjuryType(CodeTransfer.InjuryType.covrentPlatFormCode(((ciPerson)personLossList.get(i)).getInjuryType()));
			if("SZ".equals(((ciPerson)personLossList.get(i)).getPersonProperty())){
				((ciPerson)personLossList.get(i)).setPersonProperty("2");
			}else{
				((ciPerson)personLossList.get(i)).setPersonProperty("1");
			}
			estimateStartTime = sdf1.format(sdf.parse(((ciPerson)personLossList.get(i)).getEstimateStartTime()));
			underEndTime = sdf1.format(sdf.parse(((ciPerson)personLossList.get(i)).getUnderEndTime()));
			((ciPerson)personLossList.get(i)).setEstimateStartTime(estimateStartTime);
			((ciPerson)personLossList.get(i)).setUnderEndTime(underEndTime);
			hospitalInfoList.add(((ciPerson)personLossList.get(i)).getHospitalname());
			((ciPerson)personLossList.get(i)).setHospitalInfoList(hospitalInfoList);
			((ciPerson)personLossList.get(i)).setInjuryIdentifyInfoDataList(hospitalInfoList);
			sumPersonLoss += ((ciPerson)personLossList.get(i)).getUnderDefLoss();//人伤核损金额
			//人伤跟踪人员身份证号码
			prpDuserDto = new PrpDuserDto();
			prpDuserDto = prpDuserAction.findByPrimaryKey(dbManager, ((ciPerson)personLossList.get(i)).getEstimateCode());
			((ciPerson)personLossList.get(i)).setEstimateCertiCode(prpDuserDto.getIdentifyNumber());
			//人伤核损人员身份证号码
			String underWriteCertiCode = "";
			ArrayList swfLogVerif= (ArrayList)new BLSwfLogAction().findByConditions(dbManager, " registNo = '"+registNo+"' and nodetype = 'veriw' and lossitemcode = '"+((ciPerson)personLossList.get(i)).getLossItemCode()+"' order by submittime desc ");
			if(swfLogVerif != null && swfLogVerif.size() > 0 ){
				SwfLogDto swfLogdto1 = (SwfLogDto) swfLogVerif.get(0);
				prpDuserDto = prpDuserAction.findByPrimaryKey(dbManager, swfLogdto1.getHandlerCode());
				underWriteCertiCode = prpDuserDto.getIdentifyNumber();
			}
			((ciPerson)personLossList.get(i)).setUnderWriteCertiCode(prpDuserDto.getIdentifyNumber());
			String conditions1 = " registno='"+registNo+"' and personno='"+((ciPerson)personLossList.get(i)).getPersonNo()+"'";
			Collection prpldiagnosisList = blPrpldiagnosisFacade.findByConditions(conditions1);//主要诊断信息
			PrpldiagnosisDto prpldiagnosisDto = null;
			ArrayList injuryList = new ArrayList();
			if(prpldiagnosisList.size()>0 && prpldiagnosisList !=null){
				Iterator diagnosis = prpldiagnosisList.iterator();
				while(diagnosis.hasNext()){
					prpldiagnosisDto = new PrpldiagnosisDto();
					prpldiagnosisDto = (PrpldiagnosisDto)diagnosis.next();
					((ciPerson)personLossList.get(i)).setInjuryPart(prpldiagnosisDto.getInjurypart());
					if("".equals(((ciPerson)personLossList.get(i)).getInjurylevelcode())){
						((ciPerson)personLossList.get(i)).setInjurylevelcode("10");
					}
					if("".equals(((ciPerson)personLossList.get(i)).getInjuryPart())){
						((ciPerson)personLossList.get(i)).setInjuryPart("0"+(i+1));
					}
					((ciPerson)personLossList.get(i)).setInjurylevelcode(((ciPerson)personLossList.get(i)).getInjurylevelcode());
					injuryList.add(((ciPerson)personLossList.get(i)).getInjuryPart());
				}
			}
			((ciPerson)personLossList.get(i)).setInjuryList(injuryList);
		}
		
		String conditions2 = " registno='"+registNo+"' and feetypecode='021' ";
		BLPrplpersonfeeFacade prplpersonfeeFacade = new BLPrplpersonfeeFacade();
		Collection prplpersonfeeList = prplpersonfeeFacade.findByConditions(conditions2);
		PrplpersonfeeDto prplpersonfeeDto = null;
		ArrayList personfeeList = null;
		int j=0;
		Iterator personfee = prplpersonfeeList.iterator();
		if(personLossList!=null && personLossList.size()>0){
			while(personfee.hasNext()){
				personfeeList = new ArrayList();
				prplpersonfeeDto = new PrplpersonfeeDto();
				prplpersonfeeDto = (PrplpersonfeeDto)personfee.next();
				((ciPerson)personLossList.get(j)).setFeeType("500");
				((ciPerson)personLossList.get(j)).setUdefLoss(((ciPerson)personLossList.get(j)).getUnderDefLoss());
				personfeeList.add(((ciPerson)personLossList.get(j)).getFeeType());
				((ciPerson)personLossList.get(j)).setLossFeeList(personfeeList);
				j++;
				certaVerif.setLossFeeList(personfeeList);
				if((j+1)>personLossList.size()){
					break;
				}
			}
		}
		certaVerif.setPersonLossList(personLossList);
		//代位信息
		String subconditions = "registNo='"+registNo+"' and linkertype='1'" ;
		ArrayList subrogationList = (ArrayList)new BLPrpLsubrogationAction().findByConditions(dbManager, subconditions);
		certaVerif.setSubrogationList(subrogationList);
		if((carLossList==null || carLossList.size()<=0) && (propLossList == null || propLossList.size()<=0) && (personLossList == null || personLossList.size()<=0)){
			Vehicle vehicle = new Vehicle();
			BLPrpLthirdPartyFacade blPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
			PrpLthirdPartyDto prpLthirdPartyDto = blPrpLthirdPartyFacade.findByPrimaryKey(registNo, 1);
			vehicle.setLicensePlateNo(prpLthirdPartyDto.getLicenseNo());
			vehicle.setLicensePlateType(prpLthirdPartyDto.getLicensePlateType());
			vehicle.setVehicleProperty("1");
			vehicle.setDriverName(prpLregistDto.getDriverName());
			vehicle.setDriverLicenseNo(DriverLicenseNo);
			vehicle.setCertiCode(certiCode);
			vehicle.setCertiType(certiType);
			vehicle.setIsRobber("0");
			vehicle.setFieldType(fieldType);
			DateTime dateTime = new DateTime();
			estimateStartTime = sdf1.format(sdf.parse(dateTime.current().toString()));
			underEndTime = sdf1.format(sdf.parse(dateTime.current().toString()));
			vehicle.setEstimateStartTime(estimateStartTime);
			vehicle.setUnderEndTime(underEndTime);
			carLossList.add(vehicle);
			certaVerif.setCarLossList(carLossList);

		}
		certaVerif.setPolicyNO(policyNo);
        underTotalDefLoss = sumCarLoss + sumPropLoss + sumPersonLoss;
        certaVerif.setUnderTotalDefLoss(underTotalDefLoss);
        
		return certaVerif;
	}
	
	/***
	 * 
	 * 单证2012
	 */
	protected Certi getCerti(DBManager dbManager, String registNo,String registType)
			throws SQLException, Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmm");
		String conditions = " registNo='"+registNo+"' and nodetype='certi'";
		ArrayList<SwfLogDto> list1 =(ArrayList<SwfLogDto>)new BLSwfLogAction().findByConditions(dbManager, conditions);
		if(null==list1||list1.size()==0){
			list1 = (ArrayList<SwfLogDto>)new BLSwfLogStoreAction().findByConditions(dbManager, conditions);
		}
		PrpLregistDto prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager, registNo);		
		Certi certi = new Certi();
		certi.setRegistNo(registNo);
		String DocEndTime = sdf1.format(sdf.parse(list1.get(0).getSubmitTime()));
		certi.setDocEndTime(DocEndTime);
		certi.setSubrogationFlag(prpLregistDto.getSubrogateFlag());
		certi.setSubCertiType(prpLregistDto.getSubCertiType());
		certi.setSubClaimFlag(prpLregistDto.getSubClaimFlag());
		ArrayList certifyDirectList = new ArrayList();
		String recaseFlag = "";
		PrpLcertifyCollectDto prpLcertifyCollectDto= new BLPrpLcertifyCollectAction().findByPrimaryKey(dbManager, registNo, "1");
		if(prpLcertifyCollectDto!=null){
			recaseFlag = prpLcertifyCollectDto.getRecaseFlag();
		}
		String conditions1 = "registNo = '"+registNo+"' and recaseFlag ='"+recaseFlag+"'";
		certifyDirectList = (ArrayList)new BLPrpLcertifyDirectAction().findByConditions(dbManager, conditions1);
		for(int i=0;i<certifyDirectList.size();i++){
			if(((PrpLcertifyDirectDto)certifyDirectList.get(i)).getTypeCode().indexOf("E")>-1||
					((PrpLcertifyDirectDto)certifyDirectList.get(i)).getTypeCode().indexOf("F")>-1){
				((PrpLcertifyDirectDto)certifyDirectList.get(i)).setTypeCode("1");
			}else if(((PrpLcertifyDirectDto)certifyDirectList.get(i)).getTypeCode().indexOf("D")>-1){
				((PrpLcertifyDirectDto)certifyDirectList.get(i)).setTypeCode("3");
			}else{
				((PrpLcertifyDirectDto)certifyDirectList.get(i)).setTypeCode("2");
			}
		}
		certi.setDocDetailList(certifyDirectList);
		String conditions2 = "registNo = '"+registNo+"' and linkertype='1'";
		ArrayList subrogationList = (ArrayList)new BLPrpLsubrogationAction().findByConditions(dbManager, conditions2);
		certi.setSubrogationList(subrogationList);
        String Rconditions = "registNo='"+registNo+"'";
        ArrayList<PrpLRegistRPolicyDto> prpLRegistRPolicyList = (ArrayList<PrpLRegistRPolicyDto>) new BLPrpLRegistRPolicyFacade().findByConditions(Rconditions);
        for(PrpLRegistRPolicyDto prpLRegistRPolicyDto : prpLRegistRPolicyList){
            if("1".equals(prpLRegistRPolicyDto.getPolicyType()) && "1".equals(prpLRegistRPolicyDto.getValidStatus())){
            	certi.setPolicyNO(prpLRegistRPolicyDto.getPolicyNo());
            }
        }
		return certi;
	}
	
	
	//损失类型合并 
	protected ArrayList losstypeBing(ArrayList endCaseAppSituationList)
	throws SQLException, Exception {	
		ArrayList endCaseAppSituationListBing=new ArrayList();		
		for(int m=0;m<endCaseAppSituationList.size();m++)
		{
			EndCaseAppSituation endCaseAppSituation=(EndCaseAppSituation)endCaseAppSituationList.get(m);
			if(endCaseAppSituationListBing.size()==0){
				endCaseAppSituationListBing.add(endCaseAppSituation);
			}else{
				int k=0;
				for(int j=0;j<endCaseAppSituationListBing.size();j++){
					EndCaseAppSituation endCaseAppSituationB=(EndCaseAppSituation)endCaseAppSituationListBing.get(j);
					if(endCaseAppSituation.getLossType().equals(endCaseAppSituationB.getLossType())){						
						endCaseAppSituationB.setAppPaySum(endCaseAppSituationB.getAppPaySum()+endCaseAppSituation.getAppPaySum());
					}else{
						k++;
					}
				}
				if(k==endCaseAppSituationListBing.size()){					
					endCaseAppSituationListBing.add(endCaseAppSituation);
				}
			}
		 }		
		return endCaseAppSituationListBing;	
	}
	
	@Override
	/**
	 * 
	 * 获得理算核赔信息
	 */
	protected CompensateVeric getCompensateVeric(DBManager dbManager,String registType,
			String compensateNo) throws SQLException, Exception {
		
		ResultSet rs = null;
		ResultSet rs1 = null;
		CompensateVeric compensateVeric = null;
		CompensateVeric compensateVeric1 = new CompensateVeric();
		ArrayList compensateVericList = new ArrayList();
		PrpLcompensateDto prpLcompensateDto1 = null;
		BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		PrpLcompensateDto prpLcompensateDto = blPrpLcompensateAction.findByPrimaryKey(dbManager,compensateNo);
		PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(prpLcompensateDto.getClaimNo());
		PrpLregistDto prpLregistDto=new BLPrpLregistFacade().findByPrimaryKey( prpLclaimDto.getRegistNo());
		String FGDate = AppConfig.get("sysconst.FG_DATE");
		PubTools pubTools  = new PubTools();
		String riskCode=prpLclaimDto.getRiskCode();
		boolean isFG=false;
		isFG=CodeTransfer.isFG(riskCode);
		String conditions = " claimNo = '"+ prpLclaimDto.getClaimNo() +"' ";
		ArrayList prpLcompensateDtoList = (ArrayList)blPrpLcompensateAction.findByConditions(dbManager, conditions);
		compensateVeric1.setRegistNo(prpLclaimDto.getRegistNo());
		compensateVeric1.setPolicyNo(prpLcompensateDto.getPolicyNo());
		compensateVeric1.setClaimNo(prpLcompensateDto.getClaimNo());
		compensateVeric1.setCompensateNo(compensateNo);
		if(prpLcompensateDtoList.size() > 0){
				for(int index1 = 0 ;index1 < prpLcompensateDtoList.size();index1++){
					compensateVeric = new CompensateVeric();
					prpLcompensateDto1 = (PrpLcompensateDto)prpLcompensateDtoList.get(index1);
					compensateVeric.setCompensateNo(prpLcompensateDto1.getCompensateNo());
					compensateVeric.setPolicyNo(prpLcompensateDto1.getPolicyNo());
					compensateVeric.setRegistNo(prpLclaimDto.getRegistNo());
					compensateVeric.setClaimNo(prpLcompensateDto1.getClaimNo());
					compensateNo = prpLcompensateDto1.getCompensateNo();
					String handleText = "";
					String strSql = " Select n.handletext "+
										" from UwNotion n "+
										" Where n.flowid = (select distinct g.flowid "+
										" from Wflog g "+
											" where  g.businessNo = '"+compensateNo+"') "+
											" order by n.logno ";
					rs = dbManager.executeQuery(strSql);
					while(rs.next()){
						handleText += rs.getString(1);
					}
					rs.close();
					//是否新增设备
					String isDeviceItem = "";
					String strSQL = " SELECT COUNT(1) from prpCcarDevice WHERE policyno = '"+prpLcompensateDto1.getPolicyNo()+"' ";
					rs1 = dbManager.executeQuery(strSQL);
					while(rs1.next()){
						isDeviceItem = rs1.getString(1);
					}
					rs1.close();
					if(Integer.parseInt(isDeviceItem) > 0){
						isDeviceItem = "1";//是
					}else{
						isDeviceItem = "0";//否
					}
					compensateVeric.setUnderWriteDesc(handleText);
					compensateVeric.setSumPaid(prpLcompensateDto1.getSumThisPaid());
					compensateVeric.setOtherFee(String.valueOf(prpLcompensateDto1.getSumNoDutyFee()));
					compensateVeric.setUnderWriteEnd(new SimpleDateFormat("yyyyMMddHHmm").format(prpLcompensateDto1.getUnderWriteEndDate()));
					ArrayList<ClaimCover> claimCoverList = new ArrayList();
					ArrayList<RecoveryOrPay> recoveryOrPayList = new ArrayList();
					ClaimCover claimCover = null;
					RecoveryOrPay recoveryOrPay = null;
					BLPrpLRecoveryOrPayFacade blPrpLRecoveryOrPayFacade = new BLPrpLRecoveryOrPayFacade();
					conditions = " compensateNo = '"+compensateNo+"' ";
					ArrayList<PrpLRecoveryOrPayDto> prpLRecoveryOrPayList = (ArrayList)blPrpLRecoveryOrPayFacade.findByConditions(conditions);
					PrpLRecoveryOrPayDto prpLRecoveryOrPayDto = null;
					double claimCoverAmountProp = 0.0;
					//代为案件
					boolean isFalse = false;
					boolean isFalse1 = false;
					
					if(prpLRecoveryOrPayList.size()>0){
						//追偿
						for(int i = 0;i < prpLRecoveryOrPayList.size();i++){
							prpLRecoveryOrPayDto = prpLRecoveryOrPayList.get(i);
							if("1".equals(prpLRecoveryOrPayDto.getRecoveryOrPayFlag())){
								claimCoverAmountProp += prpLRecoveryOrPayDto.getRecoveryOrPayAmount();
								recoveryOrPay= new RecoveryOrPay();
								recoveryOrPay.setSerialNo(prpLRecoveryOrPayDto.getSerialNo());
								recoveryOrPay.setRecoveryOrPayFlag(prpLRecoveryOrPayDto.getRecoveryOrPayFlag());
								recoveryOrPay.setRecoveryOrPayType(prpLRecoveryOrPayDto.getRecoveryOrPayType());
								recoveryOrPay.setRecoveryOrPayMan(prpLRecoveryOrPayDto.getRecoveryOrPayMan());
								recoveryOrPay.setRecoveryCode(prpLRecoveryOrPayDto.getRecoveryCode());
								recoveryOrPay.setRecoveryOrPayAmount(prpLRecoveryOrPayDto.getRecoveryOrPayAmount().toString());
								recoveryOrPay.setRecoveryRemark(prpLRecoveryOrPayDto.getRecoveryRemark());
								recoveryOrPayList.add(recoveryOrPay);
								isFalse = true; 
							}
							
						}
						if(isFalse){
							claimCover = new ClaimCover();
							claimCover.setRecoveryOrPayFlag("1");
							if(isFG){
								if(riskCode.equals("0546")){
									claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode("A"));
								}else{
									claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode("A"));
								}
								claimCover.setClaimFeeType("5");
							}else{
							    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode("A"));
							    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
							    	claimCover.setClaimFeeType("5");
							    }else{
							    	claimCover.setClaimFeeType("3");
							    }  
							}
							claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
							claimCover.setSalvageFee(Double.toString(0.00));
							claimCover.setClaimAmount(Double.toString(claimCoverAmountProp));
							claimCover.setLossAmount(Double.toString(claimCoverAmountProp));
							claimCoverList.add(claimCover);
						}
						compensateVeric.setSumPaid(prpLcompensateDto1.getSumThisPaid()+claimCoverAmountProp);
						//清付信息
						claimCoverAmountProp = 0.0;
						for(int i = 0;i < prpLRecoveryOrPayList.size();i++){
							prpLRecoveryOrPayDto = prpLRecoveryOrPayList.get(i);
							if("2".equals(prpLRecoveryOrPayDto.getRecoveryOrPayFlag())){
								claimCoverAmountProp += prpLRecoveryOrPayDto.getRecoveryOrPayAmount();
								recoveryOrPay= new RecoveryOrPay();
								recoveryOrPay.setSerialNo(prpLRecoveryOrPayDto.getSerialNo());
								recoveryOrPay.setRecoveryOrPayFlag(prpLRecoveryOrPayDto.getRecoveryOrPayFlag());
								recoveryOrPay.setRecoveryOrPayType(prpLRecoveryOrPayDto.getRecoveryOrPayType());
								recoveryOrPay.setRecoveryOrPayMan(prpLRecoveryOrPayDto.getRecoveryOrPayMan());
								recoveryOrPay.setRecoveryCode(prpLRecoveryOrPayDto.getRecoveryCode());
								recoveryOrPay.setRecoveryOrPayAmount(prpLRecoveryOrPayDto.getRecoveryOrPayAmount().toString());
								recoveryOrPay.setRecoveryRemark(prpLRecoveryOrPayDto.getRecoveryRemark());
								recoveryOrPayList.add(recoveryOrPay);
								isFalse1 = true;
							}
						}
						if(isFalse1){
							claimCover = new ClaimCover();
							claimCover.setRecoveryOrPayFlag("2");
							if(isFG){
								if(riskCode.equals("0546")){
									claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode("A"));
								}else{
									claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode("A"));
								}
								claimCover.setClaimFeeType("5");
							}else{
							    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode("A"));
							    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
							    	claimCover.setClaimFeeType("5");
							    }else{
							    	claimCover.setClaimFeeType("3");
							    }
							}
							claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
							claimCover.setSalvageFee(Double.toString(0.00));
							claimCover.setLossAmount(Double.toString(claimCoverAmountProp));
							claimCover.setClaimAmount(Double.toString(claimCoverAmountProp));
							claimCoverList.add(claimCover);
						}
						
					}
					
					//自付信息
					//财产损失
					BLPrpLlossFacade blPrpLlossFacade = new BLPrpLlossFacade();
					BLPrpLlossFacadeFG blPrpLlossFacadeFG = new BLPrpLlossFacadeFG();
					PrpLlossDto prpLlossDto = null;
					double sunRealPaid = 0.0;
					boolean isExists = true;
					String[] kindCode = new String[50];
					Double[] kindCodeAmount = new Double[50] ;
					Double[] salvageFee=new Double[50] ;
					Double[] lossAmount=new Double[50] ;
					int j = 0;
					int l = 0;
					int g = 0;
					int h = 0;
					conditions = " compensateNo = '"+compensateNo+"' ";
					ArrayList<PrpLlossDto> prpLlossDtoList =null;
					if(isFG){
						prpLlossDtoList = (ArrayList)blPrpLlossFacadeFG.findByConditions(conditions);
					}else{
						prpLlossDtoList = (ArrayList)blPrpLlossFacade.findByConditions(conditions);
					}
					
					if(prpLlossDtoList.size()>0){
						for(int i = 0;i < prpLlossDtoList.size();i++){
							isExists = true;
							prpLlossDto = prpLlossDtoList.get(i);
							if(i == 0){
								kindCode[j++] = prpLlossDto.getKindCode();
								kindCodeAmount[l++] = prpLlossDto.getSumRealPay();
								isExists = false;
								if(prpLlossDto.getFeeTypeCode().equals("05")){
									salvageFee[g++] = prpLlossDto.getSumRealPay();
								}else{
									salvageFee[g++] = 0.0;
								}
								if(prpLlossDto.getFeeTypeCode().equals("04")){
									lossAmount[h++] = -prpLlossDto.getSumLoss();
								}else{
									lossAmount[h++] = prpLlossDto.getSumLoss();
								}
							}else{
								for(int k = 0;k < kindCode.length;k++){
									
									if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLlossDto.getKindCode())){
										isExists = false;
										kindCodeAmount[k] += prpLlossDto.getSumRealPay();
										if(prpLlossDto.getFeeTypeCode().equals("05")){
											salvageFee[k] += prpLlossDto.getSumRealPay();
										}else{
											salvageFee[k] +=0.0;
										}
										if(prpLlossDto.getFeeTypeCode().equals("04")){
											lossAmount[k] -= prpLlossDto.getSumLoss();
										}else{
											lossAmount[k] += prpLlossDto.getSumLoss();
										}
										k++;
									}
								}
							}
							if(isExists){
								kindCode[j++] = prpLlossDto.getKindCode();
								kindCodeAmount[l++] = prpLlossDto.getSumRealPay();
								if(prpLlossDto.getFeeTypeCode().equals("05")){
									salvageFee[g++] = prpLlossDto.getSumRealPay();
								}else{
									salvageFee[g++] = 0.0;
								}
								if(prpLlossDto.getFeeTypeCode().equals("04")){
									lossAmount[h++] = -prpLlossDto.getSumLoss();
								}else{
									lossAmount[h++] = prpLlossDto.getSumLoss();
								}
							}
						}
						for(int index = 0 ; index < kindCode.length;index++){
							if(kindCode[index] != null && !"".equals(kindCode[index])){
								claimCover = new ClaimCover();
								claimCover.setRecoveryOrPayFlag("3");
								if(isFG){
									if(riskCode.equals("0546")){
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
									}else{
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
									}
									claimCover.setClaimFeeType("2");
								}else{
								    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
								    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
								    	claimCover.setClaimFeeType("2");
								    }else{
								    	claimCover.setClaimFeeType("3");
								    }
								}
								claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
								
								if(salvageFee[index]==null||salvageFee[index].equals("")){
									claimCover.setSalvageFee(Double.toString(0.00));
								}else{
							//	    claimCover.setSalvageFee(Double.toString(salvageFee[index]));
								    claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
								}
						//		claimCover.setLossAmount(Double.toString(lossAmount[index]));
								claimCover.setLossAmount(new DecimalFormat("0.00").format(lossAmount[index]));
								if("B".equals(kindCode[index])){
						//			claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]-claimCoverAmountProp));
									claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]-claimCoverAmountProp));
								}else{
						//			claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]));
									claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
								}
								//是否新增设备赋值
								if("004".equals(kindCode[index])){
									claimCover.setIsDeviceItem(isDeviceItem);
								}
								claimCoverList.add(claimCover);
							}
						}
					}
					
					//死亡伤残
					BLPrpLpersonLossFacade blPersonLossFacade = new BLPrpLpersonLossFacade();
					BLPrpLpersonLossFacadeFG blPersonLossFacadeFG = new BLPrpLpersonLossFacadeFG();
					PrpLpersonLossDto prpLpersonLossDto = null;
					kindCode = new String[50];
					kindCodeAmount = new Double[50] ;
					salvageFee=new Double[50] ;
					lossAmount=new Double[50] ;
					j = 0;
					l = 0;
					sunRealPaid = 0.0; 
					conditions = " compensateNo = '"+compensateNo+"' and feecategory = 'D' ";
					ArrayList<PrpLpersonLossDto> prpLpersonLossDtoList =null;
					if(isFG){
						prpLpersonLossDtoList = (ArrayList)blPersonLossFacadeFG.findByConditions(conditions);
					}else{
						prpLpersonLossDtoList = (ArrayList)blPersonLossFacade.findByConditions(conditions);
					}
					if(prpLpersonLossDtoList.size()>0){
						for(int i = 0; i < prpLpersonLossDtoList.size();i++){
							isExists = true;
							prpLpersonLossDto = prpLpersonLossDtoList.get(i);
							if(i == 0){
								kindCode[j++] = prpLpersonLossDto.getKindCode();
								kindCodeAmount[l] = prpLpersonLossDto.getSumRealPay();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLpersonLossDto.getSumLoss();
								l++;
								isExists = false;
							}else{
								for(int k = 0;k < kindCode.length;k++){
									if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLpersonLossDto.getKindCode())){
										isExists = false;
										kindCodeAmount[k] += prpLpersonLossDto.getSumRealPay();
										salvageFee[k] += 0.00;
										lossAmount[k] += prpLpersonLossDto.getSumLoss();
										k++;
									}
								}
							}
							if(isExists){
								kindCode[j++] = prpLpersonLossDto.getKindCode();
								kindCodeAmount[l] = prpLpersonLossDto.getSumRealPay();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLpersonLossDto.getSumLoss();
								l++;
							}
						}
						for(int index = 0;index < kindCode.length;index++){
							if(kindCode[index] != null && !"".equals(kindCode[index])){
								claimCover = new ClaimCover();
								claimCover.setRecoveryOrPayFlag("3");
								if(isFG){
									if(riskCode.equals("0546")){
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
									}else{
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
									}
									claimCover.setClaimFeeType("5");
								}else{
								    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
								    claimCover.setClaimFeeType("1");
								}
								claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
								
						//		claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]));
								claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
								if(salvageFee[index]==null||salvageFee[index].equals("")){
									claimCover.setSalvageFee(Double.toString(0.00));
								}else{
						//		    claimCover.setSalvageFee(Double.toString(salvageFee[index]));
									claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
								}
						//		claimCover.setLossAmount(Double.toString(lossAmount[index]));
								claimCover.setLossAmount(new DecimalFormat("0.00").format(lossAmount[index]));
								claimCoverList.add(claimCover);
							}
						}
					}
					//医疗费用
					sunRealPaid = 0.0; 
					conditions = " compensateNo = '"+compensateNo+"' and feecategory = 'M' ";
					if(isFG){
						prpLpersonLossDtoList = (ArrayList)blPersonLossFacadeFG.findByConditions(conditions);
					}else{
						prpLpersonLossDtoList = (ArrayList)blPersonLossFacade.findByConditions(conditions);
					}
					
					kindCode = new String[50];
					kindCodeAmount = new Double[50] ;
					salvageFee=new Double[50] ;
					lossAmount=new Double[50] ;
					j = 0;
					l = 0;
					if(prpLpersonLossDtoList.size()>0){
						for(int i = 0; i < prpLpersonLossDtoList.size();i++){
							isExists = true;
							prpLpersonLossDto = prpLpersonLossDtoList.get(i);
							if(i == 0){
								kindCode[j++] = prpLpersonLossDto.getKindCode();
								kindCodeAmount[l] = prpLpersonLossDto.getSumRealPay();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLpersonLossDto.getSumLoss();
								l++;
								isExists = false;
							}else{
								for(int k = 0;k < kindCode.length;k++){
									if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLpersonLossDto.getKindCode())){
										isExists = false;
										kindCodeAmount[k] += prpLpersonLossDto.getSumRealPay();
										salvageFee[k] = 0.00;
										lossAmount[k] += prpLpersonLossDto.getSumLoss();
										k++;
									}
								}
							}
							if(isExists){
								kindCode[j++] = prpLpersonLossDto.getKindCode();
								kindCodeAmount[l] = prpLpersonLossDto.getSumRealPay();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLpersonLossDto.getSumLoss();
								l++;
							}
						}
						for(int index = 0;index < kindCode.length;index++){
							if(kindCode[index] != null && !"".equals(kindCode[index])){
								claimCover = new ClaimCover();
								claimCover.setRecoveryOrPayFlag("3");
								if(isFG){
									if(riskCode.equals("0546")){
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
									}else{
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
									}
									claimCover.setClaimFeeType("6");
								}else{
								    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
								    claimCover.setClaimFeeType("2");
								}
								claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
								
						//		claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]));
								claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
								if(salvageFee[index]==null||salvageFee[index].equals("")){
									claimCover.setSalvageFee(Double.toString(0.00));
								}else{
						//		    claimCover.setSalvageFee(Double.toString(salvageFee[index]));
								    claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
								}
						//		claimCover.setLossAmount(Double.toString(lossAmount[index]));
								claimCover.setLossAmount(new DecimalFormat("0.00").format(lossAmount[index]));
								claimCoverList.add(claimCover);
							}
						}
					}
					//无责代赔
					sunRealPaid = 0.0;
					kindCode = new String[50];
					kindCodeAmount = new Double[50] ;
					salvageFee=new Double[50] ;
					lossAmount=new Double[50] ;
					j = 0;
					l = 0;
					String nodutyConditionP = " compensateNo = '"+compensateNo+"' ";
					ArrayList<PrpLnodutyLossDto> prpLnodutyLossList =null;
					if(isFG){
						prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLossFG(dbManager).findByConditions(nodutyConditionP);
					}else{
						prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLoss(dbManager).findByConditions(nodutyConditionP);
					}
					PrpLnodutyLossDto prpLnodutyLossDto = null;
					if(prpLnodutyLossList.size()>0){
						for(int i = 0;i < prpLnodutyLossList.size();i++){
							prpLnodutyLossDto = prpLnodutyLossList.get(i);
							if(i == 0){
								kindCode[j++] = prpLnodutyLossDto.getKindCode();
								kindCodeAmount[l] = prpLnodutyLossDto.getRealPaid();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLnodutyLossDto.getRealPaid();
								l++;
								isExists = false;
							}else{
								for(int k = 0;k < kindCode.length;k++){
									if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLnodutyLossDto.getKindCode())){
										isExists = false;
										kindCodeAmount[k] += prpLnodutyLossDto.getRealPaid();
										salvageFee[k] += 0.00;
										lossAmount[k] += prpLnodutyLossDto.getRealPaid();
										k++;
									}
								}
							}
							if(isExists){
								kindCode[j++] = prpLnodutyLossDto.getKindCode();
								kindCodeAmount[l] = prpLnodutyLossDto.getRealPaid();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLnodutyLossDto.getRealPaid();
								l++;
							}
						}
						for(int index = 0;index < kindCode.length;index++){
							if(kindCode[index] != null && !"".equals(kindCode[index])){
								claimCover = new ClaimCover();
								claimCover.setRecoveryOrPayFlag("3");
								if(isFG){
									if(riskCode.equals("0546")){
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
									}else{
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
									}
									claimCover.setClaimFeeType("7");
								}else{
								    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
								    claimCover.setClaimFeeType("7");
								}
								claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
								
						//		claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]));
								claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
								if(salvageFee[index]==null||salvageFee[index].equals("")){
									claimCover.setSalvageFee(Double.toString(0.00));
								}else{
							//	    claimCover.setSalvageFee(Double.toString(salvageFee[index]));
									claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
								}
							//	claimCover.setLossAmount(Double.toString(lossAmount[index]));
								claimCover.setLossAmount(new DecimalFormat("0.00").format(lossAmount[index]));
								claimCoverList.add(claimCover);
							}
						}
					}
					
					//费用
					sunRealPaid = 0.0;
					kindCode = new String[50];
					kindCodeAmount = new Double[50] ;
					salvageFee=new Double[50] ;
					lossAmount=new Double[50] ;
					j = 0;
					l = 0;
					nodutyConditionP = " compensateNo = '"+compensateNo+"' ";
					ArrayList<PrpLchargeDto> PrpLchargeDtoList =null;
					if(isFG){
						PrpLchargeDtoList = (ArrayList)new DBPrpLchargeFG(dbManager).findByConditions(nodutyConditionP);
					}else{
						PrpLchargeDtoList = (ArrayList)new DBPrpLcharge(dbManager).findByConditions(nodutyConditionP);
					}
					PrpLchargeDto prpLchargeDto = null;
					if(PrpLchargeDtoList.size()>0 && false){
						for(int i = 0;i < PrpLchargeDtoList.size();i++){
							prpLchargeDto = PrpLchargeDtoList.get(i);
							if(i == 0){
								kindCode[j++] = prpLchargeDto.getKindCode();
								kindCodeAmount[l] = prpLchargeDto.getChargeAmount();
								if(prpLchargeDto.getChargeCode().equals("03")){
									salvageFee[l] =prpLchargeDto.getChargeAmount();
								}else{
									salvageFee[l] =0.0;
								}
								lossAmount[l] = prpLchargeDto.getChargeAmount();
								l++;
								isExists = false;
							}else{
								for(int k = 0;k < kindCode.length;k++){
									if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLchargeDto.getKindCode())){
										isExists = false;
										kindCodeAmount[k] += prpLchargeDto.getChargeAmount();
										if(prpLchargeDto.getChargeCode().equals("03")){
											salvageFee[k] +=prpLchargeDto.getChargeAmount();
										}else{
											salvageFee[k] +=0.0;
										}
										lossAmount[k] += prpLchargeDto.getChargeAmount();
										k++;
									}
								}
							}
							if(isExists){
								kindCode[j++] = prpLchargeDto.getKindCode();
								kindCodeAmount[l] = prpLchargeDto.getChargeAmount();
								if(prpLchargeDto.getChargeCode().equals("03")){
									salvageFee[l] =prpLchargeDto.getChargeAmount();
								}else{
									salvageFee[l] =0.0;
								}
								lossAmount[l++] = prpLchargeDto.getChargeAmount();
								l++;
							}
						}
						for(int index = 0;index < kindCode.length;index++){
							if(kindCode[index] != null && !"".equals(kindCode[index])){
								claimCover = new ClaimCover();
								claimCover.setRecoveryOrPayFlag("3");
								if(isFG){
									if(riskCode.equals("0546")){
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
									}else{
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
									}
									claimCover.setClaimFeeType("6");
								}else{
								    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
								    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
								    	claimCover.setClaimFeeType("6");
								    }else{
								    	claimCover.setClaimFeeType("4");
								    }
								}
								claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
								
								claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]));
								if(salvageFee[index]==null||salvageFee[index].equals("")){
									claimCover.setSalvageFee(Double.toString(0.00));
								}else{
								    claimCover.setSalvageFee(Double.toString(salvageFee[index]));
								}
								claimCover.setLossAmount(Double.toString(lossAmount[index]));
								claimCoverList.add(claimCover);
							}
						}
					}
					if(claimCoverList == null || claimCoverList.size() == 0){
						claimCover = new ClaimCover();
						claimCover.setRecoveryOrPayFlag("3");
						if(isFG){
							if(riskCode.equals("0546")){
								claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode("A"));
							}else{
								claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode("A"));
							}
							claimCover.setClaimFeeType("5");
						}else{
						    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode("A"));
						    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
						    	claimCover.setClaimFeeType("5");
						    }else{
						    	claimCover.setClaimFeeType("3");
						    }
						}
						claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
						claimCover.setLossAmount("0.00");
						claimCover.setSalvageFee("0.00");
						claimCover.setClaimAmount("0.00");
						claimCoverList.add(claimCover);
					}
					compensateVeric.setRecoveryOrPayList(recoveryOrPayList);
					compensateVeric.setClaimCoverList(claimCoverList);
					compensateVericList.add(compensateVeric);
			}
			compensateVeric1.setCompensateVericList(compensateVericList);
		}
		return compensateVeric1;
	}   
	
	/***
	 *  
	 *  结案2011
	 */
	protected EndCase getEndCase(DBManager dbManager, String claimNo,String uploadFlag)
			throws SQLException, Exception {
		EndCase endCase = new EndCase();
		String policyNo = "";
		String registNo = "";
		String riskCode="";
		String caseNo = "";
		String compensateNo = "";
		DateTime claimDate = new DateTime();
		DateTime endCaseDate = new DateTime();
		double sumDutyPaid=0d;     //赔款金额(不包括费用)
		double sumDirectClaimAmount=0d;//直接理赔费用)
		double indemnitydutyRate = 0.0;
		String claimType = "1";
		// 获取驾驶员信息
		String driverName = "";
		String certiType = "";
		String certiCode = "";
		String conditions="";
		BLPrpLloss blPrpLloss = new BLPrpLloss();
		BLPrpLpersonLoss blPrpLpersonLoss = new BLPrpLpersonLoss();
		ArrayList carLossList = new ArrayList();
		ArrayList propLossList = new ArrayList();
		ArrayList personLossList = new ArrayList();
		ArrayList prplchargeList=new ArrayList();
		List prpLrecoveryorpayList = new ArrayList();
		List claimCoverList = new ArrayList();
		ClaimCover claimCover = null;
		RecoveryOrPay recoveryOrPay = null;
		double carSumLoss=0;     //总车辆损失金额
		double carSumPaid=0;     //总车辆赔款金额
		double propSumLoss=0;    //总财产损失金额
		double propSumPaid=0;    //总财产赔款金额
		double personSumLoss=0;  //总人员损失金额
		double personSumPaid=0;  //总人员赔款金额
		double chargeSumLoss=0;  //总费用损失金额
		double chargeSumPaid=0;  //总费用赔款金额
		 
		AccidentInfor accidentInfor = new AccidentInfor(); // 出险信息
		boolean isInsuredDuty = true; // 是否事故责任
		List compensateList = (ArrayList) new BLCompensateAction().findPrpLcompensateOfValidUndwrtByClaimNo(dbManager, claimNo);
        //结案上传是只上传第一张计算书
        for (int i = 0; i < compensateList.size(); i++) {
		    PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) compensateList.get(i);
		    sumDutyPaid+=prpLcompensateDto.getSumDutyPaid();
		    sumDirectClaimAmount+=prpLcompensateDto.getSumNoDutyFee();
		    compensateNo += "'" + prpLcompensateDto.getCompensateNo() + "',";
		    /**modify by daidesheng 2016-11-18 begain*/
		    //赔偿责任比例
		    if(prpLcompensateDto.getTimes() == 1){
		    	indemnitydutyRate = prpLcompensateDto.getIndemnityDutyRate()/100;
		    }
		    /**modify by daidesheng 2016-11-18 end*/
        }
        compensateNo = compensateNo.substring(0,compensateNo.length() - 1);
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(dbManager, claimNo);
	    riskCode=prpLclaimDto.getRiskCode();
		PrpLregistDto prpLregistDto=new BLPrpLregistFacade().findByPrimaryKey( prpLclaimDto.getRegistNo());
		endCase.setDamageDate(prpLregistDto.getDamageStartDate());
		String FGDate = AppConfig.get("sysconst.FG_DATE");
		PubTools pubTools  = new PubTools();
		boolean isFG=false;
		isFG=CodeTransfer.isFG(riskCode);
		if (prpLclaimDto != null) {
			registNo = prpLclaimDto.getRegistNo();
			policyNo = prpLclaimDto.getPolicyNo();
			claimDate = prpLclaimDto.getClaimDate();
			caseNo = prpLclaimDto.getCaseNo();
			endCaseDate = prpLclaimDto.getEndCaseDate();
			riskCode=prpLclaimDto.getRiskCode();
	//		indemnitydutyRate=prpLclaimDto.getIndemnityDutyRate()/100;
		}	
		//是否新增设备
		ResultSet rs = null;
		String isDeviceItem = "";
		String strSQL = " SELECT COUNT(1) from prpCcarDevice WHERE policyno = '"+prpLclaimDto.getPolicyNo()+"' ";
		rs = dbManager.executeQuery(strSQL);
		while(rs.next()){
			isDeviceItem = rs.getString(1);
		}
		rs.close();
		if(Integer.parseInt(isDeviceItem) > 0){
			isDeviceItem = "1";//是
		}else{
			isDeviceItem = "0";//否
		}
		
		
		
		//new2011
		//String condition = " claimno = '"+claimNo+"' and times = '1'";
//		String condition = " claimno = '"+claimNo+"' and PrpLcompensateflag = '1'";
		
		
		
//		Collection compensatelist=bLPrpLcompensateFacade.findByConditions(condition);
//		if(compensatelist!=null && compensatelist.size()>0){
//		for(Iterator it=compensatelist.iterator();it.hasNext();){//新理赔需求，需要汇总
//			prpLcompensateDto=(PrpLcompensateDto)it.next();
//			compensateNo=prpLcompensateDto.getCompensateNo();
//			sumDutyPaid+=prpLcompensateDto.getSumDutyPaid();	//累计	
//			if (prpLcompensateDto.getIndemnityDutyRate() / 100 == 0.0) {
//				isInsuredDuty = false;
//			}
//			String conditions = " compensateNo='"+compensateNo+"'";
//			//车损、物损取值 
//			blPrpLloss.query(conditions);
//			for (int i = 0; i < blPrpLloss.getSize(); i++) {
//				PrpLlossSchema prpLlossSchema = blPrpLloss.getArr(i);						
//				if(!("").equals(prpLlossSchema.getLicenseNo())){
//					CarLoss carLoss = new CarLoss();  //商业险车辆损失情况
//					carLoss.setIndemnityCode(prpLlossSchema.getFeeTypeCode());
//					carLoss.setSumLoss(Double.parseDouble(prpLlossSchema.getSumLoss()));
//					carLoss.setSumDuty(Double.parseDouble(prpLlossSchema.getSumRealPay()));
//					carLossList.add(carLoss);
//					carSumLoss+=Double.parseDouble(prpLlossSchema.getSumLoss());
//					carSumPaid+=Double.parseDouble(prpLlossSchema.getSumRealPay());
//				}else{
//					PropLoss propLoss = new PropLoss();  //商业险财产损失情况
//					propLoss.setSumDuty(Double.parseDouble(prpLlossSchema.getSumRealPay()));
//					propLoss.setSumLoss(Double.parseDouble(prpLlossSchema.getSumLoss()));
//					propLossList.add(propLoss);
//					propSumLoss+=Double.parseDouble(prpLlossSchema.getSumLoss());
//					propSumPaid+=Double.parseDouble(prpLlossSchema.getSumRealPay());
//				}
//			}		
//			//人伤取值
//			blPrpLpersonLoss.query(conditions);
//			for (int j = 0; j < blPrpLpersonLoss.getSize(); j++){
//				PrpLpersonLossSchema prpLpersonLossSchema = blPrpLpersonLoss.getArr(j);
//				PersonLoss personLoss = new PersonLoss();
//				personLoss.setSumLoss(Double.parseDouble(prpLpersonLossSchema.getSumLoss()));
//				personLoss.setSumDuty(Double.parseDouble(prpLpersonLossSchema.getSumRealPay()));
//				personLoss.setIndemnityCode(prpLpersonLossSchema.getLiabDetailCode());
//				personLossList.add(personLoss);
//				personSumLoss+=Double.parseDouble(prpLpersonLossSchema.getSumLoss());
//				personSumPaid+=Double.parseDouble(prpLpersonLossSchema.getSumRealPay());
//			}
//			//施救费取值
//			String conditionsShiJiu = "compensateno='" + compensateNo
//				+ "' and compensateno in (select compensateno from prplcompensate where underwriteflag='1' or underwriteflag='3') and sumrealpay!=0 ";
//			ArrayList prplchargeShiJiuList=(ArrayList)new BLPrpLchargeAction().findByConditions(dbManager, conditionsShiJiu);
//			for( int m=0;m<prplchargeShiJiuList.size();m++)
//			{
//				PrpLchargeDto prpLchargeDto=(PrpLchargeDto)prplchargeShiJiuList.get(m);
//				prplchargeList.add(prpLchargeDto);
//				chargeSumPaid+=prpLchargeDto.getSumRealPay();
//				chargeSumLoss+=prpLchargeDto.getChargeAmount();
//			}			
//		}}else{
//			String conditions_pre = " claimNo ='" + claimNo +"'";
//			List prepayList = (ArrayList) new BLPrpLprepayAction().findByConditions(dbManager, conditions_pre);
//			if(prepayList != null && prepayList.size() > 0){
//				for(int i = 0; i < prepayList.size(); i++){					
//					PrpLprepayDto  prpLprepayDto = (PrpLprepayDto)prepayList.get(i);
//					//预赔时损失默认为人伤损失
//					PersonLoss personLoss = new PersonLoss();
//					personLoss.setSumLoss(prpLprepayDto.getSumPrePaid());
//					personLoss.setSumDuty(prpLprepayDto.getSumPrePaid());
//					personLoss.setIndemnityCode("103");//费用默认为住院费
//					personLossList.add(personLoss);
//					personSumLoss+=prpLprepayDto.getSumPrePaid();
//					personSumPaid+=prpLprepayDto.getSumPrePaid();
//					sumDutyPaid += prpLprepayDto.getSumPrePaid();
//				}
//			}
//			claimType = "3";
//		}
		double claimCoverAmountProp = 0.0;
		double claimCoverAmountProp1 = 0.0;
		if(compensateList!=null && compensateList.size()>0){
		BLPrpLRecoveryOrPayFacade blPrpLRecoveryOrPayFacade = new BLPrpLRecoveryOrPayFacade();
		conditions = " compensateNo in (" + compensateNo + ")";
		ArrayList<PrpLRecoveryOrPayDto> prpLRecoveryOrPayList = (ArrayList)blPrpLRecoveryOrPayFacade.findByConditions(conditions);
		PrpLRecoveryOrPayDto prpLRecoveryOrPayDto = null;
		Map recoverMap = new HashMap();
		Map recoverMap1 = new HashMap();
		List recoverList=new ArrayList();
		//代为案件
		boolean isTrue=false;
		if(prpLRecoveryOrPayList!=null&&prpLRecoveryOrPayList.size()>0){
			//追偿
			conditions = " compensateNo in (" + compensateNo + ") and RecoveryOrPayFlag = '1' ";
			prpLRecoveryOrPayList = (ArrayList)blPrpLRecoveryOrPayFacade.findByConditions(conditions);
			for(int i = 0;i < prpLRecoveryOrPayList.size();i++){
				prpLRecoveryOrPayDto = prpLRecoveryOrPayList.get(i);
				if(recoverMap.containsKey(prpLRecoveryOrPayDto.getRecoveryCode())){
					double RecoveryOrPayAmount=prpLRecoveryOrPayDto.getRecoveryOrPayAmount()+Double.parseDouble(String.valueOf(recoverMap.get(prpLRecoveryOrPayDto.getRecoveryCode())));
					recoverMap.put(prpLRecoveryOrPayDto.getRecoveryCode(),RecoveryOrPayAmount);
				}else{
					recoverMap.put(prpLRecoveryOrPayDto.getRecoveryCode(),prpLRecoveryOrPayDto.getRecoveryOrPayAmount());
					recoverMap1.put(prpLRecoveryOrPayDto.getRecoveryCode(), prpLRecoveryOrPayDto.getSerialNo());
				}
				
			}
			for(int i = 0;i < prpLRecoveryOrPayList.size();i++){
				prpLRecoveryOrPayDto = prpLRecoveryOrPayList.get(i);
				claimCoverAmountProp += prpLRecoveryOrPayDto.getRecoveryOrPayAmount();
				if(recoverMap1.get(prpLRecoveryOrPayDto.getRecoveryCode()).equals(prpLRecoveryOrPayDto.getSerialNo())){
				if(recoverMap.containsKey(prpLRecoveryOrPayDto.getRecoveryCode())){
						recoveryOrPay=new RecoveryOrPay();
						recoveryOrPay.setSerialNo(prpLRecoveryOrPayDto.getSerialNo());
						recoveryOrPay.setRecoveryOrPayFlag(prpLRecoveryOrPayDto.getRecoveryOrPayFlag());
						recoveryOrPay.setRecoveryOrPayType(prpLRecoveryOrPayDto.getRecoveryOrPayType());
						recoveryOrPay.setRecoveryOrPayMan(prpLRecoveryOrPayDto.getRecoveryOrPayMan());
						recoveryOrPay.setRecoveryCode(prpLRecoveryOrPayDto.getRecoveryCode());
						recoveryOrPay.setRecoveryOrPayAmount(String.valueOf(recoverMap.get(prpLRecoveryOrPayDto.getRecoveryCode())));
						recoveryOrPay.setRecoveryRemark(prpLRecoveryOrPayDto.getRecoveryRemark());
						prpLrecoveryorpayList.add(recoveryOrPay);
						recoverList.add(prpLRecoveryOrPayDto.getRecoveryCode());
						isTrue=true;
				}			
			}
			}
			if(isTrue){
			claimCover=new ClaimCover();
			claimCover.setRecoveryOrPayFlag("1");
			if(isFG){
				if(riskCode.equals("0546")){
					claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode("A"));
				}else{
					claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode("A"));
				}
				claimCover.setClaimFeeType("5");
			}else{
			    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode("A"));
			    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
			    	claimCover.setClaimFeeType("5");
			    }else{
			    	claimCover.setClaimFeeType("3");
			    }  
			}
			claimCover.setLiabilityRate(new DecimalFormat("0.00").format(indemnitydutyRate));
			claimCover.setSalvageFee(Double.toString(0.00));
			claimCover.setClaimAmount(String.valueOf(claimCoverAmountProp));
			claimCover.setLossAmount(Double.toString(claimCoverAmountProp));
			claimCoverList.add(claimCover);
			}
			
			//清付
			Map recoverMap2 = new HashMap();
			Map recoverMap3 = new HashMap();
			isTrue=false;
			conditions = " compensateNo in (" + compensateNo + ") and RecoveryOrPayFlag = '2' ";
			prpLRecoveryOrPayList = (ArrayList)blPrpLRecoveryOrPayFacade.findByConditions(conditions);
			claimCoverAmountProp1 = 0.0;
			for(int i = 0;i < prpLRecoveryOrPayList.size();i++){
				prpLRecoveryOrPayDto = prpLRecoveryOrPayList.get(i);
				if(recoverMap2.containsKey(prpLRecoveryOrPayDto.getRecoveryCode())){
					double RecoveryOrPayAmount=prpLRecoveryOrPayDto.getRecoveryOrPayAmount()+Double.parseDouble(String.valueOf(recoverMap2.get(prpLRecoveryOrPayDto.getRecoveryCode())));
					recoverMap2.put(prpLRecoveryOrPayDto.getRecoveryCode(),RecoveryOrPayAmount);
				}else{
					recoverMap2.put(prpLRecoveryOrPayDto.getRecoveryCode(),prpLRecoveryOrPayDto.getRecoveryOrPayAmount());
					recoverMap3.put(prpLRecoveryOrPayDto.getRecoveryCode(), prpLRecoveryOrPayDto.getSerialNo());
				}
				
			}
			for(int i = 0;i < prpLRecoveryOrPayList.size();i++){
				prpLRecoveryOrPayDto = prpLRecoveryOrPayList.get(i);
				claimCoverAmountProp1 += prpLRecoveryOrPayDto.getRecoveryOrPayAmount();
				if(recoverMap3.get(prpLRecoveryOrPayDto.getRecoveryCode()).equals(prpLRecoveryOrPayDto.getSerialNo())){
				if(recoverMap2.containsKey(prpLRecoveryOrPayDto.getRecoveryCode())){
						recoveryOrPay=new RecoveryOrPay();
						recoveryOrPay.setSerialNo(prpLRecoveryOrPayDto.getSerialNo());
						recoveryOrPay.setRecoveryOrPayFlag(prpLRecoveryOrPayDto.getRecoveryOrPayFlag());
						recoveryOrPay.setRecoveryOrPayType(prpLRecoveryOrPayDto.getRecoveryOrPayType());
						recoveryOrPay.setRecoveryOrPayMan(prpLRecoveryOrPayDto.getRecoveryOrPayMan());
						recoveryOrPay.setRecoveryCode(prpLRecoveryOrPayDto.getRecoveryCode());
						recoveryOrPay.setRecoveryOrPayAmount(String.valueOf(recoverMap2.get(prpLRecoveryOrPayDto.getRecoveryCode())));
						recoveryOrPay.setRecoveryRemark(prpLRecoveryOrPayDto.getRecoveryRemark());
						prpLrecoveryorpayList.add(recoveryOrPay);
						recoverList.add(prpLRecoveryOrPayDto.getRecoveryCode());
						isTrue=true;
				}			
			}
			}
			if(isTrue){
			claimCover=new ClaimCover();
			claimCover.setRecoveryOrPayFlag("2");
			if(isFG){
				if(riskCode.equals("0546")){
					claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode("A"));
				}else{
					claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode("A"));
				}
				claimCover.setClaimFeeType("5");
			}else{
			    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode("A"));
			    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
			    	claimCover.setClaimFeeType("5");
			    }else{
			    	claimCover.setClaimFeeType("3");
			    }  
			}
			claimCover.setLiabilityRate(new DecimalFormat("0.00").format(indemnitydutyRate));
			claimCover.setSalvageFee(Double.toString(0.00));
			claimCover.setClaimAmount(String.valueOf(claimCoverAmountProp1));
			claimCover.setLossAmount(Double.toString(claimCoverAmountProp1));
			claimCoverList.add(claimCover);
			}
		}
		//自付信息
		//财产损失
		BLPrpLlossFacade blPrpLlossFacade = new BLPrpLlossFacade();
		BLPrpLlossFacadeFG blPrpLlossFacadeFG = new BLPrpLlossFacadeFG();
		PrpLlossDto prpLlossDto = null;
		double sunRealPaid = 0.0;
		boolean isExists = true;
		String[] kindCode = new String[50];
		Double[] kindCodeAmount = new Double[50] ;
		Double[] salvageFee=new Double[50] ;
		int j = 0;
		int l = 0;
		ArrayList<PrpLlossDto> prpLlossDtoList = null;
		conditions = " compensateNo in (" + compensateNo + ") and kindcode not in('801','802','803','806','807','902','903','905','906','908','916','M')";
		if(isFG){
			prpLlossDtoList = (ArrayList)blPrpLlossFacadeFG.findByConditions(conditions);
		}else{
			prpLlossDtoList = (ArrayList)blPrpLlossFacade.findByConditions(conditions);
		}
		if(prpLlossDtoList.size()>0){
			for(int i = 0;i < prpLlossDtoList.size();i++){
				isExists = true;
				prpLlossDto = prpLlossDtoList.get(i);
				if(i == 0){
					kindCode[j++] = prpLlossDto.getKindCode();
					kindCodeAmount[l] = prpLlossDto.getSumAllRealPay();
					if(prpLlossDto.getFeeTypeCode().equals("05")){
						salvageFee[l] = prpLlossDto.getSumRealPay();
					}else{
						salvageFee[l] = 0.0;
					}
					l++;
					isExists = false;
				}else{
					for(int k = 0;k < kindCode.length;k++){
						
						if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLlossDto.getKindCode())){
							isExists = false;
							kindCodeAmount[k] += prpLlossDto.getSumAllRealPay();
							if(prpLlossDto.getFeeTypeCode().equals("05")){
								salvageFee[k] += prpLlossDto.getSumRealPay();
							}else{
								salvageFee[k] += 0.0;
							}
							k++;
						}
					}
				}
				if(isExists){
					kindCode[j++] = prpLlossDto.getKindCode();
					kindCodeAmount[l] = prpLlossDto.getSumAllRealPay();
					if(prpLlossDto.getFeeTypeCode().equals("05")){
						salvageFee[l] = prpLlossDto.getSumRealPay();
					}else{
						salvageFee[l] = 0.0;
					}
					l++;
				}
			}
			for(int index = 0 ; index < kindCode.length;index++){
				if(kindCode[index] != null && !"".equals(kindCode[index])){
					claimCover = new ClaimCover();
					claimCover.setRecoveryOrPayFlag("3");
					if(isFG){
						if(riskCode.equals("0546")){
							claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
						}else{
							claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
						}
						claimCover.setClaimFeeType("2");
					}else{
					    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
					    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
					    	claimCover.setClaimFeeType("2");
					    }else{
					    	claimCover.setClaimFeeType("3");
					    }  
					}
					claimCover.setLiabilityRate(new DecimalFormat("0.00").format(indemnitydutyRate));
					
					if("B".equals(kindCode[index])){
				//		claimCover.setClaimAmount(String.valueOf(kindCodeAmount[index]-claimCoverAmountProp1));
						claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]-claimCoverAmountProp1));
					}else{
			//			claimCover.setClaimAmount(String.valueOf(kindCodeAmount[index]));
						claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
					}
					if(salvageFee[index]==null||salvageFee[index].equals("")){
						claimCover.setSalvageFee(Double.toString(0.00));
					}else{
				//	    claimCover.setSalvageFee(Double.toString(salvageFee[index]));
					    claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
					}
					//是否新增设备赋值
					if("004".equals(kindCode[index])){
						claimCover.setIsDeviceItem(isDeviceItem);
					}
					claimCoverList.add(claimCover);
				}
			}
		}
		
		//死亡伤残
		BLPrpLpersonLossFacade blPersonLossFacade = new BLPrpLpersonLossFacade();
		BLPrpLpersonLossFacadeFG blPersonLossFacadeFG = new BLPrpLpersonLossFacadeFG();
		PrpLpersonLossDto prpLpersonLossDto = null;
		kindCode = new String[50];
		kindCodeAmount = new Double[50] ;
		salvageFee=new Double[50] ;
		j = 0;
		l = 0;
		sunRealPaid = 0.0; 
		conditions = "  compensateNo in (" + compensateNo + ") and feecategory = 'D' ";
		ArrayList<PrpLpersonLossDto> prpLpersonLossDtoList =null;
		if(isFG){
			prpLpersonLossDtoList = (ArrayList)blPersonLossFacadeFG.findByConditions(conditions);
		}else{
			prpLpersonLossDtoList = (ArrayList)blPersonLossFacade.findByConditions(conditions);
		}
		if(prpLpersonLossDtoList.size()>0){
			for(int i = 0; i < prpLpersonLossDtoList.size();i++){
				isExists = true;
				prpLpersonLossDto = prpLpersonLossDtoList.get(i);
				if(i == 0){
					kindCode[j++] = prpLpersonLossDto.getKindCode();
					kindCodeAmount[l] = prpLpersonLossDto.getSumAllRealPay();
					salvageFee[l] = 0.00;
					l++;
					isExists = false;
				}else{
					for(int k = 0;k < kindCode.length;k++){
						if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLpersonLossDto.getKindCode())){
							isExists = false;
							kindCodeAmount[k] += prpLpersonLossDto.getSumAllRealPay();
							salvageFee[k] += 0.00;
							k++;
						}
					}
				}
				if(isExists){
					kindCode[j++] = prpLpersonLossDto.getKindCode();
					kindCodeAmount[l] = prpLpersonLossDto.getSumAllRealPay();
					salvageFee[l] = 0.00;
					l++;
				}
			}
			for(int index = 0;index < kindCode.length;index++){
				if(kindCode[index] != null && !"".equals(kindCode[index])){
					claimCover = new ClaimCover();
					claimCover.setRecoveryOrPayFlag("3");
					if(isFG){
						if(riskCode.equals("0546")){
							claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
						}else{
							claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
						}
						claimCover.setClaimFeeType("5");
					}else{
					    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
					    claimCover.setClaimFeeType("1");
					}
					claimCover.setLiabilityRate(new DecimalFormat("0.00").format(indemnitydutyRate));
					
					if(salvageFee[index]==null||salvageFee[index].equals("")){
						claimCover.setSalvageFee(Double.toString(0.00));
					}else{
				//	    claimCover.setSalvageFee(Double.toString(salvageFee[index]));
					    claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
					}
			//		claimCover.setClaimAmount(String.valueOf(kindCodeAmount[index])); //赔款金额（含施救费），为必传项
					claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index])); //赔款金额（含施救费），为必传项
					claimCoverList.add(claimCover);
				}
			}
		}
		//医疗费用
		sunRealPaid = 0.0; 
		conditions = " compensateNo in (" + compensateNo + ") and feecategory = 'M' ";
		if(isFG){
			prpLpersonLossDtoList = (ArrayList)blPersonLossFacadeFG.findByConditions(conditions);
		}else{
			prpLpersonLossDtoList = (ArrayList)blPersonLossFacade.findByConditions(conditions);
		}
		
		kindCode = new String[50];
		kindCodeAmount = new Double[50] ;
		salvageFee=new Double[50] ;
		j = 0;
		l = 0;
		if(prpLpersonLossDtoList.size()>0){
			for(int i = 0; i < prpLpersonLossDtoList.size();i++){
				isExists = true;
				prpLpersonLossDto = prpLpersonLossDtoList.get(i);
				if(i == 0){
					kindCode[j++] = prpLpersonLossDto.getKindCode();
					kindCodeAmount[l] = prpLpersonLossDto.getSumAllRealPay();
					salvageFee[l] = 0.00;
					l++;
					isExists = false;
				}else{
					for(int k = 0;k < kindCode.length;k++){
						if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLpersonLossDto.getKindCode())){
							isExists = false;
							kindCodeAmount[k] += prpLpersonLossDto.getSumAllRealPay();
							salvageFee[k] += 0.00;
							k++;
						}
					}
				}
				if(isExists){
					kindCode[j++] = prpLpersonLossDto.getKindCode();
					kindCodeAmount[l] = prpLpersonLossDto.getSumAllRealPay();
					salvageFee[l] = 0.00;
					l++;
				}
			}
			for(int index = 0;index < kindCode.length;index++){
				if(kindCode[index] != null && !"".equals(kindCode[index])){
					claimCover = new ClaimCover();
					claimCover.setRecoveryOrPayFlag("3");
					if(isFG){
						if(riskCode.equals("0546")){
							claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
						}else{
							claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
						}
						claimCover.setClaimFeeType("6");
					}else{
					    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
					    claimCover.setClaimFeeType("2");
					}
					claimCover.setLiabilityRate(new DecimalFormat("0.00").format(indemnitydutyRate));
					
			//		claimCover.setClaimAmount(String.valueOf(kindCodeAmount[index]));
					claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
					if(salvageFee[index]==null||salvageFee[index].equals("")){
						claimCover.setSalvageFee(Double.toString(0.00));
					}else{
				//	    claimCover.setSalvageFee(Double.toString(salvageFee[index]));
					    claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
					}
					claimCoverList.add(claimCover);
				}
			}
		}
		//无责代赔
		sunRealPaid = 0.0;
		kindCode = new String[50];
		kindCodeAmount = new Double[50] ;
		salvageFee=new Double[50] ;
		j = 0;
		l = 0;
		String nodutyConditionP = "  compensateNo in (" + compensateNo + ")";
		ArrayList<PrpLnodutyLossDto> prpLnodutyLossList =null;
		if(isFG){
			prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLossFG(dbManager).findByConditions(nodutyConditionP);
		}else{
			prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLoss(dbManager).findByConditions(nodutyConditionP);
		}
		PrpLnodutyLossDto prpLnodutyLossDto = null;
		if(prpLnodutyLossList.size()>0){
			for(int i = 0;i < prpLnodutyLossList.size();i++){
				prpLnodutyLossDto = prpLnodutyLossList.get(i);
				if(i == 0){
					kindCode[j++] = prpLnodutyLossDto.getKindCode();
					kindCodeAmount[l] = prpLnodutyLossDto.getRealPaid();
					salvageFee[l] = 0.00;
					l++;
					isExists = false;
				}else{
					for(int k = 0;k < kindCode.length;k++){
						if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLnodutyLossDto.getKindCode())){
							isExists = false;
							kindCodeAmount[k] += prpLnodutyLossDto.getRealPaid();
							salvageFee[k] += 0.00;
							k++;
						}
					}
				}
				if(isExists){
					kindCode[j++] = prpLnodutyLossDto.getKindCode();
					kindCodeAmount[l] = prpLnodutyLossDto.getRealPaid();
					salvageFee[l] = 0.00;
					l++;
				}
			}
			for(int index = 0;index < kindCode.length;index++){
				if(kindCode[index] != null &&!"".equals(kindCode[index])){
					claimCover = new ClaimCover();
					claimCover.setRecoveryOrPayFlag("3");
					if(isFG){
						if(riskCode.equals("0546")){
							claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
						}else{
							claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
						}
						claimCover.setClaimFeeType("2");
					}else{
					    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
					    claimCover.setClaimFeeType("7");
					}
					claimCover.setLiabilityRate(new DecimalFormat("0.00").format(indemnitydutyRate));
					
			//		claimCover.setClaimAmount(String.valueOf(kindCodeAmount[index]));
					claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
					if(salvageFee[index]==null||salvageFee[index].equals("")){
						claimCover.setSalvageFee(Double.toString(0.00));
					}else{
				//	    claimCover.setSalvageFee(Double.toString(salvageFee[index]));
					    claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
					}
					claimCoverList.add(claimCover);
				}
			}
		}
		//费用
		sunRealPaid = 0.0;
		chargeSumPaid=0.0;
		kindCode = new String[50];
		kindCodeAmount = new Double[50] ;
		salvageFee=new Double[50] ;
		j = 0;
		l = 0;
		nodutyConditionP = "compensateNo in (" + compensateNo + ")";
		ArrayList<PrpLchargeDto> PrpLchargeDtoList =null;
		if(isFG){
			PrpLchargeDtoList = (ArrayList)new DBPrpLchargeFG(dbManager).findByConditions(nodutyConditionP);
		}else{
			PrpLchargeDtoList = (ArrayList)new DBPrpLcharge(dbManager).findByConditions(nodutyConditionP);
		}
		PrpLchargeDto prpLchargeDto = null;
		if(PrpLchargeDtoList.size()>0&&false){
			for(int i = 0;i < PrpLchargeDtoList.size();i++){
				prpLchargeDto = PrpLchargeDtoList.get(i);
				chargeSumPaid+=prpLchargeDto.getChargeAmount();
				if(i == 0){
					kindCode[j++] = prpLchargeDto.getKindCode();
					kindCodeAmount[l] = prpLchargeDto.getChargeAmount();
					if(prpLchargeDto.getChargeCode().equals("03")){
						salvageFee[l] =prpLchargeDto.getChargeAmount();
					}else{
						salvageFee[l] =0.0;
					}
					l++;
					isExists = false;
				}else{
					for(int k = 0;k < kindCode.length;k++){
						if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLchargeDto.getKindCode())){
							isExists = false;
							kindCodeAmount[k] += prpLchargeDto.getChargeAmount();
							if(prpLchargeDto.getChargeCode().equals("03")){
								salvageFee[k] +=prpLchargeDto.getChargeAmount();
							}else{
								salvageFee[k] +=0.0;
							}
							k++;
						}
					}
				}
				if(isExists){
					kindCode[j++] = prpLchargeDto.getKindCode();
					kindCodeAmount[l] = prpLchargeDto.getChargeAmount();
					if(prpLchargeDto.getChargeCode().equals("03")){
						salvageFee[l] =prpLchargeDto.getChargeAmount();
					}else{
						salvageFee[l] =0.0;
					}
					l++;
				}
			}
			for(int index = 0;index < kindCode.length;index++){
				if(kindCode[index] != null && !"".equals(kindCode[index])){
					claimCover = new ClaimCover();
					claimCover.setRecoveryOrPayFlag("3");
					if(isFG){
						if(riskCode.equals("0546")){
							claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
						}else{
							claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
						}
						claimCover.setClaimFeeType("6");
					}else{
					    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
					    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
					    	claimCover.setClaimFeeType("6");
					    }else{
					    	claimCover.setClaimFeeType("4");
					    }  
					}
					claimCover.setLiabilityRate(new DecimalFormat("0.00").format(indemnitydutyRate));
					
					claimCover.setClaimAmount(String.valueOf(kindCodeAmount[index]));
					if(salvageFee[index]==null||salvageFee[index].equals("")){
						claimCover.setSalvageFee(Double.toString(0.00));
					}else{
					    claimCover.setSalvageFee(Double.toString(salvageFee[index]));
					}
					claimCoverList.add(claimCover);
				}
			}
		}
		}else{
			String conditions_pre = " claimNo ='" + claimNo +"'";
			List prepayList = (ArrayList) new BLPrpLprepayAction().findByConditions(dbManager, conditions_pre);
			if(prepayList != null && prepayList.size() > 0){
				for(int i = 0; i < prepayList.size(); i++){					
					PrpLprepayDto  prpLprepayDto = (PrpLprepayDto)prepayList.get(i);
					//预赔时损失默认为人伤损失
					PersonLoss personLoss = new PersonLoss();
					personLoss.setSumLoss(prpLprepayDto.getSumPrePaid());
					personLoss.setSumDuty(prpLprepayDto.getSumPrePaid());
					personLoss.setIndemnityCode("103");//费用默认为住院费
					personLossList.add(personLoss);
					personSumLoss+=prpLprepayDto.getSumPrePaid();
					personSumPaid+=prpLprepayDto.getSumPrePaid();
					sumDutyPaid += prpLprepayDto.getSumPrePaid();
				}
			}
			claimType = "3";
		}
		DateTime damageStartDate = new DateTime();
		String damageStartHour = "";
		String accidentPlace = "";  //出险地点
		String handleUnit ="";
		
		prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager, registNo);
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			// 获取出险地点
			accidentPlace = prpLregistDto.getDamageAddress();
			handleUnit = prpLregistDto.getHandleUnit();
			if("".equals(handleUnit))handleUnit="99";
			
			endCase.setDamageDate(damageStartDate);
		}
		
		
		
		// 获取出险经过
		//String accidentDesc = getPrpLltext(dbManager,claimNo,"09");
		//new 2011
		String accidentDesc = getprplregisttext(dbManager,registNo);
		
		//定义反欺诈案件
		String conditionsF = " registNo='"+registNo+"' and nodetype='compp'";
		ArrayList<PrpLFirstVeriOpinionDto> firstVeriOpinionList = null;
		PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto = null;
		CIPrpLfraudTypeDto ciPrpLfraudTypeDto = null;
		List prpLfraudTypeList = new ArrayList();
		firstVeriOpinionList = (ArrayList)new BLPrpLFirstVeriOpinionAction().findByConditions(dbManager, conditionsF);
		if(firstVeriOpinionList!=null && firstVeriOpinionList.size()>0){
			for(int f=0;f<firstVeriOpinionList.size();f++){
				ciPrpLfraudTypeDto = new CIPrpLfraudTypeDto();
				prpLFirstVeriOpinionDto = firstVeriOpinionList.get(f);
				endCase.setIsRefuseCase(prpLFirstVeriOpinionDto.getLingjieAnType()); //是否拒赔，系统中'1'为拒赔
				endCase.setRefusereason(prpLFirstVeriOpinionDto.getPeifuIns()); //拒赔原因
				endCase.setFraudLogo(prpLFirstVeriOpinionDto.getFraudLogo());
				endCase.setFraudRecoverAmount(prpLFirstVeriOpinionDto.getFraudRecoverAmount());
				ciPrpLfraudTypeDto.setFraudType(prpLFirstVeriOpinionDto.getFraudType());
				prpLfraudTypeList.add(ciPrpLfraudTypeDto);
			}
			endCase.setPrpLFraudTypeList(prpLfraudTypeList);
		}
		//定义反欺诈案件结束
		
		// 获取拒赔原因
		String refusereason = getPrpLltext(dbManager,claimNo,"10");
		// 获取出险日期，出险时间
		Date damageDate = new Date((damageStartDate.getYear() - 1900),
				(damageStartDate.getMonth() - 1), damageStartDate.getDate(),
				Integer.parseInt(damageStartHour.split(":")[0]), Integer
						.parseInt(damageStartHour.split(":")[1]));
		accidentInfor.setAccidentTime(damageDate);
		accidentInfor.setAccidentPlace(accidentPlace);
		accidentInfor.setAccidentDesc(accidentDesc);
		accidentInfor.setHandleUnit(handleUnit);
		accidentInfor.setIndemnityDuty(prpLclaimDto.getIndemnityDuty());
		
		//驾驶员信息
		PrpLdriverDto prpLdriverDto = new BLPrpLdriverFacade()
		.findByPrimaryKey(registNo, 1);
		if (prpLdriverDto != null) {
			driverName = prpLdriverDto.getDriverName();
			certiType = prpLdriverDto.getIdentifyType();
			certiCode = prpLdriverDto.getIdentifyNumber();
			if(certiCode.length()>18){
				certiCode=certiCode.substring(0, 18);
			}
		}else {
			driverName = "无";
			certiType = "99";
			certiCode = "0";
		}
		if(driverName==null
				||"".equals(driverName))
		{
			driverName = "无";
		}
		//三者车信息
		List thirdCarList = new ArrayList();
		//thirdCarList = getThirdCarList(dbManager, registNo);
		System.out.println("2");
		endCase.setPolicyNo(policyNo);
		endCase.setRegistNo(registNo);
		endCase.setClaimNo(claimNo);
		endCase.setEndCaseNo(caseNo);
		sumDutyPaid+=claimCoverAmountProp;
		endCase.setSumDutyPaid(sumDutyPaid);
		Date dateTime = null;
//		if(claimDate.compareTo(endCaseDate)==0){
//			dateTime = new DateTime(DateTime.current().addHour(5),DateTime.YEAR_TO_MINUTE);
//		}else{
//			dateTime = endCaseDate;
//		}
		if("1".equals(uploadFlag)){
			dateTime = new DateTime(prpLclaimDto.getEndCaseDate(), DateTime.YEAR_TO_MINUTE);
		}else{
			dateTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_MINUTE);	
		}
		System.out.println("结案时间"+new SimpleDateFormat("yyyyMMddHHmm").format(dateTime));
		BLPrpLcarLossFacade blPrpLcarLossFacade=new BLPrpLcarLossFacade();
		PrpLcarLossDto prpLcarLossDto=blPrpLcarLossFacade.findByPrimaryKey(registNo, "1");
		String isTotalLoss="";
		if(prpLcarLossDto!=null){
			isTotalLoss=prpLcarLossDto.getIsAllLoss();
		}else{
			isTotalLoss="1";
		}
		String claimCode=getClaimCode(dbManager,"V3104",registNo,claimNo,"");
		BLCIClaimDemandAction claimDemand=new BLCIClaimDemandAction();
		CIClaimDemandDto ciClaimDemandDto=new CIClaimDemandDto();
		ciClaimDemandDto=claimDemand.findByPrimaryKey(dbManager, claimCode);
		if(null!=ciClaimDemandDto){
		    endCase.setClaimConfirm(ciClaimDemandDto.getCaseCheckNo());
		}else{
			endCase.setClaimConfirm("");	
		}
		endCase.setEndCaseTime(dateTime);
		endCase.setInsuredDuty(isInsuredDuty);
		endCase.setClaimType(claimType);
		if("0".equals(isTotalLoss)){
			isTotalLoss = "1";
		}else{
			isTotalLoss = "0";
		}
		endCase.setIsTotalLoss(isTotalLoss);
		if("1".equals(endCase.getIsRefuseCase())){
		}else{
			endCase.setIsRefuseCase("0");
		}
	//	endCase.setRefusereason(refusereason);
		endCase.setDirectClaimAmount(sumDirectClaimAmount);
		endCase.setDriverName(driverName);
		endCase.setCertiType(certiType);
		endCase.setCertiCode(certiCode);
		endCase.setAccidentInfor(accidentInfor);
		endCase.setOptionType(handleUnit);
		endCase.setDamageCode(prpLclaimDto.getDamageCode());		
		endCase.setThirdCarList(thirdCarList);
		endCase.setCarSumLoss(carSumLoss);
		endCase.setCarSumPaid(carSumPaid);
		endCase.setPersonSumLoss(personSumLoss);
		endCase.setPersonSumPaid(personSumPaid);
		endCase.setPropSumLoss(propSumLoss);
		endCase.setPropSumPaid(propSumPaid);
		endCase.setChargeSumPaid(chargeSumPaid);//总费用赔款金额
		endCase.setChargeSumLoss(chargeSumLoss);//总费用损失金额
		endCase.setCarLossList(carLossList);
		endCase.setPropLossList(propLossList);
		endCase.setPersonLossList(personLossList);		
		endCase.setPrplchargeList(prplchargeList);	
		endCase.setPrpLrecoveryorpayList(prpLrecoveryorpayList);
		//add by lianjingwei 20081028 车辆损失情况、物损损失情况、人员损失情况须至少填写一条赔偿情况信息不能为空 start
		if(claimCoverList.size()==0){
			claimCover = new ClaimCover();
			claimCover.setRecoveryOrPayFlag("3");
			if(isFG){
				if(riskCode.equals("0546")){
					claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode("A"));
				}else{
					claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode("A"));
				}
				claimCover.setClaimFeeType("1");
			}else{
			    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode("A"));
			    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
			    	claimCover.setClaimFeeType("1");
			    }else{
			    	claimCover.setClaimFeeType("3");
			    }  
			}
			claimCover.setLiabilityRate(Double.toString(0.0));
			claimCover.setSalvageFee(Double.toString(0.0));
			claimCover.setClaimAmount(String.valueOf(0.0));
			claimCoverList.add(claimCover);
		}
		//add by lianjingwei 20081028 车辆损失情况、物损损失情况、人员损失情况须至少填写一条赔偿情况信息不能为空 end
		endCase.setClaimCoverList(claimCoverList);
		return endCase;
	}
	
	
	//2011商业险平台交互
	public ArrayList getRecaseList(String claimNo) throws Exception {
		boolean blnReturn = false;   //为false为无重开 或 重开已结案
		String conditions=" claimNo = '"+claimNo+"'";
		int maxSerialNo = 0;
		
		UIRecaseAction   uiRecaseAction = new UIRecaseAction();
		Collection   list = uiRecaseAction.findByConditions(conditions);
		ArrayList prpLrecaseDtoList = null;
		if (list != null && list.size()>0) {
			maxSerialNo = uiRecaseAction.getMaxSerialNo(claimNo);
			String conditions1=" claimno='"+claimNo+"' and serialNo='"+maxSerialNo+"'";
			prpLrecaseDtoList=(ArrayList)uiRecaseAction.findByConditions(conditions1);			
		}
		return prpLrecaseDtoList;
	}
	
	/**
	 * 
	 * 结案追加 2011
	 */
	protected EndCaseAppend getEndCaseAppend(DBManager dbManager, String claimNo,String cishu)
	throws SQLException, Exception {
		Date dateTime = null;
		EndCaseAppend endCaseAppend = new EndCaseAppend();
		BLPrpLcompensateFacade bLPrpLcompensateFacade=new BLPrpLcompensateFacade();
		ArrayList endCaseAppSituationList = new ArrayList();
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(dbManager, claimNo);
		ArrayList prpLrecaseDtoList = getRecaseList(claimNo);
		String compensateNo="";
		String conditions = "";
		String serialNo = "1";
		String  recaseReason = "";
		DateTime recaseDate = new DateTime();
		BLPrpLloss blPrpLloss = new BLPrpLloss();
		BLPrpLpersonLoss blPrpLpersonLoss = new BLPrpLpersonLoss();	
		for(int i=0;i<prpLrecaseDtoList.size();i++)
		{
			PrpLrecaseDto prpLrecaseDto=(PrpLrecaseDto)prpLrecaseDtoList.get(i);
			PrpLcompensateDto prpLcompensateDto= null;
			int times = 0;
			//新理赔添加2011,参数中加入追加次数
			if("".equals(cishu)){
				times=prpLrecaseDto.getSerialNo()+1;
			}else{
				times=Integer.parseInt(cishu);
			}
			String condition=" claimno='"+claimNo+"' and times='"+times+"'";			
			Collection compensatelist=bLPrpLcompensateFacade.findByConditions(condition);
			if(compensatelist!=null && compensatelist.size()>0){
				prpLcompensateDto=(PrpLcompensateDto)compensatelist.iterator().next();
				compensateNo=prpLcompensateDto.getCompensateNo();
			}
			serialNo = String.valueOf(prpLrecaseDto.getSerialNo());
			recaseDate = prpLrecaseDto.getCloseCaseDate();
			recaseReason = prpLrecaseDto.getReCaseReason();
			
			conditions = " compensateNo='"+compensateNo+"'";
			//车损、物损取值 
			blPrpLloss.query(conditions);
			for (int j = 0; j < blPrpLloss.getSize(); j++) {
				PrpLlossSchema prpLlossSchema = blPrpLloss.getArr(j);	
				EndCaseAppSituation endCaseAppSituation = new EndCaseAppSituation();					
				if(!("").equals(prpLlossSchema.getLicenseNo())){
					endCaseAppSituation.setLossType("1");
				}else{
					endCaseAppSituation.setLossType("2");
				}
				endCaseAppSituation.setAppPaySum(Double.parseDouble(prpLlossSchema.getSumRealPay()));
				endCaseAppSituationList.add(endCaseAppSituation);	
			}		
			//人伤取值
			blPrpLpersonLoss.query(conditions);
			for (int j = 0; j < blPrpLpersonLoss.getSize(); j++){
				PrpLpersonLossSchema prpLpersonLossSchema = blPrpLpersonLoss.getArr(j);
				EndCaseAppSituation endCaseAppSituation = new EndCaseAppSituation();					
				endCaseAppSituation.setLossType("3");
				endCaseAppSituation.setAppPaySum(Double.parseDouble(prpLpersonLossSchema.getSumRealPay()));
				endCaseAppSituationList.add(endCaseAppSituation);
			}
			//施救费取值
			String conditionsShiJiu = "compensateno='" + compensateNo
				+ "' and compensateno in (select compensateno from prplcompensate where underwriteflag='1' or underwriteflag='3') and sumrealpay!=0 ";
			ArrayList prplchargeShiJiuList=(ArrayList)new BLPrpLchargeAction().findByConditions(dbManager, conditionsShiJiu);
			for( int m=0;m<prplchargeShiJiuList.size();m++)
			{
				PrpLchargeDto prpLchargeDto=(PrpLchargeDto)prplchargeShiJiuList.get(m);
				EndCaseAppSituation endCaseAppSituation = new EndCaseAppSituation();
				endCaseAppSituation.setLossType("4");
				endCaseAppSituation.setAppPaySum(prpLchargeDto.getSumRealPay());
				endCaseAppSituationList.add(endCaseAppSituation);
			}     
			DateTime endcaseDate = prpLclaimDto.getEndCaseDate();
			boolean boo=(endcaseDate.getYear()==recaseDate.getYear())&&(endcaseDate.getMonth()==recaseDate.getMonth())&&(endcaseDate.getDate()==recaseDate.getDate());
			if(boo){
				dateTime = new Date((prpLrecaseDto.getCloseCaseDate().getYear() - 1900),
						(prpLrecaseDto.getCloseCaseDate().getMonth() - 1), prpLrecaseDto.getCloseCaseDate().getDate(),
						23, 59);
			}else{
				dateTime =recaseDate;
			}
		}
		//赔偿信息按损失类型合并
	    endCaseAppend.setEndCaseAppSituationList(losstypeBing(endCaseAppSituationList));		
		
		//车辆损失情况、物损损失情况、人员损失情况须至少填写一条赔偿情况信息不能为空 start
		if(endCaseAppend.getEndCaseAppSituationList().size()==0){
			EndCaseAppSituation endCaseAppSituation = new EndCaseAppSituation();
			endCaseAppSituation.setLossType("9");			
			endCaseAppSituation.setAppPaySum(0.00);
			endCaseAppSituationList.add(endCaseAppSituation);
			endCaseAppend.setEndCaseAppSituationList(endCaseAppSituationList);
		}
		//车辆损失情况、物损损失情况、人员损失情况须至少填写一条赔偿情况信息不能为空 end		
		
		endCaseAppend.setClaimNo(claimNo);
		endCaseAppend.setSerialNo(serialNo);
		endCaseAppend.setRegistNo(prpLclaimDto.getRegistNo());
		endCaseAppend.setPolicyNO(prpLclaimDto.getPolicyNo());
		endCaseAppend.setCaseNo(prpLclaimDto.getCaseNo());
		endCaseAppend.setComCode(prpLclaimDto.getComCode());
		endCaseAppend.setRecaseDate(dateTime);
		endCaseAppend.setRecaseReason(recaseReason);
		return endCaseAppend;
	}

//	/**
//	 * 获得商业险赔付对象2011
//	 */
//	protected Payinfor getPayinfor(DBManager dbManager, String compensateNo,String registType,String payRefNo)
//	throws SQLException, Exception {		
//		Payinfor payinfor = new Payinfor();	
//		DateTime payRefdate = new DateTime();
//		DateTime endcaseDate = new DateTime();
//		double sumPaid = 0.0;
//		String payType="1";
//		String claimNo = "";
//		String registNo = "";
//		String policyNo="";
//		String times = "1";
//		
//		/*String compensateNos = "";
//		String preCompensateNos = "";
//		String serialNo = "";*/
//		PrpLcompensateDto prpLcompensateDto = new BLPrpLcompensateFacade().findByPrimaryKey(compensateNo);//605063466002009000151-001
//		if(prpLcompensateDto!=null){//实赔
//			claimNo = prpLcompensateDto.getClaimNo();
//		//	times = String.valueOf(prpLcompensateDto.getTimes());
//		//	sumPaid = prpLcompensateDto.getSumDutyPaid();
//		}else{//预陪
//			BLPrpLprepayAction blPrpLprepayAction = new BLPrpLprepayAction();
//			PrpLprepayDto prpLprepayDto = blPrpLprepayAction.findByPrimaryKey(dbManager, compensateNo);
//			if(prpLprepayDto!=null){
//				claimNo=prpLprepayDto.getClaimNo();
//		//		sumPaid = prpLprepayDto.getSumPrePaid();
//		//		times = compensateNo.substring(compensateNo.length()-1, compensateNo.length());
//			}
//		}
//		
//		
//		//new 2011 new 2011new 2011new 2011new 2011new 2011new 2011new 2011
//		String strSql="";
//		ResultSet rs = null;
//		String newSql="Select Sum(payAmount) ,compensateNo,paydate From prplpay  Where paydate Is Not Null And compensateNo ='"+compensateNo+"'  Group By compensateNo,paydate Order By paydate Desc";
//		rs = dbManager.executeQuery(newSql);
//		if(rs.next()){
// 			sumPaid=rs.getDouble(1);
// 			payRefdate=dbManager.getDateTime(rs, DateTime.YEAR_TO_SECOND,3);
// 			rs.last(); //移到最后一行   
// 			int rowCount = rs.getRow();//得到当前行号，也就是记录数 
// 			times=String.valueOf(rowCount);
// 		}
//		PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(claimNo);
//		registNo = prpLclaimDto.getRegistNo();
//		//policyNo = getPolicyNo(dbManager, registNo,registType);
//		policyNo = prpLclaimDto.getPolicyNo();
//		endcaseDate=prpLclaimDto.getEndCaseDate();
//		if(payRefdate.after(endcaseDate)){
//			payType = "2";
//		}
//		/* strSql = " Select Max(uploadSerialNo) From (							  "+
//			" select uploadSerialNo from prplcompensate where claimno = '" + claimNo + "'  "+
//			" Union All                                                     "+
//			" select uploadSerialNo from prplprepay where claimno = '" + claimNo + "'      "+
//			" )                                                             ";
//		rs = dbManager.executeQuery(strSql);
//		if(rs.next()){
//			serialNo = (rs.getInt(1) + 1) + "";
//		}*/
//		String serialNo = "1";
//		strSql=" select Max(uploadSerialNo) from prplpay where claimno='"+claimNo+"'";
//		rs=dbManager.executeQuery(strSql);
//		if(rs.next()){
//			serialNo = (rs.getInt(1) + 1) + "";
//		}
//		/*//取实付金额、实付时间
//		 strSql = " Select rec.certino,rec.payrefreason,cl.endcasedate as endcasedate,		" +
//			" Sum(rec.payreffee) From prplclaim cl,                                 " +
//			" prpjpayrefrec rec                                                     " +
//			" Where rec.claimno=cl.claimno                                          " +
//			" And rec.payrefreason In ('P50','P60')                                 " +
//			" And rec.payrefno='" + payRefNo + "' "+
//			" And cl.claimno='" + claimNo + "'                                      " +
//			" Group By  rec.certino,rec.payrefreason,cl.endcasedate  "; 
//		rs = dbManager.executeQuery(strSql);
//		while(rs.next()){
//			if(endcaseDate.isEmpty()){
//				endcaseDate = dbManager.getDateTime(rs, DateTime.YEAR_TO_SECOND, "endcasedate");
//			}
//			if(payRefdate.isEmpty()){
//				//预赔从prplprepay表取实付时间
//				if("P50".equals(rs.getString(2))){
//					BLPrpLprepayAction blPrpLprepayAction = new BLPrpLprepayAction();
//					PrpLprepayDto prpLprepayDto = blPrpLprepayAction.findByPrimaryKey(dbManager, rs.getString(1));
//					payRefdate = prpLprepayDto.getPayRefDate();
//					System.err.println("成功取得预配日期！！");
//				}else{
//				//实赔从prplcompensate表取实付时间
//					BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
//					PrpLcompensateDto prpLcompensateDTO = blPrpLcompensateAction.findByPrimaryKey(dbManager, rs.getString(1));
//					payRefdate = prpLcompensateDTO.getPayrefDate();
//					System.err.println("成功取得实赔日期！！");
//				}
//			}
//			if("P60".equals(rs.getString(2))){
//				compensateNos += "'" + rs.getString(1) + "',";
//			}else{
//				preCompensateNos += "'" + rs.getString(1) + "',";
//			}
//			
//			if(payRefdate.after(endcaseDate)){
//				payType = "2";
//			}
//			if(compensateNos.length() > 1){
//				compensateNos = compensateNos.substring(0, compensateNos.length() - 1);
//			}
//			if(preCompensateNos.length() > 1){
//				preCompensateNos = preCompensateNos.substring(0, preCompensateNos.length() - 1);
//			}
//		}*/
//		
//		
//		payinfor.setPayType(payType);
//		payinfor.setClaimNo(claimNo);
//		payinfor.setRegistNo(registNo);
//		payinfor.setPolicyNo(policyNo);
//		payinfor.setSumPaid(sumPaid);
//		payinfor.setTimes(times);
//		payinfor.setPayDate(payRefdate);
//		
//		payinfor.setSerialNo(serialNo);
//		/*payinfor.setPreCompensateNos(preCompensateNos);
//		payinfor.setCompensateNos(compensateNos);*/
//		rs.close();
//		return payinfor;
//	}
	/**
	 * 获得商业险赔付对象2011
	 */
	protected Payinfor getPayinfor(DBManager dbManager, String claimNo,String registType,String payRefNo)
	throws SQLException, Exception {
		Payinfor payinfor = new Payinfor();	
		
		ResultSet rs = null;
		String serialNo = null;//取上传序号
		String strSql = " Select Max(uploadSerialNo) From (							  "+
			" select uploadSerialNo from prplcompensate where claimno = '" + claimNo + "'  "+
			" Union All                                                     "+
			" select uploadSerialNo from prplprepay where claimno = '" + claimNo + "'      "+
			" )                                                             ";
		rs = dbManager.executeQuery(strSql);
		if(rs.next()){
			serialNo = (rs.getInt(1) + 1) + "";
		}
		if(rs!=null){
			rs.close();
		}
		//取实付金额、实付时间
		DateTime payRefdate = new DateTime();
		Paydata payData = null;
		List<Paydata> payDataList = new ArrayList<Paydata>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");
		double payAmount = 0D;
		String compensateNos = "";
		String preCompensateNos = "";
		strSql = "Select rec.certino,rec.payrefreason,cl.endcasedate as endcasedate,     "+
				"Sum(rec.payreffee),lr.recoverycode                                      "+
				" From prplclaim cl, prpjpayrefrec rec, PrpLRecoveryOrPay lr             "+
				"Where rec.claimno = cl.claimno                                          "+
				"  And lr.compensateno (+) = rec.certino                                 "+
				"  And lr.serialno(+) = rec.recoveryserialno                             "+
//				"  And (substr(rec.flag, 1, 1) not in ('1', '2') Or rec.flag is null)    "+
				"  And rec.payrefreason In ('P50', 'P60', 'P97', 'Z03','P63')                  "+
				//"  And rec.payrefno = '" + payRefNo + "'                                 "+
				"  And cl.claimno = '" + claimNo + "'                                    "+
				"Group By rec.certino, rec.payrefreason, cl.endcasedate, lr.recoverycode ";
		rs = dbManager.executeQuery(strSql);
		while(rs.next()){
			payAmount += rs.getDouble(4);
			if(payRefdate.isEmpty()){
				//预赔从prplprepay表取实付时间
				if("P50".equals(rs.getString(2))){
					BLPrpLprepayAction blPrpLprepayAction = new BLPrpLprepayAction();
					PrpLprepayDto prpLprepayDto = blPrpLprepayAction.findByPrimaryKey(dbManager, rs.getString(1));
					payRefdate = prpLprepayDto.getPayRefDate();
					System.err.println("成功取得预配日期！！");
				}else{
				//实赔从prplcompensate表取实付时间
					BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
					PrpLcompensateDto prpLcompensateDTO = blPrpLcompensateAction.findByPrimaryKey(dbManager, rs.getString(1));
					payRefdate = prpLcompensateDTO.getPayrefDate();
					System.err.println("成功取得实赔日期！！");
				}
			}
			if("P60".equals(rs.getString(2))){
				compensateNos += "'" + rs.getString(1) + "',";
			}else{
				preCompensateNos += "'" + rs.getString(1) + "',";
			}
			/**收款账户明细列表*/
			payData = new Paydata();
			payData.setClaimAmount(rs.getDouble(4));
			payData.setRecoveryCode(rs.getString(5)==null?"":rs.getString(5));
			payDataList.add(payData);
			
		}
		if(rs!=null){
			rs.close();
		}
		/**
		 * 赔付登记待修改
		 * 存在精度问题可能提示赔款超过14位
		 */
		payAmount=Str.round(payAmount,2);
		//将赔偿支付时间写入所有payData对象中
		if(!payRefdate.isEmpty()){
			for(Iterator itr = payDataList.iterator();itr.hasNext();){
				((Paydata)itr.next()).setPayDate(payRefdate);
			}
		}
		//格式化计算书号和预赔计算书号；由605063418002010000006-005,605063418002010000006-003,格式为605063418002010000006-005,605063418002010000006-003。
		if(compensateNos.length() > 1){
			compensateNos = compensateNos.substring(0, compensateNos.length() - 1);
		}
		if(preCompensateNos.length() > 1){
			preCompensateNos = preCompensateNos.substring(0, preCompensateNos.length() - 1);
		}
		if("".equals(payRefNo)){
			//通过立案号获取payRefNo
			strSql = " select payrefno from prpjpayrefrec  where claimno = '"+claimNo+"' " +
			 	     " and certitype in ('C','Y') " +
			 	     " and payrefreason In ('P50', 'P60', 'P97', 'Z03') " +
			 	     " and payrefno <> '0' " +
			 	     " and payrefno is not null ";
			rs = dbManager.executeQuery(strSql);
			if(rs.next()){
				payRefNo = rs.getString(1);
			}
			if (rs != null){
				rs.close();
			}
		}
		//赔款支付 开户行，账户名
		String bankName = "";
		String accountName = "";
		strSql = "select c.bankname,a.accountname from accbankcode c,accbankaccount a,PrpJpayRefMain m,PrpJpayRefDetail d " +
				"where m.payrefno = d.payrefno " +
				"and d.bankcode = c.bankcode " +
				"and a.bankcode = d.bankcode " +
				"and m.payrefunit = a.centercode " +
				"and a.accountcode = d.accountno " +
				"and d.payrefno='"+ payRefNo +"'";
		rs = dbManager.executeQuery(strSql);
		if(rs.next()){
			bankName = rs.getString(1);
			//accountName = rs.getString(2);
		}
		if(rs!=null){
			rs.close();
		}
		/**
		 * 赔付登记待修改
		 * 此处存在负数赔案没有支付信息
		 */
		//增加收款明细列表信息
		List<Paydata> payDataList1 = new ArrayList<Paydata>();
		double claimAmount = 0D;
		DateTime paydate = new DateTime(); 
		String queryPayment = "select bankaccount,banktype,receiverfullname,certiftype,certifno,payamount, paydate, inputdate from prplpay " +
		  "where  " +
				" prplpay.claimno = '"+claimNo+"'" +
				"  and prplpay.paymenttype in ('P50', 'P60', 'P97', 'Z03','P63')"+
				"  and EXISTS (SELECT 1 FROM prplpaymain WHERE prplpaymain.paymentno=prplpay.serialno "+
				"  and prplpaymain.thirdpayflag IN ('7','9','m'))";
		rs = dbManager.executeQuery(queryPayment);
		while(rs.next()){
			payData = new Paydata();
			if(rs.getString(3) != null && !"".equals(rs.getString(3))){
				payData.setRBankAcountName(rs.getString(3));
			}
			payData.setCentiType(rs.getString(4));
			//因为上传平台时有的传了CentiCode，有的传了RBankCenticode所以在这里对两个字段赋统一值
			payData.setCentiCode(rs.getString(5));
			payData.setRBankCenticode(rs.getString(5));
			/**
			 * 因为存在证件号码为空的数据（支付录入没有复现问题）
			 * 所以在这里处理下
			 */
			if(null==payData.getRBankCenticode() || "".equals(payData.getRBankCenticode())
				||null==payData.getCentiType() || "".equals(payData.getCentiType())	){
				payData.setCentiType("99");
				payData.setRBankCenticode("0");
				payData.setCentiCode("0");
			}
			
			payData.setPaydate(rs.getDate(7));
			payData.setPayDate(new DateTime(rs.getDate(7)));
			if("".equals(payData.getPaydate()) || payData.getPaydate()==null){
				payData.setPaydate(rs.getDate(8));
			}
			if("".equals(payData.getPayDate()) || payData.getPayDate()==null){
				payData.setPayDate(new DateTime(rs.getDate(8)));
			}
			payData.setClaimAmount(rs.getDouble(6));
			payDataList1.add(payData);
		}
		if(rs!=null){
			rs.close();
		}
		
		/**
		 * 增加负数赔案支付信息（预赔没有负数所以在这里不查询P50）
		 * 1、根据立案号取实收实付表取负数信息，
		 * 2、取得负数的理算书号查询是否录入了负数的支付信息
		 * 3、根据负数的支付编号查询是否是正负合并录入
		 */
		BLPrpJpayRefRec blPrpJpayRefRec = new BLPrpJpayRefRec();
		String strRefRec =  " claimno='"+claimNo+"' AND payreffee<0  and payrefreason in ( 'P60', 'P97', 'Z03','P63') and substr(payrefstate,1,1)='1' and payrefdate is not null "
		+" and exists (select 1 from prplcompensate  where prplcompensate.compensateno=prpjpayrefrec.certino and prplcompensate.claimno=prpjpayrefrec.claimno and prplcompensate.sumpaid<0) ";
		blPrpJpayRefRec.query(strRefRec);
		//遍历负数信息
		for(int i =0;i<blPrpJpayRefRec.getSize();i++){
			PrpJpayRefRecSchema prpJpayRefRecSchema = blPrpJpayRefRec.getArr(i);
			//通过理算书和立案号查询正负合并信息
			BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
			String strPaymain=" paymentno in ( select serialno from prplpay where claimno='"+prpJpayRefRecSchema.getClaimNo()+"' and compensateno='"+prpJpayRefRecSchema.getCertiNo()+"'  and paymenttype='"+prpJpayRefRecSchema.getPayRefReason()+"' ) and payamount=0 ";
			Collection collection = blPrpLpaymainFacade.findByConditions(strPaymain);
			if(collection!=null && collection.size()>0){
				blPrpJpayRefRec.remove(i);
				i--;
			}
		}
		/**
		 * 剔除正负合并后如果存在正数支付信息则拷贝正数的收款人名称、证件类型、证件号码
		 * 若没有正数支付信息则写死
		 */
		for(int i =0;i<blPrpJpayRefRec.getSize();i++){
			PrpJpayRefRecSchema prpJpayRefRecSchema = blPrpJpayRefRec.getArr(i);
			if(payDataList1.size()>0){
				Paydata payDataPlus=payDataList1.get(0);
				payData = new Paydata();
				payData.setRBankAcountName(payDataPlus.getRBankAcountName());
				payData.setCentiType(payDataPlus.getCentiType());
				//因为上传平台时有的传了CentiCode，有的传了RBankCenticode所以在这里对两个字段赋统一值
				payData.setRBankCenticode(payDataPlus.getRBankCenticode());
				payData.setCentiCode(payDataPlus.getRBankCenticode());
				payData.setClaimAmount(Double.parseDouble(prpJpayRefRecSchema.getPayRefFee()));
				/**
				 * 赔付登记待修改
				 * PayDate存在两个，两个都保存
				 */
				if(prpJpayRefRecSchema.getPayRefDatetime()==null || "".equals(prpJpayRefRecSchema.getPayRefDatetime()) || prpJpayRefRecSchema.getPayRefDatetime().length()<19){
					payData.setPaydate(new SimpleDateFormat("yyyy-MM-dd").parse(prpJpayRefRecSchema.getPayRefDate()));
					payData.setPayDate(new DateTime(new SimpleDateFormat("yyyy-MM-dd").parse(prpJpayRefRecSchema.getPayRefDate())));
				}else{
					payData.setPaydate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(prpJpayRefRecSchema.getPayRefDatetime()));
					payData.setPayDate(new DateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(prpJpayRefRecSchema.getPayRefDatetime())));
				}
				
				payDataList1.add(payData);
				
			}else{
				payData = new Paydata();
				payData.setRBankAcountName(prpJpayRefRecSchema.getInsuredName());
				payData.setCentiType("99");
				payData.setRBankCenticode("0");
				payData.setCentiCode("0");
				payData.setClaimAmount(Double.parseDouble(prpJpayRefRecSchema.getPayRefFee()));
				if(prpJpayRefRecSchema.getPayRefDatetime()==null || "".equals(prpJpayRefRecSchema.getPayRefDatetime()) || prpJpayRefRecSchema.getPayRefDatetime().length()<19){
					payData.setPaydate(new SimpleDateFormat("yyyy-MM-dd").parse(prpJpayRefRecSchema.getPayRefDate()));
					payData.setPayDate(new DateTime(new SimpleDateFormat("yyyy-MM-dd").parse(prpJpayRefRecSchema.getPayRefDate())));
				}else{
					payData.setPaydate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(prpJpayRefRecSchema.getPayRefDatetime()));
					payData.setPayDate(new DateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(prpJpayRefRecSchema.getPayRefDatetime())));
				}
				payDataList1.add(payData);
			}
			
		}
		
		String policyNo = "";
		String registNo = "";
 		PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(claimNo);
 		registNo = prpLclaimDto.getRegistNo();
		policyNo = prpLclaimDto.getPolicyNo();
		
		payinfor.setClaimNo(claimNo);
		payinfor.setRegistNo(registNo);
		payinfor.setPolicyNo(policyNo);
		payinfor.setSumPaid(payAmount);
		payinfor.setBankName(bankName);
		payinfor.setAccountName(accountName);
		payinfor.setSerialNo(serialNo);
		payinfor.setPreCompensateNos(preCompensateNos);
		payinfor.setCompensateNos(compensateNos);
		payinfor.setPayDate(payDataList1);

		return payinfor;
	}
	/**
	 * 案件注销2011
	 */
	protected CancelCase getCancelCaseZJ(DBManager dbManager, String businessNo,String policyNo)
	throws SQLException, Exception {
		CancelCase cancelCase = new CancelCase();
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, businessNo);
		double DirectClaimAmount=0.0;
		if(prpLclaimDto==null)//没有立案数据，为报案注销
		{
			PrpLregistDto prpLregistDto=new BLPrpLregistAction().findByPrimaryKey(
					dbManager, businessNo);
	        String Rconditions = "registNo='"+prpLregistDto.getRegistNo()+"'";
	        ArrayList<PrpLRegistRPolicyDto> prpLRegistRPolicyList = (ArrayList<PrpLRegistRPolicyDto>) new BLPrpLRegistRPolicyFacade().findByConditions(Rconditions);
	        for(PrpLRegistRPolicyDto prpLRegistRPolicyDto : prpLRegistRPolicyList){
	            if("1".equals(prpLRegistRPolicyDto.getPolicyType()) && "1".equals(prpLRegistRPolicyDto.getValidStatus())){
	            	cancelCase.setPolicyNO(prpLRegistRPolicyDto.getPolicyNo());
	            }
	        }
			cancelCase.setClaimNo("");
			cancelCase.setRegistNo(prpLregistDto.getRegistNo());
			cancelCase.setComCode(prpLregistDto.getComCode());
			cancelCase.setPolicyNO(policyNo);
			//2011
			if("".equals(prpLregistDto.getLogoutType())){
				prpLregistDto.setLogoutType("99");
			}
			//Date date=new SimpleDateFormat("yyyy-MM-dd hh:MM").parse(prpLregistDto.getCancelDate().toString());

			
			String conditions="";
		    ArrayList swflogList=null;
			//Date date=new SimpleDateFormat("yyyy-MM-dd hh:MM").parse(prpLclaimDto.getCancelDate().toString());
			//String cancelDate=new SimpleDateFormat("YYYYMMDDHHMM").format(prpLclaimDto.getCancelDate());
			Date cancelDate=null;
		    BLSwfLogStoreAction swfLogStoreAction=new BLSwfLogStoreAction();
			conditions=" businessNo='"+businessNo+"' and nodetype='rcanc'";
			swflogList=(ArrayList)swfLogStoreAction.findByConditions(dbManager, conditions);
			if(swflogList!=null&&swflogList.size()>0){
				SwfLogDto swfLogStoreDto=new SwfLogDto();
				swfLogStoreDto=(SwfLogDto)swflogList.get(0);
				cancelDate=new DateTime(swfLogStoreDto.getFlowInTime().toString(),DateTime.YEAR_TO_MINUTE);
			}else{					
				BLSwfLogAction swfLogAction=new BLSwfLogAction();
				conditions=" businessNo='"+businessNo+"' and nodetype='rcanc'";
				swflogList=(ArrayList)swfLogAction.findByConditions(dbManager, conditions);
				if(swflogList!=null&&swflogList.size()>0){
					SwfLogDto swfLogDto=new SwfLogDto();
					swfLogDto=(SwfLogDto)swflogList.get(0);
					cancelDate=new DateTime(swfLogDto.getFlowInTime().toString(),DateTime.YEAR_TO_MINUTE);
				}
			}
			if(cancelDate==null||"".equals(cancelDate)){
			    cancelDate=new DateTime(prpLregistDto.getCancelDate(),DateTime.YEAR_TO_MINUTE);
			}
			Collection prpLregistTextList = new BLPrpLregistTextAction()
			.findByConditions(dbManager, "texttype='2' and registno='" + cancelCase.getRegistNo() + "'");
		    StringBuffer context = new StringBuffer();
		    if( prpLregistTextList != null )
		    {
			   Iterator iterator = prpLregistTextList.iterator();
			   while(iterator.hasNext()){
				  PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto)iterator.next();
				  if( "2".equals(prpLregistTextDto.getTextType()) ){
					context.append("  ");
					context.append(prpLregistTextDto.getContext());
					context.append("\t");
				
				  }
			   }
		    }
		    cancelCase.setCancelDesc(context.toString());
			cancelCase.setCancelDate(cancelDate);
			cancelCase.setCancelCause("21");
			cancelCase.setCancelType("1");
			cancelCase.setDirectClaimAmount("0");
		}else//立案注销
		{
			cancelCase.setClaimNo(prpLclaimDto.getClaimNo());
			cancelCase.setRegistNo(prpLclaimDto.getRegistNo());
			cancelCase.setPolicyNO(prpLclaimDto.getPolicyNo());
			cancelCase.setComCode(prpLclaimDto.getComCode());
			String conditions="";
		    Collection swflogList=null;
		    BLPrpLpreChargeFacade blPrpLpreChargeFacade=new BLPrpLpreChargeFacade();
		    PrpLpreChargeDto prpLpreChargeDto=null; 
		    ArrayList list=(ArrayList)blPrpLpreChargeFacade.findByConditions(" claimno='"+prpLclaimDto.getClaimNo()+"'");
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					DirectClaimAmount+=((PrpLpreChargeDto)list.get(i)).getSumPrepaid();
				}
			}else{
				DirectClaimAmount=0.0;
			}
		    //Date date=new SimpleDateFormat("yyyy-MM-dd hh:MM").parse(prpLclaimDto.getCancelDate().toString());
			//String cancelDate=new SimpleDateFormat("YYYYMMDDHHMM").format(prpLclaimDto.getCancelDate());
			Date cancelDate=null;
		    BLSwfLogStoreAction swfLogStoreAction=new BLSwfLogStoreAction();
			conditions=" businessNo='"+businessNo+"' and nodetype='cance'";
			swflogList=swfLogStoreAction.findByConditions(dbManager, conditions);
			if(swflogList!=null&&swflogList.size()>0){
				SwfLogDto swfLogStoreDto=new SwfLogDto();
				swfLogStoreDto=(SwfLogDto)swflogList.iterator().next();
				cancelDate=new DateTime(swfLogStoreDto.getFlowInTime().toString(),DateTime.YEAR_TO_MINUTE);
			}else{					
				BLSwfLogAction swfLogAction=new BLSwfLogAction();
				conditions=" businessNo='"+businessNo+"' and nodetype='cance'";
				swflogList=swfLogAction.findByConditions(dbManager, conditions);
				if(swflogList!=null&&swflogList.size()>0){
					SwfLogDto swfLogDto=new SwfLogDto();
					swfLogDto=(SwfLogDto)swflogList.iterator().next();
					cancelDate=new DateTime(swfLogDto.getFlowInTime().toString(),DateTime.YEAR_TO_MINUTE);
				}
			}
			if(cancelDate==null||"".equals(cancelDate)){
			    cancelDate=new DateTime(prpLclaimDto.getCancelDate(),DateTime.YEAR_TO_MINUTE);
			}
			cancelCase.setCancelDate(cancelDate);
			/*String conditions=" claimno='"+prpLclaimDto.getClaimNo()+"' ";
			Collection coll=new BLPrpLRegistRPolicyAction().findByConditions(dbManager, conditions);
			prpLRegistRPolicyDto=(PrpLRegistRPolicyDto)coll.iterator().next();
			cancelCase.setCancelCause(prpLRegistRPolicyDto.getCancelReason());*/
			//new 2011
			Collection prpLregistTextList = new BLPrpLltextAction()
			.findByConditions(dbManager, "texttype='10' and claimno='"
					+ cancelCase.getClaimNo() + "'");
	        StringBuffer context = new StringBuffer();
	        if (prpLregistTextList != null) {
		    Iterator iterator = prpLregistTextList.iterator();
		       while (iterator.hasNext()) {
			   PrpLltextDto PrpLltextDto = (PrpLltextDto) iterator
					.next();
				context.append("  ");
				context.append(PrpLltextDto.getContext());
				context.append("\t");
		       }
	        }
	        cancelCase.setCancelDesc(context.toString());
			cancelCase.setCancelCause("21");
			cancelCase.setCancelType("2");
			cancelCase.setDirectClaimAmount(Double.toString(DirectClaimAmount));
		}
		return cancelCase;
	}
	
	/**
	 * 获得强制保险平台需要的案后重开对象
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected  ReCase getReCase(DBManager dbManager, String claimNo)throws SQLException, Exception{
		
		ReCase reCase = new ReCase();
		
		//1.取立案信息
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, claimNo);
		String policyNo = prpLclaimDto.getPolicyNo();
	    UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
	    String conditions="claimNo ='"+claimNo+"'";
	    int maxSerialNo=0;
	    if(uiRecaseAction.findByConditions(conditions)!=null){
	       maxSerialNo =  uiRecaseAction.getMaxSerialNo(claimNo);
	    }
	    ReCaseDto   recaseDto =  new ReCaseDto();
	    recaseDto=(ReCaseDto)uiRecaseAction.findByPrimaryKey(claimNo, maxSerialNo);
		//5.设置值
	    // modify by chu 20131013
	    //reCase.setReOpenCause(recaseDto.getPrpLrecaseDto().getReCaseReason());
	    //prpLrecaseDto = reCaseDto.getPrpLrecaseDto();
	    String recaseReason = "";
		if(recaseDto.getPrpLrecaseList()!=null&&!recaseDto.getPrpLrecaseList().isEmpty())recaseReason =recaseDto.getPrpLrecaseList().get(0).getReCaseReason();
		reCase.setReOpenCause(recaseReason);
//		String reOpenHour=new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_MINUTE).toString().substring(11, 16);
//		String reOpenDate=formatDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY),(reOpenHour.split(":")[0]), 
//				(reOpenHour.split(":")[1]));
		Date reOpenDate=new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_MINUTE);
		reCase.setReOpenDate(reOpenDate);
		reCase.setClaimNo(claimNo);
		reCase.setPolicyNo(policyNo);
		reCase.setRegistNo(prpLclaimDto.getRegistNo());
		return reCase;
	}
	/**
	 * 获得强制保险平台需要的案后重开对象(buchuan)
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected  ReCase getReCase(DBManager dbManager, String claimNo,int serlalNo)throws SQLException, Exception{
		
		ReCase reCase = new ReCase();
		
		//1.取立案信息
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, claimNo);
		String policyNo = prpLclaimDto.getPolicyNo();
	    UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
	    ReCaseDto   recaseDto =  new ReCaseDto();
	    recaseDto=(ReCaseDto)uiRecaseAction.findByPrimaryKey(claimNo, serlalNo);
		//5.设置值
	    // modify by chu 20131013
	    //reCase.setReOpenCause(recaseDto.getPrpLrecaseDto().getReCaseReason());
	    //prpLrecaseDto = reCaseDto.getPrpLrecaseDto();
	    String recaseReason = "";
	    DateTime time = new DateTime();
		if(recaseDto.getPrpLrecaseList()!=null&&!recaseDto.getPrpLrecaseList().isEmpty()){
			recaseReason =recaseDto.getPrpLrecaseList().get(0).getReCaseReason();
			time = recaseDto.getPrpLrecaseList().get(0).getOpenCaseDate();
		}
		reCase.setReOpenCause(recaseReason);
	    //reCase.setReOpenCause(recaseDto.getPrpLrecaseList().get(0).getReCaseReason());
//		String reOpenHour=new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_MINUTE).toString().substring(11, 16);
//		String reOpenDate=formatDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY),(reOpenHour.split(":")[0]), 
//				(reOpenHour.split(":")[1]));
		Date reOpenDate=new DateTime(time,DateTime.YEAR_TO_MINUTE);
		reCase.setReOpenDate(reOpenDate);
		reCase.setClaimNo(claimNo);
		reCase.setPolicyNo(policyNo);
		reCase.setRegistNo(prpLclaimDto.getRegistNo());
		return reCase;
	}
	/**
	 * 开始追偿确认
	 */
	protected RecoveryConfirm getRecoveryConfirm(DBManager dbManager, String recoveryCode)
	throws SQLException, Exception {
		RecoveryConfirm recoveryConfirm = new RecoveryConfirm();
		recoveryConfirm.setRecoveryCode(recoveryCode);
		return recoveryConfirm;
	}
	

	/**
	 * 获取三者车信息
	 */
	private List getThirdCarList(DBManager dbManager, String registNo)
			throws SQLException, Exception {
		List thirdCarList = new ArrayList();
		Collection thirdCarCollection = new BLPrpLthirdPartyAction()
				.findByConditions(dbManager, " registno='" + registNo
						+ "' and serialno<>'1'");
		for (Iterator iter = thirdCarCollection.iterator(); iter.hasNext();) {
			PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto) iter
					.next();
			thirdCarList.add(new ThirdCar(prpLthirdPartyDto.getLicenseNo()));
		}
		return thirdCarList;
	}


	/**
	 * 根据报案号获得保单号
	 */
	private String getPolicyNo(DBManager dbManager, String registNo, String registType)
			throws SQLException, Exception {
		String policyNo = "";
		/*String policyTye = "";
		if(Iconstants.RequstType.REGIST.equals(registType)
				||Iconstants.RequstType.CLAIM.equals(registType)
				||Iconstants.RequstType.COMPENSATE.equals(registType)
				||Iconstants.RequstType.ENDCASE.equals(registType)
				||Iconstants.RequstType.CANCEL_REGIST_CASE.equals(registType)){
			policyTye = "3";
		}else if(Iconstants.RequstType.REGIST_SYX.equals(registType)
				||Iconstants.RequstType.CLAIM_SYX.equals(registType)
				||Iconstants.RequstType.COMPENSATE_SYX.equals(registType)
				||Iconstants.RequstType.ENDCASE_SYX.equals(registType)
				||Iconstants.RequstType.CANCEL_REGISTSYX_CASE.equals(registType)
				||Iconstants.ZJRequstType.REGIST_SYX.equals(registType)
				||Iconstants.ZJRequstType.CLAIM_SYX.equals(registType)
				||Iconstants.ZJRequstType.COMPENSATE_SYX.equals(registType)
				||Iconstants.ZJRequstType.ENDCASE_SYX.equals(registType)
				||Iconstants.ZJRequstType.CANCEL_CASE.equals(registType)){
			policyTye = "1";
		}*/
		List prpLregistRPolicyList = new ArrayList();
		BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
		
		prpLregistRPolicyList = (ArrayList) blPrpLRegistRPolicyAction
				.findByConditions(dbManager, " registno='" + registNo+ "' and policytype='1' and validstatus='1' ");//新加
						//+ "' and policytype='"+policyTye+"'");
						
		if (prpLregistRPolicyList != null && prpLregistRPolicyList.size() > 0) {
			policyNo = ((PrpLRegistRPolicyDto) prpLregistRPolicyList.get(0))
					.getPolicyNo();
		}
		return policyNo;
	}

	private String getPrpLltext(DBManager dbManager,String claimNo,String textType) throws Exception
	{
		String desc = "";
		String conditions = " claimno='" + claimNo + "' and texttype='"+textType+"' order by lineno";
		List prpLltextList = (ArrayList) new BLPrpLltextAction().findByConditions(dbManager, conditions);
		for (Iterator iter = prpLltextList.iterator(); iter.hasNext();) {
			PrpLltextDto prpLltextDto = (PrpLltextDto) iter.next();
			desc += prpLltextDto.getContext();
		}
		if(desc.length()>500){
			desc = desc.substring(0,499);
	    }
		return  desc ;
	}
	 private String getprplregisttext(DBManager dbManager,String registNo) throws Exception
	  {
		  StringBuffer str   = new StringBuffer();
	      String DamageContextTemp = "";
	      String DamageContext = "";
		  BLPrpLregistTextAction blPrpLregistTextAction  = new BLPrpLregistTextAction();
	      String conditions = "  registno='"+registNo+"' and textType='1'   Order By texttype,lineno " ;
	      Collection col = new ArrayList();
	      col = blPrpLregistTextAction.findByConditions(dbManager,conditions);
	      Iterator it  = col.iterator();
	      PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
	      while(it.hasNext())
	      {
	    	  prpLregistTextDto = (PrpLregistTextDto)it.next();
	    	  str.append(prpLregistTextDto.getContext());
	      }
	      DamageContextTemp = str.toString();
	      if(DamageContextTemp.length()==0)
	      {
	    	  DamageContext = "无描述";
	    	  
	      }
	      else if(DamageContextTemp.length()>500)
	      {
	    	  DamageContext = DamageContextTemp.substring(0,499);
	      }
	      else
	      {
	    	  DamageContext = DamageContextTemp;
	      }
	      System.out.println("【出险经过】----------"+DamageContext);
	      return  DamageContext;
	  }
  private String getDamageContext(DBManager dbManager,String registNo) throws Exception
  {
	  StringBuffer str   = new StringBuffer();
      String DamageContextTemp = "";
      String DamageContext = "";
	  BLPrpLregistTextAction blPrpLregistTextAction  = new BLPrpLregistTextAction();
      String conditions = "  registno='"+registNo+"'   Order By texttype,lineno " ;
      Collection col = new ArrayList();
      col = blPrpLregistTextAction.findByConditions(dbManager,conditions);
      Iterator it  = col.iterator();
      PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
      while(it.hasNext())
      {
    	  prpLregistTextDto = (PrpLregistTextDto)it.next();
    	  str.append(prpLregistTextDto.getContext());
      }
      DamageContextTemp = str.toString();
      if(DamageContextTemp.length()==0)
      {
    	  DamageContext = "无描述";
    	  
      }
      else if(DamageContextTemp.length()>500)
      {
    	  DamageContext = DamageContextTemp.substring(0,499);
      }
      else
      {
    	  DamageContext = DamageContextTemp;
      }
      System.out.println("【出险经过】----------"+DamageContext);
      return  DamageContext;
  }
/*  public String StringToDate(String strDate) {
	  String  date = "";
	  if(!("").equals(strDate)){
		  String[] arrDate =  strDate.split(" ");
		  String[] arrDate1 =  arrDate[0].trim().split("-");
	      for(int i=0;i<arrDate1.length;i++){
	    	  date = date + arrDate1[i];
	      }
	      String[] arrDate2 =  arrDate[1].trim().split(":");
	      for(int i=0;i<arrDate2.length;i++){
	    	  date = date + arrDate2[i];
	      }
	  }   
      
      return date; 
  }*/
	/**
	 * 将DateTime类型的日期转换成yyyyMMddHHmm格式的字符串
	 * @author sinosoft_guoyuan
	 * @param Date
	 * @return String 格式化后的日期
	 */
	public String formatDate(DateTime iDate,String iHour,String iMinutes) throws Exception{
		String strDate  = "";
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyyMMdd HH:mm");
		
		Date date = new Date();
		date.setTime(iDate.getTime());
		
		strDate = dateFormat2.format(dateFormat3.parse(dateFormat1.format(date) + " " + iHour + ":" + iMinutes));
		
		return strDate;
	}
}
