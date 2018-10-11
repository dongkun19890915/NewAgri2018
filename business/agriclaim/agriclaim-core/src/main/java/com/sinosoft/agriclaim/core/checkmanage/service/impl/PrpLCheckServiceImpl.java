package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckDto;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLCheckDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheck;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheckKey;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckService;
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
 * @description 查勘/代查勘信息表Core接口实现
 */
@Service
public class PrpLCheckServiceImpl extends BaseServiceImpl implements PrpLCheckService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCheckServiceImpl.class);
    
    @Autowired
    private PrpLCheckDao prpLCheckDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCheckDto prpLCheckDto) {
        PrpLCheck prpLCheck = this.convert(prpLCheckDto, PrpLCheck.class);
        prpLCheckDao.save(prpLCheck);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,java.lang.Integer referSerialNo) {
        PrpLCheckKey prpLCheckKey = new PrpLCheckKey(registNo,referSerialNo);
        prpLCheckDao.delete(prpLCheckKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCheckDto prpLCheckDto) {
        PrpLCheck prpLCheck = this.convert(prpLCheckDto, PrpLCheck.class);
        prpLCheckDao.save(prpLCheck);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCheckDto queryByPK(String registNo,java.lang.Integer referSerialNo) {
        PrpLCheckKey prpLCheckKey = new PrpLCheckKey(registNo,referSerialNo);
        PrpLCheck prpLCheck = prpLCheckDao.findOne(prpLCheckKey);
        return this.convert(prpLCheck,PrpLCheckDto.class);
    }

    /**
     *@description 按报案号查询最大序列号
     *@param registNo 清单号
     *@return serialNo 最大序列号
     *@author 王心洋
     *@time 2018-01-18
     */
    public Integer queryMaxSerialByRegistNo(String registNo) throws Exception{
        Integer serialNo = prpLCheckDao.queryMaxSerialByRegistNo(registNo);
        if(serialNo == null){
            serialNo = 0;
        }
        return serialNo;
    }
}