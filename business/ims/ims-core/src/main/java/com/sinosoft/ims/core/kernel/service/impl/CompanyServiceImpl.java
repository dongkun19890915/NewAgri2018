package com.sinosoft.ims.core.kernel.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.sinosoft.ims.api.kernel.dto.CompanyConditionDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.core.kernel.dao.PrpDcompanyDao;
import com.sinosoft.ims.core.kernel.dao.specification.CompanySpecBuilder;
import com.sinosoft.ims.core.kernel.entity.PrpDcompany;
import com.sinosoft.ims.core.kernel.entity.PrpDcompanyKey;
import com.sinosoft.ims.core.kernel.service.CompanyService;

/**
 * @description 机构服务接口实现
 * @author HSQ
 * @date 2017年8月30日 上午10:41:26
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl implements CompanyService {

	/**
	 * log日志
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Autowired
	private PrpDcompanyDao prpDcompanyDao;

	/**
	 * @description 新增机构 （机构从其他库导入，暂时不用）
	 * @param prpDcompanyDto
	 * @return
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月30日 上午10:46:56
	 */
	@Override
	@Transactional
	public String saveCompany(PrpDcompanyDto prpDcompanyDto) throws Exception {
//		if (StringUtils.isNotEmpty(prpDcompanyDto.getComCode())) {
//			throw new Exception("机构代码必须为空！");
//		}
//		// TODO 机构从其他库导入，暂不生成机构代码
//		PrpDcompany prpDcompany = convert(prpDcompanyDto, PrpDcompany.class);
//		prpDcompanyDao.save(prpDcompany);
//		LOGGER.error("新增机构comCode={}成功！", prpDcompanyDto.getComCode());
		return "success";
	}

	/**
	 * @description 删除机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月30日 上午10:48:23
	 */
	@Override
	@Transactional
	@CacheEvict(value = {"queryCompanyByComCode", "getAllLowerCompany", "translateCodeCompany"}, allEntries = true)
	public String removeCompany(String comCode) throws Exception {
		if (StringUtils.isEmpty(comCode)) {
			throw new Exception("机构代码不能为空！");
		}
		PrpDcompanyDto prpDcompanyDto = queryCompanyByComCode(comCode);
		if (null == prpDcompanyDto) {
			LOGGER.error("机构comCode={}不存在！", comCode);
			throw new Exception("机构" + comCode + "不存在！");
		}
		PrpDcompanyKey prpDcompanyKey = new PrpDcompanyKey(comCode);
		prpDcompanyDao.delete(prpDcompanyKey);
		LOGGER.error("删除机构comCode={}成功！", comCode);
		return "success";
	}

	/**
	 * @description 修改机构
	 * @param prpDcompanyDto
	 * @return
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月30日 上午10:48:34
	 */
	@Override
	@Transactional
	@CacheEvict(value = {"queryCompanyByComCode", "getAllLowerCompany", "translateCodeCompany"}, allEntries = true)
	public String modifyCompany(PrpDcompanyDto prpDcompanyDto) throws Exception {
		if (StringUtils.isEmpty(prpDcompanyDto.getComCode())) {
			throw new Exception("机构代码不能为空！");
		}
		PrpDcompanyDto prpDcompanyDto2 = queryCompanyByComCode(prpDcompanyDto.getComCode());
		if(null == prpDcompanyDto2){
			LOGGER.error("机构comCode={}不存在！", prpDcompanyDto.getComCode());
			throw new Exception("机构" + prpDcompanyDto.getComCode() + "不存在！");
		}
		PrpDcompany prpDcompany = this.convert(prpDcompanyDto, PrpDcompany.class);
		prpDcompanyDao.save(prpDcompany);
		LOGGER.error("修改机构comCode={}成功！", prpDcompanyDto.getComCode());
		return "success";
	}

	/**
	 * @description 根据机构代码获取机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 上午10:48:46
	 */
	@Override
	@Cacheable(value = "queryCompanyByComCode", key = "#comCode")
	public PrpDcompanyDto queryCompanyByComCode(String comCode) {
		if (StringUtils.isEmpty(comCode)) {
			return null;
		}
		PrpDcompanyKey prpDcompanyKey = new PrpDcompanyKey(comCode);
		PrpDcompany prpDcompany = prpDcompanyDao.findOne(prpDcompanyKey);
		return this.convert(prpDcompany, PrpDcompanyDto.class);
	}

	/**
	 * @description 获取直接上级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月30日 上午10:49:16
	 */
	@Override
	public PrpDcompanyDto getUpperCompany(String comCode) throws Exception {
		if (StringUtils.isEmpty(comCode)) {
			return null;
		}
		PrpDcompanyDto prpDcompanyDto = queryCompanyByComCode(comCode);
		if (null == prpDcompanyDto) {
			LOGGER.error("机构comCode={}不存在！", comCode);
			throw new Exception("机构" + comCode + "不存在！");
		}
		if (comCode.equals(prpDcompanyDto.getUpperComCode())) {// 总公司上级机构返回本身
			return prpDcompanyDto;
		}
		String upperComCode = prpDcompanyDto.getUpperComCode();
		return queryCompanyByComCode(upperComCode);
	}

	/**
	 * @description 获取所有上级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月30日 上午10:49:29
	 */
	@Override
	public List<PrpDcompanyDto> getAllUpperCompany(String comCode) throws Exception {
		if (StringUtils.isEmpty(comCode)) {
			return null;
		}
		List<PrpDcompanyDto> list = new ArrayList<PrpDcompanyDto>();
		while (true) {
			PrpDcompanyDto prpDcompanyDto = queryCompanyByComCode(comCode);
			if (null != prpDcompanyDto) {
				list.add(prpDcompanyDto);
				if (comCode.equals(prpDcompanyDto.getUpperComCode())) {
					break;
				}
				comCode = prpDcompanyDto.getUpperComCode();
			} else {
				LOGGER.error("机构comCode={}不存在！", comCode);
				throw new Exception("机构" + comCode + "不存在！");
			}
		}
		return list;
	}

	/**
	 * @description 获取直接下级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 上午10:49:41
	 */
	@Override
	public List<PrpDcompanyDto> getLowerCompany(String comCode) {
		if (StringUtils.isEmpty(comCode)) {
			return null;
		}
		Specification<PrpDcompany> specification = CompanySpecBuilder.lowerCompanySpecification(comCode);
		List<PrpDcompany> list = prpDcompanyDao.findAll(specification);
		List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<PrpDcompanyDto>(list.size());
		convertCollection(list, prpDcompanyDtoList, PrpDcompanyDto.class);
		return prpDcompanyDtoList;
	}

	/**
	 * @description 获取所有下级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 上午10:49:50
	 */
	@Override
	//@Cacheable(value = "getAllLowerCompany", key = "#comCode")
	public List<PrpDcompanyDto> getAllLowerCompany(String comCode) {
		if (StringUtils.isEmpty(comCode)) {
			return null;
		}
		List<PrpDcompanyDto> returnList = new ArrayList<>();
		List<PrpDcompany> list = prpDcompanyDao.getAllLowerCompany(comCode);
		convertCollection(list, returnList, PrpDcompanyDto.class);
		return returnList;
	}

	/**
	 * @description 机构转译
	 * @param comCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月30日 上午10:50:01
	 */
	@Override
	@Cacheable(value = "translateCodeCompany", key = "#comCode+'_'+#isChinese")
	public String translateCode(String comCode, boolean isChinese) throws Exception {
		if (StringUtils.isEmpty(comCode)) {
			return "";
		}
		PrpDcompanyDto prpDcompanyDto = queryCompanyByComCode(comCode);
		if(null == prpDcompanyDto){
			LOGGER.error("机构comCode={}不存在！", comCode);
			throw new Exception("机构" + comCode + "不存在！");
		}else{
			if(isChinese){
				return prpDcompanyDto.getComCName();
			}else{
				if(StringUtils.isNotEmpty(prpDcompanyDto.getComCName())){
					return prpDcompanyDto.getComCName();
				}else{
					return prpDcompanyDto.getComCName();
				}
			}
		}
	}

	/**
	 * @description 根据条件查询机构
	 * @param companyConditionDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月30日 上午10:50:12
	 */
	@Override
	public List<PrpDcompanyDto> findCompanyByCondition(CompanyConditionDto companyConditionDto) throws Exception {
		// 考虑到如果没有传查询参数会查询所有，故在此做限制，后续开发可调整此处限制
//		if(StringUtils.isEmpty(companyConditionDto.getComCode()) 
//				&& StringUtils.isEmpty(companyConditionDto.getComCName()) || StringUtils.isEmpty(companyConditionDto.getAddressCName())){
//			throw new Exception("机构名称/机构地址不能同时为空！");
//		}
		Specification<PrpDcompany> specification = CompanySpecBuilder.conditionSpecification(companyConditionDto);
		List<PrpDcompany> list = prpDcompanyDao.findAll(specification);
		List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<PrpDcompanyDto>(list.size());
		convertCollection(list, prpDcompanyDtoList, PrpDcompanyDto.class);
		return prpDcompanyDtoList;
	}

	/**
	 * @description 根据comcode查询机构
	 * @param companyConditionDto
	 * @return prpDcompanyDto
	 * @throws Exception
	 * @author hrx
	 * @date 2017年9月13日
	 */
	public List<PrpDcompanyDto> queryCompanyByCondition(CompanyConditionDto companyConditionDto) throws Exception {
		String comCode = companyConditionDto.getComCode();
		String upperComCode = companyConditionDto.getUpperComCode();
		String comLevel = companyConditionDto.getComLevel();

		List<PrpDcompany> list = prpDcompanyDao.queryCompanyByCondition(comCode, upperComCode, comLevel);
		List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<PrpDcompanyDto>(list.size());
		convertCollection(list, prpDcompanyDtoList, PrpDcompanyDto.class);

		return prpDcompanyDtoList;
	}
	
	/**
	 * @description 是否是总公司
	 * @param comCode 机构代码
	 * @return 是则返回true，否则返回false
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月13日 上午11:28:50
	 */
	@Override
	public boolean isTopCompany(String comCode){
        PrpDcompanyDto prpDcompanyDto = this.queryCompanyByComCode(comCode);
        if (prpDcompanyDto != null && prpDcompanyDto.getUpperComCode().equals(prpDcompanyDto.getComCode())) {
            return true;
        }
        return false;
	}

	/**
	 * @description 是否是同级机构(含本身)
     * @param comCode 机构代码
     * @param comparComCode 被比较的机构代码
     * @return 是则返回true，否则返回false
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月14日 下午1:41:25
	 */
	@Override
	public boolean isSameLevelCompany(String comCode, String comparComCode) {
        PrpDcompanyDto prpDcompanyDto = this.queryCompanyByComCode(comCode);
        PrpDcompanyDto prpDcompanyCompareDto = this.queryCompanyByComCode(comparComCode);
        if (prpDcompanyDto != null && prpDcompanyCompareDto != null) {
            if ((prpDcompanyDto.getComLevel()).equals(prpDcompanyCompareDto.getComLevel())) {
                return true;
            }
        }
        return false;
	}

	/**
	 * @description 是否是下级机构(含本身)
	 * @param comCode 机构代码
     * @param upperComCode 上级机构代码
     * @return 是则返回true，否则返回false
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月14日 下午1:41:25
	 */
	@Override
	public boolean isSubCompany(String comCode, String upperComCode) {
        PrpDcompanyDto prpDcompanyDto = this.queryCompanyByComCode(comCode);
        if (prpDcompanyDto != null) {
            if (comCode.equals(upperComCode)) {
                return true;
            }
            if (prpDcompanyDto.getUpperComCode().equals(upperComCode)) {
                return true;
            }
            // 到了最顶级时还没有匹配则表示不是其支公司
            if (prpDcompanyDto.getUpperComCode().equals(prpDcompanyDto.getComCode())) {
                return false;
            }
            return isSubCompany(prpDcompanyDto.getUpperComCode(), upperComCode);
        }
        return false;
	}

	/**
	 * @description 根据comcode、机构级别查询机构
	 * @param comCode
	 * @param comLevel
	 * @return prpDcompanyDto
	 * @throws Exception
	 * @author hrx
	 * @date 2017年9月25日
	 */
	public PrpDcompanyDto getCompanyByCondition(String comCode, String comLevel) throws Exception {

		PrpDcompany prpDcompany = prpDcompanyDao.getCompanyByCondition(comCode,  comLevel);
		return this.convert(prpDcompany, PrpDcompanyDto.class);
	}
	
	/**
   	 * @description 工作流初始化批量分配模板信息所用，查询所有的有效的出单机构，幷按comcode排序
   	 * @param 
   	 * @return
     * @author yanghang
   	 * @throws Exception
   	 * @date 2017年10月25日
     */
	public List<PrpDcompanyDto> querySwfAllCompany() {
		List<PrpDcompany> prpDcompanyList = prpDcompanyDao.querySwfAllCompany();
		List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<PrpDcompanyDto>();
		convertCollection(prpDcompanyList, prpDcompanyDtoList,PrpDcompanyDto.class );
		return prpDcompanyDtoList;
	}
	
}
