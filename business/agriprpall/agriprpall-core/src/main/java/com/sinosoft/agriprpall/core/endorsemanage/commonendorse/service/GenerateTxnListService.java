package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31PolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingPolicyListDto;

import java.util.List;

/**
 * 普通批改清单表处理类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
public interface GenerateTxnListService {
    /**
    *  清单表处理
    * @param policyEndorseDto 保单批单封装Dto
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 18:38 2017/12/5
    */
    public void dealTxnList(PolicyEndorseDto policyEndorseDto)throws Exception;
    /**
    * 清单表保存
    * @param policyEndorseDto
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 18:38 2017/12/5
    */
    public void saveNYXList(PolicyEndorseDto policyEndorseDto) throws Exception;

    /**
     * herdEndorChgDetail表处理
     * @param herdPolicyListDtoList 表对象集合
     * @param blPolicyDtoNew  页面传入保单大对象
     * @param blEndorseDto   批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 18:42 2017/12/5
     */
    public void evaluateBreedFromPolicyToEndor(List<HerdPolicyListDto> herdPolicyListDtoList, ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception;
    /**
     * nyxEndorChgDetail表处理
     * @param nyxPolicyListDtoList 表对象集合
     * @param blPolicyDtoNew  页面传入保单大对象
     * @param blEndorseDto   批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 18:42 2017/12/5
     */
    public void evaluateNyxFromPolicyToEndor(List<NyxPolicyListDto> nyxPolicyListDtoList, ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception;
    public void evaluatePlantingFromPolicyToEndor(List<PlantingPolicyListDto> plantingPolicyListDtoList, ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception;
    public void evaluatePlanting31FromPolicyToEndor(List<Planting31PolicyListDto> planting31PolicyListDtoList, ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception;
}
