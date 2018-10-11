package com.sinosoft.ims.core.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.ims.api.auth.dto.UtiTaskDto;
import com.sinosoft.ims.core.auth.dao.UtiTaskDao;
import com.sinosoft.ims.core.auth.entity.UtiTask;
import com.sinosoft.ims.core.auth.entity.UtiTaskKey;
import com.sinosoft.ims.core.auth.service.UtiTaskService;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 任务定义表Core接口实现
 */
@Service
public class UtiTaskServiceImpl extends BaseServiceImpl implements UtiTaskService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiTaskServiceImpl.class);
    
    @Autowired
    private UtiTaskDao utITaskDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiTaskDto utITaskDto) {
        UtiTask utITask = this.convert(utITaskDto, UtiTask.class);
        utITaskDao.save(utITask);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String taskCode) {
        UtiTaskKey utITaskKey = new UtiTaskKey(taskCode);
        utITaskDao.delete(utITaskKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiTaskDto utITaskDto) {
        UtiTask utITask = this.convert(utITaskDto, UtiTask.class);
        utITaskDao.save(utITask);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiTaskDto queryByPK(String taskCode) {
        UtiTaskKey utITaskKey = new UtiTaskKey(taskCode);
        UtiTask utITask = utITaskDao.findOne(utITaskKey);
        return this.convert(utITask,UtiTaskDto.class);
    }
}