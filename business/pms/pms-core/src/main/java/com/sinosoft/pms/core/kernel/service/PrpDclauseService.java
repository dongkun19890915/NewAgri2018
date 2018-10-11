package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseDto;
import com.sinosoft.pms.api.kernel.dto.ResponsePrpDclauseDto;
import com.sinosoft.pms.core.kernel.entity.PrpDclause;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 06:20:36.415 
 * @description 条款代码表Core接口
 */
public interface PrpDclauseService {
    /**
     *@description 新增
     *@param
     */
    void save(PrpDclauseDto prpDclauseDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode, Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclauseDto prpDclauseDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpDclauseDto queryByPK(String clauseCode, Integer lineNo);
    /**
     * 根据条款代码查询条款代码表的风险等级说明，第三方识别说明
     * @author: 宋振振
     * @date: 2017/10/23 15:26
     * @param clauseCode 条款代码
     * @return List<PrpDclauseDto> 返回相应条款代码的条款信息
     */
    public List<PrpDclauseDto> queryClauseByClauseCode(String clauseCode)throws Exception;

    /**
     * 按险种查询CLauseDto(特约及附加信息双击域)
     * @param riskCode 险种代码
     * @return List<PrpDclauseDto> 返回PrpDclauseDto整个对象
     * @author 王保良
     * @throws Exception
     * @date 2017年10月12日 下午3:20:00
     */
    public List<PrpDclauseDto> queryClauseByRiskCode(String riskCode) throws Exception;
    /**
     *  根据clauseCode 条款代码查询PrpDclause条款信息表信息
     * @author: 田慧
     * @date: 2017/12/2 12:50
     * @param clauseCode 条款代码
     * @return PrpDclauseDto的集合
     */
    public List<PrpDclauseDto> queryPrpdclauseInfoByCondition(String clauseCode,String insuranceCode)throws Exception;

    /**
     * 根据codeCode查询条款代码和条款名称
     * @author: 刘曼曼
     * @date: 2017/12/19 15:16
     * @param riskCode 险种
     * @return List<ResponsePrpDclauseDto> 保险代码和保险名称集合
     * @throws Exception
     */
    public List<ResponsePrpDclauseDto> queryPrpdclauseInfo(String riskCode)throws Exception;

    /**
     * 根据条款代码查询险种内容
     * @author: 刘曼曼
     * @date: 2017/12/19 17:33
     * @param riskCode 险种代码
     * @return List<String> 条款内容集合
     * @throws Exception
     */
    public List<PrpDclauseDto>  queryByKindContext(String clauseCode,String itemCode)throws Exception;


}