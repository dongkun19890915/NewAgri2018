package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPengageDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCengageDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCengage;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCengageKey;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCengageService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * PrpCengageService表服务接口实现类
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
@Service
public class PrpCengageServiceImpl extends BaseServiceImpl implements PrpCengageService {

    @Autowired
    private PrpCengageDao prpCengageDao;
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPengageDto
     * @return PrpCengage
     * @throws Exception
     */
    @Override
    public PrpCengageDto PEvaluateC(PrpPengageDto prpPengageDto) throws Exception {
        PrpCengageDto prpCengageDto=new PrpCengageDto();
        prpCengageDto.setPolicyNo(prpPengageDto.getPolicyNo()) ;
        prpCengageDto.setRiskCode(prpPengageDto.getRiskCode());
        prpCengageDto.setSerialNo(prpPengageDto.getSerialNo());
        prpCengageDto.setLineNo(prpPengageDto.getLineNo());
        prpCengageDto.setClauseCode(prpPengageDto.getClauseCode());
        prpCengageDto.setClauses(prpPengageDto.getClauses());
        prpCengageDto.setTitleFlag(prpPengageDto.getTitleFlag());
        prpCengageDto.setFlag(prpPengageDto.getFlag());

        return prpCengageDto;
    }

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPengageDto
     * @return PrPCengageDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCengageDto generatePrpCengage(PrpCPengageDto prpCPengageDto) throws Exception {
        PrpCengageDto prpCengageDto=new PrpCengageDto();
        prpCengageDto.setPolicyNo(prpCPengageDto.getPolicyNo());
        prpCengageDto.setRiskCode(prpCPengageDto.getRiskCode());
        prpCengageDto.setSerialNo(prpCPengageDto.getSerialNo());
        prpCengageDto.setLineNo(prpCPengageDto.getLineNo());
        prpCengageDto.setClauseCode(prpCPengageDto.getClauseCode());
        prpCengageDto.setClauses(prpCPengageDto.getClauses());
        prpCengageDto.setTitleFlag(prpCPengageDto.getTitleFlag());
        prpCengageDto.setFlag(prpCPengageDto.getFlag());
        return prpCengageDto;
    }

    /**
     *@description 新增
     *@param
     */
    public void save(PrpCengageDto prpCEngageDto) {
        PrpCengage prpCEngage = this.convert(prpCEngageDto, PrpCengage.class);
        prpCengageDao.save(prpCEngage);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String policyNo,java.lang.Integer serialNo,java.lang.Integer lineNo) {
        PrpCengageKey prpCEngageKey = new PrpCengageKey(policyNo,serialNo,lineNo);
        prpCengageDao.delete(prpCEngageKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpCengageDto prpCEngageDto) {
        PrpCengage prpCEngage = this.convert(prpCEngageDto, PrpCengage.class);
        prpCengageDao.save(prpCEngage);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpCengageDto queryByPK(String policyNo,java.lang.Integer serialNo,java.lang.Integer lineNo) {
        PrpCengageKey prpCEngageKey = new PrpCengageKey(policyNo,serialNo,lineNo);
        PrpCengage prpCEngage = prpCengageDao.findOne(prpCEngageKey);
        return this.convert(prpCEngage,PrpCengageDto.class);
    }

    /**
     * @description: （保单抄件通过保单号查找特别约定）
     * @author: 王志文
     * @date: 2017/11/16 8:51
     * @param policyNo
     * @return
     */
    @Override
    public List<PrpCengageDto> queryEngageByPolicyNo(String policyNo) {
        List<PrpCengage> prpCEngages = prpCengageDao.queryEngageListByPolicyNo(policyNo);
        List<PrpCengageDto> prpCEngageDtos = new ArrayList<PrpCengageDto>();
        for (PrpCengage prpCEngage: prpCEngages
                ) {
            prpCEngageDtos.add(this.convert(prpCEngage,PrpCengageDto.class));
        }
        return prpCEngageDtos;
    }
    /**
     * 根据保单号，编码查询免赔率
     * @author: 田健
     * @date: 2018/4/13 12:32
     * @param policyNo 保单号
     * @param clauseCode 免赔率编码
     * @return 免赔率
     */
    @Override
   public String queryClausesByPolicyNo (String policyNo,String clauseCode){
        String deductibleRate ="" ;
        List<PrpCengage> prpCengageList = prpCengageDao.queryAllByPolicyNoAndClauseCode(policyNo,clauseCode);
        for (PrpCengage prpCEngage: prpCengageList) {
            if(prpCEngage.getLineNo() ==2 &&"TX001".equals(prpCEngage.getClauseCode())){
                deductibleRate = prpCEngage.getClauses();
            }
        }
        return deductibleRate;
    }
}
