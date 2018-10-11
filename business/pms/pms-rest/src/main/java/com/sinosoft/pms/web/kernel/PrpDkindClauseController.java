package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.PrpDkindClauseApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindClauseDto;
import com.sinosoft.pms.core.kernel.service.PrpDkindClauseService;
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
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDkindClausecontroller层
 */
@RestController
@RequestMapping(value = PrpDkindClauseController.PATH)
public class PrpDkindClauseController implements PrpDkindClauseApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDkindClauseController.class);

    @Autowired
    private PrpDkindClauseService prpDkindClauseService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpDkindClauseDto prpDkindClauseDto) {
        prpDkindClauseService.save(prpDkindClauseDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody String riskCode,String clauseFlag,String kindCode,String language,String clauseCode) {
        prpDkindClauseService.remove(riskCode,clauseFlag,kindCode,language,clauseCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDkindClauseDto prpDkindClauseDto) {
        prpDkindClauseService.modify(prpDkindClauseDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDkindClauseDto queryByPK(@RequestBody String riskCode,String clauseFlag,String kindCode,String language,String clauseCode) {
        return prpDkindClauseService.queryByPK(riskCode,clauseFlag,kindCode,language,clauseCode);
    }
}
