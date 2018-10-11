package com.sinosoft.ims.api.kernel;


import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.RequestPrpDuserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059
 * @description 员工代码表Api接口
 */
@Component
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = PrpDuserApi.PATH)
public interface PrpDuserApi {

    public static final String PATH = "prpDuser";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDuserDto prpDuserDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("userCode") String userCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDuserDto prpDuserDto);
    /**
     * 按主键查询实体
     * @author: 宋振振
     * @date: 2017/11/17 10:17
     * @param userCode 员工代码
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    public @ResponseBody PrpDuserDto queryByPK(@RequestParam("userCode") String userCode)throws Exception;


    /**
     * 查询当前用户信息
     * @author: 汪强
     * @date: 2018/01/17 10:17
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     */
    @RequestMapping(value = "getUserInfo",method = {RequestMethod.POST})
    public @ResponseBody PrpDuserDto getUserInfo()throws Exception;

    /**
     * 修改密码
     * @author: 汪强
     * @date: 2018/01/17 10:17
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     */
    @RequestMapping(value = "modifyPwd",method = {RequestMethod.POST})
    public @ResponseBody String modifyPwd(@RequestParam("userCode")String userCode,@RequestParam("password")String password,@RequestParam("passwordNew")String passwordNew)throws Exception;

    /**
     * 修改当前用户信息
     * @author: 汪强
     * @date: 2018/01/17 10:17
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     */
    @RequestMapping(value = "modifyUserInfo",method = {RequestMethod.POST})
    public @ResponseBody PrpDuserDto modifyUserInfo(@RequestBody PrpDuserDto prpDuserDto)throws Exception;

    /**
     * @description:（归属业务员查询）
     * @author: 陈道洋
     * @date: 2017/11/2 9:17
     * @param requestPrpDuserDto 入参Dto
     * @return 业务员查询结果数据
     * @throws Exception
     */
    @RequestMapping(value = "queryHandler1CodeInfo",method = {RequestMethod.POST})
    public @ResponseBody
    List<PrpDuserDto> queryHandler1CodeInfo(@RequestBody RequestPrpDuserDto requestPrpDuserDto)throws Exception;

    /**
     *
     * @author: 刘曼曼 根据操作人代码查询操作人名称
     * @date: 2017/11/15 12:10
     * @param  map
     * @return 中文或英文
     */
    @RequestMapping(value = "translateCode",method = {RequestMethod.POST})
    String translateCode(@RequestBody Map<String,String> map) throws Exception;

    /**
     *  根据用户代码查询用户名称
     * @author: 刘曼曼
     * @date: 2017/11/24 14:11
     * @param operatorCodes 用户代码集合
     * @return List<String>用户名称集合
     */
    @RequestMapping(value = "queryOperatorName",method = {RequestMethod.POST})
    public @ResponseBody List<String> queryOperatorName(@RequestBody List<String> operatorCodes)throws Exception;

    /**
     * * 根据用户代码查询用户名称
     * @author: 田慧
     * @date: 20:09
     * @param operatorCodes 用户代码集合
     * @return  List<String> 用户信息集合
     * @throws Exception
     */
    @RequestMapping(value = "getOperatorCode",method = {RequestMethod.POST})
    public @ResponseBody List<PrpDuserDto> getOperatorCode(@RequestBody List<String> operatorCodes)throws Exception;

    /**
     * 根据多个userCode查询得到list<prpDuser>
     * @author: 何伟东
     * @date: 2017/11/23 14:17
     * @param userCodeList usercode集合
     * @return list<prpDuser>
     */
    @PostMapping(value = "queryByUserCodes")
    public @ResponseBody List<PrpDuserDto> queryByUserCodeList(@RequestBody List<String> userCodeList);

    /**
     *  根据员工名称获取员工代码
     * @author: 田慧
     * @date: 2017/12/4 14:46
     * @param userName 员工名称
     * @return PrpDuserDto的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByUserName",method = {RequestMethod.POST})
    public @ResponseBody List<String> queryByUserName(@RequestParam("userName") String userName)throws Exception;
    /**
     * @description:方法功能简述: 根据机构编码查询查勘处理单位
     * @author 安齐崇
     * @date 2017年12月14日下午9:13:30
     * @param comCode 机构编码
     * @return
     */
    @RequestMapping(value = "queryCheckPersion",method = {RequestMethod.POST})
    @ResponseBody
    List<PrpDuserDto> queryCheckPerson(@RequestParam("comCode") String comCode);
    /**
     * （根据员工代码代码查询对应中文名称）
     * @author: 董坤
     * @date: 2017/11/18 11:03
     * @param userCode 员工代码
     * @return 对应中文名称
     */
    @RequestMapping(value = "translateCodeByPK",method = {RequestMethod.POST})
    public @ResponseBody String translateCodeByPK(@RequestParam("userCode") String userCode);
    /**
     * （查询被维护人）
     * 根据班表机构查询被维护人
     * @author: 孙朋飞
     * @date: 2017/11/20 16:19
     * @param handleDept 班表机构
     * @param queryType 查询类型"1"是查询被维护人，不填查询所有
     * @return 被维护人的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpDuserByHandleDept",method = {RequestMethod.POST})
    public @ResponseBody
    List<PrpDuserDto> queryPrpDuserByHandleDept(@RequestParam(value="handleDept") String handleDept,@RequestParam(value="queryType") String queryType) throws Exception;

    /**
     * 
      * @description 调度页面查询查勘和定损人员双击域
      * @author yk
      * @date 2017年12月22日 上午10:25:59
      * @param map里面有comCode和taskCode
      * @return List<PrpDuserDto>用户集合
     */
    @RequestMapping(value = "queryCheckAndLossPeople",method = {RequestMethod.POST})
    @ResponseBody List<Map<String, String>> queryCheckAndLossPeople(@RequestBody Map<String, String> map);
}