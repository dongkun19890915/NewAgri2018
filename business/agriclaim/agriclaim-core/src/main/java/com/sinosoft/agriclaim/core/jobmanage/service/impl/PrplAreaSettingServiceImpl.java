package com.sinosoft.agriclaim.core.jobmanage.service.impl;

import com.sinosoft.agriclaim.api.jobmanage.dto.PrplAreaSettingDto;
import com.sinosoft.agriclaim.api.jobmanage.dto.RequestPrplAreaSettingQueryDto;
import com.sinosoft.agriclaim.api.jobmanage.dto.RequestSavePrplAreaSettingDto;
import com.sinosoft.agriclaim.core.jobmanage.dao.PrplAreaSettingDao;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrplAreaSetting;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrplAreaSettingKey;
import com.sinosoft.agriclaim.core.jobmanage.service.PrplAreaSettingService;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
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
 * @time  2017-11-08 05:42:38.981
 * @description 区域设置表Core接口实现
 */
@Service
@Transactional
public class PrplAreaSettingServiceImpl extends BaseCustomServiceImpl implements PrplAreaSettingService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrplAreaSettingServiceImpl.class);

    @Autowired
    private PrplAreaSettingDao prplAreaSettingDao;
    //数据库操作类
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    /**
     *@description 新增
     *@param
     */
    public void save(PrplAreaSettingDto prplAreaSettingDto) {
        PrplAreaSetting prplAreaSetting = this.convert(prplAreaSettingDto, PrplAreaSetting.class);
        prplAreaSettingDao.save(prplAreaSetting);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(Long id) {
        PrplAreaSettingKey prplAreaSettingKey = new PrplAreaSettingKey(id);
        prplAreaSettingDao.delete(prplAreaSettingKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrplAreaSettingDto prplAreaSettingDto) {
        PrplAreaSetting prplAreaSetting = this.convert(prplAreaSettingDto, PrplAreaSetting.class);
        prplAreaSettingDao.save(prplAreaSetting);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrplAreaSettingDto queryByPK(Long id) {
        PrplAreaSettingKey prplAreaSettingKey = new PrplAreaSettingKey(id);
        PrplAreaSetting prplAreaSetting = prplAreaSettingDao.findOne(prplAreaSettingKey);
        return this.convert(prplAreaSetting,PrplAreaSettingDto.class);
    }
    /**
     * （区域设置按班表机构或被维护人查询-分页查询）
     * @author: 孙朋飞
     * @date: 2017/10/26 15:31
     * @param queryDto （班表机构handleDept（必传），被维护人工号handlerCode（非必传），险种classCode）
     * @return 区域设置表的分页集合
     * @throws Exception
     */
    public PageInfo<PrplAreaSettingDto> queryPrplAreaSettingByCondition(RequestPrplAreaSettingQueryDto queryDto) throws Exception {
        //校验参数
        if(queryDto==null){
            throw new DataVerifyException("请求参数不能为空！");
        }
        if(StringUtils.isEmpty(queryDto.getHandleDept())){
            throw new DataVerifyException("班表机构不能为空！");
        }
        if(StringUtils.isEmpty(queryDto.getClassCode())){
            throw new DataVerifyException("险种不能为空！");
        }
        if(queryDto.getPageNo()==0 ){
            queryDto.setPageNo(1);
        }
        if(queryDto.getPageSize()==0){
            queryDto.setPageSize(20);
        }
        StringBuilder dataSql=new StringBuilder("select p from PrplAreaSetting p where ");
        //查询总数
        StringBuilder countSql=new StringBuilder("select count(1) from PrplAreaSetting p where ");
        //查询条件
        StringBuilder conditions = new StringBuilder();
        Map<String,String> condition= new HashMap<>();
        List<String> list = prpDcompanyApi.queryPrpDcompanyByComCode(queryDto.getHandleDept());
        if(list==null|| !(list.size()>0)){
            return null;
        }
        conditions.append(" p.handleDept in (:list)");
        conditions.append(" and p.classCode =:classCode ");
        if(StringUtils.isNotEmpty(queryDto.getHandlerCode())){
            conditions.append(" and p.handlerCode=:handlerCode");
            condition.put("handlerCode",queryDto.getHandlerCode());
        }
        dataSql.append(conditions).append(" order by p.flowinTime");
        countSql.append(conditions);
        //执行
        Query query = entityManager.createQuery(dataSql.toString());
        Query countQuery = entityManager.createQuery(countSql.toString());
        if(StringUtils.isNotEmpty(queryDto.getHandlerCode())){
            for (Map.Entry<String, String> entry : condition.entrySet()) {
                query.setParameter(entry.getKey(),entry.getValue());
                countQuery.setParameter(entry.getKey(),entry.getValue());
            }
        }
        query.setParameter("list",list);
        query.setParameter("classCode",queryDto.getClassCode());
        countQuery.setParameter("list",list);
        countQuery.setParameter("classCode",queryDto.getClassCode());
        query.setFirstResult((queryDto.getPageNo()-1)*queryDto.getPageSize());
        query.setMaxResults(queryDto.getPageSize());
        List<PrplAreaSetting> resultList = query.getResultList();
        List<PrplAreaSettingDto> prplAreaSettingDtoList=new ArrayList<>();
        convertCollection(resultList,prplAreaSettingDtoList,PrplAreaSettingDto.class);
        for (PrplAreaSettingDto prplAreaSettingDto : prplAreaSettingDtoList) {
            //班表中文名
            PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(prplAreaSettingDto.getHandleDept());
            prplAreaSettingDto.setComCName(prpDcompanyDto.getComCName());
        }
        long countNum=Long.valueOf(String.valueOf(countQuery.getSingleResult()));
        //封装页面参数
        PageInfo<PrplAreaSettingDto> pageInfo=new PageInfo<>();
        pageInfo.setContent(prplAreaSettingDtoList);
        pageInfo.setPages(queryDto.getPageNo());//总页数
        pageInfo.setTotalCount(countNum);//总数量
        return pageInfo;
    }

    /**
     * 区域设置保存（新增区域设置）
     * @Author：孙朋飞
     * @Date：16:50 2017/10/27
     * @param prplAreaSettingDtoList 区域设置集合
     * @return  成功返回 true
     * @throws Exception
     */
    public boolean batchSavePrplAreaSetting(List<PrplAreaSettingDto> prplAreaSettingDtoList) throws Exception {
        if(prplAreaSettingDtoList==null ||prplAreaSettingDtoList.size()==0){
            throw new DataVerifyException("请求数据不能为空!");
        }
        //修改时先删除在保存
        if(StringUtils.isNotEmpty(prplAreaSettingDtoList.get(0).getPrplAreaSettingDtoHandlercode())){
            //根据被维护人删除 对应的区域设置
            prplAreaSettingDao.deletePrplAreaSettingByHandlerCode(prplAreaSettingDtoList.get(0).getPrplAreaSettingDtoHandlercode(),prplAreaSettingDtoList.get(0).getPrplAreaSettingDtoHandleDept());
        }else if(StringUtils.isNotEmpty(prplAreaSettingDtoList.get(0).getPrplAreaSettingDtoHandleDept())){
            //根据机构删除 对应的区域设置
            prplAreaSettingDao.deletePrplAreaSettingByHandleDept(prplAreaSettingDtoList.get(0).getPrplAreaSettingDtoHandleDept());
        }
        //设置录入时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<PrplAreaSetting> prplAreaSettingList=new ArrayList<>();
        String userName = SinoRequestContext.getCurrentContext().getUser().getUserName();
        String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
        //不能使用封装方法convertCollection，否则影响下面的功能
        for (PrplAreaSettingDto prplAreaSettingDto : prplAreaSettingDtoList) {
            PrplAreaSetting prplAreaSetting = new PrplAreaSetting();
            prplAreaSetting.setId(prplAreaSettingDto.getId());
            prplAreaSetting.setHandlerCode(prplAreaSettingDto.getHandlerCode());
            prplAreaSetting.setHandleDept(prplAreaSettingDto.getHandleDept());
            prplAreaSetting.setHandlerName(prplAreaSettingDto.getHandlerName());
            prplAreaSetting.setArea(prplAreaSettingDto.getArea());
            prplAreaSetting.setTel(prplAreaSettingDto.getTel());
            prplAreaSetting.setOperator(prplAreaSettingDto.getOperator());
            prplAreaSetting.setOperatorId(prplAreaSettingDto.getOperatorId());
            prplAreaSetting.setFlowinTime(prplAreaSettingDto.getFlowinTime());
            prplAreaSetting.setModifyTime(prplAreaSettingDto.getModifyTime());
            prplAreaSetting.setClassCode(prplAreaSettingDto.getClassCode());
            prplAreaSetting.setRemark(prplAreaSettingDto.getRemark());
            prplAreaSettingList.add(prplAreaSetting);
        }
        if(prplAreaSettingList!=null &&prplAreaSettingList.size()>0){
            for (PrplAreaSetting prplAreaSetting : prplAreaSettingList) {
                if(prplAreaSetting.getId()==null ||prplAreaSetting.getId()==0 ){
                    prplAreaSetting.setClassCode("99");//非车险查勘区域险类都设置‘99’，车险查勘区域设置险类设置‘05’
                    //保存登录人
                    prplAreaSetting.setFlowinTime(sdf.format(new Date()));
                }else{
                    if(StringUtils.isEmpty(prplAreaSetting.getFlowinTime())){
                        prplAreaSetting.setFlowinTime(sdf.format(new Date()));
                    }else{
                        prplAreaSetting.setModifyTime(sdf.format(new Date()));
                    }
                }
                prplAreaSetting.setOperator(userName);
                prplAreaSetting.setOperatorId(userCode);
                prplAreaSettingDao.save(prplAreaSetting);
            }
        }
        return true;
    }
    /**
     * （校验查勘人）
     * 查询人员是否已存在当前选择区域
     * @author: 孙朋飞
     * @date: 2017/11/9 10:51
     * @param requestPrplAreaSettingQueryDto （班表机构handleDept，工号handlerCode，险种classCode）
     * @return 区域设置和作业区域的集合
     * @throws Exception
     */
    public String checkPrplAreaSettingByHandlerCode(RequestPrplAreaSettingQueryDto requestPrplAreaSettingQueryDto) throws Exception{
        if(StringUtils.isEmpty(requestPrplAreaSettingQueryDto.getHandleDept())){
            throw new DataVerifyException("班表机构不能为空!");
        }
        if(StringUtils.isEmpty(requestPrplAreaSettingQueryDto.getHandlerCode())){
            throw new DataVerifyException("工号不能为空!");
        }
        if(StringUtils.isEmpty(requestPrplAreaSettingQueryDto.getClassCode())){
            throw new DataVerifyException("险种不能为空!");
        }
        //根据险类和班表机构查询区域设置表
        return prplAreaSettingDao.findPrplAreaSettingByHandlerCodeAndHandleDept(requestPrplAreaSettingQueryDto.getHandlerCode(), requestPrplAreaSettingQueryDto.getHandleDept(),requestPrplAreaSettingQueryDto.getClassCode());
    }

    /**
     * （查询班表机构或者被维护人）
     * @author: 孙朋飞
     * @date: 2017/11/10 11:00
     * @param requestPrplAreaSettingQueryDto （班表机构handleDept，工号handlerCode，险种classCode）
     * @return 区域设置和作业区域
     * @throws Exception
     */
    public List<PrplAreaSettingDto> queryPrplAreaSettingByHandleDeptAndHandlerCode(RequestPrplAreaSettingQueryDto requestPrplAreaSettingQueryDto) throws Exception{
        //参数校验
        if(StringUtils.isEmpty(requestPrplAreaSettingQueryDto.getHandleDept())){
            throw new DataVerifyException("班表机构不能为空!");
        }
        StringBuilder dataSql=new StringBuilder("select p from PrplAreaSetting p where ");
        StringBuilder conditions=new StringBuilder();
        Map<String,String> condition= new HashMap<>();
        conditions.append("  p.handleDept=:handleDept");
        conditions.append(" and p.classCode =:classCode ");
        condition.put("classCode",requestPrplAreaSettingQueryDto.getClassCode());
        condition.put("handleDept",requestPrplAreaSettingQueryDto.getHandleDept());
        if(StringUtils.isNotEmpty(requestPrplAreaSettingQueryDto.getHandlerCode())){
            conditions.append(" And p.handlerCode=:handlerCode");
            condition.put("handlerCode",requestPrplAreaSettingQueryDto.getHandlerCode());
        }
        dataSql.append(conditions);
        Query query = entityManager.createQuery(dataSql.toString());
        for (Map.Entry<String, String> entry : condition.entrySet()) {
            query.setParameter(entry.getKey(),entry.getValue());
        }
        List<PrplAreaSetting> resultList = query.getResultList();
        List<PrplAreaSettingDto> prplAreaSettingDtoList=new ArrayList<PrplAreaSettingDto>();
        convertCollection(resultList,prplAreaSettingDtoList,PrplAreaSettingDto.class);
        //获取作业区域，区域设置表中一个班表机构可能对应多个区域，如（3405000000;3405210000），
        //要想在页面显示作业区域，则需要分别处理
        if(prplAreaSettingDtoList!=null && prplAreaSettingDtoList.size()>0){
            for (PrplAreaSettingDto prplAreaSettingDto : prplAreaSettingDtoList) {
                if(StringUtils.isNotEmpty(prplAreaSettingDto.getArea())){
                    String[] str = prplAreaSettingDto.getArea().split(";");
                    String areaName = "";
                    for(int i=0;i<str.length;i++){
                        PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(str[i]);
                        if(prpDcompanyDto!=null){
                            if(i==0){
                                areaName+= prpDcompanyDto.getComCName();
                            }else{
                                areaName+= ";"+prpDcompanyDto.getComCName();
                            }
                        }
                    }
                    prplAreaSettingDto.setAreaName(areaName);
                }
            }
        }
        return prplAreaSettingDtoList;
    }
    /**
     * 当前机构及其下属机构下区域设置
     * @author: 孙朋飞
     * @date: 2018/3/17 14:56
     * @param handleDept 班表机构
     * @return 区域设置人员
     * @throws Exception
     */
    @Override
    public List<PrplAreaSettingDto> queryPrplAreaSettingByhandleDept(String handleDept) throws Exception {
        //查询该机构及其下属机构
        if(StringUtils.isEmpty(handleDept)){
            throw new DataVerifyException("班表机构不能为空!");
        }
        List<String> list = prpDcompanyApi.queryPrpDcompanyByComCode(handleDept);
        //查询区域设置下面不为空的
        List<PrplAreaSetting> prplAreaSettingByhandleDept = prplAreaSettingDao.findPrplAreaSettingByhandleDept(list);
        List<PrplAreaSettingDto> prplAreaSettingDtoList=new ArrayList<>();
        convertCollection(prplAreaSettingByhandleDept,prplAreaSettingDtoList,PrplAreaSettingDto.class);
        return prplAreaSettingDtoList;
    }

}