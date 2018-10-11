package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainAgriDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 农业险投保单信息表Core接口
 */
public interface PrpTmainAgriService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTmainAgriDto prpTmainAgriDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTmainAgriDto prpTmainAgriDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTmainAgriDto queryByPK(@RequestParam("proposalNo") String proposalNo);
}