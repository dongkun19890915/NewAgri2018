package com.sinosoft.agriclaim.core.schedulemanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLregistListQueryDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.*;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLAccIPersonDao;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLclaimStatusDao;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLextDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLAccIPerson;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatus;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatusKey;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLext;
import com.sinosoft.agriclaim.core.businessutilmanage.service.WorkProcessService;
import com.sinosoft.agriclaim.core.common.enums.AgriclaimWorkProcessEnum;
import com.sinosoft.agriclaim.core.common.utils.StringConvert;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistExtDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistTextDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistExt;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistText;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleItemDao;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleMainWfDao;
import com.sinosoft.agriclaim.core.schedulemanage.dao.ZdyClaimDemandDao;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleItem;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWf;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWfKey;
import com.sinosoft.agriclaim.core.schedulemanage.service.ScheduleService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.PrplReturnVisitSwflogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogStoreDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfPathDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.PrplReturnVisitSwflog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogStore;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPath;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfLogService;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.UserInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiCodeTransferApi;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.api.kernel.PrpDagentApi;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDagentDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.UserDto;
import com.sinosoft.pms.api.kernel.PrpDitemAgriApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description 调度任务处理接口
 * @author 马俊玲
 * @date 2017年11月18日 下午3:24:43
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ScheduleServiceImpl extends BaseServiceImpl implements ScheduleService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceImpl.class);
    @Autowired
    private PrpLScheduleMainWfDao prpLscheduleMainWFDao;
    @Autowired
    private PrpLRegistDao prpLregistDao;
    @Autowired
    private PrpLclaimStatusDao prpLclaimStatusDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpLScheduleItemDao prpLscheduleItemDao;
    @Autowired
    private PrpLRegistExtDao prpLregistExtDao;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private SwfLogService swfLogService;
    @Autowired
    private ZdyClaimDemandDao zdyClaimDemandDao;
    @Autowired
    private PrpLRegistDao prplRegistDao;
    @Autowired
    private PrplReturnVisitSwflogDao prplreturnvisitswflogDao;
    @Autowired
    private PrpLclaimStatusDao prplClaimStatusDao;
    @Autowired
    private UtiCodeTransferApi utiCodeTransferApi;
    @Autowired
    private PrpDagentApi prpDagentApi;
    @Autowired
    private PrpLRegistTextDao prpLregistTextDao;
    @Autowired
    private PrpLAccIPersonDao prpLacciPersonDao;
    @Autowired
    private PrpLextDao prpLextDao;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private SwfPathDao swfPathDao;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
    private WorkProcessService workProcessService;
    @Autowired
    private PrpDitemAgriApi prpDitemAgriApi;
    @Autowired
    private SwfLogStoreDao swfLogStoreDao;
    @Autowired
    private UtiGroupApi utiGroupApi;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 保存调度信息
     * 
     * @author 马俊玲
     * @param schedule
     *            调度对象
     * @param workFlow
     *            工作流对象
     * @return 无
     * @throws Exception
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public void saveSchedule(ScheduleDto schedule, WorkFlowDto workFlow, String saveType, String commiFlag) {
        String msg = "";
        if ("GETBACKEDIT".equals(saveType)) {
            if (schedule.getPrpLscheduleMainWFDto() != null) {
                prpLscheduleMainWFDao.save(convert(schedule.getPrpLscheduleMainWFDto(), PrpLScheduleMainWf.class));
            }
            if (schedule.getPrpLscheduleItemDtoList() != null) {
                List<PrpLScheduleItem> prpLscheduleItemList = new ArrayList<PrpLScheduleItem>();
                this.convertCollection(schedule.getPrpLscheduleItemDtoList(), prpLscheduleItemList,
                        PrpLScheduleItem.class);
                prpLscheduleItemDao.deleteInBatch(prpLscheduleItemList);
                prpLscheduleItemDao.save(prpLscheduleItemList);

            }
        } else {
            if ("cancel".equals(saveType)) {
            } else {
                insert(schedule, saveType, commiFlag);
            }
        }
        if (workFlow != null) {
            try {
                workFlowService.deal(workFlow);
            } catch (Exception e) {
                msg = "工作流workFlowService.deal(workFlow)出错";
                throw new BusinessException(msg);
            }
        }
    }

    /**
     * 保存调度信息
     * 
     * @author 马俊玲
     * @param schedule
     *            调度对象
     * @return 无
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    private void insert(ScheduleDto schedule, String saveType, String commiFlag) {

        if (schedule.getPrpLscheduleMainWFDto() == null) {
            throw new DataVerifyException();
        }
        // 首先删除原来的相关数据
        deleteSubInfo(schedule);
        // 只有定损，没有查勘的情况下，所使用的保存方式
        if ("schel".equals(saveType)) {
            if (schedule.getPrpLscheduleItemDtoList() != null) {
                List<PrpLScheduleItem> prpLscheduleItemList = new ArrayList<PrpLScheduleItem>();
                this.convertCollection(schedule.getPrpLscheduleItemDtoList(), prpLscheduleItemList,
                        PrpLScheduleItem.class);
                prpLscheduleItemDao.save(prpLscheduleItemList);
            }
        } else {
            if (schedule.getPrpLscheduleMainWFDto() != null) {
                // 双代案件,出险地调度首次提交调度保存时,记录此时间为双代提交时间
                if ("1".equals(commiFlag)) {
                    List<PrpLRegist> prpLregistList = prpLregistDao
                            .findByCondition(schedule.getPrpLscheduleMainWFDto().getRegistNo());
                    if (null != prpLregistList && prpLregistList.size() > 0) {
                        for (PrpLRegist prplRegist : prpLregistList) {
                            // prplRegist.setcommiTime(new
                            // DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND
                            // ));//prplregist表没有CommiTime字段
                            prplRegistDao.save(prplRegist);
                        }
                    }
                }
                if (!"NOCK".equals(schedule.getPrpLscheduleMainWFDto().getScheduleType())) {
                    prpLscheduleMainWFDao.save(convert(schedule.getPrpLscheduleMainWFDto(), PrpLScheduleMainWf.class));
                }
            }
            if (schedule.getPrpLscheduleItemDtoList() != null) {
                List<PrpLScheduleItem> prpLscheduleItemList = new ArrayList<PrpLScheduleItem>();
                this.convertCollection(schedule.getPrpLscheduleItemDtoList(), prpLscheduleItemList,
                        PrpLScheduleItem.class);
                prpLscheduleItemDao.save(prpLscheduleItemList);
            }
        }
        // 扩展信息
        if (schedule.getPrpLRegistExtDtoList() != null && schedule.getPrpLRegistExtDtoList().size() !=0) {
            if (schedule.getPrpLRegistExtDtoList().get(0).getRegistNo() == null){
                schedule.getPrpLRegistExtDtoList().get(0).setRegistNo(schedule.getPrpLscheduleMainWFDto().getRegistNo());
            }
            List<PrpLRegistExt> PrpLregistExtList = new ArrayList<PrpLRegistExt>();
            this.convertCollection(schedule.getPrpLRegistExtDtoList(), PrpLregistExtList, PrpLRegistExt.class);
            prpLregistExtDao.save(PrpLregistExtList);
        }
        // 回访信息
        if (schedule.getPrplreturnvisitswflogDto() != null) {
            prplreturnvisitswflogDao.save(convert(schedule.getPrplreturnvisitswflogDto(), PrplReturnVisitSwflog.class));
        }
        // 进行节点状态的改变
        updateClaimStatus(schedule);
        // 进行新案件提示表的案件状态改变
    }

    /**
     * 变更调度的操作状态的方法
     * 
     * @author 马俊玲
     * @param schedule
     *            调度对象
     * @return 无
     */
    public void updateClaimStatus(ScheduleDto schedule) {
        // 示例未完成
        if (schedule.getPrpLclaimStatusDto() != null) {
            List<PrpLclaimStatus> prplClaimStatusList = prplClaimStatusDao.findByCondition(schedule.getPrpLclaimStatusDto().getBusinessno(), schedule.getPrpLclaimStatusDto().getSerialno(), "v");
            if (null != prplClaimStatusList && prplClaimStatusList.size() > 0) {
                prplClaimStatusDao.deleteInBatch(prplClaimStatusList);
                prplClaimStatusDao.save(convert(schedule.getPrpLclaimStatusDto(), PrpLclaimStatus.class));
            }
        }
    }

    /**
     * 删除调度子表信息
     * 
     * @author 马俊玲
     * @param schedule
     *            调度对象
     * @return 无
     */
    private void deleteSubInfo(ScheduleDto schedule) {
        // 示例未完成
        String scheduleType = schedule.getScheduleType();
        if (schedule.getPrpLscheduleMainWFDto() != null) {
            if ("sched".equals(scheduleType)) {
            } else {
            }
            // 删除扩展信息
            List<PrpLRegistExt> prpLregistExtList = prpLregistExtDao
                    .queryByRegistNo(schedule.getPrpLscheduleMainWFDto().getRegistNo());
            prpLregistExtDao.delete(prpLregistExtList);
        }
    }

    /**
     * 查询调度信息
     * 
     * @author 马俊玲
     * @param scheduleID
     *            调度ID
     * @param registNo
     *            报案号
     * @param schedule
     *            调度对象
     * @return 无
     */
    public void queryScheduleInfo(int scheduleID, String registNo, ScheduleDto schedule) {
        PrpLScheduleMainWfKey prpLscheduleMainWFKey = new PrpLScheduleMainWfKey(scheduleID, registNo);
        PrpLScheduleMainWf prpLscheduleMainWf = prpLscheduleMainWFDao.findOne(prpLscheduleMainWFKey);
        if (null != prpLscheduleMainWf) {
            schedule.setPrpLscheduleMainWFDto(convert(prpLscheduleMainWf, PrpLScheduleMainWfDto.class));
        }
        PrpLclaimStatusKey prplClaimStatusKey = new PrpLclaimStatusKey(registNo, "sched", scheduleID);
        PrpLclaimStatus prpLclaimStatus = prpLclaimStatusDao.findOne(prplClaimStatusKey);
        if (null != prpLclaimStatus) {
            schedule.setPrpLclaimStatusDto(convert(prpLclaimStatus, PrpLclaimStatusDto.class));
        }
        List<PrpLScheduleItem> prpLscheduleItemList = prpLscheduleItemDao.findByRegistNoAndScheduleId(registNo,
                scheduleID);
        List<PrpLScheduleItemDto> prpLscheduleItemDtoList = new ArrayList<PrpLScheduleItemDto>();
        if (null != prpLscheduleItemList && prpLscheduleItemList.size() > 0) {
            this.convertCollection(prpLscheduleItemList, prpLscheduleItemDtoList, PrpLScheduleItemDto.class);
        }
        schedule.setPrpLscheduleItemDtoList(prpLscheduleItemDtoList);
        List<PrpLRegistExt> prpLregistExtList = prpLregistExtDao.queryByRegistNo(registNo);
        List<PrpLRegistExtDto> prpLregistExtDtoList = new ArrayList<PrpLRegistExtDto>();
        if (null != prpLregistExtList && prpLregistExtList.size() > 0) {
            this.convertCollection(prpLregistExtList, prpLregistExtDtoList, PrpLRegistExtDto.class);
        }
        schedule.setPrpLRegistExtDtoList(prpLregistExtDtoList);
    }

    /**
     * @description 系统内调度／改派
     * @author 马俊玲
     * @param saveDto
     * @return resultMap
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public Map<String, String> scheduleSaveDeal(ScheduleSaveDto saveDto) {
        String msg = "";
        if (null == saveDto) {
            if (LOGGER.isErrorEnabled()) {
                msg = "无效的入参";
                LOGGER.error("调度>>>>>>>>>>>>>>>>>>>{}", msg);
            }


            return null;
        }
        Map<String, String> resultMap = new HashMap<String, String>();
        // 定损调度选择
        // 工作流号获取 是从前端的url中获取的
        String swfLogFlowID = saveDto.getSwflogFlowId();
        // 工作流logno序号 也是从前端的url中获取的
        String swfLogLogNo = saveDto.getSwflogLogNo();
        // 查勘通知调度进行定损调度
        String activeSchedule = "";
        UserInfo userInfo = SinoRequestContext.getCurrentContext().getUser();
        UserDto user = new UserDto();
        user.setUserCode(userInfo.getUserCode());
        user.setComCode(userInfo.getLoginComCode());
        // 查勘调度的选择
        String checkSelectSend = saveDto.getCheckSelectSend();
        String oldcheckFlag = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getScheduleFlag();
        String endflag = saveDto.getEndflag();
        String saveType = saveDto.getSaveType();
        String commiFlag = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getCommiFlag();
        String editType = saveDto.getSaveType();
        boolean selectCheckNow = false;
        String riskCode = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getRiskCode();
        Map<String, String> riskCodeMap = new HashMap<String, String>();
        riskCodeMap.put("riskCode", riskCode);
        // 保单条款代码
        // 报案号
        String registNo = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getRegistNo();
        // 调度号 这个scheduleID到底是什么
        int scheduleID = -1;
        // 防止重复提交
        String oldLastAccessedTime = saveDto.getOldScheduleLastAccessedTime() + "";
        List<SwfLog> swfLogListCheck = null;
        List<SwfLogStore> swfLogStoreListCheck = null;




        //查询此节点的报案号是不是已经被报案注销了,如果是报案注销的状态,是不允许调度的
        swfLogStoreListCheck = swfLogStoreDao.findByNodeTypeAndRegistNoWithNodeStatus("regis", registNo);
        if (swfLogStoreListCheck != null && swfLogStoreListCheck.size() > 0) {
            msg = "此案件已经申请报案注销，不允许执行其他操作！";
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("调度=================={}", msg);
            }
            throw new BusinessException(msg);
        }
        swfLogListCheck = swfLogDao.findByNodeTypeAndRegistNo("cance", registNo);
        if (swfLogListCheck != null && swfLogListCheck.size() > 0) {
            msg = "案件'" + registNo + "'已经申请立案注销，不允许进行调度操作！";
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("调度=================={}", msg);
            }
            throw new BusinessException(msg);
        }
        //非改派状态下如果已经生成查勘定损环节是不允许调度的 只能改派
        if (!"GETBACKEDIT".equals(editType)) {
            for (int i = 0; i < saveDto.getScheduleDto().getPrpLscheduleItemDtoList().size(); i++) {
                swfLogListCheck = swfLogDao.findByNodeTypeAndRegistNoAndNodeStatus("check", registNo, "0");
                if (swfLogListCheck != null && swfLogListCheck.size() > 0 /* && scheduleCheckIni[i+1].equals("0") */) {
                    msg = "此案件已经调度过，并且生成查勘或定损节点，不能再进行调度处理！";
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.error("调度=================={}", msg);
                    }
                    throw new BusinessException(msg);
                }
            }
        }

        if (null == oldLastAccessedTime || "null".equals(oldLastAccessedTime) || "".equals(oldLastAccessedTime)) {
            resultMap.put("oldScheduleLastAccessedTime", new Date().getTime() + "");
            // 把调度案件由正在处理改为待处理
            // 判断是哪种类型的保存

            scheduleID = 1;
            resultMap.put("registNo", registNo);
            resultMap.put("scheduleID", String.valueOf(scheduleID));
            resultMap.put("isSave", "1");
            ScheduleDto schedule = new ScheduleDto();
            // 把页面上的信息给schedule对象赋值
            viewToDto(saveDto, schedule);
            // 生成回访信息 begin
            PrplReturnVisitSwflogDto prplreturnvisitswflog = null;
            try {
                prplreturnvisitswflog = swfLogService.setReturnVisitSwflogDto(saveDto, registNo, "sched", "0");
            } catch (Exception e) {
                throw new BusinessException("调度.swfLogService异常！");
            }
            schedule.setPrplreturnvisitswflogDto(prplreturnvisitswflog);
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("editType======{}", editType);
            }
            SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();
            // 调度改派
            if ("GETBACKEDIT".equals(editType)) {
                // 判断是哪种类型的改派，是定损的，还是
                String getbackNodeType = saveDto.getGetbackNodeType();
                LOGGER.error("getbackNodeType======{}", getbackNodeType);
                String scheduleObjectID = "";
                // 目前改派只保存业务数据，但是，如果是修改节点上的人的话。。。
                String newHandlerCode = "";
                WorkFlowDto workFlowDto = new WorkFlowDto();
                // 有没有做换人操作
                newHandlerCode = saveDto.getNewHandlerCode();
                // 更换用户，这个其他的函数也可以进行调用的
                if (StringUtils.isNotBlank(newHandlerCode)) {
                    LOGGER.error("新更换的人员代码:{}", newHandlerCode);
                    workFlowDto = swfLogService.changeFlowNodeHandler(swfLogFlowID, swfLogLogNo, newHandlerCode,
                            user.getUserName() + "进行了调度改派人员" + newHandlerCode, scheduleObjectID);
                }
                List<SwfLog> swfLogList =swfLogDao.findAll(Specifications.<SwfLog>and()
                        .eq("nodeType","check")
                        .eq(StringUtils.isNotEmpty(registNo),"registNo", registNo)
                        .eq("nodeStatus", "0").build()); 
                if(null!=swfLogList&&swfLogList.size()==1){
                    SwfLog swfLog=swfLogList.get(0);
                    swfLog.setHandlerCode(schedule.getPrpLscheduleMainWFDto().getNextHandlerCode());
                    swfLog.setHandlerName(schedule.getPrpLscheduleMainWFDto().getNextHandlerName());
                    swfLogDao.save(swfLog);
                }
                if (workFlowService.checkDealDto(workFlowDto)) {
                    // 将改派后的任务变成待处理
                    if (workFlowDto.getUpdateSwfLogDto() != null) {
                        workFlowDto.getUpdateSwfLogDto().setNodeStatus("0");
                    }
                    changeSave(schedule, workFlowDto);
                } else {
                    changeSave(schedule, null);
                }

            }
            // 正常调度
            else {
                // 4.以下是工作流处理的过程
                // 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
                // 是否完成调度
                boolean finishSchedule = true;
                SwfLogDto swfLogDtoDealNode = new SwfLogDto();
                swfLogDtoDealNode.setNodeStatus(schedule.getPrpLclaimStatusDto().getStatus());
                swfLogDtoDealNode.setFlowId(swfLogFlowID);
                swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
                swfLogDtoDealNode.setNextBusinessNo(registNo);
                swfLogDtoDealNode.setKeyIn(registNo);
                swfLogDtoDealNode.setKeyOut(registNo);

                SwfLogDto swfLogDtoTemp = swfLogService.queryByPK(swfLogDtoDealNode.getFlowId(),
                        swfLogDtoDealNode.getLogNo());
                swfLogDtoDealNode.setNodeStatus(schedule.getPrpLclaimStatusDto().getStatus());
                if (null != swfLogDtoTemp) {
                    swfLogDtoTemp.setNodeStatus(schedule.getPrpLclaimStatusDto().getStatus());
                    swfLogDtoTemp.setFlowId(swfLogFlowID);
                    swfLogDtoTemp.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
                    swfLogDtoTemp.setNextBusinessNo(registNo);
                    swfLogDtoTemp.setKeyIn(registNo);
                    swfLogDtoTemp.setKeyOut(registNo);
                    if ("sched".equals(swfLogDtoTemp.getNodeType())) {
                        activeSchedule = swfLogDtoTemp.getTypeFlag();
                    }
                    swfLogTransferDto.setSwfLogDto(swfLogDtoTemp);
                } else {
                    if (LOGGER.isErrorEnabled()) {
                        msg = "没有查到当前节点信息";
                        LOGGER.error("调度>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}", msg);
                    }
                }

                // 根据类型不同，操作不同
                List<SwfLogDto> nextNodeList = new ArrayList<SwfLogDto>();
                if ("15".equals(activeSchedule)) {
                }
                // 不再查勘了
                else {
                    if ("0".equals(oldcheckFlag) && "1".equals(checkSelectSend)) {
                        // 选择了查勘调度
                        SwfLogDto swfLogNextNode = new SwfLogDto();
                        String nextHandlerCode1 = saveDto.getScheduleDto().getPrpLscheduleMainWFDto()
                                .getNextHandlerCode();
                        String nextHandlerName1 = saveDto.getScheduleDto().getPrpLscheduleMainWFDto()
                                .getNextHandlerName();

                        //生成下一个节点必定是查勘 在此处是写死的
                        swfLogNextNode.setNodeNo(0);
                        swfLogNextNode.setNodeType("check");
                        swfLogNextNode.setHandlerCode(nextHandlerCode1);
                        swfLogNextNode.setHandlerName(nextHandlerName1);
                        // 老核心中此处没有给deptname赋值，为什么老核心在此处只给HandleDept赋值，后面有要从newHandleDept和newDeptName中取值？
                        swfLogNextNode.setNewHandleDept(schedule.getPrpLscheduleMainWFDto().getScheduleObjectId());
                        swfLogNextNode.setNewDeptName(schedule.getPrpLscheduleMainWFDto().getScheduleObjectName());
                        swfLogNextNode.setHandleDept(schedule.getPrpLscheduleMainWFDto().getScheduleObjectId());
                        swfLogNextNode.setDeptName(schedule.getPrpLscheduleMainWFDto().getScheduleObjectName());
                        swfLogTransferDto.setNewDeptName(schedule.getPrpLscheduleMainWFDto().getScheduleObjectName());
                        swfLogTransferDto.setNewHandleDept(schedule.getPrpLscheduleMainWFDto().getScheduleObjectId());

                        swfLogNextNode.setFlowId(swfLogFlowID);
                        swfLogNextNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
                        swfLogNextNode.setNextBusinessNo(registNo);
                        swfLogNextNode.setKeyIn(registNo);
                        swfLogNextNode.setKeyOut(registNo);
                        swfLogNextNode.setNodeStatus(schedule.getPrpLclaimStatusDto().getStatus());
                        // 如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
                        swfLogTransferDto.setNextNodeListType("1");
                        nextNodeList.add(swfLogNextNode);
                        // 表示本次选择了查勘调度
                        selectCheckNow = true;
                    }
                }
                swfLogTransferDto.setSwfLogNextList(nextNodeList);
                // 调度标的部分开始
                // 如果本次选择了查勘调度，在全流程条件下无论定损是否都选择了，都认为调度就是没有完成
                // endflag=1,表示半流程
                if (selectCheckNow && "0".equals(endflag)) {
                    finishSchedule = false;
                }
                // 如果没选查勘调度，则没有完成
                if ("0".equals(checkSelectSend)) {
                    finishSchedule = false;
                }
                // 半流程的特殊处理
                swfLogTransferDto.setUserUserCode(user.getUserCode());
                swfLogTransferDto.setUserComCode(user.getComCode());
                swfLogTransferDto.setUserComName(user.getCityComName());
                swfLogTransferDto.setNextBusinessNo(registNo);
                // --------------------------------------
                String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
                String userComCode = SinoRequestContext.getCurrentContext().getUser().getLoginComCode();
                String userName = SinoRequestContext.getCurrentContext().getUser().getUserName();
                swfLogTransferDto.setUserUserCode(userCode);
                swfLogTransferDto.setUserComCode(userComCode);
                swfLogTransferDto.setUserUserName(userName);
                PrpDcompanyDto querPrpDcompanyDto = new PrpDcompanyDto();
                try {
                    querPrpDcompanyDto = prpDcompanyApi.queryByPK(userComCode);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                swfLogTransferDto.setUserComName(querPrpDcompanyDto.getComCName());
                // --------------------------------------
                WorkFlowDto workFlow = workFlowService.viewToDto(swfLogTransferDto);

                // 3.保存调度信息,没有完成的话，设置状态为2,未完成查勘的，没有 把所有定损调度做完的，都是待处理的状态
                if (!finishSchedule && workFlow.isUpdate()) {
                    workFlow.getUpdateSwfLogDto().setNodeStatus("0");
                } else {
                    if (workFlow.isUpdate()) {
                        // 检查之前是否有查勘，并且还没结束的节点
                        // 双代案件,由于查勘是由出险地来做的所以,承保方(commiflag=2)提交时不用判断查勘是否做完
                        if (!"2".equals(commiFlag)) {
                            msg = swfLogService.checkNodeSubmit(swfLogFlowID, swfLogLogNo);
                            if (!msg.equals("")) {
                                workFlow.getUpdateSwfLogDto().setNodeStatus("0");
                            }
                        }
                    }
                }

                if ((workFlow.isCreate()) || (workFlow.isUpdate()) || (workFlow.isSubmit()) || (workFlow.isClose())) {
                    if ("1".equals(endflag) && workFlow.getUpdateSwfLogDto() != null) {

                        if (workFlow.getUpdateSwfLogDto().getNodeStatus().equals("4")) {
                            workFlow.setClose(true);
                        } else {
                            workFlow.setClose(false);
                        }
                    }
                    saveSchedule(schedule, workFlow, saveType, commiFlag);
                } else {
                    saveSchedule(schedule, workFlow, saveType, commiFlag);
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.error("报案号:" + registNo + ";注意:没有发现与工作流流程相关任何数据！！");
                    }
                }
            //  流程查询服务调用
                try {
                       workProcessService.saveWorkProcess(schedule.getPrpLscheduleMainWFDto().getPolicyNo(), schedule.getPrpLscheduleMainWFDto().getRegistNo(), null, null, saveDto.getPrpLregistDto().getClassCode(), schedule.getPrpLscheduleMainWFDto().getRiskCode(), "sched","check", AgriclaimWorkProcessEnum.未立案, SinoRequestContext.getCurrentContext().getUserCode());
                    } catch (Exception e) {
                        throw new BusinessException("保存到工作流程表失败！！");
                    }
                resultMap.put("nodeType1", "sched");
            }
        } else {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("报案任务重复提交");
            }
        }
        return resultMap;
    }

    /**
     * 保存调度信息
     * 
     * @author 马俊玲
     * @param schedule
     * @param workFlowDto
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    private void changeSave(ScheduleDto schedule, WorkFlowDto workFlowDto) {
        String msg = "";
        if (schedule.getPrpLscheduleMainWFDto() != null) {
            prpLscheduleMainWFDao.save(convert(schedule.getPrpLscheduleMainWFDto(), PrpLScheduleMainWf.class));
        }
        if (schedule.getPrpLscheduleItemDtoList() != null) {
            List<PrpLScheduleItem> prpLscheduleItemList = new ArrayList<PrpLScheduleItem>();
            this.convertCollection(schedule.getPrpLscheduleItemDtoList(), prpLscheduleItemList, PrpLScheduleItem.class);
            prpLscheduleItemDao.deleteInBatch(prpLscheduleItemList);
            prpLscheduleItemDao.save(prpLscheduleItemList);
        }
        if (workFlowDto != null) {
            try {
                workFlowService.deal(workFlowDto);
            } catch (Exception e) {
                msg = "工作流 workFlowService.deal(workFlowDto)出错";
                throw new BusinessException(msg);
            }
        }
    }

    /**
     * 保存查勘时查勘页面数据整理.
     * 
     * @param ScheduleSaveDto
     *            调度数据保存数据结构
     * @param Schedule
     *            查勘数据传输数据结构
     * @author 马俊玲
     */
    public void viewToDto(ScheduleSaveDto saveDto, ScheduleDto schedule) {

        UserInfo userInfo = SinoRequestContext.getCurrentContext().getUser();
        // 取得当前用户信息，写操作员信息到Dto中
        UserDto user = new UserDto();
        user.setUserCode(userInfo.getUserCode());
        user.setUserName(userInfo.getUserName());
        user.setComCode(userInfo.getLoginComCode());
        /*---------------------调度主表prpLscheduleMainWF------------------------------------*/
        int prpLscheduleMainWFScheduleID;
        String prpLscheduleMainWFRegistNo = "";
        int prpLscheduleMainWFSurveyNo = null == saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getSurveyNo() ? 1
                : saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getSurveyNo();
        String prpLscheduleMainWFClaimComCode = "";
        String prpLscheduleMainWFRiskCode = "";
        String prpLscheduleMainWFPolicyNo = "";
        String prpLscheduleMainWFOperatorCode;
        String prpLscheduleMainWFInputDate;
        String prpLscheduleMainWFScheduleObjectID = "";
        String prpLscheduleMainWFScheduleObjectName = "";
        String prpLscheduleMainWFScheduleType = "";
        String prpLscheduleMainWFCheckOperatorCode = "";
        String prpLscheduleMainWFCheckFlag = "4";
        String prpLscheduleMainWFCheckInfo = "";
        String prpLscheduleMainWFCheckSite = "";
        // 是否已经调度，如果调度了就是1
        String prpLscheduleMainWFScheduleFlag = "";
        String prpLscheduleMainWFNextHandlerCode = "";
        String prpLscheduleMainWFNextHandlerName = "";
        String prpLscheduleMainWFNextNodeNo = "";
        String flag = "";
        // 查勘项目双代标志
        // String prpLscheduleMainWFCommiItemFlag = "";
        PrpLScheduleMainWfDto prpLscheduleMainWF = new PrpLScheduleMainWfDto();

        prpLscheduleMainWFScheduleID = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getScheduleId();
        prpLscheduleMainWFRegistNo = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getRegistNo();
        // 因为双代的关系,查勘和定损项目都可能为不同的调度中心代码,所以要单独区分
        prpLscheduleMainWFClaimComCode = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getClaimcomCode();
        prpLscheduleMainWFRiskCode = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getRiskCode();
        flag = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getFlag();
        prpLscheduleMainWFPolicyNo = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getPolicyNo();
        prpLscheduleMainWFOperatorCode = user.getUserCode();
        if (null != saveDto) {
            prpLscheduleMainWFScheduleObjectID = saveDto.getPrpLScheduleMainWfDto().getScheduleObjectId();
        }
        if (null != saveDto) {
            prpLscheduleMainWFScheduleObjectName = saveDto.getPrpLscheduleMainWFDto().getScheduleObjectName();
        }
        prpLscheduleMainWFCheckSite = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getCheckSite();
        prpLscheduleMainWFCheckInfo = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getCheckInfo();
        prpLscheduleMainWFScheduleFlag = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getScheduleFlag();
        prpLscheduleMainWFNextHandlerCode = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getNextHandlerCode();
        prpLscheduleMainWFNextHandlerName = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getNextHandlerName();
        prpLscheduleMainWFNextNodeNo = saveDto.getNextNodeNo();
        prpLscheduleMainWFScheduleType = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getScheduleType();
        // 查勘项目双代标志
        // 从数据库里查询是否已经查勘操作过了，如果操作过，则不再重复更新了

        queryScheduleInfo(1, (String) prpLscheduleMainWFRegistNo, schedule);
        PrpLclaimStatusDto prpLclaimStatus = new PrpLclaimStatusDto();

        if (schedule.getPrpLscheduleMainWFDto() != null && "1".equals(schedule.getPrpLscheduleMainWFDto().getScheduleFlag())) {
            prpLscheduleMainWF = schedule.getPrpLscheduleMainWFDto();
            prpLclaimStatus = schedule.getPrpLclaimStatusDto();
        } else {
            prpLscheduleMainWF.setScheduleId(prpLscheduleMainWFScheduleID);
            prpLscheduleMainWF.setRegistNo((String) prpLscheduleMainWFRegistNo);
            prpLscheduleMainWF.setSurveyNo(prpLscheduleMainWFSurveyNo);

            prpLscheduleMainWF.setClaimcomCode(prpLscheduleMainWFClaimComCode);
            prpLscheduleMainWF.setRiskCode(prpLscheduleMainWFRiskCode);
            prpLscheduleMainWF.setPolicyNo(prpLscheduleMainWFPolicyNo);
            prpLscheduleMainWF.setOperatorCode(prpLscheduleMainWFOperatorCode);
            prpLscheduleMainWF.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
            prpLscheduleMainWF.setInputHour(DateTime.current().getHour());
            prpLscheduleMainWF.setScheduleType(prpLscheduleMainWFScheduleType);
            prpLscheduleMainWF.setCheckOperatorCode(prpLscheduleMainWFCheckOperatorCode);
            prpLscheduleMainWF.setCheckFlag(prpLscheduleMainWFCheckFlag);
            prpLscheduleMainWF.setScheduleArea(0);
            prpLscheduleMainWF.setFlag(flag);
            // 案件双代标志
            prpLscheduleMainWF.setNextNodeNo(prpLscheduleMainWFNextNodeNo);
            // 判断查勘是否被选中
            String checkSelectSend = saveDto.getCheckSelectSend();
            if ("1".equals(checkSelectSend)) {
                prpLscheduleMainWFScheduleFlag = "1";
            }
            // 如果查勘调度过了，就是1
            prpLscheduleMainWF.setScheduleFlag(prpLscheduleMainWFScheduleFlag);

            /*---------------------文本表------------------------------------*/
            // 目前还没有
            /*---------------------调度操作状态内容prpLclaimStatus------------------------------------*/

            prpLclaimStatus.setStatus("4");
            prpLclaimStatus.setBusinessno(prpLscheduleMainWF.getRegistNo());
            prpLclaimStatus.setPolicyno(prpLscheduleMainWF.getPolicyNo());
            prpLclaimStatus.setNodetype("sched");

            prpLclaimStatus.setInputdate(prpLscheduleMainWF.getInputDate());
            prpLclaimStatus.setOperatedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
            prpLclaimStatus.setHandlercode(user.getUserCode());
            prpLclaimStatus.setRiskcode(prpLscheduleMainWF.getRiskCode());
            // 把scheduleid暂时放在serialNo中了。。。
            // 如果先做的是三者什么的调度，那么,不做查勘调度
            if ("0".equals(checkSelectSend)) {
                // 只保存定损
                prpLscheduleMainWF.setSaveType("schel");
            }
            prpLclaimStatus.setSerialno(1);
        }

        prpLscheduleMainWF.setScheduleObjectId(prpLscheduleMainWFScheduleObjectID);
        prpLscheduleMainWF.setScheduleObjectName(prpLscheduleMainWFScheduleObjectName);
        prpLscheduleMainWF.setCheckInfo(prpLscheduleMainWFCheckInfo);
        prpLscheduleMainWF.setNextHandlerCode(prpLscheduleMainWFNextHandlerCode);
        prpLscheduleMainWF.setNextHandlerName(prpLscheduleMainWFNextHandlerName);
        prpLscheduleMainWF.setCheckSite(prpLscheduleMainWFCheckSite);

        if (prpLscheduleMainWFRegistNo == null && prpLscheduleMainWFScheduleObjectID == null) {
            // 只保存定损
            prpLscheduleMainWF.setSaveType("schel");
        }
        // 设置没有查勘
        if ("NOCK".equals(prpLscheduleMainWFScheduleType)) {
            // 只保存定损
            prpLscheduleMainWF.setSaveType("schel");
        }

        // 加到ArrayList中
        schedule.setPrpLscheduleMainWFDto(prpLscheduleMainWF);
        schedule.setPrpLclaimStatusDto(prpLclaimStatus);

        /*---------------------调度标底prpLScheduleItem------------------------------------*/
        List<PrpLScheduleItemDto> scheduleItemDtoList = new ArrayList<PrpLScheduleItemDto>();
        PrpLScheduleItemDto prpLscheduleItemDto = null;
        String riskCode = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getRiskCode();
        Map<String, String> riskCodeMap = new HashMap<String, String>();
        riskCodeMap.put("riskCode", riskCode);
        String prpLscheduleItemRegistNo = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getRegistNo();
        // 未加双代前,查勘与定损项目的调度中心为同一个,但加上双代后,可能每个都不同,所以要单独区分
        prpLscheduleMainWFInputDate = format.format(saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getInputDate());
        prpLscheduleMainWFOperatorCode = saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getOperatorCode();
        int maxRow = 0;
        maxRow = saveDto.getScheduleDto().getPrpLscheduleItemDtoList().size();
        // 调度保存提交的下一个节点的人员和节点名称
        prpLscheduleMainWFScheduleFlag = StringUtils
                .rightTrim(saveDto.getScheduleDto().getPrpLscheduleMainWFDto().getScheduleFlag());
        for (int index = 0; index < maxRow; index++) {
            prpLscheduleItemDto = new PrpLScheduleItemDto();
            prpLscheduleItemDto
                    .setScheduleId(saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getScheduleId());
            prpLscheduleItemDto.setRegistNo(prpLscheduleItemRegistNo);
            prpLscheduleItemDto.setItemNo(saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getItemNo());

            prpLscheduleItemDto.setClaimComCode(
                    saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getClaimComCode());
            // 表示是否选中
            prpLscheduleItemDto
                    .setSelectSend(saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getSelectSend());
            // 如果选中的话，surveyTimes=1
            prpLscheduleItemDto.setSurveyTimes(0);
            // 是否被调度过
            int strSurveyTimes = saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getSurveyTimes();
            // 判断是不是进行了新的调度选择判断
            // reason:调度处理的人是不一样的，需要保留原来的人
            prpLscheduleItemDto.setInputDate(new DateTime(prpLscheduleMainWFInputDate, DateTime.YEAR_TO_DAY));
            // 已经调度过的日期处理
            if (prpLscheduleItemDto.getSelectSend().equals("1") && 1 == strSurveyTimes) {
                prpLscheduleItemDto.setOperatorCode(user.getUserCode());
                if (null != saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getInputDate()) {
                    prpLscheduleItemDto.setInputDate(new DateTime(
                            format.format(
                                    saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getInputDate()),
                            DateTime.YEAR_TO_DAY));

                }
                prpLscheduleItemDto.setOperatorCode(
                        saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getOperatorCode());
            }
            if (prpLscheduleItemDto.getSelectSend().equals("1") && 0 == strSurveyTimes) {
                prpLscheduleItemDto.setOperatorCode(user.getUserCode());
                prpLscheduleItemDto.setInputDate(new DateTime(prpLscheduleMainWFInputDate, DateTime.YEAR_TO_DAY));

            }

            if (prpLscheduleItemDto.getSelectSend().equals("1")) {
                prpLscheduleItemDto.setSurveyTimes(1);
            }

            prpLscheduleItemDto
                    .setSurveyType(saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getSurveyType());
            prpLscheduleItemDto
                    .setCheckSite(saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getCheckSite());
            // 保存联系人名称
            prpLscheduleItemDto.setCommendRepairFactoryCode(
                    saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getCommendRepairFactoryCode());
            prpLscheduleItemDto.setFactorYestimateLoss(
                    saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getFactorYestimateLoss());
            prpLscheduleItemDto.setFactoryPhone(
                    saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getFactoryPhone());
            prpLscheduleItemDto.setExigencegree(
                    saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getExigencegree());
            if (saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getScheduleObjectId().trim()
                    .length() < 1) {
                saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).setScheduleObjectId("_");
            }
            prpLscheduleItemDto.setScheduleObjectId(
                    saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getScheduleObjectId());
            prpLscheduleItemDto.setScheduleObjectName(
                    saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getScheduleObjectName());

            prpLscheduleItemDto
                    .setResultInfo(saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getResultInfo());
            prpLscheduleItemDto
                    .setBookFlag(saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getBookFlag());
            prpLscheduleItemDto.setScheduleType(
                    saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getScheduleType());

            prpLscheduleItemDto.setFlag(saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getFlag());
            // reason:调度保存提交的下一个节点的人员和节点名称,目前情况
            prpLscheduleItemDto
                    .setNextNodeNo(saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getNextNodeNo());
            prpLscheduleItemDto.setNextHandlerCode(
                    saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getNextHandlerCode());
            prpLscheduleItemDto.setNextHandlerName(
                    saveDto.getScheduleDto().getPrpLscheduleItemDtoList().get(index).getNextHandlerName());

            // 加入调度标的集合
            scheduleItemDtoList.add(prpLscheduleItemDto);
        }
        // 调度集合中加调度标的
        schedule.setPrpLscheduleItemDtoList(scheduleItemDtoList);
        /*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
        PrpLRegistExtDto prpLregistExtDto = null;
        // 从界面得到输入数组
        List<PrpLRegistExtDto> registExtDtoList = saveDto.getPrpLregistExtDto().getPrpLRegistExtDtoList();
        // 对象赋值
        // 报案扩展信息 部分开始
        List<PrpLRegistExtDto> prpLregistExtList = new ArrayList<PrpLRegistExtDto>();
        if (registExtDtoList == null) {
        } else {

            for (int index = 0; index < registExtDtoList.size(); index++) {
                prpLregistExtDto = new PrpLRegistExtDto();
                prpLregistExtDto.setRegistNo(saveDto.getPrpLregistExtDto().getRegistNo());
                prpLregistExtDto.setRiskCode(saveDto.getPrpLregistExtDto().getRiskCode());
                prpLregistExtDto.setSerialNo(registExtDtoList.get(index).getSerialNo());
                prpLregistExtDto.setInputDate(registExtDtoList.get(index).getInputDate());
                prpLregistExtDto.setInputHour(registExtDtoList.get(index).getInputHour());
                prpLregistExtDto.setOperatorCode(registExtDtoList.get(index).getOperatorCode());
                prpLregistExtDto.setContext(registExtDtoList.get(index).getContext());
                // 老核心中没有给该字段赋值，新核心中必须赋值，暂时赋值为‘sched'
                prpLregistExtDto.setNodeType("sched");
                // 加入集合
                prpLregistExtList.add(prpLregistExtDto);
            }
            // 报案集合中加入损失部位
            schedule.setPrpLRegistExtDtoList(prpLregistExtList);
        }

    }

    /**
     * @description 根据入参对象查询工作流主表信息
     * @author 马俊玲
     * @date 2017年11月14日
     * @param inParameterSchedulDto
     *            查询入参对象
     * @return pageInfo 分页对象
     */
    @Override
    public PageInfo<ScheduleQueryBackDto> querySchedulByCondition(InParameterSchedulDto inParameterSchedulDto) throws Exception {
        if (inParameterSchedulDto == null) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("prpLCheckQueryInDto对象不允许为null");
            }
            throw new DataVerifyException("prpLCheckQueryInDto对象不允许为null");
        } else {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("registNo={},policyNo={},insuredName={},riskCode={},nodeStatus={}",
                        inParameterSchedulDto.getRegistNo(), inParameterSchedulDto.getPolicyNo(),
                        inParameterSchedulDto.getInsuredName(), inParameterSchedulDto.getRiskCode(),
                        inParameterSchedulDto.getNodeStatus());
            }
        }
        int pageNo = inParameterSchedulDto.getPageNo();
        int pageSize = inParameterSchedulDto.getPageSize();
        if (pageNo < 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new DataVerifyException("每页数量不能小于1");
        }
        String conditions = "";
        String conditionsCount = "";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        Map<String, Object> paraMapCount = new HashMap<String, Object>();
        try {
            conditions = getNodeConditionsByNodeNo(inParameterSchedulDto, "query", paraMap);
            conditionsCount = getNodeConditionsByNodeNo(inParameterSchedulDto, "", paraMapCount);
        } catch (Exception ex) {
            throw new BusinessException("查询结果异常");
        }
        Query agentQuery = entityManager.createQuery(conditions);
        for (String key : paraMap.keySet()) {
            agentQuery.setParameter(key, paraMap.get(key));
        }
        Query agentQueryCount = entityManager.createQuery(conditionsCount);
        for (String key : paraMapCount.keySet()) {
            agentQueryCount.setParameter(key, paraMapCount.get(key));
        }
        List contList = agentQueryCount.getResultList();
        long totalSize = Long.parseLong(contList.get(0).toString());
        agentQuery.setFirstResult((pageNo - 1) * pageSize);
        agentQuery.setMaxResults(pageSize);
        List<SwfLog> swfLogList = agentQuery.getResultList();
        List<ScheduleQueryBackDto> swfLogDtoList = new ArrayList<ScheduleQueryBackDto>();
        ScheduleQueryBackDto scheduleQueryBackDto = null;
        if (null != swfLogList && swfLogList.size() > 0) {
            for (int i=0;i<swfLogList.size();i++) {
                scheduleQueryBackDto = new ScheduleQueryBackDto();
                scheduleQueryBackDto.setRegistNo(swfLogList.get(i).getRegistNo());
                scheduleQueryBackDto.setPolicyNo(swfLogList.get(i).getPolicyNo());
                scheduleQueryBackDto.setRiskCode(swfLogList.get(i).getRiskCode());
                scheduleQueryBackDto.setInsuredname(swfLogList.get(i).getInsuredName());
                scheduleQueryBackDto.setLossItemName(swfLogList.get(i).getLossitemName());
                scheduleQueryBackDto.setFlowinTime(swfLogList.get(i).getFlowInTime());
                scheduleQueryBackDto.setNodeStatus(swfLogList.get(i).getNodeStatus());
                scheduleQueryBackDto.setHandlerName(swfLogList.get(i).getHandlerName());
                scheduleQueryBackDto.setSwflogLogNo(swfLogList.get(i).getLogNo());
                scheduleQueryBackDto.setSwflogModelNo(swfLogList.get(i).getModelNo());
                scheduleQueryBackDto.setNodeType(swfLogList.get(i).getNodeType());
                scheduleQueryBackDto.setSwflogFlowId(swfLogList.get(i).getFlowId());
                PrpLRegist prpLRegist= prpLregistDao.findByRegistNo(swfLogList.get(i).getRegistNo());
                scheduleQueryBackDto.setLossName(prpLRegist.getLossName());
                swfLogDtoList.add(scheduleQueryBackDto);
            }
        }
        PageInfo<ScheduleQueryBackDto> pageInfo = new PageInfo<>();
        // 数据存放dto集合
        pageInfo.setContent(swfLogDtoList);
        // 当前页数
        pageInfo.setPages(pageNo);
        // 总记录数
        pageInfo.setTotalCount(totalSize);
        return pageInfo;
    }

    /**
     * @description 根据对象拼接SQL
     * @author 马俊玲
     * @date 2017年11月15日
     * @param prpLCheckQueryInDto
     *            入参对象
     * @param flag
     *            查询参数
     * @return string 拼接完成的SQL
     */
    private String getNodeConditionsByNodeNo(InParameterSchedulDto inParameterSchedulDto, String flag,
            Map<String, Object> paraMap) throws Exception{
        // 保单号
        String policyNo = inParameterSchedulDto.getPolicyNo();
        // 报案号
        String registNo = inParameterSchedulDto.getRegistNo();
        // 被保险人姓名
        String insuredName = inParameterSchedulDto.getInsuredName();
        // 流入开始时间
        String flowInTimeStart = inParameterSchedulDto.getFlowInTimeStart();
        // 流出结束时间
        String flowInTimeEnd = inParameterSchedulDto.getFlowInTimeEnd();
        // 险种大类
        String riskType = inParameterSchedulDto.getRiskType();
        // 案件状态
        String nodeStatus = inParameterSchedulDto.getNodeStatus();
        if (StringUtils.isEmpty(riskType)) {
            String msg = "险种大类不能为空";
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("调度任务查询>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}", msg);
            }
            throw new DataVerifyException(msg);
        }
        StringBuilder stringBuilder = null;
        if ("query".equals(flag)) {
            stringBuilder = new StringBuilder("select  e FROM SwfLog e WHERE e.nodeType = 'sched' ");
        } else {
            stringBuilder = new StringBuilder("SELECT count(1) FROM SwfLog e WHERE e.nodeType = 'sched' ");
        }
        try {
            if (StringUtils.isNotEmpty(policyNo)) {
                this.addStringCondition("policyNo", policyNo, "*", stringBuilder, paraMap);
            }
            if (StringUtils.isNotEmpty(registNo)) {
                this.addStringCondition("registNo", registNo, "*", stringBuilder, paraMap);
            }
            if (StringUtils.isNotEmpty(insuredName)) {
                this.addStringCondition("insuredName", insuredName, "*", stringBuilder, paraMap);
            }
        } catch (Exception e) {
            throw new BusinessException();
        }
        if (StringUtils.isNotEmpty(riskType)) {
            Map<String, String> riskTyprMap = new HashMap<String, String>();
            riskTyprMap.put("riskType", riskType);
            List<UtiCodeTransferDto> outerCodeList = null;
            try {
                outerCodeList = utiCodeTransferApi.queryByRiskType(riskTyprMap);
            } catch (Exception e) {
                throw new BusinessException();
            }
            if (outerCodeList != null && outerCodeList.size() > 0) {
                stringBuilder.append(" and e.riskCode in (");
                for (int i = 0; i < outerCodeList.size(); i++) {
                    if (i == outerCodeList.size() - 1) {
                        stringBuilder.append("'" + outerCodeList.get(i).getOuterCode() + "'");
                    } else {
                        stringBuilder.append("'" + outerCodeList.get(i).getOuterCode() + "',");
                    }
                }
                stringBuilder.append(")");
            }
        } else {
            stringBuilder.append(" and (e.riskCode like '31%' or e.riskCode like '32%') and e.riskCode <> '3119' ");
        }
        if (StringUtils.isNotEmpty(nodeStatus)) {
            if (!"all".equals(nodeStatus)) {
                this.addStringCondition("nodeStatus", nodeStatus, "", stringBuilder, paraMap);
            } else {
                stringBuilder.append(" and e.nodeStatus in ('0','2','4') ");
            }
        }
        if (StringUtils.isNotEmpty(flowInTimeStart) && StringUtils.isNotEmpty(flowInTimeEnd)) {
            stringBuilder.append(" and e.flowInTime between '").append(flowInTimeStart).append("' and '")
                    // flowIntime数据库中是varchar2类型，加上空格3表示大于当天的最高的23时之后报案的案件
                    .append(flowInTimeEnd + " 3").append("' ");
        }
        //获取权限查询条件
        AddCodePowerConditionDto addCodePowerConditionDto =new AddCodePowerConditionDto(inParameterSchedulDto.getUserCode(),inParameterSchedulDto.getLoginComCode(),
                inParameterSchedulDto.getLoginGradeCodes(),inParameterSchedulDto.getTableName(),inParameterSchedulDto.getUserCodeFields(),
                inParameterSchedulDto.getComCodeFields(), "", "e", false);
        String codePower = utiGroupApi.addCodePower(addCodePowerConditionDto);
        stringBuilder.append(codePower);
        if ("query".equals(flag)) {
            stringBuilder.append(" and e.systemFlag = 'agri' order by e.handleTime desc");
        } else {
            stringBuilder.append(" and e.systemFlag = 'agri' ");
        }
        LOGGER.error(stringBuilder.toString());
        return stringBuilder.toString();
    }

    /**
     * sql参数String转换
     * 
     * @author 马俊玲
     * @throws Exception
     * @date 2017年10月20日 17:30:27
     */
    public void addStringCondition(String name, String value, String sign, StringBuilder strWhere,
            Map<String, Object> paraMap) {
        if (value != null && !"".equals(value.trim())) {
            if (StringUtils.isNotEmpty(value)) {
                if ("*".equals(sign)) {
                    strWhere.append(" and " + name + " like :" + name);
                    paraMap.put(name, value + "%");
                } else {
                    strWhere.append(" and " + name + " = :" + name);
                    paraMap.put(name, value);
                }
            }
        }
    }

    /**
     * jpql设置统一返回类型
     * 
     * @param list
     * @param pageNo
     * @param totalSize
     * @param dtoClass
     * @param <T>
     * @return
     */
    public <T> PageInfo<T> setPageInfo(List<?> list, int pageNo, long totalSize, Class<T> dtoClass) {
        List<T> listDto = new ArrayList<T>(list.size());
        // 生成response pageinfo格式
        PageInfo<T> pageInfo = new PageInfo<>();
        convertCollection(list, listDto, dtoClass);
        pageInfo.setContent(listDto);
        pageInfo.setPages(pageNo);
        pageInfo.setTotalCount(totalSize);
        return pageInfo;
    }

    /**
     * 调度的详询、改派、调度的页面初始化
     * 
     * @param schedulDetailInDto
     * @return schedulDetailOutDto
     * @author 马俊玲
     * @throws Exception
     * @date 2017年11月6日 下午13:30
     */
    @Override
    public SchedulDetailOutDto querySchedulDetail(SchedulDetailInDto taskSchedulingDetailedInDto) throws Exception {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.error("详细查询开始={}", "----------------开始--------------------");
        }
        String editType = taskSchedulingDetailedInDto.getEditType();
        if (StringUtils.isEmpty(editType)) {
            throw new DataVerifyException("参数\"编辑类型\"没有值");
        }
        String registNo = "";
        Integer scheduleID = null;
        SchedulDetailOutDto outDto = null;
        // 2。已提交调度任务列表中的调度信息详细查看
        // 调用位置:已提交调度任务 ->任务列表中选中一个报案->显示保存过的调度任务信息
        if ("ADD".equals(editType) || "GETBACKEDIT".equals(editType) || "SHOW".equals(editType)) {
            // 报案号
            registNo = taskSchedulingDetailedInDto.getRegistNo();
            // 调度号
            scheduleID = taskSchedulingDetailedInDto.getScheduleID();
            List<PrpLScheduleMainWf> prpLScheduleMainWfList = prpLscheduleMainWFDao
                    .findAll(Specifications.<PrpLScheduleMainWf>and().eq("registNo", registNo).build());
            if (null == prpLScheduleMainWfList || prpLScheduleMainWfList.size() == 0) {
                throw new BusinessException("没有查到调度主表信息");
            }
            PrpLScheduleMainWf prpLScheduleMainWf = prpLScheduleMainWfList.get(0);
            PrpLScheduleMainWfDto prpLScheduleMainWfDto = this.convert(prpLScheduleMainWf, PrpLScheduleMainWfDto.class);

            List<PrpLclaimStatus> prpLclaimStatus = prplClaimStatusDao.findByCondition(registNo, 0, "regis");
            PrpLclaimStatusDto prpLclaimStatusDto = null;
            if (null != prpLclaimStatus && prpLclaimStatus.size() > 0) {
                prpLclaimStatusDto = this.convert(prpLclaimStatus.get(0), PrpLclaimStatusDto.class);
            }
            List<PrpLScheduleItem> listScheduleItem = prpLscheduleItemDao.findByRegistNoAndScheduleId(registNo,
                    scheduleID);
            List<PrpLScheduleItemDto> listScheduleItemDto = new ArrayList<PrpLScheduleItemDto>();
            this.convertCollection(listScheduleItem, listScheduleItemDto, PrpLScheduleItemDto.class);

            List<PrpLRegistExt> listRegistExt = prpLregistExtDao.queryByRegistNo(registNo);
            List<PrpLRegistExtDto> listRegistExtDto = new ArrayList<PrpLRegistExtDto>();
            this.convertCollection(listRegistExt, listRegistExtDto, PrpLRegistExtDto.class);
            if(null!=listRegistExtDto&&listRegistExtDto.size()>0){
                for(PrpLRegistExtDto prpLRegistExtDto:listRegistExtDto){
                    String oprateCode=prpLRegistExtDto.getOperatorCode();
                    if (null != oprateCode) {
                        PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(oprateCode);
                        String operatorName = prpDuserDto.getUserName();
                        prpLRegistExtDto.setOperatorName(operatorName);
                        String inputDate=prpLRegistExtDto.getInputDate();
                        if(null!=inputDate&&inputDate.length()>10){
                            prpLRegistExtDto.setInputDate(inputDate.substring(0, 10));
                        }
                    }
                }
            }
            // RegistDto
            PrpLRegistDto prpLRegistDto = null;
            List<PrpLRegist> listPrpLRegist = prpLregistDao.findByCondition(registNo);
            if (null != listPrpLRegist && listPrpLRegist.size() > 0) {
                prpLRegistDto = this.convert(listPrpLRegist.get(0), PrpLRegistDto.class);
            }
            // 查出来的对象为null
            // List<PrpLext> prpLextList = prpLextDao.findByCondition(registNo,
            // "01");
            List<PrpLext> prpLextList = prpLextDao
                    .findAll(Specifications.<PrpLext>and().eq("certiNo", registNo).eq("certiType", "01").build());
            List<PrpLextDto> prpLextDtoLit = new ArrayList<PrpLextDto>();
            this.convertCollection(prpLextList, prpLextDtoLit, PrpLextDto.class);
            List<PrpLRegistText> listRegistText = prpLregistTextDao
                    .findAll(Specifications.<PrpLRegistText>and().eq("registNo", registNo).build());
            List<PrpLRegistTextDto> listRegistTextDto = new ArrayList<PrpLRegistTextDto>();
            this.convertCollection(listRegistText, listRegistTextDto, PrpLRegistTextDto.class);
            List<PrpLAccIPerson> listAcciPerson = prpLacciPersonDao
                    .findAll(Specifications.<PrpLAccIPerson>and().eq("certiNo", registNo).build());
            // 如果性别没有的险种，给赋值为9（与核心分户录入时统一），其表示未知
            for (PrpLAccIPerson prpLacciPerson : listAcciPerson) {
                PrpLAccIPersonDto prpLacciPersonDto = this.convert(prpLacciPerson, PrpLAccIPersonDto.class);
                if (prpLacciPersonDto.getSex() == null || prpLacciPersonDto.getSex() == "") {
                    prpLacciPersonDto.setSex("9");
                }
            }

            String policyNo = taskSchedulingDetailedInDto.getPolicyNo();
            // 查询保单大对象信息
            String agentCode = "";
            // 从另一个服务获取保单对象
            // Map<String,String> policyNoMap=new HashMap<String,String>();
            // policyNoMap.put("policyNo", policyNo);
            // PrpCmainDto prpCmainDto =prpCmainApi.queryByPK(policyNoMap);
            // if (prpCmainDto!=null){
            // agentCode = prpCmainDto.getAgentCode();
            // //代理人代码
            // }
            if (agentCode != null && !"".equals(agentCode)) {
                prpLScheduleMainWfDto.setAgentCode(agentCode);
                PrpDagentDto prpDagentDto = prpDagentApi.queryByPK(agentCode);
                prpLScheduleMainWfDto.setAgentName(prpDagentDto.getAgentName());// 得到代理人名称
            }
            if (null == prpLRegistDto) {
                throw new DataVerifyException("没查到该报案号对应的报案信息");
            }
            PrpLregistListQueryDto prpLregistDetailDto = new PrpLregistListQueryDto();
            prpLRegistDto.setPrpLregistListQueryDto(prpLregistDetailDto);
            prpLRegistDto.setReportHour(StringConvert.toStandardTime(prpLRegistDto.getReportHour()));
            prpLRegistDto.getPrpLregistListQueryDto().setReportMinute(prpLRegistDto.getReportHour().substring(3, 5));
            prpLRegistDto.setReportHour(prpLRegistDto.getReportHour().substring(0, 2));
            prpLRegistDto.setDamageStartHour(StringConvert.toStandardTime(prpLRegistDto.getDamageStartHour()));
            prpLRegistDto.getPrpLregistListQueryDto()
                    .setDamageStartMinute(prpLRegistDto.getDamageStartHour().substring(3, 5));
            prpLRegistDto.setDamageStartHour(prpLRegistDto.getDamageStartHour().substring(0, 2));
            // 定义出参对象
            outDto = new SchedulDetailOutDto();
            outDto.setPrpLregistDto(prpLRegistDto);
            // 设置扩展属性
            prpLScheduleMainWfDto.setLinkerName(prpLRegistDto.getLinkerName());
            prpLScheduleMainWfDto.setPhoneNumber(prpLRegistDto.getPhoneNumber());
            prpLScheduleMainWfDto.setOperatorName(SinoRequestContext.getCurrentContext().getUser().getUserName());
            // prpLScheduleMainWfDto.setLicenseNo(prpLRegistDto.getLicenseNo());//非农险字段
            /*报损金额*/
            if (prpLRegistDto.getEstimateLoss() != null) {
                prpLScheduleMainWfDto.setEstimateLoss(prpLRegistDto.getEstimateLoss());
            }else{
                prpLScheduleMainWfDto.setEstimateLoss(0.00);
            }
            if ("_".equals(prpLScheduleMainWfDto.getScheduleObjectId())) {
                prpLScheduleMainWfDto.setScheduleObjectId("");
            }
            
            prpLScheduleMainWfDto.setSaveType(editType);
            // 给报案文件多行列表准备数据
            // PrpLRegistTextDto prpLregistTextDto = new
            // PrpLRegistTextDto();
            // String tempContext = "";
            prpLScheduleMainWfDto.setRegistText("");
            if (listRegistTextDto != null) {
                for (PrpLRegistTextDto prpLRegistTextDto : listRegistTextDto) {
                    if ("1".equals(prpLRegistTextDto.getTextType())) {
                        prpLScheduleMainWfDto
                                .setRegistText(prpLScheduleMainWfDto.getRegistText() + prpLRegistTextDto.getContext());
                    }
                }
            }

            // 设置查勘操作的状态为 案件修改 (正处理任务)
            if (prpLclaimStatusDto != null) {
                if (prpLclaimStatusDto.getStatus().equals("7")) {
                    prpLclaimStatusDto.setStatus("3");
                }
                prpLScheduleMainWfDto.setStatus(prpLclaimStatusDto.getStatus());
            } else {
                // 已提交，已经处理完毕的状态
                prpLScheduleMainWfDto.setStatus("4");
            }
            // 还要判断ClaimComCode为空的情况
            String nodeType = taskSchedulingDetailedInDto.getNodeType();
            // 调度任务双代标识: 0 or null:非双代案件; 1:双代代调度案件(出险方) 2:双代部分委托他方调度案件(承保方)
            String commiFlag = taskSchedulingDetailedInDto.getCommiFlag();
            if (!"GETBACKEDIT".equals(editType)) {
                String schedFlag = taskSchedulingDetailedInDto.getSchedFlag();
                if (schedFlag != null && !schedFlag.equals("")) {
                    outDto.setSchedFlag(schedFlag);
                } else {
                    outDto.setSchedFlag("");
                }
            }
            // 因为双代处理任务时,显示信息也借用此函数,故要区分一下,双代任务是没有双代标志的.
            if (!(nodeType == null)) {
                if ("commi".equals(nodeType)) {
                } else {
                    prpLScheduleMainWfDto.setCommiFlag(commiFlag);
                }
            } else {
                prpLScheduleMainWfDto.setCommiFlag(commiFlag);
            }

            ScheduleDto scheduleDto = new ScheduleDto();
            scheduleDto.setPrpLscheduleMainWFDto(prpLScheduleMainWfDto);
            scheduleDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
            scheduleDto.setPrpLscheduleItemDtoList(listScheduleItemDto);
            scheduleDto.setPrpLRegistExtDtoList(listRegistExtDto);
            // 设置相关代码的中文转换
            changeCodeToName(scheduleDto);
            // 设置主查勘信息内容到窗体表单
            outDto.setPrpLscheduleMainWFDto(prpLScheduleMainWfDto);
            // 设置各个子表信息项到窗体表单
            setSubInfo(scheduleDto, editType);
            // 设置工作流下一个节点提交的配置信息
            if ("4".equals(prpLScheduleMainWfDto.getStatus())) {
                // 已经是展现了
                outDto.setFinishSubmit("");
            } else {
                getSubmitNodes(outDto, taskSchedulingDetailedInDto);
            }
            setProvinceCode(outDto, prpLRegistDto.getComCode());

            // 给报案信息补充说明多行列表准备数据
            PrpLRegistExtDto prpLregistExtDto = new PrpLRegistExtDto();
            prpLregistExtDto.setRegistNo(scheduleDto.getPrpLscheduleMainWFDto().getRegistNo());
            prpLregistExtDto.setRiskCode(scheduleDto.getPrpLscheduleMainWFDto().getRiskCode());
            List<PrpLRegistExtDto> registExtDtoList = scheduleDto.getPrpLRegistExtDtoList();
            prpLregistExtDto.setPrpLRegistExtDtoList(registExtDtoList);
            outDto.setScheduleDto(scheduleDto);
            outDto.setPrpLregistExtDto(prpLregistExtDto);
            setProvinceCode(outDto, prpLRegistDto.getComCode());
            if ("ADD".equals(editType)) {
                prpLScheduleMainWfDto.setOperatorName(SinoRequestContext.getCurrentContext().getUser().getUserName());
                // 添加查勘机构和定损机构的默认值
                PrpLScheduleMainWfDto prpLScheduleMainWfDtoSub = scheduleDto.getPrpLscheduleMainWFDto();
                if (null != prpLScheduleMainWfDtoSub) {
                    String claimcomCode = prpLScheduleMainWfDtoSub.getClaimcomCode();
                    if (StringUtils.isEmpty(claimcomCode)) {
                        throw new BusinessException("参数\"节点类型\"没有值");
                    }
                    PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(claimcomCode);
                    String centerCode = "";
                    if ("1".equals(prpDcompanyDto.getCenterFlag())) {
                        if ("2".equals(prpDcompanyDto.getFlag())) {
                            centerCode = prpDcompanyDto.getUpperComCode();
                        } else {
                            centerCode = claimcomCode;
                        }
                    }
                    String comCName = prpDcompanyDto.getComCName();
                    prpLScheduleMainWfDtoSub.setScheduleObjectId(centerCode);
                    prpLScheduleMainWfDtoSub.setScheduleObjectName(comCName);

                    List<PrpLScheduleItemDto> listScheduleItemDtoSub = scheduleDto.getPrpLscheduleItemDtoList();
                    for (PrpLScheduleItemDto prpLScheduleItemDto : listScheduleItemDtoSub) {
                        prpLScheduleItemDto.setScheduleObjectId(centerCode);
                        prpLScheduleItemDto.setScheduleObjectName(comCName);
                    }
                }
            }

        }
        outDto.setSwfLogFlowID(taskSchedulingDetailedInDto.getSwfLogFlowID());
        outDto.setSwfLogLogNo(taskSchedulingDetailedInDto.getSwfLogLogNo());
        return outDto;
    }

    /**
     * 根据PrpPrepayDto中的已经设置的代码内容，对代码进行名称转换
     * 
     * @param scheduleDto
     * @throws Exception
     * 
     */
    private void changeCodeToName(ScheduleDto scheduleDto) throws Exception {
        // (1)对业务归属结构进行转换
        String comCod = scheduleDto.getPrpLscheduleMainWFDto().getClaimcomCode();
        String claimComName = "";
        PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(comCod);
        if (null != prpDcompanyDto) {
            claimComName = prpDcompanyDto.getComCName();
        }
        scheduleDto.getPrpLscheduleMainWFDto().setClaimcomName(claimComName);
        // (2)对操作员进行处理
        String operatorName = "";
        String userCode = scheduleDto.getPrpLscheduleMainWFDto().getOperatorCode();
        if (null != userCode) {
            PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(userCode);
            operatorName = prpDuserDto.getUserName();
        }
        scheduleDto.getPrpLscheduleMainWFDto().setOperatorName(operatorName);
    }

    /**
     * 根据Dto中的各子表内的信息填充界面
     * 
     * @param httpServletRequest
     *            返回给页面的request
     * @param scheduleDto
     *            查勘的数据类
     * @throws Exception
     */
    private void setSubInfo(ScheduleDto scheduleDto, String editType) {

        List<PrpLScheduleItemDto> scheduleItemListTemp = new ArrayList<PrpLScheduleItemDto>();
        List<PrpLScheduleItemDto> scheduleItemList = scheduleDto.getPrpLscheduleItemDtoList();
        // 要过滤掉不同的scheduleType的内容,只有查勘定损才过滤的。。报案保存的是_,变成""
        for (int i = 0; i < scheduleItemList.size(); i++) {
            PrpLScheduleItemDto prpLscheduleItemDtoTemp = new PrpLScheduleItemDto();
            prpLscheduleItemDtoTemp = scheduleItemList.get(i);
            if (prpLscheduleItemDtoTemp.getScheduleObjectId().equals("_")) {
                prpLscheduleItemDtoTemp.setScheduleObjectId("");
                prpLscheduleItemDtoTemp.setScheduleObjectName("");
            }
            // 如果没有调度过，默认进去为0,就是没有被选中
            if (prpLscheduleItemDtoTemp.getSurveyTimes() == 0) {
                prpLscheduleItemDtoTemp.setSelectSend("0");
            }
            if ((!"SHOW".equals(editType)) && prpLscheduleItemDtoTemp.getClaimComCode() != null
                    && prpLscheduleItemDtoTemp.getClaimComCode().length() > 0) {
            } else {
                scheduleItemListTemp.add(prpLscheduleItemDtoTemp);
            }
        }
        scheduleDto.setPrpLscheduleItemDtoList(scheduleItemListTemp);
    }

    /**
     * 查询工作流可以用来选择的节点内容
     * 
     * @param modelNo
     *            String
     * @param nodeNo
     *            String
     * @throws Exception
     */
    private void getSubmitNodes(SchedulDetailOutDto outDto, SchedulDetailInDto schedulDetailInDto) {
        String modelNo = schedulDetailInDto.getModelNo(); // 模板号
        String nodeNo = schedulDetailInDto.getNodeNo(); // 节点号
        int nextNodeNo = 0;
        SwfPathDto swfPathDto = new SwfPathDto();
        List<SwfPath> SwfPathList = swfPathDao
                .findAll(Specifications.<SwfPath>and().eq("modelNo", modelNo).eq("startNodeNo", nodeNo).build());
        List<SwfPathDto> SwfPathDtoList = new ArrayList<SwfPathDto>();
        this.convertCollection(SwfPathList, SwfPathDtoList, SwfPathDto.class);
        if (modelNo != null && nodeNo != null) {
            for (SwfPathDto swfPathDto2 : SwfPathDtoList) {
                nextNodeNo = swfPathDto2.getEndNodeNo();
                swfPathDto.setNextNodeNo(nextNodeNo);
            }
        }
        outDto.setSwfPathList(SwfPathDtoList);
        outDto.setSwfPathDto(swfPathDto);
    }

    private void setProvinceCode(SchedulDetailOutDto outDto, String comCode) {
        /**
         * 获得保单归属机构的相应省份代码,用以 的业务需求。（要求在调度时只能选择该分公司相关的所有公司进行调度）
         * ComCode的第1、2两位是相应的省份代码，如"3400000000"中的"34"就是省份代码
         */
        String provinceCode = comCode.substring(0, 2);
        outDto.setProvinceCode(provinceCode);
    }

    @Override
    public Map<String, String> gisScheduleSaveDeal(AgriScheduleDto agriScheduleDto) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ScheduleSaveDto saveDto = new ScheduleSaveDto();
        saveDto.setCheckSelectSend("1");
        String registNo = agriScheduleDto.getRegistNo();
        SwfLog swfLog=swfLogDao.queryRegistByRegistNo(registNo);
        String flowId = swfLog.getFlowId();
        String logNo = String.valueOf(swfLog.getLogNo());
        String saveType  = "";

        saveDto.setSwflogFlowId(flowId);
        saveDto.setSwflogLogNo(logNo);
        saveDto.setSaveType(saveType);

        PrpLScheduleMainWfDto prpLScheduleMainWfDto= new PrpLScheduleMainWfDto();
        //todo scheduleID是什么东西
        prpLScheduleMainWfDto.setScheduleId(1);
        prpLScheduleMainWfDto.setRegistNo(registNo);
        //todo surveyNo是什么东西
        prpLScheduleMainWfDto.setSurveyNo(0);
        //todo
        prpLScheduleMainWfDto.setClaimcomCode(agriScheduleDto.getScheduleObjectID());

        prpLScheduleMainWfDto.setRiskCode(agriScheduleDto.getRiskCode());
        prpLScheduleMainWfDto.setPolicyNo(swfLog.getPolicyNo());
        //todo
        prpLScheduleMainWfDto.setInputDate(simpleDateFormat.parse("2018-05-07"));
        //todo
        prpLScheduleMainWfDto.setInputHour(16);

        prpLScheduleMainWfDto.setScheduleFlag("0");
        prpLScheduleMainWfDto.setScheduleObjectId(agriScheduleDto.getScheduleObjectID());
        prpLScheduleMainWfDto.setScheduleObjectName(agriScheduleDto.getScheduleObjectName());
        //todo
        prpLScheduleMainWfDto.setScheduleType("ALLS");

        //todo
        prpLScheduleMainWfDto.setCheckFlag("0");

        prpLScheduleMainWfDto.setCheckSite(agriScheduleDto.getCheckSite());

        prpLScheduleMainWfDto.setLinkerName(agriScheduleDto.getRepairFactoryName());
        prpLScheduleMainWfDto.setPhoneNumber(agriScheduleDto.getFactoryPhone());
        prpLScheduleMainWfDto.setOperatorName(agriScheduleDto.getOperatorName());
        prpLScheduleMainWfDto.setEstimateLoss(Double.valueOf(agriScheduleDto.getFactoryEstimateLoss()));

        //todo
        prpLScheduleMainWfDto.setSaveType("ADD");
        //todo
        prpLScheduleMainWfDto.setRegistText("这是出险摘要");

        prpLScheduleMainWfDto.setRegistText("");

        //todo
        prpLScheduleMainWfDto.setStatus("4");
        //todo
        prpLScheduleMainWfDto.setClaimcomName(agriScheduleDto.getScheduleObjectName());

        saveDto.setPrpLscheduleMainWFDto(prpLScheduleMainWfDto);

        PrpLRegist prpLRegist = new PrpLRegist();
        prpLRegist= prpLregistDao.findByRegistNo(registNo);
        PrpLRegistDto prpLRegistDto = convert(prpLRegist,PrpLRegistDto.class);
        saveDto.setPrpLregistDto(prpLRegistDto);

        PrpLRegistExtDto prpLRegistExtDto=agriScheduleDto.getRegistExtDto();
        prpLRegistExtDto.setRegistNo(agriScheduleDto.getRegistNo());
        List<PrpLRegistExtDto> prpLRegistExtDtoList = new ArrayList<>();
        prpLRegistExtDtoList.add(prpLRegistExtDto);
        saveDto.setPrpLregistExtDto(new PrpLRegistExtDto());
        if(prpLRegistExtDtoList!=null) {
            saveDto.getPrpLregistExtDto().setPrpLRegistExtDtoList(prpLRegistExtDtoList);
        }

        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setPrpLRegistExtDtoList(prpLRegistExtDtoList);
        prpLScheduleMainWfDto.setNextHandlerCode(agriScheduleDto.getNextHandlerCode());
        prpLScheduleMainWfDto.setNextHandlerName(agriScheduleDto.getNextHandlerName());

        scheduleDto.setPrpLscheduleMainWFDto(prpLScheduleMainWfDto);

        scheduleDto.setPrpLRegistExtDtoList(prpLRegistExtDtoList);

        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setBusinessno(registNo);
        prpLclaimStatusDto.setPolicyno(prpLRegist.getPolicyNo());
        prpLclaimStatusDto.setNodetype("regis");
        prpLclaimStatusDto.setSerialno(0);
        prpLclaimStatusDto.setRiskcode(agriScheduleDto.getRiskCode());
        prpLclaimStatusDto.setStatus("4");
        //todo
        prpLclaimStatusDto.setHandlercode("0000000000");
        //todo
        prpLclaimStatusDto.setInputdate(simpleDateFormatHour.parse("2018-05-04 08:08:08"));
        //todo
        prpLclaimStatusDto.setOperatedate(simpleDateFormatHour.parse("2018-05-04 08:08:08"));
        scheduleDto.setPrpLclaimStatusDto(prpLclaimStatusDto);



        List<PrpLScheduleItemDto> prpLScheduleItemDtoList=new ArrayList<>(10);
        prpLScheduleItemDtoList.add(new PrpLScheduleItemDto());
        prpLScheduleItemDtoList.get(0).setScheduleId(1);
        prpLScheduleItemDtoList.get(0).setRegistNo(registNo);
        //todo
        prpLScheduleItemDtoList.get(0).setItemNo(-2);
        //todo
        prpLScheduleItemDtoList.get(0).setSelectSend("");
        //todo
        prpLScheduleItemDtoList.get(0).setSurveyTimes(0);
        //todo
        prpLScheduleItemDtoList.get(0).setSurveyType("1");
        prpLScheduleItemDtoList.get(0).setCheckSite(agriScheduleDto.getItemCheckSit());
        prpLScheduleItemDtoList.get(0).setLicenseNo("财产损失");

        prpLScheduleItemDtoList.get(0).setScheduleObjectId(agriScheduleDto.getItemScheduleObjectID());
        prpLScheduleItemDtoList.get(0).setScheduleObjectName(agriScheduleDto.getItemScheduleObjectName());
        //prpLScheduleItemDtoList.get(0).setInputDate();
        prpLScheduleItemDtoList.get(0).setScheduleType("sched");
        prpLScheduleItemDtoList.get(0).setNextHandlerCode(agriScheduleDto.getNextHandlerCode());
        prpLScheduleItemDtoList.get(0).setNextHandlerName(agriScheduleDto.getNextHandlerName());
        prpLScheduleItemDtoList.get(0).setNextNodeNo("certa");
        prpLScheduleItemDtoList.get(0).setExigencegree(agriScheduleDto.getExigenceGree());
        scheduleDto.setPrpLscheduleItemDtoList(prpLScheduleItemDtoList);
        saveDto.setScheduleDto(scheduleDto);


        Map<String,String> map1 = scheduleSaveDeal(saveDto);






        return map1;
    }

}
