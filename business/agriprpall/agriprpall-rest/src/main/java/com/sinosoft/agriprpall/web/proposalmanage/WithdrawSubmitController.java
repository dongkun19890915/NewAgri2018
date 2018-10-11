package com.sinosoft.agriprpall.web.proposalmanage;


import com.sinosoft.agriprpall.api.proposalmanage.WithdrawSubmitApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTrenewalDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.WithdrawSubmitService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:33:55.391 
 * @description PrpTrenewalcontroller层
 */
@RestController
@RequestMapping(value = WithdrawSubmitController.PATH)
public class WithdrawSubmitController implements WithdrawSubmitApi {

    private static Logger LOGGER = LoggerFactory.getLogger(WithdrawSubmitController.class);

    @Autowired
    private WithdrawSubmitService withdrawSubmitService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTrenewalDto prpTrenewalDto) {
        withdrawSubmitService.save(prpTrenewalDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo) {
        withdrawSubmitService.remove(proposalNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTrenewalDto prpTrenewalDto) {
        withdrawSubmitService.modify(prpTrenewalDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTrenewalDto queryByPK(@RequestBody String proposalNo) {
        return withdrawSubmitService.queryByPK(proposalNo);
    }
    /**
     *  撤单
     * @author: 钱浩
     * @date: 2017/10/22 16:30
     * @param map: proposalNo 投保单号
     * @return ResponseDto： 撤单状态：成功或失败
     * @throws Exception
     */
    public @ResponseBody
    Map<String,String> withdrawProposal(@RequestBody Map<String,String> map)throws  Exception{
        String proposalNo=map.get("proposalNo");
        return withdrawSubmitService.withdrawProposal(proposalNo);
    }
}
