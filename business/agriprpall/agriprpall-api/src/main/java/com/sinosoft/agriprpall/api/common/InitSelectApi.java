package com.sinosoft.agriprpall.api.common;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.common.dto.SelectTagListDto;
import com.sinosoft.agriprpall.api.common.dto.SelectTagRetuenDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * *公共封装
 * @Author: 田慧
 * @Date: 2017/12/13 17:40
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = InitSelectApi.PATH)

public interface InitSelectApi {
    public static final String PATH = "initSelect";
    /**
     * 根据条件查询信息
     * @author: 田慧
     * @date: 2017/12/12 10:57
     * @param selectTagListDto 查询请求Dto ，codeType业务类型，riskCode险种代码，codeCode、upperCode、codeCName、comCode、userCode、methodCode等可以复用
     * @return SelectTagRetuenDto 返回Dto
     * @throws Exception
     */
    @RequestMapping(value = "initSelect",method = {RequestMethod.POST})
    public SelectTagRetuenDto initSelect(@RequestBody SelectTagListDto selectTagListDto) throws Exception;
}
