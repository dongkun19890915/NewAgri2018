package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.UtiKeyDto;
import com.sinosoft.dms.core.dict.dao.UtiKeyDao;
import com.sinosoft.dms.core.dict.entity.UtiKey;
import com.sinosoft.dms.core.dict.entity.UtiKeyKey;
import com.sinosoft.dms.core.dict.service.UtiKeyService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * @description UtiKeyCore接口实现
 */
@Service
public class UtiKeyServiceImpl extends BaseServiceImpl implements UtiKeyService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiKeyServiceImpl.class);
    
    @Autowired
    private UtiKeyDao utiKeyDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiKeyDto utiKeyDto) {
        UtiKey utiKey = this.convert(utiKeyDto, UtiKey.class);
        utiKeyDao.save(utiKey);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String tablEName) {
        UtiKeyKey utiKeyKey = new UtiKeyKey(tablEName);
        utiKeyDao.delete(utiKeyKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiKeyDto utiKeyDto) {
        UtiKey utiKey = this.convert(utiKeyDto, UtiKey.class);
        utiKeyDao.save(utiKey);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiKeyDto queryByPK(String tablEName) {
        UtiKeyKey utiKeyKey = new UtiKeyKey(tablEName);
        UtiKey utiKey = utiKeyDao.findOne(utiKeyKey);
        return this.convert(utiKey,UtiKeyDto.class);
    }

}