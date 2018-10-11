package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdEndorChgDetailDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-14 07:07:05.012 
 * @description 养殖险保单清单最新数据表Core接口
 */
public interface HerdEndorChgDetailService {

    /**
     *@description 新增
     *@param
     */
    void save(HerdEndorChgDetailDto herdEndorChgDetailDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String inusreListCode, String earLabel, String endorseNo, String kindCode, String fCode);
    /**
     *@description 修改
     *@param
     */
    void modify(HerdEndorChgDetailDto herdEndorChgDetailDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    HerdEndorChgDetailDto queryByPK(String inusreListCode, String earLabel, String endorseNo, String kindCode, String fCode);

    /**
     * 按照清单号删除
     *@param inusreListCode 清单号
     *@author 王心洋
     *@time 2017-11-18
     */
    public void removeByInusreListCode(String inusreListCode);
    /**
     * 按照清单号删除
     *@param inusreListCode 清单号
     *@author 王心洋
     *@time 2017-11-18
     */
    public int getSumInsured(String inusreListCode);
    /**
     * 批改保存前删除
     * @param endorseNo 批单号
     * @return void
     * @throws
     * @author 李冬松
     * @date 17:10 2018/4/12
     */
    public void removeByEndorseNo(String endorseNo)throws Exception;
    public void saveList(List<HerdEndorChgDetailDto> herdEndorChgDetailDtoList)throws Exception;
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    Map<String,List<HerdEndorChgDetailDto>> queryByEndorseNoList(List<String> endorseNoList);

    /**
     * 根据批单号码集合查询herd的批改变化量清单
     *
     * @param endorseNo 批单号码
     * @return List<HerdEndorChgDetailDto>
     * @date: 2018/4/13 17:59
     * @author: 何伟东
     */
    List<HerdEndorChgDetailDto> queryByEndorseNo(String endorseNo);
}