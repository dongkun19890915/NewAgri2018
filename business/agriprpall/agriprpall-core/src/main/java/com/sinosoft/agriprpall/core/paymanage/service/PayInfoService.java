package com.sinosoft.agriprpall.core.paymanage.service;

import com.sinosoft.agriprpall.api.paymanage.dto.*;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 支付信息维护模块Service
 *
 * @author: 何伟东
 * @date: 2017/12/20 18:08
 */
public interface PayInfoService {

    /**
     * 支付信息录入列表信息查询
     *
     * @param queryPayInfoByConditionDto 查询条件
     * @param isInput                    true-支付信息录入查询;false-支付信息修改查询
     * @return 符合条件的列表信息
     * @author: 何伟东
     * @date: 2017/12/20 17:53
     */
    PageInfo<ResponsePayInfoDto> queryPayInfoByCondition(QueryPayInfoByConditionDto queryPayInfoByConditionDto, boolean isInput) throws Exception;

    /**
     * 保存整单支付信息，支持多个批单批量录入一条支付信息
     *
     * @param requestSavePayInfoDto 批单号码(支持批量录入整单支付信息)，整单支付信息
     * @author: 何伟东
     * @date: 2017/12/22 10:30
     */
    Map<String, String> saveSinglePayInfo(RequestSavePayInfoDto requestSavePayInfoDto, boolean isModify) throws Exception;

    /**
     * 保存清单支付信息，不支持批量录入
     *
     * @param requestSavePayInfoDto 清单支付批单号码，清单支付信息
     * @author: 何伟东
     * @date: 2017/12/22 16:49
     */
    void saveListPayInfo(RequestSavePayInfoDto requestSavePayInfoDto, boolean isModify) throws Exception;

    /**
     * 支付信息明细信息查询
     *
     * @param endorseNo 批单号码
     * @param costType  费用类型
     * @return prpPaySubDtos-支付信息类型以及关联数据，List<PrpPayMainDto>-支付信息主要数据
     * @author: 何伟东
     * @date: 2017/12/26 10:46
     */
    ResponsePayInfoDetailsDto queryPayInfoDetails(String endorseNo, String costType) throws Exception;

    /**
     * 清单支付信息录入，导出Excel
     *
     * @param endorseNo 批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:37
     */
    String exportExcel(String endorseNo, String costType) throws Exception;

    /**
     * 清单支付信息录入，导入Excel
     *
     * @param requestImportPayListDto 入参dto
     * @return list<prpPaymainDto> 从文件中读取的数据
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    List<PrpPayMainDto> importExcel(RequestImportPayListDto requestImportPayListDto) throws Exception;

    /**
     * 导出批改后清单excel文件
     *
     * @param endorseNo 批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    @Deprecated
    String exportCPEndorseList(String endorseNo) throws Exception;

    /**
     * 根据领款人类型，证件号码，批单号集合，同步账户信息
     *
     * @param endorseNos   批单号集合
     * @param receiverType 领款人类型
     * @param certifyNo    证件号码
     * @param certiType    证件类型
     * @return 账户信息
     * @author: 何伟东
     * @date: 2018/1/16 14:25
     */
    List<SynchronizeInfoDto> synchronizeAccount(List<String> endorseNos, String receiverType, String certiType, String certifyNo);

    /**
     * 下载批改变化量清单excel文件
     *
     * @param endorseNo 批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    Map<String, String> exportEndorseList(String endorseNo) throws Exception;

    /**
     * 查询批单的支付信息类型
     *
     * @param endorseNo 批单号码
     * @param costType  批单号码
     * @return payType-文件下载短链接
     * @author: 何伟东
     * @date: 2018/2/8 10:38
     */
    String queryPayInfoType(String endorseNo, String costType) throws Exception;

    /**
     * 下载支付清单的模板文件
     *
     * @param endorseNo 批单号码
     * @param costType  费用类型
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2018/05/03 17:14
     */
    String downloadPayListTempLate(String endorseNo, String costType) throws Exception;

    /**
     * 查询开户银行信息
     *
     * @param bank bank
     * @return 开户银行信息
     * @author: 何伟东
     * @date: 2018-05-15 11:32
     */
    List<PrpDBankBranchDto> getBankInfo(String bank) throws Exception;
}
