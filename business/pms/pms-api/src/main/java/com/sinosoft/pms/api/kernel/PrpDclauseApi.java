package com.sinosoft.pms.api.kernel;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseDto;
import com.sinosoft.pms.api.kernel.dto.ResponsePrpDclauseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 06:20:36.415 
 * @description 条款代码表Api接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDclauseApi.PATH)
public interface PrpDclauseApi {

    public static final String PATH = "prpDclause";
    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDclauseDto prpDclauseDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("clauseCode") String clauseCode,@RequestParam("lineNo")  Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDclauseDto prpDclauseDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDclauseDto queryByPK(@RequestParam("clauseCode") String clauseCode,@RequestParam("lineNo")  Integer lineNo);
    /**
     * 根据条款代码查询条款代码表的风险等级说明，第三方识别说明
     * @author: 宋振振
     * @date: 2017/10/23 15:26
     * @param clauseCode 条款代码
     * @return List<PrpDclauseDto> 返回相应条款代码的条款信息
     */
    @RequestMapping(value = "queryClauseByClauseCode",method = {RequestMethod.POST})
    public @ResponseBody List<PrpDclauseDto> queryClauseByClauseCode(@RequestParam(value = "clauseCode") String clauseCode) throws Exception;

    /**
     * 按险种查询CLauseDto(特约及附加信息双击域)
     * @param map 键为riskCode 险种代码
     * @return List<PrpDclauseDto> 返回PrpDclauseDto整个对象
     * @author 王保良
     * @throws Exception
     * @date 2017年10月12日 下午3:20:00
     */
    @RequestMapping(value="queryClauseByRiskCode",method= RequestMethod.POST)
    public @ResponseBody List<PrpDclauseDto> queryClauseByRiskCode(@RequestBody Map<String,String> map) throws Exception;

    /**
     *  根据clauseCode 条款代码查询PrpDclause条款信息表信息
     * @author: 田慧
     * @date: 2017/12/2 12:50
     * @param map 包括clauseCode 条款代码
     * @return PrpDclauseDto的集合
     */
    @RequestMapping(value = "queryPrpdclauseInfoByCondition",method = RequestMethod.POST)
    public List<PrpDclauseDto> queryPrpdclauseInfoByCondition(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 根据条款代码集合查询条款代码和条款名称
     * @author: 刘曼曼
     * @date: 2017/12/19 15:16
     * @param map riskCode 险种
     * @return List<ResponsePrpDclauseDto> 保险代码和保险名称集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpdclauseInfo",method = RequestMethod.POST)
    public @ResponseBody List<ResponsePrpDclauseDto> queryPrpdclauseInfo(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 根据条款代码查询险种内容
     * @author: 刘曼曼
     * @date: 2017/12/19 17:33
     * @param map riskCode 险种代码
     * @return List<String> 条款内容集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByKindContext",method = {RequestMethod.POST})
    public @ResponseBody List<PrpDclauseDto>  queryByKindContext(@RequestBody Map<String,String> map)throws Exception;

}