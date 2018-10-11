package com.sinosoft.framework.agri.core.excel.annotation;


import org.apache.poi.hssf.util.HSSFColor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel导出项配置
 * @Author: 何伟东
 * @Date: 2017/11/24 11:24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface ExportConfig {

	/**
	 * 表头显示名
	 * @author: 何伟东
	 * @date: 2017/11/24 11:23
	 * @return 表头显示名(如：id字段显示为"编号") 默认为字段名
	 */
	String value() default "field";

	/**
	 * 单元格宽度
	 * @author: 何伟东
	 * @date: 2017/11/24 11:24
	 * @return 单元格宽度 默认100(-1为自动计算列宽)
	 */
	short width() default 100;

	/**
	 * 将单元格值进行转换后再导出：<br/>
	 * 目前支持以下几种场景：<br/>
	 * 1. 固定的数值转换为字符串值（如：1代表男，2代表女）<br/>
	 * <b>表达式:</b> "s:1=男,2=女"<br/>
	 * 2. 数值对应的值需要查询数据库才能进行映射(实现com.sinosoft.agriprpall.core.excelutil.convert.ExportConvert接口)<br/>
	 * <b>表达式:</b> "c:com.sinosoft.agriprpall.core.excelutil.convert.ExportConvert实现类"
	 * @author: 何伟东
	 * @date: 2017/11/24 11:25
	 * @return 默认不启用
	 */
	String convert() default "";
	
	
	/**
	 * 当前单元格的字体颜色
	 * @author: 何伟东
	 * @date: 2017/11/24 11:25
	 * @return 当前单元格的字体颜色 (默认 HSSFColor.BLACK.index)
	 */
	short color() default HSSFColor.BLACK.index;
	

	/**
	 * 将单元格的值替换为当前配置的值：<br/>
	 * 应用场景: <br/>
	 * 密码字段导出为："******"
	 * @author: 何伟东
	 * @date: 2017/11/24 11:25
	 * @return 默认true
	 */
	String replace() default "";

	/**
	 * 设置单元格数据验证（下拉框）
	 * <b>表达式:</b> "c:com.sinosoft.agriprpall.core.excelutil.convert.ExportRange实现类"
	 * @author: 何伟东
	 * @date: 2017/11/24 11:25
	 * @return 默认不启用
	 */
	String range() default  "" ;

	/**
	 * 设置属性在导出Excel中是否启用，默认启用
	 * @author: 何伟东
	 * @date: 2017/11/24 11:25
	 * @return 默认true
	 */
	boolean enabled() default true;
}
