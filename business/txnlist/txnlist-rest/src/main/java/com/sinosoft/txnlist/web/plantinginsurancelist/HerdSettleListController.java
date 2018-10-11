package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.HerdSettleListApi;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdSettleListService;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdSettleListDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description 养殖险理赔明细表controller层
 */
@RestController
@RequestMapping(value = HerdSettleListController.PATH)
public class HerdSettleListController implements HerdSettleListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(HerdSettleListController.class);

    @Autowired
    private HerdSettleListService herdSettleListService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody HerdSettleListDto herdSettleListDto) {
        herdSettleListService.save(herdSettleListDto);
    }

//    /**
//     *@description 删除
//     *@param
//     */
//    public void remove(@RequestBody String settleListCode,String earLabel,String fCode,String kindCode,java.lang.Integer serialNo) {
//        herdSettleListService.remove(settleListCode,earLabel,fCode,kindCode,serialNo);
//    }
//    /**
//     *@description 修改
//     *@param
//     */
//    @Override
//    public void modify(@RequestBody HerdSettleListDto herdSettleListDto) {
//        herdSettleListService.modify(herdSettleListDto);
//    }
//    /**
//     *@description 按主键查询实体
//     *@param
//     */
//    public HerdSettleListDto queryByPK(@RequestBody String settleListCode,String earLabel,String fCode,String kindCode,java.lang.Integer serialNo) {
//        return herdSettleListService.queryByPK(settleListCode,earLabel,fCode,kindCode,serialNo);
//    }


//    /**
//     *  根据GIS清单号查询承保清单 养殖险
//     * @param gisInsureListCode
//     * @return
//     * @throws Exception
//     * @author 汪强
//     */
//    @Override
//    public List<HerdSettleListDto> queryByGisInsureListCode(@RequestParam("gisInsureListCode") String gisInsureListCode)throws Exception{
////        return herdSettleListService.queryByGisInsureListCode(gisInsureListCode);
//        return null;
//    }



    /**
     * 根据GIS清单号查询承保清单 养殖险
     * @param gisInsureListCode
     * @return List<PlantingPolicyListDto>
     * @author: 汪强
     * @date: 2017/11/28
     */
    @Override
    public List<HerdSettleListDto> queryByGisInsureListCode(String gisInsureListCode) throws Exception {
        List<HerdSettleListDto> herdSettleListDtoList=herdSettleListService.queryByGisInsureListCode(gisInsureListCode);;
        return herdSettleListDtoList;
    }
}
