package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDlimitClassDto;
import com.sinosoft.pms.core.kernel.dao.PrpDlimitClassDao;
import com.sinosoft.pms.core.kernel.entity.PrpDlimitClass;
import com.sinosoft.pms.core.kernel.entity.PrpDlimitClassKey;
import com.sinosoft.pms.core.kernel.service.PrpDlimitClassService;
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
 * @description 限额免赔险种分类子表Core接口实现
 */
@Service
public class PrpDlimitClassServiceImpl extends BaseServiceImpl implements PrpDlimitClassService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDlimitClassServiceImpl.class);
    
    @Autowired
    private PrpDlimitClassDao prpDlimitClassDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDlimitClassDto prpDlimitClassDto) {
        PrpDlimitClass prpDlimitClass = this.convert(prpDlimitClassDto, PrpDlimitClass.class);
        prpDlimitClassDao.save(prpDlimitClass);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String limitCode,String classCode) {
        PrpDlimitClassKey prpDlimitClassKey = new PrpDlimitClassKey(limitCode,classCode);
        prpDlimitClassDao.delete(prpDlimitClassKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDlimitClassDto prpDlimitClassDto) {
        PrpDlimitClass prpDlimitClass = this.convert(prpDlimitClassDto, PrpDlimitClass.class);
        prpDlimitClassDao.save(prpDlimitClass);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDlimitClassDto queryByPK(String limitCode,String classCode) {
        PrpDlimitClassKey prpDlimitClassKey = new PrpDlimitClassKey(limitCode,classCode);
        PrpDlimitClass prpDlimitClass = prpDlimitClassDao.findOne(prpDlimitClassKey);
        return this.convert(prpDlimitClass,PrpDlimitClassDto.class);
    }
}