package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLCfeecoinsDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLCfeecoinsDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLCfeecoins;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLCfeecoinsKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLCfeecoinsService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
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
 * @time  2017-11-08 05:35:28.283 
 * @description 共保费用信息表（无表名）Core接口实现
 */
@Service
public class PrpLCfeecoinsServiceImpl extends BaseServiceImpl implements PrpLCfeecoinsService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCfeecoinsServiceImpl.class);
    
    @Autowired
    private PrpLCfeecoinsDao prpLCfeecoinsDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCfeecoinsDto prpLCfeecoinsDto) {
        PrpLCfeecoins prpLCfeecoins = this.convert(prpLCfeecoinsDto, PrpLCfeecoins.class);
        prpLCfeecoinsDao.save(prpLCfeecoins);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String businessNo,java.lang.Double serialNo) {
        PrpLCfeecoinsKey prpLCfeecoinsKey = new PrpLCfeecoinsKey(businessNo,serialNo);
        prpLCfeecoinsDao.delete(prpLCfeecoinsKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCfeecoinsDto prpLCfeecoinsDto) {
        PrpLCfeecoins prpLCfeecoins = this.convert(prpLCfeecoinsDto, PrpLCfeecoins.class);
        prpLCfeecoinsDao.save(prpLCfeecoins);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCfeecoinsDto queryByPK(String businessNo,java.lang.Double serialNo) {
        PrpLCfeecoinsKey prpLCfeecoinsKey = new PrpLCfeecoinsKey(businessNo,serialNo);
        PrpLCfeecoins prpLCfeecoins = prpLCfeecoinsDao.findOne(prpLCfeecoinsKey);
        return this.convert(prpLCfeecoins,PrpLCfeecoinsDto.class);
    }

    /**
     *
     * @description 根据业务号查询PrpLCfeecoins
     * @author 周柯宇
     * @date 2018年1月26日 下午3:45:11
     * @param businessNo业务号
     * @return List<PrpLCfeecoinsDto>
     * @Throws Exception
     */
    @Override
    public List<PrpLCfeecoinsDto> queryByBusinessNo(String businessNo) throws Exception {
        if(StringUtils.isEmpty(businessNo)){
            throw new DataVerifyException("业务号不能为空");
        }
        List<PrpLCfeecoins> prpLCfeecoinsList = prpLCfeecoinsDao.findByBusinessNo(businessNo);
        List<PrpLCfeecoinsDto> prpLCfeecoinsDtoList = new ArrayList<PrpLCfeecoinsDto>();
        this.convertCollection(prpLCfeecoinsList, prpLCfeecoinsDtoList, PrpLCfeecoinsDto.class);
        return prpLCfeecoinsDtoList;
    }
}