package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdcEndorChgDetailDto;

import java.util.List;

public interface HerdcEndorChgDetailService {
    /**
     * 批改保存前删除
     * @param insureListCode 标的清单号
     * @return void
     * @throws
     * @author 李冬松
     * @date 17:54 2018/4/12
     */
    public void removeByInsureListCode(String insureListCode)throws Exception;
    public void save(List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList)throws Exception;
    public List<HerdcEndorChgDetailDto> queryByInsureListCode(String insureListCode)throws Exception;
}
