package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.policymanage.dto.AcceptInsuranceDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PlantingExcelDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingInsuranceListDto;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 12:54:07.447 
 * @description 清单下载Core接口
 */
public interface PlantingExcelService {


    /**
     *  分户清单查询
     * @author: 钱浩
     * @date: 2017/10/31 11:14
     * @param inusreListCode 清单号
     * @param pageNo 页数
     * @param pageSize  每页条数
     * @return ResponseDto：
     */
    public PageInfo<PlantingInsuranceListDto> queryPlantingExcelByConnection(String inusreListCode, Integer pageNo, Integer pageSize)throws Exception;
    /**
     * 分户清单 暂不使用
     * @author: 钱浩
     * @date: 2017/11/1 11:35
     * @param proposalNo 投保单号
     * @param policyNo 保单号
     * @param inusreListCode 清单号
     * @param userCode 用户编码
     * @return  ResponseDto ：下载链接地址
     * @throws Exception
     */
    @Deprecated
    public Map<String, String> getPlantingExcel(String riskCode, String proposalNo, String policyNo, String inusreListCode, String userCode) throws Exception;

    /**
     * 种植分户清单下载
     *
     * @param proposalNo     投保单号
     * @param policyNo       保单号
     * @param inusreListCode 清单号
     * @param userCode       用户编码
     * @return ResponseDto ：下载链接地址
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/1 11:35
     */
    @Deprecated
    public String getPlantingToExcel(String riskCode, String proposalNo, String policyNo, String inusreListCode, String userCode) throws Exception;
    /**
     *  养殖险分户清单的下载
     * @author: 田慧
     * @date: 2017/12/5 10:04
     * @param riskCode 险种代码
     * @param proposalNo 投保单号
     * @param policyNo 保单号
     * @param inusreListCode  清单号
     * @param userCode  用户编码
     * @return  下载链接地址
     * @throws Exception
     */
    @Deprecated
    public String getHerdInsuranceListExcel(String riskCode, String proposalNo, String policyNo, String inusreListCode, String userCode)throws Exception;
    /**
     *  多险别养殖险分户清单的下载
     * @author: 田慧
     * @date: 2017/12/5 10:04
     * @param riskCode 险种代码
     * @param proposalNo 投保单号
     * @param policyNo 保单号
     * @param inusreListCode  清单号
     * @param userCode  用户编码
     * @return  下载链接地址
     * @throws Exception
     */
    public String getNyxInsuranceListExcel(String riskCode, String proposalNo, String policyNo, String inusreListCode, String userCode)throws Exception;
    /**
     * 清单下载
     * @author: 田健
     * @date: 2018/3/19 15:40
     * @param plantingExcelDto  清单下载条件信息
     * @return map中的key为短链接
     * @throws Exception
     */
    public Map<String,String> getFileId(PlantingExcelDto plantingExcelDto)throws Exception;
    /**
     * 根据出险时间、保单号查询清单信息
     * @author: 田健
     * @date: 2018/4/11 9:36
     * @param policyNo 保单号
     * @param validDate 出险时间
     * @return 承保分户清单dto集合
     * @throws Exception
     */
    public List<AcceptInsuranceDto> queryInsureListInfo(String policyNo, Date validDate) throws Exception;
    /**
     * 根据出险时间、保单号查询清单信息并下载
     * @author: 田健
     * @date: 2018/4/11 9:36
     * @param policyNo 保单号
     * @param validDate 出险时间
     * @return 承保分户清单dto集合
     * @throws Exception
     */
    public Map<String,String> getInsureListInfoFileId(String policyNo,Date validDate)throws Exception;

    public Map<String ,String> endorExcel(PlantingExcelDto plantingExcelDto)throws Exception;
    /**
     * 批改后清单下载
     * @param
     * @return
     * @throws
     * @author 李冬松
     * @date 10:01 2018/4/17
     */
    public Map<String, String> afterEndorExcel(String endorseNo) throws Exception;
    public Map<String ,String> chgEndorExcel(String policyNo)throws Exception;
}