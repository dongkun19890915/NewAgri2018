package com.sinosoft.agriprpall.core.endorsemanage.util;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCsubsidyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndorItemKindService;
import com.sinosoft.dms.api.dict.PrpDexchApi;
import com.sinosoft.dms.api.dict.dto.PrpDexchDto;
import com.sinosoft.framework.agri.core.utils.Str;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDshortRateDto;
import com.sinosoft.utility.string.ChgData;
import com.sinosoft.utility.string.ChgDate;
import com.sinosoft.utility.string.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PubTools {


    @Autowired
    private SpecialEndorItemKindService specialEndorseItemKindService;
    @Autowired
    private PrpDexchApi prpDexchApi;


    public double getExchangeRate(String iBaseCurrency, String iExchCurrency, String iExchDate) throws Exception {
        double dblExchangeRate = 0.0;
        double dblExchangeRate2 = 0.0;
        double dblExchangeRate3 = 0.0;
        final ChgDate chgDate = new ChgDate();
        iExchDate = chgDate.toFormat(iExchDate);
        iBaseCurrency = iBaseCurrency.trim();
        iExchCurrency = iExchCurrency.trim();
        if (iBaseCurrency.equals(iExchCurrency)) {
            dblExchangeRate = 1.0;
            return dblExchangeRate;
        }
        if (iExchDate == null || iExchDate.length() == 0) {
            return dblExchangeRate;
        }
        iExchDate = iExchDate.substring(0, 10);
        dblExchangeRate = getStraightExchangeRate(iBaseCurrency, iExchCurrency, iExchDate);
        if (dblExchangeRate != 0.0) {
            return dblExchangeRate;
        }
        dblExchangeRate = getStraightExchangeRate(iExchCurrency, iBaseCurrency, iExchDate);
        if (dblExchangeRate != 0.0) {
            dblExchangeRate = 1.0 / dblExchangeRate;
            return dblExchangeRate;
        }
        dblExchangeRate2 = getStraightExchangeRate(iBaseCurrency, "USD", iExchDate);
        if (dblExchangeRate2 != 0.0) {
            dblExchangeRate3 = getStraightExchangeRate(iExchCurrency, "USD", iExchDate);
            if (dblExchangeRate3 != 0.0) {
                dblExchangeRate = dblExchangeRate2 / dblExchangeRate3;
                return dblExchangeRate;
            }
            dblExchangeRate3 = getStraightExchangeRate("USD", iExchCurrency, iExchDate);
            if (dblExchangeRate3 != 0.0) {
                dblExchangeRate = dblExchangeRate2 * dblExchangeRate3;
                return dblExchangeRate;
            }
        }
        dblExchangeRate2 = getStraightExchangeRate("USD", iBaseCurrency, iExchDate);
        if (dblExchangeRate2 != 0.0) {
            dblExchangeRate3 = getStraightExchangeRate(iExchCurrency, "USD", iExchDate);
            if (dblExchangeRate3 != 0.0) {
                dblExchangeRate = dblExchangeRate3 * dblExchangeRate2;
                return dblExchangeRate;
            }
            dblExchangeRate3 = getStraightExchangeRate("USD", iExchCurrency, iExchDate);
            if (dblExchangeRate3 != 0.0) {
                dblExchangeRate = dblExchangeRate3 / dblExchangeRate2;
                return dblExchangeRate;
            }
        }
        return dblExchangeRate;
    }

    private double getStraightExchangeRate(final String iBaseCurrency, final String iExchCurrency, String iExchDate) throws Exception {
        double dblExchangeRate = 0.0;
        String strWherePart = "";
        String strExchDate = "";
        int intCount = 0;
        final ChgDate chgDate = new ChgDate();
        iExchDate = chgDate.toFormat(iExchDate);
        final ChgData chgData = new ChgData();
        PrpDexchDto prpDexchDto = new PrpDexchDto();
        List<PrpDexchDto> prpDexchDtoList = prpDexchApi.queryMaxExchDateByConditions(iBaseCurrency,iExchCurrency,iExchDate);
        if (prpDexchDtoList.size()>0){
            prpDexchDto = prpDexchDtoList.get(0);
        }
        intCount = prpDexchDtoList.size();
        if (intCount == 0) {
            dblExchangeRate = 0.0;
            return dblExchangeRate;
        }
        strExchDate = prpDexchDto.getExchDate().toString();
        if (intCount > 0){
            intCount = 0;
        }else {
            intCount = 100;
        }
        if (intCount != 0) {
            dblExchangeRate = 0.0;
            return dblExchangeRate;
        }
        dblExchangeRate = Double.parseDouble(ChgData.chgStrZero(strExchDate));
        return dblExchangeRate;
    }

    /**
     * 得到下n个天
     *
     * @param strDate  起始时间
     * @param intCount 计算天数
     * @return 结果时间
     * @author 王心洋
     * @time 2017-11-11
     */
    public static String getNextDateFullDate(String strDate, int intCount) {
        String strReturn;
        strReturn = new java.sql.Date(java.sql.Date.valueOf(strDate).getTime() + (intCount * 24 * 60 * 60 * 1000)).toString();
        return strReturn;
//        DateUtil.dateAddDay()
//        DateUtil.differentDays
//        DateUtil.differentMonth
    }

    /**
     * @param strRiskCode      险种
     * @param startDate        时间段的起始日期
     * @param intStartHour     时间段起始小时数
     * @param endDate          时间段的终止日期
     * @param intEndHour       时间段的终止小时数
     * @param strShortRateFlag 短期费率方式（1 短期费率表、4 月比例、2 日比例、3 不计）
     * @return Double dblShortRate短期系数
     * @desc 获取给定险种的短期系数（短期费率表、月比例、日比例、不计）
     * @desc 是业务系统UICommon.js中的短期费率计算的java实现
     * @author 王心洋
     * @time 2017-11-11
     */
    public double getShortRate(String strRiskCode, Date startDate, int intStartHour, Date endDate, int intEndHour, String strShortRateFlag)
            throws Exception {

        //阳光需求，当开始日期与终止日期同一天时，不计短期费率 add by luyang 2005-11-10 02:51
        if (startDate == endDate) {
            return 100;
        }
        //阳光需求，当开始日期与终止日期同一天时，不计短期费率 add by luyang 2005-11-10 02:51

        if (strShortRateFlag.equals("4")) { //月比例
            return getMonthShortRate(strRiskCode, startDate, intStartHour, endDate, intEndHour);
        } else if (strShortRateFlag.equals("2")) { //日比例
            return getDayShortRate(strRiskCode, startDate, intStartHour, endDate, intEndHour);
        } else if (strShortRateFlag.equals("1")) { //短期费率表
            return getShortRateTable(strRiskCode, startDate, intStartHour, endDate, intEndHour);
        } else { //不计
            return 100;
        }
    }

    /**
     * @param strRiskCode  险种
     * @param startDate    时间段的起始日期
     * @param intStartHour 时间段起始小时数
     * @param endDate      时间段的终止日期
     * @param intEndHour   时间段的终止小时数
     * @return Double dblShortRate短期系数
     * @desc 获取给定险种的短期系数（月短期费率）
     * @desc 是业务系统UICommon.js中的短期费率计算的java实现
     * @author 王心洋
     * @time 2017-11-11
     */
    public static double getMonthShortRate(String strRiskCode, Date startDate, int intStartHour, Date endDate, int intEndHour)
            throws Exception {
        double dblShortRate = 0d;
        int intMonth = 0;
        intMonth = getMonthMinus(startDate, intStartHour, endDate, intEndHour);
        if (startDate == endDate && intStartHour < intEndHour) {
            intMonth++;
        }
        dblShortRate = (double) intMonth / 12 * 100;
        return Str.round(dblShortRate, 4);
    }

    /**
     * @param strRiskCode  险种
     * @param startDate    时间段的起始日期
     * @param intStartHour 时间段起始小时数
     * @param endDate      时间段的终止日期
     * @param intEndHour   时间段的终止小时数
     * @return Double dblShortRate短期系数
     * @desc 获取给定险种的短期系数（日短期费率）
     * @desc 是业务系统UICommon.js中的短期费率计算的java实现
     * @author 王心洋
     * @time 2017-11-11
     */
    public static double getDayShortRate(String strRiskCode, Date startDate, int intStartHour, Date endDate, int intEndHour)
            throws Exception {
        double dblShortRate = 0d;
        int intDay = 0;
        intDay = getDayMinus(startDate, intStartHour, endDate, intEndHour);
        dblShortRate = intDay * 100 / 365d;
        if (dblShortRate > 100) {
            dblShortRate = 100;
        }
        return Str.round(dblShortRate, 4);
    }

    /**
     * @param strRiskCode  险种
     * @param startDate    时间段的起始日期
     * @param intStartHour 时间段起始小时数
     * @param endDate      时间段的终止日期
     * @param intEndHour   时间段的终止小时数
     * @return Double dblShortRate短期系数
     * @desc 获取给定险种的短期系数（短期费率表）
     * @desc 是业务系统UICommon.js中的短期费率计算的java实现
     * @author 王心洋
     * @time 2017-11-11
     */
    public double getShortRateTable(String strRiskCode, Date startDate, int intStartHour, Date endDate, int intEndHour)
            throws Exception {
        PrpDshortRateDto prpDshortRateDto = new PrpDshortRateDto();
        ChgData chgData = new ChgData();

        double[] arrShortRateTable = new double[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 85, 90, 95, 100};
        double dblShortRate = 0d;

        int intYear = 0;
        Integer intMonth = 0;
        int intDay = 0;

        if (strRiskCode.substring(0, 2).equals("26") ||
                strRiskCode.substring(0, 2).equals("27")) {
            arrShortRateTable = new double[]{0, 25, 35, 45, 55, 65, 70, 75, 80, 85, 90, 95, 100};

        } else if (strRiskCode.equals("1526") || strRiskCode.equals("1517") || strRiskCode.equals("1536")) {

            arrShortRateTable = new double[]{0, 30, 35, 45, 55, 65, 70, 75, 80, 85, 90, 95, 100};
        } else {
            arrShortRateTable = new double[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 85, 90, 95, 100};//公用险种专用
        }

        intMonth = getMonthMinus(startDate, intStartHour, endDate, intEndHour);
        intYear = intMonth / 12;
        intMonth = intMonth % 12;
        intDay = getDayMinus(startDate, intStartHour, endDate, intEndHour);

       /* if (strRiskCode.equals("2706") || strRiskCode.equals("2714")){
            if (intDay <= 15) { //小于15天不计算
                dblShortRate = 0;
                return dblShortRate;
            } else if (intDay <= 30 && intDay >15) { //15到30天按一个月算
                //获取当前险种的短期费率
                prpDshortRateDto = prpDshortRateApi.queryByPK(strRiskCode, 1);
                if (prpDshortRateDto != null) {
                    // 从短期费率表中获取到
                    dblShortRate = intYear* 100+ Double.parseDouble(chgData.chgStrZero(prpDshortRateDto.getShortRate()+""));
                } else {
                    // 获取不到则返回缺省的短期费率
                    dblShortRate = intYear * 100 + arrShortRateTable[intMonth];
                }
                return dblShortRate;
            }
        }*/

        //获取当前险种的短期费率
//       SpecialEndorItemKindService specialEndorseItemKindService =new SpecialEndorseItemKindServiceImpl();
        prpDshortRateDto = specialEndorseItemKindService.queryPrpDshortRateDto(strRiskCode, intMonth);
        if (prpDshortRateDto != null) {
            // 从短期费率表中获取到
            dblShortRate = intYear * 100 + Double.parseDouble(chgData.chgStrZero(prpDshortRateDto.getShortRate() + ""));
        } else {
            // 获取不到则返回缺省的短期费率
            dblShortRate = intYear * 100 + arrShortRateTable[intMonth];
        }
        return Str.round(dblShortRate, 4);
    }

    /**
     * @param startDate    时间段的起始日期
     * @param intStartHour 时间段起始小时数
     * @param endDate      时间段的终止日期
     * @param intEndHour   时间段的终止小时数
     * @return int intMonth 月份数
     * @desc 根据起始和终止日期计算月份差
     * @desc 是业务系统UICommon.js中的短期费率计算的java实现（脚本中没有判断小时数）
     * @author 王心洋
     * @time 2017-11-11
     */
    public static int getMonthMinus(Date startDate, int intStartHour, Date endDate, int intEndHour)
            throws Exception {
        int intMonth = 0;
        intMonth = (endDate.get(Date.YEAR) - startDate.get(Date.YEAR)) * 12
                + endDate.get(Date.MONTH) - startDate.get(Date.MONTH);
        if (endDate.get(Date.DATE) - startDate.get(Date.DATE) > 0 ||
                endDate.get(Date.DATE) == startDate.get(Date.DATE) &&
                        intEndHour > intStartHour) {
            intMonth++;
        }
        return intMonth;
    }

    /**
     * @param startDate    时间段的起始日期
     * @param intStartHour 时间段起始小时数
     * @param endDate      时间段的终止日期
     * @param intEndHour   时间段的终止小时数
     * @return int intDay 天数
     * @desc 根据起始和终止日期计算天数差
     * @desc 是业务系统UICommon.js中的短期费率计算的java实现（脚本中没有判断小时数）
     * @author 王心洋
     * @time 2017-11-11
     */
    public static int getDayMinus(Date startDate, int intStartHour, Date endDate, int intEndHour)
            throws Exception {
        int intDay = 0;
        java.util.Date startDateJava = new java.util.Date(
                startDate.get(Date.YEAR), startDate.get(Date.MONTH) - 1,
                startDate.get(Date.DATE), intStartHour, 0, 0);
        java.util.Date endDateJava = new java.util.Date(endDate.get(Date.YEAR),
                endDate.get(Date.MONTH) - 1, endDate.get(Date.DATE),
                intEndHour, 0, 0);
        intDay = (int) ((endDateJava.getTime() - startDateJava.getTime()) / 86400000L);
        return intDay;
    }

    /**
     * @param strRiskCode      险种
     * @param startDate        时间段的起始日期
     * @param intStartHour     时间段起始小时数
     * @param endDate          时间段的终止日期
     * @param intEndHour       时间段的终止小时数
     * @param finishDate       保单终保日期
     * @param intFinishHour    保单终保小时数
     * @param strShortRateFlag 短期费率方式（1 短期费率表、4 月比例、2 日比例、3 不计）
     * @return Double dblShortRate短期系数
     * @desc 获取给定险种的短期系数（短期费率表、月比例、日比例、不计）
     * @desc 是业务系统UICommon.js中的短期费率计算的java实现
     */
    public double getCommerceShortRate(String strRiskCode, Date startDate, int intStartHour, Date endDate, int intEndHour, Date finishDate, int intFinishHour, String strShortRateFlag)
            throws Exception {
        if (startDate == endDate) {
            return 100;
        }
        if (strShortRateFlag.equals("4")) { //月比例
            return getCommerceMonthShortRate(strRiskCode, startDate, intStartHour, endDate, intEndHour, finishDate, intFinishHour);
        } else if (strShortRateFlag.equals("2")) { //日比例
            return getCommerceDayShortRate(strRiskCode, startDate, intStartHour, endDate, intEndHour, finishDate, intFinishHour);
        } else if (strShortRateFlag.equals("1")) { //短期费率表
            return getShortRateTable(strRiskCode, startDate, intStartHour, endDate, intEndHour);
        } else { //不计
            return 0;
        }
    }

    /**
     * @param strRiskCode  险种
     * @param startDate    时间段的起始日期
     * @param intStartHour 时间段起始小时数
     * @param endDate      时间段的终止日期
     * @param intEndHour   时间段的终止小时数
     * @return Double dblShortRate短期系数
     * @desc 获取给定险种的短期系数（月短期费率）
     * @desc 是业务系统UICommon.js中的短期费率计算的java实现
     */
    public static double getCommerceMonthShortRate(String strRiskCode, Date startDate, int intStartHour, Date endDate, int intEndHour, Date finishDate, int intFinishHour)
            throws Exception {
        double dblShortRate = 0d;
        int intMonth = 0;
        int intFullMonth = 0;
        //月比例短期费率的值先从prpDshortRate中取.如果该表中没有再按:月数/12*100计算
        int intReturnStatus = 100;
        intFullMonth = getMonthMinus(startDate, intStartHour, finishDate, intFinishHour);
        intMonth = getMonthMinus(startDate, intStartHour, endDate, intEndHour);
        if (startDate == endDate && intStartHour < intEndHour) {
            intMonth++;
        }
        dblShortRate = (double) intMonth / 12 * 100d;//适用短期单 保险期间不满一年的情况
        dblShortRate = Str.round(dblShortRate, 4);
        return dblShortRate;
    }

    /**
     * @param strRiskCode   险种
     * @param startDate     时间段的起始日期
     * @param intStartHour  时间段起始小时数
     * @param endDate       时间段的终止日期
     * @param intEndHour    时间段的终止小时数
     * @param finishDate    保单终保日期
     * @param intFinishHour 保单终保小时数
     * @return Double dblShortRate短期系数
     * @desc 获取给定险种的短期系数（日短期费率）
     * @desc 是业务系统UICommon.js中的短期费率计算的java实现
     */
    public static double getCommerceDayShortRate(String strRiskCode, Date startDate, int intStartHour, Date endDate, int intEndHour, Date finishDate, int intFinishHour)
            throws Exception {
        double dblShortRate = 0d;
        int intDay = 0;
        int intFullDay = 0;
        intDay = getDayMinus(startDate, intStartHour, endDate, intEndHour);
        intFullDay = getDayMinus(startDate, intStartHour, finishDate, intFinishHour);
        dblShortRate = intDay * 100d / 365;//适用短期单 保险期间不满一年的情况
        //计算完月例后进行四舍五入成两位小数
        dblShortRate = Str.round(dblShortRate, 4);
        return dblShortRate;
    }

    /**
     * 计算批改保险期限短期费率
     *
     * @param startDateNew Date
     * @param startHourNew int
     * @param endDateNew   Date
     * @param endHourNew   int
     * @param startDateOld Date
     * @param startHourOld int
     * @param endDateOld   Date
     * @param endHourOld   int
     * @param shortFlag    String 批改时选择的短期费率
     * @param shortRateOld double
     * @param riskCode     String
     * @return double
     * @throws Exception
     * @author 王心洋
     */
    public double calPeriodShortRate(Date startDateNew, int startHourNew,
                                     Date endDateNew, int endHourNew,
                                     Date startDateOld, int startHourOld,
                                     Date endDateOld, int endHourOld,
                                     String shortFlag, double shortRateOld,
                                     String riskCode)
            throws Exception {
        double shortRate = 0d; //返回的短期系数
        double shortRateOld2 = 0d; //原保险期限、新短期费率方式计算的短期系数
        double shortRateNew = 0d; //新保险期限、新短期费率方式计算的短期系数

        shortRateNew = getShortRate(riskCode,
                startDateNew, startHourNew,
                endDateNew, endHourNew,
                shortFlag);
        shortRateOld2 = getShortRate(riskCode,
                startDateOld, startHourOld,
                endDateOld, endHourOld,
                shortFlag);
        //短期系数=原短期系数
        //+新保险期限、新短期费率方式计算的短期系数
        //-原保险期限、新短期费率方式计算的短期系数
        shortRate = shortRateOld + shortRateNew - shortRateOld2;
        return Str.round(shortRate, 4);
    }

    /**
     * @param strRiskCode
     * @param dblPremiumOld
     * @param dblShortRateOld
     * @return double dblPremiumNew
     * @desc 计算批改保险期限保费
     * @author 王心洋
     */
    public double calculateByPeriod(String strRiskCode, double dblPremiumOld, double dblShortRateOld, double dblShortRateNew)
            throws Exception {
        double dblPremiumNew = 0;
        dblPremiumNew = dblPremiumOld * (dblShortRateNew / dblShortRateOld);
        return Str.round(dblPremiumNew, 2);
    }

    /**
     * double类型数据转换
     *
     * @author 王心洋
     * @time 2017-11-23
     */
    //TODO 技术统一处理
    public String chgZero(Double doubleValue) {
        String strReturn = null;
        if (doubleValue == null || doubleValue == 0.0D) {
            strReturn = "0.00";
        } else {
            strReturn = String.valueOf(doubleValue);
        }
        return strReturn;
    }

    //TODO 技术统一处理
    public String chgZero(Integer intValue) {
        String strReturn = null;
        if (intValue == null || intValue == 0) {
            strReturn = "0";
        } else {
            strReturn = String.valueOf(intValue);
        }
        return strReturn;
    }

    //TODO 技术统一处理
    public String chgZero(String strValue) {
        String strReturn = null;
        if (StringUtils.isEmpty(strValue)) {
            strReturn = "0";
        } else {
            strReturn = strValue;
        }
        return strReturn;
    }

    /**
     * @param amountOld
     * @param amountNew
     * @param rateOld
     * @param rateNew
     * @param oldDiscount
     * @param newDiscount
     * @param shortRateOld
     * @param shortRateNew
     * 计算批改保险期限保费
     * @return double 保费
     * @throws Exception
     * @author 王保良
     */
    public Double calculateByItem(Double amountOld, Double amountNew, Double rateOld, Double rateNew, Double oldDiscount, Double newDiscount, Double shortRateOld, Double shortRateNew) throws Exception {
        shortRateOld = 1.0;//旧短期费率系数不参加计算,已经体现在旧保额里
        Double chgPremium = 0.0;

        chgPremium = ((amountNew - amountOld) * rateNew * newDiscount * shortRateNew +
                amountOld * (rateNew * newDiscount - rateOld * oldDiscount) * shortRateNew) * shortRateOld;

        return chgPremium;
    }

    /**
     *
     * @param amountOld
     * @param amountNew
     * @param rateOld
     * @param rateNew
     * @param oldDiscount
     * @param newDiscount
     * @param shortRateNew
     * @param premiumOld
     * @return
     * @throws Exception
     */
    public Double calculatePremium(Double amountOld, Double amountNew, Double rateOld, Double rateNew, Double oldDiscount, Double newDiscount, Double shortRateNew
                                    ,Double premiumOld)throws Exception{
        double premiumNew=0.00;

        if( amountNew * rateNew ==amountOld  * rateOld)
        {
            //计算保费
            premiumNew = premiumOld;
        }
        else
        {
            //计算保费变化量
            double vChgPremium=calculateByItem(amountOld,amountNew,rateOld,rateNew,oldDiscount,newDiscount,new Double(0.00),shortRateNew);

            //计算保费
            premiumNew = premiumOld + vChgPremium;
        }
        return premiumNew;

    }


    /**
     * 计算各险别保费
     * @param prpCitemKindDto
     * @param amount
     * @param rate
     * @param shortRate
     * @param adjustRate
     * @return double 保费
     * @throws Exception
     * @author 王保良
     */
    public Double formulizePremium(PrpCitemKindDto prpCitemKindDto, Double amount, Double rate, Double shortRate, Double adjustRate) throws Exception {
        //新保费
        Double newPremium = 0.00;
        //保费变化量
        Double chgPremium = 0.00;
        //百分制计算
        Integer calculator = 100;

        Double amountOld = prpCitemKindDto.getAmount();
        Double rateOld = prpCitemKindDto.getRate();
        Double shortRateOld = prpCitemKindDto.getShortRate();
        Double premiumOld = prpCitemKindDto.getPremium();
        Double adjustRateOld = 0.0;

        Double amountNew = amount;
        Double rateNew = rate;
        Double shortRateNew = shortRate;
        Double adjustRateNew = 0.0;

        if (prpCitemKindDto.getFlag() !=null && prpCitemKindDto.getFlag().substring(1, 2) == "1") {
            adjustRateOld = prpCitemKindDto.getAdjustRate();
            adjustRateNew = adjustRate;
        }

        if (amountNew * rateNew == amountOld * rateOld) {
            newPremium = premiumOld;
        } else {
            chgPremium += calculateByItem(amountOld, amountNew, rateOld / calculator, rateNew / calculator, 1.0, 1.0, shortRateOld / 100, shortRateNew / 100);
            newPremium = premiumOld + chgPremium;
        }
        if (adjustRateNew != null) {
            if (adjustRateOld == null) {
                adjustRateOld = 0.0;
            }
            newPremium = newPremium - (adjustRate ==null ?0d:adjustRate - adjustRateOld);
        }
        if (newPremium < 0) {
            newPremium = 0.0;
        }
        return new BigDecimal(newPremium).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * 计算比例补贴的比例之合
     * @param blPolicyNew
     * @return double比例之合
     * @author 王心洋
     */
    public double calculateSubsidy(ResponseQueryPolicyInfoDto blPolicyNew){
        List<PrpCsubsidyDto> prpCsubsidyDtoList = blPolicyNew.getPrpCsubsidyDtoList();
        double subsity=0;
        for(int i=1;i<prpCsubsidyDtoList.size();i++){
            if("01".equals(prpCsubsidyDtoList.get(i).getSubsidyType()))
                subsity = subsity + prpCsubsidyDtoList.get(i).getSubsidyRate();
        }
        return subsity;
    }

    /**
     * 计算政府补贴金额
     */
    public ResponseQueryPolicyInfoDto calculateSubsidyFee(ResponseQueryPolicyInfoDto blPolicyNew, List<Double> benchmarkPremiumList) throws Exception {
        double sumBenchMark = sumBenchMarkPreimum(benchmarkPremiumList);
        double govRate = 0;//政府补贴比例
        double subsidyPremium = 0;//叠加政府补贴金额
        double perSubsidyPremium = 0;//每条政府补贴金额
        //取政府补贴比例之和
        govRate = calculateSubsidy(blPolicyNew);

        List<PrpCsubsidyDto> prpCsubsidyDtoList = blPolicyNew.getPrpCsubsidyDtoList();
        for(int i=1;i<prpCsubsidyDtoList.size();i++){
            if("01".equals(prpCsubsidyDtoList.get(i).getSubsidyType())){
                if(i == prpCsubsidyDtoList.size() - 1){
                    //最后一笔政府补贴金额＝总保费－自缴－已计算得政府补贴
                    perSubsidyPremium = new BigDecimal(sumBenchMark - sumBenchMark * (1-govRate) - subsidyPremium)
                            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    blPolicyNew.getPrpCsubsidyDtoList().get(i).setSubsidyPremium(perSubsidyPremium);
                }else{
                    perSubsidyPremium = new BigDecimal(sumBenchMark * prpCsubsidyDtoList.get(i).getSubsidyRate()/100)
                            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    blPolicyNew.getPrpCsubsidyDtoList().get(i).setSubsidyPremium(perSubsidyPremium);
                    subsidyPremium = new BigDecimal(subsidyPremium + prpCsubsidyDtoList.get(i).getSubsidyPremium())
                            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                }
            }
        }
        return blPolicyNew;
    }

    //todo benchmarkPremium去加? 数据库里为什么有0? benchmarkPremium 这个方法可能有问题
    public Double sumBenchMarkPreimum(List<Double> benchmarkPremiumList)throws Exception{

        Double benchmarkPremium=0.00;
        for (int i=0;i<benchmarkPremiumList.size();i++){
            benchmarkPremium+=benchmarkPremiumList.get(i);
        }
        return benchmarkPremium;
    }

    //处理精确工具

    /**
     * 处理精确工具
     * @param v 要处理的数据
     * @param scale 保留小数位数
     * @return double 要处理的结果
     * @author 王心洋
     * @time 2017-12-22
     */
    public double round(double v, int scale) {
        BigDecimal b = new BigDecimal(Double.toString(v));

        BigDecimal one = new BigDecimal("1");

        return b.divide(one, scale, 4).doubleValue();
    }

    /**
     * 日期比较方法
     * @param firstDate
     * @param secondDate
     * @return
     * @throws Exception
     */
    public  int compareDate(java.util.Date firstDate, java.util.Date secondDate)
            throws Exception {
        int intReturn = 0;

        try {
            if (firstDate.after(secondDate)) {
                intReturn = 1;
            } else if (firstDate.before(secondDate)) {
                intReturn = -1;
            } else if (firstDate.equals(secondDate)) {
                intReturn = 0;
            }
            return intReturn;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * 获取特殊批改初始化交集的信息
     * @author: ldd
     * @date: 2018/1/9 18:17
     * @param retainInfoByPolicyNo 需要比对的大集合
     * @return
     */
    public List getRetainList(Map<String, List<? extends Object>> retainInfoByPolicyNo) {
        if (retainInfoByPolicyNo == null || retainInfoByPolicyNo.size() < 1) {
            throw new DataVerifyException("用于比对交集的key集合为空！");
        }
        List resultList = new ArrayList();
        Map<Object, Integer> repeatNum = new HashMap<>();
        if (retainInfoByPolicyNo.size() > 1) {
            retainInfoByPolicyNo.forEach((policyNo, objects) -> {
                if (repeatNum.containsKey(objects)) {
                    Integer integer = repeatNum.get(objects);
                    repeatNum.put(objects, integer + 1);
                } else {
                    repeatNum.put(objects, 1);
                }
            });
            List<Map.Entry<Object, Integer>> collect = repeatNum.entrySet().stream()
                    .filter(objectIntegerEntry -> objectIntegerEntry.getValue() == 1)
                    .collect(Collectors.toList());
            if (collect.size() == 0) {
                List value = retainInfoByPolicyNo.entrySet().iterator().next().getValue();
                resultList.addAll(value);
            } else {
                List<String> policyNos = new ArrayList<>();
                collect.forEach(objectIntegerEntry -> {
                    List key = (List) objectIntegerEntry.getKey();
                    try {
                        Field policyNoField = key.get(0).getClass().getDeclaredField("policyNo");
                        policyNoField.setAccessible(true);
                        String policyNo = (String) policyNoField.get(key.get(0));
                        policyNos.add(policyNo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                resultList.add(policyNos.toString());
            }
        }else {
            retainInfoByPolicyNo.forEach((policyNo, objects) -> resultList.addAll(objects));
        }
        return resultList;
    }
    /**
     * 利用反射机制,判断属性若为null，赋默认值
     * @param obj
     */
    public void convertNullToDef(Object obj) {
    	if(obj == null) {
    		return;
    	}
    	Class objClass = (Class)obj.getClass();
    	Field fArray[] = objClass.getDeclaredFields();
    	try {
    		for(int i = 0 ; i < fArray.length; i++) {// 遍历所有属性
        		Field field = fArray[i];
        		String name = field.getName(); // 获取属性的名字
        		if(name.equals("nClinicPremium")) {
        			return;
        		}
        		name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
        		String type = field.getGenericType().toString();
        		if(type.equals("class java.lang.String")) {// 如果type是类类型，则前面包含"class "，后面跟类名
        			Method method = objClass.getMethod("get" + name);
        			String value = (String) method.invoke(obj); // 调用getter方法获取属性值
        			if (value == null) {
        				method = objClass.getMethod("set"+name,String.class);
        				method.invoke(obj, "");
                    }
        		}

        		if (type.equals("class java.lang.Double")) {
                    Method method = objClass.getMethod("get" + name);
                    Double value = (Double) method.invoke(obj);
                    if (value == null) {
                    	method = objClass.getMethod("set"+name,Double.class);
                    	method.invoke(obj, 0.00);
                    }
                }
        	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}

    }
    public double nullToDouble(Double data)throws Exception{
        if(data==null){
            return 0.0;
        }else {
            return data;
        }
    }

}

