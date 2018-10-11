package com.sinosoft.dms.web.customer;

import com.sinosoft.dms.api.customer.PrpDcustomerUnitApi;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerUnitDto;
import com.sinosoft.dms.core.customer.service.PrpDcustomerUnitService;
import com.sinosoft.framework.dto.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-09 11:34:12.554 
 * @description 集体客户代码表controller层
 */
@RestController
@RequestMapping(value = PrpDcustomerUnitController.PATH)
public class PrpDcustomerUnitController implements PrpDcustomerUnitApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDcustomerUnitController.class);

    @Resource
    private PrpDcustomerUnitService prpDcustomerUnitService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDcustomerUnitDto prpDcustomerUnitDto) {
        prpDcustomerUnitService.save(prpDcustomerUnitDto);
    }
    /**
     * 保存集体客户信息
     * @author: 田健
     * @date: 2017/12/28 11:09
     * @param prpDcustomerUnitDtos 集体客户信息集合
     * @Return 返回成功
     */
    @Override
    public String saveByList(@RequestBody List<PrpDcustomerUnitDto> prpDcustomerUnitDtos) {
        prpDcustomerUnitService.saveByList(prpDcustomerUnitDtos);
        return "Success";
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("customercode") String customercode) {
        prpDcustomerUnitService.remove(customercode);
    }

    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDcustomerUnitDto prpDcustomerUnitDto) {
        prpDcustomerUnitService.modify(prpDcustomerUnitDto);
    }
    /**
     * （根据客户代码查询团体客户风险等级信息）
     * @author: 赵鹏
     * @date: 2017/12/17 13:22
     * @param customercode （客户代码）
     * @return PrpDcustomerUnitDto（客户风险等级信息列表）
     * @throws Exception
     */
    public @ResponseBody
    PrpDcustomerUnitDto queryByPK(@RequestParam("customercode") String customercode) {
        return prpDcustomerUnitService.queryByPK(customercode);
    }

    /**
     * （查询团体客户风险等级信息）
     * @author: 赵鹏
     * @date: 2017/12/17 13:22
     * @param prpDcustomerUnitDto （查询条件，客户类型，证件类型，证件号码）
     * @return PrpDcustomerUnitDto（客户风险等级信息 列表）
     * @throws Exception
     */
    public  @ResponseBody PageInfo<PrpDcustomerUnitDto> queryAllUnit(@RequestBody  PrpDcustomerUnitDto prpDcustomerUnitDto) {
        return prpDcustomerUnitService.queryAllUnit(prpDcustomerUnitDto);
    }

    @Override
    public List<PrpDcustomerUnitDto> queryByInsureName(@RequestBody Map<String, String> map) throws Exception {
        return prpDcustomerUnitService.queryByInsureName(map.get("insureName"));
    }
}
