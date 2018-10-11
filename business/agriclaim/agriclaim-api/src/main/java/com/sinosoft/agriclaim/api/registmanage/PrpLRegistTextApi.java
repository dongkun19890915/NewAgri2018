package com.sinosoft.agriclaim.api.registmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * @description 报案文字表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLRegistTextApi.PATH)
public interface PrpLRegistTextApi {

    public static final String PATH = "prpLRegistText";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpLRegistTextDto prpLRegistTextDto);

    /**
     *@description 删除
     *@param map String registNo,String textType,java.lang.Integer lineNo
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestBody Map<String,String> map);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpLRegistTextDto prpLRegistTextDto);
    /**
     *@description 按主键查询实体
     *@param map String registNo,String textType,java.lang.Integer lineNo
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody
    PrpLRegistTextDto queryByPK(@RequestBody Map<String,String> map);
    /**
     * @description:方法功能简述: 根据条件查询报案文字信息
     * @author chong
     * @date 2017年11月9日下午4:17:15
     * @param map registNo 报案号 textType 文本类型  (1出险摘要2拒赔文字3查勘报告)
     * @return registTextDtoList
     */
    @RequestMapping(value = "queryByRegistNoAndTextType",method = {RequestMethod.POST})
    @ResponseBody
    List<PrpLRegistTextDto> queryByRegistNoAndTextType(@RequestBody Map<String,String> map);
}