package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.common.util.VATTools;
import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCcoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.PrpTcoinsApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.CoinsVATDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PremiumVATDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTcoinsDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.VATConstantDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePMainForYGZService;
import com.sinosoft.framework.agri.core.utils.Str;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.pms.api.rate.PrpDriskKindTaxApi;
import com.sinosoft.pms.api.rate.dto.PrpDriskKindTaxDto;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GeneratePMainForYGZServiceImpl implements GeneratePMainForYGZService {
    @Autowired
    private PrpDriskKindTaxApi prpdriskkindtaxApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpTcoinsApi PrpTcoinsApi;
    /**
     *  批单价税分离
     * @author: 王心洋
     * @date: 2017/10/26 16:18
     * @param blPolicyDtoNew 页面传入保单数据
     * @param blEndorseDto 页面传入批单数据
     */
    @Override
    public void dealPMainForYGZ(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception {

            PremiumVATDto chgvatDto = new PremiumVATDto();
            ArrayList<ItemKindDto> chgitemKindList = new ArrayList<>();
            PrpCPmainDto prpCPmainDto = blEndorseDto.getPrpCPmainDto();
            PrpPmainDto prpPmainDto = blEndorseDto.getPrpPmainDto();
            PrpPfeeDto prpPfeeDto = null;
            ItemKindDto ItemKindDto = null;
            String endorseNo = prpPmainDto.getEndorseNo();

            //封装chgvatDto;
            chgvatDto.setFormula("2");//公式二
            chgvatDto.setVatFeeType("1");//计算价税分离的费用类型
            chgvatDto.setBusinessType("E");//业务类型 -批单
            chgvatDto.setBusinessNo(endorseNo);//业务单号;
            chgvatDto.setComcode(prpPmainDto.getComCode());//机构代码;
            chgvatDto.setRiskCode(prpPmainDto.getRiskCode());
            chgvatDto.setCurrency(prpPmainDto.getCurrency());
            if(prpPmainDto.getChgPremium()==null)
                prpPmainDto.setChgPremium(0.00);
            chgvatDto.setSumPremium(prpPmainDto.getChgPremium());

            List<PrpPitemKindDto> prpPitemKindDtoList = blEndorseDto.getPrpPitemKindDtoList();
            for(int i=0;i<prpPitemKindDtoList.size();i++){
                PrpPitemKindDto prpPitemKindDto = prpPitemKindDtoList.get(i);
                ItemKindDto = new ItemKindDto();
                ItemKindDto.setBusinessNo(prpPitemKindDto.getPolicyNo());
                ItemKindDto.setRiskCode(prpPitemKindDto.getRiskCode());
                ItemKindDto.setItemKindNo(prpPitemKindDto.getItemKindNo()+"");
                ItemKindDto.setKindCode(prpPitemKindDto.getKindCode());
                ItemKindDto.setAmount(Double.parseDouble(chgDoubleZero(prpPitemKindDto.getChgAmount())));
                ItemKindDto.setPremium(Double.parseDouble(chgDoubleZero(prpPitemKindDto.getChgPremium())));
                chgitemKindList.add(ItemKindDto);
            }
            chgvatDto.setItemKindDtoList(chgitemKindList);
            vatCalculatePrem(chgvatDto);

            //封装P表数据
            //prpPmain
            prpPmainDto.setChgNoTaxPremium(chgvatDto.getSumNoTaxPremium());
            prpPmainDto.setChgTaxFee(chgvatDto.getSumTaxFee());

            //prpPitemKind
            prpPitemKindDtoList = blEndorseDto.getPrpPitemKindDtoList();
            chgitemKindList = chgvatDto.getItemKindDtoList();
            for(int i = 0; i < prpPitemKindDtoList.size(); i++){
                String itemkindno = prpPitemKindDtoList.get(i).getItemKindNo()+"";
                Iterator it = chgitemKindList.iterator();
                while (it.hasNext()) {
                    ItemKindDto = (ItemKindDto) it.next();
                    if (itemkindno.equals(ItemKindDto.getItemKindNo())) {
                        prpPitemKindDtoList.get(i).setTaxFlag(ItemKindDto.getTaxFlag());
                        prpPitemKindDtoList.get(i).setTaxRate(ItemKindDto.getTaxRate());
                        prpPitemKindDtoList.get(i).setChgNoTaxPremium(ItemKindDto.getNoTaxPremium());
                        prpPitemKindDtoList.get(i).setChgTaxFee(ItemKindDto.getTaxFee());
                        break;
                    }
                }
            }

            //prppfee
            if(blEndorseDto.getPrpPfeeDtoList() != null && blEndorseDto.getPrpPfeeDtoList().size()>0){
                prpPfeeDto = blEndorseDto.getPrpPfeeDtoList().get(0);
                prpPfeeDto.setChgTaxPremium(chgvatDto.getSumNoTaxPremium());
                prpPfeeDto.setChgTaxPremium1(chgvatDto.getSumNoTaxPremium());
                prpPfeeDto.setChgTaxPremium2(chgvatDto.getSumNoTaxPremium());
                prpPfeeDto.setChgTaxFee(chgvatDto.getSumTaxFee());
                prpPfeeDto.setChgTaxFee1(chgvatDto.getSumTaxFee());
                prpPfeeDto.setChgTaxFee2(chgvatDto.getSumTaxFee());
            }

            //prpPplan
            if(blEndorseDto.getPrpPplanDtoList()!=null && blEndorseDto.getPrpPplanDtoList().size()==1){
                PrpPplanDto prpPplanSchema =blEndorseDto.getPrpPplanDtoList().get(0);
                prpPplanSchema.setNoTaxPremium(chgvatDto.getSumNoTaxPremium());
                prpPplanSchema.setTaxFee(chgvatDto.getSumTaxFee());
            }else{
                //分期业务;
                double tempSumNoTaxPremium = 0d;//调差用总不含税保费
                for(int i=0;i<blEndorseDto.getPrpPplanDtoList().size();i++){
                    PrpPplanDto prpPplanSchema = blEndorseDto.getPrpPplanDtoList().get(i);
                    if(chgvatDto.getSumPremium() == 0){ //批改收付原因,变化保费为0;
                        prpPplanSchema.setNoTaxPremium(prpPplanSchema.getPlanFee());
                        prpPplanSchema.setTaxFee(0.00);
                    }else{
                        if(i<blEndorseDto.getPrpPplanDtoList().size()-1){
                            prpPplanSchema.setNoTaxPremium(Str.round((chgvatDto.getSumNoTaxPremium() *
                                    (Double.parseDouble(chgDoubleZero(prpPplanSchema.getPlanFee())) / chgvatDto.getSumPremium())),2));
                            tempSumNoTaxPremium = VATTools.add(tempSumNoTaxPremium,Double.parseDouble(chgDoubleZero(prpPplanSchema.getNoTaxPremium())));
                        }else{
                            //最后一期，调差;
                            prpPplanSchema.setNoTaxPremium(VATTools.sub(chgvatDto.getSumNoTaxPremium(),tempSumNoTaxPremium));
                        }
                        prpPplanSchema.setTaxFee(VATTools.sub(prpPplanSchema.getPlanFee(),prpPplanSchema.getNoTaxPremium()));
                    }
                }
            }

            //封装CP对象
            //prpCPmain
            double chgSumNoTaxPremium=Double.parseDouble(chgDoubleZero(prpPmainDto.getChgNoTaxPremium()));
            double chgSumTaxFee=Double.parseDouble(chgDoubleZero(prpPmainDto.getChgTaxFee()));
            double sumNoTaxPremiumOld=Double.parseDouble(chgDoubleZero(prpPmainDto.getSumNoTaxPremium()));
            double sumTaxFeeOld=Double.parseDouble(chgDoubleZero(prpPmainDto.getSumTaxFee()));
            double sumNoTaxPremiumNew= VATTools.add(sumNoTaxPremiumOld,chgSumNoTaxPremium);
            double sumTaxFeeNew=VATTools.add(sumTaxFeeOld,chgSumTaxFee);

            prpCPmainDto.setSumNoTaxPremium(sumNoTaxPremiumNew);
            prpCPmainDto.setSumTaxFee(sumTaxFeeNew);

            //prpCPitemKind;
            PrpPitemKindDto prpPitemKindDto;
            PrpCPitemKindDto prpCPitemKindDto;
            double chgNoTaxPremium;
            double chgTaxFee;
            double NoTaxPremiumOld;
            double TaxFeeOld;
            double NoTaxPremiumNew;
            double TaxFeeNew;
            for(int i=0; i< prpPitemKindDtoList.size();i++){
                prpPitemKindDto=prpPitemKindDtoList.get(i);
                for (int j=0;j<blEndorseDto.getPrpCPitemKindDtoList().size();j++){
                    prpCPitemKindDto=blEndorseDto.getPrpCPitemKindDtoList().get(j);
                    if(prpCPitemKindDto.getItemKindNo().equals(prpPitemKindDto.getItemKindNo())){
                        chgNoTaxPremium=Double.parseDouble(chgDoubleZero(prpPitemKindDto.getChgNoTaxPremium()));
                        chgTaxFee=Double.parseDouble(chgDoubleZero(prpPitemKindDto.getChgTaxFee()));
                        NoTaxPremiumOld=Double.parseDouble(chgDoubleZero(prpPitemKindDto.getNoTaxPremium()));
                        TaxFeeOld=Double.parseDouble(chgDoubleZero(prpPitemKindDto.getTaxFee()));
                        NoTaxPremiumNew=VATTools.add(NoTaxPremiumOld,chgNoTaxPremium);
                        TaxFeeNew=VATTools.add(TaxFeeOld,chgTaxFee);
                        prpCPitemKindDto.setNoTaxPremium(NoTaxPremiumNew);
                        prpCPitemKindDto.setTaxFee(TaxFeeNew);
                        break;
                    }
                }
            }
            //设置TaxRate、TaxFlag
            for(int i=0;i<chgvatDto.getItemKindDtoList().size();i++){
                ItemKindDto=chgvatDto.getItemKindDtoList().get(i);
                for (int j=0;j<blEndorseDto.getPrpCPitemKindDtoList().size();j++){
                    prpCPitemKindDto=blEndorseDto.getPrpCPitemKindDtoList().get(j);
                    if(prpCPitemKindDto.getItemKindNo().equals(ItemKindDto.getItemKindNo())){
                        prpCPitemKindDto.setTaxRate(ItemKindDto.getTaxRate());
                        prpCPitemKindDto.setTaxFlag(ItemKindDto.getTaxFlag());
                        break;
                    }
                }
            }



            //prpCPfee
            if(blEndorseDto.getPrpCPfeeDtoList() != null){
                PrpCPfeeDto prpCPfeeDto = blEndorseDto.getPrpCPfeeDtoList().get(0);
                double NotaxPremiumOld=Double.parseDouble(chgDoubleZero(prpCPfeeDto.getNoTaxPremium()));
                double taxFeeOld=Double.parseDouble(chgDoubleZero(prpCPfeeDto.getTaxFee()));
                double NotaxPremiumOld1=Double.parseDouble(chgDoubleZero(prpCPfeeDto.getNoTaxPremium1()));
                double taxFeeOld1=Double.parseDouble(chgDoubleZero(prpCPfeeDto.getTaxFee1()));
                double NotaxPremiumOld2=Double.parseDouble(chgDoubleZero(prpCPfeeDto.getNoTaxPremium2()));
                double taxFeeOld2=Double.parseDouble(chgDoubleZero(prpCPfeeDto.getTaxFee2()));
                if(prpPfeeDto==null){//金额没变化，pfee没数据
                    prpPfeeDto = new PrpPfeeDto();
                }
                double NotaxPremiumChg=Double.parseDouble(chgDoubleZero(prpPfeeDto.getChgTaxPremium()));
                double taxFeeChg=Double.parseDouble(chgDoubleZero(prpPfeeDto.getChgTaxFee()));
                double NotaxPremiumChg1=Double.parseDouble(chgDoubleZero(prpPfeeDto.getChgTaxPremium1()));
                double taxFeeChg1=Double.parseDouble(chgDoubleZero(prpPfeeDto.getChgTaxFee1()));
                double NotaxPremiumChg2=Double.parseDouble(chgDoubleZero(prpPfeeDto.getChgTaxPremium2()));
                double taxFeeChg2=Double.parseDouble(chgDoubleZero(prpPfeeDto.getChgTaxFee2()));

                prpCPfeeDto.setNoTaxPremium(VATTools.add(NotaxPremiumOld,NotaxPremiumChg));
                prpCPfeeDto.setNoTaxPremium1(VATTools.add(NotaxPremiumOld1,NotaxPremiumChg1));
                prpCPfeeDto.setNoTaxPremium2(VATTools.add(NotaxPremiumOld2,NotaxPremiumChg2));
                prpCPfeeDto.setTaxFee(VATTools.add(taxFeeOld,taxFeeChg));
                prpCPfeeDto.setTaxFee1(VATTools.add(taxFeeOld1,taxFeeChg1));
                prpCPfeeDto.setTaxFee2(VATTools.add(taxFeeOld2,taxFeeChg2));
            }

            PrpCPplanDto prpCPplanDto = null;
            List<PrpCPplanDto> blPrpCPplanDtoList = new ArrayList<>();
            for(int i=0;i<blEndorseDto.getPrpCPplanDtoList().size();i++){ //获得只有该批单的plan记录
                prpCPplanDto = blEndorseDto.getPrpCPplanDtoList().get(i);
                if(endorseNo.equals(prpCPplanDto.getEndorseNo())){
                    blPrpCPplanDtoList.add(prpCPplanDto);
                }
            }
            if(blPrpCPplanDtoList.size() == 1){
                prpCPplanDto = blPrpCPplanDtoList.get(0);
                prpCPplanDto.setNoTaxPremium(chgvatDto.getSumNoTaxPremium()); //变化量的价税分离
                prpCPplanDto.setTaxFee(chgvatDto.getSumTaxFee());//变化量的价税分离
            }else{
                //分期业务拆分
                double tempSumNoTaxPremium = 0d;//调差用总不含税保费
                for(int i=0;i<blPrpCPplanDtoList.size();i++){
                    prpCPplanDto = blPrpCPplanDtoList.get(i);
                    if(chgvatDto.getSumPremium() == 0){ //批改收付原因,变化保费为0;
                        prpCPplanDto.setNoTaxPremium(prpCPplanDto.getPlanFee());
                        prpCPplanDto.setTaxFee(0.00);
                    }else{
                        if(i<blPrpCPplanDtoList.size()-1){
                            prpCPplanDto.setNoTaxPremium(Str.round((chgvatDto.getSumNoTaxPremium() *
                                    (Double.parseDouble(chgDoubleZero(prpCPplanDto.getPlanFee())) / chgvatDto.getSumPremium())),2));
                            tempSumNoTaxPremium = VATTools.add(tempSumNoTaxPremium,Double.parseDouble(chgDoubleZero(prpCPplanDto.getNoTaxPremium())));
                        }else{//最后一条记录,调差
                            prpCPplanDto.setNoTaxPremium(VATTools.sub(chgvatDto.getSumNoTaxPremium(),tempSumNoTaxPremium));
                        }
                        prpCPplanDto.setTaxFee(VATTools.sub(Double.parseDouble(chgDoubleZero(prpCPplanDto.getPlanFee())),Double.parseDouble(chgDoubleZero(prpCPplanDto.getNoTaxPremium()))));
                    }
                }
            }
            //共保处理
            if(blEndorseDto.getPrpCPcoinsDetailDtoList()!=null&&blEndorseDto.getPrpCPcoinsDetailDtoList().size()!=0)
            this.dealPCoinsMainForYGZ(blPolicyDtoNew, blEndorseDto);

    }
    public String chgStrZero(String str){
        if(StringUtils.isEmpty(str)){
            str = "0";
        }
        return str;
    }

    public String chgDoubleZero(Double a){
        String str;
        if(a == null ){
            str = "0";
        }else{
            str = a + "";
        }
        return str;
    }

    /**
     *  保费价税分离计算接口方法
     * 保费价税分离计算步骤：
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
     * @author 王心洋
     * @time 2017-11-06
     * @param pvatDto 保费价税分离计算封装dto
     * @return 包括了价税分离结果后的PremiumVATDto
     */
    private PremiumVATDto vatCalculatePrem(PremiumVATDto pvatDto) throws Exception {

        String RiskCode = "";
        String KindCode = "";
        String taxRateType = pvatDto.getVatFeeType();
        ArrayList<ItemKindDto> list = null;

        Map<Double, ArrayList<ItemKindDto>> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if(pvatDto.getItemKindDtoList()==null || pvatDto.getItemKindDtoList().size()==0){

            ItemKindDto itemKindDto = new ItemKindDto();

            itemKindDto.setPremium(pvatDto.getSumPremium());
            itemKindDto.setOrderByPremium(Math.abs(itemKindDto.getPremium()));//取绝对值
            //根据当前时间取距离当前时间最近的一条税率
            PrpDriskKindTaxDto prpdriskkindtaxDto =getRiskTaxDto(pvatDto.getComcode(), pvatDto.getRiskCode(), KindCode, taxRateType,sdf.format(new Date()));
            if(prpdriskkindtaxDto==null){
                throw new Exception("未查询到对应机构、险种、险别下的增值税税率信息，请联系系统管理员！");
            }
            itemKindDto.setTaxRate(prpdriskkindtaxDto.getTaxRate());
            itemKindDto.setTaxFlag(prpdriskkindtaxDto.getTaxFlag());

            calculateTax(itemKindDto, pvatDto.getFormula());

            pvatDto.setSumNoTaxPremium(itemKindDto.getNoTaxPremium());
            pvatDto.setSumTaxFee(itemKindDto.getTaxFee());

            return pvatDto;
        }

        //取税率，且对险别进行分组，可能有性能问题，待优化
        for(int i=0;i<pvatDto.getItemKindDtoList().size();i++){

            RiskCode = pvatDto.getItemKindDtoList().get(i).getRiskCode();
            KindCode = pvatDto.getItemKindDtoList().get(i).getKindCode();

            //根据当前时间取距离当前时间最近的一条税率
            PrpDriskKindTaxDto prpdriskkindtaxDto =getRiskTaxDto(pvatDto.getComcode(), RiskCode, KindCode, taxRateType,sdf.format(new Date()));
            if(prpdriskkindtaxDto==null){
                throw new Exception("未查询到对应机构、险种、险别下的增值税税率信息，请联系系统管理员！");
            }
            pvatDto.getItemKindDtoList().get(i).setTaxRate(prpdriskkindtaxDto.getTaxRate());
            pvatDto.getItemKindDtoList().get(i).setTaxFlag(prpdriskkindtaxDto.getTaxFlag());
            if(pvatDto.getItemKindDtoList().get(i).getPremium() !=0){
                pvatDto.getItemKindDtoList().get(i).setOrderByPremium(Math.abs(pvatDto.getItemKindDtoList().get(i).getPremium()));//取绝对值
                if(map.containsKey(pvatDto.getItemKindDtoList().get(i).getTaxRate())){
                    map.get(pvatDto.getItemKindDtoList().get(i).getTaxRate()).add(pvatDto.getItemKindDtoList().get(i));
                }else{
                    list = new ArrayList<>();
                    list.add(pvatDto.getItemKindDtoList().get(i));
                    map.put(pvatDto.getItemKindDtoList().get(i).getTaxRate(), list );
                }
            }else{
                pvatDto.getItemKindDtoList().get(i).setTaxFee(0);
                pvatDto.getItemKindDtoList().get(i).setNoTaxPremium(0);
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
        Map<String, ItemKindDto> map1 = new HashMap<String, ItemKindDto>();
        ComparatorChain chain =  new ComparatorChain();
        chain.addComparator(new BeanComparator("orderByPremium"));//按金额绝对值排序
        //计算每个险别的不含税保费、税额
        while(iter.hasNext()){
            tempTaxRate = iter.next();
            list = map.get(tempTaxRate);
            Collections.sort(list, chain);
            sumPremiumTemp = 0d;
            sumTaxFeeTemp = 0d;
            sumNoTaxPremiumTemp = 0d;
            for(int i=0;i<list.size();i++){
                sumPremium = VATTools.add(sumPremium,list.get(i).getPremium());
                sumPremiumTemp = VATTools.add(sumPremiumTemp,list.get(i).getPremium());
                if(Double.compare(list.get(i).getTaxRate(), 0)==0
                        || VATConstantDto.TAKFLAG_2.equals(pvatDto.getItemKindDtoList().get(i).getTaxFlag())){
                    sumNoPayTaxPremium = VATTools.add(sumNoPayTaxPremium,list.get(i).getPremium());
                }
                if(i<(list.size()-1) || i==0){
                    calculateTax(list.get(i),pvatDto.getFormula());
                    sumNoTaxPremium = VATTools.add(sumNoTaxPremium,list.get(i).getNoTaxPremium());
                    sumTaxFee = VATTools.add(sumTaxFee,list.get(i).getTaxFee());
                    sumNoTaxPremiumTemp = VATTools.add(sumNoTaxPremiumTemp,list.get(i).getNoTaxPremium());
                    sumTaxFeeTemp = VATTools.add(sumTaxFeeTemp,list.get(i).getTaxFee());
                }else{
                    tempPremium = list.get(i).getPremium();
                    list.get(i).setPremium(sumPremiumTemp);
                    calculateTax(list.get(i),pvatDto.getFormula());
                    list.get(i).setPremium(tempPremium);
                    list.get(i).setNoTaxPremium(VATTools.sub(list.get(i).getNoTaxPremium(),sumNoTaxPremiumTemp));
                    list.get(i).setTaxFee(VATTools.sub(list.get(i).getTaxFee(),sumTaxFeeTemp));
                    sumNoTaxPremium = VATTools.add(sumNoTaxPremium,list.get(i).getNoTaxPremium());
                    sumTaxFee = VATTools.add(sumTaxFee,list.get(i).getTaxFee());
                }
                map1.put(list.get(i).getItemKindNo(), list.get(i));
            }
        }
        pvatDto.setSumPremium(sumPremium);
        pvatDto.setSumNoTaxPremium(sumNoTaxPremium);
        pvatDto.setSumTaxFee(sumTaxFee);
        if(sumNoTaxPremium == 0d){
            pvatDto.setDutyRatio(0);
        }else{
            pvatDto.setDutyRatio(VATTools.div(sumNoPayTaxPremium,sumNoTaxPremium,2));
        }
        return pvatDto;
    }

    /**
     *  批单共保信息价税分离
     * @author 王心洋
     * @time 2017-11-06
     * @param blPolicyDtoNew 保单信息dto
     * @param blEndorseDto 批单信息dto
     * @throws Exception
     */
    public void dealPCoinsMainForYGZ(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto) throws Exception{

        List<PrpCPcoinsDetailDto> blPrpCPcoinsDetailDtoList = blEndorseDto.getPrpCPcoinsDetailDtoList();
        if(blPrpCPcoinsDetailDtoList.size() == 0){
            return;
        }
        CoinsVATDto cpvatDto = new CoinsVATDto();
        CoinsVATDto chgvatDto = new CoinsVATDto();
        ArrayList<CoinsDetailDto> cpcoinsDetailList = new ArrayList<CoinsDetailDto>();
        ArrayList<CoinsDetailDto> pcoinsDetailList = new ArrayList<CoinsDetailDto>();

        PrpCPmainDto prpCPmainSchema = blEndorseDto.getPrpCPmainDto();
        PrpPmainDto prpPmainDto = blEndorseDto.getPrpPmainDto();
        String endorseNo = prpPmainDto.getEndorseNo();
        String proposalno = prpPmainDto.getProposalNo();
        List<PrpTcoinsDto> blPrpTcoinsDtoList = new ArrayList<>();
        double ourCoinsRate = 0d;
        //封装CP参数;
        cpvatDto.setFormula("2");//公式二
        cpvatDto.setVatFeeType("1");
        cpvatDto.setExpenseCalType("1");
        cpvatDto.setBusinessNo(endorseNo);
        cpvatDto.setComcode(prpCPmainSchema.getComCode());//机构代码;
        cpvatDto.setRiskcode(prpCPmainSchema.getRiskCode());
        cpvatDto.setCurrency(prpCPmainSchema.getCurrency());
        cpvatDto.setSumPremium(Double.parseDouble(chgDoubleZero(prpCPmainSchema.getSumPremium())));
        cpvatDto.setSumNoTaxPremium(Double.parseDouble(chgDoubleZero(prpCPmainSchema.getSumNoTaxPremium())));
        cpvatDto.setDutyRatio(0);

        CoinsDetailDto coinsDetailDto = null;
        for(int i=0;i<blPrpCPcoinsDetailDtoList.size();i++){
            PrpCPcoinsDetailDto prpCPcoinsDetailDto = blPrpCPcoinsDetailDtoList.get(i);
            coinsDetailDto = new CoinsDetailDto();
            coinsDetailDto.setBusinessNo(endorseNo);
            coinsDetailDto.setCoinsCode(prpCPcoinsDetailDto.getCoinsCode());
            coinsDetailDto.setAgentFee(Double.parseDouble(chgDoubleZero(prpCPcoinsDetailDto.getAgentFee())));
            coinsDetailDto.setOperateFee(Double.parseDouble(chgDoubleZero(prpCPcoinsDetailDto.getOperateFee())));
            coinsDetailDto.setCoinsPremium(Double.parseDouble(chgDoubleZero(prpCPcoinsDetailDto.getCoinsPremium())));
            for(int j = 0;j < blPolicyDtoNew.getPrpCcoinsDtoList().size(); j++){
                PrpCcoinsDto prpCcoinsDto = blPolicyDtoNew.getPrpCcoinsDtoList().get(j);
                if(prpCcoinsDto.getCoinsCode().equals(prpCPcoinsDetailDto.getCoinsCode())){
                    coinsDetailDto.setCoinsRate(Double.parseDouble(chgDoubleZero(prpCcoinsDto.getCoinsRate()))/100);//最新共保比例;
                    if(prpCcoinsDto.getCoinsType().equals("1")){//我方
                        ourCoinsRate = Double.parseDouble(chgDoubleZero(prpCcoinsDto.getCoinsRate()))/100;
                    }
                    break;
                }
            }
            cpcoinsDetailList.add(coinsDetailDto);
        }
        if(ourCoinsRate == 0){
            blPrpTcoinsDtoList = PrpTcoinsApi.findByProposalNo(proposalno);//如果Ccoins表共保比例为0,获取Tcoins表中的共保比例;
            CoinsDetailDto coinsDetailDtoCP = null;
            Iterator it = cpcoinsDetailList.iterator();
            while(it.hasNext()){
                coinsDetailDtoCP = (CoinsDetailDto)it.next();
                for(int index=0;index<blPrpTcoinsDtoList.size();index++){
                    PrpTcoinsDto prpTcoinsDto = blPrpTcoinsDtoList.get(index);
                    if(prpTcoinsDto.getCoinsCode().equals(coinsDetailDtoCP.getCoinsCode())){
                        coinsDetailDtoCP.setCoinsRate(Double.parseDouble(chgDoubleZero(prpTcoinsDto.getCoinsRate()))/100);
                        if(prpTcoinsDto.getCoinsType().equals("1")){//我方
                            ourCoinsRate = Double.parseDouble(chgDoubleZero(prpTcoinsDto.getCoinsRate()))/100;
                        }
                    }
                }
            }
        }
        cpvatDto.setCoinsRate(ourCoinsRate);
        cpvatDto.setCoinsDetailDtoList(cpcoinsDetailList);

        //封装P的参数;
        chgvatDto.setFormula("2");//公式二
        chgvatDto.setVatFeeType("1");
        chgvatDto.setExpenseCalType("1");
        chgvatDto.setBusinessNo(endorseNo);
        chgvatDto.setComcode(prpPmainDto.getComCode());//机构代码;
        chgvatDto.setRiskcode(prpPmainDto.getRiskCode());
        chgvatDto.setCurrency(prpPmainDto.getCurrency());
        chgvatDto.setSumPremium(Double.parseDouble(chgDoubleZero(prpPmainDto.getChgPremium())));
        chgvatDto.setSumNoTaxPremium(Double.parseDouble(chgDoubleZero(prpPmainDto.getChgNoTaxPremium())));
        chgvatDto.setDutyRatio(0);

        List<PrpPcoinsDetailDto> blPrpPcoinsDetail = blEndorseDto.getPrpPcoinsDetailDtoList();
        for(int i=0;i<blPrpPcoinsDetail.size();i++){
            PrpPcoinsDetailDto prpPcoinsDetailDto = blPrpPcoinsDetail.get(i);
            coinsDetailDto = new CoinsDetailDto();
            coinsDetailDto.setCoinsCode(prpPcoinsDetailDto.getCoinsCode());
            coinsDetailDto.setAgentFee(Double.parseDouble(chgDoubleZero(prpPcoinsDetailDto.getChgAgentFee())));
            coinsDetailDto.setOperateFee(Double.parseDouble(chgDoubleZero(prpPcoinsDetailDto.getChgOperateFee())));
            coinsDetailDto.setCoinsPremium(Double.parseDouble(chgDoubleZero(prpPcoinsDetailDto.getChgCoinsPremium())));

            for(int j = 0;j < blPolicyDtoNew.getPrpCcoinsDtoList().size(); j++){
                PrpCcoinsDto prpCcoinsDto = blPolicyDtoNew.getPrpCcoinsDtoList().get(j);
                if(prpCcoinsDto.getCoinsCode().equals(prpPcoinsDetailDto.getCoinsCode())){
                    coinsDetailDto.setCoinsRate(Double.parseDouble(chgDoubleZero(prpCcoinsDto.getCoinsRate()))/100);//共保比例;
                    if(prpCcoinsDto.getCoinsType().equals("1")){//我方
                        ourCoinsRate = Double.parseDouble(chgDoubleZero(prpCcoinsDto.getCoinsRate()))/100;
                    }
                    break;
                }
            }
            pcoinsDetailList.add(coinsDetailDto);
        }
        if(ourCoinsRate == 0){
            blPrpTcoinsDtoList = PrpTcoinsApi.findByProposalNo(proposalno);//如果Ccoins表共保比例为0,获取Tcoins表中的共保比例;
            CoinsDetailDto coinsDetailDtoP = null;
            Iterator it = pcoinsDetailList.iterator();
            while(it.hasNext()){
                coinsDetailDtoP = (CoinsDetailDto)it.next();
                for(int index=0;index<blPrpTcoinsDtoList.size();index++){
                    PrpTcoinsDto prpTcoinsDto = blPrpTcoinsDtoList.get(index);
                    if(prpTcoinsDto.getCoinsCode().equals(coinsDetailDtoP.getCoinsCode())){
                        coinsDetailDtoP.setCoinsRate(Double.parseDouble(chgDoubleZero(prpTcoinsDto.getCoinsRate()))/100);
                        if(prpTcoinsDto.getCoinsType().equals("1")){//我方
                            ourCoinsRate = Double.parseDouble(chgDoubleZero(prpTcoinsDto.getCoinsRate()))/100;
                        }
                    }
                }
            }
        }
        chgvatDto.setCoinsRate(ourCoinsRate);
        chgvatDto.setCoinsDetailDtoList(pcoinsDetailList);

        vatCalculateCoins(cpvatDto);
        vatCalculateCoins(chgvatDto);

        //CPcoinsDetail
        for(int i = 0 ; i < blPrpCPcoinsDetailDtoList.size() ; i++){
            PrpCPcoinsDetailDto prpCPcoinsDetailDto = blPrpCPcoinsDetailDtoList.get(i);
            for(int j=0 ; j < cpvatDto.getCoinsDetailDtoList().size() ; j++){
                coinsDetailDto = cpvatDto.getCoinsDetailDtoList().get(j);
                if(prpCPcoinsDetailDto.getCoinsCode().equals(coinsDetailDto.getCoinsCode())){
                    prpCPcoinsDetailDto.setCoinsNoTaxPremium(coinsDetailDto.getCoinsNoTaxPremium());
                    prpCPcoinsDetailDto.setCoinsTaxFee(coinsDetailDto.getCoinsTaxFee());
                    prpCPcoinsDetailDto.setOperateTaxRate(coinsDetailDto.getOperatetaxrate());
                    prpCPcoinsDetailDto.setOperateNoTaxPremium(coinsDetailDto.getOperateNoTaxPremium());
                    prpCPcoinsDetailDto.setOperateTaxFee(coinsDetailDto.getOperatetaxfee());
                    prpCPcoinsDetailDto.setAgentNoTaxPremium(coinsDetailDto.getAgentNoTaxPremium());
                    prpCPcoinsDetailDto.setAgentTaxFee(coinsDetailDto.getAgenttaxfee());
                    break;
                }
            }
        }

        //PcoinsDetail
        for(int i = 0 ; i < blPrpPcoinsDetail.size() ; i++){
            PrpPcoinsDetailDto prpPcoinsDetailDto = blPrpPcoinsDetail.get(i);
            for(int j=0 ; j < chgvatDto.getCoinsDetailDtoList().size() ; j++){
                coinsDetailDto = chgvatDto.getCoinsDetailDtoList().get(j);
                if(prpPcoinsDetailDto.getCoinsCode().equals(coinsDetailDto.getCoinsCode())){
                    prpPcoinsDetailDto.setOperateTaxRate((coinsDetailDto.getOperatetaxrate()));
                    prpPcoinsDetailDto.setChgCoinsNoTaxPremium(coinsDetailDto.getCoinsNoTaxPremium());
                    prpPcoinsDetailDto.setChgCoinsTaxFee(coinsDetailDto.getCoinsTaxFee());
                    prpPcoinsDetailDto.setChgOperateNoTaxPremium(Double.parseDouble(chgDoubleZero(coinsDetailDto.getOperateNoTaxPremium())));
                    prpPcoinsDetailDto.setChgOperateTaxFee(coinsDetailDto.getOperatetaxfee());
                    prpPcoinsDetailDto.setChgAgentNoTaxPremium(coinsDetailDto.getAgentNoTaxPremium());
                    prpPcoinsDetailDto.setChgAgentTaxFee(coinsDetailDto.getAgenttaxfee());
                    break;
                }
            }
        }

        //prpPplancoins
        List<PrpPplanCoinsDto> blPrpPplanCoins = blEndorseDto.getPrpPplanCoinsDtoList();
        PrpPplanCoinsDto prpPplanCoinsDto = null;
        if(blPrpPplanCoins.size()>0){//农险政策性拆分
            for(int i = 0 ; i < blPrpPcoinsDetail.size() ; i++){
                double tempChgNoTaxPremiumP = 0d;//调差用不含税保费变化量;
                double tempChgTaxFeeP = 0d; //调差用税额变化量;
                PrpPcoinsDetailDto prpPcoinsDetailDto = blPrpPcoinsDetail.get(i);
                List<PrpPplanCoinsDto> prpPplanCoinsDtoList =  new ArrayList<>();
                for(int j=0;j<blPrpPplanCoins.size();j++){
                    prpPplanCoinsDto = blPrpPplanCoins.get(j);
                    if(prpPcoinsDetailDto.getCoinsCode().equals(prpPplanCoinsDto.getCoinsCode())){
                        prpPplanCoinsDtoList.add(prpPplanCoinsDto);
                    }
                }
                for(int index=0;index<prpPplanCoinsDtoList.size();index++){
                    prpPplanCoinsDto = prpPplanCoinsDtoList.get(index);
                    if(prpPplanCoinsDtoList.size() == 1){
                        prpPplanCoinsDto.setNoTaxPremium(prpPcoinsDetailDto.getChgCoinsNoTaxPremium());
                        prpPplanCoinsDto.setTaxFee(prpPcoinsDetailDto.getChgCoinsTaxFee());
                    }else{
                        //共保方业务拆分
                        if(index<prpPplanCoinsDtoList.size()-1){
                            prpPplanCoinsDto.setNoTaxPremium(Str.round(Double.parseDouble(chgDoubleZero(prpPcoinsDetailDto.getChgCoinsNoTaxPremium())) *
                                    ((prpPplanCoinsDto.getPlanRate())/100),2));//chgnotaxpremium
                            prpPplanCoinsDto.setTaxFee(Str.round(Double.parseDouble(chgDoubleZero(prpPcoinsDetailDto.getChgCoinsTaxFee())) *
                                    ((prpPplanCoinsDto.getPlanRate())/100),2));//chgtaxfee
                            tempChgNoTaxPremiumP = VATTools.add(tempChgNoTaxPremiumP,Double.parseDouble(chgDoubleZero(prpPplanCoinsDto.getNoTaxPremium())));
                            tempChgTaxFeeP = VATTools.add(tempChgTaxFeeP,Double.parseDouble(chgDoubleZero(prpPplanCoinsDto.getTaxFee())));
                        }else{//最后一条记录,调差
                            prpPplanCoinsDto.setNoTaxPremium(VATTools.sub(prpPcoinsDetailDto.getChgCoinsNoTaxPremium(),tempChgNoTaxPremiumP));
                            prpPplanCoinsDto.setTaxFee(VATTools.sub(prpPcoinsDetailDto.getChgCoinsTaxFee(),tempChgTaxFeeP));
                        }
                    }
                }
            }
            if(blPrpPcoinsDetail.size() == 0 ){//批改补贴比例,没有保费变化，则没有P表数据;
                for(int j=0;j<blPrpPplanCoins.size();j++){
                    prpPplanCoinsDto = blPrpPplanCoins.get(j);
                    prpPplanCoinsDto.setNoTaxPremium(prpPplanCoinsDto.getPlanFee());
                    prpPplanCoinsDto.setTaxFee(0.00);
                }
            }
        }

        //prpCPplancoins
        List<PrpCPplanCoinsDto> prpCPplanCoinsDtoList = blEndorseDto.getPrpCPplanCoinsDtoList();
        PrpCPplanCoinsDto prpCPplanCoinsDto = null;
        if(prpCPplanCoinsDtoList.size()>0){//农险政策性拆分
            for(int i = 0 ; i < blPrpCPcoinsDetailDtoList.size() ; i++){
                PrpCPcoinsDetailDto prpCPcoinsDetailDto = blPrpCPcoinsDetailDtoList.get(i);
                List<PrpCPplanCoinsDto> blPrpCPplanCoinsTEMP =  new ArrayList<>();
                for(int j=0;j<prpCPplanCoinsDtoList.size();j++){
                    prpCPplanCoinsDto = prpCPplanCoinsDtoList.get(j);
                    if(prpCPcoinsDetailDto.getCoinsCode().equals(prpCPplanCoinsDto.getCoinsCode())){
                        blPrpCPplanCoinsTEMP.add(prpCPplanCoinsDto);
                    }
                }
                //循环判断，将P表数据赋到CP表新增数据中，原记录保持不变;
                for(int index=0;index<blPrpCPplanCoinsTEMP.size();index++){
                    prpCPplanCoinsDto = blPrpCPplanCoinsTEMP.get(index);
                    for(int k =0;k<blPrpPplanCoins.size();k++){
                        prpPplanCoinsDto = blPrpPplanCoins.get(k);
                        if(prpCPplanCoinsDto.getPayReason().equals(prpPplanCoinsDto.getPayReason())
                                && prpCPplanCoinsDto.getSerialNo().equals(prpPplanCoinsDto.getSerialNo())){
                            prpCPplanCoinsDto.setNoTaxPremium(prpPplanCoinsDto.getNoTaxPremium());
                            prpCPplanCoinsDto.setTaxFee(prpPplanCoinsDto.getTaxFee());
                        }
                    }
                }
            }
        }
    }
    /**
     * 得到险别税率 取靠近传入日期最近配置的费率 险别可以不传，如果险别不传则取该险种最新配置的费率
     * @param comcode  机构
     * @param riskcode  险种
     * @param kindcode  险别
     * @param taxRateType  税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率
     * @param validDate 当前日期
     * @return PrpdriskkindtaxDto
     * @throws Exception
     * @author 王心洋
     * @time 2017-11-11
     */
    public PrpDriskKindTaxDto getRiskTaxDto(String comcode,String riskcode,String kindcode,String taxRateType,String validDate)
            throws Exception{
        PrpDriskKindTaxDto prpdriskkindtaxDto = null;
        double result = 0d;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String comCodeTemp = comcode;
        PrpDriskKindTaxDto prpDriskKindTaxDto = new PrpDriskKindTaxDto();
        prpDriskKindTaxDto.setComCode(comcode);
        prpDriskKindTaxDto.setRiskCode(riskcode);
        prpDriskKindTaxDto.setKindCode(kindcode);
        prpDriskKindTaxDto.setTaxRateType(taxRateType);
        prpDriskKindTaxDto.setValidDate(sdf.parse(validDate));
        prpdriskkindtaxDto = prpdriskkindtaxApi.findTaxRateByLowerComcodeToUpper(prpDriskKindTaxDto);
        while(prpdriskkindtaxDto==null){//如果找不到，查该机构的核算单位的税率
            try {
                //如果当前机构没有配置 就一直查询上级核算单位的税率，直到总公司为止
                //对应的getCenterCode方法各项目组要根据自身实际代码调用
                comCodeTemp = prpDcompanyApi.queryByPK(comCodeTemp).getUpperComCode();
                if(StringUtils.isEmpty(comCodeTemp)){
                    throw new Exception("找不到该出单机构的核算单位");
                }
                prpDriskKindTaxDto.setComCode(comCodeTemp);

                prpdriskkindtaxDto = prpdriskkindtaxApi.findTaxRateByLowerComcodeToUpper(prpDriskKindTaxDto);
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("没有找到该机构及上级核算单位的基础税率！！");
            }
        }
        return prpdriskkindtaxDto;
    }
    /**
     * 根据不同的公式计算不含税保费、税额
     * @param itemKindDto 险别对象
     * @param formula
     * 		    税额计算公式1：税额=含税保费-不含税保费
     * 		    税额计算公式2：税额=含税保费/(1+税率)*税率
     * @author 王心洋
     * @time 2017-11-10
     */
    public void calculateTax(ItemKindDto itemKindDto,String formula){
        if(StringUtils.isEmpty(formula) || StringUtils.isEmpty(formula.trim()) || VATConstantDto.FORMULA_2.equals(formula) ){
            calculateTax2(itemKindDto);
        }else{
            calculateTax1(itemKindDto);
        }
    }
    /**
     * 保费价税分离计算公式1
     * 公式1：
     *   含税保费=应缴保费（现有的premium）
     *   不含税保费=含税保费/（1+税率）;
     *   税额=含税保费-不含税保费
     * @param itemKindDto 险别列表对象
     * @author 王心洋
     * @time 2017-11-10
     */
    public void calculateTax1(ItemKindDto itemKindDto){
        //不含税保费
        double noTaxPremium = 0d;
        //税额
        double taxFee = 0d;

        noTaxPremium = VATTools.div(itemKindDto.getPremium(),(1+itemKindDto.getTaxRate()),2);
        taxFee = VATTools.sub(itemKindDto.getPremium(),noTaxPremium);

        itemKindDto.setNoTaxPremium(noTaxPremium);
        itemKindDto.setTaxFee(taxFee);

    }
    /**
     * 保费价税分离计算公式2
     *   公式2：
     *   含税保费=应缴保费（现有的premium）
     *   税额=含税保费/(1+税率)*税率
     *   不含税保费=含税保费-税额;
     * @param itemKindDto 险别列表对象
     * @author 王心洋
     * @time 2017-11-10
     */
    public void calculateTax2(ItemKindDto itemKindDto){
        //不含税保费
        double noTaxPremium = 0d;
        //税额
        double taxFee = 0d;

        taxFee = VATTools.mul((itemKindDto.getPremium()/(1 + itemKindDto.getTaxRate())),itemKindDto.getTaxRate());
        noTaxPremium = VATTools.sub(itemKindDto.getPremium(), taxFee);

        itemKindDto.setNoTaxPremium(noTaxPremium);
        itemKindDto.setTaxFee(taxFee);

    }
    /**
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
     *
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
     * @param cvatDto
     * @return
     * @author 王心洋
     * @time 2017-11-10
     */
    public CoinsVATDto vatCalculateCoins(CoinsVATDto cvatDto) throws Exception{

        double sumPremium = 0d;//总含税保费
        double sumNoTaxPremium = 0d;//总不含税保费
        double coinsRate = 1d; //从共保比例  如果为主共保则为1
        coinsRate = cvatDto.getCoinsRate();//国元主共业务也存我方金额，故都需要coinsrate
        if(cvatDto.getItemKindList()!=null && cvatDto.getItemKindList().size()>0){
            for(int i=0;i<cvatDto.getItemKindList().size();i++){
                sumPremium = VATTools.add(sumPremium,VATTools.div(cvatDto.getItemKindList().get(i).getPremium(), coinsRate, 2) );
                sumNoTaxPremium = VATTools.add(sumNoTaxPremium, VATTools.div(cvatDto.getItemKindList().get(i).getNoTaxPremium(), coinsRate, 2) );
            }
        }else{
            if(coinsRate != 0){
                sumPremium = VATTools.div(cvatDto.getSumPremium(), coinsRate, 2);
                sumNoTaxPremium = VATTools.div(cvatDto.getSumNoTaxPremium(), coinsRate, 2);
            }
        }

        CoinsDetailDto coinsDetailDto = null;

        double sumCoinsNoTaxPremium = 0d;//尾差处理  除了最后一位的共保不含税保费
        double coinsPremium = 0d;//共保含税保费
        double coinsNoTaxPremium = 0d;//共保不含税保费
        double coinsTaxFee = 0d;//共保税额

        Collections.sort((List)cvatDto.getCoinsDetailDtoList());//排序
        boolean isTotal = false;
        for(int i=0;i<cvatDto.getCoinsDetailDtoList().size();i++){
            //计算保费税额
            coinsDetailDto = cvatDto.getCoinsDetailDtoList().get(i);
            coinsPremium = coinsDetailDto.getCoinsPremium();
            coinsNoTaxPremium = VATTools.mul(sumNoTaxPremium, coinsDetailDto.getCoinsRate());
            coinsTaxFee = VATTools.sub(coinsPremium, coinsNoTaxPremium);
            coinsDetailDto.setCoinsTaxFee(coinsTaxFee);
            coinsDetailDto.setCoinsNoTaxPremium(coinsNoTaxPremium);

            if((!isTotal && i == cvatDto.getCoinsDetailDtoList().size()-2)  ||
                    (i == cvatDto.getCoinsDetailDtoList().size()-1 && i!=0 && isTotal ) ){//倒数第二条调差,和倒数第一条
                coinsPremium = coinsDetailDto.getCoinsPremium();
                coinsNoTaxPremium = VATTools.sub(sumNoTaxPremium, sumCoinsNoTaxPremium);
                coinsTaxFee = VATTools.sub(coinsPremium, coinsNoTaxPremium);
                coinsDetailDto.setCoinsTaxFee(coinsTaxFee);
                coinsDetailDto.setCoinsNoTaxPremium(coinsNoTaxPremium);
            }else{
                if(!"0".equals(coinsDetailDto.getCoinsCode())){
                    sumCoinsNoTaxPremium = VATTools.add(sumCoinsNoTaxPremium, coinsNoTaxPremium);
                }else{
                    isTotal = true;
                }
            }
        }
        return cvatDto;
    }
}
