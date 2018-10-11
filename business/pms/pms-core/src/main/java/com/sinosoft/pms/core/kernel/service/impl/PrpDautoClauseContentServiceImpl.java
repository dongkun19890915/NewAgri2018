package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseContentDto;
import com.sinosoft.pms.core.kernel.dao.PrpDautoClauseContentDao;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseContent;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseContentKey;
import com.sinosoft.pms.core.kernel.service.PrpDautoClauseContentService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:28:14.022 
 * @description 动态生成特约内容规则表Core接口实现
 */
@Service
public class PrpDautoClauseContentServiceImpl extends BaseServiceImpl implements PrpDautoClauseContentService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDautoClauseContentServiceImpl.class);
    
    @Autowired
    private PrpDautoClauseContentDao prpDautoClauseContentDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDautoClauseContentDto prpDautoClauseContentDto) {
        PrpDautoClauseContent prpDautoClauseContent = this.convert(prpDautoClauseContentDto, PrpDautoClauseContent.class);
        prpDautoClauseContentDao.save(prpDautoClauseContent);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,String comCode,String riskCode,String serialNo) {
        PrpDautoClauseContentKey prpDautoClauseContentKey = new PrpDautoClauseContentKey(clauseCode,comCode,riskCode,serialNo);
        prpDautoClauseContentDao.delete(prpDautoClauseContentKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDautoClauseContentDto prpDautoClauseContentDto) {
        PrpDautoClauseContent prpDautoClauseContent = this.convert(prpDautoClauseContentDto, PrpDautoClauseContent.class);
        prpDautoClauseContentDao.save(prpDautoClauseContent);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDautoClauseContentDto queryByPK(String clauseCode,String comCode,String riskCode,String serialNo) {
        PrpDautoClauseContentKey prpDautoClauseContentKey = new PrpDautoClauseContentKey(clauseCode,comCode,riskCode,serialNo);
        PrpDautoClauseContent prpDautoClauseContent = prpDautoClauseContentDao.findOne(prpDautoClauseContentKey);
        return this.convert(prpDautoClauseContent,PrpDautoClauseContentDto.class);
    }

    /**
     *@description 按条件查询实体
     *@param
     */
    public List<PrpDautoClauseContentDto> queryByCondition(String clauseCode,String comCode,String riskCode) {
        List<PrpDautoClauseContent> prpDautoClauseContents = new ArrayList<>();
        List<PrpDautoClauseContentDto> prpDautoClauseContentDtos = null;

        try {
            Specification<PrpDautoClauseContent> specifications = specifications(clauseCode, comCode, riskCode);
            prpDautoClauseContents = prpDautoClauseContentDao.findAll(specifications);

            prpDautoClauseContentDtos = new ArrayList<PrpDautoClauseContentDto>(prpDautoClauseContents.size());
            this.convertCollection(prpDautoClauseContents, prpDautoClauseContentDtos, PrpDautoClauseContentDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prpDautoClauseContentDtos;
    }

    public static Specification<PrpDautoClauseContent> specifications(String clauseCode, String comCode, String riskCode) throws Exception {
        return Specifications.<PrpDautoClauseContent>and().eq(com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(clauseCode), "clauseCode", clauseCode)
                .eq(com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(comCode), "comCode", comCode)
                .eq(com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(riskCode), "riskCode", riskCode)
                .build();
    }
}