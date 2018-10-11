package com.sinosoft.agriclaim.web.claimmanage;

import com.sinosoft.agriclaim.api.claimmanage.PrpLClaimLossApi;
import com.sinosoft.agriclaim.api.claimmanage.dto.ClaimDto1;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimLossService;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimLossDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案险别估损金额表controller层
 */
@RestController
@RequestMapping(value = PrpLClaimLossController.PATH)
public class PrpLClaimLossController implements PrpLClaimLossApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLClaimLossController.class);

    @Autowired
    private PrpLClaimLossService prpLClaimLossService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLClaimLossDto prpLClaimLossDto) {
        prpLClaimLossService.save(prpLClaimLossDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("claimNo") String claimNo,@RequestParam("serialNo") java.lang.Integer serialNo) {
        prpLClaimLossService.remove(claimNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLClaimLossDto prpLClaimLossDto) {
        prpLClaimLossService.modify(prpLClaimLossDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimLossDto queryByPK(@RequestParam("claimNo") String claimNo,@RequestParam("serialNo") java.lang.Integer serialNo) {
        return prpLClaimLossService.queryByPK(claimNo,serialNo);
    }

    /**
     *  根据立案号查询PrpLClaimLoss表信息
     * @author: 汪钊
     * @date: 2017/11/20 15:50
     * @param map 包括claimNo立案号
     * @return prpLClaimLossDtoList 返回PrpLClaimLossDto的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByClaimNo",method = {RequestMethod.POST})
    public List<PrpLClaimLossDto> queryByClaimNo(@RequestBody Map<String,String> map){
        return prpLClaimLossService.queryByClaimNo(map.get("claimNo"));
    }

   public String saveCLaimLoss( @RequestBody ClaimDto1 claimDto)throws Exception{
     return prpLClaimLossService.saveCLaimLoss(claimDto);
   };
}
