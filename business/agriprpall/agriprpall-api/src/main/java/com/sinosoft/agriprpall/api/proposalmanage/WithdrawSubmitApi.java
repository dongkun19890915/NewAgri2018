package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTrenewalDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:33:55.391 
 * @description PrpTrenewalApi接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = WithdrawSubmitApi.PATH)
public interface WithdrawSubmitApi {

    public static final String PATH = "submitform";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpTrenewalDto prpTrenewalDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String proposalNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpTrenewalDto prpTrenewalDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpTrenewalDto queryByPK(String proposalNo);

    /**
     *  撤单
     * @author: 钱浩
     * @date: 2017/10/22 16:30
     * @param map:proposalNo 投保单号
     * @return ResponseDto： 撤单状态：成功或失败
     * @throws Exception
     */
    @RequestMapping(value = "withdrawProposal",method = {RequestMethod.POST})
    public @ResponseBody
    Map<String,String> withdrawProposal(@RequestBody Map<String,String> map)throws  Exception;
    }