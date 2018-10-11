package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.PrpDclauseCodeApi;
import com.sinosoft.pms.api.kernel.dto.*;
import com.sinosoft.pms.core.kernel.service.PrpDclauseCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * @description 条款配置主表controller层
 */
@RestController
@RequestMapping(value =   PrpDclauseCodeController.PATH)
public class   PrpDclauseCodeController implements   PrpDclauseCodeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(  PrpDclauseCodeController.class);

    @Autowired
    private   PrpDclauseCodeService   PrpDclauseCodeService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(PrpDclauseCodeDto   PrpDclauseCodeDto) {
          PrpDclauseCodeService.save(  PrpDclauseCodeDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestParam("clauseCode") String clauseCode) {
          PrpDclauseCodeService.remove(clauseCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDclauseCodeDto   PrpDclauseCodeDto) {
          PrpDclauseCodeService.modify(  PrpDclauseCodeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public   PrpDclauseCodeDto queryByPK(@RequestBody Map<String,String> map) {
        return   PrpDclauseCodeService.queryByPK(map.get("clauseCode"));
    }

    /**
     * 根据条款代码查询该条款的政策性标志并翻译
     * @author: 王保良
     * @date: 2017/12/19 17:33
     * @param  map key:clauseCode 条款代码
     * @return Map<String,String> map 返回政策性中文名称
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> queryByPkAndTranslate(@RequestBody Map<String, String> map) throws Exception {
        return  PrpDclauseCodeService.queryByPkAndTranslate(map.get("clauseCode"));

    }

    /**
     *  （根据机构与险种查询条款信息）
     * @author: 祝凯
     * @date: 2017/11/15 10:31
     * @param map 包括 riskCode 险种、comCode  机构
     * @return  条款信息
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PrpDclauseCodeDto> queryByRiskCodeAndCom(@RequestBody Map<String,String> map) throws Exception{
        String riskCode=map.get("riskCode");
        String comCode=map.get("comCode");
        return PrpDclauseCodeService.queryByRiskCodeAndCom(riskCode,comCode) ;
    }
    /**
     * * 根据机构和险种查询条款信息
     * @author: 田慧
     * @date: 10:22
     * @param queryItemDto riskCode 险种、comCodeList  机构
     * @return 条款实体类信息
     * @throws Exception
     */
    public @ResponseBody List<PrpDclauseCodeDto> queryItemByRiskCodeAndCom(@RequestBody QueryItemDto queryItemDto) throws Exception{
        String riskcode = queryItemDto.getRiskCode();
        List<String> comCodeList = queryItemDto.getComCodeList();
        return PrpDclauseCodeService.queryItemByRiskCodeAndCom(riskcode,comCodeList);
    }
    /**
     *  按条件查询条款列表信息
     * @Author: 刘曼曼
     * @date: 2017/11/7 10:35
     * @param clauseCodeQueryConditionDto 查询条款条件Dto
     * @return PageInfo<ResponsePrpDclauseCodeDto>  集合
     */
    @Override
    public @ResponseBody PageInfo<ResponsePrpDclauseCodeDto> QureyClauseCodeCondition(@RequestBody ClauseCodeQueryConditionDto clauseCodeQueryConditionDto)throws  Exception {
        return PrpDclauseCodeService.qureyClauseCodeCondition(clauseCodeQueryConditionDto);
    }

    /**
     *  按条款代码查询PrpDclauseCode,PrpDclauseCodeCom,PrpDclauseCodeKind 的列表信息
     * @author: 刘曼曼
     * @date: 2017/11/7 19:32
     * @param map clauseCode 条款代码
     * @return  ResponseClauseInfoDto 返回 PrpDclauseCodeDto,PrpDclauseCodeComDto,PrpDclauseCodeKindDto 的Dto
     */
    @Override
    public @ResponseBody
    ResponseClauseInfoDto queryClauseCodeByComByKind(@RequestBody Map<String,String> map) throws  Exception{
        String clauseCode=map.get("clauseCode");
        String userCode=map.get("userCode");
        String comCode=map.get("comCode");
        return PrpDclauseCodeService.queryClauseCodeByComByKind(clauseCode,userCode,comCode);
    }

    /**
     * 在PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表插入信息
     * @author: 刘曼曼
     * @date: 2017/11/8 11:09
     * @param requestClauseCodeInfoDto 条款保存信息Dto
     */
    @Override
    public @ResponseBody Map<String,String> saveClauseByComByKind(@RequestBody RequestClauseCodeInfoDto requestClauseCodeInfoDto ) throws Exception{
        return PrpDclauseCodeService.saveClauseByComByKind(requestClauseCodeInfoDto);
    }


    /**
     * 修改PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表信息
     * @author: 刘曼曼
     * @date: 2017/11/8 11:09
     * @param requestClauseCodeInfoDto 条款配置Dto,条款险别配置Dto的集合,条款机构配置Dto的集合
     */
    @Override
    public @ResponseBody Map<String,String> modifyClauseByComByKind(@RequestBody RequestClauseCodeInfoDto requestClauseCodeInfoDto )throws  Exception{
        Map<String,String> map=PrpDclauseCodeService.modifyClauseByComByKind(requestClauseCodeInfoDto);
        return map;
    }

    /**
     * 根据条款代码停用、启用条款
     * @author: 刘曼曼
     * @date: 2017/11/9 15:58
     * @param prpDclauseCodeDto 条款配置的Dto
     */
    @Override
    public Map<String,String> motifyenableOrDisableClause(@RequestBody PrpDclauseCodeDto prpDclauseCodeDto)throws  Exception{
       return PrpDclauseCodeService.motifyenableOrDisableClause(prpDclauseCodeDto);
    }

    /**
     * 根据条款代码删除PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表的信息
     * @author: 刘曼曼
     * @date: 2017/11/9 18:14
     * @param map clauseCode 条款代码
     */
    @Override
    public @ResponseBody Map<String,String> removeByClause(@RequestBody Map<String,String> map)throws Exception{
        String clauseCode=map.get("clauseCode");
       return PrpDclauseCodeService.removeByClause(clauseCode);
    }


    /**
     * 根据条款代码批量删除PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表的信息
     * @author: 刘曼曼
     * @date: 2017/11/9 18:14
     * @param clauseCodes 条款代码集合
     */
    @Override
    public @ResponseBody Map<String,String> removeBatchByClause ( @RequestBody List<String> clauseCodes)throws Exception{
      return   PrpDclauseCodeService.removeBatchByClause(clauseCodes);
    }
    /**
     * * 根据条款代码查询条款配置主表信息
     * @author: 田慧
     * @date: 16:54
     * @param map 健为clauseCode  条款代码
     * @return PrpDclauseCodeDto
     * @throws Exception
     */
    @Override
    public @ResponseBody PrpDclauseCodeDto getPrpDclauseCodeInfo(@RequestBody Map<String,String> map) throws Exception{
        String clauseCode=map.get("clauseCode");
        return PrpDclauseCodeService.getPrpDclauseCodeInfo(clauseCode);
    }

}
