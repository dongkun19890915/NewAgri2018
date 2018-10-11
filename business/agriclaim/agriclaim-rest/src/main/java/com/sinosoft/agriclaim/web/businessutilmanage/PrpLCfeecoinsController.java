package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLCfeecoinsApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLCfeecoinsDto;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLCfeecoinsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 共保费用信息表（无表名）controller层
 */
@RestController
@RequestMapping(value = PrpLCfeecoinsController.PATH)
public class PrpLCfeecoinsController implements PrpLCfeecoinsApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCfeecoinsController.class);

    @Autowired
    private PrpLCfeecoinsService prpLCfeecoinsService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCfeecoinsDto prpLCfeecoinsDto) {
        prpLCfeecoinsService.save(prpLCfeecoinsDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String businessNo,java.lang.Double serialNo) {
        prpLCfeecoinsService.remove(businessNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCfeecoinsDto prpLCfeecoinsDto) {
        prpLCfeecoinsService.modify(prpLCfeecoinsDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCfeecoinsDto queryByPK(@RequestBody String businessNo,java.lang.Double serialNo) {
        return prpLCfeecoinsService.queryByPK(businessNo,serialNo);
    }

    /**
     * @description 共保费用信息表查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
    @Override
    @ResponseBody
    public List<PrpLCfeecoinsDto> queryByBusinessNo(@RequestParam("businessNo")String businessNo) throws Exception {
        return prpLCfeecoinsService.queryByBusinessNo(businessNo);
    }
}
