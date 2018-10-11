package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCinsuredDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.RequestPrpCinsuredDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * *PrpCinsured的Api接口
 * @Author: 田慧
 * @Date: 2017/11/20 16:27
 */

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCinsuredApi.PATH)
public interface PrpCinsuredApi {
    public static final String PATH = "prpCinsured";
    /**
     * 根据主键查询prpCinsured 投保人被保险人关系表信息
     * @author: 田慧
     * @date: 2017/11/20 16:35
     * @param requestPrpCinsuredDto 包括policyNo保单号、serialNo 序号
     * @return  返回 PrpCinsuredDto
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpCinsuredDto queryByPK(@RequestBody RequestPrpCinsuredDto requestPrpCinsuredDto);
    /**
     *   根据保单号查询prpCinsured 投保人被保险人关系表信息
     * @author: 田慧
     * @date: 2017/11/20 16:19
     * @param  map 包括policyNo保单号
     * @return prpCinsuredDtoList 返回prpCinsuredDto的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByPolicyNo",method = {RequestMethod.POST})
    public List<PrpCinsuredDto> queryByPolicyNo(@RequestBody Map<String,String> map)throws Exception;
/**
 *  根据保单号、关系人标识查询prpCinsured 投保人被保险人关系表信息
 * @author: 田慧
 * @date: 2017/11/20 16:51
 * @param map 包括policyNo保单号、insuredFlag关系人标识
 * @return prpCinsuredDtoList 返回prpCinsuredDto的集合
 * @throws Exception
 */
@RequestMapping(value = "queryByCondition",method = {RequestMethod.POST})
public List<PrpCinsuredDto> queryByCondition(@RequestBody Map<String,String> map)throws Exception;
    /**
     *  根据身份证查询PrpCinsuredDto投保人被保险人关系表Dto结果集
     * @author: 田慧
     * @date: 2017/11/22 10:20
     * @param map 包括policyNo保单号、dentifyNumber 身份证件号
     * @return 返回prpCinsuredDtoList 投保人被保险人关系表Dto的集合
     */
    @RequestMapping(value = "queryPolicyNoByID",method = {RequestMethod.POST})
    public List<PrpCinsuredDto> queryPolicyNoByID(@RequestBody Map<String,String> map)throws Exception;

    @RequestMapping(value = "queryPolicyById",method = RequestMethod.POST)
    public List<PrpCmainDto> queryPolicyById(@RequestBody Map<String,String> map) throws Exception;

    /**
     * （查询被保险人代码）
     * @author: 王志文
     * @date: 2018/3/31 18:14
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryInsuredCodeByPolicyNoAndInsuredName",method = RequestMethod.POST)
    List<PrpCinsuredDto> queryInsuredCodeByPolicyNoAndInsuredName(@RequestBody Map<String,String> map)throws Exception;


    /**
     * 根据被保险人代码查询被保险人信息
     * @author: 王志文
     * @date: 2018/3/31 18:14
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryByInsuredCode",method = RequestMethod.POST)
    List<PrpCinsuredDto> queryByInsuredCode(@RequestBody Map<String,String> map )throws Exception;
}
