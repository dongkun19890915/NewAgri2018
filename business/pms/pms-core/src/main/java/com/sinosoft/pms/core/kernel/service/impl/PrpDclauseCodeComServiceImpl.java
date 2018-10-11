package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto. PrpDclauseCodeComDto;
import com.sinosoft.pms.core.kernel.dao. PrpDclauseCodeComDao;
import com.sinosoft.pms.core.kernel.entity. PrpDclauseCodeCom;
import com.sinosoft.pms.core.kernel.entity. PrpDclauseCodeComKey;
import com.sinosoft.pms.core.kernel.service. PrpDclauseCodeComService;
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
 * @description 条款机构配置表Core接口实现
 */
@Service
public class  PrpDclauseCodeComServiceImpl extends BaseServiceImpl implements  PrpDclauseCodeComService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger( PrpDclauseCodeComServiceImpl.class);
    
    @Autowired
    private  PrpDclauseCodeComDao  PrpDclauseCodeComDao;

    /**
     *@description 新增
     *@param
     */
    public void save( PrpDclauseCodeComDto  PrpDclauseCodeComDto) {
         PrpDclauseCodeCom  PrpDclauseCodeCom = this.convert( PrpDclauseCodeComDto,  PrpDclauseCodeCom.class);
         PrpDclauseCodeComDao.save( PrpDclauseCodeCom);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,String comCode,String comName) {
         PrpDclauseCodeComKey  PrpDclauseCodeComKey = new  PrpDclauseCodeComKey(clauseCode,comCode,comName);
         PrpDclauseCodeComDao.delete( PrpDclauseCodeComKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify( PrpDclauseCodeComDto  PrpDclauseCodeComDto) {
         PrpDclauseCodeCom  PrpDclauseCodeCom = this.convert( PrpDclauseCodeComDto,  PrpDclauseCodeCom.class);
         PrpDclauseCodeComDao.save( PrpDclauseCodeCom);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public  PrpDclauseCodeComDto queryByPK(String clauseCode,String comCode,String comName) {
         PrpDclauseCodeComKey  PrpDclauseCodeComKey = new  PrpDclauseCodeComKey(clauseCode,comCode,comName);
         PrpDclauseCodeCom  PrpDclauseCodeCom =  PrpDclauseCodeComDao.findOne( PrpDclauseCodeComKey);
        return this.convert( PrpDclauseCodeCom, PrpDclauseCodeComDto.class);
    }
}