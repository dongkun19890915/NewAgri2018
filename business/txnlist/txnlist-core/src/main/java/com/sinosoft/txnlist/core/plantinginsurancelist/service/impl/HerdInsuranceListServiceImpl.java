package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdInsuranceListDto;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainList;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.HerdInsuranceListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdInsuranceListKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdInsuranceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * @description 投保明细表Core接口实现
 */
@Service
public class HerdInsuranceListServiceImpl extends BaseServiceImpl implements HerdInsuranceListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HerdInsuranceListServiceImpl.class);
    @Autowired
    private HerdInsuranceListDao herdInsuranceListDao;
    @Autowired
    private InsureMainListDao insureMainListDao;
    /**
     * @description:（批量保存）
     * @author: 田健
     * @date: 2017/10/20 11:55
     * @param herdInsuranceListDtoList
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveByList(List<HerdInsuranceListDto> herdInsuranceListDtoList) {
        List<HerdInsuranceList> herdInsuranceLists = new ArrayList<HerdInsuranceList>();
        this.convertCollection(herdInsuranceListDtoList,herdInsuranceLists,HerdInsuranceList.class);
        herdInsuranceListDao.save(herdInsuranceLists);
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
        herdInsuranceListDao.removeByInusreListCode(inusreListCode);
    }
    /**
     * 保存
     * @author: 田健
     * @date: 2018/3/19 12:02
     * @param herdInsuranceListDto 养殖险Dto
     */
    @Override
    public void save(HerdInsuranceListDto herdInsuranceListDto) {
        HerdInsuranceList herdInsuranceList = this.convert(herdInsuranceListDto, HerdInsuranceList.class);
        herdInsuranceListDao.save(herdInsuranceList);
    }
    /**
     *根据主键删除
     * @author: 田健
     * @date: 2018/3/19 14:13
     * @param inusreListCode 清单编号
     * @param earlAbel 耳标号
     * @param fCode 农户代码
     * @param kindCode 险别代码
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String inusreListCode, String earlAbel, String fCode, String kindCode) {
        HerdInsuranceListKey herdInsuranceListKey = new HerdInsuranceListKey(inusreListCode,earlAbel,fCode,kindCode);
        herdInsuranceListDao.delete(herdInsuranceListKey);
    }
    /**
     *修改
     * @author: 田健
     * @date: 2018/3/19 14:14
     * @param herdInsuranceListDto 养殖险Dto
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(HerdInsuranceListDto herdInsuranceListDto) {
        HerdInsuranceList herdInsuranceList = this.convert(herdInsuranceListDto, HerdInsuranceList.class);
        herdInsuranceListDao.save(herdInsuranceList);
    }
    /**
     * 根据主键查询
     * @author: 田健
     * @date: 2018/3/19 14:15
     * @param inusreListCode 清单编号
     * @param earlAbel 耳标号
     * @param fCode 农户代码
     * @param kindCode 险别代码
     * @return 养殖险对象
     */
    @Override
    public HerdInsuranceListDto queryByPK(String inusreListCode, String earlAbel, String fCode, String kindCode) {
        HerdInsuranceListKey herdInsuranceListKey = new HerdInsuranceListKey(inusreListCode,earlAbel,fCode,kindCode);
        HerdInsuranceList herdInsuranceList = herdInsuranceListDao.findOne(herdInsuranceListKey);
        return this.convert(herdInsuranceList,HerdInsuranceListDto.class);
    }
    /**
     * 根据清单号查询HerdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/19 14:39
     * @param inusreListCode 清单编号
     * @return 清单表信息集合
     */
    @Override
    public List<HerdInsuranceListDto> queryByInusreListCode(String inusreListCode) {
        List<HerdInsuranceList> herdInsuranceLists = herdInsuranceListDao.findByInusreListCode(inusreListCode);
        List<HerdInsuranceListDto> herdInsuranceListDtoList = new ArrayList<HerdInsuranceListDto>();
        this.convertCollection(herdInsuranceLists,herdInsuranceListDtoList,HerdInsuranceListDto.class);
        return herdInsuranceListDtoList;
    }
    /**
     * 根据保单号查询HerdInsuranceList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param policyNo 为保单号
     * @return HerdInsuranceListDto集合
     * @throws Exception
     */
    @Override
    public List<HerdInsuranceListDto> queryNyxInsuranceListDtoByPolicyNo(String policyNo){
        List<InsureMainList> insureMainLists = insureMainListDao.findByPolicyNo(policyNo);
        if (insureMainLists.size() > 0) {
            InsureMainList insureMainList = insureMainLists.get(0);
            List<HerdInsuranceList> herdInsuranceLists = herdInsuranceListDao.findByInusreListCode(insureMainList.getInusreListCode());
            List<HerdInsuranceListDto> herdInsuranceListDtoList = new ArrayList<>(herdInsuranceLists.size());
            this.convertCollection(herdInsuranceLists, herdInsuranceListDtoList, HerdInsuranceListDto.class);
            return herdInsuranceListDtoList;
        } else {
            LOGGER.error("此清单号没有信息");
            throw new DataVerifyException("此清单号没有信息");
        }
    }

    /**
     * @author:
     * @date: 2018/5/22 下午 18:18
     */
    @Override
    public long countByInusreListCode(String inusreListCode) {
        return herdInsuranceListDao.countByInusreListCode(inusreListCode);
    }
}