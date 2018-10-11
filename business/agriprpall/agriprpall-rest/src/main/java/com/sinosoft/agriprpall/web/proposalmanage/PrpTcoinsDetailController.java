package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTcoinsDetailApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTcoinsDetailDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTcoinsDetailService;
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
 * @time  2017-10-21 05:54:45.680 
 * @description 共保明细信息表controller层
 */
@RestController
@RequestMapping(value = PrpTcoinsDetailController.PATH)
public class PrpTcoinsDetailController implements PrpTcoinsDetailApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTcoinsDetailController.class);

    @Autowired
    private PrpTcoinsDetailService prpTcoinsDetailService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTcoinsDetailDto prpTcoinsDetailDto) {
        prpTcoinsDetailService.save(prpTcoinsDetailDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo,Integer serialNo,String currency) {
        prpTcoinsDetailService.remove(proposalNo,serialNo,currency);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTcoinsDetailDto prpTcoinsDetailDto) {
        prpTcoinsDetailService.modify(prpTcoinsDetailDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTcoinsDetailDto queryByPK(@RequestBody String proposalNo,Integer serialNo,String currency) {
        return prpTcoinsDetailService.queryByPK(proposalNo,serialNo,currency);
    }
}
