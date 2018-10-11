package com.sinosoft.txnlist.web.insuremainlist;

import com.sinosoft.txnlist.api.insuremainlist.CMPManFieldListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMPManFieldListDto;
import com.sinosoft.txnlist.core.insuremainlist.service.CMPManFieldListService;
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
 * @description 草莓组合险连带被保险人表3controller层
 */
@RestController
@RequestMapping(value = CMPManFieldListController.PATH)
public class CMPManFieldListController implements CMPManFieldListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(CMPManFieldListController.class);

    @Autowired
    private CMPManFieldListService cMPManFieldListService;

    /**
     * @param
     * @description 新增
     */
    public void save(@RequestBody CMPManFieldListDto cMPManFieldListDto) {
        cMPManFieldListService.save(cMPManFieldListDto);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(@RequestBody String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        cMPManFieldListService.remove(insureListCode, fCode, itemCode, idCard, kindCode);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(@RequestBody CMPManFieldListDto cMPManFieldListDto) {
        cMPManFieldListService.modify(cMPManFieldListDto);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public CMPManFieldListDto queryByPK(@RequestBody String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        return cMPManFieldListService.queryByPK(insureListCode, fCode, itemCode, idCard, kindCode);
    }
}
