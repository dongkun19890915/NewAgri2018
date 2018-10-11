package com.sinosoft.agriclaim.web.docmanage;

import com.sinosoft.agriclaim.api.docmanage.PrplCertifyDirectApi;
import com.sinosoft.agriclaim.api.docmanage.dto.PrplCertifyDirectDto;
import com.sinosoft.agriclaim.core.docmanage.service.PrplCertifyDirectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:44:49.773 
 * @description 索赔指引表controller层
 */
@RestController
@RequestMapping(value = PrplCertifyDirectController.PATH)
public class PrplCertifyDirectController implements PrplCertifyDirectApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrplCertifyDirectController.class);

    @Autowired
    private PrplCertifyDirectService prplCertifyDirectService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrplCertifyDirectDto prplCertifyDirectDto) {
        prplCertifyDirectService.save(prplCertifyDirectDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,Integer serialNo,String lossItemCode) {
        prplCertifyDirectService.remove(registNo,serialNo,lossItemCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrplCertifyDirectDto prplCertifyDirectDto) {
        prplCertifyDirectService.modify(prplCertifyDirectDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrplCertifyDirectDto queryByPK(@RequestBody String registNo,Integer serialNo,String lossItemCode) {
        return prplCertifyDirectService.queryByPK(registNo,serialNo,lossItemCode);
    }
}
