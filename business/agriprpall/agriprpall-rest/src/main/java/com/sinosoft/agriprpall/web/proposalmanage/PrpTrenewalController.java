package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTrenewalApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTrenewalDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTrenewalService;
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
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:33:55.391 
 * @description PrpTrenewalcontroller层
 */
@RestController
@RequestMapping(value = PrpTrenewalController.PATH)
public class PrpTrenewalController implements PrpTrenewalApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTrenewalController.class);

    @Autowired
    private PrpTrenewalService prpTrenewalService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTrenewalDto prpTrenewalDto) {
        prpTrenewalService.save(prpTrenewalDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo) {
        prpTrenewalService.remove(proposalNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTrenewalDto prpTrenewalDto) {
        prpTrenewalService.modify(prpTrenewalDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTrenewalDto queryByPK(@RequestBody String proposalNo) {
        return prpTrenewalService.queryByPK(proposalNo);
    }
}
