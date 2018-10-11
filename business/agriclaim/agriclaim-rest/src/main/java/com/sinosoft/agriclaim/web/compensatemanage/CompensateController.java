package com.sinosoft.agriclaim.web.compensatemanage;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sinosoft.agriclaim.api.compensatemanage.CompensateApi;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensatePageRequestDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensatePageResponseDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensateSaveInDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompeQueryInDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.agriclaim.core.compensatemanage.service.CompensateService;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 养殖险理赔明细表controller层
 */
@RestController
@RequestMapping(value = CompensateController.PATH)
public class CompensateController implements CompensateApi {

    private static Logger LOGGER = LoggerFactory.getLogger(CompensateController.class);

    @Autowired
    private CompensateService compensateService;

    /**
	  * @description 承保需要的服务,根据条件查询计算书信息集合
	  * @author 杨航
	  * @date 2017年11月14日 上午9:46:52
	  * @param prpLCompensateDto 计算书信息入参
	  * @return prpLCompensateDtoList
	 */
	@Override
	public List<PrpLCompensateDto> queryPrpLCompensateByCondition(@RequestBody PrpLCompensateDto prpLCompensateDto) {
		return compensateService.queryPrpLCompensateByCondition(prpLCompensateDto);
	}
	
	/**
	 * @description 理算查询
	 * @author 闫磊
	 * @date 2017年11月24日 
	 * @param prpLCompeQueryInDto 查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	@Override
	public PageInfo<SwfLogExtendDto> queryByCompeInDto(@RequestBody PrpLCompeQueryInDto prpLCompeQueryInDto)throws Exception{
		return compensateService.queryByCompeInDto(prpLCompeQueryInDto);
	}
	/**
	 * @description 理算暂存提交
	 * @author 闫磊
	 * @date 2017年12月8日 
	 * @param  compensateSaveInDto 获取主键的对象
	 * @return map 成功或者失败
	 */
	@Override
	public Map<String,Object> saveSubmitBySave(@RequestBody CompensateSaveInDto compensateSaveInDto)throws Exception{
		return compensateService.saveSubmitBySave(compensateSaveInDto);
	}
	/**
	 * @description:方法功能简述:理算页面初始化对外服务方法
	 * @author 安齐崇
	 * @date 2017年11月13日下午1:55:28
	 * @param requestDto 参数接收类
	 * @return responseDto 组装数据类
	 * @throws Exception 
	 */
	@Override
	public @ResponseBody CompensatePageResponseDto compensatePageInit(@RequestBody CompensatePageRequestDto requestDto) throws Exception {
		return compensateService.compensatePageInit(requestDto);
	}

	/**
	 * （理算时重新生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/12 15:08
	 * @param compensateNo
	 * @throws Exception
	 */
	public void getLDangerInfoNewC(@RequestParam("compensateNo") String compensateNo) throws Exception{
		compensateService.getLDangerInfoNewC(compensateNo);
	}

	/**
	 * （理算时生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/12 15:08
	 * @param prpLcompensateDto
	 * @throws Exception
	 */
	public void getCDangerInfo (@RequestBody PrpLCompensateDto prpLcompensateDto) throws Exception{
		compensateService.getCDangerInfo(prpLcompensateDto);
	}
}
