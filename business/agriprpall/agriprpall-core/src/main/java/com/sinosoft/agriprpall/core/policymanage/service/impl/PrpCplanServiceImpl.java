package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPplanDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPplanDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCplanDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCplan;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCplanKey;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCplanService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * @description 收费计划表Core接口实现
 */
@Service
public class PrpCplanServiceImpl extends BaseServiceImpl implements PrpCplanService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpCplanServiceImpl.class);
    
    @Autowired
    private PrpCplanDao prpCplanDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpCplanDto prpCplanDto) {
        PrpCplan prpCplan = this.convert(prpCplanDto, PrpCplan.class);
        prpCplanDao.save(prpCplan);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String policyNo,Integer serialNo) {
        PrpCplanKey prpCplanKey = new PrpCplanKey(policyNo,serialNo);
        prpCplanDao.delete(prpCplanKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpCplanDto prpCplanDto) {
        PrpCplan prpCplan = this.convert(prpCplanDto, PrpCplan.class);
        prpCplanDao.save(prpCplan);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpCplanDto queryByPK(String policyNo,Integer serialNo) {
        PrpCplanKey prpCplanKey = new PrpCplanKey(policyNo,serialNo);
        PrpCplan prpCplan = prpCplanDao.findOne(prpCplanKey);
        return this.convert(prpCplan,PrpCplanDto.class);
    }
    /**
     * 根据保单号查询缴费计划表PrpCplan
     * @author: 宋振振
     * @date: 2017/11/11 14:38
     * @param policyNo
     * @return Map<String,String>返回应交费金额总数，拖欠金额总数
     * @throws Exception
     */
    @Override
    public Map<String,String> queryPrpCplanByPolicyNo(String policyNo) throws Exception{
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("没有提供policyNo参数！");
        }

        List<Object[]> list = new ArrayList<Object[]>();
        list = prpCplanDao.findFeeSum(policyNo);
        String sumPlanFee = String.valueOf(list.get(0)[0]);
        String sumDelinquentFee = String.valueOf(list.get(0)[1]);
        Map<String, String> sumMap = new HashMap<>();
        sumMap.put("planFee", sumPlanFee);
        sumMap.put("delinquentFee", sumDelinquentFee);

        return sumMap;
    }
    /**
     * 理赔调用服务，查询未缴费的条数
     * @author: 田健
     * @date: 2017/11/10 17:23
     * @param policyNo 保单号
     * @return 查询到的数量（int)
     */
    @Override
    public long queryPays(String policyNo) {
        return prpCplanDao.queryPays(policyNo);
    }
    /**
     * 理赔调用服务，查询计划缴费和已缴费
     * @author: 田健
     * @date: 2017/11/11 11:12
     * @param policyNo 保单号
     * @return int[]集合
     */
    @Override
    public int[] getDelinquentfeeTime(String policyNo) {
        List<PrpCplan> prpCplanList = prpCplanDao.getDelinquentfeeTime(policyNo);
        int size = prpCplanList.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = prpCplanList.get(i).getSerialNo();
        }
        return ints;
    }
    /**
     *  根据保单号查询prpCplan表（收费计划表）信息
     * @author: 田慧
     * @date: 2017/11/20 9:54
     * @param policyNo 保单号
     * @return prpCplanDtoList 返回PrpCplanDto的集合
     */
    @Override
    public List<PrpCplanDto> queryByPolicyNo(String policyNo)throws Exception{
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        policyNo = "%" + policyNo + "%";
        List<PrpCplan> prpCplanList = prpCplanDao.findByPolicyNoLike(policyNo);
        List<PrpCplanDto> prpCplanDtoList = new ArrayList<PrpCplanDto>();
        this.convertCollection(prpCplanList, prpCplanDtoList, PrpCplanDto.class);
        return prpCplanDtoList;
    }

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public PrpCplanDto PEvaluateC(PrpPplanDto prpPplanDto) throws Exception {
        PrpCplanDto prpCplanDto=new PrpCplanDto();
        prpCplanDto.setPolicyNo(prpPplanDto.getPolicyNo());
        prpCplanDto.setEndorseNo(prpPplanDto.getEndorseNo1());
        prpCplanDto.setSerialNo(prpPplanDto.getSerialNo());
        prpCplanDto.setPayNo(prpPplanDto.getPayNo());
        prpCplanDto.setPayReason(prpPplanDto.getPayReason());
        prpCplanDto.setCurrency(prpPplanDto.getCurrency());
        prpCplanDto.setPlanDate(prpPplanDto.getPlanDate());
        prpCplanDto.setPlanFee(prpPplanDto.getPlanFee());
        prpCplanDto.setDelinquentFee(prpPplanDto.getDelinquentFee());
        prpCplanDto.setPlanStartDate(prpPplanDto.getPlanStartDate());
        prpCplanDto.setFlag(prpPplanDto.getFlag());
        prpCplanDto.setPlanRate(prpPplanDto.getPlanRate());
        prpCplanDto.setNoTaxPremium(prpPplanDto.getNoTaxPremium());
        prpCplanDto.setTaxFee(prpPplanDto.getTaxFee());
        return prpCplanDto;
    }

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCplanDto generatePrpCplan(PrpCPplanDto prpCPplanDto) throws Exception {
        PrpCplanDto prpCplanDto=new PrpCplanDto();
        prpCplanDto.setPolicyNo(prpCPplanDto.getPolicyNo());
        prpCplanDto.setEndorseNo(prpCPplanDto.getEndorseNo());
        prpCplanDto.setSerialNo(prpCPplanDto.getSerialNo());
        prpCplanDto.setPayNo(prpCPplanDto.getPayNo());
        prpCplanDto.setPayReason(prpCPplanDto.getPayReason());
        prpCplanDto.setPlanDate(prpCPplanDto.getPlanDate());
        prpCplanDto.setCurrency(prpCPplanDto.getCurrency());
        prpCplanDto.setPlanFee(prpCPplanDto.getPlanFee());
        prpCplanDto.setPlanRate(prpCPplanDto.getPlanRate());
        prpCplanDto.setDelinquentFee(prpCPplanDto.getDelinquentFee());
        prpCplanDto.setFlag(prpCPplanDto.getFlag());
        prpCplanDto.setPlanStartDate(prpCPplanDto.getPlanStartDate());
        prpCplanDto.setNoTaxPremium(prpCPplanDto.getNoTaxPremium());
        prpCplanDto.setTaxFee(prpCPplanDto.getTaxFee());
        return prpCplanDto;
    }

    /**
     * @description: （按保单号查询所有的数据，保单抄件用）
     * @author: 王志文
     * @date: 2017/11/16 9:27
     * @param policyNo
     * @return
     */
    @Override
    public List<PrpCplanDto> queryPrpCplanListByPolicyNo(String policyNo)throws Exception {
        List<PrpCplan> prpCplans = prpCplanDao.queryListByPolicyNo(policyNo);
        List<PrpCplanDto> prpCplanDtos = new ArrayList<PrpCplanDto>();
        for (PrpCplan prp: prpCplans
                ) {
            prpCplanDtos.add(this.convert(prp,PrpCplanDto.class));
        }
        return prpCplanDtos;
    }
}