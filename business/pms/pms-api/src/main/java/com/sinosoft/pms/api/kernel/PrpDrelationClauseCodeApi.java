package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDrelationClauseCodeDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-18 02:37:33.970 
 * @description 条款与保险责任关联表Api接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDrelationClauseCodeApi.PATH)
public interface PrpDrelationClauseCodeApi {

    public static final String PATH = "prpDrelationClauseCode";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDrelationClauseCodeDto prpDrelationClauseCodeDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("clauseCode")String clauseCode,@RequestParam("insuranceCode")String insuranceCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDrelationClauseCodeDto prpDrelationClauseCodeDto);

    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDrelationClauseCodeDto queryByPK(@RequestParam(value="clauseCode") String clauseCode,@RequestParam(value="insuranceCode")String insuranceCode);
    /**
     *@description 按条款代码查询实体
     *@param
     */
    @RequestMapping(value = "queryByClauseCode",method = {RequestMethod.POST})
   public @ResponseBody List<PrpDrelationClauseCodeDto> queryByClauseCode(@RequestParam (value="clauseCode")String clauseCode);
}