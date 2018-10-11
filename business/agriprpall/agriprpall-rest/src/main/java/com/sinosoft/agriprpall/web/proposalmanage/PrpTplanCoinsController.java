package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTplanCoinsApi;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTplanCoinsService;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTplanCoinsDto;
import com.sinosoft.framework.dto.PageInfo;
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
 * @time  2017-10-24 01:57:51.087 
 * @description 共保方收费计划表controller层
 */
@RestController
@RequestMapping(value = PrpTplanCoinsController.PATH)
public class PrpTplanCoinsController implements PrpTplanCoinsApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTplanCoinsController.class);

    @Autowired
    private PrpTplanCoinsService prpTplanCoinsService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTplanCoinsDto prpTplanCoinsDto) {
        prpTplanCoinsService.save(prpTplanCoinsDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo,String coinsCode,Integer serialNo,String payReason) {
        prpTplanCoinsService.remove(proposalNo,coinsCode,serialNo,payReason);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTplanCoinsDto prpTplanCoinsDto) {
        prpTplanCoinsService.modify(prpTplanCoinsDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTplanCoinsDto queryByPK(@RequestBody String proposalNo,String coinsCode,Integer serialNo,String payReason) {
        return prpTplanCoinsService.queryByPK(proposalNo,coinsCode,serialNo,payReason);
    }
}
