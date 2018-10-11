package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossExtDto;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLverifyLossExtDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLossExt;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLossExtKey;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLverifyLossExtService;
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
 * @time  2017-11-17 08:28:31.346 
 * @description 处理意见表Core接口实现
 */
@Service
public class PrpLverifyLossExtServiceImpl extends BaseServiceImpl implements PrpLverifyLossExtService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLverifyLossExtServiceImpl.class);
    
    @Autowired
    private PrpLverifyLossExtDao prpLverifyLossExtDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLverifyLossExtDto prpLverifyLossExtDto) {
        PrpLverifyLossExt prpLverifyLossExt = this.convert(prpLverifyLossExtDto, PrpLverifyLossExt.class);
        prpLverifyLossExtDao.save(prpLverifyLossExt);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo) {
        PrpLverifyLossExtKey prpLverifyLossExtKey = new PrpLverifyLossExtKey(registNo);
        prpLverifyLossExtDao.delete(prpLverifyLossExtKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLverifyLossExtDto prpLverifyLossExtDto) {
        PrpLverifyLossExt prpLverifyLossExt = this.convert(prpLverifyLossExtDto, PrpLverifyLossExt.class);
        prpLverifyLossExtDao.save(prpLverifyLossExt);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLverifyLossExtDto queryByPK(String registNo) {
        PrpLverifyLossExtKey prpLverifyLossExtKey = new PrpLverifyLossExtKey(registNo);
        PrpLverifyLossExt prpLverifyLossExt = prpLverifyLossExtDao.findOne(prpLverifyLossExtKey);
        return this.convert(prpLverifyLossExt,PrpLverifyLossExtDto.class);
    }
}