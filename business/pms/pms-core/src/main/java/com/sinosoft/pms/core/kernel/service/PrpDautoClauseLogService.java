package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseLogDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:28:59.683 
 * @description 自动生成特约主表日志表Core接口
 */
public interface PrpDautoClauseLogService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDautoClauseLogDto prpDautoClauseLogDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String uUID);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDautoClauseLogDto prpDautoClauseLogDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDautoClauseLogDto queryByPK(String uUID);
}