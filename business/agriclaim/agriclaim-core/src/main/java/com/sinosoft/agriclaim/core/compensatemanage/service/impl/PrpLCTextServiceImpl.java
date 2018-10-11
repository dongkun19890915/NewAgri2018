package com.sinosoft.agriclaim.core.compensatemanage.service.impl;

import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCTextDto;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCTextDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCText;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCTextKey;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLCTextService;
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
 * @time  2017-11-08 05:40:44.225 
 * @description 赔款计算文字表Core接口实现
 */
@Service
public class PrpLCTextServiceImpl extends BaseServiceImpl implements PrpLCTextService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCTextServiceImpl.class);
    
    @Autowired
    private PrpLCTextDao prpLCTextDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCTextDto prpLCTextDto) {
        PrpLCText prpLCText = this.convert(prpLCTextDto, PrpLCText.class);
        prpLCTextDao.save(prpLCText);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String compensateNo,String textType,java.lang.Integer lineNo) {
        PrpLCTextKey prpLCTextKey = new PrpLCTextKey(compensateNo,textType,lineNo);
        prpLCTextDao.delete(prpLCTextKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCTextDto prpLCTextDto) {
        PrpLCText prpLCText = this.convert(prpLCTextDto, PrpLCText.class);
        prpLCTextDao.save(prpLCText);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCTextDto queryByPK(String compensateNo,String textType,java.lang.Integer lineNo) {
        PrpLCTextKey prpLCTextKey = new PrpLCTextKey(compensateNo,textType,lineNo);
        PrpLCText prpLCText = prpLCTextDao.findOne(prpLCTextKey);
        return this.convert(prpLCText,PrpLCTextDto.class);
    }
}