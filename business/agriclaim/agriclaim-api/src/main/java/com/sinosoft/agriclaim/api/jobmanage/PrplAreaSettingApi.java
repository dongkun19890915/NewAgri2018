package com.sinosoft.agriclaim.api.jobmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.jobmanage.dto.PrplAreaSettingDto;
import com.sinosoft.agriclaim.api.jobmanage.dto.RequestPrplAreaSettingQueryDto;
import com.sinosoft.agriclaim.api.jobmanage.dto.RequestSavePrplAreaSettingDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981
 * @description 区域设置表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrplAreaSettingApi.PATH)
public interface PrplAreaSettingApi {

    public static final String PATH = "prplAreaSetting";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrplAreaSettingDto prplAreaSettingDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(Long id);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrplAreaSettingDto prplAreaSettingDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrplAreaSettingDto queryByPK(Long id);
    /**
     * （区域设置按班表机构或被维护人查询-分页查询）
     * @author: 孙朋飞
     * @date: 2017/10/26 15:31
     * @param requestPrplAreaSettingQueryDto （班表机构handleDept（必传），被维护人工号handlerCode（非必传），险种classCode（必传））
     * @return 区域设置表的分页集合
     * @throws Exception
     */
    @RequestMapping(value="queryPrplAreaSettingByCondition",method={RequestMethod.POST})
    public @ResponseBody
    PageInfo<PrplAreaSettingDto> queryPrplAreaSettingByCondition(@RequestBody RequestPrplAreaSettingQueryDto requestPrplAreaSettingQueryDto) throws Exception;
    /**
     * 区域设置批量保存（新增区域设置）
     * @Author：孙朋飞
     * @Date：16:18 2017/10/27
     * @param prplAreaSettingDtoList 区域设置集合
     * @return  成功返回"区域设置信息添加成功。" 失败返回"操作失败"
     * @throws Exception
     */
    @RequestMapping(value = "batchSavePrplAreaSetting",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> batchSavePrplAreaSetting(@RequestBody List<PrplAreaSettingDto> prplAreaSettingDtoList) throws Exception;

    /**
     *（校验查勘人）
     * 查询人员是否已存在当前选择区域
     * @author: 孙朋飞
     * @date: 2017/11/9 10:38
     * @param requestPrplAreaSettingQueryDto （班表机构handleDept（必传），被维护人工号handlerCode（必传），险种classCode（必传））
     * @return 是否已经添加作业区域
     * @throws Exception
     */
    @RequestMapping(value = "checkPrplAreaSettingByHandlerCode",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> checkPrplAreaSettingByHandlerCode(@RequestBody RequestPrplAreaSettingQueryDto requestPrplAreaSettingQueryDto) throws Exception;
    /**
     * （班表机构或者被维护人查询）
     * 点击班表机构查询该班表机构下的所有人员，点击被维护人显示此人的信息
     * @author: 孙朋飞
     * @date: 2017/11/10 11:00
     * @param requestPrplAreaSettingQueryDto （班表机构handleDept（必传），工号handlerCode（非必传），险种（必传））
     * @return 区域设置和作业区域
     * @throws Exception
     */
    @RequestMapping(value = "queryPrplAreaSettingByHandleDeptAndHandlerCode",method = {RequestMethod.POST})
    public @ResponseBody
    List<PrplAreaSettingDto> queryPrplAreaSettingByHandleDeptAndHandlerCode(@RequestBody RequestPrplAreaSettingQueryDto requestPrplAreaSettingQueryDto) throws Exception;

    /**
     * 当前机构及其下属机构下区域设置
     * @author: 孙朋飞
     * @date: 2018/3/17 14:56
     * @param map handleDept 班表机构
     * @return 区域设置人员
     * @throws Exception
     */
    @RequestMapping(value = "queryPrplAreaSettingByhandleDept",method = {RequestMethod.POST})
    public @ResponseBody List<PrplAreaSettingDto> queryPrplAreaSettingByhandleDept(@RequestBody Map<String,String> map) throws Exception;

}