package com.sinosoft.dms.core.billno.service;


import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 11:36:52.998 
 * @description UtiKeyCore接口
 */
public interface BillNoService {

    /***
     * 投保单号与保单号生成 模板号，条款号，批次号
     * @author: 钱浩
     * @date: 2017/10/13 18:21
     * @param   tableName 表单
     * @param  riskCode 险种
     * @param iComCode 机构代码
     * @param  iYear 年份
     * @return ResponseDto： 投保单号或保单号  模板号，条款号
     * @throws Exception
     */
    public Map<String,String> getBillNo(String tableName, String riskCode, String iComCode, String iYear, String userCode) throws Exception;

    /**
     * 批单，缴费通知书单号生成
     * @author: 钱浩
     * @date: 2017/10/13 18:22
     * @param tableName 表代码
     * @param policyNo 保单号
     * @return ResponseDto： 批单号或缴费通知书号
     * @throws Exception
     */
    public String  getNo(String tableName, String policyNo) throws Exception;


    /**
     * 将单号分离成单号头+分组+流水号
     * @author: 宋振振
     * @param iTableName
     * @param iBillNo
     * @return String[] 用于内部调用
     * @throws Exception
     */
    public String[] pickNo(String iTableName, String iBillNo) throws Exception;
    /**
     * 根据条件删除PrpMaxUse表里面的单号
     * @author: 宋振振
     * @date: 2017/11/8 8:57
     * @param groupNo
     * @param tableName
     * @param maxNo
     * @throws Exception
     */
    public  void deleteNo(String groupNo, String tableName, String maxNo)throws Exception;


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
    public String createInsuranceCode(String insureListCode, String riskCode, String areasCode) throws Exception;
    /**
     * 成功后删除获取的单号
     * @author: 钱浩
     * @date: 2017/11/23 下午 17:45
     ** @param iTableName 表名
     * @param iBillNo 单号
     * @throws Exception
     */
    public void deleteBillNo(String iTableName, String iBillNo) throws Exception;

    /**
     * 放回新单号
     * @author: 王保良
     * @date: 2017/12/11 下午 17:45
     * @param iTableName 表名
     * @param iBillNo 单号
     * @throws Exception
     */
    public void putNo(String tableName, String billNo)throws Exception;
}