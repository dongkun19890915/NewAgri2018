package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLAcciCheckTextDto;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLAcciCheckTextDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLAcciCheckText;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLAcciCheckTextKey;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLAcciCheckTextService;
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
 * @time  2017-11-08 05:38:49.324 
 * @description 调查文本信息表Core接口实现
 */
@Service
public class PrpLAcciCheckTextServiceImpl extends BaseServiceImpl implements PrpLAcciCheckTextService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLAcciCheckTextServiceImpl.class);
    
    @Autowired
    private PrpLAcciCheckTextDao prpLAcciCheckTextDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLAcciCheckTextDto prpLAcciCheckTextDto) {
        PrpLAcciCheckText prpLAcciCheckText = this.convert(prpLAcciCheckTextDto, PrpLAcciCheckText.class);
        prpLAcciCheckTextDao.save(prpLAcciCheckText);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String checkNo,String textType,java.lang.Integer lineNo) {
        PrpLAcciCheckTextKey prpLAcciCheckTextKey = new PrpLAcciCheckTextKey(checkNo,textType,lineNo);
        prpLAcciCheckTextDao.delete(prpLAcciCheckTextKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLAcciCheckTextDto prpLAcciCheckTextDto) {
        PrpLAcciCheckText prpLAcciCheckText = this.convert(prpLAcciCheckTextDto, PrpLAcciCheckText.class);
        prpLAcciCheckTextDao.save(prpLAcciCheckText);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLAcciCheckTextDto queryByPK(String checkNo,String textType,java.lang.Integer lineNo) {
        PrpLAcciCheckTextKey prpLAcciCheckTextKey = new PrpLAcciCheckTextKey(checkNo,textType,lineNo);
        PrpLAcciCheckText prpLAcciCheckText = prpLAcciCheckTextDao.findOne(prpLAcciCheckTextKey);
        return this.convert(prpLAcciCheckText,PrpLAcciCheckTextDto.class);
    }
}