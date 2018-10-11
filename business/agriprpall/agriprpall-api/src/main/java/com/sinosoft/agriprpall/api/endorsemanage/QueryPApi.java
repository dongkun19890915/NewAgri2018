package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 查询批单列表信息
 * @Author: 王保良
 * @Date: 2017/11/23 10:49
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = QueryPApi.PATH)
public interface QueryPApi {
    public static final String PATH="endorsemanage";

    /**
     *  根据批单号查询出相应的Blendorse中的P表大对象
     * @param endorseNo 批单号
     * @return BlendorseDto(查出来的是所有的P表对象)
     * @author 王保良
     * @throws  Exception
     * @date 2017年11月28日
     */
    @RequestMapping(value = "queryP",method = RequestMethod.POST)
    public BLEndorseDto queryP(@RequestParam(value = "endorseNo") String endorseNo) throws Exception;
}
