package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;


import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;

import java.util.Date;
import java.util.List;

public interface PrpPheadService {

    public String queryEndorseNo(String strWhere) throws Exception;
    public  Integer queryMaxEndorseNo(String strWhere) throws Exception;
    /**
    *通过主键查询PrpPhead对象
    * @param policyNo  保单号
    * @return PrpPheadDto
    * @throws Exception
    * @author 李冬松
    * @date 16:46 2017/11/23
    */
    public List<PrpPheadDto> queryAllByPolicyNo(String policyNo) throws Exception;
    /**
    * 通过保单号，出险小时，出险日期查询批单头表信息，返回List
    * @param policyNo,保单号
     * @param validDate, 出险日期
     * @param validHour 出险小时
    * @return java.util.List<com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto>
    * @throws Exception
    * @author 李冬松
    * @date 17:32 2017/12/15
    */


    /**
     *通过保单号，出险小时，出险日期查询批单头表信息
     * @author: 李冬松
     * @date: 2017/12/23 14:32
     * @param policyNo 保单号
     * @param validDate 出险日期
     * @param  validHour  出险小时
     * @return List<PrpPheadDto>批单表集合
     * @throws Exception
     */
    public List<PrpPheadDto> queryByPolicyNoAndDamagerDate(String policyNo, String validDate, String validHour) throws Exception;

    /**
     * 根据policyNo和时间条件查询PrpPheadDto集合
     * @author: 刘曼曼
     * @date: 2017/12/23 14:34
     * @param policyNo 保单号
     * @param damageDate 生效日期
     * @param damageHour 生效小时
     * @return List<PrpPheadDto>批单表集合
     * @throws Exception
     */
    public List<PrpPheadDto> queryPrpPheadDtoByNoANDTime(String policyNo,String damageDate,String damageHour)throws Exception;

    /**
     * （通过保单号查询批单信息）
     * @author: 王志文
     * @date: 2017/11/16 17:30
     * @param policyNo
     * @return
     */
    List<PrpPheadDto> queryByPolicyNo(String policyNo);

    List<PrpPheadDto> queryByCondition(String policyNo,Date startDate)throws Exception;
}
