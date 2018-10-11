package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.InsurePreliminaryConfirmApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.InsurePreliminaryConfirmDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestInsuranceQueryDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.InsurePreliminaryConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: 潘峰
 * @Date: 2017/11/6 下午3:20
 * 投保预确认清单Controller
 */
@RestController
@RequestMapping(value = InsurePreliminaryConfirmApi.PATH)
public class InsurePreliminaryConfirmController implements InsurePreliminaryConfirmApi {


    @Autowired
    private InsurePreliminaryConfirmService insurePreliminaryConfirmService;


    /**
     * 投保预确认清单编号查询，查询 主信息，农户信息，田快信息
     * 如果用户传入insureListCode 则通过 insureListCode 模糊查询，否则全查
     * @param requestInsuranceQueryDto 用户输入的查询条件
     * @return ResponseDto 里的 PageInfo<GisInsureMainListDto>  GisInsureMainListDto是主信息，农户信息，田快信息
     * @author: 潘峰
     * @date: 2017/11/6 下午2:18
     */
    @Override
    public PageInfo<GisInsureMainListDto> findAllByInsureListCodeLike(@RequestBody RequestInsuranceQueryDto requestInsuranceQueryDto) {
        PageInfo<GisInsureMainListDto> gisInsureMainListDtos = insurePreliminaryConfirmService.findGisInsureMainList(requestInsuranceQueryDto);
        return gisInsureMainListDtos;
    }


    /**
     * 种植险：投保清单持久化服务：保存投保清单(农险一期)
     * @param insurePreliminaryConfirmDto 清单主表信息、种植险农户信息
     * @return void
     * @author: 潘峰
     * @date: 2017/11/16 下午2:37
     */
    @Override
    public void savePlantingInsurePreliminaryConfirm(@RequestBody InsurePreliminaryConfirmDto insurePreliminaryConfirmDto) throws Exception {
        insurePreliminaryConfirmService.savePlantingInsurePreliminaryConfirm(insurePreliminaryConfirmDto);
    }

    /**
     * 养殖险：投保清单持久化服务(农险一期)
     * @author: 何伟东
     * @date: 2017/12/5 14:34
     * @param insurePreliminaryConfirmDto 清单主表信息、养殖险农户信息
     */
    @Override
    public void saveHerdInseredPreliminaryConfirm(@RequestBody InsurePreliminaryConfirmDto insurePreliminaryConfirmDto) throws Exception {
        insurePreliminaryConfirmService.saveHerdInseredPreliminaryConfirm(insurePreliminaryConfirmDto);
    }

    /**
     * 农业险：投保清单持久化服务(农险二期)
     * @author: 何伟东
     * @date: 2017/12/8 15:01
     * @param insurePreliminaryConfirmDto 清单主表信息、农业险农户信息
     */
    @Override
    public void saveNyxInseredPreliminaryConfirm(@RequestBody InsurePreliminaryConfirmDto insurePreliminaryConfirmDto) throws Exception {
        insurePreliminaryConfirmService.saveNyxInseredPreliminaryConfirm(insurePreliminaryConfirmDto);
    }


    /**
     * 通过清单编号查询投保预确认清单信息 主信息，农户信息，田快信息
     * @param param insureListCode清单编号
     * @return ResponseDto 里的 InsurePreliminaryConfirmDto insureMainListDto,gisNyxInsuranceListDtos,gisFeildDtos
     * @author: 潘峰
     * @date: 2017/11/7 下午5:24
     */
    @Override
    public @ResponseBody InsurePreliminaryConfirmDto queryInsurePreliminarydConfirm(@RequestBody Map<String, String> param) throws Exception {
        return insurePreliminaryConfirmService.queryInsurePreliminaryConfirm(param.get("insureListCode"));
    }

    /**
     * 通过清单编号查询投保预确认清单信息 主信息，农户信息，田快信息
     *
     * @param param insureListCode清单编号
     * @return ResponseDto 里的 InsurePreliminaryConfirmDto insureMainListDto,gisNyxInsuranceListDtos,gisFeildDtos
     * @author: 潘峰
     * @date: 2017/11/7 下午5:24
     */
    @Override
    public  @ResponseBody InsurePreliminaryConfirmDto queryInsurePreliminaryConfirmForInner(@RequestBody Map<String,String> param) throws Exception {
        return insurePreliminaryConfirmService.queryInsurePreliminaryConfirm(param.get("insureListCode"));
    }

}
