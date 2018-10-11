package com.sinosoft.ims.core.kernel.service.impl;

import com.sinosoft.ims.api.kernel.dto.PrpDuserSubDto;
import com.sinosoft.ims.core.kernel.dao.PrpDuserSubDao;
import com.sinosoft.ims.core.kernel.entity.PrpDuserSub;
import com.sinosoft.ims.core.kernel.entity.PrpDuserSubKey;
import com.sinosoft.ims.core.kernel.service.PrpDuserSubService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 用户表附表Core接口实现
 */
@Service
public class PrpDuserSubServiceImpl extends BaseServiceImpl implements PrpDuserSubService {
	/** log日志 */
//    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDuserSubServiceImpl.class);
    
    @Autowired
    private PrpDuserSubDao prpDuserSubDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDuserSubDto prpDuserSubDto) {
        PrpDuserSub prpDuserSub = this.convert(prpDuserSubDto, PrpDuserSub.class);
        prpDuserSubDao.save(prpDuserSub);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String userCode) {
        PrpDuserSubKey prpDuserSubKey = new PrpDuserSubKey(userCode);
        prpDuserSubDao.delete(prpDuserSubKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDuserSubDto prpDuserSubDto) {
        PrpDuserSub prpDuserSub = this.convert(prpDuserSubDto, PrpDuserSub.class);
        prpDuserSubDao.save(prpDuserSub);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDuserSubDto queryByPK(String userCode) {
        PrpDuserSubKey prpDuserSubKey = new PrpDuserSubKey(userCode);
        PrpDuserSub prpDuserSub = prpDuserSubDao.findOne(prpDuserSubKey);
        return this.convert(prpDuserSub,PrpDuserSubDto.class);
    }
}