package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDlimitClassDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 限额免赔险种分类子表Core接口
 */
public interface PrpDlimitClassService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDlimitClassDto prpDlimitClassDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String limitCode,String classCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDlimitClassDto prpDlimitClassDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDlimitClassDto queryByPK(String limitCode,String classCode);
}