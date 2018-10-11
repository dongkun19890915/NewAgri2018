package com.sinosoft.notice.core.model.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.notice.core.model.entity.SmsContent;
import com.sinosoft.notice.core.model.entity.SmsContentKey;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 潘峰
 * @date 2017/12/11 上午11:16
 */
public interface SmsContentDao extends JpaBaseDao<SmsContent, SmsContentKey> {


    @Query(value = "SELECT n FROM SmsContent n where n.distributed ='1' AND  n.sendTime = TO_DATE(TO_CHAR(sysdate,'yyyy-mm-dd hh24:mi'),'yyyy-mm-dd hh24:mi')")
    List<SmsContent> findByTimeAndStatus();

    Integer countByPolicyNo(String policyNo);

    List<SmsContent> findByPolicyNo(String policyNo);
}
