package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;

/**
 * p表查询服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
public interface QueryPService {
    /**
     *  根据批单号查询出相应的Blendorse中的P表大对象
     * @param endorseNo 批单号
     * @return BlendorseDto(查出来的是所有的P表对象)
     * @author 王保良
     * @throws  Exception
     * @date 2017年11月28日
     */
    public BLEndorseDto queryP(String endorseNo) throws Exception;
}
