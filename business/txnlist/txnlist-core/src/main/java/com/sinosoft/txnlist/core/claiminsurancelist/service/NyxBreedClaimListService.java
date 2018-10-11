package com.sinosoft.txnlist.core.claiminsurancelist.service;


import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxBreedClaimListDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxPlantingClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxBreedClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxPlantingClaimListDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 03:26:32.072 
 * @description 养殖险理赔清单信息表Core接口
 */
public interface NyxBreedClaimListService {

    /**
     *@description 新增
     *@param
     */
    void save(NyxBreedClaimListDto nyxBreedClaimListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String listNo, String serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(NyxBreedClaimListDto nyxBreedClaimListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    NyxBreedClaimListDto queryByPK(String listNo, String serialNo);


    /**
     * @Description: 理赔清单数据分页查询（养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxBreedClaimListDto  llistNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */
    public PageInfo<NyxBreedClaimListDto> queryNyxBreedClaimListByCondition(RequestNyxBreedClaimListDto requestNyxBreedClaimListDto);

    /**
     * @Description: 理赔清单数据查询（养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxBreedClaimListDto  listNo  policyNo  registNo  compensateNo fCode
     * @Return List<NyxBreedClaimListDto> 结果集，
     */

    public List<NyxBreedClaimListDto> queryNyxBreedClaimListByConditions(RequestNyxBreedClaimListDto requestNyxBreedClaimListDto);


    /**
     * @Description: 理赔清单计算书号关联（养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param   listNo  compensateNo
     * @Return
     */
    public  void  updateNyxBreedClaimListCompensateNo(Map<String ,String > map);
    /**
     * 批量保存养殖险险理赔清单信息
     * @author: 孙朋飞
     * @date: 2017/12/29 11:42
     * @param nyxBreedClaimListDtos 理赔清单的集合
     * @return 是否保存成功
     * @throws Exception
     */
    public boolean batchSaveNyxBreedClaimList(List<NyxBreedClaimListDto> nyxBreedClaimListDtos) throws Exception;

    /**
     * 养殖险根据保单号、报案号查询承保清单、定损清单封装理赔清单
     * map 保单号、报案号、计算书号
     * @author: 王心洋
     * @date: 2018/03/31
     * @throws Exception
     */
    void assembleNyxBreedClaimList(String policyNo,String registNo,String compensateNo) throws Exception;
    /**
     * 根据报案号和清单号回写立安好
     * @author:
     * @date: 2018/3/27 19:49
     * @param map
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveclaimNo",method ={RequestMethod.POST} )
    void saveclaimNo(String listNo,String registNo,String claimNo) throws Exception;
    /**
     * 根据报案号删除理赔清单信息
     * @author: 陈道洋
     * @date: 2018/3/27 18:43
     * @param registNo 报案号
     * @throws Exception
     */
    public void deleteNyxBreedClaimListByRegistNo(String registNo,String compensateNo,String nodeType) throws Exception;

    /**
     * （养殖险计算过程生成）
     * @author: 王志文
     * @date: 2018/4/27 10:35
     * @param policyNo
     * @param kindCode
     * @param listNo
     * @param registNo
     * @return
     * @throws Exception
     */
    public Map<String, Object> queryBreedProcess(String policyNo,String kindCode, String listNo,String registNo)throws Exception;
    /**
     * （根据立案号查立案信息）
     * @author: 陈道洋
     * @date: 2018/4/26 20:45
     * @param map
     * @return
     * @throws Exception
     */
    public List<NyxBreedClaimListDto> queryByClaimNo(@RequestBody List<String> list)throws Exception;
}