package com.sinosoft.agriclaim.web.jobmanage;

import com.sinosoft.agriclaim.api.jobmanage.PrplAreaSettingApi;
import com.sinosoft.agriclaim.api.jobmanage.dto.RequestPrplAreaSettingQueryDto;
import com.sinosoft.agriclaim.api.jobmanage.dto.RequestSavePrplAreaSettingDto;
import com.sinosoft.agriclaim.core.jobmanage.service.PrplAreaSettingService;
import com.sinosoft.agriclaim.api.jobmanage.dto.PrplAreaSettingDto;
import com.sinosoft.framework.dto.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981
 * @description 区域设置表controller层
 */
@RestController
@RequestMapping(value = PrplAreaSettingController.PATH)
public class PrplAreaSettingController implements PrplAreaSettingApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrplAreaSettingController.class);

    @Autowired
    private PrplAreaSettingService prplAreaSettingService;

    /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrplAreaSettingDto prplAreaSettingDto) {
        prplAreaSettingService.save(prplAreaSettingDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody Long id) {
        prplAreaSettingService.remove(id);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrplAreaSettingDto prplAreaSettingDto) {
        prplAreaSettingService.modify(prplAreaSettingDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrplAreaSettingDto queryByPK(@RequestBody Long id) {
        return prplAreaSettingService.queryByPK(id);
    }
    /**
     * （区域设置按班表机构或被维护人查询-分页查询）
     * @author: 孙朋飞
     * @date: 2017/10/26 15:31
     * @param requestPrplAreaSettingQueryDto （班表机构handleDept（必传），被维护人工号handlerCode（非必传），险种classCode）
     * @return 区域设置表的分页集合
     * @throws Exception
     */
    public @ResponseBody
    PageInfo<PrplAreaSettingDto> queryPrplAreaSettingByCondition(@RequestBody RequestPrplAreaSettingQueryDto requestPrplAreaSettingQueryDto) throws Exception {
        return prplAreaSettingService.queryPrplAreaSettingByCondition(requestPrplAreaSettingQueryDto);

    }
    /**
     * 区域设置保存（新增区域设置）
     * @Author：孙朋飞
     * @Date：16:18 2017/10/27
     * @param prplAreaSettingDtoList 区域设置的集合
     * @return  成功返回"区域设置信息添加成功。" 失败返回"操作失败"
     * @throws Exception
     */
    public @ResponseBody Map<String,String> batchSavePrplAreaSetting(@RequestBody List<PrplAreaSettingDto> prplAreaSettingDtoList) throws Exception{
        boolean flag=prplAreaSettingService.batchSavePrplAreaSetting(prplAreaSettingDtoList);
        Map<String,String> map=new HashMap<>();
        if(flag){
            map.put("message","区域设置信息添加成功。");
        }else{
            map.put("message","操作失败!");
        }
        return map;
    }
    /**
     *（校验查勘人）
     * 查询人员是否已存在当前选择区域
     * @author: 孙朋飞
     * @date: 2017/11/9 10:38
     * @param requestPrplAreaSettingQueryDto 接受页面的参数（handleDept，handlerCode，险种classCode）
     * @return 是否已经添加作业区域
     * @throws Exception
     */
    public @ResponseBody Map<String,String> checkPrplAreaSettingByHandlerCode(@RequestBody RequestPrplAreaSettingQueryDto requestPrplAreaSettingQueryDto) throws Exception {
        String handlerName = prplAreaSettingService.checkPrplAreaSettingByHandlerCode(requestPrplAreaSettingQueryDto);
        Map<String,String> map=new HashMap<>();
        map.put("message",handlerName);
        return map;
    }
    /**
     * （班表机构或者被维护人查询）
     * @author: 孙朋飞
     * @date: 2017/11/10 11:00
     * @param requestPrplAreaSettingQueryDto （班表机构handleDept，工号handlerCode，险种classCode）
     * @return 区域设置和作业区域
     * @throws Exception
     */
    public @ResponseBody
    List<PrplAreaSettingDto> queryPrplAreaSettingByHandleDeptAndHandlerCode(@RequestBody RequestPrplAreaSettingQueryDto requestPrplAreaSettingQueryDto) throws Exception {
        return prplAreaSettingService.queryPrplAreaSettingByHandleDeptAndHandlerCode(requestPrplAreaSettingQueryDto);
    }
    /**
     * 当前机构及其下属机构下区域设置
     * @author: 孙朋飞
     * @date: 2018/3/17 14:56
     * @param map handleDept 班表机构
     * @return 区域设置人员
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PrplAreaSettingDto> queryPrplAreaSettingByhandleDept(@RequestBody Map<String, String> map) throws Exception {
        return prplAreaSettingService.queryPrplAreaSettingByhandleDept(map.get("handleDept"));
    }


}
