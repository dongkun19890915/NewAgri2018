package com.sinosoft.agriclaim.core.registmanage.service.impl;

import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistTextDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistText;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistTextKey;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistTextService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * @description 报案文字表Core接口实现
 */
@Service
public class PrpLRegistTextServiceImpl extends BaseServiceImpl implements PrpLRegistTextService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLRegistTextServiceImpl.class);
    
    @Autowired
    private PrpLRegistTextDao prpLRegistTextDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLRegistTextDto prpLRegistTextDto) {
        PrpLRegistText prpLRegistText = this.convert(prpLRegistTextDto, PrpLRegistText.class);
        prpLRegistTextDao.save(prpLRegistText);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,String textType,java.lang.Integer lineNo) {
        PrpLRegistTextKey prpLRegistTextKey = new PrpLRegistTextKey(registNo,textType,lineNo);
        prpLRegistTextDao.delete(prpLRegistTextKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLRegistTextDto prpLRegistTextDto) {
        PrpLRegistText prpLRegistText = this.convert(prpLRegistTextDto, PrpLRegistText.class);
        prpLRegistTextDao.save(prpLRegistText);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRegistTextDto queryByPK(String registNo,String textType,java.lang.Integer lineNo) {
        PrpLRegistTextKey prpLRegistTextKey = new PrpLRegistTextKey(registNo,textType,lineNo);
        PrpLRegistText prpLRegistText = prpLRegistTextDao.findOne(prpLRegistTextKey);
        return this.convert(prpLRegistText,PrpLRegistTextDto.class);
    }
    @Override
    public List<PrpLRegistTextDto> queryByRegistNoAndTextType(String registNo, String textType) {
        Specification<PrpLRegistText> specification = Specifications.<PrpLRegistText>and().eq("registNo", registNo).eq("textType", textType).build();
        Sort sort =new Sort("lineNo");
        List<PrpLRegistText> registTextList = prpLRegistTextDao.findAll(specification, sort);
        List<PrpLRegistTextDto> registTextDtoList = new ArrayList<>();
        this.convertCollection(registTextList, registTextDtoList, PrpLRegistTextDto.class);
        return registTextDtoList;
    }
}