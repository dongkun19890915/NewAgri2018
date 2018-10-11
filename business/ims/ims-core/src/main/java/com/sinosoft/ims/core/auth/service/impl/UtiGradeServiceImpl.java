package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.ims.api.auth.dto.UtiGradeDto;
import com.sinosoft.ims.core.auth.dao.UtiGradeDao;
import com.sinosoft.ims.core.auth.entity.UtiGrade;
import com.sinosoft.ims.core.auth.entity.UtiGradeKey;
import com.sinosoft.ims.core.auth.service.UtiGradeService;
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
 * @description 岗位定义表Core接口实现
 */
@Service
public class UtiGradeServiceImpl extends BaseServiceImpl implements UtiGradeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiGradeServiceImpl.class);
    
    @Autowired
    private UtiGradeDao utiGradeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiGradeDto utiGradeDto) {
        UtiGrade utiGrade = this.convert(utiGradeDto, UtiGrade.class);
        utiGradeDao.save(utiGrade);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String gradeCode) {
        UtiGradeKey utiGradeKey = new UtiGradeKey(gradeCode);
        utiGradeDao.delete(utiGradeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiGradeDto utiGradeDto) {
        UtiGrade utiGrade = this.convert(utiGradeDto, UtiGrade.class);
        utiGradeDao.save(utiGrade);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiGradeDto queryByPK(String gradeCode) {
        UtiGradeKey utiGradeKey = new UtiGradeKey(gradeCode);
        UtiGrade utiGrade = utiGradeDao.findOne(utiGradeKey);
        return this.convert(utiGrade,UtiGradeDto.class);
    }
}