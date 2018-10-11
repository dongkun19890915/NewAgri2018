package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.EndorseCancelService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.dao.PrpPmainLoanDao;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EndorseCancelServiceImpl extends BaseServiceImpl implements EndorseCancelService {
    @Autowired
    private PrpPinsuredDao prpPinsuredDao;
    @Autowired
    private PrpPinsuredNatureDao prpPinsuredNatureDao;
    @Autowired
    private PrpPinsuredArtifDao prpPinsuredArtifDao;
    @Autowired
    private PrpPaddressDao prpPaddressDao;
    @Autowired
    private PrpPitemKindAgriDao prpPitemKindAgriDao;
    @Autowired
    private PrpPsubSidyDao prpPsubSidyDao;
    @Autowired
    private PrpPfeildDao prpPfeildDao;
    @Autowired
    private PrpPitemKindDao prpPitemKindDao;
    @Autowired
    private PrpPengageDao prpPengageDao;
    @Autowired
    private PrpPfeeDao prpPfeeDao;
    @Autowired
    private PrpPplanDao prpPplanDao;
    @Autowired
    private PrpPplanCoinsDao prpPplanCoinsDao;
    @Autowired
    private PrpPmainAgriDao prpPmainAgriDao;
    @Autowired
    private PrpPmainLoanDao prpPmainLoanDao;
    @Autowired
    private PrpPcoinsDetailDao prpPcoinsDetailDao;
    @Autowired
    private PrpPcoinsDao prpPcoinsDao;
    @Autowired
    private PrpPexpenseDao prpPexpenseDao;
    @Autowired
    private PrpPcommissionDao prpPcommissionDao;
    @Autowired
    private PrpPcommissionDetailDao prpPcommissionDetailDao;
    @Autowired
    private PrpPtextDao prpPtextDao;
    @Autowired
    private PrpPmainDao prpPmainDao;
    @Autowired
    private PrpPheadDao prpPheadDao;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancel(String endorseNo) throws Exception {
        if (StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单号不能为空");
        }
        prpPinsuredDao.deleteByEndorseNo(endorseNo);
        prpPinsuredNatureDao.cancelPrpPinsuredNature(endorseNo);
        prpPinsuredArtifDao.cancelPrpPinsuredArtif(endorseNo);
        prpPaddressDao.deleteByEndorseNo(endorseNo);
        prpPitemKindAgriDao.deleteByEndorseNo(endorseNo);
        prpPsubSidyDao.deleteByEndorseNo(endorseNo);
        prpPfeildDao.cancelPrpPfeild(endorseNo);
        prpPitemKindDao.deleteByEndorseNo(endorseNo);
        prpPengageDao.deleteByEndorseNo(endorseNo);
        prpPfeeDao.deleteByEndorseNo(endorseNo);
        prpPplanDao.deleteByEndorseNo(endorseNo);
        prpPplanCoinsDao.cancelPrpPplanCoins(endorseNo);
        prpPmainAgriDao.deleteByEndorseNo(endorseNo);
        prpPmainLoanDao.cancelPrpPmainLoan(endorseNo);
        prpPcoinsDetailDao.deleteByEndorseNo(endorseNo);
        prpPcoinsDao.deleteByEndorseNo(endorseNo);
        prpPexpenseDao.deleteByEndorseNo(endorseNo);
        prpPcommissionDao.deleteByEndorseNo(endorseNo);
        prpPcommissionDetailDao.deleteByEndorseNo(endorseNo);
        prpPtextDao.cancelPrpPtext(endorseNo);
        prpPmainDao.deleteByEndorseNo(endorseNo);
        prpPheadDao.deleteByEndorseNo(endorseNo);
    }
}
