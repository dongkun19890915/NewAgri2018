package com.sinosoft.txnlist.api.plantinginsurancelist;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.InsurePreliminaryConfirmDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestInsuranceQueryDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: 潘峰
 * @Date: 2017/11/6 下午3:20
 * 投保预确认清单Api
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = InsurePreliminaryConfirmApi.PATH)
public interface InsurePreliminaryConfirmApi {

    String PATH = "insurePrelimiparyConfirm";

    /**
     * 投保预确认清单编号查询，查询 主信息，农户信息，田快信息
     * 如果用户传入insureListCode 则通过 insureListCode 模糊查询，否则全查
     * @param requestInsuranceQueryDto 用户输入的查询条件
     * @return ResponseDto 里的 PageInfo<GisInsureMainListDto>  GisInsureMainListDto是主信息，农户信息，田快信息
     * @author: 潘峰
     * @date: 2017/11/6 下午2:18
     */
    @RequestMapping(value = "findGisInsureMainLists", method = {RequestMethod.POST})
    PageInfo<GisInsureMainListDto> findAllByInsureListCodeLike(@RequestBody RequestInsuranceQueryDto requestInsuranceQueryDto);


    /**
     * 种植险：投保清单持久化服务：保存投保清单(农险一期)
     * @param insurePreliminaryConfirmDto 清单主表信息、种植险农户信息
     * @return void
     * @author: 潘峰
     * @date: 2017/11/16 下午2:37
     */
    @RequestMapping(value = "savePlantingInsurePreliminaryConfirm", method = {RequestMethod.POST})
    void savePlantingInsurePreliminaryConfirm(@RequestBody InsurePreliminaryConfirmDto insurePreliminaryConfirmDto) throws Exception;

    /**
     * 养殖险：投保清单持久化服务(农险一期)
     * @author: 何伟东
     * @date: 2017/12/5 14:34
     * @param insurePreliminaryConfirmDto 清单主表信息、养殖险农户信息
     */
    @RequestMapping(value = "saveHerdInseredPreliminaryConfirm" , method = RequestMethod.POST)
    void saveHerdInseredPreliminaryConfirm(@RequestBody InsurePreliminaryConfirmDto insurePreliminaryConfirmDto) throws Exception;

    /**
     * 农业险：投保清单持久化服务(农险二期)
     * @author: 何伟东
     * @date: 2017/12/8 15:01
     * @param insurePreliminaryConfirmDto 清单主表信息、农业险农户信息
     */
    @RequestMapping(value = "saveNyxInseredPreliminaryConfirm" , method = RequestMethod.POST)
    void saveNyxInseredPreliminaryConfirm(@RequestBody InsurePreliminaryConfirmDto insurePreliminaryConfirmDto) throws Exception;

    /**
     * 通过清单编号查询投保预确认清单信息 主信息，农户信息，田快信息
     * @param param insureListCode清单编号
     * @return ResponseDto 里的 InsurePreliminaryConfirmDto insureMainListDto,gisNyxInsuranceListDtos,gisFeildDtos
     * @author: 潘峰
     * @date: 2017/11/7 下午5:24
     */
    @RequestMapping(value = "queryInsurePreliminaryConfirm", method = {RequestMethod.POST})
    InsurePreliminaryConfirmDto queryInsurePreliminarydConfirm(@RequestBody Map<String,String> param) throws Exception;


    /**
     * 通过清单编号查询投保预确认清单信息 主信息，农户信息，田快信息
     * @param param insureListCode清单编号
     * @return ResponseDto 里的 InsurePreliminaryConfirmDto insureMainListDto,gisNyxInsuranceListDtos,gisFeildDtos
     * @author: 潘峰
     * @date: 2017/11/7 下午5:24
     */
    @RequestMapping(value = "/inner/queryInsurePreliminaryConfirm", method = {RequestMethod.POST})
    @ResponseBody InsurePreliminaryConfirmDto queryInsurePreliminaryConfirmForInner(@RequestBody Map<String,String> param) throws Exception;


}
