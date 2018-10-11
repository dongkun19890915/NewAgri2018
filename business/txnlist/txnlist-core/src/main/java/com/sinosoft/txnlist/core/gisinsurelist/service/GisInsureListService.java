package com.sinosoft.txnlist.core.gisinsurelist.service;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.gisinsurelist.dto.*;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdFarmerItemDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceInfoDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestInsuranceQueryDto;

import java.util.List;
import java.util.Map;

/**
 * 金禾中间表数据操作类Service
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:46
 */
public interface GisInsureListService {
    public Map<String, List<GisFarmerItemForPremiumDto>> queryGisFarmerItemInfo(String insureListCode, String serialNo, List<String> itemListCodes)throws Exception;

    public PageInfo<List<GisFarmerItemDto>> queryGisFarmerItemInfoDetail(String insureListCode, String serialNo, List<String> itemListCodes,Integer pageNo,Integer pageSize) throws Exception;

    /**
     * 根据清单号和序列号查询金禾清单gisFarmerItem表
     *
     * @param queryGisFarmerItemDto 序列号和清单号map
     * @return gisFarmerItemInfoDtoList 金禾主表部分信息集合
     * @throws Exception
     * @Author: 钱浩
     */
    public Map<String, List<GisFarmerItemForPremiumDto>> queryGisZHFarmerItemInfo(String insureListCode, String serialNo, List<String> itemListCodes, List<String> itemCodeList) throws Exception;
    /**
     * 投保预确认清单编号查询，查询 主信息，农户信息，田快信息
     * 如果用户传入insureListCode 则通过 insureListCode 模糊查询，否则全查
     *
     * @param requestInsuranceQueryDto 用户输入的查询条件
     * @return PageInfo<GisInsureMainListDto>  GisInsureMainListDto是主信息，农户信息，田快信息
     * @author: 李冬松
     * @date: 2017/11/6 下午2:18
     */
    public PageInfo<GisInsureMainListDto> findGisInsureMainList(RequestInsuranceQueryDto requestInsuranceQueryDto)throws Exception;

    /**
     * 通过清单号和序列号查询GisItemList信息
     *
     * @param insureListCode 清单号
     * @param serialNo       序列号
     * @return gisItemListDtoList gisItemList表集合
     * @throws Exception
     * @Author: 李冬松
     */
    public List<GisItemListDto> findGisItemListByInsureListCodeAndserialNo(String insureListCode,String serialNo)throws Exception;

    /**
     *查询GisFarmerList表信息与GisInsureMainList投保预确认数据主表信息
     * @param insureListCode,清单号 serialNo序列号
     * @return java.util.List<GisFarmerListDto> gisFarmerListdTO集合
     * @throws Exception
     * @author 李冬松
     * @date 15:50 2018/1/19
     */
    public ResponseGisMainAndFarmerListDto findGisFarmerListByInsureListCodeAndserialNo(RequestQueryFarmerDto requestDto)throws Exception;

    public List<GisFarmerListDto> findGisFarmerListInfo(String insureListCode, String serialNo,String itemCode)throws Exception;
    /**31险类
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     * @author: 李冬松
     * @date: 2017/10/20 11:43
     * @param txnlistDetailedDto 保费计算请求dto
     * @return boolean true为保存成功，false为失败
     * @throws Exception
     */
    public boolean checkInsuranceCode(TxnlistDetailedDto txnlistDetailedDto) throws Exception;

    /**31大棚蔬菜类
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     * @author: 李冬松
     * @date: 2017/10/20 11:43
     * @param txnlistDetailedDto 保费计算请求dto
     * @return boolean true为保存成功，false为失败
     * @throws Exception
     */
    public boolean check31InsuranceCode(TxnlistDetailedDto txnlistDetailedDto) throws Exception;

    /**
     * 31险类
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param txnlistDetailedDto 保费计算请求dto
     * @return boolean true为保存成功，false为失败
     * @throws Exception
     * @author: 李冬松
     * @date: 2017/10/20 11:43
     */
    public boolean checkNyxInsuranceCode(TxnlistDetailedDto txnlistDetailedDto) throws Exception;

    /**
     * 31险类
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param txnlistDetailedDto 保费计算请求dto
     * @return boolean true为保存成功，false为失败
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/10/20 11:43
     */
    public boolean checkZHInsuranceCode(TxnlistDetailedDto txnlistDetailedDto) throws Exception;
    /**
     *带耳标号的存NyxinsuranceList
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param txnlistDetailedDto 保费计算请求dto
     * @return boolean true为保存成功，false为失败
     * @throws Exception
     * @author: 李冬松
     * @date: 2017/10/20 11:43
     */
    public boolean checkNyxInsuranceCodeForbreeding(TxnlistDetailedDto txnlistDetailedDto) throws Exception;
    /**32险类
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     * @author: 李冬松
     * @date: 2017/10/20 11:43
     * @param txnlistDetailedDto 保费计算请求dto
     * @return boolean true为保存成功，false为失败
     * @throws Exception
     */
    public boolean UICheckHerdInsuranceCode(TxnlistDetailedDto txnlistDetailedDto) throws Exception;

    /**
     * 根据标的清单号查询plantingInsuranceList表信息
     * @param requestInsuranceInfoDto 请求入参，具体见dto
     * @return java.util.Map<java.lang.String,com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto> 返回标的清单号对应的plantinginsuranceListDto信息
     * @throws Exception
     * @author 李冬松
     * @date 15:44 2018/1/19
     */
    public Map<String, InsuranceInfoDto> findInsuranceInfo (RequestInsuranceInfoDto requestInsuranceInfoDto)throws Exception;
    /**31大棚蔬菜险类
     * 根据标的清单号查询plantingInsuranceList表信息
     * @param requestInsuranceInfoDto 请求入参，具体见dto
     * @return java.util.Map<java.lang.String,com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto> 返回标的清单号对应的plantinginsuranceListDto信息
     * @throws Exception
     * @author 李冬松
     * @date 15:44 2018/1/19
     */
    public Map<String, InsuranceInfoDto> find31InsuranceInfo (RequestInsuranceInfoDto requestInsuranceInfoDto)throws Exception;
    /**32险类
     *  根据标的清单号查询herdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/2 17:21
     * @param requestInsuranceInfoDto 清单号、标的清单集合
     * @return map中的key值是标的清单号，value值是此标的清单下的农户信息金额集合
     * @throws Exception
     */
    public Map<String, NyxInsuranceInfoDto> findHerdInsuranceInfo (RequestInsuranceInfoDto requestInsuranceInfoDto)throws Exception;

    /**32险类，存nyxinsurancelist
     *  根据标的清单号查询herdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/2 17:21
     * @param requestInsuranceInfoDto 清单号、标的清单集合
     * @return map中的key值是标的清单号，value值是此标的清单下的农户信息金额集合
     * @throws Exception
     */
    public Map<String, NyxInsuranceInfoDto> findNyxInsuranceInfo (RequestInsuranceInfoDto requestInsuranceInfoDto)throws Exception;

    public GisInsureMainListDto queryByPk(String gisInsureMainListCode,String serialNo)throws Exception;

    /**
     * 根据清单编号、序号、标的代码
     *
     * @param insureListCode 清单编号
     * @param serialNo       序号
     * @param itemCode       标的代码
     * @return itemListCode 标的清单编号
     * @author: 何伟东
     * @date: 2018/01/22 20:39
     */
    String queryItemListCodeByPK(String insureListCode, Integer serialNo, String itemCode);

    /**
     * 保存和校验接收的金禾投保预确认清单数据
     *
     * @param gisItemListRequestDto 接收金禾数据的dto
     * @return true-成功
     * @author: 何伟东
     * @date: 2018/01/30 9:08
     */
    Boolean saveAndCheckGisInsureList(GisItemListRequestDto gisItemListRequestDto) throws Exception;

    /**
     * 根据清单号和序号查询田块信息
     *
     * @param String insureMainList
     * @param Integer serialNo
     * @param String fCode
     * @return GisFieldListDto
     * @author: 王保良
     * @date: 2018/01/30 9:08
     */
    public PageInfo queryGisFieldList(String insureMainList,Integer serialNo,String fCode,  String itemCode, Integer pageNo,Integer pageSize) throws Exception;

    /**
     *  根据清单号和序号农户代码查询耳标号信息）
     * @author: 田健
     * @date: 2018/3/7 11:49
     * @param insureMainList 清单号
     * @param serialNo 序列号
     * @param fCode 农户代码
     * @return GisHerdFieldListDto集合  预投保清单农户标的清单明细表（物）Dto
     * @throws Exception
     */
    public PageInfo<GisHerdFieldListDto> queryHerdGisFieldList(String insureMainList,Integer serialNo,String fCode,Integer pageNo,Integer pageSize) throws Exception;
    /**
     * 根据清单号、序列号、标的代码查询农户与耳标号信息
     * @author: 田健
     * @date: 2018/3/1 10:31
     * @param insureListCode 清单号
     * @param serialNo 序列号
     * @param itemListCodes 标的代码集合
     * @return map集合，key是标的清单号，value值是农户信息与耳标号信息Dto
     * @throws Exception
     */
    public Map<String,List<HerdFarmerItemDto>> queryFarmerItemAndHerdFieldListInfo(String insureListCode, String serialNo, List<String> itemListCodes) throws Exception;

    /**
     * @param gisInsureListCode
     * @return
     */
    UnderwritingListDto underwritingListQuery(String gisInsureListCode) throws Exception;

    String markListDownload(String insureListCode, String serialNo, List<String> itemListCodes) throws Exception;

    /**
     * 金禾的清单号和险种的标的匹配，有至少一个匹配时才能出单
     *
     * @param gisInsureListCode - 金禾的清单号码
     * @param serialNo          - 序号
     * @param riskCode          - 险种代码
     * @return message - 成功
     * @author: 何伟东
     * @date: 2018/4/27 11:02
     */
    String matchGisItemList(String gisInsureListCode, String serialNo, String riskCode);
    /**
     * 保费计算时校验标的清单与标的是否匹配（除新单外）
     * @author: 田健
     * @date: 2018/5/17 20:15
     * @param gisInsureListCode 金禾清单编号
     * @param serialNo 序列号
     * @param itemCodeLists 标的代码集合
     * @param itemListCodes 标的清单号集合
     * @return map集合 ，key为1：数据匹配 ，0:数据不匹配
     */
    public Map<String,String> CheckItemCodeListMethod(String gisInsureListCode,Integer serialNo,List<String> itemCodeLists,List<String> itemListCodes);
    public List<GisFarmerItemDto> queryInsureCount(String gisInsureListCode,String serialNo,String itemCode)throws Exception;
    public GisInsureMainListDto querySerialNo(String insureListCode)throws Exception;
}