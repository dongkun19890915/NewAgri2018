package com.sinosoft.txnlist.web.makeuplist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.makeuplist.MakeUpListApi;
import com.sinosoft.txnlist.api.makeuplist.dto.ListingQueryConditions;
import com.sinosoft.txnlist.api.makeuplist.dto.ListingQueryResults;
import com.sinosoft.txnlist.api.makeuplist.dto.MakeUpListDto;
import com.sinosoft.txnlist.core.makeuplist.MakeUpListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 潘峰
 * @date 2018/1/22 上午10:29
 */
@RestController
@RequestMapping(value = MakeUpListController.PATH)
public class MakeUpListController implements MakeUpListApi {

    @Autowired
    private MakeUpListService makeUpListService;

    @Override
    public List<MakeUpListDto> queryMakeUpList(@RequestBody Map<String, String> map) throws Exception {
        String gisInsureListCode = map.get("gisInsureListCode");
        List<MakeUpListDto> makeUpListDtos = makeUpListService.queryMakeUpList(gisInsureListCode);
        return makeUpListDtos;
    }

    @Override
    public PageInfo<MakeUpListDto> queryMakeUpListByInsureListCode(@RequestBody Map<String, Object> map) throws Exception {
        return makeUpListService.queryMakeUpListByInsureListCode((String) map.get("gisInsureListCode"), (int) map.get("pageNo"), (int) map.get("pageSize"));
    }

    /**
     * 通过查询条件查询清单分页
     *
     * @param listingQueryConditions
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 07/02/2018 9:48 AM
     */
    @Override
    public PageInfo<ListingQueryResults> pageFindByConditions(@RequestBody ListingQueryConditions listingQueryConditions) throws Exception {
        return makeUpListService.pageFindByConditions(listingQueryConditions);
    }

    /**
     * 导入耳标号清单，并校验
     *
     * @param param fileId-文件Id
     * @return
     * @date: 2018/2/7 10:24
     * @author: 何伟东
     */
    @Override
    public Map<String, String> importEarLabelList(@RequestBody Map<String, String> param) throws Exception {
        String message = makeUpListService.importEarLabelList(param.get("fileId"));
        Map<String, String> returnMessage = new HashMap<>(1);
        returnMessage.put("message", message);
        return returnMessage;
    }

    /**
     * 导入连带被保险人清单，并校验
     *
     * @param param fileId-文件Id
     * @return
     * @date: 2018/2/7 10:24
     * @author: 何伟东
     */
    @Override
    public Map<String, String> importJointInsured(@RequestBody Map<String, String> param) throws Exception {
        String message = makeUpListService.importJointInsured(param.get("fileId"));
        Map<String, String> returnMessage = new HashMap<>(1);
        returnMessage.put("message", message);
        return returnMessage;
    }


    /**
     * 下载带有农户信息的耳标号清单模板
     *
     * @param param gisInsureListCode - 金禾清单号码
     * @return shortLink
     * @author: 何伟东
     * @date: 2018/4/24 9:56
     */
    @Override
    public @ResponseBody
    Map<String, String> downloadEarLabelList(@RequestBody Map<String, String> param) throws Exception {
        String shortLink = makeUpListService.downloadEarLabelList(param.get("gisInsureListCode"));
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("shortLink", shortLink);
        return returnMap;
    }

    /**
     * 下载带有农户信息的连带被保险人清单模板
     *
     * @param param gisInsureListCode - 金禾清单号码
     * @return shortLink
     * @author: 何伟东
     * @date: 2018/4/24 9:56
     */
    @Override
    public @ResponseBody
    Map<String, String> downloadJointInsured(@RequestBody Map<String, String> param) throws Exception {
        String shortLink = makeUpListService.downloadJointInsured(param.get("gisInsureListCode"));
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("shortLink", shortLink);
        return returnMap;
    }

    /**
     * 校验要补录的耳标号或者连带被保险人是否存在
     *
     * @param param gisInsureListCode - 金禾清单号码
     * @author: 何伟东
     * @date: 2018-05-10 14:37
     */
    @Override
    public Integer checkDoesItExist(@RequestBody Map<String, String> param) throws Exception {
        return makeUpListService.checkDoesItExist(param.get("gisInsureListCode"));
    }
}
