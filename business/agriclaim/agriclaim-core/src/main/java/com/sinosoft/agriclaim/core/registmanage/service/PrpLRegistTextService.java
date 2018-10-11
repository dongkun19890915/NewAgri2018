package com.sinosoft.agriclaim.core.registmanage.service;


import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * @description 报案文字表Core接口
 */
public interface PrpLRegistTextService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLRegistTextDto prpLRegistTextDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo,String textType,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLRegistTextDto prpLRegistTextDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLRegistTextDto queryByPK(String registNo,String textType,java.lang.Integer lineNo);
    /**
     * @description:方法功能简述: 根据条件查询报案文字信息
     * @author chong
     * @date 2017年11月9日下午4:17:15
     * @param registNo 报案号
     * @param textType 文本类型  (1出险摘要2拒赔文字3查勘报告)
     * @return registTextDtoList
     */
    List<PrpLRegistTextDto> queryByRegistNoAndTextType(String registNo, String textType);
}