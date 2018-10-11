package com.sinosoft.txnlist.api.makeuplist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.makeuplist.dto.ListingQueryConditions;
import com.sinosoft.txnlist.api.makeuplist.dto.ListingQueryResults;
import com.sinosoft.txnlist.api.makeuplist.dto.MakeUpListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author 潘峰
 * @date 2018/1/22 上午10:04
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = MakeUpListApi.PATH)
public interface MakeUpListApi {


    String PATH = "makeUpList";


    /**
     * 通过核保标志查询补全清单
     *
     * @param map
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 07/02/2018 9:46 AM
     */
    @RequestMapping(value = "queryMakeUpList", method = {RequestMethod.POST})
    @ResponseBody
    List<MakeUpListDto> queryMakeUpList(@RequestBody Map<String, String> map) throws Exception;

    /**
     * 查询金禾清单关联的未提交核保投保单信息
     *
     * @param map gisInsureListCode - 金禾的清单号码
     * @author: 何伟东
     * @date: 2018/4/17 18:05
     */
    @RequestMapping(value = "queryMakeUpListByInsureListCode", method = {RequestMethod.POST})
    @ResponseBody
    PageInfo<MakeUpListDto> queryMakeUpListByInsureListCode(@RequestBody Map<String, Object> map) throws Exception;


    /**
     * 通过查询条件查询清单分页
     *
     * @param listingQueryConditions
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 07/02/2018 9:48 AM
     */
    @RequestMapping(value = "pageFindByConditions", method = RequestMethod.POST)
    @ResponseBody
    PageInfo<ListingQueryResults> pageFindByConditions(@RequestBody ListingQueryConditions listingQueryConditions) throws Exception;

    /**
     * 导入耳标号清单，并校验
     *
     * @param param fileId-文件Id
     * @return
     * @date: 2018/2/7 10:24
     * @author: 何伟东
     */
    @RequestMapping(value = "importEarLabelList", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> importEarLabelList(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 导入连带被保险人清单，并校验
     *
     * @param param fileId-文件Id
     * @return
     * @date: 2018/2/7 10:24
     * @author: 何伟东
     */
    @RequestMapping(value = "importJointInsured", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> importJointInsured(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 下载带有农户信息的耳标号清单模板
     *
     * @param param gisInsureListCode - 金禾清单号码
     * @return shortLink
     * @author: 何伟东
     * @date: 2018/4/24 9:56
     */
    @RequestMapping(value = "downloadEarLabelList", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> downloadEarLabelList(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 下载带有农户信息的连带被保险人清单模板
     *
     * @param param gisInsureListCode - 金禾清单号码
     * @return shortLink
     * @author: 何伟东
     * @date: 2018/4/24 9:56
     */
    @RequestMapping(value = "downloadJointInsured", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> downloadJointInsured(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 校验要补录的耳标号或者连带被保险人是否存在
     *
     * @param param gisInsureListCode - 金禾清单号码
     * @author: 何伟东
     * @date: 2018-05-10 14:37
     */
    @RequestMapping(value = "checkDoesItExist", method = RequestMethod.POST)
    @ResponseBody
    Integer checkDoesItExist(@RequestBody Map<String, String> param) throws Exception;

}
