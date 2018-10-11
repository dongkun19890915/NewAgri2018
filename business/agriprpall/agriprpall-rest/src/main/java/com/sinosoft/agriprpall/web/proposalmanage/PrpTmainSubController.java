package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTmainSubApi;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTmainSubService;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainSubDto;
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
 * @description 投保单隶属表controller层
 */
@RestController
@RequestMapping(value = PrpTmainSubController.PATH)
public class PrpTmainSubController implements PrpTmainSubApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTmainSubController.class);

    @Autowired
    private PrpTmainSubService prpTmainSubService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTmainSubDto prpTmainSubDto) {
        prpTmainSubService.save(prpTmainSubDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo,String mainPolicyNo) {
        prpTmainSubService.remove(proposalNo,mainPolicyNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTmainSubDto prpTmainSubDto) {
        prpTmainSubService.modify(prpTmainSubDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTmainSubDto queryByPK(@RequestBody String proposalNo,String mainPolicyNo) {
        return prpTmainSubService.queryByPK(proposalNo,mainPolicyNo);
    }
}
