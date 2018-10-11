package com.sinosoft.dms.api.billno;



import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 11:36:52.998 
 * @description BillNoApi接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = BillNoApi.PATH)
public interface BillNoApi {

    public static final String PATH = "billno";

    /***
     * 投保单号与保单号生成 模板号，条款号 ，批次号
     * @author: 钱浩
     * @date: 2017/10/13 18:21
     * @param   billNoDto 入参对象
     * @return ResponseDto： 投保单号或保单号  模板号，条款号
     * @throws Exception
     */
    @RequestMapping(value = "getBillNo", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,String> getBillNo(@RequestBody BillNoDto billNoDto) throws Exception;

    /**
     * 批单，缴费通知书单号生成
     * @author: 钱浩
     * @date: 2017/10/13 18:22
     * @param   billNoDto 入参对象
     * @return ResponseDto： 批单号或缴费通知书号
     * @throws Exception
     */
    @RequestMapping(value = "getNo", method = RequestMethod.POST)
    public @ResponseBody ResponseDto getNo(@RequestBody BillNoDto billNoDto) throws Exception;


    /**
     * 批单，缴费通知书单号生成
     * @author: 钱浩
     * @date: 2017/10/13 18:22
     * @param tableName 表代码
     * @param policyNo 保单号
     * @return ResponseDto： 批单号或缴费通知书号
     * @throws Exception
     */
    @RequestMapping(value = "getNos", method = RequestMethod.POST)
    public @ResponseBody String getNos(@RequestParam("tableName") String tableName, @RequestParam("policyNo") String policyNo) throws Exception;

    /**
     * 将单号分离成单号头+分组+流水号
     * @author: 宋振振
     * @date: 2017/10/13 18:22
     * @param iTableName
     * @param iBillNo
     * @return String[] 用于内部调用
     * @throws Exception
     */
    @RequestMapping(value = "pickNo", method = RequestMethod.POST)
    public @ResponseBody String[] pickNo(@RequestParam("iTableName") String iTableName, @RequestParam("iBillNo") String iBillNo) throws Exception;
    /**
     * 根据条件删除PrpMaxUse表里面的单号
     * @author: 宋振振
     * @date: 2017/11/8 8:57
     * @param groupNo
     * @param tableName
     * @param maxNo
     * @throws Exception
     */
    @RequestMapping(value = "deleteNo",method = RequestMethod.POST)
    public void deleteNo(@RequestParam("groupNo") String groupNo, @RequestParam("tableName") String tableName, @RequestParam("maxNo") String maxNo)throws Exception;

    /**
     *  生成清单号
     * @param insureListCode 清单号
     * @param riskCode 险种
     * @param areasCode 地域编码
     * @return 清单号
     * @author 王心洋
     * @throws Exception
     * @date 2017年10月19日 下午3:19:42
     */
    @RequestMapping(value = "createInsuranceCode", method = RequestMethod.POST)
    public String createInsuranceCode(@RequestParam(value = "insureListCode") String insureListCode,
                                      @RequestParam(value = "riskCode") String riskCode,
                                      @RequestParam(value = "areasCode") String areasCode) throws Exception;
    /**
     * 删除获取的单号
     * @author: 钱浩
     * @date: 2017/11/23 下午 17:45
     * @param iTableName 表名
     * @param iBillNo 单号
     * @throws
     * @throws Exception
     */
    @RequestMapping(value = "deleteBillNo",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> deleteBillNo(@RequestParam("iTableName") String iTableName, @RequestParam("iBillNo") String iBillNo) throws Exception;

    /**
     * 放回新单号
     * @author: 王保良
     * @date: 2017/12/11 下午 17:45
     * @param map key:TableName 表名
     * @param map key:BillNo 单号
     * @throws Exception
     */
    @RequestMapping(value = "putNo",method = RequestMethod.POST)
    public void putNo(@RequestBody Map<String,String> map)throws Exception;

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
    @RequestMapping(value = "apply",method = RequestMethod.POST)
    public String apply(@RequestBody Map<String,String> map) throws Exception;

}