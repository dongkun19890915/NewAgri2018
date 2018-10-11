package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEndorChgDetailDto;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740
 * @description nyxendorchgdetailCore接口
 */
public interface NyxEndorChgDetailService {

    /**
     *@description 新增
     *@param
     */
    void save(NyxEndorChgDetailDto nyxEndorChgDetailDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String inusreListCode,String businessNo,String endorseNo,String kindCode,String itemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(NyxEndorChgDetailDto nyxEndorChgDetailDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    NyxEndorChgDetailDto queryByPK(String inusreListCode,String businessNo,String endorseNo,String kindCode,String itemCode);
    public void removeByEnodrseNo(String endorseNo)throws Exception;
    public void saveList(List<NyxEndorChgDetailDto> nyxEndorChgDetailDtoList)throws Exception;
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    public Map<String,List<NyxEndorChgDetailDto>> queryByEndorseNoList(List<String> endorseNoList);

    /**
     * 根据批单号码集合查询herd的批改变化量清单
     *
     * @param endorseNo 批单号码
     * @return List<HerdEndorChgDetailDto>
     * @date: 2018/4/13 17:59
     * @author: 何伟东
     */
    List<NyxEndorChgDetailDto> queryByEndorseNo(String endorseNo);
}