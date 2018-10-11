package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.NyxCpEndorChgDetailApi;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxCpEndorChgDetailService;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxCpEndorChgDetailDto;
import com.sinosoft.framework.dto.PageInfo;
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
 * @description nyxcpendorchgdetailcontroller层
 */
@RestController
@RequestMapping(value = NyxCpEndorChgDetailController.PATH)
public class NyxCpEndorChgDetailController implements NyxCpEndorChgDetailApi {

    private static Logger LOGGER = LoggerFactory.getLogger(NyxCpEndorChgDetailController.class);

    @Autowired
    private NyxCpEndorChgDetailService nyxCpEndorChgDetailService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody NyxCpEndorChgDetailDto nyxCpEndorChgDetailDto) {
        nyxCpEndorChgDetailService.save(nyxCpEndorChgDetailDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam String insureListCode)throws Exception {
        nyxCpEndorChgDetailService.remove(insureListCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody NyxCpEndorChgDetailDto nyxCpEndorChgDetailDto) {
        nyxCpEndorChgDetailService.modify(nyxCpEndorChgDetailDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
//    public NyxCpEndorChgDetailDto queryByPK(@RequestBody String inusreListCode,String businessNo,String kindCode,String itemCode) {
//        return nyxCpEndorChgDetailService.queryByPK(inusreListCode,businessNo,kindCode,itemCode);
//    }

    @Override
    public void saveList(@RequestBody List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtoList) throws Exception {
        nyxCpEndorChgDetailService.saveList(nyxCpEndorChgDetailDtoList);
    }

    @Override
    public @ResponseBody List<NyxCpEndorChgDetailDto> queryByInsureListCode(@RequestBody Map<String, String> map) throws Exception {
        return nyxCpEndorChgDetailService.queryByInsureLitCode(map.get("insureListCode"));
    }
}
