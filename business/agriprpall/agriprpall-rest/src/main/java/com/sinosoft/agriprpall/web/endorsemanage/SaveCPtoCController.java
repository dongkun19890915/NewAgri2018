package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.SaveCPtoCApi;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.SaveCPtoCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = SaveCPtoCApi.PATH)
public class SaveCPtoCController implements SaveCPtoCApi{
    @Autowired
    private SaveCPtoCService saveCPtoCService;

    @Override
    public boolean saveCPtoC(String policyNo) throws Exception {
        return saveCPtoCService.saveCPtoC(policyNo);
    }
}
