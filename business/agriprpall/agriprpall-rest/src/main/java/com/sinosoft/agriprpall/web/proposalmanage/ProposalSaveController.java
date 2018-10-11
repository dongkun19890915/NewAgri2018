package com.sinosoft.agriprpall.web.proposalmanage;


import com.sinosoft.agriprpall.api.proposalmanage.ProposalSaveApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ProposalSaveDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.ProposalSaveService;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = ProposalSaveController.PATH)
public class ProposalSaveController implements ProposalSaveApi {

    @Autowired
    private ProposalSaveService proposalSaveService;

    /**
     * 投保单保存方法
     *
     * @param proposalSaveDto
     * @return 投保单单号
     * @throws Exception
     * @author: 何伟东
     * @date: 2017/10/26 14:48
     */
    @Override
    public @ResponseBody
    Map<String, String> save(@RequestBody ProposalSaveDto proposalSaveDto) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        try {
            String proposalNo = proposalSaveService.save(proposalSaveDto);
            map.put("proposalNo", proposalNo);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return map;
    }
}
