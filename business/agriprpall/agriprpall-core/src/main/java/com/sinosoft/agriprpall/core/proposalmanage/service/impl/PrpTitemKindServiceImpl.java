package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTitemKindDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTitemKindDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTitemKind;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTitemKindKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTitemKindService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 标的子险信息Core接口实现
 */
@Service
public class PrpTitemKindServiceImpl extends BaseServiceImpl implements PrpTitemKindService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTitemKindServiceImpl.class);
    
    @Autowired
    private PrpTitemKindDao prpTitemKindDao;
    @PersistenceContext
    private EntityManager entityManager;
    /**
     *@description 新增
     *@param
     */
    public void save(PrpTitemKindDto prpTitemKindDto) {
        PrpTitemKind prpTitemKind = this.convert(prpTitemKindDto, PrpTitemKind.class);
        prpTitemKindDao.save(prpTitemKind);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,Integer itemkindNo) {
        PrpTitemKindKey prpTitemKindKey = new PrpTitemKindKey(proposalNo,itemkindNo);
        prpTitemKindDao.delete(prpTitemKindKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTitemKindDto prpTitemKindDto) {
        PrpTitemKind prpTitemKind = this.convert(prpTitemKindDto, PrpTitemKind.class);
        prpTitemKindDao.save(prpTitemKind);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTitemKindDto queryByPK(String proposalNo,Integer itemkindNo) {
        PrpTitemKindKey prpTitemKindKey = new PrpTitemKindKey(proposalNo,itemkindNo);
        PrpTitemKind prpTitemKind = prpTitemKindDao.findOne(prpTitemKindKey);
        return this.convert(prpTitemKind,PrpTitemKindDto.class);
    }

    /**
     * 根据投保单号查询PrpTitemKind
     *
     * @param proposalNo
     * @return List<PrpTitemKindDto>
     * @author: 钱浩
     * @date: 2017/12/5 上午 11:47
     */
    public List<PrpTitemKindDto> queryByConnection(String proposalNo) throws Exception {
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号不能为空");
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select p from PrpTitemKind p where p.proposalNo=:proposalNo  ");
        Query query = entityManager.createQuery(buffer.toString());
        query.setParameter("proposalNo", proposalNo);
        List<PrpTitemKind> prpTitemKinds = query.getResultList();
        List<PrpTitemKindDto> prpTitemKindDtoList = new ArrayList<PrpTitemKindDto>();
        convertCollection(prpTitemKinds, prpTitemKindDtoList, PrpTitemKindDto.class);
        return prpTitemKindDtoList;

    }
}