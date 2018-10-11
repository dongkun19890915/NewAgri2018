package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCrenewalDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCrenewalDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCrenewal;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCrenewalService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrpCrenewalServiceImpl extends BaseServiceImpl implements PrpCrenewalService {

    @Autowired
    private PrpCrenewalDao prpCrenewalDao;


    @Override
    public List<PrpCrenewalDto> queryByPolicyNo(String policyNo) throws Exception {
        List<PrpCrenewal> prpCrenewalList=prpCrenewalDao.findPrpCrenewalByPolicyNo(policyNo);
        List<PrpCrenewalDto> prpCrenewalDtoList=new ArrayList<>();
        convertCollection(prpCrenewalList,prpCrenewalDtoList,PrpCrenewalDto.class);
        return prpCrenewalDtoList;
    }

    @Override
    public List<PrpCrenewalDto> queryByOldPolicyNo(String policyNo, String oldPolicyNo) throws Exception {
        List<PrpCrenewal> prpCrenewalList=prpCrenewalDao.findByPolicyNoAndOldPolicyNo(policyNo,oldPolicyNo);
        List<PrpCrenewalDto> prpCrenewalDtoList=new ArrayList<>();
        convertCollection(prpCrenewalList,prpCrenewalDtoList,PrpCrenewalDto.class);
        return prpCrenewalDtoList;
    }
}
