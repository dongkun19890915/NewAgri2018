package com.sinosoft.agriclaim.web.combinemanage;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.agriclaim.api.combinemanage.PrpLCombineApi;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCaseQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCaseQueryOutDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckDetailQueryDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckQueryOutDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimDetailQueryDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimQueryOutDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.PrpLCombineDto;
import com.sinosoft.agriclaim.core.combinemanage.service.PrpLCombineService;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-25 08:10:12.537 
 * @description controller
 */
@RestController
@RequestMapping(value = PrpLCombineController.PATH)
public class PrpLCombineController implements PrpLCombineApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCombineController.class);

    @Autowired
    private PrpLCombineService prpLCombineService;

   /**
     *@description 
     *@param
     */
    public void save(@RequestBody PrpLCombineDto prpLCombineDto) {
        prpLCombineService.save(prpLCombineDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("registNo") String registNo) {
        prpLCombineService.remove(registNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCombineDto prpLCombineDto) {
        prpLCombineService.modify(prpLCombineDto);
    }
    /**
     *@description  按主键查询实体
     *@param 
     */
    public PrpLCombineDto queryByPK(@RequestParam("registNo") String registNo) {
        return prpLCombineService.queryByPK(registNo);
    }
    /**
     * @descption 新增合并案件服务
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<PrpLCombineDto> 新增合并案件条件组织的对象集合
     * @return Map 返回是否成功
     */
	@Override
	public Map<String,String> saveCombine(@RequestBody List<PrpLCombineDto>  prpLCombineDtos) throws Exception {
		// TODO Auto-generated method stub
		return   prpLCombineService.saveCombine(prpLCombineDtos);
		

	}
/**
     * @descption 删除合并案件服务
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<PrpLCombineDto> 删除合并案件条件组织的对象集合
     * @return Map 返回是否成功
     */
	@Override
	public Map<String,String> logicRemoveCombine(@RequestBody List<PrpLCombineDto>  prpLCombineDtos) throws Exception {
		// TODO Auto-generated method stub
		return   prpLCombineService.logicRemoveComCase(prpLCombineDtos);
	}

	
	  /**
   * @descption 合并查勘定损页面初始化（ADD ,EDIT.SHOW）
   * @author moujiaxing
   * @date 2017-12-01
   * @param List<Map<String,String>> 合并查勘定损页面初始化（ADD ,EDIT.SHOW）条件组织的对象集合
   * @return List<ComCheckDetailQueryDto>  返回初始化对象集合
   */
	@Override
	public List<ComCheckDetailQueryDto> comCheckPageInit(@RequestBody List<Map<String,String>> listMap) throws Exception {
		// TODO Auto-generated method stub
		 return prpLCombineService.comCheckPageInit(listMap);
	}
    /**
     * @descption 合并立案页面初始化（ADD ,EDIT.SHOW）
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<Map<String,String>> 合并立案页面初始化（ADD ,EDIT.SHOW）条件组织的对象集合
     * @return List<ComClaimDetailQueryDto>  返回初始化对象集合
     */
	@Override
	public List<ComClaimDetailQueryDto> comClaimPageInit(@RequestBody List<Map<String,String>> listMap) throws Exception { 
		// TODO Auto-generated method stub
		return prpLCombineService.comClaimPageInit(listMap);
	}

	 /**
     * @descption 合并案件查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCaseQueryInDto 合并案件查询条件组织的对象
     * @return PageInfo 包含并案信息的PageInfo对象
     */
    public @ResponseBody PageInfo<ComCaseQueryOutDto> queryByComCaseInDto(@RequestBody ComCaseQueryInDto comCaseQueryInDto) {
        return prpLCombineService.queryByComCaseInDto(comCaseQueryInDto);
    }
    /**
     * @descption 合并查勘定损查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckQueryInDto 合并查勘定损查询条件组织的对象
     * @return PageInfo 包含合并查勘定损信息的PageInfo对象
     */
    public @ResponseBody PageInfo<ComCheckQueryOutDto> queryByComCheckInDto(@RequestBody ComCheckQueryInDto comCheckQueryInDto) throws Exception {
        return prpLCombineService.queryByComCheckInDto(comCheckQueryInDto);
    }
    
    /**
     * @descption 合并立案查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckQueryInDto 合并立案查询条件组织的对象
     * @return PageInfo 包含合并立案信息的PageInfo对象
     */
    public @ResponseBody PageInfo<ComClaimQueryOutDto> queryByComClaimInDto(@RequestBody ComClaimQueryInDto comClaimQueryInDto) throws Exception{
        return prpLCombineService.queryByComClaimInDto(comClaimQueryInDto);
    }
    /**
     * @descption 合并查勘定损暂存、提交服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckInDtoList 合并查勘定损暂存、提交信息列表
     */
    public @ResponseBody Map<String,String> saveSubmitComCheck(@RequestBody List<ComCheckInDto> comCheckInDtoList) throws Exception {
        return prpLCombineService.saveSubmitComCheck(comCheckInDtoList);
    }
    /**
     * @descption 合并立案提交服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckInDtoList 合并立案提交信息列表
     */
    public @ResponseBody Map<String,String> saveSubmitComClaim(@RequestBody List<ComClaimInDto> comCheckInDtoList) throws Exception {
        return prpLCombineService.saveSubmitComClaim(comCheckInDtoList);
    }
}
