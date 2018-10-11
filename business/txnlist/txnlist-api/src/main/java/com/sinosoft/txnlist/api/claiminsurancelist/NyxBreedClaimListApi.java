package com.sinosoft.txnlist.api.claiminsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxBreedClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxPlantingClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxBreedClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxPlantingClaimListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 03:26:32.072 
 * @description 养殖险理赔清单信息表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = NyxBreedClaimListApi.PATH)
public interface NyxBreedClaimListApi {

    public static final String PATH = "nyxBreedClaimList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(NyxBreedClaimListDto nyxBreedClaimListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(Map<String, String> map);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(NyxBreedClaimListDto nyxBreedClaimListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    NyxBreedClaimListDto queryByPK(Map<String, String> map);



    /**
     * @Description: 理赔清单数据查询（养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxBreedClaimListDto  listNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */
    @RequestMapping (value="queryNyxBreedClaimListByCondition",method = {RequestMethod.POST})
    public @ResponseBody
    PageInfo<NyxBreedClaimListDto> queryNyxBreedClaimListByCondition(@RequestBody RequestNyxBreedClaimListDto requestNyxBreedClaimListDto)throws Exception;



    /**
     * @Description: 理赔清单数据查询（养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxBreedClaimListDto  listNo  policyNo  registNo  compensateNo fCode
     * @Return List<NyxBreedClaimListDto> 结果集，
     */
    @RequestMapping(value = "queryNyxBreedClaimListByConditions",method = RequestMethod.POST)
    public List<NyxBreedClaimListDto> queryNyxBreedClaimListByConditions(@RequestBody RequestNyxBreedClaimListDto requestNyxBreedClaimListDto)throws Exception;



    /**
     * @Description: 理赔清单计算书号关联（养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param   listNo  compensateNo
     * @Return
     */
    @RequestMapping(value = "updateNyxBreedClaimListCompensateNo",method = RequestMethod.POST)
    public  void  updateNyxBreedClaimListCompensateNo( @RequestBody Map<String ,String > map);
    /**
     * 批量保存养殖险险理赔清单信息
     * @author: 孙朋飞
     * @date: 2017/12/29 11:42
     * @param nyxBreedClaimListDtos 理赔清单的集合
     * @return 是否保存成功
     * @throws Exception
     */
    @RequestMapping(value="batchSaveNyxBreedClaimList",method = {RequestMethod.POST})
    public @ResponseBody
    boolean batchSaveNyxBreedClaimList(@RequestBody List<NyxBreedClaimListDto> nyxBreedClaimListDtos) throws Exception;

    /**
     * 养殖险根据保单号、报案号查询承保清单、定损清单封装理赔清单
     * map 保单号、报案号、计算书号
     * @author: 王心洋
     * @date: 2018/03/31
     * @throws Exception
     */
    @RequestMapping(value="assembleNyxBreedClaimList",method = {RequestMethod.POST})
    void assembleNyxBreedClaimList(@RequestBody Map<String,String> map) throws Exception;
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
    void saveclaimNo(@RequestBody Map<String,String> map) throws Exception;
    /**
     * 根据报案号删除理赔清单信息
     * @author: 陈道洋
     * @date: 2018/3/27 18:43
     * @param registNo 报案号
     * @throws Exception
     */
    @RequestMapping(value = "deleteNyxBreedClaimListByRegistNo",method ={RequestMethod.POST} )
    public void deleteNyxBreedClaimListByRegistNo(@RequestParam("registNo")String registNo,@RequestParam("compensateNo") String compensateNo,@RequestParam("nodeType")String nodeType) throws Exception;

    /**
     * （养殖险计算过程生成）
     * @author: 王志文
     * @date: 2018/4/26 20:45
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryBreedProcess",method = {RequestMethod.POST})
    public Map<String, Object> queryBreedProcess(@RequestBody Map<String,Object> map )throws Exception;
    /**
     * （根据立案号查立案信息）
     * @author: 陈道洋
     * @date: 2018/4/26 20:45
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryByClaimNo",method = {RequestMethod.POST})
    public List<NyxBreedClaimListDto> queryByClaimNo(@RequestBody List<String> list)throws Exception;
}