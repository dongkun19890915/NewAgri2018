package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.QueryEndorseListInfoApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestEndorseListDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.ResponseEndorseListDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryEndorseListInfoService;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(QueryEndorseListInfoApi.PATH)
public class QueryEndorseListInfoController implements QueryEndorseListInfoApi {

    @Autowired
    private QueryEndorseListInfoService queryEndorseListInfoService;

    /**
     * 按条件查询批单列表
     * @author: 刘曼曼
     * @date: 2017/11/23 16:16
     * @param requestEndorseListDto 查询批单列表条件Dto
     * @return  PageInfo<ResponseEndorseListDto>  批单列表信息
     * @throws Exception
     */
    public @ResponseBody  PageInfo<ResponseEndorseListDto>  queryEndorsListInfo(@RequestBody RequestEndorseListDto requestEndorseListDto) throws Exception{
        return queryEndorseListInfoService.queryEndorsListInfo(requestEndorseListDto);
    }

}
