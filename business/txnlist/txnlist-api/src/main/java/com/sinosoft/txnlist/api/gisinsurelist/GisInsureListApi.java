package com.sinosoft.txnlist.api.gisinsurelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.gisinsurelist.dto.*;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdFarmerItemDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceInfoDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestInsuranceQueryDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 金禾中间表数据操作类Api
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:03
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = GisInsureListApi.PATH)
public interface GisInsureListApi {
    String PATH = "gisInsureListApi";

    /**
     * 根据清单号和序列号查询金禾清单gisFarmerItem表
     * @param map 序列号和清单号map
     * @return gisFarmerItemInfoDtoList 金禾主表部分信息集合
     * @throws Exception
     * @Author: 李冬松
     */
    @RequestMapping(value = "queryGisFarmerItemInfo",method = {RequestMethod.POST})
    public @ResponseBody Map<String, List<GisFarmerItemForPremiumDto>> queryGisFarmerItemInfo(@RequestBody QueryGisFarmerItemDto queryGisFarmerItemDto)throws Exception;

    /**
     * 根据清单号和序列号查询金禾清单gisFarmerItem表
     *
     * @param queryGisFarmerItemDto 序列号和清单号map
     * @return gisFarmerItemInfoDtoList 金禾主表部分信息集合
     * @throws Exception
     * @Author: 钱浩
     */
    @RequestMapping(value = "queryGisZHFarmerItemInfo", method = {RequestMethod.POST})
    public @ResponseBody
    Map<String, List<GisFarmerItemForPremiumDto>> queryGisZHFarmerItemInfo(@RequestBody QueryGisFarmerItemDto queryGisFarmerItemDto) throws Exception;

    /**
     * 根据清单号和序列号查询金禾清单gisFarmerItem表
     * @param map 序列号和清单号map
     * @return gisFarmerItemInfoDtoList 金禾主表部分信息集合
     * @throws Exception
     * @Author: 李冬松
     */
    @RequestMapping(value = "queryGisFarmerItemInfoDetail",method = {RequestMethod.POST})
    public @ResponseBody PageInfo<List<GisFarmerItemDto>> queryGisFarmerItemInfoDetail(@RequestBody QueryGisFarmerItemDto queryGisFarmerItemDto)throws Exception;

    /**
     * 投保预确认清单编号查询，查询 主信息，农户信息，田快信息
     * 如果用户传入insureListCode 则通过 insureListCode 模糊查询，否则全查
     * @param requestInsuranceQueryDto 用户输入的查询条件
     * @return ResponseDto 里的 PageInfo<GisInsureMainListDto>  GisInsureMainListDto是主信息，农户信息，田快信息
     * @author: 李冬松
     * @date: 2018/1/16 下午2:18
     */
    @RequestMapping(value = "findGisInsureMainLists", method = {RequestMethod.POST})
    @ResponseBody PageInfo<GisInsureMainListDto> findAllByInsureListCodeLike(@RequestBody RequestInsuranceQueryDto requestInsuranceQueryDto)throws Exception;

    /**
     * 通过清单号和序列号查询GisItemList信息
     * @param map 清单号和序列号map
     * @return GisItemListDtoList GisItemList表信息集合
     * @throws Exception
     * @author: 李冬松
     */
    @RequestMapping(value = "findGisItemListByInsureListCodeAndserialNo",method = {RequestMethod.POST})
    public @ResponseBody  List<GisItemListDto> findGisItemListByInsureListCodeAndserialNo(@RequestBody Map<String,String> map)throws Exception;
    /**
     * 通过清单号和序列号查询GisItemList信息
     * @param map 清单号和序列号map
     * @return GisFarmerListDtoList GisFarmerList表信息集合
     * @throws Exception
     * @author: 李冬松
     */

    @RequestMapping(value = "findGisFarmerListByInsureListCodeAndserialNo",method = {RequestMethod.POST})
    public @ResponseBody ResponseGisMainAndFarmerListDto findGisFarmerListByInsureListCodeAndserialNo(@RequestBody RequestQueryFarmerDto requestQueryFarmerDto)throws Exception;

    @RequestMapping(value = "findGisFarmerListInfo",method = {RequestMethod.POST})
    public @ResponseBody  List<GisFarmerListDto> findGisFarmerListInfo(@RequestBody Map<String,String> map)throws Exception;
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
    @RequestMapping(value = "checkInsuranceCode",method = {RequestMethod.POST})
    public @ResponseBody
    ResponseDto checkInsuranceCode(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception;

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
    @RequestMapping(value = "check31InsuranceCode",method = {RequestMethod.POST})
    public @ResponseBody  ResponseDto check31InsuranceCode(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception;

    /**
     *没有耳标号的存NYxinsurancelist
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
    @RequestMapping(value = "checkNyxInsuranceCode", method = {RequestMethod.POST})
    public @ResponseBody
    ResponseDto checkNyxInsuranceCode(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception;

    /**
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
    @RequestMapping(value = "checkZHInsuranceCode", method = {RequestMethod.POST})
    public @ResponseBody
    ResponseDto checkZHInsuranceCode(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception;

    /**
     * 带耳标号的存Nyxinsurance
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
    @RequestMapping(value = "checkNyxInsuranceCodeForbreeding", method = {RequestMethod.POST})
    public @ResponseBody
    boolean checkNyxInsuranceCodeForbreeding(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception;
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
    @RequestMapping(value = "UICheckHerdInsuranceCode",method = {RequestMethod.POST})
    public @ResponseBody ResponseDto UICheckHerdInsuranceCode(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception;

    /**
     * 根据标的清单号查询plantingInsuranceList表信息
     * @param requestInsuranceInfoDto 请求入参，具体见dto
     * @return java.util.Map<java.lang.String,com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto> 返回标的清单号对应的plantinginsuranceListDto信息
     * @throws Exception
     * @author 李冬松
     * @date 15:44 2018/1/19
     */
    @RequestMapping(value = "findInsuranceInfo",method = {RequestMethod.POST})
    public @ResponseBody  Map<String,InsuranceInfoDto> findInsuranceInfo(@RequestBody RequestInsuranceInfoDto requestInsuranceInfoDto)throws Exception;

    /**31大棚蔬菜险类
     * 根据标的清单号查询plantingInsuranceList表信息
     * @param requestInsuranceInfoDto 请求入参，具体见dto
     * @return java.util.Map<java.lang.String,com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto> 返回标的清单号对应的plantinginsuranceListDto信息
     * @throws Exception
     * @author 李冬松
     * @date 15:44 2018/1/19
     */
    @RequestMapping(value = "find31InsuranceInfo",method = {RequestMethod.POST})
    public @ResponseBody  Map<String,InsuranceInfoDto> find31InsuranceInfo(@RequestBody RequestInsuranceInfoDto requestInsuranceInfoDto)throws Exception;
    /**32险类
     *  根据标的清单号查询herdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/2 17:21
     * @param requestInsuranceInfoDto 清单号、标的清单集合
     * @return map中的key值是标的清单号，value值是此标的清单下的农户信息金额集合
     * @throws Exception
     */
    @RequestMapping(value = "findHerdInsuranceInfo",method = {RequestMethod.POST})
    public @ResponseBody Map<String, NyxInsuranceInfoDto> findHerdInsuranceInfo (@RequestBody RequestInsuranceInfoDto requestInsuranceInfoDto)throws Exception;
    /**32险类,存nyxinsurancelist
     *  根据标的清单号查询herdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/2 17:21
     * @param requestInsuranceInfoDto 清单号、标的清单集合
     * @return map中的key值是标的清单号，value值是此标的清单下的农户信息金额集合
     * @throws Exception
     */
    @RequestMapping(value = "findNyxInsuranceInfo",method = {RequestMethod.POST})
    public @ResponseBody Map<String, NyxInsuranceInfoDto> findNyxInsuranceInfo(@RequestBody RequestInsuranceInfoDto requestInsuranceInfoDto)throws Exception;


    @RequestMapping(value = "queryByPk",method = RequestMethod.POST)
    public GisInsureMainListDto queryByPk(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 根据清单编号、序号、标的代码
     *
     * @param param insureListCode-清单编号，serialNo-序号，itemCode-标的代码
     * @return itemListCode-标的清单编号
     * @author: 何伟东
     * @date: 2018/01/22 20:39
     */
    @RequestMapping(value = "queryItemListCodeByPK", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> queryItemListCodeByPK(@RequestBody Map<String, Object> param);

    /**
     * 保存和校验接收的金禾投保预确认清单数据
     *
     * @param gisItemListRequestDto 接收金禾数据的dto
     * @return true-成功
     * @author: 何伟东
     * @date: 2018/01/30 9:08
     */
    @RequestMapping(value = "saveAndCheckGisInsureList", method = RequestMethod.POST)
    @ResponseBody
    String saveAndCheckGisInsureList(@RequestBody GisItemListRequestDto gisItemListRequestDto) throws Exception;


    /**
     * 根据清单号和序号查询田块信息
     *
     * @param map key为 insurelistcode 和 serialno
     * @return GisFieldListDto
     * @author: 王保良
     * @date: 2018/01/30 9:08
     */
    @RequestMapping(value = "queryGisFieldList",method = RequestMethod.POST)
    public @ResponseBody PageInfo queryGisFieldList(@RequestBody Map<String,Object> map) throws Exception;
    /**
     *  根据清单号和序号农户代码查询耳标号信息）
     * @author: 田健
     * @date: 2018/3/7 11:47
     * @param map key为 insurelistcode 和 serialno，农户代码
     * @return GisHerdFieldListDto集合  预投保清单农户标的清单明细表（物）Dto
     * @throws Exception
     */
    @RequestMapping(value = "queryHerdGisFieldList",method = RequestMethod.POST)
    public @ResponseBody PageInfo<GisHerdFieldListDto> queryHerdGisFieldList(@RequestBody Map<String,Object> map) throws Exception;
    /**
     * 根据清单号、序列号、标的代码查询农户与耳标号信息
     * @author: 田健
     * @date: 2018/3/1 14:47
     * @param queryGisFarmerItemDto  序列号和清单号map
     * @return map集合，key是标的清单号，value值是农户信息与耳标号信息Dto
     * @throws Exception
     */
    @RequestMapping(value = "queryFarmerItemAndHerdFieldListInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,List<HerdFarmerItemDto>> queryFarmerItemAndHerdFieldListInfo(@RequestBody QueryGisFarmerItemDto queryGisFarmerItemDto) throws Exception;


    /**
     * 金禾系统调用交易清单接口查看保单信息
     *
     * @param map
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 13/03/2018 9:39 AM
     */
    @RequestMapping(value = "underwritingListQuery", method = RequestMethod.POST)
    UnderwritingListDto underwritingListQuery(@RequestBody Map<String, String> map) throws Exception;


    /**
     * 标的清单下载
     *
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 19/03/2018 11:10 AM
     */
    @RequestMapping(value = "markListDownload", method = RequestMethod.POST)
    Map<String, String> markListDownload(@RequestBody QueryGisFarmerItemDto queryGisFarmerItemDto) throws Exception;

    /**
     * 金禾的清单号和险种的标的匹配，有至少一个匹配时才能出单
     *
     * @param param gisInsureListCode - 金禾的清单号码, serialNo - 序号, riskCode - 险种代码
     * @return message - 成功
     * @author: 何伟东
     * @date: 2018/4/27 11:02
     */
    @PostMapping(value = "matchGisItemList")
    @ResponseBody
    Map<String, String> matchGisItemList(@RequestBody Map<String, String> param);
    /**
     * 保费计算时校验标的清单与标的是否匹配（除新单外）
     * @author: 田健
     * @date: 2018/5/17 20:15
     * @param  map 中的key为 gisInsureListCode 金禾清单编号、serialNo 序列号、itemCode 标的代码、itemCodeList 标的清单号
     * @return map集合 ，key为1：数据匹配 ，0:数据不匹配
     */
    @RequestMapping(value = "CheckItemCodeListMethod", method = RequestMethod.POST)
    @ResponseBody Map<String,String> CheckItemCodeListMethod(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "queryInsureCount", method = RequestMethod.POST)
    @ResponseBody List<GisFarmerItemDto> queryInsureCount(@RequestBody Map<String, String> map) throws Exception;

    @RequestMapping(value = "querySerialNo", method = RequestMethod.POST)
    @ResponseBody GisInsureMainListDto querySerialNo(@RequestBody Map<String, String> map) throws Exception;
}