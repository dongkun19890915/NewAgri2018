package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;
/**
 * @description 核保通过后将CP表中的最新数据写入到C表中
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
public interface SaveCPtoCService {
    public boolean saveCPtoC(String policyNo) throws Exception;
}
