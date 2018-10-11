package com.sinosoft.dms.core.billno.service.impl;

import com.sinosoft.agriclaim.api.compensatemanage.PrpLCompensateApi;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriprpall.api.endorsemanage.PrpPheadApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.PrpPolicyFeeNoticeApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpPolicyFeeNoticeDto;
import com.sinosoft.agriprpall.api.proposalmanage.PrpTmainApi;
import com.sinosoft.dms.api.billno.dto.*;
import com.sinosoft.dms.core.billno.service.BillNoService;
import com.sinosoft.dms.core.dict.dao.PrpGroupDao;
import com.sinosoft.dms.core.dict.dao.PrpMaxNoDao;
import com.sinosoft.dms.core.dict.dao.PrpMaxUseDao;
import com.sinosoft.dms.core.dict.dao.UtiKeyDao;
import com.sinosoft.dms.core.dict.entity.*;
import com.sinosoft.framework.agri.core.utils.UUIDUtil;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.UserInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-10 11:36:52.998
 * @description UtiKeyCore接口实现
 */
@Service
public class BillNoServiceImpl extends BaseServiceImpl implements BillNoService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BillNoServiceImpl.class);

    @Autowired
    private UtiKeyDao utiKeyDao;
    @Autowired
    private PrpMaxNoDao prpMaxNoDao;
    @Autowired
    private PrpGroupDao prpGroupDao;
    @Autowired
    private PrpMaxUseDao prpMaxUseDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpPheadApi prpPheadApi;
    @Autowired
    private PrpTmainApi prpTmainApi;
    @Autowired
    private PrpCmainApi prpCmainApi;
    @Autowired
    private PrpPolicyFeeNoticeApi prpPolicyFeeNoticeApi;
    @Autowired
    private BillNoService billNoService;
    @Autowired
    private PrpLCompensateApi prpLCompensateApi;


    /***
     * 投保单号与保单号生成 ，短信号，模板号，条款号，清单号，批次号
     *    1.拼接成组号
     *    2.获取最大单号
     *    3.删除老单号
     *    4.生成投保单号或保单号
     *    5.校验投保单号或保单号的有效性
     * @author: 钱浩
     * @date: 2017/10/13 18:21
     * @param   tableName 表单
     * @param  riskCode 险种
     * @param iComCode 机构代码
     * @param  iYear 年份
     * @param userCode 用户代码
     * @return ResponseDto： 投保单号或保单号
     * @throws Exception
     */
    @Override
    public Map<String, String> getBillNo(String tableName, String riskCode, String iComCode, String iYear, String userCode) throws Exception {
        if (StringUtils.isEmpty(tableName)) {
            throw new Exception("表名不能为空");
        }
        String ttyCode = UUIDUtil.create8Id();
        String groupNo;
        String strMaxNo = "";
        String strNextMaxNo = "";
        UserInfo userinfo = SinoRequestContext.getCurrentContext().getUser();
        userCode = userinfo.getUserCode();
        String strNewNo = "";
        int index = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = simpleDateFormat.format(new Date());
        if (tableName.trim().equalsIgnoreCase("prpphead") || tableName.trim().equalsIgnoreCase("insuremainlist") || tableName.trim().equalsIgnoreCase("prppaymain") || tableName.trim().equalsIgnoreCase("smstemplate") || tableName.trim().equalsIgnoreCase("Insuranceexempts") || tableName.trim().equalsIgnoreCase("Insurance")) {
            iYear = date;
        }
        PrpMaxNoDto prpMaxNoDto = new PrpMaxNoDto();
        PrpMaxUseDto prpMaxUseDto = new PrpMaxUseDto();
        int intNoLength, intChgLength;
        int intMaxNo;
        int i;
        Long intCount;
        String strYear = String.valueOf(iYear);
        // 1.拼接成组号
        groupNo = getGroupNo(tableName, riskCode, iComCode, strYear, userCode);
        if (groupNo == null || groupNo.length() == 0) {
            return null;
        }
        int intMaxLength = 3;
        String strCertiNoMax = "";


        while (true) {
            List<MPrpMaxNoUntiDto> mPrpMaxNoUntiDtoList = prpMaxNoDao.queryPrpMaxNo(groupNo, tableName);
            //2.获取最大单号
            MPrpMaxNoUntiDto mPrpMaxNoUntiDto = mPrpMaxNoUntiDtoList.get(0);
            if (mPrpMaxNoUntiDto.getCount() == 0) {
                //调整单号处理规则，当没有做单号初始化的时候，自动初始化单号 modify by luyang 2006-4-28
                if (tableName.trim().equalsIgnoreCase("prpdclausecode") || tableName.trim().equalsIgnoreCase("smstemplate")) { //条款号
                    //4位序列号
                    prpMaxNoDto.setMaxNo("0001");
                    prpMaxNoDto.setFlag("0");
                } else if (tableName.trim().equalsIgnoreCase("prpmmodelmain")) {
                    prpMaxNoDto.setMaxNo("001");
                    prpMaxNoDto.setFlag("0");
                } else {
                    prpMaxNoDto.setMaxNo("000001");
                    prpMaxNoDto.setFlag("0");
                }
                prpMaxNoDto.setGroupNo(groupNo);
                prpMaxNoDto.setTableName(tableName);
                PrpMaxNo prpMaxNo = convert(prpMaxNoDto, PrpMaxNo.class);
                prpMaxNoDao.save(prpMaxNo);
                mPrpMaxNoUntiDtoList = prpMaxNoDao.queryPrpMaxNo(groupNo, tableName);
                mPrpMaxNoUntiDto = mPrpMaxNoUntiDtoList.get(0);
            }
            strMaxNo = mPrpMaxNoUntiDto.getMaxNo();
            strNextMaxNo = mPrpMaxNoUntiDto.getMinNo();
            intCount = mPrpMaxNoUntiDto.getCount();
            if (strMaxNo.trim().equals(strNextMaxNo.trim())) {
                intNoLength = strNextMaxNo.length();
                intMaxNo = Integer.parseInt(strNextMaxNo) + 1;
                strMaxNo = String.valueOf(intMaxNo);
                /*if (tableName.trim().equalsIgnoreCase("fcorepolicy") ||
                        tableName.trim().equalsIgnoreCase("fporeendor") ||
                        tableName.trim().equalsIgnoreCase("florepay") ||
                        tableName.trim().equalsIgnoreCase("fzacc") ||
                        tableName.trim().equalsIgnoreCase("fcirepolicy") ||
                        tableName.trim().equalsIgnoreCase("fpireendor") ||
                        tableName.trim().equalsIgnoreCase("flirepay")) {
                    intChgLength = 5 - strMaxNo.length();//终端版统一为intNoLength =6
                    strMaxNo = newString("0", intChgLength) + strMaxNo;
                } else*/
                if (tableName.trim().equalsIgnoreCase("prpphead") || tableName.trim().equalsIgnoreCase("insuremainlist") || tableName.trim().equalsIgnoreCase("prppaymain") || tableName.trim().equalsIgnoreCase("Insuranceexempts") || tableName.trim().equalsIgnoreCase("Insurance")) {
                    strMaxNo = StringUtils.leftPad(strMaxNo, 6, "0");
                } else if (tableName.trim().equalsIgnoreCase("prpdclausecode") || tableName.trim().equalsIgnoreCase("smstemplate")) {
                    strMaxNo = StringUtils.leftPad(strMaxNo, 4, "0");
                } else if (tableName.trim().equalsIgnoreCase("prpmmodelmain")) {//后期改造4位
                    strMaxNo = StringUtils.leftPad(strMaxNo, 4, "0");
                } else {
                    intChgLength = 6 - strMaxNo.length();
                    strMaxNo = newString("0", intChgLength) + strMaxNo;
                }
                //向prpMaxNo表中插入新生成的单号
                prpMaxNoDto.setGroupNo(groupNo);
                prpMaxNoDto.setTableName(tableName);
                prpMaxNoDto.setMaxNo(strMaxNo);
                prpMaxNoDto.setFlag("0");
                PrpMaxNo prpMaxNo = convert(prpMaxNoDto, PrpMaxNo.class);
                try {
                    prpMaxNoDao.save(prpMaxNo);
                } catch (Exception ex) {
                    continue;
                }
            }
            try {
                String maxNo = strNextMaxNo;
                //3.删除老单号
                prpMaxNoDao.delete(new PrpMaxNoKey(groupNo, tableName, maxNo));
            } catch (Exception ex) {
                continue;
            }
            //向prpMaxUse表中插入最小的单号
            prpMaxUseDto.setGroupNo(groupNo);
            prpMaxUseDto.setTableName(tableName);
            prpMaxUseDto.setMaxNo(strNextMaxNo);
            prpMaxUseDto.setTtyCode(ttyCode);
            prpMaxUseDto.setFlag("0");
            PrpMaxUse prpMaxUse = convert(prpMaxUseDto, PrpMaxUse.class);
            try {
                prpMaxUseDao.save(prpMaxUse);
            } catch (Exception ex) {
                continue;
            }
            if (tableName.trim().equals("prpmmodelmain") || tableName.trim().equals("prppaymain") || tableName.trim().equals("Insurance") || tableName.trim().equals("Insuranceexempts")) {
                strNewNo = groupNo + strNextMaxNo;
            } else if (tableName.trim().equals("prpdclausecode") || tableName.trim().equalsIgnoreCase("smstemplate")) {
                strNewNo = groupNo + strNextMaxNo;
            } else if (tableName.trim().equals("prpphead") || tableName.trim().equalsIgnoreCase("insuremainlist")) {
                strNewNo = groupNo + strNextMaxNo;
            } else { //4.生成投保单号或保单号
                strNewNo = pullNo(tableName, strNextMaxNo, groupNo);
            }
            if ("prplcompensate".equals(tableName)) {

                List<PrpLCompensateDto> prpLCompensateDtoList = prpLCompensateApi.queryByRiskCode(riskCode);

                if (prpLCompensateDtoList.size() > 0) {
                    PrpLCompensateDto prpLcompensateDto = prpLCompensateDtoList.get(0);
                    strCertiNoMax = prpLcompensateDto.getCompensateNo();
                }

                int intPos = strCertiNoMax.lastIndexOf('_');
                intMaxNo = 0;

                if (intPos > -1) {
                    strMaxNo = strCertiNoMax.substring(intPos + 1);
                } else {
                    strMaxNo = "0";
                }

                intMaxNo = Integer.parseInt(strMaxNo) + 1;
                String shortStrNewNo = StringUtils.newString("0", intMaxLength - ("" + intMaxNo).length()) + intMaxNo;
                if (shortStrNewNo.length() > intMaxLength) {
                    throw new Exception("too long!");
                }

                strNewNo = strNewNo + "-" + shortStrNewNo;
                Map<String, String> map = new HashMap<String, String>();
                map.put("billNo", strNewNo);
                return map;
            }
            //5.校验投保单号或保单号的有效性
            if (tableName.trim().equals("prppaymain") || tableName.trim().equals("Insurance") || tableName.trim().equals("Insuranceexempts") || tableName.trim().equals("prpmmodelmain") || tableName.trim().equals("prpdclausecode") || tableName.trim().equalsIgnoreCase("smstemplate") || tableName.trim().equalsIgnoreCase("insuremainlist")) {
                break;
            }
            if (checkNo(tableName, strNewNo, groupNo, "0")) {
                break;
            }
            for (i = 0; i < 5; i++) {
                //删除PrpMaxUse表中的单号
                try {
                    String maxNo = strNewNo;
                    prpMaxUseDao.delete(new PrpMaxUseKey(groupNo, tableName, maxNo));
                } catch (Exception ex) {
                    throw (ex);
                } finally {
                    continue;
                }
            }
            ++index;
            //暂时写死，防止无限死循环
            if (index > 1000) {
                throw new DataVerifyException("循环1000次未获取单号，请联系管理员");
            }
        }
        //返回新生成的投保单号或保单号
        Map<String, String> map = new HashMap<String, String>();
        map.put("billNo", strNewNo);
        return map;
    }

    /**
     * @param tableName
     * @param iBillNo
     * @param groupNo
     * @return
     * @throws Exception tableName,strMinNo,groupNo
     * @description 拉长单号
     */
    private String getUikeyNo(String tableName, String iBillNo, String groupNo) throws Exception {
        UtiKey utiKey = utiKeyDao.findOne(new UtiKeyKey(tableName));
        UtiKeyDto utiKeyDto = convert(utiKey, UtiKeyDto.class);
        if (utiKeyDto.getTableName() == null || "".equals(utiKeyDto.getTableName())) {
            return "";
        }
        String billNo = utiKeyDto.getHeadId() + groupNo + iBillNo;

        return billNo;
    }

    /**
     * @param tableName 表代码
     * @param policyNo  保单号
     * @return ResponseDto： 批单号或缴费通知书号
     * @throws Exception
     * @description: 批单，单号生成
     * 1.判断是否该保单号已生成批单号
     * 2.组成批单号
     * @author: 钱浩
     * @date: 2017/10/13 18:22
     */
    @Override
    public String getNo(String tableName, String policyNo) throws Exception {
        if (StringUtils.isEmpty(tableName)) {
            throw new Exception("表名不能为空");
        }
        UtiKeyDto utiKeyDto = new UtiKeyDto();
        int intResult = 0;
        String strCertiNoMax = ""; //从数据库中查询当前最大的单号
        String strCertiNoCurrent = ""; //返回的单号
        String strCondition = "";
        String strMaxNo = ""; //最大的尾号
        String strConditionMax = "";
        String strHeadID = ""; //头字母
        int intEndorsenoMaxLength = 0; //长度限制
        int intMaxLength = 2; //长度限制
        int intPos = 0; //“_”在单号中的位置
        int intMaxNo = 0; //最大的尾号
        tableName = tableName.trim().toLowerCase(); //表名处理
        UtiKey utiKey = utiKeyDao.findOne(new UtiKeyKey(tableName));
        utiKeyDto = convert(utiKey, UtiKeyDto.class);
        if (utiKeyDto.getTableName() == null || "".equals(utiKeyDto.getTableName())) {
            strHeadID = "E";
        } else {
            strHeadID = utiKeyDto.getHeadId();
        }
        if (tableName.equals("prpphead")) //批单
        {
            PrpPheadDto prpPheadDto = new PrpPheadDto();
            //1.判断是否该保单号已生成批单号
            intMaxLength = 2;
            strConditionMax = " "
                    + " WHERE endorseNo LIKE '" + strHeadID + policyNo.substring(1, policyNo.length()) + "-%'";
            Integer index = prpPheadApi.queryMaxEndorseNo(strConditionMax);
            if (index == null) {
                index = 0;
            }
            intEndorsenoMaxLength = index;
            if (intEndorsenoMaxLength == 25) {
                strCondition = ""
                        + "  WHERE endorseNo LIKE '" + strHeadID + policyNo.substring(1, policyNo.length()) + "-%' and length(endorseNo)=25"
                        + " ORDER BY endorseNo DESC";
            } else {
                strCondition = " "
                        + " WHERE endorseNo LIKE '" + strHeadID + policyNo.substring(1, policyNo.length()) + "-%'"
                        + " ORDER BY endorseNo DESC";
            }
            //如果已存在批单号，取批单号
            String endorse = prpPheadApi.queryEndorseNo(strCondition);
            if (endorse != null) {
                strCertiNoMax = endorse;
            }
        } else if (tableName.equals("prppolicyfeenotice")) //缴费通知书
        {
            intMaxLength = 3;


            List<PrpPolicyFeeNoticeDto> prpPolicyFeeNoticeList = prpPolicyFeeNoticeApi.queryByPolicyNo(policyNo);

            for (PrpPolicyFeeNoticeDto PrpPolicyFeeNoticeDto : prpPolicyFeeNoticeList) {
                strCertiNoMax = PrpPolicyFeeNoticeDto.getPolicyFeeNo();
            }
        }
        //键值处理,以下为公用
        if (tableName.equals("prppolicyfeenotice")) {
            if (!"".equals(strCertiNoMax) && strCertiNoMax.length() > 3) {
                int startIndex = strCertiNoMax.length() - 3;
                strMaxNo = strCertiNoMax.substring(startIndex);
            } else {
                strMaxNo = "0";
            }

            intMaxNo = 0;

            intMaxNo = Integer.parseInt(strMaxNo) + 1;
            strCertiNoCurrent = StringUtils.newString("0", intMaxLength - ("" + intMaxNo).length()) + intMaxNo;


            //处理超长
            if (strCertiNoCurrent.length() > intMaxLength) {
                throw new Exception("too long!");
            }

            strCertiNoCurrent = strHeadID + policyNo.substring(1) + strCertiNoCurrent;
        } else {
            intPos = strCertiNoMax.lastIndexOf('-');
            intMaxNo = 0;

            if (intPos > -1) {
                strMaxNo = strCertiNoMax.substring(intPos + 1);
            } else {
                strMaxNo = "0";
            }
            intMaxNo = Integer.parseInt(strMaxNo) + 1;
            strCertiNoCurrent = StringUtils.newString("0", intMaxLength - ("" + intMaxNo).length()) + intMaxNo;
            //2.组成批单号
            strCertiNoCurrent = strHeadID + policyNo.substring(1) + "-" + strCertiNoCurrent;
        }
        return strCertiNoCurrent;
    }


    /**
     * @param tableName
     * @param riskCode
     * @param iComCode
     * @param iYear
     * @return
     * @throws Exception
     * @description 投保单，保单 组成单号
     */
    private String getGroupNo(String tableName, String riskCode, String iComCode, String iYear, String userCode) throws Exception {
        String groupNo = "";
        String subGroupNo = "";
        PrpGroupDto prpGroupDto = new PrpGroupDto();
        tableName = tableName.toLowerCase();
        if(riskCode!=null){
            riskCode = riskCode.toUpperCase();
        }
        /*if (tableName.trim().equalsIgnoreCase("fcorepolicy") ||
                tableName.trim().equalsIgnoreCase("fporeendor") ||
                tableName.trim().equalsIgnoreCase("florepay") ||
                tableName.trim().equalsIgnoreCase("fzacc") ||
                tableName.trim().equalsIgnoreCase("fcirepolicy") ||
                tableName.trim().equalsIgnoreCase("fpireendor") ||
                tableName.trim().equalsIgnoreCase("flirepay")) {
            //分保业务号：I/O+险类代码(1位)+业务年度+公司代码(4位)
            //modify by zhaoning20061121 begin Reason:安信需求的单号规则:I/O+险类代码(1位)+公司代码(4位)+业务年度
            if (tableName.trim().equalsIgnoreCase("fcirepolicy"))
                groupNo = "I" + riskCode.substring(0, 1) + iComCode.substring(0, 4) + iYear;
            else
                groupNo = "O" + riskCode.substring(0, 1) + iComCode.substring(0, 4) + iYear;
            //modify by zhaoning20061121 end
        } else */
        if (tableName.trim().equalsIgnoreCase("fjsettle")) {
            //直接业务号:业务年度 + "R"
            groupNo = iYear + "R";
        } else if (tableName.trim().equalsIgnoreCase("prpdgroupinfo")) {
            //直接业务号:业务年度 + "R"
            groupNo = iComCode.substring(0, 6) + iYear + "0000";
        } else if (tableName.trim().equalsIgnoreCase("prpmmodelmain")) { //模板号
            //TB+险种代码+员工代码四位+年份+六位序列号
            if (userCode.length() < 8) {
                userCode = StringUtils.leftPad(userCode, 8, "0");
            } else if (userCode.length() > 8) {
                userCode = userCode.substring(0, 8);
            }
            groupNo = "TB" + riskCode + userCode + iYear;
        } else if (tableName.trim().equalsIgnoreCase("prpdclausecode")) {//条款号
            //TK+险种代码+年份+四位序列号
            groupNo = "TK" + riskCode + iYear;
        } else if (tableName.trim().equalsIgnoreCase("prpphead")) {//批次号
            //PLPG+登陆机构+年月日份+6位序列号
            groupNo = "PLPG" + iComCode.substring(0, 6) + iYear;
        } else if (tableName.trim().equalsIgnoreCase("Insurance")) {//保险责任号
            //PLPG+登陆机构+年月日份+6位序列号
            groupNo = "BX" + iYear;
        } else if (tableName.trim().equalsIgnoreCase("Insuranceexempts")) {//保险免除责任号
            //PLPG+登陆机构+年月日份+6位序列号
            groupNo = "BM" + iYear;
        } else if (tableName.trim().equalsIgnoreCase("smstemplate")) {//短信号
            //DX++年月日份
            groupNo = "DX" + iYear;
        } else if (tableName.trim().equalsIgnoreCase("insuremainlist")) {//清单号
            //QDBH+登陆机构+年月日份+6位序列号
            groupNo = "QDBH" + riskCode + iComCode.substring(0, 6) + iYear;
        } else if (tableName.trim().equalsIgnoreCase("prppaymain")) {//支付号
            //Z+机构代码+年月日+6位序列号
            groupNo = "Z" + iComCode.substring(0, 6) + iYear;
        } else {
            //直接业务号
            if (riskCode.length() >= 4) riskCode = riskCode.substring(0, 4);
            if (riskCode.length() == 3) riskCode = riskCode + "0";
            //modify by luyang reason: 06年度以后使用新的单号规则 begin
            int intYear = 0;
            if (iYear != null && !iYear.equals("")) {
                intYear = Integer.parseInt(iYear);
            }
      /*
      if( intYear<2006 ){
        //阳光生成单号规则更改：公司代码（8位）+险种代码（4位）+业务年度（2位）
        strGroupNo = iComCode.substring(0,8) + iRiskCode + iYear.substring(2);
      }else{
        //阳光生成单号规则更改：公司代码（4位）+险种代码（4位）+业务年度（4位）
        strGroupNo = iComCode.substring(0,4) + iRiskCode + iYear;
      }
      */
            //strGroupNo = iRiskCode.substring(0,4)+iYear+iComCode.substring(0,8);
            //strGroupNo = iRiskCode+iYear+iComCode.substring(0,6);
            //modify by zhaoning20061121 Reason:安信需求的单号规则
            groupNo = riskCode + iComCode.substring(0, 6) + iYear;
            //modify by luyang reason: 06年度以后使用新的单号规则 begin
        }
        subGroupNo = groupNo;
        List<PrpGroupDto> prpGroupDtoList = prpGroupDao.queryPrpGroup(subGroupNo);
        if (prpGroupDtoList != null && prpGroupDtoList.size() != 0) {
            PrpGroupDto prpGroupDto1 = prpGroupDtoList.get(0);
            groupNo = prpGroupDto1.getGroupNo();
        }
        return groupNo;
    }

    /**
     * @param iString
     * @param iTimes
     * @return
     * @description 工具
     */
    private String newString(String iString, int iTimes) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < iTimes; i++) {
            buffer.append(iString);
        }
        return buffer.toString();
    }

    /**
     * @param iTableName
     * @param iBillNo
     * @param iGroupNo
     * @param iCheckFlag
     * @return
     * @throws Exception
     * @description 检验单号
     */
    private boolean checkNo(String iTableName, String iBillNo, String iGroupNo, String iCheckFlag) throws Exception {
        int intResult = 0;
        int intCount = 0;
        boolean blnResult = false;
        String strFieldName = "", strWherePart = "";
        String strSql = "";
        String strGroupNo = "", strMaxNo = "", strBillNo = "";
        String[] strPickNo = new String[3];

        //校验单号的合法性
        String tableName = iTableName;
        UtiKey utiKey = utiKeyDao.findOne(new UtiKeyKey(tableName));
        UtiKeyDto utiKeyDto = convert(utiKey, UtiKeyDto.class);
        if(utiKeyDto!=null && !"".equals(utiKeyDto)) {
            if (utiKeyDto.getTableName() == null || "".equals(utiKeyDto.getTableName())) {
                blnResult = false;
                return blnResult;
            }
            strFieldName = utiKeyDto.getFieldName();
        }
        //将单号分离成单号头+分组+流水号
        strPickNo = pickNo(iTableName, iBillNo);
        strGroupNo = strPickNo[1];
        strMaxNo = strPickNo[2];
        //拉长单号
        iBillNo = pullNo(iTableName, iBillNo, strGroupNo);
        if (iCheckFlag.trim().equals("2")) {
            blnResult = true;
            return blnResult;
        }
        //获取所有的分组
        strWherePart = "GroupNo ='" + strGroupNo.trim() + "'";
        String groupNo = strGroupNo.trim();
        List<PrpGroupDto> prpGroupDtos = prpGroupDao.queryAllPrpGroup(groupNo);
        Map<String, String> map = new HashMap<String, String>();
        if (iTableName.trim().equalsIgnoreCase("prptmain")) {
            map.put("proposalNo", iBillNo);
            intCount = prpTmainApi.queryProposalNo(map);
            map.clear();
        } else if (iTableName.trim().equalsIgnoreCase("prpcmain")) {
            map.put("policyNo", iBillNo);
            intCount = prpCmainApi.queryPolicyNo(map);
            map.clear();
        }
        for (int i = 0; i < prpGroupDtos.size(); i++) {
            strBillNo = strPickNo[0] + prpGroupDtos.get(i).getSubGroupNo().trim()
                    + strMaxNo;
            strSql += " OR " + strFieldName.trim() + "='" + strBillNo.trim() + "'";
        }
        if (intCount > 1) {
            blnResult = false;
        } else if ((intCount == 1) && (iCheckFlag.trim().equals("0"))) {
            blnResult = false;
        } else if ((intCount == 0) && (iCheckFlag.trim().equals("1"))) {
            blnResult = false;
        } else if ((intCount == 0) && (iCheckFlag.trim().equals("2"))) {
            blnResult = false;
        } else {
            blnResult = true;
        }
        return blnResult;
    }

    /**
     * @param tableName
     * @param iBillNo
     * @param groupNo
     * @return
     * @throws Exception tableName,strMinNo,groupNo
     * @description 拉长单号
     */
    private String pullNo(String tableName, String iBillNo, String groupNo) throws Exception {
        UtiKeyDto utiKeyDto = new UtiKeyDto();
        String strHeadID = "", strColLength = "";
        String strBillNo = "";
        int intResult = 0;
        int intNoLength = 0, intChgLength = 0;
        int intLength = 0;

        strBillNo = iBillNo;
        UtiKey utiKey = utiKeyDao.findOne(new UtiKeyKey(tableName));
        utiKeyDto = convert(utiKey, UtiKeyDto.class);
        if(utiKeyDto!=null && !"".equals(utiKeyDto)) {
            if (utiKeyDto.getTableName() == null || "".equals(utiKeyDto.getTableName())) {
                return strBillNo;
            }
            strHeadID = utiKeyDto.getHeadId();
            strColLength = String.valueOf(utiKeyDto.getCollength());
        }
        //单号的总长度
        intLength = groupNo.length() + strColLength.length() + 1;
        if (iBillNo.length() >= intLength) {
            return iBillNo;
        }
        intNoLength = iBillNo.length();
        intChgLength = strColLength.length() - intNoLength;
        iBillNo = newString("0", intChgLength) + iBillNo;

        iBillNo = strHeadID.trim() + groupNo.trim() + iBillNo.trim();


        return iBillNo;
    }

    /**
     * 将单号分离成单号头+分组+流水号
     *
     * @param iTableName
     * @param iBillNo
     * @return String[]
     * @throws Exception
     * @author: 钱浩
     */
    public String[] pickNo(String iTableName, String iBillNo) throws Exception {
        String[] strPickNo = new String[3];
        String strGroupNo = "";
        String strSerialNo = "";

        if (iTableName.trim().equalsIgnoreCase("fcorepolicy") ||
                iTableName.trim().equalsIgnoreCase("fporeendor") ||
                iTableName.trim().equalsIgnoreCase("florepay") ||
                iTableName.trim().equalsIgnoreCase("fzacc")) {
            if (iBillNo.length() == 16) {
                strGroupNo = iBillNo.substring(1, 10);
                strSerialNo = iBillNo.substring(10);
            }
        } else if (iTableName.trim().equalsIgnoreCase("fjsettle")) {
            if (iBillNo.length() == 8) {
                strGroupNo = iBillNo.substring(0, 4);
                strSerialNo = iBillNo.substring(4, 7);
            }
        } else if (iTableName.trim().equalsIgnoreCase("prpdgroupinfo")) {
            if (iBillNo.length() == 21) {
                strGroupNo = iBillNo.substring(1, 15);
                strSerialNo = iBillNo.substring(15);
            }
        } else if (!iTableName.trim().equalsIgnoreCase("prpphead")) {
            if (iBillNo.length() == 21) {
                strGroupNo = iBillNo.substring(1, 15);
                strSerialNo = iBillNo.substring(15);
            } else if (iBillNo.length() == 19) {
                strGroupNo = iBillNo.substring(1, 13);
                strSerialNo = iBillNo.substring(13);
            }
        }

        String subGroupNo = strGroupNo;
        List<PrpGroupDto> prpGroupDtoList = prpGroupDao.queryPrpGroup(subGroupNo);
        if (prpGroupDtoList != null && prpGroupDtoList.size() != 0) {
            PrpGroupDto prpGroupDto1 = prpGroupDtoList.get(0);
            strGroupNo = prpGroupDto1.getGroupNo();
        }
        strPickNo[0] = iBillNo.substring(0, 1);
        strPickNo[1] = strGroupNo;
        strPickNo[2] = strSerialNo;
        return strPickNo;
    }


    /**
     * 根据条件删除PrpMaxUse表里面的单号
     *
     * @param groupNo
     * @param tableName
     * @param maxNo
     * @throws Exception
     * @author: 宋振振
     * @date: 2017/11/8 8:57
     */
    @Transactional
    public void deleteNo(String groupNo, String tableName, String maxNo) throws Exception {
        if (StringUtils.isEmpty(groupNo) && StringUtils.isEmpty(tableName) && StringUtils.isEmpty(maxNo)) {
            throw new DataVerifyException("入参不能为空！");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Delete From PrpMaxUse p Where p.groupNo ='").append(groupNo).append("' And p.tableName ='").append(tableName)
                .append("' And p.maxNo ='").append(maxNo).append("'");

        Query dataQuery = entityManager.createQuery(stringBuilder.toString());
        dataQuery.executeUpdate();
    }

    /**
     * 生成清单号
     *
     * @param insureListCode 清单号
     * @param riskCode       险种
     * @param areasCode      地域编码
     * @return 清单号
     * @throws Exception
     * @author 王心洋
     * @date 2017年10月19日 下午3:19:42
     */
    @Override
    public String createInsuranceCode(String insureListCode, String riskCode, String areasCode) throws Exception {
        String insuranceCode;
        Date currentTime = new Date();
        String pioDate = new SimpleDateFormat("yyMMddHHmmss").format(currentTime);
        if (!org.apache.commons.lang3.StringUtils.isEmpty(insureListCode)) {
            insuranceCode = insureListCode;
        } else {
            insuranceCode = "1" + riskCode + areasCode + pioDate;
        }

        return insuranceCode;
    }


    /**
     * 成功后删除获取的单号
     *
     * @param iTableName 表名
     * @param iBillNo    单号
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/23 下午 17:45
     */
    @Transactional
    public void deleteBillNo(String iTableName, String iBillNo) throws Exception {
        if (StringUtils.isEmpty(iTableName) && StringUtils.isEmpty(iBillNo)) {
            throw new DataVerifyException("入参不能为空！");
        }
        String tableName = iTableName;
        String groupNo = "";
        String maxNo = "";
        String[] strPickNo = new String[3];
        //根据strBillNo的2~16位获取组号
        strPickNo = pickNo(iTableName, iBillNo);
        groupNo = strPickNo[1];
        maxNo = strPickNo[2];
        //删除maxuse中的最大号记录
        StringBuffer buffer = new StringBuffer();
        buffer.append(" delete from PrpMaxUse p where p.groupNo=:groupNo and p.tableName=:tableName and  maxNo=:maxNo ");
        Query query = entityManager.createQuery(buffer.toString());
        query.setParameter("groupNo", groupNo);
        query.setParameter("tableName", tableName);
        query.setParameter("maxNo", maxNo);
        query.executeUpdate();
    }

    /**
     * 放回新单号
     * @author: 王保良
     * @date: 2017/12/11 下午 17:45
     * @param tableName 表名
     * @param billNo 单号
     * @throws Exception
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void putNo(String tableName, String billNo) throws Exception {
        if (StringUtils.isEmpty(tableName)){
            throw new DataVerifyException("请传入tableName");
        }
        if (StringUtils.isEmpty(billNo)){
            throw new DataVerifyException("请传入billNo");
        }
        String groupNo="";
        String maxUse="";
        String[] maxMinNo=new String[3];
        String[] pickNo=new String[3];
        int intResult=0;

        //修改取号规则,批单号不放在prpmaxNo中,而是由程序实现,有保单号拼接而成
        if (!tableName.equalsIgnoreCase("prpphead")){
            pickNo=billNoService.pickNo(tableName,billNo);
            groupNo=pickNo[1];
            maxUse=pickNo[2];
            List<MPrpMaxNoUntiDto> mPrpMaxNoUntiDtoList=prpMaxNoDao.queryPrpMaxNo(groupNo,tableName);
            MPrpMaxNoUntiDto mPrpMaxNoUntiDto=mPrpMaxNoUntiDtoList.get(0);
            maxMinNo[0]=mPrpMaxNoUntiDto.getMaxNo();
            maxMinNo[1]=mPrpMaxNoUntiDto.getMinNo();
            maxMinNo[2]=String.valueOf(mPrpMaxNoUntiDto.getCount());

            prpMaxUseDao.deleteByCondition(groupNo,tableName,maxUse);

            if (Integer.parseInt(maxUse)+1==Integer.parseInt(maxMinNo[0])){
                prpMaxNoDao.deleteByCondition(groupNo,tableName,maxUse);
                PrpMaxNo prpMaxNo=new PrpMaxNo();
                prpMaxNo.setGroupNo(groupNo);
                prpMaxNo.setTableName(tableName);
                prpMaxNo.setMaxNo(maxUse);
                prpMaxNoDao.save(prpMaxNo);
            }
            if (Integer.parseInt(maxUse)+1<Integer.parseInt(maxMinNo[0])){
                PrpMaxNo prpMaxNo=new PrpMaxNo();
                prpMaxNo.setGroupNo(groupNo);
                prpMaxNo.setTableName(tableName);
                prpMaxNo.setMaxNo(maxUse);
                prpMaxNo.setFlag("0");
                prpMaxNoDao.save(prpMaxNo);
            }

        }
    }

}