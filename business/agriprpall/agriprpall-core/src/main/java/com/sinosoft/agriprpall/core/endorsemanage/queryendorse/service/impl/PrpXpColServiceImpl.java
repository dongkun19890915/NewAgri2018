package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpXpColDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpXpColDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpXpCol;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpXpColKey;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpXpColService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 06:23:40.452 
 * @description 批文数据字典表Core接口实现
 */
@Service
public class PrpXpColServiceImpl extends BaseServiceImpl implements PrpXpColService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpXpColServiceImpl.class);
    
    @Autowired
    private PrpXpColDao prpXpColDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpXpColDto prpXpColDto) {
        PrpXpCol prpXpCol = this.convert(prpXpColDto, PrpXpCol.class);
        prpXpColDao.save(prpXpCol);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String tableName,Integer colSeq,Integer dispSeq) {
        PrpXpColKey prpXpColKey = new PrpXpColKey(riskCode,tableName,colSeq,dispSeq);
        prpXpColDao.delete(prpXpColKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpXpColDto prpXpColDto) {
        PrpXpCol prpXpCol = this.convert(prpXpColDto, PrpXpCol.class);
        prpXpColDao.save(prpXpCol);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpXpColDto queryByPK(String riskCode,String tableName,Integer colSeq,Integer dispSeq) {
        PrpXpColKey prpXpColKey = new PrpXpColKey(riskCode,tableName,colSeq,dispSeq);
        PrpXpCol prpXpCol = prpXpColDao.findOne(prpXpColKey);
        return this.convert(prpXpCol,PrpXpColDto.class);
    }
}