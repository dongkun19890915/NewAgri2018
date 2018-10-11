package com.sinosoft.agriclaim.core.paymentmanage.service.impl;

import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.paymentmanage.service.PaymentGetNoUtilService;
import com.sinosoft.dms.api.dict.PrpMaxNoApi;
import com.sinosoft.dms.api.dict.PrpMaxUseApi;
import com.sinosoft.dms.api.dict.UtiKeyApi;
import com.sinosoft.dms.api.dict.dto.PrpMaxNoDto;
import com.sinosoft.dms.api.dict.dto.PrpMaxUseDto;
import com.sinosoft.dms.api.dict.dto.UtiKeyDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentGetNoUtilImpl extends BaseCustomServiceImpl implements PaymentGetNoUtilService{
    @Autowired
    private PrpLCompensateDao prpLCompensateDao;
    @Autowired
    private UtiKeyApi utiKeyApi;
    @Autowired
    private PrpMaxNoApi prpMaxNoApi;
    @Autowired
    private PrpMaxUseApi prpMaxUseApi;

    /**
     * （获取一个新的编号）
     * @author: 王志文
     * @date: 2017/12/27 11:45
     * @param iTableName 表名
     * @param iRiskCode 险种代码
     * @param iComCode 机构代码
     * @param iYear 当前年份
     * @return 新的编号
     */
    public String getNo(String iTableName,String iRiskCode,String iComCode,int iYear){
        PrpMaxNoDto prpMaxNoDto;
        PrpMaxUseDto prpMaxUseDto;
        UtiKeyDto utiKeyDto;
        String strGroupNo;
        String strMaxNo, strMinNo, strNewNo;
        int intMaxNo;
        String strYear = String.valueOf(iYear);
        //拼接成组号
        //根据单号规则获取单号编组
        strGroupNo = combineGroupNo(iTableName, iRiskCode, iComCode, strYear);
        //获取单号设定的实际编组
        String strCertiNoMax = "";
        int intMaxLength = 3;
        //1)计算书的取号
        if (iTableName.equals("prplcompensate")) {
            //当是计算书的情况下，IRiskCode传入的立案号码，所以可以根据立案号码来计算需要的序号。
            List<PrpLCompensate> prpLCompensateList = prpLCompensateDao.queryAllByClaimNo(iRiskCode);
            if (prpLCompensateList.size() > 0) {
                PrpLCompensateDto prpLcompensateDto = this.convert(prpLCompensateList.get(0),PrpLCompensateDto.class);
                strCertiNoMax = prpLcompensateDto.getCompensateNo();
            }

            int intPos = strCertiNoMax.lastIndexOf('-');

            if (intPos > -1) {
                strMaxNo = strCertiNoMax.substring(intPos + 1);
            } else {
                strMaxNo = "0";
            }
            intMaxNo = Integer.parseInt(strMaxNo) + 1;
            int length = intMaxLength - ("" + intMaxNo).length()+ intMaxNo;
            StringBuilder builder = new StringBuilder();
            for (int k = 0; k < length; ++k) {
                builder.append("0");
            }
            strNewNo = builder.toString();
            if (strNewNo.length() > intMaxLength) {
                throw new BusinessException("too long!");
            }
            //计算书是立案号"C"+（2，15）+序号 按照要求，是这么
            //计算书是“6”开头
            strNewNo = "6"+iRiskCode.substring(1) + "-" + strNewNo;
            return strNewNo;
        }

        if (strGroupNo == null || strGroupNo.length() == 0) {
            throw new BusinessException("Bill.getNo未取到组号 ! ");
        }
        //根据表名获取单号描述信息
        utiKeyDto = utiKeyApi.queryByPK(iTableName.trim());
        if (utiKeyDto == null) {
            throw new BusinessException("Bill.getNo未获取到单号描述信息 ! ");
        }
        int intChgLength;
        while (true) {
            String[] strMaxMinNo = new String[3];
            List<Object []> objectList = prpMaxNoApi.queryMaxNoByGroupNoAndTableName(strGroupNo, iTableName);
            if (objectList.size()>0){
                for (Object [] objects: objectList) {
                    strMaxMinNo[0] = (String)objects[0];
                    strMaxMinNo[1] = (String)objects[1];
                    strMaxMinNo[2] = ((Integer)objects[2]).toString();
                }
                if ("0".equals(strMaxMinNo[2])) {
                    PrpMaxNoDto maxNoDto = new PrpMaxNoDto();
                    maxNoDto.setGroupNo(strGroupNo);
                    maxNoDto.setTableName(iTableName);
                    maxNoDto.setMaxNo("000001");
                    maxNoDto.setFlag("0");
                    prpMaxNoApi.save(maxNoDto);
                    strMaxMinNo[0] = "000001";
                    strMaxMinNo[1] = "000001";
                }
            }
            strMaxNo = strMaxMinNo[0];
            strMinNo = strMaxMinNo[1];

            if(strMaxNo.equals("")||strMinNo.equals("")){
                throw new BusinessException("编组" + strGroupNo + "单号没有初始化，请系统管理员维护");
            }
            if (strMaxNo.trim().equals(strMinNo.trim())) {
                intMaxNo = Integer.parseInt(strMinNo) + 1;
                strMaxNo = String.valueOf(intMaxNo);
                intChgLength = utiKeyDto.getCollEngth() - strMaxNo.length();
                if (intChgLength < 0){
                    intChgLength = 0;
                }
                StringBuilder builder = new StringBuilder();
                for (int k = 0; k < intChgLength; ++k) {
                    builder.append("0");
                }
                strMaxNo = builder.toString()+strMaxNo ;
                //向prpMaxNo表中插入新生成的单号
                prpMaxNoDto = new PrpMaxNoDto();
                prpMaxNoDto.setGroupNo(strGroupNo);
                prpMaxNoDto.setTableName(iTableName);
                prpMaxNoDto.setMaxNo(strMaxNo);
                prpMaxNoDto.setFlag("0");
                try {
                    prpMaxNoApi.save(prpMaxNoDto);
                }catch (Exception e) {
                    continue;
                }
            }
            try {
                prpMaxNoApi.remove(strGroupNo, iTableName, strMinNo);
            } catch (Exception e) {
                continue;
            }
            //向prpMaxUse表中插入最小的单号
            prpMaxUseDto = new PrpMaxUseDto();
            prpMaxUseDto.setGroupNo(strGroupNo);
            prpMaxUseDto.setTableName(iTableName);
            prpMaxUseDto.setMaxNo(strMinNo);
            prpMaxUseDto.setTtyCode("");
            prpMaxUseDto.setFlag("0");
            try {
                prpMaxUseApi.save(prpMaxUseDto);
            } catch (Exception ex) {
                continue;
            }

            strNewNo = pullNo(iTableName, strMinNo, strGroupNo);
            for (int i = 0; i < 5; i++) {
                //删除PrpMaxUse表中的单号
                try {
//                    prpMaxUseApi.remove(strGroupNo, iTableName, strNewNo);
                }catch (Exception ex) {
                    throw new BusinessException("数据处理异常");
                }
            }
            return strNewNo;
        }
    }

    /**
     * （支付录入获取一个新号中组合分组序号）
     * @author: 王志文
     * @date: 2017/12/15 16:00
     * @param iTableName 表名
     * @param iRiskCode 险种代码
     * @param iComCode 机构代码
     * @param iYear 年份
     * @return 分组序号
     */
    private String combineGroupNo(String iTableName,String iRiskCode,String iComCode,String iYear){
        String strGroupNo;
        iTableName = iTableName.toLowerCase();
        iRiskCode = iRiskCode.toUpperCase();
        if (iTableName.trim().equalsIgnoreCase("fcorepolicy")
                || iTableName.trim().equalsIgnoreCase("fporeendor")
                || iTableName.trim().equalsIgnoreCase("florepay")
                || iTableName.trim().equalsIgnoreCase("fzacc")
                || iTableName.trim().equalsIgnoreCase("fcirepolicy")
                || iTableName.trim().equalsIgnoreCase("fpireendor")
                || iTableName.trim().equalsIgnoreCase("flirepay")) {
            //分保业务号：I/O+险类代码(1位)+业务年度+公司代码(4位)
            if (iTableName.trim().equalsIgnoreCase("fcirepolicy")){
                strGroupNo = "I" + iRiskCode.substring(0, 1) + iComCode.substring(0, 4) + iYear ;
            }
            else{
                strGroupNo = "O" + iRiskCode.substring(0, 1) + iComCode.substring(0, 4) + iYear;
            }
        } else if (iTableName.trim().equalsIgnoreCase("fjsettle")) {
            //直接业务号:业务年度 + "R"
            strGroupNo = iYear + "R";
        } else if (iTableName.trim().equalsIgnoreCase("prplpaymain")) {
            //支付编号生成规则
            //查勘、定损、单证环节生成规则(处理prplpaygather表)：ZG+4位险种代码+6位机构代码+4位年份代码+6位流水号码
            //理算、预赔、支付环节生成规则(处理prplpay表、prplpaymain)：Z+4位险种代码+6位机构代码+4位年份代码+6位流水号码
            strGroupNo ="Z"+ iRiskCode + iComCode.substring(0,6) + iYear;
        } else {
            //变更成国寿的取号方式:
            //说明	编码类型	4位险种代码	4位年份代码	6位机构代码	6位流水号码
            //报案－R；立案－A；结案－W；理算－C
            if("prplcompensate".equals(iTableName)){
                iRiskCode = iRiskCode.substring(2,5);
            }
            strGroupNo = iRiskCode + iComCode.substring(0,6) + iYear;
        }
        return strGroupNo;
    }

    /**
     * （获取编号中拉伸编号）
     * @author: 王志文
     * @date: 2017/12/14 20:43
     */
    private String pullNo(String iTableName,String iBillNo,String iGroupNo){
        UtiKeyDto utiKeyDto;
        String strHeadID;
        int colLength;
        int intNoLength;
        int intChgLength;
        int intLength;
        utiKeyDto = utiKeyApi.queryByPK(iTableName);
        if (utiKeyDto == null) {
            return iBillNo;
        }
        strHeadID = utiKeyDto.getHeadId();
        colLength = utiKeyDto.getCollEngth();
        //单号的总长度
        intLength = iGroupNo.length() + colLength + 1;
        if (iBillNo.length() >= intLength) {
            return iBillNo;
        }
        intNoLength = iBillNo.length();
        intChgLength = colLength - intNoLength;

        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < intChgLength; ++k) {
            builder.append("0");
        }
        iBillNo = builder + iBillNo;
        if (StringUtils.isNotEmpty(strHeadID)){
            iBillNo = strHeadID.trim() + iGroupNo.trim() + iBillNo.trim();
        }else{
            iBillNo = iGroupNo.trim() + iBillNo.trim();
        }
        return iBillNo;
    }

}
