package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.PrpMaxNoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * @description PrpMaxNoApi接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpMaxNoApi.PATH)
public interface PrpMaxNoApi {

    public static final String PATH = "prpMaxNo";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpMaxNoDto prpMaxNoDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("groupNo") String groupNo, @RequestParam("tableName")String tableName,@RequestParam("maxNo") String maxNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpMaxNoDto prpMaxNoDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpMaxNoDto queryByPK(@RequestParam("groupNo")String groupNo, @RequestParam("tableName")String tableName,@RequestParam("maxNo") String maxNo);

    /**
     * （通过分组号，表名 查询最大序号和最小序号和个数）
     * @author: 王志文
     * @date: 2017/12/14 20:06
     * @param groupNo
     * @param tableName
     * @return
     */
    @RequestMapping(value = "queryMaxNoByGroupNoAndTableName",method = {RequestMethod.POST})
    List<Object[]> queryMaxNoByGroupNoAndTableName(@RequestParam("groupNo") String groupNo, @RequestParam("tableName") String tableName);
}