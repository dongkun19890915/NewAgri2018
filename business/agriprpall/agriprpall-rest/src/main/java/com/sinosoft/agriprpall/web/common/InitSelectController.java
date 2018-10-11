package com.sinosoft.agriprpall.web.common;

import com.sinosoft.agriprpall.api.common.InitSelectApi;
import com.sinosoft.agriprpall.api.common.dto.SelectTagListDto;
import com.sinosoft.agriprpall.api.common.dto.SelectTagRetuenDto;
import com.sinosoft.agriprpall.core.common.InitSelectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *公共封装
 * @Author: 田慧
 * @Date: 2017/12/13 17:40
 */
@RestController
@RequestMapping(value = InitSelectController.PATH)
public class InitSelectController implements InitSelectApi{
    private static Logger LOGGER = LoggerFactory.getLogger(InitSelectController.class);
    @Autowired
    private InitSelectService InitSelectService;
    /**
     * 根据条件查询信息
     * @author: 田慧
     * @date: 2017/12/12 10:57
     * @param selectTagListDto 查询请求Dto ，codeType业务类型，riskCode险种代码，codeCode、upperCode、codeCName、comCode、userCode、methodCode等可以复用
     * @return SelectTagRetuenDto 返回Dto
     * @throws Exception
     */
    @Override
    public SelectTagRetuenDto initSelect(@RequestBody SelectTagListDto selectTagListDto) throws Exception {
        return InitSelectService.initSelect(selectTagListDto);
    }
}
