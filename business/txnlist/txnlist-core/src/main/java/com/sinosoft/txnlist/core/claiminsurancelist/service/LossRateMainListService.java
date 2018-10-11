package com.sinosoft.txnlist.core.claiminsurancelist.service;


import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * @description 定损清单主表Core接口
 */
public interface LossRateMainListService {

    /**
     *@description 新增
     *@param
     */
    void save(LossRateMainListDto lossRateMainListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String lossListCode,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(LossRateMainListDto lossRateMainListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    LossRateMainListDto queryByPK(String lossListCode,java.lang.Integer serialNo);

    /**
     *@description 按清单号查询最大序列号
     *@param lossListCode 清单号
     *@return serialNo 最大序列号
     *@author 王心洋
     *@time 2018-01-18
     */
    Integer queryMaxSerialByLossListCode(String lossListCode) throws Exception;

    /**
     * 按条件查询实体集合
     * @param policyNo 保单号
     * @param bizNo 报案号
     * @return List<LossRateMainListDto>定损清单信息列表
     * @author 王心洋
     * @time 2018-01-19
     */
    List<LossRateMainListDto> queryByConditions(String policyNo, String bizNo) throws Exception;
    /**
     * 关联报案号和清单信息
     * @param lossListCode 损失率清单号
     * @param bizNo 报案号
     * @author 王心洋
     * @time 2018-01-19
     */
    void compareInsurance(String lossListCode, String bizNo,String checkBoxFlag,String serialNo) throws Exception;
    /**
     * 按条件查询已关联实体集合
     * @param policyNo 保单号
     * @param bizNo 报案号
     * @return LossRateWholeListDto定损清单信息列表
     * @author 王心洋
     * @time 2018-01-19
     */
    LossRateWholeListDto queryComparable(String policyNo, String bizNo) throws Exception;
    /**
     * 根据保单号、报案号查询定损清单表中有耳标号的清单号
     * @param policyNo 保单号
     * @param bizNo 报案号
     * @return String 清单号
     * @author 王心洋
     * @time 2018-01-23
     */
    String queryEarLabelCount(String policyNo,String bizNo) throws Exception;
    /**
     * 查询养殖险的定损清单
     * @author: 孙朋飞
     * @date: 2018/1/19 9:26
     * @param  registNo 报案号
     * @param policyNo 报单号
     * @param nodeType 节点类型
     * @param lossListCode 清单号
     * @return 养殖险的定损清单集合
     * @throws Exception
     */
    public List<ResponseBreedLossRateListDto> queryBreedLossRateListByLossListCode(String registNo,String policyNo,String nodeType,String lossListCode) throws Exception;
    /**
     * 查询种植险的定损清单
     * @author: 孙朋飞
     * @date: 2018/1/19 14:40
     * @param  registNo 报案号
     * @param  policyNo 保单号
     * @param  nodeType 节点类型
     * @param  lossListCode 清单号
     * @return 种植险的定损清单集合
     * @throws Exception
     */
    public List<ResponsePlantingLossRateListDto> queryPlantingLossRateListByLossListCode(String registNo,String policyNo,String nodeType,String lossListCode) throws Exception;
    /**
     * 查询养殖险的定损清单
     * @author: 陈道洋
     * @date: 2018/1/19 9:26
     * @param  registNo 报案号
     * @param lossListCode 清单号
     * @return 养殖险的定损清单集合
     * @throws Exception
     */
    public List<ResponseBreedLossRateListDto> downloadlList(String registNo,String lossListCode,String policyNo) throws Exception;
    /**
     * 查询种植险的定损清单
     * @author: 陈道洋
     * @date: 2018/1/19 14:40
     * @param  registNo 报案号
     * @param  lossListCode 清单号
     * @return 种植险的定损清单集合
     * @throws Exception
     */
    public List<ResponsePlantingLossRateListDto> plantingdownloadlList(String registNo,String lossListCode,String policyNo) throws Exception;

    /**
     * 定损清单大对象保存接口
     * @author: 王心洋
     * @date: 2018/3/19
     * @param requestGYLossRateAllListDto
     * @throws Exception
     */
    void saveLossRateAllList(LossRateWholeListDto requestGYLossRateAllListDto) throws Exception;
    /**
     * 通过报案号和清单号查询是否关联
     * @author: 孙朋飞
     * @date: 2018/3/31 16:09
     * @param registNo 报案号
     * @param lossListCode 清单号
     * @return 是否关联
     * @throws Exception
     */
    public boolean queryLossRateMainListByRegistNoAndLossListCode(String registNo, String lossListCode);

    /**
     * g根据保单号查询清单号
     * @author: 陈道洋
     * @date: 2018/3/31 16:09
     * @param  policyNo 保单号
     * @return 是否关联
     * @throws Exception
     */
    public void queryByPolicyNo(@RequestParam("policyNo")String policyNo ,@RequestParam("nodeOrigin")String nodeOrigin,@RequestParam("registNo")String registNo) throws Exception;
    /**
     * g根据保单号查询清单号
     * @author: 陈道洋
     * @date: 2018/3/31 16:09
     * @param  registNo 保单号
     * @return 是否关联
     * @throws Exception
     */
    public List<LossRateMainListDto> queryByregistNo(@RequestParam("registNo")String registNo) throws Exception;

    /**
     * 通过保单号和报案号查询查勘编号（checkId）
     * @param （policyNo保单号 bizNo报案号）
     * @return 查勘编号（checkId）
     * @throws Exception
     * @author: 李文刚
     * @date: 2018/4/16 16:09
     */
    public List<LossRateMainListDto> findCheckId( LossRateMainListDto lossRateMainListDto) throws Exception;

    /**
     * 根据清单号和保单号回写报案号
     * @author: 孙朋飞
     * @date: 2018/4/23 9:26
     * @param lossListCode 清单号
     * @param policyNo 保单号
     * @param registNo 报案号
     * @throws Exception
     */
    public void updateLossRateMainListByLossListCode(String lossListCode, String policyNo, String registNo) throws Exception;
}