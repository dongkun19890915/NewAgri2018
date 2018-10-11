package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.PowerApi;
import com.sinosoft.ims.api.auth.dto.CheckPowerPrpallResDto;
import com.sinosoft.ims.api.auth.dto.PowerConditionDto;
import com.sinosoft.ims.core.auth.service.PowerService;
import com.sinosoft.ims.core.common.enums.ImsErrorEnum;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(PowerApi.PATH)
public class PowerController implements PowerApi {
	
	private static Log LOGGER = LogFactory.getLog(PowerController.class);
    @Autowired
    private PowerService powerApi;

    /**
	 * @description 判断某个功能是否有权执行
	 * @param powerConditionDto
	 * @return ResponseDto
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月15日 下午3:42:55
	 */
	@Override
	public ResponseDto checkPower(@RequestBody PowerConditionDto powerConditionDto) {
		if(LOGGER.isInfoEnabled()){
			LOGGER.error(powerConditionDto.getUserCode() + "==" + powerConditionDto.getComCode());
		}
		//生成缓存key
		StringBuffer cacheKey = new StringBuffer();
		cacheKey.append(powerConditionDto.getUserCode())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getComCode())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getGradeCodes())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getTaskCodes());
		if(!StringUtils.isEmpty(powerConditionDto.getRiskCode())){
			cacheKey.append(IMSConstant.DILIMITER).append(powerConditionDto.getRiskCode());
		}
		if(!StringUtils.isEmpty(powerConditionDto.getSystemCode())){
			cacheKey.append(IMSConstant.DILIMITER).append(powerConditionDto.getSystemCode());
		}
		if(LOGGER.isInfoEnabled()){
			LOGGER.error("=rest cacheKey=" + cacheKey);
		}
		ResponseDto result = new ResponseDto();
		boolean value = powerApi.checkPower(powerConditionDto, cacheKey.toString());
		if(value){
			result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
			result.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
		}else{
			result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
			result.setResultMsg(ImsErrorEnum.IMS_ERROR.getName());
		}
		return result;
	}

	/**
	 * @description 检验给定的员工是否具有针对某些数据操作的权限(查询方式为本机构及同级机构及下级机构)
	 * @param powerConditionDto
	 * @return ResponseDto
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月15日 下午3:48:01
	 */
	@Override
	public ResponseDto checkDataPower(@RequestBody PowerConditionDto powerConditionDto) {
		if(LOGGER.isInfoEnabled()){
			LOGGER.error(powerConditionDto.getUserCode() + "=UserCode=" + powerConditionDto.getComCode());
		}
		//生成缓存key
		StringBuffer cacheKey = new StringBuffer();
		cacheKey.append(powerConditionDto.getUserCode())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getComCode())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getGradeCodes())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getDataUserCode())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getDataComCode());
		if(!StringUtils.isEmpty(powerConditionDto.getRiskCode())){
			cacheKey.append(IMSConstant.DILIMITER).append(powerConditionDto.getRiskCode());
		}
		if(!StringUtils.isEmpty(powerConditionDto.getQueryComType())){
			cacheKey.append(IMSConstant.DILIMITER).append(powerConditionDto.getQueryComType());
		}
		if(LOGGER.isInfoEnabled()){
			LOGGER.error("=rest cacheKey=" + cacheKey);
		}
		ResponseDto responseDto = null;
		responseDto = powerApi.checkDataPower(powerConditionDto, cacheKey.toString());
		return responseDto;
	}

	/**
	 * @description 根据外部传入的信息获取查询条件附加权限
	 * @param powerConditionDto
	 * @return String 附加的权限SQL语句
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月15日 下午3:52:52
	 */
	@Override
	public String addPower(@RequestBody PowerConditionDto powerConditionDto) {
		//生成缓存key
		StringBuffer cacheKey = new StringBuffer();
		cacheKey.append(powerConditionDto.getUserCode())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getComCode())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getGradeCodes())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getTableName());
		if(!StringUtils.isEmpty(powerConditionDto.getUserCodeFields())){
			cacheKey.append(IMSConstant.DILIMITER).append(powerConditionDto.getUserCodeFields());
		}
		if(!StringUtils.isEmpty(powerConditionDto.getComCodeFields())){
			cacheKey.append(IMSConstant.DILIMITER).append(powerConditionDto.getComCodeFields());
		}
		if(!StringUtils.isEmpty(powerConditionDto.getQueryComType())){
			cacheKey.append(IMSConstant.DILIMITER).append(powerConditionDto.getQueryComType());
		}
		if(LOGGER.isInfoEnabled()){
			LOGGER.error("=rest cacheKey=" + cacheKey);
		}
		String result = powerApi.addPower(powerConditionDto, cacheKey.toString());
		if(LOGGER.isInfoEnabled()){
			LOGGER.error("=result=" + result);
		}
		return result;
	}

	/**
	 * @description 获取可操作险种条件
	 * @param powerConditionDto
	 * @return String 附加的权限SQL语句
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月15日 下午3:56:53
	 */
	@Override
	public String addRiskPower(@RequestBody PowerConditionDto powerConditionDto) {
		//生成缓存key
		StringBuffer cacheKey = new StringBuffer();
		cacheKey.append(powerConditionDto.getUserCode())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getComCode())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getGradeCodes())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getTableName());
		if(LOGGER.isInfoEnabled()){
			LOGGER.error("=rest cacheKey=" + cacheKey);
		}
		String result = powerApi.addRiskPower(powerConditionDto, cacheKey.toString());
		if(LOGGER.isInfoEnabled()){
			LOGGER.error("=result=" + result);
		}
		return result;
	}

	/**
	 * @description 承保系统判断某个功能是否有权执行，前端不用传险种代码
	 * @param PowerConditionDto
	 * @return ResponseDto
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月20日 上午10:31:37
	 */
	@Override
	public CheckPowerPrpallResDto checkPowerPrpall(@RequestBody PowerConditionDto powerConditionDto) {
		if(LOGGER.isInfoEnabled()){
			LOGGER.error(powerConditionDto.getUserCode() + "==" + powerConditionDto.getComCode());
		}
		//生成缓存key
		StringBuffer cacheKey = new StringBuffer();
		cacheKey.append(powerConditionDto.getUserCode())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getComCode())
		.append(IMSConstant.DILIMITER).append(powerConditionDto.getTaskCodes());
		if(!StringUtils.isEmpty(powerConditionDto.getGradeCodes())){
			cacheKey.append(IMSConstant.DILIMITER).append(powerConditionDto.getGradeCodes());
		}
		if(LOGGER.isInfoEnabled()){
			LOGGER.error("=cacheKey=" + cacheKey);
		}
		CheckPowerPrpallResDto responseDto = null;
		responseDto = powerApi.checkPowerPrpall(powerConditionDto, cacheKey.toString());
		return responseDto;
	}
	/**
	 * 校验地址权限
	 * @author: 田健
	 * @date: 2018/2/22 16:49
	 * @param url 访问地址
	 * @return Map，中的value是布尔类型
	 */
	@Override
	@ResponseBody
	public Map<String,Boolean> checkURLPower(@RequestParam(value = "url") String url)throws Exception {
		System.out.println("权限校验url:"+url);
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		String userCode = SinoRequestContext.getCurrentContext().getUserCode();
		Boolean flag = powerApi.checkURLPower(url,userCode);
		map.put("authFlag",flag);
		return map;
	}

}
