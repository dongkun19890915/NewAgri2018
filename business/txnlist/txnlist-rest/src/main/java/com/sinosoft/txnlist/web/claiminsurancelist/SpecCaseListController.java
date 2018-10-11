package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.txnlist.api.claiminsurancelist.SpecCaseListApi;
import com.sinosoft.txnlist.core.claiminsurancelist.service.SpecCaseListService;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.SpecCaseListDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-23 10:16:34.906 
 * @description 特殊赔案清单表controller层
 */
@RestController
@RequestMapping(value = SpecCaseListController.PATH)
public class SpecCaseListController implements SpecCaseListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SpecCaseListController.class);

    @Autowired
    private SpecCaseListService specCaseListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SpecCaseListDto specCaseListDto) {
        specCaseListService.save(specCaseListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("serialNo") String serialNo,@RequestParam("preCompensateNo") String preCompensateNo) {
        specCaseListService.remove(serialNo,preCompensateNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SpecCaseListDto specCaseListDto) {
        specCaseListService.modify(specCaseListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SpecCaseListDto queryByPK(@RequestParam("serialNo") String serialNo,@RequestParam("preCompensateNo") String preCompensateNo) {
        return specCaseListService.queryByPK(serialNo,preCompensateNo);
    }
    /**
     * 分页查询特殊赔案清单
     * @author: 孙朋飞
     * @date: 2018/1/23 19:26
     * @param map precompensateNo 预赔单号,pageNo当前页数，pageSize每页显示条数
     * @return 特殊赔案清单合集
     * @throws Exception
     */
    @Override
    public @ResponseBody PageInfo<SpecCaseListDto> querySpecCaseListByPreCompensateNo(@RequestBody Map<String, String> map) throws Exception {
        return specCaseListService.querySpecCaseListByPreCompensateNo(map.get("preCompensateNo"),map.get("pageNo"),map.get("pageSize"));
    }
    /**
     * 查询特殊赔案清单
     * @author: 孙朋飞
     * @date: 2018/1/24 8:33
     * @param map listNo 清单号
     * @return 特殊赔案清单合集
     * @throws Exception
     */
    @Override
    public @ResponseBody List<SpecCaseListDto> querySpecCaseListByNoPage(@RequestBody Map<String, String> map) throws Exception {
        return specCaseListService.querySpecCaseListByNoPage(map.get("listNo"));
    }
    /**
     * 批量保存预赔清单
     * @author: 孙朋飞
     * @date: 2018/1/24 15:03
     * @param specCaseListDtoList 预赔清单集合
     * @return 成功返回true
     * @throws Exception
     */
    @Override
    public @ResponseBody boolean batchSaveSpecCaseList(@RequestBody List<SpecCaseListDto> specCaseListDtoList) throws Exception {
        return specCaseListService.batchSaveSpecCaseList(specCaseListDtoList);
    }
    /**
     * 清单号关联预赔单号
     * @author: 孙朋飞
     * @date: 2018/2/11 15:02
     * @param map 清单号和预赔单号
     * @return 清单号关联预赔单号成功
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> saveSpecCaseListPreCompensateNo(@RequestBody Map<String, String> map) throws Exception {
        boolean flag=specCaseListService.saveSpecCaseListPreCompensateNo(map.get("listNo"),map.get("preCompensateNo"));
        Map<String,String> returnParam=new HashMap<>();
        if(flag){
            returnParam.put("message","清单号关联预赔单号成功!");
        }
        return returnParam;
    }
}
