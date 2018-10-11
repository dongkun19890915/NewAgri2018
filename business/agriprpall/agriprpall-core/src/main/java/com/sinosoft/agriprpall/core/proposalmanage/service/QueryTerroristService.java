package com.sinosoft.agriprpall.core.proposalmanage.service;

import com.sinosoft.agriprpall.api.client.dto.ResponseQueryTerroristInfoDto;
import com.sinosoft.framework.dto.ResponseDto;

import java.util.List;

public interface QueryTerroristService {
    /**
     * 调用反洗钱系统服务查询所有恐怖分子
     * @author: 宋振振
     * @date: 2017/10/21 11:02
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @return 返回恐怖分子信息列表
     * @throws Exception
     */
    public List<ResponseQueryTerroristInfoDto> queryTerroristInfo(Integer pageNo,Integer pageSize) throws Exception;
}
