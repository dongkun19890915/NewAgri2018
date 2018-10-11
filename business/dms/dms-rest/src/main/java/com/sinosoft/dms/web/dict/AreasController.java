package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.AreasApi;
import com.sinosoft.dms.api.dict.dto.AreasDto;
import com.sinosoft.dms.api.dict.dto.AreasParamsDto;
import com.sinosoft.dms.core.dict.service.AreasService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 06:45:04.724 
 * @description 行政区域表controller层
 */
@RestController
@RequestMapping(value = AreasController.PATH)
public class AreasController implements AreasApi {

    private static Logger LOGGER = LoggerFactory.getLogger(AreasController.class);

    @Autowired
    private AreasService areasService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody AreasDto areasDto) {
        areasService.save(areasDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String areaCode) {
        areasService.remove(areaCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody AreasDto areasDto) {
        areasService.modify(areasDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public AreasDto queryByPK(@RequestBody String areaCode) {
        return areasService.queryByPK(areaCode);
    }

    /**
     * @description:（查询承保清单归属区域信息）
     * @author: 董坤
     * @date: 2017/10/14 8:55
     * @param areasParamsDto
     * @return List<AreasDto>
     * @throws Exception
     */
    @Override
    public @ResponseBody
    List<AreasDto> queryAreasByCondition(@RequestBody AreasParamsDto areasParamsDto) throws Exception{
        return areasService.queryAreasByCondition(areasParamsDto);
    }
}
