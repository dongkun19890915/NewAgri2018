package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PrpCengageApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCengageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 特别约定表controller层
 */
@RestController
@RequestMapping(value = PrpCengageController.PATH)
public class PrpCengageController implements PrpCengageApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpCengageController.class);

    @Autowired
    private PrpCengageService prpCEngageService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpCengageDto prpCEngageDto) {
        prpCEngageService.save(prpCEngageDto);
    }

    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpCengageDto prpCEngageDto) {
        prpCEngageService.modify(prpCEngageDto);
    }

    /**
     * @description: （保单抄件通过保单号查找特别约定）
     * @author: 王志文
     * @date: 2017/11/16 8:51
     * @param policyNo
     * @return
     */
    @Override
    public List<PrpCengageDto> queryEngageByPolicyNo(@RequestParam("policyNo") String policyNo) {
        return prpCEngageService.queryEngageByPolicyNo(policyNo);
    }
}
