package com.sinosoft.txnlist.web.insuremainlist;

import com.sinosoft.txnlist.api.insuremainlist.CMCManFieldListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMCManFieldListDto;
import com.sinosoft.txnlist.core.insuremainlist.service.CMCManFieldListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * @description 草莓组合险连带被保险人表1controller层
 */
@RestController
@RequestMapping(value = CMCManFieldListController.PATH)
public class CMCManFieldListController implements CMCManFieldListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(CMCManFieldListController.class);

    @Autowired
    private CMCManFieldListService cMCManFieldListService;

    /**
     * @param
     * @description 新增
     */
    public void save(@RequestBody CMCManFieldListDto cMCManFieldListDto) {
        cMCManFieldListService.save(cMCManFieldListDto);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(@RequestBody String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        cMCManFieldListService.remove(insureListCode, fCode, itemCode, idCard, kindCode);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(@RequestBody CMCManFieldListDto cMCManFieldListDto) {
        cMCManFieldListService.modify(cMCManFieldListDto);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public CMCManFieldListDto queryByPK(@RequestBody String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        return cMCManFieldListService.queryByPK(insureListCode, fCode, itemCode, idCard, kindCode);
    }
}
