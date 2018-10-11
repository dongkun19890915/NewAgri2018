package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDclassDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 12:48:22.282 
 * @description 险类代码表Api接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpdclassApi.PATH)
public interface PrpdclassApi {

    String PATH = "prpdclass";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDclassDto prpDclassDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("classCode") String classCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDclassDto prpdclassDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDclassDto queryByPK(@RequestParam("classCode") String classCode);

    /**
     * 查询所有的险类
     * @author: 王保良
     * @date: 2017/12/19 17:33
     * @param map 中的key为险类代码
     * @return List<PrpDclassDto> 险类内容集合
     * @throws Exception
     */
    @RequestMapping(value = "queryAllClass",method = RequestMethod.POST)
    public List<PrpDclassDto> queryAllClass(@RequestBody Map<String,String> map)throws Exception;
}