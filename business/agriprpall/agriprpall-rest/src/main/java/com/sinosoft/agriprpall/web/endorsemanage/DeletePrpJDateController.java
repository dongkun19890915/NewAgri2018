package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.DeletePrpJDateApi;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.DeletePrpJDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 根据保单号删除
 * @author 王保良
 * @date 2017年11月10日
 */
@RestController
@RequestMapping(value = DeletePrpJDateApi.PATH)
public class DeletePrpJDateController implements DeletePrpJDateApi{
    @Autowired
    private DeletePrpJDateService prpJDateService;

    @Override
    public void deletePrpJDate(@RequestBody Map<String, String> map) throws Exception {
        prpJDateService.deletePrpJDate(map.get("businessNo"));
    }
}
