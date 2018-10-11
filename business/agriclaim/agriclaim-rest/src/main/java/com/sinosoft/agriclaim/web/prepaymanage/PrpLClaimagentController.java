package com.sinosoft.agriclaim.web.prepaymanage;

import com.sinosoft.agriclaim.api.prepaymanage.PrpLClaimagentApi;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrpLClaimagentService;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLClaimagentDto;
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
 * @time  2017-11-08 05:44:02.119 
 * @description 代理赔保单信息表controller层
 */
@RestController
@RequestMapping(value = PrpLClaimagentController.PATH)
public class PrpLClaimagentController implements PrpLClaimagentApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLClaimagentController.class);

    @Autowired
    private PrpLClaimagentService prpLClaimagentService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLClaimagentDto prpLClaimagentDto) {
        prpLClaimagentService.save(prpLClaimagentDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String claimNo) {
        prpLClaimagentService.remove(claimNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLClaimagentDto prpLClaimagentDto) {
        prpLClaimagentService.modify(prpLClaimagentDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimagentDto queryByPK(@RequestBody String claimNo) {
        return prpLClaimagentService.queryByPK(claimNo);
    }
}
