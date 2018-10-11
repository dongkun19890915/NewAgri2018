package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.NyxEndorChgDetailDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxEndorChgDetailKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxEndorChgDetailService;
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
 * @description nyxendorchgdetailCore接口实现
 */
@Service
public class NyxEndorChgDetailServiceImpl extends BaseServiceImpl implements NyxEndorChgDetailService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(NyxEndorChgDetailServiceImpl.class);
    
    @Autowired
    private NyxEndorChgDetailDao nyxEndorChgDetailDao;

    /**
     *@description 新增
     *@param
     */
    public void save(NyxEndorChgDetailDto nyxEndorChgDetailDto) {
        NyxEndorChgDetail nyxEndorChgDetail = this.convert(nyxEndorChgDetailDto, NyxEndorChgDetail.class);
        nyxEndorChgDetailDao.save(nyxEndorChgDetail);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String inusreListCode,String businessNo,String endorseNo,String kindCode,String itemCode) {
        NyxEndorChgDetailKey nyxEndorChgDetailKey = new NyxEndorChgDetailKey(inusreListCode,businessNo,endorseNo,kindCode,itemCode);
        nyxEndorChgDetailDao.delete(nyxEndorChgDetailKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(NyxEndorChgDetailDto nyxEndorChgDetailDto) {
        NyxEndorChgDetail nyxEndorChgDetail = this.convert(nyxEndorChgDetailDto, NyxEndorChgDetail.class);
        nyxEndorChgDetailDao.save(nyxEndorChgDetail);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public NyxEndorChgDetailDto queryByPK(String inusreListCode,String businessNo,String endorseNo,String kindCode,String itemCode) {
        NyxEndorChgDetailKey nyxEndorChgDetailKey = new NyxEndorChgDetailKey(inusreListCode,businessNo,endorseNo,kindCode,itemCode);
        NyxEndorChgDetail nyxEndorChgDetail = nyxEndorChgDetailDao.findOne(nyxEndorChgDetailKey);
        return this.convert(nyxEndorChgDetail,NyxEndorChgDetailDto.class);
    }

    @Override
    public void removeByEnodrseNo(String endorseNo) throws Exception {
        if(StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单号为空！");
        }
        nyxEndorChgDetailDao.removeByEnodrseNo(endorseNo);
    }

    @Override
    public void saveList(List<NyxEndorChgDetailDto> nyxEndorChgDetailDtoList) throws Exception {
        if(nyxEndorChgDetailDtoList!=null&&nyxEndorChgDetailDtoList.size()>0){
            List<NyxEndorChgDetail> nyxEndorChgDetailList=new ArrayList<>();
            convertCollection(nyxEndorChgDetailDtoList,nyxEndorChgDetailList,NyxEndorChgDetail.class);
            nyxEndorChgDetailDao.save(nyxEndorChgDetailList);
        }
    }
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    @Override
    public Map<String,List<NyxEndorChgDetailDto>> queryByEndorseNoList(List<String> endorseNoList){
        if (endorseNoList.size()==0) {
            throw new DataVerifyException("批单号码集合不能为空！");
        }
        Map<String,List<NyxEndorChgDetailDto>> map = new HashMap<>();
        for(int i=0;i<endorseNoList.size();i++){
            List<NyxEndorChgDetail> nyxEndorChgDetails = nyxEndorChgDetailDao.findByEndorseNo(endorseNoList.get(i));
            List<NyxEndorChgDetailDto> nyxEndorChgDetailDtos = new ArrayList<>();
            convertCollection(nyxEndorChgDetails,nyxEndorChgDetailDtos,NyxEndorChgDetailDto.class);
            map.put(endorseNoList.get(i),nyxEndorChgDetailDtos);
        }
        return map;
    }

    /**
     * 根据批单号码集合查询herd的批改变化量清单
     *
     * @param endorseNo 批单号码
     * @return List<HerdEndorChgDetailDto>
     * @date: 2018/4/13 17:59
     * @author: 何伟东
     */
    @Override
    public List<NyxEndorChgDetailDto> queryByEndorseNo(String endorseNo) {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        List<NyxEndorChgDetailDto> nyxEndorChgDetailDtos = new ArrayList<>();
        List<NyxEndorChgDetail> nyxEndorChgDetails = nyxEndorChgDetailDao.findByEndorseNo(endorseNo);
        convertCollection(nyxEndorChgDetails, nyxEndorChgDetailDtos, NyxEndorChgDetailDto.class);
        return nyxEndorChgDetailDtos;
    }
}