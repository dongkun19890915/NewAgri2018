


package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndorRefreshPlanService;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.PrpDexchApi;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SpecialEndorRefreshPlanServiceImpl extends BaseServiceImpl implements SpecialEndorRefreshPlanService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SpecialEndorRefreshPlanServiceImpl.class);

    @Autowired
    private PrpCmainDao prpCmainDao;

    @Autowired
    private PrpDexchApi prpDexchApi;

    @Autowired
    private PrpDcurrencyApi prpDcurrencyApi;

    /**
     * 刷新缴费计划
     * @author: 刘曼曼
     * @date: 2017/12/15 9:39
     * @param responseQueryPolicyInfoDtoNew 页面的保单大对象
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDtoOld 查询的保单大对象
     * @return ResponseQueryPolicyInfoDto 保单大对象
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseQueryPolicyInfoDto refreshPlanByPayTimes(ResponseQueryPolicyInfoDto responseQueryPolicyInfoDtoNew, BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDtoOld) throws Exception {
        if (responseQueryPolicyInfoDtoNew == null) {
            responseQueryPolicyInfoDtoNew = new ResponseQueryPolicyInfoDto();
        }

        Date validDate = blEndorseDto.getPrpPheadDto().getValidDate(); //批改生效日期
        Double dbPremium1Old = 0.0; // 查询的应缴金额
        Double dbPremium1New = 0.0; //页面获得的自缴保费
        Double dbSumPremium1Old = 0.0; //查询的应缴金额汇总
        Double dbSumPremium1New = 0.0;//页面获得的自缴保费汇总
        Double dbChgPremium1 = 0.0;
        int intRowsCount = 0;
        String riskCode = responseQueryPolicyInfoDtoOld.getPrpCmainDto().getRiskCode();//险种
        Date strstartDate = responseQueryPolicyInfoDtoOld.getPrpCmainDto().getStartDate();//起保日期
        Date endDate = responseQueryPolicyInfoDtoOld.getPrpCmainDto().getEndDate();//终保日期
        //总的保费
        Double sumPremium1 = responseQueryPolicyInfoDtoNew.getPrpCmainDto().getSumPremium();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String strValidDate = sdf.format(validDate);
        Date startDate=sdf.parse(strValidDate);

        if("3119".equals(riskCode)){
            for(int i=0;i<=responseQueryPolicyInfoDtoNew.getPrpCitemKindDtoList().size();i++){
                dbPremium1New=responseQueryPolicyInfoDtoNew.getPrpCitemKindDtoList().get(i).getPremium();
                if (null == dbPremium1New) {
                    dbPremium1New = 0.0;
                }
                //自缴保费汇总
                dbSumPremium1New = dbSumPremium1New + dbPremium1New;
            }
        }
        //原值
        List<PrpCplanDto> prpCplanDtoList=responseQueryPolicyInfoDtoOld.getPrpCplanDtoList();
        for(int i=0;i<prpCplanDtoList.size();i++){
            dbPremium1Old = prpCplanDtoList.get(i).getPlanFee();
            if(null == dbPremium1Old){
                dbPremium1Old=0.0;
            }
            //应缴金额汇总
            dbSumPremium1Old = dbSumPremium1Old+dbPremium1Old;
        }

        dbChgPremium1 = new BigDecimal((dbSumPremium1New - dbSumPremium1Old)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        if("3".equals(riskCode.charAt(0))){
            //获得查询的总保费
            Double premiumOld = responseQueryPolicyInfoDtoOld.getPrpCmainDto().getSumPremium();
            //页面获得总保费
            Double premiumNew = responseQueryPolicyInfoDtoNew.getPrpCmainDto().getSumPremium();

            //计算补贴变化
            dbPremium1Old=0.0; //查询补贴保费汇总
            dbPremium1New=0.0; //页面获得的补贴保费汇总
            Double dbSubsidyPremium1Old=0.0; //查询的补贴保费
            Double dbSubsidyPremium1New=0.0; //页面获得的补贴保费

            for(int i=0;i<responseQueryPolicyInfoDtoNew.getPrpCsubsidyDtoList().size();i++){
                dbSubsidyPremium1Old=responseQueryPolicyInfoDtoOld.getPrpCsubsidyDtoList().get(i).getSubsidyPremium();
                dbSubsidyPremium1New=responseQueryPolicyInfoDtoNew.getPrpCsubsidyDtoList().get(i).getSubsidyPremium();
                if(null != dbSubsidyPremium1New){
                    dbSubsidyPremium1New=0.0;
                }
                dbPremium1Old = dbPremium1Old + dbSubsidyPremium1Old;
                dbPremium1New = dbPremium1New + dbSubsidyPremium1New;

                if(null == dbPremium1Old){
                    dbPremium1Old = 0.0;
                }
                if(null == dbPremium1New){
                    dbPremium1New = 0.0;
                }
                if(null == premiumOld){
                    premiumOld = 0.0;
                }
                if(null == premiumNew){
                    premiumNew = 0.0;
                }
            }

            //获得差额
            Double premiumchge = new BigDecimal(premiumNew-premiumOld).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            Double subsidychge =  new BigDecimal(dbPremium1New-dbPremium1Old).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            if(premiumchge!=subsidychge){
                intRowsCount = responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().size();
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayReason("P10");//签单收保费
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayNo(0);
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanStartDate(startDate);
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanDate(responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).getPlanStartDate());
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setCurrency(responseQueryPolicyInfoDtoNew.getPrpCfeeDtoList().get(intRowsCount-1).getCurrency1());
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setCurrency(prpDcurrencyApi.translateCode(responseQueryPolicyInfoDtoNew.getPrpCfeeDtoList().get(intRowsCount-1).getCurrency1(), LanguageFlagConstant.CHINESE));
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanFee(new BigDecimal(premiumchge-subsidychge).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                Double planRate=calculatePlanRate(responseQueryPolicyInfoDtoNew.getPrpCsubsidyDtoList());
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanRate(planRate);
                Double planFee= new BigDecimal(responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).getPlanFee()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setDelinquentFee(planFee);;
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayRefFee(0.0);
            }
        }

        List<PrpCsubsidyDto> prpCsubsidyDtoListNew=responseQueryPolicyInfoDtoNew.getPrpCsubsidyDtoList();
        for (int i = 0; i <prpCsubsidyDtoListNew.size(); i++) {
            //查询的补贴保费
            dbPremium1Old = responseQueryPolicyInfoDtoOld.getPrpCsubsidyDtoList().get(i).getSubsidyPremium();
            //页面获得的补贴保费
            dbPremium1New = responseQueryPolicyInfoDtoNew.getPrpCsubsidyDtoList().get(i).getSubsidyPremium();
            if (null == dbPremium1Old) {
                dbPremium1Old = 0.0;
            }
            if (null == dbPremium1New) {
                dbPremium1New = 0.0;
            }
            //补贴保费差额
            dbChgPremium1 = new BigDecimal((dbPremium1New - dbPremium1Old)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            if (dbChgPremium1 != 0) {
                //增加一行
                intRowsCount = responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().size();
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayNo(0);
                //缴费起期
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanStartDate(strstartDate);
                //缴费止期
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanDate(endDate);
                //缴费原因
                String[] subsidyCodes=blEndorseDto.getEndorseConditionDto().getSubsidyCode();
                String[] subsidyRates=blEndorseDto.getEndorseConditionDto().getSubsidyRate();
                if("03".equals(subsidyCodes[i])){
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayReason("RS3");
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayReasonName("中央财政");
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanRate(Double.valueOf(subsidyRates[i]));
                }
                if("04".equals(subsidyCodes[i])){
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayReason("RS4");
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayReasonName("省级财政");
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanRate(Double.valueOf(subsidyRates[i]));
                }
                if("05".equals(subsidyCodes[i])){
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayReason("RS5");
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayReasonName("地市财政");
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanRate(Double.valueOf(subsidyRates[i]));
                }
                if("06".equals(subsidyCodes[i])){
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayReason("RS6");
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayReasonName("其他来源");
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanRate(Double.valueOf(subsidyRates[i]));
                }
                if("07".equals(subsidyCodes[i])){
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayReason("RS7");
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayReasonName("县(区)财政)");
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanRate(Double.valueOf(subsidyRates[i]));
                }
                //币别
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setCurrency(responseQueryPolicyInfoDtoNew.getPrpCfeeDtoList().get(0).getCurrency1());
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanCurrencyName(prpDcurrencyApi.translateCode(responseQueryPolicyInfoDtoNew.getPrpCfeeDtoList().get(0).getCurrency1(), LanguageFlagConstant.CHINESE));
                //应缴金额,最后一条记录的值为总保费减缴费计划中的汇总金额，避免一分钱问题
                if(i==responseQueryPolicyInfoDtoOld.getPrpCsubsidyDtoList().size()){
                    //获得当前缴费计划汇总金额与总保费的差额
                    Double planFee=calPlanFeeToPremium(responseQueryPolicyInfoDtoNew.getPrpCmainDto(),responseQueryPolicyInfoDtoNew.getPrpCplanDtoList(),responseQueryPolicyInfoDtoNew.getPrpCfeeDtoList());
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanFee(planFee);
                }else{
                    Double strPlanFee =new BigDecimal(dbChgPremium1).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                    responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPlanFee(strPlanFee);
                }

                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setDelinquentFee(responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).getPlanFee());
                //实缴金额
                responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(intRowsCount-1).setPayRefFee(0.00);
            }
        }
        //检查缴费计划中的汇总金额与总保费是否一致
        checkPlanPayFee(responseQueryPolicyInfoDtoNew);

        return responseQueryPolicyInfoDtoNew;
    }

    /**
     * 计算缴费计划的总保费
     * @author: 刘曼曼
     * @date: 2017/12/15 9:45
     * @param responseQueryPolicyInfoDtoNew 保单大对象
     * @return Boolean
     * @throws Exception
     */
    @Override
    public Boolean  checkPlanPayFee(ResponseQueryPolicyInfoDto responseQueryPolicyInfoDtoNew) throws Exception {
        //总保费
        Double sumPremium1 = responseQueryPolicyInfoDtoNew.getPrpCmainDto().getSumPremium();
        Double dbSumPremium1 = new BigDecimal(sumPremium1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        Double dbSumPremiumPlan = 0.0; //缴费计划的总保费
        int intRowsCount =responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().size();
        if(dbSumPremium1==0.0) {
           dbSumPremium1=getSumAmountPermiumFee(responseQueryPolicyInfoDtoNew.getPrpCfeeDtoList());//修改返回总保费
        }
        //异常处理
        if(intRowsCount==0) {
            intRowsCount = 1;
        }

        //得到缴费计划的总保费
        for(int i=0;i<intRowsCount;i++){
            dbSumPremiumPlan = dbSumPremiumPlan+responseQueryPolicyInfoDtoNew.getPrpCplanDtoList().get(i).getPlanFee();
        }
        dbSumPremiumPlan = new BigDecimal(dbSumPremiumPlan).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        if(dbSumPremiumPlan!=dbSumPremium1){
            throw new DataVerifyException("缴费计划的各项保费总和不等于保单总保费!");
        }
        return true;
    }

    /**
     * 获得总保费
     * @author: 刘曼曼
     * @date: 2017/12/15 9:47
     * @param prpCfeeDtoListNew 保单保额保费表集合
     * @return Double 总保费
     * @throws Exception
     */
    @Override
    public Double getSumAmountPermiumFee(List<PrpCfeeDto> prpCfeeDtoListNew) throws Exception {
        //原币
        Double dbSumAmount = 0.0;
        Double dbSumPremium = 0.0;
        //保单汇总币别
        Double dbSumAmount2 = 0.0;
        Double dbSumPremium2 = 0.0;
        //支付保费币别
        Double dbSumAmount1 = 0.0;
        Double dbSumPremium1 = 0.0;
        //总不含税保费
        Double dbSumNoTaxPremium1 = 0.0;

        //获得原币，保单汇总币别，支付保费币别，总不含税保费
        for(int i=0;i<prpCfeeDtoListNew.size();i++) {
            dbSumAmount = dbSumAmount + prpCfeeDtoListNew.get(i).getAmount();
            dbSumPremium = dbSumPremium + prpCfeeDtoListNew.get(i).getPremium();
            dbSumAmount2 = dbSumAmount2 + prpCfeeDtoListNew.get(i).getAmount2();
            dbSumPremium2 = dbSumPremium2 + prpCfeeDtoListNew.get(i).getPremium2();
            dbSumAmount1 = dbSumAmount1 + prpCfeeDtoListNew.get(i).getAmount1();
            dbSumPremium1 = dbSumPremium1 + prpCfeeDtoListNew.get(i).getPremium1();
            dbSumNoTaxPremium1 = dbSumNoTaxPremium1 + prpCfeeDtoListNew.get(i).getNoTaxPremium1();

        }
            //控制四舍五入
            Double sumAmount=new BigDecimal(dbSumAmount).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            Double sumPremium=new BigDecimal(dbSumPremium).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            Double sumAmount2=new BigDecimal(dbSumAmount2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            Double sumPremium2=new BigDecimal(dbSumPremium2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            Double sumAmount1=new BigDecimal(dbSumAmount1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            Double sumPremium1=new BigDecimal(dbSumPremium1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            Double sumNoTaxPremium1=new BigDecimal(dbSumNoTaxPremium1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return sumPremium1;
    }

    /**
     * 计算当前缴费计划汇总金额与总保费的差额
     * @author: 刘曼曼
     * @date: 2017/12/13 15:48
     * @param prpCmainDto，prpCplanDtoList，prpCfeeDtoList 保单主表信息，收费计划表信息，保单保额保费信息
     * @return Double 当前缴费计划汇总金额与总保费的差额
     * @throws Exception
     */
    @Override
    public Double calPlanFeeToPremium(PrpCmainDto prpCmainDto, List<PrpCplanDto> prpCplanDtoList, List<PrpCfeeDto> prpCfeeDtoList)throws Exception {

        Double sumPremium1 = prpCmainDto.getSumPremium();//总保费
        Double dbSumPremium1 = new BigDecimal(sumPremium1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        Double dbSumPremiumPlan = 0.0;//当前缴费计划汇总金额
        Double dbSumPremiumPlanTemp = 0.0;//应缴费金额
        Integer intRowsCount = prpCplanDtoList.size();
        if (dbSumPremium1 == 0) {
            dbSumPremium1= getSumAmountPermiumFee(prpCfeeDtoList);
        }
        //异常处理
        if (null == intRowsCount) {
            intRowsCount = 1;
        }

        //得到缴费计划的总保费
        for (int i = 1; i <= intRowsCount; i++) {
            dbSumPremiumPlanTemp = prpCplanDtoList.get(i).getPlanFee();
            if (null == dbSumPremiumPlanTemp) {
                dbSumPremiumPlanTemp = 0.0;
            }
            dbSumPremiumPlan = dbSumPremiumPlan + dbSumPremiumPlanTemp;

        }
        dbSumPremiumPlan = new BigDecimal(dbSumPremiumPlan).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return new BigDecimal(dbSumPremium1 - dbSumPremiumPlan).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 计算自缴比例的方法
     * @author: 刘曼曼
     * @date: 2017/12/13 15:47
     * @param prpCsubsidyDtoList 补贴信息集合
     * @return Double 自缴比例
     */
    public Double calculatePlanRate(List<PrpCsubsidyDto> prpCsubsidyDtoList){
        Double subsidyRate =0.00;
        Double planRate= 100.0;
        for(int i=1;i<prpCsubsidyDtoList.size();i++)
        {
            subsidyRate += prpCsubsidyDtoList.get(i).getSubsidyRate();
        }
        planRate = planRate - subsidyRate;
        return new BigDecimal(planRate).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}