package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTinsuredDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 保险关系人表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpTinsuredApi.PATH)
public interface PrpTinsuredApi {

    public static final String PATH = "prpTinsured";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpTinsuredDto prpTinsuredDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String proposalNo, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpTinsuredDto prpTinsuredDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpTinsuredDto queryByPK(@RequestParam("proposalNo") String proposalNo, @RequestParam("serialNo") Integer serialNo);

    /**
     *  根据投保单号查询prpTinsured表信息
     * @author: 田慧
     * @date: 2017/11/20 15:50
     * @param map 包括proposalNo投保单号
     * @return prpTinsuredDtoList 返回PrpTinsuredDto的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByPolicyNo",method = {RequestMethod.POST})
    public List<PrpTinsuredDto> queryByPolicyNo(@RequestBody Map<String,String> map)throws Exception;
    /**
     *  根据投保单号、关系人标识查询prpTinsured保险关系人表表信息
     * @author: 田慧
     * @date: 2017/11/20 13:49
     * @param map 包括 proposalNo 投保单号\insuredFlag 关系人标识
     * @return prpTinsuredDtoList 返回保险关系人表Dto的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByCondition",method = {RequestMethod.POST})
    public List<PrpTinsuredDto> queryByCondition(@RequestBody Map<String,String> map) throws Exception;
}