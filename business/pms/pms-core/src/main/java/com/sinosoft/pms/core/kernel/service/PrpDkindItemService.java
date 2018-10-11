package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.PrpDkindItemDto;
import com.sinosoft.pms.api.kernel.dto.QueryItemCodePmsDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDkindItemCore接口
 */
public interface PrpDkindItemService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDkindItemDto prpDkindItemDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode, String kindCode, String itemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDkindItemDto prpDkindItemDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDkindItemDto queryByPK(String riskCode, String kindCode, String itemCode);
    /**
     * * 根据险种代码和险别代码查询标的代码
     * @author: 田慧
     * *@param queryItemCodePmsDto  险种代码和险别代码
     * @date: 13:22
     * @return itemCodeList 标的代码集合
     */
     List<String> queryItemCode(String riskCode,List<String> kindCodeList) throws Exception;

    /**
     * 根据险别和险种及标的代码查询险别标的关联表
     * @author: 刘曼曼
     * @date: 10:29 10:29
     * @param riskCode 险种代码
     * @param kindCodes 险别代码
     * @param itemCodes 标的代码
     * @return List<PrpDkindItem> 询险别标的关联表集合
     */
    public List<PrpDkindItemDto> queryFlag(String riskCode, List<String> kindCodes, List<String> itemCodes)throws Exception;
}