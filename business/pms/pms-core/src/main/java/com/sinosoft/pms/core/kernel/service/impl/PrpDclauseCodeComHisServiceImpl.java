package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto. PrpDclauseCodeComHisDto;
import com.sinosoft.pms.core.kernel.dao. PrpDclauseCodeComHisDao;
import com.sinosoft.pms.core.kernel.entity. PrpDclauseCodeComHis;
import com.sinosoft.pms.core.kernel.entity. PrpDclauseCodeComHisKey;
import com.sinosoft.pms.core.kernel.service. PrpDclauseCodeComHisService;
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
 * @time  2017-11-07 03:36:19.515 
 * @description 条款机构配置轨迹表Core接口实现
 */
@Service
public class  PrpDclauseCodeComHisServiceImpl extends BaseServiceImpl implements  PrpDclauseCodeComHisService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger( PrpDclauseCodeComHisServiceImpl.class);
    
    @Autowired
    private  PrpDclauseCodeComHisDao  PrpDclauseCodeComHisDao;

    /**
     *@description 新增
     *@param
     */
    public void save( PrpDclauseCodeComHisDto  PrpDclauseCodeComHisDto) {
         PrpDclauseCodeComHis  PrpDclauseCodeComHis = this.convert( PrpDclauseCodeComHisDto,  PrpDclauseCodeComHis.class);
         PrpDclauseCodeComHisDao.save( PrpDclauseCodeComHis);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,String comCode,java.lang.Double indexNo) {
         PrpDclauseCodeComHisKey  PrpDclauseCodeComHisKey = new  PrpDclauseCodeComHisKey(clauseCode,comCode,indexNo);
         PrpDclauseCodeComHisDao.delete( PrpDclauseCodeComHisKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify( PrpDclauseCodeComHisDto  PrpDclauseCodeComHisDto) {
         PrpDclauseCodeComHis  PrpDclauseCodeComHis = this.convert( PrpDclauseCodeComHisDto,  PrpDclauseCodeComHis.class);
         PrpDclauseCodeComHisDao.save( PrpDclauseCodeComHis);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public  PrpDclauseCodeComHisDto queryByPK(String clauseCode,String comCode,java.lang.Double indexNo) {
         PrpDclauseCodeComHisKey  PrpDclauseCodeComHisKey = new  PrpDclauseCodeComHisKey(clauseCode,comCode,indexNo);
         PrpDclauseCodeComHis  PrpDclauseCodeComHis =  PrpDclauseCodeComHisDao.findOne( PrpDclauseCodeComHisKey);
        return this.convert( PrpDclauseCodeComHis, PrpDclauseCodeComHisDto.class);
    }
}