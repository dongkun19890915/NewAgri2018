package com.sinosoft.agriclaim.core.docmanage.service;


import com.sinosoft.agriclaim.api.docmanage.dto.PrpLCertifyImgDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * @description 单证及影像表Core接口
 */
public interface PrpLCertifyImgService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCertifyImgDto prpLCertifyImgDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String businessNo,java.lang.Double serialNo,String lossItemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCertifyImgDto prpLCertifyImgDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCertifyImgDto queryByPK(String businessNo,java.lang.Double serialNo,String lossItemCode);
    /**
     * @description:方法功能简述: 根据报案号和状态码查询 并以typecode 进行排序 并返回对象集合
     * @author chong
     * @date 2017年11月9日下午3:39:02
     * @param registNo 报案号
     * @param validStatus 状态码
     * @return certifyImgDtoList
     */
    List<PrpLCertifyImgDto> queryByConditionAndOrder(String registNo,String validStatus);
}