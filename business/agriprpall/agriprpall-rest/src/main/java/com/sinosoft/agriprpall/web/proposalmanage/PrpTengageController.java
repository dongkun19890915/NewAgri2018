package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTengageApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTengageDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTengageDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTengageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author codegen@研发中心
 * @mail yanghang@sinosoft.com.cn
 * @time  2017-10-19 06:31:19.937 
 * @description 特别约定表controller层
 */
@RestController
@RequestMapping(value = PrpTengageController.PATH)
public class PrpTengageController implements PrpTengageApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTengageController.class);

    @Autowired
    private PrpTengageService prpTengageService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTengageDto prpTengageDto) {
        prpTengageService.save(prpTengageDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo,Integer serialNo,Integer lineno) {
        prpTengageService.remove(proposalNo,serialNo,lineno);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTengageDto prpTengageDto) {
        prpTengageService.modify(prpTengageDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTengageDto queryByPK(@RequestBody String proposalNo, Integer serialNo, Integer lineno) {
        return prpTengageService.queryByPK(proposalNo,serialNo,lineno);
    }
}
