package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxCpEndorChgDetailDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description nyxcpendorchgdetailCore接口
 */
public interface NyxCpEndorChgDetailService {

    /**
     *@description 新增
     *@param
     */
    void save(NyxCpEndorChgDetailDto nyxCpEndorChgDetailDto);

    /**
     *@description 删除
     *@param
     */
    public void remove(String inusreListCode)throws Exception;
    /**
     *@description 修改
     *@param
     */
    void modify(NyxCpEndorChgDetailDto nyxCpEndorChgDetailDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    NyxCpEndorChgDetailDto queryByPK(String inusreListCode,String businessNo,String kindCode,String itemCode);
    public void saveList(List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtoList)throws Exception;
    public List<NyxCpEndorChgDetailDto> queryByInsureLitCode(String insureListCode)throws Exception;
}