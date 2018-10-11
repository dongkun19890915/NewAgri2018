package com.sinosoft.agriclaim.web.registmanage;

import com.sinosoft.agriclaim.api.registmanage.PrpLRegistTextApi;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistTextService;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
import com.sinosoft.framework.dto.PageInfo;
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
 * @time  2017-11-08 05:45:22.527 
 * @description 报案文字表controller层
 */
@RestController
@RequestMapping(value = PrpLRegistTextController.PATH)
public class PrpLRegistTextController implements PrpLRegistTextApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLRegistTextController.class);

    @Autowired
    private PrpLRegistTextService prpLRegistTextService;

    /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLRegistTextDto prpLRegistTextDto) {
        prpLRegistTextService.save(prpLRegistTextDto);
    }

    /**
     *@description 删除
     *@param map String registNo,String textType,java.lang.Integer lineNo
     */
    public void remove(@RequestBody Map<String,String> map) {
        prpLRegistTextService.remove(map.get("registNo"),map.get("textType"),Integer.parseInt(map.get("lineNo")));
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLRegistTextDto prpLRegistTextDto) {
        prpLRegistTextService.modify(prpLRegistTextDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRegistTextDto queryByPK(@RequestBody Map<String,String> map) {
        return prpLRegistTextService.queryByPK(map.get("registNo"),map.get("textType"),Integer.parseInt(map.get("lineNo")));
    }
    /**
     * @description:方法功能简述: 根据条件查询报案文字信息
     * @author chong
     * @date 2017年11月9日下午4:17:15
     * @param map registNo 报案号 textType 文本类型  (1出险摘要2拒赔文字3查勘报告)
     * @return registTextDtoList
     */
    public List<PrpLRegistTextDto> queryByRegistNoAndTextType(@RequestBody Map<String,String> map){
        String registNo = map.get("registNo");
        String textType = map.get("textType");
        return prpLRegistTextService.queryByRegistNoAndTextType(registNo,textType);
    }
}
