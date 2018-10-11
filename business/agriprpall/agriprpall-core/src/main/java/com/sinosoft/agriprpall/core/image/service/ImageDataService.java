package com.sinosoft.agriprpall.core.image.service;

import com.sinosoft.agriprpall.api.image.dto.SystemToImageRequsetDto;

import java.util.Map;

/**
 * @author 潘峰
 * @date 07/03/2018 4:23 PM
 */
public interface ImageDataService {
    /**
     * 生成请求报文
     *
     * @param systemToImageRequsetDto
     * @return
     * @throws Exception
     */
    String transportXML(SystemToImageRequsetDto systemToImageRequsetDto) throws Exception;

}
