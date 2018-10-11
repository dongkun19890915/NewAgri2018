package com.sinosoft.demo.core.customer.service;

import com.sinosoft.demo.core.customer.dao.PrpDuserDao;
import com.sinosoft.demo.core.customer.entity.PrpDuser;
import com.sinosoft.demo.core.customer.entity.PrpDuserKey;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 *@Description:客户信息service类
 *@Author:周家伟
 *@Since:2017年9月29日
 */
public interface PrpDuserService {

    /**
     *
     * @param prpDuserKey
     * @return
     */
    //一、继承JPA自带方法
    public PrpDuser findOne(PrpDuserKey prpDuserKey);


    /**
     * @description 批插事务验证 多张表同时插入，异常回滚
     * @author 汪强
     * @date 14:27:00  2017-10-20
     * @param
     * @return
     * @throws Exception
     */
    public void insertBatchTranscation() throws Exception;


}
