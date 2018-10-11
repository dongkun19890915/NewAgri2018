package com.sinosoft.dms.core.customer.service.impl;

import com.sinosoft.agriprpall.api.policymanage.PrpCinsuredApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCinsuredDto;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerRiskLevelSubDto;
import com.sinosoft.dms.core.customer.dao.PrpDcustomerRiskLevelSubDao;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerRiskLevelSub;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerRiskLevelSubKey;
import com.sinosoft.dms.core.customer.service.PrpDcustomerRiskLevelSubService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 记录客户风险等级详细表Core接口实现
 */
@Service
public class PrpDcustomerRiskLevelSubServiceImpl extends BaseServiceImpl implements PrpDcustomerRiskLevelSubService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDcustomerRiskLevelSubServiceImpl.class);
    
    @Autowired
    private PrpDcustomerRiskLevelSubDao prpdcustomerrisklevelsubDao;
    @Autowired
    private PrpCinsuredApi prpCinsuredApi;
    /**
     *@description 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDcustomerRiskLevelSubDto prpdcustomerrisklevelsubDto) {
        PrpDcustomerRiskLevelSub prpdcustomerrisklevelsub = this.convert(prpdcustomerrisklevelsubDto, PrpDcustomerRiskLevelSub.class);
        prpdcustomerrisklevelsubDao.save(prpdcustomerrisklevelsub);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String customerRiskLevelId) {
        PrpDcustomerRiskLevelSubKey prpdcustomerrisklevelsubKey = new PrpDcustomerRiskLevelSubKey(customerRiskLevelId);
        prpdcustomerrisklevelsubDao.delete(prpdcustomerrisklevelsubKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDcustomerRiskLevelSubDto prpdcustomerrisklevelsubDto) {
        PrpDcustomerRiskLevelSub prpdcustomerrisklevelsub = this.convert(prpdcustomerrisklevelsubDto, PrpDcustomerRiskLevelSub.class);
        prpdcustomerrisklevelsubDao.save(prpdcustomerrisklevelsub);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDcustomerRiskLevelSubDto queryByPK(String customerRiskLevelId) {
        PrpDcustomerRiskLevelSubKey prpdcustomerrisklevelsubKey = new PrpDcustomerRiskLevelSubKey(customerRiskLevelId);
        PrpDcustomerRiskLevelSub prpdcustomerrisklevelsub = prpdcustomerrisklevelsubDao.findOne(prpdcustomerrisklevelsubKey);
        return this.convert(prpdcustomerrisklevelsub,PrpDcustomerRiskLevelSubDto.class);
    }
    /**
     * （查询被保险人和投保人风险等级）
     * @author: 王志文
     * @date: 2018/3/31 17:55
     * @param policyNo 保单号
     * @return
     * @throws Exception
     */
    @Override
    public List<PrpDcustomerRiskLevelSubDto> queryRiskLevel(String policyNo) throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put("policyNo",policyNo);
        List<PrpCinsuredDto> prpCinsuredDtoList = prpCinsuredApi.queryInsuredCodeByPolicyNoAndInsuredName(map);
        String insuredCode = "";
        String insuredCode1 = "";
        if (prpCinsuredDtoList.size()>0){
            for (PrpCinsuredDto prpCinsuredDto : prpCinsuredDtoList){
                //被保险人
                if ("1".equals(prpCinsuredDto.getInsuredFlag())){
                    insuredCode = prpCinsuredDto.getInsuredCode();
                }
                //投保人
                else if ("2".equals(prpCinsuredDto.getInsuredFlag())){
                    insuredCode1 = prpCinsuredDto.getInsuredCode();
                }
            }
        }
        List<PrpDcustomerRiskLevelSubDto> prpDcustomerRiskLevelSubBackList = new ArrayList<>();
        List<PrpDcustomerRiskLevelSub> prpDcustomerRiskLevelSubList = prpdcustomerrisklevelsubDao.queryAllByCustomerCode(insuredCode);
        List<PrpDcustomerRiskLevelSub> prpDcustomerRiskLevelSubList1 = prpdcustomerrisklevelsubDao.queryAllByCustomerCode(insuredCode1);
        if (prpDcustomerRiskLevelSubList.size()>0){
            PrpDcustomerRiskLevelSub prpDcustomerRiskLevelSub = prpDcustomerRiskLevelSubList.get(0);
            prpDcustomerRiskLevelSubBackList.add(this.convert(prpDcustomerRiskLevelSub,PrpDcustomerRiskLevelSubDto.class));
        }
        if (prpDcustomerRiskLevelSubList1.size()>0){
            PrpDcustomerRiskLevelSub prpDcustomerRiskLevelSub = prpDcustomerRiskLevelSubList1.get(0);
            prpDcustomerRiskLevelSubBackList.add(this.convert(prpDcustomerRiskLevelSub,PrpDcustomerRiskLevelSubDto.class));
        }
        return prpDcustomerRiskLevelSubBackList;
    }
}