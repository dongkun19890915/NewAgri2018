package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPitemKindAgriDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPitemKindAgriDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindAgriDto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PrpCitemKindAgriService {


    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param policyNo 保单号
     * @param kindCode 险别
     * @return List<PrpCitemKindAgriDto>
     */
    public List<PrpCitemKindAgriDto> queryByConditions(String policyNo, String kindCode) throws Exception;

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPitemKindAgriDto
     * @return PrpCitemKindAgriDto
     * @throws Exception
     */
    public PrpCitemKindAgriDto PEvaluateC(PrpPitemKindAgriDto prpPitemKindAgriDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPitemKindAgriDto
     * @return PrpCitemKindAgriDto
     * @throws Exception
     */
    public PrpCitemKindAgriDto generatePrpCitemKindAgri(PrpCPitemKindAgriDto prpCPitemKindAgriDto, BLEndorseDto blEndorseDto) throws Exception;

    /**
     *  （按照 policyNo itemkindno kindcode 报案所在茬次时间 查询 PrpCitemKind 集合）
     * @author: 王志文
     * @date: 2018/3/14 17:45
     * @param policyNo 保单号
     * @param kindCode 险别代码
     * @param itemKindNo 标的序号
     * @param times 茬次
     * @return
     * @throws Exception
     */
    public PrpCitemKindAgriDto queryByPk(String policyNo, String kindCode,int times,int itemKindNo)throws Exception;

    /**
     * （查询茬次信息）
     * @author: 王志文
     * @date: 2018/4/20 15:11
     * @param policyNo 保单号
     * @param kindCode 险别代码
     * @param itemKindNo 标的序号
     * @return
     * @throws Exception
     */
    public List<PrpCitemKindAgriDto> queryListByPolicyNoAndKindCodeAndTimesDate(String policyNo, String kindCode,int itemKindNo)throws Exception;

    /**
     * 根据保单号、险种、险别、出险时间查询茬次信息
     * @author: 孙朋飞
     * @date: 2018/4/25 8:52
     * @param policyNo 保单号
     * @param riskCode 险种
     * @param kindCode 险别
     * @param damageStartDate 出险时间
     * @return 茬次
     */
    public Map<String,Integer> queryPrpcItemKindAgriTimesByConditions(String policyNo, String riskCode, String kindCode, String damageStartDate) throws Exception;
}
