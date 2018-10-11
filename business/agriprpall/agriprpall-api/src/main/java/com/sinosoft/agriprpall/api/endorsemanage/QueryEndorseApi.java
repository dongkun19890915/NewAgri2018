package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestShowPrPoEnDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 批单信息查询服务
 * @author 王保良
 * @date 2017年11月28日
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = QueryEndorseApi.PATH)
public interface QueryEndorseApi {
    public static final String PATH="endorsemanage";

    /**
     * 批单查询 (根据业务类型BIZTYPE的不同进行不同的查询)
     * @param endorseNo 批单号
     * @return VecReturnDto(包含保单信息及批改前的信息)
     * @author 王保良 刘曼曼
     * @throws  Exception
     * @date 2017年11月28日
     */
    @RequestMapping(value = "queryEndorseInfo",method = RequestMethod.POST)
    public PolicyEndorseDto queryEndorseInfo(@RequestBody RequestShowPrPoEnDto requestShowPrPoEnDto) throws Exception;

}
