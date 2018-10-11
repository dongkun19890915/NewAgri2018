package com.sinosoft.ims.api.auth;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703
 * @description UtiCodeTransferApi接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UtiCodeTransferApi.PATH)
public interface UtiCodeTransferApi {

    public static final String PATH = "utiCodeTransfer";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(UtiCodeTransferDto utiCodeTransferDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String configCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(UtiCodeTransferDto utiCodeTransferDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    UtiCodeTransferDto queryByPK(@RequestParam("configCode") String configCode);

    /**
     * 根据险种大类查询UtiCodeTransferDto 险别大类结果集
     * @author: 田慧
     * @date: 2017/11/22 17:05
     * @param map 包括riskType 险种大类
     * @return UtiCodeTransferDto  险别大类的集合
     */
    @RequestMapping(value = "queryByRiskType",method = {RequestMethod.POST})
    public List<UtiCodeTransferDto> queryByRiskType(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 根据outerCode查询UtiCodeTransferDto 险别大类结果集
     * @author 杨昆
     * @date 2017年12月15日 下午10:28:15
     * @param map 包括outerCode属性
     * @return UtiCodeTransferDto集合
     */
    @RequestMapping(value = "queryUtiCodeTransferDtoByOuterCode", method = RequestMethod.POST)
    public List<UtiCodeTransferDto> queryUtiCodeTransferDtoByOuterCode(@RequestBody Map<String,String> map) ;
    /**
     * @description:方法功能简述: 根据传入的险种类型查询出outerCode集合
     * @author 安齐崇
     * @date 2017年12月14日下午11:12:33
     * @param riskTypes
     * @return
     */
    @RequestMapping(value = "queryOuterCodeByTypes",method = {RequestMethod.POST})
    @ResponseBody
    List<String> queryOuterCodeByTypes(@RequestBody List<String> riskTypes);

}