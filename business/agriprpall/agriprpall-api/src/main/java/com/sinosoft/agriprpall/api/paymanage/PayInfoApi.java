package com.sinosoft.agriprpall.api.paymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.paymanage.dto.*;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 支付信息维护模块Api
 *
 * @author: 何伟东
 * @date: 2017/12/20 18:08
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PayInfoApi.PAHT)
public interface PayInfoApi {

    String PAHT = "payinfo";

    /**
     * 支付信息录入列表信息查询
     *
     * @param queryPayInfoByConditionDto 查询条件
     * @return 符合条件的列表信息
     * @author: 何伟东
     * @date: 2017/12/20 17:53
     */
    @RequestMapping(value = "queryInputPayInfo", method = RequestMethod.POST)
    @ResponseBody
    PageInfo<ResponsePayInfoDto> queryInputPayInfo(@RequestBody QueryPayInfoByConditionDto queryPayInfoByConditionDto) throws Exception;

    /**
     * 保存整单支付信息，支持多个批单批量录入一条支付信息
     *
     * @param requestSavePayInfoDto 批单号码(支持批量录入整单支付信息)，整单支付信息
     * @author: 何伟东
     * @date: 2017/12/22 10:30
     */
    @RequestMapping(value = "saveSinglePayInfo", method = RequestMethod.POST)
    Map<String, String> saveSinglePayInfo(@RequestBody RequestSavePayInfoDto requestSavePayInfoDto) throws Exception;

    /**
     * 保存清单支付信息，不支持批量录入
     *
     * @param requestSavePayInfoDto 清单支付批单号码，清单支付信息
     * @author: 何伟东
     * @date: 2017/12/22 16:49
     */
    @RequestMapping(value = "saveListPayInfo", method = RequestMethod.POST)
    void saveListPayInfo(@RequestBody RequestSavePayInfoDto requestSavePayInfoDto) throws Exception;

    /**
     * 支付信息修改列表信息查询
     *
     * @param queryPayInfoByConditionDto 查询条件
     * @return 符合条件的列表信息
     * @author: 何伟东
     * @date: 2017/12/25 10:46
     */
    @RequestMapping(value = "queryModifyPayInfo", method = RequestMethod.POST)
    @ResponseBody
    PageInfo<ResponsePayInfoDto> queryModifyPayInfo(@RequestBody QueryPayInfoByConditionDto queryPayInfoByConditionDto) throws Exception;

    /**
     * 支付信息明细信息查询
     *
     * @param param endorseNo-批单号码,costType-费用类型
     * @return prpPaySubDtos-支付信息类型以及关联数据，List<PrpPayMainDto>-支付信息主要数据
     * @author: 何伟东
     * @date: 2017/12/26 10:46
     */
    @RequestMapping(value = "queryPayInfoDetails", method = RequestMethod.POST)
    @ResponseBody
    ResponsePayInfoDetailsDto queryPayInfoDetails(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 修改整单支付信息
     *
     * @param requestSavePayInfoDto endorseNo-批单号码，prpPayMainDto-整单支付信息
     * @author: 何伟东
     * @date: 2017/12/26 17:33
     */
    @RequestMapping(value = "modifySinglePayInfo", method = RequestMethod.POST)
    void modifySinglePayInfo(@RequestBody RequestSavePayInfoDto requestSavePayInfoDto) throws Exception;

    /**
     * 修改清单支付信息
     *
     * @param requestImportPayListDto endorseNo-批单号码，prpPayMainDtos-清单支付信息集合
     * @author: 何伟东
     * @date: 2017/12/26 17:54
     */
    @RequestMapping(value = "modifyListPayInfo", method = RequestMethod.POST)
    List<PrpPayMainDto> modifyListPayInfo(@RequestBody RequestImportPayListDto requestImportPayListDto) throws Exception;


    /**
     * 清单支付信息录入，导出Excel
     *
     * @param param endorseNo-批单号码，costType-费用类型
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:37
     */
    @RequestMapping(value = "exportExcel", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> exportExcel(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 清单支付信息录入，导入Excel
     *
     * @param requestImportPayListDto 入参dto
     * @return list<prpPaymainDto> 从文件中读取的数据
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    @RequestMapping(value = "inputImportExcel", method = RequestMethod.POST)
    @ResponseBody
    List<PrpPayMainDto> inputImportExcel(@RequestBody RequestImportPayListDto requestImportPayListDto) throws Exception;

    /**
     * 下载批改后清单excel文件
     *
     * @param param endorseNo-批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    @RequestMapping(value = "exportCPEndorseList", method = RequestMethod.POST)
    @Deprecated
    @ResponseBody
    Map<String, String> exportCPEndorseList(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 根据领款人类型，证件号码，批单号集合，同步账户信息
     *
     * @param param endorseNos-批单号集合，receiverType-领款人类型，certifyNo-证件号码
     * @return 账户信息
     * @author: 何伟东
     * @date: 2018/1/16 14:25
     */
    @RequestMapping(value = "synchronizeAccount", method = RequestMethod.POST)
    @ResponseBody
    List<SynchronizeInfoDto> synchronizeAccount(@RequestBody Map<String, Object> param);

    /**
     * 下载批改变化量清单excel文件
     *
     * @param param endorseNo-批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    @RequestMapping(value = "exportEndorseList", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> exportEndorseList(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 查询批单的支付信息类型
     *
     * @param param endorseNo-批单号码，costType-费用类型
     * @return payType-支付信息类型
     * @author: 何伟东
     * @date: 2018/2/8 10:38
     */
    @RequestMapping(value = "queryPayInfoType", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> queryPayInfoType(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 下载支付清单的模板文件
     *
     * @param param endorseNo-批单号码，costType-费用类型
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2018/05/03 17:14
     */
    @RequestMapping(value = "downloadPayListTempLate", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> downloadPayListTempLate(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 查询开户银行信息
     *
     * @param param bank
     * @return 开户银行信息
     * @author: 何伟东
     * @date: 2018-05-15 11:32
     */
    @RequestMapping(value = "getBankInfo", method = RequestMethod.POST)
    @ResponseBody
    List<PrpDBankBranchDto> getBankInfo(@RequestBody Map<String, String> param) throws Exception;

}
