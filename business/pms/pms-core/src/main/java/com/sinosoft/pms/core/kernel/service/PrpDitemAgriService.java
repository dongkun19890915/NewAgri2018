package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDItemRequestParamsDto;
import com.sinosoft.pms.api.kernel.dto.PrpDitemAgriDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description 标的项目代码表Core接口
 */
public interface PrpDitemAgriService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDitemAgriDto prpDitemAgriDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode, String itemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDitemAgriDto prpDitemAgriDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpDitemAgriDto queryByPK(String riskCode, String itemCode);

    /**
     * @description:（查询主险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     */
    List<PrpDitemAgriDto> queryMainUnderlyingTypeByCondition(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception;
    /**
     * @description:（查询附加险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     */
    List<PrpDitemAgriDto> querySubUnderlyingTypeByCondition(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception;

    /**
     * 根据险种和标的代码查询标的名称
     * @param riskCode 险种代码
     * @param itemCode 标的代码
     * @return PrpDitem 标的项目代码表信息
     */
    public String queryItemName(String riskCode,String itemCode )throws Exception;

    /**
     * 根据险种查询prpditem表
     * @param riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    public List<PrpDitemAgriDto> queryPrpDitemInfoDto(String riskCode,String kindCode)throws Exception;

    /**
     *  根据标的名称查询标的代码
     * @author: 田慧
     * @date: 2017/12/22 11:12
     * @param itemCName 标的名称
     * @return itemCode的集合
     * @throws Exception
     */
    List<String> queryItemCode(String itemCName)throws Exception;
    /**
     * * 根据险种代码和标的代码查询标的名称
     * @author: 田慧
     * @date: 15:29
     * @param  riskCode,itemCodeList 险种代码和标的代码集合
     * @return PrpDitemAgriDto
     * @throws Exception
     */
    List<PrpDitemAgriDto> queryItemName(String riskCode,List<String> itemCodeList)throws Exception;

    /**
     * 根据险种查询prpditem表
     *
     * @param map riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */

    public Map<String, String> queryPrpDitemDto(@RequestBody Map<String, String> map) throws Exception;

}