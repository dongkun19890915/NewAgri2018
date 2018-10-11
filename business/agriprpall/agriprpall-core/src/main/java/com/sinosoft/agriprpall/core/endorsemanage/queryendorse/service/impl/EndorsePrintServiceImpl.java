package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.client.dto.RequestVisaStatusWriteBackDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPmainDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPtextDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPtext;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.EndorsePrintService;
import com.sinosoft.agriprpall.core.policymanage.service.VisaService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time 2017-10-23 06:09:14.757
 * @description 保险人关系表Core接口实现
 */
@Service
public class EndorsePrintServiceImpl extends BaseServiceImpl implements EndorsePrintService {

    @Autowired
    private PrpPheadDao prpPheadDao;

    @Autowired
    private PrpPtextDao prpPtextDao;

    @Autowired
    private PrpPmainDao prpPmainDao;

    @Autowired
    private VisaService visaService;

    /**
     * @param endorseNo 批单号
     * @param endorseNo
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：批单正本打印，全打
     * @author: 潘峰
     */
    @Override
    public PrpPheadDto endorsementPrint(String endorseNo) {

        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号不能为空！");
        }

        StringBuilder strEndorseText = new StringBuilder();
        List<PrpPtext> ptexts = prpPtextDao.findByEndorseNoOrderByLineNo(endorseNo);
        for (PrpPtext ptext : ptexts) {
            strEndorseText.append(ptext.getEndorseText());
        }
        PrpPhead prpPhead = prpPheadDao.findByEndorseNo(endorseNo);
        PrpPheadDto prpPheadDtos = convert(prpPhead, PrpPheadDto.class);
        prpPheadDtos.setEndorseTexts(strEndorseText.toString());
        return prpPheadDtos;

    }

    /**
     * 回写批单打印流水号服务
     *
     * @param requestVisaStatusWriteBackDtos - 包含业务号、归属及机构、流水号、单证类型
     * @return message 成功or失败
     * @author: 何伟东
     * @date: 2017/12/4 14:54
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String printNoWriteBack(List<RequestVisaStatusWriteBackDto> requestVisaStatusWriteBackDtos) {
        // 调用老系统回写单证状态
        String returnStatus = visaService.visaStatusWriteBack(requestVisaStatusWriteBackDtos);
        if ("1".equals(returnStatus)) {
            // 回写批单单证流水号
            for (RequestVisaStatusWriteBackDto requestVisaStatusWriteBackDto : requestVisaStatusWriteBackDtos) {
                int i = prpPmainDao.updatePrintNo(requestVisaStatusWriteBackDto.getBusinessNo(), requestVisaStatusWriteBackDto.getVisaSerialNo());
                if (i <= 0) {
                    throw new BusinessException("没有数据被修改");
                }
            }
        } else {
            throw new BusinessException("回写单证状态失败！");
        }
        return "成功";
    }


}
