package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.PrpDpersonFeeCodeRiskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDpersonFeeCodeRiskDto;
import com.sinosoft.pms.core.kernel.service.PrpDpersonFeeCodeRiskService;
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
 * @time  2017-11-04 10:42:46.546 
 * @description 人伤费用险种对照表controller层
 */
@RestController
@RequestMapping(value = PrpDpersonFeeCodeRiskController.PATH)
public class PrpDpersonFeeCodeRiskController implements PrpDpersonFeeCodeRiskApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDpersonFeeCodeRiskController.class);

    @Autowired
    private PrpDpersonFeeCodeRiskService prpDpersonFeeCodeRiskService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto) {
        prpDpersonFeeCodeRiskService.save(prpDpersonFeeCodeRiskDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody String riskCode,String feeCode) {
        prpDpersonFeeCodeRiskService.remove(riskCode,feeCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto) {
        prpDpersonFeeCodeRiskService.modify(prpDpersonFeeCodeRiskDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDpersonFeeCodeRiskDto queryByPK(@RequestBody String riskCode,String feeCode) {
        return prpDpersonFeeCodeRiskService.queryByPK(riskCode,feeCode);
    }
}
