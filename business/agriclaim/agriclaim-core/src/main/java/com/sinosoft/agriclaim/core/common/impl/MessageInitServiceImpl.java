package com.sinosoft.agriclaim.core.common.impl;

import com.sinosoft.agriclaim.api.common.dto.MessageInitDto;
import com.sinosoft.agriclaim.api.common.dto.MessageInitRequestDto;
import com.sinosoft.agriclaim.core.common.MessageInitService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriprpall.api.policymanage.PrpCinsuredApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCinsuredDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MessageInitServiceImpl extends BaseServiceImpl implements MessageInitService{
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
    private PrpLRegistDao prpLRegistDao;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpCinsuredApi prpCinsuredApi;

    @Override
    public MessageInitDto messageInit(MessageInitRequestDto messageInitRequestDto) throws Exception {

        List<String> list=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String policyNo = messageInitRequestDto.getPolicyNo();
        String registNo = messageInitRequestDto.getRegistNo();
        PrpLRegist prpLRegist= prpLRegistDao.findByRegistNo(registNo);
        //被保险人代码
        String insuredCode = prpLRegist.getInsuredCode();
        //被保险人姓名
        String insuredName = prpLRegist.getInsuredName();
        //报案人
        String reportorName = prpLRegist.getReportorName();
        //出险时间 以及 出险时间的转换
        Date damageStartDate = prpLRegist.getDamageStartDate();
        String damageDate = sdf.format(damageStartDate);
        //出险地点
        String damageAddress = prpLRegist.getDamageAddress();
        //查勘定损人员
        String handlerName = messageInitRequestDto.getHandlerName();
        //查勘定损人员手机号码
        String handlerPhoneNumber = "";
        if (StringUtils.isNotEmpty(messageInitRequestDto.getHandlerCode())) {
            PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(messageInitRequestDto.getHandlerCode());
            handlerPhoneNumber = prpDuserDto.getMobile();
            if (StringUtils.isEmpty(handlerPhoneNumber)){
                handlerPhoneNumber="(未查询到该人员的手机号码)";
            }
        }
        //报案人手机号码
        String reportPhoneNumber = prpLRegist.getPhoneNumber();
        //被保险人手机号码
        String insuredPhoneNumber = "";
        Map<String,String> map = new HashMap<>();
        map.put("insuredCode",insuredCode);
        List<PrpCinsuredDto> prpCinsuredDtoList=prpCinsuredApi.queryByInsuredCode(map);
        if (prpCinsuredDtoList.size()!=0){
            insuredPhoneNumber = prpCinsuredDtoList.get(0).getPhoneNumber();
        }

        /** 组装查勘人员短信内容*/
        StringBuilder handlerMessage = new StringBuilder("你好，");
        handlerMessage.append(policyNo+"保单于:");
        handlerMessage.append(damageDate.substring(0,4)+"年");
        handlerMessage.append(damageDate.substring(5,7)+"月");
        handlerMessage.append(damageDate.substring(8,10)+"日");
        handlerMessage.append(damageDate.substring(11,13)+"时");
        handlerMessage.append(damageDate.substring(14,16)+"分");
        handlerMessage.append("在 ");
        handlerMessage.append(damageAddress+" 出险 ,报案号为");
        handlerMessage.append(registNo+" ,报案人为");
        handlerMessage.append(reportorName+" ,手机号码为");
        handlerMessage.append(reportPhoneNumber+" ,被保险人为");
        handlerMessage.append(insuredName+" ,手机号码为");
        handlerMessage.append(insuredPhoneNumber+" ,烦请知晓并及时进行查勘，谢谢！【国元保险】");
        String handlerMessages = handlerMessage.toString();

        /** 组装报案人员短信内容*/
        StringBuilder reportMessage = new StringBuilder("客户你好,保单");
        reportMessage.append(policyNo+"的报案已受理 ,报案号为");
        reportMessage.append(registNo+"出险时间为 ");
        reportMessage.append(damageDate.substring(0,4)+"年");
        reportMessage.append(damageDate.substring(5,7)+"月");
        reportMessage.append(damageDate.substring(8,10)+"日");
        reportMessage.append(damageDate.substring(11,13)+"时");
        reportMessage.append(damageDate.substring(14,16)+"分,出险地点为");
        reportMessage.append(damageAddress+" ,查勘人员为");
        reportMessage.append(handlerName+" ,手机号码为");
        reportMessage.append(handlerPhoneNumber+"，如有疑问请致电4009696999/96999（安徽省内）。【国元保险】");
        String reportMessages = reportMessage.toString();

        /** 组装被保险人短信内容*/
        StringBuilder insuredMessage = new StringBuilder("客户你好,保单");
        insuredMessage.append(policyNo+"的报案已受理,报案号为");
        insuredMessage.append(registNo+" ,出险时间为");
        insuredMessage.append(damageDate.substring(0,4)+"年");
        insuredMessage.append(damageDate.substring(5,7)+"月");
        insuredMessage.append(damageDate.substring(8,10)+"日");
        insuredMessage.append(damageDate.substring(11,13)+"时");
        insuredMessage.append(damageDate.substring(14,16)+"分 ,出险地点为"+damageAddress);
        if(handlerName!=null) {
            insuredMessage.append(" ,查勘人员为" + handlerName);
            insuredMessage.append(" ,手机号码为" + handlerPhoneNumber);
        }
        insuredMessage.append(" ,如有疑问请致电4009696999/96999（安徽省内）。【国元保险】");
        String insuredMessages = insuredMessage.toString();

        list.add(handlerMessages);
        list.add(reportMessages);
        list.add(insuredMessages);
        MessageInitDto messageInitDto=new MessageInitDto();
        messageInitDto.setMessage(list);

        messageInitDto.setHandlerName(messageInitRequestDto.getHandlerName());
        messageInitDto.setHandlerPhoneNumber(handlerPhoneNumber);
        messageInitDto.setReportorName(reportorName);
        messageInitDto.setReportorPhoneNumber(reportPhoneNumber);
        messageInitDto.setInsuredName(insuredName);
        messageInitDto.setInsuredPhoneNumber(insuredPhoneNumber);
        return messageInitDto;
    }
}
