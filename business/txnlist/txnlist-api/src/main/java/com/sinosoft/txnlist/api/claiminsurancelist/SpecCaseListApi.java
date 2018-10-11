package com.sinosoft.txnlist.api.claiminsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.SpecCaseListDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-23 10:16:34.906 
 * @description 特殊赔案清单表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = SpecCaseListApi.PATH)
public interface SpecCaseListApi {

    public static final String PATH = "specCaseList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(SpecCaseListDto specCaseListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("serialNo") String serialNo,@RequestParam("preCompensateNo") String preCompensateNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(SpecCaseListDto specCaseListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    SpecCaseListDto queryByPK(@RequestParam("serialNo") String serialNo,@RequestParam("preCompensateNo") String preCompensateNo);

    /**
     * 分页查询特殊赔案清单
     * @author: 孙朋飞
     * @date: 2018/1/23 19:26
     * @param map precompensateNo 预赔单号,pageNo-当前页，pageSize-每页显示条数
     * @return 特殊赔案清单合集
     * @throws Exception
     */
    @RequestMapping(value="querySpecCaseListByPreCompensateNo",method = {RequestMethod.POST})
    public @ResponseBody PageInfo<SpecCaseListDto> querySpecCaseListByPreCompensateNo(Map<String,String> map) throws Exception;

    /**
     * 查询特殊赔案清单
     * @author: 孙朋飞
     * @date: 2018/1/24 8:33
     * @param map listNo 清单号
     * @return 特殊赔案清单合集
     * @throws Exception
     */
    @RequestMapping(value="querySpecCaseListByNoPage",method = {RequestMethod.POST})
    public @ResponseBody List<SpecCaseListDto> querySpecCaseListByNoPage(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 批量保存预赔清单
     * @author: 孙朋飞
     * @date: 2018/1/24 15:03
     * @param specCaseListDtoList 预赔清单集合
     * @return 成功返回true
     * @throws Exception
     */
    @RequestMapping(value="batchSaveSpecCaseList",method = {RequestMethod.POST})
    public @ResponseBody boolean batchSaveSpecCaseList(@RequestBody List<SpecCaseListDto> specCaseListDtoList) throws Exception;

    /**
     * 清单号关联预赔单号
     * @author: 孙朋飞
     * @date: 2018/2/11 15:02
     * @param map 清单号和预赔单号
     * @return 清单号关联预赔单号成功
     * @throws Exception
     */
    @RequestMapping(value="saveSpecCaseListPreCompensateNo",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> saveSpecCaseListPreCompensateNo(@RequestBody Map<String,String> map) throws Exception;
}