package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel.PrpDrelationClauseCodeApi;
import com.sinosoft.pms.core.kernel.service.PrpDrelationClauseCodeService;
import com.sinosoft.pms.api.kernel.dto.PrpDrelationClauseCodeDto;
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
 * @time  2017-12-18 02:37:33.970 
 * @description 条款与保险责任关联表controller层
 */
@RestController
@RequestMapping(value = PrpDrelationClauseCodeController.PATH)
public class PrpDrelationClauseCodeController implements PrpDrelationClauseCodeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDrelationClauseCodeController.class);

    @Autowired
    private PrpDrelationClauseCodeService prpDrelationClauseCodeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDrelationClauseCodeDto prpDrelationClauseCodeDto) {
        prpDrelationClauseCodeService.save(prpDrelationClauseCodeDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestParam(value="clauseCode") String clauseCode,@RequestParam(value="insuranceCode")String insuranceCode) {
        prpDrelationClauseCodeService.remove(clauseCode,insuranceCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDrelationClauseCodeDto prpDrelationClauseCodeDto) {
        prpDrelationClauseCodeService.modify(prpDrelationClauseCodeDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpDrelationClauseCodeDto queryByPK(@RequestParam(value="clauseCode") String clauseCode,@RequestParam(value="insuranceCode")String insuranceCode) {
        return prpDrelationClauseCodeService.queryByPK(clauseCode,insuranceCode);
    }
    /**
     *@description 按条款代码查询实体
     *@param
     */
    @Override
    public @ResponseBody List<PrpDrelationClauseCodeDto> queryByClauseCode( @RequestParam(value ="clauseCode" ) String clauseCode) {
        return prpDrelationClauseCodeService.queryByClauseCode(clauseCode);
    }
}
