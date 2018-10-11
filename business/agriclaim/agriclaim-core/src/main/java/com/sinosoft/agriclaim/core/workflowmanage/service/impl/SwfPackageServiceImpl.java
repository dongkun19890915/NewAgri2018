package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPackageDto;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfPackageDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPackage;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPackageKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfPackageService;
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
 * @time  2017-11-08 05:47:03.090 
 * @description 工作流明细信息包表Core接口实现
 */
@Service
public class SwfPackageServiceImpl extends BaseServiceImpl implements SwfPackageService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SwfPackageServiceImpl.class);
    
    @Autowired
    private SwfPackageDao swfPackageDao;

    /**
     *@description 新增
     *@param
     */
    public void save(SwfPackageDto swfPackageDto) {
        SwfPackage swfPackage = this.convert(swfPackageDto, SwfPackage.class);
        swfPackageDao.save(swfPackage);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String packageId,java.lang.Integer detailNo) {
        SwfPackageKey swfPackageKey = new SwfPackageKey(packageId,detailNo);
        swfPackageDao.delete(swfPackageKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SwfPackageDto swfPackageDto) {
        SwfPackage swfPackage = this.convert(swfPackageDto, SwfPackage.class);
        swfPackageDao.save(swfPackage);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfPackageDto queryByPK(String packageId,java.lang.Integer detailNo) {
        SwfPackageKey swfPackageKey = new SwfPackageKey(packageId,detailNo);
        SwfPackage swfPackage = swfPackageDao.findOne(swfPackageKey);
        return this.convert(swfPackage,SwfPackageDto.class);
    }
}