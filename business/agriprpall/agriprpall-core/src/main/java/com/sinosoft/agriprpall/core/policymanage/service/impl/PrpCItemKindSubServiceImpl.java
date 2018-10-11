package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCitemKindDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKind;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCItemKindSubService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrpCItemKindSubServiceImpl extends BaseServiceImpl implements PrpCItemKindSubService {
    @Autowired
    private PrpCitemKindDao prpCitemKindDao;
    /**
    * @description
    * @param policyNo
    * @return java.util.List<com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto>
    * @throws
    * @author 李冬松
    * @date 14:12 2017/10/28
    */
    @Override
    public List<PrpCitemKindDto> findPrpCItemKindSubInfo(String policyNo) throws Exception {
        List<PrpCitemKind> prpCItemKindList= prpCitemKindDao.queryPrpCItemKindSubByCondition(policyNo);
        List<PrpCitemKindDto> prpCitemKindDtoList =new ArrayList<>();
        convertCollection(prpCItemKindList, prpCitemKindDtoList,PrpCitemKindDto.class);
        return prpCitemKindDtoList;
    }
}
