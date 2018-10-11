package com.sinosoft.dms.core.model.service;

import com.sinosoft.dms.api.model.dto.PrpModelCoinsDetailDto;

public interface PrpModelCoinsDetailService {

    public PrpModelCoinsDetailDto queryByPk(String modelCode,Integer serialNo,String currency)throws Exception;

    public void save(PrpModelCoinsDetailDto prpModelCoinsDetailDto)throws Exception;

    public void update(PrpModelCoinsDetailDto prpModelCoinsDetailDto)throws Exception;

    public void delete(String modelCode,Integer serialNo,String currency) throws Exception;
}
