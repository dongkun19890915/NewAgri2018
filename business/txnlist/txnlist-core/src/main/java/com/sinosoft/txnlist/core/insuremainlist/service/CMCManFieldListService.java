package com.sinosoft.txnlist.core.insuremainlist.service;


import com.sinosoft.txnlist.api.insuremainlist.dto.CMCManFieldListDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * @description 草莓组合险连带被保险人表1Core接口
 */
public interface CMCManFieldListService {

    /**
     * @param
     * @description 新增
     */
    void save(CMCManFieldListDto cMCManFieldListDto);

    /**
     * @param
     * @description 删除
     */
    void remove(String insureListCode, String fCode, String itemCode, String idCard, String kindCode);

    /**
     * @param
     * @description 修改
     */
    void modify(CMCManFieldListDto cMCManFieldListDto);

    /**
     * @param
     * @description 按主键查询实体
     */
    CMCManFieldListDto queryByPK(String insureListCode, String fCode, String itemCode, String idCard, String kindCode);
}