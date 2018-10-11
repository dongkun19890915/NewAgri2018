package com.sinosoft.pms.core.kernel.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.pms.api.kernel.dto.ClassQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDclassDto;

/**
 * @description 险类接口服务service
 * @author HSQ
 * @date 2017年9月4日 上午9:45:27
 */
public interface ClassService {

	/**
	 * @description 新增险类
	 * @param prpDclassDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
    String saveClass(PrpDclassDto prpDclassDto) throws Exception;

	/**
	 * @description 删除险类
	 * @param classCode
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:06
	 */
    String removeClass(String classCode) throws Exception;

	/**
	 * @description 修改险类
	 * @param prpDclassDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:22
	 */
    String modifyClass(PrpDclassDto prpDclassDto) throws Exception;

	/**
	 * @description 按主键查询险类
	 * @param classCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:40
	 */
    PrpDclassDto queryClassByPK(String classCode) throws Exception;

	/**
	 * @description 险类转译
	 * @param classCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:35:40
	 */
    String translateCode(String classCode, boolean isChinese) throws Exception;
	
	/**
	 * @description 根据条件查询险类
	 * @param classQueryConditionDto
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:30:59
	 */
    List<PrpDclassDto> findClassByCondition(ClassQueryConditionDto classQueryConditionDto);

	/**
	 * @description 查询所有险类
	 * @return List<PrpDclassDto>
	 * @author HSQ
	 * @date 2017年12月13日 上午10:30
	 */
	public List<PrpDclassDto> queryAllClass() throws Exception;

}