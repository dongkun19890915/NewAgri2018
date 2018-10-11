package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;


import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPtextDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 01:44:37.955 
 * @description 批改文字信息表Core接口
 */
public interface PrpPtextService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpPtextDto prpPtextDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String endorseNo, String policyNo, Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpPtextDto prpPtextDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpPtextDto queryByPK(String endorseNo, String policyNo, Integer lineNo);
    /**
     * 根据批单号查询批文信息
     * @author: 宋振振
     * @date: 2017/11/20 10:02
     * @param endorseNo 批单号
     * @return List<PrpPtextDto> 返回批文信息
     * @throws Exception
     */
    public List<PrpPtextDto> queryPrpPtextByEndorseNo(String endorseNo)throws Exception;
    /**
     * 修改批文
     * @author: 宋振振
     * @date: 2017/11/20 18:01
     * @param endorseNo 批单号
     * @param strPtext 批文
     * @param fromPage 是否该页从批单修改处进入的标志
     * @throws Exception
     */
    public void modifyPrpPtext(String endorseNo,String strPtext,String fromPage)throws Exception;
    /**
     * 批单保存前批文修改功能
     * @param strPtext   新批文
     * @return PrpPtextDto 批文对象
     * @throws Exception
     * @author 李冬松
     * @date 11:03 2018/1/10
     */
    public List<PrpPtextDto> updatePrpPtext(String strPtext)throws Exception;
}