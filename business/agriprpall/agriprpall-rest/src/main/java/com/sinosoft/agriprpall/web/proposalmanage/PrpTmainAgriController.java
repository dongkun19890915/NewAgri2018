package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTmainAgriApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainAgriDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTmainAgriService;
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
 * @time  2017-10-18 08:03:36.446 
 * @description 农业险投保单信息表controller层
 */
@RestController
@RequestMapping(value = PrpTmainAgriController.PATH)
public class PrpTmainAgriController implements PrpTmainAgriApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTmainAgriController.class);

    @Autowired
    private PrpTmainAgriService prpTmainAgriService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTmainAgriDto prpTmainAgriDto) {
        prpTmainAgriService.save(prpTmainAgriDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo) {
        prpTmainAgriService.remove(proposalNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTmainAgriDto prpTmainAgriDto) {
        prpTmainAgriService.modify(prpTmainAgriDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTmainAgriDto queryByPK(@RequestBody String proposalNo) {
        return prpTmainAgriService.queryByPK(proposalNo);
    }
}
