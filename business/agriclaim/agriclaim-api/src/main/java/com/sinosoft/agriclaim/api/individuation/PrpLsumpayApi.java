package com.sinosoft.agriclaim.api.individuation;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.individuation.dto.PayInfoBackDto;
import com.sinosoft.agriclaim.api.individuation.dto.PrpLsumpayDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-22 07:48:26.564 
 * @description 账户信息表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLsumpayApi.PATH)
public interface PrpLsumpayApi {

    public static final String PATH = "prpLsumpay";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpLsumpayDto prpLsumpayDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("serialNo") String serialNo, @RequestParam("claimNo") String claimNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpLsumpayDto prpLsumpayDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLsumpayDto queryByPK(@RequestParam("serialNo") String serialNo, @RequestParam("claimNo") String claimNo);
    /**
	  * @description 理赔支付信息退回回写
	  * @author 汪钊
	  * @date 2017年11月14日 上午9:46:52
	  * @param nodeType 节点号
	  * @param compensateNo 计算书号
	  * @param preparNo 预赔号
	  * @param serialNo 序号
	  * @return prpLsumpayDtoList
	 */
    @RequestMapping(value = "queryPrpLsumpayByCondition",method = {RequestMethod.POST})
    List<PrpLsumpayDto> queryPrpLsumpayByCondition(@RequestParam("nodeType") String nodeType, @RequestParam("compensateNo") String compensateNo, @RequestParam("preparNo") String preparNo, @RequestParam("serialNo") String serialNo);

    /**
     * @description 支付信息退回接口
     * @author 汪钊
     * @date 2017年12月27日 上午11:02:56
     * @param payInfoBackDto
     * @return 
     */ 
     @RequestMapping(value = "payInfoBack",method = {RequestMethod.POST})
     void payInfoBack(@RequestBody PayInfoBackDto payInfoBackDto);
    
    /**
	  * @description 理赔支付信息回写
	  * @author 周柯宇
	  * @date 2017-12-8 14:17:28
	  * @param exceptionFlag 异常标记
	  * @param exceptionStartFlag 异常开始标记
	  * @param preparNo 预赔号
	  * @param compensateNo 计算书号
	  * @return prpLsumpayDtoList
	 */
    @RequestMapping(value = "queryByPreparNoAndExceptionFlagAndExceptionStartFlag",method = {RequestMethod.POST})
	List<PrpLsumpayDto> queryByPreparNoAndExceptionFlagAndExceptionStartFlag(@RequestParam("preparNo") String preparNo, @RequestParam("exceptionFlag") String exceptionFlag,
                                                                             @RequestParam("exceptionStartFlag") String exceptionStartFlag, @RequestParam("compensateNo") String compensateNo) throws Exception;

}