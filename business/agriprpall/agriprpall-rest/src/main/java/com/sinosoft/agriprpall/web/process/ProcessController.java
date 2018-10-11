package com.sinosoft.agriprpall.web.process;

import com.sinosoft.agriprpall.api.process.ProcessApi;
import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程节点数据生成
 *
 * @date: 2018/4/4 15:27
 * @author: 何伟东
 */
@RestController
@RequestMapping(value = ProcessController.PATH)
public class ProcessController implements ProcessApi {


    @Autowired
    private ProcessService processService;

    @Override
    public @ResponseBody
    Map<String, String> generateNodeData(@RequestBody ProcessDto processDto) {
        Map<String, String> returnMap = new HashMap<>(1);
        try {
            processService.generateNodeData(processDto);
        } catch (Exception e) {
            returnMap.put("message", e.getMessage());
        }
        return returnMap;
    }

    @Override
    public @ResponseBody
    Map<String, String> generateMultipleNodeData(List<ProcessDto> processDtos) {
        Map<String, String> returnMap = new HashMap<>(1);
        for (ProcessDto processDto : processDtos) {
            try {
                processService.generateNodeData(processDto);
            } catch (Exception e) {
                returnMap.put("message", e.getMessage());
            }
        }
        return returnMap;
    }
}
