package com.sinosoft.dms.core.dict.dao.specification;

import com.sinosoft.dms.core.dict.entity.PrpDcode;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class PrpDCodeSpecBuilder {
	/**
	 * 拼接个性查询的查询条件
	 * @param condition codecodelike(true为codecode模糊查询)
	 * @return
	 * @throws Exception
	 */
	public static Specification<PrpDcode> genCondition(PrpDcode condition, boolean codecodelike) {
		if(!codecodelike){
			return Specifications.<PrpDcode>and()
					.eq(StringUtils.isNotEmpty(condition.getCodeCode()),"codeCode", condition.getCodeCode())
					.eq(StringUtils.isNotEmpty(condition.getCodeType()),"codeType",condition.getCodeType())
					.eq(StringUtils.isNotEmpty(condition.getUpperCode()),"upperCode",condition.getUpperCode())
					.eq(StringUtils.isNotEmpty(condition.getCodeCName()),"codeCName",condition.getCodeCName())
					.eq(true,"validStatus","1")
					.build();
		}else{
			return Specifications.<PrpDcode>and()
					.like(StringUtils.isNotEmpty(condition.getCodeCode()),"codeCode", condition.getCodeCode()+"%")
					.eq(StringUtils.isNotEmpty(condition.getCodeType()),"codeType",condition.getCodeType())
					.eq(StringUtils.isNotEmpty(condition.getUpperCode()),"upperCode",condition.getUpperCode())
					.like(StringUtils.isNotEmpty(condition.getCodeCName()),"codeCName",condition.getCodeCName()+"%")
					.eq(true,"validStatus","1")
					.build();
		}
	}
	/**
	 * @author 田健
	 * @mail tianjian@sinosoft.com.cn
	 * @time  2017-10-11
	 *@description 根据codeType查询prpDCode实体
	 */
	public static Specification<PrpDcode> queryCodeInfoByCodeType(String codeType){
		return Specifications.<PrpDcode>and()
				.eq(StringUtils.isNotEmpty(codeType),"codeType",codeType)
				.eq(true,"validStatus","1")
				.build();
	}

	/**
	 * @description:归属机构查询Specification组装
	 * @author: 王保良
	 * @date: 2017/11/16 17:46
	 * @param codeType 类型 、 fieldExt上级地域代码
	 * @return Specification组装好的对象
	 */
	public static Specification<PrpDcode> queryAreasProvinceInfo(String codeType,String fieldExt){
		if ("BusinessProvince".equals(codeType)) {//省
			return Specifications.<PrpDcode>and()
					.eq(true, "codeType", "BusinessZone")
					.eq(true,"flag","1")
					.build();
		} else if ("BusinessTown".equals(codeType)) {//区县
			return Specifications.<PrpDcode>and()
					.eq(true,"codeType","BusinessZone")
					.eq(true,"flag","2")
					.eq(StringUtils.isNotEmpty(fieldExt), "newCodeCode", fieldExt)
					.build();
		} else if ("BusinessCountry".equals(codeType)) {//乡
			return Specifications.<PrpDcode>and()
					.eq(true,"codeType","BusinessZone")
					.eq(true,"flag","3")
					.eq(StringUtils.isNotEmpty(fieldExt), "newCodeCode", fieldExt)
					.build();
		}
		return null;
	}

}
