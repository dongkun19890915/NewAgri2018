package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainList;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.NyxPolicyListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxPolicyList;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxPolicyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class NyxPolicyListServiceImpl extends BaseServiceImpl implements NyxPolicyListService{
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NyxPolicyListService.class);
    @Autowired
    private NyxPolicyListDao nyxPolicyListDao;
    @Autowired
    private InsureMainListDao insureMainListDao;

    @Override
    public List<NyxPolicyListDto> findByInusreListCode(String inusreListCode) throws Exception {
        if(StringUtils.isEmpty(inusreListCode)){
            throw new DataVerifyException("inusreListCode为空！");
        }
        List<NyxPolicyList> nyxPolicyListList=nyxPolicyListDao.queryNyxByInsureListCode(inusreListCode);
        List<NyxPolicyListDto> nyxPolicyListDtoList=new ArrayList<>();
        convertCollection(nyxPolicyListList,nyxPolicyListDtoList,NyxPolicyListDto.class);
        return nyxPolicyListDtoList;
    }

    /**
     * 根据保单号码查询承保清单数据
     *
     * @param policyNo 保单号码
     * @return 承保分户清单数据
     * @author: 何伟东
     * @date: 2017/12/28 17:29
     */
    @Override
    public List<NyxPolicyListDto> queryByPolicyNo(String policyNo) {
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        List<InsureMainList> insureMainLists = insureMainListDao.findByPolicyNo(policyNo);
        String inusreListCode = "";
        if (insureMainLists.size()>0){
            inusreListCode = insureMainLists.get(0).getInusreListCode();
        }
        List<NyxPolicyList> nyxPolicyLists = nyxPolicyListDao.queryNyxByInsureListCode(inusreListCode);
        List<NyxPolicyListDto> nyxPolicyListDtos = new ArrayList<>();
        this.convertCollection(nyxPolicyLists, nyxPolicyListDtos, NyxPolicyListDto.class);
        return nyxPolicyListDtos;
    }
    /**
     * 根据保单号查询NyxPolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param policyNo 为保单号
     * @return NyxPolicyListDto集合
     * @throws Exception
     */
    @Override
    public List<NyxPolicyListDto> queryInsuranceListDtoByPolicyNo(String policyNo){
        List<InsureMainList> insureMainLists = insureMainListDao.findByPolicyNo(policyNo);
        if (insureMainLists.size() > 0) {
            InsureMainList insureMainList = insureMainLists.get(0);
            List<NyxPolicyList> nyxPolicyLists = nyxPolicyListDao.findByInusreListCode(insureMainList.getInusreListCode());
            List<NyxPolicyListDto> nyxPolicyListDtoList = new ArrayList<>(nyxPolicyLists.size());
            this.convertCollection(nyxPolicyLists, nyxPolicyListDtoList, NyxPolicyListDto.class);
            return nyxPolicyListDtoList;
        } else {
            LOGGER.error("此清单号没有信息");
            throw new DataVerifyException("此清单号没有信息");
        }
    }
}
