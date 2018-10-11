package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PrpCaddressApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpAddressRespDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCaddressDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCaddressService;
import com.sinosoft.framework.dto.ResponseDto;
import feign.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
* @Description: 保单保险地址表controller层
* @Author: 宋振振
* @Date: 9:00 2017/10/17
*/
@RestController
@RequestMapping(value = PrpCaddressController.PATH)
public class PrpCaddressController implements PrpCaddressApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpCaddressController.class);

    @Autowired
    private PrpCaddressService prpCaddressService;
    /**
     *  往PrpCaddress保险地址表信息新增信息
     * @author: 田慧
     * @date: 2017/12/22 15:31
     * @param prpCaddressDto PrpCaddress保险地址表Dto
     */
    public void save(@RequestBody PrpCaddressDto prpCaddressDto) {
        prpCaddressService.save(prpCaddressDto);
    }

    /**
     *  根据主键删除PrpCaddress保险地址表信息
     * @author: 田慧
     * @date: 2017/12/22 15:33
     * @param map 键为policyNo保单号码 、addressNo地址序号
     */
    public void remove(@RequestBody Map<String,Object> map) {
        String policyNo = (String) map.get("policyNo");
        Integer addressNo = (Integer) map.get("addressNo");
        prpCaddressService.remove(policyNo,addressNo);
    }
    /**
     *  修改PrpCaddress保险地址表信息
     * @author: 田慧
     * @date: 2017/12/22 15:27
     * @param prpCaddressDto PrpCaddress保险地址表
     */
    public void modify(@RequestBody PrpCaddressDto prpCaddressDto) {
        prpCaddressService.modify(prpCaddressDto);
    }
    /**
     *  根据主键查询PrpCaddress保险地址表信息
     * @author: 田慧
     * @date: 2017/12/22 15:18
     * @param map 键为policyNo保单号码 、addressNo地址序号
     * @return PrpCaddressDto
     */
    public PrpCaddressDto queryByPK(@RequestBody Map<String,Object> map) {
        String policyNo = (String) map.get("policyNo");
        Integer addressNo = (Integer) map.get("addressNo");
        return prpCaddressService.queryByPK(policyNo,addressNo);
    }
    /**
     * 根据投保单号或保单号查询标的地址打印信息
     * @author: 宋振振
     * @date: 2017/10/17 9:00
     * @param bizType 保单类型（PROPOSAL或POLICY）
     * @param bizNo 数据号（投保单号或保单号）
     * @return PrpAddressRespDto 返回标的地址打印信息
     * @throws Exception
     */
    public @ResponseBody
    PrpAddressRespDto queryPrpaddressPrintByCondition(@RequestParam(value = "bizType") String bizType, @RequestParam(value = "bizNo") String bizNo) throws Exception{
        return prpCaddressService.queryPrpaddressPrintByCondition(bizType,bizNo);
    }

}
