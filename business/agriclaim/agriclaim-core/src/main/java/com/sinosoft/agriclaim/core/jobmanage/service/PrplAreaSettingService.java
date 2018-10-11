package com.sinosoft.agriclaim.core.jobmanage.service;


import com.sinosoft.agriclaim.api.jobmanage.dto.PrplAreaSettingDto;
import com.sinosoft.agriclaim.api.jobmanage.dto.RequestPrplAreaSettingQueryDto;
import com.sinosoft.agriclaim.api.jobmanage.dto.RequestSavePrplAreaSettingDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981 
 * @description 区域设置表Core接口
 */
public interface PrplAreaSettingService {

    /**
     *@description 新增
     *@param
     */
    void save(PrplAreaSettingDto prplAreaSettingDto);

    /**
     *@description 删除
     *@param
     */
    void remove(Long id);
    /**
     *@description 修改
     *@param
     */
    void modify(PrplAreaSettingDto prplAreaSettingDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrplAreaSettingDto queryByPK(Long id);
    /**
     * （区域设置按班表机构或被维护人查询-分页查询）
     * @author: 孙朋飞
     * @date: 2017/10/26 15:31
     * @param requestPrplAreaSettingQueryDto （班表机构handleDept（必传），被维护人工号handlerCode（非必传），险种classCode）
     * @return 区域设置表的分页集合
     * @throws Exception
     */
    public  PageInfo<PrplAreaSettingDto> queryPrplAreaSettingByCondition(RequestPrplAreaSettingQueryDto requestPrplAreaSettingQueryDto) throws Exception;
    /**
     * 区域设置保存（新增区域设置）
     * @Author：孙朋飞
     * @Date：16:18 2017/10/27
     * @param prplAreaSettingDtoList 区域设置集合
     * @return  成功返回 true
     * @throws Exception
     */
    public boolean batchSavePrplAreaSetting(List<PrplAreaSettingDto> prplAreaSettingDtoList) throws Exception;
    /**
     *（校验查勘人）
     * 查询人员是否已存在当前选择区域
     * @author: 孙朋飞
     * @date: 2017/11/9 10:38
     * @param requestPrplAreaSettingQueryDto 接受页面的参数（handleDept，handlerCode，险种classCode）
     * @return 是否已经添加作业区域
     * @throws Exception
     */
    public String checkPrplAreaSettingByHandlerCode(RequestPrplAreaSettingQueryDto requestPrplAreaSettingQueryDto) throws Exception;
    /**
     * （班表机构或者被维护人查询）
     * @author: 孙朋飞
     * @date: 2017/11/10 11:00
     * @param requestPrplAreaSettingQueryDto 接受页面的参数（handleDept，handerCode，险种classCode）
     * @return 区域设置和作业区域
     * @throws Exception
     */
    public List<PrplAreaSettingDto> queryPrplAreaSettingByHandleDeptAndHandlerCode(RequestPrplAreaSettingQueryDto requestPrplAreaSettingQueryDto) throws Exception;
    /**
     * 当前机构及其下属机构下区域设置
     * @author: 孙朋飞
     * @date: 2018/3/17 14:56
     * @param handleDept 班表机构
     * @return 区域设置人员
     * @throws Exception
     */
    public List<PrplAreaSettingDto> queryPrplAreaSettingByhandleDept(String handleDept) throws Exception;
}