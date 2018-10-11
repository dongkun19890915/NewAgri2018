package com.sinosoft.dms.api.model;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.model.dto.PrpMmodelComDto;
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
 * @time  2017-11-07 03:35:35.009 
 * @description 模板机构配置表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpMmodelComApi.PATH)
public interface PrpMmodelComApi {

   public static final String PATH = "prpMmodelCom";

    /**
     *@description 新增
     *@param
     */
   @RequestMapping(value = "save",method = {RequestMethod.POST})
   void save(@RequestBody List<PrpMmodelComDto> prpMmodelComDtos);

    /**
     * 内部调用
     * @author: 潘峰
     * @date: 2017/12/13 下午2:30
     * @param modelCode
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "find", method = {RequestMethod.GET})
    List<PrpMmodelComDto> findByModelCode(@RequestParam("noticeCode") String modelCode) throws Exception;


    /**
     * 内部调用
     * @author: 潘峰
     * @date: 2017/12/13 下午2:30
     * @param modelCode
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    void deleteByModelCode(@RequestParam("noticeCode") String modelCode) throws Exception;


    /**
     *  根据机构代码和模板代码模糊查询模板机构配置表信息
     * @author: 田慧
     * @date: 2017/11/8 19:54
     * @param map 模板代码和机构代码
     * @return PrpMmodelComDto模板机构配置表的集合
     */
   @RequestMapping(value = "queryByComcode",method = {RequestMethod.POST})
   public List<PrpMmodelComDto> queryByComcode(@RequestBody Map<String,String> map)throws Exception;
}