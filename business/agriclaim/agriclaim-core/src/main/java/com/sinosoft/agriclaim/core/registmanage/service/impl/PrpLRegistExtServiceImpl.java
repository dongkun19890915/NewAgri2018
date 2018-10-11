package com.sinosoft.agriclaim.core.registmanage.service.impl;

import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistExtDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistExt;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistExtKey;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistExtService;
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
 * @time  2017-11-08 05:45:22.527 
 * @description 报案信息补充说明Core接口实现
 */
@Service
public class PrpLRegistExtServiceImpl extends BaseServiceImpl implements PrpLRegistExtService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLRegistExtServiceImpl.class);
    
    @Autowired
    private PrpLRegistExtDao prpLRegistExtDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLRegistExtDto prpLRegistExtDto) {
        PrpLRegistExt prpLRegistExt = this.convert(prpLRegistExtDto, PrpLRegistExt.class);
        prpLRegistExtDao.save(prpLRegistExt);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,java.lang.Integer serialNo,String nodeType) {
        PrpLRegistExtKey prpLRegistExtKey = new PrpLRegistExtKey(registNo,serialNo,nodeType);
        prpLRegistExtDao.delete(prpLRegistExtKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLRegistExtDto prpLRegistExtDto) {
        PrpLRegistExt prpLRegistExt = this.convert(prpLRegistExtDto, PrpLRegistExt.class);
        prpLRegistExtDao.save(prpLRegistExt);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRegistExtDto queryByPK(String registNo,java.lang.Integer serialNo,String nodeType) {
        PrpLRegistExtKey prpLRegistExtKey = new PrpLRegistExtKey(registNo,serialNo,nodeType);
        PrpLRegistExt prpLRegistExt = prpLRegistExtDao.findOne(prpLRegistExtKey);
        return this.convert(prpLRegistExt,PrpLRegistExtDto.class);
    }
    @Override
    public List<PrpLRegistExtDto> queryByRegistNo(String registNo) {
        Specification<PrpLRegistExt> specification = Specifications.<PrpLRegistExt>and().eq("registNo", registNo).build();
        List<PrpLRegistExt> registExtList = prpLRegistExtDao.findAll(specification);
        List<PrpLRegistExtDto> registExtDtoList = new ArrayList<PrpLRegistExtDto>();
        this.convertCollection(registExtList, registExtDtoList, PrpLRegistExtDto.class);
        return registExtDtoList;
    }
}