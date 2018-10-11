package com.sinosoft.agriclaim.core.claimmanage.utils;

import java.util.HashMap;
import java.util.Map;

public class GetPayStatusFlagUtil {

    public static Map<String,String> getPayStatusFlag(){
        Map<String,String> map = new HashMap<>();
        map.put("0","待提交");
        map.put("1","待审核");
        map.put("2","审核不通过");
        map.put("3","支付中心待处理");
        map.put("4","支付中心退回");
        map.put("5","已打包待审核");
        map.put("6","打包审核通过待发送");
        map.put("7","已发往银行");
        map.put("8","银行打回");
        map.put("9","支付成功");
        map.put("m","默认成功");
        map.put("n","银行退回支付中心");
        map.put("a","审核退回");
        map.put("f","已作废");
        return map;
    }
}
