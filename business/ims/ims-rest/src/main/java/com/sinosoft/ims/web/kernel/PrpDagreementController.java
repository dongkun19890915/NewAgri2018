package com.sinosoft.ims.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.PrpDagreementApi;
import com.sinosoft.ims.api.kernel.dto.PrpDagreementDto;
import com.sinosoft.ims.core.kernel.service.PrpDagreementService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description 代理协议表controller层
 */
@RestController
@RequestMapping(value = PrpDagreementController.PATH)
public class PrpDagreementController implements PrpDagreementApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDagreementController.class);

    @Autowired
    private PrpDagreementService prpDagreementService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDagreementDto prpDagreementDto) {
        prpDagreementService.save(prpDagreementDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String agreementNo) {
        prpDagreementService.remove(agreementNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDagreementDto prpDagreementDto) {
        prpDagreementService.modify(prpDagreementDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDagreementDto queryByPK(@RequestBody String agreementNo) {
        return prpDagreementService.queryByPK(agreementNo);
    }
}
