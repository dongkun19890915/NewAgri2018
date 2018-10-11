package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.client.dto.RequestVisaStatusWriteBackDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;

import java.util.List;

/**
 * @author 潘峰
 * @time 2017-10-25 06:09:14.757
 * @description 批单正本打印接口
 */
public interface EndorsePrintService {


    /**
     * @param endorseNo 批单号
     * @param endorseNo
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：批单正本打印，全打
     * @author: 潘峰
     */
    public PrpPheadDto endorsementPrint(String endorseNo);

    /**
     * 回写批单打印流水号服务
     * @author: 何伟东
     * @date: 2017/12/4 14:54
     * @param requestVisaStatusWriteBackDtos - 包含业务号、归属及机构、流水号、单证类型
     * @return message 成功or失败
     */
    public String printNoWriteBack(List<RequestVisaStatusWriteBackDto> requestVisaStatusWriteBackDtos);

}
