package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 12:48:22.282 
 * @description 险种代码表Core接口
 */
public interface PrpDriskService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskDto prpdriskDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskDto prpdriskDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskDto queryByPK(String riskCode);

    /**
     * （根据险种代码查询prpdrisk表返回中文或英文名称）
     * @author: 田健
     * @date: 2017/10/22 14:49
     * @param riskCode 险种代码
     * @param isChinese 中文标识
     * @return 中文或英文名称
     */
    String translateCode(String riskCode, String isChinese) throws Exception;

    /**
     * 根据险类查询该险类下的所有险种
     * @author: 王保良
     * @date: 2017/10/22 14:49
     * @param classCode 险类代码
     * @return List<PrpDriskDto>
     */
    List<PrpDriskDto> queryRiskCodeInfo(String classCode) throws Exception;

    /**
     * 根据险类、标的集合代码查询prpdrisk表返回该险类下的所有数据(快速出单)
     * @author: 王保良
     * @date: 2017/10/22 14:49
     * @param classCode 险类代码
     * @param itemCodeList 标的代码集合
     * @return List<PrpDriskDto>
     */
    List<PrpDriskDto> queryRiskCodeInfoQuick(String classCode,List<String> itemCodeList) throws Exception;

    /**
     * 根据险类代码查询该险类下的所有险种
     * @author: 王心洋
     * @date: 2018/03/16
     * @param riskType
     * @return List<PrpDriskDto>
     */
    List<Map<String, String>> queryRiskByRiskType(String riskType) throws Exception;
    /**
     * 根据多个riskCode查询得到List<PrpDrisk>
     * @author: 何伟东
     * @date: 2017/11/23 15:18
     * @param riskCodeList 多个riskCode的list集合
     * @return List<PrpDriskDto>
     */
    public List<PrpDriskDto> queryByRiskCodeList(List<String> riskCodeList);

    /**
     * 根据险种代码查询险种名称
     * @author: 刘曼曼
     * @date: 2017/12/19 11:52
     * @param riskCodes 险种代码集合
     * @return List<String>险种名称集合
     * @throws Exception
     */
    public List<String> translateCodeName(List<String> riskCodes) throws Exception;

    /**
     * 根据险种代码查询保费计算方式
     * @author: 刘曼曼
     * @date: 2017/12/19 11:52
     * @param riskCode 险种代码
     * @return Double 费率分位
     * @throws Exception
     */
    public Double queryByRiskCode(String riskCode)throws Exception;
    /**
     * @param riskCode 险种代码
     * @return 中文名称
     * @description:（根据险种代码查询prpdrisk表返回名称）
     * @author: 董坤
     * @date: 2017/10/22 14:49
     */
    public String translateCodeByPK(String riskCode);

    /**
     * 根据validStatus查询险种表
     * @author: 王保良
     * @date: 2017/12/10 15:18
     * @return String[]
     */
    public String[] queryByValidStatus() throws Exception;
    /**
     * 根据validStatus和Flag表示符查询险种表
     * @author: 王保良
     * @date: 2017/12/10 15:18
     * @return String[]
     */
    public String[] queryByValidStatusAndFlag() throws Exception;
    /**
     *  根据标的查询险种（快速出单带出险种、险类）
     * @author: 田健
     * @date: 2018/4/8 20:23
     * @param itemCodeList 标的代码集合
     * @return 标的对象集合
     */
    List<PrpDriskDto> queryByItemCode(List<String> itemCodeList);

    /**
     * 险种（）
     *
     * @return
     * @author: qianhao
     * @date: 2018/4/8 20:23
     */
    Map<String, String> queryByRiskName();
}