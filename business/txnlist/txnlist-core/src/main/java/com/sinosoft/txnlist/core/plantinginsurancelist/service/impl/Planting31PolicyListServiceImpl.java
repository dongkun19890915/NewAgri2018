package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31PolicyListDto;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainList;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.Planting31PolicyListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31PolicyList;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.Planting31PolicyListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Planting31PolicyListServiceImpl extends BaseServiceImpl implements Planting31PolicyListService{
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Planting31PolicyListService.class);
    @Autowired
    private Planting31PolicyListDao planting31PolicyListDao;
    @Autowired
    private InsureMainListDao insureMainListDao;

    @Override
    public List<Planting31PolicyListDto> findByInusreListCode(String inusreListCode) throws Exception {
        if(StringUtils.isEmpty(inusreListCode)){
            throw new DataVerifyException("inusreListCode为空！");
        }
        List<Planting31PolicyList> planting31PolicyListList=planting31PolicyListDao.queryPlanting31ByInsuereListCode(inusreListCode);
        List<Planting31PolicyListDto> planting31PolicyListDtoList=new ArrayList<>();
        convertCollection(planting31PolicyListList,planting31PolicyListDtoList,Planting31PolicyListDto.class);
        return planting31PolicyListDtoList;
    }
    /**
     * 根据保单号查询Planting31PolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param policyNo 为保单号
     * @return Planting31PolicyListDto集合
     * @throws Exception
     */
    @Override
    public List<Planting31PolicyListDto> queryInsuranceListDtoByPolicyNo(String policyNo){
        List<InsureMainList> insureMainLists = insureMainListDao.findByPolicyNo(policyNo);
        if (insureMainLists.size() > 0) {
            InsureMainList insureMainList = insureMainLists.get(0);
            List<Planting31PolicyList> planting31PolicyLists = planting31PolicyListDao.findByInusreListCode(insureMainList.getInusreListCode());
            List<Planting31PolicyListDto> planting31PolicyListDtoList = new ArrayList<>(planting31PolicyLists.size());
            this.convertCollection(planting31PolicyLists, planting31PolicyListDtoList, Planting31PolicyListDto.class);
            return planting31PolicyListDtoList;
        } else {
            LOGGER.error("此清单号没有信息");
            throw new DataVerifyException("此清单号没有信息");
        }
    }
}
