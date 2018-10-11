package com.sinosoft.agriclaim.web.individuation;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.agriclaim.api.individuation.PrpLsumpayApi;
import com.sinosoft.agriclaim.api.individuation.dto.PayInfoBackDto;
import com.sinosoft.agriclaim.api.individuation.dto.PrpLsumpayDto;
import com.sinosoft.agriclaim.core.individuation.service.PrpLsumpayService;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-22 07:48:26.564 
 * @description 账户信息表controller层
 */
@RestController
@RequestMapping(value = PrpLsumpayController.PATH)
public class PrpLsumpayController implements PrpLsumpayApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLsumpayController.class);

    @Autowired
    private PrpLsumpayService prpLsumpayService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLsumpayDto prpLsumpayDto) {
        prpLsumpayService.save(prpLsumpayDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("serialNo")  String serialNo,@RequestParam("claimNo") String claimNo) {
        prpLsumpayService.remove(serialNo,claimNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLsumpayDto prpLsumpayDto) {
        prpLsumpayService.modify(prpLsumpayDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLsumpayDto queryByPK(@RequestParam("serialNo") String serialNo,@RequestParam("claimNo") String claimNo) {
        return prpLsumpayService.queryByPK(serialNo,claimNo);
    }

	@Override
	public List<PrpLsumpayDto> queryPrpLsumpayByCondition(@RequestParam("nodeType") String nodeType,@RequestParam("compensateNo") String compensateNo,@RequestParam("preparNo") String preparNo,@RequestParam("serialNo") String serialNo) {
		
		return prpLsumpayService.queryPrpLsumpayByCondition(nodeType, compensateNo, preparNo, serialNo);
	}

	/**
     * @description 支付信息退回接口
     * @author 汪钊
     * @date 2017年12月27日 上午11:02:56
     * @param payInfoBackDto
     * @return 
     */ 
	@Override
	public void payInfoBack(@RequestBody PayInfoBackDto payInfoBackDto) {
		prpLsumpayService.payInfoBack(payInfoBackDto);
	}
	
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
	@Override
	@ResponseBody
	public List<PrpLsumpayDto> queryByPreparNoAndExceptionFlagAndExceptionStartFlag(@RequestParam("preparNo")String preparNo,
			@RequestParam("exceptionFlag")String exceptionFlag,@RequestParam("exceptionStartFlag") String exceptionStartFlag,@RequestParam("compensateNo") String compensateNo)  throws Exception {
		
		return prpLsumpayService.queryByPreparNoAndExceptionFlagAndExceptionStartFlag(preparNo,exceptionFlag,exceptionStartFlag,compensateNo);
	}

}
