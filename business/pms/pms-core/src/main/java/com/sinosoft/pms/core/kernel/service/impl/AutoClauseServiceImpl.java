package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.kernel.CompanyApi;
import com.sinosoft.ims.api.kernel.dto.CompanyConditionDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.pms.api.kernel.dto.*;
import com.sinosoft.pms.core.config.service.SysConfigService;
import com.sinosoft.pms.core.kernel.dao.*;
import com.sinosoft.pms.core.kernel.entity.*;
import com.sinosoft.pms.core.kernel.service.*;
import com.sinosoft.pms.core.common.pub.UUIDUtil;
import io.jsonwebtoken.lang.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @description 自动特约接口服务serviceImpl
 * @author hrx
 * @date 2017年9月13
 */
@Service
@Transactional
public class AutoClauseServiceImpl extends BaseServiceImpl implements AutoClauseService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoClauseServiceImpl.class);

    @Autowired
    private SysConfigService sysConfigService;

    @Autowired
    private CompanyApi companyApi;

    @Autowired
    private RiskService riskService;

    @Autowired
    private PrpDautoClauseService prpDautoClauseService;

    @Autowired
    private PrpDautoClauseDao prpDautoClauseDao;

    @Autowired
    private PrpDautoClauseLogDao prpDautoClauseLogDao;

    @Autowired
    private PrpDautoClauseRuleDao prpDautoClauseRuleDao;

    @Autowired
    private PrpDautoClauseRuleLogDao prpDautoClauseRuleLogDao;

    @Autowired
    private PrpDautoClauseContentDao prpDautoClauseContentDao;

    @Autowired
    private PrpDautoClauseContentLogDao prpDautoClauseContentLogDao;

    @Autowired
    private PrpDautoClauseRuleService prpDautoClauseRuleService;

    @Autowired
    private PrpDautoClauseContentService prpDautoClauseContentService;

    /**
     * @description 新增自动特约
     * @param autoClauseRequestDto
     * @return strMessage
     * @throws Exception
     * @author hrx
     * @since 2017/9/13
     */
    public String saveAutoClause(AutoClauseRequestDto autoClauseRequestDto) throws Exception {
        String strMessage = "success";

        //数据校验、业务校验
        this.checkAutoClause(autoClauseRequestDto);

        String comCode = "";
        String comLevel = "";
        String policySort = "";
        String topComCode = "";
        String saveType = "";
        List comCodeList = new ArrayList();
        List policySortList = new ArrayList();
        List<PrpDcompanyDto> prpDcompanyDtos = new ArrayList<>();
        CompanyConditionDto companyConditionDto = new CompanyConditionDto();

        saveType = autoClauseRequestDto.getSaveType();
        if (null == saveType || "".equals(saveType)){
            saveType = "I";
        }
        if ("I".equals(saveType)){
            topComCode = sysConfigService.getValue("ROOTCOMCODE");//获取总公司机构代码
            if (null == topComCode || "".equals(topComCode)){
                Assert.hasText(topComCode, "未查询到KEY=ROOTCOMCODE 的记录！");
            }
            if (autoClauseRequestDto.getComCode().size() == 1 && autoClauseRequestDto.getComCode().get(0).equals(topComCode)){

                comCode = autoClauseRequestDto.getComCode().get(0).toString();
                if ("00".equals(comCode.substring(0,2))){
                    comLevel = "2";//二级机构
                } else {
                    comLevel = "3";//二级机构
                }
                companyConditionDto.setComCode(comCode);
                companyConditionDto.setUpperComCode(comCode);
                companyConditionDto.setComLevel(comLevel);
                prpDcompanyDtos = companyApi.queryCompanyByCondition(companyConditionDto);

                if (null != prpDcompanyDtos && prpDcompanyDtos.size() > 0){
                    for (PrpDcompanyDto prpDcompanyDto : prpDcompanyDtos){
                        if (!topComCode.equals(prpDcompanyDto.getComCode())){
                            comCodeList.add(prpDcompanyDto.getComCode());
                        }
                    }
                    autoClauseRequestDto.setComCode(comCodeList);
                }

            }
        }

        //适用系统
        policySortList = autoClauseRequestDto.getPolicySort();
        for (int i = 0; i < policySortList.size(); i++){
            policySort = policySort + policySortList.get(i) + ",";
        }

        //组织保存数据
        try{
            if (null != autoClauseRequestDto.getComCode() && autoClauseRequestDto.getComCode().size() > 0){
                List<PrpDautoClause> prpDautoClauses = this.generatePrpDautoClause(autoClauseRequestDto, policySort);
                List<PrpDautoClauseLog> prpDautoClauseLogs = this.generatePrpDautoClauseLog(autoClauseRequestDto, policySort, saveType);
                List<PrpDautoClauseRule> prpDautoClauseRules = this.generatePrpDautoClauseRule(autoClauseRequestDto);
                List<PrpDautoClauseRuleLog> prpDautoClauseRuleLogs = this.generatePrpDautoClauseRuleLog(autoClauseRequestDto, saveType);
                List<PrpDautoClauseContent> prpDautoClauseContents = this.generatePrpDautoClauseContent(autoClauseRequestDto);
                List<PrpDautoClauseContentLog> prpDautoClauseContentLogs = this.generatePrpDautoClauseContentLog(autoClauseRequestDto, saveType);

                if (null != prpDautoClauses && prpDautoClauses.size() > 0){
                    if ("I".equals(saveType)) {
                        prpDautoClauseDao.save(prpDautoClauses);
                        prpDautoClauseLogDao.save(prpDautoClauseLogs);
                        prpDautoClauseRuleDao.save(prpDautoClauseRules);
                        prpDautoClauseRuleLogDao.save(prpDautoClauseRuleLogs);
                        prpDautoClauseContentDao.save(prpDautoClauseContents);
                        prpDautoClauseContentLogDao.save(prpDautoClauseContentLogs);
                    } else if ("U".equals(saveType)) {
                        prpDautoClauseLogDao.save(prpDautoClauseLogs);
                        prpDautoClauseRuleLogDao.save(prpDautoClauseRuleLogs);
                        prpDautoClauseContentLogDao.save(prpDautoClauseContentLogs);
                        prpDautoClauseService.remove(autoClauseRequestDto.getComCode().get(0).toString(),
                                autoClauseRequestDto.getRiskCode().get(0).toString(), autoClauseRequestDto.getClauseCode().toString());
                        prpDautoClauseRuleDao.deleteByCondition(autoClauseRequestDto.getClauseCode().toString(),
                                autoClauseRequestDto.getComCode().get(0).toString(), autoClauseRequestDto.getRiskCode().get(0).toString());
                        prpDautoClauseContentDao.deleteByCondition(autoClauseRequestDto.getClauseCode().toString(),
                                autoClauseRequestDto.getComCode().get(0).toString(), autoClauseRequestDto.getRiskCode().get(0).toString());
                        prpDautoClauseDao.save(prpDautoClauses);
                        prpDautoClauseRuleDao.save(prpDautoClauseRules);
                        prpDautoClauseContentDao.save(prpDautoClauseContents);
                    }
                }
            } else {
                Assert.notNull(comCodeList, "适用机构不能为空！");
            }

        }catch (Exception e){
            e.printStackTrace();
            strMessage = "fail: " + e.getMessage();
        }

        return strMessage;
    }

    private List<PrpDautoClause> generatePrpDautoClause(AutoClauseRequestDto autoClauseRequestDto, String policySort) throws Exception{
        String autoCreateText = "1";
        String addText = "1";
        PrpDautoClauseDto prpDautoClauseDto = new PrpDautoClauseDto();
        List<PrpDautoClauseDto> prpDautoClauseDtos = new ArrayList<>();
        List<PrpDautoClause> prpDautoClauses = new ArrayList<>();

        String othFlag = autoCreateText + autoClauseRequestDto.getDelText() + addText + autoClauseRequestDto.getClauseType();
        for (int m = 0; m < autoClauseRequestDto.getComCode().size(); m++){
            for (int n = 0; n < autoClauseRequestDto.getRiskCode().size(); n++) {
                prpDautoClauseDto = prpDautoClauseService.queryByPK(autoClauseRequestDto.getComCode().get(m).toString(),
                        autoClauseRequestDto.getRiskCode().get(n).toString(), autoClauseRequestDto.getClauseCode());
                if (null != prpDautoClauseDto && "I".equals(autoClauseRequestDto.getSaveType())) {
                    throw new BusinessException("特约名称" + prpDautoClauseDto.getClauseName() + "已配置！");
                }
                //自动特约主表
                prpDautoClauseDto = new PrpDautoClauseDto();
                prpDautoClauseDto.setClauseCode(autoClauseRequestDto.getClauseCode());
                prpDautoClauseDto.setClauseName(autoClauseRequestDto.getClauseName());
                prpDautoClauseDto.setComCode(autoClauseRequestDto.getComCode().get(m).toString());
                prpDautoClauseDto.setRiskCode(autoClauseRequestDto.getRiskCode().get(n).toString());
                prpDautoClauseDto.setValidStatus("1");
                prpDautoClauseDto.setClauseText(autoClauseRequestDto.getClauseText());
                prpDautoClauseDto.setOthFlag(othFlag);
                prpDautoClauseDto.setPolicySort(policySort);
                prpDautoClauseDto.setRemark(autoClauseRequestDto.getRemark());
                prpDautoClauseDto.setOperatorCode(SinoRequestContext.getCurrentContext().getUserCode());
                prpDautoClauseDto.setOperateDate(new Date());
                prpDautoClauseDtos.add(prpDautoClauseDto);
            }
        }
        this.convertCollection(prpDautoClauseDtos, prpDautoClauses, PrpDautoClause.class);
        return prpDautoClauses;
    }

    private List<PrpDautoClauseLog> generatePrpDautoClauseLog(AutoClauseRequestDto autoClauseRequestDto, String policySort, String saveType) throws Exception{
        String autoCreateText = "1";
        String addText = "1";
        PrpDautoClauseLogDto prpDautoClauseLogDto = null;
        List<PrpDautoClauseLogDto> prpDautoClauseLogDtos = new ArrayList<>();
        List<PrpDautoClauseLog> prpDautoClauseLogs = new ArrayList<>();

        String othFlag = autoCreateText + autoClauseRequestDto.getDelText() + addText + autoClauseRequestDto.getClauseType();
        for (int m = 0; m < autoClauseRequestDto.getComCode().size(); m++){
            for (int n = 0; n < autoClauseRequestDto.getRiskCode().size(); n++){
                prpDautoClauseLogDto = new PrpDautoClauseLogDto();
                prpDautoClauseLogDto.setUUID(UUIDUtil.createId());
                prpDautoClauseLogDto.setClauseCode(autoClauseRequestDto.getClauseCode());
                prpDautoClauseLogDto.setClauseName(autoClauseRequestDto.getClauseName());
                prpDautoClauseLogDto.setComCode(autoClauseRequestDto.getComCode().get(m).toString());
                prpDautoClauseLogDto.setRiskCode(autoClauseRequestDto.getRiskCode().get(n).toString());
                prpDautoClauseLogDto.setValidStatus("1");
                prpDautoClauseLogDto.setClauseText(autoClauseRequestDto.getClauseText());
                prpDautoClauseLogDto.setOthFlag(othFlag);
                prpDautoClauseLogDto.setPolicySort(policySort);
                prpDautoClauseLogDto.setOperatorCode(SinoRequestContext.getCurrentContext().getUserCode());
                prpDautoClauseLogDto.setOperateDate(new Date());
                prpDautoClauseLogDto.setRemark(autoClauseRequestDto.getRemark());
                if ("I".equals(saveType)) {
                    prpDautoClauseLogDto.setOperateType("I");
                } else if ("U".equals(saveType)) {
                    prpDautoClauseLogDto.setOperateType("U");
                }
                prpDautoClauseLogDtos.add(prpDautoClauseLogDto);
            }
        }
        this.convertCollection(prpDautoClauseLogDtos, prpDautoClauseLogs, PrpDautoClauseLog.class);
        return prpDautoClauseLogs;
    }

    private List<PrpDautoClauseRule> generatePrpDautoClauseRule(AutoClauseRequestDto autoClauseRequestDto) throws Exception{
        int groupNo = 0;
        int serialNo = 1;
        PrpDautoClauseRuleDto prpDautoClauseRuleDto = null;
        List<PrpDautoClauseRuleDto> prpDautoClauseRuleDtos = new ArrayList<>();
        List<PrpDautoClauseRule> prpDautoClauseRules = new ArrayList<>();
        List<AutoClauseModuleDto> autoClauseModuleDtos = new ArrayList<>();

        autoClauseModuleDtos = autoClauseRequestDto.getAutoClauseModuleDtos();
        if (null != autoClauseModuleDtos && autoClauseModuleDtos.size() > 0){
            for (int m = 0; m < autoClauseRequestDto.getComCode().size(); m++){
                for (int n = 0; n < autoClauseRequestDto.getRiskCode().size(); n++){
                    groupNo = 0;
                    for (AutoClauseModuleDto autoClauseModuleDto : autoClauseModuleDtos){//车险自动生成特约规则组
                        serialNo = 1;
                        groupNo = groupNo + 1;
                        for (ClauseModuleDto clauseModuleDto : autoClauseModuleDto.getClauseModuleDtos()){//车险自动生成特约规则组内数据条数
                            prpDautoClauseRuleDto = new PrpDautoClauseRuleDto();
                            prpDautoClauseRuleDto.setGroupNo(createNo(groupNo));
                            prpDautoClauseRuleDto.setSerialNo(createNo(serialNo));
                            prpDautoClauseRuleDto.setClauseCode(autoClauseRequestDto.getClauseCode());
                            prpDautoClauseRuleDto.setComCode(autoClauseRequestDto.getComCode().get(m).toString());
                            prpDautoClauseRuleDto.setRiskCode(autoClauseRequestDto.getRiskCode().get(n).toString());
                            prpDautoClauseRuleDto.setModule(clauseModuleDto.getModule());
                            prpDautoClauseRuleDto.setProperty(clauseModuleDto.getProperty());
                            prpDautoClauseRuleDto.setPropertyType(clauseModuleDto.getPropertyType());
                            prpDautoClauseRuleDto.setCheckType(clauseModuleDto.getCheckType());
                            prpDautoClauseRuleDto.setCheckValue(clauseModuleDto.getCheckValue());
                            prpDautoClauseRuleDto.setCheckModule(clauseModuleDto.getCheckModule());
                            prpDautoClauseRuleDto.setCheckProperty(clauseModuleDto.getCheckProperty());
                            prpDautoClauseRuleDto.setValidStatus("1");
                            prpDautoClauseRuleDto.setRemark(clauseModuleDto.getRuleRemark());
                            serialNo = serialNo + 1;
                            prpDautoClauseRuleDtos.add(prpDautoClauseRuleDto);
                        }
                    }
                }
            }
            this.convertCollection(prpDautoClauseRuleDtos, prpDautoClauseRules, PrpDautoClauseRule.class);
        }
        return prpDautoClauseRules;
    }

    private List<PrpDautoClauseRuleLog> generatePrpDautoClauseRuleLog(AutoClauseRequestDto autoClauseRequestDto, String saveType) throws Exception{
        int groupNo = 0;
        int serialNo = 1;
        PrpDautoClauseRuleLogDto prpDautoClauseRuleLogDto = null;
        List<PrpDautoClauseRuleLogDto> prpDautoClauseRuleLogDtos = new ArrayList<>();
        List<PrpDautoClauseRuleLog> prpDautoClauseRuleLogs = new ArrayList<>();
        List<AutoClauseModuleDto> autoClauseModuleDtos = new ArrayList<>();

        autoClauseModuleDtos = autoClauseRequestDto.getAutoClauseModuleDtos();
        if (null != autoClauseModuleDtos && autoClauseModuleDtos.size() > 0){
            for (int m = 0; m < autoClauseRequestDto.getComCode().size(); m++){
                for (int n = 0; n < autoClauseRequestDto.getRiskCode().size(); n++){
                    groupNo = 0;
                    for (AutoClauseModuleDto autoClauseModuleDto : autoClauseModuleDtos){
                        serialNo = 1;
                        groupNo = groupNo + 1;
                        for (ClauseModuleDto clauseModuleDto : autoClauseModuleDto.getClauseModuleDtos()){
                            prpDautoClauseRuleLogDto = new PrpDautoClauseRuleLogDto();
                            prpDautoClauseRuleLogDto.setUUID(UUIDUtil.createId());
                            prpDautoClauseRuleLogDto.setGroupNo(createNo(groupNo));
                            prpDautoClauseRuleLogDto.setSerialNo(createNo(serialNo));
                            prpDautoClauseRuleLogDto.setClauseCode(autoClauseRequestDto.getClauseCode());
                            prpDautoClauseRuleLogDto.setComCode(autoClauseRequestDto.getComCode().get(m).toString());
                            prpDautoClauseRuleLogDto.setRiskCode(autoClauseRequestDto.getRiskCode().get(n).toString());
                            prpDautoClauseRuleLogDto.setModule(clauseModuleDto.getModule());
                            prpDautoClauseRuleLogDto.setProperty(clauseModuleDto.getProperty());
                            prpDautoClauseRuleLogDto.setPropertyType(clauseModuleDto.getPropertyType());
                            prpDautoClauseRuleLogDto.setCheckType(clauseModuleDto.getCheckType());
                            prpDautoClauseRuleLogDto.setCheckValue(clauseModuleDto.getCheckValue());
                            prpDautoClauseRuleLogDto.setCheckModule(clauseModuleDto.getCheckModule());
                            prpDautoClauseRuleLogDto.setCheckProperty(clauseModuleDto.getCheckProperty());
                            prpDautoClauseRuleLogDto.setValidStatus("1");
                            prpDautoClauseRuleLogDto.setRemark(clauseModuleDto.getRuleRemark());
                            prpDautoClauseRuleLogDto.setOperatorCode(SinoRequestContext.getCurrentContext().getUserCode());
                            prpDautoClauseRuleLogDto.setOperateDate(new Date());
                            if ("I".equals(saveType)) {
                                prpDautoClauseRuleLogDto.setOperateType("I");
                            } else if ("U".equals(saveType)) {
                                prpDautoClauseRuleLogDto.setOperateType("U");
                            }
                            prpDautoClauseRuleLogDtos.add(prpDautoClauseRuleLogDto);
                        }
                    }
                }
            }
            this.convertCollection(prpDautoClauseRuleLogDtos, prpDautoClauseRuleLogs, PrpDautoClauseRuleLog.class);
        }
        return prpDautoClauseRuleLogs;
    }

    private List<PrpDautoClauseContent> generatePrpDautoClauseContent(AutoClauseRequestDto autoClauseRequestDto) throws Exception{
        int serialNo = 1;
        String propertySub = "";
        PrpDautoClauseContentDto prpDautoClauseContentDto = null;
        List<PrpDautoClauseContentDto> prpDautoClauseContentDtos = new ArrayList<>();
        List<PrpDautoClauseContent> prpDautoClauseContents = new ArrayList<>();
        List<AutoClauseTextModuleDto> autoClauseTextModuleDtos = new ArrayList<>();

        autoClauseTextModuleDtos = autoClauseRequestDto.getAutoClauseTextModuleDtos();
        if (null != autoClauseTextModuleDtos && autoClauseTextModuleDtos.size() > 0){
            for (int m = 0; m < autoClauseRequestDto.getComCode().size(); m++){
                for (int n = 0; n < autoClauseRequestDto.getRiskCode().size(); n++){
                    serialNo = 1;
                    for (AutoClauseTextModuleDto autoClauseTextModuleDto : autoClauseTextModuleDtos){//动态生成特约内容规则条数
                        prpDautoClauseContentDto = new PrpDautoClauseContentDto();
                        prpDautoClauseContentDto.setComCode(autoClauseRequestDto.getComCode().get(m).toString());
                        prpDautoClauseContentDto.setRiskCode(autoClauseRequestDto.getRiskCode().get(n).toString());
                        prpDautoClauseContentDto.setClauseCode(autoClauseRequestDto.getClauseCode());
                        prpDautoClauseContentDto.setModule(autoClauseTextModuleDto.getTextModule());
                        prpDautoClauseContentDto.setSerialNo(String.valueOf(serialNo));
                        prpDautoClauseContentDto.setProperty(autoClauseTextModuleDto.getTextProporty());
                        prpDautoClauseContentDto.setPropertyType(autoClauseTextModuleDto.getTextProportyType());
                        prpDautoClauseContentDto.setValueType(autoClauseTextModuleDto.getValueType());
                        if (null != autoClauseTextModuleDto.getValueType() && "Circle".equals(autoClauseTextModuleDto.getValueType())){
                            if (null !=prpDautoClauseContentDto.getPropertySub() && !"".equals(prpDautoClauseContentDto.getPropertySub())){
                                propertySub = prpDautoClauseContentDto.getPropertySub().replace(":", "::");
                            }
                        }
                        prpDautoClauseContentDto.setPropertySub(propertySub);
                        prpDautoClauseContentDto.setValidStatus("1");
                        prpDautoClauseContentDto.setRemark(autoClauseTextModuleDto.getTextRemark());
                        serialNo = serialNo + 1;
                        prpDautoClauseContentDtos.add(prpDautoClauseContentDto);
                    }
                }
            }
            this.convertCollection(prpDautoClauseContentDtos, prpDautoClauseContents, PrpDautoClauseContent.class);
        }
        return prpDautoClauseContents;
    }

    private List<PrpDautoClauseContentLog> generatePrpDautoClauseContentLog(AutoClauseRequestDto autoClauseRequestDto, String saveType) throws Exception{
        int serialNo = 1;
        String propertySub = "";
        PrpDautoClauseContentLogDto prpDautoClauseContentLogDto = null;
        List<PrpDautoClauseContentLogDto> prpDautoClauseContentLogDtos = new ArrayList<>();
        List<PrpDautoClauseContentLog> prpDautoClauseContentLogs = new ArrayList<>();
        List<AutoClauseTextModuleDto> autoClauseTextModuleDtos = new ArrayList<>();

        autoClauseTextModuleDtos = autoClauseRequestDto.getAutoClauseTextModuleDtos();
        if (null != autoClauseTextModuleDtos && autoClauseTextModuleDtos.size() > 0){
            for (int m = 0; m < autoClauseRequestDto.getComCode().size(); m++){
                for (int n = 0; n < autoClauseRequestDto.getRiskCode().size(); n++){
                    serialNo = 1;
                    for (AutoClauseTextModuleDto autoClauseTextModuleDto : autoClauseTextModuleDtos){
                        prpDautoClauseContentLogDto = new PrpDautoClauseContentLogDto();
                        prpDautoClauseContentLogDto.setUUID(UUIDUtil.createId());
                        prpDautoClauseContentLogDto.setComCode(autoClauseRequestDto.getComCode().get(m).toString());
                        prpDautoClauseContentLogDto.setRiskCode(autoClauseRequestDto.getRiskCode().get(n).toString());
                        prpDautoClauseContentLogDto.setClauseCode(autoClauseRequestDto.getClauseCode());
                        prpDautoClauseContentLogDto.setModule(autoClauseTextModuleDto.getTextModule());
                        prpDautoClauseContentLogDto.setSerialNo(String.valueOf(serialNo));
                        prpDautoClauseContentLogDto.setProperty(autoClauseTextModuleDto.getTextProporty());
                        prpDautoClauseContentLogDto.setPropertyType(autoClauseTextModuleDto.getTextProportyType());
                        prpDautoClauseContentLogDto.setValueType(autoClauseTextModuleDto.getValueType());
                        if (null != autoClauseTextModuleDto.getValueType() && "Circle".equals(autoClauseTextModuleDto.getValueType())){
                            if (null != prpDautoClauseContentLogDto.getPropertySub() && !"".equals(prpDautoClauseContentLogDto.getPropertySub())){
                                propertySub = prpDautoClauseContentLogDto.getPropertySub().replace(":", "::");
                            }
                        }
                        prpDautoClauseContentLogDto.setPropertySub(propertySub);
                        prpDautoClauseContentLogDto.setValidStatus("1");
                        prpDautoClauseContentLogDto.setRemark(autoClauseTextModuleDto.getTextRemark());
                        prpDautoClauseContentLogDto.setOperatorCode(SinoRequestContext.getCurrentContext().getUserCode());
                        prpDautoClauseContentLogDto.setOperateDate(new Date());
                        if ("I".equals(saveType)) {
                            prpDautoClauseContentLogDto.setOperateType("I");
                        } else if ("U".equals(saveType)) {
                            prpDautoClauseContentLogDto.setOperateType("U");
                        }
                        serialNo = serialNo + 1;
                        prpDautoClauseContentLogDtos.add(prpDautoClauseContentLogDto);
                    }
                }
            }
            this.convertCollection(prpDautoClauseContentLogDtos, prpDautoClauseContentLogs, PrpDautoClauseContentLog.class);
        }
        return prpDautoClauseContentLogs;
    }

    public void checkAutoClause(AutoClauseRequestDto autoClauseRequestDto) throws Exception {
        LOGGER.error("进入自动特约服务数据业务校验");
        //非空校验
        Assert.notNull(autoClauseRequestDto, "入参不能空");

        String[] propertySubs = null;
        int clauseContextLength = 0;
        List<ClauseModuleDto> clauseModuleDtos = new ArrayList<ClauseModuleDto>();

        String clauseCode = autoClauseRequestDto.getClauseCode();//特约代码
        String clauseContext = autoClauseRequestDto.getClauseText();//特约内容
        String remark = autoClauseRequestDto.getRemark();//备注
        List policySorts = autoClauseRequestDto.getPolicySort();//特约适用系统
        List comCodes = autoClauseRequestDto.getComCode();//适用机构
        List riskCodes = autoClauseRequestDto.getRiskCode();//适用险种
        List<AutoClauseModuleDto> autoClauseModuleDtos = autoClauseRequestDto.getAutoClauseModuleDtos();//车险自动生成特约规则
        List<AutoClauseTextModuleDto> autoClauseTextModuleDtos = autoClauseRequestDto.getAutoClauseTextModuleDtos();//动态生成特约内容规则

        Assert.hasText(clauseCode, "特别约定代码不能空");
        Assert.notNull(policySorts, "特别约定适用系统不能空");
        Assert.notNull(comCodes, "特别约定适用机构不能空");
        Assert.notNull(riskCodes, "特别约定适用险种不能空");
        Assert.hasText(remark, "备注信息不能空");

        if (null != autoClauseModuleDtos && autoClauseModuleDtos.size() > 0){
            for (AutoClauseModuleDto autoClauseModuleDto :autoClauseModuleDtos){
                clauseModuleDtos = autoClauseModuleDto.getClauseModuleDtos();
                for (ClauseModuleDto clauseModuleDto : clauseModuleDtos){
                    if ("".equals(clauseModuleDto.getModule()) || "请选择".equals(clauseModuleDto.getModule())){
                        Assert.hasText(clauseModuleDto.getModule(), "车险自动生成特约规则模块信息不能空");
                    }
                    if ("".equals(clauseModuleDto.getProperty()) || "请选择".equals(clauseModuleDto.getProperty())){
                        Assert.hasText(clauseModuleDto.getProperty(), "车险自动生成特约规则属性不能空");
                    }
                    if ("".equals(clauseModuleDto.getCheckType()) || "请选择".equals(clauseModuleDto.getCheckType())){
                        Assert.hasText(clauseModuleDto.getCheckType(), "车险自动生成特约规则校验类型不能空");
                    }
                    if ("".equals(clauseModuleDto.getCheckValue()) &&
                            ("".equals(clauseModuleDto.getCheckModule()) || "请选择".equals(clauseModuleDto.getCheckModule()))){
                        throw new BusinessException("车险自动生成特约规则校验值和校验模块必录其一！");
                    }
                }
            }
        }

        if (null != autoClauseTextModuleDtos && autoClauseTextModuleDtos.size() > 0){
            for (AutoClauseTextModuleDto autoClauseTextModuleDto : autoClauseTextModuleDtos){
                if ("".equals(autoClauseTextModuleDto.getTextModule()) || "请选择".equals(autoClauseTextModuleDto.getTextModule())){
                    Assert.hasText(autoClauseTextModuleDto.getTextModule(), "动态生成特约内容规则模块信息不能空");
                }
                if ("".equals(autoClauseTextModuleDto.getTextProporty()) || "请选择".equals(autoClauseTextModuleDto.getTextProporty())){
                    Assert.hasText(autoClauseTextModuleDto.getTextProporty(), "动态生成特约内容规则属性不能空");
                }
                if ("".equals(autoClauseTextModuleDto.getValueType()) || "请选择".equals(autoClauseTextModuleDto.getValueType())){
                    Assert.hasText(autoClauseTextModuleDto.getValueType(), "动态生成特约内容规则带入类型不能空");
                }
                if ("Circle".equals(autoClauseTextModuleDto.getValueType()) && !"".equals(autoClauseTextModuleDto.getPropertySub())){
                    propertySubs = autoClauseTextModuleDto.getPropertySub().split("#");
                    for (int i = 0; i < propertySubs.length; i++){
                        Assert.hasText(propertySubs[i], "动态生成特约内容规则辅助值格式不正确！带入类型为'多属性循环显示'时，辅助值的录入规则如：'0:男#1:女'");
                        if (propertySubs[i].split(":").length != 2){
                            throw new BusinessException("动态生成特约内容规则辅助值格式不正确！带入类型为'多属性循环显示'时，辅助值的录入规则如：'0:男#1:女'");
                        }
                    }
                }
            }
        }
        if (!"".equals(clauseContext)){
            clauseContextLength = clauseContext.split("\\*\\*\\*\\*\\*").length;
            if (clauseContext.indexOf("*****") > -1 && (null == autoClauseTextModuleDtos || autoClauseTextModuleDtos.size() <= 0)){
                throw new BusinessException("特约内容模板中的变量位'*****'应和特约内容规则数量一致!");
            }
            if (clauseContext.indexOf("*****") > -1 && null != autoClauseTextModuleDtos && autoClauseTextModuleDtos.size() > 0
                    && autoClauseTextModuleDtos.size() != clauseContextLength - 1){
                throw new BusinessException("特约内容模板中的变量位'*****'应和特约内容规则数量一致!");
            }
            if (clauseContext.indexOf("[[") > -1 && clauseContext.indexOf("]]") > -1 &&
                    clauseContext.indexOf("[[") < clauseContext.indexOf("]]")){
                if (null != autoClauseTextModuleDtos && autoClauseTextModuleDtos.size() > 0){
                    for (AutoClauseTextModuleDto clauseTextModuleDto : autoClauseTextModuleDtos){
                        if ("".equals(clauseTextModuleDto.getValueType()) || "请选择".equals(clauseTextModuleDto.getValueType())){
                            Assert.hasText(clauseTextModuleDto.getValueType(), "特约内容模板中包含'[[]]'时，特约内容规则中需选择'多属性循环显示'类型的带入类型!");
                        }
                        if (!"Circle".equals(clauseTextModuleDto.getValueType()) && !"CIRCLE".equals(clauseTextModuleDto.getValueType())){
                            Assert.hasText(clauseTextModuleDto.getValueType(), "特约内容模板中包含'[[]]'时，特约内容规则中需选择'多属性循环显示'类型的带入类型!");
                        }
                    }
                } else {
                    throw new BusinessException("约内容模板中包含'[[]]'时，特约内容规则中需选择'多属性循环显示'类型的带入类型!");
                }
            }
        }
        LOGGER.error("自动特约服务数据业务校验结束");
    }

    public String createNo(int num) throws Exception{
        String strNo = "000";
        strNo = String.valueOf(num);
        int strLength = strNo.length();
        if(strLength < 3){
            for(int i = strLength; i < 3; i++){
                strNo = "0" + strNo;
            }
        }
        return strNo;
    }

    /**
     * @description 自动特约查询
     * @param autoClauseQueryConditionDto
     * @return PageInfo<PrpDautoClauseDto>
     * @throws Exception
     * @author hrx
     * @since 2017/9/18
     */
    public PageInfo<PrpDautoClauseDto> queryAutoClause(AutoClauseQueryConditionDto autoClauseQueryConditionDto) throws Exception{
        //组织查询条件
        Specification<PrpDautoClause> autoClauseQuerySpecification = autoClauseQuerySpecification(autoClauseQueryConditionDto);
        Pageable page = this.getPageable(autoClauseQueryConditionDto);
        //查询
        Page<PrpDautoClause> prpDautoClausePage = prpDautoClauseDao.findAll(autoClauseQuerySpecification, page);
        PageInfo<PrpDautoClauseDto> prpDautoClausePageInfo = this.convertPage(prpDautoClausePage, PrpDautoClauseDto.class);

        if (null != prpDautoClausePageInfo.getContent() && prpDautoClausePageInfo.getContent().size() > 0){
            for (PrpDautoClauseDto prpDautoClauseDto : prpDautoClausePageInfo.getContent()){
                prpDautoClauseDto.setComName(companyApi.translateCode(prpDautoClauseDto.getComCode(), true));
                prpDautoClauseDto.setRiskName(prpDautoClauseDto.getRiskCode() + " - "
                        + riskService.translateCode(prpDautoClauseDto.getRiskCode(), true));
            }
        }
        return prpDautoClausePageInfo;
    }

    /**
     * @description 自动特约查询Specification
     * @param autoClauseQueryConditionDto
     * @return
     * @author hrx
     * @date 2017年9月18
     */
    public static Specification<PrpDautoClause> autoClauseQuerySpecification(AutoClauseQueryConditionDto autoClauseQueryConditionDto) throws Exception {
        return Specifications.<PrpDautoClause>and().eq(StringUtils.isNotEmpty(autoClauseQueryConditionDto.getClauseCode()), "clauseCode", autoClauseQueryConditionDto.getClauseCode())
                .eq(StringUtils.isNotEmpty(autoClauseQueryConditionDto.getComCode()), "comCode", autoClauseQueryConditionDto.getComCode())
                .eq(StringUtils.isNotEmpty(autoClauseQueryConditionDto.getRiskCode()), "riskCode", autoClauseQueryConditionDto.getComCode())
                .build();
    }

    /**
     * @description 自动特约删除
     * @param autoClauseDeleteConditionDto
     * @return
     * @throws Exception
     * @author hrx
     * @since 2017/9/19
     */
    public String deleteAutoClause(AutoClauseDeleteConditionDto autoClauseDeleteConditionDto) throws Exception{
        //数据校验、业务校验
        this.checkDeleteAutoClause(autoClauseDeleteConditionDto);

        String returnMessage = "success";
        String clauseCode = "";//特约代码
        String comCode = "";//归属机构代码
        String riskCode = "";//险种代码
        String operatorCode = "";//操作员
        try {
            operatorCode = autoClauseDeleteConditionDto.getOperatorCode();
            List<AutoClauseQueryConditionDto> autoClauseQueryConditionDtos = autoClauseDeleteConditionDto.getAutoClauseQueryConditionDtos();
            for (AutoClauseQueryConditionDto autoClauseQueryConditionDto : autoClauseQueryConditionDtos) {
                clauseCode = autoClauseQueryConditionDto.getClauseCode();
                comCode = autoClauseQueryConditionDto.getComCode();
                riskCode = autoClauseQueryConditionDto.getRiskCode();

                this.deleteAutoClauseLog(clauseCode, comCode, riskCode, operatorCode);
                prpDautoClauseService.remove(comCode, riskCode, clauseCode);
                prpDautoClauseRuleDao.deleteByCondition(clauseCode, comCode, riskCode);
                prpDautoClauseContentDao.deleteByCondition(clauseCode, comCode, riskCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnMessage = "fail: " + e.getMessage();
        }
        return returnMessage;
    }

    public void checkDeleteAutoClause(AutoClauseDeleteConditionDto autoClauseDeleteConditionDto) throws Exception {
        LOGGER.error("进入自动特约删除服务数据业务校验");
        //非空校验
        Assert.notNull(autoClauseDeleteConditionDto, "入参不能空");

        List<AutoClauseQueryConditionDto> autoClauseQueryConditionDtos = autoClauseDeleteConditionDto.getAutoClauseQueryConditionDtos();
        Assert.notNull(autoClauseQueryConditionDtos, "请选择要删除的记录！");

        String clauseCode = "";//特约代码
        String comCode = "";//归属机构代码
        String riskCode = "";//险种代码
        for (AutoClauseQueryConditionDto autoClauseQueryConditionDto : autoClauseQueryConditionDtos){
            clauseCode = autoClauseQueryConditionDto.getClauseCode();
            comCode = autoClauseQueryConditionDto.getComCode();
            riskCode = autoClauseQueryConditionDto.getRiskCode();

            Assert.hasText(clauseCode, "特约代码不能空");
            Assert.hasText(comCode, "归属机构代码不能空");
            Assert.hasText(riskCode, "险种代码不能空");
        }
        LOGGER.error("自动特约删除服务数据业务校验结束");
    }

    public void deleteAutoClauseLog(String clauseCode, String comCode, String riskCode, String operatorCode) throws Exception {
        PrpDautoClauseLogDto prpDautoClauseLogDto = new PrpDautoClauseLogDto();
        PrpDautoClauseRuleLogDto prpDautoClauseRuleLogDto = null;
        PrpDautoClauseContentLogDto prpDautoClauseContentLogDto = new PrpDautoClauseContentLogDto();
        List<PrpDautoClauseLog> prpDautoClauseLogs = null;
        List<PrpDautoClauseRuleLog> prpDautoClauseRuleLogs = null;
        List<PrpDautoClauseContentLog> prpDautoClauseContentLogs = null;
        List<PrpDautoClauseLogDto> prpDautoClauseLogDtos = new ArrayList<>();
        List<PrpDautoClauseRuleLogDto> prpDautoClauseRuleLogDtos = new ArrayList<>();
        List<PrpDautoClauseContentLogDto> prpDautoClauseContentLogDtos = new ArrayList<>();

        PrpDautoClauseDto prpDautoClauseDto = prpDautoClauseService.queryByPK(comCode, riskCode, clauseCode);
        if (null != prpDautoClauseDto) {
            prpDautoClauseLogDto.setUUID(UUIDUtil.createId());
            prpDautoClauseLogDto.setClauseCode(prpDautoClauseDto.getClauseCode());
            prpDautoClauseLogDto.setClauseName(prpDautoClauseDto.getClauseName());
            prpDautoClauseLogDto.setComCode(prpDautoClauseDto.getComCode());
            prpDautoClauseLogDto.setRiskCode(prpDautoClauseDto.getRiskCode());
            prpDautoClauseLogDto.setValidStatus(prpDautoClauseDto.getValidStatus());
            prpDautoClauseLogDto.setClauseText(prpDautoClauseDto.getClauseText());
            prpDautoClauseLogDto.setOthFlag(prpDautoClauseDto.getOthFlag());
            prpDautoClauseLogDto.setPolicySort(prpDautoClauseDto.getPolicySort());
            prpDautoClauseLogDto.setOperatorCode(operatorCode);
            prpDautoClauseLogDto.setOperateDate(new Date());
            prpDautoClauseLogDto.setRemark(prpDautoClauseDto.getRemark());
            prpDautoClauseLogDto.setOperateType("D");
            prpDautoClauseLogDtos.add(prpDautoClauseLogDto);
            prpDautoClauseLogs = new ArrayList<PrpDautoClauseLog>(prpDautoClauseLogDtos.size());
            this.convertCollection(prpDautoClauseLogDtos, prpDautoClauseLogs, PrpDautoClauseLog.class);
        } else {
            Assert.notNull(prpDautoClauseDto, "特约不存在！");
        }

        List<PrpDautoClauseRuleDto> prpDautoClauseRuleDtos = prpDautoClauseRuleService.queryByCondition(clauseCode, comCode, riskCode);
        if (null != prpDautoClauseRuleDtos && prpDautoClauseRuleDtos.size() > 0) {
            for (PrpDautoClauseRuleDto prpDautoClauseRuleDto : prpDautoClauseRuleDtos) {
                prpDautoClauseRuleLogDto = new PrpDautoClauseRuleLogDto();
                prpDautoClauseRuleLogDto.setUUID(UUIDUtil.createId());
                prpDautoClauseRuleLogDto.setGroupNo(prpDautoClauseRuleDto.getGroupNo());
                prpDautoClauseRuleLogDto.setSerialNo(prpDautoClauseRuleDto.getSerialNo());
                prpDautoClauseRuleLogDto.setClauseCode(prpDautoClauseRuleDto.getClauseCode());
                prpDautoClauseRuleLogDto.setComCode(prpDautoClauseRuleDto.getComCode());
                prpDautoClauseRuleLogDto.setRiskCode(prpDautoClauseRuleDto.getRiskCode());
                prpDautoClauseRuleLogDto.setModule(prpDautoClauseRuleDto.getModule());
                prpDautoClauseRuleLogDto.setProperty(prpDautoClauseRuleDto.getProperty());
                prpDautoClauseRuleLogDto.setPropertyType(prpDautoClauseRuleDto.getPropertyType());
                prpDautoClauseRuleLogDto.setCheckType(prpDautoClauseRuleDto.getCheckType());
                prpDautoClauseRuleLogDto.setCheckValue(prpDautoClauseRuleDto.getCheckValue());
                prpDautoClauseRuleLogDto.setCheckModule(prpDautoClauseRuleDto.getCheckModule());
                prpDautoClauseRuleLogDto.setCheckProperty(prpDautoClauseRuleDto.getCheckProperty());
                prpDautoClauseRuleLogDto.setValidStatus(prpDautoClauseRuleDto.getValidStatus());
                prpDautoClauseRuleLogDto.setRemark(prpDautoClauseRuleDto.getRemark());
                prpDautoClauseRuleLogDto.setOperatorCode(operatorCode);
                prpDautoClauseRuleLogDto.setOperateDate(new Date());
                prpDautoClauseRuleLogDto.setOperateType("D");
                prpDautoClauseRuleLogDtos.add(prpDautoClauseRuleLogDto);
            }
            prpDautoClauseRuleLogs = new ArrayList<PrpDautoClauseRuleLog>(prpDautoClauseRuleLogDtos.size());
            this.convertCollection(prpDautoClauseRuleLogDtos, prpDautoClauseRuleLogs, PrpDautoClauseRuleLog.class);

        }

        List<PrpDautoClauseContentDto> prpDautoClauseContentDtos = prpDautoClauseContentService.queryByCondition(clauseCode, comCode, riskCode);
        if (null != prpDautoClauseContentDtos && prpDautoClauseContentDtos.size() > 0) {
            for (PrpDautoClauseContentDto prpDautoClauseContentDto : prpDautoClauseContentDtos){
                prpDautoClauseContentLogDto = new PrpDautoClauseContentLogDto();
                prpDautoClauseContentLogDto.setUUID(UUIDUtil.createId());
                prpDautoClauseContentLogDto.setComCode(prpDautoClauseContentDto.getComCode());
                prpDautoClauseContentLogDto.setRiskCode(prpDautoClauseContentDto.getRiskCode());
                prpDautoClauseContentLogDto.setClauseCode(prpDautoClauseContentDto.getClauseCode());
                prpDautoClauseContentLogDto.setModule(prpDautoClauseContentDto.getModule());
                prpDautoClauseContentLogDto.setSerialNo(prpDautoClauseContentDto.getSerialNo());
                prpDautoClauseContentLogDto.setProperty(prpDautoClauseContentDto.getProperty());
                prpDautoClauseContentLogDto.setPropertyType(prpDautoClauseContentDto.getPropertyType());
                prpDautoClauseContentLogDto.setValueType(prpDautoClauseContentDto.getValueType());
                prpDautoClauseContentLogDto.setPropertySub(prpDautoClauseContentDto.getPropertySub());
                prpDautoClauseContentLogDto.setValidStatus(prpDautoClauseContentDto.getValidStatus());
                prpDautoClauseContentLogDto.setRemark(prpDautoClauseContentDto.getRemark());
                prpDautoClauseContentLogDto.setOperatorCode(operatorCode);
                prpDautoClauseContentLogDto.setOperateDate(new Date());
                prpDautoClauseContentLogDto.setOperateType("D");
                prpDautoClauseContentLogDtos.add(prpDautoClauseContentLogDto);
            }
            prpDautoClauseContentLogs = new ArrayList<PrpDautoClauseContentLog>(prpDautoClauseContentLogDtos.size());
            this.convertCollection(prpDautoClauseContentLogDtos, prpDautoClauseContentLogs, PrpDautoClauseContentLog.class);
        }

        prpDautoClauseLogDao.save(prpDautoClauseLogs);
        prpDautoClauseRuleLogDao.save(prpDautoClauseRuleLogs);
        prpDautoClauseContentLogDao.save(prpDautoClauseContentLogs);
    }

    /**
     * @description 自动特约修改
     * @param autoClauseQueryConditionDto
     * @return
     * @throws Exception
     * @author hrx
     * @since 2017/9/20
     */
    public AutoClauseResponseDto updateAutoClause(AutoClauseQueryConditionDto autoClauseQueryConditionDto) throws Exception{
        //非空校验
        this.checkUpdateAutoClause(autoClauseQueryConditionDto);

        String clauseCode = autoClauseQueryConditionDto.getClauseCode();
        String comCode = autoClauseQueryConditionDto.getComCode();
        String riskCode = autoClauseQueryConditionDto.getRiskCode();

        PrpDautoClauseKey prpDautoClauseKey = new PrpDautoClauseKey();
        prpDautoClauseKey.setClauseCode(clauseCode);
        prpDautoClauseKey.setComCode(comCode);
        prpDautoClauseKey.setRiskCode(riskCode);
        PrpDautoClause prpDautoClause = prpDautoClauseDao.findOne(prpDautoClauseKey);
        Assert.notNull(prpDautoClause, "特约不存在！");

        String delText = "";
        String clauseType = "";
        String comName = "";
        String riskName = "";
        Map ruleMap = new HashMap();
        List<AutoClauseModuleDto> autoClauseModuleDtos = new ArrayList();
        AutoClauseResponseDto autoClauseResponseDto = new AutoClauseResponseDto();

        String othFlag = prpDautoClause.getOthFlag();
        if (null != othFlag && !"".equals(othFlag)) {
            if ("0".equals(othFlag.substring(1,2))) {
                delText = "否";
            } else {
                delText = "是";
            }
            if ("A".equals(othFlag.substring(3,4))) {
                clauseType = "A类";
            } else if ("B".equals(othFlag.substring(3,4))) {
                clauseType = "B类";
            } else if ("C".equals(othFlag.substring(3,4))) {
                clauseType = "C类";
            }
        }

        List<PrpDautoClauseRuleDto> ruleList = null;
        AutoClauseModuleResponseDto autoClauseModuleResponseDto = null;
        List<AutoClauseModuleResponseDto> autoClauseModuleResponseDtos = new ArrayList<>();

        List<PrpDautoClauseRuleDto> prpDautoClauseRuleDtos = prpDautoClauseRuleService.queryByCondition(clauseCode, comCode, riskCode);
        if (null != prpDautoClauseRuleDtos && prpDautoClauseRuleDtos.size() > 0) {
            for (PrpDautoClauseRuleDto prpDautoClauseRuleDto : prpDautoClauseRuleDtos) {
                if (ruleMap.containsKey(prpDautoClauseRuleDto.getGroupNo())) {
                    ruleList = (List<PrpDautoClauseRuleDto>) ruleMap.get(prpDautoClauseRuleDto.getGroupNo());
                    ruleList.add(prpDautoClauseRuleDto);
                } else {
                    ruleList = new ArrayList();
                    ruleList.add(prpDautoClauseRuleDto);
                    ruleMap.put(prpDautoClauseRuleDto.getGroupNo(), ruleList);
                }
            }
            Iterator iterator = ruleMap.values().iterator();
            while (iterator.hasNext()) {
                autoClauseModuleResponseDto = new AutoClauseModuleResponseDto();
                prpDautoClauseRuleDtos = (List<PrpDautoClauseRuleDto>) iterator.next();
                autoClauseModuleResponseDto.setPrpDautoClauseRuleDtos(prpDautoClauseRuleDtos);
                autoClauseModuleResponseDtos.add(autoClauseModuleResponseDto);
            }
        }

        List<PrpDautoClauseContentDto> prpDautoClauseContentDtos = prpDautoClauseContentService.queryByCondition(clauseCode, comCode, riskCode);
        if (null != prpDautoClauseContentDtos && prpDautoClauseContentDtos.size() > 0) {
            for (PrpDautoClauseContentDto prpDautoClauseContentDto : prpDautoClauseContentDtos) {
                if (null != prpDautoClauseContentDto.getPropertySub() && !"".equals(prpDautoClauseContentDto.getPropertySub())) {
                    prpDautoClauseContentDto.setPropertySub(prpDautoClauseContentDto.getPropertySub().replace("::", ":"));
                }
            }
        }

        comName = companyApi.translateCode(comCode, true);
        riskName = riskService.translateCode(riskCode, true);

        autoClauseResponseDto.setComCode(comCode);
        autoClauseResponseDto.setComName(comName);
        autoClauseResponseDto.setRiskCode(riskCode);
        autoClauseResponseDto.setRiskName(riskName);
        autoClauseResponseDto.setClauseCode(clauseCode);
        autoClauseResponseDto.setClauseName(prpDautoClause.getClauseName());
        autoClauseResponseDto.setPolicySort(prpDautoClause.getPolicySort());
        autoClauseResponseDto.setDelText(delText);
        autoClauseResponseDto.setClauseType(clauseType);
        autoClauseResponseDto.setClauseText(prpDautoClause.getClauseText());
        autoClauseResponseDto.setRemark(prpDautoClause.getRemark());
        autoClauseResponseDto.setAutoClauseModuleResponseDtos(autoClauseModuleResponseDtos);
        autoClauseResponseDto.setPrpDautoClauseContentDtos(prpDautoClauseContentDtos);

        return autoClauseResponseDto;
    }

    public void checkUpdateAutoClause(AutoClauseQueryConditionDto autoClauseQueryConditionDto) throws Exception {
        LOGGER.error("进入自动特约修改服务数据业务校验");
        //非空校验
        Assert.notNull(autoClauseQueryConditionDto, "入参不能空");

        String clauseCode = autoClauseQueryConditionDto.getClauseCode();//特约代码
        String comCode = autoClauseQueryConditionDto.getComCode();//归属机构代码
        String riskCode = autoClauseQueryConditionDto.getRiskCode();//险种代码
        Assert.hasText(clauseCode, "特约代码不能空");
        Assert.hasText(comCode, "归属机构代码不能空");
        Assert.hasText(riskCode, "险种代码不能空");

        LOGGER.error("自动特约删除服务数据业务校验结束");
    }
}
