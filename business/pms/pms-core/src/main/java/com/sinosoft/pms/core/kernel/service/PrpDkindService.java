package com.sinosoft.pms.core.kernel.service;

import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 08:08:33.126
 *  险别代码表Core接口
 */
public interface PrpDkindService {

    /**
     * 新增
     *@param
     */
    void save(PrpDkindDto prpDkindDto);

    /**
     * 删除
     *@param
     */
    void remove(String riskCode, String kindCode);
    /**
     * 修改
     *@param
     */
    void modify(PrpDkindDto prpDkindDto);
    /**
     * 按主键查询实体
     *@param
     */
    PrpDkindDto queryByPK(String riskCode, String kindCode);

    /**
     *  根据riskCode查询prpdkind表
     * @author: 何伟东
     * @date: 2017/10/31 16:28
     * @param riskCode
     * @return
     */
    List<PrpDkindDto> queryByRiskCode(String riskCode);

    /**
     * 查询主险附加险别信息
     * @author: 何伟东
     * @date: 2017/11/4 16:04
     * @param riskCode 险种代码
     * @param kindCName 险种中文名称
     * @param codeType 险别类型1主险2附加险
     * @return
     */
    List<PrpDkindDto> queryKindCodeInfo(String riskCode, String kindCName, String codeType)  throws Exception;

    /**
     * 根据多个险别序号查询该险种下的险别信息
     *
     * @param riskCode  险种代码
     * @param kindCodes 险别代码集合（list）
     * @return 险别代码-险别中文名称
     * @author: 何伟东
     * @date: 2018/1/11 18:01
     */
    Map<String, String> queryByKindCodes(String riskCode, List<String> kindCodes) throws Exception;
}