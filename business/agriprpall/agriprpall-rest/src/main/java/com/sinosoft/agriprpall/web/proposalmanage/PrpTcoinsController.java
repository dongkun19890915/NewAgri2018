package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTcoinsApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTcoinsDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTcoinsDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTcoinsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 05:54:45.680 
 *  共保信息表controller层
 */
@RestController
@RequestMapping(value = PrpTcoinsController.PATH)
public class PrpTcoinsController implements PrpTcoinsApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTcoinsController.class);

    @Autowired
    private PrpTcoinsService prpTcoinsService;

   /**
     * 新增
     *@param
     */
    public void save(@RequestBody PrpTcoinsDto prpTcoinsDto) {
        prpTcoinsService.save(prpTcoinsDto);
    }

    /**
     * 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo,Integer serialNo) {
        prpTcoinsService.remove(proposalNo,serialNo);
    }
    /**
     * 修改
     *@param
     */
    public void modify(@RequestBody PrpTcoinsDto prpTcoinsDto) {
        prpTcoinsService.modify(prpTcoinsDto);
    }
    /**
     * 按主键查询实体
     *@param 
     */
    public PrpTcoinsDto queryByPK(@RequestBody String proposalNo, Integer serialNo) {
        return prpTcoinsService.queryByPK(proposalNo,serialNo);
    }
    /**
     * 按proposalNo查询实体集合
     * @author 王心洋
     * @time 2017-11-08
     * @param proposalNo 投保单号
     * @return PrpTcoinsDto 共保信息list集合
     */
    public List<PrpTcoinsDto> findByProposalNo(String proposalNo){
        return prpTcoinsService.findByProposalNo(proposalNo);
    }
}
