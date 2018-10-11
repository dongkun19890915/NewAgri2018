package com.sinosoft.txnlist.api.insuremainlist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMCPManFieldListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * @description 草莓组合险连带被保险人表2Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = CMCPManFieldListApi.PATH)
public interface CMCPManFieldListApi {

    public static final String PATH = "cMCPManFieldList";

    /**
     * @param
     * @description 新增
     */
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    void save(CMCPManFieldListDto cMCPManFieldListDto);

    /**
     * @param
     * @description 删除
     */
    @RequestMapping(value = "remove", method = {RequestMethod.POST})
    void remove(@RequestParam("insureListCode") String insureListCode, @RequestParam("fCode") String fCode, @RequestParam("itemCode") String itemCode, @RequestParam("idCard") String idCard, @RequestParam("kindCode") String kindCode);

    /**
     * @param
     * @description 修改
     */
    @RequestMapping(value = "modify", method = {RequestMethod.POST})
    void modify(CMCPManFieldListDto cMCPManFieldListDto);

    /**
     * @param
     * @description 按主键查询实体
     */
    @RequestMapping(value = "queryByPK", method = {RequestMethod.POST})
    CMCPManFieldListDto queryByPK(@RequestParam("insureListCode") String insureListCode, @RequestParam("fCode") String fCode, @RequestParam("itemCode") String itemCode, @RequestParam("idCard") String idCard, @RequestParam("kindCode") String kindCode);

    /**
     * @author: 钱浩
     * @date: 2018/4/20 下午 15:47
     */

    @RequestMapping(value = "insertCMcTOcp", method = {RequestMethod.POST})
    Boolean insertCMcTOcp(@RequestParam("policyNo") String policyNo) throws Exception;

}