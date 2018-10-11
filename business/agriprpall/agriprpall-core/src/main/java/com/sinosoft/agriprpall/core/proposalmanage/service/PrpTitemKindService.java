package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTitemKindDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 标的子险信息Core接口
 */
public interface PrpTitemKindService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTitemKindDto prpTitemKindDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, Integer itemkindNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTitemKindDto prpTitemKindDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTitemKindDto queryByPK(String proposalNo, Integer itemkindNo);

    /**
     * 根据投保单号查询PrpTitemKind
     *
     * @param proposalNo
     * @return List<PrpTitemKindDto>
     * @author: 钱浩
     * @date: 2017/12/5 上午 11:47
     */
    public List<PrpTitemKindDto> queryByConnection(String proposalNo) throws Exception;
}