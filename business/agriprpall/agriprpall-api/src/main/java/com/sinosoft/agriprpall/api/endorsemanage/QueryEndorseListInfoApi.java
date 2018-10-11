package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestEndorseListDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.ResponseEndorseListDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 查询批单列表信息
 * @Author: 刘曼曼
 * @Date: 2017/11/23 10:49
 */
@FeignClient(name= AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME)
public interface QueryEndorseListInfoApi {
    public static final String PATH="QueryEndors";

    /**
     * 按条件查询批单列表
     * @author: 刘曼曼
     * @date: 2017/11/23 16:16
     * @param requestEndorseListDto 查询批单列表条件Dto
     * @return  PageInfo<ResponseEndorseListDto>  批单列表信息
     * @throws Exception
     */
    @RequestMapping(value = "queryEndorsListInfo",method = {RequestMethod.POST})
    public @ResponseBody
    PageInfo<ResponseEndorseListDto> queryEndorsListInfo(@RequestBody RequestEndorseListDto requestEndorseListDto) throws Exception;



}
