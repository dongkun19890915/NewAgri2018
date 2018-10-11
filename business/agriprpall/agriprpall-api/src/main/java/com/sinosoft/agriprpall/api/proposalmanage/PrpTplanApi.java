package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTplanDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
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
 * @description 收费计划表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpTplanApi.PATH)
public interface PrpTplanApi {

    public static final String PATH = "prpTplan";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpTplanDto prpTplanDto);

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
    void modify(PrpTplanDto prpTplanDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpTplanDto queryByPK(String proposalNo, Integer serialNo);

    /**
     *  根据投保单号查询prpTplan 收费计划表详细信息
     * @author: 田慧
     * @date: 2017/11/20 9:39
     * @param map 包括proposalNo投保单号
     * @return prpTplanDtoList  返回收费计划表Dto集合
     */
    @RequestMapping(value = "queryByProposalNo",method = {RequestMethod.POST})
    public List<PrpTplanDto> queryByProposalNo(@RequestBody Map<String,String> map)throws Exception;
}