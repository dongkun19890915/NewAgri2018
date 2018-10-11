package com.sinosoft.agriclaim.core.endcasemanage.service.impl;

import com.sinosoft.agriclaim.api.endcasemanage.dto.PrpLCaseNoDto;
import com.sinosoft.agriclaim.core.endcasemanage.dao.PrpLCaseNoDao;
import com.sinosoft.agriclaim.core.endcasemanage.entity.PrpLCaseNo;
import com.sinosoft.agriclaim.core.endcasemanage.entity.PrpLCaseNoKey;
import com.sinosoft.agriclaim.core.endcasemanage.service.PrpLCaseNoService;
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
 * @time  2017-11-08 05:42:04.174 
 * @description 赔案号表Core接口实现
 */
@Service
public class PrpLCaseNoServiceImpl extends BaseServiceImpl implements PrpLCaseNoService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCaseNoServiceImpl.class);
    
    @Autowired
    private PrpLCaseNoDao prpLCaseNoDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCaseNoDto prpLCaseNoDto) {
        PrpLCaseNo prpLCaseNo = this.convert(prpLCaseNoDto, PrpLCaseNo.class);
        prpLCaseNoDao.save(prpLCaseNo);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String certiNo,String certiType,String caseNo) {
        PrpLCaseNoKey prpLCaseNoKey = new PrpLCaseNoKey(certiNo,certiType,caseNo);
        prpLCaseNoDao.delete(prpLCaseNoKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCaseNoDto prpLCaseNoDto) {
        PrpLCaseNo prpLCaseNo = this.convert(prpLCaseNoDto, PrpLCaseNo.class);
        prpLCaseNoDao.save(prpLCaseNo);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCaseNoDto queryByPK(String certiNo,String certiType,String caseNo) {
        PrpLCaseNoKey prpLCaseNoKey = new PrpLCaseNoKey(certiNo,certiType,caseNo);
        PrpLCaseNo prpLCaseNo = prpLCaseNoDao.findOne(prpLCaseNoKey);
        return this.convert(prpLCaseNo,PrpLCaseNoDto.class);
    }

    /**
     *@description 按主键查询记录数
     *@author jiaoyunzhen
     *@serialData 2017年12月22日09:53:18}
     *@param
     */
    public int count(String caseNo,String strCaseNo) {
		/*Specification<PrpLCaseNo> build = Specifications.<PrpLCaseNo>or()
				.eq(StringUtils.isNotBlank(caseNo), "caseNo", caseNo)
				.eq("certiType", "1")
				.build();*/

        List<PrpLCaseNo> prpLCaseNoList = prpLCaseNoDao.findByCaseNo(caseNo);

        return prpLCaseNoList.size();
    }
}