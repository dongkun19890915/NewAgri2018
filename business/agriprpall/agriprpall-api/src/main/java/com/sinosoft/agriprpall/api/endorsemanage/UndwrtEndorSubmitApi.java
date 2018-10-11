package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.UndwrtEndorSubmitDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 批改提交核保
 * @author: 钱浩
 * @date: 2017/11/29 上午 10:29
 */
@FeignClient(name= AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = UndwrtEndorSubmitApi.PATH)
public interface UndwrtEndorSubmitApi {

    public static final String PATH="undwrtendorsubmit";

    /**
     *   批改提交核保
     * @author: 钱浩
     * @date: 2017/11/29 上午 10:33
     * @param undwrtEndorSubmitDto 入参对象
     * @return list 返回语句，状态集合
     * @throws Exception  save
     */
    @RequestMapping(value = "saveUndwrtByEndorseNo",method = RequestMethod.POST)
    public @ResponseBody List<String> saveUndwrtByEndorseNo(@RequestBody UndwrtEndorSubmitDto undwrtEndorSubmitDto)throws Exception;


}
