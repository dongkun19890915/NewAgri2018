package com.sinosoft.pms.core.kernel.service;

import com.sinosoft.pms.api.kernel.dto.PrpDkindAgriDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 08:08:33.126
 *  险别代码表Core接口
 */
public interface PrpDkindAgriService {

    /**
     * 新增
     *@param
     */
    void save(PrpDkindAgriDto prpDkindAgriDto);

    /**
     * 删除
     *@param
     */
    void remove(String riskCode, String kindCode);
    /**
     * 修改
     *@param
     */
    void modify(PrpDkindAgriDto prpDkindAgriDto);
    /**
     * 按主键查询实体
     *@param
     */
    PrpDkindAgriDto queryByPK(String riskCode, String kindCode);

    /**
     *  根据riskCode查询prpdkind表
     * @author: 何伟东
     * @date: 2017/10/31 16:28
     * @param riskCode
     * @return
     */
    List<PrpDkindAgriDto> queryByRiskCode(String riskCode);

    /**
     * 查询主险附加险别信息
     * @author: 何伟东
     * @date: 2017/11/4 16:04
     * @param riskCode 险种代码
     * @param kindCName 险种中文名称
     * @param codeType 险别类型1主险2附加险
     * @return
     */
    List<PrpDkindAgriDto> queryKindCodeInfo(String riskCode, String kindCName, String codeType)  throws Exception;
    /**
     * （根据险别代码查询prpdkindagri表返回中文或英文名称）
     * @author: 刘曼曼
     * @date: 2018/1/22 15:47
     * @param riskCode 险种代码
     * @param isChinese 中文标识
     * @return 中文或英文名称
     */
    public String translateCode(String kindCode,String riskCode, String isChinese) throws Exception;

}