package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseFindDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = EndorseSaveApi.PATH)
public interface EndorseSaveApi {
    public static final String PATH="endorse";
    @RequestMapping(value = "endorseSave",method = RequestMethod.POST)
    /**
    * 批单保存
    * @param endorseFindDto
    * @return boolean
    * @throws
    * @author 李冬松
    * @date 14:57 2017/12/13
    */
    public @ResponseBody
    boolean endorseSave(EndorseFindDto endorseFindDto)throws Exception;
}
