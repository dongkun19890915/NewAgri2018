package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTitemKindAgriApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTitemKindAgriDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTitemKindAgriService;
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
 * @description 农险标的信息表controller层
 */
@RestController
@RequestMapping(value = PrpTitemKindAgriController.PATH)
public class PrpTitemKindAgriController implements PrpTitemKindAgriApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTitemKindAgriController.class);

    @Autowired
    private PrpTitemKindAgriService prpTitemKindAgriService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTitemKindAgriDto prpTitemKindAgriDto) {
        prpTitemKindAgriService.save(prpTitemKindAgriDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo,Integer itemKindNo,String kindCode,Integer times) {
        prpTitemKindAgriService.remove(proposalNo,itemKindNo,kindCode,times);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTitemKindAgriDto prpTitemKindAgriDto) {
        prpTitemKindAgriService.modify(prpTitemKindAgriDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTitemKindAgriDto queryByPK(@RequestBody String proposalNo,Integer itemKindNo,String kindCode,Integer times) {
        return prpTitemKindAgriService.queryByPK(proposalNo,itemKindNo,kindCode,times);
    }
}
