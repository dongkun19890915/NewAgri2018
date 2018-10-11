package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingPolicyListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.InsuredListPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 承保清单操作类ServiceImpl
 *
 * @author 潘峰
 * @date 2017/11/14 上午11:05
 */
@Service
public class InsuredListPersistenceServiceImpl extends BaseServiceImpl implements InsuredListPersistenceService {

    @Autowired
    private PlantingPolicyListDao plantingPolicyListDao;

    @Autowired
    private PlantingpolicylistoriginDao plantingpolicylistoriginDao;

    @Autowired
    private HerdPolicyListDao herdPolicyListDao;

    @Autowired
    private HerdPolicyListOriginDao herdPolicyListOriginDao;

    @Autowired
    private NyxPolicyListDao nyxPolicyListDao;

    @Autowired
    private NyxPolicyListOriginDao nyxPolicyListOriginDao;


    /**
     * 种植险(农险一期)：承保清单持久化接口，需要持久化承保清单最新数据表，以及承保清单原始数据表
     * 如果saveFlag为1的时候为保存，2为更新
     *
     * @param plantingPolicyListDtos 种植险清单 ，savaFlag，保存或者更新
     * @return void
     * @author: 潘峰
     * @date: 2017/11/14 上午10:26
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void savePlantingInsuredList(List<PlantingPolicyListDto> plantingPolicyListDtos, String saveFlag) throws DataVerifyException {
        //1保存
        if (null != plantingPolicyListDtos && plantingPolicyListDtos.size() > 0) {
            //无论更新还是保存都会往这张表写数据
            List<PlantingPolicyList> plantingPolicyLists = new ArrayList<>();
            this.convertCollection(plantingPolicyListDtos, plantingPolicyLists, PlantingPolicyList.class);
            plantingPolicyListDao.save(plantingPolicyLists);
            //只有保存的时候才会向这张表写数据
            if ("1".equals(saveFlag)) {
                List<Plantingpolicylistorigin> plantingpolicylistorigins = new ArrayList<>();
                this.convertCollection(plantingPolicyListDtos, plantingpolicylistorigins, Plantingpolicylistorigin.class);
                plantingpolicylistoriginDao.save(plantingpolicylistorigins);
            }
        } else {
            throw new DataVerifyException("承保清单数据不能为空！");
        }
    }

    /**
     * 养殖险(农险一期)：承保清单持久化接口，需要持久化承保清单最新数据表，以及承保清单原始数据表
     *
     * @param herdPolicyListDtos 养殖险承保清单主表
     * @param saveFlag           1保存，2更新
     * @author: 何伟东
     * @date: 2017/12/5 15:12
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveHerdInsuredList(List<HerdPolicyListDto> herdPolicyListDtos, String saveFlag) throws DataVerifyException {
        if (null != herdPolicyListDtos && herdPolicyListDtos.size() > 0) {
            // 承保清单数据表
            List<HerdPolicyList> herdPolicyLists = new ArrayList<>();
            this.convertCollection(herdPolicyListDtos, herdPolicyLists, HerdPolicyList.class);
            herdPolicyListDao.save(herdPolicyLists);
            // 承保清单原始信息表
            if ("1".equals(saveFlag)) {
                List<HerdPolicyListOrigin> herdPolicyListOrigins = new ArrayList<>();
                this.convertCollection(herdPolicyListDtos, herdPolicyListOrigins, HerdPolicyListOrigin.class);
                herdPolicyListOriginDao.save(herdPolicyListOrigins);
            }
        } else {
            throw new DataVerifyException("承保清单数据不能为空！");
        }
    }

    /**
     * 农业险(农险二期)：承保清单持久化接口，需要持久化承保清单最新数据表，以及承保清单原始数据表
     *
     * @param nyxPolicyListDtos 农业险承保清单主表
     * @param saveFlag          1保存，2更新
     * @author: 何伟东
     * @date: 2017/12/8 15:50
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveNyxInsuredList(List<NyxPolicyListDto> nyxPolicyListDtos, String saveFlag) throws DataVerifyException {
        // 承保清单数据表
        if (null != nyxPolicyListDtos && nyxPolicyListDtos.size() > 0) {
            List<NyxPolicyList> nyxPolicyLists = new ArrayList<>();
            this.convertCollection(nyxPolicyListDtos, nyxPolicyLists, NyxPolicyList.class);
            nyxPolicyListDao.save(nyxPolicyLists);
            // 承保清单原始信息表
            if ("1".equals(saveFlag)) {
                List<NyxPolicyListOrigin> nyxPolicyListOrigins = new ArrayList<>();
                this.convertCollection(nyxPolicyListDtos, nyxPolicyListOrigins, NyxPolicyListOrigin.class);
                nyxPolicyListOriginDao.save(nyxPolicyListOrigins);
            }
        } else {
            throw new DataVerifyException("承保清单数据不能为空！");
        }
    }

}
