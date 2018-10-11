package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpDcodeRiskDto;
import com.sinosoft.dms.core.dict.dao.PrpDcodeRiskDao;
import com.sinosoft.dms.core.dict.entity.PrpDcodeRisk;
import com.sinosoft.dms.core.dict.service.PrpDcodeRiskService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 特约及附加信息查询service层接口实现类
 * @Author: 王保良
 * @Date: 2017/11/17 10:53
 */
@Service
public class PrpDcodeRiskServiceImpl extends BaseServiceImpl implements PrpDcodeRiskService{
    @Autowired
    private PrpDcodeRiskDao prpDcodeRiskDao;

    /**
     * 根据险种代码查询CodeCode
     * @author 王保良
     * @param riskCode (险种代码)
     * @return List<String> codeCode的集合
     * @time 2017-11-17
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List queryCodeCode(String riskCode) throws Exception{
        if (StringUtils.isEmpty(riskCode)){
            throw new Exception("险种代码不能为空");
        }
        return prpDcodeRiskDao.findCodeCodeByRiskCode(riskCode);
    }
    /**
     * @description:方法功能简述: 根据riskCode 和codeType查询返回结果集
     * @author 安齐崇
     * @date 2017年11月10日下午4:09:34
     * @param riskCode 险种编码
     * @param codeType 代码类型
     * @return codeRiskDtoList
     */
    @Override
	public List<PrpDcodeRiskDto> queryByCodesAndType(String riskCodes, String codeType) {
		if(StringUtils.isEmpty(riskCodes) || StringUtils.isEmpty(codeType)){
			return null;
		}
		String[] codes = riskCodes.split("-");
		Specification<PrpDcodeRisk> specification = null;
		if(codes.length ==  1){
			specification = Specifications.<PrpDcodeRisk>and().eq("riskCode", riskCodes).eq("codeType", codeType).build();
		}else{
			specification = Specifications.<PrpDcodeRisk>and().eq("codeType", codeType).in("riskCode", codes).build();
			
		}
		List<PrpDcodeRisk> codeRiskList = prpDcodeRiskDao.findAll(specification);
		List<PrpDcodeRiskDto> codeRiskDtoList = new ArrayList<PrpDcodeRiskDto>();
		this.convertCollection(codeRiskList, codeRiskDtoList, PrpDcodeRiskDto.class);
		return codeRiskDtoList;
	}
}
