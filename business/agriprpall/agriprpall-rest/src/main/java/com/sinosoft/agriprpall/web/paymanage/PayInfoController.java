package com.sinosoft.agriprpall.web.paymanage;

import com.sinosoft.agriprpall.api.paymanage.PayInfoApi;
import com.sinosoft.agriprpall.api.paymanage.dto.*;
import com.sinosoft.agriprpall.core.paymanage.service.PayInfoService;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支付信息维护模块Controller
 *
 * @author: 何伟东
 * @date: 2017/12/20 18:08
 */
@RestController
@RequestMapping(value = PayInfoController.PAHT)
public class PayInfoController implements PayInfoApi {

    @Autowired
    PayInfoService payInfoService;


    /**
     * 支付信息录入列表信息查询
     *
     * @param queryPayInfoByConditionDto 查询条件
     * @return 符合条件的列表信息
     * @author: 何伟东
     * @date: 2017/12/20 17:53
     */
    @Override
    public @ResponseBody
    PageInfo<ResponsePayInfoDto> queryInputPayInfo(@RequestBody QueryPayInfoByConditionDto queryPayInfoByConditionDto) throws Exception {
        return payInfoService.queryPayInfoByCondition(queryPayInfoByConditionDto, true);
    }

    /**
     * 保存整单支付信息，支持多个批单批量录入一条支付信息
     *
     * @param requestSavePayInfoDto 批单号码(支持批量录入整单支付信息)，整单支付信息
     * @author: 何伟东
     * @date: 2017/12/22 10:30
     */
    @Override
    public Map<String, String> saveSinglePayInfo(@RequestBody RequestSavePayInfoDto requestSavePayInfoDto) throws Exception {
        return payInfoService.saveSinglePayInfo(requestSavePayInfoDto, false);
    }

    /**
     * 保存清单支付信息，不支持批量录入
     *
     * @param requestSavePayInfoDto 清单支付批单号码，清单支付信息
     * @author: 何伟东
     * @date: 2017/12/22 16:49
     */
    @Override
    public void saveListPayInfo(@RequestBody RequestSavePayInfoDto requestSavePayInfoDto) throws Exception {
        payInfoService.saveListPayInfo(requestSavePayInfoDto, false);
    }

    /**
     * 支付信息修改列表信息查询
     *
     * @param queryPayInfoByConditionDto 查询条件
     * @return 符合条件的列表信息
     * @author: 何伟东
     * @date: 2017/12/25 10:46
     */
    @Override
    public @ResponseBody
    PageInfo<ResponsePayInfoDto> queryModifyPayInfo(@RequestBody QueryPayInfoByConditionDto queryPayInfoByConditionDto) throws Exception {
        return payInfoService.queryPayInfoByCondition(queryPayInfoByConditionDto, false);
    }

    /**
     * 支付信息明细信息查询
     *
     * @param param endorseNo-批单号码,costType-费用类型
     * @return prpPaySubDtos-支付信息类型以及关联数据，List<PrpPayMainDto>-支付信息主要数据
     * @author: 何伟东
     * @date: 2017/12/26 10:46
     */
    @Override
    public @ResponseBody
    ResponsePayInfoDetailsDto queryPayInfoDetails(@RequestBody Map<String, String> param) throws Exception {
        return payInfoService.queryPayInfoDetails(param.get("endorseNo"), param.get("costType"));
    }

    /**
     * 修改整单支付信息
     *
     * @param requestSavePayInfoDto endorseNo-批单号码，prpPayMainDto-整单支付信息
     * @author: 何伟东
     * @date: 2017/12/26 17:33
     */
    @Override
    public void modifySinglePayInfo(@RequestBody RequestSavePayInfoDto requestSavePayInfoDto) throws Exception {
        payInfoService.saveSinglePayInfo(requestSavePayInfoDto, true);
    }

    /**
     * 修改清单支付信息
     *
     * @param requestImportPayListDto endorseNo-批单号码，prpPayMainDtos-清单支付信息集合
     * @author: 何伟东
     * @date: 2017/12/26 17:54
     */
    @Override
    public @ResponseBody
    List<PrpPayMainDto> modifyListPayInfo(@RequestBody RequestImportPayListDto requestImportPayListDto) throws Exception {
        requestImportPayListDto.setModify(true);
        return payInfoService.importExcel(requestImportPayListDto);
    }

    /**
     * 清单支付信息录入，导出Excel
     *
     * @param param endorseNo-批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:37
     */
    @Override
    public @ResponseBody
    Map<String, String> exportExcel(@RequestBody Map<String, String> param) throws Exception {
        String shortLink = payInfoService.exportExcel(param.get("endorseNo"), param.get("costType"));
        Map<String, String> returnMap = new HashMap<>(1);
        returnMap.put("shortLink", shortLink);
        return returnMap;
    }

    /**
     * 清单支付信息录入，导入Excel
     *
     * @param requestImportPayListDto fileId-上传到fileserver的文件id
     * @return list<prpPaymainDto> 从文件中读取的数据
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    @Override
    public @ResponseBody
    List<PrpPayMainDto> inputImportExcel(@RequestBody RequestImportPayListDto requestImportPayListDto) throws Exception {
        requestImportPayListDto.setModify(false);
        return payInfoService.importExcel(requestImportPayListDto);
    }

    /**
     * 导出批改后清单excel文件
     *
     * @param param endorseNo-批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    @Override
    @Deprecated
    public @ResponseBody
    Map<String, String> exportCPEndorseList(@RequestBody Map<String, String> param) throws Exception {
        String shortLink = payInfoService.exportCPEndorseList(param.get("endorseNo"));
        Map<String, String> returnMap = new HashMap<>(1);
        returnMap.put("shortLink", shortLink);
        return returnMap;
    }

    /**
     * 根据领款人类型，证件号码，批单号集合，同步账户信息
     *
     * @param param endorseNos-批单号集合，receiverType-领款人类型，certifyNo-证件号码
     * @return 账户信息
     * @author: 何伟东
     * @date: 2018/1/16 14:25
     */
    @Override
    public @ResponseBody
    List<SynchronizeInfoDto> synchronizeAccount(@RequestBody Map<String, Object> param) {
        List<String> endorseNos = (List<String>) param.get("endorseNos");
        String receiverType = (String) param.get("receiverType");
        String certiType = (String) param.get("certiType");
        String certifyNo = (String) param.get("certifyNo");
        return payInfoService.synchronizeAccount(endorseNos, receiverType, certiType, certifyNo);
    }

    /**
     * 下载批改变化量清单excel文件
     *
     * @param param endorseNo-批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    @Override
    public @ResponseBody
    Map<String, String> exportEndorseList(@RequestBody Map<String, String> param) throws Exception {
        return payInfoService.exportEndorseList(param.get("endorseNo"));
    }

    /**
     * 查询批单的支付信息类型
     *
     * @param param endorseNo-批单号码，costType-费用类型
     * @return payType-文件下载短链接
     * @author: 何伟东
     * @date: 2018/2/8 10:38
     */
    @Override
    public @ResponseBody
    Map<String, String> queryPayInfoType(@RequestBody Map<String, String> param) throws Exception {
        String payType = payInfoService.queryPayInfoType(param.get("endorseNo"), param.get("costType"));
        Map<String, String> returnMap = new HashMap<>(1);
        returnMap.put("payType", payType);
        return returnMap;
    }

    /**
     * 下载支付清单的模板文件
     *
     * @param param endorseNo-批单号码，costType-费用类型
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2018/05/03 17:14
     */
    @Override
    public @ResponseBody
    Map<String, String> downloadPayListTempLate(@RequestBody Map<String, String> param) throws Exception {
        String shortLink = payInfoService.downloadPayListTempLate(param.get("endorseNo"), param.get("costType"));
        Map<String, String> returnMap = new HashMap<>(1);
        returnMap.put("shortLink", shortLink);
        return returnMap;
    }

    /**
     * 查询开户银行信息
     *
     * @param param bank
     * @return 开户银行信息
     * @author: 何伟东
     * @date: 2018-05-15 11:32
     */
    @Override
    public @ResponseBody List<PrpDBankBranchDto> getBankInfo(@RequestBody Map<String, String> param) throws Exception {
        return payInfoService.getBankInfo(param.get("bank"));
    }
}
