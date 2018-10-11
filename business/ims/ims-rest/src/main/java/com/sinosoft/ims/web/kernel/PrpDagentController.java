package com.sinosoft.ims.web.kernel;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.kernel.PrpDagentApi;
import com.sinosoft.ims.api.kernel.dto.AgentReqDto;
import com.sinosoft.ims.api.kernel.dto.PrpDagentDto;
import com.sinosoft.ims.core.kernel.service.PrpDagentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @Description: 中介机构代码表Controller层
* @Author: 宋振振
* @Date: 10:55 2017/10/10
*/
@RestController
@RequestMapping(value = PrpDagentController.PATH)
public class PrpDagentController implements PrpDagentApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDagentController.class);

    @Autowired
    private PrpDagentService prpDagentService;
    private String validStatus="1";
    /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDagentDto prpDagentDto) {
        prpDagentService.save(prpDagentDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String agentCode) {
        prpDagentService.remove(agentCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDagentDto prpDagentDto) {
        prpDagentService.modify(prpDagentDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpDagentDto queryByPK(@RequestBody String agentCode) {
        return prpDagentService.queryByPK(agentCode);
    }
    /**
     * 根据条件查询代理人/经纪人信息
     * @author: 宋振振
     * @date: 2017/10/10 10:55
     * @param  agentReqDto 代理人/经纪人查询请求参数的Dto
     * @return List<PrpDagentDto> 返回代理人/经纪人信息
     * @throws Exception
     */
    public  @ResponseBody List<PrpDagentDto> queryAgentInfo(@RequestBody AgentReqDto agentReqDto) throws Exception{
        return  prpDagentService.queryAgentInfo(agentReqDto,validStatus);
    }
}
