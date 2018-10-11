package com.sinosoft.notice.common;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.notice.api.common.UtilNoticeModelApi;
import com.sinosoft.notice.api.common.dto.UtilNoticeModelDto;
import com.sinosoft.notice.core.model.service.UtilNoticeModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 潘峰
 * @date 2017/12/4 上午11:39
 */
@RestController
@RequestMapping(value = UtilNoticeModelController.PATH)
public class UtilNoticeModelController implements UtilNoticeModelApi {

    @Autowired
    private UtilNoticeModelService utilNoticeModelService;


    @Override
    public UtilNoticeModelDto addUtilNoticeModel(@RequestBody UtilNoticeModelDto utilNoticeModelDto) throws Exception {
        return utilNoticeModelService.addUtilNoticeModelService(utilNoticeModelDto);
    }

    @Override
    public Map<String, String> deleteUtilNoticeModel(@RequestBody Map<String, String> map) throws Exception {
        String noticeCode = map.get("noticeCode");
        String message = utilNoticeModelService.deleteUtilNoticeModel(noticeCode);
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("message", message);
        return returnMap;
    }

    @Override
    public UtilNoticeModelDto findUtilNoticeModel(@RequestBody Map<String, String> map) throws Exception {
        String noticeCode = map.get("noticeCode");
        String comCode = map.get("comCode");
        return utilNoticeModelService.findUtilNoticeModel(noticeCode, comCode);
    }

    /**
     * 判断用户是否输入有中文，如果有，就走模板名称模糊查询，如果没有，走模板编号模糊查询
     *
     * @param map noticeCode
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 2017/12/18 上午10:03
     */
    @Override
    public List<UtilNoticeModelDto> findNoticeContent(@RequestBody Map<String, String> map) throws Exception {
        String comCode = map.get("comCode");
        String userCode = map.get("userCode");
        String loginGradeCodes=map.get("loginGradeCodes");
        String riskCode=map.get("riskCode");
        List<UtilNoticeModelDto> utilNoticeModels = utilNoticeModelService.findNoticeContent(comCode, userCode,loginGradeCodes,riskCode);
        return utilNoticeModels;

    }


    @Override
    public Map<String, String> updateUtilNoticeModel(@RequestBody UtilNoticeModelDto utilNoticeModelDto) throws Exception {
        String message = utilNoticeModelService.updateUtilNoticeModel(utilNoticeModelDto);
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("message", message);
        return returnMap;
    }

    @Override
    public Map<String, String> changeStatus(@RequestBody Map<String, String> map) throws Exception {
        String noticeCode = map.get("noticeCode");
        String status = map.get("status");
        String message = utilNoticeModelService.changeStatus(noticeCode, status);
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("message", message);
        return returnMap;
    }


    /**
     * 短信模板列表分页查询
     * @param map
     * @return Page<UtilNoticeModelDto>
     * @throws Exception
     * @author 潘峰
     * @date 2017年9月29日
     */
    @Override
    public PageInfo<UtilNoticeModelDto> queryNoticeModelPaging(@RequestBody Map<String, Object> map) throws Exception {

        Integer offset = (Integer) map.get("offset");
        Integer length = (Integer) map.get("length");
        String noticeName = (String) map.get("noticeName");
        String type = (String) map.get("type");
        return utilNoticeModelService.queryByNoticeNamePaging(offset, length, noticeName, type);
    }

    @Override
    public Map<String, String> deleteAllUtilNoticeModel(@RequestBody List<String> noticeCodes) throws Exception {
        return utilNoticeModelService.deleteAllUtilNoticeModel(noticeCodes);
    }
}
