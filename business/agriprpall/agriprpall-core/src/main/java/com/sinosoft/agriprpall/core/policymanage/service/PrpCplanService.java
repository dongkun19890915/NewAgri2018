package com.sinosoft.agriprpall.core.policymanage.service;


import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPplanDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPplanDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * *PrpCplan表的Core接口
 * @Author: 田慧
 * @Date: 2017/11/20 16:23
 */

public interface PrpCplanService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpCplanDto prpCplanDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String policyNo, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpCplanDto prpCplanDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpCplanDto queryByPK(String policyNo, Integer serialNo);
    /**
     * 根据保单号查询收费计划表PrpCplan
     * @author: 宋振振
     * @date: 2017/11/11 14:38
     * @param policyNo
     * @return Map<String,String>返回应交费金额总数，拖欠金额总数
     * @throws Exception
     */
    public Map<String,String> queryPrpCplanByPolicyNo(String policyNo) throws Exception;
    /**
     * 理赔调用服务，查询缴费情况
     * @author: 田健
     * @date: 2017/11/10 17:15
     * @param policyNo 保单号
     * @return 查询到的数量（int)
     */
    public long queryPays(String policyNo);
    /**
     * 理赔调用服务，查询计划缴费和已缴费
     * @author: 田健
     * @date: 2017/11/11 11:11
     * @param policyNo 保单号
     * @return int[] 期数
     */
    public int[] getDelinquentfeeTime(String policyNo);
    /**
     *  根据保单号查询prpCplan表（收费计划表）信息
     * @author: 田慧
     * @date: 2017/11/20 9:54
     * @param policyNo 保单号
     * @return prpCplanDtoList 返回PrpCplanDto的集合
     */
    public List<PrpCplanDto> queryByPolicyNo(String policyNo)throws Exception;

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPplanDto
     * @return PrpCplanDto
     * @throws Exception
     */
    public PrpCplanDto PEvaluateC(PrpPplanDto prpPplanDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPplanDto
     * @return PrpCplanDto
     * @throws Exception
     */
    public PrpCplanDto generatePrpCplan(PrpCPplanDto prpCPplanDto)throws Exception;


    /**
     * @description: （按保单号查询所有的数据，保单抄件用）
     * @author: 王志文
     * @date: 2017/11/16 9:27
     * @param policyNo
     * @return
     */
    List<PrpCplanDto> queryPrpCplanListByPolicyNo(String policyNo)throws Exception;

}