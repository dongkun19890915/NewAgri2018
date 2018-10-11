package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseContentLogDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-13 02:28:53.337 
 * @description 动态生成特约内容规则表日志表Core接口
 */
public interface PrpDautoClauseContentLogService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDautoClauseContentLogDto prpDautoClauseContentLogDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String uUID);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDautoClauseContentLogDto prpDautoClauseContentLogDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDautoClauseContentLogDto queryByPK(String uUID);
}