package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.HerdEndorChgDetailDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdEndorChgDetailKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdEndorChgDetailService;
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
 * @time  2017-11-14 07:07:05.012 
 * @description 养殖险保单清单最新数据表Core接口实现
 */
@Service
public class HerdEndorChgDetailServiceImpl extends BaseServiceImpl implements HerdEndorChgDetailService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(HerdEndorChgDetailServiceImpl.class);
    
    @Autowired
    private HerdEndorChgDetailDao herdEndorChgDetailDao;

    /**
     *@description 新增
     *@param
     */
    public void save(HerdEndorChgDetailDto herdEndorChgDetailDto) {
        HerdEndorChgDetail herdEndorChgDetail = this.convert(herdEndorChgDetailDto, HerdEndorChgDetail.class);
        herdEndorChgDetailDao.save(herdEndorChgDetail);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String inusreListCode,String earLabel,String endorseNo,String kindCode,String fCode) {
        HerdEndorChgDetailKey herdEndorChgDetailKey = new HerdEndorChgDetailKey(inusreListCode,earLabel,endorseNo,kindCode,fCode);
        herdEndorChgDetailDao.delete(herdEndorChgDetailKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(HerdEndorChgDetailDto herdEndorChgDetailDto) {
        HerdEndorChgDetail herdEndorChgDetail = this.convert(herdEndorChgDetailDto, HerdEndorChgDetail.class);
        herdEndorChgDetailDao.save(herdEndorChgDetail);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public HerdEndorChgDetailDto queryByPK(String inusreListCode,String earLabel,String endorseNo,String kindCode,String fCode) {
        HerdEndorChgDetailKey herdEndorChgDetailKey = new HerdEndorChgDetailKey(inusreListCode,earLabel,endorseNo,kindCode,fCode);
        HerdEndorChgDetail herdEndorChgDetail = herdEndorChgDetailDao.findOne(herdEndorChgDetailKey);
        return this.convert(herdEndorChgDetail,HerdEndorChgDetailDto.class);
    }
    /**
     * 按照清单号删除
     *@param inusreListCode 清单号
     *@author 王心洋
     *@time 2017-11-18
     */
    public void removeByInusreListCode(String inusreListCode){
        herdEndorChgDetailDao.removeByInusreListCode(inusreListCode);
    }
    /**
     * 按照清单号删除
     *@param inusreListCode 清单号
     *@author 王心洋
     *@time 2017-11-18
     */
    public int getSumInsured(String inusreListCode){
        return herdEndorChgDetailDao.getSumInsured(inusreListCode);
    }
    /**
    * 批改保存前删除
    * @param endorseNo 批单号
    * @return void
    * @throws
    * @author 李冬松
    * @date 17:10 2018/4/12
    */
    public void removeByEndorseNo(String endorseNo)throws Exception{
        if(StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单号为空！");
        }
        herdEndorChgDetailDao.removeByEndorseNo(endorseNo);
    }

    @Override
    public void saveList(List<HerdEndorChgDetailDto> herdEndorChgDetailDtoList) throws Exception {
        if(herdEndorChgDetailDtoList!=null&&herdEndorChgDetailDtoList.size()>0){
            List<HerdEndorChgDetail> herdEndorChgDetailList=new ArrayList<>();
            convertCollection(herdEndorChgDetailDtoList,herdEndorChgDetailList,HerdEndorChgDetail.class);
            herdEndorChgDetailDao.save(herdEndorChgDetailList);
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
    public Map<String,List<HerdEndorChgDetailDto>> queryByEndorseNoList(List<String> endorseNoList){
        if (endorseNoList.size()==0) {
            throw new DataVerifyException("批单号码集合不能为空！");
        }
        Map<String,List<HerdEndorChgDetailDto>> map = new HashMap<>();
        for(int i=0;i<endorseNoList.size();i++){
            List<HerdEndorChgDetail> herdEndorChgDetailList = herdEndorChgDetailDao.findByEndorseNo(endorseNoList.get(i));
            List<HerdEndorChgDetailDto> herdEndorChgDetailDtoList = new ArrayList<>();
            convertCollection(herdEndorChgDetailList,herdEndorChgDetailDtoList,HerdEndorChgDetailDto.class);
            map.put(endorseNoList.get(i),herdEndorChgDetailDtoList);
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
    public List<HerdEndorChgDetailDto> queryByEndorseNo(String endorseNo) {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        List<HerdEndorChgDetailDto> herdEndorChgDetailDtos = new ArrayList<>();
        List<HerdEndorChgDetail> herdEndorChgDetails = herdEndorChgDetailDao.findByEndorseNo(endorseNo);
        convertCollection(herdEndorChgDetails, herdEndorChgDetailDtos, HerdEndorChgDetailDto.class);
        return herdEndorChgDetailDtos;
    }
}