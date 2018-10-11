package com.sinosoft.agriclaim.core.jobmanage.service.impl;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.jobmanage.dto.*;
import com.sinosoft.agriclaim.core.jobmanage.dao.PrpLJobLinkerDao;
import com.sinosoft.agriclaim.core.jobmanage.dao.PrpLJobManagerDao;
import com.sinosoft.agriclaim.core.jobmanage.dao.PrpLJobManagerTimeDao;
import com.sinosoft.agriclaim.core.jobmanage.dao.PrplAreaSettingDao;
import com.sinosoft.agriclaim.core.jobmanage.entity.*;
import com.sinosoft.agriclaim.core.jobmanage.service.PrpLJobManagerService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;



/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-08 05:42:38.981
 * @description 班表管理主表Core接口实现
 */

@Service
public class PrpLJobManagerServiceImpl extends BaseCustomServiceImpl implements PrpLJobManagerService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLJobManagerServiceImpl.class);

    @Autowired
    private PrpLJobManagerDao prpLJobManagerDao;
    @Autowired
    private PrpLJobManagerTimeDao prpLJobManagerTimeDao;
    @Autowired
    private PrpLJobLinkerDao prpLJobLinkerDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrplAreaSettingDao prplAreaSettingDao;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
    private PrpDuserApi prpDuserApi;

    /**
     * @Description: 根据条件查询是否存在该月班表主表信息
     * @throws Exception
     * @Author: 李文刚
     * @Date： 2017/11/13 9:08
     * @Param prpLJobManagerDto 班表机构handleDept，班表月份month，险类classCode,当班人handlerCode
     * @Return prpLJobManagerDtoList 班表主表信息集合
     */
    public List <PrpLJobManagerDto> queryJobManagerByCondition(PrpLJobManagerDto prpLJobManagerDto) throws Exception {
        //三个必选条件不能为空
        String handleDept = prpLJobManagerDto.getHandleDept();
        if (StringUtils.isEmpty(handleDept)) {
            throw new DataVerifyException("班表机构不能为空");
        }
        String month = prpLJobManagerDto.getMonth();
        if (StringUtils.isEmpty(month)) {
            throw new DataVerifyException("班表月份不能为空");
        }
        String classCode = prpLJobManagerDto.getClassCode();
        if (StringUtils.isEmpty(classCode)) {
            throw new DataVerifyException("险类不能为空");
        }
        // 查询数据HQL
        StringBuilder dataSql = new StringBuilder("select p from PrpLJobManager p where  p.handleDept =:handleDept and p.month=:month and p.classCode=:classCode");
        StringBuilder condition = new StringBuilder();
        Map<String, String> conditions = new HashMap<>();

        conditions.put("handleDept", handleDept);
        conditions.put("month", month);
        conditions.put("classCode", classCode);
        //当班人员不为空时
        String handlerCode = prpLJobManagerDto.getHandlerCode();
        if (StringUtils.isNotEmpty(handlerCode)) {
            condition.append(" and p.handlerCode=:handlerCode");
            conditions.put("handlerCode", handlerCode);
        }
        dataSql.append(condition);
        Query query = entityManager.createQuery(dataSql.toString());

        for (Map.Entry<String, String> entry : conditions.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        List<PrpLJobManager> resultList = query.getResultList();

        List<PrpLJobManagerDto> prpLJobManagerDtoList = new ArrayList<>();
        //数据库对象集合转为dto对象集
        convertCollection(resultList, prpLJobManagerDtoList, PrpLJobManagerDto.class);
         return prpLJobManagerDtoList;

    }

    /**
     * @Description: 根据班表机构handleDept，班表月份month，险类classCode,当班人handlerCode查询班表主表，班表从表，联系表信息
     * 此服务接口为班表管理模块的上个月班表查询，机构查询，个人查询所公用.具体由prpLJobManagerDto中queryType前端赋值判断查询方式
     * queryType:copy查询上个月班表信息，queryType:institution为机构查询queryType:personal个人查询
     * @throws  Exception
     * @author: 李文刚
     * @date: 2017/11/22 14:16
     * @Param prpLJobManagerDto 封装查询条件参数：班表机构handleDept，班表月份month，险类classCode,当班人handlerCode,queryType为查询方式判断
     * @Return PrpLJobManagerSaveDto 班表主表结果集，从表结果集，联系人表结果集封装成DTO对象
     */

    public PrpLJobManagerSaveDto queryJobManagerDetailByCondition(PrpLJobManagerDto prpLJobManagerDto) throws Exception {

        if (prpLJobManagerDto == null) {
            throw new DataVerifyException("无记录查询条件异常");
        }
        //三个查询条件必选项
        String handleDept = prpLJobManagerDto.getHandleDept();
        if (StringUtils.isEmpty(handleDept)) {
            throw new DataVerifyException("班表机构不能为空");
        }
        String month = prpLJobManagerDto.getMonth();
        if (StringUtils.isEmpty(month)) {
            throw new DataVerifyException("班表月份不能为空");
        }
        String classCode = prpLJobManagerDto.getClassCode();
        if (StringUtils.isEmpty(classCode)) {
            throw new DataVerifyException("险类不能为空");
        }
        //查询类型不能为空
        String queryType=prpLJobManagerDto.getQueryType();
        if(StringUtils.isEmpty(queryType)){
            throw new DataVerifyException("查询类型不能为空");
        }
        //得到上个月的月份
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar cday = Calendar.getInstance();
        cday.setTime(sdf.parse(month));
        cday.set(cday.MONTH, cday.get(cday.MONTH) - 1);
        String oldMonth = sdf.format(cday.getTime());
        // 查询数据HQL
        StringBuilder dataSql = new StringBuilder("select p from PrpLJobManager p where p.handleDept =:handleDept and p.month=:month and p.classCode=:classCode");
        StringBuilder timeSql = new StringBuilder("select t from PrpLJobManagerTime t where t.fid in (select p.id from PrpLJobManager p where p.handleDept =:handleDept and p.month=:month and p.classCode=:classCode");
        StringBuilder linkSql = new StringBuilder("select k from PrpLJobLinker k where k.handleDept =:handleDept and k.month=:month and k.classCode=:classCode");
        Map<String, String> conditions = new HashMap<>();
        Map<String, String> condition = new HashMap<>();
        //有三个必选条件时,queryType:copy查询上个月班表信息，queryType:institution为机构查询queryType:personal个人查询
        if ("copy".equals(prpLJobManagerDto.getQueryType())) {
            conditions.put("month", oldMonth);
            conditions.put("handleDept", handleDept);
            conditions.put("classCode", classCode);
        }

        if ("institution".equals(prpLJobManagerDto.getQueryType()) || "personal".equals(prpLJobManagerDto.getQueryType())) {
            conditions.put("month", month);
            conditions.put("handleDept", handleDept);
            conditions.put("classCode", classCode);
        }

        //非必选条件（当班人员)不为空时queryType值为copy时复制查询,queryType值为personal个人查询
        String handlerCode = prpLJobManagerDto.getHandlerCode();
        if (StringUtils.isNotEmpty(handlerCode)) {
            if ("copy".equals(prpLJobManagerDto.getQueryType())) {
                dataSql.append(" and p.handlerCode=:handlerCode");
                timeSql.append(" and p.handlerCode=:handlerCode");
                condition.put("handleDept", handleDept);
                condition.put("month", oldMonth);
                condition.put("classCode", classCode);
                condition.put("handlerCode", handlerCode);
            }
            if ("personal".equals(prpLJobManagerDto.getQueryType())) {
                dataSql.append(" and p.handlerCode=:handlerCode");
                timeSql.append(" and p.handlerCode=:handlerCode");
                condition.put("handleDept", handleDept);
                condition.put("month", month);
                condition.put("classCode", classCode);
                condition.put("handlerCode", handlerCode);
            }
        }

        timeSql.append(")");
        //创建查询对象
        Query dataQuery = entityManager.createQuery(dataSql.toString());
        Query timeQuery = entityManager.createQuery(timeSql.toString());
        Query linkQuery = entityManager.createQuery(linkSql.toString());

        //必选条件参数赋值，三种查询方式都有
        if ("copy".equals(prpLJobManagerDto.getQueryType()) || "personal".equals(prpLJobManagerDto.getQueryType())
                || "institution".equals(prpLJobManagerDto.getQueryType())) {
            for (Map.Entry<String, String> entry : conditions.entrySet()) {
                dataQuery.setParameter(entry.getKey(), entry.getValue());
                timeQuery.setParameter(entry.getKey(), entry.getValue());
                linkQuery.setParameter(entry.getKey(), entry.getValue());
            }
        }
        //handlerCode有值时参数赋值queryType类型为copy和personal方式
        if (StringUtils.isNotEmpty(handlerCode)) {
            if ("copy".equals(prpLJobManagerDto.getQueryType()) || "personal".equals(prpLJobManagerDto.getQueryType())) {
                for (Map.Entry<String, String> entry : condition.entrySet()) {
                    dataQuery.setParameter(entry.getKey(), entry.getValue());
                    timeQuery.setParameter(entry.getKey(), entry.getValue());
                }
            }
        }

        //查询结果集
        List<PrpLJobManager> dataQueryList = dataQuery.getResultList();
        List<PrpLJobManagerTime> timeQueryList = timeQuery.getResultList();
        List<PrpLJobLinker> linkQueryList = linkQuery.getResultList();

        List<PrpLJobManagerDto> prpLJobManagerDtoList = new ArrayList<>();
        List<PrpLJobManagerTimeDto> prpLJobManagerTimeDtoList = new ArrayList<>();
        List<PrpLJobLinkerDto> prpLJobLinkerDtoList = new ArrayList<>();
        //数据对象集合转dto对象集合
        convertCollection(dataQueryList, prpLJobManagerDtoList, PrpLJobManagerDto.class);
        convertCollection(timeQueryList, prpLJobManagerTimeDtoList, PrpLJobManagerTimeDto.class);
        convertCollection(linkQueryList, prpLJobLinkerDtoList, PrpLJobLinkerDto.class);
        //给班表主表dto对象prpLJobManagerTimeDtoList 里头放对应时间表信息。
                   List<PrpLJobManagerTimeDto> prpLJobManagerTimeDtoList1;
                    List<PrpLJobManagerTimeDto> amList1;
                    List<PrpLJobManagerTimeDto> pmList1;
             for (PrpLJobManagerDto lprpLJobManagerDto : prpLJobManagerDtoList) {
                   prpLJobManagerTimeDtoList1=new ArrayList<>();
                                      amList1=new ArrayList<>();
                                      pmList1=new ArrayList<>();
                          String id = lprpLJobManagerDto.getId();
                     for (PrpLJobManagerTimeDto lprpLJobManagerTimeDto : prpLJobManagerTimeDtoList) {
                              String fid = lprpLJobManagerTimeDto.getFid();
                        if (lprpLJobManagerTimeDto.getFid().equals( lprpLJobManagerDto.getId())) {
                            prpLJobManagerTimeDtoList1.add(lprpLJobManagerTimeDto);
                             lprpLJobManagerDto.setPrpLJobManagerTimeDtoList(prpLJobManagerTimeDtoList1);

                        if ("AM".equals(lprpLJobManagerTimeDto.getDateType())){
                              amList1.add(lprpLJobManagerTimeDto);
                              lprpLJobManagerDto.setAmList(amList1);
                        }
                         if ("PM".equals(lprpLJobManagerTimeDto.getDateType())){
                              pmList1.add(lprpLJobManagerTimeDto);
                              lprpLJobManagerDto.setPmList(pmList1);
                         }
                        }
            }

        }

        PrpLJobManagerSaveDto prpLJobManagerSaveDto = new PrpLJobManagerSaveDto();
        prpLJobManagerSaveDto.setPrpLJobManagerDtoList(prpLJobManagerDtoList);
        prpLJobManagerSaveDto.setPrpLJobLinkerDtoList(prpLJobLinkerDtoList);
        return prpLJobManagerSaveDto;
    }



    /**
     * @Description: 新增和修改班表主表信息
     * @Author:李文刚
     * @Date：2017/11/2 20:13
     * @Param PrpLJobManagerSaveDto 新增和修改班表信息的对象
     * @Return boolean  保存成功与否
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public  boolean savePrpLJobManager(PrpLJobManagerSaveDto prpLJobManagerSaveDto) throws Exception {
        //从大Dto得到两个Dto的List对象
        List<PrpLJobManagerDto> prpLJobManagerDtoList = prpLJobManagerSaveDto.getPrpLJobManagerDtoList();
        List<PrpLJobLinkerDto> prpLJobLinkerDtoList = prpLJobManagerSaveDto.getPrpLJobLinkerDtoList();

        //校验dto有数值
        if(("null").equals(prpLJobManagerDtoList)||prpLJobManagerDtoList.size()<1||prpLJobManagerDtoList==null){
            throw new DataVerifyException("主表保存信息不能为空");
        }
        if (("null").equals(prpLJobLinkerDtoList)||prpLJobLinkerDtoList.size()<1||prpLJobLinkerDtoList==null){
            throw new DataVerifyException("联系人表保存信息不能为空");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String inTime = sdf.format(new Date());
        //对prpLJobManagerDtoList数据以及PrpLJobManagerDto中的prpLJobManagerTimeDtoList数据处理。
        for (PrpLJobManagerDto lPrpLJobManagerDto : prpLJobManagerDtoList) {
            String handleDept = lPrpLJobManagerDto.getHandleDept();
            String classCode = lPrpLJobManagerDto.getClassCode();
            String month = lPrpLJobManagerDto.getMonth();
            String handlerCode = lPrpLJobManagerDto.getHandlerCode();
            String jobRole = lPrpLJobManagerDto.getJobRole();
            String systemCode = AgriClaimConstant.AGRI_CLAIM_SYSTEMCODE;
            String operator = SinoRequestContext.getCurrentContext().getUser().getUserName();
            String operatorId = SinoRequestContext.getCurrentContext().getUser().getUserCode();

            //id生成规则
            String id = month.replaceAll("-", "").toString() + handleDept + classCode + handlerCode + jobRole.replaceAll(";", "");

            List<PrpLJobManagerTimeDto> prpLJobManagerTimeDtoList = lPrpLJobManagerDto.getPrpLJobManagerTimeDtoList();
            lPrpLJobManagerDto.setSystemCode(systemCode);
            lPrpLJobManagerDto.setJobRole("3");//工作角色，1-车物查勘，2-人伤查勘,3-非车查勘
            lPrpLJobManagerDto.setOperator(operator);
            lPrpLJobManagerDto.setOperatorId(operatorId);
            List<PrpLJobManagerTimeDto> amList = lPrpLJobManagerDto.getAmList();
            List<PrpLJobManagerTimeDto> pmList = lPrpLJobManagerDto.getPmList();
            //对时间表信息校验：
             //if(("null").equals(prpLJobManagerTimeDtoList)||prpLJobManagerTimeDtoList.size()<1||prpLJobManagerTimeDtoList==null){
             //throw new DataVerifyException("时间表保存信息不能为空");
             //}
             //根据id判断是否修改班表主表信息，如果id有值则是修改班表信息
            if (StringUtils.isNotEmpty(lPrpLJobManagerDto.getId())) {
                //生成modifyTime
                lPrpLJobManagerDto.setModifyTime(inTime);
                String id1 = lPrpLJobManagerDto.getId();
                //根据id删除已有时间表数据
                prpLJobManagerTimeDao.deleteTimeCondition(lPrpLJobManagerDto.getId());
                //删除已有主表数据
                prpLJobManagerDao.deleteManagerCondition(handleDept, classCode, month);
                for (PrpLJobManagerTimeDto lprpLJobManagerTimeDto : prpLJobManagerTimeDtoList) {
                    if (lprpLJobManagerTimeDto.getCheckFlag()) {
                      if(StringUtils.isEmpty(lprpLJobManagerTimeDto.getFid())) {
                          lprpLJobManagerTimeDto.setFid(id);
                          //将Dto对象集转为数据库对象集并保存班表时间表信息
                          PrpLJobManagerTime prpLJobManagerTime = convert(lprpLJobManagerTimeDto, PrpLJobManagerTime.class);
                          prpLJobManagerTimeDao.save(prpLJobManagerTime);
                      }else {
                          //将Dto对象集转为数据库对象集并保存班表时间表信息
                          PrpLJobManagerTime prpLJobManagerTime = convert(lprpLJobManagerTimeDto, PrpLJobManagerTime.class);
                          prpLJobManagerTimeDao.save(prpLJobManagerTime);
                      }
                    }
                }

                for (PrpLJobManagerTimeDto aprpLJobManagerTimeDto : amList) {
                    if (aprpLJobManagerTimeDto.getCheckFlag()) {
                        if (StringUtils.isEmpty(aprpLJobManagerTimeDto.getFid())) {
                            aprpLJobManagerTimeDto.setFid(id);
                            PrpLJobManagerTime prpLJobManagerTime = convert(aprpLJobManagerTimeDto, PrpLJobManagerTime.class);
                            prpLJobManagerTimeDao.save(prpLJobManagerTime);
                        } else {
                            //将Dto对象集转为数据库对象集并保存班表时间表信息
                            PrpLJobManagerTime prpLJobManagerTime = convert(aprpLJobManagerTimeDto, PrpLJobManagerTime.class);
                            prpLJobManagerTimeDao.save(prpLJobManagerTime);
                        }
                    }
                }

                for (PrpLJobManagerTimeDto pprpLJobManagerTimeDto : pmList) {
                    if (pprpLJobManagerTimeDto.getCheckFlag()) {
                        if(StringUtils.isEmpty(pprpLJobManagerTimeDto.getFid())){
                            pprpLJobManagerTimeDto.setFid(id);
                            PrpLJobManagerTime prpLJobManagerTime = convert(pprpLJobManagerTimeDto, PrpLJobManagerTime.class);
                            prpLJobManagerTimeDao.save(prpLJobManagerTime);

                        }else {
                            //将Dto对象集转为数据库对象集并保存班表时间表信息
                            PrpLJobManagerTime prpLJobManagerTime = convert(pprpLJobManagerTimeDto, PrpLJobManagerTime.class);
                            prpLJobManagerTimeDao.save(prpLJobManagerTime);
                        }
                    }
                }

            } else {
                //生成id，flowInTime,
                lPrpLJobManagerDto.setId(id);
                lPrpLJobManagerDto.setflowInTime(inTime);
                for (PrpLJobManagerTimeDto lprpLJobManagerTimeDto : prpLJobManagerTimeDtoList) {
                    //生成fid
                    lprpLJobManagerTimeDto.setFid(id);
                    if (lprpLJobManagerTimeDto.getCheckFlag()) {
                        //将Dto对象集转为数据库对象集并保存班表时间表信息
                        PrpLJobManagerTime prpLJobManagerTime = convert(lprpLJobManagerTimeDto, PrpLJobManagerTime.class);
                        prpLJobManagerTimeDao.save(prpLJobManagerTime);
                    }
                }

                    for (PrpLJobManagerTimeDto aprpLJobManagerTimeDto : amList) {
                        //生成fid
                        aprpLJobManagerTimeDto.setFid(id);
                        if (aprpLJobManagerTimeDto.getCheckFlag()) {
                            //将Dto对象集转为数据库对象集并保存班表时间表信息
                            PrpLJobManagerTime prpLJobManagerTime = convert(aprpLJobManagerTimeDto, PrpLJobManagerTime.class);
                            prpLJobManagerTimeDao.save(prpLJobManagerTime);
                        }
                    }

                    for (PrpLJobManagerTimeDto pprpLJobManagerTimeDto : pmList) {
                        //生成fid
                        pprpLJobManagerTimeDto.setFid(id);
                        if (pprpLJobManagerTimeDto.getCheckFlag()) {
                            //将Dto对象集转为数据库对象集并保存班表时间表信息
                            PrpLJobManagerTime prpLJobManagerTime = convert(pprpLJobManagerTimeDto, PrpLJobManagerTime.class);
                            prpLJobManagerTimeDao.save(prpLJobManagerTime);
                        }
                    }


            }
        }
        //对联系人表数据prpLJobLinkerDtoList处理。
        for (PrpLJobLinkerDto lprpLJobLinkerDto : prpLJobLinkerDtoList) {
            String month = lprpLJobLinkerDto.getMonth();
            String handleDept= lprpLJobLinkerDto.getHandleDept();
            String classCode = lprpLJobLinkerDto.getClassCode();
            String staffUserCode = lprpLJobLinkerDto.getStaffUserCode();
            String staffPosition = lprpLJobLinkerDto.getStaffPosition();

            //staffId不为空则是修改，创建修改时间modifyTime
            if (StringUtils.isNotEmpty(lprpLJobLinkerDto.getStaffId())) {
                lprpLJobLinkerDto.setModifyTime(inTime);
                prpLJobLinkerDao.deleteLinkerCondition(handleDept,classCode,month);
            }
            //否则staffId为空为新增,创建staffId，flowInTime
            else {
                String staffId = month.replaceAll("-", "").toString() + handleDept + classCode + staffUserCode + staffPosition;
                lprpLJobLinkerDto.setStaffId(staffId);
                lprpLJobLinkerDto.setFlowInTime(inTime);
            }
        }
        //将Dto对象集转为数据库对象集并保存班表主表信息
        List<PrpLJobManager> prpLJobManagerList = new ArrayList<PrpLJobManager>();
        convertCollection(prpLJobManagerDtoList, prpLJobManagerList, PrpLJobManager.class);
         prpLJobManagerDao.save(prpLJobManagerList);
       //将Dto对象集转为数据库对象集并保存班表联系人表信息
        List<PrpLJobLinker> prpLJobLinkerList = new ArrayList<PrpLJobLinker>();
        convertCollection(prpLJobLinkerDtoList, prpLJobLinkerList, PrpLJobLinker.class);
        prpLJobLinkerDao.save(prpLJobLinkerList);
        //保存结果判断
        return true;
            }

    /**
     * @Description: 分页查询班表主表信息
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/11/13 17:02
     * @Param queryPrpLJobManagerDto  month  handleDept  classCode  handlerCode  封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */
    public PageInfo<PrpLJobManagerDto> queryPrpLJobManagerByCondition(QueryPrpLJobManagerDto queryPrpLJobManagerDto) throws Exception {

        if (queryPrpLJobManagerDto.getPageSize() == 0) {
            queryPrpLJobManagerDto.setPageSize(20);
        }
        if (queryPrpLJobManagerDto.getPageNo() < 1) {
            throw new DataVerifyException("查询页码不能小于1！");
        }
        if (queryPrpLJobManagerDto.getPageSize() < 1) {
            throw new DataVerifyException("查询每页数量不能小于1！");
        }
        StringBuilder count = new StringBuilder(200);
        StringBuilder sql = new StringBuilder(200);

        count.append("SELECT  COUNT(1) FROM PrpLJobManager p ");
        sql.append("SELECT p FROM PrpLJobManager p ");

        String dateCondition;
        //定义查询条件语句
        List<String> conditionList = new ArrayList<String>();
        //定义条件参数集合
        Map<String, String> paraMap = new HashMap<String, String>();

        if (StringUtils.isNotEmpty(queryPrpLJobManagerDto.getMonth())) {
            conditionList.add("and p.month=:month");
            paraMap.put("month", queryPrpLJobManagerDto.getMonth());
        }

        if (StringUtils.isNotEmpty(queryPrpLJobManagerDto.getHandleDept())) {

            conditionList.add("and p.handleDept=:handleDept");
            paraMap.put("handleDept", queryPrpLJobManagerDto.getHandleDept());
        }

        if (StringUtils.isNotEmpty(queryPrpLJobManagerDto.getClassCode())) {

            conditionList.add("and p.classCode=:classCode");
            paraMap.put("classCode", queryPrpLJobManagerDto.getClassCode());
        }

        if (StringUtils.isNotEmpty(queryPrpLJobManagerDto.getHandlerCode())) {
            conditionList.add("and p.handlerCode =:handlerCode");
            paraMap.put("handlerCode", queryPrpLJobManagerDto.getHandlerCode());
        }

        //如果有拼接条件
        if (conditionList.size() > 0) {
            //去掉第一个"and"字符串
            dateCondition = this.joinCondition(conditionList);
            sql.append(" where ");
            sql.append(dateCondition);
            count.append(" where");
            count.append(dateCondition);
        }

        sql.append("order by to_date(p.flowInTime ,'yyyy-MM-dd hh24:mi:ss') desc");

        Query dataQuery = entityManager.createQuery(sql.toString());
        Query countQuery = entityManager.createQuery(count.toString());
        for (Map.Entry<String, String> entry : paraMap.entrySet()) {
            dataQuery.setParameter(entry.getKey(), entry.getValue());
            countQuery.setParameter(entry.getKey(), entry.getValue());
        }
        //当前页第一条数据在总数据中位置
        dataQuery.setFirstResult((queryPrpLJobManagerDto.getPageNo() - 1) * queryPrpLJobManagerDto.getPageSize());
        dataQuery.setMaxResults(queryPrpLJobManagerDto.getPageSize());

        long countNum = (long) countQuery.getSingleResult();

        List<PrpLJobManager> resultList = dataQuery.getResultList();
        List<PrpLJobManagerDto> prpLJobManagerDtoList = new ArrayList<>();


        convertCollection(resultList, prpLJobManagerDtoList, PrpLJobManagerDto.class);
        //统一封装分页响应dto
        PageInfo<PrpLJobManagerDto> pageInfo = new PageInfo<PrpLJobManagerDto>();
        pageInfo.setContent(prpLJobManagerDtoList);// 数据存放dto集合
        pageInfo.setPages(queryPrpLJobManagerDto.getPageNo());// 当前页数
        pageInfo.setTotalCount(countNum);// 总记录数
        return pageInfo;
         }


    /**
     * @Description: 调度环节需要的班表查询按钮信息查询
     * @throws Exception
     * @Author: 李文刚
     * @date: 2017/12/14 16:26
     * @Param queryPrpLJobManagerDto   handleDept  classCode  time1  time2 封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */

    public PageInfo<PrpManagerDto> queryDispatcherPrpLJobManagerByCondition(QueryPrpLJobManagerDto queryPrpLJobManagerDto) throws Exception {

        if (queryPrpLJobManagerDto.getPageSize() == 0) {
            queryPrpLJobManagerDto.setPageSize(20);
        }

        if (queryPrpLJobManagerDto.getPageNo() < 1) {
            throw new DataVerifyException("查询页码不能小于1！");
        }
        if (queryPrpLJobManagerDto.getPageSize() < 1) {
            throw new DataVerifyException("查询每页数量不能小于1！");

        }
        StringBuilder count = new StringBuilder(200);
        StringBuilder sql = new StringBuilder(200);
        //原生sql
        count.append("select count(1) from PrpLJobManagerTime t1 left join PrpLJobManager t2 on t1.fid = t2.id left join PrplAreaSetting t3 on t2.handlerName = t3.handlerName and t2.handledept=t3.handledept");
        sql.append("select  rownum n , t1.time, t1.dateType, t2.handlerName,t3.tel, t2.jobRole  from PrpLJobManagerTime t1 left join  PrpLJobManager t2 on t1.fid = t2.id  left join PrplAreaSetting t3  on t2.handlerName = t3.handlerName and t2.handledept=t3.handledept");

        String dateCondition;
        //定义查询条件语句
        List<String> conditionList = new ArrayList<String>();
        //定义条件参数集合
        Map<String, String> paraMap = new HashMap<String, String>();

        if (StringUtils.isNotEmpty(queryPrpLJobManagerDto.getHandleDept())) {

            conditionList.add("and t2.handleDept=:handleDept");
            paraMap.put("handleDept", queryPrpLJobManagerDto.getHandleDept());
        }

        if (StringUtils.isNotEmpty(queryPrpLJobManagerDto.getClassCode())) {

            conditionList.add("and t2.classCode=:classCode");
            paraMap.put("classCode", queryPrpLJobManagerDto.getClassCode());
        }
        if (StringUtils.isNotEmpty(queryPrpLJobManagerDto.getTime1())) {

            conditionList.add("and to_date(t1.time, 'YYYY-MM-DD') >= to_date(:time1, 'YYYY-MM-DD') ");
            paraMap.put("time1", queryPrpLJobManagerDto.getTime1());
        }
        if (StringUtils.isNotEmpty(queryPrpLJobManagerDto.getTime2())  ) {
            conditionList.add("and to_date(t1.time, 'YYYY-MM-DD') <= to_date(:time2, 'YYYY-MM-DD')");
            paraMap.put("time2", queryPrpLJobManagerDto.getTime2());
        }

        //如果有拼接条件
        if (conditionList.size() > 0) {
            //去掉第一个"and"字符串
            dateCondition = this.joinCondition(conditionList);
            sql.append(" where ");
            sql.append(dateCondition);
            count.append(" where");
            count.append(dateCondition);
        }

        sql.append(" order by to_date(t1.time, 'YYYY-MM-DD')");
        Query dataQuery = entityManager.createNativeQuery(sql.toString(),PrpManagerInfo.class);
        Query countQuery = entityManager.createNativeQuery(count.toString())  ;
        for (Map.Entry<String, String> entry : paraMap.entrySet()) {
            dataQuery.setParameter(entry.getKey(), entry.getValue());
            countQuery.setParameter(entry.getKey(), entry.getValue());
        }

        dataQuery.setFirstResult((queryPrpLJobManagerDto.getPageNo() - 1) * queryPrpLJobManagerDto.getPageSize());
        dataQuery.setMaxResults(queryPrpLJobManagerDto.getPageSize());

        long countNum = Long.valueOf( String.valueOf (countQuery.getSingleResult()));

        List<PrpManagerInfo> prpManagerInfoList =  dataQuery.getResultList();
        List<PrpManagerDto> prpManagerDtoList=new ArrayList<>();
        convertCollection(prpManagerInfoList,prpManagerDtoList,PrpManagerDto.class);

        //统一封装分页响应dto
        PageInfo<PrpManagerDto> pageInfo = new PageInfo<>();
        pageInfo.setContent(prpManagerDtoList);// 数据存放dto集合
        pageInfo.setPages(queryPrpLJobManagerDto.getPageNo());// 当前页数
        pageInfo.setTotalCount(countNum);// 总记录数
        return pageInfo;
    }
    /**
     *（查询当天班表信息）
     * @author: 孙朋飞
     * @date: 2017/12/13 17:26
     * @param requestDto （policyNo保单号（必传），handleDept班表机构（必传））
     * @return 班表信息列表集合
     * @throws Exception
     */
    public List<ResponsePrpLJobManagerDto> queryPrpLJobManagerByPolicyNoAndHandleDept(RequestPrpLJobManagerDto requestDto) throws Exception {
        //参数校验
         if(StringUtils.isEmpty(requestDto.getHandleDept())){
            throw new DataVerifyException("班表机构不能为空!");
        }
        if(StringUtils.isEmpty(requestDto.getPolicyNo())){
            throw new DataVerifyException("保单号不能为空!");
        }
        //保单号截取险种大类
        String classCode=requestDto.getPolicyNo().substring(1,3);
        Calendar ca = Calendar.getInstance();
        int hours = ca.get(Calendar.HOUR_OF_DAY);//当前小时
        String dateType = "";//上午，下午
        //得到当前time当前日期
        DateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String time =sd.format(new Date());
        //得到dateType  AM/PM
        if(hours >= AgriClaimConstant.AGRI_CLAIM_FOREHOUR && hours < AgriClaimConstant.AGRI_CLAIM_AFTERHOUR){
            dateType = "AM";
        }else{
            dateType = "PM";
        }
        //由条件得到classCode
        if("31,32".indexOf(classCode)<0){
            classCode = AgriClaimConstant.AGRI_CLAIM_CLASSCODE;
        }
        StringBuilder condition=new StringBuilder();
        List<String> list= prpLJobManagerTimeDao.findPrpLJobManagerTimeByTime(time,dateType);
        if(list!=null&&list.size()>0){
            //条件
            condition.append(" p.systemCode=:systemCode and p.classCode=:classCode and p.handleDept=:handleDept  and p.id in (:list) ");
        }else{
            return null;
        }
        StringBuilder dataSql=new StringBuilder("select p from PrpLJobManager p where ");
        dataSql.append(condition);
        Query dataQuery = entityManager.createQuery(dataSql.toString());
        //赋值
        dataQuery.setParameter("systemCode", AgriClaimConstant.AGRI_CLAIM_SYSTEMCODE);
        dataQuery.setParameter("classCode",classCode);
        dataQuery.setParameter("handleDept",requestDto.getHandleDept());
        dataQuery.setParameter("list",list);
        List<PrpLJobManager> resultList = dataQuery.getResultList();
        List<ResponsePrpLJobManagerDto> responseDtoList=new ArrayList<>();
        ResponsePrpLJobManagerDto respPrpLJobManagerDto;
        if(resultList!=null){
            for (PrpLJobManager prpLJobManager : resultList) {
                //日期
                respPrpLJobManagerDto= new ResponsePrpLJobManagerDto();
                respPrpLJobManagerDto.setTime(time);
                respPrpLJobManagerDto.setHandlerCode(prpLJobManager.getHandlerCode());
                //班次名称，白班or夜班
                respPrpLJobManagerDto.setDateType(dateType);
                respPrpLJobManagerDto.setHandlerName(prpLJobManager.getHandlerName());
                //作业区域  根据险类和班表机构查询作业区域
                List<PrplAreaSetting> prplAreaSettingList = prplAreaSettingDao.findPrplAreaSettingByClassCodeAndHandlerCode(AgriClaimConstant.AGRI_CLAIM_CLASSCODE, prpLJobManager.getHandlerCode());
                if(prplAreaSettingList!=null && prplAreaSettingList.size()>0){
                    for (PrplAreaSetting prplAreaSetting : prplAreaSettingList) {
                        if(StringUtils.isNotEmpty(prplAreaSetting.getArea())){
                            String[] area = prplAreaSetting.getArea().split(";");
                            String areaName = "";
                            for(int i=0;i<area.length;i++){
                                PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(area[i]);
                                if(prpDcompanyDto!=null){
                                    if(i==0){
                                        areaName+= prpDcompanyDto.getComCName();
                                    }else{
                                        areaName+= ";"+prpDcompanyDto.getComCName();
                                    }
                                }
                            }
                            //作业区域中文
                            respPrpLJobManagerDto.setAreaName(areaName);
                            //联系电话
                            respPrpLJobManagerDto.setTel(prplAreaSetting.getTel());
                        }
                    }
                }
                //工作角色
                respPrpLJobManagerDto.setJobRole(prpLJobManager.getJobRole());
                //查勘次数
                Integer checkCount;
                String dateBegin;
                String dateEnd;
                if("AM".equals(dateType)){
                    dateBegin = time+AgriClaimConstant.AGRI_CLAIM_FORENOON;
                    dateEnd   = time+AgriClaimConstant.AGRI_CLAIM_AFTERNOON;
                }else{
                    Date timeBegin = sd.parse(time);
                    Date timeEnd   = sd.parse(time);
                    if(hours> AgriClaimConstant.AGRI_CLAIM_AFTERHOUR){
                        ca.setTime(timeEnd);
                        ca.set(ca.DAY_OF_YEAR, ca.get(ca.DAY_OF_YEAR)+1);
                        timeEnd=ca.getTime();
                    }else if(hours<=AgriClaimConstant.AGRI_CLAIM_FOREHOUR){
                        ca.setTime(timeBegin);
                        ca.set(ca.DAY_OF_YEAR, ca.get(ca.DAY_OF_YEAR)-1);
                        timeBegin=ca.getTime();
                    }
                    dateBegin = sd.format(timeBegin)+AgriClaimConstant.AGRI_CLAIM_AFTERNOON;
                    dateEnd   = sd.format(timeEnd)+AgriClaimConstant.AGRI_CLAIM_FORENOON;
                }
                checkCount= swfLogDao.findSwfLogByConditions(prpLJobManager.getHandlerCode(),dateBegin,dateEnd,AgriClaimConstant.AGRI_CLAIM_CHECK);
                respPrpLJobManagerDto.setCheckCount(String.valueOf(checkCount));
                responseDtoList.add(respPrpLJobManagerDto);
            }
        }
        //排过班的  都是查勘员 没必要进行下面的校验
        /*List<PrpDuserDto> prpDuserDtoList = prpDuserApi.queryPrpDuserByHandleDept(requestDto.getHandleDept(), "1");
        List<ResponsePrpLJobManagerDto> joblist =new ArrayList<>();
        if(prpDuserDtoList!=null&&prpDuserDtoList.size()>0 ){
            for (PrpDuserDto prpDuserDto : prpDuserDtoList) {
                for (ResponsePrpLJobManagerDto responsePrpLJobManagerDto : responseDtoList) {
                    if(prpDuserDto.getUserCode().equals(responsePrpLJobManagerDto.getHandlerCode())&& "3".equals(responsePrpLJobManagerDto.getJobRole())){
                        joblist.add(responsePrpLJobManagerDto);
                    }
                }
            }
        }*/
        return responseDtoList;
    }
}

































































































