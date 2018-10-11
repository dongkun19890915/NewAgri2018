package com.sinosoft.agriclaim.api.prepaymanage;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrepayApplicationDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrepayDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrepayPageReqDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrepayPageResDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLSpeciQueryInDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.SpecialCaseReqDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.SpecialCaseResDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 特殊赔案服务接口类
 * @author 杨航
 * @date 2017年11月14日
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrepayApi.PATH)
public interface PrepayApi {

    public static final String PATH = "prepay";
     
    /**
	 * @description 承保需要的方法,根据条件查询PrpLPrepay
	 * @author 杨航
	 * @date 2017年11月13日 下午9:30:33
	 * @param prpLPrepayDto
	 *            特殊赔案信息
	 * @return prpLPrepayDtoList
	 */
    @RequestMapping(value = "queryPrpLPrepayByCondition",method = {RequestMethod.POST})
	@ResponseBody
	List<PrpLPrepayDto> queryPrpLPrepayByCondition(@RequestBody PrpLPrepayDto prpLPrepayDto);
    
    /**
   	 * @description 特殊赔案查询
   	 * @author 闫磊
   	 * @date 2017年11月24日 
   	 * @param prpLSpeciQueryInDto 查询入参对象
   	 * @return pageInfo 工作流主表信息大对象
   	 */
   	@RequestMapping(value = "queryBySpeciIn",method = {RequestMethod.POST})
   	@ResponseBody PageInfo<SwfLogExtendDto> queryBySpeciInDto(@RequestBody PrpLSpeciQueryInDto prpLSpeciQueryInDto)throws Exception;

   	/**
   	 * @description 特殊赔案前置查询
   	 * @author 闫磊
   	 * @date 2017年12月11日 
   	 * @param prpLSpeciQueryInDto 查询入参对象
   	 * @return pageInfo 工作流主表信息大对象
   	 */
   	@RequestMapping(value = "queryByTurnSpeciIn",method = {RequestMethod.POST})
   	@ResponseBody PageInfo<SwfLogExtendDto> queryByTurnSpeciInDto(@RequestBody PrpLSpeciQueryInDto prpLSpeciQueryInDto)throws Exception;
   	
   	/**
     * 
      * @description 特殊赔案信息提交
      * @author yk
      * @date 2017年12月14日 下午11:18:56
      * @param prepayDto 特殊赔案dto
      * @return String预赔号
     */
    @RequestMapping(value = "savePrepay",method = {RequestMethod.POST})
    Map<String, String> savePrepay(@RequestBody PrepayDto prepayDto) throws Exception;
   	
    
    /**
     * 
      * @description 特殊赔案申请提交
      * @author yk
      * @date 2017年12月14日 下午11:18:56
      * @param prepayApplicationDto 特殊赔案dto
      * @return String预赔号
     */
    @RequestMapping(value = "savePrepayApplication",method = {RequestMethod.POST})
    Map<String, String> savePrepayApplication(@RequestBody PrepayApplicationDto prepayApplicationDto);
    /**
   	 * @description 特殊赔案申请初始化
   	 * @author 安齐崇
   	 * @date 2017年12月11日 
   	 * @param requestDto 查询入参对象
   	 * @return pageInfo 工作流主表信息大对象
   	 */
    @RequestMapping(value = "queryPrepayApplyInfo",method = {RequestMethod.POST})
	@ResponseBody
	SpecialCaseResDto  specialCaseApplyInit(SpecialCaseReqDto requestDto) throws Exception;
    /**
	 * @description:方法功能简述:特殊赔案页面初始化对外服务方法
	 * @author 安齐崇
	 * @date 2017年12月7日上午9:59:05
	 * @param requestDto
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "prepayPageInit",method = {RequestMethod.POST})
    @ResponseBody
    PrepayPageResDto prepayPageInit(PrepayPageReqDto requestDto) throws Exception;
    
}