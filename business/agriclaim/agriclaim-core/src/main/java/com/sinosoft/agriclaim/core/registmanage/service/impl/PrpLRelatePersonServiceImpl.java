package com.sinosoft.agriclaim.core.registmanage.service.impl;

import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRelatePersonDto;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRelatePersonDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRelatePerson;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRelatePersonKey;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRelatePersonService;
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
 * @time  2017-11-08 05:45:22.527 
 * @description 联系人表Core接口实现
 */
@Service
public class PrpLRelatePersonServiceImpl extends BaseServiceImpl implements PrpLRelatePersonService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLRelatePersonServiceImpl.class);
    
    @Autowired
    private PrpLRelatePersonDao prpLRelatePersonDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLRelatePersonDto prpLRelatePersonDto) {
        PrpLRelatePerson prpLRelatePerson = this.convert(prpLRelatePersonDto, PrpLRelatePerson.class);
        prpLRelatePersonDao.save(prpLRelatePerson);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,String personType,java.lang.Integer serialNo) {
        PrpLRelatePersonKey prpLRelatePersonKey = new PrpLRelatePersonKey(registNo,personType,serialNo);
        prpLRelatePersonDao.delete(prpLRelatePersonKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLRelatePersonDto prpLRelatePersonDto) {
        PrpLRelatePerson prpLRelatePerson = this.convert(prpLRelatePersonDto, PrpLRelatePerson.class);
        prpLRelatePersonDao.save(prpLRelatePerson);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRelatePersonDto queryByPK(String registNo,String personType,java.lang.Integer serialNo) {
        PrpLRelatePersonKey prpLRelatePersonKey = new PrpLRelatePersonKey(registNo,personType,serialNo);
        PrpLRelatePerson prpLRelatePerson = prpLRelatePersonDao.findOne(prpLRelatePersonKey);
        return this.convert(prpLRelatePerson,PrpLRelatePersonDto.class);
    }
}