package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestSpecialEndorseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = SpecialEndorseApi.PATH)
public interface SpecialEndorseApi {
    public static final String PATH="endorsemanage";

    /**
     * 特殊批改批量处理总接口
     * @param requestSpecialEndorseDto 批单对象集合、批改条件对象合并大对象
     * @return List<PolicyEndorseDto>新旧保单、批单大对象集合
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-22
     */
    @RequestMapping(value = "specialEndorse",method = RequestMethod.POST)
    public List<PolicyEndorseDto> specialEndorse(@RequestBody RequestSpecialEndorseDto requestSpecialEndorseDto) throws Exception;

    /**
     * 特殊批改批量处理总接口
     * @param requestSpecialEndorseDto 批单对象集合、批改条件对象合并大对象
     * @return RequestSpecialEndorseDto 特殊批改初始化信息
     * @throws Exception
     * @author ldd
     * @time 2018-01-10
     */
    @RequestMapping(value = "specialEndorIni",method = RequestMethod.POST)
    public RequestSpecialEndorseDto specialEndorIni(@RequestBody RequestSpecialEndorseDto requestSpecialEndorseDto) throws Exception;
}
