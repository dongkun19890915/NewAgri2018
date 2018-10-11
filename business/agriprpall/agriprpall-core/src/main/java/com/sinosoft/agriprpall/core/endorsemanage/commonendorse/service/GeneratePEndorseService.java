package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
/**
 * 普通批改P表处理类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
public interface GeneratePEndorseService {
    /**
    * 生成批单对象
    * @param policyEndorseDto 保单批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 18:47 2017/12/5
    */
    public void generatePNew(PolicyEndorseDto policyEndorseDto) throws Exception;

    /**
     * @description: web批改后金额处理函数,老系统中因为阳光调整比较的大，现在此函数只是用来处理批改后生成缴费计划的数据
     * @author: 李东东
     * @date: 2017/11/1 16:12
     * @param
     * @throws Exception
     */
    public void webAfterCal(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto) throws Exception;
    /**
    * @description
    * @param blPolicyDtoNew, 保单大对象  blEndorseDto ，批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 18:50 2017/12/5
    */
    public void settleBeforeSave(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception;
    /**
     * @description 更新批改次数
     * @param policyEndorseDto 保单批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 14:35 2017/11/11
     */
    public void updateEndorseTimes(PolicyEndorseDto policyEndorseDto)throws Exception;
    /**
    * 批单保存方法
    * @param blPolicyDtoNew 保单大对象, blEndorseDto 批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 19:05 2017/12/5
    */
    public void saveEndorseInfo(PolicyEndorseDto policyEndorseDto) throws Exception;

    /**
     * 保单转批单接口
     * @param blPolicyDtoOld 旧保单大对象
     * @param blPolicyDtoNew 新保单大对象
     * @param blEndorseDto 批单大对象
     * @throws Exception
     * @author 王心洋
     * @date 2017/12/22
     */
    public void evaluateFromPolicyToEndor(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto) throws Exception;

    public  void generatePrpPfee(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception;
}
