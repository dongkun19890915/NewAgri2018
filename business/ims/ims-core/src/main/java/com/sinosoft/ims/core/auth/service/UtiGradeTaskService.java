package com.sinosoft.ims.core.auth.service;


import com.sinosoft.ims.api.auth.dto.UtiGradeTaskDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 岗位功能权限表Core接口
 */
public interface UtiGradeTaskService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiGradeTaskDto utiGradeTaskDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String gradeCode, String taskCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiGradeTaskDto utiGradeTaskDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiGradeTaskDto queryByPK(String gradeCode, String taskCode);

    /**
     *  查询UtiGradeTask表所有数据
     * @author: ldd
     * @date: 2017/11/17 9:23
     * @param systemCode 系统代码
     * @return UtiGradeTaskDto集合
     */
    List<UtiGradeTaskDto> queryAllBySystemCode(String systemCode) throws Exception;
    /**
     *  查询UtiGradeTask表集合
     * @author: ldd
     * @date: 2017/11/17 9:23
     * @param gradeCode 岗位代码
     * @return UtiGradeTaskDto集合
     */
    List<UtiGradeTaskDto> queryAllByGradeCode(String gradeCode) throws Exception;
}