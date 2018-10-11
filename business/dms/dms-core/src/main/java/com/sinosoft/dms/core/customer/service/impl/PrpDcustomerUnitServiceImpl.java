package com.sinosoft.dms.core.customer.service.impl;

import com.sinosoft.dms.api.customer.dto.PrpDcustomerUnitDto;
import com.sinosoft.dms.core.customer.dao.PrpDcustomerUnitDao;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerUnit;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerUnitKey;
import com.sinosoft.dms.core.customer.service.PrpDcustomerUnitService;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-09 11:34:12.554 
 * @description 集体客户代码表Core接口实现
 */
@Service
public class PrpDcustomerUnitServiceImpl extends BaseCustomServiceImpl implements PrpDcustomerUnitService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDcustomerUnitServiceImpl.class);
    
    @Autowired
    private PrpDcustomerUnitDao prpDcustomerUnitDao;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDcustomerUnitDto prpDcustomerUnitDto) {
        PrpDcustomerUnit prpDcustomerUnit = this.convert(prpDcustomerUnitDto, PrpDcustomerUnit.class);
        prpDcustomerUnitDao.save(prpDcustomerUnit);
    }
    /**
     * 保存集体客户信息
     * @author: 田健
     * @date: 2017/12/28 11:09
     * @param prpDcustomerUnitDtos 集体客户信息集合
     */
    @Override
    public void saveByList(List<PrpDcustomerUnitDto> prpDcustomerUnitDtos) {
        List<PrpDcustomerUnit> prpDcustomerUnits = new ArrayList<PrpDcustomerUnit>();
        this.convertCollection(prpDcustomerUnitDtos,prpDcustomerUnits,PrpDcustomerUnit.class);
        prpDcustomerUnitDao.save(prpDcustomerUnits);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String customercode) {
        PrpDcustomerUnitKey prpDcustomerUnitKey = new PrpDcustomerUnitKey(customercode);
        prpDcustomerUnitDao.delete(prpDcustomerUnitKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDcustomerUnitDto prpDcustomerUnitDto) {
        PrpDcustomerUnit prpDcustomerUnit = this.convert(prpDcustomerUnitDto, PrpDcustomerUnit.class);
        prpDcustomerUnitDao.save(prpDcustomerUnit);
    }
    /**
     *@description 按主键查询实体
     *@paramzs
     */
    public PrpDcustomerUnitDto queryByPK(String customercode) {
        PrpDcustomerUnitKey PrpDcustomerUnit=new PrpDcustomerUnitKey(customercode);
        PrpDcustomerUnit prpDcustomerUnit = prpDcustomerUnitDao.findOne(PrpDcustomerUnit);
        return this.convert(prpDcustomerUnit,PrpDcustomerUnitDto.class);
    }
    /**
     * @param prpDcustomerUnitDto
     * @return String
     * @description:（查询团体客户信息）
     * @author: 赵鹏
     * @date: 2017/10/18 8:57
     */
    public   PageInfo<PrpDcustomerUnitDto> queryAllUnit(PrpDcustomerUnitDto prpDcustomerUnitDto){
        //获取得到的参数
        int pageNo=prpDcustomerUnitDto.getPageNo();
        int pageSize=prpDcustomerUnitDto.getPageSize();

        if (pageNo< 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new DataVerifyException("每页数量不能小于1");
        }
        Map<String,Object> paraMap=new HashMap<String,Object>();
        StringBuilder dataSql = new StringBuilder("SELECT p.* FROM PrpDcustomerUnit p ");
        StringBuilder countSql=new StringBuilder("SELECT COUNT(1) FROM PrpDcustomerUnit p");
        //判断参数是否为空，不为空则追加sql
        List<String> strWhere = new ArrayList<String>();
        //客户代码
        if (com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(prpDcustomerUnitDto.getCustomerCode())) {
            strWhere.add(" AND p.customerCode=:customerCode ");
            paraMap.put("customerCode",prpDcustomerUnitDto.getCustomerCode());
        }
        //客户姓名
        if (com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(prpDcustomerUnitDto.getCustomerCName())) {
            strWhere.add(" AND p.customerCName like :customerCName ");
            paraMap.put("customerCName","%"+prpDcustomerUnitDto.getCustomerCName()+"%");
        }
        //客户类型
        if (null != prpDcustomerUnitDto.getCustomerKind()) {
            strWhere.add(" AND p.customerKind=:customerKind ");
            paraMap.put("customerKind",prpDcustomerUnitDto.getCustomerKind());
        }
        //风险等级
        if (com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(prpDcustomerUnitDto.getRiskLevel())) {
            strWhere.add(" AND p.riskLevel=:riskLevel ");
            paraMap.put("riskLevel",prpDcustomerUnitDto.getRiskLevel());
        }
        //身份证号
        if (com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(prpDcustomerUnitDto.getOrganizeCode())) {
            strWhere.add(" AND p.organizeCode=:organizeCode ");
            paraMap.put("organizeCode", prpDcustomerUnitDto.getOrganizeCode());
        }
        //如果有拼接条件
        if (strWhere.size() > 0) {
            //自动拼接条件sql语句
            String  dataCondition = this.joinCondition(strWhere);

            //增加分页查询语句的查询条件
            dataSql.append(" where "); //where 根据实际情况是否需要在这里添加
            dataSql.append(dataCondition);

            //增加统计总页数据语句
            countSql.append(" where "); //where 根据实际情况是否需要在这里添加
            countSql.append(dataCondition);
        }
        //执行sql
        Query dataQuery= entityManager.createNativeQuery(dataSql.toString(),PrpDcustomerUnit.class);
        Query countQuery = entityManager.createNativeQuery(countSql.toString());
        this.setQueryParam(dataQuery,pageNo,pageSize,paraMap);
        this.setQueryParam(countQuery,paraMap);

        //查询总条数
        Long totalSize = Long.valueOf(countQuery.getSingleResult().toString());
        //查询结果
        List<PrpDcustomerUnit> dataList=dataQuery.getResultList();

        List<PrpDcustomerUnitDto>  dataDtoList=new ArrayList<PrpDcustomerUnitDto>();
        this.convertCollection(dataList,dataDtoList,PrpDcustomerUnitDto.class);
        PageInfo<PrpDcustomerUnitDto> pageInfo=this.setPageInfo(dataDtoList,pageNo,totalSize,PrpDcustomerUnitDto.class);

        return pageInfo;
    }

    @Override
    public List<PrpDcustomerUnitDto> queryByInsureName(String insureName) {
        if (StringUtils.isEmpty(insureName)){
            throw new DataVerifyException("客户名称不能为空");
        }
        List<PrpDcustomerUnit> prpDcustomerUnitList=prpDcustomerUnitDao.findPrpDcustomerUnitByCustomerCName(insureName);
        List<PrpDcustomerUnitDto> prpDcustomerUnitDtoList=new ArrayList<>();
        convertCollection(prpDcustomerUnitList,prpDcustomerUnitDtoList,PrpDcustomerUnitDto.class);
        return prpDcustomerUnitDtoList;
    }
}