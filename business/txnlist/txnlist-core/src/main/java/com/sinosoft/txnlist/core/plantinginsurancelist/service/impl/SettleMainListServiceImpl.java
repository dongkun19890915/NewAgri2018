package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RegisterCoderDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.SettleMainListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.SettleMainListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.SettleMainList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.SettleMainListKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.SettleMainListService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description settlemainlistCore接口实现
 */
@Service
public class SettleMainListServiceImpl extends BaseServiceImpl implements SettleMainListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SettleMainListServiceImpl.class);
    
    @Autowired
    private SettleMainListDao settleMainListDao;

    /**
     *@description 新增
     *@param
     */
    public void save(SettleMainListDto settleMainListDto) {
        SettleMainList settleMainList = this.convert(settleMainListDto, SettleMainList.class);
        settleMainListDao.save(settleMainList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String settleListCode) {
        SettleMainListKey settleMainListKey = new SettleMainListKey(settleListCode);
        settleMainListDao.delete(settleMainListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SettleMainListDto settleMainListDto) {
        SettleMainList settleMainList = this.convert(settleMainListDto, SettleMainList.class);
        settleMainListDao.save(settleMainList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SettleMainListDto queryByPK(String settleListCode) {
        SettleMainListKey settleMainListKey = new SettleMainListKey(settleListCode);
        SettleMainList settleMainList = settleMainListDao.findOne(settleMainListKey);
        return this.convert(settleMainList,SettleMainListDto.class);
    }

    @Override
    public List<SettleMainListDto> findByCondition(String policyNo, String valiDity) throws Exception {
        if(StringUtils.isEmpty(policyNo)||StringUtils.isEmpty(valiDity)){
            throw new DataVerifyException("policyNo或valiDity不可为空！");
        }
        List<SettleMainList> settleMainListList=settleMainListDao.queryAllByCondition(policyNo,valiDity);
        List<SettleMainListDto> settleMainListDtoList=new ArrayList<>();
        convertCollection(settleMainListList,settleMainListDtoList,SettleMainListDto.class);
        return settleMainListDtoList;
    }
    /**
     *@description 按主键查询实体
     *@param registerCoder
     *@author 马俊玲
     */
    @Override
    public List<SettleMainListDto> findByRegisterCode(String registerCoder) {
        List<SettleMainListDto> settleMainLisDtotList=null;
        List<SettleMainList> settleMainListList = settleMainListDao.findAll(Specifications.<SettleMainList>and().eq(StringUtils.isEmpty(registerCoder),"registerCoder",registerCoder).build());
        if(null!=settleMainListList&&settleMainListList.size()>0){
            settleMainLisDtotList=new ArrayList<SettleMainListDto>();
            for(SettleMainList settleMainList:settleMainListList){
                settleMainLisDtotList.add(convert(settleMainList,SettleMainListDto.class));
            }
        }
        return settleMainLisDtotList;
    }
    /**
     *@description 按主键查询实体
     *@param registerCoder
     *@author 马俊玲
     */
    @Override
    public List<SettleMainListDto> queryByRegisterCodeAndValidity(RegisterCoderDto registerCoder) {
        List<SettleMainListDto> settleMainLisDtotList=null;
        List<SettleMainList> settleMainListList = settleMainListDao.findAll(Specifications.<SettleMainList>and()
                .eq(StringUtils.isEmpty(registerCoder.getRegisteCode()),"registerCoder",registerCoder.getRegisteCode())
                .eq(StringUtils.isEmpty(registerCoder.getValidity()),"validity",registerCoder.getValidity())
                .build());
        if(null!=settleMainListList&&settleMainListList.size()>0){
            settleMainLisDtotList=new ArrayList<SettleMainListDto>();
            for(SettleMainList settleMainList:settleMainListList){
                settleMainLisDtotList.add(convert(settleMainList,SettleMainListDto.class));
            }
        }
        return settleMainLisDtotList;
    }
}