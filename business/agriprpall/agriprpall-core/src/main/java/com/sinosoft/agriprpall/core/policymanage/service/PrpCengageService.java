package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPengageDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;

import java.util.List;

/**
 * PrpCengageService表服务接口
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
public interface PrpCengageService {
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPengageDto
     * @return PrpCengageDto
     * @throws Exception
     */
    public PrpCengageDto PEvaluateC(PrpPengageDto prpPengageDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPengageDto
     * @return PrpCengageDto
     * @throws Exception
     */
    public PrpCengageDto generatePrpCengage(PrpCPengageDto prpCPengageDto) throws Exception;

    /**
     *@description 新增
     *@param
     */
    void save(PrpCengageDto prpCEngageDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String policyNo,java.lang.Integer serialNo,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpCengageDto prpCEngageDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpCengageDto queryByPK(String policyNo,java.lang.Integer serialNo,java.lang.Integer lineNo);

    /**
     * @description: （保单抄件通过保单号查找特别约定）
     * @author: 王志文
     * @date: 2017/11/16 8:51
     * @param policyNo
     * @return
     */
    List<PrpCengageDto> queryEngageByPolicyNo(String policyNo);

    /**
     * 根据保单号，编码查询免赔率
     * @author: 田健
     * @date: 2018/4/13 12:32
     * @param policyNo 保单号
     * @param clauseCode 免赔率编码
     * @return 免赔率
     */
    String queryClausesByPolicyNo (String policyNo,String clauseCode);
}
