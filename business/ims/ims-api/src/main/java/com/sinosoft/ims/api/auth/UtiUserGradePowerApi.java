package com.sinosoft.ims.api.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.UtiUserGradePowerDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * @description UtiUserGradePowerApi接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UtiUserGradePowerApi.PATH)
public interface UtiUserGradePowerApi {

    public static final String PATH = "utiUserGradePower";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(UtiUserGradePowerDto utiUserGradePowerDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String comCode, String userCode, String gradeCode, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(UtiUserGradePowerDto utiUserGradePowerDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    UtiUserGradePowerDto queryByPK(String comCode, String userCode, String gradeCode, Integer serialNo);

    /**
     * 业务员特殊批改查询所属机构的业务员
     * @author: 宋振振
     * @date: 2018/3/17 17:22
     * @param map 机构代码和保单号集合
     * @return 业务员名称和代码
     * @throws Exception
     */
    @RequestMapping(value = "queryUserCode",method = {RequestMethod.POST})
    public @ResponseBody List<PrpDuserDto> queryUserCode(@RequestBody Map map)throws Exception;
}