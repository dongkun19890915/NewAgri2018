package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTsubsidyApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTsubsidyDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTsubsidyService;
import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTsubsidyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 补贴表controller层
 */
@RestController
@RequestMapping(value = PrpTsubsidyController.PATH)
public class PrpTsubsidyController implements PrpTsubsidyApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTsubsidyController.class);

    @Autowired
    private PrpTsubsidyService prpTsubsidyService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTsubsidyDto prpTsubsidyDto) {
        prpTsubsidyService.save(prpTsubsidyDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo,String subsidyCode,String subsidyType) {
        prpTsubsidyService.remove(proposalNo,subsidyCode,subsidyType);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTsubsidyDto prpTsubsidyDto) {
        prpTsubsidyService.modify(prpTsubsidyDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTsubsidyDto queryByPK(@RequestBody String proposalNo, String subsidyCode, String subsidyType) {
        return prpTsubsidyService.queryByPK(proposalNo,subsidyCode,subsidyType);
    }
}
