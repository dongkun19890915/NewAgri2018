package com.sinosoft.agriprpall.core.process.service;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;

public interface ProcessService {

    void generateNodeData(ProcessDto processDto) throws Exception;
}
