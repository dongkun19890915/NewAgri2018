package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTfeildApi;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTfeildService;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTfeildDto;
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
 * @description 大户田块信息controller层
 */
@RestController
@RequestMapping(value = PrpTfeildController.PATH)
public class PrpTfeildController implements PrpTfeildApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTfeildController.class);

    @Autowired
    private PrpTfeildService prpTfeildService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTfeildDto prpTfeildDto) {
        prpTfeildService.save(prpTfeildDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo,String feildNo) {
        prpTfeildService.remove(proposalNo,feildNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTfeildDto prpTfeildDto) {
        prpTfeildService.modify(prpTfeildDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTfeildDto queryByPK(@RequestBody String proposalNo,String feildNo) {
        return prpTfeildService.queryByPK(proposalNo,feildNo);
    }
}
