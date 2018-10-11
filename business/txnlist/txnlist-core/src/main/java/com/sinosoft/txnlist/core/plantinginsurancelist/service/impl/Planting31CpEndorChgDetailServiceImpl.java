package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31CpEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.Planting31CpEndorChgDetailDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31CpEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31CpEndorChgDetailKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.Planting31CpEndorChgDetailService;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description planting31cpendorchgdetailCore接口实现
 */
@Service
public class Planting31CpEndorChgDetailServiceImpl extends BaseServiceImpl implements Planting31CpEndorChgDetailService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(Planting31CpEndorChgDetailServiceImpl.class);
    
    @Autowired
    private Planting31CpEndorChgDetailDao planting31CpEndorChgDetailDao;

    /**
     *@description 新增
     *@param
     */
    public void save(Planting31CpEndorChgDetailDto planting31CpEndorChgDetailDto) {
        Planting31CpEndorChgDetail planting31CpEndorChgDetail = this.convert(planting31CpEndorChgDetailDto, Planting31CpEndorChgDetail.class);
        planting31CpEndorChgDetailDao.save(planting31CpEndorChgDetail);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String inusreListCode,String kindCode,String itemCode,String fIdCard) {
        Planting31CpEndorChgDetailKey planting31CpEndorChgDetailKey = new Planting31CpEndorChgDetailKey(inusreListCode,kindCode,itemCode,fIdCard);
        planting31CpEndorChgDetailDao.delete(planting31CpEndorChgDetailKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(Planting31CpEndorChgDetailDto planting31CpEndorChgDetailDto) {
        Planting31CpEndorChgDetail planting31CpEndorChgDetail = this.convert(planting31CpEndorChgDetailDto, Planting31CpEndorChgDetail.class);
        planting31CpEndorChgDetailDao.save(planting31CpEndorChgDetail);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public Planting31CpEndorChgDetailDto queryByPK(String inusreListCode,String kindCode,String itemCode,String fIdCard) {
        Planting31CpEndorChgDetailKey planting31CpEndorChgDetailKey = new Planting31CpEndorChgDetailKey(inusreListCode,kindCode,itemCode,fIdCard);
        Planting31CpEndorChgDetail planting31CpEndorChgDetail = planting31CpEndorChgDetailDao.findOne(planting31CpEndorChgDetailKey);
        return this.convert(planting31CpEndorChgDetail,Planting31CpEndorChgDetailDto.class);
    }


    @Transactional
    @Override
    public void removePlanting31CpEndorChgDetail(String inusreListCode)throws  Exception{
        if(StringUtils.isEmpty(inusreListCode)){
            throw new DataVerifyException("投保清单编号不能为空！");
        }

        this.planting31CpEndorChgDetailDao.deletePlanting31CpEndorChgDetail(inusreListCode);
    }

    @Override
    public void savePlanting31CpEndorChgDetail(List<Planting31CpEndorChgDetailDto> planting31CpEndorChgDetailDtoList)throws  Exception{
        if(planting31CpEndorChgDetailDtoList.size()==0){
            throw new DataVerifyException("集合不能为空！");
        }

        List<Planting31CpEndorChgDetail> planting31CpEndorChgDetailList=new ArrayList<Planting31CpEndorChgDetail>();
        this.convertCollection(planting31CpEndorChgDetailDtoList,planting31CpEndorChgDetailList,Planting31CpEndorChgDetail.class);
        this.planting31CpEndorChgDetailDao.save(planting31CpEndorChgDetailList);
    }

    @Override
    public List<Planting31CpEndorChgDetailDto> queryByInsureListCode(String insureListCode) throws Exception {
        if(StringUtils.isEmpty(insureListCode)){
            throw new DataVerifyException("清单号为空！");
        }
        List<Planting31CpEndorChgDetail> planting31CpEndorChgDetailList=planting31CpEndorChgDetailDao.queryAllByInusreListCode(insureListCode);
        List<Planting31CpEndorChgDetailDto> planting31CpEndorChgDetailDtoList=new ArrayList<>();
        convertCollection(planting31CpEndorChgDetailList,planting31CpEndorChgDetailDtoList,Planting31CpEndorChgDetailDto.class);
        return planting31CpEndorChgDetailDtoList;
    }
}