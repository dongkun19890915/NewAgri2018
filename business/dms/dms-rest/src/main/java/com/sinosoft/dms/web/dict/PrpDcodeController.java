package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.*;
import com.sinosoft.dms.core.dict.service.PrpCountryCodeService;
import com.sinosoft.dms.core.dict.service.PrpDcodeService;
import com.sinosoft.dms.core.dict.service.PrpTownCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 08:34:23.982
 * @description 通用代码表controller层
 */
@RestController
@RequestMapping(value = PrpDcodeController.PATH)
public class PrpDcodeController implements PrpDcodeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDcodeController.class);

    @Autowired
    private PrpDcodeService prpDcodeService;
    @Autowired
    private PrpTownCodeService prpTownCodeService;
    @Autowired
    private PrpCountryCodeService prpCountryCodeService;
   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpDcodeDto prpDcodeDto) {
        prpDcodeService.save(prpDcodeDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestParam("codeType") String codeType,@RequestParam("codeCode") String codeCode) {
        prpDcodeService.remove(codeType,codeCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDcodeDto prpDcodeDto) {
        prpDcodeService.modify(prpDcodeDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public @ResponseBody PrpDcodeDto queryByPK(@RequestParam("codeType") String codeType,@RequestParam("codeCode") String codeCode) {
        return prpDcodeService.queryByPK(codeType,codeCode);
    }

    @Override
    public PrpDcodeDto querybyPk(@RequestBody Map<String, String> map) throws Exception {
        return prpDcodeService.queryByPK(map.get("codeType"),map.get("codeCode"));
    }

    /**
     * @author 王心洋
     * @description 根据codeType,codeCode,languageFlag 查询一条中文或英文名称
     * @param codeType,codeCode,languageFlag
     * @return 代码对应名称
     * @time 2017-10-29
     */
    @Override
    public String translateCode(@RequestParam("codeType") String codeType,@RequestParam("codeCode") String codeCode,@RequestParam("languageFlag") String languageFlag) {
        return prpDcodeService.translateCode(codeType,codeCode,languageFlag);
    }

    /**
     * 根据codeType 代码类型、riskCode险种查询prpDCode实体
     * @author: 田健
     * @date: 2017/11/5 15:33
     * @param codeType 代码类型
     * @return prpDcodeDto 集合
     */
    @Override
    public @ResponseBody List<PrpDcodeDto> queryCodeInfoByCodeType(@RequestParam("codeType") String codeType,@RequestParam("riskCode") String riskCode) {
        return prpDcodeService.queryCodeInfoByCodeType(codeType,riskCode);
    }

    /**
     * 根据codeType 代码类型、riskCode险种查询prpDCode实体
     * @author: 田健
     * @date: 2017/10/22 16:42
     * @param map key中的codeType是代码类型、riskCode是险种
     * @return prpDCodeDto 集合
     */
    @Override
    public @ResponseBody List<PrpDcodeDto> queryCodeInfoByCodeTypeAndRiskCode(@RequestBody Map<String,String> map) {
        String codeType = map.get("codeType");
        String riskCode = map.get("riskCode");
        return prpDcodeService.queryCodeInfoByCodeType(codeType,riskCode);
    }

    /**
     * 根据codeType,codeCName,riskCode获取业务代码中文含义业务代码的codeCode
     * @author: 田健
     * @date: 2017/11/5 15:30
     * @param codeType 代码类型
     * @param codeCName 业务名称
     * @param riskCode 险种代码
     * @return 业务代码
     */
    @Override
    public @ResponseBody String translateName(@RequestParam("codeType") String codeType,@RequestParam("codeCName") String codeCName,@RequestParam("riskCode") String riskCode){
        return prpDcodeService.translateName(codeType,codeCName,riskCode);
    }

    /**
     * 根据iCodeType，iRiskCode，hpFlag查询prpdcode表获取列表数据
     * @author: 田健
     * @date: 2017/10/21 16:29
     * @param * @param map 中key codeType是代码类型、riskCode 险种代码、hpFlag 贫困标志
     * @return  prpDcodeDto 集合
     */
    @Override
    @Deprecated
    public @ResponseBody List<PrpDcodeDto> getOptionCode(@RequestBody Map<String,Object> map) {
        String codeType = (String) map.get("codeType");
        String riskCode = (String) map.get("riskCode");
        int hpFlag = (Integer) map.get("hpFlag");
        return prpDcodeService.getOptionCode(codeType,riskCode,hpFlag);
    }
    /**
     * 根据codeType，riskCode查询prpdcode列表信息
     * @author: 田健
     * @date: 2017/10/21 17:46
     * @param requestPrpDcodeListDto 查询 prpDcode大Dto 包含 codeType 代码类型 和riskCode 险种代码
     * @return ResponsePrpDcodeListDto 返回大对象，包含codeType与实体集合
     */
    @Override
    public @ResponseBody ResponsePrpDcodeListDto getOptionCode(@RequestBody RequestPrpDcodeListDto requestPrpDcodeListDto) throws Exception{
        ResponsePrpDcodeListDto responsePrpDcodeListDto=prpDcodeService.getOptionCode(requestPrpDcodeListDto);
        return responsePrpDcodeListDto;
    }

    /**
     * codeType和feildExt查询归属区域信息
     * @author: 王保良
     * @date: 2017/11/16 17:46
     * @param (map 代码类型(Businessprovince,BusinessTown,BUsinessCountry
     * BusinessCity,BusinessAreaName),feildExt)
     * @return ResponseDto(返回的是满足条件的PrpDcode实体类对象)
     */
//    @Override
//    public Object queryAreasProvinceInfo(Map<String,String> map) throws Exception {
//        String codeType = map.get("codeType");
//        String fieldExt = map.get("fieldExt");
////      根据传入的codeType的不同,调用不用的service的方法查询归属机构
//        if ("BusinessProvince".equals(codeType) || "BusinessTown".equals(codeType) || "BusinessCountry".equals(codeType)) {
//             return prpDcodeService.queryAreasProvinceInfo(codeType,fieldExt);
//        }else if ("BusinessCity".equals(codeType)){
//            return prpTownCodeService.queryAreasProvinceInfo(codeType,fieldExt);
//        }else if ("BusinessAreaName".equals(codeType)){
//            return prpCountryCodeService.queryAreasProvinceInfo(codeType,fieldExt);
//        }else {
//            throw new DataVerifyException("请传入正确的codeType");
//        }
//    }
    @Override
    public List<PrpDcodeDto> queryAreasProvinceInfo(@RequestBody Map<String,String> map) throws Exception {
        String codeType = map.get("codeType");
        String fieldExt = map.get("fieldExt");
        return prpDcodeService.queryAreasProvinceInfo(codeType,fieldExt);
    }

    /**
     * 根据险种、编辑类型、业务名称、业务代码查询业务代码表数据集
     * @author: 杨成程
     * @date: 2017/12/03 15:30
     * @param requestDto
     * @return
     */
    @Override
     public @ResponseBody List<PrpDcodeDto> queryCodeInfoByCodeName(@RequestBody RequestQueryCodeInfoDto requestDto) throws Exception{
         return prpDcodeService.queryCodeInfoByCodeName(requestDto);
     }
	/**
     * @description: 根据类型  和code编码的集合查询信息，如投保数量对应的单位信息 codeCodeList是codecode字符串由"-"拼接而成</p>
     * @auther chong
     * @date 2017年11月3日下午5:37:04
     * @param codeType
     * @param codeCodeList
     * @return prpDcodeDtoList
     */
	@Override
	@ResponseBody
	public List<PrpDcodeDto> queryByCondition(@RequestParam("codeType") String codeType,@RequestParam("codeCodeList") String codeCodeList) {
		return prpDcodeService.queryByCondition(codeType, codeCodeList);
	}
    /**
     * （根据主键查询代码对应中文）
     * @param codeType 代码类别
     * @param codeCode 代码
     * @return 代码对应中文
     * @author: 董坤
     * @date: 2017/11/18 10:09
     */
    @Override
    public @ResponseBody String translateCodeByPK(String codeType, String codeCode) {
        return prpDcodeService.translateCodeByPK(codeType,codeCode);
    }
    /**
     *  根据客户类型查询证件类型
     * @author: 田慧
     * @date: 2017/12/23 11:25
     * @param map 键为flag
     * @return dentifyType 证件类型
     * @throws Exception
     */
    @Override
    public PrpDcodeRetuenDto queryIdentifyType(@RequestBody Map<String,String> map)throws Exception{
        String flag = map.get("flag");
        return prpDcodeService.queryIdentifyType(flag);
    }

    /**
     * @description:方法功能简述:根据类型和险种编码查询下下拉信息
     * @author 安齐崇
     * @date 2017年11月10日下午7:06:37
     * @param codeType 查询类型
     * @param riskCode 险种编码
     */
	@Override
	@ResponseBody
	public List<PrpDcodeDto> queryOptionBox(@RequestParam("codeType") String codeType,@RequestParam("riskCode") String riskCode) {
		return prpDcodeService.queryOptionBox(codeType,riskCode);
	}
    /**
     * 根据多个代码查询对应的证件类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 证件类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public @ResponseBody
    Map<String, String> queryCertifyTypeByCodes(@RequestBody List<String> codes) {
        return prpDcodeService.queryCertifyTypeByCodes(codes);
    }

    /**
     * 根据多个代码查询对应的领款人类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 领款人类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public @ResponseBody
    Map<String, String> queryReceiverTypesByCodes(@RequestBody List<String> codes) {
        return prpDcodeService.queryReceiverTypesByCodes(codes);
    }

    /**
     * 根据多个代码查询对应的银行账号属性中文名称键值对
     *
     * @param codes 代码集合
     * @return 银行账号属性代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public @ResponseBody
    Map<String, String> queryAccountTypeByCodes(@RequestBody List<String> codes) {
        return prpDcodeService.queryAccountTypeByCodes(codes);
    }

    /**
     * 根据多个代码查询对应的银行账号类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 银行账号类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public @ResponseBody
    Map<String, String> queryAccountFlagByCodes(@RequestBody List<String> codes) {
        return prpDcodeService.queryAccountFlagByCodes(codes);
    }

    /**
     * 根据多个代码查询对应的费用类型中文名
     *
     * @param costType 费用类型
     * @return 费用类型名称
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public @ResponseBody
    Map<String, String> queryCostTypeByCode(@RequestBody Map<String, String> costType) {
        String costTypeName = prpDcodeService.queryCostTypeByCode(costType.get("costType"));
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("costTypeName", costTypeName);
        return returnMap;
    }

    /**
     * 根据多个代码查询对应的短期费率方式中文名称键值对
     *
     * @param codes 代码集合
     * @return 短期费率方式代码-短期费率方式名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public @ResponseBody
    Map<String, String> queryShortRateFlagByCodes(@RequestBody List<String> codes) {
        return prpDcodeService.queryShortRateFlagByCodes(codes);
    }

    /**
     * 根据代码类型和代码查出对应的代码数据，代码可以为空
     *
     * @param param codeType-代码类型，codeCode-代码
     * @return prpdcode的集合
     * @date: 2018/2/12 11:17
     * @author: 何伟东
     */
    @Override
    public @ResponseBody
    List<PrpDcodeDto> queryCodeInfoByTypeAndCode(@RequestBody Map<String, String> param) {
        return prpDcodeService.queryCodeInfoByTypeAndCode(param.get("codeType"), param.get("codeCode"));
    }

    @Override
    public List<PrpDcodeDto> queryReportType() throws Exception {
        return prpDcodeService.queryReportType();
    }
}

