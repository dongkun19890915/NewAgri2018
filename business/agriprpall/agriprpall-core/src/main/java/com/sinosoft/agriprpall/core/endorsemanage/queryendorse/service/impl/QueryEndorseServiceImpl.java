package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTengageDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPengage;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPheadKey;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.*;
import com.sinosoft.agriprpall.core.policymanage.service.EvaluateFromCpToCService;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyQueryService;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 批单明细信息查询服务
 * @author 王保良
 * @date 2017年11月28日
 */
@Service
public class QueryEndorseServiceImpl implements QueryEndorseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryEndorseServiceImpl.class);


    @Autowired
    private PrpPheadDao prpPheadDao;
    @Autowired
    private PolicyQueryService policyQueryService;
    @Autowired
    private QueryPService queryPService;
    @Autowired
    private SettleService settleService;
    @Autowired
    private BackWardService backWardService;
    @Autowired
    private QueryCPservice queryCPservice;
    @Autowired
    private EvaluateFromCpToCService evaluateFromCpToCService;

    /**
     * 寻找所查询批单保单信息及批改前的信息(供下面的queryEndorseDetail方法调用)
     * @param endorseNo 批单号
     * @return PolicyEndorseDto(包含保单信息及批改前的信息)
     * @author 王保良
     * @throws  Exception
     * @date 2017年11月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PolicyEndorseDto queryEndorseInfo(String endorseNo) throws Exception {
        ResponseQueryPolicyInfoDto blPolicyDto = new ResponseQueryPolicyInfoDto();

        PrpPheadKey prpPheadKey=new PrpPheadKey(endorseNo);
        PrpPhead prpPhead=prpPheadDao.findOne(prpPheadKey);

        //获取保单号
        String policyNo=prpPhead.getPolicyNo();
        //获取批单号
        String pEndorseNo=prpPhead.getEndorseNo();
        //获取批改日期
        Date endorDate=prpPhead.getEndorDate();



        //获取当前保单的最新数据
        blPolicyDto=policyQueryService.queryPolicyInfoByPolicyNo(policyNo,null,null,null);



        //根据保单号 批单号 批改日期 查询phead集合 返回的是所查询的批单phead以及之后的所有批单头phead
        //比如-01 -02 -03 -04 去查询 -02 会返回 -02 -03 -04的phead集合
        List<PrpPhead> prpPheadList=prpPheadDao.findByCondition(policyNo,pEndorseNo,endorDate);

        /** 如果已经是最后的一期批单了*/
        if (prpPheadList.size()==1){
            //如果已经是最后一个批单了

            //根据这个批单号查询出批单大对象
            BLEndorseDto blEndorseDto=queryPService.queryP(endorseNo);

            //p表标志置c表处理
            settleService.settle(blEndorseDto,blPolicyDto);
            PolicyEndorseDto policyEndorseDto=new PolicyEndorseDto();
            policyEndorseDto.setBlEndorseDto(blEndorseDto);
            policyEndorseDto.setBlPolicyInfoDtoNew(blPolicyDto);//放入保单大对象
            return policyEndorseDto;
        }



        // 保单后还有批单，保单（批改后新数据）对应的批单（批改前旧数据）不是最新的批单
        // 重新获取批单号
        for (int i=0;i<prpPheadList.size();i++){
            PrpPhead prpPheadSchema=prpPheadList.get(i);
            // 回倒批单 backWard blPolicyDto保单号是查出来的保单大对象
            // 比如我查总共7次批单 那么此时的保单大对象是第6期后的保单大对象
            // 而后面的批单号是第7次的批单大对象
            // 即可以看成是一个核批后的情况,用核批后的保单大对象和当期的批单大对象比较
            // 这里将当期循环的批单大对象放入到blPolicyDto中
            backWardService.backWard(prpPheadSchema.getEndorseNo(),blPolicyDto);

            if (i == prpPheadList.size()-2){
                endorseNo=prpPheadList.get(i+1).getEndorseNo();
                break;
            }
        }
        BLEndorseDto blEndorseDto=queryPService.queryP(endorseNo);
        settleService.settle(blEndorseDto,blPolicyDto);
        PolicyEndorseDto policyEndorseDto=new PolicyEndorseDto();
        policyEndorseDto.setBlEndorseDto(blEndorseDto);
        policyEndorseDto.setBlPolicyInfoDtoNew(blPolicyDto);
        return policyEndorseDto;
    }




    /**
     * 根据业务类型BizType寻找所查询批单保单信息及批改前的信息
     * @param requestShowPrPoEnDto (包含BizNo业务号,BizType业务类型,familyNo 分户号,damageDate 出险日期)
     * @return PolicyEndorseDto(包含保单信息及批改前的信息)
     * @author 王保良
     * @throws  Exception
     * @date 2017年11月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PolicyEndorseDto queryEndorseDetail(RequestShowPrPoEnDto requestShowPrPoEnDto) throws Exception {
        String endorseNo=requestShowPrPoEnDto.getBizNo();

        /** 这两个对象分该批单是核批前还是核批后的情况返回一个*/
        //批单核批后的保单对象
        ResponseQueryPolicyInfoDto blPolicyDto=new ResponseQueryPolicyInfoDto();
        //批单核批前的保单对象
        ResponseQueryPolicyInfoDto blPolicyDtoOld=new ResponseQueryPolicyInfoDto();
        /** */

        //批单大对象
        BLEndorseDto blEndorseDto=new BLEndorseDto();

        //批单头对象
        PrpPheadDto prpPheadDto=new PrpPheadDto();

        //用来装载保单和批单对象
        PolicyEndorseDto policyEndorseDto=new PolicyEndorseDto();

        PrpPheadKey prpPheadKey=new PrpPheadKey(endorseNo);
        PrpPhead prpPhead=prpPheadDao.findOne(prpPheadKey);

        if (prpPhead==null){
            throw new DataVerifyException("该业务号没有批单头信息");
        }



        /**这是核心的方法*/
        policyEndorseDto=this.queryEndorseInfo(endorseNo);



        /** 获取保单对象 **/
        blPolicyDto=policyEndorseDto.getBlPolicyInfoDtoNew();
        /** 获取批单对象 **/
        blEndorseDto=policyEndorseDto.getBlEndorseDto();


        /** 去查询这个批单是核批前还是核批后 根据情况的不同(已经核批,返回保单对象/未核批 返回的是cp表对象) */
        List<PrpPhead> prpPheadList=prpPheadDao.findAllByCondition(endorseNo);
        /** 1.这是未核批通过的情况下  该批单号肯定已经是最近的一期了*/
        if (prpPheadList.size()>0){
            CPpolicyDto cPpolicyDto=new CPpolicyDto();
            cPpolicyDto=queryCPservice.queryCPolicyInfo(prpPheadList.get(0).getPolicyNo());
            evaluateFromCpToCService.evaluateFromCpToC(blPolicyDtoOld,cPpolicyDto,blEndorseDto);
            settleService.settle(blEndorseDto,blPolicyDtoOld);
            // 特别约定信息PP
            List<QueryProposalPrpTengageDto> prpTengageDtoList = new ArrayList<>();
            QueryProposalPrpTengageDto prpTengageDto = null;
            for (PrpCengageDto prpCengageDto : blPolicyDtoOld.getPrpCengageDtoList()) {
                if (prpTengageDto == null || !prpCengageDto.getClauseCode().equals(prpTengageDto.getClauseCode())) {
                    prpTengageDto = new QueryProposalPrpTengageDto();
                    prpTengageDto.setClauseCode(prpCengageDto.getClauseCode());
                    prpTengageDto.setSerialNo(prpCengageDto.getSerialNo());
                    prpTengageDto.setFlag(prpCengageDto.getFlag());
                    prpTengageDtoList.add(prpTengageDto);
                }
                // 条款标题名称
                if ("0".equals(prpCengageDto.getTitleFlag())) {
                    prpTengageDto.setClauseName(prpCengageDto.getClauses());
                } else {
                    if (StringUtils.isEmpty(prpTengageDto.getClausesContent())) {
                        prpTengageDto.setClausesContent(prpCengageDto.getClauses());
                    } else {
                        prpTengageDto.setClausesContent(prpTengageDto.getClausesContent() + prpCengageDto.getClauses());
                    }
                }
            }
            blPolicyDtoOld.setQueryProposalPrpTengageDtoList(prpTengageDtoList);
            policyEndorseDto.setBlPolicyInfoDtoNew(blPolicyDtoOld);
        }
        /** 这是核批通过的 */
        else {
            policyEndorseDto.setBlPolicyInfoDtoNew(blPolicyDto);
        }
        policyEndorseDto.setBlEndorseDto(blEndorseDto);
        return policyEndorseDto;
    }

}
