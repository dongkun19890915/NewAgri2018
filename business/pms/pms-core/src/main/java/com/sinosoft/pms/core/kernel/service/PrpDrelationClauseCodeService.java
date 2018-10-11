package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDrelationClauseCodeDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-18 02:37:33.970 
 * @description 条款与保险责任关联表Core接口
 */
public interface PrpDrelationClauseCodeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDrelationClauseCodeDto prpDrelationClauseCodeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode, String insuranceCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDrelationClauseCodeDto prpDrelationClauseCodeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDrelationClauseCodeDto queryByPK(String clauseCode, String insuranceCode);
    /**
     *@description 按条款代码查询实体
     *@param
     */
    public   List<PrpDrelationClauseCodeDto> queryByClauseCode(String clauseCode);
}