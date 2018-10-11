package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PrpCdangCoinsApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCdangerCoinsDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCdangCoinsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * *PrpCcoins 共保信息表controller层
 *
 * @Author: qh
 * @Date: 2017/11/20 15:14
 */
@RestController
@RequestMapping(value = PrpCdangCoinsController.PATH)
public class PrpCdangCoinsController implements PrpCdangCoinsApi {
    private static Logger LOGGER = LoggerFactory.getLogger(PrpCplanController.class);
    @Autowired
    private PrpCdangCoinsService prpCdangCoinsService;


    /**
     * （queryCdangerCoinsDtos 服务）
     *
     * @return
     * @throws Exception
     * @author: qh
     * @date: 2018/4/12 18:08
     */
    @RequestMapping(value = "queryCdangerCoinsDtos", method = {RequestMethod.POST})
    public List<PrpCdangerCoinsDto> queryCdangerCoinsDtos(@RequestParam("policyNo") String policyNo) throws Exception {
        return prpCdangCoinsService.queryCdangerCoinsDtos(policyNo);
    }
}
