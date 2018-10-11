package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.HerdcEndorChgDetailApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdcEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdcEndorChgDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = HerdcEndorChgDetailApi.PATH)
public class HerdcEndorChgDetailController implements HerdcEndorChgDetailApi {
    @Autowired
    private HerdcEndorChgDetailService herdcEndorChgDetailService;
    /**
    * 批改保存前删除
    * @param insureListCode 标的清单号
    * @return void
    * @throws
    * @author 李冬松
    * @date 17:51 2018/4/12
    */
    @Override
    public void removeByInsureListCode(@RequestParam String insureListCode) throws Exception {
        herdcEndorChgDetailService.removeByInsureListCode(insureListCode);
    }

    @Override
    public void save(@RequestBody List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList) throws Exception {
        herdcEndorChgDetailService.save(herdcEndorChgDetailDtoList);
    }

    @Override
    public @ResponseBody List<HerdcEndorChgDetailDto> queryByInsureListCode(@RequestBody Map<String, String> map) throws Exception {
        return herdcEndorChgDetailService.queryByInsureListCode(map.get("insureListCode"));
    }
}
