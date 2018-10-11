package com.sinosoft.agriclaim.core.individuation.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sinosoft.agriclaim.api.individuation.dto.PayInfoBackDto;
import com.sinosoft.agriclaim.api.individuation.dto.PrpLsumpayDto;
import com.sinosoft.agriclaim.api.individuation.dto.PrpLsumpayLogDto;
import com.sinosoft.agriclaim.core.individuation.dao.PrpLsumpayDao;
import com.sinosoft.agriclaim.core.individuation.dao.PrpLsumpayLogDao;
import com.sinosoft.agriclaim.core.individuation.entity.PrpLsumpay;
import com.sinosoft.agriclaim.core.individuation.entity.PrpLsumpayKey;
import com.sinosoft.agriclaim.core.individuation.entity.PrpLsumpayLog;
import com.sinosoft.agriclaim.core.individuation.service.PrpLsumpayLogService;
import com.sinosoft.agriclaim.core.individuation.service.PrpLsumpayService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.exception.BusinessException;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-22 07:48:26.564 
 * @description 账户信息表Core接口实现
 */
@Service
public class PrpLsumpayServiceImpl extends BaseServiceImpl implements PrpLsumpayService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLsumpayServiceImpl.class);
    
    @Autowired
    private PrpLsumpayDao prpLsumpayDao;
    @Autowired
    private PrpLsumpayLogDao prpLsumpayLogDao;
    @Autowired
    private PrpLsumpayLogService prpLsumpayLogService;
    
    /**
     *@description 新增
     *@param
     */
    public void save(PrpLsumpayDto prpLsumpayDto) {
        PrpLsumpay prpLsumpay = this.convert(prpLsumpayDto, PrpLsumpay.class);
        prpLsumpayDao.save(prpLsumpay);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String serialNo,String claimNo) {
        PrpLsumpayKey prpLsumpayKey = new PrpLsumpayKey(serialNo,claimNo);
        prpLsumpayDao.delete(prpLsumpayKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLsumpayDto prpLsumpayDto) {
        PrpLsumpay prpLsumpay = this.convert(prpLsumpayDto, PrpLsumpay.class);
        prpLsumpayDao.save(prpLsumpay);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLsumpayDto queryByPK(String serialNo,String claimNo) {
        PrpLsumpayKey prpLsumpayKey = new PrpLsumpayKey(serialNo,claimNo);
        PrpLsumpay prpLsumpay = prpLsumpayDao.findOne(prpLsumpayKey);
        return this.convert(prpLsumpay,PrpLsumpayDto.class);
    }
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
	@Override
	public List<PrpLsumpayDto> queryPrpLsumpayByCondition(String nodeType, String compensateNo, String preparNo,
			String serialNo) {
		
		Specification<PrpLsumpay> build = Specifications.<PrpLsumpay>and().eq("nodeType", nodeType).eq(StringUtils.isNotEmpty(compensateNo), "compensateNo", compensateNo).eq(StringUtils.isNotEmpty(preparNo), "preparNo", preparNo).eq("serialNo", serialNo).build();
		List<PrpLsumpay> prpLsumpayList = prpLsumpayDao.findAll(build);
		List<PrpLsumpayDto> prpLsumpayDtoList = new ArrayList<PrpLsumpayDto>();
		this.convertCollection(prpLsumpayList, prpLsumpayDtoList, PrpLsumpayDto.class);
		return prpLsumpayDtoList;
	}
	
	/**
     * @description 支付信息退回接口
     * @author 汪钊
     * @date 2017年12月27日 上午11:02:56
     * @param payInfoBackDto
     * @return 
     */ 
	@Override
	public void payInfoBack(PayInfoBackDto payInfoBackDto) {
		
		Specification<PrpLsumpay> build = Specifications.<PrpLsumpay>and().eq("nodeType", payInfoBackDto.getNodeType()).eq(StringUtils.isNotBlank(payInfoBackDto.getCompensateNo()), "compensateNo", payInfoBackDto.getCompensateNo()).eq(StringUtils.isNotBlank(payInfoBackDto.getPreparNo()), "preparNo", payInfoBackDto.getPreparNo()).eq("serialNo", payInfoBackDto.getAcpaymentInfoId()).build();
		List<PrpLsumpay> prpLsumpayList = prpLsumpayDao.findAll(build);
		List<PrpLsumpayDto> prpLsumpayDtoList = new ArrayList<PrpLsumpayDto>();
		this.convertCollection(prpLsumpayList, prpLsumpayDtoList, PrpLsumpayDto.class);
		if(prpLsumpayDtoList==null || prpLsumpayDtoList.size()==0){
			throw new BusinessException("支付信息退回失败，业务号或业务类型无效");
		}
		PrpLsumpayDto prpLsumpayDto = prpLsumpayDtoList.get(0);
		prpLsumpayDto.setStatus("3");// 置为退回状态。
		prpLsumpayDto.setHandlerCode("");
		prpLsumpayDto.setHandlerName("");
		prpLsumpayDto.setHandleTime(DateTime.current());
		prpLsumpayDto.setBackReasonCode(payInfoBackDto.getBackCode());
		prpLsumpayDto.setBackReason(payInfoBackDto.getBackMessage());
		this.modify(prpLsumpayDto);		
		PrpLsumpayLogDto prpLsumpayLogDto = this.convert(prpLsumpayDto, PrpLsumpayLogDto.class);
		String insuredName = prpLsumpayDto.getInsuredName();
		if(insuredName==null){
		   insuredName = "";
		}
		String accountName = prpLsumpayDto.getAccountName();
		if(accountName==null){
			accountName = "";
		}
		if(insuredName.equals(accountName)) {//设置同一人标志
			prpLsumpayDto.setSamePersonFlag("1");
    	} else {
    		prpLsumpayDto.setSamePersonFlag("0");
    	}
		List<PrpLsumpayLog> prpLsumpayLogList = prpLsumpayLogDao.findAll(Specifications.<PrpLsumpayLog>and()
				.eq("claimNo", prpLsumpayDto.getClaimNo())
				.eq("serialNo", prpLsumpayDto.getSerialNo())
				.build());
		int count = 0;
		if(prpLsumpayLogList!=null && prpLsumpayLogList.size()>0){
			count = prpLsumpayLogList.size();
		}
		prpLsumpayLogDto.setLogNo(String.valueOf(count+1));
		prpLsumpayLogDto.setCertiId(payInfoBackDto.getCertiId());
		prpLsumpayLogDto.setUploadFileName(payInfoBackDto.getUploadFileName());
		prpLsumpayLogService.save(prpLsumpayLogDto);
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
	public List<PrpLsumpayDto> queryByPreparNoAndExceptionFlagAndExceptionStartFlag(String preparNo,
			String exceptionFlag, String exceptionStartFlag,String compensateNo) throws Exception {
		
		Specification<PrpLsumpay> build = Specifications.<PrpLsumpay>and().eq(StringUtils.isEmpty(preparNo),"preparNo", preparNo).eq(StringUtils.isNotEmpty(exceptionFlag), "exceptionFlag", exceptionFlag).eq(StringUtils.isNotEmpty(exceptionStartFlag), "exceptionStartFlag", exceptionStartFlag).eq(StringUtils.isEmpty(compensateNo),"compensateNo", compensateNo).build();
		List<PrpLsumpay> prpLsumpayList = prpLsumpayDao.findAll(build);
		List<PrpLsumpayDto> prpLsumpayDtoList = new ArrayList<PrpLsumpayDto>();
		this.convertCollection(prpLsumpayList, prpLsumpayDtoList, PrpLsumpayDto.class);
		return prpLsumpayDtoList;
	}
}