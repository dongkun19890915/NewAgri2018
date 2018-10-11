package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpDbusinessDataCheckDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpDbusinessDataCheckDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpDbusinessDataCheck;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpDbusinessDataCheckKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpDbusinessDataCheckService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 01:52:20.999 
 *  业务数据检查表Core接口实现
 */
@Service
public class PrpDbusinessDataCheckServiceImpl extends BaseServiceImpl implements PrpDbusinessDataCheckService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDbusinessDataCheckServiceImpl.class);
    
    @Autowired
    private PrpDbusinessDataCheckDao prpDbusinessDataCheckDao;

    /**
     * 新增
     *@param
     */
    @Override
    public void save(PrpDbusinessDataCheckDto prpDbusinessDataCheckDto) {
        PrpDbusinessDataCheck prpDbusinessDataCheck = this.convert(prpDbusinessDataCheckDto, PrpDbusinessDataCheck.class);
        prpDbusinessDataCheckDao.save(prpDbusinessDataCheck);
    }
    /**
     * 删除
     *@param
     */
    @Override
    public void remove(String serialNo) {
        PrpDbusinessDataCheckKey prpDbusinessDataCheckKey = new PrpDbusinessDataCheckKey(serialNo);
        prpDbusinessDataCheckDao.delete(prpDbusinessDataCheckKey);
    }
    /**
     * 修改
     *@param
     */
    @Override
    public void modify(PrpDbusinessDataCheckDto prpDbusinessDataCheckDto) {
        PrpDbusinessDataCheck prpDbusinessDataCheck = this.convert(prpDbusinessDataCheckDto, PrpDbusinessDataCheck.class);
        prpDbusinessDataCheckDao.save(prpDbusinessDataCheck);
    }
    /**
     * 按主键查询实体
     *@param 
     */
    @Override
    public PrpDbusinessDataCheckDto queryByPK(String serialNo) {
        PrpDbusinessDataCheckKey prpDbusinessDataCheckKey = new PrpDbusinessDataCheckKey(serialNo);
        PrpDbusinessDataCheck prpDbusinessDataCheck = prpDbusinessDataCheckDao.findOne(prpDbusinessDataCheckKey);
        return this.convert(prpDbusinessDataCheck,PrpDbusinessDataCheckDto.class);
    }
}