package com.sinosoft.ims.core.auth.service;


import com.sinosoft.ims.api.auth.dto.UtiUserGradeTaskDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 机构员工岗位差异功能权限表Core接口
 */
public interface UtiUserGradeTaskService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiUserGradeTaskDto utiUserGradeTaskDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String comCode, String userCode, String gradeCode, String taskCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiUserGradeTaskDto utiUserGradeTaskDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiUserGradeTaskDto queryByPK(String comCode, String userCode, String gradeCode, String taskCode);

    /**
     *  根据comCode、userCode查询实体
     * @author: ldd
     * @date: 2017/11/17 9:14
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @return  UtiUserGradeTaskDto集合
     * @throws Exception
     */
    List<UtiUserGradeTaskDto> queryAllByCondition(String comCode, String userCode) throws Exception;

    /**
     *  根据comCode、userCode、gradeCode查询实体
     * @author: ldd
     * @date: 2017/11/17 9:14
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @param gradeCode 岗位代码
     * @return  UtiUserGradeTaskDto集合
     * @throws Exception
     */
    List<UtiUserGradeTaskDto> queryUtiUserGradeTaskDtoByCondition(String comCode, String userCode,String gradeCode) throws Exception;
}