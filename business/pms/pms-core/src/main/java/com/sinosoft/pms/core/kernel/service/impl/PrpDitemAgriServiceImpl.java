package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDItemRequestParamsDto;
import com.sinosoft.pms.api.kernel.dto.PrpDitemAgriDto;
import com.sinosoft.pms.core.kernel.dao.PrpDitemAgriDao;
import com.sinosoft.pms.core.kernel.dao.PrpDitemDao;
import com.sinosoft.pms.core.kernel.dao.PrpDkindItemDao;
import com.sinosoft.pms.core.kernel.entity.PrpDitem;
import com.sinosoft.pms.core.kernel.entity.PrpDitemAgri;
import com.sinosoft.pms.core.kernel.entity.PrpDitemAgriKey;
import com.sinosoft.pms.core.kernel.service.PrpDitemAgriService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @time  2017-11-04 10:42:46.546 
 * @description 标的项目代码表Core接口实现
 */
@Service
public class PrpDitemAgriServiceImpl extends BaseCustomServiceImpl implements PrpDitemAgriService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDitemAgriServiceImpl.class);
    
    @Autowired
    private PrpDitemAgriDao prpDitemAgriDao;
    @Autowired
    private PrpDitemDao prpDitemDao;
    private String validStatus="1";
    @Autowired
    private PrpDitemDao prpDItemDao;
    @Autowired
    private PrpDkindItemDao prpDkindItemDao;
    @PersistenceContext
    private EntityManager entityManager;


    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDitemAgriDto prpDitemAgriDto) {
        PrpDitemAgri prpDitemAgri = this.convert(prpDitemAgriDto, PrpDitemAgri.class);
        prpDitemAgriDao.save(prpDitemAgri);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String riskCode,String itemCode) {
        PrpDitemAgriKey prpDitemAgriKey = new PrpDitemAgriKey(riskCode,itemCode);
        prpDitemAgriDao.delete(prpDitemAgriKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDitemAgriDto prpDitemAgriDto) {
        PrpDitemAgri prpDitemAgri = this.convert(prpDitemAgriDto, PrpDitemAgri.class);
        prpDitemAgriDao.save(prpDitemAgri);
    }
    /**
     *@description 按主键查询实体
     * @param
     */
    @Override
    public PrpDitemAgriDto queryByPK(String riskCode, String itemCode) {
        PrpDitemAgriKey prpDitemAgriKey = new PrpDitemAgriKey(riskCode,itemCode);
        PrpDitemAgri prpDitemAgri = prpDitemAgriDao.findOne(prpDitemAgriKey);
        return this.convert(prpDitemAgri,PrpDitemAgriDto.class);

    }

    /**
     * @description:（查询主险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     */

    @Override
    public List<PrpDitemAgriDto> queryMainUnderlyingTypeByCondition(PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception{

        String strRiskCode = prpDItemRequestParamsDto.getRiskCode();
        //1.校验请求参数
        if (StringUtils.isEmpty(strRiskCode)) {
            throw new DataVerifyException("险种代码不能为空!");
        }
        //2.原生SQL
        StringBuilder Sql = new StringBuilder("SELECT p from PrpDitemAgri p where (p.riskCode= :strRiskCode OR p.riskCode='0000') AND p.validStatus= :validStatus ORDER BY p.itemCode");
        //根据险别拼写关联责任条件 add by guolei 2006-11-13  end
        System.out.print(Sql.toString());
        //4.根据条件进行查询
        javax.persistence.Query dataQuery = entityManager.createQuery(Sql.toString());
        dataQuery.setParameter("strRiskCode",strRiskCode);
        dataQuery.setParameter("validStatus",validStatus);
        List<PrpDitemAgri> list = dataQuery.getResultList();
        //5.往响应Dto里存值并添加发哦集合中,(数组的位置要与数据库里的位置对应)
        List<PrpDitemAgriDto> arraylist = new ArrayList<PrpDitemAgriDto>();
        if (list != null && list.size() > 0) {
            convertCollection(list,arraylist,PrpDitemAgriDto.class);
        }
        return arraylist;
    }



    /**
     * @description:（查询附加险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     */
    @Override
    public List<PrpDitemAgriDto> querySubUnderlyingTypeByCondition(PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception{
        String strRiskCode = prpDItemRequestParamsDto.getRiskCode();
        //1.校验请求参数
        if (StringUtils.isEmpty(strRiskCode)) {
            throw new DataVerifyException("险种代码不能为空!");
        }
        //2、定义sql查询语句
        StringBuilder Sql=new StringBuilder(" SELECT p from PrpDitem p where ");
        //3.定义条件参数集合
        Map<String,Object> paraMap=new HashMap<String,Object>();
        //4.拼接查询条件
        Sql.append(" (p.riskCode= :riskCode or p.riskCode= '0000' ) and p.validStatus= :validstatus ");
        paraMap.put("riskCode",strRiskCode);
        paraMap.put("validstatus",validStatus);
        //根据险别拼写关联责任条件 add by guolei 2006-11-13  end
        Sql.append(" ORDER BY p.itemCode ");
        System.out.print(Sql);
        //5.创建查询对象
        javax.persistence.Query dataQuery = entityManager.createQuery(Sql.toString());
        //6.设置参数
        this.setQueryParam(dataQuery,1,100,paraMap);
        //7.获得查询结果
        List<PrpDitem> list = dataQuery.getResultList();
        //8.往响应Dto里存值并添加发哦集合中,(数组的位置要与数据库里的位置对应)
        List<PrpDitemAgriDto> arraylist = new ArrayList<PrpDitemAgriDto>();
        if (list != null && list.size() > 0) {
            for (PrpDitem prpDItem : list) {
                PrpDitemAgriDto prpDItemDto = new PrpDitemAgriDto();
                prpDItemDto.setItemCode(prpDItem.getItemCode());
                prpDItemDto.setItemCName(prpDItem.getItemCName());
                prpDItemDto.setItemEName(prpDItem.getItemEName());
                arraylist.add(prpDItemDto);
            }
        }
        return arraylist;

    }

    /**
     * 根据险种和标的代码查询标的名称
     * @param riskCode 险种代码
     * @param itemCode 标的代码
     * @return PrpDitem 标的项目代码表信息
     */
    @Override
    public String queryItemName(String riskCode,String itemCode )throws Exception{
        String itemName= prpDitemAgriDao.findByRiskCodeAndItemCName(riskCode,itemCode);
        return itemName;
    }

    /**
     * 根据险种查询prpditem表
     * @param riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    @Override
    public List<PrpDitemAgriDto> queryPrpDitemInfoDto(String riskCode,String kindCode)throws Exception{
        List<String> itemCodeList = prpDkindItemDao.findByRiskCodeAndKindCode(riskCode,kindCode);
        List<PrpDitem> prpDitemList = null;
        if(itemCodeList.size()==0){
            prpDitemList=prpDitemDao.findByRiskCode(riskCode);
        }else{
            prpDitemList=prpDitemDao.queryByItemCodes(riskCode,itemCodeList);
        }
        List<PrpDitemAgriDto> prpDitemDtoList=new ArrayList<>();
        convertCollection(prpDitemList,prpDitemDtoList,PrpDitemAgriDto.class);
        return prpDitemDtoList;
    }
    /**
     *  根据标的名称查询标的代码
     * @author: 田慧
     * @date: 2017/12/22 11:12
     * @param itemCName 标的名称
     * @return itemCode的集合
     * @throws Exception
     */
    @Override
    public  List<String> queryItemCode(String itemCName)throws Exception{
        return prpDitemAgriDao.queryItemCode(itemCName);
    }
    /**
     * 根据险种查询prpditem表
     * @param  map riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    public Map<String, String> queryPrpDitemDto(Map<String, String> map) throws Exception {
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(map.get("riskCode"))) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        List<PrpDitemAgri> prpDitemAgriList = prpDitemAgriDao.queryByRiskinfo(map.get("riskCode"));
        Map<String, String> map1 = new HashMap<>();
        if (prpDitemAgriList != null && prpDitemAgriList.size() > 0) {
            for (PrpDitemAgri prpDitemAgri : prpDitemAgriList) {
                map1.put(prpDitemAgri.getItemCode(), prpDitemAgri.getItemCName());
            }
        } else {
            throw new DataVerifyException("险种代码无对应标的！");
        }

        return map1;
    }

    /**
     * * 根据险种代码和标的代码查询标的名称
     * @author: 田慧
     * @date: 15:29
     * @param  riskCode,itemCodeList 险种代码和标的代码集合
     * @return itemNameList 标的名称集合
     * @throws Exception
     */
    @Override
    public List<PrpDitemAgriDto> queryItemName(String riskCode, List<String> itemCodeList)throws Exception{
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        if (itemCodeList.size()==0){
            throw new DataVerifyException("标的代码不能为空！");
        }
        Map<String,Object> paraMap=new HashMap<String,Object>();
        StringBuilder strWhere = new StringBuilder();
        StringBuilder sql=new StringBuilder("select pp from PrpDitemAgri pp ");
        strWhere.append(" where pp.riskCode=:riskCode");
        paraMap.put("riskCode",riskCode);
        strWhere.append(" and pp.itemCode in :itemCodeList");
        paraMap.put("itemCodeList",itemCodeList);
        sql.append(strWhere);
        Query dataResult = entityManager.createQuery(sql.toString());
        this.setQueryParam(dataResult,paraMap);
        List<PrpDitemAgri> prpDkindItemList = dataResult.getResultList();
        List<PrpDitemAgriDto> prpDitemAgriDtoList = new ArrayList<>();
        this.convertCollection(prpDkindItemList,prpDitemAgriDtoList,PrpDitemAgriDto.class);
        return prpDitemAgriDtoList;
    }

}