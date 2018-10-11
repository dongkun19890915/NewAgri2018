package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.QueryComCodeInfoDto;
import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.*;
import com.sinosoft.pms.core.kernel.dao.*;
import com.sinosoft.pms.core.kernel.entity.*;
import com.sinosoft.pms.core.kernel.service.PrpDclauseCodeService;
import com.sinosoft.pms.core.kernel.service.PrpDclauseService;
import com.sinosoft.pms.core.kernel.service.PrpDitemAgriService;
import com.sinosoft.pms.core.kernel.service.PrpDkindAgriService;
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
 * @author 祝凯
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * @description 条款配置主表Core接口实现
 */
@Service
public class   PrpDclauseCodeServiceImpl extends BaseCustomServiceImpl implements   PrpDclauseCodeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(  PrpDclauseCodeServiceImpl.class);
    
    @Autowired
    private PrpDclauseCodeDao PrpDclauseCodeDao;

    @Autowired
    private PrpDcompanyApi prpDcompanyApi;

    @Autowired
    private   PrpDclauseCodeDao   prpDclauseCodeDao;

    @Autowired
    private PrpDclauseCodeComDao prpDclauseCodeComDao;

    @Autowired
    private PrpDclauseCodeKindDao prpDclauseCodeKindDao;

    @Autowired
    private PrpDkindAgriService prpDkindAgriService;

    @Autowired
    private PrpDclauseCodeHisDao prpDclauseCodeHisDao;

    @Autowired
    private PrpDclauseCodeComHisDao prpDclauseCodeComHisDao;

    @Autowired
    private PrpDclauseCodeKindHisDao prpDclauseCodeKindHisDao;
    @Autowired
    private UtiGroupApi utiGroupApi;
    @Autowired
    private BillNoApi billNoApi;

    @Autowired
    private PrpDriskDao prpDriskDao;

    @Autowired
    private PrpDclauseDao prpDclauseDao;
    @Autowired
    private PrpDclauseService prpDclauseService;

    @Autowired
    private PrpDrelationClauseCodeDao prpDrelationClauseCodeDao;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDitemAgriService prpDitemAgriService;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    public void save(  PrpDclauseCodeDto   PrpDclauseCodeDto) {
          PrpDclauseCode   PrpDclauseCode = this.convert(  PrpDclauseCodeDto,   PrpDclauseCode.class);
          PrpDclauseCodeDao.save(  PrpDclauseCode);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode) {
          PrpDclauseCodeKey   PrpDclauseCodeKey = new   PrpDclauseCodeKey(clauseCode);
          PrpDclauseCodeDao.delete(  PrpDclauseCodeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(  PrpDclauseCodeDto   PrpDclauseCodeDto) {
          PrpDclauseCode   PrpDclauseCode = this.convert(  PrpDclauseCodeDto,   PrpDclauseCode.class);
          PrpDclauseCodeDao.save(  PrpDclauseCode);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public   PrpDclauseCodeDto queryByPK(String clauseCode) {
          PrpDclauseCodeKey   PrpDclauseCodeKey = new   PrpDclauseCodeKey(clauseCode);
          PrpDclauseCode   PrpDclauseCode =   PrpDclauseCodeDao.findOne(  PrpDclauseCodeKey);
        return this.convert(  PrpDclauseCode,  PrpDclauseCodeDto.class);
    }

    /**
     *  （根据传入的险种和机构查询满足条件的所有条款信息集合）
     * @author: 祝凯
     * @date: 2017/11/15 10:33
     * @param riskCode 险种
     * @param comCode 机构
     * @return  条款信息实体类集合
     * @throws Exception
     */
    @Override
    public List<PrpDclauseCodeDto> queryByRiskCodeAndCom(String riskCode,String comCode) throws Exception{
        List<PrpDclauseCodeDto> prpDclauseCodeDtoList = new ArrayList<PrpDclauseCodeDto>();
        List<PrpDclauseCode> prpDclauseCodeList = new ArrayList<PrpDclauseCode>();
        List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<PrpDcompanyDto>();
        Map<String,Object> paraMap=new HashMap<String,Object>();

        //传入数据校验
        if(StringUtils.isEmpty(comCode)){
            throw new DataVerifyException("传入的机构不能为空!");
        }
        if(StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("传入的险种不能为空!");
        }

        //查询该机构下所有子级机构的信息集合
        List<String> conditionList = new ArrayList<String>();
        Map<String,String> map = new HashMap<>();
        map.put("comCode",comCode);
        prpDcompanyDtoList = prpDcompanyApi.queryDownCompany(map);
        String sql = " select distinct c.* from PrpDclauseCode c ,PrpDclauseCodeCom com where c.validStatus='1' and c.logicDelete='1' and TRUNC(startDate) <= TRUNC(sysdate) and TRUNC(endDate) >= TRUNC(sysdate) and c.flag='1' and c.clauseCode" +
                " = com.clauseCode ";
        StringBuilder strWhere = new StringBuilder();
        //拼接查询该机构下包含所有子机构下的 所有条款信息
        if (prpDcompanyDtoList.size() > 0) {
            strWhere.append(" AND com.comCode in (");
        }
        for (int i = 0; i < prpDcompanyDtoList.size(); i++) {
            PrpDcompanyDto prpDcompanyDto = prpDcompanyDtoList.get(i);
            //机构大于1000个 处理方式是 拼接 or comCode in ()
            if(i <1000){
                if (i == prpDcompanyDtoList.size()-1 || i==999) {
                    strWhere.append("'" + prpDcompanyDto.getComCode() + "'");
                } else {
                    strWhere.append("'"+prpDcompanyDto.getComCode() +"'"+ ",");
                }
            }else if(i==1000){
                if(i == prpDcompanyDtoList.size()-1){
                    strWhere.append(" ) OR comCode In ( '"+ prpDcompanyDto.getComCode()+"'");
                }else{
                    strWhere.append(" ) OR comCode In ( '"+ prpDcompanyDto.getComCode()+"',");
                }
            }else{
                if(i == prpDcompanyDtoList.size()-1){
                    strWhere.append(" '"+ prpDcompanyDto.getComCode()+"'");
                }else{
                    strWhere.append("'"+ prpDcompanyDto.getComCode()+"',");
                }
            }
        }
        if (prpDcompanyDtoList.size() > 0) {
            strWhere.append(" )");
        }
        strWhere.append(" and c.riskCode = :riskCode");
        paraMap.put("riskCode",riskCode);
        strWhere.append(" order by c.clauseCode");
        sql+=strWhere;
        javax.persistence.Query dataQuery= entityManager.createNativeQuery(sql,PrpDclauseCode.class);
        this.setQueryParam(dataQuery,paraMap);
        prpDclauseCodeList = dataQuery.getResultList();
        this.convertCollection(prpDclauseCodeList, prpDclauseCodeDtoList, PrpDclauseCodeDto.class);
        return prpDclauseCodeDtoList;
    }

    /**
     *  （根据传入的险种和机构查询满足条件的所有条款信息集合）
     * @author: 田慧
     * @date: 2018/3/2 9:50
     * @param riskCode 险种代码
     * @param comCodeList 适用机构集合
     * @return
     * @throws Exception
     */
    @Override
    public List<PrpDclauseCodeDto> queryItemByRiskCodeAndCom(String riskCode,List<String> comCodeList) throws Exception{
        List<PrpDclauseCodeDto> prpDclauseCodeDtoList = new ArrayList<PrpDclauseCodeDto>();
        List<PrpDclauseCode> prpDclauseCodeList = new ArrayList<PrpDclauseCode>();
        Map<String,Object> paraMap=new HashMap<String,Object>();

        //传入数据校验
        if(comCodeList.size()<=0){
            throw new DataVerifyException("传入的机构不能为空!");
        }
        if(StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("传入的险种不能为空!");
        }

        String sql="select distinct c.* from PrpDclauseCode c ,PrpDclauseCodeCom com where c.validStatus='1' and c.logicDelete='1' and TRUNC(startDate) <= TRUNC(sysdate) and TRUNC(endDate) >= TRUNC(sysdate) and c.flag='1' and c.clauseCode = com.clauseCode ";

        StringBuilder strWhere = new StringBuilder();
        //拼接查询该机构下包含所有子机构下的 所有条款信息
        if (comCodeList.size() > 0) {
            strWhere.append(" AND com.comCode in (");
        }
        for (int i = 0; i < comCodeList.size(); i++) {
            String comCode = comCodeList.get(i);
            //机构大于1000个 处理方式是 拼接 or comCode in ()
            if(i <1000){
                if (i == comCodeList.size()-1 || i==999) {
                    strWhere.append("'" + comCode + "'");
                } else {
                    strWhere.append("'"+comCode +"'"+ ",");
                }
            }else if(i==1000){
                if(i == comCodeList.size()-1){
                    strWhere.append(" ) OR comCode In ( '"+ comCode+"'");
                }else{
                    strWhere.append(" ) OR comCode In ( '"+ comCode+"',");
                }
            }else{
                if(i == comCodeList.size()-1){
                    strWhere.append(" '"+ comCode+"'");
                }else{
                    strWhere.append("'"+ comCode+"',");
                }
            }
        }
        if (comCodeList.size() > 0) {
            strWhere.append(" )");
        }
        strWhere.append(" and c.riskCode = :riskCode");
        paraMap.put("riskCode",riskCode);
        sql+=strWhere;
        javax.persistence.Query dataQuery= entityManager.createNativeQuery(sql,PrpDclauseCode.class);
        this.setQueryParam(dataQuery,paraMap);
        prpDclauseCodeList = dataQuery.getResultList();
        this.convertCollection(prpDclauseCodeList, prpDclauseCodeDtoList, PrpDclauseCodeDto.class);
        return prpDclauseCodeDtoList;

    }
    /**
     * 按条件查询条款列表信息
     * @Author: 刘曼曼
     * @date: 2017/11/7 10:35
     * @param clauseCodeQueryConditionDto 查询条款条件Dto
     * @return PageInfo<ResponsePrpDclauseCodeDto> 条款信息集合
     */
    public   PageInfo<ResponsePrpDclauseCodeDto> qureyClauseCodeCondition(ClauseCodeQueryConditionDto clauseCodeQueryConditionDto)throws Exception{
        //获取得到的参数
        int pageNo=clauseCodeQueryConditionDto.getPageNo();
        int pageSize=clauseCodeQueryConditionDto.getPageSize();
        if (clauseCodeQueryConditionDto.getPageNo() < 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        if (clauseCodeQueryConditionDto.getPageSize() < 1) {
            throw new DataVerifyException("每页数量不能小于1");
        }

        //获得操作人代码
        List<String> userCodes= new ArrayList<>();
        if(StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getOperatorName())) {
            userCodes = prpDuserApi.queryByUserName(clauseCodeQueryConditionDto.getOperatorName());
        }
        //获取标的代码
        List<String> itemCodes=new ArrayList<>();
        if(StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getItemName())){
            itemCodes=prpDitemAgriService.queryItemCode(clauseCodeQueryConditionDto.getItemName());
        }
        //获得险种代码
//        List<String> riskCodes=new ArrayList<>();
//        if(StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getRiskName())){
//            riskCodes=prpDriskDao.queryRiskName(clauseCodeQueryConditionDto.getRiskName());
//        }
        //获得适用机构代码--改成下拉框，这里不需要了
//        List<String> comCodes=new ArrayList<>();
//        if(StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getComName())){
//            Map<String,String> map=new HashMap();
//            map.put("comCName",clauseCodeQueryConditionDto.getComName());
//            List<PrpDcompanyDto> prpDcompanyDtoList=prpDcompanyApi.queryComCode(map);
//            for(PrpDcompanyDto prpDcompanyDto:prpDcompanyDtoList){
//                comCodes.add(prpDcompanyDto.getComCode());
//            }
//         }

        Map<String,Object> paraMap=new HashMap<String,Object>();
        //原生sql
        StringBuilder dataSql = new StringBuilder("SELECT distinct cc.* FROM PrpDclauseCode cc left join PrpDclauseCodeCom ss on cc.clauseCode=ss.clauseCode left join PrpDclauseCodeKind kk on cc.clauseCode=kk.clauseCode where cc.logicDelete='1' ");
        StringBuilder countSql=new StringBuilder("SELECT COUNT(1) FROM (SELECT distinct cc.* FROM PrpDclauseCode cc left join PrpDclauseCodeCom ss on cc.clauseCode=ss.clauseCode left join PrpDclauseCodeKind kk on cc.clauseCode=kk.clauseCode where cc.logicDelete='1' ");

        //判断参数是否为空，不为空则追加sql
        StringBuilder strWhere = new StringBuilder();
        //条款代码
        if (StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getClauseCode())) {
            strWhere.append(" AND cc.clauseCode like :clauseCode  ");
            paraMap.put("clauseCode","%"+clauseCodeQueryConditionDto.getClauseCode()+"%");
        }
        //获取权限查询条件
        AddCodePowerConditionDto addCodePowerConditionDto = new AddCodePowerConditionDto(clauseCodeQueryConditionDto.getUserCode(), clauseCodeQueryConditionDto.getLoginComCode(),
                clauseCodeQueryConditionDto.getLoginGradeCodes(), clauseCodeQueryConditionDto.getTableName(), "",
                "ComCode", "", "ss", false);
        String codePower = utiGroupApi.addCodePower(addCodePowerConditionDto);
        strWhere.append(codePower);
        //条款名称
        if (StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getClauseName())) {
            strWhere.append(" AND cc.clauseName=:clauseName ");
            paraMap.put("clauseName",clauseCodeQueryConditionDto.getClauseName());
        }
        //创建时间
        if (StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getCreateDateStart())&& StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getCreateDateEnd())) {
            strWhere.append(" AND TRUNC(cc.createDate) between to_date(:createDateStart,'yyyy-MM-dd') and to_date(:createDateEnd,'yyyy-MM-dd') ");
            paraMap.put("createDateStart",clauseCodeQueryConditionDto.getCreateDateStart());
            paraMap.put("createDateEnd",clauseCodeQueryConditionDto.getCreateDateEnd());
        }
        //机构代码
        if (StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getComCode())) {
            strWhere.append(" AND ss.comCode=:comCode ");
            paraMap.put("comCode",clauseCodeQueryConditionDto.getComCode());
        }
        //创建人
        if (StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getOperatorName())) {
           if(userCodes.size()>0){
               strWhere.append(" AND cc.operatorCode in(:operatorCodes) ");
               paraMap.put("operatorCodes",userCodes);
           }else{
               strWhere.append(" AND cc.operatorCode =:operatorCode ");
               paraMap.put("operatorCode","");
           }
        }
        //适用省份
        if (StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getProvence())) {
            strWhere.append(" AND　cc.provence=:provence ");
            paraMap.put("provence",clauseCodeQueryConditionDto.getProvence());
        }
        //险种代码
        if (StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getRiskCode())) {
            strWhere.append(" AND　cc.riskCode=:riskCode ");
            paraMap.put("riskCode",clauseCodeQueryConditionDto.getRiskCode());
        }
        //标的代码
        if (StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getItemName())) {
            if(itemCodes.size()>0) {
                strWhere.append(" AND　kk.itemCode in(:itemCodes) ");
                paraMap.put("itemCodes", itemCodes);
            }else {
                strWhere.append(" AND　kk.itemCode=:itemCode ");
                paraMap.put("itemCode","");
            }
        }
        //政策性标识
        if(StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getBusinessType())){
            strWhere.append(" AND　cc.businessType=:businessType ") ;
            paraMap.put("businessType",clauseCodeQueryConditionDto.getBusinessType());
        }
        //有效标准字段
        if (StringUtils.isNotEmpty(clauseCodeQueryConditionDto.getValidStatus())) {
            if("1".equals(clauseCodeQueryConditionDto.getValidStatus())){
                strWhere.append(" AND　cc.validStatus=:validStatus and TRUNC(startDate) <= TRUNC(sysdate) and TRUNC(endDate) >= TRUNC(sysdate) and cc.flag='1' ");
                paraMap.put("validStatus",clauseCodeQueryConditionDto.getValidStatus());
            }else if("0".equals(clauseCodeQueryConditionDto.getValidStatus())){
                strWhere.append(" AND　(cc.validStatus=:validStatus or TRUNC(startDate) > TRUNC(sysdate) or TRUNC(endDate) < TRUNC(sysdate) or cc.flag='0' ) ");
                paraMap.put("validStatus",clauseCodeQueryConditionDto.getValidStatus());
            }

        }
        strWhere.append("order by cc.createDate desc");

        //增加分页查询语句的查询条件
        dataSql.append(strWhere);
        //增加统计总页数据语句
        countSql.append(strWhere);
        countSql.append(")");

        //执行sql
        Query dataQuery= entityManager.createNativeQuery(dataSql.toString(),PrpDclauseCode.class);
        Query countQuery = entityManager.createNativeQuery(countSql.toString());
        this.setQueryParam(dataQuery,pageNo,pageSize,paraMap);
        this.setQueryParam(countQuery,paraMap);

        //查询总条数
        Long totalSize = Long.valueOf(countQuery.getSingleResult().toString());
        //查询结果
        List<PrpDclauseCode> dataList=dataQuery.getResultList();
        List<PrpDclauseCodeDto>  dataDtoList=new ArrayList<PrpDclauseCodeDto>();
        this.convertCollection(dataList,dataDtoList,PrpDclauseCodeDto.class);
        //封装结果
        List<ResponsePrpDclauseCodeDto> responsePrpDclauseCodeDtoList=new ArrayList<ResponsePrpDclauseCodeDto>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String today=sdf.format(new Date());
        Long currenDate=sdf.parse(today).getTime();
        for(PrpDclauseCodeDto prpDclauseCodeDto1:dataDtoList){
            ResponsePrpDclauseCodeDto responsePrpDclauseCodeDto=new ResponsePrpDclauseCodeDto();
            responsePrpDclauseCodeDto.setClauseCode(prpDclauseCodeDto1.getClauseCode());
            responsePrpDclauseCodeDto.setClauseName(prpDclauseCodeDto1.getClauseName());
            responsePrpDclauseCodeDto.setCreateDate(prpDclauseCodeDto1.getCreateDate());
            responsePrpDclauseCodeDto.setRemark(prpDclauseCodeDto1.getRemark());
            responsePrpDclauseCodeDto.setRiskCode(prpDclauseCodeDto1.getRiskCode());
            responsePrpDclauseCodeDto.setStartDate(prpDclauseCodeDto1.getStartDate());
            responsePrpDclauseCodeDto.setEndDate(prpDclauseCodeDto1.getEndDate());
            responsePrpDclauseCodeDto.setCreateYear(prpDclauseCodeDto1.getCreateYear());
            responsePrpDclauseCodeDto.setBusinessType(prpDclauseCodeDto1.getBusinessType());
            responsePrpDclauseCodeDto.setValidStatus(prpDclauseCodeDto1.getValidStatus());
            responsePrpDclauseCodeDto.setFlag(prpDclauseCodeDto1.getFlag());
            Map<String,String> map=new HashMap<>();
            String operatorName="";
            if(StringUtils.isNotEmpty(prpDclauseCodeDto1.getOperatorCode())) {
                map.put("userCode",prpDclauseCodeDto1.getOperatorCode());
                map.put("isChinese",LanguageFlagConstant.CHINESE);
                operatorName = prpDuserApi.translateCode(map);
            }
            responsePrpDclauseCodeDto.setOperatorName(operatorName);
            if("1".equals(prpDclauseCodeDto1.getFlag())){
                Long startDate=prpDclauseCodeDto1.getStartDate().getTime();
                Long endDate=prpDclauseCodeDto1.getEndDate().getTime();
                if("1".equals(prpDclauseCodeDto1.getValidStatus()) && startDate<=currenDate && endDate>=currenDate){
                    responsePrpDclauseCodeDto.setValidStatus1("1");
                }
            }else
               if("0".equals(prpDclauseCodeDto1.getFlag())){
                responsePrpDclauseCodeDto.setValidStatus1("0");
            }
            responsePrpDclauseCodeDto.setValidStatus(prpDclauseCodeDto1.getValidStatus());
            responsePrpDclauseCodeDtoList.add(responsePrpDclauseCodeDto);
        }

        //统一封装
        PageInfo<ResponsePrpDclauseCodeDto> pageInfo=this.setPageInfo(responsePrpDclauseCodeDtoList,pageNo,totalSize,ResponsePrpDclauseCodeDto.class);

        return pageInfo;
    }


    /**
     *  按条款代码查询PrpDclauseCode,PrpDclauseCodeCom,PrpDclauseCodeKind 的列表信息
     * @author: 刘曼曼
     * @date: 2017/11/7 19:32
     * @param clauseCode 条款代码
     * @return  ResponseClauseInfoDto 返回 PrpDclauseCodeDto,PrpDclauseCodeComDto,PrpDclauseCodeKindDto,PrpDrelationClauseCodeDto的集合
     */
    public ResponseClauseInfoDto queryClauseCodeByComByKind(String clauseCode, String userCode,String comCode  ) throws  Exception{
        if(StringUtils.isEmpty(clauseCode)){
            throw new DataVerifyException("条款代码不能为空");
        }
        if(StringUtils.isEmpty(userCode)){
            throw new DataVerifyException("用户代码不能为空");
        }
        if(StringUtils.isEmpty(comCode)){
            throw new DataVerifyException("机构代码不能为空");
        }

//        UserInfo userinfo = SinoRequestContext.getCurrentContext().getUser();
//        String userCode = userinfo.getUserCode();
//        String iComCode = userinfo.getLoginComCode();

        //根据条款代码查询条款配置主表信息
        PrpDclauseCode prpDclauseCode=prpDclauseCodeDao.findByClauseCode(clauseCode);
        ResponseClauseInfoDto responseClauseInfoDto = new ResponseClauseInfoDto();
        if(null != prpDclauseCode){
            PrpDclauseCodeDto  prpDclauseCodeDto=this.convert(prpDclauseCode,PrpDclauseCodeDto.class);
            //根据险种代码查询险种中文名称
            Map map=new HashMap();
            map.put("riskCode",prpDclauseCodeDto.getRiskCode());
            map.put("isChinese","zh-CN");
            String riskCName=prpDriskApi.translateCode(map);
            prpDclauseCodeDto.setRiskCName(riskCName);
            responseClauseInfoDto.setPrpDclauseCodeDto(prpDclauseCodeDto);
        }

        //根据条款代码查询条款机构配置表信息
        List<PrpDclauseCodeCom> prpDclauseCodeComList=prpDclauseCodeComDao.findByClauseCode(clauseCode);
        if(prpDclauseCodeComList.size()>0){
            List<PrpDclauseCodeComDto> prpDclauseCodeComDtoList=new ArrayList<PrpDclauseCodeComDto>();
            this.convertCollection(prpDclauseCodeComList,prpDclauseCodeComDtoList,PrpDclauseCodeComDto.class);


            List<String> selectList=new ArrayList<>();
            for(PrpDclauseCodeComDto prpDclauseCodeComDto : prpDclauseCodeComDtoList){
                selectList.add(prpDclauseCodeComDto.getComCode());
            }
            //调用机构数方法
            QueryComCodeInfoDto queryComCodeInfoDto = new QueryComCodeInfoDto();
            queryComCodeInfoDto.setSelectList(selectList);

            queryComCodeInfoDto.setUserCode(userCode);
                queryComCodeInfoDto.setLoginComCode(comCode);
                List<CompanyListDto> companyListDtoList = new ArrayList<>();
                List<com.sinosoft.ims.api.kernel.dto.CompanyListDto> companyListDtos=prpDcompanyApi.queryCompanyTree(queryComCodeInfoDto);
                this.convertCollection(companyListDtos,companyListDtoList,CompanyListDto.class);
                responseClauseInfoDto.setCompanyListDtoList(companyListDtoList);
            responseClauseInfoDto.setPrpDclauseCodeComDtoList(prpDclauseCodeComDtoList);

        }



        //根据条款代码查询条款险别配置表信息
        List<PrpDclauseCodeKind> PrpDclauseCodeKindList= prpDclauseCodeKindDao.findByClauseCode(clauseCode);
        if(PrpDclauseCodeKindList.size()>0){
            List<PrpDclauseCodeKindDto> prpDclauseCodeKindDtoList=new ArrayList<PrpDclauseCodeKindDto>();
            this.convertCollection(PrpDclauseCodeKindList, prpDclauseCodeKindDtoList,PrpDclauseCodeKindDto.class);
            //查询标的名称和险别名称
            for(PrpDclauseCodeKindDto prpDclauseCodeKindDto:prpDclauseCodeKindDtoList){
                 String itemCName=prpDitemAgriService.queryItemName(prpDclauseCode.getRiskCode(),prpDclauseCodeKindDto.getItemCode());
                prpDclauseCodeKindDto.setItemCName(itemCName);
                String kindCName=prpDkindAgriService.translateCode(prpDclauseCodeKindDto.getKindCode(),prpDclauseCode.getRiskCode(),LanguageFlagConstant.CHINESE);
                prpDclauseCodeKindDto.setKindCName(kindCName);
            }
            responseClauseInfoDto.setPrpDclauseCodeKindDtoList(prpDclauseCodeKindDtoList);
            //根据险别代码查询险别列表信息
//            List<PrpDkind> prpDkindList=new ArrayList<PrpDkind>();
//            List<String> listKind = new ArrayList<String>();
//            for(int i=0;i<PrpDclauseCodeKindList.size();i++){
//                listKind.add(PrpDclauseCodeKindList.get(i).getKindCode());
//            }
//            prpDkindList = prpDkindDao.findByKindCodeAndRiskCode(listKind,prpDclauseCode.getRiskCode());
//            if(prpDkindList.size()>0){
//                List<PrpDkindDto> prpDkindListDto=new ArrayList<PrpDkindDto>();
//                this.convertCollection(prpDkindList,prpDkindListDto,PrpDkindDto.class);
//                responseClauseInfoDto.setPrpDkindDtoList(prpDkindListDto);
//            }
        }

        //根据险种代码查询PrpDrisk表获得费率分位
        if(null != prpDclauseCode){
            Double calculator=prpDriskDao.queryByRiskCode(prpDclauseCode.getRiskCode());
            responseClauseInfoDto.setCalculator(calculator);
        }

        //根据条款代码查询条款与保险责任关系表
        List<PrpDrelationClauseCode> prpDrelationClauseCodeList=prpDrelationClauseCodeDao.queryAllByClauseCode(clauseCode);
        if(prpDrelationClauseCodeList.size() >0){
            List<PrpDrelationClauseCodeDto> prpDrelationClauseCodeDtoList=new ArrayList<PrpDrelationClauseCodeDto>();
            convertCollection(prpDrelationClauseCodeList,prpDrelationClauseCodeDtoList,PrpDrelationClauseCodeDto.class);
            String insuranceName="";
            for(PrpDrelationClauseCodeDto prpDrelationClauseCodeDto:prpDrelationClauseCodeDtoList){
                if("BX".equals(prpDrelationClauseCodeDto.getInsuranceCode().substring(0,2))){
                    insuranceName=prpDcodeApi.translateCodeByPK("InsuranceDuty","Insurance");
                }else if("BM".equals(prpDrelationClauseCodeDto.getInsuranceCode().substring(0,2))){
                    insuranceName=prpDcodeApi.translateCodeByPK("InsuranceDuty","Insuranceexempts");
                }
                prpDrelationClauseCodeDto.setInsuranceName(insuranceName);
            }
            responseClauseInfoDto.setPrpDrelationClauseCodeDtoList(prpDrelationClauseCodeDtoList);
        }

        //根据保险责任代码查询PrpDclause表
        List<String> insuranceCodes=new ArrayList<String>();
        for(PrpDrelationClauseCode prpDrelationClauseCode:prpDrelationClauseCodeList){
            insuranceCodes.add(prpDrelationClauseCode.getInsuranceCode());
        }
        if(insuranceCodes.size()!=0) {
            List<PrpDclause> prpDclauseListClause = prpDclauseDao.queryPrpdclause(insuranceCodes);
            List<PrpDclauseDto> prpDclauseDtoListClause = new ArrayList<PrpDclauseDto>();
            convertCollection(prpDclauseListClause, prpDclauseDtoListClause, PrpDclauseDto.class);
            responseClauseInfoDto.setPrpdclauseDtoListClause(prpDclauseDtoListClause);
        }
        //根据险种代码查询PrpDclause表
//        List<PrpDclauseDto> prpDclauseListKind=prpDclauseService.queryByKindContext(prpDclauseCode.getRiskCode());
//        if(prpDclauseListKind.size()>0){
//           responseClauseInfoDto.setPrpdclauseDtoListKind(prpDclauseListKind);
//        }

        return responseClauseInfoDto;
    }

    /**
     * 在PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表插入信息
     * @author: 刘曼曼
     * @date: 2017/11/8 11:09
     * @param requestClauseCodeInfoDto 条款保存信息Dto
     */
    @Transactional
    public Map<String, String> saveClauseByComByKind(RequestClauseCodeInfoDto requestClauseCodeInfoDto) throws Exception{
        //获取得到的参数
        PrpDclauseCodeDto prpDclauseCodeDto= requestClauseCodeInfoDto.getPrpDclauseCodeDto();
        List<PrpDclauseCodeComDto> prpDclauseCodeComDtoList= requestClauseCodeInfoDto.getPrpDclauseCodeComDtoList();
        List<PrpDclauseCodeKindDto> prpDclauseCodeKindDtoList= requestClauseCodeInfoDto.getPrpDclauseCodeKindDtoList();
        List<PrpDrelationClauseCodeDto> prpDrelationClauseCodeDtoList= requestClauseCodeInfoDto.getPrpDrelationClauseCodeDtoList();
//        List<String> insuranceList=requestClauseCodeInfoDto.getInsuranceList();
//        List<String> isFlagList=requestClauseCodeInfoDto.getIsFlagList();
        //获取当前时间
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String createDate=sdf.format(date);
        //调用dms系统，传入险种，返回条款代码
        String clauseCode="";
        BillNoDto billNoDto=new BillNoDto();
        if(StringUtils.isNotEmpty(prpDclauseCodeDto.getRiskCode())){
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
            String year=dateFormat.format(new Date());
            billNoDto.setTableName("prpdclausecode");
            billNoDto.setRiskCode(prpDclauseCodeDto.getRiskCode());
            billNoDto.setiComCode(null);
            billNoDto.setiYear(year);
            billNoDto.setUserCode(null);
            Map<String,String> map=billNoApi.getBillNo(billNoDto);
            if(map!=null){
                clauseCode=map.get("billNo");
            }else{
                throw new  DataVerifyException("条款号未获取！");
            }
        }

        //获取标的代码
//        //判断comCode的前两位，向条款主表添加版本号
//        if (StringUtils.isNotEmpty(prpDclauseCodeComDtoList.get(0).getComCode())) {
//            String isVersionNo = prpDclauseCodeComDtoList.get(0).getComCode().substring(0,2);
//            //判断版本号和版本类型
//            if("00".equals(isVersionNo) || "34".equals(isVersionNo)){
//                //00和34是安徽
//                prpDclauseCodeDto.setVersionNo("A");
//                prpDclauseCodeDto.setVersionType("A");
//            }else if("41".equals(isVersionNo)){
//                //41是河南
//                prpDclauseCodeDto.setVersionNo("B");
//                prpDclauseCodeDto.setVersionType("B");
//            }else if("42".equals(isVersionNo)){
//                //42是湖北
//                prpDclauseCodeDto.setVersionNo("C");
//                prpDclauseCodeDto.setVersionType("C");
//            }else if("52".equals(isVersionNo)){
//                //52是贵州
//                prpDclauseCodeDto.setVersionNo("D");
//                prpDclauseCodeDto.setVersionType("D");
//            }
//        }
        Map<String,String> map=new HashMap<String,String>();
    try{
        //向条款配置主表插入信息
        if(null != prpDclauseCodeDto){
            prpDclauseCodeDto.setClauseCode(clauseCode);
            prpDclauseCodeDto.setCreateDate(sdf.parse(createDate));
            prpDclauseCodeDto.setUpdateDate(sdf.parse(createDate));
            //判断是暂存还是保存
            if(StringUtils.isEmpty(prpDclauseCodeDto.getFlag())){
                prpDclauseCodeDto.setFlag("0");//暂存
            }
            PrpDclauseCode prpDclauseCode=this.convert(prpDclauseCodeDto,PrpDclauseCode.class);
            prpDclauseCodeDao.save(prpDclauseCode);
        }
        //向条款机构配置表插入信息
        if(prpDclauseCodeComDtoList.size() != 0){
            for(PrpDclauseCodeComDto prpDclauseCodeComDto:prpDclauseCodeComDtoList){
                prpDclauseCodeComDto.setClauseCode(clauseCode);
                //判断是暂存还是保存
                if(StringUtils.isEmpty(prpDclauseCodeComDto.getFlag())){
                    prpDclauseCodeComDto.setFlag("0");//暂存
                }
            }
            List<PrpDclauseCodeCom> prpDclauseCodeComList =new ArrayList<PrpDclauseCodeCom>();
            this.convertCollection(prpDclauseCodeComDtoList,prpDclauseCodeComList,PrpDclauseCodeCom.class);
            prpDclauseCodeComDao.save(prpDclauseCodeComList);
        }

        //向条款险别配置表插入信息
        if(prpDclauseCodeKindDtoList.size() != 0){
            //设置条款代数值
            for(PrpDclauseCodeKindDto prpDclauseCodeKindDto : prpDclauseCodeKindDtoList) {
                prpDclauseCodeKindDto.setClauseCode(clauseCode);
                if(StringUtils.isNotEmpty(prpDclauseCodeKindDto.getKindContext())){
                    List<PrpDclauseDto> prpDclauseDtos=ungroupText(prpDclauseCodeKindDto.getKindContext(),clauseCode,prpDclauseCodeKindDto.getItemCode());
                    List<PrpDclause> prpDclauseskind=new ArrayList<>();
                    convertCollection(prpDclauseDtos,prpDclauseskind,PrpDclause.class);
                    prpDclauseDao.save(prpDclauseskind);
                }
            }
//            //获得1-主险/2-附加险和是否计入保额（Y/N）
//            for(int i=0;i<insuranceList.size();i++){
//                String calculateFlag=isFlagList.get(i)+insuranceList.get(i);
//                prpDclauseCodeKindDtoList.get(i).setCalculateFlag(calculateFlag);
//            }
            List<PrpDclauseCodeKind> prpDclauseCodeKindList=new ArrayList<PrpDclauseCodeKind>();
            this.convertCollection(prpDclauseCodeKindDtoList,prpDclauseCodeKindList,PrpDclauseCodeKind.class);
            prpDclauseCodeKindDao.save(prpDclauseCodeKindList);
        }

        //向条款与保险责任关联表插入信息
        if(prpDrelationClauseCodeDtoList.size() != 0){
            for(PrpDrelationClauseCodeDto prpDrelationClauseCodeDto : prpDrelationClauseCodeDtoList) {
                prpDrelationClauseCodeDto.setClauseCode(clauseCode);
                if(StringUtils.isNotEmpty(prpDrelationClauseCodeDto.getInsuranceText())){
                    List<PrpDclauseDto> prpDclauseDtos=ungroupText(prpDrelationClauseCodeDto.getInsuranceText(),clauseCode,prpDrelationClauseCodeDto.getInsuranceCode());
                    List<PrpDclause> prpDclauses=new ArrayList<>();
                    convertCollection(prpDclauseDtos,prpDclauses,PrpDclause.class);
                    prpDclauseDao.save(prpDclauses);
                }
            }
            List<PrpDrelationClauseCode> prpDrelationClauseCodeList =new ArrayList<PrpDrelationClauseCode>();
            convertCollection(prpDrelationClauseCodeDtoList,prpDrelationClauseCodeList,PrpDrelationClauseCode.class);
            prpDrelationClauseCodeDao.save(prpDrelationClauseCodeList);

        }
        map.put("message","success");
        map.put("success",clauseCode);
    } catch (Exception e) {
        //失败
        map.put("message","failed");
        e.printStackTrace();
    } finally {

    }
        return map;
    }
    private List<PrpDclauseDto> ungroupText(String strText,String clausecode,String insuranceCode) throws Exception {

        PrpDclauseDto prpDclauseDto = null; // 新增Schema
        String[] arrText = {}; // 拆分的批文数组
        List list = new ArrayList(); // 数组
        int intLineNo = 0; // 行号
        intLineNo = 0;
        StringBuilder buffer = new StringBuilder();
        // 拆分
        arrText = splits(strText, 25);//FIELDLENGHT=80

        // 赋值
        for (int i = 0; i < arrText.length; i++) {
            // 长度校验
            if (arrText[i].trim().getBytes().length > PMSConstant.PMS_SERVICE_FIELDLENGHT) {
                throw new DataVerifyException("批文长度过长！");
            }
            intLineNo++; // 行号加一
            prpDclauseDto = new PrpDclauseDto();
            prpDclauseDto.setClauseCode(insuranceCode);
            prpDclauseDto.setContext(arrText[i]);
            prpDclauseDto.setLineNo(intLineNo);
            prpDclauseDto.setNewClauseCode(clausecode);
            prpDclauseDto.setValidStatus("1");
            prpDclauseDto.setLanguage("C");
            prpDclauseDto.setTitleFlag("0");
            list.add(prpDclauseDto);
        }
        return list;
    }
    /**
     * 用来拆分特约信息
     * @author: 田健
     * @date: 2018/2/2 8:42
     * @param originalString 字符串
     * @param splitByteLength 要截取的长度
     * @return 返回的字符串集合
     */
    public static String[] splits(String originalString, int splitByteLength){
        if(originalString.isEmpty()){
            return null;
        }

        int total=originalString.length();
        //获取数组总长度
        int len=(int)  Math.ceil(total/Double.valueOf(splitByteLength));
        //截取的起始位置
        int startIndex,endIndex;

        String[] ary=new String[len];
        String temp;
        for(int i=0;i<len;i++){
            startIndex=i*splitByteLength;
            endIndex=(i+1)*splitByteLength;
            if(endIndex>total){
                endIndex=total;
            }
            temp=originalString.substring(startIndex,endIndex);
            ary[i]=temp;
        }
        return ary;
    }

    /**
     * 修改PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表信息
     * @author: 刘曼曼
     * @date: 2017/11/8 11:09
     * @param requestClauseCodeInfoDto 条款配置Dto,条款险别配置Dto的集合,条款机构配置Dto的集合，条款与保险责任关系表Dto
     */
    @Transactional
    public Map<String,String> modifyClauseByComByKind(RequestClauseCodeInfoDto requestClauseCodeInfoDto)throws Exception{
        //获取得到的参数
        PrpDclauseCodeDto prpDclauseCodeDto= requestClauseCodeInfoDto.getPrpDclauseCodeDto();
        List<PrpDclauseCodeComDto> prpDclauseCodeComDtoList= requestClauseCodeInfoDto.getPrpDclauseCodeComDtoList();
        List<PrpDclauseCodeKindDto> prpDclauseCodeKindDtoList= requestClauseCodeInfoDto.getPrpDclauseCodeKindDtoList();
        List<PrpDrelationClauseCodeDto> prpDrelationClauseCodeDtoList= requestClauseCodeInfoDto.getPrpDrelationClauseCodeDtoList();
//        List<String> insuranceList=requestClauseCodeInfoDto.getInsuranceList();
//        List<String> isFlagList=requestClauseCodeInfoDto.getIsFlagList();

        if(null == prpDclauseCodeDto){
            throw new DataVerifyException("条款主表信息不能为空！");
        }
        if(prpDclauseCodeComDtoList.size()==0){
            throw new DataVerifyException("条款机构配置表信息不能为空");
        }
        if(prpDclauseCodeKindDtoList.size()==0){
            throw new DataVerifyException("条款险别配置表信息不能为空");
        }
        if(prpDrelationClauseCodeDtoList.size()==0) {
            throw new DataVerifyException("条款与保险责任关系表信息不能为空");
        }

        SimpleDateFormat sfd=new SimpleDateFormat("yyyy-MM-dd");
        String updateDate=sfd.format(new Date());
        prpDclauseCodeDto.setUpdateDate(sfd.parse(updateDate));
        //修改的条款主表信息
        //把条款主表Dto转换成条款主表entity
        PrpDclauseCode prpDclauseCode=this.convert(prpDclauseCodeDto,PrpDclauseCode.class);
        //根据条款代码查询条款主表信息，并向轨迹表添加数据
        PrpDclauseCode prpDclauseCode1=prpDclauseCodeDao.findByClauseCode(prpDclauseCodeDto.getClauseCode());
        //将主表Dto信息转换到轨迹表Dto中
        PrpDclauseCodeHis prpDclauseCodeHis=this.convert(prpDclauseCode1,PrpDclauseCodeHis.class);
        //查询轨迹表的最大修改次数进行自增一次
        Double maxIndexNo1=prpDclauseCodeHisDao.getMaxIndexNo();
        prpDclauseCodeHis.setIndexNo(maxIndexNo1+1);
        //向条款轨迹主表插入信息
        prpDclauseCodeHisDao.save(prpDclauseCodeHis);
        //保存修改的条款主表信息
        prpDclauseCodeDao.save(prpDclauseCode);

        //修改的条款机构配置表信息
        List<PrpDclauseCodeCom> prpDclauseCodeComList=new ArrayList<PrpDclauseCodeCom>();
        //把结构表Dto集合转换成机构表entity集合
        this.convertCollection(prpDclauseCodeComDtoList,prpDclauseCodeComList,PrpDclauseCodeCom.class);
        //根据条款代码查询条款机构配置表信息，并向轨迹表加添数据
        List<PrpDclauseCodeCom> prpDclauseCodeComList1=prpDclauseCodeComDao.findByClauseCode(prpDclauseCodeDto.getClauseCode());
        //查询轨迹表的最大修改次数进行自增一次
        List<PrpDclauseCodeComHis> prpDclauseCodeComHisList=new ArrayList<PrpDclauseCodeComHis>();
        Double maxIndexNo2 = prpDclauseCodeComHisDao.getMaxIndexNo();
        for(PrpDclauseCodeCom prpDclauseCodeCom : prpDclauseCodeComList1){
            //将主表Dto信息转换到轨迹表Dto中
            PrpDclauseCodeComHis prpDclauseCodeComHis=this.convert(prpDclauseCodeCom,PrpDclauseCodeComHis.class);
            prpDclauseCodeComHis.setIndexNo(maxIndexNo2+1);
            prpDclauseCodeComHisList.add(prpDclauseCodeComHis);
        }
        //向款机构配置轨迹表插入信息
        prpDclauseCodeComHisDao.save(prpDclauseCodeComHisList);
        //先删除条款机构配置表的信息
      //prpDclauseCodeComDao.deleteClauseCode(prpDclauseCodeDto.getClauseCode());
        //改成删对象
        prpDclauseCodeComDao.delete(prpDclauseCodeComList1);
        //保存修改的条款机构配置表信息
        prpDclauseCodeComDao.save(prpDclauseCodeComList);


        //修改的条款险别配置表信息
        List<PrpDclauseCodeKind> prpDclauseCodeKindList = new ArrayList<PrpDclauseCodeKind>();
        if(prpDclauseCodeKindDtoList.size()>0){
            //保存险别详情
            for(PrpDclauseCodeKindDto prpDclauseCodeKindDto : prpDclauseCodeKindDtoList) {
                if(StringUtils.isNotEmpty(prpDclauseCodeKindDto.getKindContext())){
                    List<PrpDclauseDto> prpDclauseDtos=ungroupText(prpDclauseCodeKindDto.getKindContext(),prpDclauseCodeKindDto.getClauseCode(),prpDclauseCodeKindDto.getItemCode());
                    List<PrpDclause> prpDclauseskind=new ArrayList<>();
                    convertCollection(prpDclauseDtos,prpDclauseskind,PrpDclause.class);
                    prpDclauseDao.deletePrpDclause(prpDclauseCodeKindDto.getClauseCode(),prpDclauseCodeKindDto.getItemCode());
                    prpDclauseDao.save(prpDclauseskind);
                }
            }
            //获得1-主险/2-附加险和是否计入保额（Y/N）
//            for(int i=0;i<insuranceList.size();i++){
//                String calculateFlag=isFlagList.get(i)+insuranceList.get(i);
//                prpDclauseCodeKindDtoList.get(i).setCalculateFlag(calculateFlag);
//            }
            //把险别表Dto集合转换成险别表entity集合
            this.convertCollection(prpDclauseCodeKindDtoList,prpDclauseCodeKindList,PrpDclauseCodeKind.class);
            //根据条款代码查询条款险别配置表信息，并向轨迹表加添数据
            List<PrpDclauseCodeKind> prpDclauseCodeKindList1=prpDclauseCodeKindDao.findByClauseCode(prpDclauseCodeDto.getClauseCode());
            //查询轨迹表的最大修改次数进行自增一次
            List<PrpDclauseCodeKindHis> prpDclauseCodeKindHisList=new ArrayList<PrpDclauseCodeKindHis>();
            Double maxIndexNo3 = prpDclauseCodeKindHisDao.getMaxIndexNo();
            for(PrpDclauseCodeKind prpDclauseCodeKind : prpDclauseCodeKindList1 ){
                //将主表Dto信息转换到轨迹表Dto中
                PrpDclauseCodeKindHis prpDclauseCodeKindHis= this.convert(prpDclauseCodeKind,PrpDclauseCodeKindHis.class);
                prpDclauseCodeKindHis.setIndexNo(maxIndexNo3+1);
                prpDclauseCodeKindHisList.add(prpDclauseCodeKindHis);
            }
            //向条款险别配置轨迹表插入信息
            prpDclauseCodeKindHisDao.save(prpDclauseCodeKindHisList);
            //先删除条款险别配置表信息
//            prpDclauseCodeKindDao.deleteClauseCode(prpDclauseCodeDto.getClauseCode());
            prpDclauseCodeKindDao.delete(prpDclauseCodeKindList1);
            //保存修改的条款险别配置表信息
            prpDclauseCodeKindDao.save(prpDclauseCodeKindList);
        }

        //修改条款与保险责任关系表信息
        List<PrpDrelationClauseCode> prpDrelationClauseCodeList=new ArrayList<PrpDrelationClauseCode>();
        if(prpDrelationClauseCodeDtoList.size()>0){
            for(PrpDrelationClauseCodeDto prpDrelationClauseCodeDto : prpDrelationClauseCodeDtoList) {
                if(StringUtils.isNotEmpty(prpDrelationClauseCodeDto.getInsuranceText())){
                    List<PrpDclauseDto> prpDclauseDtos=ungroupText(prpDrelationClauseCodeDto.getInsuranceText(),prpDrelationClauseCodeDto.getClauseCode(),prpDrelationClauseCodeDto.getInsuranceCode());
                    List<PrpDclause> prpDclauses=new ArrayList<>();
                    convertCollection(prpDclauseDtos,prpDclauses,PrpDclause.class);
                    prpDclauseDao.deletePrpDclause(prpDrelationClauseCodeDto.getClauseCode(),prpDrelationClauseCodeDto.getInsuranceCode());
                    prpDclauseDao.save(prpDclauses);
                }
            }
            convertCollection(prpDrelationClauseCodeDtoList,prpDrelationClauseCodeList,PrpDrelationClauseCode.class);
            //先删除条款与保险责任关系表信息
            prpDrelationClauseCodeDao.deleteClauseCode(prpDclauseCodeDto.getClauseCode());
            //保存修改的条款与保险责任关系表信息
            prpDrelationClauseCodeDao.save(prpDrelationClauseCodeList);
        }

        Map<String,String> map=new HashMap<String,String>();
        map.put("message","success");
        return map;
    }

    /**
     ** 根据条款代码停用、启用条款
     * @author: 刘曼曼
     * @date: 2017/11/9 15:58
     * @param prpDclauseCodeDto 条款配置的Dto
     * @return Map 返回信息
     * @throws Exception
     */
    @Transactional
    public Map<String, String> motifyenableOrDisableClause(PrpDclauseCodeDto prpDclauseCodeDto)throws Exception{
        if(null != prpDclauseCodeDto){
            //根据主键查询到所有的字段存到实体类中
            PrpDclauseCode prpDclauseCode=prpDclauseCodeDao.findOne(new PrpDclauseCodeKey(prpDclauseCodeDto.getClauseCode()));
            prpDclauseCode.setValidStatus(prpDclauseCodeDto.getValidStatus());
            prpDclauseCodeDao.save(prpDclauseCode);
        }

        Map<String,String> map=new HashMap<String,String>();
        map.put("message","success");
        return map;
    }

    /**
     * 根据条款代码删除PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表的信息
     * @author: 刘曼曼
     * @date: 2017/11/9 18:14
     * @param clauseCode 条款代码
     */
    @Transactional
    public Map<String, String> removeByClause(String clauseCode)throws Exception{
        if(StringUtils.isEmpty(clauseCode)){
            throw new DataVerifyException("条款代码不能为空");
        }
        //删除条款配置主表信息
        prpDclauseCodeDao.deleteClauseCode(clauseCode);
        //删除条款机构配置表信息
//        prpDclauseCodeComDao.deleteClauseCode(clauseCode);
        //删除条款限险别配置表信息
//        prpDclauseCodeKindDao.deleteClauseCode(clauseCode);
        //删除条款与保险责任关系表
//        prpDrelationClauseCodeDao.deleteClauseCode(clauseCode);
        Map<String,String> map=new HashMap<String,String>();
        map.put("message","success");
        return map;
    }


    /**
     * 根据条款代码批量删除PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKind列表的信息
     * @author: 刘曼曼
     * @date: 2017/11/9 18:14
     * @param clauseCodes 条款代码集合
     */
    @Transactional
    public Map<String,String> removeBatchByClause(List<String> clauseCodes)throws Exception{
        if(clauseCodes.size()==0){
            throw new DataVerifyException("条款代码集合不能为空！");
        }
        //批量删除条款配置主表信息
        prpDclauseCodeDao.deleteList(clauseCodes);
        //批量删除条款机构配置表信息
//        prpDclauseCodeComDao.deleteList(clauseCodes);
        //批量删除条款限险别配置表信息
//        prpDclauseCodeKindDao.deleteList(clauseCodes);
        //删除条款与保险责任关系表
//        prpDrelationClauseCodeDao.deleteList(clauseCodes);

        Map<String,String> map=new HashMap<String,String>();
        map.put("message","success");
        return map;
    }

    /**
     * 根据条款代码查询该条款的政策性标志并翻译
     * @author: 王保良
     * @date: 2017/12/19 17:33
     * @param clauseCode 条款代码
     * @return Map<String,String> map 返回政策性中文名称
     * @throws Exception
     */
    @Override
    public Map<String,String> queryByPkAndTranslate(String clauseCode) throws Exception {
        PrpDclauseCodeKey   prpDclauseCodeKey = new   PrpDclauseCodeKey(clauseCode);
        PrpDclauseCode   prpDclauseCode =   PrpDclauseCodeDao.findOne(prpDclauseCodeKey);
        String businessType= prpDclauseCode.getBusinessType();
        PrpDcodeDto prpDcodeDto=prpDcodeApi.queryByPK("BusinessType1",businessType);
        Map<String,String> map=new HashMap<>();
        map.put("message",prpDcodeDto.getCodeCName());
        map.put("businessType",businessType);
        return map;
    }
    /**
     * * 根据条款代码查询条款配置主表信息
     * @author: 田慧
     * @date: 17:00
     * @param clauseCode 条款代码
     * @return PrpDclauseCodeDto
     * @throws Exception
     */
    @Override
    public PrpDclauseCodeDto getPrpDclauseCodeInfo(String clauseCode)throws Exception{
        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String datedate = simpleDateFormat.format(date);
//        date = simpleDateFormat.parse(datedate);
        PrpDclauseCode prpDclauseCode=PrpDclauseCodeDao.getPrpDclauseCodeInfo(clauseCode,date);
        PrpDclauseCodeDto prpDclauseCodeDto = this.convert(prpDclauseCode,PrpDclauseCodeDto.class);
        return prpDclauseCodeDto;
    }
}