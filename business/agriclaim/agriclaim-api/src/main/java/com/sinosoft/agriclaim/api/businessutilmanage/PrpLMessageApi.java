package com.sinosoft.agriclaim.api.businessutilmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLMessageDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestPrpLMessageDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestSavePrpLMessageDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponsePrpLMessageDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔流转讨论留言表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLMessageApi.PATH)
public interface PrpLMessageApi {

    public static final String PATH = "prpLMessage";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLMessageDto prpLMessageDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String registNo,java.lang.Integer serialNo,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLMessageDto prpLMessageDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLMessageDto queryByPK(String registNo,java.lang.Integer serialNo,java.lang.Integer lineNo);

    /**
     * （查看理赔沟通页面信息）
     * @param requestPrpLMessageDto 查询理赔沟通页面所需条件
     * @return 理赔沟通页面显示信息
     * @author: 董坤
     * @date: 2017/11/15 19:56
     */
    @RequestMapping(value = "queryClaimCommunicationByCondition",method = {RequestMethod.POST})
    @ResponseBody
    ResponsePrpLMessageDto queryClaimCommunicationByCondition(@RequestBody RequestPrpLMessageDto requestPrpLMessageDto);
    /**
     * （保存理赔沟通页面信息）
     * @author: 董坤
     * @date: 2017/11/15 21:11
     * @param requestSavePrpLMessageDto 理赔沟通保存的页面信息
     * @return 保存成功与否信息
     */
    @RequestMapping(value = "saveClaimCommunicationInfo",method = {RequestMethod.POST})
    @ResponseBody
    Map<String,String> saveClaimCommunicationInfo(@RequestBody RequestSavePrpLMessageDto requestSavePrpLMessageDto) throws Exception;

    /**
     * 查询留言列表
     * @author: 孙朋飞
     * @date: 2018/4/3 9:30
     * @param map registNo 报案号
     * @return 各节点留言
     * @throws Exception
     */
    @RequestMapping(value="queryPrpLMessageByRegistNo",method = {RequestMethod.POST})
    public @ResponseBody List<PrpLMessageDto> queryPrpLMessageByRegistNo(@RequestBody Map<String,String> map) throws Exception;
}