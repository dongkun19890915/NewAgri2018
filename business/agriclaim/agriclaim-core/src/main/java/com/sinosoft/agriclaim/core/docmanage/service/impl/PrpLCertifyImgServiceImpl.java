package com.sinosoft.agriclaim.core.docmanage.service.impl;

import com.sinosoft.agriclaim.api.docmanage.dto.PrpLCertifyImgDto;
import com.sinosoft.agriclaim.core.docmanage.dao.PrpLCertifyImgDao;
import com.sinosoft.agriclaim.core.docmanage.entity.PrpLCertifyImg;
import com.sinosoft.agriclaim.core.docmanage.entity.PrpLCertifyImgKey;
import com.sinosoft.agriclaim.core.docmanage.service.PrpLCertifyImgService;
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
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * @description 单证及影像表Core接口实现
 */
@Service
public class PrpLCertifyImgServiceImpl extends BaseServiceImpl implements PrpLCertifyImgService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCertifyImgServiceImpl.class);
    
    @Autowired
    private PrpLCertifyImgDao prpLCertifyImgDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCertifyImgDto prpLCertifyImgDto) {
        PrpLCertifyImg prpLCertifyImg = this.convert(prpLCertifyImgDto, PrpLCertifyImg.class);
        prpLCertifyImgDao.save(prpLCertifyImg);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String businessNo,java.lang.Double serialNo,String lossItemCode) {
        PrpLCertifyImgKey prpLCertifyImgKey = new PrpLCertifyImgKey(businessNo,serialNo,lossItemCode);
        prpLCertifyImgDao.delete(prpLCertifyImgKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCertifyImgDto prpLCertifyImgDto) {
        PrpLCertifyImg prpLCertifyImg = this.convert(prpLCertifyImgDto, PrpLCertifyImg.class);
        prpLCertifyImgDao.save(prpLCertifyImg);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCertifyImgDto queryByPK(String businessNo,java.lang.Double serialNo,String lossItemCode) {
        PrpLCertifyImgKey prpLCertifyImgKey = new PrpLCertifyImgKey(businessNo,serialNo,lossItemCode);
        PrpLCertifyImg prpLCertifyImg = prpLCertifyImgDao.findOne(prpLCertifyImgKey);
        return this.convert(prpLCertifyImg,PrpLCertifyImgDto.class);
    }
    @Override
    public List<PrpLCertifyImgDto> queryByConditionAndOrder(String registNo, String validStatus) {
        Specification<PrpLCertifyImg> specification = Specifications.<PrpLCertifyImg>and().eq("businessNo", registNo).eq("validStatus", validStatus).build();
        Sort sort = new Sort("typeCode");
        List<PrpLCertifyImg> certifyImgList = prpLCertifyImgDao.findAll(specification, sort);
        List<PrpLCertifyImgDto> certifyImgDtoList = new ArrayList<PrpLCertifyImgDto>();
        this.convertCollection(certifyImgList, certifyImgDtoList, PrpLCertifyImgDto.class);
        return certifyImgDtoList;
    }
}