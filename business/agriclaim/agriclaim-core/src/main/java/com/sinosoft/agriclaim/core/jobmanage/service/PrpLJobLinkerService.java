package com.sinosoft.agriclaim.core.jobmanage.service;


import com.sinosoft.agriclaim.api.jobmanage.dto.PrpLJobLinkerDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981 
 * @description 联系人Core接口
 */
public interface PrpLJobLinkerService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLJobLinkerDto prpLJobLinkerDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String staffId);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLJobLinkerDto prpLJobLinkerDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLJobLinkerDto queryByPK(String staffId);
}