package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.endorsemanage.dto.UndwrtEndorSubmitDto;
import com.sinosoft.agriprpall.api.proposalmanage.UndwrtSubmitApi;
import com.sinosoft.agriprpall.core.proposalmanage.service.UndwrtSubmitService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059 
 * @description 工作流主表controller层
 */
@RestController
@RequestMapping(value = UndwrtSubmitController.PATH)
public class UndwrtSubmitController implements UndwrtSubmitApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UndwrtSubmitController.class);

    @Autowired
    private UndwrtSubmitService undwrtSubmitService;
    /**
     * 提交核保接口
     * @author: 钱浩
     * @date: 2017/10/17 14:18
     * @param undwrtEndorSubmitDto 入参对象
     * @return ResponseDto 提交核保状态与工作流号
     * @throws Exception
     */
    public List submitUndwrtByProposal(@RequestBody UndwrtEndorSubmitDto undwrtEndorSubmitDto) throws Exception{
        return  undwrtSubmitService.submitUndwrtByProposal(undwrtEndorSubmitDto);
    }
}
