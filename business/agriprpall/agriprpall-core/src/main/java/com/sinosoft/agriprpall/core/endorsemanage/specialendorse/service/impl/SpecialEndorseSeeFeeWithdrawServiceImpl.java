package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;


import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.EndorseCancellationService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.PolicyCancellationService;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 见费出单保单注销
 * @author 王保良
 * @date 2017年11月10日
 */
@Service
public class SpecialEndorseSeeFeeWithdrawServiceImpl extends BaseServiceImpl{

    public static final Logger LOGGER= LoggerFactory.getLogger(SpecialEndorseSeeFeeWithdrawServiceImpl.class);

    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpPheadDao prpPheadDao;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PolicyCancellationService policyCancellationService;
    @Autowired
    private EndorseCancellationService endorseCancellationService;

    public void specialEndorseSeeFeeWithdraw(String businessNo) throws Exception{

        businessNo=businessNo.trim();
        String firstBusinessNo=businessNo.substring(0,1);
        //判断如果是保单号 保单号的位数是否正确
        if (firstBusinessNo=="2"){
            if (businessNo.length()!=21){
                throw new DataVerifyException("保单号:"+businessNo+"不正确,请传入正确的21位保单号");
            }
        }


        //判断如果是批单号 批单号的位数是否正确
        if (firstBusinessNo=="3"){
            if (businessNo.length()!=24){
                throw new DataVerifyException("批单号:"+businessNo+"不正确,请传入正确的24位批单号");
            }
        }
        //既不是保单号也不是批单号则错误
        if (!"2".equals(firstBusinessNo) && "3".equals(firstBusinessNo)) {
            throw new DataVerifyException("业务号:"+businessNo+"不存在,请传入正确的业务号");
        }

        //根据业务号查询保单主表
        String comCode="";
        PrpCmain prpCmain=prpCmainDao.findByPolicyNo(businessNo);
        PrpCmainDto prpCmainDto=convert(prpCmain,PrpCmainDto.class);

        //根据业务号查询批单头表
        PrpPhead prpPhead= prpPheadDao.findByEndorseNo(businessNo);
        PrpPheadDto prpPheadDto=convert(prpPhead,PrpPheadDto.class);

        //如果是保单号判断保单号是否是见费出单
        if ("2".equals(firstBusinessNo)){
            if (!"1".equals(prpCmainDto.getIsSeeFeeFlag())){
                throw new DataVerifyException("此险种不是见费出单险种,不能使用该功能");
            }
            comCode=prpCmainDto.getComCode();
        }
        //如果是批单号判断批单号是否是见费出单
        if ("3".equals(firstBusinessNo)){
            if (!"1".equals(prpPheadDto.getIsSeeFeeFlag())){
                throw new DataVerifyException("此险种不是见费出单险种,不能使用该功能");
            }
            comCode=prpPheadDto.getComCode();
        }





        String displayPolicyNo="注销的号码为:";
        String displayEndorNo="注销的批单号码为";
        List<PrpCmain> prpCmainList=new ArrayList<>();
        ResponseQueryPolicyInfoDto blPolicy=new ResponseQueryPolicyInfoDto();



        /** 定时任务调用或注销指定保单时，注销保单 */
        if (StringUtils.isNotEmpty(businessNo) || "2".equals(firstBusinessNo)) {
            if (!"34".equals(comCode.substring(0, 2)) || !"00".equals(comCode.substring(0, 2))) {
                String[] riskCodeList=prpDriskApi.queryByValidStatus();
                prpCmainList=prpCmainDao.findByCondition1(riskCodeList);
                if ("2".equals(firstBusinessNo)){
                    prpCmainList=prpCmainDao.findByCondition2(riskCodeList,businessNo);
                }
            }else {
                String[] riskCodeList=prpDriskApi.queryByValidStatusAndFlag();
                prpCmainList=prpCmainDao.findByCondition1(riskCodeList);
                if ("2".equals(firstBusinessNo)){
                    prpCmainList=prpCmainDao.findByCondition2(riskCodeList,businessNo);
                }
            }
        }
        for (int i=0;i<prpCmainList.size();i++){
            PrpCmain prpCmainSchema=prpCmainList.get(i);
            String policyNo=prpCmainSchema.getPolicyNo();

            /** 注销保单信息 */
            //todo 注销保单信息
            policyCancellationService.cancellation(blPolicy,policyNo);

            displayPolicyNo = displayPolicyNo+prpCmainDto.getPolicyNo();
        }




        /**注销批单信息 */
        List<PrpPhead> prpPheadList=new ArrayList<>();
        if (businessNo ==null || "3".equals(firstBusinessNo) || businessNo.length()==0){
            String[] riskCodeArray=prpDriskApi.queryByValidStatus();
            // 注销批单信息
            prpPheadList=prpPheadDao.findByCondition1(riskCodeArray);
            //如果业务号不为空，则系统将只注销输入的批单号，否则将注销所有过期30天的批单
            if ("3".equals(firstBusinessNo)){
                prpPheadList=prpPheadDao.findByCondition2(riskCodeArray,businessNo);
            }
        }
        BLEndorseDto blEndorseDto=new BLEndorseDto();
        for (int i=0;i<prpPheadList.size();i++){
            PrpPhead prpPheadSchema=prpPheadList.get(i);
            String endorseNo=prpPheadSchema.getEndorseNo();

            //todo blEndorse.cancellation() 注销批单数据
            endorseCancellationService.cancellation(blEndorseDto,endorseNo);


            displayEndorNo=displayEndorNo+prpPheadSchema.getEndorseNo();

        }



        /**保单注销提示信息 */
        if (prpCmainList.size()==0 && "2".equals(firstBusinessNo)){
            displayPolicyNo="保单号("+businessNo+")不存在或该保单不是无效保单";
            displayEndorNo="";
        }
        /** 批单提示信息  */
        if (prpPheadList.size()==0 && "3".equals(firstBusinessNo)){
            displayEndorNo="批单号("+businessNo+")不存在或该批单不是无效批单";
            displayPolicyNo="";
        }






        /**见费出单：车险和政策性农险,对于车险的单子不会带有大户信息，所以对于大户代码非空判断排除车险的单子和没有录入大户信息的政策性农险的单子*/
        /**对于批单的注销，没有涉及到保单状态的修改，所以批单注销不维护Gis平台保单状态。*/
        //todo 等着伟东写完,他表示还要两个星期

//        PrpCmain prpCmainSchema=null;
//        for (int i=0;i<prpCmainList.size();i++){
//            prpCmainSchema = prpCmainList.get(i);
//            if (!"".equals(prpCmainSchema.getRichflyCode()) && displayPolicyNo.indexOf("注销的号码为:")>-1) {
//            }
//        }

    }
}
