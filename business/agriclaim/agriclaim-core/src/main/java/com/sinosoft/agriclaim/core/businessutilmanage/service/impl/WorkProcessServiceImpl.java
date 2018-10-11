package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestWorkProcessDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponseSwfLogQueryDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.WorkProcessDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathLogDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.WorkProcessDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.WorkProcess;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.WorkProcessKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.WorkProcessService;
import com.sinosoft.agriclaim.core.businessutilmanage.utils.UsuallyUseUtils;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfFlowMainDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogStoreDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfPathLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.*;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-15 07:15:21.216
 * @description 工作流程表Core接口实现
 */
@Service
@Transactional
public class WorkProcessServiceImpl extends BaseCustomServiceImpl implements WorkProcessService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkProcessServiceImpl.class);

    @Autowired
    private WorkProcessDao workProcessDao;
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
    private SwfLogStoreDao swfLogStoreDao;
    @Autowired
    private SwfPathLogDao swfPathLogDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SwfFlowMainDao swfFlowMainDao;

    /**
     *@description 新增
     *@param
     */
    public void save(WorkProcessDto workProcessDto) {
        WorkProcess workProcess = this.convert(workProcessDto, WorkProcess.class);
        workProcessDao.save(workProcess);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(Integer id,String registNo) {
        WorkProcessKey workProcessKey = new WorkProcessKey(id,registNo);
        workProcessDao.delete(workProcessKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(WorkProcessDto workProcessDto) {
        WorkProcess workProcess = this.convert(workProcessDto, WorkProcess.class);
        workProcessDao.save(workProcess);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public WorkProcessDto queryByPK(Integer id,String registNo) {
        WorkProcessKey workProcessKey = new WorkProcessKey(id,registNo);
        WorkProcess workProcess = workProcessDao.findOne(workProcessKey);
        return this.convert(workProcess,WorkProcessDto.class);
    }
    /**
     * 报案登记暂存-结案时保存到工作流程表中（理算环节除外）
     * @author: 孙朋飞
     * @date: 2017/12/15 15:44
     * @param policyNo 保单号
     * @param registNo 报案号
     * @param claimNo 立案号
     * @param caseNo 结案号
     * @param classCode 险种大类
     * @param riskCode 险种
     * @param nodeType 当前节点代码
     * @param nextNodeType 下一节点代码
     * @param caseType 案件装态
     * @param operator 操作人
     * @throws Exception
     */
    public void saveWorkProcess(String policyNo, String registNo, String claimNo, String caseNo, String classCode, String riskCode, String nodeType, String nextNodeType, Enum caseType, String operator) throws Exception {
        //通过报案号查询最大的id
        Integer id = workProcessDao.findMaxKeyByRegistNo(registNo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //保存数据
        WorkProcess workProcess;
        if("regis".equals(nodeType)){
            workProcess = new WorkProcess();
        }else{
            //根据报案号和序号查询
            WorkProcessKey workProcessKey = new WorkProcessKey(id,registNo);
            workProcess = workProcessDao.findOne(workProcessKey);
        }
        workProcess.setId(id);
        workProcess.setPolicyNo(policyNo);
        workProcess.setRegistNo(registNo);
        workProcess.setClaimNo(claimNo);
        workProcess.setCaseNo(caseNo);
        workProcess.setClassCode(classCode);
        workProcess.setRiskCode(riskCode);
        workProcess.setNodeType(nodeType);
        workProcess.setOperator(operator);
        workProcess.setNextNodeType(nextNodeType);
        workProcess.setCaseType(caseType.toString());
        //报案流入时间
        if("regis".equals(nodeType)){
            workProcess.setRegistFlowInTime(sdf.format(new Date()));
        }
        workProcess.setFlowInTime(sdf.format(new Date()));
        workProcess.setOperateDate(new Date());
        workProcessDao.save(workProcess);
    }
    /**
     *（保存到工作流程表的信息理算环节调用的方法）
     * @author: 孙朋飞
     * @date: 2017/12/15 19:58
     * @param registNo 报案号
     * @param compensateNo 理算书号
     * @param operator 操作人
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveWorkProcessCompensate(String registNo,String compensateNo,String nodeType,String nextNodeType, String operator) throws Exception {
        if(StringUtils.isEmpty(compensateNo)){
            throw new DataVerifyException("赔款计算书号不能为空!");
        }
        Integer id = workProcessDao.findMaxKeyByRegistNo(registNo);
        //根据主键查询实体
        WorkProcessKey workProcessKey = new WorkProcessKey(id,registNo);
        WorkProcess workProcess = workProcessDao.findOne(workProcessKey);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(workProcess!=null ){
            if(StringUtils.isNotEmpty(workProcess.getCompensateNo()) && !compensateNo.equals(workProcess.getCompensateNo())){
                //有理算书号 插入新的数据  并生成新的id
                id += 1;
                WorkProcess wProcess = new WorkProcess();
                wProcess.setId(id);
                wProcess.setRegistNo(registNo);
                wProcess.setPolicyNo(workProcess.getPolicyNo());
                wProcess.setClaimNo(workProcess.getClaimNo());
                wProcess.setRegistFlowInTime(workProcess.getRegistFlowInTime());
                wProcess.setClassCode(workProcess.getClassCode());
                wProcess.setRiskCode(workProcess.getRiskCode());
                wProcess.setNodeName(workProcess.getNodeName());
                wProcess.setFlowId(workProcess.getFlowId());
                wProcess.setCompensateNo(compensateNo);
                wProcess.setNodeType(nodeType);
                wProcess.setNextNodeType(nextNodeType);
                wProcess.setOperator(operator);
                wProcess.setFlowInTime(sdf.format(new Date()));
                wProcess.setOperateDate(new Date());
                workProcessDao.save(wProcess);
                return;
            }
        }
        workProcess.setId(id);
        workProcess.setRegistNo(registNo);
        workProcess.setCompensateNo(compensateNo);
        workProcess.setNodeType(nodeType);
        workProcess.setNextNodeType(nextNodeType);
        workProcess.setOperator(operator);
        workProcess.setFlowInTime(sdf.format(new Date()));
        workProcess.setOperateDate(new Date());
        workProcessDao.save(workProcess);
    }
    /**
     *（流程查询-分页查询）
     * @author: 孙朋飞
     * @date: 2017/12/16 10:46
     * @param processDto 接受参数的Dto
     * @return 流程查询表的集合
     * @throws Exception
     */
    @Override
    public PageInfo<WorkProcessDto> queryWorkProcessByConditions(RequestWorkProcessDto processDto) throws Exception{
        //请求参数校验
        if (processDto == null) {
            throw new DataVerifyException("请求参数不能为空!");
        }
        if (processDto.getPageNo()<1) {
            processDto.setPageNo(1);
        }
        if (processDto.getPageSize()<1){
            processDto.setPageSize(20);
        }
        List<String> conditions=new ArrayList<>();
        Map<String,String> condition=new HashMap<>();
        //保单号policyNo
        if (StringUtils.isNotEmpty(processDto.getPolicyNo())){
            conditions.add(" AND p.policyNo LIKE :policyNo");
            condition.put("policyNo",processDto.getPolicyNo()+"%");
        }
        //报案号registNo
        if (StringUtils.isNotEmpty(processDto.getRegistNo())){
            conditions.add(" AND p.registNo LIKE :registNo");
            condition.put("registNo",processDto.getRegistNo()+"%");
        }
        //立案号 claimNo
        if (StringUtils.isNotEmpty(processDto.getClaimNo())){
            conditions.add(" AND p.claimNo LIKE :claimNo");
            condition.put("claimNo",processDto.getClaimNo()+"%");
        }
        //赔案号caseNo
        if (StringUtils.isNotEmpty(processDto.getCaseNo())){
            conditions.add(" AND p.caseNo LIKE :caseNo");
            condition.put("caseNo",processDto.getCaseNo()+"%");
        }
        //赔款计算书号compensateNo
        if (StringUtils.isNotEmpty(processDto.getCompensateNo())){
            conditions.add(" AND p.compensateNo LIKE :compensateNo ");
            condition.put("compensateNo",processDto.getCompensateNo()+"%");
        }
        //险种大类 classCode 种植险“31” 养殖险“32”
        if (StringUtils.isNotEmpty(processDto.getClassCode())){
            conditions.add(" AND p.classCode LIKE :classCode");
            condition.put("classCode",processDto.getClassCode());
        }
        //流入时间
        if (StringUtils.isNotEmpty(processDto.getInTime()) ){
            conditions.add(" AND to_date(p.registFlowInTime,'yyyy-mm-dd hh24:mi:ss') >= to_date(:inTime,'yyyy-mm-dd hh24:mi:ss')");
            condition.put("inTime",processDto.getInTime());
        }
        //～时间
        if(StringUtils.isNotEmpty(processDto.getOutTime())){
            conditions.add(" AND to_date(p.registFlowInTime,'yyyy-mm-dd hh24:mi:ss') <= to_date(:outTime,'yyyy-mm-dd hh24:mi:ss')");
            condition.put("outTime",processDto.getOutTime());
        }

        //案件状态 结案“1”，未结案“0”,全部为null
        if(StringUtils.isNotEmpty(processDto.getCaseType())){
            if("1".equals(processDto.getCaseType())){
                conditions.add(" AND p.caseNo is not null ");
            }else if("0".equals(processDto.getCaseType())){
                conditions.add(" AND p.caseNo is null ");
            }
        }
        //数据
        StringBuilder dataSql=new StringBuilder("select p from WorkProcess p ");
        StringBuilder countSql=new StringBuilder("select count(1) from WorkProcess p");
        if(conditions.size()>0){
            String dataConditions = this.joinCondition(conditions);
            dataSql.append(" where ");
            dataSql.append(dataConditions);
            countSql.append(" where ");
            countSql.append(dataConditions);
        }
        dataSql.append(" order by p.flowInTime");
        Query query = entityManager.createQuery(dataSql.toString());
        Query countQuery= entityManager.createQuery(countSql.toString());
        query.setFirstResult((processDto.getPageNo()-1)*processDto.getPageSize());
        query.setMaxResults(processDto.getPageSize());
        for (Map.Entry<String, String> entry : condition.entrySet()) {
            query.setParameter(entry.getKey(),entry.getValue());
            countQuery.setParameter(entry.getKey(),entry.getValue());
        }
        List<WorkProcess> resultList = query.getResultList();
        Long countNum=Long.valueOf(String.valueOf(countQuery.getSingleResult()));
        List<WorkProcessDto> workProcessDtoList=new ArrayList<>();
        for (WorkProcess workProcess : resultList) {
            //节点的名称
            workProcess.setNodeName(UsuallyUseUtils.nodeTypeTransformToChinese(workProcess.getNextNodeType()));
        }
        convertCollection(resultList,workProcessDtoList,WorkProcessDto.class);
        PageInfo<WorkProcessDto> pageInfo=new PageInfo<WorkProcessDto>();
        pageInfo.setContent(workProcessDtoList);//添加数据
        pageInfo.setPages(processDto.getPageNo());// 当前页数
        pageInfo.setTotalCount(countNum);// 总记录数
        return pageInfo;
    }
    /**
     * 案件流程节点列表信息查询
     * @author: 孙朋飞
     * @date: 2017/11/7 11:40
     * @param processDto 接受参数的Dto(RegistNo报案号（必传），flowId流程号)
     * @return 返回日志表、收付信息表、流程主表、工作流路径日志表信息
     * @throws Exception
     */
    public ResponseSwfLogQueryDto querySwfLogAndSwfLogStoreByConditions(RequestWorkProcessDto processDto) throws Exception {
        //请求参数校验
        if (processDto == null) {
            throw new DataVerifyException("请求参数不能为空！");
        }
        if(StringUtils.isEmpty(processDto.getRegistNo())){
            throw new DataVerifyException("报案号不能为空！");
        }
        //获取流程号
        String flowId=processDto.getFlowId();
        if(StringUtils.isEmpty(flowId)){
            String registNo=processDto.getRegistNo();
            //查询swflog
            flowId = swfLogDao.findSwfLogByRegistNo(registNo);
            if(StringUtils.isEmpty(flowId)){
                flowId=  swfLogStoreDao.findSwfLogStoreByRegistNo(registNo);
            }
        }
        //查询流程主表，通过流程主表中的flowstatus的状态，如果是“1”表示没有完成，从swflog表里查询
        //如果是flowstatus=0 ，则表示需要从swflogstore表里取数据。
        SwfFlowMainKey swfFlowMainKey = new SwfFlowMainKey(flowId);
        SwfFlowMain swfFlowMain = swfFlowMainDao.findOne(swfFlowMainKey);
        ResponseSwfLogQueryDto responseSwfLogQueryDto =new ResponseSwfLogQueryDto();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (swfFlowMain!=null){
            //根据流程编号去swfFlowMain查询流程说明，hql查询 流程的状态、创建时间、关闭事件
            responseSwfLogQueryDto.setFlowStatusName(UsuallyUseUtils.flowStatusToChinese(swfFlowMain.getFlowStatus()));
            if("0".equals(swfFlowMain.getFlowStatus())) {
                //流转结束显示关闭时间
                if(swfFlowMain.getCloseDate()!=null){
                    responseSwfLogQueryDto.setCloseDateName(sdf.format(swfFlowMain.getCloseDate()) + AgriClaimConstant.AGRI_CLAIM_CLOSE);
                }
            }
            if(swfFlowMain.getCreatDate()!=null){
                responseSwfLogQueryDto.setCreatDateName(sdf.format(swfFlowMain.getCreatDate())+ AgriClaimConstant.AGRI_CLAIM_CREATE);
            }
            responseSwfLogQueryDto.setIsSpecialCase(AgriClaimConstant.AGRI_CLAIM_NOTSPECIALCASE);
        }else{
            return null;
        }
        Query dataQuery =null;
        if(("1").equals(swfFlowMain.getStoreFlag())){
            //从存储表里查询
            StringBuilder dataSql=new StringBuilder("select p from SwfLogStore p where p.flowId=:flowId order by p.logNo ASC");
            dataQuery = entityManager.createQuery(dataSql.toString());
        }else{
            StringBuilder dataSql=new StringBuilder("select p from SwfLog p where p.flowId=:flowId order by p.logNo ASC");
            dataQuery = entityManager.createQuery(dataSql.toString());
        }
        dataQuery.setParameter("flowId",flowId);
        //查询流程路径
        List<SwfPathLog> swfPathLogList=swfPathLogDao.findFlowPathLogByFlowId(flowId);
        List<SwfPathLogDto> swfPathLogDtoList =new ArrayList<>();
        convertCollection(swfPathLogList,swfPathLogDtoList,SwfPathLogDto.class);
        List<SwfLogDto> responseList=new ArrayList<>();
        if(!("1").equals(swfFlowMain.getStoreFlag())){
            List<SwfLog>  swfLogList = dataQuery.getResultList();
            convertCollection(swfLogList,responseList,SwfLogDto.class);
        }else{
            List<SwfLogStore> swfLogList = dataQuery.getResultList();
            convertCollection(swfLogList,responseList,SwfLogDto.class);
        }
        if(responseList!=null &&responseList.size()>0){
            for (SwfLogDto QueryDto : responseList) {
                //去掉理算让人不理解的状态显示 理算状态显示为空
                if(!"compe".equals(QueryDto.getNodeType())){
                    QueryDto.setNodeStatusName(UsuallyUseUtils.nodeStatusToChinese(QueryDto.getNodeStatus()));
                }
                if("speci".equals(QueryDto.getNodeType())){
                    responseSwfLogQueryDto.setIsSpecialCase(AgriClaimConstant.AGRI_CLAIM_SPECIALCASE);
                }
            }
        }
        //第一个节点
        SwfLogDto sswfLogListDto = responseList.get(0);
        //查询的总条数
        if(responseList!=null){
            responseSwfLogQueryDto.setCountNum(responseList.size());
        }
        //todo 如果已支付查询支付日期、支付总额、保险人等
        //流程查询树的封装
        int    treeLayerDeep        = 0  ;//节点层深度
        int    treeStartNodeNo      = 1  ;//缺省开始节点为1
        Collection swfLogTreeList  = new ArrayList();
        //加入第一个报案节点;
        if(treeLayerDeep==0){
            for(int j=0;j<responseList.size();j++){
                SwfLogDto swfLogFirstDto  = responseList.get(j);
                if(swfLogFirstDto.getNodeNo() == 1){
                    treeLayerDeep = 1;
                    swfLogFirstDto.setTreeLayer(treeLayerDeep);
                    //将得到层与节点信息装入节点树
                    swfLogFirstDto.setStartNodeNo(0);
                    swfLogFirstDto.setEndNodeNo(1);
                    responseList.add(swfLogFirstDto);
                    break;
                }
            }
        }
        createNodeTree(swfLogTreeList,responseList,swfPathLogDtoList,treeStartNodeNo,treeLayerDeep);
        swfLogTreeList.add(sswfLogListDto);
        List<SwfLogDto> treeList = orderFlowList((ArrayList)swfLogTreeList);
        List<SwfLogDto> newTreeList=new ArrayList<>();
        //循环添加占位符
        List<Integer> list=new ArrayList<>();
        for (SwfLogDto swfLogDto : treeList) {
            //最大的节点
            Integer nodePosLayer = swfLogDto.getNodePosLayer();
            Integer treeLayer = swfLogDto.getTreeLayer();
            //获取每一层最小的列  再比较这个列与该层其它列
            Integer minNodePosLayer = findMinNodePosLayer(nodePosLayer, treeLayer, treeList);
            //如果层数与上一层相等则不进行下一轮的添加了   只添加其自身。
            if(!list.contains(treeLayer)){
                for(int i=minNodePosLayer-1;i>0;--i){
                    SwfLogDto swfLogDto1 = new SwfLogDto();
                    swfLogDto1.setNodePosLayer(i);
                    swfLogDto1.setTreeLayer(treeLayer);
                    newTreeList.add(swfLogDto1);
                }
            }
            for (SwfLogDto swf : treeList) {
                if(treeLayer.equals(swf.getTreeLayer())&&nodePosLayer.equals(swf.getNodePosLayer())){
                    //添加本身
                    newTreeList.add(swf);
                }
            }
            list.add(treeLayer);


        }
        responseSwfLogQueryDto.setSwfLogDtoTreeList(newTreeList);
        responseSwfLogQueryDto.setSwfPathLogList(swfPathLogDtoList);
        return  responseSwfLogQueryDto;
    }



    /**
     *（请具体描述此方法的用途及逻辑）
     * @author: 孙朋飞
     * @date: 2018/2/9 21:14
     * @param nodePosLayer 每一列
     * @param treeLayer 每一层
     * @param treeList 树的集合
     * @return 每层最小的列
     * @throws Exception
     */
    private static Integer findMinNodePosLayer(Integer nodePosLayer,Integer treeLayer,List<SwfLogDto> treeList) throws Exception{
        for (SwfLogDto swfLogDto : treeList) {
            if(treeLayer.equals(swfLogDto.getTreeLayer())){
                if(nodePosLayer>swfLogDto.getNodePosLayer()){
                    nodePosLayer=swfLogDto.getNodePosLayer();
                }

            }
        }
        return nodePosLayer;
    }
    /**
     * 将日志表的数据和工作流路径表数据封装成树型结构
     * @date: 2017/12/19 16:46
     * @param swfLogTreeList 节点树
     * @param swfLogList wfLog列表
     * @param swfPathLogList wfPathLog列表
     * @param treeStartNodeNo 树的开始节点
     * @param treeLayerDeep 树的层深
     * @throws Exception
     */
    private static  void createNodeTree(Collection swfLogTreeList,List<SwfLogDto> swfLogList,List<SwfPathLogDto> swfPathLogList,int treeStartNodeNo,int treeLayerDeep) throws Exception{
        /**
         * 程序设计思路:
         * 根据第一个节点，做为开始节点，得到startNode节点的endNode,以此endNode节点的做为
         * startNode再查询它的EndNode,以此方法递归得到一个树状结构
         */
        int treeEndNodeNo   = 0 ;                //树或边的终止节点
        List<SwfPathLogDto> layerPathList = new ArrayList<>();   //存放本层的节点
        for(int i=0;i<swfPathLogList.size();i++){
            SwfPathLogDto swfPathLogNodeDto = swfPathLogList.get(i);
            if(swfPathLogNodeDto.getStartNodeNo()==treeStartNodeNo){
                layerPathList.add(swfPathLogNodeDto);
            }//end if
        }
        //从层里查询到有哪些结束节点，判断结束节点是否有后续节点，如果有则取后续节点，没有则结束
        for(int k=0;k<layerPathList.size();k++){
            SwfPathLogDto swfPathLogLayerDto = layerPathList.get(k);
            treeEndNodeNo = swfPathLogLayerDto.getEndNodeNo();
            //是否有后续节点
            if(isExistNextNode(swfPathLogList,treeEndNodeNo)){
                //System.out.println("startNo2=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo2=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName()  );
                //查找与条件中的结束节点
                for(int j=0 ;j<swfLogList.size();j++) {
                    SwfLogDto swfLogNodeDto =swfLogList.get(j);
                    //System.out.println("######要处理的数据="+treeLayerDeep+"|"+ "startNo=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName() + "||" + swfLogNodeDto.getNodeNo() + "|"+swfLogNodeDto.getNodeName() );
                    if(swfLogNodeDto.getLogNo()==treeEndNodeNo){
                        //设置层
                        if (k == 0) {
                            treeLayerDeep = treeLayerDeep + 1;
                        }
                        swfLogNodeDto.setTreeLayer(treeLayerDeep) ;
                        //将得到层与节点信息装入节点树
                        //System.out.println("layer="+treeLayerDeep+"|"+ "startNo=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName() + "||" + swfLogNodeDto.getNodeNo() + "|"+swfLogNodeDto.getNodeName() );
                        swfLogNodeDto.setStartNodeNo(swfPathLogLayerDto.getStartNodeNo()) ;
                        swfLogNodeDto.setEndNodeNo(swfPathLogLayerDto.getEndNodeNo()) ;
                        swfLogTreeList.add(swfLogNodeDto);
                        //递归查找下一节点
                        createNodeTree(swfLogTreeList,swfLogList,swfPathLogList,treeEndNodeNo,treeLayerDeep);
                        break;    //取得下一节点后不再循环
                    }
                }//end for
            }
            else{
                //查找与条件中的结束节点
                for(int j=0 ;j<swfLogList.size() ;j++){
                    SwfLogDto swfLogNodeDto =swfLogList.get(j);
                    if(swfLogNodeDto.getLogNo()==treeEndNodeNo){
                        //设置层
                        if (k == 0) {
                            treeLayerDeep = treeLayerDeep + 1;
                        }
                        swfLogNodeDto.setTreeLayer(treeLayerDeep) ;
                        //将得到层与节点信息装入节点树
                        System.out.println("无后序节点layer="+treeLayerDeep+"|"+ "startNo=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName() + "||" + swfLogNodeDto.getNodeNo() + "|"+swfLogNodeDto.getNodeName() + "|"  );
                        swfLogNodeDto.setStartNodeNo(swfPathLogLayerDto.getStartNodeNo()) ;
                        swfLogNodeDto.setEndNodeNo(swfPathLogLayerDto.getEndNodeNo()) ;
                        swfLogTreeList.add(swfLogNodeDto);
                        break;    //取得下一节点后不再循环
                    }
                }//end for
            }
        }
        treeLayerDeep = treeLayerDeep - 1 ;
    }
    /**
     * 判断是否有后续节点
     * @date: 2017/12/19 17:07
     * @param sourceList 工作流路径的集合
     * @param startNode 开始节点
     * @return 有后续节点返回true
     * @throws Exception
     */
    private static boolean isExistNextNode(List<SwfPathLogDto> sourceList,int startNode) throws Exception {
        boolean isExist = false;  //是否有后续节点
        for(int i=0;i<sourceList.size();i++) {
            SwfPathLogDto swfPathLogNodeDto = sourceList.get(i);
            if(swfPathLogNodeDto.getStartNodeNo() ==startNode){
                isExist = true;
            }
        }
        return isExist;
    }

    /**
     * 整理成要输出的顺序列表
     * @author: 孙朋飞
     * @date: 2017/12/19 17:06
     * @param sourceList 树形结构所需的数据
     * @return 整理后的树形列表
     * @throws Exception
     */
    private List<SwfLogDto> orderFlowList(List<SwfLogDto> sourceList) throws Exception {
        List<SwfLogDto> sameLayerList = new ArrayList<>();  //存放同层
        List<SwfLogDto> noSameNodeList = new ArrayList<>(); //同层没有相同节点列表
        List<SwfLogDto> orderList      = new ArrayList<>(); //已排好次序的列表
        int startNodeNo     = 0 ;  //开始节点
        int endNodeNo       = 0 ;  //结束节点
        int treeLayerDeep   = 0 ;  //层中节点数
        int countLayerSameNode = 0 ;//同层中相同节点的个数

        //去掉startNodeNo，endNodeNo相同的同层节点,
        for(int i=0;i<sourceList.size();i++){
            SwfLogDto swfLogSource = sourceList.get(i);
            startNodeNo = swfLogSource.getStartNodeNo() ;
            endNodeNo = swfLogSource.getEndNodeNo();
            treeLayerDeep = swfLogSource.getTreeLayer() ;
            for(int j=0;j<noSameNodeList.size();j++){
                SwfLogDto swfLogDiff = noSameNodeList.get(j);  //用于比较的Dto
                if(swfLogDiff.getStartNodeNo()==startNodeNo && swfLogDiff.getEndNodeNo()==endNodeNo&&swfLogDiff.getTreeLayer() == treeLayerDeep){
                    countLayerSameNode = 1 ;
                    break;
                }
            }
            if(countLayerSameNode==0)
                noSameNodeList.add(swfLogSource) ;
            countLayerSameNode = 0 ;
        }
        //将同层按顺序排列
        for(int k=0;k<noSameNodeList.size();k++){
            for(int n=0;n<noSameNodeList.size() ;n++){
                SwfLogDto swfLogList = noSameNodeList.get(n);
                if (swfLogList.getTreeLayer() == k + 1) {
                    sameLayerList.add(swfLogList);
                }
            }
        }
        //对同层节点计数，并列出位置次序，从高到低的次序
        int nodeCount      = 0 ;//节点数
        int nodePosOrder   = 0 ;//节点在层的位置
        int oldLayer       = 0 ;//旧的层
        int currLayer      = 0 ;//当前层
        int oldNodePosOrder= 1 ;//旧的层节点在层的位置
        int flag=0;//标记
        int oldStartNodeNo=0;//上一个开始的节点
        for(int k=0;k<sameLayerList.size();k++){
            List<Integer> arrayList=new ArrayList<>();
            SwfLogDto swfLogOrder = sameLayerList.get(k);
            //得到前一节点的层数,根据前一节点的层数判断是否放在一个层
            if (k == 0){
                oldLayer = 1;
            }
            else {
                oldLayer = currLayer;
            }
            currLayer = swfLogOrder.getTreeLayer() ;
            for(int n=0;n<sameLayerList.size() ;n++){
                SwfLogDto swfLogList = sameLayerList.get(n);
                if (swfLogList.getTreeLayer() == currLayer ) {
                    nodeCount = nodeCount + 1;
                }else{
                    if(swfLogList.getEndNodeNo()==swfLogOrder.getStartNodeNo()){
                        //获取旧的层nodePosOrder
                        oldNodePosOrder=swfLogList.getNodePosLayer();
                        arrayList.add(oldNodePosOrder);
                    }
                }
            }
            //每层数量为1的话取最小值
            currLayer = swfLogOrder.getTreeLayer() ;
            swfLogOrder.setCountNode(nodeCount) ;
            //设置次序
            //第一个节点nodePosOrder为1
            if(oldLayer==currLayer){
                //同一层如果开始节点一致才进行标记
                if(oldStartNodeNo==swfLogOrder.getStartNodeNo()){
                    flag++;
                }
                if(nodePosOrder>0){
                    nodePosOrder = flag+oldNodePosOrder;
                } else {
                    nodePosOrder = 1;
                }
                swfLogOrder.setNodePosLayer(nodePosOrder) ;
            } else {
                nodePosOrder = oldNodePosOrder;
                if(nodeCount==1){
                    nodePosOrder=Collections.min(arrayList);
                }
                swfLogOrder.setNodePosLayer(nodePosOrder) ;
                flag=0;
            }
            oldStartNodeNo = swfLogOrder.getStartNodeNo();
            orderList.add(swfLogOrder);
            nodeCount =  0 ;
        }
        //modify by weishixin add 20050225 start
        //reason:计算流入和流出时间差
        //计算停留时间差
        int size =  orderList.size();
        DateTime beginTime = null ;   //开始时间
        DateTime endTime   = null  ;  //结束时间
        String   flowInTime = "" ;    //流入时间
        String   submitTime = "" ;    //提交时间
        int      stopTime   = 0 ;     //停留时间
        boolean  isDate     = false ;     //是否是日期
        boolean  isDateInput    = false ; //输入日期是否正确
        StringBuffer stopTimeDesc  = null ;
        for(int i=0;i<size;i++)
        {
            SwfLogDto swfLogListStopTime = orderList.get(i);
            flowInTime = swfLogListStopTime.getFlowInTime() ;
            submitTime = swfLogListStopTime.getSubmitTime() ;

            //对于没有时间的案件 设置stopTime = 0 ;
            if(flowInTime==null||flowInTime.equals("null") ||flowInTime.equals("")||submitTime==null||submitTime.equals("null") ||submitTime.equals("") ) {
                stopTime = 0 ;
            } else  //计算差值
            {
                isDate = this.isDateTime(flowInTime);
                //判断输入日期是否正确
                if(isDate){
                    if(flowInTime.length() <11) {
                        beginTime = new DateTime(flowInTime, DateTime.YEAR_TO_DAY);
                    }
                    else{
                        beginTime = new DateTime(flowInTime, DateTime.YEAR_TO_SECOND);
                    }
                    isDateInput = true ;
                }else {
                    isDateInput = false ;
                }
                isDate = this.isDateTime(submitTime);
                if(isDate){
                    if(submitTime.length()<11){
                        endTime = new DateTime(submitTime, DateTime.YEAR_TO_DAY);
                    }else{
                        endTime = new DateTime(submitTime, DateTime.YEAR_TO_SECOND);
                    }
                    isDateInput = true ;
                }else {
                    isDateInput = false ;
                }

                if(isDateInput) {
                    long diffTime = endTime.getTime()- beginTime.getTime() ;

                    swfLogListStopTime.setStopTime(diffTime) ;
                    //计算文字描述
                    long dayToMiins = 1000*60*60*24 ;
                    long hourToMiins = 60*60*1000;
                    long minuteToMiins = 60*1000;
                    int  secondToMiins = 1000;
                    long hourCount   = 0 ;  //小时数
                    long minuteCount = 0 ;  //分钟
                    int  secondCount = 0;
                    long dayCount   = (long)diffTime/dayToMiins  ;
                    long remainNum = diffTime % dayToMiins  ;
                    if(remainNum>0) {
                        hourCount = (long)remainNum/hourToMiins;  //计算小时
                        remainNum      = remainNum % hourToMiins;
                        if(remainNum > 0) {
                            minuteCount = (long)remainNum/minuteToMiins; //计算分钟
                            remainNum   = remainNum % minuteToMiins;
                            if(remainNum>0) {
                                secondCount = (int)remainNum/secondToMiins;

                            } else {
                                secondCount = 0 ;
                            }
                        } else {
                            minuteCount = 0 ;
                        }
                    } else{
                        hourCount = 0 ;
                    }
                    stopTimeDesc = new StringBuffer();

                    stopTimeDesc =  stopTimeDesc.append(dayCount+"天"+hourCount+"小时"+minuteCount + "分钟"+secondCount+"秒");
                }
                stopTimeDesc = stopTimeDesc.append("日期格式不正确");
                swfLogListStopTime.setStopTimeDesc(stopTimeDesc.toString()) ;
            }
        }
        return orderList;
    }

    /**
     *判断日期源串是否是日期
     * @author: 孙朋飞
     * @date: 2017/12/19 17:10
     * @param sourceDateTime 传入的日期
     * @return 是日期返回true
     * @throws Exception
     */
    private boolean isDateTime(String sourceDateTime) throws Exception {
        boolean isDate = false ;
        DateTime checkTime = null ;
        try {
            if(sourceDateTime.length()<11){
                checkTime = new DateTime(sourceDateTime,DateTime.YEAR_TO_DAY);
                isDate = true ;
            }
            else{
                checkTime = new DateTime(sourceDateTime,DateTime.YEAR_TO_SECOND);
                isDate = true ;
            }
            System.out.println("不是日期："+sourceDateTime);
        } catch(Exception e) {
            System.out.println("不是日期："+sourceDateTime);
            isDate = false ;
        }
        return isDate;
    }
}