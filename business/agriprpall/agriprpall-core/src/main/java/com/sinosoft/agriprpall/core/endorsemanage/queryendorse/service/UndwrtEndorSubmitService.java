package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.UndwrtEndorSubmitDto;

import java.util.List;

/**
 * 批改提交核保
 * @author: 钱浩
 * @date: 2017/11/29 上午 10:29
 */
public interface UndwrtEndorSubmitService {
    /**
     *   批改提交 核保
     * @author: 钱浩
     * @date: 2017/11/29 上午 10:33
     * @param undwrtEndorSubmitDto 入参对象
     * @return list 返回语句，状态集合
     * @throws Exception
     */
    public List<String> saveUndwrtByEndorseNo(UndwrtEndorSubmitDto undwrtEndorSubmitDto)throws Exception;

}
