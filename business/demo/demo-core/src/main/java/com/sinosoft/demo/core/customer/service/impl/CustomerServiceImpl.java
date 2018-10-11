package com.sinosoft.demo.core.customer.service.impl;

import com.sinosoft.demo.api.customer.dto.PrpDcustomerDto;
import com.sinosoft.demo.api.customer.dto.PrpDcustomerQueryConditionDto;
import com.sinosoft.demo.core.customer.dao.PrpDcustomerDao;
import com.sinosoft.demo.core.customer.dao.specification.CustomerSpecBuilder;
import com.sinosoft.demo.core.customer.entity.PrpDcustomer;
import com.sinosoft.demo.core.customer.entity.PrpDcustomerKey;
import com.sinosoft.demo.core.customer.service.CustomerService;
import com.sinosoft.demo.core.webservice.NewAgriPrpallService;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.*;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:客户信息service实现类
 * @Author:周家伟
 * @Since:2017年9月29日
 */
@Service
@Transactional
public class CustomerServiceImpl extends BaseCustomServiceImpl implements CustomerService {

    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private PrpDcustomerDao prpDcustomerDao;


    @PersistenceContext
    private EntityManager entityManager;

    /**
     * @param offset
     * @param length
     * @return
     * @throws Exception
     * @description 分页查询
     * @author 汪强
     * @date 2017年9月30日
     */
    @Override
    public Page<PrpDcustomerDto> queryCustomerPaging(Integer offset, Integer length) throws Exception {


        //PageRequest pageRequest=new PageRequest(offset,length,null);//int page, int size, Sort sort

        //List<PrpDcustomer> prpDcustomers=prpDcustomerDao.findAll(pageRequest);
//		List<PrpDcustomerDto> prpDcustomers=null;
// 		prpDcustomerDao.findAll(new PageRequest(1,3, Sort.Direction.ASC,"id"));


        Sort sorts = new Sort(new Sort.Order(Sort.Direction.ASC, "id"), new Sort.Order(Sort.Direction.ASC, "customerCname"));
        Page<PrpDcustomer> pages = prpDcustomerDao.findAll(new PageRequest(offset, length, null));


        return null;
    }


    /**
     * @param customerCode 客户代码
     * @return PrpDcustomerDto 客户信息对象
     * @throws Exception
     * @description 依据主键查询客户信息
     * @author 周家伟
     * @date 2017年9月29日
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public PrpDcustomerDto queryCustomerByPK(String customerCode) throws Exception {
        if (StringUtils.isEmpty(customerCode)) {
            throw new Exception("客户编码不能为空！");
        }
        PrpDcustomerKey prpDcustomerKey = new PrpDcustomerKey(Long.valueOf(customerCode));
        PrpDcustomer prpDcustomer = prpDcustomerDao.findOne(prpDcustomerKey);
        return convert(prpDcustomer, PrpDcustomerDto.class);
    }

    /**
     * @param prpDcustomerDto 客户信息查询入参封装对象
     * @return List<PrpDcustomerDto> 客户信息列表
     * @throws Exception
     * @description 依据条件查询客户信息
     * @author 周家伟
     * @date 2017年9月29日
     */
    @Override
    public List<PrpDcustomerDto> queryCustomerByCondition(PrpDcustomerDto prpDcustomerDto) throws Exception {
        //将查询条件封装成Specification对象
        Specification<PrpDcustomer> specification = CustomerSpecBuilder.customerSpecification(prpDcustomerDto);
        //查询数据库
        List<PrpDcustomer> prpDcustomerList = prpDcustomerDao.findAll(specification);
        List<PrpDcustomerDto> prpDcustomerDtoList = new ArrayList<PrpDcustomerDto>();
        for (PrpDcustomer prpDcustomer : prpDcustomerList) {
            //将数据库对应实体类转成dto
            PrpDcustomerDto prpDcustomerDtoTemp = convert(prpDcustomer, PrpDcustomerDto.class);
            prpDcustomerDtoList.add(prpDcustomerDtoTemp);
        }
        return prpDcustomerDtoList;
    }

    /**
     * @return List<PrpDcustomerDto> 客户信息列表
     * @throws Exception
     * @description 查询全部客户信息
     * @author 汪强
     * @date 2017年9月29日
     */
    @Override
    public List<PrpDcustomerDto> queryAll() throws Exception {
        //查询数据表
        List<PrpDcustomer> prpDcustomerList = prpDcustomerDao.findAll();
        //将数据表对象转成dto对象
        List<PrpDcustomerDto> prpDcustomerDtoList = new ArrayList<PrpDcustomerDto>();
        for (PrpDcustomer prpDcustomer : prpDcustomerList) {
            //将数据库对应实体类转成dto
            PrpDcustomerDto prpDcustomerDtoTemp = convert(prpDcustomer, PrpDcustomerDto.class);
            prpDcustomerDtoList.add(prpDcustomerDtoTemp);
        }
        return prpDcustomerDtoList;
    }


    /**
     * @return
     * @throws Exception
     * @description 分页带条件排序查询
     * @author 汪强
     * @date 2017年10月8日
     */
    @Override
    public PageInfo<PrpDcustomerDto> queryPaging(PrpDcustomerQueryConditionDto queryDto) throws Exception {
        PageInfo<PrpDcustomerDto> prpDcustomerDtoPageInfo = new PageInfo<>();
        Pageable page = this.getPageable(queryDto);
        Page<PrpDcustomer> prpDcustomerPage = prpDcustomerDao.findAll(genCondition(queryDto), page);

        PageInfo<PrpDcustomerDto> prpDcustomerDtoPage = convertPage(prpDcustomerPage, PrpDcustomerDto.class);
        return prpDcustomerDtoPage;

//		Sort sort=new Sort(Sort.Direction.DESC,"customerCode");
//		Pageable pageable=new PageRequest(offset,length,sort);
//		Page<PrpDcustomer> prpDcustomerPage = prpDcustomerDao.findAll(new Specification<PrpDcustomer>(){
//			@Override
//			public Predicate toPredicate(Root<PrpDcustomer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//				List<Predicate> list = new ArrayList<Predicate>();
//				list.add(criteriaBuilder.equal(root.get("customerCName").as(String.class),"田健一"));
//				Predicate[] p = new Predicate[list.size()];
//				return criteriaBuilder.and(list.toArray(p));
//			}
//		},pageable);
////		Page<PrpDcustomer> prpDcustomerPage= prpDcustomerDao.findAll(pageable);
//		PageInfo<PrpDcustomerDto> prpDcustomerDtoPage=convertPage(prpDcustomerPage,PrpDcustomerDto.class);
//		return prpDcustomerDtoPage;
    }

    /**
     * @param customerCode
     * @return
     * @throws Exception
     * @description 根据主键物理删除记录
     * @author 汪强
     * @date 2017年9月30日
     */
    @Override
    public boolean removeByPrimaryKey(String customerCode) throws Exception {
        //判断主键是否有值
        if (StringUtils.isEmpty(customerCode)) {
            LOGGER.info("客户编码不允许为空");
            throw new Exception("客户编码不允许为空");
        }

        //customerCode转prpDcustomerKey对象
        PrpDcustomerKey prpDcustomerKey = new PrpDcustomerKey();
        prpDcustomerKey.setCustomerCode(Long.valueOf(customerCode));
        try {
            prpDcustomerDao.delete(prpDcustomerKey);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @param customerCode
     * @return
     * @throws Exception
     * @description 根据主键物理批量删除记录
     * @author 汪强
     * @date 2017年9月30日
     */
    @Override
    public boolean removeByPrimaryKeys(String[] customerCode) throws Exception {
        //将主键数据转成对象集合
        List<PrpDcustomer> prpdcustomers = new ArrayList<PrpDcustomer>();
        for (String s : customerCode) {
            PrpDcustomer prpDcustomer = new PrpDcustomer();
            prpDcustomer.setCustomerCode(Long.valueOf(s));
            prpdcustomers.add(prpDcustomer);
        }

        //批量删除操作
        try {
            prpDcustomerDao.deleteInBatch(prpdcustomers);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void logicRemoveByPrimaryKey(String customerCode) throws Exception {
        //参考updateCustomerName方法
    }

    /**
     * @param prpDcustomerDto
     * @return boolean
     * @throws Exception
     * @description 插入prpDcustomer对象
     * @author 汪强
     * @date 2017年9月30日
     */
    @Override
    public boolean saveCustomer(PrpDcustomerDto prpDcustomerDto) throws Exception {
        //判断主键是否有值
        String customerCode = prpDcustomerDto.getCustomerCode();
        if (StringUtils.isEmpty(customerCode)) {
            LOGGER.info("客户编码不允许为空");
            throw new Exception("客户编码不允许为空");
        }
        //dto对象转数据对象
        PrpDcustomer prpDcustomer = convert(prpDcustomerDto, PrpDcustomer.class);
        try {
            prpDcustomerDao.save(prpDcustomer);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @param prpDcustomerDtos
     * @return
     * @throws Exception
     * @description 批量插入prpDcustomer对象
     * @author 汪强
     * @date 2017年9月30日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveCustomers(List<PrpDcustomerDto> prpDcustomerDtos) throws Exception {
        List<PrpDcustomer> prpDcustomers = new ArrayList<PrpDcustomer>();
        String customerCode;
        //将dto对象转成数据表对象
        for (PrpDcustomerDto prpDcustomerDto : prpDcustomerDtos) {
            customerCode = prpDcustomerDto.getCustomerCode();
            //判断customerCode是否为空
            if (StringUtils.isEmpty(customerCode)) {
                throw new Exception("客户编码不能为空");
            }
            PrpDcustomer prpDcustomer = convert(prpDcustomerDto, PrpDcustomer.class);
            prpDcustomers.add(prpDcustomer);
        }
        prpDcustomerDao.save(prpDcustomers);
        return false;
    }


    /**
     * @param prpDcustomerDto
     * @return String
     * @throws Exception
     * @description 修改customer记录
     * @author 汪强
     * @date 2017年9月30日
     */
    @Override
    public boolean modifyCustomer(PrpDcustomerDto prpDcustomerDto) throws Exception {
        //判断主键是否有值
        String customerCode = prpDcustomerDto.getCustomerCode();
        if (StringUtils.isEmpty(customerCode)) {
            LOGGER.info("客户编码不允许为空");
            throw new Exception("客户编码不允许为空");
        }
        //dto对象转数据对象
        PrpDcustomer prpDcustomer = convert(prpDcustomerDto, PrpDcustomer.class);
        prpDcustomerDao.saveAndFlush(prpDcustomer);
        return true;
    }

    /**
     * @param prpDcustomers
     * @return String
     * @throws Exception
     * @description 批量修改customer记录
     * @author 汪强
     * @date 2017年9月30日
     */
    @Override
    public boolean modifyCustomers(List<PrpDcustomer> prpDcustomers) throws Exception {
        return false;
    }


    /**
     * @param customerCode
     * @return PrpDcustomerDto
     * @throws Exception
     * @description 根据主键查找prpDcustomer对象
     * @author 汪强
     * @date 2017年9月30日
     */
    @Override
    public PrpDcustomerDto getByPrimaryKey(String customerCode) throws Exception {
        //设置主键值
        PrpDcustomerKey prpDcustomerKey = new PrpDcustomerKey();
        prpDcustomerKey.setCustomerCode(Long.valueOf(customerCode));

        PrpDcustomer prpDcustomer = prpDcustomerDao.findOne(prpDcustomerKey);
        //数据对象转dto对象
        PrpDcustomerDto prpDcustomerDto = convert(prpDcustomer, PrpDcustomerDto.class);
        return prpDcustomerDto;
    }


    /**
     * @param customerCName
     * @return List<PrpDcustomer>
     * @throws Exception
     * @description 根据用户名查找 jpql方法
     * @author 汪强
     * @date 2017年9月30日
     */
    public List<PrpDcustomerDto> findCustomerByName(String customerCName) throws Exception {
        List<PrpDcustomer> prpDcustomerList = prpDcustomerDao.findCustomerByName(customerCName);
        List<PrpDcustomerDto> prpDcustomerDtoList = new ArrayList<PrpDcustomerDto>();
        for (PrpDcustomer prpDcustomer : prpDcustomerList) {
            //将数据库对应实体类转成dto
            PrpDcustomerDto prpDcustomerDtoTemp = convert(prpDcustomer, PrpDcustomerDto.class);
            prpDcustomerDtoList.add(prpDcustomerDtoTemp);
        }
        return prpDcustomerDtoList;
    }

    /**
     * @param customerCName
     * @param customerCode
     * @return boolean
     * @throws Exception
     * @description 根据主键修改用户姓名
     * @author 汪强
     * @date 2017年9月30日
     */
    @Override
    public boolean updateCustomerName(String customerCName, String customerCode) throws Exception {
        return prpDcustomerDao.updateCustomerName(customerCName, customerCode) > 0;
    }

    /**
     * @param queryDto
     * @return Specification<PrpDcustomer>
     * @description 根据主键修改用户姓名
     * @author 汪强
     * @date 2017年9月30日
     */
    private Specification<PrpDcustomer> genCondition(PrpDcustomerQueryConditionDto queryDto) {
        return Specifications.<PrpDcustomer>and()
                .like(StringUtils.isNotEmpty(queryDto.getCustomerCName()), "customerCName", queryDto.getCustomerCName() + "%")
//				.eq(StringUtils.isNotEmpty(condition.getCodeType()),"codeType",condition.getCodeType())
                .build();
    }


    //使用entityManage自定查询 JPQL语法查询
    @Override
    public PageInfo<PrpDcustomerDto> queryEntityManageNativeSql(PrpDcustomerQueryConditionDto queryDto) throws Exception {
        if (queryDto.getPageNo() < 1) {
            throw new Exception("页码不能小于1");
        }
        if (queryDto.getPageSize() < 1) {
            throw new Exception("每页数量不能小于1");
        }

        int pageNo = queryDto.getPageNo();
        int pageSize = queryDto.getPageSize();
        //1、定义sql查询语句 与查询条件语句
        StringBuilder dataSql = new StringBuilder("select p from PrpDcustomer p ");
        StringBuilder dataCountSql = new StringBuilder("select count(p) from PrpDcustomer p ");

        String dataCondition;

        //2、定义条件参数集合
        Map<String, Object> paraMap = new HashMap<String, Object>();
        //定义查询条件语句
        List<String> conditionList = new ArrayList<String>();

        //3、判断查询条件是否有值
        if (StringUtils.isNotEmpty(queryDto.getCustomerCName())) {
            //dataCondition.append(" and p.customerCName like :customerCName ");
            conditionList.add(" and p.customerCName like :customerCName ");
            paraMap.put("customerCName", queryDto.getCustomerCName() + "%");
        }
        if (StringUtils.isNotEmpty(queryDto.getCustomerCode())) {
            //dataCondition.append(" and p.customerCode=:customerCode");
            conditionList.add(" and p.customerCode=:customerCode ");
            paraMap.put("customerCode", queryDto.getCustomerCode());
        }

        //如果有拼接条件
        if (conditionList.size() > 0) {
            //自动拼接条件sql语句
            dataCondition = this.joinCondition(conditionList);

            //增加分页查询语句的查询条件
            dataSql.append(" where "); //where 根据实际情况是否需要在这里添加
            dataSql.append(dataCondition);

            //增加统计总页数据语句
            dataCountSql.append(" where "); //where 根据实际情况是否需要在这里添加
            dataCountSql.append(dataCondition);
        }

        //dataSql.append(dataCondition);

        //增加排序语句
        dataSql.append(" order by p.customerCode");

        //统计总页数据语句
        //dataCountSql.append(dataCondition);


        //5、创建查询对象
        Query dataQuery = entityManager.createQuery(dataSql.toString());
        Query dataCountQuery = entityManager.createQuery(dataCountSql.toString());

        //6、设置参数
        this.setQueryParam(dataQuery, pageNo, pageSize, paraMap);
        this.setQueryParam(dataCountQuery, paraMap);

        //7、获得查询结果和总页数
        List<PrpDcustomer> list = dataQuery.getResultList();
        long totalSize = (long) dataCountQuery.getSingleResult();

        //8、将查询结果转换pageinfo格式
        PageInfo<PrpDcustomerDto> pageInfo=this.setPageInfo(list,pageNo,totalSize,PrpDcustomerDto.class);

        return pageInfo;
    }


    /**
     * @param name
     * @return String
     * @throws Exception
     * @description webservice接口调用验证
     * @author 汪强
     * @date 2017年9月30日
     */
    public String testWebService(String name) throws Exception {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(NewAgriPrpallService.class);
//        factory.setUsername("ZWS_ECS");
//        factory.setPassword("abcd1234");
        factory.setAddress("http://192.168.0.175:7001/undwrt/services/NewAgriPrpallService?wsdl");
        NewAgriPrpallService port = (NewAgriPrpallService) factory.create();

        return port.testWebService("sfdds");
    }

    @Override
    public void testSequence() {

        PrpDcustomer prpDcustomer = new PrpDcustomer();
        prpDcustomer.setCustomerType("1");
        //prpDcustomer.setCustomerCode("1111111");
        prpDcustomer.setShorthandCode("1");
        prpDcustomer.setCustomerCName("1231");

        prpDcustomerDao.save(prpDcustomer);
    }

}
