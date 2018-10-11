package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.dto.*;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.core.auth.dao.UtiGroupDao;
import com.sinosoft.ims.core.auth.dao.UtiPlatConfigDao;
import com.sinosoft.ims.core.auth.entity.*;
import com.sinosoft.ims.core.auth.service.PowerService;
import com.sinosoft.ims.core.auth.service.UtiGroupService;
import com.sinosoft.ims.core.kernel.dao.PrpDcompanyDao;
import com.sinosoft.ims.core.kernel.entity.PrpDcompany;
import com.sinosoft.ims.core.kernel.entity.PrpDcompanyKey;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

import static com.sinosoft.ims.IMSConstant.PERFECT_COM_TREE;
import static org.springframework.util.StringUtils.isEmpty;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiGroupCore接口实现
 */
@Service
public class UtiGroupServiceImpl extends BaseServiceImpl implements UtiGroupService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiGroupServiceImpl.class);

    /**
     * 用户的机构权限代码
     */
    public static List<String> powerComCode;
    /**
     * 用户代码
     */
    public static String userCode;
    /**
     * 登录机构代码
     */
    public static String loginComCode;

    @Autowired
    private UtiGroupDao utiGroupDao;
    @Autowired
    private UtiPlatConfigDao utiPlatConfigDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDcompanyDao prpDcompanyDao;
    @Autowired
    private PowerService powerService;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiGroupDto utiGroupDto) {
        UtiGroup utiGroup = this.convert(utiGroupDto, UtiGroup.class);
        utiGroupDao.save(utiGroup);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String groupCode) {
        UtiGroupKey utiGroupKey = new UtiGroupKey(groupCode);
        utiGroupDao.delete(utiGroupKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiGroupDto utiGroupDto) {
        UtiGroup utiGroup = this.convert(utiGroupDto, UtiGroup.class);
        utiGroupDao.save(utiGroup);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiGroupDto queryByPK(String groupCode) {
        UtiGroupKey utiGroupKey = new UtiGroupKey(groupCode);
        UtiGroup utiGroup = utiGroupDao.findOne(utiGroupKey);
        return this.convert(utiGroup,UtiGroupDto.class);
    }
    /**
    *  获取权限查询条件方法
    * @param addCodePowerConditionDto
    *
    *  入参说明：1.userCode必传。
    *  2.tableName为所要查询的表名，必传。
    *  3.loginComCode和loginGradeCodes至少传一个。
    *  4.userCodeFields为userCode字段的字符串 "userCode"，如为空则传"",
    *  comCodeFields同userCodeFields，传则"comCode",如为空则传""。
    *  5.tableName1为表的别名，传入后会把别名拼到返回的SQL里。
    *  6.riskCode 为险种，可传可不传，如果不传，则传""。
    *  7.flag 是判断返回的SQL里要不要拼险种条件部分，类似于tableName1.riskCode IN('3101','3201')，
    *  如果true为要拼险种，false为不要拼险种。
    *
    * @return String 返回权限查询条件的Sql字符串
    * @throws Exception
    * @author 李冬松
    * @date 11:29 2017/11/20
    */
    @Override
    public String addCodePower(AddCodePowerConditionDto addCodePowerConditionDto) throws Exception {
        if (StringUtils.isEmpty(addCodePowerConditionDto.getUserCode())) {
            throw new DataVerifyException("参数\"员工代码\"没有值");
        }
        if (StringUtils.isEmpty(addCodePowerConditionDto.getTableName())) {
            throw new DataVerifyException("参数\"表名\"没有值");
        }
        if (StringUtils.isEmpty(addCodePowerConditionDto.getLoginComCode()) && StringUtils.isEmpty(addCodePowerConditionDto.getLoginGradeCodes())) {
            throw new DataVerifyException("参数\"登录机构\"和\"登录岗位列表\"必须有一个有值");
        }
        if (StringUtils.isEmpty(addCodePowerConditionDto.getUserCodeFields()) && StringUtils.isEmpty(addCodePowerConditionDto.getComCodeFields())) {
            throw new DataVerifyException("参数\"用户字段名称\"和\"机构字段名称\"必须有一个有值");
        }

        String userCodeFields=addCodePowerConditionDto.getUserCodeFields();
        String tableName=addCodePowerConditionDto.getTableName();
        String comCodeFields=addCodePowerConditionDto.getComCodeFields();
        String userCode=addCodePowerConditionDto.getUserCode();
        String loginComCode=addCodePowerConditionDto.getLoginComCode();
        String loginGradeCodes=addCodePowerConditionDto.getLoginGradeCodes();
        String riskCode=addCodePowerConditionDto.getRiskCode();
        String tableName1=addCodePowerConditionDto.getTableName1();
        boolean requireRiskCode=addCodePowerConditionDto.isFlag();
        // POWER:管理员有所有业务权限
        if(powerService.isSuperUser(loginComCode,userCode)){
            return "";
        }
        if(userCodeFields==null||comCodeFields==null){
            throw new DataVerifyException("userCodeFields,comCodeFields不可为null!");
        }
        List<String> userCodeFieldsList=new ArrayList<>();
        Long n1=System.currentTimeMillis();
        System.out.println("hasColumn 开始");
        // 处理UserCode字段列表
        if (userCodeFields.length() > 0&&hasColumn(tableName,userCodeFields)) {
            userCodeFieldsList.add(userCodeFields);
        }
        if(hasColumn(tableName,"HandlerCode")){
            userCodeFieldsList.add("HandlerCode");
        }
        if(hasColumn(tableName,"OperatorCode")){
            userCodeFieldsList.add("OperatorCode");
        }
        if(hasColumn(tableName,"Handler1Code")){
            userCodeFieldsList.add("Handler1Code");
        }
        Long n2=System.currentTimeMillis();
        System.out.println(((n2-n1))+"毫秒");

        // 处理ComCode字段列表，目前不提供检测字段是否存在的功能
        String[] comCodeFieldsArray = StringGyUtils.split(comCodeFields, ",");

        StringBuffer buffer = new StringBuffer();// 结果SQL语句的Buffer
        boolean perfectComTree = true; // 是否是完美的机构树，默认为true
        UtiPlatConfigKey utiPlatConfigKey=new UtiPlatConfigKey("platform",PERFECT_COM_TREE);
        UtiPlatConfig utiPlatConfig =utiPlatConfigDao.findOne(utiPlatConfigKey);
        UtiPlatConfigDto utiPlatConfigDto=convert(utiPlatConfig,UtiPlatConfigDto.class);
        utiPlatConfigDto.setParamCode("");
        if (utiPlatConfigDto != null) {
            perfectComTree = DataUtils.getBoolean(utiPlatConfigDto.getParamCode());
        }

        // 根据员工代码、机构代码/岗位代码查询出所有机构员工岗位
        //原生SQL
        String sql="select u.*,( select PrpDcompany.comlevel  from PrpDcompany where  u.comcode = PrpDcompany.comcode) as comlevel " +
                "FROM UtiUserGrade u  WHERE u.userCode=:userCode and u.comCode=:loginComCode and u.gradeCode like :loginGradeCodes ";

        Query query=entityManager.createNativeQuery(sql,UtiUserGrade.class);
        loginGradeCodes = "%" + loginGradeCodes + "%";
        query.setParameter("userCode",userCode);
        query.setParameter("loginComCode",loginComCode);
        query.setParameter("loginGradeCodes",loginGradeCodes);
        List<UtiUserGrade> utiUserGradeList=new ArrayList<>();
        utiUserGradeList = query.getResultList();
        List<UtiUserGradeDto> utiUserGradeDtoList=new ArrayList<>();
        for(UtiUserGrade utiUserGrade   :utiUserGradeList){
            utiUserGradeDtoList.add(convert(utiUserGrade,UtiUserGradeDto.class));
        }
        // 对所有的机构员工岗位进行顺序处理,每个机构员工岗位之间是OR的关系
        for (UtiUserGradeDto utiUserGradeDto: utiUserGradeDtoList) {
            //原生SQL
            String strSql = "select up.* from UtiUserGradePower up where up.userCode LIKE :userCode and up.comCode=:loginComCode and up.gradeCode like :loginGradeCode";
            Query query1=entityManager.createNativeQuery(strSql,UtiUserGradePower.class);
            userCode="%"+userCode+"%";
            loginGradeCodes = "%" + loginGradeCodes + "%";
            query1.setParameter("userCode",userCode);
            query1.setParameter("loginComCode",utiUserGradeDto.getComCode());
            query1.setParameter("loginGradeCode",utiUserGradeDto.getGradeCode());
            List<UtiUserGradePower> utiUserGradePowers = query1.getResultList();
            List<UtiUserGradePowerDto> utiUserGradePowerDtoList=new ArrayList<>();
            convertCollection(utiUserGradePowers,utiUserGradePowerDtoList,UtiUserGradePowerDto.class);
            // 对机构员工岗位的每条业务记录进行顺序处理
            for (UtiUserGradePowerDto utiUserGradePowerDto:utiUserGradePowerDtoList) {
                StringBuffer recordSQL = new StringBuffer();// 每条记录生成的SQL语句
                String permitRiskCode = utiUserGradePowerDto.getPermitRiskCode();
                // 险种代码不为*时加上险种控制
                if (!permitRiskCode.equals("*")) {
                    // 允许操作的险种不包含传入险种即continue
                    if (!(permitRiskCode.endsWith(riskCode) || permitRiskCode.indexOf(riskCode + ",") > -1)) {
                        continue;
                    }
                }
                // 机构和员工之间的关系为OR , 各字段之间的关系为OR
                // 处理机构代码字段
                StringBuffer comCodeSQL = new StringBuffer();// ComCode生成的SQL语句
                for (int i = 0; i < comCodeFieldsArray.length; i++) {
                    String field = comCodeFieldsArray[i];
                    String permitComCode = "";
                    String exceptComCodes = "";
                    // 如果是代码权限则使用CodePermitComCode和CodeExceptComCode字段
                    permitComCode = utiUserGradePowerDto.getCodePermitComCode();
                    exceptComCodes = utiUserGradePowerDto.getCodeExceptComCode();
                    if (permitComCode.trim().length() == 0) {
                        permitComCode = utiUserGradePowerDto.getPermitComCode();
                    }

                    StringBuffer comCodeFieldSQL = getComCodeSQL(tableName1 + "." + field, permitComCode,
                            exceptComCodes, perfectComTree);
                    if (i == 0) {
                        comCodeSQL.append("(").append(comCodeFieldSQL).append(")");
                    } else {
                        comCodeSQL.append(" OR (").append(comCodeFieldSQL).append(")");
                    }
                }
                // 处理机构结束

                // 处理员工代码字段
                StringBuffer userCodeSQL = new StringBuffer();// UserCode生成的SQL语句
                for (int i = 0; i < userCodeFieldsList.size(); i++) {
                    String field = userCodeFieldsList.get(i);
                    StringBuffer userCodeFieldSQL = new StringBuffer();
                    userCodeFieldSQL.append("(").append(tableName1).append(".").append(field).append(" like '").append(userCode).append("')"); // 员工默认有察看自身参与的数据的权限
                    String[] permitUserCodes = StringGyUtils.split(utiUserGradePowerDto.getPermitUserCode(), ",");
                    if(permitUserCodes!=null) {
                        for (int j = 0; j < permitUserCodes.length; j++) {
                            String permitUserCode = permitUserCodes[j];
                            userCodeFieldSQL .append(" OR (").append(tableName1).append(".").append(field).append(" = '").append(permitUserCode).append("')") ;
                        }
                    }
                    // 最开始要加AND。最开始和最后的条件要包括起来
                    if (i == 0) {
                        userCodeSQL.append(" OR (").append(userCodeFieldSQL).append(")");
                    } else {
                        userCodeSQL.append(" OR (").append(userCodeFieldSQL).append(")");
                    }
                }
                if (userCodeSQL.toString().trim().toUpperCase().startsWith("OR")) {
                    userCodeSQL =new StringBuffer(userCodeSQL.toString().trim().substring("OR".length()).trim());
                }
                if (!StringUtils.isEmpty(comCodeSQL) && !StringUtils.isEmpty(userCodeSQL)) {
                    System.out.println(userCodeSQL);
                    recordSQL .append(" AND ((")  .append(comCodeSQL)  .append(") OR (")  .append(userCodeSQL)  .append("))") ;
                } else if (!StringUtils.isEmpty(comCodeSQL)) {
                    recordSQL .append(" AND (")  .append(comCodeSQL)  .append(")") ;
                } else if (!StringUtils.isEmpty(userCodeSQL)) {
                    recordSQL .append(" AND (")  .append(userCodeSQL)  .append(")") ;
                }

                // 将各条记录产生的SQL拼起来即所需完整SQL，各记录间的关系为OR
                if (recordSQL.toString().trim().length() > 0) {
                    if (recordSQL.toString().trim().toUpperCase().startsWith("AND")) {
                        recordSQL=new StringBuffer(recordSQL.toString().trim().substring("AND".length()).trim());
                    }
                    // 第一次添加时无需OR
                    if (buffer.length() == 0) {
                        buffer.append("(");
                        buffer.append(recordSQL);
                        buffer.append(")");
                    } else {
                        // 过滤重复条件
                        if (buffer.indexOf(recordSQL.toString()) == -1) {
                            buffer.append(" OR (");
                            buffer.append(recordSQL);
                            buffer.append(")");
                        }
                    }
                    recordSQL .delete(0,recordSQL.length());
                }
            }

        }
        /*获取险种权限*/
        if(StringUtils.isEmpty(riskCode)&&requireRiskCode){
            buffer.append(addRiskCodePermit(addCodePowerConditionDto));
        }
        // 不存在业务权限配置时抛出异常

        if (buffer.length() == 0) {
            String message = "不存在业务权限，无权执行此操作! 参数为：";
            message += "员工代码='" + userCode + "',";
            message += "登录机构代码='" + loginComCode + "',";
            message += "登录岗位代码='" + loginGradeCodes + "'";
            throw new DataVerifyException(message);
        }
        // 返回时将SQL语句包起来，并用AND连接。
        buffer.insert(0, " AND ("); // 前面插入AND (
        buffer.append(")"); // 后面追加)
        return buffer.toString();
    }
    /**
     *  获取权限查询条件子方法方法
     * @param fieldName 字段名
     * @param comCode 机构名
     * @param exceptComCode
     * @return String 返回权限查询条件的Sql字符串
     * @throws Exception
     * @author 李冬松
     * @date 11:29 2017/11/20
     */
    public StringBuffer getComCodeSQL(String fieldName, String comCode, String exceptComCode, boolean perfectComTree) throws Exception {
        StringBuffer comCodeSQL = new StringBuffer();
        if (isEmpty(comCode)) {
            throw new DataVerifyException("(代码)权限机构代码不能为空");
        }
        // 如果除外机构包含权限机构则直接返回1=0
        if(exceptComCode==null){
            exceptComCode="";
        }
//        if (exceptComCode.indexOf(comCode) > -1) {
//            return new StringBuffer("1=0");
//        }
        List<PrpDcompany> prpDcompanyList = prpDcompanyDao.queryByComCode(comCode);

        List<PrpDcompanyDto> prpDcompanyDtoList=new ArrayList<>();
        PrpDcompanyDto prpDcompanyDto =null;
        if(prpDcompanyList!=null&&prpDcompanyList.size()>0)

            convertCollection(prpDcompanyList,prpDcompanyDtoList,PrpDcompanyDto.class);
            prpDcompanyDto = prpDcompanyDtoList.get(0);
        if (perfectComTree) {// 是完美的机构树，采用尾部偶数截零法
            // 如果不是总公司则需要添加机构条件
            if (isTopCompany(comCode) == false) {
                comCodeSQL .append("(") ;
                String companyCode = tailEvenTrim(comCode);// 公司代码
                comCodeSQL .append(fieldName) .append(" LIKE '")  .append(companyCode)  .append("%') ") ;

            }
            String[] values = StringGyUtils.split(exceptComCode, ",");
            for (int i = 0; i < values.length; i++) {
                String exceptCompanyCode = tailEvenTrim(values[i]);// 公司代码
                // 长度为0表示是总公司无需处理，否则要添加机构条件
                if (exceptCompanyCode.length() == 0) {
                    comCodeSQL .append(" AND (1 = 0)") ;
                    break; // 发现一个则无需继续了
                }
                // 长度一致则直接用=操作符
                if (exceptComCode.length() == exceptCompanyCode.length()) {
                    comCodeSQL .append(" AND (")  .append(fieldName)  .append(" != '")  .append(exceptCompanyCode)  .append("')") ;
                } else {
                    comCodeSQL .append(" AND (")  .append(fieldName)  .append(" NOT LIKE '")  .append(exceptCompanyCode)  .append("%')") ;
                }

            }
        } else {// 不是完美的机构树，采用递归查询法
            // 长度一致则直接用=操作符
            if(comCode.indexOf("YL") > -1){ //机构为医疗事业部
                //原生SQL
                String sql="Select ComCode from prpdCompany t Start With ComCode = :comCode Connect By  upperylcomCode = Prior comCode  AND prior ComCode != ComCode AND validstatus = '1'";
                Query query=entityManager.createNativeQuery(sql);
                query.setParameter("comCode" ,comCode);
                List<String> list =query.getResultList();
                if (list.size() == 0) {
                    comCodeSQL .append("1=0") ;
                } else {
                    if(list!=null&&list.size()<1000){
                        comCodeSQL .append(fieldName)  .append(" IN (") ;
                        for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
                            String comCodeTemp = iter.next();
                            comCodeSQL .append("'")  .append(comCodeTemp)  .append("'") ;
                            if (iter.hasNext()) {
                                comCodeSQL .append(",") ;
                            }
                        }
                        comCodeSQL .append(")") ;
                    }
                }
            }else{
                //修改
//                Collection companys =findByComCode(comCode, exceptComCode);
//                if (companys.size() == 0) {
//                    comCodeSQL .append("1=0") ;
//                } else {
//                    String strSQL = "";
//                    if("1".equals(prpDcompanyDto.getSpecLevelFlag())){
//                        //走进非完美机构树的理赔中心用户的sql
//                        comCodeSQL.append(" exists (select 1 from prpdcompany where speclevel like '").append(prpDcompanyDto.getSpecLevel()).append("%' and comcode=").append(fieldName).append(" )");
//                    }else{
//                        if(companys!=null&&companys.size()<1000){
//                            comCodeSQL .append(fieldName)  .append(" IN (") ;
//                            for (Iterator iter = companys.iterator(); iter.hasNext();) {
//                                PrpDcompanyDto element = (PrpDcompanyDto) iter.next();
//                                comCodeSQL .append("'")  .append(element.getComCode())  .append("'") ;
//                                if (iter.hasNext()) {
//                                    comCodeSQL .append(",") ;
//                                }
//                            }
//                            comCodeSQL .append(")") ;
//                        }else{
//                            comCodeSQL = getOracleSQLIn(companys, fieldName);
//                        }
//                    }
//                }
                List<String> list = findByComCode(comCode, exceptComCode);
                if(list==null ||list.size()==0){
                    comCodeSQL .append("1=0") ;
                }else{
                    String strSQL = "";
                    if("1".equals(prpDcompanyDto.getSpecLevelFlag())){
                        //走进非完美机构树的理赔中心用户的sql
                        comCodeSQL.append(" exists (select 1 from prpdcompany where speclevel like '").append(prpDcompanyDto.getSpecLevel()).append("%' and comcode=").append(fieldName).append(" )");
                    }else{
                        if(list!=null&&list.size()<1000){
                            comCodeSQL .append(fieldName)  .append(" IN (") ;
                            for (int i=0;i<list.size();i++) {
                                if(i>0){
                                    comCodeSQL.append(",");
                                }
                                comCodeSQL.append("'").append(list.get(i)).append("'");
                            }
                            comCodeSQL .append(")") ;
                        }
                        //TODO 未处理
//                        else{
//                            comCodeSQL = getOracleSQLIn(companys, fieldName);
//                        }
                    }
                }

            }
        }

        if (comCodeSQL.toString().trim().toUpperCase().startsWith("AND")) {
            comCodeSQL = new StringBuffer(comCodeSQL.toString().trim().substring("AND".length()).trim());
        }
        if (comCodeSQL.toString().trim().length() == 0) {
            comCodeSQL = new StringBuffer("1=1");
        }
        String[] table = StringGyUtils.split(fieldName, ".");
        if (table[0].toLowerCase().equals("prpdcustomeridv") || table[0].toLowerCase().equals("prpdcustomerunit")) {
            // 查询客户资料时加上允许下级查看的上级机构
        	/*如果是总公司，不拼这个条件，不然sql报错 */
            if(isTopCompany(comCode) == false){
                //Collection upperCompanys = findByComCode(comCode, exceptComCode);
//                if(upperCompanys!=null&&upperCompanys.size()<1000){
//                    comCodeSQL .append(" OR (")  .append(fieldName)  .append(" IN (") ;
//                    for (Iterator iter = upperCompanys.iterator(); iter.hasNext();) {
//                        PrpDcompanyDto element = (PrpDcompanyDto) iter.next();
//                        comCodeSQL .append("'")  .append(element.getComCode())  .append("'") ;
//                        if (iter.hasNext()) {
//                            comCodeSQL .append(",") ;
//                        }
//                    }
//                }else{
//                    comCodeSQL .append(" OR ( ").append(getOracleSQLIn(upperCompanys, fieldName));
//                }
                List<String> list = findByComCode(comCode, exceptComCode);
                if (list != null && list.size() < 1000) {
                    comCodeSQL.append(" OR (").append(fieldName).append(" IN (");
                    for (int i=0;i<list.size();i++) {
                        if(i>0){
                            comCodeSQL.append(",");
                        }
                        comCodeSQL.append("'").append(list.get(i)).append("'");
                    }
                }
                //TODO 未处理
//                else {
//                    comCodeSQL.append(" OR ( ").append(getOracleSQLIn(upperCompanys, fieldName));
//                }

                comCodeSQL .append(") AND lowerViewFlag = '1'") ;
                new StringBuffer("(").append(comCodeSQL);
                comCodeSQL .append(" ))") ;
            }
        }
        return comCodeSQL;
    }
    /**
    * 判断是否为超级用户
    * @param comCode 机构代码
    * @return boolean 是返回true,否返回false
    * @throws Exception
    * @author 李冬松
    * @date 11:39 2017/11/20
    */
    public boolean isTopCompany(String comCode)
            throws Exception {
        PrpDcompanyKey prpDcompanyKey=new PrpDcompanyKey(comCode);
        PrpDcompany prpDcompany = prpDcompanyDao.findOne(prpDcompanyKey);
        PrpDcompanyDto prpDcompanyDto=convert(prpDcompany,PrpDcompanyDto.class);
        if (prpDcompanyDto != null
                && prpDcompanyDto.getUpperComCode().equals(
                prpDcompanyDto.getComCode())) {
            return true;
        }
        return false;
    }

    private StringBuffer getOracleSQLIn(Collection ids, String field) {
        StringBuffer strConditions =new StringBuffer(" (") ;
        for (Iterator iter = ids.iterator(); iter.hasNext();) {

            PrpDcompanyDto element = (PrpDcompanyDto) iter.next();
            strConditions .append(field)  .append("= '") .append(element.getComCode())  .append("'") ;
            if (iter.hasNext()) {
                strConditions .append(" or ") ;
            }
        }
        strConditions .append(")") ;
        return strConditions;
    }

    /**
     * 尾部偶数截零法处理机构代码
     * @param comCode 机构代码
     * @return 尾部偶数截零法处理后的机构代码
     * @throws Exception
     * @author 李冬松
     * @date 11:39 2017/11/20
     */
    private  String tailEvenTrim(String comCode) {
        if (comCode == null || comCode.trim().length() == 0) {
            return "";
        }
        //根据comCode的级别，选取comCode的前几位（1级 全部,2级 前4位,3级 前6位，5级 前8位）
        try {
            //取机构代码的级别
            ArrayList  prpDcompany = (ArrayList)prpDcompanyDao.queryByComCode(comCode);
            PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)prpDcompany.get(0);
            String comlevel = prpDcompanyDto.getComLevel();

            if("1".equals(comlevel))
            {
                comCode ="";
            }else if("2".equals(comlevel))
            {
                comCode = comCode.substring(0, 4);
            }else if("3".equals(comlevel))
            {
                comCode = comCode.substring(0, 6);
            }else if("4".equals(comlevel))
            {
                comCode = comCode.substring(0, 8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comCode;
    }
    /**
     * 获取机构（包含本身）
     * @param comCode 机构代码
     * @param exceptComCode 除外机构代码
     * @return PrpDcompanyDto列表
     * @throws Exception
     * @author 李冬松
     * @date 11:39 2017/11/20
    */
    public List<String> findByComCode(String comCode,String exceptComCode) throws Exception {
        //TODO 去掉记时日志
        Long n1=System.currentTimeMillis();
        //修改优化代码
        List<String> list=prpDcompanyDao.selectAllUpperComCode(comCode);
        Long n2=System.currentTimeMillis();
        System.out.println((n2-n1)+"毫秒 findByComCode");
        return list;

        //原代码
//        Collection companys = new ArrayList();
//        PrpDcompanyKey prpDcompanyKey=new PrpDcompanyKey(comCode);
//        PrpDcompany prpDcompany = prpDcompanyDao.findOne(prpDcompanyKey);
//        PrpDcompanyDto prpDcompanyDto=convert(prpDcompany,PrpDcompanyDto.class);
//        if (prpDcompanyDto != null) {
//            companys = findByComCodeWithoutUpper(prpDcompanyDto, comCode, exceptComCode);
//        }
//        return companys;
    }
    /**
     * 获取机构（包含本身）(不支持UPPER_COMPANY)
     * @param comCode  机构代码
     * @param exceptComCode  除外机构代码
     * @return PrpDcompanyDto列表
     * @throws Exception
     * @author 李冬松
     * @date 11:39 2017/11/20
     */
    private Collection findByComCodeWithoutUpper(PrpDcompanyDto prpDcompanyDto,String comCode, String exceptComCode) throws Exception {
        Collection companys = new ArrayList();
        String conditions = "";
        if (prpDcompanyDto != null) {
            Query query = null;
            // 如果机构代码不在除外机构代码列表中，则查询下级，否则不查询
            if (exceptComCode.indexOf(comCode) == -1) {
                //添加自身
                companys.add(prpDcompanyDto);
                conditions = "select p.* from prpdcompany p where p.UpperComCode = :comCode ";
                query = entityManager.createNativeQuery(conditions, PrpDcompany.class);
                query.setParameter("comCode", comCode);
                // 如果conditons不为空,则进行以下递归处理
                if (!conditions.equals("")) {
                    List<PrpDcompany> prpDcompanyList = query.getResultList();
                    List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<>();
                    convertCollection(prpDcompanyList, prpDcompanyDtoList, PrpDcompanyDto.class);
                    for (PrpDcompanyDto p : prpDcompanyDtoList) {
                        if (exceptComCode.indexOf(p.getComCode()) == -1 && !p.getComCode().equals(p.getUpperComCode())) {
                            companys.add(p);
                            findByComCodeRecursive(companys, p.getComCode(), exceptComCode);
                        }
                    }
                }
            }
        }
        return companys;
    }
    /**
     * 递归添加下级机构
     * @param comCode 机构代码
     * @param exceptComCode  除外机构代码
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 11:39 2017/11/20
     */
    private void findByComCodeRecursive(Collection companys, String comCode, String exceptComCode
                                        ) throws Exception {
        String conditions = "";

        conditions = "select p.* from prpdcompany p where  p.upperComCode=:comCode ORDER BY p.comCode";
        Query query=entityManager.createNativeQuery(conditions,PrpDcompany.class);
        query.setParameter("comCode",comCode);
        List<PrpDcompany> prpDcompanyList = query.getResultList();
        List<PrpDcompanyDto> prpDcompanyDtoList=new ArrayList<>();
        convertCollection(prpDcompanyList,prpDcompanyDtoList,PrpDcompanyDto.class);
        for (PrpDcompanyDto prpDcompanyDto:prpDcompanyDtoList) {

            if (exceptComCode.indexOf(prpDcompanyDto.getComCode()) == -1
                    && !prpDcompanyDto.getComCode().equals(prpDcompanyDto.getUpperComCode())) {
                companys.add(prpDcompanyDto);
                findByComCodeRecursive(companys, prpDcompanyDto.getComCode(), exceptComCode);
            }
        }
    }
    /**
    * 判断表中是否有该字段
    * @param tableName 表名
    * @param columnName 字段名
    * @return boolean 有返回true,无返回false
    * @throws Exception
    * @author 李冬松
    * @date 11:48 2017/11/20
    */
    public boolean hasColumn(String tableName, String columnName)  {
        boolean blnFoundFlag = false;
        List<PrpDpowerTable> prpDpowerTableList=null;
        String sqlString = " SELECT p.* FROM PrpDpowerTable p WHERE p.tableName=:tableName and p.tableColumn=:columnName";
        Query query=entityManager.createNativeQuery(sqlString.toString(),PrpDpowerTable.class);
        query.setParameter("tableName",tableName);
        query.setParameter("columnName",columnName);
        prpDpowerTableList=query.getResultList();
        if (prpDpowerTableList!=null&&prpDpowerTableList.size()!=0){
            blnFoundFlag = true;
        }
        return blnFoundFlag;
    }
    /**
    * 获取险种权限
     * 说明
    * @param addCodePowerConditionDto
    * @return java.lang.String 返回险种权限的SQL
    * @throws Exception
    * @author 李冬松
    * @date 16:11 2017/12/21
    */
    @Override
    public String addRiskCodePermit(AddCodePowerConditionDto addCodePowerConditionDto) throws Exception {
        String userCode=addCodePowerConditionDto.getUserCode();
        String loginComCode=addCodePowerConditionDto.getLoginComCode();
        String loginGradeCodes=addCodePowerConditionDto.getLoginGradeCodes();
        String tableName1=addCodePowerConditionDto.getTableName1();
        StringBuffer buffer=new StringBuffer();
        //原生SQL
        StringBuffer riskCodeSql=new StringBuffer("select u.* from utiuserGradePower u where u.userCode like :userCode" +
                " and u.comCode like :comCode and u.gradeCode like :gradeCode and u.serialNo=1" );
        Query riskCodeQuery=entityManager.createNativeQuery(riskCodeSql.toString(),UtiUserGradePower.class);
        userCode="%"+userCode+"%";
        loginComCode = "%"+loginComCode+"%";
        loginGradeCodes="%"+loginGradeCodes+"%";
        riskCodeQuery.setParameter("userCode",userCode);
        riskCodeQuery.setParameter("comCode",loginComCode);
        riskCodeQuery.setParameter("gradeCode",loginGradeCodes);
        List<UtiUserGradePower> utiUserGradePowerList=riskCodeQuery.getResultList();
        if(utiUserGradePowerList==null||utiUserGradePowerList.size()==0){
            throw new DataVerifyException("该用户&机构&岗位没有对应的险种权限！");
        }
        UtiUserGradePower utiUserGradePower=utiUserGradePowerList.get(0);
        //因为查出来的结果只会有一条记录，所以只要判断第一个元素就可以了
        if(!utiUserGradePower.getPermitRiskCode().equals("*")){
            buffer.append(" AND "+tableName1+".riskCode IN(");
            String[] riskCodes=utiUserGradePower.getPermitRiskCode().split(",");
            for(int i=0;i<riskCodes.length;i++){
                if(i==riskCodes.length-1){
                    buffer.append("'"+riskCodes[i]+"'");
                }else {
                    buffer.append("'"+riskCodes[i]+"',");
                }
            }
            buffer.append(")");
        }
        return buffer.toString();
    }

    /**
     * 获取机构权限的list
     *
     * @param addCodePowerConditionDto
     * @return
     * @author: 何伟东
     * @date: 2018/1/5 16:02
     */
    @Override
    public List<String> getCodePowerList(AddCodePowerConditionDto addCodePowerConditionDto) throws Exception {
        long n1=System.currentTimeMillis();
        String codeSql = this.addCodePower(addCodePowerConditionDto);
        List<String> codeList=null;
        if (StringUtils.isNotEmpty(codeSql)) {
            String[] codeArr = codeSql.replaceAll("[^0-9^,]", "").split(",");
            codeList = Arrays.asList(codeArr);
        }
        long n2=System.currentTimeMillis();

        System.out.println((n2-n1)+" 毫秒  getCodePowerList");
        return codeList;
    }

    /**
     * 获取子级机构信息
     *
     * @param param loginComCode-机构代码；comCode-机构代码;userCode-用户代码
     * @return 所有子级机构信息
     * @author: 何伟东
     * @date: 2018/1/5 16:02
     */
    @Override
    public List<SubComDto> getSubComList(Map<String, String> param) throws Exception {
        if (param == null || param.size() < 1){
            throw new DataVerifyException("入参不能为空");
        }
        String comCode = param.get("comCode");
        if (StringUtils.isEmpty(comCode)){
            throw new DataVerifyException("机构代码不能为空");
        }
        String loginComCode = param.get("loginComCode");
        if (StringUtils.isEmpty(loginComCode)){
            throw new DataVerifyException("登录机构代码不能为空");
        }
        String userCode = param.get("userCode");
        if (StringUtils.isEmpty(userCode)){
            throw new DataVerifyException("用户代码不能为空");
        }
        // 查询该机构的所有子级机构
        Map<String,String> condition = new HashMap<>(1);
        condition.put("comCode",comCode);
        List<SubComDto> subComDtos = prpDcompanyApi.querySubComInfo(condition);
        if ((!userCode.equals(UtiGroupServiceImpl.userCode)) || (!loginComCode.equals(UtiGroupServiceImpl.loginComCode)) || UtiGroupServiceImpl.powerComCode == null) {
            AddCodePowerConditionDto conditionDto = new AddCodePowerConditionDto();
            conditionDto.setLoginComCode(loginComCode);
            conditionDto.setUserCode(userCode);
            conditionDto.setTableName("PrpDcompany");
            conditionDto.setUserCodeFields("userCode");
            conditionDto.setComCodeFields("comCode");
            // todo 暂无法获取岗位代码,写为固定值
            conditionDto.setLoginGradeCodes("127");
            UtiGroupServiceImpl.powerComCode = this.getCodePowerList(conditionDto);
            UtiGroupServiceImpl.userCode = userCode;
            UtiGroupServiceImpl.loginComCode = loginComCode;
        }
        // 把用户可以操作的机构状态改为1
        subComDtos.forEach(subComDto -> {
            String subComCode = subComDto.getComCode();
            int index = UtiGroupServiceImpl.powerComCode.indexOf(subComCode);
            if (index >= 0) {
                subComDto.setIsOperate("1");
            }
        });
        return subComDtos;
    }
}