package com.sinosoft.agriclaim.core.registmanage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sinosoft.agriclaim.api.registmanage.dto.CompensateFeeDto;
import com.sinosoft.agriclaim.api.registmanage.dto.RelatePolicyInfoDto;
import com.sinosoft.agriclaim.api.registmanage.dto.RelateRegistExtDto;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistRPolicyDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistKey;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistRPolicy;
import com.sinosoft.agriclaim.core.registmanage.service.RelatePolicyInfoService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriprpall.api.endorsemanage.PrpPheadApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.policymanage.PolicyQueryApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;

/**
 * @author 陈旭
 * @time 2017-11-14 15:38:49.324
 * @description 保单关联信息Core接口实现
 */
@Service
public class RelatePolicyInfoServiceImpl extends BaseServiceImpl implements RelatePolicyInfoService {
	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RelatePolicyInfoServiceImpl.class);

	private static final Exception DataVerifyException = null;

	@Autowired
	private PrpLRegistDao prpLRegistDao;
	@Autowired
	private PrpLRegistRPolicyDao prpLRegistRPolicyDao;
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private SwfLogDao swfLogDao;
	@Autowired
	private PolicyQueryApi policyQueryApi;
	@Autowired
	private PrpPheadApi prpPheadApi;

	/**
	  * @description 关联保单
	  * @author 安齐崇
	  * @date 2017年12月29日 上午11:13:05
	  * @param policyNoMap 里面只有保单号
	  * @return relatePolicyInfoDto 关联保单大对象
	 */
	@Override
	public RelatePolicyInfoDto showRelateInfo(Map<String, String> policyNoMap) throws Exception {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("进入关联RelatePolicyInfoServiceImpl,获得的保单号是{}", policyNoMap.get("policyNo"));
		}
		RelatePolicyInfoDto relatePolicyInfoDto = new RelatePolicyInfoDto();
		if (StringUtils.isNotEmpty(policyNoMap.get("policyNo"))) {
			// 查询保单大对象 ，待调承保服务
			Map<String,String> policyMap = new HashMap<>();
			policyMap.put("policyNo", policyNoMap.get("policyNo"));
			ResponseQueryPolicyInfoDto responseDto = policyQueryApi
					.queryPolicyInfoByPolicyNo(policyMap);
			PrpCmainDto prpCmainDto = responseDto.getPrpCmainDto();
			// 查询批单大对象 ，待调承保服务
			List<PrpPheadDto> headList = prpPheadApi.queryAllByPolicyNo(policyNoMap);
			if (headList == null) {
				headList = new ArrayList<>();
			}
			Specification<PrpLRegist> specification = Specifications.<PrpLRegist>and()
					.eq("policyNo", policyNoMap.get("policyNo")).build();
			List<PrpLRegist> registList = prpLRegistDao.findAll(specification);
			List<RelateRegistExtDto> registExtDtoList = new ArrayList<RelateRegistExtDto>();
			this.convertCollection(registList, registExtDtoList, RelateRegistExtDto.class);
			if (registExtDtoList.size() == 0) {
				List<PrpLRegistRPolicy> registRPolicyList = prpLRegistRPolicyDao.findAll(
						Specifications.<PrpLRegistRPolicy>and().eq("policyNo", policyNoMap.get("policyNo")).build());
				for (int i = 0; i < registRPolicyList.size(); i++) {
					PrpLRegistRPolicy prpLRegistRPolicyDto = registRPolicyList.get(i);
					PrpLRegist registDto = prpLRegistDao.findOne(new PrpLRegistKey(prpLRegistRPolicyDto.getRegistNo()));
					RelateRegistExtDto prpLregistDto = this.convert(registDto, RelateRegistExtDto.class);
					String statement = "select sum(t.sumpaid)  from prplcompensate t  where  t.claimno = '"
							+ prpLRegistRPolicyDto.getRegistNo()
							+ "' and (t.UnderWriteFlag = '1' or t.UnderWriteFlag ='3')";
					Query query = entityManager.createNativeQuery(statement);
					double sumPaid = 0.0;
					if (query.getSingleResult() != null) {
						sumPaid = (double) query.getSingleResult();
					}
					CompensateFeeDto feeDto = new CompensateFeeDto();
					feeDto.setSumPaid(sumPaid);
					prpLregistDto.setCompensateFeeDto(feeDto);
					List<SwfLog> swfLogList = swfLogDao.findAll(Specifications.<SwfLog>and()
							.eq("businessNo", prpLRegistRPolicyDto.getRegistNo()).eq("nodeType", "regis").build());
					String flowId = "";
					for (SwfLog swfLog : swfLogList) {
						flowId = swfLog.getFlowId();
					}
					prpLregistDto.setWorkFlowId(flowId);
					registExtDtoList.add(prpLregistDto);
				}
			}
			else {
				// 下面分别计算每个报案的赔款金额
				for (int i = 0; i < registExtDtoList.size(); i++) {
					RelateRegistExtDto prpLregistDto = registExtDtoList.get(i);
					// 设置报案信息的赔款金额
					String statement = "select sum(t.sumpaid)  from prplcompensate t  where  t.claimno = '"
							+ prpLregistDto.getRegistNo() + "' and (t.UnderWriteFlag = '1' or t.UnderWriteFlag ='3')";

					Query query = entityManager.createNativeQuery(statement);
					double sumPaid = 0.0;
					if (query.getSingleResult() != null) {
						sumPaid = (double) query.getSingleResult();
					}
					CompensateFeeDto feeDto = new CompensateFeeDto();
					feeDto.setSumPaid(sumPaid);
					prpLregistDto.setCompensateFeeDto(feeDto);
					List<SwfLog> swfLogList = swfLogDao.findAll(Specifications.<SwfLog>and()
							.eq("businessNo", prpLregistDto.getRegistNo()).eq("nodeType", "regis").build());
					String flowId = "";
					for (SwfLog swfLog : swfLogList) {
						flowId = swfLog.getFlowId();
					}
					prpLregistDto.setWorkFlowId(flowId);
				}
			}

			// 设置保单主信息
			relatePolicyInfoDto.setPrpCmainDto(prpCmainDto);
			// 设置批单信息(List中保存的是PrpPheadDto对象)
			relatePolicyInfoDto.setPrpPheadDtoList(headList);

			// 设置报案信息(List中保存的是:prpLregistDto对象)
			relatePolicyInfoDto.setPrpLregistDtoList(registExtDtoList);

			return relatePolicyInfoDto;
		} else {
			throw new BusinessException("关联保单数据处理异常！");
		}
	}
}