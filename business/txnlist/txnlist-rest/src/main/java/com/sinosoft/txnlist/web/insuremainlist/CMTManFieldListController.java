package com.sinosoft.txnlist.web.insuremainlist;

import com.sinosoft.txnlist.api.insuremainlist.CMTManFieldListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMTManFieldListDto;
import com.sinosoft.txnlist.core.insuremainlist.service.CMTManFieldListService;
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
 * @description 草莓组合险连带被保险人表controller层
 */
@RestController
@RequestMapping(value = CMTManFieldListController.PATH)
public class CMTManFieldListController implements CMTManFieldListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(CMTManFieldListController.class);

    @Autowired
    private CMTManFieldListService cMTManFieldListService;

    /**
     * @param
     * @description 新增
     */
    public void save(@RequestBody CMTManFieldListDto cMTManFieldListDto) {
        cMTManFieldListService.save(cMTManFieldListDto);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(@RequestBody String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        cMTManFieldListService.remove(insureListCode, fCode, itemCode, idCard, kindCode);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(@RequestBody CMTManFieldListDto cMTManFieldListDto) {
        cMTManFieldListService.modify(cMTManFieldListDto);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public CMTManFieldListDto queryByPK(@RequestBody String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        return cMTManFieldListService.queryByPK(insureListCode, fCode, itemCode, idCard, kindCode);
    }
}
