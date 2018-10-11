package com.sinosoft.agriclaim.core.claimmanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLLTextDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLLText;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLLTextKey;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLLTextService;
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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案文字表Core接口实现
 */
@Service
public class PrpLLTextServiceImpl extends BaseServiceImpl implements PrpLLTextService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLLTextServiceImpl.class);
    
    @Autowired
    private PrpLLTextDao prpLLTextDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLLTextDto prpLLTextDto) {
        PrpLLText prpLLText = this.convert(prpLLTextDto, PrpLLText.class);
        prpLLTextDao.save(prpLLText);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String claimNo,String textType,java.lang.Integer lineNo) {
        PrpLLTextKey prpLLTextKey = new PrpLLTextKey(claimNo,textType,lineNo);
        prpLLTextDao.delete(prpLLTextKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLLTextDto prpLLTextDto) {
        PrpLLText prpLLText = this.convert(prpLLTextDto, PrpLLText.class);
        prpLLTextDao.save(prpLLText);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLLTextDto queryByPK(String claimNo,String textType,java.lang.Integer lineNo) {
        PrpLLTextKey prpLLTextKey = new PrpLLTextKey(claimNo,textType,lineNo);
        PrpLLText prpLLText = prpLLTextDao.findOne(prpLLTextKey);
        return this.convert(prpLLText,PrpLLTextDto.class);
    }

    /**
     * （理赔打印结案报告获取文本信息）
     * @author: 王志文
     * @date: 2017/11/30 17:15
     * @param claimNo
     * @param textType
     * @return
     */
    @Override
    public List<PrpLLTextDto> queryListByClaimNoAndTextType(String claimNo, String textType) {
        List<PrpLLText> prpLLTexts = prpLLTextDao.queryPrpLLTextsByClaimNoAndTextType(claimNo,textType);
        List<PrpLLTextDto> prpLLTextDtos = new ArrayList<PrpLLTextDto>();
        for (PrpLLText prp: prpLLTexts) {
            prpLLTextDtos.add(this.convert(prp,PrpLLTextDto.class));
        }
        return prpLLTextDtos;
    }
}