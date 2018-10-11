package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDItemRequestParamsDto;
import com.sinosoft.pms.api.kernel.dto.PrpDitemDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-04 10:42:46.546
 * @description 标的项目代码表Core接口
 */
public interface PrpDitemService {

    /**
     * @param
     * @description 新增
     */
    void save(PrpDitemDto prpDitemDto);

    /**
     * @param
     * @description 删除
     */
    void remove(String riskCode, String itemCode);

    /**
     * @param
     * @description 修改
     */
    void modify(PrpDitemDto prpDitemDto);

    /**
     * @param
     * @description 按主键查询实体
     */
    PrpDitemDto queryByPK(String riskCode, String itemCode);

    /**
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     * @description:（查询主险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     */
    List<PrpDitemDto> queryMainUnderlyingTypeByCondition(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception;

    /**
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     * @description:（查询附加险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     */
    List<PrpDitemDto> querySubUnderlyingTypeByCondition(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception;

    /**
     * 根据险种和标的代码查询标的名称
     *
     * @param riskCode 险种代码
     * @param itemCode 标的代码
     * @return PrpDitem 标的项目代码表信息
     */
    public String queryItemName(String riskCode, String itemCode) throws Exception;

    /**
     * 根据险种查询prpditem表
     *
     * @param riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    public List<PrpDitemDto> queryPrpDitemInfoDto(String riskCode, String kindCode) throws Exception;

    /**
     * 根据标的名称查询标的代码
     *
     * @param itemCName 标的名称
     * @return itemCode的集合
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/22 11:12
     */
    List<String> queryItemCode(String itemCName) throws Exception;

    /**
     * 根据险种代码和多个标的代码查询标的中文名称
     *
     * @param riskCode  险种代码
     * @param itemCodes 标的代码
     * @return 标的代码-标的名称
     * @author: 何伟东
     * @date: 2018/1/11 19:29
     */
    Map<String, String> queryByItemCodes(String riskCode, List<String> itemCodes);

    /**
     * 根据险种代码查询对应的标的信息
     *
     * @param riskCode 险种代码
     * @return 标的代码-标的名称
     * @author: 何伟东
     * @date: 2018/1/11 19:29
     */
    List<PrpDitemDto> queryByRiskCode(String riskCode);
}