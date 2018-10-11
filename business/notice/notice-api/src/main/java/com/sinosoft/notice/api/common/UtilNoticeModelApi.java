package com.sinosoft.notice.api.common;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.notice.NoticeConstant;
import com.sinosoft.notice.api.common.dto.UtilNoticeModelDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author 潘峰
 * @date 2017/12/4 上午11:43
 */
@FeignClient(name = NoticeConstant.NOTICE_SERVICE_NAME, path = SendNoticeApi.PATH)
public interface UtilNoticeModelApi {

    String PATH = "utilNoticeModel";



    /**
     * 短信模板新增功能
     * @param utilNoticeModelDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addUtilNoticeModel", method = RequestMethod.POST)
    UtilNoticeModelDto addUtilNoticeModel(@RequestBody UtilNoticeModelDto utilNoticeModelDto) throws Exception;


    /**
     * 短信模板逻辑删除
     * @param map ,noticeCode
     * @return
     */
    @RequestMapping(value = "/deleteUtilNoticeModel", method = RequestMethod.POST)
    Map<String, String> deleteUtilNoticeModel(@RequestBody Map<String, String> map) throws Exception;


    /**
     * 短信模板详细信息查询服务
     * @param map noticeCode
     * @return
     */
    @RequestMapping(value = "/findUtilNoticeModel", method = RequestMethod.POST)
    UtilNoticeModelDto findUtilNoticeModel(@RequestBody Map<String, String> map) throws Exception;


    /**
     * 通过短信模板名称获得短信内容
     *
     * @param map noticeCode
     * @return
     */
    @RequestMapping(value = "/findNoticeContent", method = RequestMethod.POST)
    List<UtilNoticeModelDto> findNoticeContent(@RequestBody Map<String, String> map) throws Exception;

    /**
     * 短信模板修改服务
     * @param utilNoticeModelDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateUtilNoticeModel", method = RequestMethod.POST)
    Map<String, String> updateUtilNoticeModel(@RequestBody UtilNoticeModelDto utilNoticeModelDto) throws Exception;

    /**
     * 短信状态启用或停用
     * @param map status,noticeCode
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    Map<String, String> changeStatus(@RequestBody Map<String, String> map) throws Exception;


    /**
     * 短信列表分页查询
     * @param map offset 当前页码数 length 每页大小
     * @return Page<UtilNoticeModelDto>
     * @throws Exception
     * @author 潘峰
     * @date 2017年12月29日
     */
    @RequestMapping(value = "queryNoticeModelPaging", method = RequestMethod.POST)
    PageInfo<UtilNoticeModelDto> queryNoticeModelPaging(@RequestBody Map<String, Object> map) throws Exception;

    /**
     * 根据模板代码批量删除短信模板
     *
     * @param noticeCodes
     * @author: 潘峰
     * @date: 2017/11/9 18:14
     */
    @RequestMapping(value = "deleteAllUtilNoticeModel", method = {RequestMethod.POST})
    Map<String, String> deleteAllUtilNoticeModel(@RequestBody List<String> noticeCodes) throws Exception;


}