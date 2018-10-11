package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-10 08:34:23.982
 * @description 通用代码表Core接口
 */
public interface PrpDcodeService {

    /**
     * @param
     * @description 新增
     */
    void save(PrpDcodeDto prpDcodeDto);

    /**
     * @param
     * @description 删除
     */
    void remove(String codeType, String codeCode);

    /**
     * @param
     * @description 修改
     */
    void modify(PrpDcodeDto prpDcodeDto);

    /**
     * @param
     * @description 按主键查询实体
     */
    PrpDcodeDto queryByPK(String codeType, String codeCode);

    /**
     * @author 王心洋
     * @description 根据codeType, codeCode, languageFlag 查询一条中文或英文名称
     * @time 2017-10-29
     */
    String translateCode(String codeType, String codeCode, String languageFlag);

    /**
     * 根据codeType 代码类型、riskCode险种查询prpDCode实体
     *
     * @param codeType 业务类型
     * @return prpdcode集合
     * @author: 田健
     * @date: 2017/11/5 15:28
     */
    List<PrpDcodeDto> queryCodeInfoByCodeType(String codeType, String riskCode);

    /**
     * 根据codeType,codeCName,riskCode获取业务代码中文含义业务代码的codeCode
     *
     * @param codeType  业务类型
     * @param codeCName 业务名称
     * @param riskCode  险种代码
     * @return 业务代码
     * @author: 田健
     * @date: 2017/11/5 15:30
     */
    String translateName(String codeType, String codeCName, String riskCode);

    /**
     * @param codeType 代码类型
     * @param riskCode 险种代码
     * @param hpFlag   贫困标志
     * @return prpDcodeDto 集合
     * @description:（根据iCodeType，iRiskCode，hpFlag查询prpdcode表获取列表数据）
     * @author: 田健
     * @date: 2017/10/21 16:29
     */
    @Deprecated
    List<PrpDcodeDto> getOptionCode(String codeType, String riskCode, int hpFlag);

    /**
     * @param requestPrpDcodeListDto 查询prpDcode大Dto，包含CodeType 代码类型 和 riskCode 险种代码
     * @return ResponsePrpDcodeListDto 返回大对象，包含codeType与实体集合
     * @description:（根据codeType，riskCode查询prpdcode列表信息）
     * @author: 田健
     * @date: 2017/10/21 17:46
     */
    ResponsePrpDcodeListDto getOptionCode(RequestPrpDcodeListDto requestPrpDcodeListDto) throws Exception;


    /**
     * codeType和feildExt查询归属机构信息
     *
     * @param codeType 代码种类
     * @param fieldExt 上级区域代码
     * @return 返回的是满足条件的PrpDcode实体类对象
     * @throws Exception
     * @author: 王保良
     * @date: 2017/11/16 17:46
     */
    List<PrpDcodeDto> queryAreasProvinceInfo(String codeType, String fieldExt) throws Exception;

    /**
     * 根据险种、编辑类型、业务名称、业务代码查询业务代码表数据集
     *
     * @param requestDto
     * @return
     * @author: 杨成程
     * @date: 2017/12/03 15:30
     */
    List<PrpDcodeDto> queryCodeInfoByCodeName(RequestQueryCodeInfoDto requestDto) throws Exception;

    /**
     * @param codeType
     * @param codeCodeList
     * @return prpDcodeDtoList
     * @description: 根据类型  和code编码的集合查询信息，如投保数量对应的单位信息 codeCodeList是codecode字符串由"-"拼接而成</p>
     * @author 安齐崇
     * @date 2017年11月3日下午5:37:04
     */
    List<PrpDcodeDto> queryByCondition(String codeType, String codeCodeList);

    /**
     * （根据主键查询代码对应中文）
     *
     * @param codeType 代码类别
     * @param codeCode 代码
     * @return 代码对应中文
     * @author: 董坤
     * @date: 2017/11/18 10:09
     */
    public String translateCodeByPK(String codeType, String codeCode);

    /**
     * 根据客户类型查询证件类型
     *
     * @param flag flag 为1是个人，flag为2 是集体
     * @return dentifyType 证件类型
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/23 11:25
     */
    PrpDcodeRetuenDto queryIdentifyType(String flag) throws Exception;

    /**
     * @param codeType 查询类型
     * @param riskCode 险种编码
     * @description:方法功能简述:根据类型和险种编码查询下下拉信息
     * @author 安齐崇
     * @date 2017年11月10日下午7:06:37
     */
    List<PrpDcodeDto> queryOptionBox(String codeType, String riskCode);

    /**
     * 根据多个代码查询对应的证件类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 证件类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    Map<String, String> queryCertifyTypeByCodes(List<String> codes);

    /**
     * 根据多个代码查询对应的领款人类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 领款人类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    Map<String, String> queryReceiverTypesByCodes(List<String> codes);

    /**
     * 根据多个代码查询对应的银行账号属性中文名称键值对
     *
     * @param codes 代码集合
     * @return 银行账号属性代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    Map<String, String> queryAccountTypeByCodes(List<String> codes);


    /**
     * 根据多个代码查询对应的银行账号类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 银行账号类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    Map<String, String> queryAccountFlagByCodes(List<String> codes);

    /**
     * 根据多个代码查询对应的费用类型中文名称键值对
     *
     * @param costType 代码集合
     * @return 费用类型代码-费用类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    String queryCostTypeByCode(String costType);

    /**
     * 根据多个代码查询对应的短期费率方式中文名称键值对
     *
     * @param codes 代码集合
     * @return 短期费率方式代码-短期费率方式名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    Map<String, String> queryShortRateFlagByCodes(List<String> codes);

    /**
     * 根据代码类型和代码查出对应的代码数据，代码可以为空
     *
     * @param codeType 代码类型
     * @param codeCode 代码
     * @return prpdcode的集合
     * @date: 2018/2/12 11:17
     * @author: 何伟东
     */
    List<PrpDcodeDto> queryCodeInfoByTypeAndCode(String codeType, String codeCode);


    List<PrpDcodeDto> queryReportType()throws Exception;
}

