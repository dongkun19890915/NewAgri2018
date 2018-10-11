package com.sinosoft.txnlist.core.insuremainlist.service;


import com.sinosoft.txnlist.api.insuremainlist.dto.CMCPManFieldListDto;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * @description 草莓组合险连带被保险人表2Core接口
 */
public interface CMCPManFieldListService {

    /**
     * @param
     * @description 新增
     */
    void save(CMCPManFieldListDto cMCPManFieldListDto);

    /**
     * @param
     * @description 删除
     */
    void remove(String insureListCode, String fCode, String itemCode, String idCard, String kindCode);

    /**
     * @param
     * @description 修改
     */
    void modify(CMCPManFieldListDto cMCPManFieldListDto);

    /**
     * @param
     * @description 按主键查询实体
     */
    CMCPManFieldListDto queryByPK(String insureListCode, String fCode, String itemCode, String idCard, String kindCode);

    /**
     * mm
     * 批改保存连带被保险人清单转存
     *
     * @param policyNo
     * @return
     */
    public Boolean insertCMcTOcp(String policyNo) throws Exception;
}