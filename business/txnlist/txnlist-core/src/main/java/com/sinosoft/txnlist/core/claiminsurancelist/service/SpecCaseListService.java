package com.sinosoft.txnlist.core.claiminsurancelist.service;


import com.sinosoft.txnlist.api.claiminsurancelist.dto.SpecCaseListDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-23 10:16:34.906 
 * @description 特殊赔案清单表Core接口
 */
public interface SpecCaseListService {

    /**
     *@description 新增
     *@param
     */
    void save(SpecCaseListDto specCaseListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String serialNo, String preCompensateNo);
    /**
     *@description 修改
     *@param
     */
    void modify(SpecCaseListDto specCaseListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SpecCaseListDto queryByPK(String serialNo, String preCompensateNo);

    /**
     * 分页查询特殊赔案清单
     * @author: 孙朋飞
     * @date: 2018/1/23 19:37
     * @param preCompensateNo 预赔单号
     * @param pageNo 当前页
     * @param pageSize 每页显示条数
     * @return 预赔清单合集
     * @throws Exception
     */
    public PageInfo<SpecCaseListDto> querySpecCaseListByPreCompensateNo(String preCompensateNo, String pageNo, String pageSize) throws Exception;

    /**
     * 查询特殊赔案清单
     * @author: 孙朋飞
     * @date: 2018/1/24 8:37
     * @param listNo 清单号
     * @return 特殊赔案清单合集
     * @throws Exception
     */
    public List<SpecCaseListDto> querySpecCaseListByNoPage(String listNo) throws Exception;

    /**
     * 批量保存特殊赔案清单
     * @author: 孙朋飞
     * @date: 2018/1/24 15:07
     * @param specCaseListDtoList 预赔清单集合
     * @return 成功返回true
     * @throws Exception
     */
    public boolean batchSaveSpecCaseList(List<SpecCaseListDto> specCaseListDtoList) throws Exception;

    /**
     * 清单号关联预赔单号
     * @author: 孙朋飞
     * @date: 2018/2/11 15:02
     * @param listNo 清单号
     * @param preCompensateNo 预赔单号
     * @return 清单号关联预赔单号成功
     * @throws Exception
     */
    public boolean saveSpecCaseListPreCompensateNo(String listNo, String preCompensateNo) throws Exception;
}