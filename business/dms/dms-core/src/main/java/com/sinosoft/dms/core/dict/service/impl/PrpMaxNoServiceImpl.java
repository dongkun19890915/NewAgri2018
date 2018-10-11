package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpMaxNoDto;
import com.sinosoft.dms.core.dict.dao.PrpMaxNoDao;
import com.sinosoft.dms.core.dict.entity.PrpMaxNo;
import com.sinosoft.dms.core.dict.entity.PrpMaxNoKey;
import com.sinosoft.dms.core.dict.service.PrpMaxNoService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import java.lang.Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * @description PrpMaxNoCore接口实现
 */
@Service
public class PrpMaxNoServiceImpl extends BaseServiceImpl implements PrpMaxNoService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpMaxNoServiceImpl.class);
    
    @Autowired
    private PrpMaxNoDao prpMaxNoDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpMaxNoDto prpMaxNoDto) {
        PrpMaxNo prpMaxNo = this.convert(prpMaxNoDto, PrpMaxNo.class);
        prpMaxNoDao.save(prpMaxNo);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String groupNo,String tableName,String maxNo) {
        PrpMaxNoKey prpMaxNoKey = new PrpMaxNoKey(groupNo,tableName,maxNo);
        prpMaxNoDao.delete(prpMaxNoKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpMaxNoDto prpMaxNoDto) {
        PrpMaxNo prpMaxNo = this.convert(prpMaxNoDto, PrpMaxNo.class);
        prpMaxNoDao.save(prpMaxNo);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpMaxNoDto queryByPK(String groupNo,String tableName,String maxNo) {
        PrpMaxNoKey prpMaxNoKey = new PrpMaxNoKey(groupNo,tableName,maxNo);
        PrpMaxNo prpMaxNo = prpMaxNoDao.findOne(prpMaxNoKey);
        return this.convert(prpMaxNo,PrpMaxNoDto.class);
    }

    /**
     * （通过分组号，表名 查询最大序号和最小序号和个数）
     * @author: 王志文
     * @date: 2017/12/14 20:06
     * @param groupNo
     * @param tableName
     * @return
     */
    @Override
    public List<Object[]> queryMaxNoByGroupNoAndTableName(String groupNo, String tableName) {
        return prpMaxNoDao.queryMaxNoByGroupNoAndTableName(groupNo,tableName);
    }
}