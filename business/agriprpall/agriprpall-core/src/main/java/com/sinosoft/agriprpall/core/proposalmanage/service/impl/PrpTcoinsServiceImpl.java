package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTcoinsDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTcoinsDao;
import com.sinosoft.agriprpall.core.proposalmanage.dao.specification.QueryProposalSpecBuilder;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTcoins;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTcoinsKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTcoinsService;
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
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 05:54:45.680 
 *  共保信息表Core接口实现
 */
@Service
public class PrpTcoinsServiceImpl extends BaseServiceImpl implements PrpTcoinsService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTcoinsServiceImpl.class);
    
    @Autowired
    private PrpTcoinsDao prpTcoinsDao;

    /**
     * 新增
     *@param
     */
    public void save(PrpTcoinsDto prpTcoinsDto) {
        PrpTcoins prpTcoins = this.convert(prpTcoinsDto, PrpTcoins.class);
        prpTcoinsDao.save(prpTcoins);
    }
    /**
     * 删除
     *@param
     */
    public void remove(String proposalNo,Integer serialNo) {
        PrpTcoinsKey prpTcoinsKey = new PrpTcoinsKey(proposalNo,serialNo);
        prpTcoinsDao.delete(prpTcoinsKey);
    }
    /**
     * 修改
     *@param
     */
    public void modify(PrpTcoinsDto prpTcoinsDto) {
        PrpTcoins prpTcoins = this.convert(prpTcoinsDto, PrpTcoins.class);
        prpTcoinsDao.save(prpTcoins);
    }
    /**
     * 按主键查询实体
     *@param 
     */
    public PrpTcoinsDto queryByPK(String proposalNo,Integer serialNo) {
        PrpTcoinsKey prpTcoinsKey = new PrpTcoinsKey(proposalNo,serialNo);
        PrpTcoins prpTcoins = prpTcoinsDao.findOne(prpTcoinsKey);
        return this.convert(prpTcoins,PrpTcoinsDto.class);
    }

    /**
     * 按proposalNo查询实体集合
     * @author 王心洋
     * @param proposalNo 投保单号
     * @time 2017-11-08
     * @return PrpTcoinsDto 共保信息list集合
     */
    public List<PrpTcoinsDto> findByProposalNo(String proposalNo){
        List<PrpTcoins> prpTcoinsList = prpTcoinsDao.findAll(QueryProposalSpecBuilder.findPrpTcoinsByPolicyNo(proposalNo));
        List<PrpTcoinsDto> prpTcoinsDtoList = new ArrayList<>();
        this.convertCollection(prpTcoinsList,prpTcoinsDtoList,PrpTcoinsDto.class);
        return prpTcoinsDtoList;
    }
}