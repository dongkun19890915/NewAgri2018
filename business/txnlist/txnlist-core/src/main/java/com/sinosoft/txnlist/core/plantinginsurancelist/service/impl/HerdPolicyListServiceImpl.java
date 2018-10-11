package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainList;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.HerdPolicyListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdPolicyList;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdPolicyListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HerdPolicyListServiceImpl extends BaseServiceImpl implements HerdPolicyListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HerdPolicyListService.class);

    @Autowired
    private HerdPolicyListDao herdPolicyListDao;
    @Autowired
    private InsureMainListDao insureMainListDao;

    /**
     * 按照fCardId,inusreListCode查询查询结果集
     *@param fIdCard 农户身份证
     *@param inusreListCode 投保清单编号
     *@return List<HerdPolicyListDto> HerdPolicyList结果集合
     * @author 王心洋
     * @time 2017-11-17
     */
    @Override
    public List<HerdPolicyListDto> queryByfIdCardAndInusreListCode(String fIdCard, String inusreListCode) {
        List<HerdPolicyListDto> herdPolicyListDtoList = new ArrayList<>();
        List<HerdPolicyList> herdPolicyList = herdPolicyListDao.queryByInsureListCodeAndFIdCard(fIdCard,inusreListCode);
        this.convertCollection(herdPolicyList,herdPolicyListDtoList,HerdPolicyListDto.class);
        return herdPolicyListDtoList;
    }
    /**
    *
    * @param insureListCode
    * @return java.util.List<com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto>
    * @throws
    * @author 李冬松
    * @date 10:42 2017/11/22
    */
    @Override
    public List<HerdPolicyListDto> queryByInsureListCode(String insureListCode) throws Exception {
        if(StringUtils.isEmpty(insureListCode)){
            throw new DataVerifyException("insureListCode为空");
        }
        List<HerdPolicyList> herdPolicyListList=herdPolicyListDao.queryHerdByInsureListCode(insureListCode);
        List<HerdPolicyListDto> herdPolicyListDtoList=new ArrayList<>();
        convertCollection(herdPolicyListList,herdPolicyListDtoList,HerdPolicyListDto.class);
        return herdPolicyListDtoList;
    }

    /**
     * 根据保单号码查询承保清单数据
     *
     * @param policyNo 保单号码
     * @return 承保分户清单数据
     * @author: 龚翔
     * @date: 2018/02/26 16:29
     */
    @Override
    public List<HerdPolicyListDto> queryByPolicyNo(String policyNo) throws Exception{
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        List<InsureMainList> insureMainLists = insureMainListDao.findByPolicyNo(policyNo);
        String inusreListCode = insureMainLists.get(0).getInusreListCode();
        List<HerdPolicyList> herdPolicyLists = herdPolicyListDao.queryHerdByInsureListCode(inusreListCode);
        List<HerdPolicyListDto> herdPolicyListDtos = new ArrayList<>();
        this.convertCollection(herdPolicyLists, herdPolicyListDtos, HerdPolicyListDto.class);
        return herdPolicyListDtos;
    }
    /**
     * 根据清单号和农户代查询标的代码
     *
     * @param prarm policyNo-保单号码
     * @return 承保分户清单数据
     * @author: 陈道洋
     * @date: 2018/02/26 15:34
     */
    @Override
    public HerdPolicyListDto queryByInusreListCodeAndFcode(String inusreListCode, String fCode) throws Exception {
        if (StringUtils.isEmpty(inusreListCode)) {
            throw new DataVerifyException("清单号不能为空");
        }
        if (StringUtils.isEmpty(fCode)) {
            throw new DataVerifyException("农户代码不能为空");
        }
        HerdPolicyList herdPolicyList = herdPolicyListDao.queryByInusreListCodeAndFcode(inusreListCode, fCode);
        HerdPolicyListDto herdPolicyListDto = this.convert(herdPolicyList, HerdPolicyListDto.class);
        return herdPolicyListDto;
    }
    /**
     * 根据保单号查询HerdPolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param policyNo 为保单号
     * @return HerdPolicyListDTo集合
     * @throws Exception
     */
    @Override
    public List<HerdPolicyListDto> queryInsuranceListDtoByPolicyNo(String policyNo){
//        List<InsureMainList> insureMainLists = insureMainListDao.findByPolicyNo(policyNo);
//        if (insureMainLists.size() > 0) {
//            InsureMainList insureMainList = insureMainLists.get(0);
//            List<HerdPolicyList> herdPolicyLists = herdPolicyListDao.findByInusreListCode(insureMainList.getInusreListCode());
//            List<HerdPolicyListDto> herdPolicyListDtoList = new ArrayList<>(herdPolicyLists.size());
//            this.convertCollection(herdPolicyLists, herdPolicyListDtoList, HerdPolicyListDto.class);
//            return herdPolicyListDtoList;
//        } else {
//            LOGGER.error("此清单号没有信息");
//            throw new DataVerifyException("此清单号没有信息");
//        }
        String InusreListCode = insureMainListDao.findInusreListCodeByPolicyNo(policyNo);
        if (StringUtils.isNotEmpty(InusreListCode)) {
            List<HerdPolicyList> herdPolicyLists = herdPolicyListDao.queryByInusreListCode(InusreListCode);
            List<HerdPolicyListDto> herdPolicyListDtoList = new ArrayList<>(herdPolicyLists.size());
            this.convertCollection(herdPolicyLists, herdPolicyListDtoList, HerdPolicyListDto.class);
            return herdPolicyListDtoList;
        } else {
            LOGGER.error("此清单号没有信息");
            throw new DataVerifyException("此清单号没有信息");
        }

    }
}
