package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLMessageDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestPrpLMessageDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestSavePrpLMessageDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponsePrpLMessageDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLMessageDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLMessage;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLMessageKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLMessageService;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import ma.glasnost.orika.impl.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔流转讨论留言表Core接口实现
 */
@Service
public class PrpLMessageServiceImpl extends BaseServiceImpl implements PrpLMessageService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLMessageServiceImpl.class);
    
    @Autowired
    private PrpLMessageDao prpLMessageDao;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDcodeApi prpDcodeApi;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLMessageDto prpLMessageDto) {
        PrpLMessage prpLMessage = this.convert(prpLMessageDto, PrpLMessage.class);
        prpLMessageDao.save(prpLMessage);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,java.lang.Integer serialNo,java.lang.Integer lineNo) {
        PrpLMessageKey prpLMessageKey = new PrpLMessageKey(registNo,serialNo,lineNo);
        prpLMessageDao.delete(prpLMessageKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLMessageDto prpLMessageDto) {
        PrpLMessage prpLMessage = this.convert(prpLMessageDto, PrpLMessage.class);
        prpLMessageDao.save(prpLMessage);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLMessageDto queryByPK(String registNo,java.lang.Integer serialNo,java.lang.Integer lineNo) {
        PrpLMessageKey prpLMessageKey = new PrpLMessageKey(registNo,serialNo,lineNo);
        PrpLMessage prpLMessage = prpLMessageDao.findOne(prpLMessageKey);
        return this.convert(prpLMessage,PrpLMessageDto.class);
    }

    /**
     * （查看理赔沟通页面信息）
     * @param requestPrpLMessageDto 查询理赔沟通页面所需条件
     * @return 理赔沟通页面显示信息
     * @author: 董坤
     * @date: 2017/11/15 19:56
     */
    @Override
    public ResponsePrpLMessageDto queryClaimCommunicationByCondition(RequestPrpLMessageDto requestPrpLMessageDto) {
        if(StringUtils.isEmpty(requestPrpLMessageDto.getRegistNo())){
            throw new DataVerifyException("报案号不能为空！");
        }
        if(StringUtils.isEmpty(requestPrpLMessageDto.getPolicyNo())){
            throw new DataVerifyException("保单号不能为空！");
        }
//        if(StringUtils.isEmpty(requestPrpLMessageDto.getClaimNo())){
//            throw new DataVerifyException("立案号不能为空！");
//        }
        if(StringUtils.isEmpty(requestPrpLMessageDto.getRiskCode())){
            throw new DataVerifyException("险种代码不能为空！");
        }
        if(StringUtils.isEmpty(requestPrpLMessageDto.getNodeType())){
            throw new DataVerifyException("节点类型不能为空！");
        }
        if(StringUtils.isEmpty(requestPrpLMessageDto.getOperatorCode())){
            throw new DataVerifyException("操作员代码不能为空！");
        }
        if(requestPrpLMessageDto.getInputDate() ==null){
            throw new DataVerifyException("输单日期不能为空！");
        }
        //将代码转成文字
        if(StringUtils.isNotEmpty(requestPrpLMessageDto.getNodeType())){
            String NodeTypeName = prpDcodeApi.translateCodeByPK("CommunicatNodeType",requestPrpLMessageDto.getNodeType());
            requestPrpLMessageDto.setNodeTypeName(NodeTypeName);
        }

        if(StringUtils.isEmpty(requestPrpLMessageDto.getOperatorName())){
            String userName= prpDuserApi.translateCodeByPK(requestPrpLMessageDto.getOperatorCode());
            requestPrpLMessageDto.setOperatorName(userName);
        }
        requestPrpLMessageDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));

        ResponsePrpLMessageDto responsePrpLMessageDto = new ResponsePrpLMessageDto();
        List<PrpLMessage> prpLMessageList = prpLMessageDao.findByRegistNo(requestPrpLMessageDto.getRegistNo());
        List<PrpLMessageDto> prpLMessageDtoList = new ArrayList<>();
        //存入留言区信息
        PrpLMessageDto prpLMessageDto = new PrpLMessageDto();
        for (PrpLMessage prpLMessage : prpLMessageList) {
            prpLMessageDto = this.convert(prpLMessage,PrpLMessageDto.class);
            prpLMessageDto.setNodeType(prpDcodeApi.translateCodeByPK("CommunicatNodeType",prpLMessage.getNodeType()));
            prpLMessageDtoList.add(prpLMessageDto);
        }
        responsePrpLMessageDto.setPrpLMessageDtoList(prpLMessageDtoList);
        //存入上部分信息
        responsePrpLMessageDto.setClaimNo(requestPrpLMessageDto.getClaimNo());
        responsePrpLMessageDto.setPolicyNo(requestPrpLMessageDto.getPolicyNo());
        responsePrpLMessageDto.setRegistNo(requestPrpLMessageDto.getRegistNo());
        responsePrpLMessageDto.setInputDate(requestPrpLMessageDto.getInputDate());
        responsePrpLMessageDto.setNodeType(requestPrpLMessageDto.getNodeType());
        responsePrpLMessageDto.setNodeTypeName(requestPrpLMessageDto.getNodeTypeName());
        responsePrpLMessageDto.setOperatorCode(requestPrpLMessageDto.getOperatorCode());
        responsePrpLMessageDto.setOperatorName(requestPrpLMessageDto.getOperatorName());
        responsePrpLMessageDto.setRiskCode(requestPrpLMessageDto.getRiskCode());
        responsePrpLMessageDto.setOperatorName(requestPrpLMessageDto.getOperatorName());
        return responsePrpLMessageDto;
    }

    /**
     * （保存理赔沟通页面信息）
     * @param requestSavePrpLMessageDto 理赔沟通保存的页面信息
     * @return 保存成功与否信息
     * @author: 董坤
     * @date: 2017/11/15 21:11
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveClaimCommunicationInfo(RequestSavePrpLMessageDto requestSavePrpLMessageDto) throws Exception{
        if(StringUtils.isEmpty(requestSavePrpLMessageDto.getRegistNo())){
            throw new DataVerifyException("报案号不能为空！");
        }
        if(StringUtils.isEmpty(requestSavePrpLMessageDto.getPolicyNo())){
            throw new DataVerifyException("保单号不能为空！");
        }
//        if(StringUtils.isEmpty(requestSavePrpLMessageDto.getClaimNo())){
//            throw new DataVerifyException("立案号不能为空！");
//        }
        if(StringUtils.isEmpty(requestSavePrpLMessageDto.getRiskCode())){
            throw new DataVerifyException("险种代码不能为空！");
        }
        if(StringUtils.isEmpty(requestSavePrpLMessageDto.getNodeType())){
            throw new DataVerifyException("节点类型不能为空！");
        }
        if(StringUtils.isEmpty(requestSavePrpLMessageDto.getNodeTypeName())){
            throw new DataVerifyException("节点类型名称不能为空！");
        }
        if(StringUtils.isEmpty(requestSavePrpLMessageDto.getOperatorCode())){
            throw new DataVerifyException("操作员代码不能为空！");
        }
        if(StringUtils.isEmpty(requestSavePrpLMessageDto.getOperatorName())){
            throw new DataVerifyException("操作员名称不能为空！");
        }
        if(requestSavePrpLMessageDto.getInputDate() ==null){
            throw new DataVerifyException("输单日期不能为空！");
        }
        if(requestSavePrpLMessageDto.getContext() ==null){
            throw new DataVerifyException("记录信息不能为空！");
        }
        String message = "保存成功";
        PrpLMessage prpLMessage = convert(requestSavePrpLMessageDto,PrpLMessage.class);
        Integer serialNo = prpLMessageDao.findMaxSerialNoByRegistNo(requestSavePrpLMessageDto.getRegistNo())+1;//序号
        if(serialNo == null){
            serialNo = 1;
        }
        prpLMessage.setSerialNo(serialNo);
        prpLMessage.setLineNo(1);
        prpLMessage.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
        prpLMessageDao.save(prpLMessage);
        return message;
    }
    /**
     * 查询留言列表
     * @author: 孙朋飞
     * @date: 2018/4/3 9:30
     * @param registNo 报案号
     * @return 各节点留言
     * @throws Exception
     */
    @Override
    public List<PrpLMessageDto> queryPrpLMessageByRegistNo(String registNo) throws Exception {
        if(StringUtils.isEmpty(registNo)){
            throw new DataVerifyException("报案号不能为空！");
        }
        //根据报案号查询各节点留言
        List<PrpLMessage> prpLMessageList = prpLMessageDao.findPrpLMessageByRegistNo(registNo);
        List<PrpLMessageDto> prpLMessageDtoList=new ArrayList<>();
        convertCollection(prpLMessageList,prpLMessageDtoList,PrpLMessageDto.class);
        if(prpLMessageDtoList!=null&&prpLMessageDtoList.size()>0){
            //节点类型转化为中文
            for (PrpLMessageDto prpLMessageDto : prpLMessageDtoList) {
                String nodeType = prpDcodeApi.translateCodeByPK("CommunicatNodeType", prpLMessageDto.getNodeType());
                prpLMessageDto.setNodeType(nodeType);
            }
        }
        return prpLMessageDtoList;
    }

}