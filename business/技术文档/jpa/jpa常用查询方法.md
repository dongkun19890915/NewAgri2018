# 一、JPA接口默认提默的方法
JpaRepository主要方法，接口都已经声名，直接继承使用
```
List<T> findAll();
List<T> findAll(Sort sort);    
List<T> findAll(Iterable<ID> ids);
<S extends T> List<S> save(Iterable<S> entities);
<S extends T> S saveAndFlush(S entity);
void deleteInBatch(Iterable<T> entities);
void deleteAllInBatch();
T getOne(ID id);  
boolean  exists(ID id);
```
# 二、基于命名规则的简单查询
框架在进行方法名解析时，会先把方法名多余的前缀截取掉，比如 find、findBy、read、readBy、get、getBy，然后对剩下部分进行解析。并且如果方法的最后一个参数是 Sort 或者 Pageable 类型，也会提取相关的信息，以便按规则进行排序或者分页查询。
- And --- 等价于 SQL 中的 and 关键字，比如 findByUsernameAndPassword(String user, Striang pwd)；
- Or --- 等价于 SQL 中的 or 关键字，比如 findByUsernameOrAddress(String user, String addr)；
- Between --- 等价于 SQL 中的 between 关键字，比如 findBySalaryBetween(int max, int min)；
- LessThan --- 等价于 SQL 中的 "<"，比如 findBySalaryLessThan(int max)；
- GreaterThan --- 等价于 SQL 中的">"，比如 findBySalaryGreaterThan(int min)；
- IsNull --- 等价于 SQL 中的 "is null"，比如 findByUsernameIsNull()；
- IsNotNull --- 等价于 SQL 中的 "is not null"，比如 findByUsernameIsNotNull()；
- NotNull --- 与 IsNotNull 等价；
- Like --- 等价于 SQL 中的 "like"，比如 findByUsernameLike(String user)；
- NotLike --- 等价于 SQL 中的 "not like"，比如 findByUsernameNotLike(String user)；
- OrderBy --- 等价于 SQL 中的 "order by"，比如 findByUsernameOrderBySalaryAsc(String user)；
- Not --- 等价于 SQL 中的 "！ ="，比如 findByUsernameNot(String user)；
- In --- 等价于 SQL 中的 "in"，比如 findByUsernameIn(Collection<String> userList) ，方法的参数可以是 Collection 类型，也可以是数组或者不定长参数；
- NotIn --- 等价于 SQL 中的 "not in"，比如 findByUsernameNotIn(Collection<String> userList) ，方法的参数可以是 Collection 类型，也可以是数组或者不定长参数；



# 三、基于EntityManager方式的高级查询
样例：
```
public class PrpDuserServiceTest extends TestBase{
    //注入entityManager
    @PersistenceContext
    private EntityManager entityManager;

    public Page<PrpDcustomer> queryJpql() {
        //jpql查询语句，非原生sql   jpql里全部是对象和属性，不是数据库里的表和字段，所以注意命名和大小写
        String dataSql="select p from PrpDcustomer p where p.customerCName like :customerCName";
        Query dataQuery=entityManager.createQuery(dataSql);
        dataQuery.setParameter("customerCName","张%”);
        //分页设置
        dataQuery.setFirstResult(0);
        dataQuery.setMaxResults(10);
        //获取查询结果
        List<PrpDcustomer> list=dataQuery.getResultList();
    }

    //查询行号+对象
    public void queryCount(){
        String dataSql="select RowNum as LineNum ,p from PrpDcustomer p";
        Query dataQuery=entityManager.createQuery(dataSql);
        //dataQuery.setMaxResults(10);
        List<Object[]> list=dataQuery.getResultList();
        for (Object[] obj:list){
            System.out.println(obj[0]);
            PrpDcustomer pc=(PrpDcustomer) obj[1];
            System.out.println(pc.getCustomerCName());
        }
    }
}
```

- 原生sql查询对
```
String dataSql = "select userCode,userName,userName,createdBy,createdTime from PrpDuser";
Query dataQuery = entityManager.createNativeQuery(dataSql,PrpDuser.class);
List<PrpDuser>  list = dataQuery.getResultList();
//PrpDuser 需要加entity、id注解 
```

- 集合参数
```
List<String> stringList = new ArrayList<String>();
stringList.add("001");
stringList.add("002");
stringList.add("003");
stringList.add("004");
String dataSql = "select p from PrpDuser p where p.userCode in (:list)";
Query dataQuery = entityManager.createQuery(dataSql);
dataQuery.setParameter("list", stringList);

List<PrpDuser> list = dataQuery.getResultList();
```

- 执行更新语句
```
Query query = em.createQuery("update Person as p set p.name =?1 where p. personid=?2");
query.setParameter(1, “黎明”);
query.setParameter(2, new Integer(1) );
int result = query.executeUpdate(); //影响的记录数
```
- 插入
```
PrpDuser prpDuser=prpDuserDao.findOne("001");
prpDuser.setUserCode("017");
prpDuser.setUserName("张三017");
entityManager.persist(prpDuser);
```

- 修改
```
PrpDuser prpDuser=new PrpDuser();
prpDuser.setUserCode("017");
prpDuser.setUserName("张三");
entityManager. merge(prpDuser);
```