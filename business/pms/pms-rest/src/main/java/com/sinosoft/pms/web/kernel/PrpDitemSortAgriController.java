package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel.PrpDitemSortAgriApi;
import com.sinosoft.pms.api.kernel.dto.PrpDitemSortAgriDto;
import com.sinosoft.pms.core.kernel.service.PrpDitemSortAgriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = PrpDitemSortAgriApi.PATH)
public class PrpDitemSortAgriController implements PrpDitemSortAgriApi {
    @Autowired
    private PrpDitemSortAgriService prpDitemSortAgriService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpDitemSortAgriDto queryByPk(@RequestBody Map<String, String> map) throws Exception {
        return prpDitemSortAgriService.queryByPK(map.get("itemCode"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(@RequestBody PrpDitemSortAgriDto prpDitemSortAgriDto) throws Exception {
        prpDitemSortAgriService.save(prpDitemSortAgriDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(@RequestBody Map<String, String> map) throws Exception {
        prpDitemSortAgriService.remove(map.get("itemCode"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(@RequestBody PrpDitemSortAgriDto prpDitemSortAgriDto) throws Exception {
        prpDitemSortAgriService.modify(prpDitemSortAgriDto);
    }
}
