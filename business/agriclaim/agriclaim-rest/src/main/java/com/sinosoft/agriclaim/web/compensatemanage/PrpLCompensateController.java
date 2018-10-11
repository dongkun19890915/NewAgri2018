package com.sinosoft.agriclaim.web.compensatemanage;

import com.sinosoft.agriclaim.api.compensatemanage.PrpLCompensateApi;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLCompensateService;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔款计算书表controller层
 */
@RestController
@RequestMapping(value = PrpLCompensateController.PATH)
public class PrpLCompensateController implements PrpLCompensateApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCompensateController.class);

    @Autowired
    private PrpLCompensateService prpLCompensateService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCompensateDto prpLCompensateDto) {
        prpLCompensateService.save(prpLCompensateDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String compensateNo) {
        prpLCompensateService.remove(compensateNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCompensateDto prpLCompensateDto) {
        prpLCompensateService.modify(prpLCompensateDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCompensateDto queryByPK(@RequestBody String compensateNo) {
        return prpLCompensateService.queryByPK(compensateNo);
    }
    /**
     * 承保清单的下载
     * @author: 孙朋飞
     * @date: 2017/12/28 17:47
     * @param param policyNo 保单号
     * @return 下载链接
     * @throws Exception
     */
    @Override
    public @ResponseBody  Map<String, String> expNyxPolicyList(@RequestBody Map<String, String> param) throws Exception {
        return prpLCompensateService.expNyxPolicyList(param);
    }

    /**
     *  根据立案号查询PrpLCompensate信息
     * @author: 周柯宇
     * @date: 2017-12-7 17:02:49
     * @param proposalNo 投保单号
     * @return prpLCompensateDtoList  返回赔款计算书表表Dto集合
     */
    @ResponseBody
    public List<PrpLCompensateDto> queryClaimNo(@RequestParam("claimNo") String claimNo) throws Exception {

        return prpLCompensateService.queryClaimNo(claimNo);
    }

    /**
     * （按险种代码查询理算数据）
     * @author: 王志文
     * @date: 2018/3/28 16:02
     * @param riskCode
     * @return
     * @throws Exception
     */
    @Override
    public List<PrpLCompensateDto> queryByRiskCode(@RequestParam("riskCode") String riskCode) throws Exception {
        return prpLCompensateService.queryByRiskCode(riskCode);
    }
}
