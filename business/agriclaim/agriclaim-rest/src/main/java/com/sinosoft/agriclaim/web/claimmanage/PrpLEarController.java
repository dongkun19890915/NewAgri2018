package com.sinosoft.agriclaim.web.claimmanage;

import com.sinosoft.agriclaim.api.claimmanage.PrpLEarApi;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLEarDto;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLEarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-01 01:33:42.103 
 * @description 耳标号表controller层
 */
@RestController
@RequestMapping(value = PrpLEarController.PATH)
public class PrpLEarController implements PrpLEarApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLEarController.class);

    @Autowired
    private PrpLEarService prpLEarService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLEarDto prpLEarDto) {
        prpLEarService.save(prpLEarDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String policyNo,String earNo,String registNo) {
        prpLEarService.remove(policyNo,earNo,registNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLEarDto prpLEarDto) {
        prpLEarService.modify(prpLEarDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLEarDto queryByPK(@RequestBody String policyNo,String earNo,String registNo) {
        return prpLEarService.queryByPK(policyNo,earNo,registNo);
    }
}
