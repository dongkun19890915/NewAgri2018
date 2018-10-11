package com.sinosoft.agriprpall.web.common;

import com.sinosoft.agriprpall.api.common.SelectParameterApi;
import com.sinosoft.agriprpall.api.common.dto.RequestParameterDto;
import com.sinosoft.agriprpall.api.common.dto.ResponseParameterDto;
import com.sinosoft.agriprpall.core.common.SelectParameterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 12:54:07.447 
 * @description
 */
@RestController
@RequestMapping(value = SelectParameterController.PATH)
public class SelectParameterController implements SelectParameterApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SelectParameterController.class);

    @Autowired
    private SelectParameterService selectParameterService;
    /**
     *   双击域公共入口
     * @author: 钱浩
     * @date: 2017/11/27 上午 9:13
     * @param requestParameterDto 参数大对象
     * @return requestParameterDto返参大对象
     * @throws Exception
     */
    @Override
    public @ResponseBody ResponseParameterDto queryFindSelect(@RequestBody  RequestParameterDto requestParameterDto) throws Exception {
        return selectParameterService.queryFindSelect(requestParameterDto);
    }
}
