package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.PrpDsubsidyDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDsubsidyApi接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDsubsidyApi.PATH)
public interface PrpDsubsidyApi {

    public static final String PATH = "prpDsubsidy";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDsubsidyDto prpDsubsidyDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String riskCode, String comCode, String subsidyYear, String validStatus, String subsidyCode, String subsidyType);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDsubsidyDto prpDsubsidyDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDsubsidyDto queryByPK(String riskCode, String comCode, String subsidyYear, String validStatus, String subsidyCode, String subsidyType);
    /**
     * 根据条件查询PrpDsubsidy补贴信息表信息(此方法只针对3218险种)
     * @author: 田健
     * @date: 2017/12/1 18:41
     * @param map 集合，存放 riskCode险种，comCode归属机构，subsidyYear年份
     * @return 返回List<PrpDsubsidyDto>补贴信息表信息集合
     * @throws Exception
     */
    @RequestMapping(value = "findPrpDsubsidyDtoListByCondition",method = {RequestMethod.POST})
    List<PrpDsubsidyDto> findPrpDsubsidyDtoListByCondition(@RequestBody Map<String,String> map)throws Exception;
}