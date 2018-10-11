package com.sinosoft.agriprpall.core.common;

import com.sinosoft.agriprpall.api.common.dto.RequestParameterDto;
import com.sinosoft.agriprpall.api.common.dto.ResponseParameterDto;

public interface SelectParameterService {
    /**
     *   双击域公共入口
     * @author: 钱浩
     * @date: 2017/11/27 上午 9:13
     * @param requestParameterDto 参数大对象
     * @return requestParameterDto返参大对象
     * @throws Exception
     */
    public ResponseParameterDto queryFindSelect(RequestParameterDto requestParameterDto) throws Exception;
}
