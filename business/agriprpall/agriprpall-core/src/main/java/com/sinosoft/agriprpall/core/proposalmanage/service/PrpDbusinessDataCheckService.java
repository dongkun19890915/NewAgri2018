package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpDbusinessDataCheckDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 01:52:20.999 
 *  业务数据检查表Core接口
 */
public interface PrpDbusinessDataCheckService {

    /**
     * 新增
     *@param
     */
    void save(@RequestBody PrpDbusinessDataCheckDto prpDbusinessDataCheckDto);

    /**
     * 删除
     *@param
     */
    void remove(@RequestParam(value = "id") String id);
    /**
     * 修改
     *@param
     */
    void modify(@RequestBody PrpDbusinessDataCheckDto prpDbusinessDataCheckDto);
    /**
     * 按主键查询实体
     *@param 
     */
    public @ResponseBody PrpDbusinessDataCheckDto queryByPK(@RequestParam(value ="id") String id);
}