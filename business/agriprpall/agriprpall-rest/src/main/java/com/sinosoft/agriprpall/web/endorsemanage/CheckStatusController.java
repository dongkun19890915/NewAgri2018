package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.CheckStatusApi;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.CheckStatusService;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (查询是否有效的批单）
 * @author 王保良
 * @date 2017年11月10日
 */
@RestController
@RequestMapping(value = CheckStatusApi.PATH)
public class CheckStatusController implements CheckStatusApi{
    @Autowired
    private CheckStatusService checkStatusService;

    /**
     * 根据保单号查询是否有有效批单
     * @param policyNo 保单号
     * @return status 标示了查询结果,有或者无有效的批单 并封装进responseDto中
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    public Integer checkStatus(String policyNo) throws Exception {
        return checkStatusService.checkStatus(policyNo);
    }
}
