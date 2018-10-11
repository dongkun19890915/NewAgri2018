package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.core.dict.entity.PrpDcode;
import com.sinosoft.dms.core.dict.entity.PrpDcodeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 08:34:23.982 
 * 通用代码表Dao数据操作对象
 */
@Repository
public interface PrpDcodeDao extends JpaBaseDao<PrpDcode,PrpDcodeKey> {
    /**
     * @author 田健
     * @mail tianjian@sinosoft.com.cn
     * @time  2017-10-11
     * @description 根据codeType获取业务代码业务代码中文含义codeCName
     */
    public List<PrpDcode> queryCodeListByCodeType(@Param("codeType") String codeType);

    /**
     * @author 田健
     * @mail tianjian@sinosoft.com.cn
     * @time  2017-10-11
     * @description 根据codeType,codeCName,riskCode获取业务代码中文含义的业务代码的codeCode
     */
    @Query(value="select a from PrpDcode a,PrpDcodeRisk b  where a.codeType=b.codeType  and a.codeCode=b.codeCode and a.codeType=:codeType and riskCode=:riskCode and a.codeCName=:codeCName and a.validStatus='1'")
    public PrpDcode translateName(@Param("codeType") String codeType,@Param("codeCName") String codeCName,@Param("riskCode") String riskCode);

    /**
     * 根据codeType,codeCName,riskCode获取业务代码表数据集
     * @author: 杨成程
     * @date: 2017/12/03 15:30
     * @param codeType 代码类型
     * @param CodeCName 业务名称
     * @param riskCode 险种代码
     * @return
     */
    @Query(value="select a from PrpDcode a,PrpDcodeRisk b  where a.codeType=b.codeType  and a.codeCode=b.codeCode and a.codeType=:codeType and b.riskCode=:riskCode and a.codeCName like:codeCName and a.codeCode like:codeCode and a.validStatus='1' order by b.flag")
    public List<PrpDcode> queryCodeInfoByCodeName(@Param("codeType") String codeType,@Param("codeCode") String codeCode,@Param("codeCName") String codeCName,@Param("riskCode") String riskCode);
    /**
     *  根据客户类型查询证件类型
     * @author: 田慧
     * @date: 2017/12/23 11:25
     * @param flag flag 为1是个人，flag为2 是集体
     * @return dentifyType 证件类型
     * @throws Exception
     */
    @Query(value = "select p from PrpDcode p where p.codeType = 'IdentifyType' and p.flag = :flag")
    List<PrpDcode> queryIdentifyType(@Param("flag") String flag);
    /**
     * 根据多个代码查询对应的证件类型中文名
     *
     * @param codes 代码集合
     * @return prpDcode对象
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Query(value = "select c from PrpDcode c where c.codeType='CertiType' and c.codeCode in (:codes)")
    List<PrpDcode> queryCertifyTypeByCodes(@Param(value = "codes") List<String> codes);

    /**
     * 根据多个代码查询对应的领款人类型中文名
     *
     * @param codes 代码集合
     * @return prpDcode对象
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Query(value = "select c from PrpDcode c where c.codeType='ReceiverType' and c.codeCode in (:codes)")
    List<PrpDcode> queryReceiverTypeByCodes(@Param(value = "codes") List<String> codes);

    /**
     * 根据多个代码查询对应的银行账号属性中文名
     *
     * @param codes 代码集合
     * @return prpDcode对象
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Query(value = "select c from PrpDcode c where c.codeType='AccountType' and c.codeCode in (:codes)")
    List<PrpDcode> queryAccountTypeByCodes(@Param(value = "codes") List<String> codes);

    /**
     * 根据多个代码查询对应的银行账号类型中文名
     *
     * @param codes 代码集合
     * @return prpDcode对象
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Query(value = "select c from PrpDcode c where c.codeType='AccountFlag' and c.codeCode in (:codes)")
    List<PrpDcode> queryAccountFlagByCodes(@Param(value = "codes") List<String> codes);

    /**
     * 根据多个代码查询对应的费用类型中文名称键值对
     *
     * @param code 代码集合
     * @return 费用类型代码-费用类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Query(value = "select c from PrpDcode c where c.codeType='CostType' and c.codeCode = :code")
    PrpDcode queryCostTypeByCode(@Param(value = "code") String code);

    /**
     * 根据多个代码查询对应的银行账号类型中文名
     *
     * @param codes 代码集合
     * @return prpDcode对象
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Query(value = "select c from PrpDcode c where c.codeType='ShortRateFlagMain' and c.codeCode in (:codes)")
    List<PrpDcode> queryShortRateFlagByCodes(@Param(value = "codes") List<String> codes);

    @Query(value = "select p from PrpDcode p where p.codeType='ReportType' and p.validStatus='1'")
    List<PrpDcode> queryReportType();
}