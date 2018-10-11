package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDkindItemDto;
import com.sinosoft.pms.api.kernel.dto.QueryItemCodePmsDto;
import com.sinosoft.pms.core.kernel.dao.PrpDkindItemDao;
import com.sinosoft.pms.core.kernel.entity.PrpDkindItem;
import com.sinosoft.pms.core.kernel.entity.PrpDkindItemKey;
import com.sinosoft.pms.core.kernel.service.PrpDkindItemService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
 * @description PrpDkindItemCore接口实现
 */
@Service
public class PrpDkindItemServiceImpl extends BaseCustomServiceImpl implements  PrpDkindItemService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDkindItemServiceImpl.class);
    
    @Autowired
    private PrpDkindItemDao prpDkindItemDao;
    @PersistenceContext
    private EntityManager entityManager;
    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDkindItemDto prpDkindItemDto) {
        PrpDkindItem prpDkindItem = this.convert(prpDkindItemDto, PrpDkindItem.class);
        prpDkindItemDao.save(prpDkindItem);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String riskCode,String kindCode,String itemCode) {
        PrpDkindItemKey prpDkindItemKey = new PrpDkindItemKey(riskCode,kindCode,itemCode);
        prpDkindItemDao.delete(prpDkindItemKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDkindItemDto prpDkindItemDto) {
        PrpDkindItem prpDkindItem = this.convert(prpDkindItemDto, PrpDkindItem.class);
        prpDkindItemDao.save(prpDkindItem);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDkindItemDto queryByPK(String riskCode,String kindCode,String itemCode) {
        PrpDkindItemKey prpDkindItemKey = new PrpDkindItemKey(riskCode,kindCode,itemCode);
        PrpDkindItem prpDkindItem = prpDkindItemDao.findOne(prpDkindItemKey);
        return this.convert(prpDkindItem,PrpDkindItemDto.class);
    }
    /**
     * * 根据险种代码和险别代码查询标的代码
     * @author: 田慧
     * *@param queryItemCodePmsDto  险种代码和险别代码
     * @date: 13:22
     * @return itemCodeList 标的代码集合
     */
    public List<String> queryItemCode(String riskCode,List<String> kindCodeList)throws Exception{
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空！");
        }
       if (kindCodeList.size()==0){
           throw new DataVerifyException("险别代码不能为空！");
       }
//       String strwhere="";
//       int i=0;
//       for( String str :kindCodeList){
//           ++i;
//           if(i==1){
//               strwhere+=("'"+str+"'");
//           }else{
//               strwhere+=(","+"'"+str+"'");
//           }
//       }
       Map<String,Object> paraMap=new HashMap<String,Object>();
        StringBuilder strWhere = new StringBuilder();
       StringBuilder sql=new StringBuilder("select pp.itemCode from PrpDkindItem pp ");
        strWhere.append(" where pp.riskCode=:riskCode");
        paraMap.put("riskCode",riskCode);
        strWhere.append(" and pp.kindCode in :strwhere");
        paraMap.put("strwhere",kindCodeList);
        sql.append(strWhere);
        Query dataResult = entityManager.createQuery(sql.toString());
        this.setQueryParam(dataResult,paraMap);
        List<String> prpDkindItemList = dataResult.getResultList();
//       List<Object> itemCodeList = prpDkindItemDao.queryItemCode(riskCode,kindCodeList);
       return prpDkindItemList;
    }

    /**
     * 根据险别和险种及标的代码查询险别标的关联表
     * @author: 刘曼曼
     * @date: 10:29 10:29
     * @param riskCode 险种代码
     * @param kindCodes 险别代码
     * @param itemCodes 标的代码
     * @return List<PrpDkindItem> 询险别标的关联表集合
     */
    @Override
    public List<PrpDkindItemDto> queryFlag(String riskCode, List<String> kindCodes, List<String> itemCodes)throws Exception{

        if(StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("险种代码不能为空！");
        }
        if(kindCodes==null || kindCodes.size()==0){
            throw new DataVerifyException("险别代码不能为空！");
        }
        if(itemCodes==null || itemCodes.size()==0){
            throw new DataVerifyException("标的代码不能为空！");
        }

        List<PrpDkindItem>  prpDkindItemList =prpDkindItemDao.findByRiskCodeAndKindCodeAndItemCode(riskCode,kindCodes,itemCodes);
        List<PrpDkindItemDto> prpDkindItemDtoList= new ArrayList<PrpDkindItemDto>();
        if(prpDkindItemList!=null && prpDkindItemList.size()>0){
            convertCollection(prpDkindItemList,prpDkindItemDtoList,PrpDkindItemDto.class);
        }
        return prpDkindItemDtoList;
    }
}