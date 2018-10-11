package com.sinosoft.agriclaim.web.businessutilmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.agriclaim.api.businessutilmanage.ClaimBoxInitApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ClaimBoxInitRequestVo;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ClaimBoxInitResponseVo;
import com.sinosoft.agriclaim.core.businessutilmanage.service.ClaimBoxInitService;
/**
 * @description: 类功能简述：复选框下拉框初始化服务控制类
 * @author 安齐崇
 * @date 2017年12月9日下午4:46:56
 *
 */
@RestController
@RequestMapping(ClaimBoxInitController.PATH)
public class ClaimBoxInitController implements ClaimBoxInitApi {
	@Autowired
	private ClaimBoxInitService claimBoxInitService;

	/**
	 * @description:方法功能简述: 初始化下拉框复选框服务方法
	 * @author 安齐崇
	 * @date 2017年12月9日下午4:42:12
	 * @return
	 * @throws Exception
	 */
	@Override
	@ResponseBody
	public ClaimBoxInitResponseVo queryAllClaimBox(@RequestBody ClaimBoxInitRequestVo requestDto) throws Exception {
		return claimBoxInitService.queryCommonData(requestDto);
	}

}
