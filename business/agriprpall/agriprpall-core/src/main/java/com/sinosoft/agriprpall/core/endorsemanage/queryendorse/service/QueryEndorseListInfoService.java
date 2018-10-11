package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestEndorseListDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.ResponseEndorseListDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * 批单信息查询
 * @Author: 刘曼曼
 * @Date: 2017/11/23 11:03
 */

public interface QueryEndorseListInfoService {

    /**
     * 按条件查询批单列表
     * @author: 刘曼曼
     * @date: 2017/11/23 16:16
     * @param requestEndorseListDto 查询批单列表条件Dto
     * @return PageInfo<ResponseEndorseListDto> 批单列表信息
     * @throws Exception
     */
    public PageInfo<ResponseEndorseListDto> queryEndorsListInfo(RequestEndorseListDto requestEndorseListDto) throws Exception;
}
