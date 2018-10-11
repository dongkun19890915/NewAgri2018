package com.sinosoft.txnlist.core.insuremainlist.service;


import com.sinosoft.txnlist.api.insuremainlist.dto.CMTManFieldListDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * @description 草莓组合险连带被保险人表Core接口
 */
public interface CMTManFieldListService {

    /**
     * @param
     * @description 新增
     */
    void save(CMTManFieldListDto cMTManFieldListDto);

    /**
     * @param
     * @description 删除
     */
    void remove(String insureListCode, String fCode, String itemCode, String idCard, String kindCode);

    /**
     * @param
     * @description 修改
     */
    void modify(CMTManFieldListDto cMTManFieldListDto);

    /**
     * @param
     * @description 按主键查询实体
     */
    CMTManFieldListDto queryByPK(String insureListCode, String fCode, String itemCode, String idCard, String kindCode);
}