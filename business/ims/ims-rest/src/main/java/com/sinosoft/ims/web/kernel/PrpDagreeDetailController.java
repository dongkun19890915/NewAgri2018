package com.sinosoft.ims.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.PrpDagreeDetailApi;
import com.sinosoft.ims.api.kernel.dto.PrpDagreeDetailDto;
import com.sinosoft.ims.core.kernel.service.PrpDagreeDetailService;
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
 * @description PrpDagreeDetailcontroller层
 */
@RestController
@RequestMapping(value = PrpDagreeDetailController.PATH)
public class PrpDagreeDetailController implements PrpDagreeDetailApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDagreeDetailController.class);

    @Autowired
    private PrpDagreeDetailService prpDagreeDetailService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDagreeDetailDto prpDagreeDetailDto) {
        prpDagreeDetailService.save(prpDagreeDetailDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String agreementNo,String riskCode) {
        prpDagreeDetailService.remove(agreementNo,riskCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDagreeDetailDto prpDagreeDetailDto) {
        prpDagreeDetailService.modify(prpDagreeDetailDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDagreeDetailDto queryByPK(@RequestBody String agreementNo,String riskCode) {
        return prpDagreeDetailService.queryByPK(agreementNo,riskCode);
    }
}
