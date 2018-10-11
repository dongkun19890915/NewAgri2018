package com.sinosoft.ims.core.auth.service;


import com.sinosoft.ims.api.auth.dto.UtiGradeDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 岗位定义表Core接口
 */
public interface UtiGradeService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiGradeDto utiGradeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String gradeCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiGradeDto utiGradeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiGradeDto queryByPK(String gradeCode);
}