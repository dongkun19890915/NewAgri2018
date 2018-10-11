package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.ims.api.auth.dto.UtiGradeTaskDto;
import com.sinosoft.ims.api.auth.dto.UtiUserGradeDto;
import com.sinosoft.ims.api.auth.dto.UtiUserGradePowerDto;
import com.sinosoft.ims.api.auth.dto.UtiUserGradeTaskDto;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestLoginDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    //登录机构代码
    private String loginComCode;
    //用户代码
    private String userCode;
    //任务菜单
    private String taskCode;
    //登录系统的代码
    private String systemCode;
    //农险险类代码
    List<String> classCodeList;
    //农险险种代码 List<PrpDriskDto>
    List<?> prpDriskDtoList;
    //根据comCode,userCode查utiUserGrade表信息
    List<UtiUserGradeDto> utiUserGradeDtoList;
    //根据comCode,userCode查utiUserGradeTask表信息，封装成map
    Map<String,UtiUserGradeTaskDto> utiUserGradeTaskDtoMap;
    //根据comCode,userCode查utiGradeTask表信息，封装成map
    Map<String,UtiGradeTaskDto> utiGradeTaskDtoMap;
    //根据comCode,userCode查utiUserGradePower表信息
    List<UtiUserGradePowerDto> utiUserGradePowerDtoList;
    //是否根据险种判断菜单权限
    boolean hasRiskCode;
    //是否是超级用户
    boolean ifSuperUser;
    //超级用户权限
    HashMap taskMap;

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public List<String> getClassCodeList() {
        return classCodeList;
    }

    public void setClassCodeList(List<String> classCodeList) {
        this.classCodeList = classCodeList;
    }

    public List<?> getPrpDriskDtoList() {
        return prpDriskDtoList;
    }

    public void setPrpDriskDtoList(List<?> prpDriskDtoList) {
        this.prpDriskDtoList = prpDriskDtoList;
    }

    public List<UtiUserGradeDto> getUtiUserGradeDtoList() {        return utiUserGradeDtoList;    }

    public void setUtiUserGradeDtoList(List<UtiUserGradeDto> utiUserGradeDtoList) {        this.utiUserGradeDtoList = utiUserGradeDtoList;    }

    public Map<String, UtiUserGradeTaskDto> getUtiUserGradeTaskDtoMap() {
        return utiUserGradeTaskDtoMap;
    }

    public void setUtiUserGradeTaskDtoMap(Map<String, UtiUserGradeTaskDto> utiUserGradeTaskDtoMap) {
        this.utiUserGradeTaskDtoMap = utiUserGradeTaskDtoMap;
    }

    public Map<String, UtiGradeTaskDto> getUtiGradeTaskDtoMap() {
        return utiGradeTaskDtoMap;
    }

    public void setUtiGradeTaskDtoMap(Map<String, UtiGradeTaskDto> utiGradeTaskDtoMap) {
        this.utiGradeTaskDtoMap = utiGradeTaskDtoMap;
    }


    public boolean isHasRiskCode() {
        return hasRiskCode;
    }

    public void setHasRiskCode(boolean hasRiskCode) {
        this.hasRiskCode = hasRiskCode;
    }

    public boolean isIfSuperUser() {
        return ifSuperUser;
    }

    public void setIfSuperUser(boolean ifSuperUser) {
        this.ifSuperUser = ifSuperUser;
    }

    public HashMap getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(HashMap taskMap) {
        this.taskMap = taskMap;
    }

    public List<UtiUserGradePowerDto> getUtiUserGradePowerDtoList() {
        return utiUserGradePowerDtoList;
    }

    public void setUtiUserGradePowerDtoList(List<UtiUserGradePowerDto> utiUserGradePowerDtoList) {
        this.utiUserGradePowerDtoList = utiUserGradePowerDtoList;
    }
}
