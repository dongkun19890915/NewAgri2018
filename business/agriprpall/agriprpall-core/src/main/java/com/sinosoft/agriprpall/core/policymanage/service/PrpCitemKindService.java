package com.sinosoft.agriprpall.core.policymanage.service;


import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPitemKindDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ClaimQueryDeductiblerateDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKind;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-20 05:44:18.998 
 * @description 保单标的子险信息表Core接口
 */
public interface PrpCitemKindService {
    /**
     * 标的子险信息表保存
     * @author: 田健
     * @date: 2017/12/25 16:25
     * @param prpCitemKindDto 标的子险信息Dto
     */
    void save(PrpCitemKindDto prpCitemKindDto);

    /**
     * 根据主键删除标的子险信息表数据
     * @author: 田健
     * @date: 2017/12/25 16:27
     * @param   policyNo 保单号,itemKindNo 序号
     */
    void remove(String policyNo, Integer itemKindNo);
    /**
     * 更新标的子险信息表信息
     * @author: 田健
     * @date: 2017/12/25 16:29
     * @param prpCitemKindDto 标的子险信息Dto
     */
    void modify(PrpCitemKindDto prpCitemKindDto);
    /**
     * 根据主键查询标的子险信息表数据
     * @author: 田健
     * @date: 2017/12/25 16:27
     * @param  policyNo 保单号,itemKindNo 序号
     */
    PrpCitemKindDto queryByPK(String policyNo, Integer itemKindNo);
    /**
     * 根据传来的条件查询PrpCitemKind表，返回List<PrpCitemKindDto>给服务调用
     * @author: 宋振振
     * @date: 2017/11/11 16:39
     * @param statement
     * @return List<PrpCitemKindDto>
     * @throws Exception
     */
    public List<PrpCitemKindDto> queryPrpCitemKindByCondition(String statement)throws Exception;

    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param policyNo 保单号
     * @return List<PrpCitemKind>
     */
    public List<PrpCitemKindDto> findItemByPolicyNo(String policyNo) throws Exception;

    /**
     *  根据条件查询标的子险信息表信息
     * @author: 田慧
     * @date: 2017/11/22 17:16
     * @param prpCitemKindDto 保单标的子险信息表Dto
     * @return 返回PrpCitemKindDto的集合
     * @throws Exception
     */
    public List<PrpCitemKindDto> queryByConditions(PrpCitemKindDto prpCitemKindDto)throws Exception;

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPitemKindDto
     * @return PrpCitemKindDto
     * @throws Exception
     */
    public PrpCitemKindDto PEvaluateC(PrpPitemKindDto prpPitemKindDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPitemKindDto
     * @return PrpCitemKindDto
     * @throws Exception
     */
    public PrpCitemKindDto generatePrpCitemKind(PrpCPitemKindDto prpCPitemKindDto)throws Exception;

    /**
     * @description: （理赔打印查询itemCode）
     * @author: 王志文
     * @date: 2017/11/11 9:19
     * @param policyNo
     * @return
     */
    List<PrpCitemKindDto> queryItemCodeByPolicyNo(String policyNo);

    /**
     * @description: （理赔打印查询itemCode）
     * @author: 王志文
     * @date: 2017/11/11 9:19
     * @param policyNo
     * @return
     */
    public List<PrpDcodeDto> queryItemCodeList(String policyNo);
    /**
     * 根据PolicyNo保单号和FamilyNo分户序号查询PrpCitemKindDto险别信息的集合
     * @author: 宋振振
     * @date: 2017/12/15 14:30
     * @param policyNo 保单号
     * @param familyNo 分户序号
     * @return List<PrpCitemKindDto> 险别信息的集合
     * @throws Exception
     */
    public List<PrpCitemKindDto> queryPrpCitemKindByPolicyNoAndFamilyNo(String policyNo,String familyNo)throws Exception;

    /**
     * （赔款金额计算通过保单号和险别查询损失率）
     * @author: 王志文
     * @date: 2018/1/8 10:49
     * @param policyNo 保单号
     * @param kindCode 险别代码
     * @return List<PrpCitemKind> 险别信息集合
     */
    List<PrpCitemKindDto> queryAllByPolicyNoAndKindCode(String policyNo, String kindCode,String itemCode)throws Exception;

    /**
     * 批量查询险别标的信息
     * @param policyNos 保单号集合
     * @return List<PrpCitemKindDto>
     * @date: 2018/4/12 11:42
     * @author: 何伟东
     */
    List<PrpCitemKindDto> queryItemKindByPolicyNos(List<String> policyNos)throws Exception;
    /**
     * 根据保单号、险别、标的查询信息
     * @author: 田健
     * @date: 2018/4/13 12:22
     * @param policyNo 保单号
     * @param kindCode 险别
     * @param itemCode 标的
     * @return PrpCitemKindDto信息集合
     * @throws Exception
     */
    ClaimQueryDeductiblerateDto queryAllByPolicyNoAndKindCodeAndItemCode(String policyNo, String kindCode, String itemCode)throws Exception;

}