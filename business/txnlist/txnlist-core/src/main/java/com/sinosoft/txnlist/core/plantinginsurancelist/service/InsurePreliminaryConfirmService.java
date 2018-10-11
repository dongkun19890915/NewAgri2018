package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.InsurePreliminaryConfirmDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestInsuranceQueryDto;

/**
 * @Author: 潘峰
 * @Date: 2017/11/6 下午3:20
 * 投保预确认清单Service
 */
public interface InsurePreliminaryConfirmService {


    /**
     * 投保预确认清单编号查询，查询 主信息，农户信息，田快信息
     * 如果用户传入insureListCode 则通过 insureListCode 模糊查询，否则全查
     *
     * @param requestInsuranceQueryDto 用户输入的查询条件
     * @return PageInfo<GisInsureMainListDto>  GisInsureMainListDto是主信息，农户信息，田快信息
     * @author: 潘峰
     * @date: 2017/11/6 下午2:18
     */
    PageInfo<GisInsureMainListDto> findGisInsureMainList(RequestInsuranceQueryDto requestInsuranceQueryDto);

    /**
     * 种植险：投保清单持久化服务：保存投保清单(农险一期)
     * @param insurePreliminaryConfirmDto 清单主表信息、种植险农户信息
     * @return void
     * @author: 潘峰
     * @date: 2017/11/16 下午2:37
     */
    void savePlantingInsurePreliminaryConfirm(InsurePreliminaryConfirmDto insurePreliminaryConfirmDto)  throws Exception;

    /**
     * 养殖险：投保清单持久化服务(农险一期)
     * @author: 何伟东
     * @date: 2017/12/5 14:34
     * @param insurePreliminaryConfirmDto 清单主表信息、养殖险农户信息
     */
    void saveHerdInseredPreliminaryConfirm(InsurePreliminaryConfirmDto insurePreliminaryConfirmDto)  throws Exception;

    /**
     * 农业险：投保清单持久化服务(农险二期)
     * @author: 何伟东
     * @date: 2017/12/8 15:01
     * @param insurePreliminaryConfirmDto 清单主表信息、农业险农户信息
     */
    void saveNyxInseredPreliminaryConfirm(InsurePreliminaryConfirmDto insurePreliminaryConfirmDto) throws Exception;

    /**
     * 通过清单编号查询投保预确认清单信息 主信息，农户信息，田快信息
     * @param insureListCode 清单编号
     * @return InsurePreliminaryConfirmDto insureMainListDto,gisNyxInsuranceListDtos,gisFeildDtos
     * @author: 潘峰
     * @date: 2017/11/7 下午5:24
     */
    InsurePreliminaryConfirmDto queryInsurePreliminaryConfirm(String insureListCode) throws Exception;


}
