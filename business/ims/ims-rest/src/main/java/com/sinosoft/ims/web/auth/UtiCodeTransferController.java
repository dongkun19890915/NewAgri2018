package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiCodeTransferApi;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.core.auth.service.UtiCodeTransferService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description UtiCodeTransfercontroller层
 */
@RestController
@RequestMapping(value = UtiCodeTransferController.PATH)
public class UtiCodeTransferController implements UtiCodeTransferApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiCodeTransferController.class);

    @Autowired
    private UtiCodeTransferService utiCodeTransferService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiCodeTransferDto utiCodeTransferDto) {
        utiCodeTransferService.save(utiCodeTransferDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String configCode) {
        utiCodeTransferService.remove(configCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiCodeTransferDto utiCodeTransferDto) {
        utiCodeTransferService.modify(utiCodeTransferDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */

    public UtiCodeTransferDto queryByPK(@RequestParam("configCode") String configCode) {
        return utiCodeTransferService.queryByPK(configCode);
    }
    /**
     * 根据险种大类查询UtiCodeTransferDto 险别大类结果集
     * @author: 田慧
     * @date: 2017/11/22 17:05
     * @param map 包括riskType 险种大类
     * @return UtiCodeTransferDto 险别大类的集合
     */
    @Override
    public List<UtiCodeTransferDto> queryByRiskType(@RequestBody Map<String,String> map)throws Exception{
        String riskType = map.get("riskType");
        return utiCodeTransferService.queryByRiskType(riskType);
    }
    
     /**
      * 根据outerCode查询UtiCodeTransferDto 险别大类结果集
      * @author 杨昆
      * @date 2017年12月15日 下午10:28:15
      * @param map 包括outerCode属性
      * @return UtiCodeTransferDto集合
      */
    @Override
	public List<UtiCodeTransferDto> queryUtiCodeTransferDtoByOuterCode(@RequestBody Map<String,String> map) {
    	String outerCode = map.get("outerCode");
    	return utiCodeTransferService.queryUtiCodeTransferDtoByOuterCode(outerCode);
    }
    /**
     * @description:方法功能简述: 根据传入的险种类型查询出outerCode集合
     * @author 安齐崇
     * @date 2017年12月14日下午11:12:33
     * @param riskTypes
     * @return
     */
    @Override
	@ResponseBody
	public List<String> queryOuterCodeByTypes(@RequestBody List<String> riskTypes) {
		return utiCodeTransferService.queryOuterCodeByTypes(riskTypes);
	}

}
