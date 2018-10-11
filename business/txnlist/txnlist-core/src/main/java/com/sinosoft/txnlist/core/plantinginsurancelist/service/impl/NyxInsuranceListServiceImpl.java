package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceListDto;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainList;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.NyxInsuranceListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxInsuranceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * *查询投保清单
 *
 * @Author: 田慧
 * @Date: 2017/12/11 16:11
 */
@Service
public class NyxInsuranceListServiceImpl extends BaseCustomServiceImpl implements NyxInsuranceListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NyxInsuranceListServiceImpl.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private NyxInsuranceListDao nyxInsuranceListDao;
    @Autowired
    private InsureMainListDao insureMainListDao;

    /**
     * 批量保存清单表信息
     * @author: 田健
     * @date: 2017/12/20 17:01
     * @param nyxInsuranceListDtos 清单信息集合
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveByList(List<NyxInsuranceListDto> nyxInsuranceListDtos) throws Exception{
        List<NyxInsuranceList> nyxInsuranceLists = new ArrayList<NyxInsuranceList>();
       this.convertCollection(nyxInsuranceListDtos,nyxInsuranceLists,NyxInsuranceList.class);
        nyxInsuranceListDao.save(nyxInsuranceLists);
    }
    /**
     * @description:（根据inusreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:57
     * @param inusreListCode
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeByInusreListcode(String inusreListCode) {
        nyxInsuranceListDao.removeByInusreListCode(inusreListCode);
    }

    /**
     * （根据inreListcode根据查询各项补贴金额与农户自缴份额）
     * @author: 田健
     * @date: 2017/10/20 11:57
     * @param inusreListCode
     * @return nyxInsuranceListDto 返回各项补贴金额
     */
    @Override
    public NyxInsuranceListDto getSumFee(String inusreListCode) {
        NyxInsuranceListDto nyxInsuranceListDto = new NyxInsuranceListDto();
        List<Object[]> list = new ArrayList<Object[]>();
        list = nyxInsuranceListDao.getSumFee(inusreListCode);
        //将查询出的结果放进dto中
        nyxInsuranceListDto.setSumPremium((Double) list.get(0)[0]);
        nyxInsuranceListDto.setfPremium((Double) list.get(0)[1]);
        nyxInsuranceListDto.setCentralPremium((Double) list.get(0)[2]);
        nyxInsuranceListDto.setProvincePremium((Double) list.get(0)[3]);
        nyxInsuranceListDto.setCityPremium((Double) list.get(0)[4]);
        nyxInsuranceListDto.setTownPremium((Double) list.get(0)[5]);
        nyxInsuranceListDto.setOtherPremium((Double) list.get(0)[6]);
        return nyxInsuranceListDto;
    }
    /**
     * 根据条件查询投保清单中农户户次
     * @param inusrelistCode 投保清单编号
     * @return 返回FIdCard的总条数
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/11 19:33
     */
    @Override
    public Map<String,Long> queryFIdCardByInusrelistCode(String inusrelistCode) throws Exception {
        if (StringUtils.isEmpty(inusrelistCode)) {
            throw new DataVerifyException("投保清单编号不能为空!");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        //拼接SQL
        StringBuilder resultSql = new StringBuilder("SELECT COUNT(distinct FIdCard) FROM NyxInsuranceList p " +
                " where p.validity=1 and p.inusrelistCode=:inusrelistCode");
        map.put("inusrelistCode", inusrelistCode);
        Query dataResult = entityManager.createQuery(resultSql.toString());
        this.setQueryParam(dataResult, map);
        Long totalSize = (Long) dataResult.getSingleResult();
        Map<String,Long> map1 = new HashMap<String,Long>();
        map1.put("Message",totalSize);

        return map1;
    }

    /**
     * 根据条件查询投保清单中总户数
     * @author: 田慧
     * @date: 2017/12/11 20:00
     * @param inusreListCode 投保清单编号
     * @return 返回areaNumber总数
     * @throws Exception
     */
    @Override
    public Map<String,Double> queryAreaNumberByInusrelistCode(String inusreListCode) throws Exception{
        if (StringUtils.isEmpty(inusreListCode)) {
            throw new DataVerifyException("投保清单编号不能为空!");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        //拼接SQL
        StringBuilder resultSql = new StringBuilder("SELECT SUM(areaNumber) FROM NyxInsuranceList p" +
                                                   " WHERE p.validity=1 and p.kindCode='001' and p.inusreListCode=:inusreListCode");
        map.put("inusreListCode", inusreListCode);
        Query dataResult = entityManager.createQuery(resultSql.toString());
        this.setQueryParam(dataResult, map);
        Double total = (Double) dataResult.getSingleResult();
        Map<String,Double> map1 = new HashMap<String,Double>();
        map1.put("Message",total);
        return map1;
    }
    /**
     * 根据清单号查询NyxInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/19 14:39
     * @param inusreListCode 清单编号
     * @return 清单表信息集合
     */
    @Override
    public List<NyxInsuranceListDto> queryByInusreListCode(String inusreListCode){
        List<NyxInsuranceList> nyxInsuranceLists = nyxInsuranceListDao.findByInusreListCode(inusreListCode);
        List<NyxInsuranceListDto> nyxInsuranceListDtoList = new ArrayList<>();
        this.convertCollection(nyxInsuranceLists,nyxInsuranceListDtoList,NyxInsuranceListDto.class);
        return nyxInsuranceListDtoList;
    }
    /**
     * 根据保单号查询NyxInsuranceList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param policyNo 为保单号
     * @return NyxInsuranceListDto集合
     * @throws Exception
     */
    @Override
    public List<NyxInsuranceListDto> queryNyxInsuranceListDtoByPolicyNo(String policyNo){
        List<InsureMainList> insureMainLists = insureMainListDao.findByPolicyNo(policyNo);

        if (insureMainLists.size() > 0) {
            InsureMainList insureMainList = insureMainLists.get(0);
            List<NyxInsuranceList> nyxInsuranceListList = nyxInsuranceListDao.findByInusreListCode(insureMainList.getInusreListCode());
            List<NyxInsuranceListDto> nyxInsuranceListDtoList = new ArrayList<>(nyxInsuranceListList.size());
            this.convertCollection(nyxInsuranceListList, nyxInsuranceListDtoList, NyxInsuranceListDto.class);
            return nyxInsuranceListDtoList;
        } else {
            LOGGER.error("此清单号没有信息");
            throw new DataVerifyException("此清单号没有信息");
        }
    }
}
