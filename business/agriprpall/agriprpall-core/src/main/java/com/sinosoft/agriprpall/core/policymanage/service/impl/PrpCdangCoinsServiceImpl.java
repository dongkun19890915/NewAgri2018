package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCdangerCoinsDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCdangerCoinsDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCdangerCoins;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCdangCoinsService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrpCdangCoinsServiceImpl extends BaseServiceImpl implements PrpCdangCoinsService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpCplanServiceImpl.class);

    @Autowired
    private PrpCdangerCoinsDao prpCdangerCoinsDao;
    /**
     * （queryCdangerCoinsDtos 服务）
     * @author: qh
     * @date: 2018/4/12 18:08
     * @return
     * @throws Exception
     */

    public List<PrpCdangerCoinsDto> queryCdangerCoinsDtos(String policyNo) throws Exception {
        if (StringUtils.isEmpty(policyNo)) {
            throw new Exception("保单号不能为空!");
        }
        List<PrpCdangerCoins> prpCdangerCoinsList = prpCdangerCoinsDao.queryByPolicyNos(policyNo);
        List<PrpCdangerCoinsDto> prpCdangerCoinsDtoList = new ArrayList<>();
        convertCollection(prpCdangerCoinsList, prpCdangerCoinsDtoList, PrpCdangerCoinsDto.class);

        return prpCdangerCoinsDtoList;
    }
}
