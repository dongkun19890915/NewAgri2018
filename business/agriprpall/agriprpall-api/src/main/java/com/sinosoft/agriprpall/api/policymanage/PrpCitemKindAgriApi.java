package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindAgriDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCitemKindAgriApi.PATH)
public interface PrpCitemKindAgriApi {
    public static final String PATH = "prpCitemKindAgri";

    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param policyNo 保单号
     * @param itemKindNo 标的序号
     * @param kindCode 险别
     * @return List<PrpCitemKindAgriDto>
     */
    @RequestMapping(value = "queryByConditions",method = RequestMethod.POST)
    List<PrpCitemKindAgriDto> queryByConditions(String policyNo, int itemKindNo, String kindCode) throws Exception;
}
