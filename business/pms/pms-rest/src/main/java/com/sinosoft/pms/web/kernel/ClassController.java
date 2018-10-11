package com.sinosoft.pms.web.kernel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.pms.api.kernel.ClassApi;
import com.sinosoft.pms.api.kernel.dto.ClassQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDclassDto;
import com.sinosoft.pms.core.kernel.service.ClassService;

/**
 * @description 险类接口服务controller 
 * @author HSQ
 * @date 2017年9月5日 上午9:41:54
 */
@RestController
@RequestMapping(value = ClassApi.PATH)
public class ClassController implements ClassApi {
	
	@Autowired
	private ClassService classService;

	/**
	 * @description 新增险类
	 * @param prpDclassDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@Override
	public String saveClass(@RequestBody PrpDclassDto prpDclassDto) throws Exception {
		return classService.saveClass(prpDclassDto);
	}

	/**
	 * @description 删除险类
	 * @param classCode
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:06
	 */
	@Override
	public String removeClass(String classCode) throws Exception {
		return classService.removeClass(classCode);
	}

	/**
	 * @description 修改险类
	 * @param prpDclassDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:22
	 */
	@Override
	public String modifyClass(@RequestBody PrpDclassDto prpDclassDto) throws Exception {
		return classService.modifyClass(prpDclassDto);
	}

	/**
	 * @description 按主键查询险类
	 * @param classCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:40
	 */
	@Override
	public @ResponseBody PrpDclassDto queryClassByPK(String classCode) throws Exception {
		return classService.queryClassByPK(classCode);
	}

	/**
	 * @description 险类转译
	 * @param classCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:35:40
	 */
	@Override
	public String translateCode(String classCode, boolean isChinese) throws Exception {
		return classService.translateCode(classCode, isChinese);
	}

	/**
	 * @description 根据条件查询险类
	 * @param classQueryConditionDto
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:30:59
	 */
	@Override
	public @ResponseBody List<PrpDclassDto> findClassByCondition(@RequestBody ClassQueryConditionDto classQueryConditionDto) {
		return classService.findClassByCondition(classQueryConditionDto);
	}

	/**
	 * @description 查询所有险类
	 * @return List<PrpDclassDto>
	 * @author HSQ
	 * @date 2017年12月13日 上午10:30
	 */
	@Override
	public List<PrpDclassDto> queryAllClass() throws Exception {
		return classService.queryAllClass();
	}

}
