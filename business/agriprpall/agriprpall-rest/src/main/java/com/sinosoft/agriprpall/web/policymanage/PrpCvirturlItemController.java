package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PrpCvirturlItemApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCvirturlItemDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCvirturlItemService;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value =PrpCvirturlItemController.PATH )
public class PrpCvirturlItemController implements PrpCvirturlItemApi{

    private static Logger LOGGER = LoggerFactory.getLogger(PrpCplanController.class);

    @Autowired
    private PrpCvirturlItemService prpCvirturlItemService;

    /**
     * 根据PolicyNo保单号和FamilyNo分户序号查询PrpCvirturlItemDto虚拟信息集合
     * @author: 宋振振
     * @date: 2017/12/15 15:01
     * @param map PolicyNo保单号,FamilyNo分户序号
     * @return List<PrpCvirturlItemDto> 虚拟信息集合
     * @throws Exception
     */
    public @ResponseBody List<PrpCvirturlItemDto> queryPrpCvirturlItemDtoByPolicyNoAndFamilyNo(@RequestBody Map<String,String> map)throws Exception{
        String policyNo= map.get("policyNo");
        String familyNo=map.get("familyNo");

        return prpCvirturlItemService.queryPrpCvirturlItemDtoByPolicyNoAndFamilyNo(policyNo,familyNo);
    }

    /**
     * 根据policyNo保单号查询PrpCvirturlItemDto虚拟信息集合
     * @author: 安齐崇
     * @date: 2018/1/24 15:01
     * @param map policyNo保单号
     * @return List<PrpCvirturlItemDto> 虚拟信息集合
     * @throws Exception
     */
    @Override
    public List<PrpCvirturlItemDto> queryVirturlItemByPolicyNo(@RequestBody Map<String, String> map) throws Exception {
        String policyNo= map.get("policyNo");
        String riskCode= map.get("riskCode");
        String flag= map.get("flag");
        return prpCvirturlItemService.queryVirturlItemByPolicyNo(policyNo,riskCode,flag);
    }
}
