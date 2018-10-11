package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto. PrpDclauseCodeHisDto;
import com.sinosoft.pms.core.kernel.dao. PrpDclauseCodeHisDao;
import com.sinosoft.pms.core.kernel.entity. PrpDclauseCodeHis;
import com.sinosoft.pms.core.kernel.entity. PrpDclauseCodeHisKey;
import com.sinosoft.pms.core.kernel.service. PrpDclauseCodeHisService;
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
 * @description 条款配置轨迹表主表Core接口实现
 */
@Service
public class  PrpDclauseCodeHisServiceImpl extends BaseServiceImpl implements  PrpDclauseCodeHisService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger( PrpDclauseCodeHisServiceImpl.class);
    
    @Autowired
    private  PrpDclauseCodeHisDao  PrpDclauseCodeHisDao;

    /**
     *@description 新增
     *@param
     */
    public void save( PrpDclauseCodeHisDto  PrpDclauseCodeHisDto) {
         PrpDclauseCodeHis  PrpDclauseCodeHis = this.convert( PrpDclauseCodeHisDto,  PrpDclauseCodeHis.class);
         PrpDclauseCodeHisDao.save( PrpDclauseCodeHis);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,java.lang.Double indexNo) {
         PrpDclauseCodeHisKey  PrpDclauseCodeHisKey = new  PrpDclauseCodeHisKey(clauseCode,indexNo);
         PrpDclauseCodeHisDao.delete( PrpDclauseCodeHisKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify( PrpDclauseCodeHisDto  PrpDclauseCodeHisDto) {
         PrpDclauseCodeHis  PrpDclauseCodeHis = this.convert( PrpDclauseCodeHisDto,  PrpDclauseCodeHis.class);
         PrpDclauseCodeHisDao.save( PrpDclauseCodeHis);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public  PrpDclauseCodeHisDto queryByPK(String clauseCode,java.lang.Double indexNo) {
         PrpDclauseCodeHisKey  PrpDclauseCodeHisKey = new  PrpDclauseCodeHisKey(clauseCode,indexNo);
         PrpDclauseCodeHis  PrpDclauseCodeHis =  PrpDclauseCodeHisDao.findOne( PrpDclauseCodeHisKey);
        return this.convert( PrpDclauseCodeHis, PrpDclauseCodeHisDto.class);
    }
}