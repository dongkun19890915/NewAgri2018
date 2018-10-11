package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUserLoginDto;
import com.sinosoft.ims.core.auth.dao.UtiUserLoginDao;
import com.sinosoft.ims.core.auth.entity.UtiUserLogin;
import com.sinosoft.ims.core.auth.entity.UtiUserLoginKey;
import com.sinosoft.ims.core.auth.service.UtiUserLoginService;
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
 * @description UtiUserLoginCore接口实现
 */
@Service
public class UtiUserLoginServiceImpl extends BaseServiceImpl implements UtiUserLoginService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUserLoginServiceImpl.class);
    
    @Autowired
    private UtiUserLoginDao utiUserLoginDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiUserLoginDto utiUserLoginDto) {
        UtiUserLogin utiUserLogin = this.convert(utiUserLoginDto, UtiUserLogin.class);
        utiUserLoginDao.save(utiUserLogin);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String userCode) {
        UtiUserLoginKey utiUserLoginKey = new UtiUserLoginKey(userCode);
        utiUserLoginDao.delete(utiUserLoginKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiUserLoginDto utiUserLoginDto) {
        UtiUserLogin utiUserLogin = this.convert(utiUserLoginDto, UtiUserLogin.class);
        utiUserLoginDao.save(utiUserLogin);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUserLoginDto queryByPK(String userCode) {
        UtiUserLoginKey utiUserLoginKey = new UtiUserLoginKey(userCode);
        UtiUserLogin utiUserLogin = utiUserLoginDao.findOne(utiUserLoginKey);
        return this.convert(utiUserLogin,UtiUserLoginDto.class);
    }
}