package com.sinosoft.ims.core.kernel.service.impl;


import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.UserInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.auth.dto.SubComDto;
import com.sinosoft.ims.api.kernel.dto.*;
import com.sinosoft.ims.core.auth.service.UtiGroupService;
import com.sinosoft.ims.core.kernel.dao.PrpDcompanyDao;
import com.sinosoft.ims.core.kernel.entity.PrpDcompany;
import com.sinosoft.ims.core.kernel.entity.PrpDcompanyKey;
import com.sinosoft.ims.core.kernel.service.PrpDcompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 机构代码表Core接口实现
 */
@Service
public class PrpDcompanyServiceImpl extends BaseCustomServiceImpl implements PrpDcompanyService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDcompanyServiceImpl.class);

    @Autowired
    private PrpDcompanyDao prpDcompanyDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UtiGroupService utiGroupService;
    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDcompanyDto prpDcompanyDto) {
        PrpDcompany prpDcompany = this.convert(prpDcompanyDto, PrpDcompany.class);
        prpDcompanyDao.save(prpDcompany);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String comCode) {
        PrpDcompanyKey prpDcompanyKey = new PrpDcompanyKey(comCode);
        prpDcompanyDao.delete(prpDcompanyKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDcompanyDto prpDcompanyDto) {
        PrpDcompany prpDcompany = this.convert(prpDcompanyDto, PrpDcompany.class);
        prpDcompanyDao.save(prpDcompany);
    }
    /**
     * 根据主键查询
     * @author: 宋振振
     * @date: 2017/11/14 10:00
     * @param comCode 机构代码
     * @return PrpDcompanyDto 机构代码表信息
     * @throws Exception
     */
    @Override
    public PrpDcompanyDto queryByPK(String comCode) throws Exception{
        PrpDcompanyKey prpDcompanyKey = new PrpDcompanyKey(comCode);
        PrpDcompany prpDcompany = prpDcompanyDao.findOne(prpDcompanyKey);
        return this.convert(prpDcompany,PrpDcompanyDto.class);
    }

    /**
     *  （根据传入的机构代码 查询该机构下的所有下级机构名称集合）
     * @author: 祝凯
     * @date: 2017/11/8 11:18
     * @param comCode 机构代码
     * @return
     */
    @Override
    public List<PrpDcompanyDto> queryDownCompany(String comCode) throws Exception{
        if(StringUtils.isEmpty(comCode)){
            throw new DataVerifyException("传入的机构不能为空!");
        }
        Map<String,Object> paraMap=new HashMap<String,Object>();
        //拼接遍历循环查询该机构下所有子机构信息集合
        String sql=" select  *  from PrpDcompany where validstatus = '1'";
        StringBuilder strWhere = new StringBuilder();
        strWhere.append(" start with comcode = :comCode"+" connect by comcode = prior uppercomcode  " +
                "and prior comcode != comcode ");
        paraMap.put("comCode",comCode );
        sql+=strWhere.toString();
        javax.persistence.Query dataQuery= entityManager.createNativeQuery(sql,PrpDcompany.class);
        this.setQueryParam(dataQuery,paraMap);
        List<PrpDcompany> prpDcompanyList = dataQuery.getResultList();
        List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<PrpDcompanyDto>();
        convertCollection(prpDcompanyList,prpDcompanyDtoList,PrpDcompanyDto.class);
        return prpDcompanyDtoList;
    }

    /**
     *  按照comCode查询该机构的上级省级机构
     * @author: 何伟东
     * @date: 2017/10/31 10:33
     * @param comCode 机构代码
     * @return 省级机构信息
     */
    @Override
    public PrpDcompanyDto queryProvinceComByComCode(String comCode) {
        // 原生SQL：需要使用递归查询
        String sql ="SELECT a.* FROM PrpDcompany a WHERE comLevel = '2' START WITH a.comCode = :comCode CONNECT BY NOCYCLE PRIOR a.upperComCode = a.comCode";
        Query dataQuery = entityManager.createNativeQuery(sql,PrpDcompany.class);
        dataQuery.setParameter("comCode", comCode);
        PrpDcompany prpDcompany = (PrpDcompany) dataQuery.getSingleResult();
        return convert(prpDcompany,PrpDcompanyDto.class);
    }
    /**
     * 投保单录入归属机构查询的实现方法
     * @param queryComCodeInfoDto
     * @return com.sinosoft.framework.dto.ResponseDto 归属机构的集合
     * @throws Exception
     * @author 李冬松
     * @date 15:54 2017/11/18
     */
    @Override
    public List<PrpDcompanyDto> findCompany(QueryComCodeInfoDto queryComCodeInfoDto) throws Exception {
        String comCode=queryComCodeInfoDto.getComCode();
        String loginComCode=queryComCodeInfoDto.getLoginComCode();
        String comCName=queryComCodeInfoDto.getComCName();

        StringBuilder strQueryCondition=new StringBuilder("");

        strQueryCondition.append("select PrpDcompany.*  from PrpDcompany  PrpDcompany where PrpDcompany.validStatus='1'  AND PrpDcompany.comCode like :comCode and PrpDcompany.comCName like :comCName " +
                " and (PrpDcompany.upperComCode <> '0000000000' or (PrpDcompany.upperComCode='0000000000' and PrpDcompany.comCode like'000000%'))" +
                " AND substr(PrpDcompany.comType,2,1) ='1'  ");
        AddCodePowerConditionDto addCodePowerConditionDto
                =new AddCodePowerConditionDto(queryComCodeInfoDto.getUserCode(),
                                              queryComCodeInfoDto.getLoginComCode(),
                                              queryComCodeInfoDto.getGradeCodes(),
                                              "PrpDcompany",
                                              "",
                                              "ComCode",
                                              queryComCodeInfoDto.getRiskCode(),
                                              "PrpDcompany",
                                              false);

        String addCodePower=utiGroupService.addCodePower(addCodePowerConditionDto);
        strQueryCondition.append(addCodePower);
        if(loginComCode.indexOf("YL") > -1){
            strQueryCondition.append(" AND PrpDcompany.marketType = 'YL'");
        }else{
            strQueryCondition.append(" AND PrpDcompany.marketType = 'BX'");
        }
        strQueryCondition.append(" ORDER BY PrpDcompany.comLevel,PrpDcompany.comCode");
        Query query=entityManager.createNativeQuery(strQueryCondition.toString(),PrpDcompany.class);
        comCode = "%"+comCode+"%";
        comCName= "%"+comCName+"%";
        query.setParameter("comCode",comCode);
        query.setParameter("comCName", comCName);

        List<PrpDcompany> prpDcompanyList=query.getResultList();

        List<PrpDcompanyDto> prpDcompanyDtoList=new ArrayList<>();

        convertCollection(prpDcompanyList,prpDcompanyDtoList,PrpDcompanyDto.class);

        return prpDcompanyDtoList;
    }
    /**
    *
    * @param comCode
    * @return java.util.List<com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto>
    * @throws
    * @author 李冬松
    * @date 14:39 2017/11/27
    */
    @Override
    public List<PrpDcompanyDto> findByComCode(String comCode) throws Exception {

        StringBuilder sql=new StringBuilder("select p.* from PrpDcompany p where p.comLevel='2' " +
                " start with p.comCode=:strComCodeForTemp connect by nocycle prior p.upperComCode=p.comCode ");
        Query query=entityManager.createNativeQuery(sql.toString(),PrpDcompany.class);
        query.setParameter("strComCodeForTemp",comCode);
        List<PrpDcompany> prpDcompanyList=query.getResultList();
        List<PrpDcompanyDto> prpDcompanyDtoList=new ArrayList<>();
        convertCollection(prpDcompanyList,prpDcompanyDtoList,PrpDcompanyDto.class);

        return prpDcompanyDtoList;
    }
    /**
     * @description 理赔任务转交查询所有符合条件的二级机构
     * @author 杨航
     * @date 2017年12月11日 下午4:04:46
     * @param
     * @return prpDcompanyDtoList 机构集合
     */
    @Override
	public List<PrpDcompanyTurnTaskDto> queryTurnTaskTwoLevelCompany() {
		StringBuilder sql = new StringBuilder(
				"SELECT * FROM PrpDcompany p WHERE p.comLevel = '2' and p.validStatus = '1' and ( p.comCode not like '0000%' or p.comCode like '00000013%' )");
		Query query=entityManager.createNativeQuery(sql.toString(),PrpDcompany.class);
		List<PrpDcompany> prpDcompanyList=query.getResultList();
		List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<>();
		this.convertCollection(prpDcompanyList, prpDcompanyDtoList, PrpDcompanyDto.class);
		// 判断是否有下级机构
		List<PrpDcompanyTurnTaskDto> prpDcompanyTurnTaskDtoList = new ArrayList<>();
		if (prpDcompanyDtoList != null && prpDcompanyDtoList.size() > 0) {
			for (PrpDcompanyDto prpDcompanyDto:prpDcompanyDtoList) {
				PrpDcompanyTurnTaskDto prpDcompanyTurnTaskDto = new PrpDcompanyTurnTaskDto();
				prpDcompanyTurnTaskDto.setPrpDcompanyDto(prpDcompanyDto);
				if (queryIfHasDownCompany(prpDcompanyDto.getComCode())) {
					prpDcompanyTurnTaskDto.setIfHasDownCompany("Y");
				} else {
					prpDcompanyTurnTaskDto.setIfHasDownCompany("N");
				}
				prpDcompanyTurnTaskDtoList.add(prpDcompanyTurnTaskDto);
			}
		}
		return prpDcompanyTurnTaskDtoList;
	}
	/**
	  * @description 理赔任务转交查询所有符合条件的下级机构
	  * @author 杨航
	  * @date 2017年12月12日 下午2:58:30
	  * @param prpDcompanyDto 入参对象
	  * @return prpDcompanyDtoList 机构集合
	  */
	@Override
	public List<PrpDcompanyTurnTaskDto> queryTurnTaskDownLevelCompany(PrpDcompanyDto prpDcompanyDto) {
		if (prpDcompanyDto == null || StringUtils.isEmpty(prpDcompanyDto.getComCode())) {
			throw new DataVerifyException("理赔任务转交获取下级机构入参不合法！");
		}
		StringBuilder sql = new StringBuilder(
				"SELECT * FROM PrpDcompany p WHERE p.validStatus = '1' and p.upperComCode = :comCode and ( p.comCode not like '0000%' or p.comCode like '00000013%')");
		Query query=entityManager.createNativeQuery(sql.toString(),PrpDcompany.class);
        query.setParameter("comCode",prpDcompanyDto.getComCode());
        List<PrpDcompany> prpDcompanyList=query.getResultList();
        List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<>();
		this.convertCollection(prpDcompanyList, prpDcompanyDtoList, PrpDcompanyDto.class);
		// 判断是否有下级机构
		List<PrpDcompanyTurnTaskDto> prpDcompanyTurnTaskDtoList = new ArrayList<>();
		if (prpDcompanyDtoList != null && prpDcompanyDtoList.size() > 0) {
			for (PrpDcompanyDto item : prpDcompanyDtoList) {
				PrpDcompanyTurnTaskDto prpDcompanyTurnTaskDto = new PrpDcompanyTurnTaskDto();
				prpDcompanyTurnTaskDto.setPrpDcompanyDto(item);
				if (queryIfHasDownCompany(prpDcompanyDto.getComCode())) {
					prpDcompanyTurnTaskDto.setIfHasDownCompany("Y");
				} else {
					prpDcompanyTurnTaskDto.setIfHasDownCompany("N");
				}
				prpDcompanyTurnTaskDtoList.add(prpDcompanyTurnTaskDto);
			}
		}
		return prpDcompanyTurnTaskDtoList;
	}
	/**
	  * @description 理赔任务判断机构是否还有下级机构
	  * @author 杨航
	  * @date 2017年12月12日 下午2:58:30
	  * @param comCode 入参对象
	  * @return prpDcompanyDtoList 机构集合
     */
    public boolean queryIfHasDownCompany(String comCode) {
		int count = prpDcompanyDao.queryIfHasDownCompany(comCode);
		if (count != 0) {
			return true;
		}
		return false;
	}
    /**
     * （根据机构代码查询对应中文名称）
     * @param comCode 机构代码
     * @return 中文名称
     * @author: 董坤
     * @date: 2017/11/18 10:50
     */
    @Override
    public String translateCodeByPK(String comCode) {
        PrpDcompanyKey prpDcompanyKey = new PrpDcompanyKey(comCode);
        PrpDcompany prpDcompany = prpDcompanyDao.findOne(prpDcompanyKey);
        return prpDcompany.getComCName();
    }
    /**
     * 查询作业区域
     * 根据班表机构查询表PrpDcompany回显到区域设置页面
     * @author: 孙朋飞
     * @date: 2017/11/9 14:14
     * @param prpdDto 获取班表机构
     * @return 机构代码表的集合
     * @throws Exception
     */
    public List<PrpDcompanyDto> queryPrpDcompanyByHandleDept(PrpDcompanyDto prpdDto) throws Exception {
        if(prpdDto==null){
            throw new DataVerifyException("请求数据不能为空!");
        }
        if(StringUtils.isEmpty(prpdDto.getComCode())){
            throw new DataVerifyException("班表机构不能为空!");
        }
        StringBuilder dataSql=new StringBuilder();
        //原生sql
        dataSql.append("SELECT * ");
        dataSql.append("FROM PrpDcompany p  WHERE companyFlag='1'  Connect By p.upperComCode = Prior p.comCode Start With p.comCode=:comCode");
        Query nativeQuery = entityManager.createNativeQuery(dataSql.toString(),PrpDcompany.class);
        nativeQuery.setParameter("comCode",prpdDto.getComCode());
        List<PrpDcompany> resultList = nativeQuery.getResultList();
        List<PrpDcompanyDto> prpDcompanyList=new ArrayList<>();
        convertCollection(resultList,prpDcompanyList,PrpDcompanyDto.class);
        return prpDcompanyList;
    }
    /**
     * （查询所有的班表机构）
     * @author: 孙朋飞
     * @date: 2017/11/19 21:22
     * @param prpdDto 总公司的机构代码
     * @return 所有的班表机构
     * @throws Exception
     */
    @Override
    public List<PrpDcompanyDto> queryPrpDcompanyByComCodePrivate(PrpDcompanyDto prpdDto) throws Exception {
        if(prpdDto==null){
            throw new DataVerifyException("请求数据不能为空！");
        }
        if(StringUtils.isEmpty(prpdDto.getComCode())){
            throw new DataVerifyException("机构不能为空!");
        }
        //原生sql
        StringBuilder condition= new StringBuilder("SELECT * from PrpDcompany where ");
        condition.append("companyflag = '1' And comCode In (Select Comcode From Prpdcompany Start With comCode =:comCode ");
        condition.append("Connect By Prior comCode = Uppercomcode And Prior Comcode != Comcode And Validstatus = '1')");
        Query nativeQuery = entityManager.createNativeQuery(condition.toString(),PrpDcompany.class);
        nativeQuery.setParameter("comCode",prpdDto.getComCode());
        List<PrpDcompany> resultList = nativeQuery.getResultList();
        List<PrpDcompanyDto> prpDcompanyDtoList=new ArrayList<>();
        convertCollection(resultList,prpDcompanyDtoList,PrpDcompanyDto.class);
        return prpDcompanyDtoList;
    }

    /**
     *（查询该机构及其下属机构）
     * @author: 孙朋飞
     * @date: 2017/12/12 17:41
     * @param comCode 班表机构
     * @return 机构代码集合
     * @throws Exception
     */
    @Override
    public List<String> queryPrpDcompanyByComCode(String comCode) throws Exception {
        return prpDcompanyDao.findPrpDcompanyByComCode(comCode);
    }

    /**
     * 机构树实现逻辑
     *
     * @param queryComCodeInfoDto 入参
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/27 下午 14:06
     */
    public List<CompanyListDto> queryCompanyTree(QueryComCodeInfoDto queryComCodeInfoDto) throws Exception {
        Long nn1=System.currentTimeMillis();
        String loginComCode = queryComCodeInfoDto.getLoginComCode();
        if (org.apache.commons.lang3.StringUtils.isEmpty(loginComCode)) {
            throw new DataVerifyException("登录机构代码不能为空");
        }
        String userCode = queryComCodeInfoDto.getUserCode();
        if (org.apache.commons.lang3.StringUtils.isEmpty(userCode)) {
            throw new DataVerifyException("用户代码不能为空");
        }
            AddCodePowerConditionDto conditionDto = new AddCodePowerConditionDto();
            conditionDto.setLoginComCode(loginComCode);
            conditionDto.setUserCode(userCode);
            conditionDto.setTableName("PrpDcompany");
            conditionDto.setUserCodeFields("userCode");
            conditionDto.setComCodeFields("comCode");
            conditionDto.setLoginGradeCodes("111");
        List<String> powerComCode = utiGroupService.getCodePowerList(conditionDto);
        Map<String, String> map = new HashMap<String, String>();
        Long n1=System.currentTimeMillis();
        List<CompanyListDto> companyListDtos = prpDcompanyDao.queryCompayTree();
        Long n2=System.currentTimeMillis();
        System.out.println((n2-n1)+" 毫秒 queryCompayTree");
        if((powerComCode==null || powerComCode.size()==0) && "0000000000".equals(loginComCode)){//管理员权限
           for(CompanyListDto companyListDto:companyListDtos){
               map.put(companyListDto.getComCode(), companyListDto.getComCode());
           }
        }else{
            for (String str : powerComCode) {
                map.put(str, str);
            }
        }

        List<String> list = queryComCodeInfoDto.getSelectList();
        Map<String, String> map1 = new HashMap<String, String>();
        if (list != null && list.size() > 0) {
            for (String str : list) {
                map1.put(str, str);
            }
        }
        Long n3=System.currentTimeMillis();
        List<CompanyListDto> dtoList = this.parseTree(companyListDtos, map, map1);
        System.out.println((n3-n2)+" 毫秒 parseTree");

        Long nn2=System.currentTimeMillis();
        System.out.println((nn2-nn1)+"毫秒 总时间");
        return dtoList;

    }

    //根据数据生成tree
    public List<CompanyListDto> parseTree(List<CompanyListDto> list, Map<String, String> map, Map<String, String> map1) {

        List<CompanyListDto> treeList = new ArrayList<>();

        //找出一级菜单
        for (CompanyListDto prpdCompany : list) {
            if (prpdCompany.getComCode().equals("0000000000")) {
                treeList.add(prpdCompany);
            }
        }

        for (CompanyListDto prpdCompany : treeList) {
            //获取子集
            List<CompanyListDto> childs = getChilds(list, prpdCompany.getComCode(), map, map1);
            prpdCompany.setChilds(childs);
            prpdCompany.setDisabled(true);
        }

        //输出结果
        //   String str = JSON.toJSONString(treeList);
        return treeList;
    }

    //获取子集
    public List<CompanyListDto> getChilds(List<CompanyListDto> list, String comcode, Map<String, String> map, Map<String, String> map1) {
        List<CompanyListDto> childs = new ArrayList<>();
        //获取子集
        for (CompanyListDto prpdCompany : list) {
            //查询子集的父id 并且自己不能等于自己
            String subComCode = prpdCompany.getComCode();
            boolean fals = map.containsKey(subComCode);
            if (!fals) {
                prpdCompany.setDisabled(true);

//                if (prpdCompany.getChilds() != null) {
//                    boolean flag=true;
//                    //判断子集是否全不可用
//                    for(CompanyListDto p:prpdCompany.getChilds()){
//                        if(!p.isDisabled()){
//                            flag=false;
//                            break;
//                        }
//                    }
//                    prpdCompany.setDisabled(flag);
//                }
//                if(prpdCompany.getChilds()==null){
//                    System.out.println(prpdCompany.getComCName() + "  " + 0 + " " + prpdCompany.isDisabled());
//                }else {
//                    System.out.println(prpdCompany.getComCName() + "  " + prpdCompany.getChilds().size() + " " + prpdCompany.isDisabled());
//                }
            }
            boolean flt = map1.containsKey(subComCode);
            if (flt) {
                prpdCompany.setChecked(true);
            }
            if (prpdCompany.getUpperComCode().equals(comcode) && !prpdCompany.getComCode().equals(comcode)) {
                childs.add(prpdCompany);
            }
        }

        for (CompanyListDto p : childs) {
            //递归获取子集
            List<CompanyListDto> prpdCompanies = getChilds(list, p.getComCode(), map, map1);
            p.setChilds(prpdCompanies);

        }
        if (childs.size() == 0) {
            return null;
        }

        return childs;
    }

    /**
     * 根据多个机构代码查询对应的名称
     *
     * @param comCodes 多个comCode的List
     * @return comCode -> comCName 的键值对
     * @author: 何伟东
     * @date: 2017/12/21 11:56
     */
    @Override
    public Map<String, String> queryComCNameByComCodes(List<String> comCodes) {
        if (comCodes == null || comCodes.size() < 0) {
            throw new DataVerifyException("机构代码不能为空！");
        }
        StringBuilder dateSql = new StringBuilder("SELECT c FROM PrpDcompany c WHERE c.comCode in (:comCode)");
        Query dataQuery = entityManager.createQuery(dateSql.toString());
        dataQuery.setParameter("comCode", comCodes);
        List<PrpDcompany> resultList = dataQuery.getResultList();
        Map<String, String> returnMap = new HashMap<>();
        if (resultList != null && resultList.size() > 0) {
            resultList.forEach(prpDcompany ->
                    returnMap.put(prpDcompany.getComCode(), prpDcompany.getComCName())
            );
        }
        return returnMap;
    }

    /**
     * 根据机构代码查询该机构的直接子级机构
     *
     * @param comCode 机构代码
     * @return 该机构的所有有效子机构信息
     * @author: 何伟东
     * @date: 2018/1/6 15:04
     */
    @Override
    public List<SubComDto> querySubComInfo(String comCode) {
        if (StringUtils.isEmpty(comCode)) {
            throw new DataVerifyException("机构代码不能为空");
        }
        List<PrpDcompany> prpDcompanies = prpDcompanyDao.querySubComInfo(comCode);
        if (prpDcompanies == null || prpDcompanies.size() < 1) {
            throw new BusinessException(comCode + "机构没有子机构");
        }
        List<SubComDto> subComDtos = new ArrayList<>();
        convertCollection(prpDcompanies,subComDtos,SubComDto.class);
        return subComDtos;
    }
    /**
     * 查询核算单位下的政策性农险机构的下的有效机构，Flag =’1’时校验的是归属机构不可选择中支公司
     Flag =’2’时，校验的是归属机构为政策性农险部时，政策/商业标志应选择“中央政策性
     * @param comCode 归属机构代码
     * @return 机构信息集合
     * @author: 田健
     * @date: 2018/1/6 15:04
     * @throws Exception
     */
    @Override
    public Boolean CheckBusinessComCodeInfo(String comCode, String flag) throws Exception {
        Boolean value = false;
        List<PrpDcompany> prpDcompanyList = prpDcompanyDao.CheckBusinessComCodeInfo(comCode,flag);
        if(prpDcompanyList.size()>0){
            value =true;
        }
        return value;
    }
    /**
     * 
      * @description 调度页面查询查勘调度双击域
      * @author yk
      * @date 2017年12月22日 上午10:18:26
     *  @param type ，里面有查询机构的种类
     *  @param upperComCode ，里面有查询机构的种类
      * @return DTreeDto树状对象
     */
	@Override
	public List<DTreeDto> queryUnit(String type,String upperComCode) {
        UserInfo userinfo = SinoRequestContext.getCurrentContext().getUser();
        if ("00000000".equals(upperComCode)){
            upperComCode = userinfo.getLoginComCode();
        }
		List<PrpDcompany> prpDcompanyList = null;
		if("checkOrLoss".equals(type)){
		prpDcompanyList = prpDcompanyDao.findCheckAndLossUnit(upperComCode);
		}else if("schedule".equals(type)){
		prpDcompanyList = prpDcompanyDao.findScheduleUnit(upperComCode);
		}
		int size = prpDcompanyList.size();
		List<DTreeDto> trees = new ArrayList<>();
		List<DTreeDto> childtrees = new ArrayList<>();
        if(upperComCode.equals(userinfo.getLoginComCode())){
            PrpDcompanyKey prpDcompanyKey = new PrpDcompanyKey(upperComCode);
            PrpDcompany prpDcompanyUser = prpDcompanyDao.findOne(prpDcompanyKey);
            DTreeDto dTreeDtoUser = new DTreeDto();
            dTreeDtoUser.setId(prpDcompanyUser.getComCode());
            dTreeDtoUser.setParentId(prpDcompanyUser.getUpperComCode());
            dTreeDtoUser.setName(prpDcompanyUser.getComCName());
            trees.add(dTreeDtoUser);
        }
		for(int i = 0 ; i < size ; i++){
			List<PrpDcompany> prpDcompanyChildList= new ArrayList<>();
			DTreeDto dTreeDto = new DTreeDto();
			dTreeDto.setId(prpDcompanyList.get(i).getComCode());
			dTreeDto.setParentId(prpDcompanyList.get(i).getUpperComCode());
			dTreeDto.setName(prpDcompanyList.get(i).getComCName());
			if("checkOrLoss".equals(type)){
				prpDcompanyChildList = prpDcompanyDao.findCheckAndLossUnit(prpDcompanyList.get(i).getComCode());
				}else if("schedule".equals(type)){
					prpDcompanyChildList = prpDcompanyDao.findScheduleUnit(prpDcompanyList.get(i).getComCode());
				}
			if(prpDcompanyChildList!=null && prpDcompanyChildList.size()>0){
				dTreeDto.setChildList(childtrees);
			}
			trees.add(dTreeDto);
		}
		
//		List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<>();
//		convertCollection(prpDcompanyList, prpDcompanyDtoList, PrpDcompanyDto.class);
//		List<DTreeDto> trees = new ArrayList<>();
//		for(PrpDcompanyDto prpDcompanyDto : prpDcompanyDtoList){
//			DTreeDto dTreeDto = new DTreeDto();
//			dTreeDto.setId(prpDcompanyDto.getComCode());
//			dTreeDto.setParentId(prpDcompanyDto.getUpperComCode());
//			dTreeDto.setName(prpDcompanyDto.getComCName());
//			trees.add(dTreeDto);
//		}
//		DTreeDto dTreeDto = new DTreeDto();
//		String parentId = upperComCode;
//		int level = -1 ;
//		dTreeDto =  getAllChild(dTreeDto,parentId,trees,level);
		return trees;
	}
	
	/**
	 * 
	  * @description 得到树状对象dTreeDto
	  * @author yk
	  * @date 2017年12月22日 上午10:20:37
	  * @param  dTreeDto 最开始的树状树状对象, id父节点id, trees待遍历的所有节点
	  * @return 树状对象dTreeDto
	 */
	public DTreeDto getAllChild(DTreeDto dTreeDto,String id,List<DTreeDto> trees,int level){
		List<DTreeDto> childList = findChild(id , trees);
			dTreeDto.setChildList(childList);
			dTreeDto.setLevel(++level);
			for( int i = 0 ; i < dTreeDto.getChildList().size() ; i++ ){ 
				DTreeDto dTreeDtox = dTreeDto.getChildList().get(i);
            getAllChild(dTreeDtox,dTreeDtox.getId(),trees,level); 
            if(i == dTreeDto.getChildList().size() - 1){
            	level--;
            }
        }
        return dTreeDto;
    }


	/**
	 *  
	  * @description 根据父节点id得到所有子节点
	  * @author yk
	  * @date 2017年12月22日 上午10:23:08
     *  @param id id父节点id, trees待遍历的所有节点
     *  @param trees id父节点id, trees待遍历的所有节点
	  * @return 子节点集合
	 */
	public List<DTreeDto> findChild(String id, List<DTreeDto> trees) {
		List<DTreeDto> childList = new ArrayList<>();
		for(DTreeDto dTreeDto : trees){
			if(dTreeDto.getParentId().equals(id)){
				childList.add(dTreeDto);
			}
		}
		return childList;
	}
    /**
     *
     * @description 根据机构代码查询模糊查询和机构级别查询
     * @author 周柯宇
     * @date 2018年1月18日 下午3:27:03
     * @param
     * @return List<PrpDcompanyDto>
     * @Throws Exception
     */
    @Override
    public List<PrpDcompanyDto> queryLikeComcodeAndComlevel(String comCode, String comLevel) throws Exception {
        if (StringUtils.isEmpty(comCode)) {
            throw new DataVerifyException("机构代码不能为空");
        }
        if (StringUtils.isEmpty(comLevel)) {
            throw new DataVerifyException("机构级别不能为空");
        }
        List<PrpDcompany> prpDcompanyList = prpDcompanyDao.findByComCodeStartingWithAndComLevel(comCode.substring(0,2),comLevel);
        List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<PrpDcompanyDto>();
        this.convertCollection(prpDcompanyList, prpDcompanyDtoList, PrpDcompanyDto.class);
        return prpDcompanyDtoList;
    }

    /**
     * 根据机构名称查询机构代码
     * @author 刘曼曼
     * @date 2018年3月1日 下午15:46:03
     * @param comCName 机构名称
     * @return List<PrpDcompanyDto>
     * @throws Exception
     */
    @Override
    public  List<PrpDcompanyDto> queryComCode(String comCName)throws Exception{
        if (StringUtils.isEmpty(comCName)) {
            throw new DataVerifyException("机构名称不能为空");
        }
        List<PrpDcompany> prpDcompanyList = prpDcompanyDao.findAllByComCName(comCName);
        List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<PrpDcompanyDto>();
        this.convertCollection(prpDcompanyList, prpDcompanyDtoList, PrpDcompanyDto.class);
        return prpDcompanyDtoList;
    }

    /**
     * 查询指定机构的所有子级机构
     *
     * @param comCode - 机构代码
     * @author: 何伟东
     * @date: 2018/4/23 15:49
     */
    @Override
    public List<PrpDcompanyDto> querySubordinateCompany(String comCode) throws Exception {
        if (StringUtils.isEmpty(comCode)) {
            throw new DataVerifyException("机构代码不能为空!");
        }
        //拼接遍历循环查询该机构下所有子机构信息集合
        StringBuilder sql = new StringBuilder(" select  *  from PrpDcompany where validStatus = '1'");
        StringBuilder strWhere = new StringBuilder();
        strWhere.append(" start with comCode = :comCode" + " connect by upperComCode = prior comCode " +
                "and prior comCode != comCode ");
        Query dataQuery = entityManager.createNativeQuery(sql.append(strWhere).toString(), PrpDcompany.class);
        dataQuery.setParameter("comCode", comCode);
        List<PrpDcompany> prpDcompanies = dataQuery.getResultList();
        List<PrpDcompanyDto> prpDcompanyDtos = new ArrayList<>();
        convertCollection(prpDcompanies, prpDcompanyDtos, PrpDcompanyDto.class);
        return prpDcompanyDtos;
    }
}