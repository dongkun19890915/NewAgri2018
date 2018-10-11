package com.sinosoft.notice.core.model.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.notice.api.common.dto.UtilNoticeModelDto;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-30 07:15:42.402 
 * @description 通知模板表Core接口
 */
public interface UtilNoticeModelService {

    UtilNoticeModelDto addUtilNoticeModelService(UtilNoticeModelDto utilNoticeModelDto) throws Exception;

    String deleteUtilNoticeModel(String noticeCode) throws Exception;

    UtilNoticeModelDto findUtilNoticeModel(String noticeCode, String comCode) throws Exception;

    String updateUtilNoticeModel(UtilNoticeModelDto utilNoticeModelDto) throws Exception;


    String changeStatus(String noticeCode, String status) throws Exception;


    PageInfo<UtilNoticeModelDto> queryByNoticeNamePaging(Integer offset, Integer length, String noticeName, String type) throws Exception;

    List<UtilNoticeModelDto> findNoticeContent(String comCode, String userCode,String loginGradeCodes,String riskCode) throws Exception;

    Map<String, String> deleteAllUtilNoticeModel(List<String> noticeCodes) throws Exception;
}