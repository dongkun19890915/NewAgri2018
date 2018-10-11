package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmain;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTmainService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rx.internal.operators.BackpressureUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrpTmainServiceImpl extends BaseServiceImpl implements PrpTmainService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTmainAgriServiceImpl.class);
    @Autowired
    private PrpTmainDao prpTmainDao;
    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;//新农险标识（prptmian表中的systemflag,用于区分新农险系统与老系统的数据）

    /**
     * 根据主键查询PrpTmain投保单基本信息表信息
     *
     * @param proposalNo 投保单号
     * @return PrpTmainDto
     * @author: 田慧
     * @date: 2017/12/3 11:58
     */
    @Override
    public PrpTmainDto queryByPK(String proposalNo) {
        PrpTmainKey prpTmainiKey = new PrpTmainKey(proposalNo);
        PrpTmain prpTmain = prpTmainDao.findOne(prpTmainiKey);
        PrpTmainDto prpTmainDto = this.convert(prpTmain, PrpTmainDto.class);
        if (prpTmainDto != null && !systemFlag.equals(prpTmainDto.getSystemFlag())) {
            return null;
        }
        return prpTmainDto;
    }

    /**
     * 根据policyNo保单号、riskCode险种代码检查投保单号是否存在
     *
     * @param policyNo 保单号
     * @param riskCode 险种代码
     * @return List<prpTmainDto></prpTmainDto> 投保单基本信息表信息
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/1 14:38
     */
    @Override
    public List<PrpTmainDto> checkPolicyNo(String policyNo, String riskCode) throws Exception {
        List<PrpTmain> prpTmainList = prpTmainDao.queryPrpTMainInfo(policyNo, riskCode);
        for (int i = 0; i < prpTmainList.size(); i++) {
            if (!systemFlag.equals(prpTmainList.get(i).getSystemFlag())) {
                prpTmainList.remove(i);
            }
        }
        List<PrpTmainDto> prpTmainDtoList = new ArrayList<PrpTmainDto>();
        convertCollection(prpTmainList, prpTmainDtoList, PrpTmainDto.class);
        return prpTmainDtoList;
    }

    /**
     * 获取总条数
     *
     * @param proposalNo 投保单
     * @return 条数
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/14 下午 15:30
     */
    @Override
    public Integer queryProposalNo(String proposalNo) throws Exception {
        if (StringUtils.isEmpty(proposalNo)) {
            throw new Exception("投保单号不能为空");
        }
        Integer count = prpTmainDao.queryPrpTMainCount(proposalNo);
        return count;
    }

    /**
     * 根据主键和核保标志为0查询PrpTmain投保单基本信息表信息
     *
     * @param proposalNo 投保单号 underwriteFlag 核保标志(0初始值/1通过/2不通过/3 无需核保 9待核保)
     * @return PrpTmainDto
     * @author: 潘峰
     * @date: 2017/12/3 11:58
     */
    @Override
    public PrpTmainDto queryByUnderwriteFlag(String proposalNo, String underwriteFlag) {
        PrpTmain prpTmain = prpTmainDao.findByProposalNoAndUnderwriteFlag(proposalNo, underwriteFlag);
        PrpTmainDto prpTmainDto = this.convert(prpTmain, PrpTmainDto.class);
        if (prpTmainDto != null && !systemFlag.equals(prpTmainDto.getSystemFlag())) {
            return null;
        }
        return prpTmainDto;
    }

    @Override
    public PrpTmainDto findByProposalNo(String proposalNo) {
        PrpTmain prpTmain = prpTmainDao.findByProposalNo(proposalNo);
        PrpTmainDto prpTmainDto = this.convert(prpTmain, PrpTmainDto.class);
        return prpTmainDto;
    }

    /**
     * 批量查询未提交投保单信息
     *
     * @param proposalNos 投保单号码集合
     * @author: 何伟东
     * @date: 2018/4/17 15:52
     */
    @Override
    public List<PrpTmainDto> queryInitialProposal(List<String> proposalNos) {
        if (proposalNos == null || proposalNos.size() < 1) {
            throw new DataVerifyException("至少有一个保单号码！");
        }
        List<PrpTmain> prpTmains = prpTmainDao.queryProposal(proposalNos, systemFlag);
        int sum = 0;
        for (PrpTmain prpTmain : prpTmains) {
            String underwriteFlag = prpTmain.getUnderwriteFlag();
            if (!"0".equals(underwriteFlag)) {
                sum++;
            }
        }
        if (sum != 0) {
            throw new BusinessException(sum + "");
        }
        List<PrpTmainDto> prpTmainDtos = new ArrayList<>();
        convertCollection(prpTmains, prpTmainDtos, PrpTmainDto.class);
        return prpTmainDtos;
    }
}
