package com.sinosoft.dms.core.paymanage.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.sinosoft.dms.api.paymanage.dto.PrpDbankDto;
import com.sinosoft.dms.core.paymanage.dao.PrpDbankDao;
import com.sinosoft.dms.core.paymanage.entity.PrpDbank;
import com.sinosoft.dms.core.paymanage.entity.PrpDbankKey;
import com.sinosoft.dms.core.paymanage.service.PrpDbankService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-02-13 03:08:45.046 
 * @description 银行定义表Core接口实现
 */
@Service
public class PrpDbankServiceImpl extends BaseServiceImpl implements PrpDbankService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDbankServiceImpl.class);
    
    @Autowired
    private PrpDbankDao prpDbankDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDbankDto prpDbankDto) {
        PrpDbank prpDbank = this.convert(prpDbankDto, PrpDbank.class);
        prpDbankDao.save(prpDbank);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String bankCode) {
        PrpDbankKey prpDbankKey = new PrpDbankKey(bankCode);
        prpDbankDao.delete(prpDbankKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDbankDto prpDbankDto) {
        PrpDbank prpDbank = this.convert(prpDbankDto, PrpDbank.class);
        prpDbankDao.save(prpDbank);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDbankDto queryByPK(String bankCode) {
    	PrpDbankKey prpDbankKey = new PrpDbankKey(bankCode);
        PrpDbank prpDbank = prpDbankDao.findOne(prpDbankKey);
        return this.convert(prpDbank,PrpDbankDto.class);
    }
	@Override
	public List<PrpDbankDto> getBanklist(Map<String, String> map_banklist) {
		List<PrpDbank> prpDbanklist = null;
		List<PrpDbankDto> prpDbankDtolist = null;
		try {
			//String compensateNo = prpLprepayDto.getPreCompensateNo();
			Specification<PrpDbank> build = Specifications.<PrpDbank>and()
					.eq(StringUtils.isNotBlank(map_banklist.get("banklevel")), "banklevel",map_banklist.get("banklevel"))
					.eq(StringUtils.isNotBlank(map_banklist.get("inureflag")), "inureflag",map_banklist.get("inureflag"))
					.eq(StringUtils.isNotBlank(map_banklist.get("agentcode")), "agentcode",map_banklist.get("agentcode"))
					.eq(StringUtils.isNotBlank(map_banklist.get("upperbankcode")), "upperbankcode",map_banklist.get("upperbankcode"))
					.eq(StringUtils.isNotBlank(map_banklist.get("areacode")), "areacode",map_banklist.get("areacode"))
					.eq(StringUtils.isNotBlank(map_banklist.get("bankcode")), "bankcode",map_banklist.get("bankcode"))
					.build();
			
			prpDbanklist = prpDbankDao.findAll(build);
			prpDbankDtolist = new ArrayList<PrpDbankDto>();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.convertCollection(prpDbanklist, prpDbankDtolist, PrpDbankDto.class);
		
		return prpDbankDtolist;
	}
}