package com.sinosoft.txnlist.api.claiminsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxPlantingClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxPlantingClaimListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 03:26:32.072 
 * @description 种植险理赔清单信息表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = NyxPlantingClaimListApi.PATH)
public interface NyxPlantingClaimListApi {

    public static final String PATH = "nyxPlantingClaimList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(NyxPlantingClaimListDto nyxPlantingClaimListDto);

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
    void modify(NyxPlantingClaimListDto nyxPlantingClaimListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    NyxPlantingClaimListDto queryByPK(Map<String, String> map);




    /**
     * @Description: 理赔清单数据查询（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxPlantingClaimListDto   listNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */

    @RequestMapping (value="queryNyxPlantingClaimListByCondition",method = {RequestMethod.POST})
    public @ResponseBody
    PageInfo<NyxPlantingClaimListDto> queryNyxPlantingClaimListByCondition(@RequestBody RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto)throws Exception;


    /**
     * @Description: 理赔清单数据查询（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxPlantingClaimListDto   listNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return List<NyxPlantingClaimListDto> 结果集，
     */

    @RequestMapping(value = "queryNyxPlantingClaimListByConditions",method = RequestMethod.POST)
    public List<NyxPlantingClaimListDto> queryNyxPlantingClaimListByConditions(@RequestBody RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto)throws Exception;

    /**
     * @Description: 理赔清单计算书号关联（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param   listNo  compensateNo
     * @Return
     */
    @RequestMapping(value = "updateNyxPlantingClaimListCompensateNo",method = RequestMethod.POST)
    public  void  updateNyxPlantingClaimListCompensateNo( @RequestBody Map<String ,String > map);
    /**
     * 批量保存种植险理赔清单信息
     * @author: 孙朋飞
     * @date: 2017/12/29 9:55
     * @param nyxPlantingClaimListDtoList 理赔清单的集合
     * @return 是否保存成功
     * @throws Exception
     */
    @RequestMapping(value="batchSaveNyxPlantingClaimList",method = {RequestMethod.POST})
    public @ResponseBody
    boolean batchSaveNyxPlantingClaimList(@RequestBody List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList) throws Exception;


    /**
     * （生成赔款计算过程）
     * @author: 王志文
     * @date: 2018/1/3 9:47
     * @param map
     * @return Map集合 计算结果
     * @throws Exception 异常信息
     */
    @RequestMapping(value = "queryClaimBillSummary",method = {RequestMethod.POST})
    Map<String,Object> queryClaimBillSummary(@RequestBody Map<String,Object> map)throws Exception;


    /**
     * （生成赔款计算过程供清单保存时调用）
     * @author: 王志文
     * @date: 2018/1/30 16:08
     * @param nyxPlantingClaimListDto 清单数据dto
     * @param growthPeriod  苗期
     * @return 计算结果
     * @throws Exception
     */
    @RequestMapping(value = "queryClaimBillBySave",method = {RequestMethod.POST})
    Map<String,Object> queryClaimBillBySave(@RequestBody NyxPlantingClaimListDto nyxPlantingClaimListDto,@RequestParam("growthPeriod") String growthPeriod,@RequestParam("damageWay")String damageWay,@RequestParam("damageDegree")String damageDegree)throws Exception;

    /**
     * 根据报案号删除理赔清单信息
     * @author: 孙朋飞
     * @date: 2018/3/27 18:43
     * @param registNo 报案号
     * @throws Exception
     */
    @RequestMapping(value = "deleteNyxPlantingClaimListByRegistNo",method ={RequestMethod.POST} )
    public void deleteNyxPlantingClaimListByRegistNoAndCompensateNoAndNodeType(@RequestParam("registNo")String registNo,@RequestParam("compensateNo") String compensateNo,@RequestParam("nodeType")String nodeType) throws Exception;

    /**
     * （报案号和节点状态查询数据）
     * @author: 王志文
     * @date: 2018/3/27 19:49
     * @param registNo
     * @param nodeType
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryAllByRegistNoAndNodeType",method ={RequestMethod.POST} )
    List<NyxPlantingClaimListDto> queryAllByRegistNoAndNodeType(@RequestParam("registNo")String registNo,@RequestParam("nodeType")String nodeType) throws Exception;

    /**
     * （报案号和节点状态查询数据）
     * @author:
     * @date: 2018/3/27 19:49
     * @param map
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryByRegistNoAndNodeType",method ={RequestMethod.POST} )
    List<NyxPlantingClaimListDto> queryByRegistNoAndNodeType(@RequestBody Map<String,String> map) throws Exception;
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
     * （根据出险判断当前报案标的所属茬次）
     *
     * @param map
     * @return
     * @throws Exception
     * @author: 王志文
     * @date: 2018/4/18 19:00
     */
    @RequestMapping(value = "checkStubbleByRegistNo", method = {RequestMethod.POST})
    public int checkStubbleByRegistNo(@RequestBody Map<String, Object> map) throws Exception;

    /**
     * （根据出险判断当前报案标的所属茬次）
     *
     * @param map
     * @return
     * @throws Exception
     * @author: 王志文
     * @date: 2018/4/18 19:00
     */
    @RequestMapping(value = "checkStubbleByRegistNo1", method = {RequestMethod.POST})
    public int checkStubbleByRegistNo1(@RequestBody Map<String, Object> map) throws Exception;
}