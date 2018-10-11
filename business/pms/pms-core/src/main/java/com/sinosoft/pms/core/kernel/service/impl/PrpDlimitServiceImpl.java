package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDlimitDto;
import com.sinosoft.pms.core.kernel.dao.PrpDlimitDao;
import com.sinosoft.pms.core.kernel.entity.PrpDlimit;
import com.sinosoft.pms.core.kernel.entity.PrpDlimitKey;
import com.sinosoft.pms.core.kernel.service.PrpDlimitService;
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
 * @description 限额\免陪额表Core接口实现
 */
@Service
public class PrpDlimitServiceImpl extends BaseServiceImpl implements PrpDlimitService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDlimitServiceImpl.class);
    
    @Autowired
    private PrpDlimitDao prpDlimitDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDlimitDto prpDlimitDto) {
        PrpDlimit prpDlimit = this.convert(prpDlimitDto, PrpDlimit.class);
        prpDlimitDao.save(prpDlimit);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String limitCode) {
        PrpDlimitKey prpDlimitKey = new PrpDlimitKey(limitCode);
        prpDlimitDao.delete(prpDlimitKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDlimitDto prpDlimitDto) {
        PrpDlimit prpDlimit = this.convert(prpDlimitDto, PrpDlimit.class);
        prpDlimitDao.save(prpDlimit);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDlimitDto queryByPK(String limitCode) {
        PrpDlimitKey prpDlimitKey = new PrpDlimitKey(limitCode);
        PrpDlimit prpDlimit = prpDlimitDao.findOne(prpDlimitKey);
        return this.convert(prpDlimit,PrpDlimitDto.class);
    }
}