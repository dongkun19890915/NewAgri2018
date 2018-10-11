package com.sinosoft.agriprpall.api;
/**
 * Created by Zhoujiawei on 2017/09/25.
 */
public class AgriPrpallConstant {
    public static final String AGRI_PRPALL_SERVICE_NAME = "agriprpall";
    public static final String AGRI_PRPALL_SERVICE_PROPOSAL = "PROPOSAL";
    public static final String AGRI_PRPALL_SERVICE_POLICY ="POLICY";
    public static final String AGRI_PRPALL_SERVICE_PROVINCECOMCODE="0000000000";//总公司机构代码
    public static final String EDITTYPE_CHGTERM="01";
    public static final String EDITTYPE_LOSS = "03";
    public static final String EDITTYPE_RECOVER = "37";
    public static final String EDITTYPE_WRITEOFF = "19";
    public static final String EDITTYPE_WITHDRAW = "21";
    public static final String ENDORSRE_TABLE = "prpphead";
    public static final String EDITTYPE_PLAN = "";//缴费计划批改
    public static final String ENDORSE_TYPE_ENDDATE = "ENDORSE_ENDDATE";
    public static final String EDITTYPE_MANAGEFEERATE = "59";//管理费比例批改（59）
    public static final String EDITTYPE_COMMISSION = "57";
    public static final String EDITTYPE_MIDDLECOST = "57";
    public static final String EDITTYPE_PERFORMANCE = "77";//批改绩效比例（77）
    public static final String EDITTYPE_LENDORRECOVER = "13";//赔款后恢复保额（13）
    public static final String EDITTYPE_LENDOR = "14";//赔款后减少保额（14）
    public static final String EDITTYPE_BUSINESSNATURE = "76";//业务来源批改，暂用不到
    public static final String EDITTYPE_HANDLERCODE = "85";//业务员批改
    public static final Integer AGRI_PRPALL_SERVICE_FIELDLENGHT=80;//批文长度
    public static final String AGRI_PRPALL_SERVICE_COMCODE = "ComCode";///归属机构查询
    public static final String AGRI_PRPALL_SERVICE_HANDLER2CODE = "Handler2Code";//归属业务员查询
    public static final String AGRI_PRPALL_SERVICE_BUSINESSPROVINCE = "BusinessProvince";//归属区域：省份
    public static final String AGRI_PRPALL_SERVICE_BUSINESSTOWN = "BusinessTown";//归属区域：地市
    public static final String AGRI_PRPALL_SERVICE_BUSINESSCOUNTRY = "BusinessCountry";//归属区域：区县
    public static final String AGRI_PRPALL_SERVICE_BUSINESSCITY = "BusinessCity";//归属区域：乡镇
    public static final String AGRI_PRPALL_SERVICE_BUSINESSAREANAME = "BusinessAreaName";//归属区域：村
    public static final String AGRI_PRPALL_SERVICE_CURRENCY = "Currency";//查询币别信息
    public static final String AGRI_PRPALL_SERVICE_KINDCODE0= "KindCode0";//查询险别信息（条款配置时需要）
    public static final String AGRI_PRPALL_SERVICE_ITEMCODE = "ItemCode";//查询标的信息（条款配置时需要）
    public static final String AGRI_PRPALL_SERVICE_MODEL = "Model";//根据险种代码和机构代码查询 PrpMmodelMain模板配置主表信息
    public static final String AGRI_PRPALL_SERVICE_CLAUSE = "Clause";//根据机构和险种查询条款信息
    public static final String AGRI_PRPALL_SERVICE_RISKCODE = "RiskCode";//根据险类查询险种
    public static final String AGRI_PRPALL_SERVICE_CLAUSECODE= "ClauseCode";//查询特别约定信息
    public static final String AGRI_PRPALL_SERVICE_KINDCODE = "KindCode";//查询险别信息
    public static final String AGRI_PRPALL_SERVICE_ITEMCODE0 = "ItemCode0";//查询标的
    public static final int FIELDLENGHT = 40;//常量，记录拆分长度
    public static final String AGRI_PRPALL_SERVICE_BREEDING_FARMER_LIST_FLAG = "BREEDING_FARMER_LIST_FLAG";//中央政策险养殖险标志
    public static final String AGRI_PRPALL_SERVICE_PLNATING_FARMER_LIST_FLAG = "PLNATING_FARMER_LIST_FLAG";//中央政策险种植险标志
    public static final String AGRI_PRPALL_SERVICE_NYX_SINGLE_FARMER_LIST_FLAG = "NYX_SINGLE_FARMER_LIST_FLAG";//二期清单改造新加的险种
    public static final String AGRI_PRPALL_SERVICE_NYX_MULTIPLE_FARMER_LIST_FLAG = "NYX_MULTIPLE_FARMER_LIST_FLAG"; //二期清单改造新加的险种
    public static final String AGRI_PRPALL_SERVICE_SYSTEM_CODE_PRPALL = "prpall";//归属系统，用来判断规则查询的
}