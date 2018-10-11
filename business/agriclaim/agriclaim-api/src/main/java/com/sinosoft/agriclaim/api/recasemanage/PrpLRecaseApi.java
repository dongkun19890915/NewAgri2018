package com.sinosoft.agriclaim.api.recasemanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.recasemanage.dto.*;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-08 05:44:45.570
 * @description 重开赔案表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLRecaseApi.PATH)
public interface PrpLRecaseApi {

	public static final String PATH = "prpLRecase";

	/**
	 * @description 新增
	 * @param
	 */
	@RequestMapping(value = "save", method = { RequestMethod.POST })
	void save(@RequestBody PrpLRecaseDto prpLRecaseDto);

	/**
	 * @description 删除
	 * @param
	 */
	@RequestMapping(value = "remove", method = { RequestMethod.POST })
	void remove(@RequestParam("claimNo") String claimNo,@RequestParam("serialNo")Integer serialNo);

	/**
	 * @description 修改
	 * @param
	 */
	@RequestMapping(value = "modify", method = { RequestMethod.POST })
	void modify(@RequestBody PrpLRecaseDto prpLRecaseDto);

	/**
	 * @description 按主键查询实体
	 * @param
	 */
	@RequestMapping(value = "queryByPK", method = { RequestMethod.POST })
	PrpLRecaseDto queryByPK(@RequestParam("claimNo") String claimNo,@RequestParam("serialNo")Integer serialNo);

	/**
	 * @description 重开赔案查询信息
	 * @author: 王志文
	 * @date: 2017/11/3 10:08
	 * @param reCaseDto
	 *            输入框查询信息
	 * @return 重开赔案列表信息 List
	 * @throws Exception
	 */
	@RequestMapping(value = "queryReCaseByReCaseDto", method = { RequestMethod.POST })
	PageInfo queryReCaseByReCaseDto(@RequestBody ReCaseDto reCaseDto) throws Exception;
	/*
	 * "" 全险种 "H" 种植 "I" 养殖
	 */

	/**
	 * @description 精确查询重开赔案信息
	 * @author: 王志文
	 * @date: 2017/11/3 10:09
	 * @param claimNo 立案号
	 * @return 重开赔案详细信息
	 * @throws Exception
	 */
	@RequestMapping(value = "queryReCaseByClaimNo", method = { RequestMethod.GET })
	ReCaseViewDto queryReCaseByClaimNo(@RequestParam(value = "claimNo") String claimNo) throws Exception;

	/**
	 * 重开赔案申请提交
	 * @author: 王志文
	 * @date: 2017/11/3 14:30
	 * @param reCaseCommitDto 提交页面信息
	 * @return Map<String,String> 提交是否成功等相关信息
	 * @throws Exception
	 */
	@RequestMapping(value = "saveReCaseCommittedByReCaseDto", method = { RequestMethod.POST })
	Map<String, String> saveReCaseCommittedByReCaseDto(@RequestBody ReCaseCommitDto reCaseCommitDto) throws Exception;

	/**
	 * （双核审核重开赔案后调用，将审核状态写入到理赔表中）
	 * 
	 * @author: 王志文
	 * @date: 2017/11/17 15:18
	 * @param undwrtWriteBackReCaseDto
	 *            包含流程编号、序号、业务号、审核结果
	 * @return int 返回回写结果信息，大于0 则回写成功
	 * @throws Exception
	 */
	@RequestMapping(value = "saveCaseTypeByUndwrt", method = { RequestMethod.POST })
	String saveCaseTypeByUndwrt(@RequestBody UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception;

	/**
	 * （重开赔案成功后重新生成理算节点，将新的赔款计算书号写入到重开赔案表中）
	 * @author: 王志文
	 * @date: 2017/11/17 17:04
	 * @param compensateNo 计算书号
	 * @return 写入结果，成功或失败
	 * @throws Exception
	 */
	@RequestMapping(value = "saveCompensateNoByRecase", method = { RequestMethod.GET })
	Map<String, String> saveCompensateNoByRecase(@RequestParam("compensateNo") String compensateNo,
			@RequestParam("claimNo") String claimNo) throws Exception;
	/**
	 *  根据投保单号查询PrpLRecase表信息
	 * @author: 汪钊
	 * @date: 2017/11/20 15:50
	 * @param map 包括claimNo立案号
	 * @return prpLRecaseDtoList 返回PrpLRecaseDto的集合
	 */
	@RequestMapping(value = "queryByClaimNo", method = { RequestMethod.POST })
	List<PrpLRecaseDto> queryByClaimNo(@RequestBody Map<String, String> map);

}