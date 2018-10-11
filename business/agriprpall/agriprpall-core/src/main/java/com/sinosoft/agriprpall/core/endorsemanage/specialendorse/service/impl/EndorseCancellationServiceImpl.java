package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpCPcommissionDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPcommissionDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPheadKey;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.EndorseCancelService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.DeletePrpJDateService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.EndorseCancellationService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EndorseCancellationServiceImpl extends BaseServiceImpl implements EndorseCancellationService {

    @Autowired
    private PrpCPcommissionDao prpCPcommissionDao;
    @Autowired
    private PrpPcommissionDao prpPcommissionDao;
    @Autowired
    private PrpPheadDao prpPheadDao;
    @Autowired
    private DeletePrpJDateService deletePrpJDateService;
    @Autowired
    private EndorseCancelService endorseCancelService;

    public EndorseCancellationServiceImpl() {
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancellation(BLEndorseDto blEndorse, String endorseNo) throws Exception {
        String certiType="E";


        //todo 调用宋振振的删除批改数据
        endorseCancelService.cancel(endorseNo);
        /**收付数据删除 */
        //todo 收付数据删除 调用webservice
        prpPcommissionDao.deleteByEndorseNo(endorseNo);
        PrpPheadKey prpPheadKey=new PrpPheadKey(endorseNo);
        PrpPhead prpPhead=prpPheadDao.findOne(prpPheadKey);
        if (prpPhead!=null){
            prpCPcommissionDao.deleteByPolicyNo(prpPhead.getPolicyNo());
        }
        /**删除见费出单刷卡交易失败的信息：缴费交易主表-prpjpayexch；缴费交易子表-prpjpayexchsub；刷卡记录表-prpjposrecord */
        //todo 删除见费出单刷卡交易失败的信息：缴费交易主表-prpjpayexch；缴费交易子表-prpjpayexchsub；刷卡记录表-prpjposrecord
        deletePrpJDateService.deletePrpJDate(endorseNo);
        //todo 根据批单号取得相应的缴费流水号



         }
}
