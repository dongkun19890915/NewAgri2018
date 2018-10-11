package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdcEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.HerdcEndorChgDetailDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdcEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdcEndorChgDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HerdcEndorChgDetailServiceImpl extends BaseServiceImpl implements HerdcEndorChgDetailService{
    @Autowired
    private HerdcEndorChgDetailDao herdcEndorChgDetailDao;
    /**
    * 批改保存前删除
    * @param insureListCode 标的清单号
    * @return void
    * @throws
    * @author 李冬松
    * @date 17:54 2018/4/12
    */
    @Override
    public void removeByInsureListCode(String insureListCode) throws Exception {
        if(StringUtils.isEmpty(insureListCode)){
            throw new DataVerifyException("标的清单号为空！");
        }
        herdcEndorChgDetailDao.removeByInusreListCode(insureListCode);
    }

    @Override
    public void save(List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList) throws Exception {
        if(herdcEndorChgDetailDtoList!=null&&herdcEndorChgDetailDtoList.size()!=0){
            List<HerdcEndorChgDetail> herdcEndorChgDetailList=new ArrayList<>();
            convertCollection(herdcEndorChgDetailDtoList,herdcEndorChgDetailList,HerdcEndorChgDetail.class);
            herdcEndorChgDetailDao.save(herdcEndorChgDetailList);
        }
    }

    @Override
    public List<HerdcEndorChgDetailDto> queryByInsureListCode(String insureListCode) throws Exception {
        if(StringUtils.isEmpty(insureListCode)){
            throw new DataVerifyException("清单号为空！");
        }
        List<HerdcEndorChgDetail> herdcEndorChgDetailList=herdcEndorChgDetailDao.queryAllByInusreListCode(insureListCode);
        List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList=new ArrayList<>();
        convertCollection(herdcEndorChgDetailList,herdcEndorChgDetailDtoList,HerdcEndorChgDetailDto.class);
        return herdcEndorChgDetailDtoList;
    }
}
