package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpMmodelComApi;
import com.sinosoft.dms.api.model.dto.PrpMmodelComDto;
import com.sinosoft.dms.core.model.service.PrpMmodelComService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:35:35.009
 * @description 模板机构配置表controller层
 */
@RestController
@RequestMapping(value = PrpMmodelComApi.PATH)
public class PrpMmodelComController implements PrpMmodelComApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpMmodelComController.class);

   @Autowired
    private PrpMmodelComService prpMmodelComService;

   /**
     *@description 新增
     *@param
     */
   @Override
   public void save(@RequestBody List<PrpMmodelComDto> prpMmodelComDtos) {
       prpMmodelComService.save(prpMmodelComDtos);
    }

    @Override
    public List<PrpMmodelComDto> findByModelCode(@RequestParam("noticeCode") String modelCode) throws Exception {
        return prpMmodelComService.findByModelCode(modelCode);
    }

    @Override
    public void deleteByModelCode(@RequestParam("noticeCode") String modelCode) throws Exception {
        prpMmodelComService.deleteByModelCode(modelCode);
    }


    /**
     *  根据机构代码和模板代码模糊查询模板机构配置表信息
     * @author: 田慧
     * @date: 2017/12/1 10:36
     * @param map 模板代码和机构代码
     * @return PrpMmodelComDto模板机构配置表的集合
     */

    @Override
    public @ResponseBody List<PrpMmodelComDto> queryByComcode(@RequestBody Map<String,String> map)throws Exception {
        return prpMmodelComService.queryCodeListByComcode(map);
    }


}
