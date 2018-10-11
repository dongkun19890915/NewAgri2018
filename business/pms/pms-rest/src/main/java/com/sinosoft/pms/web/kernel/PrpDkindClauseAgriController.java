package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel.PrpDkindClauseAgriApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindClauseAgriDto;
import com.sinosoft.pms.core.kernel.service.PrpDkindClauseAgriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = PrpDkindClauseAgriApi.PATH)
public class PrpDkindClauseAgriController implements PrpDkindClauseAgriApi{
    @Autowired
    private PrpDkindClauseAgriService prpDkindClauseAgriService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpDkindClauseAgriDto queryByPk(@RequestBody Map<String,String> map) throws Exception {
        return prpDkindClauseAgriService.queryByPK(map.get("riskCode"),map.get("clauseFlag"),map.get("kindCode"),map.get("language"),map.get("clauseCode"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(@RequestBody PrpDkindClauseAgriDto prpDkindClauseAgriDto) throws Exception {
        prpDkindClauseAgriService.save(prpDkindClauseAgriDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(@RequestBody Map<String,String> map) throws Exception {
        prpDkindClauseAgriService.remove(map.get("riskCode"),map.get("clauseFlag"),map.get("kindCode"),map.get("language"),map.get("clauseCode"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(@RequestBody PrpDkindClauseAgriDto prpDkindClauseAgriDto) throws Exception {
        prpDkindClauseAgriService.modify(prpDkindClauseAgriDto);
    }
}
