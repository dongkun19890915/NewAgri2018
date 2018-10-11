package com.sinosoft.agriprpall.web.image;

import com.sinosoft.agriprpall.api.image.ImageDataApi;
import com.sinosoft.agriprpall.api.image.dto.SystemToImageRequsetDto;
import com.sinosoft.agriprpall.core.image.service.ImageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘峰
 * @date 07/03/2018 4:06 PM
 */
@RestController
@RequestMapping(value = ImageDataApi.PATH)
public class ImageDataController implements ImageDataApi {

    @Autowired
    private ImageDataService imageDataService;


    /**
     * 生成请求报文
     *
     * @param systemToImageRequsetDto
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> transportXML(@RequestBody SystemToImageRequsetDto systemToImageRequsetDto) throws Exception {
        Map<String, String> returnMap = new HashMap<>(1);
        String requestXml = imageDataService.transportXML(systemToImageRequsetDto);
        returnMap.put("requestXml", requestXml);
        return returnMap;
    }
}
