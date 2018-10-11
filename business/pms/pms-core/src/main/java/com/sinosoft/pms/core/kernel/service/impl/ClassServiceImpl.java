package com.sinosoft.pms.core.kernel.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.pms.core.kernel.dao.PrpDclassDao;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.kernel.dto.ClassQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDclassDto;
import com.sinosoft.pms.core.kernel.dao.specification.ClassSpecBuilder;
import com.sinosoft.pms.core.kernel.entity.PrpDclass;
import com.sinosoft.pms.core.kernel.entity.PrpDclassKey;
import com.sinosoft.pms.core.kernel.service.ClassService;

/**
 * @description 险类接口服务serviceImpl
 * @author HSQ
 * @date 2017年9月4日 上午10:32:01
 */
@Service
public class ClassServiceImpl extends BaseServiceImpl implements ClassService {
	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassServiceImpl.class);

	@Autowired
	private PrpDclassDao prpDclassDao;

	/**
	 * @description 新增险类
	 * @param prpDclassDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@Override
	@Transactional
	@CacheEvict(value = {"translateCodeClass", "queryClassByPK"}, allEntries = true)
	public String saveClass(PrpDclassDto prpDclassDto) throws Exception {
		// 新增控制险类代码必传
		String classCode = prpDclassDto.getClassCode();
		if (StringUtils.isEmpty(classCode)) {
			throw new Exception("险类代码不能为空！");
		}
		PrpDclassDto prpDclassDtoCheck = queryClassByPK(classCode);
		if (null != prpDclassDtoCheck) {
			LOGGER.error("险类代码classCode={}已存在！", classCode);
			throw new Exception("险类代码" + classCode + "已存在！");
		}
		PrpDclass prpDclass = convert(prpDclassDto, PrpDclass.class);
		prpDclassDao.save(prpDclass);
		LOGGER.error("新增险类成功classCode={}", classCode);
		return "success";
	}

	/**
	 * @description 删除险类
	 * @param prpDclassDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@Override
	@Transactional
	@CacheEvict(value = {"translateCodeClass", "queryClassByPK"}, allEntries = true)
	public String removeClass(String classCode) throws Exception {
		if (StringUtils.isEmpty(classCode)) {
			throw new Exception("险类代码不能为空！");
		}
		PrpDclassDto prpDclassDtoCheck = queryClassByPK(classCode);
		if (null == prpDclassDtoCheck) {
			LOGGER.error("险类代码classCode={}不存在！", classCode);
			throw new Exception("险类代码" + classCode + "不存在！");
		}
		PrpDclassKey prpDclassKey = new PrpDclassKey(classCode);
		prpDclassDao.delete(prpDclassKey);
		return "success";
	}

	/**
	 * @description 修改险类
	 * @param prpDclassDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@Override
	@Transactional
	@CacheEvict(value = {"translateCodeClass", "queryClassByPK"}, allEntries = true)
	public String modifyClass(PrpDclassDto prpDclassDto) throws Exception {
		String classCode = prpDclassDto.getClassCode();
		if (StringUtils.isEmpty(classCode)) {
			throw new Exception("险类代码不能为空！");
		}
		PrpDclassDto prpDclassDtoCheck = queryClassByPK(classCode);
		if (null == prpDclassDtoCheck) {
			LOGGER.error("险类代码classCode={}不存在！", classCode);
			throw new Exception("险类代码" + classCode + "不存在！");
		}
		PrpDclass prpDclass = convert(prpDclassDto, PrpDclass.class);
		prpDclassDao.save(prpDclass);
		return "success";
	}

	/**
	 * @description 按主键查询险类
	 * @param prpDclassDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@Override
	@Cacheable(value = "queryClassByPK", key = "#classCode")
	public PrpDclassDto queryClassByPK(String classCode) throws Exception {
		if (StringUtils.isEmpty(classCode)) {
			throw new Exception("险类代码不能为空！");
		}
		PrpDclassKey prpDclassKey = new PrpDclassKey(classCode);
		PrpDclass prpDclass = prpDclassDao.findOne(prpDclassKey);
		return convert(prpDclass, PrpDclassDto.class);
	}

	/**
	 * @description 险类转译
	 * @param classCode
	 * @param isChinese
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年9月4日 上午10:25:43
	 */
	@Override
	@Cacheable(value = "translateCodeClass", key = "#classCode+'_'+#isChinese")
	public String translateCode(String classCode, boolean isChinese) throws Exception {
		if (StringUtils.isEmpty(classCode)) {
			return "";
		}
		PrpDclassDto prpDclassDto = queryClassByPK(classCode);
		if(null == prpDclassDto){
			LOGGER.error("险类代码classCode={}不存在！", classCode);
			throw new Exception("险类代码" + classCode + "不存在！");
		}else{
			if(isChinese){
				return prpDclassDto.getClassName();
			}else{
				if(StringUtils.isNotEmpty(prpDclassDto.getClassEName())){
					return prpDclassDto.getClassEName();
				}else{
					return prpDclassDto.getClassName();
				}
			}
		}
	}
	
	/**
	 * @description 根据条件查询险类
	 * @param classQueryConditionDto
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:30:59
	 */
	@Override
	public List<PrpDclassDto> findClassByCondition(ClassQueryConditionDto classQueryConditionDto) {
		Specification<PrpDclass> classQuerySpecification = ClassSpecBuilder.classQuerySpecification(classQueryConditionDto);
		List<PrpDclass> prpDclassList = prpDclassDao.findAll(classQuerySpecification);
		List<PrpDclassDto> prpDclassDtoList = new ArrayList<PrpDclassDto>(prpDclassList.size());
		convertCollection(prpDclassList, prpDclassDtoList, PrpDclassDto.class);
		return prpDclassDtoList;
	}

	/**
	 * @description 查询所有险类
	 * @return List<PrpDclassDto>
	 * @author HSQ
	 * @date 2017年12月13日 上午10:30
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<PrpDclassDto> queryAllClass() throws Exception {
		List<PrpDclass> prpDclassList=prpDclassDao.findAll();
		List<PrpDclassDto> prpDclassDtoList=new ArrayList<>();
		convertCollection(prpDclassList,prpDclassDtoList,PrpDclassDto.class);
		return prpDclassDtoList;
	}

}