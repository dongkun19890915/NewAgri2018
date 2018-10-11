package com.sinosoft.txnlist.core.claiminsurancelist.service;


import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxClaimPayListDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-02 07:30:32.914
 * @description 理赔支付清单表Core接口
 */
public interface NyxClaimPayListService {

    /**
     *@description 新增
     *@param
     */
    void save(NyxClaimPayListDto nyxClaimPayListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String listNo, String serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(NyxClaimPayListDto nyxClaimPayListDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    NyxClaimPayListDto queryByPK(String listNo, String serialNo);
    /**
     * 批量保存支付清单
     * @author: 孙朋飞
     * @date: 2018/1/2 17:18
     * @param nyxClaimPayListDtos 支付清单的excel导入集合
     * @throws Exception
     */
    public void batchSaveNyxClaimPayList(List<NyxClaimPayListDto> nyxClaimPayListDtos) throws Exception;
    /**
     * 查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/1/3 17:52
     * @param listNo 清单号
     * @return 支付清单的集合
     * @throws Exception
     */
    public List<NyxClaimPayListDto> queryNyxClaimPayListByListNo(String listNo) throws Exception;
    /**
     * 分页查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/1/3 18:59
     * @param listNo 清单号
     * @param pageNo 当前页
     * @param pageSize 每页显示条数
     * @return 支付清单的集合
     * @throws Exception
     */
    public PageInfo<NyxClaimPayListDto> queryNyxClaimPayListPage(String listNo,String pageNo,String pageSize) throws Exception;

    /**
     * （通过清单号查询所有数据）
     * @author: 王志文
     * @date: 2018/1/2 15:52
     * @param listNo 清单号
     * @return
     */
    List<NyxClaimPayListDto> queryAllNyxClaimPayListDtoByListNo(String listNo);
    /**
     * （通过支付单号查询所有数据）
     * @author: 王心洋
     * @date: 2018/1/2 15:52
     * @param paymentNo 支付单号
     * @return
     */
    List<NyxClaimPayListDto> queryAllByPaymentNo(String paymentNo);
    /**
     * 根据理算书号查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/3/29 9:59
     * @param compensateNo 理算书号
     * @return 支付清单号
     * @throws Exception
     */
    public Map<String,String> queryNyxClaimPayListByCompensateNo(String compensateNo) throws Exception;
    /**
     * 根据理算书号删除支付清单
     * @author: 孙朋飞
     * @date: 2018/3/29 11:34
     * @param compensateNo 理算书号
     * @throws Exception
     */
    public void deleteNyxClaimPayListByCompensateNo(String compensateNo) throws Exception;
}