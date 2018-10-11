package com.sinosoft.agriclaim.web.compensatemanage;

import com.sinosoft.agriclaim.api.compensatemanage.PrpLChargeApi;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLChargeDto;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLChargeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔款费用信息表controller层
 */
@RestController
@RequestMapping(value = PrpLChargeController.PATH)
public class PrpLChargeController implements PrpLChargeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLChargeController.class);

    @Autowired
    private PrpLChargeService prpLChargeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLChargeDto prpLChargeDto) {
        prpLChargeService.save(prpLChargeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String compensateNo,java.lang.Integer serialNo) {
        prpLChargeService.remove(compensateNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLChargeDto prpLChargeDto) {
        prpLChargeService.modify(prpLChargeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLChargeDto queryByPK(@RequestBody String compensateNo,java.lang.Integer serialNo) {
        return prpLChargeService.queryByPK(compensateNo,serialNo);
    }

    /**
     *
     * @description 根据业务号查询PrpLCharge
     * @author 周柯宇
     * @date 2018年1月26日 下午3:53:37
     * @param 业务号
     * @return List<PrpLChargeDto>
     * @Throws Exception
     */
    @Override
    @ResponseBody
    public List<PrpLChargeDto> queryByBusinessNo(@RequestParam("businessNo")String businessNo) {
        return prpLChargeService.queryByBusinessNo(businessNo);
    }


    /**
     * （理算保存赔付信息删除历史数据）
     * @author: 王志文
     * @date: 2018/4/27 15:08
     * @param compensateNo
     * @throws Exception
     */
    @Override
    public void deletePrpLchargeForCompeSave(@RequestParam("compensateNo") String compensateNo) throws Exception {
        prpLChargeService.deletePrpLchargeForCompeSave(compensateNo);
    }
}
