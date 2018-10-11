package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLMessageDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestPrpLMessageDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestSavePrpLMessageDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponsePrpLMessageDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔流转讨论留言表Core接口
 */
public interface PrpLMessageService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLMessageDto prpLMessageDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo,java.lang.Integer serialNo,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLMessageDto prpLMessageDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLMessageDto queryByPK(String registNo,java.lang.Integer serialNo,java.lang.Integer lineNo);

    /**
     * （查看理赔沟通页面信息）
     * @author: 董坤
     * @date: 2017/11/15 19:56
     * @param requestPrpLMessageDto 查询理赔沟通页面所需条件
     * @return 理赔沟通页面显示信息
     */
    ResponsePrpLMessageDto queryClaimCommunicationByCondition(RequestPrpLMessageDto requestPrpLMessageDto);

    /**
     * （保存理赔沟通页面信息）
     * @author: 董坤
     * @date: 2017/11/15 21:11
     * @param requestSavePrpLMessageDto 理赔沟通保存的页面信息
     * @return 保存成功与否信息
     */
    String saveClaimCommunicationInfo(RequestSavePrpLMessageDto requestSavePrpLMessageDto) throws Exception;
    /**
     * 查询留言列表
     * @author: 孙朋飞
     * @date: 2018/4/3 9:30
     * @param registNo 报案号
     * @return 各节点留言
     * @throws Exception
     */
    public List<PrpLMessageDto> queryPrpLMessageByRegistNo(String registNo) throws Exception;
}