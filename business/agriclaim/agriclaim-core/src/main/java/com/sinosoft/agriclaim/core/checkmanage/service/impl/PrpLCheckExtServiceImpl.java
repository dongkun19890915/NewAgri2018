package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckExtDto;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLCheckExtDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheckExt;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheckExtKey;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckExtService;
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
 * @description 查勘/代查勘扩展表Core接口实现
 */
@Service
public class PrpLCheckExtServiceImpl extends BaseServiceImpl implements PrpLCheckExtService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCheckExtServiceImpl.class);
    
    @Autowired
    private PrpLCheckExtDao prpLCheckExtDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCheckExtDto prpLCheckExtDto) {
        PrpLCheckExt prpLCheckExt = this.convert(prpLCheckExtDto, PrpLCheckExt.class);
        prpLCheckExtDao.save(prpLCheckExt);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,java.lang.Integer serialNo,String columnName,java.lang.Integer referSerialNo) {
        PrpLCheckExtKey prpLCheckExtKey = new PrpLCheckExtKey(registNo,serialNo,columnName,referSerialNo);
        prpLCheckExtDao.delete(prpLCheckExtKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCheckExtDto prpLCheckExtDto) {
        PrpLCheckExt prpLCheckExt = this.convert(prpLCheckExtDto, PrpLCheckExt.class);
        prpLCheckExtDao.save(prpLCheckExt);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCheckExtDto queryByPK(String registNo,java.lang.Integer serialNo,String columnName,java.lang.Integer referSerialNo) {
        PrpLCheckExtKey prpLCheckExtKey = new PrpLCheckExtKey(registNo,serialNo,columnName,referSerialNo);
        PrpLCheckExt prpLCheckExt = prpLCheckExtDao.findOne(prpLCheckExtKey);
        return this.convert(prpLCheckExt,PrpLCheckExtDto.class);
    }
    public List<PrpLCheckExtDto> queryByRegistNo(String registNo) {
        Specification<PrpLCheckExt> specification = Specifications.<PrpLCheckExt>and().eq("registNo", registNo).build();
        List<PrpLCheckExt> checkExtList = prpLCheckExtDao.findAll(specification);
        List<PrpLCheckExtDto> checkExtDtoList = new ArrayList<PrpLCheckExtDto>();
        this.convertCollection(checkExtList, checkExtDtoList, PrpLCheckExtDto.class);
        return checkExtDtoList;
    }
}