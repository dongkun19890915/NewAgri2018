package com.sinosoft.agriprpall.api.policymanage;
import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 03:00:08.517
 * @description 收费计划表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCplanApi.PATH)
public interface PrpCplanApi {

    public static final String PATH = "prpCplan";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpCplanDto prpCplanDto);

    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpCplanDto prpCplanDto);

    /**
     * 理赔调用服务，查询未缴费的条数
     * @author: 田健
     * @date: 2017/11/10 17:15
     * @param policyNo 保单号
     * @return 查询到的数量（int)
     */
    @RequestMapping(value = "queryPays",method = {RequestMethod.POST})
    long queryPays(@RequestParam("policyNo") String policyNo);
    /**
     * 理赔调用服务，查询计划缴费和已缴费
     * @author: 田健
     * @date: 2017/11/11 11:11
     * @param policyNo 保单号
     * @return int[] 期数
     */
    @RequestMapping(value = "getDelinquentfeeTime",method = {RequestMethod.POST})
    int[] getDelinquentfeeTime(@RequestParam("policyNo") String policyNo);
    /**
     * 根据保单号查询收费计划表PrpCplan
     * @author: 宋振振
     * @date: 2017/11/11 14:38
     * @param policyNo
     * @return Map<String,String>返回应交费金额总数，拖欠金额总数
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpCplanByPolicyNo",method = {RequestMethod.POST})
    public @ResponseBody
    Map<String,String> queryPrpCplanByPolicyNo(@RequestParam("policyNo") String policyNo) throws Exception;

    /**
     *  根据保单号查询收费计划表prpCplan表信息
     * @author: 田慧
     * @date: 2017/11/20 9:54
     * @param map 包括policyNo保单号
     * @return prpCplanDtoList 返回PrpCplanDto的集合
     */
    @RequestMapping(value = "queryByPolicyNo",method = {RequestMethod.POST})
    public List<PrpCplanDto> queryByPolicyNo(@RequestBody Map<String,String> map)throws Exception;

    /**
     * @description: （按保单号查询所有的数据，保单抄件用）
     * @author: 王志文
     * @date: 2017/11/16 9:27
     * @param policyNo
     * @return
     */
    @RequestMapping(value = "queryPrpCplanListByPolicyNo",method = {RequestMethod.POST})
    List<PrpCplanDto> queryPrpCplanListByPolicyNo(@RequestParam("policyNo") String policyNo)throws Exception;
}