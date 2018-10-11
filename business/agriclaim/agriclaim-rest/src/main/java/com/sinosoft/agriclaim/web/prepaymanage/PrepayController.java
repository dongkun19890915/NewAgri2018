package com.sinosoft.agriclaim.web.prepaymanage;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.agriclaim.api.prepaymanage.PrepayApi;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrepayApplicationDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrepayDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrepayPageReqDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrepayPageResDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLSpeciQueryInDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.SpecialCaseReqDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.SpecialCaseResDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrepayService;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 预赔控制器类
 * @author yanghang
 * @date 2017年11月13日
 */
@RestController
@RequestMapping(value = PrepayController.PATH)
public class PrepayController implements PrepayApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrepayController.class);
    
    @Autowired
    private PrepayService prepayService;

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
	public List<PrpLPrepayDto> queryPrpLPrepayByCondition(@RequestBody PrpLPrepayDto prpLPrepayDto) {
		return prepayService.queryPrpLPrepayByCondition(prpLPrepayDto);
	}
    
	/**
	 * @description 特殊赔案查询
	 * @author 闫磊
	 * @date 2017年11月24日
	 * @param prpLSpeciQueryInDto
	 *            查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	public PageInfo<SwfLogExtendDto> queryBySpeciInDto(@RequestBody PrpLSpeciQueryInDto PrpLSpeciQueryInDto)
			throws Exception {
		return prepayService.queryBySpeciInDto(PrpLSpeciQueryInDto);
	}

	/**
	 * @description 特殊赔案前置查询
	 * @author 闫磊
	 * @date 2017年12月11日
	 * @param prpLSpeciQueryInDto
	 *            查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	@Override
	public PageInfo<SwfLogExtendDto> queryByTurnSpeciInDto(@RequestBody PrpLSpeciQueryInDto prpLSpeciQueryInDto)
			throws Exception {
		return prepayService.queryByTurnSpeciInDto(prpLSpeciQueryInDto);
	}
	 /**
     * 
      * @description 特殊赔案的预付保存
      * @author yk
      * @date 2017年12月9日 上午12:28:26
      * @param prepayDto 预付信息对象
     */
	@Override
	public Map<String, String> savePrepay(@RequestBody PrepayDto prepayDto) throws Exception{
	 return	prepayService.savePrepay(prepayDto);
	}
	
	
	/**
     * 
      * @description 特殊赔案申请提交
      * @author yk
      * @date 2017年12月14日 下午11:18:56
      * @param prepayApplicationDto 特殊赔案dto
      * @return String预赔号
     */
	@Override
	public Map<String, String> savePrepayApplication(@RequestBody PrepayApplicationDto prepayApplicationDto) {
		return prepayService.savePrepayApplication(prepayApplicationDto);
	}
	 /**
   	 * @description 特殊赔案申请初始化
   	 * @author 安齐崇
   	 * @date 2017年12月11日 
   	 * @param requestDto 查询入参对象
   	 * @return pageInfo 工作流主表信息大对象
   	 */
	@Override
	@ResponseBody
	public SpecialCaseResDto specialCaseApplyInit(@RequestBody SpecialCaseReqDto requestDto) throws Exception {
		return prepayService.specialCaseApplyInit(requestDto);
	}

	/**
	 * @description:方法功能简述:特殊赔案页面初始化对外服务方法
	 * @author 安齐崇
	 * @date 2017年12月7日上午9:59:05
	 * @param requestDto
	 * @return
	 * @throws Exception
	 */
	@Override
	@ResponseBody
	public PrepayPageResDto prepayPageInit(@RequestBody PrepayPageReqDto requestDto) throws Exception {
		return prepayService.prepayPageInit(requestDto);
	}

}
