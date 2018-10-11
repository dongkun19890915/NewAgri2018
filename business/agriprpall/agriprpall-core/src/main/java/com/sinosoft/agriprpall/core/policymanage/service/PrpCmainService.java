package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPmainDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainRequestDto;
import com.sinosoft.agriprpall.api.policymanage.dto.RequestPrpCmainInfoDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponsePrpCmainInfoDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.ResponsePrpDclauseCodeDto;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Map;

/**
 * *PrpCmain表（保单基本信息表）的Core接口
 * @Author: 田慧
 * @Date: 2017/11/20 16:24
 */
public interface PrpCmainService {

    /**
     *  根据主键查询PrpCMain保单基本信息表信息
     * @author: 田慧
     * @date: 2017/12/3 11:53
     * @param policyNo 保单号
     * @return
     */
    PrpCmainDto queryByPK(String policyNo);
    /**
     * * （根据保单号查看是否已经打印）
     * @author: 田慧
     * @date: 20:02
     * @param PrpCmainRequestDto prpCmainRequestDto  保单号集合
     * @return resultMap
     * @throws Exception
     */
     Map<String,String> queryPrintNo(PrpCmainRequestDto prpCmainRequestDto)throws Exception;
    /**
     *  分页查询PrpCMainDto（保单基本信息表Dto）结果集
     * @author: 田慧
     * @date: 2017/11/21 10:47
     * @param prpCmainRequestDto prpCMainDto包括保单号、投保人姓名、保单起期、保单止期、页码、每页记录数
    riskCodeList 险种集合
    policyNoList 保单号集合
     * @return  返回pageInfo  分页查询主表信息（包含保单主表信息集合（PrpCMainDto）
    、当前页数、总记录数）
     * @throws Exception
     */
    public PageInfo<PrpCmainDto> queryPolicyListInfo(PrpCmainRequestDto prpCmainRequestDto) throws Exception;
    /**
     *  根据policyNo保单号、riskCode险种代码检查保单号是否存在
     * @author: 田慧
     * @date: 2017/12/1 14:38
     * @param policyNo 保单号
     * @param riskCode 险种代码
     * @return List<prpCmainDto> 保单基本信息表信息
     * @throws Exception
     */
    public List<PrpCmainDto> checkPolicyNo(String policyNo,String riskCode)throws Exception;
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param  prpPmainDto
     * @return PrpCmainDto
     * @throws Exception
     */
    public PrpCmainDto PEvaluateC(PrpPmainDto prpPmainDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPmainDto
     * @return prpCmainDto
     * @throws Exception
     */
    public PrpCmainDto generatePrpCmain(PrpCPmainDto prpCPmainDto)throws Exception;

    /* *  根据保单号检验是否存在
    * @author: 钱浩
    * @date: 2017/12/1 14:38
           * @param map 包括保单号
    * @return Integer 条数
    * @throws Exception
    */
    public Integer queryPolicyNo(String policyNo) throws Exception;

    public List<PrpCmainDto> queryByOldPolicyNo(String oldPolicyNo) throws Exception;

    public void updatePrpCmain(List<PrpCmainDto> prpCmainDtoList) throws Exception;
    /**
     * 根据保单号回写PrpCmain表的理赔次数claimTimes字段
     * @author: 宋振振
     * @date: 2017/12/15 9:58
     * @param policyNo 保单号
     * @throws Exception
     */
    public void modifyPrpCmainAddClaimTimes(String policyNo)throws Exception;

    /**
     * 批量查询保单信息
     *
     * @param policyNos 多个保单号
     * @return Map<policyNo, PrpCmainDto>
     * @date: 2018/4/12 10:48
     * @author: 何伟东
     */
    List<PrpCmainDto> queryPolicyInfoByPolicyNos(List<String> policyNos) throws Exception;

    /**
     * 关联清单查询重复性保单数据
     * @author: 刘曼曼
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    public PageInfo<ResponsePrpCmainInfoDto> queryPrpCmainInfo(RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception;


    /**
     * 关联清单查询当前投保单是否同时存在
     * @author: 汪强
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    public PageInfo<ResponsePrpCmainInfoDto> queryByPrpNoPrpCmainInfo(RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception;
    /**
     * 关联清单查询当前投保单是否同时存在
     * @author: 汪强
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    public PageInfo<ResponsePrpCmainInfoDto> queryByPrpNoPrpCmainInfoList(RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception;

    /**
     * 理赔更新有效保额
     * @author: 刘曼曼
     * @date: 19:50 19:50
     * @param policyNo 保单号
     * @param chgSumAmount 变化量
     * @return Map 更新信息
     */
    public Map<String,String> modifyBypolicy(String policyNo,Double chgSumAmount)throws Exception;
}
