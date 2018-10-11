package com.sinosoft.txnlist.web.insuremainlist;

import com.sinosoft.txnlist.api.insuremainlist.CMCPManFieldListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMCPManFieldListDto;
import com.sinosoft.txnlist.core.insuremainlist.service.CMCPManFieldListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * @description 草莓组合险连带被保险人表2controller层
 */
@RestController
@RequestMapping(value = CMCPManFieldListController.PATH)
public class CMCPManFieldListController implements CMCPManFieldListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(CMCPManFieldListController.class);

    @Autowired
    private CMCPManFieldListService cMCPManFieldListService;

    /**
     * @param
     * @description 新增
     */
    public void save(@RequestBody CMCPManFieldListDto cMCPManFieldListDto) {
        cMCPManFieldListService.save(cMCPManFieldListDto);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(@RequestBody String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        cMCPManFieldListService.remove(insureListCode, fCode, itemCode, idCard, kindCode);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(@RequestBody CMCPManFieldListDto cMCPManFieldListDto) {
        cMCPManFieldListService.modify(cMCPManFieldListDto);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public CMCPManFieldListDto queryByPK(@RequestBody String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        return cMCPManFieldListService.queryByPK(insureListCode, fCode, itemCode, idCard, kindCode);
    }

    /**
     * mm
     * 批改保存连带被保险人清单转存
     *
     * @param policyNo
     * @return
     */
    public Boolean insertCMcTOcp(@RequestParam("policyNo") String policyNo) throws Exception {
        return cMCPManFieldListService.insertCMcTOcp(policyNo);
    }
}
