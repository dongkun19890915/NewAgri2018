package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.PrpTownCodeApi;
import com.sinosoft.dms.core.dict.service.PrpTownCodeService;
import com.sinosoft.dms.api.dict.dto.PrpTownCodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 10:26:37.210 
 * @description prpTownCodecontroller层
 */
@RestController
@RequestMapping(value = PrpTownCodeController.PATH)
public class PrpTownCodeController implements PrpTownCodeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTownCodeController.class);

    @Autowired
    private PrpTownCodeService prpTownCodeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTownCodeDto prpTownCodeDto) {
        prpTownCodeService.save(prpTownCodeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String codeCode) {
        prpTownCodeService.remove(codeCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTownCodeDto prpTownCodeDto) {
        prpTownCodeService.modify(prpTownCodeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTownCodeDto queryByPK(@RequestBody String codeCode) {
        return prpTownCodeService.queryByPK(codeCode);
    }
    /**
     * codeType和feildExt查询归属机构信息
     * @author: 王保良
     * @date: 2017/11/16 17:46
     * @param  map 的 codeType 代码种类
     * @param    map 的 feildExt 上级区域代码
     * @return 返回的是满足条件的PrpDcode实体类对象
     * @throws Exception
     */
    @Override
    public List<PrpTownCodeDto> queryAreasProvinceInfo(@RequestBody Map<String,String> map) throws Exception {
        String codeType = map.get("codeType");
        String fieldExt = map.get("fieldExt");
        return prpTownCodeService.queryAreasProvinceInfo(codeType,fieldExt);
    }
}
