package com.sinosoft.agriclaim.core.registmanage.service;

import java.util.List;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

/**
 * @description: 类功能简述：公共查询类
 * @author chong
 * @date 2017年11月15日下午9:34:05
 */
public interface PageInitCommonService {
	/**
	 * @description:方法功能简述: 根据险种编码查询险种类型
	 * @author 安齐崇
	 * @date 2017年11月15日下午9:37:23
	 * @param riskCode 险种编码
	 * @return riskType 险种类型
	 */
	String findRiskTypeByCode(String riskCode);

	/**
	 * @description:方法功能简述: 已出险次数查询
	 * @author 安齐崇
	 * @date 2017年11月17日上午12:58:12
	 * @param policyNo 保单号
	 * @param registNo 报案号
	 * @return intPerilCount 已出险次数
	 */
	int getSamePolicyRegistInfo(String policyNo, String registNo);

	/**
	 * @description:方法功能简述:通过条件查询utiPlatConfigRule中rule 信息
	 * @author 安齐崇
	 * @date 2017年11月18日下午5:11:57
	 * @param paramCode
	 * @return systemCode
	 */
	String getConfigRules(String paramCode, String systemCode);
	/**
	 * @description:方法功能简述:此方法为属性拷贝方法，若目标类里面属性有值以目标类为准，若目标类属性没值，则从资源类中获取并给目标类赋值，
	 * 目标类和资源类可以支持有父类
	 * @author 安齐崇
	 * @date 2017年11月21日上午12:50:11
	 * @param src 资源类
	 * @param des 目标类
	 */
	void copyPropertiesIfNull(Object src, Object des);

	/**
	 * @description: 用于集合属性拷贝
	 * @author 安齐崇
	 * @date 2017年11月2日下午8:06:07
	 * @param srcList 源集合
	 * @param desList 目标集合
	 */
	void copyCollection(List<Object> srcList, List<Object> desList);

	/**
	 * @description:方法功能简述: 根据保单号查询保费缴费状态
	 * @author 安齐崇
	 * @date 2017年11月25日下午1:53:30
	 * @param policyNo 保单号
	 * @return intRet 缴费状态 -1未缴，1，全缴，-2，缴部分
	 * @throws Exception 
	 */
	int checkPay(String policyNo) throws Exception;
	/**
	 * @description:方法功能简述: 欠费情况
	 * @author 安齐崇
	 * @date 2017年11月15日下午12:12:34
	 * @param prpCMainDto 保单对象
	 * @return delinquentfeeCase 分期付款欠费情况描述
	 */
	String getDelinquentfeeCase(PrpCmainDto prpCMainDto);
	/**
	 * @description:方法功能简述: 进行工作流占号校验，如果工作流被占用则抛出异常
	 * @author 安齐崇
	 * @date 2017年12月7日下午2:54:03
	 * @param flowID 工作流id
	 * @param logNo  工作流编号
	 * @param userCode 用户编码
	 * @param userName 用户名称
	 * @param registNo 报案号
	 */
	void verifyIsHoldNode(String flowID,String logNo,String userCode,String userName,String businessNo);
    /**
     * @description:方法功能简述: 查询保单大对象，如果有批单进行信息回倒
     * @author 安齐崇
     * @date 2017年12月11日下午7:32:47
     * @param policyNo
     * @param strDate
     * @param strHour
     * @return policyDto 保单大对象
     * @throws Exception 
     */
	ResponseQueryPolicyInfoDto findEndOrBefore(String policyNo, String strDate, String strHour) throws Exception;
	/**
	 * @description:方法功能简述: 
	 * @author 安齐崇
	 * @date 2017年12月13日下午2:22:47
	 * @param business
	 * @param nodeType
	 */
}
