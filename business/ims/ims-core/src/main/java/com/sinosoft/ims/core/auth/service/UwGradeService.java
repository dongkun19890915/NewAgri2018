package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UwGradeDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * @description 核保核赔节点权限表Core接口
 */
public interface UwGradeService {

    /**
     *@description 新增
     *@param
     */
    void save(UwGradeDto uwGradeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String userCode, Integer modelNo, Integer nodeNo, Integer groupNo);
    /**
     *@description 修改
     *@param
     */
    void modify(UwGradeDto uwGradeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UwGradeDto queryByPK(String userCode, Integer modelNo, Integer nodeNo, Integer groupNo);
}