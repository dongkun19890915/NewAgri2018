package com.sinosoft.ims.core.kernel.dao.specification;

import com.sinosoft.ims.core.kernel.entity.PrpDuser;
import org.springframework.data.jpa.domain.Specification;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.ims.api.kernel.dto.CompanyConditionDto;
import com.sinosoft.ims.core.kernel.entity.PrpDcompany;

/**
 * @description CompanySpecBuilder
 * @author HSQ
 * @date 2017年8月30日 上午11:50:52
 */
public class CompanySpecBuilder {

	/**
	 * @description 组装下级机构specification
	 * @param upperComCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 上午11:50:39
	 */
    public static Specification<PrpDcompany> lowerCompanySpecification(String upperComCode){
        return Specifications.<PrpDcompany>and().eq(StringUtils.isNotEmpty(upperComCode), "upperComCode", upperComCode)
                .build();
    }
    
    /**
     * @description 根据条件组装specifaction
     * @param companyConditionDto
     * @return
     * @author HSQ
     * @date 2017年8月30日 下午2:25:03
     */
    public static Specification<PrpDcompany> conditionSpecification(CompanyConditionDto companyConditionDto){
    	return Specifications.<PrpDcompany>and().eq(StringUtils.isNotEmpty(companyConditionDto.getComCode()), "comCode", companyConditionDto.getComCode())
    			.like(StringUtils.isNotEmpty(companyConditionDto.getComCName()), "comCName", companyConditionDto.getComCName() + "%")
    			.like(StringUtils.isNotEmpty(companyConditionDto.getAddressCName()), "addressCName", companyConditionDto.getAddressCName() + "%")
    			.eq(StringUtils.isNotEmpty(companyConditionDto.getUpperComCode()), "upperComCode", companyConditionDto.getUpperComCode())
    			.eq(StringUtils.isNotEmpty(companyConditionDto.getValidStatus()), "validStatus", companyConditionDto.getValidStatus())
                .build();
    }
	/**
	 * @description UserSpecBuilder
	 * @author 李冬松
	 * @date 2017年10月11日 下午4:06:33
	 */

		public static Specification<PrpDuser> passwordSpecifications(String userCode, String oldPassword){
			return  Specifications.<PrpDuser>and().eq(StringUtils.isNotEmpty(userCode),"userCode",userCode)
					.eq(StringUtils.isNotEmpty(oldPassword),"passWord",oldPassword)
					.build();

		}

}
