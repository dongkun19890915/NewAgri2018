package com.sinosoft.framework.agri.core.seal.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-01-25 15:34
 */
@XStreamAlias("TREE_NODE")
public class SealDocRequestTreeNode {
    //文档名称 是
    @XStreamAlias("FILE_NO")
    private String fileNo;

    //业务系统传递给签章系统上传影像系统 是
    @XStreamAlias("USER_CODE")
    private String userCode;

    //业务系统传递给签章系统上传影像系统 是
    @XStreamAlias("USER_NAME")
    private String userName;

    //业务系统传递给签章系统上传影像系统
    @XStreamAlias("ID")
    private String id;

    //业务系统传递给签章系统上传影像系统
    @XStreamAlias("UP_USER")
    private String upUser;

    //UW010
    @XStreamAlias("APP_CODE")
    private String appCode;

    //是否加二维码
    @XStreamAlias("IS_CODEBAR")
    private Boolean isCodebar;

    //二维码内容是否加密
    @XStreamAlias("CERT_CODEBAR")
    private String certCodebar;

    //二维码类型 1是pdf417;0是QR码
    @XStreamAlias("CODEBAR_TYPE")
    private String codebarType;

    //二维码内容信息
    @XStreamAlias("CODEBAR_DATA")
    private String codebarData;

    //二维码左右偏移量
    @XStreamAlias("X_COORDINATE")
    private String xCoordinate;

    //二维码上下偏移量
    @XStreamAlias("Y_COORDINATE")
    private String yCoordinate;

    //二维码大小
    @XStreamAlias("CODEBAR_SIZE")
    private String codebarSize;

    //二维码加盖页码
    @XStreamAlias("CODEBAR_PAGE")
    private String codebarPage;

    //盖章方式 1:个人图片盖章,  0:企业盖章 2是公章和图片章都盖 3 是规则信息盖章
    @XStreamAlias("SEAL_TYPE")
    private String sealType;

    @XStreamAlias("RULE_INFO")
    private String ruleInfo;

    //规则类型 0：按照规则号进行盖章，1按照规则信息进行盖章写死
    @XStreamAlias("RULE_TYPE")
    private String ruleType;

    //规则信息 0,6000,4,6000, (这是坐标) 0,25000,5,3,50,1,2,3 , (多页坐标)AUTO_ADD:0,-1,0,0,255,保险人签章)|(4,（这是文字定位）
    @XStreamAlias("RULE_NO")
    private String ruleNo;

    //应用场景 应用场景：data是模板合成，file是文档路径
    @XStreamAlias("CJ_TYPE")
    private String cjType;

    //请求类型 0是http,1是ftp,2是base64值
    @XStreamAlias("REQUEST_TYPE")
    private String requestType;

    //文件路径（根据请求类型决定）
    @XStreamAlias("FILE_PATH")
    private String filePath;

    @XStreamAlias("MODEL_NAME")
    private String modelName;

    //是否添加标记印章 true是;false是否
    @XStreamAlias("AREA_SEAL")
    private Boolean areaSeal;

    @XStreamAlias("ftp_savepath")
    private String ftpSavepath;


    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpUser() {
        return upUser;
    }

    public void setUpUser(String upUser) {
        this.upUser = upUser;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Boolean getCodebar() {
        return isCodebar;
    }

    public void setCodebar(Boolean codebar) {
        isCodebar = codebar;
    }

    public String getCertCodebar() {
        return certCodebar;
    }

    public void setCertCodebar(String certCodebar) {
        this.certCodebar = certCodebar;
    }

    public String getCodebarType() {
        return codebarType;
    }

    public void setCodebarType(String codebarType) {
        this.codebarType = codebarType;
    }

    public String getCodebarData() {
        return codebarData;
    }

    public void setCodebarData(String codebarData) {
        this.codebarData = codebarData;
    }

    public String getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(String xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public String getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(String yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public String getCodebarSize() {
        return codebarSize;
    }

    public void setCodebarSize(String codebarSize) {
        this.codebarSize = codebarSize;
    }

    public String getCodebarPage() {
        return codebarPage;
    }

    public void setCodebarPage(String codebarPage) {
        this.codebarPage = codebarPage;
    }

    public String getSealType() {
        return sealType;
    }

    public void setSealType(String sealType) {
        this.sealType = sealType;
    }

    public String getRuleInfo() {
        return ruleInfo;
    }

    public void setRuleInfo(String ruleInfo) {
        this.ruleInfo = ruleInfo;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getCjType() {
        return cjType;
    }

    public void setCjType(String cjType) {
        this.cjType = cjType;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Boolean getAreaSeal() {
        return areaSeal;
    }

    public void setAreaSeal(Boolean areaSeal) {
        this.areaSeal = areaSeal;
    }

    public String getFtpSavepath() {
        return ftpSavepath;
    }

    public void setFtpSavepath(String ftpSavepath) {
        this.ftpSavepath = ftpSavepath;
    }
}
