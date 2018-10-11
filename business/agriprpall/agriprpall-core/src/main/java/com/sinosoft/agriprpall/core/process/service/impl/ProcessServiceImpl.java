package com.sinosoft.agriprpall.core.process.service.impl;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPmainDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmain;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmainKey;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainKey;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.agriprpall.core.process.dao.PrpStepFlowTempDao;
import com.sinosoft.agriprpall.core.process.entity.PrpStepFlowTemp;
import com.sinosoft.agriprpall.core.process.factory.ProcessNodeFactory;
import com.sinosoft.agriprpall.core.process.node.ProcessNode;
import com.sinosoft.agriprpall.core.process.service.ProcessService;
import com.sinosoft.framework.agri.core.gycore.GYcoreUtil;
import com.sinosoft.framework.agri.core.gycore.NodeItemData;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProcessServiceImpl extends BaseServiceImpl implements ProcessService {

    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessServiceImpl.class);

    private static GYcoreUtil gYcoreUtil;

    /**
     * 新农险系统标志
     */
    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;

    /**
     * 金禾webservice地址
     */
    @Value("${webservice.gycoreService.url}")
    private String gycoreService;

    /**
     * 投保单号码前缀
     */
    private final String PROPOSAL_PREFIX = "1";
    /**
     * 保单号码前缀
     */
    private final String POLICY_PREFIX = "2";
    /**
     * 批单号码前缀
     */
    private final String ENDORSE_PREFIX = "3";

    @Autowired
    private PrpStepFlowTempDao prpStepFlowTempDao;
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpPmainDao prpPmainDao;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 生成节点数据
     *
     * @param processDto 接点数据明细
     * @date: 2018/4/8 15:03
     * @author: 何伟东
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void generateNodeData(ProcessDto processDto) throws Exception {
        if (processDto == null) {
            throw new DataVerifyException("节点数据不能为空！");
        }
        LOGGER.error(processDto.toString());
        ProcessNode processNode = ProcessNodeFactory.createNode(processDto);
        processNode.checkData();
        PrpStepFlowTemp prpStepFlowTemp = this.linkedStepId(processNode);
        saveToTemp(processNode, prpStepFlowTemp);
        sendNodeData(processNode.getNodeItemData());
    }

    /**
     * 将数据推送给金禾
     *
     * @param nodeItemData 金禾数据
     * @date: 2018/4/8 16:33
     * @author: 何伟东
     */
    private void sendNodeData(NodeItemData nodeItemData) throws Exception{
        Map<String, String> reqParam = new HashMap<>(1);
        reqParam.put("bizCode", nodeItemData.getBizCode());
        Map<String, String> gisInsureListCodeMap = insureMainListApi.findGisInsureListCodeByBizCode(reqParam);
        String gisInsureListCode = gisInsureListCodeMap.get("gisInsureListCode");
        if (gisInsureListCode != null) {
            boolean isSucess = getgYcoreUtil().addNodeItemData(gisInsureListCode, nodeItemData);
            if (!isSucess) {
                LOGGER.error("数据回写金禾失败！");
                throw new BusinessException("数据回写金禾失败！");
            }
        } else {
            LOGGER.error("清单号获取失败！");
            throw new BusinessException("清单号获取失败！");
        }
    }

    /**
     * 保存数据到临时表中
     *
     * @param processNode     生成的节点数据
     * @param prpStepFlowTemp 要保存的数据
     * @date: 2018/4/8 15:10
     * @author: 何伟东
     */
    private void saveToTemp(ProcessNode processNode, PrpStepFlowTemp prpStepFlowTemp) {
        NodeItemData nodeItemData = processNode.getNodeItemData();
        if (prpStepFlowTemp == null) {
            prpStepFlowTemp = new PrpStepFlowTemp();
            prpStepFlowTemp.setUUID(UUID.randomUUID().toString().replace("-", ""));
        }
        prpStepFlowTemp.setStepId(nodeItemData.getStepId());
        prpStepFlowTemp.setNowStateCode(processNode.getNowState());
        prpStepFlowTemp.setNowStepCode(nodeItemData.getStepCode());
        this.setBizCode(prpStepFlowTemp, nodeItemData.getBizCode());
        prpStepFlowTempDao.save(prpStepFlowTemp);
    }

    /**
     * 关联节点id和上级节点数据
     *
     * @param processNode 生成的节点数据
     * @return
     * @date: 2018/4/8 15:07
     * @author: 何伟东
     */
    private PrpStepFlowTemp linkedStepId(ProcessNode processNode) {
        NodeItemData nodeItemData = processNode.getNodeItemData();
        String stepId;
        String lastStepId;
        PrpStepFlowTemp prpStepFlowTemp;
        if (processNode.isStartNode()) {
            stepId = "1";
            lastStepId = stepId;
            prpStepFlowTemp = null;
        } else {
            prpStepFlowTemp = this.queryPrpStepFlowTemp(nodeItemData.getBizCode());
            stepId = Integer.toString(Integer.parseInt(prpStepFlowTemp.getStepId()) + 1);
            lastStepId = prpStepFlowTemp.getStepId();
        }
        nodeItemData.setStepId(stepId);
        nodeItemData.setLaststepId(lastStepId);
        return prpStepFlowTemp;
    }

    /**
     * 设置临时数据的业务号
     *
     * @param prpStepFlowTemp 生成的临时表数据
     * @param bizCode         业务号码
     * @date: 2018/4/8 15:15
     * @author: 何伟东
     */
    private void setBizCode(PrpStepFlowTemp prpStepFlowTemp, String bizCode) {
        if (bizCode.startsWith(PROPOSAL_PREFIX)) {
            prpStepFlowTemp.setProposalNo(bizCode);
        } else if (bizCode.startsWith(POLICY_PREFIX)) {
            prpStepFlowTemp.setPolicyNo(bizCode);
        } else if (bizCode.startsWith(ENDORSE_PREFIX)) {
            prpStepFlowTemp.setEndorseNo(bizCode);
        }
    }

    /**
     * 根据业务号查询临时表中是否有记录
     *
     * @param bizCode 业务号
     * @return 临时表数据
     * @date: 2018/4/8 15:16
     * @author: 何伟东
     */
    private PrpStepFlowTemp queryPrpStepFlowTemp(String bizCode) {
        String proposalNo = "";
        if (StringUtils.isEmpty(bizCode)) {
            throw new DataVerifyException("业务号不能为空！");
        } else if (bizCode.startsWith(PROPOSAL_PREFIX)) {
            return prpStepFlowTempDao.findByProposalNo(bizCode);
        } else if (bizCode.startsWith(POLICY_PREFIX)) {
            PrpCmain prpCmain = prpCmainDao.findOne(new PrpCmainKey(bizCode));
            if (prpCmain != null) {
                proposalNo = prpCmain.getProposalNo();
            }
        } else if (bizCode.startsWith(ENDORSE_PREFIX)) {
            PrpPmain prpPmain = prpPmainDao.findOne(new PrpPmainKey(bizCode));
            if (prpPmain != null) {
                proposalNo = prpPmain.getProposalNo();
            }
        } else {
            throw new DataVerifyException("业务号错误！");
        }
        return prpStepFlowTempDao.findByProposalNo(proposalNo);
    }

    /**
     * 构建与金禾交互的对象
     *
     * @author: 何伟东
     * @date: 2018/4/19 19:13
     */
    public GYcoreUtil getgYcoreUtil() {
        if (gYcoreUtil == null) {
            gYcoreUtil = new GYcoreUtil(gycoreService);
        }
        return gYcoreUtil;
    }

    /**
     * 自动生成保单生效节点的定时任务
     * 每天 00:00:10 和 23:00:10 执行,取当天生效的保单信息
     * cron = "10 0 0/23 * * ?"
     *
     * @date: 2018/4/10 17:52
     * @author: 何伟东
     */
    // @Scheduled(cron = "10 0 0/23 * * ?")
    public void autoGeneratePolicyEffectiveNode() throws Exception {
        LOGGER.error("承保流程[保单生效]节点数据生成开始");
        Date date = new Date();
        String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        // 查询当天生效的保单信息
        List<PrpCmain> prpCmains = prpCmainDao.queryByStartDate(systemFlag, nowDate);
        // 已生效的保单生成节点数据处理
        for (PrpCmain prpCmain : prpCmains) {
            ProcessDto processDto = new ProcessDto.Builder()
                    .stepCode(NodeType.POLICY_EFFECTIVE_NODE)
                    .stateCode(NodeState.PROCESSED)
                    .bizCode(prpCmain.getPolicyNo())
                    .inflowTime(date)
                    .outflowTime(date)
                    .opTime(date)
                    .resultCode(prpCmain.getUnderwriteFlag())
                    .build();
            this.generateNodeData(processDto);
        }
        LOGGER.error("承保流程[保单生效]节点数据生成结束,合计共有" + prpCmains.size() + "个保单");
    }

    /**
     * 自动生成批单生效节点的定时任务
     * 每天 00:00:10 和 23:00:10 执行,取当天生效的批单信息
     * cron = "10 0 0/23 * * ?"
     *
     * @date: 2018/4/10 17:52
     * @author: 何伟东
     */
    // @Scheduled(cron = "10 0 0/23 * * ?")
    public void autoGenerateEndorseEffectiveNode() throws Exception {
        LOGGER.error("承保流程[批单生效]节点数据生成开始");
        // 查询当天生效的批单
        StringBuilder dataSql = new StringBuilder("select p from PrpPmain p, PrpPhead h where p.endorseNo=h.endorseNo " +
                "and p.systemFlag=:systemFlag and h.validDate = to_date(:validDate, 'yyyy-mm-dd hh24:mi:ss')");
        Query query = entityManager.createQuery(dataSql.toString());
        Date date = new Date();
        String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        query.setParameter("systemFlag", systemFlag);
        query.setParameter("validDate", nowDate);
        List<PrpPmain> prpPmains = query.getResultList();
        for (PrpPmain prpPmain : prpPmains) {
            ProcessDto processDto = new ProcessDto.Builder()
                    .stepCode(NodeType.ENDORSE_EFFECTIVE_NODE)
                    .stateCode(NodeState.PROCESSED)
                    .bizCode(prpPmain.getEndorseNo())
                    .inflowTime(date)
                    .outflowTime(date)
                    .opTime(date)
                    .resultCode(prpPmain.getUnderwriteFlag())
                    .build();
            this.generateNodeData(processDto);
        }
        LOGGER.error("承保流程[批单生效]节点数据生成开始");
    }

    /**
     * 自动生成到期节点的定时任务
     * 每天 00:00:10 和 23:00:10 执行,取当天到期的保单信息
     * cron = "10 0 0/23 * * ?"
     *
     * @date: 2018/4/10 17:52
     * @author: 何伟东
     */
//    @Scheduled(cron = "10 0 0/23 * * ?")
    public void autoGeneratEexpireNode() throws Exception {
        LOGGER.error("承保流程[到期]节点数据生成开始");
        Date date = new Date();
        String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        // 查询当天到期的保单信息
        List<PrpCmain> prpCmains = prpCmainDao.queryByEndDate(systemFlag, nowDate);
        // 到期的保单信息
        for (PrpCmain prpCmain : prpCmains) {
            ProcessDto processDto = new ProcessDto.Builder()
                    .stepCode(NodeType.EXPIRE_NODE)
                    .stateCode(NodeState.PROCESSED)
                    .bizCode(prpCmain.getPolicyNo())
                    .inflowTime(date)
                    .outflowTime(date)
                    .opTime(date)
                    .resultCode(prpCmain.getUnderwriteFlag())
                    .build();
            this.generateNodeData(processDto);
        }
        LOGGER.error("承保流程[到期]节点数据生成结束,合计共有" + prpCmains.size() + "个保单");
    }
}
