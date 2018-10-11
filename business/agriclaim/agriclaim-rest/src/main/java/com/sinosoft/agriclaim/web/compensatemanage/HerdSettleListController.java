package com.sinosoft.agriclaim.web.compensatemanage;

import com.sinosoft.agriclaim.api.compensatemanage.HerdSettleListApi;
import com.sinosoft.agriclaim.core.compensatemanage.service.HerdSettleListService;
import com.sinosoft.agriclaim.api.compensatemanage.dto.HerdSettleListDto;
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
 * @time  2017-11-08 05:40:44.225 
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
    public void save(@RequestBody HerdSettleListDto herdSettleListDto) {
        herdSettleListService.save(herdSettleListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String settlelistCode,String earlabel,String fCode,String kindCode,java.lang.Integer serialNo) {
        herdSettleListService.remove(settlelistCode,earlabel,fCode,kindCode,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody HerdSettleListDto herdSettleListDto) {
        herdSettleListService.modify(herdSettleListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public HerdSettleListDto queryByPK(@RequestBody String settlelistCode,String earlabel,String fCode,String kindCode,java.lang.Integer serialNo) {
        return herdSettleListService.queryByPK(settlelistCode,earlabel,fCode,kindCode,serialNo);
    }
}
