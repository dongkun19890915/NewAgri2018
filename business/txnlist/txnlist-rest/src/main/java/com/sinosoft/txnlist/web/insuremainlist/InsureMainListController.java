package com.sinosoft.txnlist.web.insuremainlist;

import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainList;
import com.sinosoft.txnlist.core.insuremainlist.service.InsureMainListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 07:14:54.112 
 * @description 清单主表controller层
 */
@RestController
@RequestMapping(value = InsureMainListController.PATH)
public class InsureMainListController implements InsureMainListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(InsureMainListController.class);

    @Autowired
    private InsureMainListService insureMainListService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public String save(@RequestBody InsureMainListDto insureMainListDto)throws Exception {
        insureMainListService.save(insureMainListDto);
        return "success";

    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestParam("inusreListCode") String inusreListCode) {
        insureMainListService.remove(inusreListCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody InsureMainListDto insureMainListDto) {
        insureMainListService.modify(insureMainListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public @ResponseBody InsureMainListDto queryByPK(@RequestParam("inusreListCode") String inusreListCode) {
        return insureMainListService.queryByPK(inusreListCode);
    }

    /**
     * @description: 按照投保单号查询
     * @author: 何伟东
     * @date: 2017/10/26 9:17
     * @param proposalNo
     * @return
     */
    @Override
    public @ResponseBody List<InsureMainListDto> queryByProposalNo(@RequestParam("proposalNo") String proposalNo) {
        return insureMainListService.queryByProposalNo(proposalNo);
    }

    /**
     * @description: 按照保单号查询集合
     * @author: 王心洋
     * @date: 2017/11/08
     * @param policyNo
     * @return List
     */
    @Override
    public @ResponseBody List<InsureMainListDto> queryByPolicyNo(@RequestParam("policyNo") String policyNo) throws Exception{
        return insureMainListService.queryByPolicyNo(policyNo);
    }

    /**
     * 根据清单编号回写投保单号和清单标志
     * @author: 陈道洋
     * @date: 2017/11/15 17:37
     * @param inusreListCode 清单编号
     * @param proposalNo 投保单号
     * @param validity 清单标志
     * @throws Exception
     */
    @Override
    public void relatedInsuranceNo(@RequestParam("inusreListCode") String inusreListCode, @RequestParam("proposalNo") String proposalNo, @RequestParam("validity") String validity) throws Exception {
        insureMainListService.relatedInsuranceNo(inusreListCode,proposalNo,validity);
    }

    /**
     * @description: 方法功能简述：根据保单号查清单信息
     * @author: 杨成程
     * @date: 2017/11/28 11:44
     * @param policyNo
     * @return
     * @throws
     */
    @Override
    public @ResponseBody List<InsureMainListDto> queryByPolicyNoAndValidity(@RequestParam("policyNo") String policyNo){
        return insureMainListService.queryByPolicyNoAndValidity(policyNo);
    }
    /**
     * @description: 方法功能简述：根据投保单清单编号查清单信息
     * @author: majunlng
     * @date: 2017/11/28 11:44
     * @param  map insureListCode
     * @return insureMainListList
     */
    @Override
    @RequestMapping(value = "queryByCondition",method = {RequestMethod.POST})
    public @ResponseBody List<String> queryByCondition( @RequestBody Map<String,String> map) {
        String strFname=map.get("strFname");
        String strFCardID=map.get("strFCardID");
        return insureMainListService.queryByCondition(strFname,strFCardID);
    }
    /**
     * @description: 方法功能简述：根据投保单清单编号查清单信息
     * @author: majunlng
     * @date: 2017/11/28 11:44
     * @param insureListCode
     * @return insureMainListList
     */
    @Override
    public @ResponseBody List<InsureMainListDto> queryByInsureListCode(@RequestParam(value = "insureListCode") String insureListCode) throws Exception {
        return insureMainListService.findByInsureListCode(insureListCode);
    }
    /**
     * 判断有无此清单号
     * @param map 中key insureListCode 清单号
     * @return String Y：有此清单号；N：无此清单号
     * @throws Exception
     * @author: 李冬松
     * @date: 2018/1/16 11:44
     */
    @Override
    public @ResponseBody Map<String,String> isInInsureMainList(@RequestBody Map<String, String> map) throws Exception {
        return insureMainListService.isInInsureMainList(map.get("insureListCode"));
    }

    @Override
    public Integer queryFarmerNumber(@RequestBody Map<String, String> map) throws Exception {
        return insureMainListService.queryFarmerNumber(map.get("policyNo"));
    }

    /**
     * 根据金禾清单编号查询保单号
     * @author: 刘曼曼
     * @date: 12:07 12:07
     * @param map 金禾清单编号
     * @return  List<String> 保单号
     * @throws Exception
     */
    @Override
    public @ResponseBody List<String> queryByGisInsureListCode(@RequestBody Map<String, String> map) throws Exception{
        return insureMainListService.queryByGisInsureListCode(map.get("gisInsureListCode"));
    }
    /**
     * 根据金禾清单编号查询保单号
     * @author: 刘曼曼
     * @date: 12:07 12:07
     * @param map 金禾清单编号
     * @return  List<String> 保单号
     * @throws Exception
     */
    @Override
    public @ResponseBody List<InsureMainListDto> findAllByProposalNos(@RequestBody Map<String, List<String>> map) throws Exception{
        return insureMainListService.findAllByProposalNos(map.get("proposalNos"));
    }
    /**
     * 根据金禾清单编号查询投保单号
     * @author: 汪强
     * @date: 12:07 12:07
     * @param map 金禾清单编号
     * @return  List<String> 投保单号
     * @throws Exception
     */
    @Override
    public @ResponseBody List<String> queryByGisProposalNo(@RequestBody Map<String,List<String>> map) throws Exception{
        return insureMainListService.queryByGisProposalNo(map.get("proposalNos"));
    }

    /**
     * 根据业务号码（投保单号、保单号、批单号）查询金禾的清单号
     *
     * @param param bizCode-业务号
     * @return gisInsureListCode 金禾清单号
     * @date: 2018/4/8 15:43
     * @author: 何伟东
     */
    @Override
    public @ResponseBody
    Map<String, String> findGisInsureListCodeByBizCode(@RequestBody Map<String, String> param)throws Exception {
        String gisInsureListCode = insureMainListService.findGisInsureListCodeByBizCode(param.get("bizCode"));
        Map<String, String> returnMap = new HashMap<>(1);
        returnMap.put("gisInsureListCode", gisInsureListCode);
        return returnMap;
    }

    @Override
    public @ResponseBody Map<String, List<InsureMainListDto>> queryByPolicy(@RequestBody Map<String, String> param) throws Exception {
        Map<String,List<InsureMainListDto>> returnMap=new HashMap<>();
        returnMap.put("insureMainList",insureMainListService.queryByPolicyNo(param.get("policyNo")));

        return returnMap;
    }

    /**
     * 根据投保单单号批量查询金禾的清单号下面的清单信息
     *
     * @param param proposalNos 投保单号码集合
     * @author: 何伟东
     * @date: 2018/4/21 17:43
     */
    @Override
    public @ResponseBody List<InsureMainListDto> queryByProposalNos(@RequestBody Map<String, List<String>> param) throws Exception {
        return insureMainListService.queryByProposalNos(param.get("proposalNos"));
    }
    /**
     * 根据耳标号和农户姓名查询保单信息
     *
     * @param param proposalNos 投保单号码集合
     * @author: 陈道洋
     * @date: 2018/4/21 17:43
     */

  public  @ResponseBody List<InsureMainListDto> queryByEarableandFname(@RequestBody Map<String, String> param) throws Exception{
        String earlAbel =param.get("earlAbel");
        String fName =param.get("fName");
      return insureMainListService.queryByEarableandFname(earlAbel,fName);
    }
}
