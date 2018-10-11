package com.sinosoft.txnlist.core.claiminsurancelist.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxPlantingClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxPlantingClaimListDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 03:26:32.072 
 * @description 种植险理赔清单信息表Core接口
 */
public interface NyxPlantingClaimListService {

    /**
     *@description 新增
     *@param
     */
    void save(NyxPlantingClaimListDto nyxPlantingClaimListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String listNo, String serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(NyxPlantingClaimListDto nyxPlantingClaimListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    NyxPlantingClaimListDto queryByPK(String listNo, String serialNo);


    /**
     * @Description: 理赔清单数据查询（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxPlantingClaimListDto   listNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */
    public PageInfo<NyxPlantingClaimListDto> queryNyxPlantingClaimListByCondition(RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto);

    /**
     * @Description: 理赔清单数据查询（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxPlantingClaimListDto   listNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return List<NyxPlantingClaimListDto> 结果集，
     */
    public List<NyxPlantingClaimListDto> queryNyxPlantingClaimListByConditions(RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto);

    /**
     * @Description: 理赔清单计算书号关联（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param   listNo  compensateNo
     * @Return
     */
    public  void  updateNyxPlantingClaimListCompensateNo(Map<String ,String > map);
    /**
     * 批量保存理赔清单信息
     * @author: 孙朋飞
     * @date: 2017/12/29 9:55
     * @param nyxPlantingClaimListDtoList 理赔清单集合
     * @return 是否保存成功
     * @throws Exception
     */
    public boolean batchSaveNyxPlantingClaimList(List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList) throws Exception;

    /**
     * （生成赔款计算过程）
     * @author: 王志文
     * @date: 2017/12/29 18:11
     * @param policyNo 保单号
     * @param kindCode 险别代码
     * @param billNo 清单号
     * @param growthPeriod 作物苗期
     * @return Map
     * @throws Exception
     */
    Map<String,Object> queryClaimBillSummary(String policyNo,String kindCode,String billNo,String growthPeriod,String registNo,String damageWay,String damageDegree) throws Exception;


    /**
     * （生成赔款计算过程供清单保存时调用）
     * @author: 王志文
     * @date: 2018/1/30 16:08
     * @param nyxPlantingClaimListDto 清单数据dto
     * @param growthPeriod  苗期
     * @return 计算结果
     * @throws Exception
     */
    Map<String,Object> queryClaimBillBySave(NyxPlantingClaimListDto nyxPlantingClaimListDto, String growthPeriod,String damageWay,String damageDegree)throws Exception;
    /**
     * 根据报案号删除理赔清单信息
     * @author: 孙朋飞
     * @date: 2018/3/27 18:43
     * @param registNo 报案号
     * @throws Exception
     */
    public void deleteNyxPlantingClaimListByRegistNoAndCompensateNoAndNodeType(String registNo,String compensateNo,String nodeType) throws Exception;

    /**
     * （报案号和节点状态查询数据）
     * @author: 王志文
     * @date: 2018/3/27 19:49
     * @param registNo
     * @param nodeType
     * @return
     * @throws Exception
     */
    List<NyxPlantingClaimListDto> queryAllByRegistNoAndNodeType(String registNo,String nodeType) throws Exception;

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
     * （根据出险日期判断当前报案标的所属茬次）
     * @author: 王志文
     * @date: 2018/4/18 19:00
     * @param registNo
     * @param map
     * @return
     * @throws Exception
     */
    public int checkStubbleByRegistNo(String registNo,Map<String,Object> map)throws Exception;

    /**
     * （根据出险日期判断当前报案标的所属茬次）
     *
     * @param registNo
     * @param map
     * @return
     * @throws Exception
     * @author: 王志文
     * @date: 2018/4/18 19:00
     */
    public int checkStubbleByRegistNo1(Map<String, Object> map) throws Exception;
}