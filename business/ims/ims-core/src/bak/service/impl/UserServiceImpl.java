package com.sinosoft.ims.core.kernel.service.impl;

import com.sinosoft.dms.api.bill.BillApi;
import com.sinosoft.dms.api.bill.dto.BillConditionDto;
import com.sinosoft.dms.api.dict.CodeApi;
import com.sinosoft.dms.api.dict.dto.NewCodeQueryConditionDto;
import com.sinosoft.dms.api.dict.dto.PrpDNewCodeDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DateUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.kernel.dto.*;
import com.sinosoft.ims.core.common.enums.ImsErrorEnum;
import com.sinosoft.ims.core.common.utils.ExcelUtilModel;
import com.sinosoft.ims.core.common.utils.ExportResult;
import com.sinosoft.ims.core.common.utils.PwdUtil;
import com.sinosoft.ims.core.kernel.dao.*;
import com.sinosoft.ims.core.kernel.entity.*;
import com.sinosoft.ims.core.kernel.service.CompanyService;
import com.sinosoft.ims.core.kernel.service.GradeService;
import com.sinosoft.ims.core.kernel.service.PowerService;
import com.sinosoft.ims.core.kernel.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    /** log日志 */
    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UtiIAccountDao utilAccoutnMapper;

    @Autowired
    private UtiIUserIdvDao utiIUserIdvMapper;

    @Autowired
    private UtiIUserDao utiIUserMapper;

    @Autowired
    private UtiIUserTypeDao utiIUserTypeMapper;

    @Autowired
    private UtiISvrDao utiISvrMapper;

    @Autowired
    private PrpDCompanyDao prpDCompanyMapper;
    
    @Autowired
    private CodeApi codeService;
    
    @Autowired
    private GradeService gradeService;
    
    @Autowired
    private BillApi billService;
    
    @Autowired
    private CompanyService companyService;
 
    @Autowired
    private PowerService powerService;
    
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
    public PageInfo<UserIdvDto> queryUserPage(UserQueryConditionDto queryDto)  {
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


        PageInfo<UserIdvDto> page = queryPageInfoByCondition(queryDto);
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

    private PageInfo<UserIdvDto> queryPageInfoByCondition(UserQueryConditionDto queryDto)
    {
        PageInfo<UserIdvDto> pageInfo = new PageInfo<UserIdvDto>();
        Pageable page = new PageRequest(queryDto.getPageNo(),queryDto.getPageSize());
        Page<UtiIUserIdv> list = utiIUserIdvMapper.findAll(genCondition(queryDto), page);

        List<UserIdvDto> userIdvDtos = new ArrayList<UserIdvDto>(list.getSize());
        convertCollection(list.getContent(), userIdvDtos, UserIdvDto.class);
        pageInfo.setContent(userIdvDtos);
        pageInfo.setTotalCount(list.getTotalElements());
        pageInfo.setPages(list.getTotalPages());
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
    public ResponseDto saveUser(UserDto userDto)  {
        //2017年8月3日17:59:51
        ResponseDto result = new ResponseDto();
        UtiIUser utiIUser = new UtiIUser();
        UtiIUserIdv utiIUserIdv = new UtiIUserIdv();
        UtiIUserType utiIUserType = new UtiIUserType();
        List<String> svrCodeList = new ArrayList<String>();
        List<UtiIAccount> utiIAccountList = new ArrayList<UtiIAccount>();
        List<AccountDto> accountDtoList = new ArrayList<AccountDto>();
        //UtiISvrExample utiISvrExample = new UtiISvrExample();
        AccountDto accountDto = null;
        UserGradeConditionDto userGradeConditionDto = new UserGradeConditionDto();
        String strUserCode = userDto.getUserCode();

        //1.1获取管理员用户的机构类型
        String comCode = userDto.getHeadComCode();
        PrpDCompanyKey prpDCompanyKey = new PrpDCompanyKey();
        prpDCompanyKey.setComCode(comCode);
        PrpDCompany prpDCompany = new PrpDCompany();
        prpDCompany = prpDCompanyMapper.findOne(prpDCompanyKey);
        //prpDCompany = prpDCompanyMapper.findByPrpDCompanyKey_CAndComCode(comCode);
        if(prpDCompany ==null ){
            throw new BusinessException("保险公司代码 "+ comCode + " 不存在！");
        }
        String comType = prpDCompany.getComType();

        String proviceComCode =userDto.getProviceComCode();

        //1.2根据proviceComCode&cityComCOde的值判断该用户的comCode
        userDto.setComCode(comCode);
        if("01".equals(comType)){
            if(!StringUtils.isEmpty(proviceComCode)){
                userDto.setComCode(proviceComCode);
           }
        }else{
            if(!StringUtils.isEmpty(proviceComCode)){
                userDto.setComCode(proviceComCode);
           }
            if(!StringUtils.isEmpty(userDto.getCityComCode())){
                userDto.setComCode(userDto.getCityComCode());
           }
        }

        // 1.2获取密码&密码md5加密
        String passWord = userDto.getPassWord();
        String md5wd = PwdUtil.md5(passWord);
        // 1.3生成当前时间
        Date date = new Date();
        // 2.1查询UtiIsvr表中所有的服务，遍历生成AccountDtoList
        //utiISvrExample.createCriteria();
        svrCodeList = utiISvrMapper.findBySqlSelsvrCode();//selectSvrCode();
        // 2.2判断svrCode是否有服务
        if (svrCodeList == null || svrCodeList.size() == 0) {
            result.setResultMsg("未查询到服务");
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getName());
            return result;
        }

        // 2.3判断userDto是否包含accountDto

            for (int i = 0; i < svrCodeList.size(); i++) {
                accountDto = new AccountDto();
                accountDtoList.add(accountDto);
            }
        utiIUser = convert(userDto, UtiIUser.class);
        utiIUser.setUserType("02");
        utiIUser.setCreateDate(date);
        utiIUser.setCreatorCode(strUserCode);
        utiIUser.setValidStatus("1");
        utiIUser.setUserSort("1");
        utiIUser.setUserName(userDto.getSalesManName());


        utiIUserIdv= convert(userDto, UtiIUserIdv.class);
        utiIUserIdv.setUserName(userDto.getSalesManName());
        utiIUserIdv.setCreateDate(date);
        //utiIUserIdv.setCreatorCode(userDto.getGlobalUserCode());

        for (int i = 0; i < accountDtoList.size(); i++) {
            UtiIAccount utiIAccount =convert(userDto, UtiIAccount.class);
            utiIAccount.setAccCode(svrCodeList.get(i) + strUserCode);
            utiIAccount.setPassWord(md5wd);
            utiIAccount.setUserCode(strUserCode);
            utiIAccount.setSvrCode(svrCodeList.get(i));
            utiIAccount.setUserName(userDto.getSalesManName());
            utiIAccount.setAccName(userDto.getSalesManName());
            utiIAccount.setCreateDate(date);
            //utiIAccount.setCreatorCode(userDto.getGlobalUserCode());
            utiIAccountList.add(utiIAccount);
        }

        utiIUserType=convert(userDto, UtiIUserType.class);
        utiIUserType.setUserCode(strUserCode);
        utiIUserType.setUserName(userDto.getSalesManName());
        utiIUserType.setUserType("02");
        utiIUserType.setCreateDate(date);
        //utiIUserType.setCreatorCode(userDto.getGlobalUserCode());

        // 6、用户重复性校验
        UtiIUserIdvKey userKey = new UtiIUserIdvKey();
        userKey.setUserCode(strUserCode);
        //UtiIUserIdv utiIUserIdvQuery = utiIUserIdvMapper.selectByPrimaryKey(userKey);
        UtiIUserIdv utiIUserIdvQuery = utiIUserIdvMapper.findOne(userKey);
        if (utiIUserIdvQuery != null) {
            result.setResultMsg(utiIUserIdvQuery.getUserCode() + "用户重复校验失败");
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            return result;
        }
        // 7、保存用户信息
//        utiIUserMapper.insert(utiIUser);
        utiIUserMapper.save(utiIUser);
//        utiIUserIdvMapper.insert(utiIUserIdv);
        utiIUserIdvMapper.save(utiIUserIdv);
        for (int index = 0; index < utiIAccountList.size(); index++) {
//            utilAccoutnMapper.insert(utiIAccountList.get(index));
            utilAccoutnMapper.save(utiIAccountList.get(index));
        }
//        utiIUserTypeMapper.insert(utiIUserType);
        utiIUserTypeMapper.save(utiIUserType);
        // 8、批量上传调用岗位配置服务
        List<String> gradeIds =userDto.getGradeIds();
        gradeIds.add("0000000000000000006");
        userGradeConditionDto.setUserCode(strUserCode);
        userGradeConditionDto.setGradeIds(gradeIds);
        //userGradeConditionDto.setGlobalUserCode(userDto.getGlobalUserCode());
        gradeService.configUserGrade(userGradeConditionDto);

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
    public ResponseDto updateUser(UserDto userDto)  {
        //2017年8月3日17:59:36
        ResponseDto result = new ResponseDto();
        UtiIUserIdv utiIUserIdv = new UtiIUserIdv();
        UtiIUser utiIUser = new UtiIUser();
        UtiIUserType utiIUserType = new UtiIUserType();
        String userCode = userDto.getUserCode();
        UserGradeConditionDto userGradeConditionDto = new UserGradeConditionDto();
        Date date = new Date();

        // 1.类型转换
        utiIUserIdv=convert(userDto, UtiIUserIdv.class);
        utiIUser=convert(userDto, UtiIUser.class);
        utiIUserType=convert(userDto, UtiIUserType.class);

        //1.1设置必须值
        utiIUserIdv.setUpdaterCode(userCode);
        utiIUserIdv.setUpdateDate(date);
        utiIUser.setUpdateDate(date);
        //utiIUser.setUpdaterCode(userDto.getGlobalUserCode());
        utiIUser.setFlag("1");
        utiIUserType.setUpdateDate(date);
        //utiIUserType.setUpdaterCode(userDto.getGlobalUserCode());

        // 2.调用岗位配置服务
        userGradeConditionDto.setUserCode(userCode);
        userGradeConditionDto.setGradeIds(userDto.getGradeIds());
        if(userDto.getGradeIds()==null){
        	result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
        	result.setResultMsg("请配置岗位");
        	return result;
        }
		//userGradeConditionDto.setGlobalUserCode(userDto.getGlobalUserCode());
        gradeService.configUserGrade(userGradeConditionDto);

        // 3.保存用户信息
        utiIUserIdvMapper.save(utiIUserIdv);
        //utiIUserIdvMapper.updateByPrimaryKeySelective(utiIUserIdv);
        utiIUserMapper.save(utiIUser);
        //utiIUserMapper.updateByPrimaryKeySelective(utiIUser);
        //utiIUserTypeMapper.updateByPrimaryKeySelective(utiIUserType);
        utiIUserTypeMapper.save(utiIUserType);
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
        utiIUserIdv = utiIUserIdvMapper.findOne(key);
        if (utiIUserIdv == null) {
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            result.setResultMsg(ImsErrorEnum.IMS_ERROR.getName());
            return result;
        }
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
    public ResponseDto checkeUserPasswd(UserDto userDto)  {
        //2017年8月3日17:59:00
        ResponseDto result = new ResponseDto();
        //UtiIAccountExample example = new UtiIAccountExample();
        try{
            // 1.获取传入密码&加密
            String inputPassword = userDto.getPassWord();
            String md5Pwd = PwdUtil.md5(inputPassword);

            // 2.获取该账号的密码
            String userCode = userDto.getUserCode();
            //userDto.setUserCode(userCode);
            //example.createCriteria().andUserCodeEqualTo(userCode);
            //List<UtiIAccount> list = utilAccoutnMapper.selectByExample(example);
            List<UtiIAccount> list = utilAccoutnMapper.findAllByUserCode(userCode);
            if (list == null || list.size() <= 0) {
                result.setResultMsg("账号不存在");
                return result;
            } else {
                String DBpassword = list.get(0).getPassWord();
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
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
    public ResponseDto updatePasswd(UserDto userDto)  {

        ResponseDto result = new ResponseDto();
        List<UtiIAccount> list = new ArrayList<UtiIAccount>();
        String userCode = userDto.getUserCode();
        Date date = new Date();
        Date newDate = DateUtils.getNextNYear(date, 5);
        String password = new String();
        // 获取密码&加密
        password = userDto.getNewPassword();
        String md5Pwd = PwdUtil.md5(password);
        
        //如果密码不存在
        if(password==null){
            result.setResultMsg("请输入密码");
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            return result;
        }
        // 通过userCode查询该userCode所有的账户
//        UtiIAccountExample example = new UtiIAccountExample();
//        example.createCriteria().andUserCodeEqualTo(userCode);
//        try {
//            list = utilAccoutnMapper.selectByExample(example);
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage());
//        }
//        if (list == null) {
//            result.setResultMsg("该用户不存在");
//            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
//            return result;
//        }
//
//        // 给所有账户设置密码
//        int count = 0;
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i).setPassWord(md5Pwd);
//            list.get(i).setPasswdSetDate(date);
//            list.get(i).setPasswdExpireDate(newDate);
//            list.get(i).setUpdateDate(new Date());
//            list.get(i).setUpdaterCode(userDto.getGlobalUserCode());
//            count += utilAccoutnMapper.updateByPrimaryKeySelective(list.get(i));
//        }
//        if (count == 0) {
//            result.setResultMsg("修改未成功");
//            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
//
//            return result;
//        }
        result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
        result.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
        return result;
    }

    /**
     * @description 根据用户代码查询用户
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月20日上午9:21:58
     */
    @Override
    public UserIdvDto queryUserInfo(UserDto userDto)  {
        UtiIUserIdvKey utiIUserIdvKey = new UtiIUserIdvKey();
        String userCode = userDto.getUserCode();

        // 设置账号userCode
        utiIUserIdvKey.setUserCode(userCode);
        // 获取用户信息
        UtiIUserIdv userIdv = utiIUserIdvMapper.findOne(utiIUserIdvKey);
        
        return convert(userIdv,UserIdvDto.class);
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
    public  Map<String, String> downloadUserInfo(UserDto userDto) 
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
    @SuppressWarnings({"unchecked", "rawtypes"})
    private void assembleGradeAndIdType(List<Map<String, Object>> list)  
    {
        GradeQueryConditionDto gradeQueryConditionDto = null;
        NewCodeQueryConditionDto newCodeQueryConditionDto = null;
        for(Map m : list){
            // 查询岗位信息
            gradeQueryConditionDto =new GradeQueryConditionDto();
            gradeQueryConditionDto.setUserCode((String)m.get("USERCODE")); 
            List<SaaGradeDto> gradeList =  gradeService.queryGradeList(gradeQueryConditionDto);
            if(gradeList !=null && gradeList.size() > 0){
                String grade ="";
                for( SaaGradeDto gradeDto :gradeList ){
                    grade += gradeDto.getGradeCode()+"-"+gradeDto.getGradeCName() + ",";
                }
                m.put("GRADE", grade.substring(0, grade.length()-1));
            }
            
            //转换证件类型
            if(m.get("IDENTITYTYPE") != null ){
                newCodeQueryConditionDto = new NewCodeQueryConditionDto();
                newCodeQueryConditionDto.setCodeType("PersonalIdentifyType");
                newCodeQueryConditionDto.setCodeCode((String)m.get("IDENTITYTYPE"));
                PrpDNewCodeDto prpDNewCodeDto = null;
                try
                {
                    prpDNewCodeDto = codeService.transCodeCodeReturnCodeName(newCodeQueryConditionDto);
                }
                catch (Exception e)
                {
                    throw new BusinessException("创建用户信息清单文件发生异常！");
                }
                if(prpDNewCodeDto != null ){
                    String idType = (String)m.get("IDENTITYTYPE") + "-" + prpDNewCodeDto.getCodeCName();
                    m.put("IDENTITYTYPE",idType);
                }
            }
        }
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
                serialNo = billService.getSerialNo(billConditionDto).getSerialNo();
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
            result = saveUser(list.get(i));
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
    public List<PrpDCompanyDto> queryUserComCodeService(UserDto userDto)  {
        UtiIUserIdv utiIUserIdv = new UtiIUserIdv();
        UtiIUserIdvKey utiIUserIdvKey = new UtiIUserIdvKey();
        List<PrpDCompany> prpDCompanyList = new ArrayList<PrpDCompany>();
        List<PrpDCompanyDto> prpDCompanyDtoList = new ArrayList<PrpDCompanyDto>();
        // 获取usercode查询出该用户所属机构
        String userCode = userDto.getUserCode();
        utiIUserIdvKey.setUserCode(userCode);
        
        utiIUserIdv = utiIUserIdvMapper.findOne(utiIUserIdvKey);
        
        if(utiIUserIdv==null){
            return null;
        }
        String comCode = utiIUserIdv.getComCode().trim();
        
        // 查询该用户的所属机构权限
        prpDCompanyList = prpDCompanyMapper.findAll(Specifications.<PrpDCompany>and()
                .eq("comCode",comCode)
                .eq("validStatus","1").build());

        // 类型转换
        for (PrpDCompany prpDCompany : prpDCompanyList) {
            prpDCompanyDtoList.add(convert(prpDCompany, PrpDCompanyDto.class));
        }
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
	public PrpDCompanyDto queryHeadComCodeService(UserDto userDto)  {
		UtiIUserIdv utiIUserIdv = new UtiIUserIdv();
		UtiIUserIdvKey utiIUserIdvKey = new UtiIUserIdvKey();
		PrpDCompanyKey prpDCompanyKey = new PrpDCompanyKey();
		PrpDCompany prpDCompany = new PrpDCompany();
		PrpDCompanyDto prpDCompanyDto  = new PrpDCompanyDto ();

		//1、获取用户信息
		//String userCode = userDto.getGlobalUserCode();
		utiIUserIdvKey.setUserCode(SinoRequestContext.getCurrentContext().getUserCode());
		utiIUserIdv = utiIUserIdvMapper.findOne(utiIUserIdvKey);
		if(utiIUserIdv==null){
		    throw new BusinessException("用户不存在！");
		}
		//2、获取所属总公司
		String HeadComCode = utiIUserIdv.getHeadComCode();
		prpDCompanyKey.setComCode(HeadComCode);
		prpDCompany = prpDCompanyMapper.findOne(prpDCompanyKey);
        prpDCompanyDto = convert(prpDCompany, PrpDCompanyDto.class);
	
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
    public List<PrpDCompanyDto> queryDownComCodeService(UserDto userDto)  {

        List<PrpDCompanyDto> prpDCompanyDtoList = new ArrayList<PrpDCompanyDto>();
        List<PrpDCompany> prpDCompanyList = new ArrayList<PrpDCompany>();
        
        Map<String, Object> params = new HashMap<String, Object>();
        UtiIUserIdv utiIUserIdv = new UtiIUserIdv();
        UtiIUserIdvKey utiIUserIdvKey = new UtiIUserIdvKey();
        //1、获取总机构
        //utiIUserIdvKey.setUserCode(userDto.getGlobalUserCode());
        utiIUserIdvKey.setUserCode(SinoRequestContext.getCurrentContext().getUserCode());
        utiIUserIdv = utiIUserIdvMapper.findOne(utiIUserIdvKey);
        if(utiIUserIdv==null){
            throw new BusinessException("该用户不存在！ userCode= " + userDto.getUserCode());
        }
        String upperComCode = utiIUserIdv.getHeadComCode();
        
        //2、获取comType
        //2017年8月3日18:01:12
        PrpDCompanyKey prpDCompanyKey = new PrpDCompanyKey();
        prpDCompanyKey.setComCode(upperComCode);
        PrpDCompany prpDCompany = new PrpDCompany();
        prpDCompany = prpDCompanyMapper.findOne(prpDCompanyKey);
//        prpDCompany = prpDCompanyMapper .selectByPrimaryKey(prpDCompanyKey);
        String comType = prpDCompany.getComType();
        
        //3、调取查询方法
        params.put("comType", comType);
        prpDCompanyList = prpDCompanyMapper.findAll(Specifications.<PrpDCompany>and()
                .eq("upperComCode", upperComCode)
                .eq("validStatus", userDto.getValidStatus()).build());
        
        //4、获取省级机构
        for (int i = 0; i < prpDCompanyList.size(); i++) {
            prpDCompanyDtoList.add(convert(prpDCompanyList.get(i), PrpDCompanyDto.class));
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
    * @
    * @author chengzhuo
    * @date 2016年10月8日下午2:04:57
    */
    @Override
    public ResponseDto checkRepeatUserCode(UserDto userDto) {
            ResponseDto result = new ResponseDto();
            String userCode = userDto.getUserCode();
            UtiIUserKey utiIUserKey = new UtiIUserKey();
            UtiIUser utiIUser = new UtiIUser();

            utiIUserKey.setUserCode(userCode);
            utiIUser = utiIUserMapper.findOne(utiIUserKey);
            if (utiIUser != null) {
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
    public PrpDCompanyDto queryUserCompany(UserDto userDto)   {
           
        UserIdvDto userIdvDto = queryUserInfo(userDto);
        
        CompanyConditionDto companyConditionDto = new CompanyConditionDto ();
        if(!StringUtils.isBlank(userIdvDto.getComCode().trim())){
            companyConditionDto.setComCode(userIdvDto.getComCode());
        }else if(!StringUtils.isBlank(userIdvDto.getHeadComCode().trim())){
            companyConditionDto.setComCode(userIdvDto.getHeadComCode());
        }else{
            throw new BusinessException("没有找到【"+userIdvDto.getUserName()+"】对应的归属机构！");
        }
        // 获取用户所属机构
        PrpDCompanyDto prpDCompanyDto = companyService.queryCompanyByComcode(companyConditionDto);
        return prpDCompanyDto;
    }

    private Specification<UtiIUserIdv> genCondition(UserQueryConditionDto condition) {
        return Specifications.<UtiIUserIdv>and()
                .eq(StringUtils.isNotEmpty(condition.getProviceComCode()), "proviceComCode", condition.getProviceComCode())
                .eq(StringUtils.isNotEmpty(condition.getCityComCode()), "cityComCode", condition.getCityComCode())
                .eq(StringUtils.isNotEmpty(condition.getUserCode()), "upperComCode", condition.getUserCode())
                .eq(StringUtils.isNotEmpty(condition.getValidStatus()), "validStatus", condition.getValidStatus())
                .eq(StringUtils.isNotEmpty(condition.getComCode()), "comCode", condition.getComCode())
                .build();
    }
}
