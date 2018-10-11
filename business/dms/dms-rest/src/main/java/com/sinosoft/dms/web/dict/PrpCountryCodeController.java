package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.PrpCountryCodeApi;
import com.sinosoft.dms.core.dict.service.PrpCountryCodeService;
import com.sinosoft.dms.api.dict.dto.PrpCountryCodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 10:28:12.446 
 * @description prpCountryCodecontroller层
 */
@RestController
@RequestMapping(value = PrpCountryCodeController.PATH)
public class PrpCountryCodeController implements PrpCountryCodeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpCountryCodeController.class);

    @Autowired
    private PrpCountryCodeService prpCountryCodeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpCountryCodeDto prpCountryCodeDto) {
        prpCountryCodeService.save(prpCountryCodeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String codeCode) {
        prpCountryCodeService.remove(codeCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpCountryCodeDto prpCountryCodeDto) {
        prpCountryCodeService.modify(prpCountryCodeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpCountryCodeDto queryByPK(@RequestBody String codeCode) {
        return prpCountryCodeService.queryByPK(codeCode);
    }
    /**
     * codeType和feildExt查询归属机构信息
     * @author: 王保良
     * @date: 2017/11/16 17:46
     * @param map 中的codeType 代码种类
     * @param map 中的feildExt 上级区域代码
     * @return 返回的是满足条件的PrpDcode实体类对象
     * @throws Exception
     */
    public List<PrpCountryCodeDto> queryAreasProvinceInfo(@RequestBody Map<String,String> map) {
        String codeType = map.get("codeType");
        String fieldExt = map.get("fieldExt");
        return prpCountryCodeService.queryAreasProvinceInfo(codeType,fieldExt);
    }

    /**
     * 按CodeCode查询实体
     * @param codeCode 代码
     * @author 王心洋
     * @time 2018-01-04
     * @return PrpCountryCodeDto
     */
    public PrpCountryCodeDto queryByCodeCode(@RequestParam("codeCode") String codeCode){
        return prpCountryCodeService.queryByCodeCode(codeCode);
    }
}
