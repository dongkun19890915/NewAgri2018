package com.sinosoft.txnlist.web.basicInfos;

import com.sinosoft.framework.agri.core.utils.Str;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.dto.UserInfo;
import com.sinosoft.txnlist.api.basicInfos.BasicInfosApi;
import com.sinosoft.txnlist.core.basicInfos.service.BasicInfosService;
import com.sinosoft.txnlist.api.basicInfos.dto.BasicInfosDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 12:58:53.230 
 * @description basicInfoscontroller层
 */
@RestController
@RequestMapping(value = BasicInfosController.PATH)
public class BasicInfosController implements BasicInfosApi {

    private static Logger LOGGER = LoggerFactory.getLogger(BasicInfosController.class);

    @Autowired
    private BasicInfosService basicInfosService;


    @Override
    public Map<String,Object> test(){

        Map<String,Object> map=new HashMap<>();
        UserInfo userInfo= SinoRequestContext.getCurrentContext().getUser();

        map.put("user",userInfo);
        return  map;
    }

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody BasicInfosDto basicInfosDto) {
        basicInfosService.save(basicInfosDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String code) {
        basicInfosService.remove(code);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody BasicInfosDto basicInfosDto) {
        basicInfosService.modify(basicInfosDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public BasicInfosDto queryByPK(@RequestBody String code) {
        return basicInfosService.queryByPK(code);
    }
}
