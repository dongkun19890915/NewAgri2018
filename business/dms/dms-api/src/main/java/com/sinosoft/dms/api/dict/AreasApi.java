package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.AreasDto;
import com.sinosoft.dms.api.dict.dto.AreasParamsDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
* @Description:（承保清单归属区域查询）
* @Author: 董坤
* @Date: 2017/10/14 8:53
*/
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = AreasApi.PATH)
public interface AreasApi {

    public static final String PATH = "areas";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(AreasDto areasDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String areaCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(AreasDto areasDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    AreasDto queryByPK(String areaCode);

    /**R
     * @description:（查询承保清单归属区域信息）
     * @author: 董坤
     * @date: 2017/10/14 8:55
     * @param areasParamsDto
     * @return List<AreasDto>
     * @throws Exception
     */
    @RequestMapping(value="queryAreasByCondition",method={RequestMethod.POST})
    public @ResponseBody
    List<AreasDto> queryAreasByCondition(AreasParamsDto areasParamsDto) throws Exception;
}