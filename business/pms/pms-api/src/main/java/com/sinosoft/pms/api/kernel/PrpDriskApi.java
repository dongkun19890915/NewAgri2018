package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 12:48:22.282 
 * @description 险种代码表Api接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDriskApi.PATH)
public interface PrpDriskApi {

    String PATH = "prpDrisk";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDriskDto prpdriskDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("riskCode") String riskCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDriskDto prpdriskDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody PrpDriskDto queryByPK(@RequestBody Map<String,String> map);
    /**
     * @description:（根据险种代码查询prpdrisk表返回中文或英文名称）
     * @author: 田健
     * @date: 2017/10/22 14:49
     * @param map 包括riskCode 险种代码、isChinese 中文标识
     * @return 中文或英文名称
     */
    @RequestMapping(value="translateCode",method = {RequestMethod.POST})
    @ResponseBody String translateCode(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 根据险类、标的集合代码查询prpdrisk表返回该险类下的所有数据(快速出单)
     * @author: 王保良
     * @date: 2017/10/22 14:49
     * @param map 键是classCode ，itemCodeList是标的代码
     * @return ResponseDto 返回的是PrpDrisk表的查询结果的集合
     */
    @RequestMapping(value = "queryRiskCodeInfoQuick",method = RequestMethod.POST)
    @ResponseBody List<PrpDriskDto> queryRiskCodeInfoQuick(@RequestBody Map<String,Object> map) throws Exception;

    /**
     * 根据险类代码查询prpdrisk表返回该险类下的所有数据
     * @author: 王保良
     * @date: 2017/10/22 14:49
     * @param map 键是classCode
     * @return ResponseDto 返回的是PrpDrisk表的查询结果的集合
     */
    @RequestMapping(value = "queryRiskCodeInfo",method = RequestMethod.POST)
    @ResponseBody List<PrpDriskDto> queryRiskCodeInfo(@RequestBody Map<String,String> map) throws Exception;
    /**
     * 根据险类代码查询该险类下的所有险种
     * @author: 王心洋
     * @date: 2018/03/16
     * @param map
     * @return List<PrpDriskDto>
     */
    @RequestMapping(value = "queryRiskByRiskType",method = RequestMethod.POST)
    @ResponseBody List<Map<String, String>> queryRiskByRiskType(@RequestBody Map<String,String> map) throws Exception;
    /**
     * 根据多个riskCode查询得到List<PrpDrisk>
     * @author: 何伟东
     * @date: 2017/11/23 15:18
     * @param riskCodeList 多个riskCode的list集合
     * @return List<PrpDriskDto>
     */
    @PostMapping(value = "queryByRiskCodeList")
    public @ResponseBody List<PrpDriskDto> queryByRiskCodeList(@RequestBody List<String> riskCodeList);

    /**
     * 根据险种代码查询险种名称
     * @author: 刘曼曼
     * @date: 2017/12/19 11:53
     * @param riskCodes 险种代码集合
     * @return List<String>险种名称集合
     * @throws Exception
     */
    @RequestMapping(value="translateCodeName",method = {RequestMethod.POST})
    @ResponseBody List<String> translateCodeName(@RequestBody List<String> riskCodes) throws Exception;

    /**
     * 根据险种代码查询保费计算方式
     * @author: 刘曼曼
     * @date: 2017/12/19 11:52
     * @param map riskCode 险种代码
     * @return Double 费率分位
     * @throws Exception
     */
    @RequestMapping(value="queryByRiskCode",method = {RequestMethod.POST})
    public @ResponseBody Double queryByRiskCode(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 根据validStatus查询险种表
     * @author: 王保良
     * @date: 2017/12/10 15:18
     * @return String[]
     */
    @RequestMapping(value = "queryByValidStatus",method = RequestMethod.POST)
    public String[] queryByValidStatus() throws Exception;
    /**
     * 根据validStatus和Flag表示符查询险种表
     * @author: 王保良
     * @date: 2017/12/10 15:18
     * @return String[]
     */
    @RequestMapping(value = "queryByValidStatusAndFlag",method = RequestMethod.POST)
    public String[] queryByValidStatusAndFlag() throws Exception;
    /**
     * @description:（根据险种代码查询prpdrisk表返回名称）
     * @author: 董坤
     * @date: 2017/10/22 14:49
     * @param riskCode 险种代码
     * @return 中文名称
     */
    @RequestMapping(value="translateCodeByPK",method = {RequestMethod.GET})
    @ResponseBody String translateCodeByPK(@RequestParam("riskCode") String riskCode);
    /**
     *  根据标的查询险种（快速出单带出险种、险类）
     * @author: 田健
     * @date: 2018/4/8 20:23
     * @param map 中的 itemCodeList 标的代码集合
     * @return 标的对象集合
     */
    @RequestMapping(value = "queryByItemCode",method = {RequestMethod.POST})
    @ResponseBody List<PrpDriskDto> queryByItemCode(@RequestBody Map<String,Object> map );

    /**
     * 险种（）
     *
     * @return
     * @author: qianhao
     * @date: 2018/4/8 20:23
     */
    @RequestMapping(value = "queryByRiskName", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, String> queryByRiskName();
}