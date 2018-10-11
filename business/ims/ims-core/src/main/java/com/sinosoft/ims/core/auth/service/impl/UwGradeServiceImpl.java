package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UwGradeDto;
import com.sinosoft.ims.core.auth.dao.UwGradeDao;
import com.sinosoft.ims.core.auth.entity.UwGrade;
import com.sinosoft.ims.core.auth.entity.UwGradeKey;
import com.sinosoft.ims.core.auth.service.UwGradeService;
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
 * @time  2017-11-05 01:11:08.689 
 * @description 核保核赔节点权限表Core接口实现
 */
@Service
public class UwGradeServiceImpl extends BaseServiceImpl implements UwGradeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UwGradeServiceImpl.class);
    
    @Autowired
    private UwGradeDao uwGradeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UwGradeDto uwGradeDto) {
        UwGrade uwGrade = this.convert(uwGradeDto, UwGrade.class);
        uwGradeDao.save(uwGrade);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String userCode,Integer modelNo,Integer nodeNo,Integer groupNo) {
        UwGradeKey uwGradeKey = new UwGradeKey(userCode,modelNo,nodeNo,groupNo);
        uwGradeDao.delete(uwGradeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UwGradeDto uwGradeDto) {
        UwGrade uwGrade = this.convert(uwGradeDto, UwGrade.class);
        uwGradeDao.save(uwGrade);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UwGradeDto queryByPK(String userCode,Integer modelNo,Integer nodeNo,Integer groupNo) {
        UwGradeKey uwGradeKey = new UwGradeKey(userCode,modelNo,nodeNo,groupNo);
        UwGrade uwGrade = uwGradeDao.findOne(uwGradeKey);
        return this.convert(uwGrade,UwGradeDto.class);
    }
}