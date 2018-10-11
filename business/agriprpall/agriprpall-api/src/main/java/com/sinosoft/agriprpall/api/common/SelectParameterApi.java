package com.sinosoft.agriprpall.api.common;


import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.common.dto.RequestParameterDto;
import com.sinosoft.agriprpall.api.common.dto.ResponseParameterDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 双击域查询
 * @author: 钱浩
 * @date: 2017/11/27 上午 9:06
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = SelectParameterApi.PATH)
public interface SelectParameterApi {

    public static final String PATH = "selectparameter";
    /**
     *   双击域公共入口
     * @author: 钱浩
     * @date: 2017/11/27 上午 9:13
     * @param requestParameterDto 参数大对象
     * @return requestParameterDto返参大对象
     * @throws Exception
     */
    @RequestMapping(value = "queryFindSelect",method = {RequestMethod.POST})
    public ResponseParameterDto queryFindSelect(@RequestBody RequestParameterDto requestParameterDto)throws  Exception;

}