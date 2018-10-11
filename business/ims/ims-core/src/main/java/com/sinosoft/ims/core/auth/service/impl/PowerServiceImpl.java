package com.sinosoft.ims.core.auth.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.ims.core.auth.dao.UtiGradeTaskDao;
import com.sinosoft.ims.core.auth.dao.UtiMenuDao;
import com.sinosoft.ims.core.auth.entity.UtiGradeTask;
import com.sinosoft.ims.core.auth.entity.UtiMenu;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.CheckPowerPrpallResDto;
import com.sinosoft.ims.api.auth.dto.PowerConditionDto;
import com.sinosoft.ims.api.auth.dto.UtiGradeTaskDto;
import com.sinosoft.ims.api.auth.dto.UtiUserGradeTaskDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.core.auth.dao.UtiUserGradeDao;
import com.sinosoft.ims.core.auth.dao.UtiUserGradePowerDao;
import com.sinosoft.ims.core.auth.entity.UtiUserGrade;
import com.sinosoft.ims.core.auth.entity.UtiUserGradePower;
import com.sinosoft.ims.core.auth.service.PowerService;
import com.sinosoft.ims.core.auth.service.UtiGradeTaskService;
import com.sinosoft.ims.core.auth.service.UtiUserGradeTaskService;
import com.sinosoft.ims.core.common.enums.ImsErrorEnum;
import com.sinosoft.ims.core.kernel.dao.PrpDcompanyDao;
import com.sinosoft.ims.core.kernel.entity.PrpDcompany;
import com.sinosoft.ims.core.kernel.service.CompanyService;
import com.sinosoft.ims.core.kernel.service.UserService;
import com.sinosoft.pms.api.kernel.RiskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;


/**
 * @author hzhongkai
 * @description 权限管理服务接口实现类
 * @date 2016年9月28日下午4:59:28
 */
@Service
public class PowerServiceImpl extends BaseServiceImpl implements PowerService {
    /**
     * log日志
     */
    private static Log LOGGER = LogFactory.getLog(PowerServiceImpl.class);
    
    @Autowired
    private CompanyService companyService;
    @Autowired
    private PrpDcompanyDao prpDcompanyDao;
    @Autowired
    private UtiUserGradeDao utiUserGradeDao;
    @Autowired
    private UtiGradeTaskDao utiGradeTaskDao;
    @Autowired
    private UtiUserGradePowerDao utiUserGradePowerDao;
    @Autowired
    private UtiGradeTaskService utiGradeTaskService;
    @Autowired
    private UtiUserGradeTaskService utiUserGradeTaskService;
    @Autowired
    private UtiMenuDao utiMenuDao;
    @Autowired
    private UserService userService;
    @Autowired
    private RiskApi riskApi;

	/**
	 * @description 判断某个功能是否有权执行
	 * @param powerConditionDto
	 * @param cacheKey 缓存key
	 * @return ResponseDto
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月15日 下午3:42:55
	 */
	@Override
	//@Cacheable(value = "PowerServiceImpl.checkPower", key = "#cacheKey")
	public boolean checkPower(PowerConditionDto powerConditionDto, String cacheKey) {
		if(LOGGER.isInfoEnabled()){
			LOGGER.error(powerConditionDto.getUserCode());
		}
		if (powerConditionDto.getTaskCodes() == null || powerConditionDto.getTaskCodes().length() == 0) {
			throw new BusinessException("岗位代码列表不能为空！");
        }
		String[] taskCodeArray = StringGyUtils.split(powerConditionDto.getTaskCodes(), ",");
		if(LOGGER.isInfoEnabled()){
			LOGGER.error(powerConditionDto.getTaskCodes() + "==powerConditionDto==" + taskCodeArray.length);
		}
		boolean value = false;
        for (int i = 0; i < taskCodeArray.length; i++) {
        	boolean flag = false;
        	if(IMSConstant.PA_SERVICE_NAME.equals(powerConditionDto.getSystemCode())){
        		flag = checkPowerImpl(powerConditionDto.getUserCode(), 
        				powerConditionDto.getComCode(), 
        				powerConditionDto.getGradeCodes(), 
        				taskCodeArray[i], 
        				powerConditionDto.getRiskCode(), true);
        	}else{
        		flag = checkPowerImpl(powerConditionDto.getUserCode(), 
        				powerConditionDto.getComCode(), 
        				powerConditionDto.getGradeCodes(), 
        				taskCodeArray[i], "", false);
        	}
        	if (flag){
        		value = true;
                break;
            }
        }
        return value;
	}
	
	/**
     * 判断某个功能是否有权执行（具体实现）
     * @param userCode 员工代码
     * @param comCode 登录机构
     * @param gradeCodes 登录岗位列表（逗号分割)
     * @param taskCode 任务代码
     * @param riskCode 险种代码
     * @param hasRiskCode 是否有险种
     * @return 有权返回true，无权返回false
     * @throws Exception
     */
    public boolean checkPowerImpl(String userCode, String comCode, String gradeCodes,
            String taskCode, String riskCode, boolean hasRiskCode) {
    	 if (StringUtils.isEmpty(userCode)) {
             throw new BusinessException("参数\"员工代码\"没有值");
         }
         if (StringUtils.isEmpty(comCode) && StringUtils.isEmpty(gradeCodes)) {
             throw new BusinessException("参数\"登录机构\"和\"登录岗位列表\"必须有一个有值");
         }
         if (StringUtils.isEmpty(taskCode)) {
             throw new BusinessException("参数\"功能代码\"没有值");
         }
         if (hasRiskCode && StringUtils.isEmpty(riskCode)) {
             throw new BusinessException("调用带险种的服务时参数\"险种代码\"必须有值");
         }
         if (isSuperUser(comCode, userCode)) {
             // 超级用户具有权限管理功能的权限
             return true;
         }
         String[] gradeCodeArray = StringGyUtils.split(gradeCodes, ",");
         if(LOGGER.isInfoEnabled()){
 			LOGGER.error(comCode + "==userCode==" + userCode);
 		 }
         // 根据员工代码、机构代码/岗位代码查询出所有机构员工岗位
         List<UtiUserGrade> utiUserGradeList = utiUserGradeDao.findAll(Specifications.<UtiUserGrade>and()
        		 .eq(StringUtils.isNotEmpty(userCode), "userCode", userCode)
        		 .eq(StringUtils.isNotEmpty(comCode), "comCode", comCode)
        		 .in(StringUtils.isNotEmpty(gradeCodes), "gradeCode", Arrays.asList(gradeCodeArray))
                .build());
         if(LOGGER.isInfoEnabled()){
  			LOGGER.error(comCode + "==utiUserGradeList==" + utiUserGradeList.size());
  		 }
         // 对所有的机构员工岗位进行顺序处理
         for (UtiUserGrade utiUserGrade : utiUserGradeList) {
             boolean value = false;
             // 如果机构员工岗位差异功能权限中有值，则为机构员工岗位差异功能权限的值，否则为机构员工岗位的岗位权限值，如果再没有则为false
             UtiUserGradeTaskDto utiUserGradeTaskDto = utiUserGradeTaskService.queryByPK(utiUserGrade.getComCode(),
            		 utiUserGrade.getUserCode(), utiUserGrade.getGradeCode(), taskCode);
             if (utiUserGradeTaskDto != null) {
                 value = DataUtils.getBoolean(utiUserGradeTaskDto.getValue());
             } else {
                 UtiGradeTaskDto utiGradeTaskDto = utiGradeTaskService.queryByPK(utiUserGrade.getGradeCode(),
                         taskCode);
                 if (utiGradeTaskDto != null) {
                     value = DataUtils.getBoolean(utiGradeTaskDto.getValue());
                 } else {
                     value = false;
                 }
             }
             if (value == true) {
                 if (hasRiskCode) {
                     List<UtiUserGradePower> utiUserGradePowerList = utiUserGradePowerDao.findAll(Specifications.<UtiUserGradePower>and()
                    		 .eq(StringUtils.isNotEmpty(userCode), "userCode", userCode)
                    		 .eq(StringUtils.isNotEmpty(utiUserGrade.getComCode()), "comCode", utiUserGrade.getComCode())
                    		 .eq(StringUtils.isNotEmpty(utiUserGrade.getGradeCode()), "gradeCode", utiUserGrade.getGradeCode())
                            .build());
                     for (UtiUserGradePower utiUserGradePower : utiUserGradePowerList) {
                         String permitRiskCode = utiUserGradePower.getPermitRiskCode();
                         if(LOGGER.isInfoEnabled()){
                   			LOGGER.error("==permitRiskCode==" + permitRiskCode);
                   		 }
                         // 允许操作的险种为*或包含传入险种即返回true
                         if (permitRiskCode.equals("*") || permitRiskCode.endsWith(riskCode)
                                 || permitRiskCode.indexOf(riskCode + ",") > -1) {
                             return true;
                         }
                     }
                 } else { // 不含险种时直接返回true
                     return true;
                 }
             }
         }
         return false;
    }
    
    /**
     * @description 是否是超级用户
     * @param comCode 机构代码
     * @return userCode 用户代码
     * @throws Exception
     * @author libin
     * @date 2017年9月13日 上午11:33:08
     */
    public boolean isSuperUser(String comCode, String userCode){
        boolean topCompany = companyService.isTopCompany(comCode);
        return topCompany && userCode.equals(StringUtils.newString('0', userCode.length()))
                && userCode.length() >= 8;
    }

	/**
	 * @description 检验给定的员工是否具有针对某些数据操作的权限(查询方式为本机构及同级机构及下级机构)
	 * @param powerConditionDto
	 * @param cacheKey缓存key
	 * @return ResponseDto
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月13日 上午11:30:11
	 */
	@Override
	@Cacheable(value = "PowerServiceImpl.checkDataPower", key = "#cacheKey")
	public ResponseDto checkDataPower(PowerConditionDto powerConditionDto, String cacheKey){
		if(LOGGER.isInfoEnabled()){
			LOGGER.error("cacheKey:"+cacheKey);
			LOGGER.error(powerConditionDto.getComCode() + "==powerConditionDto==" + powerConditionDto.getUserCode());
		}
		ResponseDto result = new ResponseDto();
		boolean value = false;
		if(IMSConstant.PA_SERVICE_NAME.equals(powerConditionDto.getSystemCode())){
			value = getPowerImpl(powerConditionDto.getUserCode(), 
    				powerConditionDto.getComCode(), 
    				powerConditionDto.getGradeCodes(), 
    				powerConditionDto.getDataUserCode(),
    				powerConditionDto.getDataComCode(),
    				powerConditionDto.getRiskCode(), 
    				false, IMSConstant.SUB_COMPANY);
    	}else{
    		value = getPowerImpl(powerConditionDto.getUserCode(), 
    				powerConditionDto.getComCode(), 
    				powerConditionDto.getGradeCodes(), 
    				powerConditionDto.getDataUserCode(),
    				powerConditionDto.getDataComCode(),
    				"", false, IMSConstant.SUB_COMPANY);
    	}
		if(value){
        	result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
            result.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
        }else{
        	result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            result.setResultMsg(ImsErrorEnum.IMS_ERROR.getName());
        }
        return result;
	}
	
	/**
	 * @description 检验给定的员工是否具有针对某些数据操作的权限(查询方式为本机构及同级机构及下级机构)
	 * @param userCode 员工代码
     * @param comCode 登录机构
     * @param gradeCodes 登录岗位列表（逗号分割)
     * @param dataUserCode 数据中的员工代码
     * @param dataComCode 数据中的机构代码
     * @param riskCode 险种代码
     * @param hasRiskCode 是否有险种
     * @param queryComType 查询的机构方式
	 * @return 有权返回true,无权返回false
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月14日 上午10:35:37
	 */
	public boolean getPowerImpl(String userCode, String comCode, String gradeCodes,
            String dataUserCode, String dataComCode, String riskCode, boolean hasRiskCode, int queryComType){
		if (StringUtils.isEmpty(userCode)) {
            throw new BusinessException("参数\"员工代码\"没有值");
        }
        if (StringUtils.isEmpty(comCode) && StringUtils.isEmpty(gradeCodes)) {
            throw new BusinessException("参数\"登录机构\"和\"登录岗位列表\"必须有一个有值");
        }
        // TODO:待确认，传入数据都为空时默认返回true。
        if (StringUtils.isEmpty(dataUserCode) && StringUtils.isEmpty(dataComCode)) {
            return true;
        }

        if (hasRiskCode == false) {
            // 调用不含险种的服务时数据员工代码等于员工代码则返回true
            if (userCode.equals(dataUserCode)) {
                return true;
            }
        }
        // POWER:管理员有所有业务权限
        if (isSuperUser(comCode, userCode)) {
            return true;
        }
        String comCodeFromDataUserCode = ""; // 从数据员工代码获取的机构代码
        if (!StringUtils.isEmpty(dataUserCode)) {
            PrpDuserDto prpDuserDto = userService.queryUserInfo(dataUserCode);
            if (prpDuserDto != null) {
                comCodeFromDataUserCode = prpDuserDto.getComCode();
            }
        }

        String[] gradeCodeArray = StringGyUtils.split(gradeCodes, ",");
        if(LOGGER.isInfoEnabled()){
			LOGGER.error(gradeCodes + "==userCode==" + userCode);
		}
        // 根据员工代码、机构代码/岗位代码查询出所有机构员工岗位
        List<UtiUserGrade> utiUserGradeList = utiUserGradeDao.findAll(Specifications.<UtiUserGrade>and()
       		 .eq(StringUtils.isNotEmpty(userCode), "userCode", userCode)
       		 .eq(StringUtils.isNotEmpty(comCode), "comCode", comCode)
       		 .in(StringUtils.isNotEmpty(gradeCodes), "gradeCode", Arrays.asList(gradeCodeArray))
               .build());
        if(LOGGER.isInfoEnabled()){
 			LOGGER.error(comCode + "==utiUserGradeList==" + utiUserGradeList.size());
 		}
        // 对所有的机构员工岗位进行顺序处理,每个机构员工岗位之间是OR的关系
        for (UtiUserGrade utiUserGrade : utiUserGradeList) {
            List<UtiUserGradePower> utiUserGradePowerList = utiUserGradePowerDao.findAll(Specifications.<UtiUserGradePower>and()
           		 .eq(StringUtils.isNotEmpty(userCode), "userCode", userCode)
           		 .eq(StringUtils.isNotEmpty(utiUserGrade.getComCode()), "comCode", utiUserGrade.getComCode())
           		 .eq(StringUtils.isNotEmpty(utiUserGrade.getGradeCode()), "gradeCode", utiUserGrade.getGradeCode())
                   .build());
            // 对机构员工岗位的每条业务记录进行顺序处理,有一条满足即返回true，否则处理下一条
            for (UtiUserGradePower utiUserGradePower : utiUserGradePowerList) {
                String permitRiskCode = utiUserGradePower.getPermitRiskCode();
                // 险种代码不为*时加上险种控制
                if (!permitRiskCode.equals("*")) {
                    // 如果服务是带险种的，则检测权限
                    if (hasRiskCode) {
                        // 允许操作的险种不包含传入险种即continue
                        if (!(permitRiskCode.endsWith(riskCode) || permitRiskCode.indexOf(riskCode + ",") > -1)) {
                            continue;
                        }
                    }
                }
                // 处理员工代码字段
                if (dataUserCode.equals(userCode)) {
                    return true;
                }
                String[] permitUserCodes = StringGyUtils.split(utiUserGradePower.getPermitUserCode(), ",");
                for (int i = 0; i < permitUserCodes.length; i++) {
                    if (dataUserCode.equals(permitUserCodes[i])) {
                        return true;
                    }
                }

                // 处理机构代码字段
                // 处理权限机构开始
                String permitComCode = utiUserGradePower.getPermitComCode();
                boolean hasComPower = true;// 默认具有机构权限
                switch (queryComType) {
                case IMSConstant.SELF_COMPANY:
                    // 如果数据机构代码和从员工代码得来的机构代码都不是权限机构，则表示无权
                    if (!dataComCode.equals(permitComCode) && !comCodeFromDataUserCode.equals(permitComCode)) {
                        hasComPower = false;
                    }
                    break;
                case IMSConstant.SAME_COMPANY:
                    // 如果数据机构代码和从员工代码得来的机构代码都不是本机构或其同级机构，则表示无权
                    if (!companyService.isSameLevelCompany(dataComCode, permitComCode)
                            && !companyService.isSameLevelCompany(comCodeFromDataUserCode,
                                    permitComCode)) {
                        hasComPower = false;
                    }
                    break;
                case IMSConstant.SUB_COMPANY:
                    // 如果数据机构代码和从员工代码得来的机构代码都不是权限机构的下级，则表示无权
                    if (!companyService.isSubCompany(dataComCode, permitComCode)
                            && !companyService.isSubCompany(comCodeFromDataUserCode, permitComCode)) {
                        hasComPower = false;
                    }
                    break;
                }

                // 如果没有机构权限，则表示无权，继续下一条的检查
                if (!hasComPower) {
                    continue;
                }

                // 处理权限机构结束
                // 处理除外机构开始
                boolean inExceptComCode = false;
                String[] exceptComCodeArray = StringGyUtils.split(utiUserGradePower.getExceptComCode(), ",");
                for (int i = 0; i < exceptComCodeArray.length; i++) {
                    String exceptCompanyCode = exceptComCodeArray[i];// 公司代码
                    // 如果数据机构代码和从员工代码得来的机构代码都不是权限机构的下级，则表示无权，继续下一条的检查
                    if (companyService.isSubCompany(dataComCode, exceptCompanyCode)
                            || companyService.isSubCompany(comCodeFromDataUserCode, exceptCompanyCode)) {
                        inExceptComCode = true;
                        break;
                    }
                }
                // 存在于除外权限机构中则继续
                if (inExceptComCode) {
                    continue;
                }
                // 处理除外机构结束

                // 经过重重检测，能到这里的话就返回true了
                return true;
            }
        }
        return false;
	}

	/**
	 * @description 根据外部传入的信息获取查询条件附加权限
	 * @param powerConditionDto
	 * @param cacheKey 缓存key
	 * @return String 附加的权限SQL语句
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月14日 下午4:22:39
	 */
	@Override
	@Cacheable(value = "PowerServiceImpl.addPower", key = "#cacheKey")
	public String addPower(PowerConditionDto powerConditionDto, String cacheKey) {
		if(LOGGER.isInfoEnabled()){
			LOGGER.error("cacheKey:"+cacheKey);
			LOGGER.error(powerConditionDto.getComCode() + "==powerConditionDto==" + powerConditionDto.getUserCode());
		}
		String result = "";
		result = this.addPowerImpl(powerConditionDto.getUserCode(), 
				powerConditionDto.getComCode(), 
				powerConditionDto.getGradeCodes(), 
				powerConditionDto.getTableName(), 
				powerConditionDto.getUserCodeFields(), 
				powerConditionDto.getComCodeFields(), "", 
				false, IMSConstant.SUB_COMPANY, IMSConstant.ADD_CODE_POWER);
        return result;
	}
	
	/**
	 * @description 业务权限的获取
     * @param userCode 员工代码
     * @param comCode 登录机构
     * @param gradeCodes 登录岗位列表（逗号分割)
     * @param tableName 表名
     * @param userCodeFields 用户字段名称（逗号分割)
     * @param comCodeFields 机构字段名称（逗号分割)
     * @param riskCode 险种代码
     * @param hasRiskCode 是否有险种
     * @param queryComType 查询的机构方式
	 * @return 返回附加的权限语句
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月14日 下午4:21:37
	 */
	public String addPowerImpl(String userCode, String comCode, String gradeCodes,
            String tableName, String userCodeFields, String comCodeFields, String riskCode, boolean hasRiskCode,
            int queryComType, int type){
        if (StringUtils.isEmpty(userCode)) {
            throw new BusinessException("参数\"员工代码\"没有值");
        }
        if (StringUtils.isEmpty(tableName)) {
            throw new BusinessException("参数\"表名\"没有值");
        }
        if (StringUtils.isEmpty(comCode) && StringUtils.isEmpty(gradeCodes)) {
            throw new BusinessException("参数\"登录机构\"和\"登录岗位列表\"必须有一个有值");
        }
        if (StringUtils.isEmpty(userCodeFields) && StringUtils.isEmpty(comCodeFields)) {
            throw new BusinessException("参数\"用户字段名称\"和\"机构字段名称\"必须有一个有值");
        }
        if (hasRiskCode && StringUtils.isEmpty(riskCode)) {
            throw new BusinessException("调用带险种的服务时参数\"险种代码\"必须有值");
        }
        // POWER:管理员有所有业务权限
        if (isSuperUser(comCode, userCode)) {
            return "";
        }

//        // 加上对HandlerCode,OperatorCode,Handler1Code等三个字段的处理
//        if (userCodeFields.length() > 0) {
//            userCodeFields += ",";
//        }
        // REASON: 来自于业务系统的调用，如果只是指定了userCodeFields的值，
        // 而comCodeFields不为空，则userCodeFields将不增加默认值
        // HandlerCode,OperatorCode,Handler1Code
        // ORIGINAL CODES：
        /* 
            userCodeFields += "HandlerCode,OperatorCode,Handler1Code";
        */
//        if (!hasRiskCode || (hasRiskCode && !"".equals(comCodeFields))) {
//            // 不分险种，或 有险种且机构代码字段不为空
//            userCodeFields += "HandlerCode,OperatorCode,Handler1Code";
//        }
        
        // 处理UserCode字段列表
        String[] userCodeFieldsArray = StringGyUtils.split(userCodeFields, ",");
//        Map<String, String> fieldMap = new HashMap<String, String>();
//        for (int i = 0; i < userCodeFieldsArray.length; i++) {
//            if (dbManager.hasColumn(tableName, userCodeFieldsArray[i])) {
//                fieldMap.put(userCodeFieldsArray[i].toLowerCase(), userCodeFieldsArray[i]);
//            }
//        }
//        userCodeFieldsArray = new String[fieldMap.size()];
//        fieldMap.values().toArray(userCodeFieldsArray);

        // 处理ComCode字段列表，目前不提供检测字段是否存在的功能
        String[] comCodeFieldsArray = StringGyUtils.split(comCodeFields, ",");

        StringBuffer buffer = new StringBuffer();// 结果SQL语句的Buffer
        boolean perfectComTree = false; // 是否是完美的机构树，默认为true
//        UtiPlatConfigDto utiPlatConfigDto = new BLUtiPlatConfigAction().findByPrimaryKey(dbManager, "platform",
//                PERFECT_COM_TREE);
//        if (utiPlatConfigDto != null) {
//            perfectComTree = DataUtils.getBoolean(utiPlatConfigDto.getParamValue());
//        }

//        boolean tableHasRiskCode = true;// 表是否含有RiskCode字段，默认为有
//        // 如果服务是不带险种的，则检测表是否含有险种字段
//        if (hasRiskCode == false) {
//            tableHasRiskCode = dbManager.hasColumn(tableName, "RiskCode");
//        }
        
        String[] gradeCodeArray = StringGyUtils.split(gradeCodes, ",");
        if(LOGGER.isInfoEnabled()){
			LOGGER.error(gradeCodes + "==userCode==" + userCode);
		}
        // 根据员工代码、机构代码/岗位代码查询出所有机构员工岗位
        List<UtiUserGrade> utiUserGradeList = utiUserGradeDao.findAll(Specifications.<UtiUserGrade>and()
       		 .eq(StringUtils.isNotEmpty(userCode), "userCode", userCode)
       		 .eq(StringUtils.isNotEmpty(comCode), "comCode", comCode)
       		 .in(StringUtils.isNotEmpty(gradeCodes), "gradeCode", Arrays.asList(gradeCodeArray))
               .build());
        if(LOGGER.isInfoEnabled()){
 			LOGGER.error(comCode + "==utiUserGradeList==" + utiUserGradeList.size());
 		}
        // 对所有的机构员工岗位进行顺序处理,每个机构员工岗位之间是OR的关系
        for (UtiUserGrade utiUserGrade : utiUserGradeList) {
            List<UtiUserGradePower> utiUserGradePowerList = utiUserGradePowerDao.findAll(Specifications.<UtiUserGradePower>and()
              		 .eq(StringUtils.isNotEmpty(userCode), "userCode", userCode)
              		 .eq(StringUtils.isNotEmpty(utiUserGrade.getComCode()), "comCode", utiUserGrade.getComCode())
              		 .eq(StringUtils.isNotEmpty(utiUserGrade.getGradeCode()), "gradeCode", utiUserGrade.getGradeCode())
                      .build());
            // 对机构员工岗位的每条业务记录进行顺序处理
            for (UtiUserGradePower utiUserGradePower : utiUserGradePowerList) {
                String recordSQL = "";// 每条记录生成的SQL语句
//                String permitRiskCode = utiUserGradePower.getPermitRiskCode();
                // 险种代码不为*时加上险种控制
//                if (!permitRiskCode.equals("*")) {
//                    // 如果服务是带险种的，则检测权限
//                    if (hasRiskCode) {
//                        // 允许操作的险种不包含传入险种即continue
//                        if (!(permitRiskCode.endsWith(riskCode) || permitRiskCode.indexOf(riskCode + ",") > -1)) {
//                            continue;
//                        }
//                    } else {
//                        if (tableHasRiskCode) { // 表存在RiskCode字段时
//                            recordSQL += SqlUtils.convertString(tableName + ".RiskCode", utiUserGradePower
//                                    .getPermitRiskCode());
//                        }
//                    }
//                }

                // 机构和员工之间的关系为OR , 各字段之间的关系为OR
                // 处理机构代码字段

                String comCodeSQL = "";// ComCode生成的SQL语句
                for (int i = 0; i < comCodeFieldsArray.length; i++) {
                    String field = comCodeFieldsArray[i];
                    String permitComCode = "";
                    String exceptComCodes = "";
                    switch (type) {
                    case IMSConstant.ADD_CODE_POWER:
                        // 如果是代码权限则使用CodePermitComCode和CodeExceptComCode字段
                        permitComCode = utiUserGradePower.getCodePermitComCode();
                        exceptComCodes = utiUserGradePower.getCodeExceptComCode();
                        if (permitComCode.trim().length() == 0) {
                            permitComCode = utiUserGradePower.getPermitComCode();
                        }
                        break;
                    case IMSConstant.ADD_CUSTOMER_POWER:
                        // 如果是客户代码权限则使用CustomePermitComCode和CustomeExceptComCode字段
                        permitComCode = utiUserGradePower.getCustomerPermitComCode();
                        exceptComCodes = utiUserGradePower.getCustomerExceptComCode();
                        if (permitComCode.trim().length() == 0) {
                            permitComCode = utiUserGradePower.getPermitComCode();
                        }
                        break;
                    default:
                        permitComCode = utiUserGradePower.getPermitComCode();
                        exceptComCodes = utiUserGradePower.getExceptComCode();
                        break;
                    }

                    if(StringUtils.isEmpty(permitComCode)){
                    	permitComCode = "";
                    }
                    if(StringUtils.isEmpty(exceptComCodes)){
                    	exceptComCodes = "";
                    }
                    String comCodeFieldSQL = getComCodeSQL(tableName + "." + field, permitComCode,
                            exceptComCodes, perfectComTree, queryComType);
                    if (i == 0) {
                        comCodeSQL += "(" + comCodeFieldSQL + ")";
                    } else {
                        comCodeSQL += " OR (" + comCodeFieldSQL + ")";
                    }
                }
                // 处理机构结束

                // 处理员工代码字段
                String userCodeSQL = "";// UserCode生成的SQL语句
                for (int i = 0; i < userCodeFieldsArray.length; i++) {
                    String field = userCodeFieldsArray[i];
                    String userCodeFieldSQL = "";
                    userCodeFieldSQL += "(" + tableName + "." + field + " = '" + userCode + "')"; // 员工默认有察看自身参与的数据的权限
                    String[] permitUserCodes = StringGyUtils.split(utiUserGradePower.getPermitUserCode(), ",");
                    for (int j = 0; j < permitUserCodes.length; j++) {
                        String permitUserCode = permitUserCodes[j];
                        userCodeFieldSQL += " OR (" + tableName + "." + field + " = '" + permitUserCode + "')";
                    }
                    // 最开始要加AND。最开始和最后的条件要包括起来
                    if (i == 0) {
                        userCodeSQL += " OR (" + userCodeFieldSQL + ")";
                    } else {
                        userCodeSQL += " OR (" + userCodeFieldSQL + ")";
                    }
                }
                if (userCodeSQL.trim().toUpperCase().startsWith("OR")) {
                    userCodeSQL = userCodeSQL.trim().substring("OR".length()).trim();
                }
                if (!StringUtils.isEmpty(comCodeSQL) && !StringUtils.isEmpty(userCodeSQL)) {
                    recordSQL += " AND ((" + comCodeSQL + ") OR (" + userCodeSQL + "))";
                } else if (!StringUtils.isEmpty(comCodeSQL)) {
                    recordSQL += " AND (" + comCodeSQL + ")";
                } else if (!StringUtils.isEmpty(userCodeSQL)) {
                    recordSQL += " AND (" + userCodeSQL + ")";
                }

                // 将各条记录产生的SQL拼起来即所需完整SQL，各记录间的关系为OR
                if (recordSQL.trim().length() > 0) {
                    if (recordSQL.trim().toUpperCase().startsWith("AND")) {
                        recordSQL = recordSQL.trim().substring("AND".length()).trim();
                    }
                    // 第一次添加时无需OR
                    if (buffer.length() == 0) {
                        buffer.append("(");
                        buffer.append(recordSQL);
                        buffer.append(")");
                    } else {
                        // 过滤重复条件
                        if (buffer.indexOf(recordSQL) == -1) {
                            buffer.append(" OR (");
                            buffer.append(recordSQL);
                            buffer.append(")");
                        }
                    }
                    recordSQL = "";
                }
            }

        }

        // 不存在业务权限配置时抛出异常
        if (buffer.length() == 0) {
            String message = "不存在业务权限，无权执行此操作! <br>参数为：";
            message += "员工代码='" + userCode + "',";
            message += "登录机构代码='" + comCode + "',";
            message += "登录岗位代码='" + gradeCodes + "'";
            throw new BusinessException(message);
        }
        // 返回时将SQL语句包起来，并用AND连接。
        buffer.insert(0, " AND ("); // 前面插入AND (
        buffer.append(")"); // 后面追加)
        return buffer.toString();
    }
	
	/**
     * 获取机构代码和除外机构代码组织的SQL语句
     * @param fieldName 表名.字段名
     * @param comCode 机构代码
     * @param exceptComCode 除外机构代码
     * @param perfectComTree 是否是完美的树 *
     * @param queryComType 查询的机构方式 <br>
     * @return 简单的SQL语句，没有用括号包围，且没有AND、OR等前缀
     * @throws Exception
     */
    public String getComCodeSQL(String fieldName, String comCode, String exceptComCode,
            boolean perfectComTree, int queryComType) {
        String comCodeSQL = "";
        if (StringUtils.isEmpty(comCode)) {
            throw new BusinessException("(代码)权限机构代码不能为空");
        }
        // 如果除外机构包含权限机构则直接返回1=0
        if (exceptComCode.indexOf(comCode) > -1) {
            return "1=0";
        }
        if (perfectComTree) {// 是完美的机构树，采用尾部偶数截零法
            // 如果不是总公司则需要添加机构条件
            if (companyService.isTopCompany(comCode) == false) {
                comCodeSQL += "(";
                switch (queryComType) {
                case IMSConstant.SELF_COMPANY:
                    comCodeSQL += fieldName + " = '" + comCode + "'";
                    break;
                case IMSConstant.SAME_COMPANY:
                	List<PrpDcompanyDto> companys = this.findByComCode(comCode, exceptComCode,
                            queryComType);
                    comCodeSQL += fieldName + " IN (";
                    int i = 0;
                    for (PrpDcompanyDto element : companys) {
                        comCodeSQL += "'" + element.getComCode() + "'";
                        i++;
                        if (i != companys.size()) {
                            comCodeSQL += ",";
                        }
                        
                    }
                    comCodeSQL += ")";
                    break;
                case IMSConstant.SUB_COMPANY:
                    String companyCode = tailEvenTrim(comCode);// 公司代码
                    comCodeSQL += fieldName + " LIKE '" + companyCode + "%'";
                    break;
                }
                comCodeSQL += ")";
            }
            String[] values = StringGyUtils.split(exceptComCode, ",");
            for (int i = 0; i < values.length; i++) {
                String exceptCompanyCode = tailEvenTrim(values[i]);// 公司代码
                // 长度为0表示是总公司无需处理，否则要添加机构条件
                if (exceptCompanyCode.length() == 0) {
                    comCodeSQL += " AND (1 = 0)";
                    break; // 发现一个则无需继续了
                }
                // 长度一致则直接用=操作符
                if (exceptComCode.length() == exceptCompanyCode.length()) {
                    comCodeSQL += " AND (" + fieldName + " != '" + exceptCompanyCode + "')";
                } else {
                    comCodeSQL += " AND (" + fieldName + " NOT LIKE '" + exceptCompanyCode + "%')";
                }

            }
        } else {// 不是完美的机构树，采用递归查询法
            // 长度一致则直接用=操作符
        	List<PrpDcompanyDto> companys = this.findByComCode(comCode, exceptComCode, queryComType);
            if (companys.size() == 0) {
                comCodeSQL = "1=0";
            } else {
                comCodeSQL = fieldName + " IN (";
                for (Iterator<PrpDcompanyDto> iter = companys.iterator(); iter.hasNext();) {
                    PrpDcompanyDto element = iter.next();
                    comCodeSQL += "'" + element.getComCode() + "'";
                    if (iter.hasNext()) {
                        comCodeSQL += ",";
                    }
                }
                comCodeSQL += ")";
            }
        }

        if (comCodeSQL.trim().toUpperCase().startsWith("AND")) {
            comCodeSQL = comCodeSQL.trim().substring("AND".length()).trim();
        }
        if (comCodeSQL.trim().length() == 0) {
            comCodeSQL = "1=1";
        }
        String[] table = StringGyUtils.split(fieldName, ".");
        if (table[0].toLowerCase().equals("prpdcustomeridv") || table[0].toLowerCase().equals("prpdcustomerunit")) {
            // 查询客户资料时加上允许下级查看的上级机构
        	List<PrpDcompanyDto> upperCompanys = this.findByComCode(comCode, exceptComCode,
                    IMSConstant.UPPER_COMPANY);
            comCodeSQL += " OR (" + fieldName + " IN (";
            for (Iterator<PrpDcompanyDto> iter = upperCompanys.iterator(); iter.hasNext();) {
                PrpDcompanyDto element = iter.next();
                comCodeSQL += "'" + element.getComCode() + "'";
                if (iter.hasNext()) {
                    comCodeSQL += ",";
                }
            }
            comCodeSQL += ") AND lowerViewFlag = '1'";
            comCodeSQL = "(" + comCodeSQL;
            comCodeSQL += " ))";

        }
        return comCodeSQL;
    }
    
    /**
     * @description 获取机构（包含本身）
     * @param comCode 机构代码
     * @param exceptComCode 除外机构代码
     * @param queryComType 查询的机构方式
     * @return PrpDcompanyDto列表
     * @throws Exception
     * @author libin
     * @date 2017年9月15日 上午9:52:42
     */
    public List<PrpDcompanyDto> findByComCode(String comCode, String exceptComCode, int queryComType){
    	List<PrpDcompanyDto> companys = new ArrayList<PrpDcompanyDto>();
        PrpDcompanyDto prpDcompanyDto = companyService.queryCompanyByComCode(comCode);
        if (prpDcompanyDto != null) {
            switch (queryComType) {
            case IMSConstant.SELF_COMPANY:
            case IMSConstant.SAME_COMPANY:
            case IMSConstant.SUB_COMPANY:
                companys = findByComCodeWithoutUpper(prpDcompanyDto, comCode, exceptComCode,
                        queryComType);
                break;
//            case IMSConstant.UPPER_COMPANY:
//                String upperConditions = "";
//                upperConditions += " comCode IN" + " (Select ComCode from prpdCompany Start With ComCode  = '"
//                        + comCode + "' Connect By Prior uppercomCode = comCode AND  "
//                        + " prior ComCode != ComCode  AND validstatus='1') AND (comCode != '" + comCode + "')";
//                upperConditions += " ORDER BY ComCode";
//                companys.addAll(dbPrpDcompany.findByConditions(upperConditions, 0, 0));
//                break;
            }
        }
        return companys;
    }

    /**
     * @description 获取机构（包含本身）(不支持UPPER_COMPANY)
     * @param 
     * @return 
     * @throws Exception
     * @author libin
     * @date 2017年9月15日 上午10:02:28
     */
    public List<PrpDcompanyDto> findByComCodeWithoutUpper(PrpDcompanyDto prpDcompanyDto, String comCode, 
    		String exceptComCode, int queryComType) {
    	List<PrpDcompanyDto> companys = new ArrayList<PrpDcompanyDto>();
        Specification<PrpDcompany> specification = null;
        if (prpDcompanyDto != null) {
            // 如果机构代码不在除外机构代码列表中，则查询下级，否则不查询
            if (exceptComCode.indexOf(comCode) == -1) {
                companys.add(prpDcompanyDto); // 添加自身
                switch (queryComType) {
                case IMSConstant.SELF_COMPANY:
                    break;
                case IMSConstant.SAME_COMPANY:
                    specification = Specifications.<PrpDcompany>and()
                    	.eq(StringUtils.isNotEmpty(comCode), "upperComCode", comCode)
                    	.eq(StringUtils.isNotEmpty(prpDcompanyDto.getComLevel()), "comLevel", prpDcompanyDto.getComLevel())
                        .build();
                    break;
                case IMSConstant.SUB_COMPANY:
                    specification = Specifications.<PrpDcompany>and()
                    	.eq(StringUtils.isNotEmpty(comCode), "upperComCode", comCode)
                        .build();
                    break;
                }
                // 如果specification不为空,则进行以下递归处理
                if (specification != null) {
                    List<PrpDcompany> list = prpDcompanyDao.findAll(specification);
                    for (PrpDcompany element : list) {
                        if (exceptComCode.indexOf(element.getComCode()) == -1
                                && !element.getComCode().equals(element.getUpperComCode())) {
                            companys.add(this.convert(element, PrpDcompanyDto.class));
                            findByComCodeRecursive(companys, element.getComCode(), exceptComCode, 
                            		queryComType, element.getComLevel());
                        }
                    }
                }
            }
        }
        return companys;
    }
    
    private void findByComCodeRecursive(List<PrpDcompanyDto> companys, String comCode,
            String exceptComCode, int queryComType, String comLevel){
        Specification<PrpDcompany> specification = null;
        switch (queryComType) {
	        case IMSConstant.SELF_COMPANY:
	            break;
	        case IMSConstant.SAME_COMPANY:
	            specification = Specifications.<PrpDcompany>and()
	            	.eq(StringUtils.isNotEmpty(comCode), "upperComCode", comCode)
	            	.eq(StringUtils.isNotEmpty(comLevel), "comLevel", comLevel)
	                .build();
	            break;
	        case IMSConstant.SUB_COMPANY:
	        	specification = Specifications.<PrpDcompany>and()
		        	.eq(StringUtils.isNotEmpty(comCode), "upperComCode", comCode)
		            .build();
	            break;
        }
        // 如果conditons不为空,则进行以下递归处理
        if (specification != null) {
        	List<PrpDcompany> list = prpDcompanyDao.findAll(specification);
            for (PrpDcompany element : list) {
                if (exceptComCode.indexOf(element.getComCode()) == -1
                        && !element.getComCode().equals(element.getUpperComCode())) {
                    companys.add(this.convert(element, PrpDcompanyDto.class));
                    findByComCodeRecursive(companys, element.getComCode(), exceptComCode, queryComType,
                            element.getComLevel());
                }
            }
        }
    }
    
    /**
     * 尾部偶数截零法处理机构代码
     * @param comCode 机构代码
     * @return 尾部偶数截零法处理后的机构代码
     */
    private static String tailEvenTrim(String comCode) {
        if (comCode == null || comCode.trim().length() == 0) {
            return "";
        }
        while (comCode.endsWith("00")) {
            comCode = comCode.substring(0, comCode.length() - 2);
        }

        return comCode;

    }
    
	/**
	 * @description 可操作险种条件的获取
     * @param powerConditionDto 员工代码
     * @param cacheKey 登录机构
     * @return 返回附加的权限语句
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月15日 下午2:00:12
	 */
	@Override
	@Cacheable(value = "PowerServiceImpl.addRiskPower", key = "#cacheKey")
	public String addRiskPower(PowerConditionDto powerConditionDto, String cacheKey) {
		if (StringUtils.isEmpty(powerConditionDto.getUserCode())) {
            throw new BusinessException("参数\"员工代码\"没有值");
        }
        if (StringUtils.isEmpty(powerConditionDto.getTableName())) {
            throw new BusinessException("参数\"表名\"没有值");
        }
        if (StringUtils.isEmpty(powerConditionDto.getComCode()) 
        		&& StringUtils.isEmpty(powerConditionDto.getGradeCodes())) {
            throw new BusinessException("参数\"登录机构\"和\"登录岗位列表\"必须有一个有值");
        }
		String value = "";
		// 调用具体实现
        value = addRiskPowerImpl(powerConditionDto.getUserCode(), 
        		powerConditionDto.getComCode(), 
        		powerConditionDto.getGradeCodes(), 
        		powerConditionDto.getTableName());
		return value;
	}
	
	/**
	 * @description 可操作险种条件的获取
     * @param userCode 员工代码
     * @param comCode 登录机构
     * @param gradeCodes 登录岗位列表（逗号分割)
     * @param tableName 表名
     * @return 返回附加的权限语句
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月15日 下午2:10:01
	 */
	public String addRiskPowerImpl(String userCode, String comCode, String gradeCodes,
            String tableName) {
        // 根据员工代码、机构代码/岗位代码查询出所有机构员工岗位
        StringBuffer buffer = new StringBuffer();
        String[] gradeCodeArray = StringGyUtils.split(gradeCodes, ",");
        List<UtiUserGradePower> utiUserGradePowerList = utiUserGradePowerDao.findAll(Specifications.<UtiUserGradePower>and()
         		 .eq(StringUtils.isNotEmpty(userCode), "userCode", userCode)
         		 .eq(StringUtils.isNotEmpty(comCode), "comCode", comCode)
         		 .in(StringUtils.isNotEmpty(gradeCodes), "gradeCode", Arrays.asList(gradeCodeArray))
                 .build());
        // 对所有的机构员工岗位进行顺序处理,每个机构员工岗位之间是OR的关系
        for (Iterator<UtiUserGradePower> iter = utiUserGradePowerList.iterator(); iter.hasNext();) {
            UtiUserGradePower utiUserGradePower = iter.next();
            if (StringUtils.isEmpty(utiUserGradePower.getPermitRiskCode())) {
                continue;
            }
            // 如果发现有*则直接返回 AND (1 = 1)
            if (utiUserGradePower.getPermitRiskCode().equals("*")) {
                return " AND (1 = 1) ";
            }
            buffer.append(utiUserGradePower.getPermitRiskCode());
            if (iter.hasNext()) {
                buffer.append(",");
            }
        }
        String[] riskCodeArray = StringGyUtils.split(buffer.toString(), ",");
        if (riskCodeArray.length == 0) {
            return " AND (1 = 0) ";
        }
        // buffer转作result用
        buffer.setLength(0);
        buffer.append(" AND " + tableName + ".RiskCode IN (");
        for (int i = 0; i < riskCodeArray.length; i++) {
            buffer.append("'").append(riskCodeArray[i]).append("'");
            if (i < riskCodeArray.length - 1) {
                buffer.append(",");
            }
        }
        buffer.append(") ");
        return buffer.toString();
    }

	/**
	 * @description 承保系统获登录时校验业务权限，前端不用传险种代码
	 * @param powerConditionDto
	 * @param cacheKey 缓存key
	 * @return ResponseDto
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月20日 上午10:34:11
	 */
	@Override
//	@Cacheable(value = "PowerServiceImpl.checkPowerPrpall", key = "#cacheKey")
	public CheckPowerPrpallResDto checkPowerPrpall(PowerConditionDto powerConditionDto, String cacheKey) {
		if (StringUtils.isEmpty(powerConditionDto.getUserCode())) {
            throw new BusinessException("参数\"员工代码\"不能为空");
        }
        if (StringUtils.isEmpty(powerConditionDto.getComCode())) {
            throw new BusinessException("参数\"登录机构\"不能为空");
        }
		if (powerConditionDto.getTaskCodes() == null || powerConditionDto.getTaskCodes().length() == 0) {
			throw new BusinessException("岗位代码列表不能为空！");
        }
		CheckPowerPrpallResDto responseDto = new CheckPowerPrpallResDto();
		responseDto.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
		responseDto.setResultMsg(ImsErrorEnum.IMS_ERROR.getName());
		RiskQueryConditionDto riskQueryConditionDto = new RiskQueryConditionDto();
		riskQueryConditionDto.setClassCode("05");
		riskQueryConditionDto.setValidStatus("1");
		List<PrpDriskDto> prpDriskDtoList = riskApi.findRiskByCondition(riskQueryConditionDto);
		LOGGER.error("==prpDriskDtoList=="+prpDriskDtoList.size());
		for(PrpDriskDto prpDriskDto : prpDriskDtoList){
			boolean value = false;
			value = this.checkPowerImpl(powerConditionDto.getUserCode(), 
    				powerConditionDto.getComCode(), 
    				powerConditionDto.getGradeCodes(), 
    				powerConditionDto.getTaskCodes(), 
    				prpDriskDto.getRiskCode(), true);
			if(value){
				responseDto.setRiskCode(prpDriskDto.getRiskCode());
				responseDto.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
				responseDto.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
				break;
			}
		}
		return responseDto;
	}
    /**
     * 校验地址权限
     * @author: 田健
     * @date: 2018/2/22 16:49
     * @param url 访问地址
     * @return true或者false
     */
	@Override
    public boolean checkURLPower(String url,String userCode)throws Exception{
	    Boolean flag = false;
	    List<String> list = new ArrayList<>();
        List<UtiUserGrade> utiUserGrades = utiUserGradeDao.findAllByUserCode(userCode);
        if(utiUserGrades.size()>0){
            for(UtiUserGrade utiUserGrade:utiUserGrades){
                list.add(utiUserGrade.getGradeCode());
            }
            List<UtiGradeTask> utiGradeTasks = utiGradeTaskDao.findAllByGradeCode(list);
            for(UtiGradeTask utiGradeTask:utiGradeTasks){
                List<UtiMenu> utiMenus = utiMenuDao.findAllByTaskCodeAnduAndUrl(url,utiGradeTask.getTaskCode());
                if(utiMenus.size()>0){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
