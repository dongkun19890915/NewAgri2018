package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.DeleteEndorseRequestDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = DeleteEndorseApi.PATH)
public interface DeleteEndorseApi {
    public static final String PATH = "deleteEndorse";

    /**
     * 批单批量删除（先校验批单号，然后再删除相关的表的数据）
     * @author: 宋振振
     * @date: 2017/11/24 15:16
     * @param deleteEndorseRequestDto 批单批量删除请求的Dto
     * @return HashMap 返回删除成功或失败的信息
     * @throws Exception
     */
    @RequestMapping(value = "deleteEndorse",method = RequestMethod.POST)
    public @ResponseBody HashMap deleteEndorse(@RequestBody DeleteEndorseRequestDto deleteEndorseRequestDto) throws Exception;

    /**
     * 批单批量删除校验（用查询批单列表的逻辑校验）
     * @author: 宋振振
     * @date: 2017/11/24 15:19
     * @param deleteEndorseRequestDto 批单批量删除请求的Dto
     * @return HashMap 批单号集合
     * @throws Exception
     */
    @RequestMapping(value = "getEndorseNoMap",method = RequestMethod.POST)
    public @ResponseBody HashMap getEndorseNoMap(@RequestBody DeleteEndorseRequestDto deleteEndorseRequestDto) throws Exception;
}
