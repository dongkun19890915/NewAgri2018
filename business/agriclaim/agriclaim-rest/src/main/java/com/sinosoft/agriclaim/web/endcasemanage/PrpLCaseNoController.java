package com.sinosoft.agriclaim.web.endcasemanage;

import com.sinosoft.agriclaim.api.endcasemanage.PrpLCaseNoApi;
import com.sinosoft.agriclaim.core.endcasemanage.service.PrpLCaseNoService;
import com.sinosoft.agriclaim.api.endcasemanage.dto.PrpLCaseNoDto;
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
 * @description 赔案号表controller层
 */
@RestController
@RequestMapping(value = PrpLCaseNoController.PATH)
public class PrpLCaseNoController implements PrpLCaseNoApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCaseNoController.class);

    @Autowired
    private PrpLCaseNoService prpLCaseNoService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCaseNoDto prpLCaseNoDto) {
        prpLCaseNoService.save(prpLCaseNoDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("certiNo") String certiNo,@RequestParam("certiType")String certiType,@RequestParam("caseNo")String caseNo) {
        prpLCaseNoService.remove(certiNo,certiType,caseNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCaseNoDto prpLCaseNoDto) {
        prpLCaseNoService.modify(prpLCaseNoDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCaseNoDto queryByPK(@RequestParam("certiNo") String certiNo,@RequestParam("certiType")String certiType,@RequestParam("caseNo")String caseNo) {
        return prpLCaseNoService.queryByPK(certiNo,certiType,caseNo);
    }

    /**
     * @author jiaoyunzhen
     * @serialData 2017年12月22日09:48:10
     */
    @Override
    public int count(@RequestParam("caseNo") String caseNo,@RequestParam("strCaseNo") String strCaseNo) {
        return prpLCaseNoService.count(caseNo,strCaseNo);
    }
}
