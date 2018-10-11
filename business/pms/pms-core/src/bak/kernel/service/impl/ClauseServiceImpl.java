package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.kernel.dto.ClauseQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDClauseDto;
import com.sinosoft.pms.core.kernel.dao.PrpDClauseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDClause;
import com.sinosoft.pms.core.kernel.entity.PrpDClauseKey;
import com.sinosoft.pms.core.kernel.service.ClauseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClauseServiceImpl extends BaseServiceImpl implements ClauseService {
    private static Log LOGGER = LogFactory.getLog(ClauseServiceImpl.class);
    
    @Autowired
    PrpDClauseDao prpDClauseDao;
    
    /**
     * @description 根据条款代码获取条款相关信息
     * @param conditionDto
     * @return PrpDRiskDto
     * @author yinqingzhu
     * @date 2016年10月13日上午9:19:41
     */
    @Override
    public PrpDClauseDto getClause(ClauseQueryConditionDto conditionDto){
        PrpDClauseDto clauseReturnDto = new PrpDClauseDto();
        PrpDClauseKey key = new PrpDClauseKey();
        String clauseCode = conditionDto.getClauseCode();
        if(clauseCode!=null){
            key.setClauseCode(clauseCode);
            PrpDClause clauseInfo = prpDClauseDao.findOne(key);
            if(clauseInfo!=null){
                clauseReturnDto = this.convert(clauseInfo,PrpDClauseDto.class);
                clauseReturnDto.setResultCode("Y");
                clauseReturnDto.setResultMsg("查询成功，数据已返回");
            }else{
                //查询不到数据，返回resultCode
                clauseReturnDto.setResultCode("N");
                clauseReturnDto.setResultMsg("没有符合查询条件的数据");
            }
        }else{
            clauseReturnDto.setResultCode("N");
            clauseReturnDto.setResultMsg("查询条件为空");
        }
        return clauseReturnDto;
    }
}
