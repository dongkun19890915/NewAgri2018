package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDItemRequestParamsDto;
import com.sinosoft.pms.api.kernel.dto.PrpDitemDto;
import com.sinosoft.pms.core.kernel.dao.PrpDitemDao;
import com.sinosoft.pms.core.kernel.dao.PrpDkindItemDao;
import com.sinosoft.pms.core.kernel.entity.PrpDitem;
import com.sinosoft.pms.core.kernel.entity.PrpDitemKey;
import com.sinosoft.pms.core.kernel.service.PrpDitemService;
import com.sinosoft.pms.core.kernel.util.BasePrpDItemServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-04 10:42:46.546
 * @description 标的项目代码表Core接口实现
 */
@Service
public class PrpDitemServiceImpl extends BasePrpDItemServiceImpl implements PrpDitemService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDitemServiceImpl.class);

    @Autowired
    private PrpDitemDao prpDitemDao;
    @Autowired
    private PrpDkindItemDao prpDkindItemDao;
    private String validStatus="1";
    @Autowired
    private PrpDitemDao prpDItemDao;
    @Autowired
    private PrpDkindItemDao prpDKindItemDao;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * @param
     * @description 新增
     */
    @Override
    public void save(PrpDitemDto prpDitemDto) {
        PrpDitem prpDitem = this.convert(prpDitemDto, PrpDitem.class);
        prpDitemDao.save(prpDitem);
    }

    /**
     * @param
     * @description 删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String riskCode, String itemCode) {
        PrpDitemKey prpDitemKey = new PrpDitemKey(riskCode, itemCode);
        prpDitemDao.delete(prpDitemKey);
    }

    /**
     * @param
     * @description 修改
     */
    @Override
    public void modify(PrpDitemDto prpDitemDto) {
        PrpDitem prpDitem = this.convert(prpDitemDto, PrpDitem.class);
        prpDitemDao.save(prpDitem);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    @Override
    public PrpDitemDto queryByPK(String riskCode, String itemCode) {
        PrpDitemKey prpDitemKey = new PrpDitemKey(riskCode, itemCode);
        PrpDitem prpDitem = prpDitemDao.findOne(prpDitemKey);
        return this.convert(prpDitem, PrpDitemDto.class);
    }

    /**
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     * @description:（查询主险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     */

    @Override
    public List<PrpDitemDto> queryMainUnderlyingTypeByCondition(PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception {

        String strRiskCode = prpDItemRequestParamsDto.getRiskCode();
        //1.校验请求参数
        if (StringUtils.isEmpty(strRiskCode)) {
            throw new DataVerifyException("险种代码不能为空!");
        }
        //2.原生SQL
        StringBuilder Sql = new StringBuilder("SELECT p from PrpDitem p where (p.riskCode= :strRiskCode OR p.riskCode='0000') AND p.validStatus= :validStatus ORDER BY p.itemCode");
        //根据险别拼写关联责任条件 add by guolei 2006-11-13  end
        System.out.print(Sql.toString());
        //4.根据条件进行查询
        javax.persistence.Query dataQuery = entityManager.createQuery(Sql.toString());
        dataQuery.setParameter("strRiskCode", strRiskCode);
        dataQuery.setParameter("validStatus", validStatus);
        List<PrpDitem> list = dataQuery.getResultList();
        //5.往响应Dto里存值并添加发哦集合中,(数组的位置要与数据库里的位置对应)
        List<PrpDitemDto> arraylist = new ArrayList<PrpDitemDto>();
        if (list != null && list.size() > 0) {
            convertCollection(list, arraylist, PrpDitemDto.class);
        }
        return arraylist;
    }


    /**
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     * @description:（查询附加险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     */
    @Override
    public List<PrpDitemDto> querySubUnderlyingTypeByCondition(PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception {
        String strRiskCode = prpDItemRequestParamsDto.getRiskCode();
        //1.校验请求参数
        if (StringUtils.isEmpty(strRiskCode)) {
            throw new DataVerifyException("险种代码不能为空!");
        }
        //2、定义sql查询语句
        StringBuilder Sql = new StringBuilder(" SELECT p from PrpDitem p where ");
        //3.定义条件参数集合
        Map<String, Object> paraMap = new HashMap<String, Object>();
        //4.拼接查询条件
        Sql.append(" (p.riskCode= :riskCode or p.riskCode= '0000' ) and p.validStatus= :validstatus ");
        paraMap.put("riskCode", strRiskCode);
        paraMap.put("validstatus", validStatus);
        //根据险别拼写关联责任条件 add by guolei 2006-11-13  end
        Sql.append(" ORDER BY p.itemCode ");
        System.out.print(Sql);
        //5.创建查询对象
        javax.persistence.Query dataQuery = entityManager.createQuery(Sql.toString());
        //6.设置参数
        this.setQueryParam(dataQuery, 1, 100, paraMap);
        //7.获得查询结果
        List<PrpDitem> list = dataQuery.getResultList();
        //8.往响应Dto里存值并添加发哦集合中,(数组的位置要与数据库里的位置对应)
        List<PrpDitemDto> arraylist = new ArrayList<PrpDitemDto>();
        if (list != null && list.size() > 0) {
            for (PrpDitem prpDItem : list) {
                PrpDitemDto prpDItemDto = new PrpDitemDto();
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
     *
     * @param riskCode 险种代码
     * @param itemCode 标的代码
     * @return PrpDitem 标的项目代码表信息
     */
    public String queryItemName(String riskCode, String itemCode) throws Exception {
        String itemName = prpDItemDao.findByRiskCodeAndItemCName(riskCode, itemCode);
        return itemName;
    }

    /**
     * 根据险种查询prpditem表
     *
     * @param riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    public List<PrpDitemDto> queryPrpDitemInfoDto(String riskCode, String kindCode) throws Exception {
        List<String> itemCodeList = prpDkindItemDao.findByRiskCodeAndKindCode(riskCode, kindCode);
        List<PrpDitem> prpDitemList = null;
        if (itemCodeList.size() == 0) {
            prpDitemList = prpDitemDao.findByRiskCode(riskCode);
        } else {
            prpDitemList = prpDitemDao.queryByItemCodes(riskCode, itemCodeList);
        }
        List<PrpDitemDto> prpDitemDtoList = new ArrayList<>();
        convertCollection(prpDitemList, prpDitemDtoList, PrpDitemDto.class);
        return prpDitemDtoList;
    }

    /**
     * 根据标的名称查询标的代码
     *
     * @param itemCName 标的名称
     * @return itemCode的集合
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/22 11:12
     */
    @Override
    public List<String> queryItemCode(String itemCName) throws Exception {
        return prpDitemDao.queryItemCode(itemCName);
    }

    /**
     * 根据险种代码和多个标的代码查询标的中文名称
     *
     * @param riskCode  险种代码
     * @param itemCodes 标的代码
     * @return 标的代码-标的名称
     * @author: 何伟东
     * @date: 2018/1/11 19:29
     */
    @Override
    public Map<String, String> queryByItemCodes(String riskCode, List<String> itemCodes) {
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空");
        }
        if (itemCodes == null || itemCodes.size() < 1) {
            throw new DataVerifyException("标的代码不能为空");
        }
        Map<String, String> returnMap = new HashMap<>();
        List<PrpDitem> prpDitems = prpDitemDao.queryByItemCodes(riskCode, itemCodes);
        prpDitems.forEach(prpDitem -> returnMap.put(prpDitem.getItemCode(), prpDitem.getItemCName()));
        return returnMap;
    }

    /**
     * 根据险种代码查询对应的标的信息
     *
     * @param riskCode 险种代码
     * @return 标的代码-标的名称
     * @author: 何伟东
     * @date: 2018/1/11 19:29
     */
    @Override
    public List<PrpDitemDto> queryByRiskCode(String riskCode) {
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空");
        }
        List<PrpDitem> prpDitems = prpDitemDao.queryByRiskCode(riskCode);
        List<PrpDitemDto> prpDitemDtos = new ArrayList<>();
        convertCollection(prpDitems, prpDitemDtos, PrpDitemDto.class);
        return prpDitemDtos;
    }
}