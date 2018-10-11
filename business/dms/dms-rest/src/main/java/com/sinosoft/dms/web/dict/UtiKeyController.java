package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.UtiKeyApi;
import com.sinosoft.dms.api.dict.dto.UtiKeyDto;
import com.sinosoft.dms.core.dict.service.UtiKeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * @description UtiKeycontroller层
 */
@RestController
@RequestMapping(value = UtiKeyController.PATH)
public class UtiKeyController implements UtiKeyApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiKeyController.class);

    @Autowired
    private UtiKeyService utiKeyService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiKeyDto utiKeyDto) {
        utiKeyService.save(utiKeyDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String tablEName) {
        utiKeyService.remove(tablEName);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiKeyDto utiKeyDto) {
        utiKeyService.modify(utiKeyDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiKeyDto queryByPK(@RequestBody String tablEName) {
        return utiKeyService.queryByPK(tablEName);
    }
}
