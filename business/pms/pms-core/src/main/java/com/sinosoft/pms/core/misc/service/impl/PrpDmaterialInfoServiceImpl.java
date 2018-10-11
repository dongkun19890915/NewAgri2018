package com.sinosoft.pms.core.misc.service.impl;

import com.sinosoft.pms.api.misc.dto.PrpDmaterialInfoDto;
import com.sinosoft.pms.core.misc.dao.PrpDmaterialInfoDao;
import com.sinosoft.pms.core.misc.entity.PrpDmaterialInfo;
import com.sinosoft.pms.core.misc.entity.PrpDmaterialInfoKey;
import com.sinosoft.pms.core.misc.service.PrpDmaterialInfoService;
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
 * @description 参考资料信息表Core接口实现
 */
@Service
public class PrpDmaterialInfoServiceImpl extends BaseServiceImpl implements PrpDmaterialInfoService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDmaterialInfoServiceImpl.class);
    
    @Autowired
    private PrpDmaterialInfoDao prpDmaterialInfoDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDmaterialInfoDto prpDmaterialInfoDto) {
        PrpDmaterialInfo prpDmaterialInfo = this.convert(prpDmaterialInfoDto, PrpDmaterialInfo.class);
        prpDmaterialInfoDao.save(prpDmaterialInfo);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String materialId) {
        PrpDmaterialInfoKey prpDmaterialInfoKey = new PrpDmaterialInfoKey(materialId);
        prpDmaterialInfoDao.delete(prpDmaterialInfoKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDmaterialInfoDto prpDmaterialInfoDto) {
        PrpDmaterialInfo prpDmaterialInfo = this.convert(prpDmaterialInfoDto, PrpDmaterialInfo.class);
        prpDmaterialInfoDao.save(prpDmaterialInfo);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDmaterialInfoDto queryByPK(String materialId) {
        PrpDmaterialInfoKey prpDmaterialInfoKey = new PrpDmaterialInfoKey(materialId);
        PrpDmaterialInfo prpDmaterialInfo = prpDmaterialInfoDao.findOne(prpDmaterialInfoKey);
        return this.convert(prpDmaterialInfo,PrpDmaterialInfoDto.class);
    }
}