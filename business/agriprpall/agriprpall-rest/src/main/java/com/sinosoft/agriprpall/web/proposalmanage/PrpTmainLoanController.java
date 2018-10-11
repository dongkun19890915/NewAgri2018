package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTmainLoanApi;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTmainLoanService;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainLoanDto;
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
 * @description 贷款保险保单信息表controller层
 */
@RestController
@RequestMapping(value = PrpTmainLoanController.PATH)
public class PrpTmainLoanController implements PrpTmainLoanApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTmainLoanController.class);

    @Autowired
    private PrpTmainLoanService prpTmainLoanService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTmainLoanDto prpTmainLoanDto) {
        prpTmainLoanService.save(prpTmainLoanDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo) {
        prpTmainLoanService.remove(proposalNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTmainLoanDto prpTmainLoanDto) {
        prpTmainLoanService.modify(prpTmainLoanDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTmainLoanDto queryByPK(@RequestBody String proposalNo) {
        return prpTmainLoanService.queryByPK(proposalNo);
    }
}
