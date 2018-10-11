package com.sinosoft.agriclaim.core.individuation.service;



import java.util.List;

import com.sinosoft.agriclaim.api.individuation.dto.PayInfoBackDto;
import com.sinosoft.agriclaim.api.individuation.dto.PrpLsumpayDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-22 07:48:26.564 
 * @description 账户信息表Core接口
 */
public interface PrpLsumpayService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLsumpayDto prpLsumpayDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String serialNo, String claimNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLsumpayDto prpLsumpayDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLsumpayDto queryByPK(String serialNo, String claimNo);
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
    List<PrpLsumpayDto> queryPrpLsumpayByCondition(String nodeType, String compensateNo, String preparNo, String serialNo);

    /**
     * @description 支付信息退回接口
     * @author 汪钊
     * @date 2017年12月27日 上午11:02:56
     * @param payInfoBackDto
     * @return 
     */ 
    void payInfoBack(PayInfoBackDto payInfoBackDto);
    
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
	List<PrpLsumpayDto> queryByPreparNoAndExceptionFlagAndExceptionStartFlag(String preparNo, String exceptionFlag,
                                                                             String exceptionStartFlag, String compensateNo)  throws Exception;
}