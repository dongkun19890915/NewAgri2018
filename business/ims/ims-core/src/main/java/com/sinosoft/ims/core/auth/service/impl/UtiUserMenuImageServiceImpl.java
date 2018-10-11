package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.ims.api.auth.dto.UtiUserMenuImageDto;
import com.sinosoft.ims.core.auth.dao.UtiUserMenuImageDao;
import com.sinosoft.ims.core.auth.entity.UtiUserMenuImage;
import com.sinosoft.ims.core.auth.entity.UtiUserMenuImageKey;
import com.sinosoft.ims.core.auth.service.UtiUserMenuImageService;
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
 * @time  2017-11-13 07:56:24.672 
 * @description 常用菜单图标信息表Core接口实现
 */
@Service
public class UtiUserMenuImageServiceImpl extends BaseServiceImpl implements UtiUserMenuImageService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUserMenuImageServiceImpl.class);
    
    @Autowired
    private UtiUserMenuImageDao utiUserMenuImageDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiUserMenuImageDto utiUserMenuImageDto) {
        UtiUserMenuImage utiUserMenuImage = this.convert(utiUserMenuImageDto, UtiUserMenuImage.class);
        utiUserMenuImageDao.save(utiUserMenuImage);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String imageId) {
        UtiUserMenuImageKey utiUserMenuImageKey = new UtiUserMenuImageKey(imageId);
        utiUserMenuImageDao.delete(utiUserMenuImageKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiUserMenuImageDto utiUserMenuImageDto) {
        UtiUserMenuImage utiUserMenuImage = this.convert(utiUserMenuImageDto, UtiUserMenuImage.class);
        utiUserMenuImageDao.save(utiUserMenuImage);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUserMenuImageDto queryByPK(String imageId) {
        UtiUserMenuImageKey utiUserMenuImageKey = new UtiUserMenuImageKey(imageId);
        UtiUserMenuImage utiUserMenuImage = utiUserMenuImageDao.findOne(utiUserMenuImageKey);
        return this.convert(utiUserMenuImage,UtiUserMenuImageDto.class);
    }
}