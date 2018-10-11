package com.sinosoft.txnlist.api.insuremainlist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 07:14:54.112 
 * @description 清单主表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = InsureMainListApi.PATH)
public interface InsureMainListApi {

    public static final String PATH = "insureMainList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    @ResponseBody String save(@RequestBody InsureMainListDto insureMainListDto)throws Exception ;

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.GET})
    void remove(@RequestParam("inusreListCode") String inusreListCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    public void modify(@RequestBody InsureMainListDto insureMainListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody InsureMainListDto queryByPK(@RequestParam("inusreListCode") String inusreListCode);

    /**
     * @description: 按投保单号查询实体
     * @author: 何伟东
     * @date: 2017/10/26 9:15
     */
    @RequestMapping(value = "queryByProposalNo",method = {RequestMethod.GET})
    public @ResponseBody List<InsureMainListDto> queryByProposalNo(@RequestParam("proposalNo") String proposalNo);

    /**
     * @description: 按保单号查询实体集合
     * @author: 王心洋
     * @date: 2017/11/08
     * @param policyNo
     * @return List
     */
    @RequestMapping(value = "queryByPolicyNo",method = {RequestMethod.GET})
    public @ResponseBody List<InsureMainListDto> queryByPolicyNo(@RequestParam("policyNo") String policyNo)throws Exception;

    /**
     * 根据清单编号回写投保单号和清单标志
     * @author: 陈道洋
     * @date: 2017/11/15 17:35
     * @param inusreListCode 清单编号
     * @param proposalNo 投保单号
     * @param validity 清单标志
     * @throws Exception
     */
    @RequestMapping(value = "relatedInsuranceNo",method = {RequestMethod.POST})
    public void relatedInsuranceNo(@RequestParam("inusreListCode") String inusreListCode, @RequestParam("proposalNo") String proposalNo, @RequestParam("validity") String validity)throws Exception;

    /**
     * @description: 方法功能简述：根据保单号查清单信息
     * @author: 杨成程
     * @date: 2017/11/28 11:44
     * @param policyNo
     * @return
     * @throws
     */
    @RequestMapping(value = "queryByPolicyNoAndValidity",method = {RequestMethod.POST})
    @ResponseBody List<InsureMainListDto> queryByPolicyNoAndValidity(@RequestParam("policyNo") String policyNo);

    /**
     * @description: 方法功能简述：根据农户姓名和身份证号查清单信息
     * @author: 马俊玲
     * @date: 2017/11/28 11:44
     * @param map fname  fCardID农户姓名
     * @return list
     * @throws
     */
    @RequestMapping(value = "queryByCondition",method = {RequestMethod.POST})
    @ResponseBody List<String> queryByCondition(@RequestBody Map<String,String> map);

    /**
     * @description: 方法功能简述：根据投保单清单编号查清单信息
     * @author: majunlng
     * @date: 2017/11/28 11:44
     * @param insureListCode
     * @return insureMainListList
     */
    @RequestMapping( value = "queryByInsureListCode",method = {RequestMethod.POST})
    public @ResponseBody List<InsureMainListDto> queryByInsureListCode(@RequestParam(value = "insureListCode") String insureListCode)throws Exception;

    /**
     * 判断有无此清单号
     * @param map 中key insureListCode 清单号
     * @return String Y：有此清单号；N：无此清单号
     * @throws Exception
     * @author: 李冬松
     * @date: 2018/1/16 11:44
     */
    @RequestMapping(value = "isInInsureMainList",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> isInInsureMainList(@RequestBody Map<String,String> map)throws Exception;

    @RequestMapping(value = "queryFarmerNumber",method = {RequestMethod.POST})
    public @ResponseBody Integer queryFarmerNumber(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 根据金禾清单编号查询保单号
     * @author: 刘曼曼
     * @date: 12:07 12:07
     * @param map 金禾清单编号
     * @return  List<String> 保单号
     * @throws Exception
     */
    @RequestMapping(value = "queryByGisInsureListCode",method = {RequestMethod.POST})
    public @ResponseBody List<String> queryByGisInsureListCode(@RequestBody Map<String,String> map) throws Exception;


    /**
     * 根据金禾清单编号查询保单号
     * @author: 刘曼曼
     * @date: 12:07 12:07
     * @param map 金禾清单编号
     * @return  List<String> 保单号
     * @throws Exception
     */
    @RequestMapping(value = "findAllByProposalNos",method = {RequestMethod.POST})
    public @ResponseBody List<InsureMainListDto> findAllByProposalNos(@RequestBody Map<String,List<String>> map) throws Exception;

    /**
     * 根据金禾投保单号查询清单编号
     * @author: 汪强
     * @date: 12:07 12:07
     * @param map 金禾清单编号
     * @return  List<String> 投保单号
     * @throws Exception
     */
    @RequestMapping(value = "queryByGisProposalNo",method = {RequestMethod.POST})
    public @ResponseBody List<String> queryByGisProposalNo(@RequestBody Map<String,List<String>> map) throws Exception;

    /**
     * 根据业务号码（投保单号、保单号、批单号）查询金禾的清单号
     *
     * @param param bizCode-业务号码
     * @return gisInsureListCode 金禾清单号
     * @date: 2018/4/8 15:43
     * @author: 何伟东
     */
    @RequestMapping(value = "findGisInsureListCodeByBizCode", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, String> findGisInsureListCodeByBizCode(@RequestBody Map<String, String> param)throws Exception;
    @RequestMapping(value = "queryByPolicy", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, List<InsureMainListDto>> queryByPolicy(@RequestBody Map<String, String> param)throws Exception;

    /**
     * 根据投保单单号批量查询金禾的清单号下面的清单信息
     *
     * @param param proposalNos 投保单号码集合
     * @author: 何伟东
     * @date: 2018/4/21 17:43
     */
    @RequestMapping(value = "queryByProposalNos", method = {RequestMethod.POST})
    @ResponseBody
    List<InsureMainListDto> queryByProposalNos(@RequestBody Map<String, List<String>> param) throws Exception;
    /**
     * 根据耳标号和农户姓名查询保单信息
     *
     * @param param proposalNos 投保单号码集合
     * @author: 陈道洋
     * @date: 2018/4/21 17:43
     */
    @RequestMapping(value = "queryByEarableandFname", method = {RequestMethod.POST})
    @ResponseBody
    List<InsureMainListDto> queryByEarableandFname(@RequestBody Map<String, String> param) throws Exception;
}