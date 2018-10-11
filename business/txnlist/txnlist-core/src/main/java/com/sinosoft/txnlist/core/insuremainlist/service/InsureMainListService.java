package com.sinosoft.txnlist.core.insuremainlist.service;

import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 07:14:54.112 
 * @description 清单主表Core接口
 */
public interface InsureMainListService {

    /**
     *@description 新增
     *@param
     */
    void save(InsureMainListDto insureMainListDto)throws Exception;
    /**
     *@description 新增
     *@param
     */
    void persist(InsureMainListDto insureMainListDto)throws Exception;

    /**
     *@description 删除
     *@param
     */
    void remove(String inusreListCode);
    /**
     *@description 修改
     *@param
     */
    public void modify(InsureMainListDto insureMainListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    public InsureMainListDto queryByPK(String inusreListCode);

    /**
     * @description: 按照投保单号查询
     * @author: 何伟东
     * @date: 2017/10/26 9:18
     * @param proposalNo
     * @return
     */
    public List<InsureMainListDto> queryByProposalNo(String proposalNo);

    /**
     * @description: 按照保单号查询集合
     * @author: 王心洋
     * @date: 2017/11/08
     * @param policyNo
     * @return List
     */
    public List<InsureMainListDto> queryByPolicyNo(String policyNo)throws Exception;

    /**
     * 根据清单编号回写投保单号和清单标志
     * @author: 陈道洋
     * @date: 2017/11/15 17:38
     * @param inusreListCode 清单编号
     * @param proposalNo 投保单号
     * @param validity 清单标志
     * @throws Exception
     */
    public void relatedInsuranceNo(String inusreListCode, String proposalNo, String validity)throws Exception;

    /**
     * @description: 方法功能简述：根据保单号查清单信息
     * @author: 杨成程
     * @date: 2017/11/28 11:44
     * @param policyNo
     * @return
     * @throws
     */
    public @ResponseBody List<InsureMainListDto> queryByPolicyNoAndValidity(String policyNo);

    /**
     * @description: 方法功能简述：根据保单号查清单信息
     * @author: majunling
     * @date: 2017/11/28 11:44
     * @param policyNo 
     * @return List<InsureMainList>
     * @throws
     */
    public @ResponseBody List<String> queryByCondition( String strFname, String strFCardID);
    
    /**
     * @description: 方法功能简述：根据投保单清单编号查清单信息
     * @author: majunlng
     * @date: 2017/11/28 11:44
     * @param insureListCode
     * @return insureMainListList
     */
    public List<InsureMainListDto> findByInsureListCode (String insureListCode)throws Exception;

    public Map<String,String> isInInsureMainList(String insureListCode)throws Exception;
    /**
    * 保单关联短信时获取农户数量
    * @param policyNo 保单号
    * @return integer 农户数量
    * @throws Exception
    * @author 李冬松
    * @date 17:53 2018/4/2
    */
    public Integer  queryFarmerNumber(String policyNo)throws Exception;

    /**
     * 根据金禾清单编号查询保单号
     * @author: 刘曼曼
     * @date: 12:07 12:07
     * @param gisInsureListCode 金禾清单编号
     * @return  List<String> 保单号
     * @throws Exception
     */
    public List<String> queryByGisInsureListCode(String gisInsureListCode) throws Exception;

    /**
     * 根据投保单号码批量查询金禾清单信息
     * @date: 12:07 12:07
     * @param proposalNos 投保单号码集合
     * @return  List<String> 清单主表信息
     * @throws Exception
     */
    public List<InsureMainListDto> findAllByProposalNos(List<String> proposalNos) throws Exception;


    /**
     * 根据金禾清单编号查询投保单号
     * @author: 汪强
     * @date: 12:07 12:07
     * @param gisInsureListCode 金禾清单编号
     * @return  List<String> 投保单号
     * @throws Exception
     */
    public List<String> queryByGisProposalNo(List<String> gisInsureListCode) throws Exception;

    /**
     * 根据业务号码（投保单号、保单号、批单号）查询金禾的清单号
     * @param bizCode 业务好
     * @return gisInsureListCode 金禾清单号
     * @date: 2018/4/8 15:43
     * @author: 何伟东
     */
    String findGisInsureListCodeByBizCode(String bizCode);

    /**
     * 根据投保单单号批量查询金禾的清单号下面的清单信息
     *
     * @param proposalNos 投保单号码集合
     * @author: 何伟东
     * @date: 2018/4/21 17:43
     */
    List<InsureMainListDto> queryByProposalNos(List<String> proposalNos) throws Exception;
    /**
     * 根据耳标号和农户姓名查询保单信息
     *
     * @param param proposalNos 投保单号码集合
     * @author: 陈道洋
     * @date: 2018/4/21 17:43
     */
    @ResponseBody
    List<InsureMainListDto> queryByEarableandFname(String earlAbel,String fName) throws Exception;
}