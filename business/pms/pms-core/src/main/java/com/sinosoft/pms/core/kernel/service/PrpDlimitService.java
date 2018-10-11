package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDlimitDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 限额\免陪额表Core接口
 */
public interface PrpDlimitService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDlimitDto prpDlimitDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String limitCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDlimitDto prpDlimitDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDlimitDto queryByPK(String limitCode);
}