package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178
 *  投保明细表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCitemKindApi.PATH)
public interface PrpCitemKindApi {

    public static final String PATH = "prpCitemKind";

    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param policyNo 保单号
     * @return List<PrpCitemKind>
     */
    @RequestMapping(value = "queryItemByPolicyNo",method = RequestMethod.POST)
    List<PrpCitemKindDto> queryItemByPolicyNo(String policyNo) throws Exception;
}
