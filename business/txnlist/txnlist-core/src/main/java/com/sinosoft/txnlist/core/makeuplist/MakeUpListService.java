package com.sinosoft.txnlist.core.makeuplist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.makeuplist.dto.ListingQueryConditions;
import com.sinosoft.txnlist.api.makeuplist.dto.ListingQueryResults;
import com.sinosoft.txnlist.api.makeuplist.dto.MakeUpListDto;

import java.util.List;

/**
 * @author 潘峰
 * @date 2018/1/22 上午10:42
 */
public interface MakeUpListService {
    List<MakeUpListDto> queryMakeUpList(String insureListCode) throws Exception;

    /**
     * 查询金禾清单关联的未提交核保投保单信息
     *
     * @param gisInsureListCode 金禾的清单号码
     * @author: 何伟东
     * @date: 2018/4/17 18:05
     */
    PageInfo<MakeUpListDto> queryMakeUpListByInsureListCode(String gisInsureListCode, int pageNo, int pageSize) throws Exception;

    PageInfo<ListingQueryResults> pageFindByConditions(ListingQueryConditions listingQueryConditions) throws Exception;


    /**
     * 导入耳标号清单，并校验
     *
     * @param fileId 文件Id
     * @return
     * @date: 2018/2/7 10:24
     * @author: 何伟东
     */
    String importEarLabelList(String fileId) throws Exception;

    /**
     * 导入连带被保险人清单，并校验
     *
     * @param fileId 文件Id
     * @return
     * @date: 2018/2/7 10:24
     * @author: 何伟东
     */
    String importJointInsured(String fileId) throws Exception;

    /**
     * 下载带有农户信息的耳标号清单模板
     *
     * @param gisInsureListCode - 金禾清单号码
     * @return shortLink
     * @author: 何伟东
     * @date: 2018/4/24 9:56
     */
    String downloadEarLabelList(String gisInsureListCode) throws Exception;

    /**
     * 下载带有农户信息的连带被保险人清单模板
     *
     * @param gisInsureListCode - 金禾清单号码
     * @return shortLink
     * @author: 何伟东
     * @date: 2018/4/24 9:56
     */
    String downloadJointInsured(String gisInsureListCode) throws Exception;

    /**
     * 校验要补录的耳标号或者连带被保险人是否存在
     *
     * @param gisInsureListCode - 金禾清单号码
     * @author: 何伟东
     * @date: 2018-05-10 14:37
     */
    Integer checkDoesItExist(String gisInsureListCode) throws Exception;
}
