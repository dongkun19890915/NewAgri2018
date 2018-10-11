package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * @description 条款配置主表Core接口
 */
public interface   PrpDclauseCodeService {
    /**
     *@description 新增
     *@param
     */
    void save(PrpDclauseCodeDto   PrpDclauseCodeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclauseCodeDto   PrpDclauseCodeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
      PrpDclauseCodeDto queryByPK(String clauseCode);

    /**
     *  （根据传入的机构和险种查询条款信息集合）
     * @author: 祝凯
     * @date: 2017/11/8 18:04
     * @param comCode 机构
     * @param riskCode 险种
     * @return List<PrpDclauseCodeDto>
     */
  List<PrpDclauseCodeDto> queryByRiskCodeAndCom(String riskCode,String comCode) throws Exception;
    /**
     *  （根据传入的险种和机构查询满足条件的所有条款信息集合）
     * @author: 田慧
     * @date: 2018/3/2 9:50
     * @param riskCode 险种代码
     * @param comCodeList 适用机构集合
     * @return List<PrpDclauseCodeDto>
     * @throws Exception
     */
    public List<PrpDclauseCodeDto> queryItemByRiskCodeAndCom(String riskCode,List<String> comCodeList) throws Exception;
    /**
     * 按条件查询条款信息
     * @Author: 刘曼曼
     * @date: 2017/11/7 10:35
     * @param clauseCodeQueryConditionDto 查询条款条件Dto
     * @return PageInfo<ResponsePrpDclauseCodeDto> 条款信息集合
     */
    public PageInfo<ResponsePrpDclauseCodeDto> qureyClauseCodeCondition(ClauseCodeQueryConditionDto clauseCodeQueryConditionDto) throws Exception;

    /**
     * 按条款代码查询PrpDclauseCode,PrpDclauseCodeCom,PrpDclauseCodeKind 的列表信息
     * @author: 刘曼曼
     * @date: 2017/11/7 19:32
     * @param clauseCode 条款代码
     * @return  ResponseClauseInfoDto 返回 PrpDclauseCodeDto,PrpDclauseCodeComDto,PrpDclauseCodeKindDto 的Dto
     */
    public ResponseClauseInfoDto queryClauseCodeByComByKind(String clauseCode, String userCode,String comCode) throws  Exception;

    /**
     * 在PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表插入信息
     * @author: 刘曼曼
     * @date: 2017/11/8 11:09
     * @param requestClauseCodeInfoDto 条款保存信息Dto
     */
    public Map<String,String> saveClauseByComByKind(RequestClauseCodeInfoDto requestClauseCodeInfoDto ) throws Exception;

    /**
     * 修改PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表信息
     * @author: 刘曼曼
     * @date: 2017/11/8 11:09
     * @param requestClauseCodeInfoDto 条款配置Dto,条款险别配置Dto的集合,条款机构配置Dto的集合
     */
    public Map<String,String> modifyClauseByComByKind(RequestClauseCodeInfoDto requestClauseCodeInfoDto)throws Exception;

    /**
     * 根据条款代码停用、启用条款
     * @author: 刘曼曼
     * @date: 2017/11/9 15:58
     * @param prpDclauseCodeDto 条款配置的Dto
     */
    public Map<String,String> motifyenableOrDisableClause(PrpDclauseCodeDto prpDclauseCodeDto) throws Exception;


    /**
     * 根据条款代码删除PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表的信息
     * @author: 刘曼曼
     * @date: 2017/11/9 18:14
     * @param clauseCode 条款代码
     */
    public Map<String,String> removeByClause(String clauseCode) throws Exception;

    /**
     * 根据条款代码批量删除PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表的信息
     * @author: 刘曼曼
     * @date: 2017/11/9 18:14
     * @param clauseCodeList 条款代码集合
     */
    public Map<String,String> removeBatchByClause(List<String> clauseCodeList)throws Exception;

    /**
     * 根据条款代码查询该条款的政策性标志并翻译
     * @author: 王保良
     * @date: 2017/12/19 17:33
     * @param clauseCode 条款代码
     * @return Map<String,String> map 返回政策性中文名称
     * @throws Exception
     */
    public Map<String,String> queryByPkAndTranslate(String clauseCode)throws Exception;

    /**
     * * 根据条款代码查询条款配置主表信息
     * @author: 田慧
     * @date: 17:00
     * @param clauseCode 条款代码
     * @return PrpDclauseCodeDto
     * @throws Exception
     */
    PrpDclauseCodeDto getPrpDclauseCodeInfo(String clauseCode)throws Exception;

}