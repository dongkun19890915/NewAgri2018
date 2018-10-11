package com.sinosoft.notice.core.model.service.impl;

import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.notice.api.common.dto.SmsConditionDto;
import com.sinosoft.notice.api.common.dto.SmsContentDto;
import com.sinosoft.notice.core.model.entity.SmsContent;
import com.sinosoft.notice.core.model.service.SmsContentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 潘峰
 * @date 2017/12/11 上午11:15
 */
@Service
public class SmsContentServiceImpl extends BaseCustomServiceImpl implements SmsContentService {


    @PersistenceContext
    private EntityManager entityManager;



    /**
     * 短信发送列表信息查询
     *
     * @param smsConditionDto 包含查询条件的dto
     * @return 分页查询得到的数据
     * @author: 何伟东
     * @date: 2017/12/12 11:39
     */
    @Override
    public PageInfo<SmsContentDto> querySmsListByCondition(SmsConditionDto smsConditionDto) {
        int pageNo = smsConditionDto.getPageNo();
        int pageSize = smsConditionDto.getPageSize();
        if (pageNo < 1) {
            throw new DataVerifyException("页数不能小于1");
        }
        if (pageSize < 1) {
            throw new DataVerifyException("每页数量不能小于1");
        }
        StringBuilder dataSql = new StringBuilder("from SmsContent sms ");
        StringBuilder countSql = new StringBuilder("select count(1) from SmsContent sms ");

        List<String> conditionList = new ArrayList<>();
        Map<String, Object> paramMap = new HashMap<>();

        // 保单号
        if (StringUtils.isNotEmpty(smsConditionDto.getPolicyNo())) {
            conditionList.add("and sms.policyNo = :policyNo");
            paramMap.put("policyNo", smsConditionDto.getPolicyNo());
        }
        // 手机号
        if (StringUtils.isNotEmpty(smsConditionDto.getPhoneNo())) {
            conditionList.add("and sms.phoneNo = :phoneNo");
            paramMap.put("phoneNo", smsConditionDto.getPhoneNo());
        }
        // 投保人名称
        if (StringUtils.isNotEmpty(smsConditionDto.getAppName())) {
            conditionList.add("and sms.appName like :appName");
            paramMap.put("appName", "%"+smsConditionDto.getAppName()+"%");
        }
        // 投保人代码
        if (StringUtils.isNotEmpty(smsConditionDto.getAppCode())) {
            conditionList.add("and sms.appCode=:appCode");
            paramMap.put("appCode", smsConditionDto.getAppCode());
        }
        // 被保险人名称
        if (StringUtils.isNotEmpty(smsConditionDto.getInsuredName())) {
            conditionList.add("and sms.insuredName like :insuredName");
            paramMap.put("insuredName", "%"+smsConditionDto.getInsuredName()+"%");
        }
        // 被保险人代码
        if (StringUtils.isNotEmpty(smsConditionDto.getInsuredCode())) {
            conditionList.add("and sms.insuredCode = :insuredCode");
            paramMap.put("insuredCode", smsConditionDto.getInsuredCode());
        }
        // 机构代码
        if (StringUtils.isNotEmpty(smsConditionDto.getMakeCom())) {
            conditionList.add("and sms.makeCom = :makeCom");
            paramMap.put("makeCom", smsConditionDto.getMakeCom());
        }
        // 起保日期起期
        if (StringUtils.isNotEmpty(smsConditionDto.getStartDateStart())) {
            conditionList.add("and sms.startDate >= to_date(:startDateStart, 'yyyy-MM-dd')");
            paramMap.put("startDateStart", smsConditionDto.getStartDateStart());
        }
        // 起保日期止期
        if (StringUtils.isNotEmpty(smsConditionDto.getStartDateEnd())) {
            conditionList.add("and sms.startDate <= to_date(:startDateEnd, 'yyyy-MM-dd')");
            paramMap.put("startDateEnd", smsConditionDto.getStartDateEnd());
        }
        // 终保日期起期
        if (StringUtils.isNotEmpty(smsConditionDto.getEndDateStart())) {
            conditionList.add("and sms.endDate >= to_date(:endDateStart, 'yyyy-MM-dd')");
            paramMap.put("endDateStart", smsConditionDto.getEndDateStart());
        }
        // 终保日期止期
        if (StringUtils.isNotEmpty(smsConditionDto.getEndDateEnd())) {
            conditionList.add("and sms.endDate <= to_date(:endDateEnd, 'yyyy-MM-dd')");
            paramMap.put("endDateEnd", smsConditionDto.getEndDateEnd());
        }
        if (conditionList.size() > 0) {
            String condition = this.joinCondition(conditionList);
            dataSql.append("where").append(condition);
            countSql.append("where").append(condition);
        }
        Query countQuery = entityManager.createQuery(countSql.toString());
        this.setQueryParam(countQuery, paramMap);
        long countSize = (long) countQuery.getSingleResult();
        List<SmsContent> smsContentList = new ArrayList<>();
        if (countSize > 0) {
            dataSql.append(" order by sms.sendTime desc");
            Query dataQuery = entityManager.createQuery(dataSql.toString());
            this.setQueryParam(dataQuery, pageNo, pageSize, paramMap);
            smsContentList = dataQuery.getResultList();
        }
        PageInfo<SmsContentDto> smsContentDtoPageInfo = this.setPageInfo(smsContentList, pageNo, countSize, SmsContentDto.class);
        return smsContentDtoPageInfo;
    }
}
