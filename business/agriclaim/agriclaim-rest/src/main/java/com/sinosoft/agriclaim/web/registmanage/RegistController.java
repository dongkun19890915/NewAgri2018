package com.sinosoft.agriclaim.web.registmanage;

import com.sinosoft.agriclaim.api.registmanage.RegistApi;
import com.sinosoft.agriclaim.api.registmanage.dto.*;
import com.sinosoft.agriclaim.core.registmanage.service.RegistService;
import com.sinosoft.framework.dto.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * @description 报案信息表controller层
 */
@RestController
@RequestMapping(value = RegistController.PATH)
public class RegistController implements RegistApi {

    private static Logger LOGGER = LoggerFactory.getLogger(RegistController.class);

    @Autowired
    private RegistService registService;

    /**
     * @description 根据条件查询报案主表的信息
     * @author 杨航
     * @date 2017年11月20日 下午3:14:03
     * @param prpLRegistDto 报案信息
     * @return prpLRegistDtoList 报案信息集合
     */
	@Override
	public List<PrpLRegistDto> queryPrpLRegistByCondition(@RequestBody PrpLRegistDto prpLRegistDto) {
		return registService.queryPrpLRegistByCondition(prpLRegistDto);
	}
	
	/**
	 * @description 报案登记根据查询入参分页查询保单列表信息
	 * @author 杨成程
	 * @date 2017/11/09 15:00
	 * @param requestDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageInfo<ResponseQueryPolicyListInfoDto> queryPolicyListInfo(
			@RequestBody RequestQueryPolicyListInfoDto requestDto) throws Exception {
		return registService.queryPolicyListInfo(requestDto);
	}
	/**
	 * @description:方法功能简述: 报案登记页面初始化
	 * @author 安齐崇
	 * @date 2017年11月22日下午7:22:52
	 * @param requestDto
	 *            封装入参的传输对象
	 * @throws Exception
	 */
	@Override
	public RegistPageResDto registPageInit(@RequestBody RegistPageReqDto requestDto) throws Exception {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("报案登记页面初始化开始....");
		}
		RegistPageResDto responseDto = registService.getPageInfo(requestDto);
		return responseDto;
	}
	/**
	 * @description:方法功能简述: 出险信息查询
	 * @author 安齐崇
	 * @date 2017年11月22日下午7:22:52
	 * @param map
	 *            封装入参
	 * @throws Exception
	 */
	@Override
	@ResponseBody
	public RiskInfoResponseDto queryPerilInfo(@RequestBody Map<String, String> map) {
		return registService.findRiskInfo(map.get("policyNo"));
	}
	 /**
     * @description 按条件查询报案任务
     * @author majunlng
     * @param prpLregistQueryDto 查询条件
     * @return pageInfo 查询结果列表分页
     * @throws Exception 
     * @date 2017－11－10
     */
    @Override
    public  @ResponseBody PageInfo<PrpLregistResponseDto> queryPrpLregistList(@RequestBody PrpLregistQueryDto prpLregistQueryDto) throws Exception  {
        return registService.queryPrpLregistByCondition(prpLregistQueryDto);
    }
	/**
	 * @description:根据传入进来的报案信息dto进行报案登记的保存,ReportRegistrationApi的实现
	 * @param registDto 报案对象
	 * @return map 返参对象
	 * @author 杨昆
	 * @throws Exception 
	 * @date:2017年10月28日下午12:53:31
	 */
	@Override
	public @ResponseBody Map<String,String> saveReport(@RequestBody ReportDto registDto) throws Exception {
		return  registService.saveReport(registDto);
	}
	/**
	 * 报案撤销
	 * @param registDto 报案对象
	 * @return map 返参对象
	 * @author 杨昆
	 * @throws Exception 
	 * @date:2017年10月28日下午12:53:31
	 */
	@Override
	public Map<String,String> cancelReport(@RequestBody PrpLRegistDtoExtend prpLRegistDto) throws Exception {
		return  registService.cancelReport(prpLRegistDto);
	}

	/**
	 * 金禾调用的报案登记接口
	 * @param registDto 报案对象
	 * @return map 返参对象
	 * @author 王保良
	 * @throws Exception
	 * @date:2017年10月28日下午12:53:31
	 */
	@Override
	public Map<String, String> gisSaveReport(@RequestBody AgriRegistDto agriRegistDto) throws Exception {

		return registService.gisSaveReport(agriRegistDto);
	}
}
