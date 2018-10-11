package com.sinosoft.ims.core.kernel.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.core.kernel.dao.specification.CompanySpecBuilder;
import com.sinosoft.utility.security.Encrypt;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.dms.api.bill.dto.BillConditionDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DateUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.UserDto;
import com.sinosoft.ims.api.kernel.dto.UserImportDto;
import com.sinosoft.ims.api.kernel.dto.UserQueryConditionDto;
import com.sinosoft.ims.core.common.enums.ImsErrorEnum;
import com.sinosoft.ims.core.common.utils.ExcelUtilModel;
import com.sinosoft.ims.core.common.utils.ExportResult;
import com.sinosoft.ims.core.common.utils.PwdUtil;
import com.sinosoft.ims.core.kernel.dao.PrpDcompanyDao;
import com.sinosoft.ims.core.kernel.dao.PrpDuserDao;
import com.sinosoft.ims.core.kernel.entity.PrpDcompany;
import com.sinosoft.ims.core.kernel.entity.PrpDcompanyKey;
import com.sinosoft.ims.core.kernel.entity.PrpDuser;
import com.sinosoft.ims.core.kernel.entity.PrpDuserKey;
import com.sinosoft.ims.core.kernel.entity.UtiIUserIdv;
import com.sinosoft.ims.core.kernel.entity.UtiIUserIdvKey;
import com.sinosoft.ims.core.kernel.service.CompanyService;
import com.sinosoft.ims.core.kernel.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    /** log日志 */
    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

//    @Autowired
//    private UtiIUserIdvDao utiIUserIdvMapper;

//    @Autowired
//    private UtiIUserTypeDao utiIUserTypeMapper;
//
//    @Autowired
//    private UtiISvrDao utiISvrMapper;

    @Autowired
    private PrpDcompanyDao prpDcompanyMapper;
    
    @Autowired
    private PrpDuserDao prpDuserMapper;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDuserDao prpDuserDao;
    
//    @Autowired
//    private CodeApi codeService;
    
//    @Autowired
//    private GradeService gradeService;
    
//    @Autowired
//    private BillApi billService;
    
    @Autowired
    private CompanyService companyService;
// 
//    @Autowired
//    private PowerService powerService;
    
    /**文件上传地址*/
    //@Value("${file.url}uploadFile")
    private String upLoadPath;
    
    /**文件下载地址*/
    //@Value("${file.url}downloadFile")
    private String downLoadPath;

    /**
     * @description 用户信息查询列表（分页）
     * @param queryDto
     * @return PageInfo<UserIdvDto>
     * @
     * @author chengzhuo
     * @date 2016年9月27日下午4:28:54
     */
    @Override
    public PageInfo<PrpDuserDto> queryUserPage(UserQueryConditionDto queryDto)  {
//        // 设置排序
//        if (StringUtils.isEmpty(queryDto.getOrderByClause())){
//            queryDto.setOrderByClause("u.usercode asc");
//        }else{
//            String orderBy = queryDto.getOrderByClause();
//            String[] arr = orderBy.split(",");
//            for ( int i=0;i<arr.length;i++){
//                orderBy += "u." + arr[i];
//                if (i==arr.length -1){
//
//                }else{
//                    orderBy  += ",";
//                }
//            }
//            queryDto.setOrderByClause(orderBy);
//        }
//        //增加权限查询条件
//        PowerConditionDto powerConditionDto = new PowerConditionDto();
//        powerConditionDto.setBaseDto(queryDto);
//        powerConditionDto.setUserCode(queryDto.getGlobalUserCode());
//        powerConditionDto.setTableName(PowerConstants.PRPDCOMPANY);
//        powerConditionDto.setOuterTableName("u");
//        String powerSql = powerService.getPowerCompanyCondition(powerConditionDto);
//        queryDto.setPowerCondition(powerSql);
//        //分页查询

    	LOGGER.error(queryDto.getUserCode());
        PageInfo<PrpDuserDto> page = queryPageInfoByCondition(queryDto);
//
//        NewCodeQueryConditionDto newCodeQueryConditionDto = new NewCodeQueryConditionDto();
//        PrpDNewCodeDto prpDNewCodeDto = new PrpDNewCodeDto();
//        //证件类型转码
//        for(int i=0;i<page.getList().size();i++){
//            String identityType ="";
//            identityType = page.getList().get(i).getIdentityType();
//            if(StringUtils.isEmpty(identityType) ){
//            	continue;
//            }
//            newCodeQueryConditionDto.setCodeType("IdentifyType");
//            newCodeQueryConditionDto.setCodeCode(identityType);
//            try
//            {
//                prpDNewCodeDto = codeService.transCodeCodeReturnCodeName(newCodeQueryConditionDto);
//            }
//            catch (Exception e)
//            {
//                throw new BusinessException("证件类型转码发生异常！" + newCodeQueryConditionDto.getCodeCode());
//            }
//            page.getList().get(i).setIdentityType(prpDNewCodeDto.getCodeCName());
//        }
//        page.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
//        page.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
        return page;
    }

    private PageInfo<PrpDuserDto> queryPageInfoByCondition(UserQueryConditionDto queryDto)
    {
        PageInfo<PrpDuserDto> pageInfo = new PageInfo<PrpDuserDto>();
        Pageable page = this.getPageable(queryDto);
        Page<PrpDuser> prpDuserPage = prpDuserMapper.findAll(genCondition(queryDto), page);
        pageInfo = this.convertPage(prpDuserPage, PrpDuserDto.class);
        return pageInfo;
    }

    /**
     * @description 单个用户增添服务
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月20日上午9:20:46
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDto saveUser(PrpDuserDto userDto)  {
        //2017年8月3日17:59:51
        ResponseDto result = new ResponseDto();
        PrpDuser prpDuser = new PrpDuser();
        //1.1获取管理员用户的机构类型
        String comCode = userDto.getComCode();
        PrpDcompanyKey prpDCompanyKey = new PrpDcompanyKey();
        prpDCompanyKey.setComCode(comCode);
        PrpDcompany prpDCompany = new PrpDcompany();
        prpDCompany = prpDcompanyMapper.findOne(prpDCompanyKey);
        if(prpDCompany == null ){
            throw new BusinessException("保险公司代码 "+ comCode + " 不存在！");
        }
        // 1.2获取密码&密码md5加密
        String passWord = userDto.getPassword();
        String md5wd = PwdUtil.md5(passWord);
        // 1.3生成当前时间
        Date date = new Date();
        DateTime today = new DateTime(new Date(), DateTime.YEAR_TO_DAY);
        // 1.4处理密码过期日期
        Date newDate = DateUtils.getNextNDate(date, IMSConstant.PASSWORD_EXPIRE_DATES);
//        // 2.1查询UtiIsvr表中所有的服务，遍历生成AccountDtoList
//        //utiISvrExample.createCriteria();
//        svrCodeList = utiISvrMapper.findBySqlSelsvrCode();
//        // 2.2判断svrCode是否有服务
//        if (svrCodeList == null || svrCodeList.size() == 0) {
//            result.setResultMsg("未查询到服务");
//            result.setResultCode(ImsErrorEnum.IMS_ERROR.getName());
//            return result;
//        }

//        // 2.3判断userDto是否包含accountDto
//
//            for (int i = 0; i < svrCodeList.size(); i++) {
//                accountDto = new AccountDto();
//                accountDtoList.add(accountDto);
//            }
        prpDuser = this.convert(userDto, PrpDuser.class);
        prpDuser.setPassword(md5wd);
        prpDuser.setPasswordSetDate(today);
        prpDuser.setPasswordExpireDate(newDate);
        prpDuser.setCreatedTime(date);
        prpDuser.setCreatedBy(SinoRequestContext.getCurrentContext().getUserCode());
        prpDuser.setUpdatedTime(date);
        prpDuser.setUpdatedBy(SinoRequestContext.getCurrentContext().getUserCode());
        prpDuser.setValidStatus("1");
        prpDuserMapper.save(prpDuser);

//        for (int i = 0; i < accountDtoList.size(); i++) {
//            UtiIAccount utiIAccount =convert(userDto, UtiIAccount.class);
//            utiIAccount.setAccCode(svrCodeList.get(i) + strUserCode);
//            utiIAccount.setPassWord(md5wd);
//            utiIAccount.setUserCode(strUserCode);
//            utiIAccount.setSvrCode(svrCodeList.get(i));
//            utiIAccount.setUserName(userDto.getSalesManName());
//            utiIAccount.setAccName(userDto.getSalesManName());
//            utiIAccount.setCreateDate(date);
//            //utiIAccount.setCreatorCode(userDto.getGlobalUserCode());
//            utiIAccountList.add(utiIAccount);
//        }
//
//        utiIUserType=convert(userDto, UtiIUserType.class);
//        utiIUserType.setUserCode(strUserCode);
//        utiIUserType.setUserName(userDto.getSalesManName());
//        utiIUserType.setUserType("02");
//        utiIUserType.setCreateDate(date);
//        //utiIUserType.setCreatorCode(userDto.getGlobalUserCode());
//
//        // 6、用户重复性校验
//        UtiIUserIdvKey userKey = new UtiIUserIdvKey();
//        userKey.setUserCode(strUserCode);
//        //UtiIUserIdv utiIUserIdvQuery = utiIUserIdvMapper.selectByPrimaryKey(userKey);
//        UtiIUserIdv utiIUserIdvQuery = utiIUserIdvMapper.findOne(userKey);
//        if (utiIUserIdvQuery != null) {
//            result.setResultMsg(utiIUserIdvQuery.getUserCode() + "用户重复校验失败");
//            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
//            return result;
//        }
//        // 7、保存用户信息
////        utiIUserMapper.insert(utiIUser);
//        utiIUserMapper.save(utiIUser);
////        utiIUserIdvMapper.insert(utiIUserIdv);
//        utiIUserIdvMapper.save(utiIUserIdv);
//        for (int index = 0; index < utiIAccountList.size(); index++) {
////            utilAccoutnMapper.insert(utiIAccountList.get(index));
//            utilAccoutnMapper.save(utiIAccountList.get(index));
//        }
////        utiIUserTypeMapper.insert(utiIUserType);
//        utiIUserTypeMapper.save(utiIUserType);
//        // 8、批量上传调用岗位配置服务
//        List<String> gradeIds =userDto.getGradeIds();
//        gradeIds.add("0000000000000000006");
//        userGradeConditionDto.setUserCode(strUserCode);
//        userGradeConditionDto.setGradeIds(gradeIds);
//        //userGradeConditionDto.setGlobalUserCode(userDto.getGlobalUserCode());
//        gradeService.configUserGrade(userGradeConditionDto);

        result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
        result.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
        return result;
    }

    /**
     * @description 修改用户个人信息
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月20日上午9:21:00
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDto updateUser(PrpDuserDto userDto)  {
        //2017年8月3日17:59:36
        ResponseDto result = new ResponseDto();
        PrpDuser prpDuser = new PrpDuser();
        PrpDuserDto oldUserDto = this.queryUserInfo(userDto.getUserCode());
        Date date = new Date();
        Date newDate=DateUtils.getNextNDate(date,IMSConstant.PASSWORD_EXPIRE_DATES);
        // 1.类型转换
        prpDuser = this.convert(userDto, PrpDuser.class);
        //1.1设置必须值
        prpDuser.setUpdatedBy(SinoRequestContext.getCurrentContext().getUserCode());
        prpDuser.setUpdatedTime(date);
        prpDuser.setPasswordExpireDate(newDate);
        //1.2密码发生变化
        if (oldUserDto.getPassword().equals("") || !oldUserDto.getPassword().equals(userDto.getPassword())) {
        	DateTime today = new DateTime(new Date(), DateTime.YEAR_TO_DAY);
        	//TODO 技术中心写的，userDto中没getNewPassword
        	//String password = userDto.getNewPassword();
            String password = null;
            String md5Pwd = PwdUtil.md5(password);
            prpDuser.setPassword(md5Pwd);
            prpDuser.setPasswordSetDate(today);
        }
//        // 2.调用岗位配置服务
//        userGradeConditionDto.setUserCode(userCode);
//        userGradeConditionDto.setGradeIds(userDto.getGradeIds());
//        if(userDto.getGradeIds()==null){
//        	result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
//        	result.setResultMsg("请配置岗位");
//        	return result;
//        }
//		//userGradeConditionDto.setGlobalUserCode(userDto.getGlobalUserCode());
//        gradeService.configUserGrade(userGradeConditionDto);
        // 3.保存用户信息
        prpDuserMapper.save(prpDuser);
        result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
        result.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
        return result;
    }

    /**
     * @description 判断该账号能否修改密码
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月25日下午2:14:21
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDto checkUpdatePasswd(UserDto userDto)  {
        ResponseDto result = new ResponseDto();
        UtiIUserIdv utiIUserIdv = new UtiIUserIdv();
        UtiIUserIdvKey key = new UtiIUserIdvKey();
        String StrUserCode = userDto.getUserCode();

        // 1、根据userCode获取该账户
        //2017年8月3日17:59:24
        key.setUserCode(StrUserCode);
//        utiIUserIdv = utiIUserIdvMapper.findOne(key);
//        if (utiIUserIdv == null) {
//            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
//            result.setResultMsg(ImsErrorEnum.IMS_ERROR.getName());
//            return result;
//        }
        String modifyPasswdFlag = utiIUserIdv.getModifyPasswdFlag();

        // 2.判断该账户能否修改密码
        if (modifyPasswdFlag == "0" || modifyPasswdFlag == null) {
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            result.setResultMsg(ImsErrorEnum.IMS_ERROR.getName());
            return result;
        }
        result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
        result.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
        return result;
    }

    /**
     * @description 密码校验（修改密码时密码校验）
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月20日上午9:21:11
     */
    @Override
    public ResponseDto checkeUserPasswd(PrpDuserDto userDto)  {
        ResponseDto result = new ResponseDto();
        // 1.获取传入密码&加密
        String inputPassword = userDto.getPassword();
        String md5Pwd = PwdUtil.md5(inputPassword);

        // 2.获取该账号的密码
        String userCode = userDto.getUserCode();
        PrpDuserKey prpDuserKey = new PrpDuserKey();
        // 设置账号userCode
        prpDuserKey.setUserCode(userCode);
        // 获取用户信息
        PrpDuser prpDuser = prpDuserMapper.findOne(prpDuserKey);
        if (prpDuser == null) {
        	result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            result.setResultMsg("账号不存在");
            return result;
        } else {
            String DBpassword = prpDuser.getPassword();
            // 3.判断密码是否正确
            if (DBpassword.equals(md5Pwd)) {
                result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
                result.setResultMsg("密码正确");
                return result;
            }
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            result.setResultMsg("密码错误");
            return result;
        }
    }

    /**
     * @description 修改密码服务
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月20日上午9:21:33
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDto updatePasswd(PrpDuserDto userDto)  {
        ResponseDto result = new ResponseDto();
        String userCode = userDto.getUserCode();
        Date date = new Date();
        Date newDate = DateUtils.getNextNDate(date, IMSConstant.PASSWORD_EXPIRE_DATES);
        String password = new String();
        PrpDuserKey prpDuserKey = new PrpDuserKey();
		prpDuserKey.setUserCode(userCode);
		PrpDuser prpDuser =  prpDuserMapper.findOne(prpDuserKey);
		//1、校验账号是否存在
		if(prpDuser == null || prpDuser.getUserCode() == null){
			result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
			result.setResultMsg("该登录账号不存在");
			return result;
		}
		
        //获取密码&加密
        //TODO 技术中心写的我们不用
       // password = userDto.getNewPassword();
        String md5Pwd = PwdUtil.md5(password);
        //2、校验新密码是否存在
        if(password == null){
            result.setResultMsg("请输入密码");
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            return result;
        }
        //3、更新用户密码
        prpDuser.setPassword(md5Pwd);
        prpDuser.setPasswordSetDate(date);
        prpDuser.setPasswordExpireDate(newDate);
        prpDuser.setUpdatedTime(new Date());
        prpDuser.setUpdatedBy(SinoRequestContext.getCurrentContext().getUserCode());
        prpDuserMapper.save(prpDuser);

        result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
        result.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
        return result;
    }

    /**
     * @description 根据用户代码查询用户
     * @param userCode
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月20日上午9:21:58
     */
    @Override
    public PrpDuserDto queryUserInfo(String userCode)  {
    	if(StringUtils.isEmpty(userCode)){
    		throw new BusinessException("用户代码不能为空！");
        }
    	PrpDuserKey prpDuserKey = new PrpDuserKey();
        // 设置账号userCode
        prpDuserKey.setUserCode(userCode);
        // 获取用户信息
        PrpDuser prpDuser = prpDuserMapper.findOne(prpDuserKey);
        return convert(prpDuser, PrpDuserDto.class);
    }

    
    /**
     * @description 用户信息批量下载功能
     * @param userDto
     * @return
     * @
     * @author hzhongkai
     * @date 2016年10月11日下午2:13:17
     */
    @Override
    public  Map<String, String> downloadUserInfo(PrpDuserDto userDto) 
    {
        // 查询数据列表
        List<Map<String, Object>> list = new ArrayList<>();//utiIUserIdvMapper.downloadUserInfo();
        // 组装用户岗位信息/证件类型
        assembleGradeAndIdType(list);
        // 生成栏位
        LinkedHashMap<String, String> columnKeys = getColumnKeys();
        // 生成HSSFWorkbook
        ExcelUtilModel excelModel = new ExcelUtilModel();
        String sheetName = "用户信息清单";
        String title = "用户信息清单  " + DateUtils.dateToStr(new Date());
        HSSFWorkbook wb = excelModel.creatXlsWithList(sheetName, title, columnKeys, list);
        // 创建Excel文件,并上传到服务器
        Map<String,String> otherParams=new HashMap<String,String>();
        //otherParams.put("userCode",userDto.getGlobalUserCode());
        otherParams.put("systemId", "agri/tempfile");
        otherParams.put("bussType", "USERINFO");
        String fileName = "D:\\用户信息清单.xls";
        Map<String, String> map = null;
        try
        {
            map = excelModel.createExcelFile(fileName, wb,upLoadPath,otherParams);
        }
        catch (IOException e)
        {
            throw new BusinessException("创建用户信息清单文件发生异常！");
        }
        return map;
    }


    /**
     * @description 组装用户岗位信息/转换证件类型
     * @param list
     * @
     * @author hzhongkai
     * @date 2016年10月11日下午6:53:25
     */
//    @SuppressWarnings({"unchecked", "rawtypes"})
    private void assembleGradeAndIdType(List<Map<String, Object>> list)  
    {
//        GradeQueryConditionDto gradeQueryConditionDto = null;
//        NewCodeQueryConditionDto newCodeQueryConditionDto = null;
//        for(Map m : list){
//            // 查询岗位信息
//            gradeQueryConditionDto =new GradeQueryConditionDto();
//            gradeQueryConditionDto.setUserCode((String)m.get("USERCODE")); 
//            List<SaaGradeDto> gradeList =  gradeService.queryGradeList(gradeQueryConditionDto);
//            if(gradeList !=null && gradeList.size() > 0){
//                String grade ="";
//                for( SaaGradeDto gradeDto :gradeList ){
//                    grade += gradeDto.getGradeCode()+"-"+gradeDto.getGradeCName() + ",";
//                }
//                m.put("GRADE", grade.substring(0, grade.length()-1));
//            }
//            
//            //转换证件类型
//            if(m.get("IDENTITYTYPE") != null ){
//                newCodeQueryConditionDto = new NewCodeQueryConditionDto();
//                newCodeQueryConditionDto.setCodeType("PersonalIdentifyType");
//                newCodeQueryConditionDto.setCodeCode((String)m.get("IDENTITYTYPE"));
//                PrpDNewCodeDto prpDNewCodeDto = null;
//                try
//                {
//                    prpDNewCodeDto = codeService.transCodeCodeReturnCodeName(newCodeQueryConditionDto);
//                }
//                catch (Exception e)
//                {
//                    throw new BusinessException("创建用户信息清单文件发生异常！");
//                }
//                if(prpDNewCodeDto != null ){
//                    String idType = (String)m.get("IDENTITYTYPE") + "-" + prpDNewCodeDto.getCodeCName();
//                    m.put("IDENTITYTYPE",idType);
//                }
//            }
//        }
    }



    
    /**
     * @description 组装栏位信息
     * @return
     * @author hzhongkai
     * @date 2016年10月11日下午6:56:59
     */
    private LinkedHashMap<String, String> getColumnKeys()
    {
        LinkedHashMap<String, String> columnKeys = new LinkedHashMap<String, String>();
        columnKeys.put(ExcelUtilModel.SERICALNUMBER, "序号");//0
        columnKeys.put(ExportResult.USERCODE ,"登录账户");  //1
        columnKeys.put(ExportResult.PASSWORD ,"登录密码");  //2
        columnKeys.put(ExportResult.GRADE ,"岗位");   //3
        columnKeys.put(ExportResult.SALESMANCODE ,"业务人员代码");    //4
        columnKeys.put(ExportResult.SALESMANNAME ,"业务人员名称");    //5
        columnKeys.put(ExportResult.PROVICECOMCODE ,"所属省级机构");  //6
        columnKeys.put(ExportResult.CITYCOMCODE ,"所属分支机构代码");   //7
        columnKeys.put(ExportResult.CITYCOMNAME ,"所属分支机构名称");   //8
        columnKeys.put(ExportResult.IDENTITYTYPE ,"证件类型");  //9
        columnKeys.put(ExportResult.IDENTIFYNUMBER ,"证件号码");    //10
        columnKeys.put(ExportResult.MOBILE,"手机号码"); //11
        columnKeys.put(ExportResult.EMAIL,"电子邮件");  //12
        columnKeys.put(ExportResult.MODIFYPASSWDFLAG ,"是否允许用户自行修改密码");  //13
        return columnKeys;
    }

    /**
     * @description 批量导入用户信息
     * @return ResponseDto
     * @
     * @author chengzhuo
     * @date 2016年9月27日下午4:30:05
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDto importUserInfo(UserImportDto userImportDto)  {
        ResponseDto result = new ResponseDto();
        
        if(StringUtils.isEmpty(userImportDto.getFileId())){
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            result.setResultMsg("fileId不允许为空！");
            return result;
        }
        
        ExcelUtilModel excelUtil = new ExcelUtilModel();
        
        String excelPath = excelUtil.downLoadFromFileServ(downLoadPath, "用户信息列表", userImportDto.getFileId());
        
        //分析Excel表格
        List<UserDto> list = analysUserExcel(excelPath,userImportDto.getGradeIds());
        
        BillConditionDto billConditionDto = new BillConditionDto();
        
        //解析每一个用户
        for(int i=0;i<list.size();i++){
            //获取保险公司三位代码
            String proviceComCode = list.get(i).getProviceComCode();
            String headComcode = list.get(i).getHeadComCode();
            String subComCode = "";
            if(!StringUtils.isEmpty(headComcode)){
                subComCode = headComcode.substring(3, 6);
            }else if (!StringUtils.isEmpty(proviceComCode)){
                subComCode = proviceComCode.substring(3, 6);
            }else{
                result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
                result.setResultMsg("所属保险公司或所属省级机构不允许为空！");
                return result;
            }
            //生成不可逆序号
            Long serialNo = null;
            try
            {
                billConditionDto.setBillType("imsUtiIUserIdv"+subComCode+"_");
//                serialNo = billService.getSerialNo(billConditionDto).getSerialNo();
            }
            catch (Exception e)
            {
                throw new BusinessException("生成序号发生异常！");
            }
            String str = String.format("%05d", serialNo);  
            //设置userCode参数
            String userCode = subComCode+str;
            list.get(i).setUserCode(userCode);
            //设置密码
            list.get(i).setPassWord("00000000");            
           // list.get(i).setGlobalUserCode(userImportDto.getGlobalUserCode());
            //调用保存服务
            //result = saveUser(list.get(i));
            //判断是否全部保存成功
            if(ImsErrorEnum.IMS_ERROR.getCode()== result.getResultCode()){
                return result;
            }
        }
        result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
        result.setResultMsg("批量保存成功");
        return result;
    }

    /**
    * @description 解析Excel
    * @param excelPath
    * @return
    * @author chengzhuo
     * @param gradeIds 
    * @date 2016年10月12日下午5:57:39
    */
    public  List<UserDto> analysUserExcel(String excelPath, List<String> gradeIds) {
        List<UserDto> list = new ArrayList<UserDto>();
        if ( StringUtils.isEmpty(excelPath)){
            return list;
        }
        try {
            UserDto userDto = null;
            FileInputStream fs = new FileInputStream(excelPath);                            
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            // 得到总行数
            int rowNum = sheet.getLastRowNum();
            HSSFRow row = sheet.getRow(0);
            StringBuilder sb = null;
            // 正文内容应该从第二行开始,第一行为表头的标题
            for (int i = 1; i <= rowNum; i++) {
                row = sheet.getRow(i);
                if (row !=null){
                    sb =new StringBuilder();
                    for (int j = 0;j<row.getLastCellNum();j++){
                        sb.append(getCellFormatValue(row.getCell(j)).trim());
                    }
                    //该行为空行 跳出本次循环
                    if(sb.length()<=0){
                        continue;
                    }
                   
                    userDto = new UserDto();
                    userDto.setSalesManCode(getCellFormatValue(row.getCell(0)));
                    userDto.setSalesManName(getCellFormatValue(row.getCell(1)));
                    userDto.setHeadComCode(getCellFormatValue(row.getCell(2)));
                    userDto.setProviceComCode(getCellFormatValue(row.getCell(3)));
                    userDto.setCityComCode(getCellFormatValue(row.getCell(4)));
                    userDto.setCityComName(getCellFormatValue(row.getCell(5)));
                    if(row.getCell(6)!=null&&!"".equals(row.getCell(6))){
                    	userDto.setIdentityType(getCellFormatValue(row.getCell(6)).substring(0, 2));
                    }
                    userDto.setIdentifyNumber(getCellFormatValue(row.getCell(7)));
                    userDto.setMobile(getCellFormatValue(row.getCell(8)));
                    userDto.setEmail(getCellFormatValue(row.getCell(9)));
                    userDto.setModifyPasswdFlag("是".equals(getCellFormatValue(row.getCell(10)))?"1":"0");
                    userDto.setGradeIds(gradeIds);
                    userDto.setShareFlag("0");
                    list.add(userDto);
                }else{
                    continue;
                }
            }
            
          //判断各行数据，如果有错给出提示
//            checkUserList(list);
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;  
    }

    /**
     * @description 机构获取服务(根据用户获取该用户可操作的机构服务）
     * @param userDto
     * @return List<PrpDCompanyDto>
     * @author chengzhuo
     * @date 2016年9月23日下午4:44:39
     */
    @Override
    public List<PrpDcompanyDto> queryUserComCodeService(PrpDuserDto userDto)  {
    	PrpDuser prpDuser = new PrpDuser();
    	PrpDuserKey prpDuserKey = new PrpDuserKey();
        List<PrpDcompanyDto> prpDCompanyDtoList = new ArrayList<PrpDcompanyDto>();
        // 获取usercode查询出该用户所属机构
        String userCode = userDto.getUserCode();
        prpDuserKey.setUserCode(userCode);
        prpDuser = prpDuserMapper.findOne(prpDuserKey);
        if(prpDuser == null){
        	throw new BusinessException("用户信息不存在！");
        }
        String comCode = prpDuser.getComCode().trim();
        // 查询该用户的所属机构权限
        prpDCompanyDtoList = companyService.getAllLowerCompany(comCode);
        return prpDCompanyDtoList;
    }

	
	/**
	 * @description 获取所属保险公司
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年10月07日下午9:15:58
	 */
	@Override
	public PrpDcompanyDto queryHeadComCodeService(PrpDuserDto userDto)  {
		PrpDcompanyKey prpDCompanyKey = new PrpDcompanyKey();
		PrpDcompany prpDCompany = new PrpDcompany();
		PrpDcompanyDto prpDCompanyDto  = new PrpDcompanyDto ();

		//1、获取用户信息
		PrpDuserKey prpDuserKey = new PrpDuserKey();
        String userCode = userDto.getUserCode();
        // 设置账号userCode
        prpDuserKey.setUserCode(userCode);
        // 获取用户信息
        PrpDuser prpDuser = prpDuserMapper.findOne(prpDuserKey);
		if(prpDuser == null){
		    throw new BusinessException("用户不存在！");
		}
		//2、获取所属总公司
		String comCode = userDto.getComCode();
		prpDCompanyKey.setComCode(comCode);
		prpDCompany = prpDcompanyMapper.findOne(prpDCompanyKey);
        prpDCompanyDto = convert(prpDCompany, PrpDcompanyDto.class);
	
		return prpDCompanyDto;
	}


    /**
     * @description 根据当前机构查询省级机构
     * @param userDto
     * @return List<PrpDCompanyDto>
     * @author chengzhuo
     * @date 2016年9月23日下午4:43:17
     */
    @Override
    public List<PrpDcompanyDto> queryDownComCodeService(UserDto userDto)  {

        List<PrpDcompanyDto> prpDCompanyDtoList = new ArrayList<PrpDcompanyDto>();
        List<PrpDcompany> prpDCompanyList = new ArrayList<PrpDcompany>();
        
        Map<String, Object> params = new HashMap<String, Object>();
        UtiIUserIdv utiIUserIdv = new UtiIUserIdv();
        UtiIUserIdvKey utiIUserIdvKey = new UtiIUserIdvKey();
        //1、获取总机构
        //utiIUserIdvKey.setUserCode(userDto.getGlobalUserCode());
        utiIUserIdvKey.setUserCode(SinoRequestContext.getCurrentContext().getUserCode());
//        utiIUserIdv = utiIUserIdvMapper.findOne(utiIUserIdvKey);
//        if(utiIUserIdv==null){
//            throw new BusinessException("该用户不存在！ userCode= " + userDto.getUserCode());
//        }
        String upperComCode = utiIUserIdv.getHeadComCode();
        
        //2、获取comType
        //2017年8月3日18:01:12
        PrpDcompanyKey prpDCompanyKey = new PrpDcompanyKey();
        prpDCompanyKey.setComCode(upperComCode);
        PrpDcompany prpDCompany = new PrpDcompany();
        prpDCompany = prpDcompanyMapper.findOne(prpDCompanyKey);
//        prpDCompany = prpDCompanyMapper .selectByPrimaryKey(prpDCompanyKey);
        String comType = prpDCompany.getComType();
        
        //3、调取查询方法
        params.put("comType", comType);
        prpDCompanyList = prpDcompanyMapper.findAll(Specifications.<PrpDcompany>and()
                .eq("upperComCode", upperComCode)
                .eq("validStatus", userDto.getValidStatus()).build());
        
        //4、获取省级机构
        for (int i = 0; i < prpDCompanyList.size(); i++) {
            prpDCompanyDtoList.add(convert(prpDCompanyList.get(i), PrpDcompanyDto.class));
        }
        return prpDCompanyDtoList;
    }
    

    /**
     * @description 封装查询条件
     * @param userQueryConditionDto
     * @return UtiIUserIdvExample
     * @author chengzhuo
     * @date 2016年9月26日下午9:15:58
     */
//    private UtiIUserIdvExample generateUserCriteria(UserQueryConditionDto userQueryConditionDto) {
//        // 封装请求对象
//        UtiIUserIdvExample utiIUserIdvExample = new UtiIUserIdvExample();
//        UtiIUserIdvExample.Criteria criteria = utiIUserIdvExample.createCriteria();
//
//        // 登陆账户
//        if (!StringUtils.isBlank(userQueryConditionDto.getUserCode())) {
//            criteria.andUserCodeEqualTo(userQueryConditionDto.getUserCode());
//        }
//        // 所属分支机构
//        if (!StringUtils.isBlank(userQueryConditionDto.getCityComCode())) {
//            criteria.andCityComCodeEqualTo(userQueryConditionDto.getCityComCode());
//        }
//        // 业务人员姓名，支持模糊查询
//        if (!StringUtils.isBlank(userQueryConditionDto.getSalesManName())) {
//            criteria.andSalesManNameLike("%" + userQueryConditionDto.getSalesManName() + "%");
//        }
//        // 所属省级机构
//        if (!StringUtils.isBlank(userQueryConditionDto.getProviceComCode())) {
//            criteria.andProviceComCodeEqualTo(userQueryConditionDto.getProviceComCode());
//        }
//        // 权限机构限制
//        if(!StringUtils.isBlank(userQueryConditionDto.getComCode())){
//        	criteria.andHeadComCodeEqualTo(userQueryConditionDto.getComCode());
//        }
//        utiIUserIdvExample.setOrderByClause("substr(usercode,0,1)  asc");
//        return utiIUserIdvExample;
//    }
    
    /**
    * @description 用户重复性校验
    * @param userDto
    * @return ResponseDto
    * @author chengzhuo
    * @date 2016年10月8日下午2:04:57
    */
    @Override
    public ResponseDto checkRepeatUserCode(PrpDuserDto userDto) {
    	ResponseDto result = new ResponseDto();
        String userCode = userDto.getUserCode();
        PrpDuserKey prpDuserKey = new PrpDuserKey();
        // 设置账号userCode
        prpDuserKey.setUserCode(userCode);
        // 获取用户信息
        PrpDuser prpDuser = prpDuserMapper.findOne(prpDuserKey);

        if (prpDuser != null) {
            result.setResultMsg("该用户已存在,请修改");
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            return result;
        }
        result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
        result.setResultMsg("可以使用该用户");
        return result;
    }
    /**
     * 根据HSSFCell类型设置数据  (Excel中数据)
     * @param cell
     * @return
     */
    private  String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式
                    
                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                    Date date = cell.getDateCellValue();
                    cellvalue =  DateUtils.dateToStr(date);
                    
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = "";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue.trim();

    }
    
    /**
     * @description 获取当前用户所属机构
     * @param userDto
     * @return ResponseDto
     * @
     * @author chengzhuo
     * @date 2016年10月8日下午2:04:57
     */
    @Override
    public PrpDcompanyDto queryUserCompany(PrpDuserDto userDto)   {
    	//获取用户的comcode
    	String strComCode = userDto.getComCode();
    	if(StringUtils.isBlank(strComCode)){
        	strComCode = queryUserInfo(userDto.getUserCode()).getComCode();
        }
    	//校验comcode是否为空
        if(StringUtils.isBlank(strComCode)){
        	throw new BusinessException("没有找到【"+userDto.getUserName()+"】对应的归属机构！");
        }
        // 获取用户所属机构
        PrpDcompanyDto prpDCompanyDto = null;
        PrpDcompanyKey prpDcompanyKey = new PrpDcompanyKey();
        prpDcompanyKey.setComCode(strComCode);
        PrpDcompany prpDcompany = prpDcompanyMapper.findOne(prpDcompanyKey);
        prpDCompanyDto = this.convert(prpDcompany, PrpDcompanyDto.class);
        return prpDCompanyDto;
    }
    /**
     * @description 业务员查询服务
     * @param userDto
     * @return List<PrpDuserDto>
     * @throws Exception
     * @author lishaoru
     * @since 2017年9月23日 15:30:58
     */
    @Override
    public List<PrpDuserDto> getHandlerInfo(PrpDuserDto userDto) throws Exception {
        //处理入参
        userDto = this.dealRequestInfo(userDto);
        //组织查询条件
        Map conditionMap = this.genetateQueryCondition(userDto);
        //执行查询语句
        List<PrpDuserDto> prpDuserDtos= this.executeQuery(conditionMap,userDto);
        return prpDuserDtos;
    }
    /**
     * @description 执行查询拼装完的查询sql 返回PageInfo对象
     * @param conditionMap
     * @param userDto
     * @return pageInfo
     * @author lishaoru
     * @throws Exception
     * @date 2017年9月20日 17:56:12
     */
    private  List<PrpDuserDto> executeQuery(Map conditionMap,PrpDuserDto userDto){
        List<PrpDuserDto> prpDuserDtoList = new ArrayList<PrpDuserDto>();
        String strQuerySql =  (String) conditionMap.get("querySql");
        List<String>  paramList = (List<String>) conditionMap.get("paramList");
        javax.persistence.Query dataQuery= entityManager.createQuery(strQuerySql);
        if (paramList.size() > 0 ){
            for ( int i = 0 ; i <paramList.size() ;i++ ){
                dataQuery.setParameter(i, paramList.get(i));
            }
        }
        List<Object []> objList = dataQuery.getResultList();//获取查询结果集
        if (objList != null && objList.size() > 0 ){
            Object[] arrList = null ;
            for (int k = 0 ; k < objList.size(); k++ ){//将结果集信息组装到List<PrpDuserDto>中
                PrpDuserDto prpDuserDto = new PrpDuserDto();
                arrList = objList.get(k);
                prpDuserDto.setUserCode(arrList[0]==null?"":arrList[0].toString());
                prpDuserDto.setUserName(arrList[1]==null?"":arrList[1].toString());
                prpDuserDto.setComCode(arrList[2]==null?"":arrList[2].toString());
                //TODO 技术中心写的，我们不用
               // prpDuserDto.setComName(arrList[3]==null?"":arrList[3].toString());
                prpDuserDtoList.add(prpDuserDto);
            }
        }

        return  prpDuserDtoList;
    }
    /**
     * @description 出单员信息查询 组织查询sql
     * @param userDto
     * @return Map<String ,List>
     * @author lishaoru
     * @throws Exception
     * @date 2017年9月20日 17:30:27
     */
    private Map<String ,List> genetateQueryCondition(PrpDuserDto userDto){
        List listCondition = new ArrayList() ;
        StringBuilder strWhere = new StringBuilder();
        int index = 0 ;
        if ("%".equals(userDto.getUserCode())&&!"%".equals(userDto.getUserName())){

            strWhere.append(" and a.userName like ?" + (index++));
            listCondition.add(userDto.getUserName());

        } else if (!"%".equals(userDto.getUserCode())&&!"%".equals(userDto.getUserName())) {

            strWhere.append(" and a.userName like ?" + (index++));
            listCondition.add(userDto.getUserName());

            strWhere.append(" and a.userCode  like ?" + (index++));
            listCondition.add(userDto.getUserCode()+"%");

        } else {

            strWhere.append(" and a.userCode  like ?" + (index++));
            listCondition.add(userDto.getUserCode()+"%");

        }

        String querySql= "select a.userCode,a.userName,a.comCode,b.comCName from PrpDuser a, PrpDcompany b "+
                " where a.comCode = b.comCode  and (b.remark !='虚拟机构' Or b.remark Is Null )  and b.validStatus='1' and a.validStatus = '1'";

        //TODO 权限查询待定
        querySql += strWhere.toString() + " order by a.userCode ";
        Map conditionMap= new HashMap();
        conditionMap.put("querySql",querySql);
        conditionMap.put("paramList",listCondition);
        return conditionMap ;
    }
    /**
     * @description 业务员查询服务 查询条件处理
     * @param userDto
     * @return List<PrpDuserDto>
     * @throws Exception
     * @author lishaoru
     * @since 2017年9月23日 15:30:58
     */
    private PrpDuserDto dealRequestInfo(PrpDuserDto userDto) throws Exception{
        userDto.setUserCode(this.getCodeValue(userDto.getUserCode()));
        userDto.setUserName(this.getCodeValue(userDto.getUserName()));
        return userDto;
    }
    /**
     * @description 业务员查询服务 查询条件处理
     * @param codeValue
     * @return String
     * @throws Exception
     * @author lishaoru
     * @since 2017年9月23日 15:30:58
     */
    private String getCodeValue(String codeValue) throws Exception{
        if(StringUtils.isNotBlank(codeValue))
        {
            codeValue = codeValue.replace("*","%");
        }
        else
        {
            codeValue ="%";
        }
        return codeValue;
    }

    private Specification<PrpDuser> genCondition(UserQueryConditionDto condition) {
        return Specifications.<PrpDuser>and()
//                .eq(StringUtils.isNotEmpty(condition.getProviceComCode()), "proviceComCode", condition.getProviceComCode())
//                .eq(StringUtils.isNotEmpty(condition.getCityComCode()), "cityComCode", condition.getCityComCode())
//                .eq(StringUtils.isNotEmpty(condition.getUserCode()), "upperComCode", condition.getUserCode())
                .eq(StringUtils.isNotEmpty(condition.getValidStatus()), "validStatus", condition.getValidStatus())
                .eq(StringUtils.isNotEmpty(condition.getComCode()), "comCode", condition.getComCode())
                .build();
    }

    /**
     *  修改PrpDuser表中的密码实现方法：
     *               1、校验。
     *               2、通过主键查询对应数据。
     *               3、旧密码加密。
     *               4、验证旧密码是否正确。
     *               5、新密码加密。
     *               6、执行更新。
     * @param userCode,用户代码 oldPassword, 旧密码 newPassword 新密码
     * @return java.lang.String 成功返回success,失败返回failed
     * @throws Exception
     * @author 李冬松
     * @date 10:51 2017/10/13
     */
    @Override
    public String modifyPassword(String userCode,String oldPassword, String newPassword) throws Exception {
        String strEncryptPwd="";

        Encrypt encrypt = new Encrypt();
        /**1、校验。*/
        if (userCode.equals("") || oldPassword.equals("") || newPassword.equals("")) {
            throw new DataVerifyException("输入不能为空！");
        }

        PrpDuserKey prpDuserKey =new PrpDuserKey(userCode);
        /**2、通过主键查询对应数据。*/
        PrpDuser password= prpDuserDao.findOne(prpDuserKey);
        /**3、旧密码加密。*/
        strEncryptPwd=encrypt.getEncryptCode(oldPassword);
        /**4、验证旧密码是否正确。*/
        Specification<PrpDuser> specification= CompanySpecBuilder.passwordSpecifications(userCode,strEncryptPwd);

        List<PrpDuser> userList= prpDuserDao.findAll(specification);
        /**5、新密码加密。*/
        strEncryptPwd=encrypt.getEncryptCode(newPassword);

        if(userList.size()>0){
            /**6、执行更新。*/
            password.setPassword(strEncryptPwd);

        }else {
            return "failed";
        }
        return "success";
    }
}
