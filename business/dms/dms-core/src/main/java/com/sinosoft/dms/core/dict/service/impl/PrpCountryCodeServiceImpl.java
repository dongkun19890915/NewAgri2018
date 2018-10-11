package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpCountryCodeDto;
import com.sinosoft.dms.core.dict.dao.PrpCountryCodeDao;

import com.sinosoft.dms.core.dict.service.PrpCountryCodeService;
import com.sinosoft.dms.core.dict.entity.PrpCountryCode;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
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
 * @time  2017-10-28 10:28:12.446 
 * @description prpCountryCodeCore接口实现
 */
@Service
public class PrpCountryCodeServiceImpl extends BaseServiceImpl implements PrpCountryCodeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpCountryCodeServiceImpl.class);
    
    @Autowired
    private PrpCountryCodeDao prpCountryCodeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpCountryCodeDto prpCountryCodeDto) {
        PrpCountryCode prpCountryCode = this.convert(prpCountryCodeDto, PrpCountryCode.class);
        prpCountryCodeDao.save(prpCountryCode);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String codeCode) {
//        PrpCountryCodeKey prpCountryCodeKey = new PrpCountryCodeKey(codeCode);
//        prpCountryCodeDao.delete(prpCountryCodeKey);
        //TODO xxx
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpCountryCodeDto prpCountryCodeDto) {
        PrpCountryCode prpCountryCode = this.convert(prpCountryCodeDto, PrpCountryCode.class);
        prpCountryCodeDao.save(prpCountryCode);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpCountryCodeDto queryByPK(String codeCode) {
//        PrpCountryCodeKey prpCountryCodeKey = new PrpCountryCodeKey(codeCode);
//        PrpCountryCode prpCountryCode = prpCountryCodeDao.findOne(prpCountryCodeKey);
//        return this.convert(prpCountryCode,PrpCountryCodeDto.class);
        return null;//TODO xxx
    }

    /**
     * codeType和feildExt查询归属机构信息
     * @author: 王保良
     * @date: 2017/11/16 17:46
     * @param codeType 代码种类
     * @param fieldExt 上级区域代码
     * @return 返回的是满足条件的PrpDcode实体类对象
     * @throws Exception
     */
    @Override
    @Transactional
    public List<PrpCountryCodeDto> queryAreasProvinceInfo(String codeType,String fieldExt) {
        List<PrpCountryCode> prpCountryCodeList=prpCountryCodeDao.findAllByUpCode(fieldExt);
        List<PrpCountryCodeDto> prpCountryCodeDtoList=new ArrayList<>();
        convertCollection(prpCountryCodeList,prpCountryCodeDtoList,PrpCountryCodeDto.class);
        return prpCountryCodeDtoList;
    }

    /**
     * 按CodeCode查询实体
     * @param codeCode 代码
     * @author 王心洋
     * @time 2018-01-04
     * @return PrpCountryCodeDto
     */
    public PrpCountryCodeDto queryByCodeCode(String codeCode){
        PrpCountryCode prpCountryCode = prpCountryCodeDao.queryByCodeCode(codeCode);
        return this.convert(prpCountryCode,PrpCountryCodeDto.class);
    }
}