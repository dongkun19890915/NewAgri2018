package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpAddressRespDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCaddressDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 保单保险地址表接口Api接口
 * @Author: 宋振振
 * @Date: 9:00 2017/10/17
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCaddressApi.PATH)
public interface PrpCaddressApi {

    public static final String PATH = "prpaddressprint";

    /**
     *  往PrpCaddress保险地址表信息新增信息
     * @author: 田慧
     * @date: 2017/12/22 15:31
     * @param prpCaddressDto PrpCaddress保险地址表Dto
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpCaddressDto prpCaddressDto);

    /**
     *  根据主键删除PrpCaddress保险地址表信息
     * @author: 田慧
     * @date: 2017/12/22 15:33
     * @param map 键为policyNo保单号码 、addressNo地址序号
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestBody Map<String,Object> map);

    /**
     *  修改PrpCaddress保险地址表信息
     * @author: 田慧
     * @date: 2017/12/22 15:27
     * @param prpCaddressDto PrpCaddress保险地址表Dto
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpCaddressDto prpCaddressDto);

    /**
     *  根据主键查询PrpCaddress保险地址表信息
     * @author: 田慧
     * @date: 2017/12/22 15:18
     * @param map 键为policyNo保单号码 、addressNo地址序号
     * @return PrpCaddressDto
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpCaddressDto queryByPK(@RequestBody Map<String,Object> map);
    /**
     * 根据投保单号或保单号查询标的地址打印信息
     * @author: 宋振振
     * @date: 2017/10/17 9:00
     * @param bizType  保单类型（PROPOSAL或POLICY）
     * @param bizNo 数据号（投保单号或保单号）
     * @return PrpAddressRespDto 返回标的地址打印信息
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpaddressPrintByCondition",method = {RequestMethod.POST})
    public @ResponseBody
    PrpAddressRespDto queryPrpaddressPrintByCondition(@RequestParam(value = "bizType") String bizType, @RequestParam(value = "bizNo") String bizNo) throws Exception;
}