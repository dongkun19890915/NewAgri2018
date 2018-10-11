package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.client.dto.RequestGetTaxRateDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseGetTaxRateDto;
import com.sinosoft.agriprpall.api.client.platformclient.AgriPrpallPlatformService;
import com.sinosoft.agriprpall.api.common.util.VATTools;
import com.sinosoft.agriprpall.api.endorsemanage.dto.ItemKindDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.*;
import com.sinosoft.agriprpall.core.proposalmanage.service.LeviedFeeService;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.pms.api.rate.PrpDriskKindTaxAgriApi;
import com.sinosoft.pms.api.rate.PrpDriskKindTaxApi;
import com.sinosoft.pms.api.rate.dto.PrpDriskKindTaxAgriDto;
import com.sinosoft.pms.api.rate.dto.PrpDriskKindTaxDto;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-24 12:54:07.447
 * @description 分保接受人代码表Core接口实现
 */
@Service
public class LeviedFeeServiceImpl extends BaseServiceImpl implements LeviedFeeService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LeviedFeeServiceImpl.class);
    @Value("${webservice.webAgriPrpallService.url}")
    private String webserviceUrl2;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDriskKindTaxAgriApi prpDriskKindTaxAgriApi;

    /**
     * @param blProposal 投保单保存对象
     * @return ResponseDto :ProposalSaveDto 投保单大对象
     * @throws Exception
     * @description: 价税分离
     * @author: 钱浩
     * @date: 2017/10/28 9:27
     */
    @Override
    public ProposalSaveDto dealTMainForYGZ(ProposalSaveDto blProposal) throws Exception {


        PremiumVATDto pvatDto = new PremiumVATDto();
        ArrayList<PrpTitemKindDto> itemKindList = new ArrayList<PrpTitemKindDto>();
        PrpTmainDto prpTmainSchema = blProposal.getPrpTmainDto();
        List<PrpTitemKindDto> blPrpTitemKind = blProposal.getPrpTitemKindDtoList();
        if (blPrpTitemKind.size() > 0) {
            //封装pvatDto
            pvatDto.setFormula("2");//公式二 税额	= [应交保费（含税）/（1+税率）]* 税率 , 不含税保费=应交保费（含税）－ 税额
            pvatDto.setVatFeeType("1");//计算价税分离的费用类型
            pvatDto.setBusinessType("T");//业务类型 T-投保单
            pvatDto.setBusinessNo(prpTmainSchema.getProposalNo());//业务单号;
            pvatDto.setComcode(prpTmainSchema.getComCode());//机构代码;
            pvatDto.setRiskCode(prpTmainSchema.getRiskCode());
            pvatDto.setCurrency(prpTmainSchema.getCurrency());
            pvatDto.setSumPremium(Double.parseDouble(chgStrZero(prpTmainSchema.getSumPremium() + "")));
            PrpTitemKindDto itemKindDto = new PrpTitemKindDto();
            for (PrpTitemKindDto prpTitemKindSchema : blPrpTitemKind) {
                itemKindDto = new PrpTitemKindDto();
                itemKindDto.setProposalNo(prpTitemKindSchema.getProposalNo());
                itemKindDto.setRiskCode(prpTitemKindSchema.getRiskCode());
                itemKindDto.setItemKindNo(prpTitemKindSchema.getItemKindNo());
                itemKindDto.setKindCode(prpTitemKindSchema.getKindCode());
                itemKindDto.setAmount(Double.parseDouble(chgStrZero(prpTitemKindSchema.getAmount() + "")));
                itemKindDto.setPremium(Double.parseDouble(chgStrZero(prpTitemKindSchema.getPremium() + "")));
                itemKindList.add(itemKindDto);
            }
            pvatDto.setItemKindList(itemKindList);
            //价税分离vat方法调用
            PremiumVATDto premiumVATDto = vatCalculate(pvatDto);

            //prptmain回写prpTmainSchema.setSumNoTaxPremium(premiumVATDto.getSumNoTaxPremium());
            prpTmainSchema.setSumNoTaxPremium(premiumVATDto.getSumNoTaxPremium());
            prpTmainSchema.setSumTaxFee(premiumVATDto.getSumTaxFee());
            //prptfee回写
            PrpTfeeDto prpTfeeSchema = blProposal.getPrpTfeeDto();
            prpTfeeSchema.setNoTaxPremium(premiumVATDto.getSumNoTaxPremium());
            prpTfeeSchema.setNoTaxPremium1(premiumVATDto.getSumNoTaxPremium());
            prpTfeeSchema.setNoTaxPremium2(premiumVATDto.getSumNoTaxPremium());
            prpTfeeSchema.setTaxFee(premiumVATDto.getSumTaxFee());
            prpTfeeSchema.setTaxFee1(premiumVATDto.getSumTaxFee());
            prpTfeeSchema.setTaxFee2(premiumVATDto.getSumTaxFee());
            //prptplan
            if (blProposal.getPrpTplanDtoList().size() == 1) {
                PrpTplanDto prpTplanSchema = blProposal.getPrpTplanDtoList().get(0);
                prpTplanSchema.setNoTaxPremium(premiumVATDto.getSumNoTaxPremium());
                prpTplanSchema.setTaxFee(premiumVATDto.getSumTaxFee());
            } else {
                //分期业务拆分
                double tempSumNoTaxPremium = 0d;//调差用总不含税保费
                for (int i = 0; i < blProposal.getPrpTplanDtoList().size(); i++) {
                    PrpTplanDto prpTplanSchema = blProposal.getPrpTplanDtoList().get(i);
                    if (i < blProposal.getPrpTplanDtoList().size() - 1) {
                        prpTplanSchema.setNoTaxPremium(round((premiumVATDto.getSumNoTaxPremium() *
                                (Double.parseDouble(chgStrZero(prpTplanSchema.getPlanFee() + "")) / premiumVATDto.getSumPremium())), 2));
                        tempSumNoTaxPremium = VATTools.add(tempSumNoTaxPremium, Double.parseDouble(chgStrZero(prpTplanSchema.getNoTaxPremium() + "")));
                    } else {//最后一条记录,调差
                        prpTplanSchema.setNoTaxPremium(VATTools.sub(premiumVATDto.getSumNoTaxPremium(), tempSumNoTaxPremium));
                    }
                    prpTplanSchema.setTaxFee(VATTools.sub(prpTplanSchema.getPlanFee(), prpTplanSchema.getNoTaxPremium()));
                }
            }
            //prptitemkind回写
            itemKindList = premiumVATDto.getItemKindList();
            for (int i = 0; i < blPrpTitemKind.size(); i++) {
                String itemkindno = String.valueOf(blPrpTitemKind.get(i).getItemKindNo());
                Iterator it = itemKindList.iterator();
                while (it.hasNext()) {
                    itemKindDto = (PrpTitemKindDto) it.next();
                    String ItemKindNo = String.valueOf(itemKindDto.getItemKindNo());
                    if (itemkindno.equals(ItemKindNo)) {
                        blPrpTitemKind.get(i).setNoTaxPremium(itemKindDto.getNoTaxPremium());
                        blPrpTitemKind.get(i).setTaxFlag(itemKindDto.getTaxFlag());
                        blPrpTitemKind.get(i).setTaxRate(itemKindDto.getTaxRate());
                        blPrpTitemKind.get(i).setTaxFee(itemKindDto.getTaxFee());
                        break;
                    }
                }
            }
            //共保处理 费用信息处理
            this.dealTCoinsMainForYGZ(blProposal);
        }
        return blProposal;
    }

    /**
     * 从页面点击币别确定时调用此价税分离服务
     * @author: 田健
     * @date: 2017/11/19 13:12
     * @param calNocTaxPremiumInfoDto 计算保费价税分离时传入的dto,包含保额、保费、险别等信息
     * @return 返回不含税保费、和税
     * @throws Exception
     */
    @Override
    public CalNoTaxPremiumInfoDto dealTMainForYGZFromPage(CalNoTaxPremiumInfoDto calNocTaxPremiumInfoDto) throws Exception {
        int mainCounts = Integer.parseInt(calNocTaxPremiumInfoDto.getMainCounts());//主险个数
        int subCounts = Integer.parseInt(calNocTaxPremiumInfoDto.getSubCounts());//附加险个数
        String kindCodeMainStr = calNocTaxPremiumInfoDto.getKindCodeMainStr();//主险险别
        String premiumMainStr = calNocTaxPremiumInfoDto.getPremiumMainStr();//主险保费
        String kindCodeSubStr = calNocTaxPremiumInfoDto.getKindCodeSubStr();//附加险险别
        String premiumSubStr = calNocTaxPremiumInfoDto.getPremiumSubStr();//附加险保费
        String itemKindNoMainStr =calNocTaxPremiumInfoDto.getItemKindNoMainStr();//主险险别序号
        String itemKindNoSubStr = calNocTaxPremiumInfoDto.getItemKindNoSubStr();//附加险险别序号
        String comCode = calNocTaxPremiumInfoDto.getComCode();//归属机构
        if(StringUtils.isEmpty(comCode)){
            throw new DataVerifyException("归属机构代码不能为空");
        }
        String riskCode = calNocTaxPremiumInfoDto.getRiskCode();//险种代码
        if(StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("险种代码不能为空");
        }
        String itemKindNo = "";//险别序号
        String kindCode = "";//险别代码
        String amount = "";//保额
        String premium = "";//保费
        PrpTitemKindDto itemKindDto = null;
        PremiumVATDto pvatDto = new PremiumVATDto();
        PremiumVATDto premiumVATDto = null;
        ArrayList<PrpTitemKindDto> itemKindList = new ArrayList<PrpTitemKindDto>();
        if(StringUtils.isNotEmpty(comCode)){
            String[] itemKindNoMain = null;
            String[] kindCodeMain = null;
            String[] premiumMain = null;
            String[] kindCodeSub = null;
            String[] itemKindNoSub = null;
            String[] premiumSub = null;
            if(StringUtils.isNotEmpty(itemKindNoMainStr)){
                 itemKindNoMain = itemKindNoMainStr.split("\\|");
            }else{
                throw new DataVerifyException("主险险别序号不能为空");
            }
            if(StringUtils.isNotEmpty(kindCodeMainStr)){
                 kindCodeMain = kindCodeMainStr.split("\\|");
            }else{
                throw new DataVerifyException("主险险别不能为空");
            }
            if(StringUtils.isNotEmpty(premiumMainStr)){
                 premiumMain = premiumMainStr.split("\\|");
            }else{
                throw new DataVerifyException("主险保费不能为空");
            }
            if(StringUtils.isNotEmpty(kindCodeSubStr)){
                kindCodeSub = kindCodeSubStr.split("\\|");
            }
            if(StringUtils.isNotEmpty(itemKindNoSubStr)){
                itemKindNoSub = itemKindNoSubStr.split("\\|");
            }
            if(StringUtils.isNotEmpty(premiumSubStr)){
                premiumSub = premiumSubStr.split("\\|");
            }


            if(mainCounts>0){
                for(int i=0;i<mainCounts;i++){
                    itemKindDto = new PrpTitemKindDto();
                    itemKindNo = itemKindNoMain[i];
                    kindCode = kindCodeMain[i];
                    premium = premiumMain[i];
                    //blPrpDkind.query("kindcode='"+kindCode+"'");
                    //itemKindDto.setBusinessNo("");
                    itemKindDto.setRiskCode(riskCode);
                    itemKindDto.setItemKindNo(Integer.valueOf(itemKindNo));
                    itemKindDto.setKindCode(kindCode);
                    itemKindDto.setPremium(Double.parseDouble(premium));
                    itemKindList.add(itemKindDto);
                }
                if(subCounts>0){
                    for(int i=0;i<subCounts;i++){
                        itemKindDto = new PrpTitemKindDto();
                        itemKindNo = itemKindNoSub[i];
                        kindCode = kindCodeSub[i];
                        premium = premiumSub[i];
                       // itemKindDto.setBusinessNo("");
                        itemKindDto.setRiskCode(riskCode);
                        itemKindDto.setItemKindNo(Integer.valueOf(itemKindNo));
                        itemKindDto.setKindCode(kindCode);
                        itemKindDto.setPremium(Double.parseDouble(premium));
                        itemKindList.add(itemKindDto);
                    }
                }
                //封装pvatDto
                pvatDto.setFormula("2");//公式二 税额	= [应交保费（含税）/（1+税率）]* 税率 , 不含税保费=应交保费（含税）－ 税额
                pvatDto.setVatFeeType("1");//计算价税分离的费用类型
                pvatDto.setBusinessType("T");//业务类型 T-投保单
                pvatDto.setBusinessNo("");//业务单号;
                pvatDto.setComcode(comCode);//机构代码;
                pvatDto.setRiskCode(riskCode);
                pvatDto.setCurrency("CNY");
                pvatDto.setItemKindList(itemKindList);
                premiumVATDto = vatCalculate(pvatDto);
            }
        }
        CalNoTaxPremiumInfoDto calNoTaxPremiumInfoDto = new CalNoTaxPremiumInfoDto();
        calNoTaxPremiumInfoDto.setSumNoTaxPremium(String.valueOf(premiumVATDto.getSumNoTaxPremium()));
        calNoTaxPremiumInfoDto.setSumTaxFee(String.valueOf(premiumVATDto.getSumTaxFee()));
        return calNoTaxPremiumInfoDto;
    }

    /**
     * 投保单共保信息价税分离
     *
     * @param blProposal
     * @throws Exception
     */
    private void dealTCoinsMainForYGZ(ProposalSaveDto blProposal) throws Exception {
        try {
            List<PrpTcoinsDetailDto> blPrpTcoinsDetail = blProposal.getPrpTcoinsDetailDtoList();
            if (blPrpTcoinsDetail == null || blPrpTcoinsDetail.size() == 0) {
                return;
            }
            CoinsVATDto cvatDto = new CoinsVATDto();
            ArrayList<PrpTcoinsDetailDto> coinsDetailList = new ArrayList<PrpTcoinsDetailDto>();
            PrpTmainDto prpTmainSchema = blProposal.getPrpTmainDto();
            PrpTcoinsDetailDto prpTcoinsDetailSchema = null;
            double ourCoinsRate = 0d;
            //封装cvatDto
            cvatDto.setFormula("2");//公式二
            cvatDto.setVatFeeType("1");
            cvatDto.setExpenseCalType("1");//手续费价税分离保费基数类型：1-按含税保费（默认）、2-不含税保费
            cvatDto.setBusinessNo(prpTmainSchema.getProposalNo());
            cvatDto.setComcode(prpTmainSchema.getComCode());//机构代码
            cvatDto.setRiskcode(prpTmainSchema.getRiskCode());//险种代码
            cvatDto.setCurrency(prpTmainSchema.getCurrency());
            cvatDto.setSumPremium(Double.parseDouble(chgStrZero(prpTmainSchema.getSumPremium() + "")));
            cvatDto.setSumNoTaxPremium(Double.parseDouble(chgStrZero(prpTmainSchema.getSumNoTaxPremium() + "")));
            cvatDto.setDutyRatio(0);//免税比例，如果传送itemKindList，则根据itemkindlist更新该字段
            PrpTcoinsDetailDto coinsDetailDto = null;
            for (int i = 0; i < blPrpTcoinsDetail.size(); i++) {
                prpTcoinsDetailSchema = blPrpTcoinsDetail.get(i);
                coinsDetailDto = new PrpTcoinsDetailDto();
                coinsDetailDto.setProposalNo(prpTcoinsDetailSchema.getProposalNo());
                coinsDetailDto.setCoinsCode(prpTcoinsDetailSchema.getCoinsCode());
                coinsDetailDto.setAgentFee(Double.parseDouble(chgStrZero(prpTcoinsDetailSchema.getAgentFee() + "")));
                coinsDetailDto.setOperateFee(Double.parseDouble(chgStrZero(prpTcoinsDetailSchema.getOperateFee() + "")));
                coinsDetailDto.setCoinsPremium(Double.parseDouble(chgStrZero(prpTcoinsDetailSchema.getCoinsPremium() + "")));
                for (int j = 0; j < blProposal.getPrpTcoinsDtoList().size(); j++) {
                    PrpTcoinsDto prpTcoinsSchema = blProposal.getPrpTcoinsDtoList().get(j);
                    if (prpTcoinsSchema.getCoinsCode().equals(prpTcoinsDetailSchema.getCoinsCode())) {
                        coinsDetailDto.setCoinsRate(Double.parseDouble(chgStrZero(prpTcoinsSchema.getCoinsRate() + "")) / 100);//共保比例;
                        if (prpTcoinsSchema.getCoinsType().equals("1")) {//我方
                            ourCoinsRate = Double.parseDouble(chgStrZero(prpTcoinsSchema.getCoinsRate() + "")) / 100;
                        }
                        break;
                    }
                }
                coinsDetailList.add(coinsDetailDto);
            }
            cvatDto.setCoinsRate(ourCoinsRate);
            cvatDto.setCoinsDetailList(coinsDetailList);
            //共保价税分离方法调用
            vatCalculate(cvatDto);
            //prptcoinsdetail回写
            for (int i = 0; i < blPrpTcoinsDetail.size(); i++) {
                prpTcoinsDetailSchema = blPrpTcoinsDetail.get(i);
                for (int j = 0; j < cvatDto.getCoinsDetailList().size(); j++) {
                    coinsDetailDto = cvatDto.getCoinsDetailList().get(j);
                    if (prpTcoinsDetailSchema.getCoinsCode().equals(coinsDetailDto.getCoinsCode())) {
                        prpTcoinsDetailSchema.setCoinsNoTaxPremium(coinsDetailDto.getCoinsNoTaxPremium());
                        prpTcoinsDetailSchema.setCoinsTaxFee(coinsDetailDto.getCoinsTaxFee());
                        prpTcoinsDetailSchema.setOperateTaxRate(coinsDetailDto.getOperateTaxRate());
                        prpTcoinsDetailSchema.setOperateNoTaxPremium(coinsDetailDto.getOperateNoTaxPremium());
                        prpTcoinsDetailSchema.setOperateTaxFee(coinsDetailDto.getOperateTaxFee());
                        prpTcoinsDetailSchema.setAgentNoTaxPremium(coinsDetailDto.getAgentNoTaxPremium());
                        prpTcoinsDetailSchema.setAgentTaxFee(coinsDetailDto.getAgentTaxFee());
                        break;
                    }
                }
            }
            //prptplancoins回写
            List<PrpTplanCoinsDto> blPrpTplanCoins = blProposal.getPrpTplanCoinsDtoList();
            List<PrpTplanCoinsDto> blPrpTplanCoinsTEMP = new ArrayList<PrpTplanCoinsDto>();
            PrpTplanCoinsDto prpTplanCoinsSchema = null;
            if (blPrpTplanCoins.size() > 0) {//农险政策性拆分
                for (int i = 0; i < blPrpTcoinsDetail.size(); i++) {
                    double tempSumNoTaxPremium = 0d;//调差用总不含税保费
                    double tempSumTaxFee = 0d;//调差用总税额
                    prpTcoinsDetailSchema = blPrpTcoinsDetail.get(i);
                    for (int j = 0; j < blPrpTplanCoins.size(); j++) {
                        prpTplanCoinsSchema = blPrpTplanCoins.get(j);
                        if (prpTcoinsDetailSchema.getCoinsCode().equals(prpTplanCoinsSchema.getCoinsCode())) {
                            blPrpTplanCoinsTEMP.add(prpTplanCoinsSchema);
                        }
                    }
                    for (int index = 0; index < blPrpTplanCoinsTEMP.size(); index++) {
                        prpTplanCoinsSchema = blPrpTplanCoinsTEMP.get(index);
                        if (blPrpTplanCoinsTEMP.size() == 1) {
                            prpTplanCoinsSchema.setNoTaxPremium(prpTcoinsDetailSchema.getCoinsNoTaxPremium());
                            prpTplanCoinsSchema.setTaxFee(prpTcoinsDetailSchema.getCoinsTaxFee());
                        } else {
                            //共保方业务拆分
                            if (index < blPrpTplanCoinsTEMP.size() - 1) {
                                prpTplanCoinsSchema.setNoTaxPremium(round(prpTcoinsDetailSchema.getCoinsNoTaxPremium() *
                                        ((prpTplanCoinsSchema.getPlanRate()) / 100), 2));
                                prpTplanCoinsSchema.setTaxFee(round(prpTcoinsDetailSchema.getCoinsTaxFee() *
                                        ((prpTplanCoinsSchema.getPlanRate()) / 100), 2));
                                tempSumNoTaxPremium = VATTools.add(tempSumNoTaxPremium, Double.parseDouble(chgStrZero(prpTplanCoinsSchema.getNoTaxPremium() + "")));
                                tempSumTaxFee = VATTools.add(tempSumTaxFee, Double.parseDouble(chgStrZero(prpTplanCoinsSchema.getTaxFee() + "")));
                            } else {//最后一条记录,调差
                                prpTplanCoinsSchema.setNoTaxPremium(VATTools.sub(prpTcoinsDetailSchema.getCoinsNoTaxPremium(), tempSumNoTaxPremium));
                                prpTplanCoinsSchema.setTaxFee(VATTools.sub(prpTcoinsDetailSchema.getCoinsTaxFee(), tempSumTaxFee));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * @Title: vatCalculate
	 * @Description:
	 * TODO保费价税分离计算接口方法
	 * TODO保费价税分离计算步骤：
	 * 投保：itemkindlist传入的为titemkindlist
	 * 1.根据传入的 PremiumVATSchema.vatFeeType判断是那种价税分离计算类型。
	 *   可传输计算类型为：保费、分入业务，为分入业务时，业务单可能无险别，需注意。
	 * 2.根据1，及传入的comcode、riskcode、kindcode，到基础税率表查询应税、免税标识、税率
	 * 3.根据常量类判断公式类型进行计算不含税保费、税额
	 *   公式1：
	 *   含税保费=应缴保费（现有的premium）
	 *   不含税保费=含税保费/（1+税率）;
	 *   税额=含税保费-不含税保费
	 *   公式2：
	 *   含税保费=应缴保费（现有的premium）
	 *   税额=含税保费/(1+税率)*税率
	 *   不含税保费=含税保费-税额;
	 *
	 *   免税比例=免税保费/合计不含税保费 *100%
	 *
	 * 批改： itemkindlist传入的为pitemkindlist，即为计算变化量
	 *
	 * 尾差处理：对itemkindlist根据税率分组，每组从小到大排序，
	 * 分别循环每组，按以下方式计算（设其中一组n条）
	 * 	分别计算该组前n-1条每一条的不含税保费、税额；
	 * 	汇总计算该组总的不含税保费、总税额
	 * 	第n条不含税保费、税额为，该组合计值与前n-1条的值求差的方式计算。
	 *
	 * @param PremiumVATSchema
	 * @return 包括了价税分离结果后的PremiumVATSchema
	 */
    private PremiumVATDto vatCalculate(PremiumVATDto pvatDto) throws Exception {
        String RiskCode = "";
        String KindCode = "";
        String TaxType = pvatDto.getVatFeeType();
        ArrayList<PrpTitemKindDto> list = null;
        Map<Double, ArrayList<PrpTitemKindDto>> map = new HashMap<Double, ArrayList<PrpTitemKindDto>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (pvatDto.getItemKindList() == null || pvatDto.getItemKindList().size() == 0) {
            PrpTitemKindDto itemKindDto = new PrpTitemKindDto();
            itemKindDto.setPremium(pvatDto.getSumPremium());
            itemKindDto.setOrderByPremium(Math.abs(itemKindDto.getPremium()));//取绝对值
            //根据当前时间取距离当前时间最近的一条税率
            //平台配置查费率
            ResponseGetTaxRateDto responseGetTaxRateDto = XmlFlatForm(pvatDto.getComcode(), pvatDto.getRiskCode(), KindCode, TaxType);
            if (responseGetTaxRateDto.getTaxRate() == null) {
                throw new Exception("未查询到对应机构、险种、险别下的增值税税率信息，请联系系统管理员！");
            }
            //平台配置
            itemKindDto.setTaxRate(responseGetTaxRateDto.getTaxRate());
            itemKindDto.setTaxFlag(responseGetTaxRateDto.getTaxFlag());
            itemKindDto.setTaxRate(0.0);
            itemKindDto.setTaxFlag("1");
            calculateTax(itemKindDto, pvatDto.getFormula());
            pvatDto.setSumNoTaxPremium(itemKindDto.getNoTaxPremium());
            pvatDto.setSumTaxFee(itemKindDto.getTaxFee());
            return pvatDto;
        }
        //取税率，且对险别进行分组，可能有性能问题，待优化
        for (int i = 0; i < pvatDto.getItemKindList().size(); i++) {
            RiskCode = pvatDto.getItemKindList().get(i).getRiskCode();
            KindCode = pvatDto.getItemKindList().get(i).getKindCode();
            //根据当前时间取距离当前时间最近的一条税率
            // 平台配置查询费率
            ResponseGetTaxRateDto prpdriskkindtaxDto = XmlFlatForm(pvatDto.getComcode(), RiskCode, KindCode, TaxType);
            if (prpdriskkindtaxDto.getTaxRate() == null) {
                throw new Exception("未查询到对应机构、险种、险别下的增值税税率信息，请联系系统管理员！");
            }
            pvatDto.getItemKindList().get(i).setTaxRate(prpdriskkindtaxDto.getTaxRate());
            pvatDto.getItemKindList().get(i).setTaxFlag(prpdriskkindtaxDto.getTaxFlag());
            if (pvatDto.getItemKindList().get(i).getPremium() != 0) {
                pvatDto.getItemKindList().get(i).setOrderByPremium(Math.abs(pvatDto.getItemKindList().get(i).getPremium()));//取绝对值
                if (map.containsKey(pvatDto.getItemKindList().get(i).getTaxRate())) {
                    map.get(pvatDto.getItemKindList().get(i).getTaxRate()).add(pvatDto.getItemKindList().get(i));
                } else {
                    list = new ArrayList<PrpTitemKindDto>();
                    list.add(pvatDto.getItemKindList().get(i));
                    map.put(pvatDto.getItemKindList().get(i).getTaxRate(), list);
                }
            } else {
                pvatDto.getItemKindList().get(i).setTaxFee(new Double(0));
                pvatDto.getItemKindList().get(i).setNoTaxPremium(new Double(0));
            }
        }
        Set<Double> set = map.keySet();
        Iterator<Double> iter = set.iterator();
        double tempTaxRate = 0d;
        double tempPremium = 0d;
        double sumPremium = 0d;//总含税保费
        double sumNoTaxPremium = 0d;//总不含税保费
        double sumTaxFee = 0d;//总税额
        double sumNoPayTaxPremium = 0d;//总的免税保费
        double sumPremiumTemp = 0d;//总含税保费 分组计算用
        double sumTaxFeeTemp = 0d;//总税额 分组计算用
        double sumNoTaxPremiumTemp = 0d;//总不含税保费 分组计算用
        Map<String, PrpTitemKindDto> map1 = new HashMap<String, PrpTitemKindDto>();
        ComparatorChain chain = new ComparatorChain();
        chain.addComparator(new BeanComparator("orderByPremium"));//按金额绝对值排序
        //计算每个险别的不含税保费、税额
        while (iter.hasNext()) {
            tempTaxRate = iter.next();
            list = map.get(tempTaxRate);
            Collections.sort(list, chain);
            sumPremiumTemp = 0d;
            sumTaxFeeTemp = 0d;
            sumNoTaxPremiumTemp = 0d;
            for (int i = 0; i < list.size(); i++) {
                sumPremium = VATTools.add(sumPremium, list.get(i).getPremium());
                sumPremiumTemp = VATTools.add(sumPremiumTemp, list.get(i).getPremium());
                if (Double.compare(list.get(i).getTaxRate(), 0) == 0
                        || VATConstantDto.TAKFLAG_2.equals(pvatDto.getItemKindList().get(i).getTaxFlag())) {
                    sumNoPayTaxPremium = VATTools.add(sumNoPayTaxPremium, list.get(i).getPremium());
                }
                if (i < (list.size() - 1) || i == 0) {
                    calculateTax(list.get(i), pvatDto.getFormula());
                    sumNoTaxPremium = VATTools.add(sumNoTaxPremium, list.get(i).getNoTaxPremium());
                    sumTaxFee = VATTools.add(sumTaxFee, list.get(i).getTaxFee());
                    sumNoTaxPremiumTemp = VATTools.add(sumNoTaxPremiumTemp, list.get(i).getNoTaxPremium());
                    sumTaxFeeTemp = VATTools.add(sumTaxFeeTemp, list.get(i).getTaxFee());
                } else {
                    tempPremium = list.get(i).getPremium();
                    list.get(i).setPremium(sumPremiumTemp);
                    calculateTax(list.get(i), pvatDto.getFormula());
                    list.get(i).setPremium(tempPremium);
                    list.get(i).setNoTaxPremium(VATTools.sub(list.get(i).getNoTaxPremium(), sumNoTaxPremiumTemp));
                    list.get(i).setTaxFee(VATTools.sub(list.get(i).getTaxFee(), sumTaxFeeTemp));
                    sumNoTaxPremium = VATTools.add(sumNoTaxPremium, list.get(i).getNoTaxPremium());
                    sumTaxFee = VATTools.add(sumTaxFee, list.get(i).getTaxFee());
                }
                map1.put(String.valueOf(list.get(i).getItemKindNo()), list.get(i));
            }
        }
        pvatDto.setSumPremium(sumPremium);
        pvatDto.setSumNoTaxPremium(sumNoTaxPremium);
        pvatDto.setSumTaxFee(sumTaxFee);
        if (sumNoTaxPremium == 0d) {
            pvatDto.setDutyRatio(0);
        } else {
            pvatDto.setDutyRatio(VATTools.div(sumNoPayTaxPremium, sumNoTaxPremium, 2));
        }
        return pvatDto;
    }

    //判断工具
    private String chgStrZero(String str) {
        if (str.equals("null")||str == null || str.equals("")) {
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

    /*
     *
	 * @Title: vatCalculate
	 * @Description: 共保业务保费、出单费、手续费价税分离计算方法
	 *  计算步骤：
	 * 投保：
	 * 联共保保费对应的税额计算：
	 * 循环CoinsDetaillist
	 *   如果itemkindlist.size>0 则
	 *     循环itemkindlist的不含税保费乘以共保比例的和，作为共保的不含税保费；共保含税保费-共保不含税保费作为共保人保费税额。
	 *   否则，使用CoinsVATDto 中总不含税保费乘以共保比例，作为共保的不含税保费；共保含税保费-共保不含税保费作为共保人保费税额。
	 *     尾差考虑方式：同投保保费价税分离
	 * 联共保对应的出单费税额计算：
	 *     根据配置的出单费税率、含税出单费，计算不含税出单费；含税出单费-不含税出单费作为当前共保人出单费税额。
	 * 联共保对应的手续费税额计算：
	 *     根据传入的免税比例，结合共保人的含税手续费，根据公式计算不含税手续费。
	 *     共保人的含税手续费-不含税共保手续费作为共保人手续费税额

	 * 批改：itemkindlist 为prppitemkind
	 * 共保保费变化量（含税）对应的税额变化量计算：
	 * 循环CoinsDetaillist
	 *   如果itemkindlist.size>0 则
	 *     循环itemkindlist的不含税保费变化量乘以共保比例的和，得到共保不含税保费变化量（考虑尾差，同投保）。
	 *   否则，使用   CoinsVATDto 中总不含税保费变化量乘以共保比例，得到共保不含税保费变化量
	 *     根据公式，共保含税保费变化量-共保不含税保费变化量，作为共保保费变化量对应税额变化量
	 * 共保出单费变化量（含税）对应的税额变化量计算：
	 *     含税出单费变化量，根据公式计算不含税出单费变化量，前者两个相减得到出单费税额变化量。
	 * 共保手续费变化量（含税）对应的税额变化量计算：
	 *     根据最新免税比例（入参）、共保含税手续费变化量，按公式计算不含税的共保手续费变化量，前者两个相减得到手续费税额变化量。
	 * @param cvatSchema
	 * @return
	 */
    private CoinsVATDto vatCalculate(CoinsVATDto cvatDto) throws Exception {

        double sumPremium = 0d;//总含税保费
        double sumNoTaxPremium = 0d;//总不含税保费
        double coinsRate = 1d; //从共保比例  如果为主共保则为1
        coinsRate = cvatDto.getCoinsRate();//国元主共业务也存我方金额，故都需要coinsrate
        //如果传入了险别，则根据险别列表汇总：含税保费、不含税保费
        if (cvatDto.getItemKindList() != null && cvatDto.getItemKindList().size() > 0) {
            for (int i = 0; i < cvatDto.getItemKindList().size(); i++) {
                sumPremium = VATTools.add(sumPremium, VATTools.div(cvatDto.getItemKindList().get(i).getPremium(), coinsRate, 2));
                sumNoTaxPremium = VATTools.add(sumNoTaxPremium, VATTools.div(cvatDto.getItemKindList().get(i).getNoTaxPremium(), coinsRate, 2));
            }
        } else {
            if (coinsRate != 0) {
                sumPremium = VATTools.div(cvatDto.getSumPremium(), coinsRate, 2);
                sumNoTaxPremium = VATTools.div(cvatDto.getSumNoTaxPremium(), coinsRate, 2);
            }
        }
        PrpTcoinsDetailDto coinsDetailDto = null;
        double sumCoinsNoTaxPremium = 0d;//尾差处理  除了最后一位的共保不含税保费
        double coinsPremium = 0d;//共保含税保费
        double coinsNoTaxPremium = 0d;//共保不含税保费
        double coinsTaxFee = 0d;//共保税额
        // Collections.sort(cvatDto.getCoinsDetailList(),null);//排序
        boolean isTotal = false;
        for (int i = 0; i < cvatDto.getCoinsDetailList().size(); i++) {
            //计算保费税额
            coinsDetailDto = cvatDto.getCoinsDetailList().get(i);
            coinsPremium = coinsDetailDto.getCoinsPremium(); //VATTools.mul(sumPremium, coinsDetailDto.getCoinsRate());
            coinsNoTaxPremium = VATTools.mul(sumNoTaxPremium, coinsDetailDto.getCoinsRate());
            coinsTaxFee = VATTools.sub(coinsPremium, coinsNoTaxPremium);
            coinsDetailDto.setCoinsTaxFee(coinsTaxFee);
            coinsDetailDto.setCoinsNoTaxPremium(coinsNoTaxPremium);
            if ((!isTotal && i == cvatDto.getCoinsDetailList().size() - 2) ||
                    (i == cvatDto.getCoinsDetailList().size() - 1 && i != 0 && isTotal)) {//倒数第二条调差,和倒数第一条
                coinsPremium = coinsDetailDto.getCoinsPremium(); //VATTools.sub(sumPremium, sumCoinsPremium);
                coinsNoTaxPremium = VATTools.sub(sumNoTaxPremium, sumCoinsNoTaxPremium);
                coinsTaxFee = VATTools.sub(coinsPremium, coinsNoTaxPremium);
                coinsDetailDto.setCoinsTaxFee(coinsTaxFee);
                coinsDetailDto.setCoinsNoTaxPremium(coinsNoTaxPremium);
            } else {
                if (!"0".equals(coinsDetailDto.getCoinsCode())) {
                    sumCoinsNoTaxPremium = VATTools.add(sumCoinsNoTaxPremium, coinsNoTaxPremium);
                } else {
                    isTotal = true;
                }
            }
        }
        return cvatDto;
    }

    /*
     *
	 * @Title: calculateTax
	 * @Description:
	 * TODO
	 * 根据不同的公式计算不含税保费、税额
	 * @param itemKindDto 险别对象
	 * @param formula
	 * 		    税额计算公式1：税额=含税保费-不含税保费
	 * 		    税额计算公式2：税额=含税保费/(1+税率)*税率
	 */
    private void calculateTax(PrpTitemKindDto itemKindDto, String formula) {
        if (formula == null || "".equals(formula.trim()) || VATConstantDto.FORMULA_2.equals(formula)) {
            calculateTax2(itemKindDto);
        } else {
            calculateTax1(itemKindDto);
        }

    }

    /*
     *
	 * @Title: calculateTax2
	 * @Description:
	 * TODO 保费价税分离计算公司2
	 * TODO
	 *   公式2：
	 *   含税保费=应缴保费（现有的premium）
	 *   税额=含税保费/(1+税率)*税率
	 *   不含税保费=含税保费-税额;
	 * @param itemKindDto 险别列表对象
	 */
    private void calculateTax2(PrpTitemKindDto itemKindDto) {
        //不含税保费
        double noTaxPremium = 0d;
        //税额
        double taxFee = 0d;

        taxFee = VATTools.mul((itemKindDto.getPremium() / (1 + itemKindDto.getTaxRate())), itemKindDto.getTaxRate());
        noTaxPremium = VATTools.sub(itemKindDto.getPremium(), taxFee);

        itemKindDto.setNoTaxPremium(noTaxPremium);
        itemKindDto.setTaxFee(taxFee);

    }

    /*
     *
	 * @Title: calculateTax1
	 * @Description:
	 * TODO保费价税分离计算公式1
	 * TODO
	 * 公式1：
	 *   含税保费=应缴保费（现有的premium）
	 *   不含税保费=含税保费/（1+税率）;
	 *   税额=含税保费-不含税保费
	 * @param itemKindDto 险别列表对象
	 */
    private void calculateTax1(PrpTitemKindDto itemKindDto) {
        //不含税保费
        double noTaxPremium = 0d;
        //税额
        double taxFee = 0d;

        noTaxPremium = VATTools.div(itemKindDto.getPremium(), (1 + itemKindDto.getTaxRate()), 2);
        taxFee = VATTools.sub(itemKindDto.getPremium(), noTaxPremium);

        itemKindDto.setNoTaxPremium(noTaxPremium);
        itemKindDto.setTaxFee(taxFee);

    }

    /**
     * 与再保对接查询税率
     * @author: 钱浩
     * @date: 2017/11/2 19:13
     */
    public ResponseGetTaxRateDto XmlFlatForm(String comCode, String riskCode, String kindCode, String taxType)throws Exception {
//        RequestGetTaxRateDto requestGetTaxRateDto = new RequestGetTaxRateDto();
//        requestGetTaxRateDto.setComCode(comCode);
//        requestGetTaxRateDto.setRiskCode(riskCode);
//        requestGetTaxRateDto.setKindCode(kindCode);
//        requestGetTaxRateDto.setTaxType(taxType);
//        PacketDto requestpacketDto = new PacketDto();
//        requestpacketDto.setBody(requestGetTaxRateDto);
//        XmlUtil xmlUtil = new XmlUtil();
//        String requestXml = xmlUtil.packetDtoToXml_bodyDto(requestpacketDto);
//        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
//        jaxWsProxyFactoryBean.setServiceClass(AgriPrpallPlatformService.class);
//        jaxWsProxyFactoryBean.setAddress(webserviceUrl2+"/webAgriPrpallService/services/AgriPrpallPlatformService?wsdl".trim());
//        AgriPrpallPlatformService newAgriPrpallPlatformService = (AgriPrpallPlatformService) jaxWsProxyFactoryBean.create();
//        String rsponseXml = newAgriPrpallPlatformService.getRiskTaxRate(requestXml);
//        PacketDto<ResponseGetTaxRateDto> rsponsepacketDto = xmlUtil.xmlToPacketDto_bodyDto(rsponseXml, ResponseGetTaxRateDto.class);
//        String statusCode = rsponsepacketDto.getHead().getReturnStatusCode();
//        if ("9999".equals(statusCode)) {
//            throw new BusinessException(rsponsepacketDto.getHead().getReturnMessage());
//        }
//        ResponseGetTaxRateDto responseGetTaxRateDto = rsponsepacketDto.getBody();
//        return responseGetTaxRateDto;
        PrpDriskKindTaxAgriDto prpDriskKindTaxDto = new PrpDriskKindTaxAgriDto();
        PrpDriskKindTaxAgriDto responseprpDriskKindTaxDto = new PrpDriskKindTaxAgriDto();
        prpDriskKindTaxDto.setComCode(comCode);
        prpDriskKindTaxDto.setKindCode(kindCode);
        prpDriskKindTaxDto.setRiskCode(riskCode);
        prpDriskKindTaxDto.setTaxRateType(taxType);
        prpDriskKindTaxDto.setValidDate(new Date());
        responseprpDriskKindTaxDto = prpDriskKindTaxAgriApi.findTaxRateByLowerComcodeToUpper(prpDriskKindTaxDto);
        ResponseGetTaxRateDto responseGetTaxRateDto = new ResponseGetTaxRateDto();
        responseGetTaxRateDto.setTaxFlag(responseprpDriskKindTaxDto.getTaxFlag());
        responseGetTaxRateDto.setTaxRate(responseprpDriskKindTaxDto.getTaxRate());
        return responseGetTaxRateDto;
    }

//    /**
//     * @description: 获取comcode及其上级的集合
//     * @author: 钱浩
//     * @date: 2017/11/4 16:36
//     */
//    public List<String> getComCode(String comCode) {
//        String icomcode = comCode;
//        String upComCode = "";
//        List<String> list = new ArrayList<String>();
//        list.add(icomcode);
//        StringBuffer buffer = new StringBuffer();
//        //循环存comcode到list
//        do {
//            buffer.append(" select UpperComCode from prpdcompany where comcode='");
//            buffer.append(icomcode);
//            buffer.append("'");
//            Query nativeQuery = entityManager.createNativeQuery(buffer.toString());
//            Object object = nativeQuery.getSingleResult();
//            upComCode = object.toString();
//            if (!icomcode.equals(upComCode)) {
//                icomcode = upComCode;
//            } else {
//                return list;
//            }
//            list.add(icomcode);
//            buffer.setLength(0);
//        } while (true);
//
//    }

}