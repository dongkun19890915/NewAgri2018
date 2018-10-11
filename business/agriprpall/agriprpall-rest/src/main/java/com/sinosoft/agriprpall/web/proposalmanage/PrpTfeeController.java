package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTfeeApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTfeeDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTfeeService;
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
 * @time  2017-10-18 08:03:36.446 
 * @description 保单保额保费表controller层
 */
@RestController
@RequestMapping(value = PrpTfeeController.PATH)
public class PrpTfeeController implements PrpTfeeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTfeeController.class);

    @Autowired
    private PrpTfeeService prpTfeeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTfeeDto prpTfeeDto) {
        prpTfeeService.save(prpTfeeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo,String currency) {
        prpTfeeService.remove(proposalNo,currency);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTfeeDto prpTfeeDto) {
        prpTfeeService.modify(prpTfeeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTfeeDto queryByPK(@RequestBody String proposalNo,String currency) {
        return prpTfeeService.queryByPK(proposalNo,currency);
    }
}
