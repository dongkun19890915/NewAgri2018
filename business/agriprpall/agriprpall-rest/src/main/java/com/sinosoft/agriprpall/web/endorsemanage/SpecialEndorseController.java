package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.SpecialEndorseApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndorIniService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndorseService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = SpecialEndorseApi.PATH)
public class SpecialEndorseController extends BaseServiceImpl implements SpecialEndorseApi {

    @Autowired
    private SpecialEndorseService specialEndorseService;
    @Autowired
    private SpecialEndorIniService specialEndorIniService;

    /**
     * 特殊批改批量处理总接口
     * @param requestSpecialEndorseDto 批单对象集合、批改条件对象合并大对象
     * @return List<PolicyEndorseDto>新旧保单、批单大对象集合
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-22
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PolicyEndorseDto> specialEndorse(@RequestBody RequestSpecialEndorseDto requestSpecialEndorseDto) throws Exception {
        return specialEndorseService.specialEndorse(requestSpecialEndorseDto);
    }

    /**
     * 特殊批改批量处理总接口
     * @param requestSpecialEndorseDto 批单对象集合、批改条件对象合并大对象
     * @return RequestSpecialEndorseDto 特殊批改初始化信息
     * @throws Exception
     * @author ldd
     * @time 2018-01-10
     */
    @Override
    public RequestSpecialEndorseDto specialEndorIni(@RequestBody RequestSpecialEndorseDto requestSpecialEndorseDto) throws Exception{
        return specialEndorIniService.querySpecialEndorIni(requestSpecialEndorseDto);
    }
}
