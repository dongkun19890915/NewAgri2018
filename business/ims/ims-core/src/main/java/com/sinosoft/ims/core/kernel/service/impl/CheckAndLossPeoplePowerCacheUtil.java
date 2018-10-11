package com.sinosoft.ims.core.kernel.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.dto.UtiUserGradeDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.core.auth.dao.UtiGradeTaskDao;
import com.sinosoft.ims.core.auth.dao.UtiUserGradeTaskDao;
import com.sinosoft.ims.core.auth.entity.UtiGradeTask;
import com.sinosoft.ims.core.auth.entity.UtiGradeTaskKey;
import com.sinosoft.ims.core.auth.entity.UtiUserGrade;
import com.sinosoft.ims.core.auth.entity.UtiUserGradeTask;
import com.sinosoft.ims.core.auth.entity.UtiUserGradeTaskKey;

@Component
public class CheckAndLossPeoplePowerCacheUtil extends BaseServiceImpl {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private UtiUserGradeTaskDao utiUserGradeTaskDao;
	@Autowired
	private UtiGradeTaskDao utiGradeTaskDao;

	/**
	 * 
	  * @description 检查是否具有权限 
	  * @author yk
	  * @date 2017年12月22日 上午10:28:59
	  * @param prpDuserDto和taskCode
	  * @return boolean是否具有权限
	 */
//	@Cacheable(value = {"checkPowerReturn" }, key = "'1^' + #prpDuserDto.userCode + '^' + #taskCode")
	public boolean checkPowerReturn(PrpDuserDto prpDuserDto, String taskCode) {
		// String taskCode = "claim.check";
		// String taskCode = "claim.certainloss";
		// 1^" + userCode + "^" + comCode + "^" + gradeCodes + "^" + taskCode
		String sql = "SELECT UtiUserGrade.*, " + "(select prpdcompany.comlevel  " + "       from prpdcompany "
				+ "           where 1=1 and UtiUserGrade.comcode = prpdcompany.comcode) as comlevel "
				+ "FROM UtiUserGrade   " + "WHERE   UserCode = ?1 " + "AND (ComCode = ?2)  " + " order by "
				+ "(select prpdcompany.comlevel from prpdcompany where 1 = 1 and UtiUserGrade.comcode = prpdcompany.comcode)"
				+ ",UtiUserGrade.comcode";
		Query query = entityManager.createNativeQuery(sql, UtiUserGrade.class);
		query.setParameter(1, prpDuserDto.getUserCode());
		query.setParameter(2, prpDuserDto.getComCode());
		List<UtiUserGrade> utiUserGradeList = query.getResultList();
		List<UtiUserGradeDto> utiUserGradeDtoList = new ArrayList<>(utiUserGradeList.size());
		convertCollection(utiUserGradeList, utiUserGradeDtoList, UtiUserGradeDto.class);
		for (UtiUserGradeDto utiUserGradeDto : utiUserGradeDtoList) {
			boolean value = false;
			UtiUserGradeTask utiUserGradeTask = utiUserGradeTaskDao
					.findOne(new UtiUserGradeTaskKey(utiUserGradeDto.getComCode(), utiUserGradeDto.getUserCode(),
							utiUserGradeDto.getGradeCode(), taskCode));
			if (utiUserGradeTask != null) {
				value = getBoolean(utiUserGradeTask.getValue());
			} else {
				UtiGradeTask utiGradeTask = utiGradeTaskDao
						.findOne(new UtiGradeTaskKey(utiUserGradeDto.getGradeCode(), taskCode));
				if (utiGradeTask != null)
					value = getBoolean(utiGradeTask.getValue());
				else {
					value = false;
				}
			}
			if (value == true) {
				return true;
			}
		}
		return false;
	}
/**
 * 
  * @description 根据utiUserGradeTask对象的value属性返回布尔值
  * @author yk
  * @date 2017年12月22日 上午10:30:14
  * @param value
  * @return boolean
 */
	private boolean getBoolean(String value) {
		if (value == null) {
			throw new DataVerifyException("argument is null");
		}
		if ((value.equalsIgnoreCase("y")) || (value.equalsIgnoreCase("yes")) || (value.equalsIgnoreCase("true"))
				|| (value.equalsIgnoreCase("t")) || (value.equalsIgnoreCase("是")) || (value.equalsIgnoreCase("1")))

		{
			return true;
		}
		if ((value.equalsIgnoreCase("n")) || (value.equalsIgnoreCase("no")) || (value.equalsIgnoreCase("false"))
				|| (value.equalsIgnoreCase("f")) || (value.equalsIgnoreCase("否")) || (value.equalsIgnoreCase("0")))

		{
			return false;
		}
		if (value.trim().equals("")) {
			return false;
		}
		throw new DataVerifyException("argument not in ('y','n','yes','no','true','false','t','f','是','否','1','0','')");
	}

}
