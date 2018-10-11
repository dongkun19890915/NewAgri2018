package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.pms.core.kernel.service.PrpDriskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 12:48:22.282
 * @description 险种代码表controller层
 */
@RestController
@RequestMapping(value = PrpDriskController.PATH)
public class PrpDriskController implements PrpDriskApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDriskController.class);

    @Autowired
    private PrpDriskService prpdriskService;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(@RequestBody PrpDriskDto prpdriskDto) {
        prpdriskService.save(prpdriskDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestParam("riskCode") String riskCode) {
        prpdriskService.remove(riskCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDriskDto prpdriskDto) {
        prpdriskService.modify(prpdriskDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public @ResponseBody PrpDriskDto queryByPK(@RequestBody Map<String,String> map) {
        String riskCode = map.get("riskCode");
        return prpdriskService.queryByPK(riskCode);
    }
    /**
     * （根据险种代码查询prpdrisk表返回中文或英文名称）
     * @author: 田健
     * @date: 2017/10/22 14:49
     * @param  map 包括riskCode 险种代码、isChinese 中文标识
     * @return 中文或英文名称
     */
    @Override
    public @ResponseBody String translateCode(@RequestBody Map<String,String> map) throws Exception{
        String riskCode = map.get("riskCode");
        String isChinese = map.get("isChinese");
        return prpdriskService.translateCode(riskCode,isChinese);
    }

    /**
     * 根据险类、标的集合代码查询prpdrisk表返回该险类下的所有数据(快速出单)
     * @author: 王保良
     * @date: 2017/10/22 14:49
     * @param map 键是classCode 险类代码 ，itemCodeList标的代码集合
     * @return ResponseDto 返回的是PrpDrisk表的查询结果的集合
     */
    @Override
    public @ResponseBody List<PrpDriskDto>  queryRiskCodeInfoQuick(@RequestBody Map<String,Object> map) throws Exception {
        return prpdriskService.queryRiskCodeInfoQuick((String)map.get("classCode"),(List)map.get("itemCodeList"));
    }
    /**
     * 根据险类代码查询该险类下的所有险种
     * @author: 王保良
     * @date: 2017/10/22 14:49
     * @param map 键是classCode 险类代码
     * @return ResponseDto 返回的是PrpDrisk表的查询结果的集合
     */
    @Override
    public @ResponseBody List<PrpDriskDto>  queryRiskCodeInfo(@RequestBody Map<String,String> map) throws Exception {
        return prpdriskService.queryRiskCodeInfo(map.get("classCode"));
    }

    /**
     * 根据险类代码查询该险类下的所有险种
     * @author: 王心洋
     * @date: 2018/03/16
     * @param map
     * @return List<PrpDriskDto>
     */
    @Override
    public @ResponseBody List<Map<String, String>> queryRiskByRiskType(@RequestBody Map<String,String> map) throws Exception{
        return prpdriskService.queryRiskByRiskType(map.get("riskType"));
    }
    /**
     * 根据险类代码查询prpdrisk表返回该险类下的所有数据
     * @author: ldd
     * @date: 2017/10/22 14:49
     * @param classCode 险类代码
     * @return ResponseDto 返回的是PrpDrisk表的查询结果的集合
     */
    public @ResponseBody List<PrpDriskDto> queryPrpDriskByClassCode(String classCode) throws Exception {
        return prpdriskService.queryRiskCodeInfo(classCode);
    }

    /**
     * 根据多个riskCode查询得到List<PrpDrisk>
     * @author: 何伟东
     * @date: 2017/11/23 15:18
     * @param riskCodeList 多个riskCode的list集合
     * @return List<PrpDriskDto>
     */
    @Override
    public @ResponseBody List<PrpDriskDto> queryByRiskCodeList(@RequestBody List<String> riskCodeList){
        return prpdriskService.queryByRiskCodeList(riskCodeList);
    }

    /**
     * 根据险种代码查询险种名称
     * @author: 刘曼曼
     * @date: 2017/12/19 11:52
     * @param riskCodes 险种代码集合
     * @return List<String>险种名称集合
     * @throws Exception
     */
    public @ResponseBody List<String> translateCodeName(@RequestBody List<String> riskCodes) throws Exception{
        return prpdriskService.translateCodeName(riskCodes);
    }

    /**
     * 根据险种代码查询保费计算方式
     * @author: 刘曼曼
     * @date: 2017/12/19 11:52
     * @param map riskCode 险种代码
     * @return Double 费率分位
     * @throws Exception
     */
    public @ResponseBody Double queryByRiskCode(@RequestBody Map<String,String> map)throws Exception{
        return prpdriskService.queryByRiskCode(map.get("riskCode"));
    }
    /**
     * @param riskCode 险种代码
     * @return 中文名称
     * @description:（根据险种代码查询prpdrisk表返回名称）
     * @author: 董坤
     * @date: 2017/10/22 14:49
     */
    @Override
    public @ResponseBody String translateCodeByPK(@RequestParam("riskCode") String riskCode) {

        return prpdriskService.translateCodeByPK(riskCode);
    }

    /**
     * 根据validStatus查询险种表
     * @author: 王保良
     * @date: 2017/12/10 15:18
     * @return String[]
     */
    @Override
    public String[] queryByValidStatus() throws Exception {
        return prpdriskService.queryByValidStatus();
    }
    /**
     * 根据validStatus和Flag表示符查询险种表
     * @author: 王保良
     * @date: 2017/12/10 15:18
     * @return String[]
     */
    @Override
    public String[] queryByValidStatusAndFlag() throws Exception {
        return prpdriskService.queryByValidStatusAndFlag();
    }
    /**
     *  根据标的查询险种（快速出单带出险种、险类）
     * @author: 田健
     * @date: 2018/4/8 20:23
     * @param ,map 中的 itemCodeList 标的代码集合
     * @return 标的对象集合
     */
    @Override
    public @ResponseBody List<PrpDriskDto> queryByItemCode(@RequestBody Map<String,Object> map){
        List<String> itemCodeList = (List)map.get("itemCodeList");
        return prpdriskService.queryByItemCode(itemCodeList);
    }

    /**
     * 险种（）
     *
     * @return
     * @author: qianhao
     * @date: 2018/4/8 20:23
     */
    @RequestMapping(value = "queryByRiskName", method = {RequestMethod.POST})
    public @ResponseBody
    Map<String, String> queryByRiskName() {
        return prpdriskService.queryByRiskName();
    }
}
