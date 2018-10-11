package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.NyxEndorChgDetailApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEndorChgDetailDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxEndorChgDetailService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description nyxendorchgdetailcontroller层
 */
@RestController
@RequestMapping(value = NyxEndorChgDetailController.PATH)
public class NyxEndorChgDetailController implements NyxEndorChgDetailApi {

    private static Logger LOGGER = LoggerFactory.getLogger(NyxEndorChgDetailController.class);

    @Autowired
    private NyxEndorChgDetailService nyxEndorChgDetailService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody NyxEndorChgDetailDto nyxEndorChgDetailDto) {
        nyxEndorChgDetailService.save(nyxEndorChgDetailDto);
    }

    /**
     *@description 删除
     *@param
     */
//    public void remove(@RequestBody String inusreListCode,String businessNo,String endorseNo,String kindCode,String itemCode) {
//        nyxEndorChgDetailService.remove(inusreListCode,businessNo,endorseNo,kindCode,itemCode);
//    }
    public void remove(@RequestBody Map<String,String> map) {
        String inusreListCode = map.get("inusreListCode");
        String businessNo = map.get("businessNo");
        String endorseNo = map.get("endorseNo");
        String kindCode = map.get("kindCode");
        String itemCode = map.get("itemCode");
        nyxEndorChgDetailService.remove(inusreListCode,businessNo,endorseNo,kindCode,itemCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody NyxEndorChgDetailDto nyxEndorChgDetailDto) {
        nyxEndorChgDetailService.modify(nyxEndorChgDetailDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
//    public NyxEndorChgDetailDto queryByPK(@RequestBody String inusreListCode,String businessNo,String endorseNo,String kindCode,String itemCode) {
//        return nyxEndorChgDetailService.queryByPK(inusreListCode,businessNo,endorseNo,kindCode,itemCode);
//    }

    @Override
    public void removeByEnodrseNo(@RequestParam("endorseNo") String endorseNo) throws Exception {
        nyxEndorChgDetailService.removeByEnodrseNo(endorseNo);
    }

    @Override
    public void saveList(@RequestBody List<NyxEndorChgDetailDto> nyxEndorChgDetailDtoList) throws Exception {
        nyxEndorChgDetailService.saveList(nyxEndorChgDetailDtoList);
    }
    public NyxEndorChgDetailDto queryByPK(@RequestBody Map<String,String> map) {
        String inusreListCode = map.get("inusreListCode");
        String businessNo = map.get("businessNo");
        String endorseNo = map.get("endorseNo");
        String kindCode = map.get("kindCode");
        String itemCode = map.get("itemCode");
        return nyxEndorChgDetailService.queryByPK(inusreListCode,businessNo,endorseNo,kindCode,itemCode);
    }
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    public @ResponseBody Map<String,List<NyxEndorChgDetailDto>> queryByEndorseNoList(@RequestBody List<String> endorseNoList){
        return nyxEndorChgDetailService.queryByEndorseNoList(endorseNoList);
    }

    /**
     * 根据批单号码集合查询nyx的批改变化量清单
     *
     * @param param endorseNo-批单号
     * @return List<NyxEndorChgDetailDto>
     * @date: 2018/4/13 18:12
     * @author: 何伟东
     */
    @Override
    public @ResponseBody
    List<NyxEndorChgDetailDto> queryByEndorseNo(@RequestBody Map<String, String> param) {
        return nyxEndorChgDetailService.queryByEndorseNo(param.get("endorseNo"));
    }
}
