package com.sinosoft.ims.api.auth;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.CheckPowerPrpallResDto;
import com.sinosoft.ims.api.auth.dto.PowerConditionDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


/**
* @description 权限管理服务接口
* @author hzhongkai
* @date 2016年9月22日下午5:06:26
*/
@FeignClient(name= IMSConstant.IMS_SERVICE_NAME,path = PowerApi.PATH)
public interface PowerApi {

	public static final String PATH = "power";
	
	/**
	* @description 判断某个功能是否有权执行
	* @param powerConditionDto
	* @return ResponseDto
	* @author hzhongkai
	* @date 2016年9月25日下午3:37:48
	*/
	@RequestMapping(value = "checkPower", method = RequestMethod.POST)
    ResponseDto checkPower(@RequestBody PowerConditionDto powerConditionDto) ;
	
	/**
	 * @description 承保系统获登录时校验业务权限，前端不用传险种代码
	 * @param PowerConditionDto
	 * @return ResponseDto
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月20日 上午10:28:48
	 */
	@RequestMapping(value = "checkPowerPrpall", method = RequestMethod.POST)
	CheckPowerPrpallResDto checkPowerPrpall(@RequestBody PowerConditionDto powerConditionDto) ;
	
	/**
	* @description 检验给定的员工是否具有针对某些数据操作的权限(查询方式为本机构及同级机构及下级机构)
	* @param  powerConditionDto
	* @return ResponseDto 
	* @author yangqunwei
	* @date 2016年10月17日 10:59:48
	*/
	@RequestMapping(value = "checkDataPower", method = RequestMethod.POST)
    ResponseDto checkDataPower(@RequestBody PowerConditionDto powerConditionDto) ;
	
	/**
	* @description 根据外部传入的信息获取查询条件附加权限
	* @param powerConditionDto
	* @return 拼接的查询条件SQL语句
	* @author hzhongkai
	* @date 2016年9月25日下午3:38:20
	*/
	@RequestMapping(value = "addPower", method = RequestMethod.POST)
    String addPower(@RequestBody PowerConditionDto powerConditionDto) ;
	
    /**
     * @description  获取可操作险种条件
     * @param powerConditionDto 查询条件DTO
     * @return  拼接的查询条件SQL语句
     * @author zkr07
     * @date 2016年10月14日下午2:52:34
     */
	@RequestMapping(value = "addRiskPower", method = RequestMethod.POST)
    String addRiskPower(@RequestBody PowerConditionDto powerConditionDto) ;

	/**
	 * 校验地址权限
	 * @author: 田健
	 * @date: 2018/2/22 16:49
	 * @param url 访问地址
	 * @return Map，中的value是布尔类型
	 */
	@RequestMapping(value = "checkURLPower", method = RequestMethod.POST)
	Map<String,Boolean> checkURLPower(@RequestParam(value = "url") String url)throws Exception ;

}
