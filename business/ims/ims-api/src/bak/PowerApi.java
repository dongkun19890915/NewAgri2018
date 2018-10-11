package com.sinosoft.ims.api.kernel;

import java.util.List;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.PowerConditionDto;
import com.sinosoft.ims.api.kernel.dto.SaaUserPermitCompanyDto;
import com.sinosoft.ims.api.kernel.dto.TreeNodeDto;
import com.sinosoft.ims.api.kernel.dto.OptPowerConditionDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
* @description 权限管理服务接口
* @author hzhongkai
* @date 2016年9月22日下午5:06:26
*/
@FeignClient(name= IMSConstant.IMS_SERVICE_NAME,path = PowerApi.PATH)
public interface PowerApi {

	public static final String PATH = "power";
	
	/**
	* @description 用户数据权限配置服务(配置允许机构)
	* @param PowerQueryConditionDto
	* @return ResponseDto
	* @
	* @author hzhongkai
	* @date 2016年9月25日下午3:37:48
	*/
	@RequestMapping(value = "configUserPermitCompany", method = RequestMethod.POST)
    ResponseDto configUserPermitCompany(PowerConditionDto powerConditionDto) ;
	/**
	* @description 用户功能权限任务
	* @param  OptPowerConditionDto  - methodCode / actionURL 必填一项
	* @return ResponseDto 
	* @
	* @author yangqunwei
	* @date 2016年10月17日 10:59:48
	*/
	@RequestMapping(value = "checkUserPowerService", method = RequestMethod.POST)
    ResponseDto checkUserPowerService(OptPowerConditionDto powerConditionDto) ;
	
	
	/**
	* @description 用户权限机构获取服务(机构数据权限)
	* @param PowerQueryConditionDto
	* @return PowerReturnDto
	* @
	* @author hzhongkai
	* @date 2016年9月25日下午3:38:20
	*/
	@RequestMapping(value = "queryUserPermitCompanyList", method = RequestMethod.POST)
    List<SaaUserPermitCompanyDto> queryUserPermitCompanyList(PowerConditionDto powerQueryConditionDto) ;
    /**
     * @description  获取业务数据查询权限
     * @param powerConditionDto 查询条件DTO
     * @return  拼接的查询条件SQL语句
     * @
     * @author zkr07
     * @date 2016年10月14日下午2:52:34
     */
	@RequestMapping(value = "getPowerCondition", method = RequestMethod.POST)
    String getPowerCondition(PowerConditionDto powerConditionDto) ;

	/**
	* @description 根据用户获取机构树
	* @param companyConditionDto
	* @return TreeNodeDto
	* @
	* @author hzhongkai
	* @date 2016年10月20日上午11:21:20
	*/
	@RequestMapping(value = "getCompanyTree", method = RequestMethod.POST)
	List<TreeNodeDto> getCompanyTree(PowerConditionDto powerConditionDto) ;
	
	
	/**
	 * @description 创建用户数据权限
	 * @param powerConditionDto
	 * @return 返回powerId
	 * @
	 * @author hzhongkai
	 * @date 2016年10月21日上午11:53:02
	 */
	@RequestMapping(value = "createUserPower", method = RequestMethod.POST)
	String createUserPower(PowerConditionDto powerConditionDto)  ;
	
    
    /**
     * @description 获取用户允许机构查询权限
     * @param powerConditionDto
     * @return
     * @
     * @author hzhongkai
     * @date 2016年10月22日上午11:43:27
     */
	@RequestMapping(value = "getPowerCompanyCondition", method = RequestMethod.POST)
    String getPowerCompanyCondition(PowerConditionDto powerConditionDto) ;

	
}
