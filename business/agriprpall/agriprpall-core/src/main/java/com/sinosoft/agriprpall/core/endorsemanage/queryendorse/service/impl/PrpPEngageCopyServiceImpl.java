package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPengageDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPengage;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPEngageCopyService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPEngageService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCengageService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * PrpPEngage表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPEngageCopyServiceImpl extends BaseServiceImpl implements PrpPEngageCopyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPEngageCopyServiceImpl.class);
}
