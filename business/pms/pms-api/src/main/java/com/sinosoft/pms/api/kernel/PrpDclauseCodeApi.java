package com.sinosoft.pms.api.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * @description 条款配置主表Api接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDclauseCodeApi.PATH)
public interface   PrpDclauseCodeApi {

    public static final String PATH = "PrpDclauseCode";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(  PrpDclauseCodeDto   PrpDclauseCodeDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String clauseCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(  PrpDclauseCodeDto   PrpDclauseCodeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
      PrpDclauseCodeDto queryByPK(@RequestBody Map<String,String> map );

    /**
     * 根据条款代码查询该条款的政策性标志并翻译
     * @author: 王保良
     * @date: 2017/12/19 17:33
     * @param Map<String,String> map key:clauseCode 条款代码
     * @return Map<String,String> map 返回政策性中文名称
     * @throws Exception
     */
    @RequestMapping(value = "queryByPkAndTranslate",method = RequestMethod.POST)
     @ResponseBody Map<String,String> queryByPkAndTranslate(@RequestBody Map<String,String> map) throws Exception;
    /**
     *  （根据机构和险种查询条款信息）
     * @author: 祝凯
     * @date: 2017/11/14 18:28
     * @param map 包括 riskCode 险种、comCode  机构
     * @return  条款实体类信息
     */
    @RequestMapping(value = "queryByRiskCodeAndCom",method = {RequestMethod.POST})
    @ResponseBody  List<PrpDclauseCodeDto>  queryByRiskCodeAndCom(@RequestBody Map<String,String> map) throws Exception;

    /**
     * * 根据机构和险种查询条款信息
     * @author: 田慧
     * @date: 10:22
     * @param queryItemDto riskCode 险种、comCodeList  机构
     * @return 条款实体类信息
     * @throws Exception
     */
    @RequestMapping(value = "queryItemByRiskCodeAndCom",method = {RequestMethod.POST})
    public @ResponseBody List<PrpDclauseCodeDto> queryItemByRiskCodeAndCom(@RequestBody QueryItemDto queryItemDto) throws Exception;
    /**
     * 按条件查询条款列表信息
     * @author: 刘曼曼
     * @date: 2017/11/7 18:26
     * @param clauseCodeQueryConditionDto 查询条款条件Dto
     * @return PageInfo<ResponsePrpDclauseCodeDto>  集合
     */
    @RequestMapping(value = "QureyClauseCodeCondition",method = {RequestMethod.POST})
    @ResponseBody PageInfo<ResponsePrpDclauseCodeDto> QureyClauseCodeCondition(@RequestBody ClauseCodeQueryConditionDto clauseCodeQueryConditionDto) throws Exception;

    /**
     * 按条款代码查询PrpDclauseCode,PrpDclauseCodeCom,PrpDclauseCodeKind 的列表信息
     * @author: 刘曼曼
     * @date: 2017/11/7 19:32
     * @param map clauseCode 条款代码
     * @return  ResponseClauseInfoDto 返回 PrpDclauseCodeDto,PrpDclauseCodeComDto,PrpDclauseCodeKindDto 的Dto
     */
    @RequestMapping(value = "queryClauseCodeByComByKind",method = {RequestMethod.POST})
    @ResponseBody
    ResponseClauseInfoDto queryClauseCodeByComByKind(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 在PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表插入信息
     * @author: 刘曼曼
     * @date: 2017/11/8 11:09
     * @param requestClauseCodeInfoDto 条款保存信息Dto
     */
    @RequestMapping(value = "saveClauseByComByKind",method = {RequestMethod.POST})
    public Map<String,String> saveClauseByComByKind(@RequestBody  RequestClauseCodeInfoDto requestClauseCodeInfoDto) throws Exception;

    /**
     * 修改PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表信息
     * @author: 刘曼曼
     * @date: 2017/11/8 11:09
     * @param requestClauseCodeInfoDto 条款配置Dto,条款险别配置Dto的集合,条款机构配置Dto的集合
     */
    @RequestMapping(value = "modifyClauseByComByKind",method = {RequestMethod.POST})
    public Map<String,String> modifyClauseByComByKind(@RequestBody RequestClauseCodeInfoDto requestClauseCodeInfoDto) throws Exception;

    /**
     * 根据条款代码停用、启用条款
     * @author: 刘曼曼
     * @date: 2017/11/9 15:58
     * @param prpDclauseCodeDto 条款配置的Dto
     */
    @RequestMapping(value = "motifyenableOrDisableClause",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> motifyenableOrDisableClause(@RequestBody PrpDclauseCodeDto prpDclauseCodeDto) throws Exception;

    /**
     * 根据条款代码删除PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表的信息
     * @author: 刘曼曼
     * @date: 2017/11/9 18:14
     * @param map clauseCode 条款代码
     */
    @RequestMapping(value = "removeByClause",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> removeByClause(@RequestBody Map<String,String> map)throws Exception;


    /**
     * 根据条款代码批量删除PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表的信息
     * @author: 刘曼曼
     * @date: 2017/11/9 18:14
     * @param clauseCodes 条款代码集合
     */
    @RequestMapping(value = "removeBatchByClause",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> removeBatchByClause(@RequestBody List<String> clauseCodes)throws Exception;

    /**
     * * 根据条款代码查询条款配置主表信息
     * @author: 田慧
     * @date: 16:54
     * @param map 健为clauseCode  条款代码
     * @return PrpDclauseCodeDto
     * @throws Exception
     */
    @RequestMapping(value = "getPrpDclauseCodeInfo",method = {RequestMethod.POST})
    @ResponseBody PrpDclauseCodeDto getPrpDclauseCodeInfo(@RequestBody Map<String,String> map) throws Exception;

}