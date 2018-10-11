package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.ims.api.auth.dto.UtiUserGradeTaskDto;
import com.sinosoft.ims.core.auth.dao.UtiUserGradeTaskDao;
import com.sinosoft.ims.core.auth.entity.UtiUserGradeTask;
import com.sinosoft.ims.core.auth.entity.UtiUserGradeTaskKey;
import com.sinosoft.ims.core.auth.service.UtiUserGradeTaskService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 机构员工岗位差异功能权限表Core接口实现
 */
@Service
public class UtiUserGradeTaskServiceImpl extends BaseServiceImpl implements UtiUserGradeTaskService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUserGradeTaskServiceImpl.class);
    
    @Autowired
    private UtiUserGradeTaskDao utiUserGradeTaskDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiUserGradeTaskDto utiUserGradeTaskDto) {
        UtiUserGradeTask utiUserGradeTask = this.convert(utiUserGradeTaskDto, UtiUserGradeTask.class);
        utiUserGradeTaskDao.save(utiUserGradeTask);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String comCode,String userCode,String gradeCode,String taskCode) {
        UtiUserGradeTaskKey utiUserGradeTaskKey = new UtiUserGradeTaskKey(comCode,userCode,gradeCode,taskCode);
        utiUserGradeTaskDao.delete(utiUserGradeTaskKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiUserGradeTaskDto utiUserGradeTaskDto) {
        UtiUserGradeTask utiUserGradeTask = this.convert(utiUserGradeTaskDto, UtiUserGradeTask.class);
        utiUserGradeTaskDao.save(utiUserGradeTask);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUserGradeTaskDto queryByPK(String comCode,String userCode,String gradeCode,String taskCode) {
        UtiUserGradeTaskKey utiUserGradeTaskKey = new UtiUserGradeTaskKey(comCode,userCode,gradeCode,taskCode);
        UtiUserGradeTask utiUserGradeTask = utiUserGradeTaskDao.findOne(utiUserGradeTaskKey);
        return this.convert(utiUserGradeTask,UtiUserGradeTaskDto.class);
    }

    /**
     *  根据comCode、userCode查询实体
     * @author: ldd
     * @date: 2017/11/17 9:14
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @return  UtiUserGradeTaskDto集合
     * @throws Exception
     */
    public List<UtiUserGradeTaskDto> queryAllByCondition(String comCode, String userCode) throws Exception{
        List<UtiUserGradeTask> utiUserGradeTaskList = utiUserGradeTaskDao.findAllByCondition(comCode,userCode);
        List<UtiUserGradeTaskDto> utiUserGradeTaskDtoList = new ArrayList<>();
        convertCollection(utiUserGradeTaskList,utiUserGradeTaskDtoList,UtiUserGradeTaskDto.class);
        return utiUserGradeTaskDtoList;
    }
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
    @Override
    public List<UtiUserGradeTaskDto> queryUtiUserGradeTaskDtoByCondition(String comCode, String userCode,String gradeCode) throws Exception{
        List<UtiUserGradeTask> utiUserGradeTaskList = utiUserGradeTaskDao.queryUtiUserGradeTaskDtoByCondition(comCode,userCode,gradeCode);
        List<UtiUserGradeTaskDto> utiUserGradeTaskDtoList = new ArrayList<>();
        convertCollection(utiUserGradeTaskList,utiUserGradeTaskDtoList,UtiUserGradeTaskDto.class);
        return utiUserGradeTaskDtoList;
    }
}