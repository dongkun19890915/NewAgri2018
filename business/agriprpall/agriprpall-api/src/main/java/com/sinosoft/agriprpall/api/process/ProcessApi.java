package com.sinosoft.agriprpall.api.process;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = ProcessApi.PATH)
public interface ProcessApi {
    String PATH = "process";

    /**
     * 生成节点数据
     *
     * @param processDto 节点相关的信息
     * @date: 2018/4/4 15:29
     * @author: 何伟东
     */
    @RequestMapping(value = "generateNodeData", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> generateNodeData(@RequestBody ProcessDto processDto);

    /**
     * 生成多个节点数据（用于自动生成下一节点数据）
     *
     * @param processDtos 多个节点相关的信息
     * @date: 2018/4/4 15:29
     * @author: 何伟东
     */
    @RequestMapping(value = "generateMultipleNodeData", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> generateMultipleNodeData(@RequestBody List<ProcessDto> processDtos);
}
