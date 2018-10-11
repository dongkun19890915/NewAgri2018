package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxPlantingClaimListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxPlantingClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxPlantingClaimListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.service.NyxPlantingClaimListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 03:26:32.072 
 * @description 种植险理赔清单信息表controller层
 */
@RestController
@RequestMapping(value = NyxPlantingClaimListController.PATH)
public class NyxPlantingClaimListController implements NyxPlantingClaimListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(NyxPlantingClaimListController.class);

    @Autowired
    private NyxPlantingClaimListService nyxPlantingClaimListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody NyxPlantingClaimListDto nyxPlantingClaimListDto) {
        nyxPlantingClaimListService.save(nyxPlantingClaimListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody Map<String,String> map) {
        String listNo = map.get("listNo");
        String serialNo = map.get("serialNo");
        nyxPlantingClaimListService.remove(listNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody NyxPlantingClaimListDto nyxPlantingClaimListDto) {
        nyxPlantingClaimListService.modify(nyxPlantingClaimListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public NyxPlantingClaimListDto queryByPK(@RequestBody Map<String,String> map) {
        String listNo = map.get("listNo");
        String serialNo = map.get("serialNo");
        return nyxPlantingClaimListService.queryByPK(listNo,serialNo);
    }



    /**
     * @Description: 理赔清单数据查询（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxPlantingClaimListDto   listNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */

    public @ResponseBody PageInfo<NyxPlantingClaimListDto> queryNyxPlantingClaimListByCondition(@RequestBody RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto)throws Exception{

        return nyxPlantingClaimListService.queryNyxPlantingClaimListByCondition(requestNyxPlantingClaimListDto);
    }

    /**
     * @Description: 理赔清单数据查询（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxPlantingClaimListDto   listNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return List<NyxPlantingClaimListDto> 结果集，
     */
    public @ResponseBody List<NyxPlantingClaimListDto> queryNyxPlantingClaimListByConditions(@RequestBody RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto)throws Exception{
        return nyxPlantingClaimListService.queryNyxPlantingClaimListByConditions(requestNyxPlantingClaimListDto);
    }


    /**
     * @Description: 理赔清单计算书号关联（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param   listNo  compensateNo
     * @Return
     */
    public  void  updateNyxPlantingClaimListCompensateNo( @RequestBody Map<String ,String > map){

        nyxPlantingClaimListService.updateNyxPlantingClaimListCompensateNo(map);
    }
    /**
     * 批量保存理赔清单信息
     * @author: 孙朋飞
     * @date: 2017/12/29 9:55
     * @param nyxPlantingClaimListDtoList 理赔清单集合
     * @return 是否保存成功
     * @throws Exception
     */
    @Override
    public @ResponseBody  boolean batchSaveNyxPlantingClaimList(@RequestBody List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList) throws Exception {
        return nyxPlantingClaimListService.batchSaveNyxPlantingClaimList(nyxPlantingClaimListDtoList);
    }

    /**
     * （生成赔款计算过程）
     * @author: 王志文
     * @date: 2018/1/3 9:47
     * @param map 集合
     * @return Map集合
     * @throws Exception 异常信息
     */
    @Override
    public Map<String, Object> queryClaimBillSummary(@RequestBody Map<String,Object> map)throws Exception {
        String policyNo = (String)map.get("policyNo");
        String kindCode = (String)map.get("kindCode");
        String billNo = (String)map.get("billNo");
        String growthPeriod = (String)map.get("growthPeriod");
        String registNo = (String)map.get("registNo");
        String damageWay = (String)map.get("damageWay");
        String damageDegree = (String)map.get("damageDegree");
        return nyxPlantingClaimListService.queryClaimBillSummary(policyNo,kindCode,billNo,growthPeriod,registNo,damageWay,damageDegree);
    }

    /**
     * （生成赔款计算过程供清单保存时调用）
     * @author: 王志文
     * @date: 2018/1/30 16:08
     * @param nyxPlantingClaimListDto 清单数据dto
     * @param growthPeriod  苗期
     * @return 计算结果
     * @throws Exception
     */
    @Override
    public Map<String, Object> queryClaimBillBySave(@RequestBody NyxPlantingClaimListDto nyxPlantingClaimListDto, @RequestParam("growthPeriod") String growthPeriod,String damageWay,String damageDegree) throws Exception {
        return nyxPlantingClaimListService.queryClaimBillBySave(nyxPlantingClaimListDto,growthPeriod,damageWay,damageDegree);
    }
    /**
     * 根据报案号删除理赔清单信息
     * @author: 孙朋飞
     * @date: 2018/3/27 18:43
     * @param registNo 报案号
     * @throws Exception
     */
    @Override
    public void deleteNyxPlantingClaimListByRegistNoAndCompensateNoAndNodeType(@RequestParam("registNo") String registNo,@RequestParam("compensateNo") String compensateNo,@RequestParam("nodeType")String nodeType) throws Exception {
        nyxPlantingClaimListService.deleteNyxPlantingClaimListByRegistNoAndCompensateNoAndNodeType(registNo,compensateNo,nodeType);
    }
    /**
     * （报案号和节点状态查询数据）
     * @author: 王志文
     * @date: 2018/3/27 19:49
     * @param registNo
     * @param nodeType
     * @return
     * @throws Exception
     */
    @Override
    public List<NyxPlantingClaimListDto> queryAllByRegistNoAndNodeType(@RequestParam("registNo")String registNo,@RequestParam("nodeType")String nodeType) throws Exception {
        return nyxPlantingClaimListService.queryAllByRegistNoAndNodeType(registNo,nodeType);
    }
    /**
     * （报案号和节点状态查询数据）
     * @author:
     * @date: 2018/3/27 19:49
     * @param map
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public List<NyxPlantingClaimListDto> queryByRegistNoAndNodeType(@RequestBody Map<String,String> map) throws Exception {
        String registNo=map.get("registNo");
        String nodeType=map.get("nodeType");
        return nyxPlantingClaimListService.queryAllByRegistNoAndNodeType(registNo,nodeType);
    }
    /**
     * 根据报案号和清单号回写立安好
     * @author:
     * @date: 2018/3/27 19:49
     * @param map
     * @param
     * @return
     * @throws Exception
     */
    public void saveclaimNo(@RequestBody Map<String,String> map) throws Exception{
        nyxPlantingClaimListService.saveclaimNo(map.get("listNo"),map.get("registNo"),map.get("claimNo"));
    }

    /**
     * （根据出险日期判断当前报案标的所属茬次）
     * @author: 王志文
     * @date: 2018/4/18 19:00
     * @param map
     * @return
     * @throws Exception
     */
    public int checkStubbleByRegistNo(@RequestBody Map<String,Object> map)throws Exception{
        String registNo = (String) map.get("registNo");
        return nyxPlantingClaimListService.checkStubbleByRegistNo(registNo,map);
    }

    /**
     * （根据出险日期判断当前报案标的所属茬次）
     *
     * @param map
     * @return
     * @throws Exception
     * @author: 王志文
     * @date: 2018/4/18 19:00
     */
    public int checkStubbleByRegistNo1(@RequestBody Map<String, Object> map) throws Exception {
        return nyxPlantingClaimListService.checkStubbleByRegistNo1(map);
    }
}
