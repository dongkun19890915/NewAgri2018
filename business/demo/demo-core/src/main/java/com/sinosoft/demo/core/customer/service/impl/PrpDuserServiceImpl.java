package com.sinosoft.demo.core.customer.service.impl;

import com.sinosoft.demo.core.customer.dao.PrpDcustomerDao;
import com.sinosoft.demo.core.customer.dao.PrpDuserDao;
import com.sinosoft.demo.core.customer.entity.PrpDcustomer;
import com.sinosoft.demo.core.customer.entity.PrpDuser;
import com.sinosoft.demo.core.customer.entity.PrpDuserKey;
import com.sinosoft.demo.core.customer.service.PrpDuserService;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PrpDuserServiceImpl extends BaseCustomServiceImpl implements PrpDuserService{

    //PrpDuser持久层
    @Autowired
    private PrpDuserDao prpDuserDao;
    //PrpDcustomer持久层
    @Autowired
    private PrpDcustomerDao prpDcustomerDao;

    //数据库操作类
    @PersistenceContext
    private EntityManager entityManager;

    //一、继承JPA自带方法
    @Override
    public PrpDuser findOne(PrpDuserKey prpDuserKey) {
        return  prpDuserDao.findOne(prpDuserKey);
    }


    //二、注解查询方法


    //三、EntityManager查询方法


    //查询行号加对象
    public void queryPrpDuserRownum(){
        String dataSql="select RowNum as LineNum ,p from PrpDuser p";
        Query dataQuery=entityManager.createQuery(dataSql);
//      dataQuery.setMaxResults(10);
        List<Object[]> list=dataQuery.getResultList();

        for (Object[] obj:list){
            System.out.println(obj[0]);
            PrpDuser pc=(PrpDuser) obj[1];
            System.out.println(pc.getUserName());
        }
    }


    /**
     * @description 批插事务验证 多张表同时插入，异常回滚
     * @author 汪强
     * @date 14:27:00  2017-10-20
     * @param
     * @return
     * @throws Exception
     */
    @Override
    @Transactional//默认对RuntimeException回滚 如果不加则只会插入一张表
    //@Transactional(rollbackFor = Exception.class) //rollbackFor = Exception.class对所有异常回滚
    public void insertBatchTranscation() throws Exception{
        //1、定义表一
        PrpDcustomer prpDcustomer = new PrpDcustomer();
        prpDcustomer.setCustomerCode(Long.valueOf("019"));
        prpDcustomer.setCustomerCName("张020");
        prpDcustomer.setCustomerType("01");

        //2、定义表二
        PrpDuser prpDuser = new PrpDuser();
        prpDuser.setUserCode("018");
        prpDuser.setUserName("张三20");

        //3、同时插入多表
        prpDcustomerDao.save(prpDcustomer);

        System.out.println(0/0);//故意抛出异常
        prpDuserDao.save(prpDuser);
    }

}
