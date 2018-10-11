package com.sinosoft.dms.web.billno;

import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.dms.core.billno.service.BillNoService;
import com.sinosoft.dms.core.customer.service.PrpDcustomerService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-10 11:36:52.998
 * @description UtiKeycontroller层
 */
@RestController
@RequestMapping(value = BillNoController.PATH)
public class BillNoController implements BillNoApi {

    private static Logger LOGGER = LoggerFactory.getLogger(BillNoController.class);

    @Autowired
    private BillNoService billNoService;
    @Autowired
    private PrpDcustomerService prpDcustomerService;

    /***
     * 投保单号与保单号生成 模板号，条款号，批次号
     * @author: 钱浩
     * @date: 2017/10/13 18:21
     * @param   billNoDto 入参对象
     * @return ResponseDto： 投保单号或保单号  模板号，条款号
     * @throws Exception
     */
    @Override
    public Map<String, String> getBillNo(@RequestBody BillNoDto billNoDto) throws Exception {
        String tableName = billNoDto.getTableName();
        String riskCode = billNoDto.getRiskCode();
        String iComCode = billNoDto.getiComCode();
        String iYear = billNoDto.getiYear();
        String userCode = billNoDto.getUserCode();
        return billNoService.getBillNo(tableName, riskCode, iComCode, iYear, userCode);
    }

    /**
     * 批单，缴费通知书单号生成
     *
     * @param billNoDto 入参对象
     * @return ResponseDto： 批单号或缴费通知书号
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/10/13 18:22
     */
    @Override
    public ResponseDto getNo(@RequestBody BillNoDto billNoDto) throws Exception {
        String tableName = billNoDto.getTableName();
        String policyNo = billNoDto.getPolicyNo();
        return ResponseDto.instance(billNoService.getNo(tableName, policyNo));
    }

    /**
     * 批单，缴费通知书单号生成
     *
     * @param tableName 表代码
     * @param policyNo  保单号
     * @return 批单号或缴费通知书号
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/10/13 18:22
     */
    @Override
    public String getNos(String tableName, String policyNo) throws Exception {
        return billNoService.getNo(tableName, policyNo);
    }


    /**
     * 将单号分离成单号头+分组+流水号
     *
     * @param iTableName
     * @param iBillNo
     * @return String[] 用于内部调用
     * @throws Exception
     * @author: 宋振振
     * @date: 2017/10/13 18:22
     */
    @Override
    public String[] pickNo(String iTableName, String iBillNo) throws Exception {
        return billNoService.pickNo(iTableName, iBillNo);
    }

    /**
     * 根据条件删除PrpMaxUse表里面的单号
     *
     * @param groupNo
     * @param tableName
     * @param maxNo
     * @throws Exception
     * @author: 宋振振
     * @date: 2017/11/8 8:57
     */
    @Override
    public void deleteNo(String groupNo, String tableName, String maxNo) throws Exception {
        billNoService.deleteNo(groupNo, tableName, maxNo);
    }

    /**
     * 生成清单号
     *
     * @param insureListCode 清单号
     * @param riskCode       险种
     * @param areasCode      地域编码
     * @return 清单号
     * @throws Exception
     * @author 王心洋
     * @date 2017年10月19日 下午3:19:42
     */
    @Override
    public String createInsuranceCode(String insureListCode, String riskCode, String areasCode) throws Exception {
        return billNoService.createInsuranceCode(insureListCode, riskCode, areasCode);
    }

    /**
     * 成功后删除获取的单号
     *
     * @param iTableName 表名
     * @param iBillNo    单号
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/23 下午 17:45
     */
    @Override
    public @ResponseBody
    Map<String, String> deleteBillNo(@RequestParam("iTableName") String iTableName, @RequestParam("iBillNo") String iBillNo) throws Exception {
        billNoService.deleteBillNo(iTableName, iBillNo);
        Map<String, String> map = new HashMap<String, String>();
        map.put("message", "删除成功!");
        return map;
    }

    /**
     * 放回新单号
     * @author: 王保良
     * @date: 2017/12/11 下午 17:45
     * @param iTableName 表名
     * @param iBillNo 单号
     * @throws Exception
     */
    @Override
    public void putNo(@RequestBody Map<String,String> map) throws Exception {
        billNoService.putNo(map.get("tableName"),map.get("billNo"));
    }

    /**
     * 生成客户号
     *
     * @param iCustomerType 客户类型
     * @param iMakeCom
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 2017/10/20 19:36
     */
    @Override
    public String apply(@RequestBody Map<String, String> map) throws Exception {
        return prpDcustomerService.apply(map.get("iCustomerType"),map.get("iMakeCom"));
    }


}
