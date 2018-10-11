package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPexpenseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCexpenseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPexpenseCopyService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPexpenseService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCexpenseService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PrpPexpenseCopyServiceImpl extends BaseServiceImpl implements PrpPexpenseCopyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPexpenseCopyServiceImpl.class);

}
