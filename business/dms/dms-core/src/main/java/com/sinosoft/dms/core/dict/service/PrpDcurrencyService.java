package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyRequestDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447
 * @description 币别代码表Core接口
 */
public interface PrpDcurrencyService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDcurrencyDto prpDcurrencyDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String currencyCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDcurrencyDto prpDcurrencyDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpDcurrencyDto queryByPK(String currencyCode);
    /**
     * 根据条件查询币别信息
     * @author: 宋振振
     * @date: 2017/10/29 11:53
     * @param prpDcurrencyRequestDto 币别查询请求参数的Dto
     * @return List<PrpDcurrencyDto>返回币别信息
     * @throws Exception
     */
    public List<PrpDcurrencyDto> queryPrpDcurrencyByCondition(PrpDcurrencyRequestDto prpDcurrencyRequestDto, String validStatus)throws Exception;


    /**
     * @description: 按照币别代码和中英文标志查询币别
     * @author 王心洋
     * @param currencyCode
     * @param languageFlag
     * @return
     * @time 2017-10-31
     */
    String translateCode(String currencyCode,String languageFlag);
    /**
     * @description:方法功能简述: 查询所有的币别信息由于下拉框的初始化
     * @author 安齐崇
     * @date 2017年12月13日下午11:59:54
     * @return
     */
	List<PrpDcurrencyDto> queryAll();
}