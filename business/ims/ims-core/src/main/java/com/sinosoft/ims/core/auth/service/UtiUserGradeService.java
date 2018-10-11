package com.sinosoft.ims.core.auth.service;


import com.sinosoft.ims.api.auth.dto.UtiUserGradeDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 用户权限表Core接口
 */
public interface UtiUserGradeService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiUserGradeDto utiUserGradeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String comCode, String userCode, String gradeCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiUserGradeDto utiUserGradeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiUserGradeDto queryByPK(String comCode, String userCode, String gradeCode);

    /**
     *  根据comCode、userCode查询UtiUserGradeDto集合
     * @author: ldd
     * @date: 2017/11/16 14:55
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @return UtiUserGradeDto集合
     * @throws Exception
     */
    List<UtiUserGradeDto> queryAllByConditon(String comCode, String userCode) throws Exception;
}