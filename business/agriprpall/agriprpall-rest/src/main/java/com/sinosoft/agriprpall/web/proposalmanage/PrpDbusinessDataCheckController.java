package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpDbusinessDataCheckApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpDbusinessDataCheckDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PlantingExcelService;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpDbusinessDataCheckService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 12:54:07.447 
 * @description 分保接受人代码表controller层
 */
@RestController
@RequestMapping(value = PrpDbusinessDataCheckController.PATH)
public class PrpDbusinessDataCheckController implements PrpDbusinessDataCheckApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDbusinessDataCheckController.class);

    @Autowired
    private PrpDbusinessDataCheckService prpDbusinessDataCheckService;

    @Override
    public void save(@RequestBody PrpDbusinessDataCheckDto prpDbusinessDataCheckDto) {

    }

    @Override
    public void remove(@RequestParam(value = "serialNo") String serialNo) {

    }

    @Override
    public void modify(PrpDbusinessDataCheckDto prpDbusinessDataCheckDto) {

    }

    @Override
    public PrpDbusinessDataCheckDto queryByPK(String serialNo) {
        return null;
    }
}
