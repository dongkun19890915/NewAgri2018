package com.sinosoft.agriclaim.core.jobmanage.service;


import com.sinosoft.agriclaim.api.jobmanage.dto.PrpLJobManagerTimeDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981 
 * @description 班表管理从表Core接口
 */
public interface PrpLJobManagerTimeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLJobManagerTimeDto prpLJobManagerTimeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String fid);
 /*   void remove(String fid  String dateType String time );*/
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLJobManagerTimeDto prpLJobManagerTimeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLJobManagerTimeDto queryByPK(String fid);
}