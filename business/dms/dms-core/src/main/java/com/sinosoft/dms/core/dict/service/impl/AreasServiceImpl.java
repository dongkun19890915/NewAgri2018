package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.AreasDto;
import com.sinosoft.dms.api.dict.dto.AreasParamsDto;
import com.sinosoft.dms.core.dict.dao.AreasDao;
import com.sinosoft.dms.core.dict.dao.specification.AreasSpecBuilder;
import com.sinosoft.dms.core.dict.entity.Areas;
import com.sinosoft.dms.core.dict.entity.AreasKey;
import com.sinosoft.dms.core.dict.service.AreasService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 06:45:04.724 
 * @description 行政区域表Core接口实现
 */
@Service
public class AreasServiceImpl extends BaseServiceImpl implements AreasService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(AreasServiceImpl.class);
    
    @Autowired
    private AreasDao areasDao;

    /**
     *@description 新增
     *@param
     */
    public void save(AreasDto areasDto) {
        Areas areas = this.convert(areasDto, Areas.class);
        areasDao.save(areas);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String areaCode) {
        AreasKey areasKey = new AreasKey(areaCode);
        areasDao.delete(areasKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(AreasDto areasDto) {
        Areas areas = this.convert(areasDto, Areas.class);
        areasDao.save(areas);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public AreasDto queryByPK(String areaCode) {
        AreasKey areasKey = new AreasKey(areaCode);
        Areas areas = areasDao.findOne(areasKey);
        return this.convert(areas,AreasDto.class);
    }

    /**
     * @description:（查询承保清单归属区域信息）
     * @author: 董坤
     * @date: 2017/10/14 9:01
     * @param areasParamsDto
     * @return List<AreasDto>
     * @throws Exception
     */
    @Override
    public List<AreasDto> queryAreasByCondition(AreasParamsDto areasParamsDto) throws Exception{
        System.err.println(areasParamsDto.getCodeType());
        if(StringUtils.isEmpty(areasParamsDto.getCodeType())){
            throw new DataVerifyException("代码类型不能为空!");
        }
        Specification<Areas> specification = AreasSpecBuilder.areasSpecification(areasParamsDto);
        List<Areas> list= areasDao.findAll(specification);
        List<AreasDto> areasDtoList  = new ArrayList<AreasDto>(list.size());
        convertCollection(list,areasDtoList,AreasDto.class);
        return areasDtoList;
    }
}