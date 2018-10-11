package com.sinosoft.agriprpall.core.image.service.impl;

import com.sinosoft.agriprpall.api.image.dto.SystemToImageRequsetDto;
import com.sinosoft.agriprpall.core.image.service.ImageDataService;
import com.sinosoft.dms.api.image.PrpDimageCodeApi;
import com.sinosoft.dms.api.image.dto.PrpDimageCodeDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘峰
 * @date 07/03/2018 4:24 PM
 */
@Service
public class ImageDataServiceImpl extends BaseServiceImpl implements ImageDataService {

    @Autowired
    private PrpDimageCodeApi prpDimageCodeApi;

    /**
     * 缓存机构
     */
    private final String COM_CODE = "00000000";
    /**
     * 操作员角色
     */
    private final String ROLE_CODE = "admin";

    /**
     * 生成请求报文
     *
     * @param systemToImageRequsetDto
     * @return
     * @throws Exception
     */
    @Override
    public String transportXML(SystemToImageRequsetDto systemToImageRequsetDto) throws Exception {
        if (systemToImageRequsetDto == null) {
            throw new DataVerifyException("入参不能为空");
        }
        if (StringUtils.isEmpty(systemToImageRequsetDto.getBusinessNo())) {
            throw new DataVerifyException("业务号不能为空");
        }
        if (StringUtils.isEmpty(systemToImageRequsetDto.getLoginComCode())) {
            throw new DataVerifyException("登录机构代码不能为空");
        }
        if (StringUtils.isEmpty(systemToImageRequsetDto.getLoginComName())) {
            throw new DataVerifyException("登录机构名称不能为空");
        }
        if (StringUtils.isEmpty(systemToImageRequsetDto.getLoginUserCode())) {
            throw new DataVerifyException("登录用户代码不能为空");
        }
        if (StringUtils.isEmpty(systemToImageRequsetDto.getLoginUserName())) {
            throw new DataVerifyException("登录用户姓名不能为空");
        }
        String businessNo = systemToImageRequsetDto.getBusinessNo();
        String riskCode = businessNo.substring(1, 5);
        Map<String, String> param = new HashMap<>(2);
        param.put("riskCode", riskCode);
        param.put("comCode", "0000000000");
        PrpDimageCodeDto prpDimageCodeDto = prpDimageCodeApi.queryByPK(param);
        String appCode = prpDimageCodeDto.getPrpallCode();
        String appName = prpDimageCodeDto.getPrpallName();
        StringBuilder returnXml = getReturnXml(systemToImageRequsetDto, appCode, appName);
        return returnXml.toString();
    }

    private StringBuilder getReturnXml(SystemToImageRequsetDto systemToImageRequsetDto, String appCode, String appName) {
        return new StringBuilder("<?xml version='1.0' encoding='UTF-8'?><root><BASE_DATA><USER_CODE>")
                .append(systemToImageRequsetDto.getLoginUserCode())
                .append("</USER_CODE><USER_NAME>")
                .append(systemToImageRequsetDto.getLoginUserName())
                .append("</USER_NAME><ORG_CODE>")
                .append(systemToImageRequsetDto.getLoginComCode())
                .append("</ORG_CODE><COM_CODE>")
                .append(COM_CODE)
                .append("</COM_CODE><ORG_NAME>")
                .append(systemToImageRequsetDto.getLoginComName())
                .append("</ORG_NAME><ROLE_CODE>")
                .append(ROLE_CODE)
                .append("</ROLE_CODE></BASE_DATA><META_DATA><BATCH><APP_CODE>")
                .append(appCode)
                .append("</APP_CODE><APP_NAME>")
                .append(appName)
                .append("</APP_NAME><BUSI_NO>")
                .append(systemToImageRequsetDto.getBusinessNo())
                .append("</BUSI_NO></BATCH></META_DATA></root>");
    }
}
