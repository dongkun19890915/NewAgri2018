package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31InsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingInsuranceListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.Planting31InsuranceListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.PlantingInsuranceListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.specification.plantinginsurancelistSpecBuilder;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31InsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31InsuranceListKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingInsuranceListKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.Planting31InsuranceListService;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingInsuranceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178 
 * @description 投保明细表Core接口实现
 */
@Service
public class Planting31InsuranceListServiceImpl extends BaseCustomServiceImpl implements Planting31InsuranceListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(Planting31InsuranceListServiceImpl.class);

    @Autowired
    private Planting31InsuranceListDao planting31InsuranceListDao;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(Planting31InsuranceListDto planting31InsuranceListDto) {
        Planting31InsuranceList planting31InsuranceList = this.convert(planting31InsuranceListDto, Planting31InsuranceList.class);
        planting31InsuranceListDao.save(planting31InsuranceList);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String inusreListCode, String itemCode, String kindCode,String fIdCard){
        Planting31InsuranceListKey planting31InsuranceListKey = new Planting31InsuranceListKey(inusreListCode,itemCode,kindCode,fIdCard);
        planting31InsuranceListDao.delete(planting31InsuranceListKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(Planting31InsuranceListDto planting31InsuranceListDto) {
        Planting31InsuranceList planting31InsuranceList = this.convert(planting31InsuranceListDto, Planting31InsuranceList.class);
        planting31InsuranceListDao.save(planting31InsuranceList);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public Planting31InsuranceListDto queryByPK(String inusreListCode, String itemCode, String kindCode,String fIdCard){
        Planting31InsuranceListKey planting31InsuranceListKey = new Planting31InsuranceListKey(inusreListCode,itemCode,kindCode,fIdCard);
        Planting31InsuranceList planting31InsuranceList = planting31InsuranceListDao.findOne(planting31InsuranceListKey);
        return this.convert(planting31InsuranceList,Planting31InsuranceListDto.class);
    }
    /**
     * @description:（根据inusreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:57
     * @param inusreListCode
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeByInusreListcode(String inusreListCode) {
        planting31InsuranceListDao.removeByInusreListCode(inusreListCode);
    }
    /**
     * @description:（批量保存）
     * @author: 田健
     * @date: 2017/10/20 11:55
     * @param planting31InsuranceListDtoList 大棚蔬菜集合
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveByList(List<Planting31InsuranceListDto> planting31InsuranceListDtoList){
        List<Planting31InsuranceList> listPlanting31InsuranceList = new ArrayList<Planting31InsuranceList>();
        this.convertCollection(planting31InsuranceListDtoList,listPlanting31InsuranceList,Planting31InsuranceList.class);
        planting31InsuranceListDao.save(listPlanting31InsuranceList);
    }

    /**
     * @description:（根据inusreListCode查询Planting31InsuranceList）
     * @author: 田健
     * @date: 2017/10/20 11:55
     * @param inusreListCode
     * @return List<Planting31InsuranceListDto>
     */
    @Override
    public List<Planting31InsuranceListDto> queryByInusreListCode (String inusreListCode){
        List<Planting31InsuranceList> planting31InsuranceLists = new ArrayList<>();
        List<Planting31InsuranceListDto> planting31InsuranceListDtoList = new ArrayList<>();
        planting31InsuranceLists =planting31InsuranceListDao.findByInusreListCode(inusreListCode);
        this.convertCollection(planting31InsuranceLists,planting31InsuranceListDtoList,Planting31InsuranceListDto.class);
        return planting31InsuranceListDtoList;
    }
}