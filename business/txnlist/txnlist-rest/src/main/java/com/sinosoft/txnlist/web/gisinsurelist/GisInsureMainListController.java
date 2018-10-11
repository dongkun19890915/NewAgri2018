package com.sinosoft.txnlist.web.gisinsurelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.txnlist.api.gisinsurelist.GisInsureListApi;
import com.sinosoft.txnlist.api.gisinsurelist.dto.*;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdFarmerItemDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceInfoDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestInsuranceQueryDto;
import com.sinosoft.txnlist.core.gisinsurelist.service.GisInsureListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 金禾中间表数据操作类Controller
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:54
 */
@RestController
@RequestMapping(value = GisInsureMainListController.PATH)
public class GisInsureMainListController implements GisInsureListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(GisInsureMainListController.class);

    @Autowired
    private GisInsureListService gisInsureListService;

    /**
     * 根据序列号和清单号查询gisFarmerItem表部分信息
     * @param queryGisFarmerItemDto 序列号和清单号map
     * @return gisFarmerItemInfoDtoList gisFarmerItem表信息集合
     * @throws Exception
     * @Author: 李冬松
     */
    @Override
    public @ResponseBody Map<String, List<GisFarmerItemForPremiumDto>> queryGisFarmerItemInfo(@RequestBody QueryGisFarmerItemDto queryGisFarmerItemDto) throws Exception {
        return gisInsureListService.queryGisFarmerItemInfo(queryGisFarmerItemDto.getInsureListCode()
                                                           ,queryGisFarmerItemDto.getSerialNo()
                                                           ,queryGisFarmerItemDto.getItemListCodes());
    }

    /**
     * 根据清单号和序列号查询金禾清单gisFarmerItem表
     *
     * @param queryGisFarmerItemDto 序列号和清单号map
     * @return gisFarmerItemInfoDtoList 金禾主表部分信息集合
     * @throws Exception
     * @Author: 钱浩
     */
    @Override
    public @ResponseBody
    Map<String, List<GisFarmerItemForPremiumDto>> queryGisZHFarmerItemInfo(@RequestBody QueryGisFarmerItemDto queryGisFarmerItemDto) throws Exception {
        return gisInsureListService.queryGisZHFarmerItemInfo(queryGisFarmerItemDto.getInsureListCode()
                , queryGisFarmerItemDto.getSerialNo()
                , queryGisFarmerItemDto.getItemListCodes(), queryGisFarmerItemDto.getKindCodeList());
    }

    /**
     * 根据序列号和清单号查询gisFarmerItem表部分信息
     * @param queryGisFarmerItemDto 序列号和清单号map
     * @return gisFarmerItemInfoDtoList gisFarmerItem表信息集合
     * @throws Exception
     * @Author: 李冬松
     */
    @Override
    public @ResponseBody PageInfo<List<GisFarmerItemDto>> queryGisFarmerItemInfoDetail(@RequestBody QueryGisFarmerItemDto queryGisFarmerItemDto) throws Exception {
        return gisInsureListService.queryGisFarmerItemInfoDetail(queryGisFarmerItemDto.getInsureListCode()
                ,queryGisFarmerItemDto.getSerialNo(),queryGisFarmerItemDto.getItemListCodes(),queryGisFarmerItemDto.getPageNo(),queryGisFarmerItemDto.getPageSize());
    }
    /**
     * 投保预确认清单编号查询，查询 主信息，农户信息，田快信息
     * 如果用户传入insureListCode 则通过 insureListCode 模糊查询，否则全查
     * @param requestInsuranceQueryDto 用户输入的查询条件
     * @return ResponseDto 里的 PageInfo<GisInsureMainListDto>  GisInsureMainListDto是主信息，农户信息，田快信息
     * @author: 潘峰
     * @date: 2017/11/6 下午2:18
     */
    @Override
    public PageInfo<GisInsureMainListDto> findAllByInsureListCodeLike(@RequestBody RequestInsuranceQueryDto requestInsuranceQueryDto)throws Exception {
        PageInfo<GisInsureMainListDto> gisInsureMainListDtos = gisInsureListService.findGisInsureMainList(requestInsuranceQueryDto);
        return gisInsureMainListDtos;
    }
    /**
     * 通过清单号和序列号查询GisItemList信息
     * @param map 清单号和序列号map
     * @return GisItemListDtoList GisItemList表信息集合
     * @throws Exception
     * @author: 李冬松
     */
    @Override
    public List<GisItemListDto> findGisItemListByInsureListCodeAndserialNo(@RequestBody Map<String, String> map) throws Exception {
        return gisInsureListService.findGisItemListByInsureListCodeAndserialNo(map.get("insureListCode"),map.get("serialNo"));
    }
    /**
     * 通过清单号和序列号查询GisFarmerList信息与GisInsureMainList投保预确认数据主表信息
     * @param requestQueryFarmerDto 清单号和序列号map
     * @return GisItemListDtoList GisFarmerList表信息集合
     * @throws Exception
     * @author: 李冬松
     */
    @Override
    public @ResponseBody ResponseGisMainAndFarmerListDto findGisFarmerListByInsureListCodeAndserialNo(@RequestBody RequestQueryFarmerDto requestQueryFarmerDto) throws Exception {
            return gisInsureListService.findGisFarmerListByInsureListCodeAndserialNo(requestQueryFarmerDto);
    }

    @Override
    public List<GisFarmerListDto> findGisFarmerListInfo(Map<String, String> map) throws Exception {
        return gisInsureListService.findGisFarmerListInfo(map.get("insureListCode"),map.get("serialNo"),map.get("itemCode"));
    }
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
    @Override
    public ResponseDto checkInsuranceCode(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        try {
            boolean flag = gisInsureListService.checkInsuranceCode(txnlistDetailedDto);
            responseDto.setResultObj(flag);
            responseDto.setResultCode("0000");
        }catch (Exception e){
            responseDto.setResultObj(false);
            responseDto.setResultMsg(e.getMessage());
            responseDto.setResultCode("9999");
        }
        return responseDto;
    }
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
    @Override
    public ResponseDto check31InsuranceCode(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        try {
            boolean flag = gisInsureListService.check31InsuranceCode(txnlistDetailedDto);
            responseDto.setResultObj(flag);
            responseDto.setResultCode("0000");
        }catch (Exception e){
            responseDto.setResultObj(false);
            responseDto.setResultMsg(e.getMessage());
            responseDto.setResultCode("9999");
        }
        return responseDto;
    }
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
    @Override
    public ResponseDto checkNyxInsuranceCode(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        try {
            boolean flag = gisInsureListService.checkNyxInsuranceCode(txnlistDetailedDto);
            responseDto.setResultObj(flag);
            responseDto.setResultCode("0000");
        }catch (Exception e){
            responseDto.setResultObj(false);
            responseDto.setResultMsg(e.getMessage());
            responseDto.setResultCode("9999");
        }
        return responseDto;
    }

    /**
     * 组合险类
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
    @Override
    public ResponseDto checkZHInsuranceCode(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        try {
            boolean flag = gisInsureListService.checkZHInsuranceCode(txnlistDetailedDto);
            responseDto.setResultObj(flag);
            responseDto.setResultCode("0000");
        }catch (Exception e){
            responseDto.setResultObj(false);
            responseDto.setResultMsg(e.getMessage());
            responseDto.setResultCode("9999");
        }
        return responseDto;
    }
    /**
     * 带耳标号的存NyxinsuranceList
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
    @Override
    public boolean checkNyxInsuranceCodeForbreeding(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        return gisInsureListService.checkNyxInsuranceCodeForbreeding(txnlistDetailedDto);
    }
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
    @Override
    public ResponseDto UICheckHerdInsuranceCode(@RequestBody TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        try {
            boolean flag = gisInsureListService.UICheckHerdInsuranceCode(txnlistDetailedDto);
            responseDto.setResultObj(flag);
            responseDto.setResultCode("0000");
        }catch (Exception e){
            responseDto.setResultObj(false);
            responseDto.setResultMsg(e.getMessage());
            responseDto.setResultCode("9999");
        }
        return responseDto;
    }
    /**31险类
     * 根据标的清单号查询plantingInsuranceList表信息
     * @param requestInsuranceInfoDto 请求入参，具体见dto
     * @return java.util.Map<java.lang.String,com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto> 返回标的清单号对应的plantinginsuranceListDto信息
     * @throws Exception
     * @author 李冬松
     * @date 15:44 2018/1/19
     */
    @Override
    public Map<String, InsuranceInfoDto> findInsuranceInfo(@RequestBody RequestInsuranceInfoDto requestInsuranceInfoDto) throws Exception {
        return gisInsureListService.findInsuranceInfo(requestInsuranceInfoDto);
    }
    /**31大棚蔬菜险类
     * 根据标的清单号查询plantingInsuranceList表信息
     * @param requestInsuranceInfoDto 请求入参，具体见dto
     * @return java.util.Map<java.lang.String,com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto> 返回标的清单号对应的plantinginsuranceListDto信息
     * @throws Exception
     * @author 李冬松
     * @date 15:44 2018/1/19
     */
    @Override
    public Map<String, InsuranceInfoDto> find31InsuranceInfo(@RequestBody RequestInsuranceInfoDto requestInsuranceInfoDto) throws Exception {
        return gisInsureListService.find31InsuranceInfo(requestInsuranceInfoDto);
    }
    /**32险类
     *  根据标的清单号查询herdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/2 17:21
     * @param requestInsuranceInfoDto 清单号、标的清单集合
     * @return map中的key值是标的清单号，value值是此标的清单下的农户信息金额集合
     * @throws Exception
     */
    @Override
    public Map<String, NyxInsuranceInfoDto> findHerdInsuranceInfo (@RequestBody RequestInsuranceInfoDto requestInsuranceInfoDto)throws Exception{
        return gisInsureListService.findHerdInsuranceInfo(requestInsuranceInfoDto);
    }
    /**32险类，存nyxinsurancelist
     *  根据标的清单号查询herdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/2 17:21
     * @param requestInsuranceInfoDto 清单号、标的清单集合
     * @return map中的key值是标的清单号，value值是此标的清单下的农户信息金额集合
     * @throws Exception
     */
    @Override
    public Map<String, NyxInsuranceInfoDto> findNyxInsuranceInfo (@RequestBody RequestInsuranceInfoDto requestInsuranceInfoDto)throws Exception{
        return gisInsureListService.findNyxInsuranceInfo(requestInsuranceInfoDto);
    }
    @Override
    public GisInsureMainListDto queryByPk(@RequestBody Map<String, String> map) throws Exception {
        return gisInsureListService.queryByPk(map.get("gisInsureMainListCode"),map.get("serialNo"));
    }

    /**
     * 根据清单编号、序号、标的代码
     *
     * @param param insureListCode-清单编号，serialNo-序号，itemCode-标的代码
     * @return itemListCode-标的清单编号
     * @author: 何伟东
     * @date: 2018/01/22 20:39
     */
    @Override
    public Map<String, String> queryItemListCodeByPK(@RequestBody Map<String, Object> param) {
        String insureListCode = (String) param.get("insureListCode");
        Integer serialNo = (Integer) param.get("serialNo");
        String itemCode = (String) param.get("itemCode");
        String itemListCode = gisInsureListService.queryItemListCodeByPK(insureListCode, serialNo, itemCode);
        Map<String,String> returnMap = new HashMap<>(1);
        returnMap.put("itemListCode",itemListCode);
        return returnMap;
    }

    /**
     * 保存和校验接收的金禾投保预确认清单数据
     *
     * @param gisItemListRequestDto 接收金禾数据的dto
     * @return true-成功
     * @author: 何伟东
     * @date: 2018/01/30 9:08
     */
    @Override
    public @ResponseBody String saveAndCheckGisInsureList(@RequestBody GisItemListRequestDto gisItemListRequestDto) throws Exception {
        String returnMessage = "";
        try {
            gisInsureListService.saveAndCheckGisInsureList(gisItemListRequestDto);
        } catch (Exception e) {
            e.printStackTrace();
            returnMessage = e.getMessage();
        }
        return returnMessage;
    }

    /**
     * 根据清单号和序号查询田块信息
     *
     * @param map key为 insurelistcode 和 serialno
     * @return GisFieldListDto
     * @author: 王保良
     * @date: 2018/01/30 9:08
     */
    @Override
    public @ResponseBody PageInfo queryGisFieldList(@RequestBody Map<String, Object> map) throws Exception {
        return gisInsureListService.queryGisFieldList((String) map.get("insureListCode"),(Integer) map.get("serialNo"),(String) map.get("fCode"),(String) map.get("itemCode"),(Integer) map.get("pageNo"),(Integer) map.get("pageSize"));
    }
    /**
     *  根据清单号和序号农户代码查询耳标号信息）
     * @author: 田健
     * @date: 2018/3/7 11:47
     * @param map key为 insurelistcode 和 serialno，农户代码
     * @return GisHerdFieldListDto集合  预投保清单农户标的清单明细表（物）Dto
     * @throws Exception
     */
    @Override
    public @ResponseBody PageInfo<GisHerdFieldListDto> queryHerdGisFieldList(@RequestBody Map<String,Object> map) throws Exception{
        return gisInsureListService.queryHerdGisFieldList((String) map.get("insureListCode"),(Integer) map.get("serialNo"),(String) map.get("fCode"),(Integer) map.get("pageNo"),(Integer) map.get("pageSize"));
    }
    /**
     * 根据清单号、序列号、标的代码查询农户与耳标号信息
     * @author: 田健
     * @date: 2018/3/1 14:47
     * @param queryGisFarmerItemDto  序列号和清单号map
     * @return map集合，key是标的清单号，value值是农户信息与耳标号信息Dto
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String,List<HerdFarmerItemDto>> queryFarmerItemAndHerdFieldListInfo(@RequestBody QueryGisFarmerItemDto queryGisFarmerItemDto) throws Exception {
        return gisInsureListService.queryFarmerItemAndHerdFieldListInfo(queryGisFarmerItemDto.getInsureListCode()
                ,queryGisFarmerItemDto.getSerialNo()
                ,queryGisFarmerItemDto.getItemListCodes());
    }

    /**
     * 金禾系统调用交易清单接口查看保单信息
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public UnderwritingListDto underwritingListQuery(@RequestBody Map<String, String> map) throws Exception {
        return gisInsureListService.underwritingListQuery(map.get("gisInsureListCode"));
    }


    @Override
    public Map<String, String> markListDownload(@RequestBody QueryGisFarmerItemDto queryGisFarmerItemDto) throws Exception {
        Map<String, String> map = new HashMap<>();
        String s = gisInsureListService.markListDownload(queryGisFarmerItemDto.getInsureListCode()
                , queryGisFarmerItemDto.getSerialNo(), queryGisFarmerItemDto.getItemListCodes());
        map.put("message", s);
        return map;
    }

    /**
     * 金禾的清单号和险种的标的匹配，有至少一个匹配时才能出单
     *
     * @param param gisInsureListCode - 金禾的清单号码, serialNo - 序号, riskCode - 险种代码
     * @return message - 成功
     * @author: 何伟东
     * @date: 2018/4/27 11:02
     */
    @Override
    public @ResponseBody
    Map<String, String> matchGisItemList(@RequestBody Map<String, String> param) {
        String message = gisInsureListService.matchGisItemList(param.get("gisInsureListCode"), param.get("serialNo"), param.get("riskCode"));
        Map<String, String> returnMap = new HashMap<>(1);
        returnMap.put("message", message);
        return returnMap;
    }
    /**
     * 保费计算时校验标的清单与标的是否匹配（除新单外）
     * @author: 田健
     * @date: 2018/5/17 20:15
     * @param  map 中的key为 gisInsureListCode 金禾清单编号、serialNo 序列号、itemCode 标的代码集合、itemCodeList 标的清单号集合
     * @return map集合 ，key为1：数据匹配 ，0:数据不匹配
     */
    public @ResponseBody Map<String,String> CheckItemCodeListMethod(@RequestBody Map<String, Object> map){
        String gisInsureListCode = (String)map.get("gisInsureListCode");
        Integer serialNo = (Integer) map.get("serialNo");
        List<String> itemCodeLists = (List<String>) map.get("itemCodeLists");//标的集合
        List<String> itemListCodes = (List<String>) map.get("itemListCodes");//标的清单集合
        return gisInsureListService.CheckItemCodeListMethod(gisInsureListCode,serialNo,itemCodeLists,itemListCodes);
    }

    @Override
    public @ResponseBody List<GisFarmerItemDto> queryInsureCount(@RequestBody Map<String, String> map) throws Exception {
        return gisInsureListService.queryInsureCount(map.get("gisInsureListCode"),map.get("serialNo"),map.get("itemCode"));
    }

    @Override
    public @ResponseBody GisInsureMainListDto querySerialNo(@RequestBody Map<String, String> map) throws Exception {
        return gisInsureListService.querySerialNo(map.get("insureListCode"));
    }
}
