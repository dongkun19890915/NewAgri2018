package com.sinosoft.agriclaim.core.compensatemanage.service;


import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLChargeDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔款费用信息表Core接口
 */
public interface PrpLChargeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLChargeDto prpLChargeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String compensateNo,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLChargeDto prpLChargeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLChargeDto queryByPK(String compensateNo,java.lang.Integer serialNo);

    /**
     *
     * @description 根据业务号查询PrpLCharge
     * @author 周柯宇
     * @date 2018年1月26日 下午3:53:37
     * @param 业务号
     * @return List<PrpLChargeDto>
     * @Throws Exception
     */
    List<PrpLChargeDto> queryByBusinessNo(String businessNo);

    /**
     * （理算保存赔付信息删除历史数据）
     * @author: 王志文
     * @date: 2018/4/27 15:08
     * @param compensateNo
     * @throws Exception
     */
    public void deletePrpLchargeForCompeSave(String compensateNo) throws Exception;
}