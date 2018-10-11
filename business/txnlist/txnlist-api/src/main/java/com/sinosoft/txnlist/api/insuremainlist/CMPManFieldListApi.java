package com.sinosoft.txnlist.api.insuremainlist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMPManFieldListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * @description 草莓组合险连带被保险人表3Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = CMPManFieldListApi.PATH)
public interface CMPManFieldListApi {

    public static final String PATH = "cMPManFieldList";

    /**
     * @param
     * @description 新增
     */
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    void save(CMPManFieldListDto cMPManFieldListDto);

    /**
     * @param
     * @description 删除
     */
    @RequestMapping(value = "remove", method = {RequestMethod.POST})
    void remove(String insureListCode, String fCode, String itemCode, String idCard, String kindCode);

    /**
     * @param
     * @description 修改
     */
    @RequestMapping(value = "modify", method = {RequestMethod.POST})
    void modify(CMPManFieldListDto cMPManFieldListDto);

    /**
     * @param
     * @description 按主键查询实体
     */
    @RequestMapping(value = "queryByPK", method = {RequestMethod.POST})
    CMPManFieldListDto queryByPK(String insureListCode, String fCode, String itemCode, String idCard, String kindCode);
}