package com.sinosoft.dms.web.customer;

import com.sinosoft.dms.api.customer.PrpDcustomerRiskLevelSubApi;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerRiskLevelSubDto;
import com.sinosoft.dms.core.customer.service.PrpDcustomerRiskLevelSubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 记录客户风险等级详细表controller层
 */
@RestController
@RequestMapping(value = PrpDcustomerRiskLevelSubController.PATH)
public class PrpDcustomerRiskLevelSubController implements PrpDcustomerRiskLevelSubApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDcustomerRiskLevelSubController.class);

    @Autowired
    private PrpDcustomerRiskLevelSubService prpdcustomerrisklevelsubService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDcustomerRiskLevelSubDto prpdcustomerrisklevelsubDto) {
        prpdcustomerrisklevelsubService.save(prpdcustomerrisklevelsubDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String customerRiskLevelId) {
        prpdcustomerrisklevelsubService.remove(customerRiskLevelId);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDcustomerRiskLevelSubDto prpdcustomerrisklevelsubDto) {
        prpdcustomerrisklevelsubService.modify(prpdcustomerrisklevelsubDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDcustomerRiskLevelSubDto queryByPK(@RequestBody String customerRiskLevelId) {
        return prpdcustomerrisklevelsubService.queryByPK(customerRiskLevelId);
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
    public List<PrpDcustomerRiskLevelSubDto> queryRiskLevel(@RequestParam("policyNo") String policyNo) throws Exception {
        return prpdcustomerrisklevelsubService.queryRiskLevel(policyNo);
    }
}
