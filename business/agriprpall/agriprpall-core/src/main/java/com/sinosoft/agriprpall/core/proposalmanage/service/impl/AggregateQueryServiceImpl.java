package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainDao;
import com.sinosoft.agriprpall.core.proposalmanage.service.AggregateQueryService;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.DecimalFormat;
import java.util.*;


/**
 *（汇总查询）
 * @Author: 陈道洋
 * @Date: 2017/11/9 10:37
 */
@Service
public class AggregateQueryServiceImpl extends BaseServiceImpl implements AggregateQueryService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(AggregateQueryServiceImpl.class);
    
    @Autowired
    private PrpTmainDao prpTmainDao;
    @Autowired
    private PrpDriskApi prpdriskApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @PersistenceContext
    private EntityManager entityManager;


    /**
     * @description:
     * 创建SQL语句
     * 拼接SQL条件
     * 创建查询对象
     * 获取查询结果
     * 定义返回参数Dto类型的集合
     * 往响应ResponsePrpTmainDto里set值并添加到集合里
     * @author: 陈道洋
     * @date: 2017/10/16 8:26
     * @param prptmainDto
     * @return
     * @throws Exception
     */
    public List<PrpTmainDto> queryPrpTmainByCondition(PrpTmainDto prptmainDto) throws Exception {
        //创建SQL语句
        StringBuilder Sql = new StringBuilder("SELECT t.riskCode,\n" +
                "      t.operatorCode,\n" +
                "      count(t.operatorCode) as sumNumber,\n" +
                "      sum(t.sumAmount) as SumAmount,\n" +
                "      sum(t.sumPremium) as SumPremium\n" +
                "   FROM PrpTmain t\n" +
                "  WHERE 1 = 1");
        Map<String,String> conditions= new HashMap<>();
        //拼接SQL条件
        if(!"".equals(prptmainDto.getRiskCode())&&prptmainDto.getRiskCode()!=null){
            if(!"".equals(prptmainDto.getRiskCodeFlag())&&prptmainDto.getRiskCodeFlag()!=null){
                if(prptmainDto.getRiskCodeFlag().equals("*")){
                    Sql.append(" and t.riskCode like:riskCode");
                    conditions.put("riskCode",prptmainDto.getRiskCode()+"%");
                }else{
                    Sql.append(" and t.riskCode =:riskCode");
                    conditions.put("riskCode",prptmainDto.getRiskCode()+"%");
                }
            }else{
                throw  new DataVerifyException("险种代码查询标志不能为空");
            }
        }

        if(!"".equals(prptmainDto.getOperatorCode())&&prptmainDto.getOperatorCode()!=null) {
            if(!"".equals(prptmainDto.getRiskCodeFlag())&&prptmainDto.getRiskCodeFlag()!=null){
                if (prptmainDto.getOperatorCodeFlag().equals("*")) {
                    Sql.append(" and t.operatorCode like :operatorCode");
                    conditions.put("operatorCode",prptmainDto.getOperatorCode()+"%");
                } else {
                    Sql.append(" and t.operatorCode =:operatorCode");
                    conditions.put("operatorCode",prptmainDto.getOperatorCode()+"%");
                }
            }else{
                throw  new DataVerifyException("员工代码查询标志不能为空");
            }
        }
        if(!"".equals(prptmainDto.getStartUpdateDate())&&prptmainDto.getStartUpdateDate()!=null){
            if( !"".equals(prptmainDto.getStartUpdateDateFlag())&&prptmainDto.getStartUpdateDateFlag()!=null){
               switch(prptmainDto.getStartUpdateDateFlag()){
                   case ">":
                       Sql.append(" and t.updateDate > to_date(:startUpdateDate,'yyyy-mm-dd hh24:mi:ss')");
                       break;
                   case "<":
                       Sql.append(" and t.updateDate < to_date(:startUpdateDate,'yyyy-mm-dd hh24:mi:ss')");
                       break;
                   case ">=":
                       Sql.append(" and t.updateDate >= to_date(:startUpdateDate,'yyyy-mm-dd hh24:mi:ss')");
                       break;
                   case "<=":
                       Sql.append(" and t.updateDate <= to_date(:startUpdateDate,'yyyy-mm-dd hh24:mi:ss')");
                       break;
                   case "=":
                       Sql.append(" and t.updateDate = to_date(:startUpdateDate,'yyyy-mm-dd hh24:mi:ss')");
                       break;
                   case ":":
                       break;
                   default:
                       throw  new DataVerifyException("传入类型不正确");
               }
                conditions.put("startUpdateDate",prptmainDto.getStartUpdateDate());
            }else{
                throw  new DataVerifyException("制单起始日期标志不能为空");
            }
        }
        if( !"".equals(prptmainDto.getEndUpdateDate())&&prptmainDto.getEndUpdateDate()!=null){
            if(!"".equals(prptmainDto.getEndUpdateDateFlag())&&prptmainDto.getEndUpdateDateFlag()!=null){
                switch (prptmainDto.getEndUpdateDateFlag()){
                    case ">":
                        Sql.append(" and t.updateDate > to_date(:endUpdateDate,'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case "<":
                        Sql.append(" and t.updateDate < to_date(:endUpdateDate,'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case ">=":
                        Sql.append(" and t.updateDate > =to_date(:endUpdateDate,'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case "<=":
                        Sql.append(" and t.updateDate <= to_date(:endUpdateDate,'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case "=":
                        Sql.append(" and t.updateDate = to_date(:endUpdateDate,'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case ":":
                        break;
                     default:
                         throw  new DataVerifyException("传入类型不正确");
                }
                conditions.put("endUpdateDate",prptmainDto.getEndUpdateDate());
            }else{
                throw  new DataVerifyException("制单结束日期标志不能为空");
            }
        }
        Sql.append(" and substr(t.othFlag, 4, 1) <> 2");
        Sql.append(" Group by t.riskCode, t.operatorCode");
        Sql.append(" ORDER BY t.riskCode ASC");
        System.out.print(Sql);
        //创建查询对象
       Query dataQuery = entityManager.createQuery(Sql.toString());
        for(Map.Entry<String, String> entrySet:conditions.entrySet()){
            dataQuery.setParameter(entrySet.getKey(),entrySet.getValue());
        }
        //获取查询结果
        List<Object[]> list = dataQuery.getResultList();
        //定义返回参数Dto类型的集合
        List<PrpTmainDto> arrayList = new ArrayList<>();
        //对double类型的数据格式化
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        //往响应ResponsePrpTmainDto里set值并添加到集合里
         if(list!=null&&list.size()>0){
          for(Object[] obj:list){
        PrpTmainDto prpTmainDto = new PrpTmainDto();
              prpTmainDto.setRiskCode(obj[0].toString());
              Map<String,String> map = new HashMap<>();
              map.put("userCode",obj[1].toString());
              map.put("isChinese", LanguageFlagConstant.CHINESE);
              prpTmainDto.setOperatorName(prpDuserApi.translateCode(map));
              prpTmainDto.setSumNumber(Double.parseDouble(obj[2].toString()));
              prpTmainDto.setSumAmount(Double.parseDouble(decimalFormat.format(obj[3])));
              prpTmainDto.setSumPremium(Double.parseDouble(obj[4].toString()));
              arrayList.add(prpTmainDto);
          }
         }
        return arrayList;
    }

}