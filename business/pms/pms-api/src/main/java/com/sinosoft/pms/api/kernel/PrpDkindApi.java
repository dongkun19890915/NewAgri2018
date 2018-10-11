package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDkindAgriDto;
import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 08:08:33.126
 *  险别代码表Api接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDkindApi.PATH)
public interface PrpDkindApi {

    String PATH = "prpDkind";

    /**
     * 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDkindDto prpDkindDto);

    /**
     * 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam(value = "riskCode") String riskCode, @RequestParam(value = "kindCode") String kindCode);
    /**
     * 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDkindDto prpDkindDto);
    /**
     * 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.GET})
    @ResponseBody PrpDkindDto queryByPK(@RequestParam(value = "riskCode") String riskCode, @RequestParam(value = "kindCode") String kindCode);

    /**
     * 根据riskCode查询prpdkind表
     * @author: 何伟东
     * @date: 2017/10/31 16:28
     * @param param riskCode 险种代码
     * @return 包含所有险别信息的list
     */
    @RequestMapping(value = "queryByRiskCode",method = {RequestMethod.POST})
    @ResponseBody List<PrpDkindDto> queryByRiskCode(@RequestBody Map<String,String> param);

    /**
     * 查询主险附加险别信息
     * @author: 何伟东
     * @date: 2017/11/4 16:04
     * @param parme
     * @return 险别信息对象
     */
    @RequestMapping(value = "queryKindCodeInfo",method = {RequestMethod.POST})
    @ResponseBody List<PrpDkindDto> queryKindCodeInfo(@RequestBody Map<String,String> parme)  throws Exception;

    /**
     * 根据多个险别序号查询该险种下的险别信息
     *
     * @param param riskCode-险种代码；kindCodes-险别代码集合（list）
     * @return 险别代码-险别中文名称
     * @author: 何伟东
     * @date: 2018/1/11 18:01
     */
    @RequestMapping(value = "queryByKindCodes", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, String> queryByKindCodes(@RequestBody Map<String, Object> param) throws Exception;


}