package com.sinosoft.dms.api.bill;


import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.bill.dto.BillConditionDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description （单号生成接口服务）
 * @author dongyingchun
 * @date 2016年9月14日下午2:29:59
 */
@FeignClient(value = DMSConstant.DMS_SERVICE_NAME, path=BillApi.ServicePath)
public interface BillApi {

    public static final String ServicePath = "billNo";

    /**
	 * @description （获取以前缀为类型的单号）
	 * @param billConditionDto
	 * @return
	 * @author zxp
	 * @date 2017年8月29日
	 */
    @RequestMapping(value = "billNo",method = {RequestMethod.POST})
	public String getBillNo(@RequestBody BillConditionDto billConditionDto) throws Exception;
    
	/**
	 * @description （获取投保单号）
	 * @param billConditionDto
	 * @return
	 * @author dongyingchun
	 * @date 2016年9月16日下午6:27:23
	 */
    @RequestMapping(value = "proposalNo",method = {RequestMethod.POST})
	public String getProposalNo(@RequestBody BillConditionDto billConditionDto) throws Exception;
	//public BillDto getProposalNo(BillConditionDto billConditionDto) throws Exception;


	/**
	 * @description 订单号生成
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 * @author zkr10
	 * @date 2016年9月28日下午7:01:59
	 */
    @RequestMapping(value = "orderNo",method = {RequestMethod.POST})
	public String getOrderNo(@RequestBody BillConditionDto billConditionDto) throws Exception;
	//public BillDto getOrderNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description （获取保单号）
	 * @param billConditionDto
	 * @return
	 * @author dongyingchun
	 * @date 2016年9月16日下午6:27:39
	 */
    @RequestMapping(value = "policyNo",method = {RequestMethod.POST})
	public String getPolicyNo(@RequestBody BillConditionDto billConditionDto) throws Exception;
	//public BillDto getPolicyNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description （ 获取批单号）
	 * @param billConditionDto
	 * @return
	 * @author ThinkPad
	 * @date 2016年9月16日下午6:27:58
	 */
    @RequestMapping(value = "endorseNo",method = {RequestMethod.POST})
	public String getEndorseNo(@RequestBody BillConditionDto billConditionDto) throws Exception;
    //public BillDto getEndorseNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description （获取批单申请号）
	 * @param billConditionDto
	 * @return
	 * @author ThinkPad
	 * @date 2016年9月16日下午6:28:08
	 */
    @RequestMapping(value = "applyNo",method = {RequestMethod.POST})
	public String getApplyNo(@RequestBody BillConditionDto billConditionDto) throws Exception;
    //public BillDto getApplyNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description (获取标的号)
	 * @param billConditionDto
	 * @return BillDto
	 * @author ZhangJiansen
	 * @date 2016年9月16日下午6:28:27
	 */
	@RequestMapping(value = "itemNo")
	public String getItemNo(@RequestBody BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description 客户编号生成
	 * 如果是个人客户，传值customerCode_1,加11位序号，
	 * 如果法人，则传值customerCode_2，加11位序号.进行截取处理，将_后面的截取
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 * @author zkr10
	 * @date 2016年9月27日下午8:07:45
	 */
	@RequestMapping(value = "customerCode")
	public String getCustomerCode(@RequestBody BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description 系统中表主键流水号生成
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 * @author zkr10
	 * @date 2016年9月27日下午8:08:02
	 */
	@RequestMapping(value = "serialNo")
	public String getSerialNo(@RequestBody BillConditionDto billConditionDto) throws Exception;
}