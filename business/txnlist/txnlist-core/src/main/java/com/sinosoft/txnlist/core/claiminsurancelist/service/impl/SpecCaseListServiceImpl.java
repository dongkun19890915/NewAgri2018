package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.SpecCaseListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.SpecCaseListDao;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.SpecCaseList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.SpecCaseListKey;
import com.sinosoft.txnlist.core.claiminsurancelist.service.SpecCaseListService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-23 10:16:34.906 
 * @description 特殊赔案清单表Core接口实现
 */
@Service
@Transactional
public class SpecCaseListServiceImpl extends BaseServiceImpl implements SpecCaseListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SpecCaseListServiceImpl.class);
    
    @Autowired
    private SpecCaseListDao specCaseListDao;
    @PersistenceContext
    private EntityManager entityManager;
    /**
     *@description 新增
     *@param
     */
    public void save(SpecCaseListDto specCaseListDto) {
        SpecCaseList specCaseList = this.convert(specCaseListDto, SpecCaseList.class);
        specCaseListDao.save(specCaseList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String serialNo,String preCompensateNo) {
        SpecCaseListKey specCaseListKey = new SpecCaseListKey(serialNo,preCompensateNo);
        specCaseListDao.delete(specCaseListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SpecCaseListDto specCaseListDto) {
        SpecCaseList specCaseList = this.convert(specCaseListDto, SpecCaseList.class);
        specCaseListDao.save(specCaseList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SpecCaseListDto queryByPK(String serialNo,String preCompensateNo) {
        SpecCaseListKey specCaseListKey = new SpecCaseListKey(serialNo,preCompensateNo);
        SpecCaseList specCaseList = specCaseListDao.findOne(specCaseListKey);
        return this.convert(specCaseList,SpecCaseListDto.class);
    }
    /**
     * 分页查询特殊赔案清单
     * @author: 孙朋飞
     * @date: 2018/1/23 19:37
     * @param preCompensateNo 预赔单号
     * @param pageNo 当前页
     * @param pageSize 每页显示条数
     * @return 预赔清单合集
     * @throws Exception
     */
    @Override
    public PageInfo<SpecCaseListDto> querySpecCaseListByPreCompensateNo(String preCompensateNo, String pageNo, String pageSize) throws Exception {
        if(StringUtils.isEmpty(preCompensateNo)){
            throw new DataVerifyException("预赔单号不能为空!");
        }
        Integer pNo;
        if(StringUtils.isNotEmpty(pageNo)&&!(Integer.valueOf(pageNo)==0)){
            pNo= Integer.valueOf(pageNo);
        }else{
            pNo=1;
        }
//        Integer pSize;
//        if(StringUtils.isNotEmpty(pageSize)&&!(Integer.valueOf(pageSize)==0)){
//            pSize = Integer.valueOf(pageSize);
//        }else{
//            pSize=20;
//        }

        StringBuilder dataSql=new StringBuilder("select p from SpecCaseList p where p.preCompensateNo=:preCompensateNo");
        StringBuilder countSql=new StringBuilder("select count(p) from SpecCaseList p where p.preCompensateNo=:preCompensateNo");
        dataSql.append(" order by p.preCompensateNo");
        Query dataQuery = entityManager.createQuery(dataSql.toString());
        Query countQuery = entityManager.createQuery(countSql.toString());
        dataQuery.setParameter("preCompensateNo",preCompensateNo);
        countQuery.setParameter("preCompensateNo",preCompensateNo);
//        dataQuery.setFirstResult((pNo-1)*pSize);
//        dataQuery.setMaxResults(pSize);
        List<SpecCaseList> resultList = dataQuery.getResultList();
        long countNum=Long.valueOf(String.valueOf(countQuery.getSingleResult()));
        List<SpecCaseListDto> specCaseList=new ArrayList<>();
        convertCollection(resultList,specCaseList,SpecCaseListDto.class);
        //封装分页数据
        PageInfo<SpecCaseListDto> pageInfo=new PageInfo<>();
        pageInfo.setContent(specCaseList);
//        pageInfo.setPages(pNo);
        pageInfo.setTotalCount(countNum);
        return pageInfo;
    }
    /**
     * 查询特殊赔案清单
     * @author: 孙朋飞
     * @date: 2018/1/24 8:37
     * @param listNo 清单号
     * @return 特殊赔案清单合集
     * @throws Exception
     */
    @Override
    public List<SpecCaseListDto> querySpecCaseListByNoPage(String listNo) throws Exception {
        if(StringUtils.isEmpty(listNo)){
            throw new DataVerifyException("清单号不能为空!");
        }
        List<SpecCaseList> specCaseList = specCaseListDao.findSpecCaseListByPreCompensateNo(listNo);
        List<SpecCaseListDto> specCaseListDto=new ArrayList<>();
        convertCollection(specCaseList,specCaseListDto,SpecCaseListDto.class);
        return specCaseListDto;
    }
    /**
     * 批量保存特殊赔案清单
     * @author: 孙朋飞
     * @date: 2018/1/24 15:07
     * @param specCaseListDtoList 预赔清单集合
     * @return 成功返回true
     * @throws Exception
     */
    @Override
    public boolean batchSaveSpecCaseList(List<SpecCaseListDto> specCaseListDtoList) throws Exception {
        if(specCaseListDtoList==null||specCaseListDtoList.size()==0){
            throw new DataVerifyException("预赔清单数据不能为空!");
        }
        List<SpecCaseList> specCaseLists=new ArrayList<>();
        convertCollection(specCaseListDtoList,specCaseLists,SpecCaseList.class);
        for (SpecCaseList specCaseList : specCaseLists) {
            entityManager.persist(specCaseList);
        }
        entityManager.flush();
        entityManager.clear();
//        specCaseListDao.save(specCaseLists);
        return true;
    }
    /**
     * 清单号关联预赔单号
     * @author: 孙朋飞
     * @date: 2018/2/11 15:02
     * @param listNo 清单号
     * @param preCompensateNo 预赔单号
     * @return 清单号关联预赔单号成功
     * @throws Exception
     */
    @Override
    public boolean saveSpecCaseListPreCompensateNo(String listNo, String preCompensateNo) throws Exception {
        specCaseListDao.updateSpecCaseListByListNo(listNo,preCompensateNo);
        return true;
    }
}