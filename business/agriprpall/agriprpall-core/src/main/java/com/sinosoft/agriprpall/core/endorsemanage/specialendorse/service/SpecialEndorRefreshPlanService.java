package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCfeeDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

import java.util.List;

public interface SpecialEndorRefreshPlanService {
    /**
     * 刷新缴费计划
     * @author: 刘曼曼
     * @date: 2017/12/15 9:39
     * @param responseQueryPolicyInfoDtoNew 页面的保单大对象
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDtoOld 查询的保单大对象
     * @return ResponseQueryPolicyInfoDto 保单大对象
     * @throws Exception
     */
    public ResponseQueryPolicyInfoDto refreshPlanByPayTimes(ResponseQueryPolicyInfoDto responseQueryPolicyInfoDtoNew, BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDtoOld) throws Exception;

    /**
     * 获得总保费
     * @author: 刘曼曼
     * @date: 2017/12/15 9:47
     * @param prpCfeeDtoListNew 保单保额保费表集合
     * @return Double 总保费
     * @throws Exception
     */
    public Double getSumAmountPermiumFee(List<PrpCfeeDto> prpCfeeDtoListNew) throws Exception;

    /**
     * 计算缴费计划的总保费
     * @author: 刘曼曼
     * @date: 2017/12/15 9:45
     * @param responseQueryPolicyInfoDtoNew 保单大对象
     * @return Boolean
     * @throws Exception
     */
    public Boolean  checkPlanPayFee(ResponseQueryPolicyInfoDto responseQueryPolicyInfoDtoNew) throws Exception;

    /**
     * 计算当前缴费计划汇总金额与总保费的差额
     * @author: 刘曼曼
     * @date: 2017/12/13 15:48
     * @param prpCmainDto，prpCplanDtoList，prpCfeeDtoList 保单主表信息，收费计划表信息，保单保额保费信息
     * @return Double 当前缴费计划汇总金额与总保费的差额
     * @throws Exception
     */
    public Double calPlanFeeToPremium(PrpCmainDto prpCmainDto, List<PrpCplanDto> prpCplanDtoList, List<PrpCfeeDto> prpCfeeDtoList)throws Exception;

}
