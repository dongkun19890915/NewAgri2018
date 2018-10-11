package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PrpCinsuredApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCinsuredDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.RequestPrpCinsuredDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCinsuredService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = PrpCinsuredController.PATH)
public class PrpCinsuredController implements PrpCinsuredApi{
    private static Logger LOGGER = LoggerFactory.getLogger(PrpCplanController.class);
    @Autowired
    private PrpCinsuredService prpCinsuredService;

    /**
     * 根据主键查询prpCinsured 投保人被保险人关系表信息
     * @author: 田慧
     * @date: 2017/11/20 16:35
     * @param requestPrpCinsuredDto 包括policyNo保单号、serialNo 序号
     * @return  返回 PrpCinsuredDto
     */
    @Override
    public PrpCinsuredDto queryByPK(@RequestBody RequestPrpCinsuredDto requestPrpCinsuredDto){
        String policyNo = requestPrpCinsuredDto.getPolicyNo();
        Integer serialNo = requestPrpCinsuredDto.getSerialNo();
        return prpCinsuredService.queryByPK(policyNo,serialNo);
    }
    /**
     *   根据保单号查询prpCinsured表信息
     * @author: 田慧
     * @date: 2017/11/20 16:19
     * @param map 包括policyNo保单号
     * @return prpCinsuredDtoList 返回prpCinsuredDto的集合
     * @throws Exception
     */
    @Override
    public List<PrpCinsuredDto> queryByPolicyNo(@RequestBody Map<String,String> map)throws Exception{
        return prpCinsuredService.queryByPolicyNo(map.get("policyNo"));
    }
    /**
     *  根据保单号、关系人标识查询prpCinsured 投保人被保险人关系表表信息
     * @author: 田慧
     * @date: 2017/11/20 16:51
     * @param  map 包括policyNo保单号、insuredFlag关系人标识
     * @return prpCinsuredDtoList 返回prpCinsuredDto的集合
     * @throws Exception
     */
    @Override
    public List<PrpCinsuredDto> queryByCondition(@RequestBody Map<String,String> map)throws Exception{
        String policyNo = map.get("policyNo");
        String insuredFlag = map.get("insuredFlag");
        return prpCinsuredService.queryByCondition(policyNo,insuredFlag);
    }
    /**
     *  根据身份证查询PrpCinsuredDto 投保人被保险人关系表Dto结果集
     * @author: 田慧
     * @date: 2017/11/22 10:20
     * @parammap 包括policyNo保单号、dentifyNumber 身份证件号
     * @return 返回prpCinsuredDtoList 投保人被保险人关系表Dto的集合
     */
    @Override
    public List<PrpCinsuredDto> queryPolicyNoByID(@RequestBody Map<String,String> map)throws Exception{
        String policyNo = map.get("policyNo");
        String identifyNumber = map.get("identifyNumber");
        return prpCinsuredService.queryPolicyNoByID(policyNo,identifyNumber);
    }

    @Override
    public List<PrpCmainDto> queryPolicyById(@RequestBody Map<String, String> map) throws Exception {
        String identifyNumber = map.get("identifyNumber");
        return prpCinsuredService.queryPolicyById(identifyNumber);
    }

    /**
     * （查询被保险人代码）
     * @author: 王志文
     * @date: 2018/3/31 18:14
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public List<PrpCinsuredDto> queryInsuredCodeByPolicyNoAndInsuredName(@RequestBody Map<String, String> map) throws Exception {
        String policyNo = map.get("policyNo");
        return prpCinsuredService.queryInsuredCodeByPolicyNoAndInsuredName(policyNo);
    }

    /**
     * 根据被保险人代码查询被保险人信息
     * @author: 王志文
     * @date: 2018/3/31 18:14
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public List<PrpCinsuredDto> queryByInsuredCode(@RequestBody Map<String, String> map) throws Exception {
        return prpCinsuredService.queryByInsuredCode(map.get("insuredCode"));
    }

}
