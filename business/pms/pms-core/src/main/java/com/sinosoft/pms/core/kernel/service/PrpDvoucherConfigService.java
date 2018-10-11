package com.sinosoft.pms.core.kernel.service;

import com.sinosoft.pms.api.kernel.dto.PrpDvoucherConfigDto;

public interface PrpDvoucherConfigService {
    public PrpDvoucherConfigDto queryByPk(String comCode,String riskCode)throws Exception;

    public void save(PrpDvoucherConfigDto prpDvoucherConfigDto)throws Exception;

    public void update(PrpDvoucherConfigDto prpDvoucherConfigDto)throws Exception;

    public void delete(String comCode,String riskCode)throws Exception;

}
