package com.sinosoft.agriprpall.core.proposalmanage.service;

import com.sinosoft.agriprpall.api.proposalmanage.dto.ProposalSaveDto;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *  投保单保存service
 * @Author: 何伟东
 * @Date: 2017/10/26 14:53
 */
@Service
public interface ProposalSaveService {

    /**
     *  投保单保存方法
     * @author: 何伟东
     * @date: 2017/10/26 14:48
     * @param proposalSaveDto 投保单大对象
     * @return 投保单单号
     * @throws Exception
     */
    public String save(ProposalSaveDto proposalSaveDto)throws Exception;
}