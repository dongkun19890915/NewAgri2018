一、数据库事务特性
    1､原子性(Atomicity)。这个整体操作就是一个原子操作，要么其中所有的操作所有都成功，要么所有的都失败。
    2､一致性(Consistency)：一个事务可以封装状态改变。事务必须始终保持系统处于一致的状态，不管在任何给定的时间并发事务有多少。
    3､隔离性(Isolation)：在一个事务正在进行的过程中，对于变更只有在该事务内部才可见。
    4､持久性(Durability)：在事务内执行的变更操作在事务成功提交后仍然生效。

二、JPA事务注解
    @Transactional事务：默认只对 RuntimeException 回滚，而非 Exception 进行回滚如果要对 checked Exceptions 进行回滚，则需要 @Transactional(rollbackFor = Exception.class)
    @Transactional 只能被应用到public方法上, 对于其它非public的方法,如果标记了@Transactional也不会报错,但方法没有事务功能.

    @Transactional
    public void testSysConfig(SysConfigEntity entity) throws Exception {
        //不会回滚
        this.saveSysConfig(entity);
        throw new Exception("sysconfig error");
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void testSysConfig1(SysConfigEntity entity) throws Exception {
        //会回滚
        this.saveSysConfig(entity);
        throw new Exception("sysconfig error");
    }
    
    @Transactional
    public void testSysConfig2(SysConfigEntity entity) throws Exception {
        //会回滚
        this.saveSysConfig(entity);
        throw new RuntimeException("sysconfig error");
    }
    
    @Transactional
    public void testSysConfig3(SysConfigEntity entity) throws Exception {
        //事务仍然会被提交
        this.testSysConfig4(entity);
        throw new Exception("sysconfig error");
    }
二、JPA事务传播特性
    @Transactional(propagation=Propagation.REQUIRED) 注解用作定义一个事务的传播特性。

    org.springframework.transaction.annotation.Propagation
    public enum Propagation {  
        REQUIRED(0),
        SUPPORTS(1),
        MANDATORY(2),
        REQUIRES_NEW(3),
        NOT_SUPPORTED(4),
        NEVER(5),
        NESTED(6);
    }
    REQUIRED ：默认参数。如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
    SUPPORTS ：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
    MANDATORY ：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
    REQUIRES_NEW ：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
    NOT_SUPPORTED ：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
    NEVER ：以非事务方式运行，如果当前存在事务，则抛出异常。
    NESTED ：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于 REQUIRED 。

指定方法：通过使用 propagation 属性设置，例如：
@Transactional(propagation = Propagation.REQUIRED)

三、JPA事务隔离级别
    @Transactional(isolation=Isolation.DEFAULT)
    1､Isolation.DEFAULT:为数据源的默认隔离级别

    2､isolation=Isolation.READ_UNCOMMITTED:未授权读取级别
以操作同一行数据为前提，读事务允许其他读事务和写事务，未提交的写事务禁止其他写事务（但允许其他读事务）。此隔离级别可以防止更新丢失，但不能防止脏读、不可重复读、幻读。此隔离级别可以通过“排他写锁”实现。

    3､iIsolation.READ_COMMITTED:授权读取级别
以操作同一行数据为前提，读事务允许其他读事务和写事务，未提交的写事务禁止其他读事务和写事务。此隔离级别可以防止更新丢失、脏读，但不能防止不可重复读、幻读。此隔离级别可以通过“瞬间共享读锁”和“排他写锁”实现。

    4､iIsolation.REPEATABLE_READ:可重复读取级别
以操作同一行数据为前提，读事务禁止其他写事务（但允许其他读事务），未提交的写事务禁止其他读事务和写事务。此隔离级别可以防止更新丢失、脏读、不可重复读，但不能防止幻读。此隔离级别可以通过“共享读锁”和“排他写锁”实现。

    5､iIsolation.SERIALIZABLE:序列化级别
提供严格的事务隔离。它要求事务序列化执行，事务只能一个接着一个地执行，不能并发执行。此隔离级别可以防止更新丢失、脏读、不可重复读、幻读。如果仅仅通过“行级锁”是无法实现事务序列化的，必须通过其他机制保证新插入的数据不会被刚执行查询操作的事务访问到。

隔离级别越高，越能保证数据的完整性和一致性，但是对并发性能的影响也越大。对于多数应用程序，可以优先考虑把数据库系统的隔离级别设为Read Committed。它能够避免更新丢失、脏读，而且具有较好的并发性能。尽管它会导致不可重复读、幻读这些并发问题，在可能出现这类问题的个别场合，可以由应用程序采用悲观锁或乐观锁来控制。

四、JPA事务超时
    @Transactional(timeout=30) //默认是30秒

五、异常回滚
    @Transactional(rollbackFor=RuntimeException.class)
    1､rollbackFor
        该属性用于设置需要进行回滚的异常类数组，当方法中抛出指定异常数组中的异常时，则进行事务回滚。例如：
        指定单一异常类：@Transactional(rollbackFor=RuntimeException.class)
        指定多个异常类：@Transactional(rollbackFor={RuntimeException.class, Exception.class})
    2､rollbackForClassName
        该属性用于设置需要进行回滚的异常类名称数组，当方法中抛出指定异常名称数组中的异常时，则进行事务回滚。例如：
        指定单一异常类名称：@Transactional(rollbackForClassName="RuntimeException")
        指定多个异常类名称：@Transactional(rollbackForClassName={"RuntimeException","Exception"})
    3､noRollbackFor
        该属性用于设置不需要进行回滚的异常类数组，当方法中抛出指定异常数组中的异常时，不进行事务回滚。例如：
        指定单一异常类：@Transactional(noRollbackFor=RuntimeException.class)
        指定多个异常类：@Transactional(noRollbackFor={RuntimeException.class, Exception.class})
    4､noRollbackForClassName
         该属性用于设置不需要进行回滚的异常类名称数组，当方法中抛出指定异常名称数组中的异常时，不进行事务回滚。例如：
        指定单一异常类名称：@Transactional(noRollbackForClassName="RuntimeException")
        指定多个异常类名称：@Transactional(noRollbackForClassName={"RuntimeException","Exception"})
六、JPA只读事务
    @Transactional(readOnly=true) 
    该属性用于设置当前事务是否为只读事务，设置为true表示只读，false则表示可读写，默认值为false。
    
    readOnly的定义，并不是不能在事务中进行修改等DML操作，它只是一个“暗示”，提示数据库驱动程序和数据库系统，这个事务并不包含更改数据的操作，那么JDBC驱动程序和数据库就有可能根据这种情况对该事务进行一些特定的优化，比方说不安排相应的数据库锁，以减轻事务对数据库的压力，毕竟事务也是要消耗数据库的资源的。

七、多对象插入事务
    PrpDcustomerServiceImpl.java
    @Transactional
    public void save(PrpDcustomer prpDcustomer)throws  Exception {
        PrpDcustomer prpDcustomerResult=prpDcustomerDao.saveAndFlush(prpDcustomer);
        throw new RuntimeException("RuntimeException error”);//故意抛出异常
    }

    PrpDjuserServiceImpl.java
    @Transactional
    public boolean save(PrpDjuser prpDjuser) throws Exception {
        prpDjuserDao.saveAndFlush(prpDjuser);
        return false;
    }
    
    //插入操作，主方法调用
    @Transactional
    public void save() throws Exception{
        PrpDcustomer prpDcustomer=new PrpDcustomer();
        prpDcustomer.setCustomerCode("011");
        prpDcustomer.setCustomerCName("张三");
        prpDcustomer.setCustomerType("01");

        PrpDjuser prpDjuser=new PrpDjuser();
        prpDjuser.setUserCode("003");
        prpDjuser.setUserCName(“李四”);

        //有runtimeException抛出 全部终于，不会出现异常插入
        prpDcustomerService.save(prpDcustomer);
        prpDjuserService.save(prpDjuser);
    }

