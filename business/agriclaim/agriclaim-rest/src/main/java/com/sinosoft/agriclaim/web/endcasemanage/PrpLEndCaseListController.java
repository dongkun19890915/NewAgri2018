package com.sinosoft.agriclaim.web.endcasemanage;

import com.sinosoft.agriclaim.api.endcasemanage.PrpLEndCaseListApi;
import com.sinosoft.agriclaim.core.endcasemanage.service.PrpLEndCaseListService;
import com.sinosoft.agriclaim.api.endcasemanage.dto.PrpLEndCaseListDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:04.174 
 * @description 结案基本信息表controller层
 */
@RestController
@RequestMapping(value = PrpLEndCaseListController.PATH)
public class PrpLEndCaseListController implements PrpLEndCaseListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLEndCaseListController.class);

    @Autowired
    private PrpLEndCaseListService prpLEndCaseListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLEndCaseListDto prpLEndCaseListDto) {
        prpLEndCaseListService.save(prpLEndCaseListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Integer id) {
        prpLEndCaseListService.remove(id);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLEndCaseListDto prpLEndCaseListDto) {
        prpLEndCaseListService.modify(prpLEndCaseListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLEndCaseListDto queryByPK(@RequestBody java.lang.Integer id) {
        return prpLEndCaseListService.queryByPK(id);
    }
}
