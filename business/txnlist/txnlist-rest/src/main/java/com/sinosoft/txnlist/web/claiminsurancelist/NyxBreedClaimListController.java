package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxBreedClaimListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxBreedClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxBreedClaimListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.service.NyxBreedClaimListService;
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
 * @description 养殖险理赔清单信息表controller层
 */
@RestController
@RequestMapping(value = NyxBreedClaimListApi.PATH)
public class NyxBreedClaimListController implements NyxBreedClaimListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(NyxBreedClaimListController.class);

    @Autowired
    private NyxBreedClaimListService nyxBreedClaimListService;

    /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody NyxBreedClaimListDto nyxBreedClaimListDto) {
        nyxBreedClaimListService.save(nyxBreedClaimListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody Map<String,String> map) {
        String listNo = map.get("listNo");
        String serialNo = map.get("serialNo");
        nyxBreedClaimListService.remove(listNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody NyxBreedClaimListDto nyxBreedClaimListDto) {
        nyxBreedClaimListService.modify(nyxBreedClaimListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public NyxBreedClaimListDto queryByPK(@RequestBody Map<String,String> map) {
        String listNo = map.get("listNo");
        String serialNo = map.get("serialNo");
        return nyxBreedClaimListService.queryByPK(listNo,serialNo);
    }



    /**
     * @Description: 理赔清单数据查询（分页查询养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxBreedClaimListDto  listNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */
    public @ResponseBody PageInfo<NyxBreedClaimListDto> queryNyxBreedClaimListByCondition(@RequestBody RequestNyxBreedClaimListDto requestNyxBreedClaimListDto)throws Exception{

        return nyxBreedClaimListService.queryNyxBreedClaimListByCondition(requestNyxBreedClaimListDto);
    }

    /**
     * @Description: 理赔清单数据查询（养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxBreedClaimListDto  listNo  policyNo  registNo  compensateNo fCode
     * @Return List<NyxBreedClaimListDto> 结果集，
     */

    public @ResponseBody
    List<NyxBreedClaimListDto> queryNyxBreedClaimListByConditions(@RequestBody RequestNyxBreedClaimListDto requestNyxBreedClaimListDto)throws Exception{
        return nyxBreedClaimListService.queryNyxBreedClaimListByConditions(requestNyxBreedClaimListDto);
    }


    /**
     * @Description: 理赔清单计算书号关联（养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param   listNo  compensateNo
     * @Return
     */

    public  void  updateNyxBreedClaimListCompensateNo( @RequestBody Map<String ,String> map){

        nyxBreedClaimListService.updateNyxBreedClaimListCompensateNo(map);
    }
    /**
     * 批量保存养殖险险理赔清单信息
     * @author: 孙朋飞
     * @date: 2017/12/29 11:42
     * @param nyxBreedClaimListDtos 理赔清单的集合
     * @return 是否保存成功
     * @throws Exception
     */
    @Override
    public @ResponseBody boolean batchSaveNyxBreedClaimList(@RequestBody List<NyxBreedClaimListDto> nyxBreedClaimListDtos) throws Exception {
        return nyxBreedClaimListService.batchSaveNyxBreedClaimList(nyxBreedClaimListDtos);
    }

    /**
     * 养殖险根据保单号、报案号查询承保清单、定损清单封装理赔清单
     * map 保单号、报案号
     * @author: 王心洋
     * @date: 2018/03/31
     * @throws Exception
     */
    @Override
    public void assembleNyxBreedClaimList(@RequestBody Map<String,String> map) throws Exception{
        String policyNo = map.get("policyNo");
        String registNo = map.get("registNo");
        String compensateNo = map.get("compensateNo");
        nyxBreedClaimListService.assembleNyxBreedClaimList(policyNo,registNo,compensateNo);
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
        nyxBreedClaimListService.saveclaimNo(map.get("listNo"),map.get("registNo"),map.get("claimNo"));
    }
    /**
     * 根据报案号删除理赔清单信息
     * @author: 陈道洋
     * @date: 2018/3/27 18:43
     * @param registNo 报案号
     * @throws Exception
     */
    public void deleteNyxBreedClaimListByRegistNo(@RequestParam("registNo") String registNo,@RequestParam("compensateNo") String compensateNo,@RequestParam("nodeType")String nodeType) throws Exception {
        nyxBreedClaimListService.deleteNyxBreedClaimListByRegistNo(registNo,compensateNo,nodeType);
    }

    /**
     * （养殖险计算过程生成）
     * @author: 王志文
     * @date: 2018/4/26 20:45
     * @param map
     * @return
     * @throws Exception
     */
    public Map<String, Object> queryBreedProcess(@RequestBody Map<String,Object> map)throws Exception{
        String policyNo = (String)map.get("policyNo");
        String kindCode = (String)map.get("kindCode");
        String listNo = (String)map.get("listNo");
        String registNo = (String)map.get("registNo");
        return nyxBreedClaimListService.queryBreedProcess(policyNo,kindCode,listNo,registNo);
    }
    /**
     * （根据立案号号查立案信息）
     * @author: 陈道洋
     * @date: 2018/4/26 20:45
     * @param map
     * @return
     * @throws Exception
     */
    public List<NyxBreedClaimListDto> queryByClaimNo(@RequestBody List<String> list)throws Exception{
        return nyxBreedClaimListService.queryByClaimNo(list);
}
}
