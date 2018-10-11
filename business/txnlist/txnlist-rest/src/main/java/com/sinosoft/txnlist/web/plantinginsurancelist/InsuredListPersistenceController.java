package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.InsuredListPersistenceApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingPolicyListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.InsuredListPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 承保清单操作类Controller
 *
 * @author 潘峰
 * @date 2017/11/14 上午10:27
 */
@RestController
@RequestMapping(value = InsuredListPersistenceApi.PATH)
public class InsuredListPersistenceController implements InsuredListPersistenceApi {

    @Autowired
    private InsuredListPersistenceService insuredListPersistenceService;

    /**
     * 种植险(农险一期)：承保清单持久化接口，需要持久化承保清单最新数据表，以及承保清单原始数据表
     * 如果saveFlag为1的时候为保存，2为更新
     *
     * @param plantingPolicyListDtos 种植险清单 ，savaFlag，保存或者更新
     * @return void
     * @author: 潘峰
     * @date: 2017/11/14 上午10:26
     */
    @Override
    public void savePlantingInsuredList(@RequestBody List<PlantingPolicyListDto> plantingPolicyListDtos, @RequestParam(value = "saveFlag") String saveFlag) throws Exception {
        insuredListPersistenceService.savePlantingInsuredList(plantingPolicyListDtos, saveFlag);
    }

    /**
     * 养殖险(农险一期)：承保清单持久化接口，需要持久化承保清单最新数据表，以及承保清单原始数据表
     *
     * @param herdPolicyListDtos 养殖险承保清单主表
     * @param saveFlag          1保存，2更新
     * @author: 何伟东
     * @date: 2017/12/5 15:12
     */
    @Override
    public void saveHerdInsuredList(@RequestBody List<HerdPolicyListDto> herdPolicyListDtos, @RequestParam(value = "saveFlag") String saveFlag) throws Exception {
        insuredListPersistenceService.saveHerdInsuredList(herdPolicyListDtos, saveFlag);
    }

    /**
     * 农业险(农险二期)：承保清单持久化接口，需要持久化承保清单最新数据表，以及承保清单原始数据表
     *
     * @param nyxPolicyListDtos 农业险承保清单主表
     * @param saveFlag         1保存，2更新
     * @author: 何伟东
     * @date: 2017/12/8 15:50
     */
    @Override
    public void saveNyxInsuredList(@RequestBody List<NyxPolicyListDto> nyxPolicyListDtos, @RequestParam(value = "saveFlag") String saveFlag) throws Exception {
        insuredListPersistenceService.saveNyxInsuredList(nyxPolicyListDtos, saveFlag);
    }


}
