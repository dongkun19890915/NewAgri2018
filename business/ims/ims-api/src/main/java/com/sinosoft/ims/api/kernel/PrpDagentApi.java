package com.sinosoft.ims.api.kernel;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.AgentReqDto;
import com.sinosoft.ims.api.kernel.dto.PrpDagentDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: 中介机构代码表Api接口
 * @Author: 宋振振
 * @Date: 10:55 2017/10/10
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = PrpDagentApi.PATH)
public interface PrpDagentApi {

    public static final String PATH = "prpdagent";
    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDagentDto prpDagentDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String agentCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDagentDto prpDagentDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDagentDto queryByPK(String agentCode);
    /**
     * 根据条件查询代理人/经纪人信息
     * @author: 宋振振
     * @date: 2017/10/10 10:55
     * @param  agentReqDto 代理人/经纪人查询请求参数的Dto
     * @return List<PrpDagentDto> 返回代理人/经纪人信息
     * @throws Exception
     */
    @RequestMapping(value = "queryAgentInfo", method = RequestMethod.POST)
    public @ResponseBody List<PrpDagentDto> queryAgentInfo(@RequestBody AgentReqDto agentReqDto) throws Exception;

}