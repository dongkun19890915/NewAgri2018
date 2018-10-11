package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ProposalSaveDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 *  投保单保存Api
 * @Author: 何伟东
 * @Date: 2017/10/26 14:23
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = ProposalSaveApi.PATH)
public interface ProposalSaveApi {
    public static final String PATH = "proposalSave";

    /**
     * 投保单保存方法
     * @author: 何伟东
     * @date: 2017/10/26 14:48
     * @param proposalSaveDto 投保单大对象
     * @return 投保单单号
     * @throws Exception
     */
    @PostMapping(value = "save")
    public @ResponseBody
    Map<String,String> save(@RequestBody ProposalSaveDto proposalSaveDto) throws Exception;
}
