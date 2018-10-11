package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTaddressApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTaddressDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTaddressService;
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
 * @description 投保单地址信息表controller层
 */
@RestController
@RequestMapping(value = PrpTaddressController.PATH)
public class PrpTaddressController implements PrpTaddressApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTaddressController.class);

    @Autowired
    private PrpTaddressService prpTaddressService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTaddressDto prpTaddressDto) {
        prpTaddressService.save(prpTaddressDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo,Integer addressNo) {
        prpTaddressService.remove(proposalNo,addressNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTaddressDto prpTaddressDto) {
        prpTaddressService.modify(prpTaddressDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTaddressDto queryByPK(@RequestBody String proposalNo,Integer addressNo) {
        return prpTaddressService.queryByPK(proposalNo,addressNo);
    }
}
