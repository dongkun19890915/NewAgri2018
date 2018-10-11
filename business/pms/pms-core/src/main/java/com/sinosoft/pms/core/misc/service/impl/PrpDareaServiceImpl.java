package com.sinosoft.pms.core.misc.service.impl;

import com.sinosoft.pms.api.misc.dto.PrpDareaDto;
import com.sinosoft.pms.core.misc.dao.PrpDareaDao;
import com.sinosoft.pms.core.misc.entity.PrpDarea;
import com.sinosoft.pms.core.misc.entity.PrpDareaKey;
import com.sinosoft.pms.core.misc.service.PrpDareaService;
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
 * @time  2017-08-22 03:00:50.124 
 * @description 区域表Core接口实现
 */
@Service
public class PrpDareaServiceImpl extends BaseServiceImpl implements PrpDareaService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDareaServiceImpl.class);
    
    @Autowired
    private PrpDareaDao prpDareaDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDareaDto prpDareaDto) {
        PrpDarea prpDarea = this.convert(prpDareaDto, PrpDarea.class);
        prpDareaDao.save(prpDarea);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String codeCode,String codeType,String areaCode) {
        PrpDareaKey prpDareaKey = new PrpDareaKey(codeCode,codeType,areaCode);
        prpDareaDao.delete(prpDareaKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDareaDto prpDareaDto) {
        PrpDarea prpDarea = this.convert(prpDareaDto, PrpDarea.class);
        prpDareaDao.save(prpDarea);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDareaDto queryByPK(String codeCode,String codeType,String areaCode) {
        PrpDareaKey prpDareaKey = new PrpDareaKey(codeCode,codeType,areaCode);
        PrpDarea prpDarea = prpDareaDao.findOne(prpDareaKey);
        return this.convert(prpDarea,PrpDareaDto.class);
    }

    /**
     *@description 按主键查询实体
     *@param areaCode
     *@author 韩雨怀
     *@date 2017年12月20日 下午4:05:09
     */
    @Override
    public PrpDareaDto queryByAreaCode(String areaCode) {
        PrpDarea prpDarea = prpDareaDao.queryByAreaCode(areaCode);
        return this.convert(prpDarea, PrpDareaDto.class);
    }
}