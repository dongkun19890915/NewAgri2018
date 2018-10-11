package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.core.proposalmanage.service.ProposalnoInsurelistService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Description: 投保单号与清单关联Core接口
 * @Author: 钱浩
 * @Date: 9:00 2017/10/17
 */
@Service
public class ProposalnoInsurelistServiceImpl extends BaseServiceImpl implements ProposalnoInsurelistService {
   /** log日志 */
   private static final Logger LOGGER = LoggerFactory.getLogger(ProposalnoInsurelistServiceImpl.class);

   /**
    * @description:投保单号与预投保清单关联
    * @author: 钱浩
    * @date: 2017/11/4 10:06
    * @param proposalNo 投保单号
    * @param inusreListCode 预投保清单号
    */
   public void relatedInsuranceNo(String proposalNo,String inusreListCode)throws Exception {


   }
}