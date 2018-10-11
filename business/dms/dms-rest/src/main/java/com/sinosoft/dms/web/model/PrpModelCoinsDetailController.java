package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelCoinsDetailApi;
import com.sinosoft.dms.api.model.dto.PrpModelCoinsDetailDto;
import com.sinosoft.dms.core.model.service.PrpModelCoinsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = PrpModelCoinsDetailApi.PATH)
public class PrpModelCoinsDetailController implements PrpModelCoinsDetailApi{
    @Autowired
    private PrpModelCoinsDetailService prpModelCoinsDetailService;

    @Override
    public PrpModelCoinsDetailDto queryByPk(Map<String, Object> map) throws Exception {
        return prpModelCoinsDetailService.queryByPk((String) map.get("modelCode"),(Integer) map.get("serialNo"),(String) map.get("currency"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpModelCoinsDetailDto prpModelCoinsDetailDto) throws Exception {
        prpModelCoinsDetailService.save(prpModelCoinsDetailDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PrpModelCoinsDetailDto prpModelCoinsDetailDto) throws Exception {
        prpModelCoinsDetailService.update(prpModelCoinsDetailDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Map<String, Object> map) throws Exception {
        prpModelCoinsDetailService.delete((String) map.get("modelCode"),(Integer) map.get("serialNo"),(String) map.get("currency"));
    }
}
