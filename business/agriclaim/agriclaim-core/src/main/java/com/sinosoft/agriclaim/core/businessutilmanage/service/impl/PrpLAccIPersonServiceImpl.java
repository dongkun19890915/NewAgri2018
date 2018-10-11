package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLAccIPersonDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLAccIPerson;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLAccIPersonKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLAccIPersonService;
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
 * @time  2017-11-08 05:35:28.283 
 * @description 索赔申请人信息表Core接口实现
 */
@Service
public class PrpLAccIPersonServiceImpl extends BaseServiceImpl implements PrpLAccIPersonService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLAccIPersonServiceImpl.class);
    
    @Autowired
    private PrpLAccIPersonDao prpLAccIPersonDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLAccIPersonDto prpLAccIPersonDto) {
        PrpLAccIPerson prpLAccIPerson = this.convert(prpLAccIPersonDto, PrpLAccIPerson.class);
        prpLAccIPersonDao.save(prpLAccIPerson);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String certiNo,String certiType,java.lang.Integer serialNo) {
        PrpLAccIPersonKey prpLAccIPersonKey = new PrpLAccIPersonKey(certiNo,certiType,serialNo);
        prpLAccIPersonDao.delete(prpLAccIPersonKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLAccIPersonDto prpLAccIPersonDto) {
        PrpLAccIPerson prpLAccIPerson = this.convert(prpLAccIPersonDto, PrpLAccIPerson.class);
        prpLAccIPersonDao.save(prpLAccIPerson);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLAccIPersonDto queryByPK(String certiNo,String certiType,java.lang.Integer serialNo) {
        PrpLAccIPersonKey prpLAccIPersonKey = new PrpLAccIPersonKey(certiNo,certiType,serialNo);
        PrpLAccIPerson prpLAccIPerson = prpLAccIPersonDao.findOne(prpLAccIPersonKey);
        return this.convert(prpLAccIPerson,PrpLAccIPersonDto.class);
    }
}