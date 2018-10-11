package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.CheckStatusApi;
import com.sinosoft.agriprpall.api.endorsemanage.UndwrtEndorSubmitApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.UndwrtEndorSubmitDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.UndwrtEndorSubmitService;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = UndwrtEndorSubmitApi.PATH)
public class UndwrtEndorSubmitController implements UndwrtEndorSubmitApi {

    @Autowired
    private UndwrtEndorSubmitService undwrtEndorSubmitService;

    /**
     * 批改提交核保
     * @param undwrtEndorSubmitDto 入参对象
     * @return list 返回语句，状态集合
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/29 上午 10:33
     */
    @Override
    public @ResponseBody
    List<String> saveUndwrtByEndorseNo(@RequestBody UndwrtEndorSubmitDto undwrtEndorSubmitDto) throws Exception {
        return undwrtEndorSubmitService.saveUndwrtByEndorseNo(undwrtEndorSubmitDto);
    }
}
