package com.sinosoft.ims.core.kernel.service.impl;

import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.auth.dto.PowerConditionDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.RequestPrpDuserDto;
import com.sinosoft.ims.core.auth.entity.UtiUserGrade;
import com.sinosoft.ims.core.auth.service.PowerService;
import com.sinosoft.ims.core.auth.service.UtiGroupService;
import com.sinosoft.ims.core.kernel.dao.PrpDcompanyDao;
import com.sinosoft.ims.core.kernel.dao.PrpDuserDao;
import com.sinosoft.ims.core.kernel.entity.PrpDcompany;
import com.sinosoft.ims.core.kernel.entity.PrpDcompanyKey;
import com.sinosoft.ims.core.kernel.entity.PrpDuser;
import com.sinosoft.ims.core.kernel.entity.PrpDuserKey;
import com.sinosoft.ims.core.kernel.entity.RPrpDuserInfo;
import com.sinosoft.ims.core.kernel.service.PrpDuserService;
import com.sinosoft.sysframework.exception.BusinessException;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 员工代码表Core接口实现
 */
@Service
public class PrpDuserServiceImpl extends BaseServiceImpl implements PrpDuserService {
	/** log日志 */
//    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDuserServiceImpl.class);
    
    @Autowired
    private PrpDuserDao prpDuserDao;
    @Autowired
    private EntityManager entityManager;
    private String validStatus="1";
    @Autowired
    private UtiGroupService utiGroupService;
    @Autowired
    private PrpDcompanyDao prpDcompanyDao;
    @Autowired
    private PowerService powerService;
    @Autowired
   	private CheckAndLossPeoplePowerCacheUtil checkAndLossPeoplePowerCacheUtil;

       
    /**
     *@description 新增
     *@param
     */
    public void save(PrpDuserDto prpDuserDto) {
        PrpDuser prpDuser = this.convert(prpDuserDto, PrpDuser.class);
        prpDuserDao.save(prpDuser);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String userCode) {
        PrpDuserKey prpDuserKey = new PrpDuserKey(userCode);
        prpDuserDao.delete(prpDuserKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDuserDto prpDuserDto) {
        PrpDuser prpDuser = this.convert(prpDuserDto, PrpDuser.class);
        prpDuserDao.save(prpDuser);
    }

    /**
     * 修改当前用户信息
     *
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     * @author: 汪强
     * @date: 2018/01/17 10:17
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyUserInfo(PrpDuserDto prpDuserDto) {
        String userCode= SinoRequestContext.getCurrentContext().getUserCode();
        if(StringUtils.isEmpty(userCode)){
            throw new DataVerifyException("员工代码userCode入參不能是空！");
        }
        if(StringUtils.isEmpty(prpDuserDto.getIdentifyNumber())||prpDuserDto.getIdentifyNumber().length()>18){
            throw new DataVerifyException("身份证号码错误！");
        }
        PrpDuserKey prpDuserKey = new PrpDuserKey(userCode);
        PrpDuser prpDuser = prpDuserDao.findOne(prpDuserKey);


        prpDuser.setUserName(prpDuserDto.getUserName());
        prpDuser.setSex(prpDuserDto.getSex());
        prpDuser.setIdentifyNumber(prpDuserDto.getIdentifyNumber());
        prpDuser.setMobile(prpDuserDto.getMobile());
        prpDuser.setEmail(prpDuserDto.getEmail());
        prpDuser.setBirthday(prpDuserDto.getBirthday());
        prpDuser.setQQ(prpDuserDto.getQQ());
        prpDuser.setWeChat(prpDuserDto.getWeChat());
        prpDuser.setAddress(prpDuserDto.getAddress());

        prpDuserDao.save(prpDuser);
    }
    /**
     * 按主键查询实体
     * @author: 宋振振
     * @date: 2017/11/17 10:17
     * @param userCode 员工代码
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     */
    public PrpDuserDto queryByPK(String userCode) throws Exception{
        if(StringUtils.isEmpty(userCode)){
            throw new DataVerifyException("员工代码userCode入參不能是空！");
        }
        PrpDuserKey prpDuserKey = new PrpDuserKey(userCode);
        PrpDuser prpDuser = prpDuserDao.findOne(prpDuserKey);
        return this.convert(prpDuser,PrpDuserDto.class);
    }
    /**
     * 归属业务员查询
     * @author: 陈道洋
     * @date: 2017/11/2 9:26
     * @param requestPrpDuserDto 请求参数Dto
     * @return 业务员查询结果数据
     * @throws Exception
     */
    @Override
    public List<PrpDuserDto> queryHandler1CodeInfo(RequestPrpDuserDto requestPrpDuserDto) throws Exception {
        if(StringUtils.isEmpty(requestPrpDuserDto.getLoginComCode())){
            throw new DataVerifyException("归属机构代码不能为空");
        }
        //查询SQL
        StringBuilder Sql = new StringBuilder("SELECT d FROM PrpDuser d WHERE substr(userflag, 3, 1) = '1'");
        Map<String,String> conditions= new HashMap<>();
        Sql.append(" AND d.validStatus='").append(validStatus).append("'");
        //拼接查询条件
        //注释原因 老系统可以输入值模糊查询，新系统现在用下拉框不用模糊查询
//        if(StringUtils.isNotEmpty(requestPrpDuserDto.getUserCode())){
//            Sql.append(" AND d.userCode like:userCode");
//            conditions.put("userCode","%"+requestPrpDuserDto.getUserCode()+"%");
//        }
//        if(StringUtils.isNotEmpty(requestPrpDuserDto.getUserName())){
//            Sql.append(" AND d.userName like:userName");
//            conditions.put("userName","%"+requestPrpDuserDto.getUserName()+"%");
//        }
        AddCodePowerConditionDto addCodePowerConditionDto = new AddCodePowerConditionDto(requestPrpDuserDto.getUserCode(),
                                                                                          requestPrpDuserDto.getLoginComCode(),
                                                                                          requestPrpDuserDto.getLoginGradeCodes(),
                                                                                        "PrpDuser",
                                                                                        "",
                                                                                        "comCode",
                                                                                        requestPrpDuserDto.getRiskCode(),
                                                                                            "d",
                                                                                             false);
        String addCodePower = utiGroupService.addCodePower(addCodePowerConditionDto);
        Sql.append(addCodePower);
        Sql.append(" AND d.comCode=:comCode");
        conditions.put("comCode",requestPrpDuserDto.getComCodeFields());
        Sql.append(" ORDER BY d.userCode");
        //创建查询对象
        Query dataQuery = entityManager.createQuery(Sql.toString());
        for(Map.Entry<String, String> entrySet:conditions.entrySet()){
            dataQuery.setParameter(entrySet.getKey(),entrySet.getValue());
        }
        List<PrpDuser> list = dataQuery.getResultList();
        List<PrpDuserDto> reslist  = new ArrayList<>();
        //转换查询结果
        convertCollection(list,reslist,PrpDuserDto.class);
        return reslist;
    }

    /**
     *
     * @author: 刘曼曼 根据操作人代码查询操作人名称
     * @date: 2017/11/15 12:10
     * @param userCode 操作人代码
     * @param isChinese 中文标识
     * @return 中文或英文
     */
    public String translateCode(String userCode, String isChinese) throws Exception{
        if(StringUtils.isEmpty(userCode)){
            throw new DataVerifyException("用户代码不能为空");
        }
        PrpDuserKey prpDuserKey = new PrpDuserKey(userCode);
        PrpDuser prpDuser = prpDuserDao.findOne(prpDuserKey);
        if(prpDuser != null){
            if(LanguageFlagConstant.CHINESE.equals(isChinese)){//isChinese是true则返回中文名称否则返回英文名称
                return prpDuser.getUserName();
            }else{
                if("".equals(prpDuser.getUserEName()) || prpDuser.getUserEName()==null){//如果英文名称为空则返回中文名称
                    return prpDuser.getUserName();
                }else{
                    return prpDuser.getUserEName();
                }
            }
        }else{
            return "";
        }

    }


    /**
     * 根据操作人代码查询操作人名称集合
     * @author: 刘曼曼
     * @date: 2017/11/24 14:11
     * @param operatorCodes 用户代码集合
     * @return List<String>用户名称集合
     */
    public List<String> queryOperatorName(List<String> operatorCodes)throws Exception{
        if(operatorCodes.size()==0){
            throw new DataVerifyException("用户代码集合不能为空！");
        }

        List<String> operatorNames=prpDuserDao.queryOperatorName(operatorCodes);
        return operatorNames;
    }

    /**
     * * 根据用户代码查询用户名称
     * @author: 田慧
     * @date: 20:09
     * @param operatorCodes 用户代码集合
     * @return  List<String> 用户信息集合
     * @throws Exception
     */
    public List<PrpDuserDto> getOperatorCode(@RequestBody List<String> operatorCodes)throws Exception{
        if(operatorCodes.size()==0){
            throw new DataVerifyException("用户代码集合不能为空！");
        }

        List<PrpDuser> operatorCodeList=prpDuserDao.getOperatorCode(operatorCodes);
        List<PrpDuserDto> prpDuserDtoList = new ArrayList<>();
        this.convertCollection(operatorCodeList,prpDuserDtoList,PrpDuserDto.class);
        return prpDuserDtoList;
    }

    /**
     * 根据多个userCode查询得到list<prpDuser>
     * @author: 何伟东
     * @date: 2017/11/23 14:17
     * @param userCodeList 多个userCode的list集合
     * @return list<prpDuser>
     */
    @Override
    public List<PrpDuserDto> queryByUserCodeList(List<String> userCodeList) {
        if (userCodeList == null || userCodeList.size() < 1) {
            throw new DataVerifyException("用户代码不能为空");
        }
        StringBuilder dataSql = new StringBuilder();
        dataSql.append("SELECT p FROM PrpDuser p WHERE p.userCode IN (:userCodeList)");
        Query dataQuery = entityManager.createQuery(dataSql.toString());
        dataQuery.setParameter("userCodeList",userCodeList);
        List<PrpDuser> prpDuserList = dataQuery.getResultList();
        List<PrpDuserDto> prpDuserDtoList = new ArrayList<>();
        convertCollection(prpDuserList,prpDuserDtoList,PrpDuserDto.class);
        return prpDuserDtoList;
    }

    /**
     *  根据员工名称获取员工代码
     * @author: 田慧
     * @date: 2017/12/4 14:46
     * @param userName 员工名称
     * @return PrpDuserDto的集合
     * @throws Exception
     */
    @Override
    public List<String> queryByUserName(String userName)throws Exception{
        List<String> prpDuserList = prpDuserDao.queryUserCodeByUserName(userName);
        return prpDuserList;
    }
    /**
     * @description:方法功能简述: 根据机构查询查勘、核损处理人员
     * @author 安齐崇
     * @date 2017年12月14日下午9:17:16
     * @param comCode 机构编码
     * @return
     */
    @Override
	public List<PrpDuserDto> queryCheckPerson(String comCode) {
	 String sql = "select * from  prpduser where ValidStatus='1' and comCode in "
	 		+ "( select ComCode from prpdCompany Start With ComCode = :comCode"
			+ " Connect By Prior comCode = uppercomCode and prior comcode != comcode and validstatus='1')";
	 Query query = entityManager.createNativeQuery(sql,PrpDuser.class);
	 query.setParameter("comCode", comCode);
	 List<PrpDuser> prpDuserList = query.getResultList();
	 List<PrpDuserDto> prpDuserDtoList = new ArrayList<>(prpDuserList.size());
	 for(int i = 0;prpDuserList!=null && prpDuserList.size() > 0 && i <prpDuserList.size();i++ ){
		 PrpDuser prpDuser = prpDuserList.get(i);
		 PrpDuserDto  prpDuserDto = new PrpDuserDto();
		 prpDuserDto.setUserCode(prpDuser.getUserCode());
		 prpDuserDto.setUserEName(prpDuser.getUserEName());
		 prpDuserDto.setUserName(prpDuser.getUserName());
		 prpDuserDtoList.add(prpDuserDto);
	 }
		return prpDuserDtoList;
	}

    /**
     * （根据员工代码代码查询对应中文名称）
     * @param userCode 员工代码
     * @return 对应中文名称
     * @author: 董坤
     * @date: 2017/11/18 11:03
     */
    @Override
    public String translateCodeByPK(String userCode) {
        PrpDuserKey prpDuserKey = new PrpDuserKey(userCode);
        PrpDuser prpDuser = prpDuserDao.findOne(prpDuserKey);
        return prpDuser.getUserName();
    }
    /**
     * （查询被维护人）
     * 根据班表机构查询被维护人
     * @author: 孙朋飞
     * @date: 2017/11/20 16:19
     * @param handleDept 班表机构
     * @param queryType 查询类型"1"是查询被维护人，不填查询所有
     * @return 被维护人的集合
     * @throws Exception
     */
    @Override
    public List<PrpDuserDto> queryPrpDuserByHandleDept(String handleDept,String queryType) throws Exception {
        if(StringUtils.isEmpty(handleDept)){
            throw new DataVerifyException("机构不能为空!");
        }
        StringBuilder conditions=new StringBuilder("p.validStatus=:validStatus AND p.comCode in ( select ComCode from prpdCompany Start With ComCode =:ComCode Connect By Prior comCode =  uppercomCode and prior comcode != comcode and validstatus=:validStatus)");
        StringBuilder dataSql=new StringBuilder("select p.userCode,p.comCode,p.userName from PrpDuser p where ");
        dataSql.append(conditions);
        Query nativeQuery = entityManager.createNativeQuery(dataSql.toString(),RPrpDuserInfo.class);
        nativeQuery.setParameter("ComCode",handleDept);
        nativeQuery.setParameter("validStatus",validStatus);
        List<RPrpDuserInfo> resultList = nativeQuery.getResultList();
        List<PrpDuserDto> prpDuserDtoList=new ArrayList<>();
        PrpDuserDto pDuserDto=null;
        if(resultList!=null &&resultList.size()>0){
            for (RPrpDuserInfo rPrpDuserInfo : resultList) {
                pDuserDto=new PrpDuserDto();
                pDuserDto.setUserCode(rPrpDuserInfo.getUserCode());
                pDuserDto.setComCode(rPrpDuserInfo.getComCode());
                pDuserDto.setUserName(rPrpDuserInfo.getUserName());
                prpDuserDtoList.add(pDuserDto);
            }
        }
        if(StringUtils.isNotEmpty(queryType)&& "1".equals(queryType)){
            //被维护人权限校验
            List<PrpDuserDto> prpDuserList=new ArrayList<>();
            if(prpDuserDtoList!=null){
                for (PrpDuserDto prpDuserDto : prpDuserDtoList) {
                    //获取上级的uppercomcode
                    String upperComCode = prpDcompanyDao.findPrpDcompanyByUpperComCode(prpDuserDto.getComCode());
                    //查出每一个被维护人的gradeCodes 多个的话用","拼接
                    StringBuilder gradeConditions=new StringBuilder("select p from UtiUserGrade p where p.comCode=:comCode and p.userCode=:userCode ");
                    Query query = entityManager.createQuery(gradeConditions.toString());
                    query.setParameter("comCode",upperComCode);
                    query.setParameter("userCode",prpDuserDto.getUserCode());
                    List<UtiUserGrade> gradeList = query.getResultList();
                    String gradeCodes="";
                    if(gradeList!=null && gradeList.size()>0){
                        for (int i=0; i<gradeList.size();i++ ){
                            if(i==0){
                                gradeCodes=gradeList.get(0).getGradeCode();
                            }else{
                                gradeCodes+= ","+gradeList.get(i).getGradeCode();
                            }
                        }
                    }
                    PowerConditionDto powerConditionDto = new PowerConditionDto();
                    powerConditionDto.setUserCode(prpDuserDto.getUserCode());
                    powerConditionDto.setComCode(upperComCode);
                    powerConditionDto.setGradeCodes(gradeCodes);
                    //菜单权限
                   powerConditionDto.setTaskCodes(IMSConstant.TASK_CLAIM_CHECK);
                    StringBuffer cacheKey = new StringBuffer();
                    cacheKey.append(powerConditionDto.getUserCode())
                            .append(IMSConstant.DILIMITER).append(powerConditionDto.getComCode())
                            .append(IMSConstant.DILIMITER).append(powerConditionDto.getGradeCodes())
                            .append(IMSConstant.DILIMITER).append(powerConditionDto.getTaskCodes());
                    boolean flag = powerService.checkPower(powerConditionDto, cacheKey.toString());
                    if(flag){
                        prpDuserList.add(prpDuserDto);
                    }
                }
            }
            return prpDuserList;
        }
        return prpDuserDtoList;
    }
    /**
     * 
      * @description 调度页面查询查勘和定损人员双击域
      * @author yk
      * @date 2017年12月22日 上午10:25:59
      * @param   ap里面有comCode和taskCode
      * @return List<PrpDuserDto>用户集合
     */
	@Override
	public List<Map<String, String>> queryCheckAndLossPeople(String comCode, String taskCode) {
		String sql = "Select * From PrpDuser  " + "Where   validStatus='1'  " + "AND comCode in "
				+ "   ( select comCode from PrpDcompany " + "      Start With comCode = ?1 "
				+ "      Connect By Prior comCode =  upperComCode " + "      and prior comCode != comCode "
				+ "      and validStatus='1')";
		Query query = entityManager.createNativeQuery(sql, PrpDuser.class);
		query.setParameter(1, comCode);
		List<PrpDuser> prpDuserList = query.getResultList();
		List<PrpDuserDto> prpDuserDtoList = new ArrayList<>(prpDuserList.size());
		convertCollection(prpDuserList, prpDuserDtoList, PrpDuserDto.class);
		List<PrpDuserDto> prpDuserDtoResultList = new ArrayList<>();
		for (PrpDuserDto prpDuserDto : prpDuserDtoList) {
			String upperComCode = getCenterCode(prpDuserDto.getComCode());
			prpDuserDto.setComCode(upperComCode);
			if (checkAndLossPeoplePowerCacheUtil.checkPowerReturn(prpDuserDto, taskCode)) {
				prpDuserDtoResultList.add(prpDuserDto);
			}
		}
		List<Map<String, String>> returnList = new ArrayList<>();
		for(PrpDuserDto prpDuserDto:prpDuserDtoResultList){
			Map<String, String> map = new HashMap<>();
			map.put("codecode", prpDuserDto.getUserCode());
			map.put("codecname", prpDuserDto.getUserName());
			returnList.add(map);
		}
		
		return returnList;
	}
	/**
	 * 
	  * @description 为要传输的对象prpDuserDto的loginComCode属性赋值
	  * @author yk
	  * @date 2017年12月22日 上午10:27:52
	  * @param iComCode
	  * @return String
	 */
		private String getCenterCode(String iComCode) {
			String centerCode = "";
			if (iComCode.equals(""))
				return "";
			while (true) {
				PrpDcompany prpDcompany = prpDcompanyDao.findOne(new PrpDcompanyKey(iComCode));
				if (prpDcompany == null) {
					throw new com.sinosoft.framework.exception.BusinessException("找不到该出单机构的核算单位");
				}
				if ("1".equals(prpDcompany.getCenterFlag())) {
					centerCode = iComCode;
					break;
				}
				if (iComCode.equals(prpDcompany.getUpperComCode())) {
					throw new com.sinosoft.framework.exception.BusinessException("该出单机构不归属于任何核算单位");
				}
				iComCode = prpDcompany.getUpperComCode();
			}
			return centerCode;
		}
}
