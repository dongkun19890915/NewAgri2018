package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpDbusinessDataCheckDto;
import com.sinosoft.dms.api.DMSConstant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 01:52:20.999 
 *  业务数据检查表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDbusinessDataCheckApi.PATH)
public interface PrpDbusinessDataCheckApi {

    public static final String PATH = "prpDbusinessDataCheck";

    /**
     * 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    public void save(@RequestBody PrpDbusinessDataCheckDto prpDbusinessDataCheckDto);

    /**
     * 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    public void remove(@RequestParam(value = "id") String id);
    /**
     * 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    public void modify(@RequestBody PrpDbusinessDataCheckDto prpDbusinessDataCheckDto);
    /**
     * 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    public @ResponseBody PrpDbusinessDataCheckDto queryByPK(@RequestParam(value = "id") String id);
}