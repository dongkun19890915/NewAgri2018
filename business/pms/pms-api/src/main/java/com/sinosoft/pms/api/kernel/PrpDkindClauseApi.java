package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.PrpDkindClauseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDkindClauseApi接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDkindClauseApi.PATH)
public interface PrpDkindClauseApi {

    String PATH = "prpDkindClause";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDkindClauseDto prpDkindClauseDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String riskCode, String clauseFlag, String kindCode, String language, String clauseCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDkindClauseDto prpDkindClauseDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDkindClauseDto queryByPK(String riskCode, String clauseFlag, String kindCode, String language, String clauseCode);
}