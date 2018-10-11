package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdInsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.MiddleHerdInsuranceListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.MiddleHerdInsuranceListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.MIddleHerdInsuranceListKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.MiddleHerdInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.MiddleHerdInsuranceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * @description 投保明细表Core接口实现
 */
@Service
public class MiddleHerdInsuranceListServiceImpl extends BaseServiceImpl implements MiddleHerdInsuranceListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MiddleHerdInsuranceListServiceImpl.class);
    @Autowired
    private MiddleHerdInsuranceListDao middleHerdInsuranceListDao;
    /**
     * @description:（根据inusreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:57
     * @param inusreListCode 清单编号
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeByInusreListcode(String inusreListCode) {
        middleHerdInsuranceListDao.removeByInusreListCode(inusreListCode);
    }
    /**
     * 批量保存清单信息
     * @author: 田健
     * @date: 2018/3/7 17:30
     * @param middleHerdInsuranceListDtoList 不带耳标号的清单信息，到农户
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveByList(List<MiddleHerdInsuranceListDto> middleHerdInsuranceListDtoList) {
        List<MiddleHerdInsuranceList> middleHerdInsuranceLists = new ArrayList<MiddleHerdInsuranceList>();
        this.convertCollection(middleHerdInsuranceListDtoList,middleHerdInsuranceLists,MiddleHerdInsuranceList.class);
        middleHerdInsuranceListDao.save(middleHerdInsuranceLists);
    }
    /**
     * 保存
     * @author: 田健
     * @date: 2018/3/19 12:02
     * @param middleHerdInsuranceListDto 养殖险Dto
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(MiddleHerdInsuranceListDto middleHerdInsuranceListDto) {
        MiddleHerdInsuranceList middleHerdInsuranceList = this.convert(middleHerdInsuranceListDto, MiddleHerdInsuranceList.class);
        middleHerdInsuranceListDao.save(middleHerdInsuranceList);
    }
    /**
     *根据主键删除
     * @author: 田健
     * @date: 2018/3/19 14:13
     * @param inusreListCode 清单编号
     * @param fCode 农户代码
     * @param kindCode 险别代码
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String inusreListCode, String fCode, String kindCode) {
        MIddleHerdInsuranceListKey mIddleHerdInsuranceListKey = new MIddleHerdInsuranceListKey(inusreListCode,fCode,kindCode);
        middleHerdInsuranceListDao.delete(mIddleHerdInsuranceListKey);
    }
    /**
     *修改
     * @author: 田健
     * @date: 2018/3/19 14:14
     * @param middleHerdInsuranceListDto 养殖险Dto
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(MiddleHerdInsuranceListDto middleHerdInsuranceListDto) {
        MiddleHerdInsuranceList middleHerdInsuranceList = this.convert(middleHerdInsuranceListDto, MiddleHerdInsuranceList.class);
        middleHerdInsuranceListDao.save(middleHerdInsuranceList);
    }
    /**
     * 根据主键查询
     * @author: 田健
     * @date: 2018/3/19 14:15
     * @param inusreListCode 清单编号
     * @param fCode 农户代码
     * @param kindCode 险别代码
     * @return 养殖险对象
     */
    @Override
    public MiddleHerdInsuranceListDto queryByPK(String inusreListCode, String fCode, String kindCode) {
        MIddleHerdInsuranceListKey mIddleHerdInsuranceListKey = new MIddleHerdInsuranceListKey(inusreListCode,fCode,kindCode);
        MiddleHerdInsuranceList middleHerdInsuranceList = middleHerdInsuranceListDao.findOne(mIddleHerdInsuranceListKey);
        return this.convert(middleHerdInsuranceList,MiddleHerdInsuranceListDto.class);
    }
    /**
     * 根据清单号查询HerdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/19 14:39
     * @param inusreListCode 清单编号
     * @return 清单表信息集合
     */
    @Override
    public List<MiddleHerdInsuranceListDto> queryByInusreListCode(String inusreListCode) {
        List<MiddleHerdInsuranceList> middleHerdInsuranceLists = middleHerdInsuranceListDao.findByInusreListCode(inusreListCode);
        List<MiddleHerdInsuranceListDto> middleHerdInsuranceListDtoList = new ArrayList<MiddleHerdInsuranceListDto>();
        this.convertCollection(middleHerdInsuranceLists,middleHerdInsuranceListDtoList,MiddleHerdInsuranceListDto.class);
        return middleHerdInsuranceListDtoList;
    }
}