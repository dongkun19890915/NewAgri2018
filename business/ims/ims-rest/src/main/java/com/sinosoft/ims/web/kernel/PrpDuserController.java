package com.sinosoft.ims.web.kernel;

import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.RequestPrpDuserDto;
import com.sinosoft.ims.core.kernel.service.PrpDuserService;
import com.sinosoft.ims.core.kernel.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description 员工代码表controller层
 */
@RestController
@RequestMapping(value = PrpDuserController.PATH)
public class PrpDuserController implements PrpDuserApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDuserController.class);

    @Autowired
    private PrpDuserService prpDuserService;

    @Autowired
    private UserLoginService userLoginService;

   /**
     *@description 新增
     *@param
     */
    @Override
    public void save(@RequestBody PrpDuserDto prpDuserDto) {
        prpDuserService.save(prpDuserDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestParam("userCode") String userCode) {
        prpDuserService.remove(userCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDuserDto prpDuserDto) {
        prpDuserService.modify(prpDuserDto);
    }
    /**
     * 按主键查询实体
     * @author: 宋振振
     * @date: 2017/11/17 10:17
     * @param userCode 员工代码
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     */
    @Override
    public @ResponseBody PrpDuserDto queryByPK(@RequestParam(value = "userCode") String userCode) throws Exception{
        return prpDuserService.queryByPK(userCode);
    }

    /**
     * 查询当前用户信息
     * @author: 汪强
     * @date: 2018/01/17 10:17
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     */
    @Override
    public @ResponseBody PrpDuserDto getUserInfo()throws Exception{
        String userCode= SinoRequestContext.getCurrentContext().getUserCode();
        PrpDuserDto prpDuserDto=prpDuserService.queryByPK(userCode);
        //密码不返回
        prpDuserDto.setPassword(null);
        return prpDuserDto;
    }


    /**
     * 修改密码
     * @author: 汪强
     * @date: 2018/01/17 10:17
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     */
    @Override
    @RequestMapping(value = "modifyPwd",method = {RequestMethod.POST})
    public @ResponseBody String modifyPwd(@RequestParam("userCode")String userCode,@RequestParam("password")String password,@RequestParam("passwordNew")String passwordNew)throws Exception{

        String result=null;
        try {
            userLoginService.modifypwd(userCode, password, passwordNew);
        }catch (DataVerifyException e){
            result=e.getMessage();
        }
        return result;
    }
    /**
     * 修改当前用户信息
     * @author: 汪强
     * @date: 2018/01/17 10:17
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     */
    @Override
    public @ResponseBody PrpDuserDto modifyUserInfo(@RequestBody PrpDuserDto prpDuserDto)throws Exception{
        prpDuserService.modifyUserInfo(prpDuserDto);
        return null;
    }


    /**
     * @description:（归属业务员查询）
     * @author: 陈道洋
     * @date: 2017/11/2 9:20
     * @param requestPrpDuserDto 入参Dto
     * @return 业务员查询结果数据
     * @throws Exception
     */
    @Override
    public @ResponseBody
    List<PrpDuserDto> queryHandler1CodeInfo(@RequestBody RequestPrpDuserDto requestPrpDuserDto) throws Exception {
        return prpDuserService.queryHandler1CodeInfo(requestPrpDuserDto);

    }
    /**
     *
     * @author: 刘曼曼 根据操作人代码查询操作人名称
     * @date: 2017/11/15 12:10
     * @param map 操作人代码
     * @return 中文或英文
     */
    @Override
    public String translateCode(@RequestBody Map<String,String> map) throws Exception{
        String userCode = map.get("userCode");
        String isChinese = map.get("isChinese");
        String translateCode=prpDuserService.translateCode(userCode,isChinese);
        return translateCode;
    }


    /**
     * 根据多个userCode查询得到list<prpDuser>
     * @author: 何伟东
     * @date: 2017/11/23 14:17
     * @param userCodeList 多个userCode的list集合
     * @return list<prpDuser>
     */
    @Override
    public @ResponseBody List<PrpDuserDto> queryByUserCodeList(@RequestBody List<String> userCodeList) {
        return prpDuserService.queryByUserCodeList(userCodeList);
    }


    /**
     *  根据用户代码查询用户名称
     * @author: 刘曼曼
     * @date: 2017/11/24 14:11
     * @param operatorCodes 用户代码集合
     * @return List<String>用户名称集合
     */
    @Override
    public @ResponseBody List<String> queryOperatorName(@RequestBody List<String> operatorCodes)throws Exception{

        return prpDuserService.queryOperatorName(operatorCodes);
    }
    /**
     * * 根据用户代码查询用户名称
     * @author: 田慧
     * @date: 20:09
     * @param operatorCodes 用户代码集合
     * @return  List<String> 用户信息集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PrpDuserDto> getOperatorCode(@RequestBody List<String> operatorCodes)throws Exception{
        return prpDuserService.getOperatorCode(operatorCodes);
    }
    /**
     *  根据员工名称获取员工代码
     * @author: 田慧
     * @date: 2017/12/4 14:46
     * @param userName 员工名称
     * @return PrpDuserDto的集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<String> queryByUserName(@RequestParam("userName") String userName)throws Exception{
        return prpDuserService.queryByUserName(userName);
    }
    /**
     * @description:方法功能简述: 根据机构编码查询查勘处理单位
     * @author 安齐崇
     * @date 2017年12月14日下午9:13:30
     * @param comCode 机构编码
     * @return
     */
    @Override
	public @ResponseBody List<PrpDuserDto> queryCheckPerson(@RequestParam("comCode") String comCode) {
		return prpDuserService.queryCheckPerson(comCode);
	}

    /**
     * （根据员工代码代码查询对应中文名称）
     * @param userCode 员工代码
     * @return 对应中文名称
     * @author: 董坤
     * @date: 2017/11/18 11:03
     */
    @Override
    public @ResponseBody String translateCodeByPK(String userCode) {
        return prpDuserService.translateCodeByPK(userCode);
    }
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
    @Override
    public @ResponseBody List<PrpDuserDto> queryPrpDuserByHandleDept(@RequestParam(value="handleDept") String handleDept,@RequestParam(value="queryType") String queryType) throws Exception {
        return prpDuserService.queryPrpDuserByHandleDept(handleDept,queryType);
    }
    /**
     * 
      * @description 调度页面查询查勘和定损人员双击域
      * @author yk
      * @date 2017年12月22日 上午10:25:59
      * @param map
      * @return List<PrpDuserDto>用户集合
     */
	@Override
	public @ResponseBody List<Map<String, String>> queryCheckAndLossPeople(@RequestBody Map<String, String> map) {
		String comCode = map.get("comCode");
		String taskCode = map.get("taskCode");
		return prpDuserService.queryCheckAndLossPeople(comCode,taskCode);
	}
	
}
