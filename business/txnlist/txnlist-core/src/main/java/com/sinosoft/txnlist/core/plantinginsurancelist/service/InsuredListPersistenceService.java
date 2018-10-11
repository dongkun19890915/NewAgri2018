package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingPolicyListDto;

import java.util.List;

/**
 * 承保清单操作类Service
 *
 * @author 潘峰
 * @date 2017/11/14 上午11:02
 */
public interface InsuredListPersistenceService {


    /**
     * 种植险(农险一期)：承保清单持久化接口，需要持久化承保清单最新数据表，以及承保清单原始数据表
     * 如果saveFlag为1的时候为保存，2为更新
     *
     * @param plantingPolicyListDtos 种植险清单 ，savaFlag，保存或者更新
     * @return void
     * @author: 潘峰
     * @date: 2017/11/14 上午10:26
     */
    void savePlantingInsuredList(List<PlantingPolicyListDto> plantingPolicyListDtos, String saveFlag) throws Exception;

    /**
     * 养殖险(农险一期)：承保清单持久化接口，需要持久化承保清单最新数据表，以及承保清单原始数据表
     *
     * @param herdPolicyListDtos 养殖险承保清单主表
     * @param saveFlag          1保存，2更新
     * @author: 何伟东
     * @date: 2017/12/5 15:12
     */
    void saveHerdInsuredList(List<HerdPolicyListDto> herdPolicyListDtos, String saveFlag) throws Exception;

    /**
     * 农业险(农险二期)：承保清单持久化接口，需要持久化承保清单最新数据表，以及承保清单原始数据表
     *
     * @param nyxPolicyListDtos 农业险承保清单主表
     * @param saveFlag         1保存，2更新
     * @author: 何伟东
     * @date: 2017/12/8 15:50
     */
    void saveNyxInsuredList(List<NyxPolicyListDto> nyxPolicyListDtos, String saveFlag) throws Exception;
}
