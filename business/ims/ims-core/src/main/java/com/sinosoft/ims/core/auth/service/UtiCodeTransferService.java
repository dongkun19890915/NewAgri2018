package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description UtiCodeTransferCore接口
 */
public interface UtiCodeTransferService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiCodeTransferDto utiCodeTransferDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String configCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiCodeTransferDto utiCodeTransferDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiCodeTransferDto queryByPK(String configCode);
    /**
     * 根据险种大类查询UtiCodeTransferDto 险别大类结果集
     * @author: 田慧
     * @date: 2017/11/22 17:05
     * @param riskType 险种大类
     * @return UtiCodeTransferDto 险别大类的集合
     */
    public List<UtiCodeTransferDto> queryByRiskType(String riskType)throws Exception;
    /**
     * 根据outerCode查询UtiCodeTransferDto 险别大类结果集
     * @author 杨昆
     * @date 2017年12月15日 下午10:28:15
     * @param map 包括outerCode属性
     * @return UtiCodeTransferDto集合
     */
	List<UtiCodeTransferDto> queryUtiCodeTransferDtoByOuterCode(String outerCode);
	 /**
     * @description:方法功能简述:根据险类编码查询outerCode 
     * @author 安齐崇
     * @date 2017年12月14日下午11:16:16
     * @param riskTypes 险类集合
     * @return
     */
	List<String> queryOuterCodeByTypes(List<String> riskTypes);
}