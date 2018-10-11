package com.sinosoft.txnlist.core.insuremainlist.service;

import com.sinosoft.txnlist.api.insuremainlist.dto.EarNoCheckDto;
import com.sinosoft.txnlist.api.insuremainlist.dto.EarNoCheckResponseDto;
import com.sinosoft.txnlist.api.insuremainlist.dto.RequestQueryPolicyDto;

import java.util.List;
import java.util.Map;

/**
* @Description: 根据清单信息查询保单Api接口
* @Author: 杨成程
* @Date: 2017/11/23 11:20
*/
public interface QueryPoilcyListService {

    /**
     *  方法功能简述：根据农户姓名、耳标号等信息查询保单号
     * @author: 杨成程
     * @date: 2017/10/18 11:44
     * @param requestDto 
     * @return 
     * @throws Exception
     */
	List<String> queryPoilcyNoList(RequestQueryPolicyDto requestDto)throws Exception;
    /**
     * 根据保单号和耳标号获取最新清单保额大于0的耳标出险时的清单信息
     * 1.根据保单号查找投保清单头表的list放入结果集
     * 2.根据投保清单号和耳标号查找保单清单最新数据表的list放入结果集
     * @author 马俊玲
     * @throws Exception
     */
    EarNoCheckResponseDto queryEndorseHerdpolicylist(EarNoCheckDto earNoCheckDto) throws Exception;

    /**
     * @param requestDto 入参Dto
     * @return
     * @throws
     * @description: 方法功能简述：根据农户姓名、农户代码等信息查询保单号
     * @author: 钱浩
     * @date: 2017/10/18 11:44
     */
    Map<String, String> queryPoilcyNo(RequestQueryPolicyDto requestDto) throws Exception;
}