package com.sinosoft.dms.api.customer;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.customer.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-09 11:34:12.554 
 * @description 个人客户代码表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDcustomerIdvApi.PATH)
public interface PrpDcustomerIdvApi {

    public static final String PATH = "prpDcustomerIdv";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDcustomerIdvDto prpDcustomerIdvDto);

    /**
     * 保存个体客户信息
     * @author: 田健
     * @date: 2017/12/28 11:01
     * @param prpDcustomerIdvDtos 个体客户信息集合
     * @Return 返回成功
     */
    @RequestMapping(value = "saveByList",method = {RequestMethod.POST})
    String saveByList(@RequestBody List<PrpDcustomerIdvDto> prpDcustomerIdvDtos);
    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String customercode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDcustomerIdvDto prpDcustomerIdvDto);
    /**
     * @description:（查询个人客户风险等级信息）
     * @author: 董坤
     * @date: 2017/10/15 22:09
     * @param requestDto
     * @return
     */
    @RequestMapping(value = "queryRiskLevelByCondition",method = {RequestMethod.POST})
    @ResponseBody List<ResponseCustomerRiskLevelDto> queryRiskLevelByCondition(@RequestBody RequestDto requestDto) throws Exception;

    /**
     * @description:（保存数据）
     * @author: 董坤
     * @date: 2017/10/18 8:54
     * @param requestSaveDto
     * @return String
     * @throws Exception
     */
    @RequestMapping(value = "saveByCondition",method = {RequestMethod.POST})
    @ResponseBody String saveByCondition(@RequestBody RequestSaveDto requestSaveDto) throws Exception;

    /**
     *  按条件查询团体客户和个体信息
     * @author: 赵鹏
     * @date: 2017/12/16 13:35
     * @param requestDto RequestUnitAndldvDto（查询的条件客户代码，身份证件类型，身份证件类型）
     * @return List<ResponseCustomerRiskLevelDto> 要显示的客户列表信息
     * @throws Exception
     */
    @RequestMapping(value = "queryAllUnitAndIdv",method = {RequestMethod.POST})
    @ResponseBody List<ResponseCustomerRiskLevelDto> queryAllUnitAndIdv(@RequestBody RequestUnitAndldvDto requestDto)throws Exception;
    /**
     * (修改保存客户风险等级数据）
     * @author: 赵鹏
     * @date:  2017/12/16 13:35
     * @param PrpDcustomerIdv （要更新或保存的参数）
     * @return Map<String ,String >返回操作码，操作信息
     * @throws Exception
     */
    @RequestMapping(value = "saveByCustomerRiskLevel",method = {RequestMethod.POST})
    @ResponseBody Map<String,String> saveByCustomerRiskLevel(@RequestBody PrpDcustomerIdvAndUnitDto PrpDcustomerIdv) throws Exception;

    /**
     * （根据客户代码查询个体和团体对象）
     * @author: 赵鹏
     * @date: 2017/12/16 16:07
     * @param map
     * @return  PrpDcustomerIdvDto （如果是个体直接返回，如果是团体转换为PrpDcustomerIdvDto对象返回）
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDcustomerIdvAndUnitDto queryByPK(@RequestBody Map<String,String> map);

    /**
     * 根据证件类型和证件号去基础表中查询是否有该大户的信息
     * @param map  key:"identifyType","identifyNumber"
     * @return List<PrpDcustomerIdv>
     * @throws Exception
     * @author: 王保良
     * @date: 2017/12/1 17:39
     */
    @RequestMapping(value = "queryPrpDcustomerByIndentity",method = RequestMethod.POST)
    public List<PrpDcustomerIdvDto> queryPrpDcustomerByIndentity(@RequestBody Map<String,String> map) throws Exception;
}