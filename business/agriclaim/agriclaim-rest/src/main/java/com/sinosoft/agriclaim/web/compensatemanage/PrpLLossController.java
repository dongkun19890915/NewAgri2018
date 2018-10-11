package com.sinosoft.agriclaim.web.compensatemanage;

import com.sinosoft.agriclaim.api.compensatemanage.PrpLLossApi;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLLossDto;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLLossService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔付标的信息表controller层
 */
@RestController
@RequestMapping(value = PrpLLossController.PATH)
public class PrpLLossController implements PrpLLossApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLLossController.class);

    @Autowired
    private PrpLLossService prpLLossService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLLossDto prpLLossDto) {
        prpLLossService.save(prpLLossDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String compensateNo,java.lang.Integer serialNo) {
        prpLLossService.remove(compensateNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLLossDto prpLLossDto) {
        prpLLossService.modify(prpLLossDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLLossDto queryByPK(@RequestBody String compensateNo,java.lang.Integer serialNo) {
        return prpLLossService.queryByPK(compensateNo,serialNo);
    }

    /**
     *
     * @description 根据业务号查询PrpLLoss表
     * @author 周柯宇
     * @date 2018年1月26日 下午3:49:27
     * @param businessNo
     * @return List<PrpLLossDto>
     * @Throws Exception
     */
    @Override
    @ResponseBody
    public List<PrpLLossDto> queryByBusinessNo(@RequestParam("businessNo")String businessNo) {

        return prpLLossService.queryByBusinessNo(businessNo);
    }
}
