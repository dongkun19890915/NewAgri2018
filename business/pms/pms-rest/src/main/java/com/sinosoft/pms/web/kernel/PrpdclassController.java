package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel.PrpdclassApi;
import com.sinosoft.pms.api.kernel.dto.PrpDclassDto;
import com.sinosoft.pms.core.kernel.service.PrpDclassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 12:48:22.282 
 * @description 险类代码表controller层
 */
@RestController
@RequestMapping(value = PrpdclassController.PATH)
public class PrpdclassController implements PrpdclassApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpdclassController.class);

    @Autowired
    private PrpDclassService prpDclassService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpDclassDto prpDclassDto) {
        prpDclassService.save(prpDclassDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestParam("classCode") String classCode) {
        prpDclassService.remove(classCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDclassDto prpdclassDto) {
        prpDclassService.modify(prpdclassDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
//    @Override
//    public @ResponseBody PrpDclassDto queryByPK(@RequestParam("classCode") String classCode) {
//        return prpDclassService.queryByPK(classCode);
//    }
    @Override
    public PrpDclassDto queryByPK(@RequestParam("classCode") String classCode){

        return prpDclassService.queryByPK(classCode);
    }

    /**
     * 查询所有的险类
     * @author: 王保良
     * @date: 2017/12/19 17:33
     * @param map 中的key为险类代码
     *@param
     * @throws Exception
     */
    @Override
    public List<PrpDclassDto> queryAllClass(@RequestBody Map<String,String> map) throws Exception {
        return prpDclassService.queryAll(map.get("classCode"));
    }
}
