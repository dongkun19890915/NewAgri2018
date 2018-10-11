package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxCpEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.NyxCpEndorChgDetailDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxCpEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxCpEndorChgDetailKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxCpEndorChgDetailService;
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
 * @description nyxcpendorchgdetailCore接口实现
 */
@Service
public class NyxCpEndorChgDetailServiceImpl extends BaseServiceImpl implements NyxCpEndorChgDetailService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(NyxCpEndorChgDetailServiceImpl.class);
    
    @Autowired
    private NyxCpEndorChgDetailDao nyxCpEndorChgDetailDao;

    /**
     *@description 新增
     *@param
     */
    public void save(NyxCpEndorChgDetailDto nyxCpEndorChgDetailDto) {
        NyxCpEndorChgDetail nyxCpEndorChgDetail = this.convert(nyxCpEndorChgDetailDto, NyxCpEndorChgDetail.class);
        nyxCpEndorChgDetailDao.save(nyxCpEndorChgDetail);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String inusreListCode)throws Exception {
        nyxCpEndorChgDetailDao.removeByInusreListCode(inusreListCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(NyxCpEndorChgDetailDto nyxCpEndorChgDetailDto) {
        NyxCpEndorChgDetail nyxCpEndorChgDetail = this.convert(nyxCpEndorChgDetailDto, NyxCpEndorChgDetail.class);
        nyxCpEndorChgDetailDao.save(nyxCpEndorChgDetail);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public NyxCpEndorChgDetailDto queryByPK(String inusreListCode,String businessNo,String kindCode,String itemCode) {
        NyxCpEndorChgDetailKey nyxCpEndorChgDetailKey = new NyxCpEndorChgDetailKey(inusreListCode,businessNo,kindCode,itemCode);
        NyxCpEndorChgDetail nyxCpEndorChgDetail = nyxCpEndorChgDetailDao.findOne(nyxCpEndorChgDetailKey);
        return this.convert(nyxCpEndorChgDetail,NyxCpEndorChgDetailDto.class);
    }

    @Override
    public void saveList(List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtoList) throws Exception {
        if(nyxCpEndorChgDetailDtoList!=null&&nyxCpEndorChgDetailDtoList.size()>0){
            List<NyxCpEndorChgDetail> nyxCpEndorChgDetailList=new ArrayList<>();
            convertCollection(nyxCpEndorChgDetailDtoList,nyxCpEndorChgDetailList,NyxCpEndorChgDetail.class);
            nyxCpEndorChgDetailDao.save(nyxCpEndorChgDetailList);
        }
    }

    @Override
    public List<NyxCpEndorChgDetailDto> queryByInsureLitCode(String insureListCode) throws Exception {
        if(StringUtils.isEmpty(insureListCode)){
            throw new DataVerifyException("清单号为空！");
        }
        List<NyxCpEndorChgDetail> nyxCpEndorChgDetailList=nyxCpEndorChgDetailDao.queryAllByInusreListCode(insureListCode);
        List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtoList=new ArrayList<>();
        convertCollection(nyxCpEndorChgDetailList,nyxCpEndorChgDetailDtoList,NyxCpEndorChgDetailDto.class);
        return nyxCpEndorChgDetailDtoList;
    }
}