package com.sinosoft.ims.core.kernel.dao.specification;

import com.sinosoft.framework.core.dao.support.PredicateBuilder;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.ims.core.kernel.entity.PrpDriskConfig;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class PrpDriskConfigSpecBuilder {
	/**方法名map*/
	private static Map<String,String> methodMap = new HashMap<String,String>();
	
	/**可以成为like的字段*/
	private static String[] likeColumn = {"comCode","riskCode","configName","extendValue","flag"};
	
	/**
	 * 线程安全获取静态方法名
	 * @return
	 */
	private static Map<String,String> getMethodMap(){
		if(methodMap == null || methodMap.isEmpty()){
			synchronized (methodMap) {
				methodMap = new HashMap<String,String>();
				Method[] methods = PrpDriskConfig.class.getDeclaredMethods();
				for(String column:likeColumn){
					for(Method m : methods){
						if(("get"+column.toLowerCase()).equals(m.getName().toLowerCase())){
							methodMap.put(column, m.getName());
							break;
						}
					}
				}
			}
			return methodMap;
		}else{
			return methodMap;
		}
	}
	
	/**
	 * 拼接个性查询的查询条件
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public static Specification<PrpDriskConfig> genCondition(PrpDriskConfig condition) throws Exception {
		PredicateBuilder<PrpDriskConfig> predicateBuilder = Specifications.and();
		Map<String,String> mmap = getMethodMap();
		/**拼接可能是like的字段为sql*/
		for(String column:likeColumn){
			Method m = condition.getClass().getMethod(mmap.get(column), null);
			String getValue = String.valueOf(m.invoke(condition, null)==null?"":m.invoke(condition, null));
			if(StringUtils.isNotEmpty(getValue)){
				if(getValue.indexOf("like:") > -1){
					predicateBuilder.like(column, getValue.replaceAll("like:", ""));
				}else{
					predicateBuilder.eq(column, getValue);
				}
			}
		}
		if(StringUtils.isNotEmpty(condition.getConfigCode())){
			predicateBuilder.eq("configCode", condition.getConfigCode());
		}
		
		return predicateBuilder.build();
	}
	
	public static void main(String[] args) {
		System.out.println(StringUtils.isNotEmpty(""));
	}
}
