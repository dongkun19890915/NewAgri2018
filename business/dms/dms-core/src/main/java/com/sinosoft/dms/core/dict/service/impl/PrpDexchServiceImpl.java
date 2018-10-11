package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpDexchDto;
import com.sinosoft.dms.core.dict.dao.PrpDexchDao;
import com.sinosoft.dms.core.dict.entity.PrpDexch;
import com.sinosoft.dms.core.dict.entity.PrpDexchKey;
import com.sinosoft.dms.core.dict.service.PrpDexchService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PrpDexchServiceImpl extends BaseServiceImpl implements PrpDexchService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDexchServiceImpl.class);
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PrpDexchDao prpDexchDao;

    /**
     * 根据入参条件获得距给定日期最近一天的两种币别的兑换率
     * @author: 宋振振
     * @date: 2017/12/8 14:49
     * @param iBaseCurrency 基准币别
     * @param iExchCurrency 兑换币别
     * @param iExchDate 兑换日期 标准的年月日格式
     * @return 返回兑换率
     * @throws Exception
     */
    public Map<String,Double> getExchangeRate(String iBaseCurrency, String iExchCurrency, String iExchDate) throws Exception{
        if(StringUtils.isEmpty(iBaseCurrency)){
            throw new DataVerifyException("基准币别不能为空!");
        }
        if(StringUtils.isEmpty(iExchCurrency)){
            throw new DataVerifyException("兑换币别不能为空!");
        }
        if(StringUtils.isEmpty(iExchDate)){
            throw new DataVerifyException("兑换日期不能为空!");
        }
        Map<String,Double> map=new HashMap<>();
        double dblExchangeRate = 0d;//要返回的兑换率
        double dblExchangeRate1 = 0d;//用于计算兑换率
        double dblExchangeRate2 = 0d;//用于计算兑换率
        iExchDate = toFormat(iExchDate);
        iBaseCurrency = iBaseCurrency.trim();
        iExchCurrency = iExchCurrency.trim();
        //如果基准币别和兑换币别相等，返回兑换率=1
        if (iBaseCurrency.equals(iExchCurrency)) {
            dblExchangeRate = 1;
            map.put("exchangeRate",dblExchangeRate);
            return map;
        }
        //如果兑换日期为null或长度为0，返回兑换率=0
        if (iExchDate == null || iExchDate.length() == 0) {
            map.put("exchangeRate",dblExchangeRate);
            return map;
        } else {
            iExchDate = iExchDate.substring(0,10);
        }
        //获取同一天基准币别和兑换币别的直接兑换率
        dblExchangeRate = getStraightExchangeRate(iBaseCurrency, iExchCurrency,iExchDate);
        if (dblExchangeRate != 0) {
            map.put("exchangeRate",dblExchangeRate);
            return map;
        }

        //获取同一天兑换币别和基准币别的直接兑换率
        dblExchangeRate = getStraightExchangeRate(iExchCurrency, iBaseCurrency,iExchDate);
        if (dblExchangeRate != 0) {
            dblExchangeRate = 1 / dblExchangeRate;
            //保留6位小数并四舍五入
            dblExchangeRate=getDouble(dblExchangeRate);
            map.put("exchangeRate",dblExchangeRate);
            return map;
        }
        //若用兑换币别与原币没查到，用USD作兑换币别
        dblExchangeRate1 = getStraightExchangeRate(iBaseCurrency, "USD",iExchDate);
        if (dblExchangeRate1 != 0) {//若存在基准币别和USD的兑换率
            dblExchangeRate2 = getStraightExchangeRate(iExchCurrency, "USD",iExchDate);
            if (dblExchangeRate2 != 0) {//若存在兑换币别和USD的兑换率
                dblExchangeRate = dblExchangeRate1 / dblExchangeRate2;
                //保留6位小数并四舍五入
                dblExchangeRate=getDouble(dblExchangeRate);
                map.put("exchangeRate",dblExchangeRate);
                return map;
            } else {
                dblExchangeRate2 = getStraightExchangeRate("USD",iExchCurrency, iExchDate);
                if (dblExchangeRate2 != 0) {//若存在USD和兑换币别的兑换率
                    dblExchangeRate = dblExchangeRate1 * dblExchangeRate2;
                    //保留6位小数并四舍五入
                    dblExchangeRate=getDouble(dblExchangeRate);
                    map.put("exchangeRate",dblExchangeRate);
                    return map;
                }
            }
        }

        dblExchangeRate1 = getStraightExchangeRate("USD", iBaseCurrency, iExchDate);
        if (dblExchangeRate1 != 0) {//若存在USD和基准币别的兑换率
            dblExchangeRate2 = getStraightExchangeRate(iExchCurrency, "USD",iExchDate);
            if (dblExchangeRate2 != 0) {//若存在兑换币别和USD的兑换率
                dblExchangeRate = dblExchangeRate2 * dblExchangeRate1;
                //保留6位小数并四舍五入
                dblExchangeRate=getDouble(dblExchangeRate);
                map.put("exchangeRate",dblExchangeRate);
                return map;
            } else {
                dblExchangeRate2 = getStraightExchangeRate("USD", iExchCurrency, iExchDate);
                if (dblExchangeRate2 != 0) {//若存在USD和兑换币别的兑换率
                    dblExchangeRate = dblExchangeRate2 / dblExchangeRate1;
                    //保留6位小数并四舍五入
                    dblExchangeRate=getDouble(dblExchangeRate);
                    map.put("exchangeRate",dblExchangeRate);
                    return map;
                }
            }
        }
        map.put("exchangeRate",dblExchangeRate);
        return map;
    }

    /**
     * 保留6位小数并四舍五入
     * @author: 宋振振
     * @date: 2017/12/15 11:06
     * @param exchangeRate
     * @return
     */
    public Double getDouble(Double exchangeRate){
        BigDecimal bigDecimal = new BigDecimal(exchangeRate);
        exchangeRate=bigDecimal.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
        return exchangeRate;
    }
    /**
     * 根据条件查询PrpDexch表中的兑换率
     * @author: 宋振振
     * @date: 2017/12/9 10:48
     * @param iBaseCurrency 基准币别
     * @param iExchCurrency 兑换币别
     * @param iExchDate 兑换日期 标准的年月日格式
     * @return 返回兑换率
     * @throws Exception
     */
    private double getStraightExchangeRate(String iBaseCurrency,String iExchCurrency, String iExchDate) throws Exception {
        double dblExchangeRate = 0d;
        String strWherePart = "";
        Date strExchDate ;
        iExchDate = toFormat(iExchDate);

        StringBuilder sqlCount=new StringBuilder("SELECT COUNT(p) FROM PrpDexch p WHERE ");
        strWherePart = " p.baseCurrency =:baseCurrency AND p.exchCurrency =:exchCurrency AND p.exchDate <= TO_DATE(:exchDate,'yyyy-mm-dd')  AND p.exchRate IS NOT NULL ";
        sqlCount.append(strWherePart);
        Query dataCount=entityManager.createQuery(sqlCount.toString());
        dataCount.setParameter("baseCurrency",iBaseCurrency);
        dataCount.setParameter("exchCurrency",iExchCurrency);
        dataCount.setParameter("exchDate",iExchDate);
        Object intCount1 = dataCount.getSingleResult();
        Long   intCount=Long.parseLong(intCount1.toString());
        //如果查询到兑换率的记录条数为0，返回兑换率=0，如果查到就走下面的
        if (intCount == 0) {
            dblExchangeRate = 0;
            return dblExchangeRate;
        }
        //获取最大的兑换日期exchDate，用于下面的sqlPrpDexch语句查询兑换率
        strExchDate=prpDexchDao.findMaxExchDate(iBaseCurrency,iExchCurrency,iExchDate);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String exchDate=format.format(strExchDate);
        //查询兑换率
        StringBuilder sqlPrpDexch =new StringBuilder();
        sqlPrpDexch.append(" Select p From PrpDexch p Where p.exchDate = TO_DATE(:exchDate,'yyyy-mm-dd') And p.baseCurrency =:baseCurrency And p.exchCurrency =:exchCurrency ");
        Query dataQuery=entityManager.createQuery(sqlPrpDexch.toString());
        dataQuery.setParameter("exchDate",exchDate);
        dataQuery.setParameter("baseCurrency",iBaseCurrency);
        dataQuery.setParameter("exchCurrency",iExchCurrency);
        List<PrpDexch> prpDexchList=dataQuery.getResultList();
        if(prpDexchList.size()>0){
            //如果查到兑换率，则返回兑换率
            dblExchangeRate = prpDexchList.get(0).getExchRate();
        } else {
            dblExchangeRate = 0;
        }

        return dblExchangeRate;
    }

    /**
     * 对日期进行加0处理的工具类，比如将2017-2-9处理为2017-02-09，只对2017-2-9和2017/2/9格式有效
     * @author: 宋振振
     * @date: 2017/12/9 11:01
     * @param iStrDate 日期
     * @return 返回日期字符串
     * @throws Exception
     */
    public String toFormat(String iStrDate) throws Exception{
        String strTemp = "";
        String strFlag = "";
        String strYear = "";
        String strMonth = "";
        String strDate = "";
        String strRet = "";
        int intStartPoint = 0;
        int intEndPoint = 0;

        if ((iStrDate == null) || (iStrDate == "") || (iStrDate.equals("null"))){//日期为null或“”或“null”，返回空字符串
            return "";
        }
        if ((iStrDate.length() < 8) || (iStrDate.length() > 10)){//长度大于10或小于8，返回日期，不做处理
            return iStrDate;
        }

        if (iStrDate.indexOf("/") > 0)
            strFlag = "/";
        if (iStrDate.indexOf("-") > 0)
            strFlag = "-";

        if (strFlag.trim().equals("")){//如果输入日期串中没有分割符，返回日期，不做处理
            return iStrDate;
        }
        //如果日期串中有分割符，进行处理
        intStartPoint = iStrDate.indexOf(strFlag);
        intEndPoint = iStrDate.lastIndexOf(strFlag);
        strTemp = iStrDate.substring(0, intStartPoint);

        if (strTemp.length() == 4) {
            strYear = iStrDate.substring(0, intStartPoint);
            strMonth = iStrDate.substring(intStartPoint + 1, intEndPoint);
            if (strMonth.length() == 1) strMonth = "0" + strMonth.trim();
            strDate = iStrDate.substring(intEndPoint + 1, iStrDate.length());
            if (strDate.length() == 1) { strDate = "0" + strDate.trim();
            }

            strFlag = "-";

            strRet = strYear.trim() + strFlag.trim() + strMonth.trim() + strFlag.trim() + strDate.trim();
        }

        if (strTemp.length() != 4) {
            strMonth = iStrDate.substring(0, intStartPoint);
            if (strMonth.length() == 1) strMonth = "0" + strMonth.trim();
            strDate = iStrDate.substring(intStartPoint + 1, intEndPoint);
            if (strDate.length() == 1) strDate = "0" + strDate.trim();
            strYear = iStrDate.substring(intEndPoint + 1, iStrDate.length());

            strFlag = "-";

            strRet = strYear.trim() + strFlag.trim() + strMonth.trim() + strFlag.trim() + strDate.trim();
        }
        return strRet.trim();//对日期去除空格
    }

    /**
     * （按主键查最大兑换时间）
     * @author: 王志文
     * @date: 2018/4/14 11:01
     * @param iBaseCurrency
     * @param iExchCurrency
     * @param iExchDate
     * @return
     * @throws Exception
     */
    public List<PrpDexchDto> queryMaxExchDateByConditions(String iBaseCurrency, String iExchCurrency, String iExchDate)throws Exception{
        List<PrpDexch> prpDexchList = prpDexchDao.findMaxExchDateDto(iBaseCurrency,iExchCurrency,iExchDate);
        List<PrpDexchDto> prpDexchDtoList = new ArrayList<>();
        this.convertCollection(prpDexchList,prpDexchDtoList,PrpDexchDto.class);
        return prpDexchDtoList;
    }
}
