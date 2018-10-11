package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 工作流路径定义表Core接口
 */
public interface SwfPathService {

    /**
     *@description 新增
     *@param
     */
    void save(SwfPathDto swfPathDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer modelNo,java.lang.Integer pathNo);
    /**
     *@description 修改
     *@param
     */
    void modify(SwfPathDto swfPathDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SwfPathDto queryByPK(java.lang.Integer modelNo,java.lang.Integer pathNo);

	/**
	 * @description 检验是不是满足路径上的条件
	 * @author yanlei
	 * @param swfPathDto 工作流路径对象
	 * @param iBusinessNo 检验条件
	 * @return
	 */
    public boolean checkPathCondition(SwfPathDto swfPathDto,String iBusinessNo) ;
}