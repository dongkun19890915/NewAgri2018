package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;

import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxClaimPayListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.NyxClaimPayListDao;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxClaimPayList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxClaimPayListKey;
import com.sinosoft.txnlist.core.claiminsurancelist.service.NyxClaimPayListService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-02 07:30:32.914
 * @description 理赔支付清单表Core接口实现
 */
@Service
@Transactional
public class NyxClaimPayListServiceImpl extends BaseServiceImpl implements NyxClaimPayListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(NyxClaimPayListServiceImpl.class);

    @Autowired
    private NyxClaimPayListDao nyxClaimPayListDao;
    @Autowired
    private EntityManager entityManager;
    /**
     *@description 新增
     *@param
     */
    public void save(NyxClaimPayListDto nyxClaimPayListDto) {
        NyxClaimPayList nyxClaimPayList = this.convert(nyxClaimPayListDto, NyxClaimPayList.class);
        nyxClaimPayListDao.save(nyxClaimPayList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String listNo,String serialNo) {
        NyxClaimPayListKey nyxClaimPayListKey = new NyxClaimPayListKey(listNo,serialNo);
        nyxClaimPayListDao.delete(nyxClaimPayListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(NyxClaimPayListDto nyxClaimPayListDto) {
        NyxClaimPayList nyxClaimPayList = this.convert(nyxClaimPayListDto, NyxClaimPayList.class);
        nyxClaimPayListDao.save(nyxClaimPayList);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public NyxClaimPayListDto queryByPK(String listNo,String serialNo) {
        NyxClaimPayListKey nyxClaimPayListKey = new NyxClaimPayListKey(listNo,serialNo);
        NyxClaimPayList nyxClaimPayList = nyxClaimPayListDao.findOne(nyxClaimPayListKey);
        return this.convert(nyxClaimPayList,NyxClaimPayListDto.class);
    }
    /**
     * 批量保存支付清单
     * @author: 孙朋飞
     * @date: 2018/1/2 17:18
     * @param nyxClaimPayListDtos 支付清单的excel导入集合
     * @throws Exception
     */
    @Override
    public void batchSaveNyxClaimPayList(List<NyxClaimPayListDto> nyxClaimPayListDtos) throws Exception {
        List<NyxClaimPayList> nyxClaimPayLists=new ArrayList<>();
        this.convertCollection(nyxClaimPayListDtos,nyxClaimPayLists,NyxClaimPayList.class);
        nyxClaimPayListDao.save(nyxClaimPayLists);
    }
    /**
     * 查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/1/3 17:52
     * @param listNo 清单号
     * @return 支付清单的集合
     * @throws Exception
     */
    @Override
    public List<NyxClaimPayListDto> queryNyxClaimPayListByListNo(String listNo) throws Exception {
        if (StringUtils.isEmpty(listNo)) {
            throw new DataVerifyException("清单号不能为空!");
        }
        List<NyxClaimPayList> nyxClaimPayList = nyxClaimPayListDao.findNyxClaimPayListByListNo(listNo);
        List<NyxClaimPayListDto> nyxClaimPayListDtos=new ArrayList<>();
        this.convertCollection(nyxClaimPayList,nyxClaimPayListDtos,NyxClaimPayListDto.class);
        return nyxClaimPayListDtos;
    }
    /**
     * 分页查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/1/3 18:59
     * @param listNo 清单号（必传）
     * @param pageNo 当前页
     * @param pageSize 每页显示条数
     * @return 支付清单的集合
     * @throws Exception
     */
    @Override
    public PageInfo<NyxClaimPayListDto> queryNyxClaimPayListPage(String listNo,String pageNo,String pageSize) throws Exception {
        if (StringUtils.isEmpty(listNo)) {
            throw new DataVerifyException("清单号不能为空!");
        }
        Integer pNo;
        if(StringUtils.isNotEmpty(pageNo)&&!(Integer.valueOf(pageNo)==0)){
            pNo= Integer.valueOf(pageNo);
        }else{
            pNo=1;
        }
        Integer pSize;
        if(StringUtils.isNotEmpty(pageSize)&&!(Integer.valueOf(pageSize)==0)){
            pSize = Integer.valueOf(pageSize);
        }else{
            pSize=20;
        }
        //数据
        StringBuilder dataSql=new StringBuilder("select p from NyxClaimPayList p where p.listNo=:listNo");
        //数量
        StringBuilder countSql=new StringBuilder("select count(1) from NyxClaimPayList p where p.listNo=:listNo");
        dataSql.append(" order by p.listNo");
        Query dataQuery = entityManager.createQuery(dataSql.toString());
        Query countQuery = entityManager.createQuery(countSql.toString());
        dataQuery.setParameter("listNo",listNo);
        countQuery.setParameter("listNo",listNo);
        dataQuery.setFirstResult((pNo-1)*pSize);
        dataQuery.setMaxResults(pSize);
        List<NyxClaimPayList> resultList = dataQuery.getResultList();
        List<NyxClaimPayListDto> nyxClaimPayListDtos=new ArrayList<>();
        convertCollection(resultList,nyxClaimPayListDtos,NyxClaimPayListDto.class);
        Object singleResult = countQuery.getSingleResult();
        long numCount=0L;
        if(singleResult!=null){
            numCount=Long.valueOf(String.valueOf(singleResult));
        }
        //封装分页数据
        PageInfo<NyxClaimPayListDto> pageInfo=new PageInfo<>();
        pageInfo.setContent(nyxClaimPayListDtos);
        pageInfo.setPages(pNo);
        pageInfo.setTotalCount(numCount);
        return pageInfo;
    }

    /**
     * （通过清单号查询所有数据）
     * @author: 王志文
     * @date: 2018/1/2 15:52
     * @param listNo 清单号
     * @return
     */
    @Override
    public List<NyxClaimPayListDto> queryAllNyxClaimPayListDtoByListNo(String listNo) {
        List<NyxClaimPayList> nyxClaimPayListList = nyxClaimPayListDao.queryAllByListNo(listNo);
        List<NyxClaimPayListDto> nyxClaimPayListDtoList = new ArrayList<>();
        if (nyxClaimPayListList.size()>0){
            for (NyxClaimPayList nyxClaimPayList: nyxClaimPayListList) {
                nyxClaimPayListDtoList.add(this.convert(nyxClaimPayList,NyxClaimPayListDto.class));
            }
        }
        return nyxClaimPayListDtoList;
    }
    /**
     * （通过支付单号查询所有数据）
     * @author: 王志文
     * @date: 2018/1/2 15:52
     * @param paymentNo 支付单号
     * @return
     */
    @Override
    public List<NyxClaimPayListDto> queryAllByPaymentNo(String paymentNo) {
        List<NyxClaimPayList> nyxClaimPayListList = nyxClaimPayListDao.queryAllByPaymentNo(paymentNo);
        List<NyxClaimPayListDto> nyxClaimPayListDtoList = new ArrayList<>();
        if (nyxClaimPayListList.size()>0){
            for (NyxClaimPayList nyxClaimPayList: nyxClaimPayListList) {
                nyxClaimPayListDtoList.add(this.convert(nyxClaimPayList,NyxClaimPayListDto.class));
            }
        }
        return nyxClaimPayListDtoList;
    }
    /**
     * 根据理算书号查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/3/29 9:59
     * @param compensateNo 理算书号
     * @return 支付清单号
     * @throws Exception
     */
    @Override
    public Map<String, String> queryNyxClaimPayListByCompensateNo(String compensateNo) throws Exception {
        List<NyxClaimPayList> nyxClaimPayList = nyxClaimPayListDao.findNyxClaimPayListByCompensateNo(compensateNo);
        Map<String,String> returnMap=new HashMap<>();
        if(nyxClaimPayList!=null&&nyxClaimPayList.size()>0){
            returnMap.put("listNo",nyxClaimPayList.get(0).getListNo());
        }
        return returnMap;
    }
    /**
     * 根据理算书号删除支付清单
     * @author: 孙朋飞
     * @date: 2018/3/29 11:34
     * @param compensateNo 理算书号
     * @throws Exception
     */
    @Override
    public void deleteNyxClaimPayListByCompensateNo(String compensateNo) throws Exception {
        nyxClaimPayListDao.deleteNyxClaimPayListByCompensateNo(compensateNo);
    }
}