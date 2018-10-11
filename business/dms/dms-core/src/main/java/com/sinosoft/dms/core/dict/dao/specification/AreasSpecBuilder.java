package com.sinosoft.dms.core.dict.dao.specification;

import com.sinosoft.dms.api.dict.dto.AreasParamsDto;
import com.sinosoft.dms.core.dict.entity.Areas;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * @description CustomerSpecBuilder
 * @author HSQ
 * @date 2017年8月28日 下午4:06:33
 */
public class AreasSpecBuilder {

//	/**
//	 * @description 组装idvSpecification TODO 组装条件待定
//	 * @param prpDcustomerIdv
//	 * @return
//	 * @author HSQ
//	 * @date 2017年8月28日 下午4:07:42
//	 */
//    public static Specification<PrpDcustomerIdv> idvSpecification(CustomerReqDto customerReqDto){
//        return Specifications.<PrpDcustomerIdv>and().eq(StringUtils.isNotEmpty(customerReqDto.getIdentifyType()), "identifyType", customerReqDto.getIdentifyType())
//        		.eq(StringUtils.isNotEmpty(customerReqDto.getIdentifyNumber()), "identifyNumber", customerReqDto.getIdentifyNumber())
//                .build();
//    }
//
//    /**
//     * @description 组装unitSpecification TODO 组装条件待定
//     * @param prpDcustomerUnit
//     * @return
//     * @author HSQ
//     * @date 2017年8月28日 下午4:07:46
//     */
//    public static Specification<PrpDcustomerUnit> unitSpecification(CustomerReqDto customerReqDto){
//    	return Specifications.<PrpDcustomerUnit>and().eq(StringUtils.isNotEmpty(customerReqDto.getOrganizeCode()), "organizeCode", customerReqDto.getOrganizeCode())
//    			.build();
//    }

    /**
          * @description 组装areasProvinceSpecification TODO 组装条件待定
          * @param codetype
          * @return
          * @author HSQ
          * @date 2017年8月28日 下午4:07:46
          */
    public static Specification<Areas> areasProvinceSpecification(String codetype){
        String superCode = "0";
        String reMark = "1";
        return Specifications.<Areas>and()
                .eq(StringUtils.isNotEmpty(codetype),"superCode",superCode)
                .eq(StringUtils.isNotEmpty(codetype),"reMark",reMark)
                .build();
    }
    /**
          * @description 组装areasProvinceSpecification TODO 组装条件待定
          * @param areasParamsDto
          * @return
          * @author HSQ
          * @date 2017年8月28日 下午4:07:46
          */
    public static Specification<Areas> areasCitySpecification(AreasParamsDto areasParamsDto){
        return Specifications.<Areas>and()
                .eq(StringUtils.isNotEmpty(areasParamsDto.getFieldExt()),"superCode",areasParamsDto.getFieldExt())
                .eq(true,"reMark","1")
                .build();

    }
    /**
          * @description 组装areasProvinceSpecification TODO 组装条件待定
          * @param areasParamsDto
          * @return
          * @author HSQ
          * @date 2017年8月28日 下午4:07:46
          */
    public static Specification<Areas> areasTownSpecification(AreasParamsDto areasParamsDto){
        return Specifications.<Areas>and()
                .eq(StringUtils.isNotEmpty(areasParamsDto.getFieldExt()),"superCode",areasParamsDto.getFieldExt())
                .eq(true,"reMark","1")
                .build();

    }
    /**
          * @description 组装areasProvinceSpecification TODO 组装条件待定
          * @param areasParamsDto
          * @return
          * @author HSQ
          * @date 2017年8月28日 下午4:07:46
          */
    public static Specification<Areas> areasCountrySpecification(AreasParamsDto areasParamsDto){
        return Specifications.<Areas>and()
                .eq(StringUtils.isNotEmpty(areasParamsDto.getFieldExt()),"superCode",areasParamsDto.getFieldExt())
                .eq(true,"reMark","1")
                .build();

    }
    /**
     * @description 组装areasProvinceSpecification TODO 组装条件待定
     * @param areasParamsDto
     * @return
     * @author HSQ
     * @date 2017年8月28日 下午4:07:46
     */
    public static Specification<Areas> areasVillageSpecification(AreasParamsDto areasParamsDto) {
        return Specifications.<Areas>and()
                .eq(StringUtils.isNotEmpty(areasParamsDto.getFieldExt()),"superCode",areasParamsDto.getFieldExt())
                .eq(true,"reMark","1")
                .build();
    }

    /**
     * @description:（组装areasProvinceSpecification）
     * @author: 董坤
     * @date: 2017/10/14 9:07
     * @param areasParamsDto
     * @return Specification<Areas>
     */
    public static Specification<Areas> areasSpecification(com.sinosoft.dms.api.dict.dto.AreasParamsDto areasParamsDto) {
        if ("AreasProvince".equals(areasParamsDto.getCodeType())) {//省
            return Specifications.<Areas>and()
                    .eq(true, "superCode", "0")
                    .eq(true, "reMark", "1")
                    .build();
        } else if ("AreasCity".equals(areasParamsDto.getCodeType())) {//市区
            return Specifications.<Areas>and()
                    .eq(StringUtils.isNotEmpty(areasParamsDto.getFieldExt()), "superCode", areasParamsDto.getFieldExt())
                    .eq(true, "reMark", "1")
                    .build();
        } else if ("AreasTown".equals(areasParamsDto.getCodeType())) {//区县
            return Specifications.<Areas>and()
                    .eq(StringUtils.isNotEmpty(areasParamsDto.getFieldExt()), "superCode", areasParamsDto.getFieldExt())
                    .eq(true, "reMark", "1")
                    .build();
        } else if ("AreasCountry".equals(areasParamsDto.getCodeType())) {//乡
            return Specifications.<Areas>and()
                    .eq(StringUtils.isNotEmpty(areasParamsDto.getFieldExt()), "superCode", areasParamsDto.getFieldExt())
                    .eq(true, "reMark", "1")
                    .build();
        } else if ("AreasVillage".equals(areasParamsDto.getCodeType())) {//行政村
            return Specifications.<Areas>and()
                    .eq(StringUtils.isNotEmpty(areasParamsDto.getFieldExt()), "superCode", areasParamsDto.getFieldExt())
                    .eq(true, "reMark", "1")
                    .build();
        }
        return null;
    }

}
