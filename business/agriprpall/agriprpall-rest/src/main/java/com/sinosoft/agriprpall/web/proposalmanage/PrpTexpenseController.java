package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTexpenseApi;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTexpenseService;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTexpenseDto;
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
 * @time  2017-10-24 01:57:51.087 
 * @description 税表controller层
 */
@RestController
@RequestMapping(value = PrpTexpenseController.PATH)
public class PrpTexpenseController implements PrpTexpenseApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTexpenseController.class);

    @Autowired
    private PrpTexpenseService prpTexpenseService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTexpenseDto prpTexpenseDto) {
        prpTexpenseService.save(prpTexpenseDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo) {
        prpTexpenseService.remove(proposalNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTexpenseDto prpTexpenseDto) {
        prpTexpenseService.modify(prpTexpenseDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTexpenseDto queryByPK(@RequestBody String proposalNo) {
        return prpTexpenseService.queryByPK(proposalNo);
    }
}
