package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31EndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.Planting31EndorChgDetailDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31EndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31EndorChgDetailKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.Planting31EndorChgDetailService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description planting31endorchgdetailCore接口实现
 */
@Service
public class Planting31EndorChgDetailServiceImpl extends BaseServiceImpl implements Planting31EndorChgDetailService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(Planting31EndorChgDetailServiceImpl.class);
    
    @Autowired
    private Planting31EndorChgDetailDao planting31EndorChgDetailDao;

    /**
     *@description 新增
     *@param
     */
    public void save(Planting31EndorChgDetailDto planting31EndorChgDetailDto) {
        Planting31EndorChgDetail planting31EndorChgDetail = this.convert(planting31EndorChgDetailDto, Planting31EndorChgDetail.class);
        planting31EndorChgDetailDao.save(planting31EndorChgDetail);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String inusreListCode,String endorseNo,String kindCode,String itemCode,String fIdCard) {
        Planting31EndorChgDetailKey planting31EndorChgDetailKey = new Planting31EndorChgDetailKey(inusreListCode,endorseNo,kindCode,itemCode,fIdCard);
        planting31EndorChgDetailDao.delete(planting31EndorChgDetailKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(Planting31EndorChgDetailDto planting31EndorChgDetailDto) {
        Planting31EndorChgDetail planting31EndorChgDetail = this.convert(planting31EndorChgDetailDto, Planting31EndorChgDetail.class);
        planting31EndorChgDetailDao.save(planting31EndorChgDetail);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public Planting31EndorChgDetailDto queryByPK(String inusreListCode,String endorseNo,String kindCode,String itemCode,String fIdCard) {
        Planting31EndorChgDetailKey planting31EndorChgDetailKey = new Planting31EndorChgDetailKey(inusreListCode,endorseNo,kindCode,itemCode,fIdCard);
        Planting31EndorChgDetail planting31EndorChgDetail = planting31EndorChgDetailDao.findOne(planting31EndorChgDetailKey);
        return this.convert(planting31EndorChgDetail,Planting31EndorChgDetailDto.class);
    }

    @Override
    public void removePlanting31EndorChgDetail(String endorseNo)throws Exception{
        if(StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单类型不能为空!");
        }
        planting31EndorChgDetailDao.deletePlanting31EndorChgDetail(endorseNo);
    }

    @Override
    public void savePlanting31EndorChgDetail(List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtoList)throws Exception{
        if(planting31EndorChgDetailDtoList.size()==0){
            return;
        }
        List<Planting31EndorChgDetail> planting31EndorChgDetailList=new ArrayList<Planting31EndorChgDetail>();
        this.convertCollection(planting31EndorChgDetailDtoList,planting31EndorChgDetailList,Planting31EndorChgDetail.class);
        planting31EndorChgDetailDao.save(planting31EndorChgDetailList);
    }
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    @Override
    public Map<String,List<Planting31EndorChgDetailDto>> queryByEndorseNoList(List<String> endorseNoList){
        if (endorseNoList.size()==0) {
            throw new DataVerifyException("批单号码集合不能为空！");
        }
        Map<String,List<Planting31EndorChgDetailDto>> map = new HashMap<>();
        for(int i=0;i<endorseNoList.size();i++){
            List<Planting31EndorChgDetail> planting31EndorChgDetailList = planting31EndorChgDetailDao.findByEndorseNo(endorseNoList.get(i));
            List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtoList = new ArrayList<>();
            convertCollection(planting31EndorChgDetailList,planting31EndorChgDetailDtoList,Planting31EndorChgDetailDto.class);
            map.put(endorseNoList.get(i),planting31EndorChgDetailDtoList);
        }
        return map;
    }

    /**
     * 根据批单号码查询planting31的批改变化量清单
     *
     * @param endorseNo 批单号码
     * @return List<Planting31EndorChgDetailDto>
     * @date: 2018/4/13 17:25
     * @author: 何伟东
     */
    @Override
    public List<Planting31EndorChgDetailDto> queryByEndorseNo(String endorseNo) {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtos = new ArrayList<>();
        List<Planting31EndorChgDetail> planting31EndorChgDetails = planting31EndorChgDetailDao.findByEndorseNo(endorseNo);
        convertCollection(planting31EndorChgDetails, planting31EndorChgDetailDtos, Planting31EndorChgDetailDto.class);
        return planting31EndorChgDetailDtos;
    }
}