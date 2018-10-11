package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UwGroupDto;
import com.sinosoft.ims.core.auth.dao.UwGroupDao;
import com.sinosoft.ims.core.auth.entity.UwGroup;
import com.sinosoft.ims.core.auth.entity.UwGroupKey;
import com.sinosoft.ims.core.auth.service.UwGroupService;
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
 * @description UwGroupCore接口实现
 */
@Service
public class UwGroupServiceImpl extends BaseServiceImpl implements UwGroupService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UwGroupServiceImpl.class);
    
    @Autowired
    private UwGroupDao uwGroupDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UwGroupDto uwGroupDto) {
        UwGroup uwGroup = this.convert(uwGroupDto, UwGroup.class);
        uwGroupDao.save(uwGroup);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(Integer groupNo,String comCode,String riskCode,String classCode) {
        UwGroupKey uwGroupKey = new UwGroupKey(groupNo,comCode,riskCode,classCode);
        uwGroupDao.delete(uwGroupKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UwGroupDto uwGroupDto) {
        UwGroup uwGroup = this.convert(uwGroupDto, UwGroup.class);
        uwGroupDao.save(uwGroup);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UwGroupDto queryByPK(Integer groupNo,String comCode,String riskCode,String classCode) {
        UwGroupKey uwGroupKey = new UwGroupKey(groupNo,comCode,riskCode,classCode);
        UwGroup uwGroup = uwGroupDao.findOne(uwGroupKey);
        return this.convert(uwGroup,UwGroupDto.class);
    }
}