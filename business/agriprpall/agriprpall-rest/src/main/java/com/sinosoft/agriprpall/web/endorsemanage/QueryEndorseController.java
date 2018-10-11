package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.EndorseConstants;
import com.sinosoft.agriprpall.api.endorsemanage.QueryEndorseApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestShowPrPoEnDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryEndorseService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.ShowPrPoEnService;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 批单信息查询服务
 * @author 王保良
 * @date 2017年11月28日
 */
@RestController
@RequestMapping(value = QueryEndorseApi.PATH)
public class QueryEndorseController implements QueryEndorseApi {

    @Autowired
    private QueryEndorseService endorseService;
    @Autowired
    private ShowPrPoEnService showPrPoEnService;

    /**
     * 根据业务类型BizType寻找所查询批单保单信息及批改前的信息
     * @param requestShowPrPoEnDto (包含BizNo业务号,BizType业务类型,familyNo 分户号,damageDate 出险日期)
     * @return PolicyEndorseDto(包含保单信息及批改前的信息)
     * @author 王保良 刘曼曼
     * @throws  Exception
     * @date 2017年11月28日
     */
    @Override
    public PolicyEndorseDto queryEndorseInfo(@RequestBody RequestShowPrPoEnDto requestShowPrPoEnDto) throws Exception{
        if (EndorseConstants.BIZTYPE_POLICY.equals(requestShowPrPoEnDto.getBizType())){
            return showPrPoEnService.showPrPoEnInfo(requestShowPrPoEnDto);
        }
        if (EndorseConstants.BIZTYPE_ENDORSE.equals(requestShowPrPoEnDto.getBizType())){
            return endorseService.queryEndorseDetail(requestShowPrPoEnDto);
        }
        else {
            throw new DataVerifyException("业务类型不明确");
        }
    }
}
