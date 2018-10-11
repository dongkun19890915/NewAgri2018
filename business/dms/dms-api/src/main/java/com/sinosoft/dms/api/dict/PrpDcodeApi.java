package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 08:34:23.982 
 * @description 通用代码表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDcodeApi.PATH)
public interface PrpDcodeApi {

    public static final String PATH = "prpDcode";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDcodeDto prpDcodeDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("codeType") String codeType, @RequestParam("codeCode") String codeCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDcodeDto prpDcodeDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody PrpDcodeDto queryByPK(@RequestParam("codeType") String codeType, @RequestParam("codeCode") String codeCode);

    /**
     *@description 按主键查询实体(用map封装的版本,原来没有封装,要改太麻烦了,所以重写一个)
     *@param
     */
    @RequestMapping(value = "queryByPk",method = RequestMethod.POST)
    @ResponseBody PrpDcodeDto querybyPk(@RequestBody Map<String,String> map) throws Exception;
    /**
     * @author 王心洋
     * @description 根据codeType,codeCode,languageFlag查询一条中文或英文名称
     * @param codeType,codeCode,languageFlag
     * @return 代码对应名称
     * @time 2017-10-29
     */
    @RequestMapping(value = "translateCode",method = {RequestMethod.POST})
    @ResponseBody String translateCode(@RequestParam("codeType") String codeType, @RequestParam("codeCode") String codeCode, @RequestParam("languageFlag") String languageFlag);


    /**
     * 根据codeType 代码类型、riskCode险种查询prpDCode实体
     * @author: 田健
     * @date: 2017/10/22 16:42
     * @param codeType 代码类型
     * @return prpDCodeDto 集合
     */
    @RequestMapping(value = "queryCodeInfoByCodeType",method = {RequestMethod.POST})
    @ResponseBody List<PrpDcodeDto> queryCodeInfoByCodeType(@RequestParam("codeType") String codeType, @RequestParam("riskCode") String riskCode);

    /**
     * 根据codeType 代码类型、riskCode险种查询prpDCode实体
     * @author: 田健
     * @date: 2017/10/22 16:42
     * @param map key中的codeType是代码类型、riskCode是险种
     * @return prpDCodeDto 集合
     */
    @RequestMapping(value = "queryCodeInfoByCodeTypeAndRiskCode",method = {RequestMethod.POST})
    @ResponseBody List<PrpDcodeDto> queryCodeInfoByCodeTypeAndRiskCode(@RequestBody Map<String,String> map);

    /**
     * 根据codeType,codeCName,riskCode获取业务代码中文含义业务代码的codeCode
     * @author: 田健
     * @date: 2017/11/5 15:30
     * @param codeType 代码类型
     * @param CodeCName 业务名称
     * @param riskCode 险种代码
     * @return 业务代码
     */
     @RequestMapping(value = "translateName",method = {RequestMethod.GET})
     @ResponseBody String translateName(@RequestParam("codeType") String codeType, @RequestParam("CodeCName") String CodeCName, @RequestParam("riskCode") String riskCode);

    /**
     * （根据iCodeType，iRiskCode，hpFlag查询prpdcode表获取列表数据）
     * @author: 田健
     * @date: 2017/10/21 16:29
     * @param map 中key codeType是代码类型、riskCode 险种代码、hpFlag 贫困标志
     * @return  prpDcodeDto 集合
     */
    @Deprecated
    @RequestMapping(value="getOptionCode",method = {RequestMethod.POST})
    @ResponseBody List<PrpDcodeDto> getOptionCode(@RequestBody Map<String,Object> map);

    /**
     * （根据codeType，riskCode查询prpdcode列表信息）
     * @author: 田健
     * @date: 2017/10/21 17:46
     * @param requestPrpDcodeListDto 查询 prpDcode大Dto 包含 codeType 代码类型 和riskCode 险种代码
     * @return ResponsePrpDcodeListDto 返回大对象，包含codeType与实体集合
     */
//    @RequestMapping(value="getOptionCodeTwo",method = {RequestMethod.GET})
//    @ResponseBody List<PrpDcodeDto> getOptionCode(@RequestParam("codeType") String codeType,@RequestParam("riskCode") String riskCode);
      @RequestMapping(value="getOptionCodeTwo",method = {RequestMethod.POST})
      @ResponseBody ResponsePrpDcodeListDto getOptionCode(@RequestBody RequestPrpDcodeListDto requestPrpDcodeListDto) throws Exception;


    /**
     * codeType和feildExt查询归属区域信息
     * @author: 王保良
     * @date: 2017/11/16 17:46
     * @param map 的 codeType 代码种类，feildExt 上级区域代码
     * @return 返回的是满足条件的PrpDcode实体类对象
     * @throws Exception
     */
    @RequestMapping(value = "queryAreasProvinceInfo",method = RequestMethod.POST)
    @ResponseBody List<PrpDcodeDto> queryAreasProvinceInfo(@RequestBody Map<String, String> map) throws Exception;

    /**
     * 根据险种、编辑类型、业务名称、业务代码查询业务代码表数据集
     * @author: 杨成程
     * @date: 2017/12/03 15:30
     * @param requestDto
     * @return
     */
    @RequestMapping(value = "queryCodeInfoByCodeName",method = {RequestMethod.POST})
    @ResponseBody List<PrpDcodeDto> queryCodeInfoByCodeName(@RequestBody RequestQueryCodeInfoDto requestDto) throws Exception;

    /**
     * （根据主键查询代码对应中文）
     * @author: 董坤
     * @date: 2017/11/18 10:09
     * @param codeType 代码类别
     * @param codeCode 代码
     * @return 代码对应中文
     */
    @RequestMapping(value="translateCodeByPK",method = {RequestMethod.GET})
    @ResponseBody String translateCodeByPK(@RequestParam("codeType") String codeType,@RequestParam("codeCode") String codeCode);

     /**
      * @description: 根据类型  和code编码的集合查询信息，如投保数量对应的单位信息 codeCodeList是codecode字符串由"-"拼接而成</p>
      * @author 安齐崇
      * @date 2017年11月3日下午5:37:04
      * @param codeType
      * @param codeCodeList
      * @return prpDcodeDtoList
      */
     @RequestMapping(value="queryByCondition",method = {RequestMethod.POST})
     @ResponseBody List<PrpDcodeDto> queryByCondition(@RequestParam("codeType") String codeType,@RequestParam("codeCodeList") String codeCodeList);
    /**
     *  根据客户类型查询证件类型
     * @author: 田慧
     * @date: 2017/12/23 11:25
     * @param map 键为flag
     * @return dentifyType 证件类型
     * @throws Exception
     */
    @RequestMapping(value="queryIdentifyType",method = {RequestMethod.POST})
    PrpDcodeRetuenDto queryIdentifyType(@RequestBody Map<String,String> map)throws Exception;
    /**
     * @description:方法功能简述:根据类型和险种编码查询下下拉信息
     * @author 安齐崇
     * @date 2017年11月10日下午7:06:37
     * @param codeType 查询类型
     * @param riskCode 险种编码
     */
    @RequestMapping(value="queryOptionBox",method = {RequestMethod.POST})
    @ResponseBody List<PrpDcodeDto> queryOptionBox(@RequestParam("codeType") String codeType,@RequestParam("riskCode") String riskCode);
    /**
     * 根据多个代码查询对应的证件类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 证件类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @RequestMapping(value = "queryCertifyTypeByCodes", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, String> queryCertifyTypeByCodes(@RequestBody List<String> codes);

    /**
     * 根据多个代码查询对应的领款人类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 领款人类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @RequestMapping(value = "queryReceiverTypesByCodes", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, String> queryReceiverTypesByCodes(@RequestBody List<String> codes);

    /**
     * 根据多个代码查询对应的银行账号属性中文名称键值对
     *
     * @param codes 代码集合
     * @return 银行账号属性代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @RequestMapping(value = "queryAccountTypeByCodes", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, String> queryAccountTypeByCodes(@RequestBody List<String> codes);

    /**
     * 根据多个代码查询对应的银行账号类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 银行账号类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @RequestMapping(value = "queryAccountFlagByCodes", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, String> queryAccountFlagByCodes(@RequestBody List<String> codes);

    /**
     * 根据代码查询对应的费用类型中文名
     *
     * @param costType 费用类型
     * @return 费用类型名称
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @RequestMapping(value = "queryUnderwriteFlagByCodes", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, String> queryCostTypeByCode(@RequestBody Map<String,String> costType);


    /**
     * 根据多个代码查询对应的短期费率方式中文名称键值对
     *
     * @param codes 代码集合
     * @return 短期费率方式代码-短期费率方式名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @RequestMapping(value = "queryShortRateFlagByCodes", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, String> queryShortRateFlagByCodes(@RequestBody List<String> codes);

    /**
     * 根据代码类型和代码查出对应的代码数据，代码可以为空
     *
     * @param param codeType代码类型，codeCode-代码
     * @return prpdcode的集合
     * @date: 2018/2/12 11:17
     * @author: 何伟东
     */
    @RequestMapping(value = "queryCodeInfoByTypeAndCode", method = {RequestMethod.POST})
    @ResponseBody
    List<PrpDcodeDto> queryCodeInfoByTypeAndCode(@RequestBody Map<String, String> param);


    @RequestMapping(value = "queryReportType",method = RequestMethod.POST)
    public @ResponseBody List<PrpDcodeDto> queryReportType() throws Exception;
}