package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.ims.api.auth.dto.UtiGradeTaskDto;
import com.sinosoft.ims.core.auth.dao.UtiGradeTaskDao;
import com.sinosoft.ims.core.auth.entity.UtiGradeTask;
import com.sinosoft.ims.core.auth.entity.UtiGradeTaskKey;
import com.sinosoft.ims.core.auth.service.UtiGradeTaskService;
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

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 岗位功能权限表Core接口实现
 */
@Service
public class UtiGradeTaskServiceImpl extends BaseServiceImpl implements UtiGradeTaskService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiGradeTaskServiceImpl.class);
    
    @Autowired
    private UtiGradeTaskDao utiGradeTaskDao;
    @Autowired
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiGradeTaskDto utiGradeTaskDto) {
        UtiGradeTask utiGradeTask = this.convert(utiGradeTaskDto, UtiGradeTask.class);
        utiGradeTaskDao.save(utiGradeTask);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String gradeCode,String taskCode) {
        UtiGradeTaskKey utiGradeTaskKey = new UtiGradeTaskKey(gradeCode,taskCode);
        utiGradeTaskDao.delete(utiGradeTaskKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiGradeTaskDto utiGradeTaskDto) {
        UtiGradeTask utiGradeTask = this.convert(utiGradeTaskDto, UtiGradeTask.class);
        utiGradeTaskDao.save(utiGradeTask);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiGradeTaskDto queryByPK(String gradeCode,String taskCode) {
        UtiGradeTaskKey utiGradeTaskKey = new UtiGradeTaskKey(gradeCode,taskCode);
        UtiGradeTask utiGradeTask = utiGradeTaskDao.findOne(utiGradeTaskKey);
        return this.convert(utiGradeTask,UtiGradeTaskDto.class);
    }

    /**
     *  查询UtiGradeTask表所有数据
     * @author: ldd
     * @date: 2017/11/17 9:23
     * @param systemCode 系统代码
     * @return UtiGradeTaskDto集合
     */
    public List<UtiGradeTaskDto> queryAllBySystemCode(String systemCode) throws Exception{
        List<UtiGradeTaskDto> utiGradeTaskDtoList = new ArrayList<>();
        //原生SQL 查询UtiGradeTask
        StringBuilder querySql = new StringBuilder(" SELECT DISTINCT p FROM UtiGradeTask p,UtiMenu m "+
                        " WHERE p.taskCode = m.taskCode AND m.validStatus = '1' AND m.systemCode = :systemCode  "
        );
        Query dataQuery = entityManager.createQuery(querySql.toString());
        dataQuery.setParameter("systemCode",systemCode);
        List<UtiGradeTask> utiGradeTaskList = dataQuery.getResultList();
        convertCollection(utiGradeTaskList,utiGradeTaskDtoList,UtiGradeTaskDto.class);

        return utiGradeTaskDtoList;
    }
    /**
     *  查询UtiGradeTask表集合
     * @author: ldd
     * @date: 2017/11/17 9:23
     * @param gradeCode 岗位代码
     * @return UtiGradeTaskDto集合
     */
    @Override
    public List<UtiGradeTaskDto> queryAllByGradeCode(String gradeCode) throws Exception {
        List<UtiGradeTask> utiGradeTaskList = new ArrayList<>();
        List<UtiGradeTaskDto> utiGradeTaskDtoList = new ArrayList<>();
        utiGradeTaskList = utiGradeTaskDao.queryAllByGradeCode(gradeCode);
        convertCollection(utiGradeTaskList, utiGradeTaskDtoList, UtiGradeTaskDto.class);
        return utiGradeTaskDtoList;
    }
}