package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;

import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestSaveLossRateListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.LossRateListDao;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateListKey;
import com.sinosoft.txnlist.core.claiminsurancelist.service.BreedLossRateListService;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRateListService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.core.claiminsurancelist.service.PlantingLossRateListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 08:50:16.862 
 * @description 理赔清单信息主表Core接口实现
 */
@Service
public class LossRateListServiceImpl extends BaseServiceImpl implements LossRateListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(LossRateListServiceImpl.class);
    
    @Autowired
    private LossRateListDao lossRateListDao;
    @Autowired
    private PlantingLossRateListService plantingLossRateListService;
    @Autowired
    private BreedLossRateListService breedLossRateListService;

    /**
     *@description 新增
     *@param
     */
    public void save(LossRateListDto lossRateListDto) {
        LossRateList lossRateList = this.convert(lossRateListDto, LossRateList.class);
        lossRateListDao.save(lossRateList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String listNo       ) {
        LossRateListKey lossRateListKey = new LossRateListKey(listNo       );
        lossRateListDao.delete(lossRateListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(LossRateListDto lossRateListDto) {
        LossRateList lossRateList = this.convert(lossRateListDto, LossRateList.class);
        lossRateListDao.save(lossRateList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRateListDto queryByPK(String listNo       ) {
        LossRateListKey lossRateListKey = new LossRateListKey(listNo       );
        LossRateList lossRateList = lossRateListDao.findOne(lossRateListKey);
        return this.convert(lossRateList,LossRateListDto.class);
    }
    /**
     * 按保单号、报案号查询实体集合
     * @param policyNo 保单号
     * @param registNo 报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public List<LossRateListDto> queryByConditions(String policyNo, String registNo) {
        List<LossRateList> lossRateList = lossRateListDao.queryByConditions(policyNo, registNo);
        List<LossRateListDto> lossRateListDtoList = new ArrayList<>();
        this.convertCollection(lossRateList,lossRateListDtoList,LossRateListDto.class);
        return lossRateListDtoList;
    }
    /**
     * 关联报案号和清单信息
     * @param listNo 损失率清单号
     * @param registNo 报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public void compareInsurance(String listNo, String registNo) {
        lossRateListDao.compareInsurance(listNo, registNo);
    }
    /**
     * 按条件查询已关联实体集合
     * @param policyNo 保单号
     * @param registNo 报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @Override
    public List<LossRateListDto> queryComparable(String policyNo, String registNo) {
        List<LossRateList> plantingLossRateList = lossRateListDao.queryComparable(policyNo, registNo);
        List<LossRateListDto> lossRateListDtoList = new ArrayList<>();
        this.convertCollection(plantingLossRateList,lossRateListDtoList,LossRateListDto.class);
        return lossRateListDtoList;
    }

    /**
     * 金禾调用定损清单保存接口
     * @param requestSaveLossRateListDto 金禾传入保存大对象
     * @author 王心洋
     * @time 2018-01-03
     */
    @Override
    public void saveLossRateList(RequestSaveLossRateListDto requestSaveLossRateListDto){
        LossRateListDto lossRateListDto = requestSaveLossRateListDto.getLossRateListDto();
        List<PlantingLossRateListDto> plantingLossRateListDtoList = requestSaveLossRateListDto.getPlantingLossRateListDtoList();
        List<BreedLossRateListDto> breedLossRateListDtoList = requestSaveLossRateListDto.getBreedLossRateListDtoList();
        this.save(lossRateListDto);
        if(plantingLossRateListDtoList!=null) {
            for (int i = 0; i < plantingLossRateListDtoList.size(); i++) {
                PlantingLossRateListDto plantingLossRateListDto = plantingLossRateListDtoList.get(i);
                plantingLossRateListService.save(plantingLossRateListDto);
            }
        }else if(breedLossRateListDtoList!=null) {
            for (int i = 0; i < breedLossRateListDtoList.size(); i++) {
                BreedLossRateListDto breedLossRateListDto = breedLossRateListDtoList.get(i);
                breedLossRateListService.save(breedLossRateListDto);
            }
        }
    }
}