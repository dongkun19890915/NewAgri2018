package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPfeildDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPfeildDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCfeildDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCfeildService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PrpCfeild表服务接口实现类
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
@Service
public class PrpCfeildServiceImpl extends BaseServiceImpl implements PrpCfeildService {

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPfeildDto
     * @return PrpCfeildDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCfeildDto PEvaluateC(PrpPfeildDto prpPfeildDto) throws Exception {
        PrpCfeildDto prpCfeildDto=new PrpCfeildDto();
//        prpCfeildDto.setPolicyNo(prpPfeildDto.getPolicyNo());
//        //todo 传入proposalNo 从prpCPmain中
//        //prpCfeildDto.setProposalNo(prpPfeildDto.getProposalNo());
//        prpCfeildDto.setFeildNo(prpPfeildDto.getFeildNo());
//        prpCfeildDto.setFeildName(prpPfeildDto.getFeildName());
//        prpCfeildDto.setFeildArea(prpPfeildDto.getFeildArea());
//        prpCfeildDto.setRichflyCode(prpPfeildDto.getRichflyCode());
//        prpCfeildDto.setRichflyCName(prpPfeildDto.getRichflyCName());
        return prpCfeildDto;
    }

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPfeildDto
     * @return PrpCfeildDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCfeildDto generatePrpCfeild(PrpCPfeildDto prpCPfeildDto,String proposalNo) throws Exception {
        PrpCfeildDto prpCfeildDto=new PrpCfeildDto();
        prpCfeildDto.setPolicyNo(prpCPfeildDto.getPolicyNo());
        prpCfeildDto.setProposalNo(proposalNo);
        prpCfeildDto.setFeildNo(prpCPfeildDto.getFeildNo());
        prpCfeildDto.setFeildName(prpCPfeildDto.getFeildName());
        prpCfeildDto.setFeildArea(prpCPfeildDto.getFeildArea());
        prpCfeildDto.setRichflyCode(prpCPfeildDto.getRichflyCode());
        prpCfeildDto.setRichflyCName(prpCPfeildDto.getRichflyCName());
        prpCfeildDto.setOperationFlag(prpCPfeildDto.getOperationFlag());
        return prpCfeildDto;
    }
}
