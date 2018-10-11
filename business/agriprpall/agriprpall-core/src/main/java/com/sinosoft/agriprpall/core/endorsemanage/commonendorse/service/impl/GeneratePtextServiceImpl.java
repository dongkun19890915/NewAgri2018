package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.PrpPmainApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpXpColDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpXpCol;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePtextService;
import com.sinosoft.agriprpall.core.endorsemanage.util.PubTools;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainAgri;
import com.sinosoft.agriprpall.core.proposalmanage.service.impl.LeviedFeeServiceImpl;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.kernel.PrpDagentApi;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDagentDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDitemApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDitemDto;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Math.abs;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-24 12:54:07.447
 * @description 批文生成Core接口实现
 */
@Service
public class GeneratePtextServiceImpl extends BaseServiceImpl implements GeneratePtextService {

    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LeviedFeeServiceImpl.class);


    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDagentApi prpDagentApi;
	@Autowired
	private PrpDcodeApi prpDcodeApi;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDriskApi prpdriskApi;
    @Autowired
    private PrpDitemApi prpDitemApi;
    @Autowired
    private PrpXpColDao prpXpColDao;

    /**
     * 批文生成
     *
     * @param policyEndorseDto
     * @return BLEndorseDto
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/16 下午 15:30
     */

    // 农险批文生成 blsvr/pg/BLPrpPtextUsual.java
    public BLEndorseDto generateUsual(PolicyEndorseDto policyEndorseDto) throws Exception {
        ResponseQueryPolicyInfoDto blPolicyDtoNew = policyEndorseDto.getBlPolicyInfoDtoNew();
        BLEndorseDto blEndorseDto = policyEndorseDto.getBlEndorseDto();
        ResponseQueryPolicyInfoDto blPolicyDtoOld=policyEndorseDto.getBlPolicyInfoDtoOld();
        List<PrpPtextDto> prpPtextDtoList = new ArrayList<PrpPtextDto>();
        blEndorseDto.setPrpPtextDtoList(prpPtextDtoList);
        int intLineNo = 0;
        String strEndorType = blEndorseDto.getPrpPheadDto().getEndorType();
        // 生成批文头信息
        intLineNo = generateHead(blEndorseDto, intLineNo);

        //生成批文
//        if (strEndorType.indexOf("11") > -1) {// 调整费率 11
//            intLineNo = ptextForRate(blPolicyDtoNew, blEndorseDto, intLineNo,blPolicyDtoOld);
//        }
//        if (strEndorType.indexOf("91") > -1) {// 调整单位保额 91
//            intLineNo = ptextForUnionAmount(blPolicyDtoNew, blEndorseDto, intLineNo);
//        }
        if (strEndorType.indexOf("01") > -1) {// 变更保险期限 01
            intLineNo = ptextForPeriod(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("03") > -1) {// 保单遗失 03
            intLineNo = ptextForLoseCert(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("15") > -1) {// 变更主保单信息 15
            intLineNo = this.ptextForMain(blPolicyDtoNew, blEndorseDto, intLineNo,blPolicyDtoOld);
        }
        if (strEndorType.indexOf("05") > -1||"11".equals(strEndorType)||"91".equals(strEndorType)||"07".equals(strEndorType)) {// 变更标的 05
            intLineNo = ptextForUsualItemKind(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("07") > -1) {// 变更地址信息 07
            intLineNo = ptextForAddress(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("08") > -1) {// 变更保单附表 08
            intLineNo = this.ptextForMainAddition(blPolicyDtoNew, blEndorseDto,
                    intLineNo, "08");
        }
        if (strEndorType.indexOf("17") > -1) {// 变更特别约定 17
            intLineNo = this.ptextForEngage(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("19") > -1) {// 保单注销 19
            intLineNo = this.ptextForAnnul(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("21") > -1) {// 全单退保 21
            intLineNo = this.ptextForUsualBack(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("22") > -1) {// 变更茬次信息（prpcitemkindagri表）信息 22
            intLineNo = this.ptextForItemKindAgri(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("71") > -1 && strEndorType.indexOf("05") < 0) {// 政府补贴批文信息 71
            intLineNo = this.ptextForUsualSubsidy(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("78") > -1) {// 变更共保信息 78
            intLineNo = this.ptextForCoins(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("85") > -1) {// 变更业务员信息85
            intLineNo = ptextForHandler(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("25") > -1) {// 变更缴费计划信息
            intLineNo = ptextForPlan(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("04") > -1 || strEndorType.indexOf("60") > -1) {// 变更投被保人信息
            intLineNo = ptextForCustomer(blPolicyDtoNew, blEndorseDto, intLineNo);
        }
        if (strEndorType.indexOf("61") > -1 ) {// 变更发票购货方信息
            intLineNo = ptextForCustomerTaxPayInfo(blEndorseDto,blPolicyDtoNew, policyEndorseDto.getBlPolicyInfoDtoOld(), intLineNo);
        }
        // 非保单注销特殊处理 410行
        String strCurrency1 = "";
        String strPtext = "";
        double dblSumChgPremium = 0;
        String strType = "";
        if(blEndorseDto.getPrpPfeeDtoList()!=null){
            for (int i = 0; i < blEndorseDto.getPrpPfeeDtoList().size(); i++) {
                if (strCurrency1.length() == 0) {
                    strCurrency1 = blPolicyDtoNew.getPrpCfeeDtoList().get(0).getCurrency1();
                }
                dblSumChgPremium += Double.parseDouble(chgStrZero(blEndorseDto.getPrpPfeeDtoList().get(i).getChgPremium1() + ""));
            }}
        if (dblSumChgPremium != 0 && strEndorType.indexOf("19") == -1) {
            /* 本次批改合计 */
            if (dblSumChgPremium > 0) {
                strType = "加收";
            } else {
                strType = "退还";
                dblSumChgPremium = dblSumChgPremium * (-1);
            }
            if (dblSumChgPremium != 0) {
                PrpPtextDto prpPtextschema = new PrpPtextDto();
                prpPtextschema.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                prpPtextschema.setPolicyNo(blEndorseDto.getPrpPheadDto().getPolicyNo());
                strPtext = "    本次批改合计" + strType + "保费" + strCurrency1
                        + round(dblSumChgPremium, 2)
                        + "元整。" + " ";
                intLineNo = intLineNo + 1;
                prpPtextschema.setLineNo(intLineNo);
                prpPtextschema.setEndorseText(strPtext);
                prpPtextschema.setFlag("");
                blEndorseDto.getPrpPtextDtoList().add(prpPtextschema);
            }
        }
        // 生成批文尾信息 452行
        if (!(strEndorType.equals("19") || strEndorType.equals("21"))) {
            generateTail(blEndorseDto, intLineNo);
        }
        return blEndorseDto;
    }
    /**发票购货方批文信息
     * @param blPolicyDtoNew
     * @param blEndorseDto
     * @param intLineNo
     * @return
     * @throws Exception 
     * @throws UserException 
     */
	private int ptextForCustomerTaxPayInfo(BLEndorseDto blEndorseDto,ResponseQueryPolicyInfoDto blPolicyDtoNew,
			ResponseQueryPolicyInfoDto blPolicyInfoDtoOld, int intLineNo) throws  Exception {
		String strPtext = "";
		PrpCmainDto prpCmainDto = blPolicyDtoNew.getPrpCmainDto();
		PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDtoNew = blPolicyDtoNew.getPrpDcustomerTaxPayInfoDto();
		PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDtoOld = blPolicyInfoDtoOld.getPrpDcustomerTaxPayInfoDto();
		if(prpDcustomerTaxPayInfoDtoOld == null){
			strPtext ="<<添加发票购货方信息>>";
			intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			if(StringUtils.isNotBlank(prpDcustomerTaxPayInfoDtoNew.getCustomerCode()) && prpDcustomerTaxPayInfoDtoNew.getCustomerCode().equals(prpCmainDto.getInsuredCode())){
				strPtext ="开票对象：被保人";
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}if(StringUtils.isNotBlank(prpDcustomerTaxPayInfoDtoNew.getCustomerCode()) && prpDcustomerTaxPayInfoDtoNew.getCustomerCode().equals(prpCmainDto.getAppliCode())){
				strPtext ="开票对象：投保人";
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(StringUtils.isNotEmpty(prpDcustomerTaxPayInfoDtoNew.getCustomerName())){
				strPtext ="发票抬头："+prpDcustomerTaxPayInfoDtoNew.getCustomerName();
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(StringUtils.isNotEmpty(prpDcustomerTaxPayInfoDtoNew.getTaxpayerType())){
				strPtext ="发票类型："+prpDcustomerTaxPayInfoDtoNew.getTaxpayerType();
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(StringUtils.isNotEmpty(prpDcustomerTaxPayInfoDtoNew.getTaxpayerNo())){
				strPtext ="税务登记证号："+prpDcustomerTaxPayInfoDtoNew.getTaxpayerNo();
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(StringUtils.isNotEmpty(prpDcustomerTaxPayInfoDtoNew.getCustomerType())){
				strPtext ="纳税人身份："+prpDcustomerTaxPayInfoDtoNew.getCustomerType();
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(StringUtils.isNotEmpty(prpDcustomerTaxPayInfoDtoNew.getAddress())){
				strPtext ="购方地址："+prpDcustomerTaxPayInfoDtoNew.getAddress();
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(StringUtils.isNotEmpty(prpDcustomerTaxPayInfoDtoNew.getPostPhone())){
				strPtext ="购方电话："+prpDcustomerTaxPayInfoDtoNew.getPostPhone();
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(StringUtils.isNotEmpty(prpDcustomerTaxPayInfoDtoNew.getAccountBank())){
				strPtext ="购方开户行："+prpDcustomerTaxPayInfoDtoNew.getAccountBank();
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
		}else{
			strPtext ="<<修改发票购货方信息>>";
			intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			if(!prpDcustomerTaxPayInfoDtoOld.getCustomerCode().equals(prpDcustomerTaxPayInfoDtoNew.getCustomerCode()) && StringUtils.isNotBlank(prpDcustomerTaxPayInfoDtoNew.getCustomerCode()) && prpDcustomerTaxPayInfoDtoNew.getCustomerCode().equals(prpCmainDto.getInsuredCode())){
				strPtext ="开票对象：由被保人修改为投保人";
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}if(!prpDcustomerTaxPayInfoDtoOld.getCustomerCode().equals(prpDcustomerTaxPayInfoDtoNew.getCustomerCode()) && StringUtils.isNotBlank(prpDcustomerTaxPayInfoDtoNew.getCustomerCode()) && prpDcustomerTaxPayInfoDtoNew.getCustomerCode().equals(prpCmainDto.getAppliCode())){
				strPtext ="开票对象：由投保人修改为被保人";
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(!(prpDcustomerTaxPayInfoDtoOld.getCustomerName()+"").equals(prpDcustomerTaxPayInfoDtoNew.getCustomerName()+"")){
				strPtext ="发票抬头：";
				if(prpDcustomerTaxPayInfoDtoOld.getCustomerName()!=null){
					strPtext+="由"+prpDcustomerTaxPayInfoDtoOld.getCustomerName();
				}
				strPtext +="修改为"+prpDcustomerTaxPayInfoDtoNew.getCustomerName();
			
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(!(prpDcustomerTaxPayInfoDtoOld.getTaxpayerType()+"").equals(prpDcustomerTaxPayInfoDtoNew.getTaxpayerType()+"")){
				strPtext ="发票类型：";
				if(prpDcustomerTaxPayInfoDtoOld.getTaxpayerType()!=null){
					strPtext+="由"+prpDcustomerTaxPayInfoDtoOld.getTaxpayerType();
				}
				strPtext +="修改为"+prpDcustomerTaxPayInfoDtoNew.getTaxpayerType();
//				strPtext ="发票类型：由"+prpDcustomerTaxPayInfoDtoOld.getTaxpayerType() +"修改为"+prpDcustomerTaxPayInfoDtoNew.getTaxpayerType();
				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(!(prpDcustomerTaxPayInfoDtoOld.getTaxpayerNo()+"").equals(prpDcustomerTaxPayInfoDtoNew.getTaxpayerNo()+"")){
				strPtext ="税务登记证号：";
				if(prpDcustomerTaxPayInfoDtoOld.getTaxpayerNo()!=null){
					strPtext+="由"+prpDcustomerTaxPayInfoDtoOld.getTaxpayerNo();
				}
				strPtext +="修改为"+prpDcustomerTaxPayInfoDtoNew.getTaxpayerNo();

				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);

//				strPtext ="税务登记证号：由"+prpDcustomerTaxPayInfoDtoOld.getTaxpayerNo()+"修改为"+prpDcustomerTaxPayInfoDtoNew.getTaxpayerNo();
//				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(!(prpDcustomerTaxPayInfoDtoOld.getCustomerType()+"").equals(prpDcustomerTaxPayInfoDtoNew.getCustomerType()+"")){
				strPtext ="纳税人身份：";
				if(prpDcustomerTaxPayInfoDtoOld.getCustomerType()!=null){
					strPtext+="由"+prpDcustomerTaxPayInfoDtoOld.getCustomerType();
				}
				strPtext +="修改为"+prpDcustomerTaxPayInfoDtoNew.getCustomerType();

				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//				strPtext ="纳税人身份：由"+prpDcustomerTaxPayInfoDtoOld.getCustomerType()+"变更为"+prpDcustomerTaxPayInfoDtoNew.getCustomerType();
//				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(!(prpDcustomerTaxPayInfoDtoOld.getAddress()+"").equals(prpDcustomerTaxPayInfoDtoNew.getAddress()+"")){
				strPtext ="购方地址：";
				if(prpDcustomerTaxPayInfoDtoOld.getAddress()!=null){
					strPtext+="由"+prpDcustomerTaxPayInfoDtoOld.getAddress();
				}
				strPtext +="修改为"+prpDcustomerTaxPayInfoDtoNew.getAddress();

				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//				strPtext ="购方地址：由"+prpDcustomerTaxPayInfoDtoOld.getAddress()+"变更为"+prpDcustomerTaxPayInfoDtoNew.getAddress();
//				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(!(prpDcustomerTaxPayInfoDtoOld.getPostPhone()+"").equals(prpDcustomerTaxPayInfoDtoNew.getPostPhone()+"")){
				strPtext ="购方电话：";
				if(prpDcustomerTaxPayInfoDtoOld.getPostPhone()!=null){
					strPtext+="由"+prpDcustomerTaxPayInfoDtoOld.getPostPhone();
				}
				strPtext +="修改为"+prpDcustomerTaxPayInfoDtoNew.getPostPhone();

				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//				strPtext ="购方电话：由"+prpDcustomerTaxPayInfoDtoOld.getPostPhone()+"变更为"+prpDcustomerTaxPayInfoDtoNew.getPostPhone();
//				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
			if(!(prpDcustomerTaxPayInfoDtoOld.getAccountBank()+"").equals(prpDcustomerTaxPayInfoDtoNew.getAccountBank()+"")){
				strPtext ="购方开户行：";
				if(prpDcustomerTaxPayInfoDtoOld.getAccountBank()!=null){
					strPtext+="由"+prpDcustomerTaxPayInfoDtoOld.getAccountBank();
				}
				strPtext +="修改为"+prpDcustomerTaxPayInfoDtoNew.getAccountBank();

				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//				strPtext ="购方开户行：由"+prpDcustomerTaxPayInfoDtoOld.getAccountBank()+"变更为"+prpDcustomerTaxPayInfoDtoNew.getAccountBank();
//				intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
			}
		}
		
        return intLineNo;
	}

	/**生成投被保人批文
     * @param blPolicyDtoNew
     * @param blEndorseDto
     * @param intLineNo
     * @return
     * @throws Exception 
     * @throws UserException 
     */
	/**生成投被保人批文
     * @param blPolicyDtoNew
     * @param blEndorseDto
     * @param intLineNo
     * @return
     * @throws Exception 
     * @throws UserException 
     */
    private int ptextForCustomer(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto, int intLineNo) throws UserException, Exception {
    	String strPtext = "<<变更投被保人>>";
    	intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
    	PrpCmainDto prpCmainDto = blPolicyDtoNew.getPrpCmainDto();
    	List<PrpCinsuredDto> prpCinsuredDtoList = blPolicyDtoNew.getPrpCinsuredDtoList();
    	List<PrpPinsuredDto> prpPinsuredDtoList = blEndorseDto.getPrpPinsuredDtoList();
    	for (PrpPinsuredDto prpPinsuredDto : prpPinsuredDtoList) {
			for (PrpCinsuredDto prpCinsuredDto : prpCinsuredDtoList) {
				if("1".equals(prpCinsuredDto.getInsuredFlag())&&prpCinsuredDto.getInsuredFlag().equals(prpPinsuredDto.getInsuredFlag())&&prpCinsuredDto.getInsuredCode().equals(prpPinsuredDto.getInsuredCode()) && prpPinsuredDto.getInsuredCode().equals(prpCmainDto.getInsuredCode()) && "U".equals(prpCinsuredDto.getFlag())){
						strPtext ="被保人做如下批改:";
						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
						if(!(prpPinsuredDto.getIdentifyNumber()+"").equals(prpCinsuredDto.getIdentifyNumber()+"")){
							strPtext ="证件号：";
							if(prpPinsuredDto.getIdentifyNumber()!=null){
								strPtext+="由"+prpPinsuredDto.getIdentifyNumber();
							}
							strPtext +="修改为"+prpCinsuredDto.getIdentifyNumber();

							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//							strPtext="证件号由"+prpPinsuredDto.getIdentifyNumber()+"变更为"+prpCinsuredDto.getIdentifyNumber();
//							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
						}
						if(!(prpPinsuredDto.getPhoneNumber()+"").equals(prpCinsuredDto.getPhoneNumber()+"")){
							strPtext ="固定电话：";
							if(prpPinsuredDto.getPhoneNumber()!=null){
								strPtext+="由"+prpPinsuredDto.getPhoneNumber();
							}
							strPtext +="修改为"+prpCinsuredDto.getPhoneNumber();

							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//							strPtext="固定电话由"+prpPinsuredDto.getPhoneNumber()+"变更为"+prpCinsuredDto.getPhoneNumber();
//							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
						}
						if(!(prpPinsuredDto.getValidPeriod3()+"").equals(prpCinsuredDto.getValidPeriod3()+"")){
							strPtext ="证件有效期：";
							if(prpPinsuredDto.getValidPeriod3()!=null){
								strPtext+="由"+prpPinsuredDto.getValidPeriod3();
							}
							strPtext +="修改为"+prpCinsuredDto.getValidPeriod3();

							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//							strPtext="证件有效期由"+prpPinsuredDto.getValidPeriod3()+"变更为"+prpCinsuredDto.getValidPeriod3();
//							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
						}
						if(!(prpPinsuredDto.getInsuredAddress()+"").equals(prpCinsuredDto.getInsuredAddress()+"")){
							strPtext ="客户地址：";
							if(prpPinsuredDto.getInsuredAddress()!=null){
								strPtext+="由"+prpPinsuredDto.getInsuredAddress();
							}
							strPtext +="修改为"+prpCinsuredDto.getInsuredAddress();

							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//							strPtext="客户地址由"+prpPinsuredDto.getInsuredAddress()+"变更为"+prpCinsuredDto.getInsuredAddress();
//							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
						}
						if(!(prpPinsuredDto.getMobile()+"").equals(prpCinsuredDto.getMobile()+"")){
							strPtext ="移动电话：";
							if(prpPinsuredDto.getMobile()!=null){
								strPtext+="由"+prpPinsuredDto.getMobile();
							}
							strPtext +="修改为"+prpCinsuredDto.getMobile();

							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//							strPtext="移动电话由"+prpPinsuredDto.getMobile()+"变更为"+prpCinsuredDto.getMobile();
//							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
						}
						if(!(prpPinsuredDto.getAccount()+"").equals(prpCinsuredDto.getAccount()+"")){
							strPtext ="银行账户：";
							if(prpPinsuredDto.getAccount()!=null){
								strPtext+="由"+prpPinsuredDto.getAccount();
							}
							strPtext +="修改为"+prpCinsuredDto.getAccount();

							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//							strPtext="银行账户由"+prpPinsuredDto.getAccount()+"变更为"+prpCinsuredDto.getAccount();
//							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
						}
						if(!(prpPinsuredDto.getBank()+"").equals(prpCinsuredDto.getBank()+"")){
							strPtext ="开户行：";
							if(prpPinsuredDto.getBank()!=null){
								strPtext+="由"+prpPinsuredDto.getBank();
							}
							strPtext +="修改为"+prpCinsuredDto.getBank();

							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//							strPtext="开户行由"+prpPinsuredDto.getBank()+"变更为"+prpCinsuredDto.getBank();
//							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
						}
						if(!(prpPinsuredDto.getEmail()+"").equals(prpCinsuredDto.getEmail()+"")){
							strPtext ="电子邮箱：";
							if(prpPinsuredDto.getBank()!=null){
								strPtext+="由"+prpPinsuredDto.getEmail();
							}
							strPtext +="修改为"+prpCinsuredDto.getEmail();

							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//							strPtext="电子邮箱由"+prpPinsuredDto.getEmail()+"变更为"+prpCinsuredDto.getEmail();
//							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
						}
						if(!(prpPinsuredDto.getPostCode()+"").equals(prpCinsuredDto.getPostCode()+"")){
							strPtext ="邮政编码：";
							if(prpPinsuredDto.getBank()!=null){
								strPtext+="由"+prpPinsuredDto.getPostCode();
							}
							strPtext +="修改为"+prpCinsuredDto.getPostCode();

							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//							strPtext="邮政编码由"+prpPinsuredDto.getPostCode()+"变更为"+prpCinsuredDto.getPostCode();
//							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
						}
						if(!(prpPinsuredDto.getRiskLevel()+"").equals(prpCinsuredDto.getRiskLevel()+"")){
							strPtext ="被保人风险等级：";
							if(prpPinsuredDto.getRiskLevel()!=null){
								String riskLevelName=prpDcodeApi.translateCode("RiskLevel",prpPinsuredDto.getRiskLevel(), LanguageFlagConstant.CHINESE);
								prpPinsuredDto.setRiskLevelName(riskLevelName);
								strPtext+="由"+prpPinsuredDto.getRiskLevelName();
							}
							String riskLevelName1=prpDcodeApi.translateCode("RiskLevel",prpCinsuredDto.getRiskLevel(), LanguageFlagConstant.CHINESE);
							prpCinsuredDto.setRiskLevelName(riskLevelName1);
							strPtext="投保人风险等级由"+prpCinsuredDto.getRiskLevelName()+"变更为"+prpCinsuredDto.getRiskLevelName();
							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
						}
					if(!(prpPinsuredDto.getBusinessSource()+"").equals(prpCinsuredDto.getBusinessSource()+"")){
						strPtext ="被保人行业名称：";
						if(prpPinsuredDto.getBusinessSource()!=null){
							String businessSourceName=prpDcodeApi.translateCode("BusinessSource1",prpPinsuredDto.getBusinessSource(), LanguageFlagConstant.CHINESE);
							prpPinsuredDto.setBusinessSourceName(businessSourceName);
							strPtext+="由"+prpPinsuredDto.getBusinessSourceName();
						}
						String businessSourceName1=prpDcodeApi.translateCode("BusinessSource1",prpCinsuredDto.getBusinessSource(), LanguageFlagConstant.CHINESE);
						prpCinsuredDto.setBusinessSourceName(businessSourceName1);
						strPtext +="修改为"+prpCinsuredDto.getBusinessSourceName();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
//							strPtext="投保人风险等级由"+prpPinsuredDto.getRiskLevel()+"级"+"变更为"+prpCinsuredDto.getRiskLevel()+"级";
//							intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getSex()+"").equals(prpCinsuredDto.getSex()+"")){
						strPtext ="性别：";
						if(prpPinsuredDto.getSex()!=null&&"1".equals(prpPinsuredDto.getSex())){
							strPtext+="由"+"男";
						}else if(prpPinsuredDto.getSex()!=null&&"2".equals(prpPinsuredDto.getSex())){
							strPtext+="由"+"女";
						}
						if(prpCinsuredDto.getSex()!=null&&"1".equals(prpCinsuredDto.getSex())){
							strPtext+="修改为"+"男";
						}else if(prpCinsuredDto.getSex()!=null&&"2".equals(prpCinsuredDto.getSex())){
							strPtext+="修改为"+"女";
						}
						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getCashFocus()+"").equals(prpCinsuredDto.getCashFocus()+"")){
						strPtext ="行业现金密度：";
						if(prpPinsuredDto.getCashFocus()!=null&&"1".equals(prpPinsuredDto.getCashFocus())){
							strPtext+="由"+"是";
						}else if(prpPinsuredDto.getCashFocus()!=null&&"2".equals(prpPinsuredDto.getCashFocus())){
							strPtext+="由"+"否";
						}
						if(prpCinsuredDto.getCashFocus()!=null&&"1".equals(prpCinsuredDto.getCashFocus())){
							strPtext+="修改为"+"是";
						}else if(prpCinsuredDto.getCashFocus()!=null&&"2".equals(prpCinsuredDto.getCashFocus())){
							strPtext+="修改为"+"否";
						}
						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getIsCareClaim()+"").equals(prpCinsuredDto.getIsCareClaim()+"")){
						strPtext ="客户是否关注审计、理赔、退保信息：";
						if(prpPinsuredDto.getIsCareClaim()!=null&&"1".equals(prpPinsuredDto.getIsCareClaim())){
							strPtext+="由"+"是";
						}else if(prpPinsuredDto.getIsCareClaim()!=null&&"2".equals(prpPinsuredDto.getIsCareClaim())){
							strPtext+="由"+"否";
						}
						if(prpCinsuredDto.getIsCareClaim()!=null&&"1".equals(prpCinsuredDto.getIsCareClaim())){
							strPtext+="修改为"+"是";
						}else if(prpCinsuredDto.getIsCareClaim()!=null&&"2".equals(prpCinsuredDto.getIsCareClaim())){
							strPtext+="修改为"+"否";
						}
						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					
				}else if("U".equals(prpCinsuredDto.getFlag())&&"2".equals(prpCinsuredDto.getInsuredFlag()) &&prpCinsuredDto.getInsuredFlag().equals(prpPinsuredDto.getInsuredFlag())&& prpCinsuredDto.getInsuredCode().equals(prpPinsuredDto.getInsuredCode())){
					strPtext="投保人做如下批改:";
					intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					if(!(prpPinsuredDto.getIdentifyNumber()+"").equals(prpCinsuredDto.getIdentifyNumber()+"")){
						strPtext ="证件号：";
						if(prpPinsuredDto.getIdentifyNumber()!=null){
							strPtext+="由"+prpPinsuredDto.getIdentifyNumber();
						}
						strPtext +="修改为"+prpCinsuredDto.getIdentifyNumber();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getPhoneNumber()+"").equals(prpCinsuredDto.getPhoneNumber()+"")){
						strPtext ="固定电话：";
						if(prpPinsuredDto.getPhoneNumber()!=null){
							strPtext+="由"+prpPinsuredDto.getPhoneNumber();
						}
						strPtext +="修改为"+prpCinsuredDto.getPhoneNumber();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getValidPeriod3()+"").equals(prpCinsuredDto.getValidPeriod3()+"")){
						strPtext ="证件有效期：";
						if(prpPinsuredDto.getValidPeriod3()!=null){
							strPtext+="由"+prpPinsuredDto.getValidPeriod3();
						}
						strPtext +="修改为"+prpCinsuredDto.getValidPeriod3();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getInsuredAddress()+"").equals(prpCinsuredDto.getInsuredAddress()+"")){
						strPtext ="客户地址：";
						if(prpPinsuredDto.getInsuredAddress()!=null){
							strPtext+="由"+prpPinsuredDto.getInsuredAddress();
						}
						strPtext +="修改为"+prpCinsuredDto.getInsuredAddress();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getMobile()+"").equals(prpCinsuredDto.getMobile()+"")){
						strPtext ="移动电话：";
						if(prpPinsuredDto.getMobile()!=null){
							strPtext+="由"+prpPinsuredDto.getMobile();
						}
						strPtext +="修改为"+prpCinsuredDto.getMobile();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getAccount()+"").equals(prpCinsuredDto.getAccount()+"")){
						strPtext ="银行账户：";
						if(prpPinsuredDto.getAccount()!=null){
							strPtext+="由"+prpPinsuredDto.getAccount();
						}
						strPtext +="修改为"+prpCinsuredDto.getAccount();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getBank()+"").equals(prpCinsuredDto.getBank()+"")){
						strPtext ="开户行：";
						if(prpPinsuredDto.getBank()!=null){
							strPtext+="由"+prpPinsuredDto.getBank();
						}
						strPtext +="修改为"+prpCinsuredDto.getBank();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getEmail()+"").equals(prpCinsuredDto.getEmail()+"")){
						strPtext ="电子邮箱：";
						if(prpPinsuredDto.getBank()!=null){
							strPtext+="由"+prpPinsuredDto.getEmail();
						}
						strPtext +="修改为"+prpCinsuredDto.getEmail();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getPostCode()+"").equals(prpCinsuredDto.getPostCode()+"")){
						strPtext ="邮政编码：";
						if(prpPinsuredDto.getBank()!=null){
							strPtext+="由"+prpPinsuredDto.getPostCode();
						}
						strPtext +="修改为"+prpCinsuredDto.getPostCode();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getRiskLevel()+"").equals(prpCinsuredDto.getRiskLevel()+"")){
						strPtext ="投保人风险等级：";
						if(prpPinsuredDto.getRiskLevel()!=null){
							String riskLevelName=prpDcodeApi.translateCode("RiskLevel",prpPinsuredDto.getRiskLevel(), LanguageFlagConstant.CHINESE);
							prpPinsuredDto.setRiskLevelName(riskLevelName);
							strPtext+="由"+prpPinsuredDto.getRiskLevelName();
						}
						String riskLevelName1=prpDcodeApi.translateCode("RiskLevel",prpCinsuredDto.getRiskLevel(), LanguageFlagConstant.CHINESE);
						prpCinsuredDto.setRiskLevelName(riskLevelName1);
						strPtext +="修改为"+prpCinsuredDto.getRiskLevelName();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getBusinessSource()+"").equals(prpCinsuredDto.getBusinessSource()+"")){
						strPtext ="投保人行业名称：";
						if(prpPinsuredDto.getBusinessSource()!=null){
							String businessSourceName=prpDcodeApi.translateCode("BusinessSource1",prpPinsuredDto.getBusinessSource(), LanguageFlagConstant.CHINESE);
							prpPinsuredDto.setBusinessSourceName(businessSourceName);
							strPtext+="由"+prpPinsuredDto.getBusinessSourceName();
						}
						String businessSourceName1=prpDcodeApi.translateCode("BusinessSource1",prpCinsuredDto.getBusinessSource(), LanguageFlagConstant.CHINESE);
						prpCinsuredDto.setBusinessSourceName(businessSourceName1);
						strPtext +="修改为"+prpCinsuredDto.getBusinessSourceName();

						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getSex()+"").equals(prpCinsuredDto.getSex()+"")){
						strPtext ="性别：";
						if(prpPinsuredDto.getSex()!=null&&"1".equals(prpPinsuredDto.getSex())){
							strPtext+="由"+"男";
						}else if(prpPinsuredDto.getSex()!=null&&"2".equals(prpPinsuredDto.getSex())){
							strPtext+="由"+"女";
						}
						if(prpCinsuredDto.getSex()!=null&&"1".equals(prpCinsuredDto.getSex())){
							strPtext+="修改为"+"男";
						}else if(prpCinsuredDto.getSex()!=null&&"2".equals(prpCinsuredDto.getSex())){
							strPtext+="修改为"+"女";
						}
						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getCashFocus()+"").equals(prpCinsuredDto.getCashFocus()+"")){
						strPtext ="行业现金密度：";
						if(prpPinsuredDto.getCashFocus()!=null&&"1".equals(prpPinsuredDto.getCashFocus())){
							strPtext+="由"+"是";
						}else if(prpPinsuredDto.getCashFocus()!=null&&"2".equals(prpPinsuredDto.getCashFocus())){
							strPtext+="由"+"否";
						}
						if(prpCinsuredDto.getCashFocus()!=null&&"1".equals(prpCinsuredDto.getCashFocus())){
							strPtext+="修改为"+"是";
						}else if(prpCinsuredDto.getCashFocus()!=null&&"2".equals(prpCinsuredDto.getCashFocus())){
							strPtext+="修改为"+"否";
						}
						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!(prpPinsuredDto.getIsCareClaim()+"").equals(prpCinsuredDto.getIsCareClaim()+"")){
						strPtext ="客户是否关注审计、理赔、退保信息：";
						if(prpPinsuredDto.getIsCareClaim()!=null&&"1".equals(prpPinsuredDto.getIsCareClaim())){
							strPtext+="由"+"是";
						}else if(prpPinsuredDto.getIsCareClaim()!=null&&"2".equals(prpPinsuredDto.getIsCareClaim())){
							strPtext+="由"+"否";
						}
						if(prpCinsuredDto.getIsCareClaim()!=null&&"1".equals(prpCinsuredDto.getIsCareClaim())){
							strPtext+="修改为"+"是";
						}else if(prpCinsuredDto.getIsCareClaim()!=null&&"2".equals(prpCinsuredDto.getIsCareClaim())){
							strPtext+="修改为"+"否";
						}
						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
				}
			}
		}
    	//intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
        return intLineNo;
	}

	private int ptextForPlan(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto, int intLineNo) throws Exception{
    	String strPtext = "<<变更缴费计划>>";
    	intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
    	List<PrpCplanDto> prpCplanDtoList = blPolicyDtoNew.getPrpCplanDtoList();
    	List<PrpPplanDto> prpPplanDtoList = blEndorseDto.getPrpPplanDtoList();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	for (PrpPplanDto prpPplanDto : prpPplanDtoList) {
			for (PrpCplanDto prpCplanDto : prpCplanDtoList) {
				if(prpPplanDto.getSerialNo().equals(prpCplanDto.getSerialNo())){
					strPtext = "第"+(prpPplanDto.getSerialNo())+"期:";
					intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					String oldStartDate = format.format(prpPplanDto.getPlanStartDate());
					String newStartDate = format.format(prpCplanDto.getPlanStartDate());
					if(!oldStartDate.equals(newStartDate)){
						strPtext = "缴费起期由"+format.format(prpPplanDto.getPlanStartDate())+"变更为"
								+format.format(prpCplanDto.getPlanStartDate());
						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					String oldPlanDate = format.format(prpPplanDto.getPlanDate());
					String newPlanDate = format.format(prpCplanDto.getPlanDate());
					if(!oldPlanDate.equals(newPlanDate)){
						strPtext = "缴费止期由"+format.format(prpPplanDto.getPlanDate())+"变更为"
								+format.format(prpCplanDto.getPlanDate());
						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
					if(!prpPplanDto.getPlanFee().equals(prpCplanDto.getPlanFee())){
						strPtext = "应缴金额由"+prpPplanDto.getPlanFee()+"变更为"
								+prpCplanDto.getPlanFee();
						intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
					}
				}
			}
		}
    	//intLineNo = this.setEndorseText(blEndorseDto, strPtext, intLineNo, true);
        return intLineNo;
	}


    /**
     * 生成批文头部信息
     *
     * @return 处理后行
     * modify by zhaoning20070601 调整批文头信息
     */
    public int generateHead(BLEndorseDto iEndorse, int iLineNo)
            throws UserException, Exception {
        String strYear = "";
        String strMonth = "";
        String strDay = "";
        String strValidDate = "";
        String strPtext = "";
        String strEndorType = "";
        String strChgPremium = "";
        String strCurrency = "";
        String strCurrencyName = "";
        double dblChgPremium = 0d;
        PrpDcurrencyDto blPrpDcurrency = new PrpDcurrencyDto();
        strEndorType = iEndorse.getPrpPheadDto().getEndorType();
        strChgPremium = String.valueOf(iEndorse.getPrpPmainDto().getChgPremium());
        strCurrency = iEndorse.getPrpPmainDto().getCurrency();
        //todo blPrpDcurrency查询 根据strCurrency  CurrencyCode  得到db.getCurrencyCName()
       /* blPrpDcurrency = prpDcurrencyApi.queryByPK(strCurrency);
        strCurrencyName = blPrpDcurrency.getCurrencyCName();*/
        strCurrencyName="人民币";
        dblChgPremium = Double.parseDouble(new DecimalFormat("0.00").format(Double.parseDouble(strChgPremium)));
        if (dblChgPremium < 0) {
            dblChgPremium = dblChgPremium * (-1);
        }
        strChgPremium = toChineseMoney(dblChgPremium, strCurrency);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        strValidDate = sdf.format(iEndorse.getPrpPheadDto().getValidDate());
        strYear = strValidDate.substring(0, 4);
        strMonth = strValidDate.substring(5, 7);
        strDay = strValidDate.substring(8, 10);
        if (strEndorType.equals("21")) {
            strPtext = "    兹经投保人申请,保险人同意自" + strYear + "年" + strMonth + "月"
                    + strDay + "日起终止本保险单保险责任,保险人应退还投保人保险费为 " + strCurrencyName
                    + " " + strChgPremium + " (大写金额)";
        }
        //strPtext = "    兹经投保人申请,保险人同意自" + strYear + "年" + strMonth + "月"
        //+ strDay + "日起,对保险单作如下批改:";
        strPtext = "    兹经投保人申请,对保险单作如下批改:";
        iLineNo = this.setEndorseText(iEndorse, strPtext, iLineNo, true);
        return iLineNo;
    }

    /**
     * 生成1行的批文信息
     * 重构setEndorseText函数,添加newLineFlag参数来区别一般的批文和附加险条款内容的批文，
     * 批单信息
     * 文字信息
     * 当前行号
     *
     * @param newLineFlag 当是一般的批文时，要程序自动添加换行符 ,newLineFlag=true,<br/>
     *                    当是附加险条款的内容时不用自动添加换行符newLineFlag=false
     * @return 处理后行号
     */
    public int setEndorseText(BLEndorseDto iEndorse, String strPtext, int iLineNo, boolean newLineFlag)
            throws UserException, Exception {
        if (newLineFlag) {
            strPtext = strPtext + " ";
        }
        PrpPtextDto prpPtextschema = new PrpPtextDto();
        prpPtextschema.setEndorseNo(iEndorse.getPrpPheadDto().getEndorseNo());
        prpPtextschema.setPolicyNo(iEndorse.getPrpPheadDto().getPolicyNo());
        iLineNo = iLineNo + 1;
        prpPtextschema.setLineNo(iLineNo);
        prpPtextschema.setEndorseText(strPtext);
        prpPtextschema.setFlag("");
        iEndorse.getPrpPtextDtoList().add(prpPtextschema);
        return iLineNo;
    }

    /**
     * 生成大写金额
     */
    public String toChineseMoney(double iFee, String iCurrency)
            throws IllegalArgumentException {
        String strChineseMoney = "";
        String strNumber = "              ";
        String strFee = "";
        String strThat = "";
        int intLength = 0;
        int i = 0;
        int j = 0;
        if ((iCurrency == null) || (iCurrency.length() == 0)) {
            iCurrency = "CNY";
        }
        if (iFee < 0.0D) {
            throw new IllegalArgumentException("金额不能为负");
        }
        if (iFee == 0.0D) {
            return strChineseMoney;
        }
        strFee = new DecimalFormat("0").format(iFee * 100.0D);
        intLength = strFee.length();
        if (intLength > 14) {
            throw new IllegalArgumentException("金额超出范围");
        }
        strNumber = strNumber.substring(0, 14 - intLength) + strFee;
        for (i = 14 - intLength; i < 14; i++) {
            j = new Integer(strNumber.substring(i, i + 1)).intValue();
            if (j > 0) {
                strChineseMoney = strChineseMoney.trim() + strThat.trim() + getUpperChineseDigit(j).trim() + getUpperChineseUnit(i, iCurrency);

                strThat = "";
            } else if (strChineseMoney.length() != 0) {
                if (i == 11) {
                    strChineseMoney = strChineseMoney + "元";
                } else if ((i == 7) && (!strNumber.substring(4, 8).equals("0000"))) {
                    strChineseMoney = strChineseMoney + "万";
                } else if ((i == 3) && (!strNumber.substring(0, 4).equals("0000"))) {
                    strChineseMoney = strChineseMoney + "亿";
                }
                if ((i < 11) || (i == 12)) {
                    strThat = getUpperChineseDigit(0);
                }
            }
        }
        if (strChineseMoney.endsWith("拾")) {
            strChineseMoney = strChineseMoney + "分";
        }
        if (strChineseMoney.endsWith("元")) {
            strChineseMoney = strChineseMoney + "整";
        }
        if (strChineseMoney.endsWith("角")) {
            strChineseMoney = strChineseMoney + "整";
        }
        if (strChineseMoney.endsWith("分")) {
            strChineseMoney = strChineseMoney + "整";
        }
        return strChineseMoney;
    }

    public String getUpperChineseDigit(int iDigit)
            throws IllegalArgumentException {
        String strUpperChineseDigit = "";
        String strUpperChineseChar = "零壹贰叁肆伍陆柒捌玖";
        if (iDigit > 9)
            throw new IllegalArgumentException("金额超出范围");
        if (iDigit < 0)
            throw new IllegalArgumentException("金额不能为负");
        strUpperChineseDigit = strUpperChineseChar.substring(iDigit, iDigit + 1);
        return strUpperChineseDigit;
    }
    private String getUpperChineseUnit(int iPoint, String iCurrency)
            throws IllegalArgumentException {
        String strUpperChineseUnit = "";
        String strUpperChineseUnitChar = "";
        if (iPoint > 13)
            throw new IllegalArgumentException("金额超出范围");
        if (iPoint < 0) {
            throw new IllegalArgumentException("金额不能为负");
        }
        iCurrency = iCurrency.trim();
        if (iCurrency.equals("CNY")) {
            strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾元角分";
        } else if (iCurrency.equals("HKD")) {
            strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾元角分";
        } else if (iCurrency.equals("JPY")) {
            strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾元角分";
        } else if (iCurrency.equals("GBP")) {
            strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾镑先令便士";
        } else {
            strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾元拾分";
        }
        strUpperChineseUnit = strUpperChineseUnitChar.substring(iPoint, iPoint + 1);
        return strUpperChineseUnit;
    }

    /**
     * 非车险变更保险期限批文
     * blPolicy 最新保单信息
     * blEndorse 批单信息
     * intLineNo 行数
     * @return int intLineNo 行数
     * @throws UserException
     * @throws Exception
     */
    public int ptextForPeriod(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                              int intLineNo) throws UserException, Exception {
        PrpPtextDto blPrpPtext = new PrpPtextDto();
        PrpCitemKindDto prpCitemKindSchema = new PrpCitemKindDto();
        PrpPitemKindDto prpPitemKindSchema = new PrpPitemKindDto();
        List<PrpCitemKindDto> blPrpCitemKindCollect = new ArrayList<PrpCitemKindDto>();
        List<PrpPitemKindDto> blPrpPitemKindCollect = new ArrayList<PrpPitemKindDto>();
        String strPtext = "";
        String strType = "";
        String strShortRateFlagName = "";
        double dblChgPremium = 0;
        double dblShortRate = 0;
        int i = 0;
        int j = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        boolean isReturned = false; // 退费的标志
        /* modify by xiaojian 20050919_1 begin reason：增加批改起运日期的批文处理 */
        strPtext = " <<变更保险期限>>";
        intLineNo = setEndorseText(blEndorse, strPtext,
                intLineNo, true);
        strPtext = "    原保单的终止日期由："
                + simpleDateFormat.format(blEndorse.getPrpPmainDto().getEndDate()).substring(0, 4)
                + "年"
                + simpleDateFormat.format(blEndorse.getPrpPmainDto().getEndDate()).substring(5, 7)
                + "月"
                + simpleDateFormat.format(blEndorse.getPrpPmainDto().getEndDate()).substring(8, 10)
                + "日改为："
                + blEndorse.getEndorseConditionDto().getEndDate().substring(0, 4)
                + "年"
                + blEndorse.getEndorseConditionDto().getEndDate().substring(5, 7)
                + "月"
                + blEndorse.getEndorseConditionDto().getEndDate().substring(8, 10) + "日。";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        // 汇总ItemKind表数据(根据客户需求对各险种的标的进行汇总)
        // add by zhaoning20070612 begin
        ItemKindPrint:
        for (i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
            for (j = 0; j < blPrpCitemKindCollect.size(); j++) {
                if (blPolicy.getPrpCitemKindDtoList().get(i).getItemCode().equals(blPrpCitemKindCollect.get(j).getItemCode())
                        && !blPolicy.getPrpCitemKindDtoList().get(i).getItemCode().equals("")
                        && !blPolicy.getPrpCitemKindDtoList().get(i).getItemCode().equals("9999")
                        && blPolicy.getPrpCitemKindDtoList().get(i).getKindName().equals(blPrpCitemKindCollect.get(j).getKindName())
                        && blPolicy.getPrpCitemKindDtoList().get(i).getModeCode().equals(blPrpCitemKindCollect.get(j).getModeCode())
                        && blPolicy.getPrpCitemKindDtoList().get(i).getRate().equals(blPrpCitemKindCollect.get(j).getRate())) {
                    // CP表
                    blPrpCitemKindCollect.get(j).setShortRateFlag(
                            blPolicy.getPrpCitemKindDtoList().get(i).getShortRateFlag());
                    blPrpCitemKindCollect.get(j).setShortRate(blPolicy.getPrpCitemKindDtoList().get(i).getShortRate());
                    blPrpCitemKindCollect.get(j).setKindName(blPolicy.getPrpCitemKindDtoList().get(i).getKindName());
                    blPrpCitemKindCollect.get(j).setAmount(Double.parseDouble(chgStrZero(blPrpCitemKindCollect.get(j).getAmount() + ""))
                            + Double.parseDouble(chgStrZero(blPolicy.getPrpCitemKindDtoList().get(i).getAmount() + "")));
                    blPrpCitemKindCollect.get(j).setPremium(Double.parseDouble(chgStrZero(blPrpCitemKindCollect.get(j).getPremium() + ""))
                            + Double.parseDouble(chgStrZero(blPolicy.getPrpCitemKindDtoList().get(i).getPremium() + "")));
                    // P表
                    blPrpPitemKindCollect.get(j).setShortRateFlag(blEndorse.getPrpPitemKindDtoList().get(i).getShortRateFlag());
                    blPrpPitemKindCollect.get(j).setShortRate(blEndorse.getPrpPitemKindDtoList().get(i).getShortRate());
                    blPrpPitemKindCollect.get(j).setKindName(
                            blEndorse.getPrpPitemKindDtoList().get(i).getKindName());
                    blPrpPitemKindCollect.get(j).setAmount(Double.parseDouble(chgStrZero(blPrpPitemKindCollect.get(j).getAmount() + ""))
                            + Double.parseDouble(chgStrZero(blEndorse.getPrpPitemKindDtoList().get(i).getAmount() + "")));
                    blPrpPitemKindCollect.get(j).setPremium(Double.parseDouble(chgStrZero(blPrpPitemKindCollect.get(j).getPremium() + ""))
                            + Double.parseDouble(chgStrZero(blEndorse.getPrpPitemKindDtoList().get(i).getPremium() + "")));
                    blPrpPitemKindCollect.get(j).setChgPremium(Double.parseDouble(chgStrZero(blPrpPitemKindCollect.get(j).getChgPremium() + ""))
                            + Double.parseDouble(chgStrZero(blEndorse.getPrpPitemKindDtoList().get(i).getChgPremium() + "")));
                    continue ItemKindPrint;
                }
            }
            BeanUtils beanUtils = new BeanUtils();
            BeanUtils.copyProperties(prpCitemKindSchema, blPolicy.getPrpCitemKindDtoList().get(i));
            blPrpCitemKindCollect.add(prpCitemKindSchema);
            BeanUtils.copyProperties(prpPitemKindSchema, blEndorse.getPrpPitemKindDtoList().get(i));
            blPrpPitemKindCollect.add(prpPitemKindSchema);
        }
        for (i = 0; i < blPrpPitemKindCollect.size(); i++) {
            prpCitemKindSchema = blPrpCitemKindCollect.get(i);
            prpPitemKindSchema = blPrpPitemKindCollect.get(i);
            dblChgPremium = Double.parseDouble(chgStrZero(String.valueOf(prpPitemKindSchema.getChgPremium())));
            if (dblChgPremium == 0) {
                continue;
            }
            if (dblChgPremium > 0) {
                strType = "应收";
            } else {
                strType = "应退";
                dblChgPremium = dblChgPremium * (-1);
                isReturned = true;
            }
            if (prpCitemKindSchema.getShortRateFlag().equals("4")) {
                strShortRateFlagName = "月";
            } else if (prpCitemKindSchema.getShortRateFlag().equals("2")) {
                strShortRateFlagName = "日";
            } else if (prpCitemKindSchema.getShortRateFlag().equals("1")) {
                strShortRateFlagName = "短期费率表";
            }
            strPtext = "    险别名称：" + prpCitemKindSchema.getKindName();
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
            strPtext = "    计算公式：";
                /*
                 * reason：按UIEndorseSpecialGenerateObject.jsp文件整理短期系数、批改公式
				 */
            // 批改公式文字描述
            // 批改后保费=原保费*新短期系数/原短期系数
            // 收费
            // 保费变化量=原保费*(新短期系数/原短期系数-1)
            if (!isReturned) {
                strPtext = "    " + strType + "保费" + "= " + "原保费" + "*"
                        + "(批改按" + strShortRateFlagName + "短期系数%" + "/"
                        + "原短期系数%" + "-1)";
                // 短期系数=原短期系数
                // +新保险期限、新短期费率方式计算的短期系数
                // -原保险期限、新短期费率方式计算的短期系数
                // 短期系数在jsp文件中已经获得，直接取就可以了
                dblShortRate = prpCitemKindSchema.getShortRate();
                strPtext = "          =" + round(prpPitemKindSchema.getPremium(), 2) + "*" + "("
                        + round(dblShortRate, 4) + "%" + "/" + round(Double.parseDouble(prpPitemKindSchema.getShortRate() + ""), 4) + "%" + "-1)"
                        + "=" + round(dblChgPremium, 2);
				intLineNo = setEndorseText(blEndorse,
						strPtext, intLineNo, true);
                // 退费
                // 保费变化量（绝对值）=原保费*(1-新短期系数/原短期系数)
            } else {
                strPtext = "    " + strType + "保费" + "= " + "原保费" + "*"
                        + "(1-批改" + strShortRateFlagName + "短期系数%" + "/"
                        + "原短期系数%)";
                // 短期系数=原短期系数
                // +新保险期限、新短期费率方式计算的短期系数
                // -原保险期限、新短期费率方式计算的短期系数
                // 短期系数在jsp文件中已经获得，直接取就可以了
                dblShortRate = prpCitemKindSchema.getShortRate();
                strPtext = "          =" + (round(prpPitemKindSchema.getPremium(), 2) + "*"
                        + "(1-" + round(dblShortRate, 4) + "%" + "/"
                        + round(Double.parseDouble(prpPitemKindSchema.getShortRate() + ""), 4) + "%)" + "=" + round(dblChgPremium, 2));

				intLineNo = setEndorseText(blEndorse,
						strPtext, intLineNo, true);
            }
        }
        return intLineNo;
    }

    //判断工具
    private String chgStrZero(String str) {
        if (str == null || str.equals("")) {
            str = "0";
        }
        return str;
    }

    //处理精确工具
    private double round(double v, int scale) {
        BigDecimal b = new BigDecimal(Double.toString(v));

        BigDecimal one = new BigDecimal("1");

        return b.divide(one, scale, 4).doubleValue();
    }

    /**
     * @return int intLineNo 行号
     * @throws UserException
     * @throws Exception
     * @desc 非车险保单遗失的批文
     * blPolicy 最新保单信息
     * blEndorse 批单信息
     */
    public int ptextForLoseCert(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                                int intLineNo) throws UserException, Exception {
        String strPtext = "";
        strPtext = "原保单因遗失而作废, 以补发保单凭证为准！";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        return intLineNo;
    }

    /**
     * STUB-ONLY：变更地址批文
     * <p>
     * 最新保单信息
     * 批改前信息
     *
     * @return 无
     * @throws UserException
     * @throws Exception
     */
    public int ptextForAddress(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                               int intLineNo) throws UserException, Exception {

        PrpCaddressDto prpCaddressSchema = new PrpCaddressDto();
        PrpPaddressDto prpPaddressSchema = new PrpPaddressDto();
        int i = 0;
        if(blPolicy.getPrpCaddressDtoList()!=null) {
            for (i = 0; i < blPolicy.getPrpCaddressDtoList().size(); i++) {
                prpCaddressSchema = blPolicy.getPrpCaddressDtoList().get(i);
                prpPaddressSchema = blEndorse.getPrpPaddressDtoList().get(i);
                if (blPolicy.getPrpCaddressDtoList().get(i).getFlag().length() > 0
                        && blPolicy.getPrpCaddressDtoList().get(i).getFlag().substring(0, 1).equals("I")) {
                    intLineNo = this.ptextForAddressInsertDelete(prpCaddressSchema,
                            "i", blEndorse, intLineNo);
                }
                if (blPolicy.getPrpCaddressDtoList().get(i).getFlag().length() > 0
                        && blPolicy.getPrpCaddressDtoList().get(i).getFlag()
                        .substring(0, 1).equals("D")) {
                    intLineNo = this.ptextForAddressInsertDelete(prpCaddressSchema,
                            "d", blEndorse, intLineNo);
                }
                if (blPolicy.getPrpCaddressDtoList().get(i).getFlag().length() > 0
                        && blPolicy.getPrpCaddressDtoList().get(i).getFlag()
                        .substring(0, 1).equals("U")) {
                    intLineNo = this.ptextForAddressUpdate(prpCaddressSchema,
                            prpPaddressSchema, blEndorse, intLineNo);
                }
            }
        }
        return intLineNo;
    }

    /**
     * STUB-ONLY：增加\删除地址批文
     * 最新保单信息
     * 批改前信息
     *
     * @return 无
     * @throws UserException
     * @throws Exception
     */
    public int ptextForAddressInsertDelete(PrpCaddressDto iPrpCaddressSchema, String strOption,
                                           BLEndorseDto blEndorse, int intLineNo) throws UserException, Exception {
        String strPtext = "";
        if (strOption.equals("i")) {
            strPtext = " <<增加地址信息>>";
        }
        if (strOption.equals("d")) {
            strPtext = " <<删除地址信息>>";
        }
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        strPtext = "    地址序号：" + iPrpCaddressSchema.getAddressNo();
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        //  增加地址编码的批改功能
        strPtext = "    地址编码：" + iPrpCaddressSchema.getAddressCode();
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        strPtext = "    地址名称：" + iPrpCaddressSchema.getAddressName();
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        return intLineNo;
    }

    /**
     * STUB-ONLY：变更地址批文
     * 最新保单信息
     * 批改前信息
     *
     * @return 无
     * @throws UserException
     * @throws Exception
     */
    public int ptextForAddressUpdate(PrpCaddressDto iPrpCaddressSchema, PrpPaddressDto iPrpPaddressSchema, BLEndorseDto blEndorse,
                                     int intLineNo) throws UserException, Exception {
        String strPtext = "";
        strPtext = " <<变更地址信息>>";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        // 简单批改，修改被保险人地址编码，生成的批文显示为修改了地址内容，实际地址信息没有修改。
        // strPtext = " 地址序号"+iPrpCaddressSchema.getAddressNo();
        if (!iPrpCaddressSchema.getAddressCode().equals(
                iPrpPaddressSchema.getAddressCode())) {
            strPtext = "    地址编码由" + iPrpPaddressSchema.getAddressCode()
                    + "变更为" + iPrpCaddressSchema.getAddressCode();
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }
        if (!iPrpCaddressSchema.getAddressName().equals(
                iPrpPaddressSchema.getAddressName())) {
            strPtext = "    地址名称由" + iPrpPaddressSchema.getAddressName()
                    + "变更为" + iPrpCaddressSchema.getAddressName();
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }
        return intLineNo;
    }

    /**
     * STUB-ONLY：变更业务员批文
     * <p>
     * 最新保单信息
     * 批改前信息
     *
     * @return 无
     * @throws UserException
     * @throws Exception
     */
    public int ptextForHandler(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                               int intLineNo) throws UserException, Exception {
        PrpCmainDto prpcmainSchema = new PrpCmainDto();
        PrpPmainDto prppmainSchema = new PrpPmainDto();
        prpcmainSchema = blPolicy.getPrpCmainDto();
        prppmainSchema = blEndorse.getPrpPmainDto();
        String strCode = prpcmainSchema.getHandler1Code();
        String strName = translateCode(strCode, true);
        String strCode1 = prppmainSchema.getHandler1Code();
        String strName1 = translateCode(strCode1, true);
        String strCode2 = prpcmainSchema.getHandlerCode();
        String strName2 = translateCode(strCode2, true);
        String strCode3 = prppmainSchema.getHandlerCode();
        String strName3 = translateCode(strCode3, true);
        String strPtext = "";
        strPtext = " <<变更业务员信息>>";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        strPtext = "    业务员由" + strName1 + "变为" + strName + "";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        return intLineNo;
    }

    /**
     * @param iUserCode 用户代码
     * @param isChinese 中外文标识
     * @return 根据语种返回中文或英文名称
     * @throw UserException, Exception
     */
    public String translateCode(String iUserCode, boolean isChinese) throws UserException, Exception {
        if (iUserCode == null || iUserCode.equals(""))
            return ""; // 代码空直接返回空字符串
        PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(iUserCode);
        if (isChinese) {
            return prpDuserDto.getUserName();
        } else {
            if (prpDuserDto.getUserEName() == null || prpDuserDto.getUserEName().equals("")) {
                return prpDuserDto.getUserName();
            } else {
                return prpDuserDto.getUserEName();
            }
        }
    }

    /**
     * @return int intLineNo 行号
     * @throws UserException
     * @throws Exception
     * @desc 变更保单附表批文
     * blPolicy 最新保单信息
     * blEndorse 批改前信息
     * intLineNo 行号
     * strEndorType 批改类型
     */
    /*
     * 所有险种类型的保单附表信息汇总分类批文生成调用
	 */
    public int ptextForMainAddition(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                                    int intLineNo, String strEndorType) throws UserException, Exception {
        //  PrpCmainProp可能为空，这里需要判断(干脆下面也都加上了)
        // 农业险种的批文
        if (blPolicy.getPrpCmainAgriDto() != null) {
            if (!blPolicy.getPrpCmainAgriDto().getFlag().equals("") && blPolicy.getPrpCmainAgriDto().getFlag() != null) {
                intLineNo = this.ptextForMainAgri(blPolicy, blEndorse,
                        intLineNo);
            }
        }
        // 在此扩充，加入代码
        return intLineNo;
    }

    // add gy guolei 添加农业险的批文
    public int ptextForMainAgri(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                                int intLineNo) throws UserException, Exception {
        PrpCmainAgriDto prpCmainAgriSchema = new PrpCmainAgriDto();
        PrpPmainAgriDto prpPmainAgriSchema = new PrpPmainAgriDto();
        PrpDcodeDto dbPrpDcode = new PrpDcodeDto();
        PrpXpColDto prpXPcolSchema = new PrpXpColDto();
        List<PrpXpColDto> prpXpColDtoList = new ArrayList<PrpXpColDto>();

        String strPtext = "    ";
        String strColname = "";
        String strColCname = "";
        String strCdata = "";
        String strPdata = "";
        prpCmainAgriSchema = blPolicy.getPrpCmainAgriDto();
        prpPmainAgriSchema = blEndorse.getPrpPmainAgriDto();
        PubTools pubTools = new PubTools();
        pubTools.convertNullToDef(prpCmainAgriSchema);//判断属性若为null，赋默认值
        pubTools.convertNullToDef(prpPmainAgriSchema);//判断属性若为null，赋默认值
        strPtext = " <<变更农业险附加信息>>";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        List<PrpXpCol> prpXPcolList = prpXpColDao.findAll(Specifications.<PrpXpCol>and()
       		 .eq(StringUtils.isNotEmpty(prpCmainAgriSchema.getRiskCode()), "riskCode", prpCmainAgriSchema.getRiskCode())
       		 .eq("tableName", "prpcmainagri")
               .build(), new Sort(Direction.ASC, "dispSeq"));
//        StringBuffer buffer = new StringBuffer();
//        buffer.append(" SELECT * FROM PrpXPcol WHERE ");
//        String strWherePart = " RiskCode = '" + prpCmainAgriSchema.getRiskCode() + "' AND tablename = '" + "prpcmainagri" + "'" +
//                " order by DispSeq ";
//        buffer.append(strWherePart);
//        Query query = entityManager.createNativeQuery(buffer.toString(), PrpXpCol.class);
//        List<PrpXpCol> prpXPcolList = query.getResultList();
        convertCollection(prpXPcolList,prpXpColDtoList,PrpXpColDto.class);
        if (prpXpColDtoList.size() == 0) {
            throw new BusinessException("ptextForMainAgri(BLPolicy, BLEndorse, int) - 无法生成批文,请维护blPrpXPcol表!!!!!!!");
        } else {
            for (int i = 0; i < prpXpColDtoList.size(); i++) {
                prpXPcolSchema = prpXpColDtoList.get(i);
                strColname = prpXPcolSchema.getColName();
                strColCname = prpXPcolSchema.getColCName();
                //种植面积
                if (strColname.equals("insurearea")) {
                    if (prpCmainAgriSchema.getInsureArea() != prpPmainAgriSchema.getInsureArea() ) {
                        if ((prpPmainAgriSchema.getInsureArea() + "").length() == 0) {
                            strPtext = "" + strColCname + "变更为" + prpCmainAgriSchema.getInsureArea() + "，";
                        } else {
                            strPtext = " " + strColCname + "由" + prpPmainAgriSchema.getInsureArea() + "变更为" + prpCmainAgriSchema.getInsureArea() + "，";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                //种植地点
                if (strColname.equals("raisesite")) {
                    if (!prpCmainAgriSchema.getRaiseSite().equals(prpCmainAgriSchema.getRaiseSite())) {
                        if (prpPmainAgriSchema.getRaiseSite().length() == 0) {
                            strPtext = "    " + strColCname + "变更为"
                                    + prpCmainAgriSchema.getRaiseSite() + "，";
                        } else {
                            strPtext = "    " + strColCname + "由"
                                    + prpPmainAgriSchema.getRaiseSite() + "变更为"
                                    + prpCmainAgriSchema.getRaiseSite() + "，";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                if (strColname.equals("valuerate")) {
                    if (prpCmainAgriSchema.getValueRate() != prpPmainAgriSchema.getValueRate()) {
                        if ((prpPmainAgriSchema.getValueRate() + "").length() == 0) {
                            strPtext = "    " + strColCname + "变更为"
                                    + prpCmainAgriSchema.getValueRate() + "，";
                        } else {
                            strPtext = "    " + strColCname + "由"
                                    + prpPmainAgriSchema.getValueRate() + "变更为"
                                    + prpCmainAgriSchema.getValueRate() + "，";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                //种植时间
                if (strColname.equals("raisedate")) {
                    if ((prpCmainAgriSchema.getRaiseDate() != null && (prpCmainAgriSchema.getRaiseDate().compareTo(prpPmainAgriSchema.getRaiseDate())!=0))
                    		|| (prpPmainAgriSchema.getRaiseDate() != null && (prpPmainAgriSchema.getRaiseDate().compareTo(prpCmainAgriSchema.getRaiseDate())!=0))) {
                        if ((prpPmainAgriSchema.getRaiseDate() + "").length() == 0) {
                            strPtext = "" + strColCname + "变更为" + prpCmainAgriSchema.getRaiseDate() + ",";
                        } else {
                            strPtext = "" + strColCname + "由" + new DateTime(prpPmainAgriSchema.getRaiseDate(), DateTime.YEAR_TO_DAY) + "变更为" + 
                            		new DateTime(prpCmainAgriSchema.getRaiseDate(), DateTime.YEAR_TO_DAY) + ",";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                if (strColname.equals("remark")) {
                    if (!prpCmainAgriSchema.getRemark().equals(prpCmainAgriSchema.getRemark())) {
                        if (prpPmainAgriSchema.getRemark().length() == 0) {
                            strPtext = "" + strColCname + "变更为" + prpCmainAgriSchema.getRemark() + ",";
                        } else {
                            strPtext = "" + strColCname + "由" + prpPmainAgriSchema.getRemark() + "变更为"
                                    + prpCmainAgriSchema.getRemark() + ",";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                if (strColname.equals("observeperiod")) {
                    if (!prpCmainAgriSchema.getObservePeriod().equals(
                            prpPmainAgriSchema.getObservePeriod())) {
                        if ((prpPmainAgriSchema.getObservePeriod() + "").length() == 0) {
                            strPtext = "" + strColCname + "变更为" + prpCmainAgriSchema.getObservePeriod() + "天,";
                        } else {
                            strPtext = "" + strColCname + "由" + prpPmainAgriSchema.getObservePeriod()
                                    + "天变更为" + prpCmainAgriSchema.getObservePeriod() + "天,";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                if (strColname.equals("observestartdate")) {
                    if ((prpCmainAgriSchema.getObserveStartDate() != null && 
                    		(prpCmainAgriSchema.getObserveStartDate().compareTo(prpPmainAgriSchema.getObserveStartDate())!=0))
                    		|| (prpPmainAgriSchema.getObserveStartDate() != null && 
                    		(prpPmainAgriSchema.getObserveStartDate().compareTo(prpCmainAgriSchema.getObserveStartDate())!=0))) {
                        if ((prpPmainAgriSchema.getObserveStartDate() + "").length() == 0) {
                            strPtext = "" + strColCname + "变更为" + prpCmainAgriSchema.getObserveStartDate() + "日,";
                        } else {
                            strPtext = "" + strColCname + "由"
                                    + prpPmainAgriSchema.getObserveStartDate() + "日" +
                                    "变更为"
                                    + prpCmainAgriSchema.getObserveStartDate() + "日,";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                if (strColname.equals("observestarthour")) {
                    if ((prpCmainAgriSchema.getObserveStartHour() != null && 
                    		(prpCmainAgriSchema.getObserveStartHour().compareTo(prpPmainAgriSchema.getObserveStartHour())!=0))
                    		|| (prpPmainAgriSchema.getObserveStartHour() != null && 
                    		(prpPmainAgriSchema.getObserveStartHour().compareTo(prpCmainAgriSchema.getObserveStartHour())!=0))) {
                        if ((prpPmainAgriSchema.getObserveStartHour() + "").length() == 0) {
                            strPtext = "" + strColCname + "变更为"
                                    + prpCmainAgriSchema.getObserveStartHour() + "时,";
                        } else {
                            strPtext = "" + strColCname + "由"
                                    + prpPmainAgriSchema.getObserveStartHour() + "时" +
                                    "变更为"
                                    + prpCmainAgriSchema.getObserveStartHour()
                                    + "时,";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                if (strColname.equals("observeenddate")) {
                    if ((prpCmainAgriSchema.getObserveEndDate() != null && 
                    		(prpCmainAgriSchema.getObserveEndDate().compareTo(prpPmainAgriSchema.getObserveEndDate())!=0))
                    		|| (prpPmainAgriSchema.getObserveEndDate() != null && 
                    		(prpPmainAgriSchema.getObserveEndDate().compareTo(prpCmainAgriSchema.getObserveEndDate())!=0))) {
                        if ((prpPmainAgriSchema.getObserveEndDate() + "").length() == 0) {
                            strPtext = "" + strColCname + "变更为"
                                    + prpCmainAgriSchema.getObserveEndDate()
                                    + "日,";
                        } else {
                            strPtext = "" + strColCname + "由"
                                    + prpPmainAgriSchema.getObserveEndDate()
                                    + "日变更为"
                                    + prpCmainAgriSchema.getObserveEndDate()
                                    + "日,";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                if (strColname.equals("observeendhour")) {
                    if ((prpCmainAgriSchema.getObserveEndHour() != null && 
                    		(prpCmainAgriSchema.getObserveEndHour().compareTo(prpPmainAgriSchema.getObserveEndHour())!=0))
                    		|| (prpPmainAgriSchema.getObserveEndHour() != null && 
                    		(prpPmainAgriSchema.getObserveEndHour().compareTo(prpCmainAgriSchema.getObserveEndHour())!=0))) {
                        if ((prpPmainAgriSchema.getObserveEndHour() + "").length() == 0) {
                            strPtext = " " + strColCname + "变更为"
                                    + prpCmainAgriSchema.getObserveEndHour()
                                    + "时,";
                        } else {
                            strPtext = "" + strColCname + "由"
                                    + prpPmainAgriSchema.getObserveEndHour()
                                    + "时变更为"
                                    + prpCmainAgriSchema.getObserveEndHour()
                                    + "时,";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                if (strColname.equals("deptname")) {
                    if (!prpCmainAgriSchema.getDeptName().equals(
                            prpPmainAgriSchema.getDeptName())) {
                        if (prpPmainAgriSchema.getDeptName().length() == 0) {
                            strPtext = "    " + strColCname + "变更为"
                                    + prpCmainAgriSchema.getDeptName()
                                    + ",";
                        } else {
                            strPtext = "    " + strColCname + "由"
                                    + prpPmainAgriSchema.getDeptName()
                                    + "变更为"
                                    + prpCmainAgriSchema.getDeptName()
                                    + ",";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                if (strColname.equals("deptaddress")) {
                    if (!prpCmainAgriSchema.getDeptAddress().equals(
                            prpPmainAgriSchema.getDeptAddress())) {
                        if (prpPmainAgriSchema.getDeptAddress().length() == 0) {
                            strPtext = "    " + strColCname + "变更为"
                                    + prpCmainAgriSchema.getDeptAddress()
                                    + ",";
                        } else {
                            strPtext = "    " + strColCname + "由"
                                    + prpPmainAgriSchema.getDeptAddress()
                                    + "变更为"
                                    + prpCmainAgriSchema.getDeptAddress()
                                    + ",";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
                if (strColname.equals("areaflag")) {
                    if (!prpCmainAgriSchema.getAreaFlag().equals(
                            prpPmainAgriSchema.getAreaFlag())) {
                        if (prpPmainAgriSchema.getAreaFlag().length() == 0) {
                            strPtext = "   " + strColCname + "变更为"
                                    + prpCmainAgriSchema.getAreaFlag()
                                    + ",";
                        } else {
                            strPtext = "   " + strColCname + "由"
                                    + prpPmainAgriSchema.getAreaFlag()
                                    + "变更为"
                                    + prpCmainAgriSchema.getAreaFlag()
                                    + ",";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strPtext, intLineNo, true);
                        continue;
                    }
                }
            }
        }
        return intLineNo;
    }

    /**
     * 变更主保单信息批文
     * 最新保单信息
     * 批改前信息
     *
     * @return 无 @throws UserException @throws Exception
     */
    public int ptextForMain(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                            int intLineNo,ResponseQueryPolicyInfoDto blPolicyDtoOld) throws UserException, Exception {
        String strPtext = "    ";
        String strCdata = "";
        String strPdata = "";
        PrpDuserDto dbPrpDuser = new PrpDuserDto();
        PrpDcompanyDto dbPrpDcompany = new PrpDcompanyDto();
        PrpCmainDto prpCmainSchema = new PrpCmainDto();
        PrpPmainDto prpPmainSchema = new PrpPmainDto();
        prpCmainSchema = blPolicy.getPrpCmainDto();
        prpPmainSchema = blEndorse.getPrpPmainDto();
        String riskCode = prpCmainSchema.getRiskCode();
        PrpCmainAgriDto prpCmainAgriDto=blPolicy.getPrpCmainAgriDto();
        PrpPmainAgriDto prpPmainAgriDto=blEndorse.getPrpPmainAgriDto();
        strPtext = " <<变更主保单信息>>";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        if (StringUtils.isNotEmpty(prpCmainSchema.getAgentCode())
                && !prpCmainSchema.getAgentCode().equals(prpPmainSchema.getAgentCode())) {
            PrpDagentDto prpDagentDto = prpDagentApi.queryByPK(prpCmainSchema.getAgentCode());
            strCdata = prpDagentDto.getAgentName();
            if (prpPmainSchema.getAgentCode().length() == 0) {
                strPtext = "代理人变更为" + strCdata + ",";
            } else {
                PrpDagentDto prpDagentDto1 = prpDagentApi.queryByPK(prpPmainSchema.getAgentCode());
                strCdata = prpDagentDto1.getAgentName();
                strPtext = "代理人由" + strPdata + "变更为" + strCdata + ",";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }

        if (StringUtils.isNotEmpty(prpCmainSchema.getHandlerCode())
                && !prpCmainSchema.getHandlerCode().equals(prpPmainSchema.getHandlerCode())) {
            PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(prpCmainSchema.getHandlerCode());
            strCdata = prpDuserDto.getUserName();
            if (prpPmainSchema.getHandlerCode().length() == 0) {
                strPtext = "经办人变更为" + strCdata + ",";
            } else {
                PrpDuserDto prpDuserDto1 = prpDuserApi.queryByPK(prpPmainSchema.getHandlerCode());
                strCdata = prpDuserDto1.getUserName();
                strPtext = "经办人由" + strPdata + "变更为" + strCdata + ",";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }

        if (StringUtils.isNotEmpty(prpCmainSchema.getHandler1Code())
                && !prpCmainSchema.getHandler1Code().equals(prpPmainSchema.getHandler1Code())) {
            PrpDuserDto prpDuserDto2 = prpDuserApi.queryByPK(prpCmainSchema.getHandlerCode());
            strCdata = prpDuserDto2.getUserName();
            if (prpPmainSchema.getHandler1Code().length() == 0) {
                strPtext = "归属经办人变更为" + strCdata + ",";
            } else {
                PrpDuserDto prpDuserDto3 = prpDuserApi.queryByPK(prpPmainSchema.getHandler1Code());
                strCdata = prpDuserDto3.getUserName();
                strPtext = "归属经办人由" + strPdata + "变更为" + strCdata + ",";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }
        if (StringUtils.isNotEmpty(prpCmainSchema.getComCode())
                && !prpCmainSchema.getComCode().equals(prpPmainSchema.getComCode())) {
            PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(prpCmainSchema.getComCode());
            strCdata = prpDcompanyDto.getComCName();
            if (prpPmainSchema.getComCode().length() == 0) {
                strPtext = "归属部门变更为" + strCdata + ",";
            } else {
                PrpDcompanyDto prpDcompanyDto1 = prpDcompanyApi.queryByPK(prpPmainSchema.getComCode());
                strPdata = prpDcompanyDto1.getComCName();
                strPtext = "归属部门由" + strPdata + "变更为" + strCdata + ",";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }
        /** *************** add by luyang 2004-10-14 ******************* */
        if (prpCmainSchema.getDisRate()!=null
                && !prpCmainSchema.getDisRate().equals(prpPmainSchema.getDisRate())) {
            if ((prpPmainSchema.getDisRate() + "").length() == 0) {
                strPtext = "手续费变更为"
                        + new DecimalFormat("#0.0000").format(prpCmainSchema.getDisRate()) + ",";
            } else {
                strPtext = "手续费由"
                        + new DecimalFormat("#0.0000").format(prpPmainSchema.getDisRate())
                        + "变更为"
                        + new DecimalFormat("#0.0000").format(prpCmainSchema.getDisRate()) + ",";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }

        if (StringUtils.isNotEmpty(prpCmainSchema.getJudicalScope())
                && !prpCmainSchema.getJudicalScope().equals(prpPmainSchema.getJudicalScope())) {
            if (prpPmainSchema.getJudicalScope().length() == 0) {
                strPtext = "司法管辖变更为" + prpCmainSchema.getJudicalScope()
                        + ", ";
            } else {
                strPtext = "司法管辖由" + prpPmainSchema.getJudicalScope()
                        + " 变更为 " + prpCmainSchema.getJudicalScope() + ", ";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }
        if(prpCmainSchema.getRemark()==null){
        	prpCmainSchema.setRemark("");
		}
		if(blEndorse.getEndorseConditionDto().getRemark()==null){
			blEndorse.getEndorseConditionDto().setRemark("");
		}
		if ( !prpCmainSchema.getRemark().equals(blEndorse.getEndorseConditionDto().getRemark())) {
			if (prpCmainSchema.getRemark().length() == 0) {
				strPtext = "出单员意见更为" + blEndorse.getEndorseConditionDto().getRemark()
						+ ", ";
			} else {
				strPtext = "出单员意见由" + prpCmainSchema.getRemark()
						+ " 变更为 " + blEndorse.getEndorseConditionDto().getRemark() + ", ";
			}
			intLineNo = setEndorseText(blEndorse, strPtext,
					intLineNo, true);
		}
        if (StringUtils.isNotEmpty(prpCmainSchema.getPolicySort()) &&
                !prpCmainSchema.getPolicySort().equals(prpPmainSchema.getPolicySort())) {
            if (prpPmainSchema.getPolicySort().length() == 0) {
                strPtext = "保单类型变更为 "
                        + translateCode("PolicySort", prpCmainSchema
                        .getPolicySort(), true) + ", ";
            } else {
                strPtext = "保单类型由 "
                        + translateCode("PolicySort", prpPmainSchema
                        .getPolicySort(), true)
                        + " 变更为 "
                        + translateCode("PolicySort", prpCmainSchema
                        .getPolicySort(), true) + ", ";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }
        if ((prpCmainSchema.getBusinessProvince() != prpPmainSchema.getBusinessProvince())
        		&& prpCmainSchema.getBusinessProvince() != null
        		&& !prpCmainSchema.getBusinessProvince().equals(prpPmainSchema.getBusinessProvince())) {
            if (prpPmainSchema.getBusinessProvince().length() == 0) {
                strPtext = "归属省份变更为 "
                        + prpCmainSchema.getStatQuantity() + ", ";
            } else {
                strPtext = "归属省份由 "
                        + prpPmainSchema.getBusinessProvince()
                        + " 变更为 "
                        + prpCmainSchema.getBusinessProvince() + ", ";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);

        }

        if (prpCmainSchema.getBusinessTown() != prpPmainSchema.getBusinessTown()
        		&& prpCmainSchema.getBusinessTown() != null
        		&&!prpCmainSchema.getBusinessTown().equals(prpPmainSchema.getBusinessTown())) {
            if (prpPmainSchema.getBusinessTown().length() == 0) {
                strPtext = "归属城市变更为 "
                        + prpCmainSchema.getBusinessTown() + ",";
            } else {
                strPtext = "归属城市由 "
                        + prpPmainSchema.getBusinessTown()
                        + " 变更为 "
                        + prpCmainSchema.getBusinessTown() + ",";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);

        }
        if (prpCmainSchema.getBusinessCounty() != prpPmainSchema.getBusinessCounty()
        		&& prpCmainSchema.getBusinessCounty() != null
                && !prpCmainSchema.getBusinessCounty().equals(prpPmainSchema.getBusinessCounty())) {
            if (prpPmainSchema.getBusinessCounty().length() == 0) {
                strPtext = "归属区县变更为"
                        + prpCmainSchema.getBusinessCounty() + ", ";
            } else {
                strPtext = "归属区县由"
                        + prpPmainSchema.getBusinessCounty()
                        + " 变更为 "
                        + prpCmainSchema.getBusinessCounty() + ", ";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);

        }
        if (prpCmainSchema.getBusinessAreaName() != prpPmainSchema.getBusinessAreaName()
        		&& prpCmainSchema.getBusinessAreaName() != null
                && !prpCmainSchema.getBusinessAreaName().equals(prpPmainSchema.getBusinessAreaName())) {
            if (prpPmainSchema.getBusinessAreaName().length() == 0) {
                strPtext = "归属乡镇变更为 "
                        + prpCmainSchema.getBusinessAreaName() + ", ";
            } else {
                strPtext = "归属乡镇由 "
                        + prpPmainSchema.getBusinessAreaName()
                        + " 变更为 "
                        + prpCmainSchema.getBusinessAreaName() + ", ";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }

        if (!prpCmainSchema.getStatQuantity().equals(prpPmainSchema.getStatQuantity())) {
            if ((prpPmainSchema.getStatQuantity() + "").length() == 0) {
                strPtext = "承保数量变更为 "
                        + prpCmainSchema.getStatQuantity() + ", ";
            } else {
                strPtext = "承保数量由 "
                        + prpPmainSchema.getStatQuantity()
                        + " 变更为 "
                        + prpCmainSchema.getStatQuantity() + ", ";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);

        }
        if (!prpCmainSchema.getSumInsured().equals(prpPmainSchema.getSumInsured())) {
            if ((prpPmainSchema.getSumInsured() + "").length() == 0) {
                strPtext = "参保农户户次变更为 "
                        + prpCmainSchema.getSumInsured() + ",";
            } else {
                strPtext = "参保农户户次由 "
                        + prpPmainSchema.getSumInsured()
                        + " 变更为 "
                        + prpCmainSchema.getSumInsured() + ",";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);

        }
        if (!prpCmainSchema.getPolicyType().equals(prpPmainSchema.getPolicyType())) {
            if (prpPmainSchema.getPolicyType().length() == 0) {
                strPtext = "投保方式变更为 "
                        + translateCode("PolicyType", prpCmainSchema.getPolicyType(), true) + ", ";
            } else {
                strPtext = "投保方式由 "
                        + translateCode("PolicyType", prpPmainSchema.getPolicyType(), true)
                        + " 变更为 "
                        + translateCode("PolicyType", prpCmainSchema.getPolicyType(), true) + ", ";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);

        }
        
        if (!prpCmainSchema.getAutoTransRenewFlag().equals(prpPmainSchema.getAutoTransRenewFlag())) {
            if (prpPmainSchema.getAutoTransRenewFlag().length() == 0) {
                strPtext = "缴费方式变更为 "
                        + translateCode("AutoTransRenewFlag1", prpCmainSchema.getAutoTransRenewFlag(), true) + ", ";
            } else {
                strPtext = "缴费方式由 "
                        + translateCode("AutoTransRenewFlag1", prpPmainSchema.getAutoTransRenewFlag(), true)
                        + " 变更为 "
                        + translateCode("AutoTransRenewFlag1", prpCmainSchema.getAutoTransRenewFlag(), true) + ", ";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);

        }
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String strDateOld=sdf.format(prpCmainSchema.getOperateDate());
		String strDateNew=sdf.format(prpPmainSchema.getOperateDate());
        if (prpCmainSchema.getOperateDate() != null && (prpPmainSchema.getOperateDate() != null
				&& (!strDateNew.equals(strDateOld)))
        		) {
            if ((prpPmainSchema.getOperateDate() + "").length() == 0) {
                strPtext = "投保日期变更为 "
                        + new DateTime(prpPmainSchema.getOperateDate(), DateTime.YEAR_TO_DAY) + ", ";
            } else {
                strPtext = "投保日期由 "
                        + new DateTime(prpCmainSchema.getOperateDate(), DateTime.YEAR_TO_DAY)
                        + " 变更为 "
                        + new DateTime(prpPmainSchema.getOperateDate(), DateTime.YEAR_TO_DAY) + ", ";
            }
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);

        }

		if ((prpCmainAgriDto.getRaiseDate()==null&&prpPmainAgriDto.getRaiseDate()!=null)
				||(prpCmainAgriDto.getRaiseDate()!=null&&prpPmainAgriDto.getRaiseDate()==null)
				||(prpCmainAgriDto.getRaiseDate()!=null&&prpPmainAgriDto.getRaiseDate()!=null&&!prpCmainAgriDto.getRaiseDate().equals(prpPmainAgriDto.getRaiseDate()))) {
        	String strCRaiseDate="";
        	String strPReiseDate="";
			if (prpCmainAgriDto.getRaiseDate()==null) {
				strCRaiseDate=" ";
			}else {
				strCRaiseDate=sdf.format(prpCmainAgriDto.getRaiseDate());
			}
			if (prpPmainAgriDto.getRaiseDate()==null) {
				strPReiseDate=" ";
			}else {
				strPReiseDate=sdf.format(prpPmainAgriDto.getRaiseDate());
			}
			if("31".equals(prpCmainAgriDto.getRiskCode().substring(0,2))){
				strPtext ="种植时间：";
				if(prpPmainAgriDto.getRaiseDate()!=null){
					strPtext+="由"+strPReiseDate;
				}
				strPtext +="修改为"+strCRaiseDate+",";
			}else {
				strPtext ="养殖时间：";
				if(prpPmainAgriDto.getRaiseDate()!=null){
					strPtext+="由"+strPReiseDate;
				}
				strPtext +="修改为"+strCRaiseDate+",";
			}
			intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
		}
        String strClassCodeNew = blPolicy.getPrpCmainDto().getClassCode();

        if ("3101,3107,3108,3114,3122,3126,3161".indexOf(riskCode) > -1) {
            PrpCmainAgriDto prpCmainAgriSchema = null;
            PrpPmainAgriDto prpPmainAgriSchema = null;
            prpCmainAgriSchema = blPolicy.getPrpCmainAgriDto();
            prpPmainAgriSchema = blEndorse.getPrpPmainAgriDto();
            if (null != prpCmainAgriSchema && null != prpPmainAgriSchema && !prpCmainAgriSchema.getRelationListNo()
                    .equals(prpPmainAgriSchema.getRelationListNo())) {
                if (prpPmainAgriSchema.getRelationListNo().length() == 0) {
                    strPtext = "分户清单关联号" + "变更为"
                            + prpCmainAgriSchema.getRelationListNo()
                            + ",";
                } else {
                    strPtext = "分户清单关联号" + "由"
                            + prpPmainAgriSchema.getRelationListNo()
                            + "变更为"
                            + prpCmainAgriSchema.getRelationListNo()
                            + ",";
                }
                intLineNo = setEndorseText(blEndorse,
                        strPtext, intLineNo, true);
            }
        }
        if (!prpCmainSchema.getThirdKnow().equals(prpPmainSchema.getThirdKnow())) {
			if(!(prpPmainSchema.getThirdKnow()+"").equals(prpCmainSchema.getThirdKnow()+"")){
				strPtext ="是否通过第三方识别：";
				if(prpPmainSchema.getThirdKnow()!=null&&"1".equals(prpPmainSchema.getThirdKnow())){
					strPtext+="由"+"是";
				}else if(prpPmainSchema.getThirdKnow()!=null&&"2".equals(prpPmainSchema.getThirdKnow())){
					strPtext+="由"+"否";
				}
				if(prpCmainSchema.getThirdKnow()!=null&&"1".equals(prpCmainSchema.getThirdKnow())){
					strPtext+="修改为"+"是";
				}else if(prpCmainSchema.getThirdKnow()!=null&&"2".equals(prpCmainSchema.getThirdKnow())){
					strPtext+="修改为"+"否";
				}
				intLineNo = this.setEndorseText(blEndorse, strPtext, intLineNo, true);
			}
        }
		if (!prpCmainSchema.getNotificationFlag().equals(blPolicyDtoOld.getPrpCmainDto().getNotificationFlag())) {
			if(!(blPolicyDtoOld.getPrpCmainDto().getNotificationFlag()+"").equals(prpCmainSchema.getNotificationFlag()+"")){
				strPtext ="是否承保公示：";
				if(blPolicyDtoOld.getPrpCmainDto().getNotificationFlag()!=null&&"1".equals(blPolicyDtoOld.getPrpCmainDto().getNotificationFlag())){
					strPtext+="由"+"是";
				}else if(blPolicyDtoOld.getPrpCmainDto().getNotificationFlag()!=null&&"2".equals(blPolicyDtoOld.getPrpCmainDto().getNotificationFlag())){
					strPtext+="由"+"否";
				}
				if(prpCmainSchema.getNotificationFlag()!=null&&"1".equals(prpCmainSchema.getNotificationFlag())){
					strPtext+="修改为"+"是";
				}else if(prpCmainSchema.getNotificationFlag()!=null&&"2".equals(prpCmainSchema.getNotificationFlag())){
					strPtext+="修改为"+"否";
				}
				intLineNo = this.setEndorseText(blEndorse, strPtext, intLineNo, true);
			}
		}
		if (!prpCmainSchema.getInceptionFlag().equals(blPolicyDtoOld.getPrpCmainDto().getInceptionFlag())) {
			if(!(blPolicyDtoOld.getPrpCmainDto().getInceptionFlag()+"").equals(prpCmainSchema.getInceptionFlag()+"")){
				strPtext ="是否验标：";
				if(blPolicyDtoOld.getPrpCmainDto().getInceptionFlag()!=null&&"1".equals(blPolicyDtoOld.getPrpCmainDto().getInceptionFlag())){
					strPtext+="由"+"是";
				}else if(blPolicyDtoOld.getPrpCmainDto().getInceptionFlag()!=null&&"2".equals(blPolicyDtoOld.getPrpCmainDto().getInceptionFlag())){
					strPtext+="由"+"否";
				}
				if(prpCmainSchema.getInceptionFlag()!=null&&"1".equals(prpCmainSchema.getInceptionFlag())){
					strPtext+="修改为"+"是";
				}else if(prpCmainSchema.getInceptionFlag()!=null&&"2".equals(prpCmainSchema.getInceptionFlag())){
					strPtext+="修改为"+"否";
				}
				intLineNo = this.setEndorseText(blEndorse, strPtext, intLineNo, true);
			}
		}
		if (!prpCmainSchema.getEccFlag().equals(blPolicyDtoOld.getPrpCmainDto().getEccFlag())) {
			if(!(blPolicyDtoOld.getPrpCmainDto().getEccFlag()+"").equals(prpCmainSchema.getEccFlag()+"")){
				strPtext ="是否扶贫项目：";
				if(blPolicyDtoOld.getPrpCmainDto().getEccFlag()!=null&&"1".equals(blPolicyDtoOld.getPrpCmainDto().getEccFlag())){
					strPtext+="由"+"是";
				}else if(blPolicyDtoOld.getPrpCmainDto().getEccFlag()!=null&&"2".equals(blPolicyDtoOld.getPrpCmainDto().getEccFlag())){
					strPtext+="由"+"否";
				}
				if(prpCmainSchema.getEccFlag()!=null&&"1".equals(prpCmainSchema.getEccFlag())){
					strPtext+="修改为"+"是";
				}else if(prpCmainSchema.getEccFlag()!=null&&"2".equals(prpCmainSchema.getEccFlag())){
					strPtext+="修改为"+"否";
				}
				intLineNo = this.setEndorseText(blEndorse, strPtext, intLineNo, true);
			}
		}
		String businessCateGroyNew="";
        String businessCateGroyOld="";
        Map<String,String> map=new HashMap<>();
		char[] groupFlagNew=prpCmainSchema.getGroupFlag().toCharArray();
        char[] groupFlagOld=blPolicyDtoOld.getPrpCmainDto().getGroupFlag().toCharArray();
        for(int i=0;i<groupFlagNew.length;i++){
            if(groupFlagNew[i]=='1'){
                map.put("codeType","BusinessCategory");
                map.put("codeCode",String.valueOf(i+1));
                List<PrpDcodeDto> list=prpDcodeApi.queryCodeInfoByTypeAndCode(map);
                businessCateGroyNew+=list.get(0).getCodeCName()+",";
            }
        }
        for(int i=0;i<groupFlagOld.length;i++){
            if(groupFlagOld[i]=='1'){
                map.put("codeType","BusinessCategory");
                map.put("codeCode",String.valueOf(i+1));
                List<PrpDcodeDto> list=prpDcodeApi.queryCodeInfoByTypeAndCode(map);
                businessCateGroyOld+=list.get(0).getCodeCName()+",";
            }
        }

		if(!prpCmainSchema.getGroupFlag().equals(blPolicyDtoOld.getPrpCmainDto().getGroupFlag())){
            strPtext = "业务大类由 "
                    + businessCateGroyOld
                    + " 变更为 "
                    + businessCateGroyNew;
            intLineNo = this.setEndorseText(blEndorse, strPtext, intLineNo, true);
        }
        if(!prpCmainSchema.getArgueSolution().equals(blPolicyDtoOld.getPrpCmainDto().getArgueSolution())){
			String argueSolutionNew="";
			String argueSolutionOld="";
			if("1".equals(prpCmainSchema.getArgueSolution())){
				argueSolutionNew="诉讼";
			}else {
				argueSolutionNew="仲裁";
			}
			if("1".equals(blPolicyDtoOld.getPrpCmainDto().getArgueSolution())){
				argueSolutionOld="诉讼";
			}else {
				argueSolutionOld="仲裁";
			}
			strPtext = "合同争议解决方法由 "
					+ argueSolutionOld
					+ " 变更为 "
					+ argueSolutionNew;
			intLineNo = this.setEndorseText(blEndorse, strPtext, intLineNo, true);
		}
        return intLineNo;
    }

    /**
     * 翻译代码
     *
     * @param iCodeType 代码类型
     * @param iCodeCode 代码
     * @param isChinese 中外文标识
     * @return 根据中外文标识返回中文或英文名称
     * @throw UserException, Exception
     */
    public String translateCode(String iCodeType, String iCodeCode, boolean isChinese) throws UserException, Exception {
        if (iCodeCode == null || iCodeCode.equals("")) {
            return ""; //代码空直接返回空字符串
        }
        PrpDcodeDto prpDcodeDto = prpDcodeApi.queryByPK(iCodeType, iCodeCode);
        if (isChinese) {
            return prpDcodeDto.getCodeCName();
        } else {
            if (prpDcodeDto.getCodeEName() == null || prpDcodeDto.getCodeEName().equals("")) {
                return prpDcodeDto.getCodeCName();
            } else {
                return prpDcodeDto.getCodeEName();
            }
        }
    }

    /**
     * STUB-ONLY：变更特别约定批文
     * <p>
     * 最新保单信息
     * 批改前信息
     *
     * @return 无
     * @throws UserException
     * @throws Exception
     */
    public int ptextForEngage(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                              int intLineNo) throws UserException, Exception {
        int i = 0;
        int iSerialNo = 0;
        PrpCengageDto prpCengageSchema = new PrpCengageDto();
        if(blPolicy.getPrpCengageDtoList()!=null) {
            for (i = 0; i < blPolicy.getPrpCengageDtoList().size(); i++) {
                prpCengageSchema = blPolicy.getPrpCengageDtoList().get(i);
                if (i == 0) {
                    iSerialNo = prpCengageSchema.getSerialNo();
                } else {
                    if (iSerialNo != prpCengageSchema
                            .getSerialNo()) {
                        iSerialNo = prpCengageSchema.getSerialNo();
                    } else {
                        continue;
                    }
                }
                if ((prpCengageSchema.getFlag().length() > 0) && (prpCengageSchema.getFlag().substring(0, 1).equals("I"))) {
                    intLineNo = this.ptextForEngageInsertDelete(blPolicy, "i",
                            blEndorse, iSerialNo, intLineNo, prpCengageSchema.getRiskCode());
                }
                if ((prpCengageSchema.getFlag().length() > 0) && (prpCengageSchema.getFlag().substring(0, 1).equals("D"))) {
                    intLineNo = this.ptextForEngageInsertDelete(blPolicy, "d",
                            blEndorse, iSerialNo, intLineNo, prpCengageSchema.getRiskCode());
                }
                if ((prpCengageSchema.getFlag().length() > 0) && (prpCengageSchema.getFlag().substring(0, 1).equals("U"))) {
                    intLineNo = this.ptextForEngageInsertDelete(blPolicy, "u",
                            blEndorse, iSerialNo, intLineNo, prpCengageSchema.getRiskCode());
                }
            }
        }
        return intLineNo;
    }

    /* 变更附加险条款，特约，免赔说明批文赋值信息
     *
	 */
    public int ptextForEngageInsertDelete(ResponseQueryPolicyInfoDto blPolicy, String strOption,
                                          BLEndorseDto blEndorse, int iSerialNo, int intLineNo, String riskcode)
            throws UserException, Exception {
        String strPtext = "";
        int i = 0;
        String oldClause = "";
        String newClause = "";
        for (int j = 0; j < blEndorse.getPrpPengageDtoList().size(); j++) {
            PrpPengageDto prpPengageSchema = blEndorse.getPrpPengageDtoList().get(j);
            if ((prpPengageSchema.getSerialNo() == iSerialNo)
                    && ("1".equals(prpPengageSchema.getTitleFlag()))
                    && ("TX".equals(prpPengageSchema.getClauseCode().substring(0, 2)))) {
                //找到原特约的名称
                oldClause = prpPengageSchema.getClauses();
                break;
            }
        }

        blEndorse.getPrpPengageDtoList().get(0).getClauses();
        PrpCengageDto prpCengageSchema = null;
        for (i = 0; i < blPolicy.getPrpCengageDtoList().size(); i++) {
            prpCengageSchema = blPolicy.getPrpCengageDtoList().get(i);
            if (prpCengageSchema.getSerialNo() == iSerialNo) {
                //找到匹配的engage
                if (("1".equals(prpCengageSchema.getTitleFlag()))) {
                    //找到标题
                    if ("TX".equals(prpCengageSchema.getClauseCode().substring(0, 2))) {
                        if (strOption.equals("i")) {
                            strPtext = "　　免赔说明变更为" + prpCengageSchema.getClauses();
                        } else {
                            strPtext = "　　免赔说明由" + oldClause + "变更为" + prpCengageSchema.getClauses();
                        }
                        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
                    } else {
                        strPtext = prpCengageSchema.getClauses();
                        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
                    }
                } else if ("0".equals(prpCengageSchema.getTitleFlag())) {
                    //找到内容
                    if (prpCengageSchema.getClauseCode().substring(0, 2).equals("TX")) {
                        //免赔
                        strPtext = "<<变更免赔说明>>";
                        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
                    } else {
                        //其他的
                        String clauseType = null;
                        if (prpCengageSchema.getClauseCode().length() == 3) {
                            clauseType = "收费条款内容信息";
                        } else if (prpCengageSchema.getClauseCode().startsWith("K")) {
                            clauseType = "不收费条款内容信息";
                        } else if (prpCengageSchema.getClauseCode().startsWith("F")) {
                            clauseType = "附加险条款内容信息";
                        } else if (prpCengageSchema.getClauseCode().substring(0, 1).equals("T")
                                && !prpCengageSchema.getClauseCode().substring(0, 2).equals("TX")) {
                            clauseType = "特约及附加信息";
                        }
                        String strOptionText = null;
                        if (strOption.equals("i")) {
                            strOptionText = "增加";
                        } else if (strOption.equals("u")) {
                            strOptionText = "变更";
                        } else if (strOption.equals("d")) {
                            strOptionText = "删除";
                        }
                        //例如" <<增加收费条款内容信息>>"
                        strPtext = " <<" + strOptionText + clauseType + ">>";
                        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
                    }
                } else {
                    throw new RuntimeException("no other types!");
                }
            }
        }
        return intLineNo;
    }

    /**
     * @return int intLineNo 行号
     * @throws UserException
     * @throws Exception
     * @desc 非车险保单注销的批文
     * blPolicy 最新保单信息
     * blEndorse 批单信息
     */
    public int ptextForAnnul(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                             int intLineNo) throws UserException, Exception {
        String strPtext = "";
        strPtext = "注销本保险单。";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        return intLineNo;
    }

    /**
     * STUB-ONLY：变更茬次信息（prpcitemkindagri）批文
     * <p>
     * 最新保单信息
     * 批改前信息
     *
     * @return 无
     * @throws UserException
     * @throws Exception
     */
    public int ptextForItemKindAgri(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                                    int intLineNo) throws UserException, Exception {
        int i = 0;
        PrpCitemKindAgriDto prpCitemKindAgri = new PrpCitemKindAgriDto();
        PrpPitemKindAgriDto prpPitemKindAgri = new PrpPitemKindAgriDto();
        int size = blEndorse.getPrpPitemKindAgriDtoList().size();
        if(blPolicy.getPrpCitemKindAgriDtoList()!=null) {
            for (i = 0; i < blPolicy.getPrpCitemKindAgriDtoList().size(); i++) {
                prpCitemKindAgri = blPolicy.getPrpCitemKindAgriDtoList().get(i);
                prpPitemKindAgri = blEndorse.getPrpPitemKindAgriDtoList().get(i);
                //茬次为0时，是主险、附加险的附加信息,不对其生成批文
                if (prpCitemKindAgri.getTimes().equals("0")) {
                    continue;
                }
                if ((blPolicy.getPrpCitemKindAgriDtoList().get(i).getFlag().length() > 0)
                        && (blPolicy.getPrpCitemKindAgriDtoList().get(i).getFlag().substring(0, 1).equals("I"))) {
                    intLineNo = this.ptextForItemKindAgriInsertDelete(prpCitemKindAgri, "i", blEndorse, intLineNo);
                }
                if ((blPolicy.getPrpCitemKindAgriDtoList().get(i).getFlag().length() > 0)
                        && (blPolicy.getPrpCitemKindAgriDtoList().get(i).getFlag().substring(0, 1).equals("D"))) {
                    intLineNo = this.ptextForItemKindAgriInsertDelete(prpCitemKindAgri, "d", blEndorse, intLineNo);
                }
                if ((blPolicy.getPrpCitemKindAgriDtoList().get(i).getFlag().length() > 0)
                        && (blPolicy.getPrpCitemKindAgriDtoList().get(i).getFlag().substring(0, 1).equals("U"))) {
                    //确保是相同的茬次
                    if (!prpCitemKindAgri.getTimes().equals(prpPitemKindAgri.getTimes())) {
                        for (int j = 0; j < blEndorse.getPrpPitemKindAgriDtoList().size(); j++) {
                            prpPitemKindAgri = blEndorse.getPrpPitemKindAgriDtoList().get(i);
                            if (prpCitemKindAgri.getTimes().equals(prpPitemKindAgri.getTimes())) {
                                break;
                            }
                        }
                    }
                    intLineNo = this.ptextForItemKindAgriUpdate(prpCitemKindAgri, prpPitemKindAgri, blEndorse, intLineNo);
                }
            }
        }
        return intLineNo;
    }

    /**
     * STUB-ONLY：增加/删除茬次信息（prpcitemkindagri）批文
     * <p>
     * 最新保单信息
     * 批改前信息
     *
     * @return 无
     * @throws UserException
     * @throws Exception
     */
    public int ptextForItemKindAgriInsertDelete(PrpCitemKindAgriDto iPrpCitemKindAgri,
                                                String strOption, BLEndorseDto blEndorse, int intLineNo)
            throws UserException, Exception {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        String strPtext = "";
        if (strOption.equals("i")) {
            strPtext = " <<增加茬次信息>>";
        }
        if (strOption.equals("d")) {
            strPtext = " <<删除茬次信息>>";
        }
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        strPtext = "茬次：" + iPrpCitemKindAgri.getTimes();
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        strPtext = "茬次起止日期：" + sdf.format(iPrpCitemKindAgri.getStratDate()) + "至" + sdf.format(iPrpCitemKindAgri.getEndDate());
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        strPtext = "保险金额分布比例：" + iPrpCitemKindAgri.getDistributingRate() + "%";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        strPtext = "茬次保险金额：" + iPrpCitemKindAgri.getTimesAmount();
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        return intLineNo;
    }

    /**
     * STUB-ONLY：变更茬次信息批文
     * <p>
     * 最新保单信息
     * 批改前信息
     *
     * @return 无
     * @throws UserException
     * @throws Exception
     */
    public int ptextForItemKindAgriUpdate(PrpCitemKindAgriDto iPrpCitemKindAgrichema,
                                          PrpPitemKindAgriDto iPrpPitemKindAgriSchema, BLEndorseDto blEndorse, int intLineNo)
            throws UserException, Exception {
        String strPtext = "";
        String strPdata = "";
        String strCdata = "";
        strPtext = " <<变更茬次信息>>";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        strPtext = "原第" + iPrpPitemKindAgriSchema.getTimes() + "茬次作如下变更：";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        strPtext = "";
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        if (!iPrpCitemKindAgrichema.getStratDate().equals(iPrpPitemKindAgriSchema.getStratDate())) {
            strPtext = "茬次起始日期由" + sdf.format(iPrpPitemKindAgriSchema.getStratDate()) + "变更为"
                    + sdf.format(iPrpCitemKindAgrichema.getStratDate()) + ",";
            intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        }

        if (!iPrpCitemKindAgrichema.getEndDate().equals(iPrpPitemKindAgriSchema.getEndDate())) {
            strPtext = "茬次终止日期由" + sdf.format(iPrpPitemKindAgriSchema.getEndDate()) + "变更为"
                    + sdf.format(iPrpCitemKindAgrichema.getEndDate()) + ",";
            intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        }

        if (!iPrpCitemKindAgrichema.getDistributingRate().equals(iPrpPitemKindAgriSchema.getDistributingRate())) {
            strPtext = "保险金额分布比例由" + iPrpPitemKindAgriSchema.getDistributingRate() + "% 变更为"
                    + iPrpCitemKindAgrichema.getDistributingRate() + "%,";
            intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        }

        if (!iPrpCitemKindAgrichema.getTimesAmount().equals(iPrpPitemKindAgriSchema.getTimesAmount())) {
            strPtext = "茬次保险金额由" + iPrpPitemKindAgriSchema.getTimesAmount() + "变更为"
                    + iPrpCitemKindAgrichema.getTimesAmount() + ",";
            intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        }
        return intLineNo;
    }

    /**
     * @return int intLineNo 行号
     * @throws UserException
     * @throws Exception     非车险的退保公式调整
     * @desc 非车险全单退保批文
     * BLPolicy
     * blPolicy 最新保单信息
     * BLEndorse
     * blEndorse 批单信息
     */
    public int ptextForUsualBack(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                                 int intLineNo) throws UserException, Exception {
        PrpCitemKindDto prpCitemKindSchema = new PrpCitemKindDto();
        PrpPitemKindDto prpPitemKindSchema = new PrpPitemKindDto();
        String strType = "";
        String strTypePremium = "";
        String strShortRateFlagName = "";
        String strPtext = "";
        double dblOldPremium = 0;//原保单保费
        double dblChgPremium = 0;//变化保费
        double dblShortRate = 0;//新短期费率
        int indexP = 0; // 批单的指针
        boolean isReturned = true; // 退费的标志  true 退费，false 收费
        if(blPolicy.getPrpCitemKindDtoList()!=null) {
            for (int i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
                prpCitemKindSchema = blPolicy.getPrpCitemKindDtoList().get(i);
                // 全单退保，正常情况下C对象有的P对象都有
                indexP = search(String.valueOf(prpCitemKindSchema.getItemKindNo()), blEndorse);
                prpPitemKindSchema = blEndorse.getPrpPitemKindDtoList().get(indexP);
                dblOldPremium = prpPitemKindSchema.getPremium();
                dblChgPremium = prpPitemKindSchema.getChgPremium();
                if (dblChgPremium == 0) {
                    continue;
                }
                dblShortRate = prpCitemKindSchema.getShortRate();
                if (dblChgPremium < 0) {
                    strType = "退";
                    isReturned = true;
                    dblChgPremium = dblChgPremium * (-1);
                } else {
                    strType = "收";
                    isReturned = false;
                }
                Map<String,String> riskCodemap = new HashMap<>();
                riskCodemap.put("riskCode",blPolicy.getPrpCmainDto().getRiskCode());
                PrpDriskDto dbPrpDrisk = prpdriskApi.queryByPK(riskCodemap);
                if (dbPrpDrisk.getRiskFlag().substring(0, 1).equals("2")) {
                    strTypePremium = "储金";
                } else {
                    strTypePremium = "保费";
                }
                if (prpCitemKindSchema.getShortRateFlag().equals("4")) {
                    strShortRateFlagName = "按月";
                } else if (prpCitemKindSchema.getShortRateFlag().equals("2")) {
                    strShortRateFlagName = "按日";
                } else if (prpCitemKindSchema.getShortRateFlag().equals("1")) {
                    strShortRateFlagName = "按短期费率表";
                } else if (prpCitemKindSchema.getShortRateFlag().equals("3")) {
                    strShortRateFlagName = "全额退保";
                }
                strPtext = "险别名称：" + prpCitemKindSchema.getKindName();
                intLineNo = setEndorseText(blEndorse, strPtext,
                        intLineNo, true);
                // reason：有的险种没有往ItemDetailName字段存信息
                if (prpCitemKindSchema.getItemDetailName().trim().length() > 0) {
                    strPtext = "项目：" + prpCitemKindSchema.getItemDetailName();
                    intLineNo = setEndorseText(blEndorse, strPtext,
                            intLineNo, true);
                }
                strPtext = "计算公式如下：";
                intLineNo = setEndorseText(blEndorse, strPtext,
                        intLineNo, true);
                // 批改后保费=原保费*新短期系数/原短期系数
                // 如果收取手续费  应退保费=原保费*(1-批改按短期费率表短期系数%/原短期系数%)*(1-退保手续费比例)
                // 收费  保费变化量=原保费*(新短期系数/原短期系数-1)
                // 退费  保费变化量=原保费*(1-新短期系数/原短期系数)
                //0401 退保公式 应退保费 = 原保险费—短期保费=原保险费 - 原保险金额×趸缴费率×短期费率系数×实际承保期限/12
                if (isReturned) {
                    strPtext = "应" + strType + strTypePremium + "="
                            + "原" + strTypePremium + "*" + "(1-批改"
                            + strShortRateFlagName + "短期系数%" + "/"
                            + "原短期系数%)";
                } else {
                    strPtext = "应" + strType + strTypePremium + "="
                            + "原" + strTypePremium + "*" + "(批改"
                            + strShortRateFlagName + "短期系数%" + "/"
                            + "原短期系数%-1)";
                }
                intLineNo = setEndorseText(blEndorse, strPtext,
                        intLineNo, true);
                if (isReturned) {

                    strPtext = "=" + round(dblOldPremium, 2) + "*"
                            + "(1-" + round(dblShortRate, 4) + "%" + "/"
                            + round(Double.parseDouble(prpPitemKindSchema.getShortRate() + ""), 4)
                            + "%)" + "=" + round(dblChgPremium, 2);
                } else {
                    strPtext = "="
                            + round(dblOldPremium, 2) + "*" + "(" + round(dblShortRate, 2) + "%" + "/"
                            + round(Double.parseDouble(prpPitemKindSchema.getShortRate() + ""), 4)
                            + "%-1)" + "=" + round(dblChgPremium, 2);
                }
                intLineNo = setEndorseText(blEndorse, strPtext,
                        intLineNo, true);
            }
        }
        return intLineNo;
    }

    /**
     * 根据险别序号寻找下标
     * <p>
     * 险别序号
     *
     * @return 下标
     */
    public int search(String iItemKindNo, BLEndorseDto blEndorse) throws Exception {
        int icurr = 0;
        int iFindFlag = 0;
        for (int i = 0; i < blEndorse.getPrpPitemKindDtoList().size(); i++) {
            if ((blEndorse.getPrpPitemKindDtoList().get(i).getItemKindNo() + "").trim().equals(iItemKindNo)) {
                icurr = i;
                iFindFlag = 1;
            }
        }
        if (iFindFlag == 0) {
            icurr = -1;
        }
        return icurr;
    }

    /**
     * @return int intLineNo 行号
     * @throws UserException
     * @throws Exception
     * @desc 非车险变更标的批文
     * blPolicy 最新保单信息
     * blEndorse 批单信息
     */
    public int ptextForUsualItemKind(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                                     int intLineNo) throws UserException, Exception {
        PrpCitemKindDto prpCitemKindSchema = new PrpCitemKindDto();
        PrpPitemKindDto prpPitemKindSchema = new PrpPitemKindDto();
        // add by guolei 增加农险附加信息批文
        PrpCitemKindAgriDto prpCitemKindAgriSchema = new PrpCitemKindAgriDto();
        PrpPitemKindAgriDto prpPitemKindAgriSchema = new PrpPitemKindAgriDto();
        PrpCsubsidyDto prpCsubsidySchema = new PrpCsubsidyDto();
        PrpPsubsidyDto prpPsubsidySchema = new PrpPsubsidyDto();
        PubTools pubTools = new PubTools();
        
        // add by guolei 增加农险附加信息批文
        List<PrpXpColDto> blPrpXPcolDto = new ArrayList<>();
        List<PrpXpCol> blPrpXPcol = new ArrayList<>();
        String strClassCode = "";
        String strRiskCode = "";
        String strCalculator = "";
        String strKindNameString = "";
        String strItemDetailName = "";
        String strColCname = "";
        String strColname = "";
        String strCdata = "";
        String strPdata = "";
        String strType2 = "";
        String labelChgAmount = "";//控制保额变化量的显示,默认为空
        String labelChgRate = "";//控制费率变化量的显示,默认为空
        String labelChgPremium = "";//控制保费变化量的显示，默认为空
        String strPtext = "";
        String strPtextPart11 = "";
        double dblOldRate = 0;
        double dblAmount = 0;
        double dblShortRate = 0;
        double dblShortRateOld = 0;
        double dblChgAmount = 0;
        double dblChgRate = 0;
        double dblChgPremium = 0;
        double dblChgPremiumTotal = 0;
        int intCounterI = 0;
        int intCounterU = 0;
        int intCounterB = 0;
        int indexP = 0;
        int i = 0;
        int j = 0;
        strClassCode = blPolicy.getPrpCmainDto().getClassCode();
        strRiskCode = blPolicy.getPrpCmainDto().getRiskCode();
        String strType1 = "";
        //todo prpdriskApi查询写死
        Map<String,String> riskCodemap = new HashMap<>();
        riskCodemap.put("riskCode",strRiskCode);
       PrpDriskDto prpDriskDto=prpdriskApi.queryByPK(riskCodemap);
        strCalculator = String.valueOf(prpDriskDto.getCalculator());
        strCalculator="100";
        if (strCalculator.equals("100")) {
            strCalculator = "%";
        } else if (strCalculator.equals("1000")) {
            strCalculator = "‰";
        }
        // 加政府补贴的批文
        String SubsidyName = "";
        if(blPolicy.getPrpCsubsidyDtoList()!=null ) {
			for (i = 0; i < blPolicy.getPrpCsubsidyDtoList().size(); i++) {
				if (StringUtils.isNotEmpty(blPolicy.getPrpCsubsidyDtoList().get(i).getOperationFlag())
						&& blPolicy.getPrpCsubsidyDtoList().get(i).getOperationFlag().substring(0, 1).equals("U")) {
					prpCsubsidySchema = blPolicy.getPrpCsubsidyDtoList().get(i);
					prpPsubsidySchema = blEndorse.getPrpPsubsidyDtoList().get(i);
					pubTools.convertNullToDef(prpCsubsidySchema);
					pubTools.convertNullToDef(prpPsubsidySchema);
					strPtext = " <<变更补贴信息>>";
					intLineNo = setEndorseText(blEndorse, strPtext,
							intLineNo, true);
					if (prpCsubsidySchema.getSubsidyCode().equals("03")) {
						SubsidyName = "中央财政补贴 ";
					} else if (prpCsubsidySchema.getSubsidyCode().equals("04")) {
						SubsidyName = "省级财政 ";
					} else if (prpCsubsidySchema.getSubsidyCode().equals("05")) {
						SubsidyName = "地市财政 ";
					} else if (prpCsubsidySchema.getSubsidyCode().equals("07")) {
						SubsidyName = "县(区)财政 ";
					} else
						SubsidyName = "其它补贴 ";

					if (round(Double.parseDouble(chgStrZero(prpCsubsidySchema.getSubsidyPremium() + "")), 2) !=
							round(Double.parseDouble(chgStrZero(prpPsubsidySchema.getSubsidyPremium() + "")), 2)) {
						strPtext = SubsidyName + "补贴金额由"
								+ prpPsubsidySchema.getSubsidyPremium() + "元，变更为"
								+ prpCsubsidySchema.getSubsidyPremium() + "元";
						intLineNo = setEndorseText(blEndorse, strPtext,
								intLineNo, true);
					}
					if (!prpCsubsidySchema.getSubsidyRate().equals(
							prpPsubsidySchema.getSubsidyRate())) {
						strPtext = SubsidyName + "补贴比例由"
								+ prpPsubsidySchema.getSubsidyRate() + "%,变更为"
								+ prpCsubsidySchema.getSubsidyRate() + "%";
						intLineNo = setEndorseText(blEndorse, strPtext,
								intLineNo, true);
					}
					if (!prpCsubsidySchema.getSubsidyDepartment().equals(
							prpPsubsidySchema.getSubsidyDepartment())) {
						strPtext = SubsidyName + "补贴机构由"
								+ prpPsubsidySchema.getSubsidyDepartment() + "变更为"
								+ prpCsubsidySchema.getSubsidyDepartment();
						intLineNo = setEndorseText(blEndorse, strPtext,
								intLineNo, true);
					}
				}
			}
		}
        if(blPolicy.getPrpCsubsidyDtoList()!=null ) {
            for (i = 0; i < blPolicy.getPrpCsubsidyDtoList().size(); i++) {
                if (StringUtils.isNotEmpty(blPolicy.getPrpCsubsidyDtoList().get(i).getOperationFlag())
                         && blPolicy.getPrpCsubsidyDtoList().get(i).getOperationFlag().substring(0, 1).equals("I")) {
                    prpCsubsidySchema = blPolicy.getPrpCsubsidyDtoList().get(i);
                    prpPsubsidySchema = blEndorse.getPrpPsubsidyDtoList().get(i);
                    pubTools.convertNullToDef(prpCsubsidySchema);
                    pubTools.convertNullToDef(prpPsubsidySchema);
                    strPtext = " <<增加补贴信息>>";
                    intLineNo = setEndorseText(blEndorse, strPtext,
                            intLineNo, true);
                    if (prpCsubsidySchema.getSubsidyCode().equals("03")) {
                        SubsidyName = "中央财政补贴 ";
                    } else if (prpCsubsidySchema.getSubsidyCode().equals("04")) {
                        SubsidyName = "省级财政 ";
                    } else if (prpCsubsidySchema.getSubsidyCode().equals("05")) {
                        SubsidyName = "地市县财政 ";
                    } else
                        SubsidyName = "其它补贴 ";
                    strPtext = "补贴类型为:" + SubsidyName + "，补贴金额为："
                            + prpCsubsidySchema.getCurrency()
                            + prpCsubsidySchema.getSubsidyPremium() + "元，"
                            + "补贴比例为:"
                            + prpCsubsidySchema.getSubsidyRate() + "%"
                            + "，补贴机构为:"
                            + prpCsubsidySchema.getSubsidyDepartment();
                    intLineNo = setEndorseText(blEndorse, strPtext,
                            intLineNo, true);
                }
            }
        }
        if( blPolicy.getPrpCsubsidyDtoList()!=null) {
            for (i = 0; i < blPolicy.getPrpCsubsidyDtoList().size(); i++) {
                if (StringUtils.isNotEmpty(blPolicy.getPrpCsubsidyDtoList().get(i).getOperationFlag())
				    && blPolicy.getPrpCsubsidyDtoList().get(i).getOperationFlag().substring(0, 1).equals("D")) {
                    prpCsubsidySchema = blPolicy.getPrpCsubsidyDtoList().get(i);
                    prpPsubsidySchema = blEndorse.getPrpPsubsidyDtoList().get(i);
                    pubTools.convertNullToDef(prpCsubsidySchema);
                    pubTools.convertNullToDef(prpPsubsidySchema);
                    strPtext = " <<删除补贴信息>>";
                    intLineNo = setEndorseText(blEndorse, strPtext,
                            intLineNo, true);
                    if (prpCsubsidySchema.getSubsidyCode().equals("03")) {
                        SubsidyName = "中央财政补贴 ";
                    } else if (prpCsubsidySchema.getSubsidyCode().equals("04")) {
                        SubsidyName = "省级财政 ";
                    } else if (prpCsubsidySchema.getSubsidyCode().equals("05")) {
                        SubsidyName = "地市县财政 ";
                    } else
                        SubsidyName = "其它补贴 ";
                    strPtext = "补贴类型为:" + SubsidyName + "，补贴金额为："
                            + prpPsubsidySchema.getCurrency()
                            + "-" + prpPsubsidySchema.getSubsidyPremium() + "元，"
                            + "补贴比例为:"
                            + prpPsubsidySchema.getSubsidyRate() + "%"
                            + "，补贴机构为:"
                            + prpPsubsidySchema.getSubsidyDepartment();
                    intLineNo = setEndorseText(blEndorse, strPtext,
                            intLineNo, true);
                }
            }
        }
        /***********************************************增加标的批文生成*******************************/
        if( blPolicy.getPrpCitemKindDtoList()!=null) {
            for (i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
                if (StringUtils.isNotEmpty(blPolicy.getPrpCitemKindDtoList().get(i).getFlag())
                        && blPolicy.getPrpCitemKindDtoList().get(i).getFlag().substring(0, 1).equals("I")) {
                    prpCitemKindSchema = blPolicy.getPrpCitemKindDtoList().get(i);
                /* ：如果是加保的虚拟标的不生成批文 */
                    if (blPolicy.getPrpCitemKindDtoList().get(i).getItemCode().equals("0000")) {
                        continue;
                    }
                    intCounterI = intCounterI + 1;
                    if (prpCitemKindSchema.getItemDetailName().trim().length() > 0) {
                        if ("I2".equals(prpCitemKindSchema.getFlag())) {
                            strKindNameString = strKindNameString + "“" + prpCitemKindSchema.getKindName() + "”" + " ";
                        } else {
                            strKindNameString = strKindNameString + "“" + prpCitemKindSchema.getItemDetailName() + "”" + " ";
                        }

                    } else {
                        strKindNameString = strKindNameString + prpCitemKindSchema.getKindName() + "、";
                    }
                    // 汇总加保保费变化量
                    dblChgPremiumTotal = dblChgPremiumTotal
                            + Double.parseDouble(chgStrZero(prpCitemKindSchema.getPremium() + ""));
                }
            }
        }
        // 输出批改公式
        if (intCounterI > 0) {
            strPtext = " <<增加标的/保险责任>>";
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
            if (strKindNameString.trim().length() > 0) {
                strKindNameString = strKindNameString.substring(0,
                        strKindNameString.length() - 1);
            }
            strPtext = "    增加标/保险责任的名称为： " + "" + strKindNameString
                    + "    共加收保费"
                    + round(dblChgPremiumTotal, 2)
                    + "元整";
            ;
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
            strPtext = "加收保费计算公式如下：";
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
            /*	国元的保费计算公式调整为：
			 * 保费变化量=保额*费率*批改短期系数(%)
			 */
            strPtext = "    加收保费=新保额" + "*" + "费率"
                    + strCalculator + "*" + "批改短期系数%";
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }
        //具体的保费计算方式
        if(blPolicy.getPrpCitemKindDtoList()!=null) {
            for (i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
                if (StringUtils.isNotEmpty(blPolicy.getPrpCitemKindDtoList().get(i).getFlag())
                        && blPolicy.getPrpCitemKindDtoList().get(i).getFlag().substring(0, 1).equals("I")) {
                    prpCitemKindSchema = blPolicy.getPrpCitemKindDtoList().get(i);
                    //如果是加保的虚拟标的不生成批文
                    if (prpCitemKindSchema.getItemCode().equals("0000")) {
                        continue;
                    }
                    if ("I1".equals(prpCitemKindSchema.getFlag())) {
                        strPtext = "" + prpCitemKindSchema.getKindName().trim()
                                + "下的标的"
                                + prpCitemKindSchema.getItemDetailName().trim();
                    } else {
                        strPtext = "" + prpCitemKindSchema.getKindName().trim();
                    }
                    strPtext = strPtext
                            + "加收保费="
                            + chgStrZero(prpCitemKindSchema.getAmount() + "")
                            + "*"
                            + chgStrZero(prpCitemKindSchema.getRate() + "")
                            + strCalculator
                            + "*"
                            + round(Double
                            .parseDouble(chgStrZero(prpCitemKindSchema.getShortRate() + "")), 4)
                            + "%"
                            + "="
                            + round(Double
                            .parseDouble(chgStrZero(prpCitemKindSchema
                                    .getPremium() + "")), 2);

                    intLineNo = setEndorseText(blEndorse, strPtext,
                            intLineNo, true);
                }

            }
        }
        /********************************************增加标的批文生成结束********************************/

        /*************************************************变更标的批文生成开始***************************/
        dblChgPremiumTotal = 0;
        strKindNameString = "";
        if(blPolicy.getPrpCitemKindDtoList()!=null) {
            for (i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
                if (StringUtils.isNotEmpty(blPolicy.getPrpCitemKindDtoList().get(i).getFlag())
                        && blPolicy.getPrpCitemKindDtoList().get(i).getFlag().substring(0, 1).equals("U")) {
				/* ：如果是加保的虚拟标的不生成批文 */
                    if (blPolicy.getPrpCitemKindDtoList().get(i).getItemCode().equals("0000")) {
                        continue;
                    }
                    intCounterU = intCounterU + 1;
                    indexP = search(blPolicy.getPrpCitemKindDtoList().get(i).getItemKindNo() + "", blEndorse);
                    // 增加下标校验
                    if (indexP == -1) {
                        throw new Exception(
                                "找不到此条标的,itemkindNo:" + blPolicy.getPrpCitemKindDtoList().get(i).getItemKindNo());
                    }
                    // 增加下标校验
                    prpPitemKindSchema = blEndorse.getPrpPitemKindDtoList().get(indexP);
                    dblChgPremiumTotal = dblChgPremiumTotal + Double.parseDouble(chgStrZero(prpPitemKindSchema.getChgPremium() + ""));
                }
            }
        }
        if (intCounterU > 0) {
            strPtext = "<<变更标的/保险责任>>";
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }
        if (strClassCode.equals("31") || strClassCode.equals("32")) {
            String str = " select * from PrpXpCol  p where  p.riskCode = '" + blPolicy.getPrpCmainDto().getRiskCode()
                    + "' and (p.tableName='prpcitemkind' or p.tableName='prpcitemkindagri')";
            Query nativeQuery = entityManager.createNativeQuery(str.toString(), PrpXpCol.class);
            blPrpXPcol = nativeQuery.getResultList();
            convertCollection(blPrpXPcol,blPrpXPcolDto,PrpXpColDto.class);
        }
        if(blPolicy.getPrpCitemKindDtoList()!=null) {
            for (i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
                prpCitemKindSchema = blPolicy.getPrpCitemKindDtoList().get(i);
                //农险要多出prpCitemKindAgriSchema表的数据
                if (strClassCode.equals("31") || strClassCode.equals("32")) {
                    prpCitemKindAgriSchema = blPolicy.getPrpCitemKindAgriDtoList().get(i);
                    pubTools.convertNullToDef(prpCitemKindAgriSchema);
                }
			/*如果是加保的虚拟标的不生成批文 */
                if (prpCitemKindSchema.getItemCode().equals("0000")) {
                    continue;
                }
                if (StringUtils.isNotEmpty(prpCitemKindSchema.getFlag()) && prpCitemKindSchema.getFlag().substring(0, 1).equals("U")) {

                    indexP = search(
                            prpCitemKindSchema.getItemKindNo() + "", blEndorse);
                    prpPitemKindSchema = blEndorse.getPrpPitemKindDtoList().get(indexP);
                    pubTools.convertNullToDef(prpCitemKindSchema);
                    pubTools.convertNullToDef(prpPitemKindSchema);

                    if (strClassCode.equals("31") || strClassCode.equals("32")) {
                        prpPitemKindAgriSchema = blEndorse.getPrpPitemKindAgriDtoList().get(indexP);
                        pubTools.convertNullToDef(prpPitemKindAgriSchema);
                    }
                    // ItemCode发生改变，要单显示一行
                    if (!prpCitemKindSchema.getItemCode().equals(
                            prpPitemKindSchema.getItemCode())) {
                        if ("U2".equals(prpCitemKindSchema.getFlag())) {
                            strKindNameString = "变更标的/保险责任名称为："
                                    + prpPitemKindSchema.getKindName() + "";
                        } else {
                            strKindNameString = "变更标的/保险责任名称为："
                                    + prpCitemKindSchema.getItemDetailName() + "";
                        }
                        intLineNo = setEndorseText(blEndorse,
                                strKindNameString, intLineNo, true);
                    }
                    for (j = 0; j < blPrpXPcolDto.size(); j++) {
                        PrpXpColDto prpXPcolSchema = blPrpXPcolDto.get(j);
                        strColname = prpXPcolSchema.getColName();
                        strColCname = prpXPcolSchema.getColCName();
                        // ItemCode 标的类别
                        if (strColname.equals("itemcode")) {
                            if (!prpCitemKindSchema.getItemCode().equals(prpPitemKindSchema.getItemCode())) {
                                //
                                PrpDitemDto prpDitemDto1 = prpDitemApi.queryByPK(prpCitemKindSchema.getRiskCode(), prpCitemKindSchema.getItemCode());
                                if (blPolicy.getPrpCmainDto().getLanguage().equals("C")) {
                                    strCdata = prpDitemDto1.getItemCName();
                                } else {
                                    strCdata = prpDitemDto1.getItemEName();
                                }
                                if ((prpPitemKindSchema.getItemCode() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为" + strCdata + "，";
                                } else {
                                    PrpDitemDto prpDitemDto2 = prpDitemApi.queryByPK(prpPitemKindSchema.getRiskCode(), prpPitemKindSchema.getItemCode());
                                    if (blPolicy.getPrpCmainDto().getLanguage().equals("C")) {
                                        strPdata = prpDitemDto2.getItemCName();
                                    } else {
                                        strPdata = prpDitemDto2.getItemEName();
                                    }
                                    strKindNameString = "" + strColCname + "由"
                                            + strPdata + "变更为" + strCdata + "，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // AddressNo 地址序号
                        if (strColname.equals("addressno")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindSchema.getAddressNo() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindSchema.getAddressNo() + ""))) {
                                if ((prpPitemKindSchema.getAddressNo() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getAddressNo()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpPitemKindSchema.getAddressNo()
                                            + "变更为"
                                            + prpCitemKindSchema.getAddressNo()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse, strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // ModeName 投保方式
                        if (strColname.equals("modename")) {
                            if (!prpCitemKindSchema.getModeCode().equals(
                                    prpPitemKindSchema.getModeCode())) {
                                if (prpPitemKindSchema.getModeCode().length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getModeName()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpPitemKindSchema.getModeName()
                                            + "变更为"
                                            + prpCitemKindSchema.getModeName()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse, strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // KindCode  险别代码
                        if (strColname.equals("kindcode")) {
                            if (!prpCitemKindSchema.getKindCode().equals(
                                    prpPitemKindSchema.getKindCode())) {
                                if (prpPitemKindSchema.getKindCode().length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getKindCode()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname
                                            + "由"
                                            + prpPitemKindSchema.getKindCode()
                                            + "变更为"
                                            + prpCitemKindSchema.getKindCode()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse, strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // kindname 险别名称
                        if (strColname.equals("kindname")) {
                            if (!prpCitemKindSchema.getKindCode().equals(
                                    prpPitemKindSchema.getKindCode())) {
                                if (prpPitemKindSchema.getKindCode().length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getKindName()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname
                                            + "由"
                                            + prpPitemKindSchema.getKindName()
                                            + "变更为"
                                            + prpCitemKindSchema.getKindName()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse, strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // UnitAmount 单位保额
                        if (strColname.equals("unitamount")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindSchema.getUnitAmount() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindSchema.getUnitAmount() + ""))) {
                                if ((prpPitemKindSchema.getUnitAmount() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpCitemKindSchema.getUnitAmount()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpPitemKindSchema.getUnitAmount()
                                            + "变更为"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpCitemKindSchema.getUnitAmount()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        //短期计算方式
						Map<String,String> map=new HashMap<>();
						Map<String,String> map1=new HashMap<>();
						List<String> list=new ArrayList<>();
						List<String> list1=new ArrayList<>();
						list.add(prpPitemKindSchema.getShortRateFlag());
						list1.add(prpCitemKindSchema.getShortRateFlag());
						map=prpDcodeApi.queryShortRateFlagByCodes(list);
						map1=prpDcodeApi.queryShortRateFlagByCodes(list1);
						String shortRateFlagNameP=map.get(prpPitemKindSchema.getShortRateFlag());
						String shortRateFlagNameC=map1.get(prpCitemKindSchema.getShortRateFlag());
                        if(strColname.equals("shortrateflag")) {
                        	if (!prpCitemKindSchema.getShortRateFlag().equals(
                                    prpPitemKindSchema.getShortRateFlag())) {
                                if (prpPitemKindSchema.getShortRateFlag().length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + shortRateFlagNameC
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname
                                            + "由"
                                            + shortRateFlagNameP
                                            + "变更为"
                                            + shortRateFlagNameC
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse, strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        //每次事故免赔率
                        if(strColname.equals("deductiblerate")) {
                        	if (Double.parseDouble(chgStrZero(prpCitemKindSchema.getDeductibleRate() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindSchema.getDeductibleRate() + ""))) {
                                if ((prpPitemKindSchema.getDeductibleRate() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getDeductibleRate()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpPitemKindSchema.getDeductibleRate()
                                            + "变更为"
                                            + prpCitemKindSchema.getDeductibleRate()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse, strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        
                       //起赔点
                        if(strColname.equals("triggerpoint")) {
                        	if (Double.parseDouble(chgStrZero(prpCitemKindSchema.getTriggerPoint()+ "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindSchema.getTriggerPoint() + ""))) {
                                if ((prpPitemKindSchema.getTriggerPoint() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getTriggerPoint()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpPitemKindSchema.getTriggerPoint()
                                            + "变更为"
                                            + prpCitemKindSchema.getTriggerPoint()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse, strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        
                        //全损损失率
                        if(strColname.equals("totallossratio")) {
                        	if (Double.parseDouble(chgStrZero(prpCitemKindSchema.getTotalLossRatio()+ "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindSchema.getTotalLossRatio() + ""))) {
                                if ((prpPitemKindSchema.getTotalLossRatio() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getTotalLossRatio()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpPitemKindSchema.getTotalLossRatio()
                                            + "变更为"
                                            + prpCitemKindSchema.getTotalLossRatio()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse, strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // Quantity
                        if (strColname.equals("quantity")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindSchema.getQuantity() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindSchema.getQuantity() + ""))) {
                                if ((prpPitemKindSchema.getQuantity() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getQuantity()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpPitemKindSchema.getQuantity()
                                            + "变更为"
                                            + prpCitemKindSchema.getQuantity()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse, strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // Amount
                        if (strColname.equals("amount")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindSchema.getAmount() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindSchema.getAmount() + ""))) {
                                if ((prpPitemKindSchema.getAmount() + "").length() == 0) {
                                    // 批文体现币种
                                    strKindNameString = "    "
                                            + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpCitemKindSchema.getAmount() + "，";
                                } else {
                                    strKindNameString = "    "
                                            + strColCname
                                            + "由"
                                            + prpPitemKindSchema.getCurrency()
                                            + prpPitemKindSchema.getAmount()
                                            + "变更为"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpCitemKindSchema.getAmount() + "，";
                                }
                                intLineNo = setEndorseText(blEndorse, strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // 标的价值
                        if (strColname.equals("value")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindSchema.getValue() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindSchema.getValue() + ""))) {
                                if ((prpPitemKindSchema.getValue() + "").length() == 0) {
                                    // 批文体现币种
                                    strKindNameString = ""
                                            + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpCitemKindSchema.getValue() + "，";
                                } else {
                                    strKindNameString = "    "
                                            + strColCname
                                            + "由"
                                            + prpPitemKindSchema.getCurrency()
                                            + prpPitemKindSchema.getValue()
                                            + "变更为"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpCitemKindSchema.getValue() + "，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // 免赔额
                        if (strColname.equals("deductible")) {
                            if (Double
                                    .parseDouble(chgStrZero(prpCitemKindSchema.getDeductible() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindSchema.getDeductible() + ""))) {
                                if ((prpPitemKindSchema.getDeductible() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getDeductible()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpPitemKindSchema.getDeductible()
                                            + "变更为"
                                            + prpCitemKindSchema.getDeductible()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // Rate
                        if (strColname.equals("rate")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindSchema.getRate() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindSchema.getRate() + ""))) {
                                if ((prpPitemKindSchema.getRate() + "").length() == 0) {
                                    strKindNameString = "    " + strColCname
                                            + "变更为" + prpCitemKindSchema.getRate()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpPitemKindSchema.getRate() + "变更为"
                                            + prpCitemKindSchema.getRate() + "，";

                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // FamilyName
                        if (strColname.equals("familyname")) {
                            if (!prpCitemKindSchema.getFamilyName().equals(
                                    prpPitemKindSchema.getFamilyName())) {
                                if ((prpPitemKindSchema.getFamilyName() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getFamilyName()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpPitemKindSchema.getFamilyName()
                                            + "变更为"
                                            + prpCitemKindSchema.getFamilyName()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // Model
                        if (strColname.equals("model")) {
                            if (!prpCitemKindSchema.getModel().equals(
                                    prpPitemKindSchema.getModel())) {
                                if ((prpPitemKindSchema.getModel() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为" + prpCitemKindSchema.getModel()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpPitemKindSchema.getModel() + "变更为"
                                            + prpCitemKindSchema.getModel() + "，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // 标的明细名称
                        if (strColname.equals("itemdetailname")) {
                            if (!prpCitemKindSchema.getItemDetailName().equals(
                                    prpPitemKindSchema.getItemDetailName())) {
                                if (prpPitemKindSchema.getItemDetailName().length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为" + prpCitemKindSchema.getModel()
                                            + "，";
                                } else {
                                    strKindNameString = ""
                                            + strColCname
                                            + "由"
                                            + prpPitemKindSchema
                                            .getItemDetailName()
                                            + "变更为"
                                            + prpCitemKindSchema
                                            .getItemDetailName() + "，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // 单位产量
                        if (strColname.equals("unitoutput")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindAgriSchema.getUnitOutput() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindAgriSchema.getUnitOutput() + ""))) {
                                if ((prpPitemKindAgriSchema.getUnitOutput() + "").length() == 0) {
                                    strKindNameString = ""
                                            + strColCname
                                            + "公斤/尾/头 ，变更为"
                                            + prpCitemKindAgriSchema
                                            .getUnitOutput() + "，";
                                } else {
                                    strKindNameString = ""
                                            + strColCname
                                            + "由"
                                            + prpPitemKindAgriSchema
                                            .getUnitOutput()
                                            + "变更为"
                                            + prpCitemKindAgriSchema
                                            .getUnitOutput() + "公斤/尾/头 ，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        //单位成本
                        if (strColname.equals("unitcost")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindAgriSchema.getUnitCost() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindAgriSchema.getUnitCost() + ""))) {
                                if ((prpPitemKindAgriSchema.getUnitCost() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpCitemKindAgriSchema.getUnitCost()
                                            + "元，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpPitemKindAgriSchema.getUnitCost()
                                            + "元，变更为"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpCitemKindAgriSchema.getUnitCost()
                                            + "元，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        if (strColname.equals("proportion")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindAgriSchema.getProportion() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindAgriSchema.getProportion() + ""))) {
                                if (prpPitemKindAgriSchema.getProportion() + "".length() == 0) {
                                    strKindNameString = "    "
                                            + strColCname
                                            + "变更为"
                                            + prpCitemKindAgriSchema
                                            .getProportion() + "，";
                                } else {
                                    strKindNameString = "    "
                                            + strColCname
                                            + "由"
                                            + prpPitemKindAgriSchema
                                            .getProportion()
                                            + "变更为"
                                            + prpCitemKindAgriSchema
                                            .getProportion() + "，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        if (strColname.equals("depreciationrate")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindAgriSchema.getDepreciationRate() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindAgriSchema.getDepreciationRate() + ""))) {
                                if ((prpPitemKindAgriSchema.getDepreciationRate() + "").length() == 0) {
                                    strKindNameString = ""
                                            + strColCname
                                            + "变更为"
                                            + prpCitemKindAgriSchema
                                            .getDepreciationRate() + "%，";
                                } else {
                                    strKindNameString = ""
                                            + strColCname
                                            + "由"
                                            + prpPitemKindAgriSchema
                                            .getDepreciationRate()
                                            + "%,变更为"
                                            + prpCitemKindAgriSchema
                                            .getDepreciationRate() + "%，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        if (strColname.equals("agriunitamount")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindAgriSchema.getUnitAmount() + "")) != Double
                                    .parseDouble(chgStrZero(prpPitemKindAgriSchema.getUnitAmount() + ""))) {
                                if ((prpPitemKindAgriSchema.getUnitAmount() + "").length() == 0) {
                                    strKindNameString = ""
                                            + strColCname
                                            + "元，变更为"
                                            + prpCitemKindAgriSchema
                                            .getUnitAmount() + "元，";
                                } else {
                                    strKindNameString = ""
                                            + strColCname
                                            + "由"
                                            + prpPitemKindAgriSchema
                                            .getUnitAmount()
                                            + "元，变更为"
                                            + prpCitemKindAgriSchema
                                            .getUnitAmount() + "元，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        //约定单价
                        if (strColname.equals("timesamount")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindAgriSchema.getTimesAmount()+ "")) != Double
                                    .parseDouble(chgStrZero(prpPitemKindAgriSchema.getTimesAmount() + ""))) {
                                if ((prpPitemKindAgriSchema.getTimesAmount() + "").length() == 0) {
                                    strKindNameString = ""
                                            + strColCname
                                            + "元，变更为"
                                            + prpCitemKindAgriSchema
                                            .getTimesAmount() + "元，";
                                } else {
                                    strKindNameString = ""
                                            + strColCname
                                            + "由"
                                            + prpPitemKindAgriSchema
                                            .getTimesAmount()
                                            + "元，变更为"
                                            + prpCitemKindAgriSchema
                                            .getTimesAmount() + "元，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        if (strColname.equals("grossquantity")) {
                            if (Double.parseDouble(chgStrZero(prpCitemKindAgriSchema.getGrossQuantity() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindAgriSchema.getGrossQuantity() + ""))) {
                                if ((prpPitemKindAgriSchema.getGrossQuantity() + "").length() == 0) {
                                    strKindNameString = ""
                                            + strColCname
                                            + "变更为"
                                            + prpCitemKindAgriSchema
                                            .getGrossQuantity()
                                            + "亩/平方尺/瓶/袋 ，";
                                } else {
                                    strKindNameString = ""
                                            + strColCname
                                            + "由"
                                            + prpPitemKindAgriSchema
                                            .getGrossQuantity()
                                            + "亩/平方尺/瓶/袋变更为"
                                            + prpCitemKindAgriSchema
                                            .getGrossQuantity()
                                            + "亩/平方尺/瓶/袋 ";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                        // add by guolei end

					/* add by xiaojian 20051028 begin reason：1807等险种有最低保费字段 */
                        // BasePremium
                        if (strColname.equals("basepremium")) {
                            if (Double
                                    .parseDouble(chgStrZero(prpCitemKindSchema.getBasePremium() + "")) !=
                                    Double.parseDouble(chgStrZero(prpPitemKindSchema.getBasePremium() + ""))) {
                                if ((prpPitemKindSchema.getBasePremium() + "").length() == 0) {
                                    strKindNameString = "" + strColCname
                                            + "变更为"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpCitemKindSchema.getBasePremium()
                                            + "，";
                                } else {
                                    strKindNameString = "" + strColCname + "由"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpPitemKindSchema.getBasePremium()
                                            + "变更为"
                                            + prpCitemKindSchema.getCurrency()
                                            + prpCitemKindSchema.getBasePremium()
                                            + "，";
                                }
                                intLineNo = setEndorseText(blEndorse,
                                        strKindNameString, intLineNo, true);
                                continue;
                            }
                        }
                    }
                }
            }
        }
        // 输出批改公式
        if (dblChgPremiumTotal != 0) {
            // 批改公式文字描述
            if (dblChgPremiumTotal > 0) {
                strType1 = "加收";
            } else if (dblChgPremiumTotal < 0) {
                strType1 = "退还";
                dblChgPremiumTotal = dblChgPremiumTotal * (-1);
            }
            if (strRiskCode.equals("ZZY")) {
                strPtext = "保费批改如下：";
            } else {
                strPtext = "保费计算公式如下：";
            }
			/*	国元的保费计算公式调整为：
			 * 0309
             *     变化保费=(保额变化量*投保档次系数*原短期费率系数)*批改短期系数(%)
             *     其中：投保档次系数恒定为：0.01
             *1580
             * 变化保费=(保额变化量*原费率*原短期费率系数＋新保额*费率变化量*原短期费率系数)*批改短期系数(%)—优惠金额
			 * 其他的走
			 * 非船舶险类：保费变化量=(保额变化量*原费率*原短期费率系数+新保额*费率变化量*原短期费率系数)*批改短期系数
			 *
			 */
            if (null != blPolicy.getPrpCmainDto() && "B01".equals(blPolicy.getPrpCmainDto().getVersionNo()) && "31".equals(blPolicy.getPrpCmainDto().getClassCode())) {
                //B01版种植险保费计算公式变化如下
                //( newUnitPremiun * newInsuredArea  -  oldUnitPremium * oldInsuredArea ) * newShortRate * oldShortRate;
                strPtext = "" + "变化保费" + "=" + strPtextPart11
                        + "( 新单位保费" + "*" + "新投保面积*原短期费率系数" + "-" + "原单位保费" + "*" + "原投保面积*原短期费率系数)"
                        + "*" + "批改短期系数(%)";
                intLineNo = setEndorseText(blEndorse, strPtext,
                        intLineNo, true);
            } else if (null != blPolicy.getPrpCmainDto() && "B01".equals(blPolicy.getPrpCmainDto().getVersionNo()) && "32".equals(blPolicy.getPrpCmainDto().getClassCode())) {
                //B01版养殖险保费计算公式变化如下
                //( newUnitPremiun * newInsuredArea  -  oldUnitPremium * oldInsuredArea ) * newShortRate * oldShortRate;
                strPtext = "    " + "变化保费" + "=" + strPtextPart11
                        + "( 新单位保费" + "*" + "新投保数量*原短期费率系数" + "-" + "原单位保费" + "*" + "原投保数量*原短期费率系数)"
                        + "*" + "批改短期系数(%)";
                intLineNo = setEndorseText(blEndorse, strPtext,
                        intLineNo, true);
            } else {
                strPtext = "    " + "变化保费" + "=" + strPtextPart11
                        + "(保额变化量" + "*" + "原费率*原短期费率系数" + "＋" + "新保额" + "*" + "费率变化量*原短期费率系数)"
                        + "*" + "批改短期系数(%)";
                intLineNo = setEndorseText(blEndorse, strPtext,
                        intLineNo, true);
            }
            // 批改公式赋值
            if(blPolicy.getPrpCitemKindDtoList()!=null) {
                for (i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
                    if (blPolicy.getPrpCitemKindDtoList().get(i).getFlag().length() >= 1
                            && blPolicy.getPrpCitemKindDtoList().get(i).getFlag().substring(0, 1).equals("U")) {
                        prpCitemKindSchema = blPolicy.getPrpCitemKindDtoList().get(i);
                        indexP = search(
                                prpCitemKindSchema.getItemKindNo() + "", blEndorse);
                        prpPitemKindSchema = blEndorse.getPrpPitemKindDtoList().get(indexP);
                        // 如果是加保的虚拟标的不生成批文
                        if (prpCitemKindSchema.getItemCode().equals("0000")) {
                            continue;
                        }
                        // 获取保额变化量
                        dblChgAmount = Double.parseDouble(chgStrZero(prpPitemKindSchema.getChgAmount() + ""));
                        if (dblChgAmount < 0) {
                            dblChgAmount = dblChgAmount * (-1);
                            labelChgAmount = "-";
                        } else {
                            labelChgAmount = "";
                        }
                        // 获取原费率
                        dblOldRate = Double.parseDouble(chgStrZero(prpPitemKindSchema.getRate() + ""));
                        // 获取新保额
                        dblAmount = Double.parseDouble(chgStrZero(prpCitemKindSchema.getAmount() + ""));
                        // 获取费率变化量
                        dblChgRate = Double.parseDouble(chgStrZero(prpCitemKindSchema.getRate() + ""))
                                - Double.parseDouble(chgStrZero(prpPitemKindSchema.getRate() + ""));
                        if (dblChgRate < 0) {
                            dblChgRate = dblChgRate * (-1);
                            labelChgRate = "-";
                        } else {
                            labelChgRate = "";
                        }
                        //获取原批改短期系数
                        dblShortRateOld = Double.parseDouble(chgStrZero(prpPitemKindSchema.getShortRate() + ""));
                        //获取批改短期系数
                        dblShortRate = Double.parseDouble(chgStrZero(prpCitemKindSchema.getShortRate() + ""));
                        if("11".equals(blEndorse.getPrpPheadDto().getEndorType())||"91".equals(blEndorse.getPrpPheadDto().getEndorType())){
                        	dblShortRate=100;
						}
                        //获取变化的保费
                        dblChgPremium = Double.parseDouble(chgStrZero(prpPitemKindSchema.getChgPremium() + ""));
                        if (dblChgPremium > 0) {
                            strType2 = "加收";
                            labelChgPremium = "";
                        } else if (dblChgPremium == 0) {
                            strType2 = "退还";
                            labelChgPremium = "";
                            dblChgPremium = dblChgPremium * (-1);
                        } else {
                            strType2 = "退还";
                            dblChgPremium = dblChgPremium * (-1);
                            labelChgPremium = "-";
                        }
                        if (null != blPolicy.getPrpCmainDto() && "B01".equals(blPolicy.getPrpCmainDto().getVersionNo()) && "31".equals(blPolicy.getPrpCmainDto().getClassCode()) && "3125,3178,3105".indexOf(blPolicy.getPrpCmainDto().getRiskCode()) < 0) {
                            strPtext = "    "
                                    + prpCitemKindSchema.getKindName().trim() + strType2
                                    + "保费" + "：" + round(dblChgPremium, 2)
                                    + "\r\n保费计算公式为：" + "("
                                    + prpCitemKindSchema.getUnitPremium()
                                    + "*" + prpCitemKindSchema.getQuantity() + "*"
                                    + dblShortRateOld + "%" + " - " + prpPitemKindSchema.getUnitPremium()
                                    + "*" + prpPitemKindSchema.getQuantity() + "*"
                                    + dblShortRateOld
                                    + "%" + ")" + "*" + dblShortRate + "%" + "="
                                    + labelChgPremium + round(dblChgPremium, 2);

                        } else if (null != blPolicy.getPrpCmainDto() && "B01".equals(blPolicy.getPrpCmainDto().getVersionNo()) && "32".equals(blPolicy.getPrpCmainDto().getClassCode())) {
                            strPtext = "    "
                                    + prpCitemKindSchema.getKindName().trim()
                                    + strType2
                                    + "保费" + "："
                                    + round(dblChgPremium, 2) + " 　　保费计算公式为："
                                    + "(" + prpCitemKindSchema.getUnitPremium() + "*"
                                    + prpCitemKindSchema.getQuantity() + "*"
                                    + dblShortRateOld + "%" + " - "
                                    + prpPitemKindSchema.getUnitPremium()
                                    + "*" + prpPitemKindSchema.getQuantity()
                                    + "*" + dblShortRateOld
                                    + "%" + ")" + "*" + dblShortRate
                                    + "%" + "=" + labelChgPremium
                                    + round(dblChgPremium, 2);

                        } else {
                            strPtext = ""
                                    + prpCitemKindSchema.getKindName().trim()
                                    + strType2
                                    + "保费" + "：" + round(dblChgPremium, 2)
                                    + "\r\n保费计算公式为："
                                    + "((" + labelChgAmount + dblChgAmount + ")*"
                                    + dblOldRate + strCalculator + "*"
                                    + dblShortRateOld
                                    + "%" + "＋" + dblAmount + "*(" + labelChgRate
                                    + dblChgRate + strCalculator + ")*"
                                    + dblShortRateOld + "%" + ")" + "*"
                                    + dblShortRate + "%" + "=" + labelChgPremium
                                    + round(dblChgPremium, 2);
                        }
                        intLineNo = setEndorseText(blEndorse, strPtext,
                                intLineNo, true);
                    }
                }
            }
        }
        /*************************************************变更标的批文生成结束*******************************************/
        /*************************************************删除（退保）标的批文生成开始*******************************************/
        strKindNameString = "";
        dblChgPremiumTotal = 0;
        if( blPolicy.getPrpCitemKindDtoList()!=null) {
            for (i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
                if (blPolicy.getPrpCitemKindDtoList().get(i).getFlag().length() >= 1
                        && (blPolicy.getPrpCitemKindDtoList().get(i).getFlag().substring(0, 1).equals("B")||blPolicy.getPrpCitemKindDtoList().get(i).getFlag().substring(0, 1).equals("D"))) {
                    prpCitemKindSchema = blPolicy.getPrpCitemKindDtoList().get(i);
                    //如果是加保的虚拟标的不生成批文
                    if (prpCitemKindSchema.getItemCode().equals("0000")) {
                        continue;
                    }
                    intCounterB = intCounterB + 1;
                    if (blPolicy.getPrpCitemKindDtoList().get(i).getItemDetailName() != null
                            && blPolicy.getPrpCitemKindDtoList().get(i).getItemDetailName().length() > 0) {
                        strItemDetailName = "";
                    }
                    strKindNameString = strKindNameString
                            + "  “" + blPolicy.getPrpCitemKindDtoList().get(i).getKindName()
                            .trim() + strItemDetailName + "” ";
                    // 汇总加保保费变化量
                    indexP = search(prpCitemKindSchema.getItemKindNo() + "", blEndorse);
                    prpPitemKindSchema = blEndorse.getPrpPitemKindDtoList().get(indexP);
                    dblChgPremiumTotal = dblChgPremiumTotal
                            + prpPitemKindSchema.getChgPremium();
                }
            }
        }
        // 输出批改公式
        // 批改公式文字描述
        if (intCounterB > 0) {
            strPtext = " <<退保标的/保险责任清单>>";
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
            if (dblChgPremiumTotal < 0) {
                dblChgPremiumTotal = dblChgPremiumTotal * (-1);
            }
            strKindNameString = strKindNameString.substring(0,
                    strKindNameString.length() - 1);
            strPtext = "退还标的/保险责任的名称为： " + strKindNameString + "　　共退还保费"
                    + round(dblChgPremiumTotal, 2)
                    + "元整";
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
            strPtext = "退还保费计算公式如下：";

            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);

            strPtext = "退还保费" + "=" + "原保费" + "-" + "现保费";
            intLineNo = setEndorseText(blEndorse, strPtext,
                    intLineNo, true);
        }
        // 批改公式赋值
        if(blPolicy.getPrpCitemKindDtoList()!=null) {
            for (i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
                if (blPolicy.getPrpCitemKindDtoList().get(i).getFlag().length() >= 1
                        && blPolicy.getPrpCitemKindDtoList().get(i).getFlag().substring(0, 1).equals("B")) {
                    prpCitemKindSchema = blPolicy.getPrpCitemKindDtoList().get(i);
                    //如果是加保的虚拟标的不生成批文
                    if (prpCitemKindSchema.getItemCode().equals("0000")) {
                        continue;
                    }
                    indexP = search(prpCitemKindSchema.getItemKindNo() + "", blEndorse);
                    prpPitemKindSchema = blEndorse.getPrpPitemKindDtoList().get(indexP);
                    if (blPolicy.getPrpCitemKindDtoList().get(i).getItemDetailName() != null
                            && blPolicy.getPrpCitemKindDtoList().get(i).getItemDetailName().length() > 0) {
                        strItemDetailName = "";
                    }
                    strPtext = "" + prpCitemKindSchema.getKindName().trim()
                            + strItemDetailName
                            + "退还保费"
                            + "="
                            + (prpPitemKindSchema.getPremium() + "")
                            + "-"
                            + (prpCitemKindSchema.getPremium() + "")
                            + "="
                            + ((prpPitemKindSchema.getChgPremium()
                            * (-1)) + "");
                    intLineNo = setEndorseText(blEndorse, strPtext,
                            intLineNo, true);
                }
            }
        }
        /******************************************删除（退保）标的批文生成结束***********************************************/
        return intLineNo;
    }

    /**
     * 变更共保信息
     *
     * @param blPolicy
     * @param blEndorse
     * @param intLineNo
     * @return
     * @throws Exception
     */
    public int ptextForCoins(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                             int intLineNo) throws Exception {
        List<PrpCcoinsDto> blprpCcoins = blPolicy.getPrpCcoinsDtoList();
        List<PrpPcoinsDto> blprpPcoins = blEndorse.getPrpPcoinsDtoList();
        String strPtext = " <<变更共保信息>>";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        strPtext = "因业务需要，对保单共保信息批改如下：";
        intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        if (blprpPcoins.size() > 0) {
            for (int i = 0; i < blprpPcoins.size(); i++) {
                if ("I".equals(blprpCcoins.get(i).getFlag())) {
                    strPtext = "新增共保人:" + blprpPcoins.get(i).getCoinsName() + "，共保比例为" + blprpPcoins.get(i).getCoinsRate() + "。";
                    intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
                }
                if ("U".equals(blprpCcoins.get(i).getFlag())) {
                    double coinsRate = blprpPcoins.get(i).getCoinsRate();
                    double coinsRateNew = blprpPcoins.get(i).getCoinsRate() + blprpPcoins.get(i).getChgCoinsRate();
                    strPtext = "修改共保人:" + blprpPcoins.get(i).getCoinsName() + "，共保比例由" + coinsRate + "修改为" + coinsRateNew + "。";
                    intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
                }
                if ("B".equals(blprpCcoins.get(i).getFlag())) {
                    strPtext = "删除共保人:" + blprpPcoins.get(i).getCoinsName() + "。";
                    intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
                }
            }
        }
        return intLineNo;
    }

    /**
     * 加政府补贴的批文
     *
     * @param blPolicy
     * @param blEndorse
     * @param intLineNo
     * @return
     * @throws UserException
     * @throws Exception
     */
    public int ptextForUsualSubsidy(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse,
                                    int intLineNo) throws Exception {
        String SubsidyName = "";
        String strPtext = "";
        PrpCsubsidyDto prpCsubsidySchema;
        //PrpPsubsidyDto prpPsubsidySchema;
        if(blPolicy.getPrpCsubsidyDtoList()!=null) {
            for (int i = 0; i < blPolicy.getPrpCsubsidyDtoList().size(); i++) {
            	prpCsubsidySchema = blPolicy.getPrpCsubsidyDtoList().get(i);
            	 if(blEndorse.getPrpPsubsidyDtoList() == null || blEndorse.getPrpPsubsidyDtoList().size()<1){
            		  if("A".equals(prpCsubsidySchema.getOperationFlag()) ){
                     	strPtext = " <<增加补贴信息>>";
                     	intLineNo = setEndorseText(blEndorse, strPtext,
                     			intLineNo, true);
                     	if (prpCsubsidySchema.getSubsidyCode().equals("03")) {
                     		SubsidyName = "中央财政补贴 ";
                     	} else if (prpCsubsidySchema.getSubsidyCode().equals("04")) {
                     		SubsidyName = "省级财政补贴 ";
                     	} else if (prpCsubsidySchema.getSubsidyCode().equals("05")) {
                     		SubsidyName = "地市县财政补贴 ";
                     	}else if (prpCsubsidySchema.getSubsidyCode().equals("07")) {
                     		SubsidyName = "县（区）财政补贴 ";
                     	}else {
                     		SubsidyName = "其它补贴 ";
                     	}
                     	strPtext = SubsidyName + "补贴金额为"
                     			+ prpCsubsidySchema.getSubsidyPremium() + "元";
                     	intLineNo = setEndorseText(blEndorse, strPtext,
                     			intLineNo, true);
                     	strPtext = "补贴比例为"
                     			+ prpCsubsidySchema.getSubsidyRate() + "%";
                     	intLineNo = setEndorseText(blEndorse, strPtext,
                     			intLineNo, true);
                     	strPtext = SubsidyName + "补贴机构为"
                     			+ prpCsubsidySchema.getSubsidyDepartment();
                     	intLineNo = setEndorseText(blEndorse, strPtext,
                     			intLineNo, true);
                     	continue;
                     }
                 }
                 
                 for (PrpPsubsidyDto prpPsubsidySchema : blEndorse.getPrpPsubsidyDtoList()) {
                if (prpCsubsidySchema.getSubsidyType().equals(prpPsubsidySchema.getSubsidyType()) && prpCsubsidySchema.getSubsidyCode().equals(prpPsubsidySchema.getSubsidyCode()) 
                        &&"U".equals(prpCsubsidySchema.getOperationFlag())) {
                    strPtext = " <<变更补贴信息>>";
                    intLineNo = setEndorseText(blEndorse, strPtext,
                            intLineNo, true);
                    if (prpCsubsidySchema.getSubsidyCode().equals("03")) {
                        SubsidyName = "中央财政补贴 ";
                    } else if (prpCsubsidySchema.getSubsidyCode().equals("04")) {
                        SubsidyName = "省级财政补贴 ";
                    } else if (prpCsubsidySchema.getSubsidyCode().equals("05")) {
                        SubsidyName = "地市县财政补贴 ";
                    }else if (prpCsubsidySchema.getSubsidyCode().equals("07")) {
                        SubsidyName = "县（区）财政补贴 ";
                    }else {
                        SubsidyName = "其它补贴 ";
                    }
                    if (round(Double.parseDouble(chgStrZero(prpCsubsidySchema.getSubsidyPremium() + "")), 2) !=
                            round(Double.parseDouble(chgStrZero(prpPsubsidySchema.getSubsidyPremium() + "")), 2)
                            ) {
                        strPtext = SubsidyName + "补贴金额由"
                                + prpPsubsidySchema.getSubsidyPremium() + "元，变更为"
                                + prpCsubsidySchema.getSubsidyPremium() + "元";
                        intLineNo = setEndorseText(blEndorse, strPtext,
                                intLineNo, true);
                    }
                    if (!prpCsubsidySchema.getSubsidyRate().equals(
                            prpPsubsidySchema.getSubsidyRate())) {
                        strPtext = SubsidyName + "补贴比例由"
                                + prpPsubsidySchema.getSubsidyRate() + "%,变更为"
                                + prpCsubsidySchema.getSubsidyRate() + "%";
                        intLineNo = setEndorseText(blEndorse, strPtext,
                                intLineNo, true);
                    }
                    if (!prpCsubsidySchema.getSubsidyDepartment().equals(
                            prpPsubsidySchema.getSubsidyDepartment())) {
                        strPtext = SubsidyName + "补贴机构由"
                                + prpPsubsidySchema.getSubsidyDepartment() + "变更为"
                                + prpCsubsidySchema.getSubsidyDepartment();
                        intLineNo = setEndorseText(blEndorse, strPtext,
                                intLineNo, true);
                    }
                }
                else if("A".equals(prpCsubsidySchema.getOperationFlag()) ){
                	strPtext = " <<增加补贴信息>>";
                	intLineNo = setEndorseText(blEndorse, strPtext,
                			intLineNo, true);
                	if (prpCsubsidySchema.getSubsidyCode().equals("03")) {
                		SubsidyName = "中央财政补贴 ";
                	} else if (prpCsubsidySchema.getSubsidyCode().equals("04")) {
                		SubsidyName = "省级财政补贴 ";
                	} else if (prpCsubsidySchema.getSubsidyCode().equals("05")) {
                		SubsidyName = "地市县财政补贴 ";
                	}else if (prpCsubsidySchema.getSubsidyCode().equals("07")) {
                		SubsidyName = "县（区）财政补贴 ";
                	}else {
                		SubsidyName = "其它补贴 ";
                	}
                	strPtext = SubsidyName + "补贴金额为"
                			+ prpCsubsidySchema.getSubsidyPremium() + "元";
                	intLineNo = setEndorseText(blEndorse, strPtext,
                			intLineNo, true);
                	strPtext = "补贴比例为"
                			+ prpCsubsidySchema.getSubsidyRate() + "%";
                	intLineNo = setEndorseText(blEndorse, strPtext,
                			intLineNo, true);
                	strPtext = SubsidyName + "补贴机构为"
                			+ prpCsubsidySchema.getSubsidyDepartment();
                	intLineNo = setEndorseText(blEndorse, strPtext,
                			intLineNo, true);
                	break;
                }
       
            }
        }
        }
               return intLineNo;
    }

    /**
     * 生成批文尾部信息
     *
     * @return 处理后行
     */
    public void generateTail(BLEndorseDto iEndorse, int iLineNo)
            throws UserException, Exception {
        /* 批文尾部信息 */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String strValidDate = format.format(iEndorse.getPrpPheadDto().getValidDate());
        String strYear = strValidDate.substring(0, 4);
        String strMonth = strValidDate.substring(5, 7);
        String strDay = strValidDate.substring(8, 10);
        String strPtext = "";
        strPtext = "对保险单作以上批改的生效日期自" + strYear + "年" + strMonth + "月" + strDay
                + "日0时起。";
        iLineNo = setEndorseText(iEndorse, strPtext, iLineNo, true);
        strPtext = " " + "本保险单所载其他的条件不变，特此批注。";
        iLineNo = setEndorseText(iEndorse, strPtext, iLineNo, true);
    }
    /**
     * 变更费率批文
     * blPolicy 最新保单信息
     * blEndorse 批单信息
     * intLineNo 行数
     * @return int intLineNo 行数
     * @throws UserException
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-22
     */
    @Deprecated
    public int ptextForRate(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse, int intLineNo,ResponseQueryPolicyInfoDto blPolicyDtoOld) throws Exception {
        PrpCitemKindDto prpCitemKindSchema = new PrpCitemKindDto();
        PrpPitemKindDto prpPitemKindSchema = new PrpPitemKindDto();
        List<PrpCitemKindDto> blPrpCitemKindCollect = new ArrayList<>();
        List<PrpPitemKindDto> blPrpPitemKindCollect = new ArrayList<>();
        Map<String,PrpCitemKindDto> prpCitemKindDtoMap=new HashMap<>();
        for(PrpCitemKindDto prpCitemKindDto:blPolicyDtoOld.getPrpCitemKindDtoList()){
        	prpCitemKindDtoMap.put(prpCitemKindDto.getItemCode(),prpCitemKindDto);
		}
        String strPtext = "";
        double dblChgPremium = 0;
        int i = 0;
        int j = 0;
        String strType2="";
        String labelChgPremium="";


		strPtext = " <<调整费率>>";
        intLineNo = setEndorseText(blEndorse, strPtext,
                intLineNo, true);
        for(i=0;i<blEndorse.getPrpPfeeDtoList().size();i++) {
            strPtext = "    原保单的费率："
                    + blEndorse.getPrpPitemKindDtoList().get(i).getRate()+"%"
                    + "改为："
                    + blPolicy.getPrpCitemKindDtoList().get(i).getRate()+"%";
            intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        }
        for(i=0;i<blEndorse.getPrpPfeeDtoList().size();i++) {
            strPtext = "    原保费："
                    + blEndorse.getPrpPitemKindDtoList().get(i).getPremium()
                    + "改为："
                    + blPolicy.getPrpCitemKindDtoList().get(i).getPremium();
            intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        }
        double dblChgRate=0.0;
        String labelChgRate="";
		for (i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
        	PrpCitemKindDto prpCitemKindDto=blPolicy.getPrpCitemKindDtoList().get(i);
        	PrpCitemKindDto prpCitemKindDtoOld=prpCitemKindDtoMap.get(prpCitemKindDto.getItemCode());
			dblChgPremium = abs(prpCitemKindDto.getPremium()-prpCitemKindDtoOld.getPremium());

			if (dblChgPremium > 0) {
				strType2 = "加收";
				labelChgPremium = "";
			} else if (dblChgPremium == 0){
				strType2 = "退还";
				labelChgPremium = "";
				dblChgPremium = dblChgPremium * (-1);
			}else {
				strType2 = "退还";
				dblChgPremium = dblChgPremium * (-1);
				labelChgPremium = "-";
			}
			dblChgRate = Double.parseDouble(chgStrZero(prpCitemKindDto.getRate() + ""))
					- Double.parseDouble(chgStrZero(prpCitemKindDtoOld.getRate() + ""));
			if (dblChgRate < 0) {
				dblChgRate = dblChgRate * (-1);
				labelChgRate = "-";
			} else {
				labelChgRate = "";
			}
			if (null != blPolicy.getPrpCmainDto() && "B01".equals(blPolicy.getPrpCmainDto().getVersionNo()) && "32".equals(blPolicy.getPrpCmainDto().getClassCode())) {
				strPtext = "    "
						+ prpCitemKindDto.getKindName().trim()
						+ strType2
						+ "保费" + "："
						+ round(dblChgPremium, 2) + " 　　保费计算公式为："
						+ "(" + prpCitemKindSchema.getUnitPremium() + "*"
						+ prpCitemKindSchema.getQuantity() + "*"
						+ prpCitemKindDtoOld.getShortRate() + "%" + " - "
						+ prpCitemKindDtoOld.getUnitPremium()
						+ "*" + prpPitemKindSchema.getQuantity()
						+ "*" + prpCitemKindDtoOld.getShortRate()
						+ "%" + ")" + "*" + prpCitemKindDto.getShortRate()
						+ "%" + "=" + labelChgPremium
						+ round(dblChgPremium, 2);

			} else {
				strPtext = ""
						+ prpCitemKindDto.getKindName().trim()
						+ strType2
						+ "保费" + "：" + round(dblChgPremium, 2)
						+ "\r\n保费计算公式为："
						+ "((" + prpCitemKindDto.getAmount() + "-" + prpCitemKindDtoOld.getAmount()+")*"
						+ prpCitemKindDtoOld.getRate() + "%" + "*"
						+ prpCitemKindDtoOld.getShortRate()
						+ "%" + "＋" + prpCitemKindDto.getAmount() + "*(" + labelChgRate
						+ dblChgRate + "%" + ")*"
						+ prpCitemKindDtoOld.getShortRate() + "%" + ")" + "*"
						+ prpCitemKindDto.getShortRate() + "%" + "=" + labelChgPremium
						+ round(dblChgPremium, 2);
			}
			intLineNo = setEndorseText(blEndorse, strPtext,
					intLineNo, true);
		}
        // 汇总ItemKind表数据(根据客户需求对各险种的标的进行汇总)
//        ItemKindPrint:
//        for (i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
//            for (j = 0; j < blPrpCitemKindCollect.size(); j++) {
//                if (blPolicy.getPrpCitemKindDtoList().get(i).getItemCode().equals(blPrpCitemKindCollect.get(j).getItemCode())
//                        && !blPolicy.getPrpCitemKindDtoList().get(i).getItemCode().equals("")
//                        && !blPolicy.getPrpCitemKindDtoList().get(i).getItemCode().equals("9999")
//                        && blPolicy.getPrpCitemKindDtoList().get(i).getKindName().equals(blPrpCitemKindCollect.get(j).getKindName())
//                        && blPolicy.getPrpCitemKindDtoList().get(i).getModeCode().equals(blPrpCitemKindCollect.get(j).getModeCode())
//                        && blPolicy.getPrpCitemKindDtoList().get(i).getRate().equals(blPrpCitemKindCollect.get(j).getRate())) {
//                    // CP表
//                    blPrpCitemKindCollect.get(j).setShortRateFlag(
//                            blPolicy.getPrpCitemKindDtoList().get(i).getShortRateFlag());
//                    blPrpCitemKindCollect.get(j).setShortRate(blPolicy.getPrpCitemKindDtoList().get(i).getShortRate());
//                    blPrpCitemKindCollect.get(j).setKindName(blPolicy.getPrpCitemKindDtoList().get(i).getKindName());
//                    blPrpCitemKindCollect.get(j).setAmount(Double.parseDouble(chgStrZero(blPrpCitemKindCollect.get(j).getAmount() + ""))
//                            + Double.parseDouble(chgStrZero(blPolicy.getPrpCitemKindDtoList().get(i).getAmount() + "")));
//                    blPrpCitemKindCollect.get(j).setPremium(Double.parseDouble(chgStrZero(blPrpCitemKindCollect.get(j).getPremium() + ""))
//                            + Double.parseDouble(chgStrZero(blPolicy.getPrpCitemKindDtoList().get(i).getPremium() + "")));
//                    // P表
//                    blPrpPitemKindCollect.get(j).setShortRateFlag(blEndorse.getPrpPitemKindDtoList().get(i).getShortRateFlag());
//                    blPrpPitemKindCollect.get(j).setShortRate(blEndorse.getPrpPitemKindDtoList().get(i).getShortRate());
//                    blPrpPitemKindCollect.get(j).setKindName(
//                            blEndorse.getPrpPitemKindDtoList().get(i).getKindName());
//                    blPrpPitemKindCollect.get(j).setAmount(Double.parseDouble(chgStrZero(blPrpPitemKindCollect.get(j).getAmount() + ""))
//                            + Double.parseDouble(chgStrZero(blEndorse.getPrpPitemKindDtoList().get(i).getAmount() + "")));
//                    blPrpPitemKindCollect.get(j).setPremium(Double.parseDouble(chgStrZero(blPrpPitemKindCollect.get(j).getPremium() + ""))
//                            + Double.parseDouble(chgStrZero(blEndorse.getPrpPitemKindDtoList().get(i).getPremium() + "")));
//                    blPrpPitemKindCollect.get(j).setChgPremium(Double.parseDouble(chgStrZero(blPrpPitemKindCollect.get(j).getChgPremium() + ""))
//                            + Double.parseDouble(chgStrZero(blEndorse.getPrpPitemKindDtoList().get(i).getChgPremium() + "")));
//                    continue ItemKindPrint;
//                }
//            }
//            BeanUtils.copyProperties(prpCitemKindSchema, blPolicy.getPrpCitemKindDtoList().get(i));
//            blPrpCitemKindCollect.add(prpCitemKindSchema);
//            BeanUtils.copyProperties(prpPitemKindSchema, blEndorse.getPrpPitemKindDtoList().get(i));
//            blPrpPitemKindCollect.add(prpPitemKindSchema);
//        }
        for (i = 0; i < blPrpPitemKindCollect.size(); i++) {
            prpCitemKindSchema = blPrpCitemKindCollect.get(i);
            prpPitemKindSchema = blPrpPitemKindCollect.get(i);
            dblChgPremium = Double.parseDouble(chgStrZero(String.valueOf(prpPitemKindSchema.getChgPremium())));
            if (dblChgPremium == 0) {
                continue;
            }
            strPtext = "    险别名称：" + prpCitemKindSchema.getKindName();
            intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        }
        return intLineNo;
    }
    /**
     * 非车险变更保险期限批文
     * blPolicy 最新保单信息
     * blEndorse 批单信息
     * intLineNo 行数
     * @return int intLineNo 行数
     * @throws UserException
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-22
     */
    public int ptextForUnionAmount(ResponseQueryPolicyInfoDto blPolicy, BLEndorseDto blEndorse, int intLineNo) throws Exception {
        PrpCitemKindDto prpCitemKindSchema = new PrpCitemKindDto();
        PrpPitemKindDto prpPitemKindSchema = new PrpPitemKindDto();
        List<PrpCitemKindDto> blPrpCitemKindCollect = new ArrayList<>();
        List<PrpPitemKindDto> blPrpPitemKindCollect = new ArrayList<>();
        String strPtext = "";
        double dblChgPremium = 0;
        int i = 0;
        int j = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-hh");
        strPtext = " <<调整单位保额>>";
        intLineNo = setEndorseText(blEndorse, strPtext,
                intLineNo, true);
        for(i=0;i<blEndorse.getPrpPfeeDtoList().size();i++) {
            strPtext = "    原保单的单位保额："
                    + blEndorse.getPrpPitemKindDtoList().get(i).getUnitAmount()
                    + "改为："
                    + blPolicy.getPrpCitemKindDtoList().get(i).getUnitAmount();
            intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        }
        for(i=0;i<blEndorse.getPrpPfeeDtoList().size();i++) {
            strPtext = "    原保单的保额："
                    + blEndorse.getPrpPitemKindDtoList().get(i).getAmount()
                    + "改为："
                    + blPolicy.getPrpCitemKindDtoList().get(i).getAmount();
            intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        }
        for(i=0;i<blEndorse.getPrpPfeeDtoList().size();i++) {
            strPtext = "    原保费："
                    + blEndorse.getPrpPitemKindDtoList().get(i).getPremium()
                    + "改为："
                    + blPolicy.getPrpCitemKindDtoList().get(i).getPremium();
            intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        }
        // 汇总ItemKind表数据(根据客户需求对各险种的标的进行汇总)
        ItemKindPrint:
        for (i = 0; i < blPolicy.getPrpCitemKindDtoList().size(); i++) {
            for (j = 0; j < blPrpCitemKindCollect.size(); j++) {
                if (blPolicy.getPrpCitemKindDtoList().get(i).getItemCode().equals(blPrpCitemKindCollect.get(j).getItemCode())
                        && !blPolicy.getPrpCitemKindDtoList().get(i).getItemCode().equals("")
                        && !blPolicy.getPrpCitemKindDtoList().get(i).getItemCode().equals("9999")
                        && blPolicy.getPrpCitemKindDtoList().get(i).getKindName().equals(blPrpCitemKindCollect.get(j).getKindName())
                        && blPolicy.getPrpCitemKindDtoList().get(i).getModeCode().equals(blPrpCitemKindCollect.get(j).getModeCode())
                        && blPolicy.getPrpCitemKindDtoList().get(i).getRate().equals(blPrpCitemKindCollect.get(j).getRate())) {
                    // CP表
                    blPrpCitemKindCollect.get(j).setShortRateFlag(
                            blPolicy.getPrpCitemKindDtoList().get(i).getShortRateFlag());
                    blPrpCitemKindCollect.get(j).setShortRate(blPolicy.getPrpCitemKindDtoList().get(i).getShortRate());
                    blPrpCitemKindCollect.get(j).setKindName(blPolicy.getPrpCitemKindDtoList().get(i).getKindName());
                    blPrpCitemKindCollect.get(j).setAmount(Double.parseDouble(chgStrZero(blPrpCitemKindCollect.get(j).getAmount() + ""))
                            + Double.parseDouble(chgStrZero(blPolicy.getPrpCitemKindDtoList().get(i).getAmount() + "")));
                    blPrpCitemKindCollect.get(j).setPremium(Double.parseDouble(chgStrZero(blPrpCitemKindCollect.get(j).getPremium() + ""))
                            + Double.parseDouble(chgStrZero(blPolicy.getPrpCitemKindDtoList().get(i).getPremium() + "")));
                    // P表
                    blPrpPitemKindCollect.get(j).setShortRateFlag(blEndorse.getPrpPitemKindDtoList().get(i).getShortRateFlag());
                    blPrpPitemKindCollect.get(j).setShortRate(blEndorse.getPrpPitemKindDtoList().get(i).getShortRate());
                    blPrpPitemKindCollect.get(j).setKindName(
                            blEndorse.getPrpPitemKindDtoList().get(i).getKindName());
                    blPrpPitemKindCollect.get(j).setAmount(Double.parseDouble(chgStrZero(blPrpPitemKindCollect.get(j).getAmount() + ""))
                            + Double.parseDouble(chgStrZero(blEndorse.getPrpPitemKindDtoList().get(i).getAmount() + "")));
                    blPrpPitemKindCollect.get(j).setPremium(Double.parseDouble(chgStrZero(blPrpPitemKindCollect.get(j).getPremium() + ""))
                            + Double.parseDouble(chgStrZero(blEndorse.getPrpPitemKindDtoList().get(i).getPremium() + "")));
                    blPrpPitemKindCollect.get(j).setChgPremium(Double.parseDouble(chgStrZero(blPrpPitemKindCollect.get(j).getChgPremium() + ""))
                            + Double.parseDouble(chgStrZero(blEndorse.getPrpPitemKindDtoList().get(i).getChgPremium() + "")));
                    continue ItemKindPrint;
                }
            }
            BeanUtils.copyProperties(prpCitemKindSchema, blPolicy.getPrpCitemKindDtoList().get(i));
            blPrpCitemKindCollect.add(prpCitemKindSchema);
            BeanUtils.copyProperties(prpPitemKindSchema, blEndorse.getPrpPitemKindDtoList().get(i));
            blPrpPitemKindCollect.add(prpPitemKindSchema);
        }
        for (i = 0; i < blPrpPitemKindCollect.size(); i++) {
            prpCitemKindSchema = blPrpCitemKindCollect.get(i);
            prpPitemKindSchema = blPrpPitemKindCollect.get(i);
            dblChgPremium = Double.parseDouble(chgStrZero(String.valueOf(prpPitemKindSchema.getChgPremium())));
            if (dblChgPremium == 0) {
                continue;
            }
            strPtext = "    险别名称：" + prpCitemKindSchema.getKindName();
            intLineNo = setEndorseText(blEndorse, strPtext, intLineNo, true);
        }
        return intLineNo;
    }
    
}



