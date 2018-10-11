package com.sinosoft.agriprpall.core.common;

import com.sinosoft.agriprpall.api.common.dto.SelectTagListDto;
import com.sinosoft.agriprpall.api.common.dto.SelectTagRetuenDto;

import java.util.List;

/**共共封装请求dto(主要针对返回参数只有codeCode、codeCname)
* @Author: 田健
* @Date: 2017/12/12 10:29
*/
public interface InitSelectService {
    /**
     * 根据条件查询信息
     * @author: 田健
     * @date: 2017/12/12 10:57
     * @param selectTagListDto 查询请求Dto ，codeType业务类型，riskCode险种代码，codeCode、upperCode、codeCName、comCode、userCode、methodCode等可以复用
     * @return SelectTagRetuenDto 返回Dto
     * @throws Exception
     */
    public SelectTagRetuenDto initSelect(SelectTagListDto selectTagListDto) throws Exception;
}


































