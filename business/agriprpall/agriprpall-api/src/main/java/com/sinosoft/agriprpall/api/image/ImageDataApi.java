package com.sinosoft.agriprpall.api.image;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.image.dto.SystemToImageRequsetDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author 潘峰
 * @date 07/03/2018 3:35 PM
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = ImageDataApi.PATH)
public interface ImageDataApi {

    String PATH = "imageData";


    /**
     * 生成请求报文
     *
     * @param systemToImageRequsetDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findImageData", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, String> transportXML(@RequestBody SystemToImageRequsetDto systemToImageRequsetDto) throws Exception;

}
