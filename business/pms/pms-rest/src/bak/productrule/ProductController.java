package com.sinosoft.pms.web.productrule;

import com.sinosoft.pms.api.productrule.ProductApi;
import com.sinosoft.pms.api.productrule.dto.*;
import com.sinosoft.pms.core.productrule.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gaofeng on 2017/7/28.
 */
@RestController
@RequestMapping(ProductApi.PATH)
public class ProductController implements ProductApi{
    @Autowired
    ProductService productService;

    @Override
    public List<UtiFactorDto> getPremiumFactorList(UtiFactorConditionDto input) throws Exception {
        return productService.getPremiumFactorList(input);
    }

    @Override
    public List<UtiDecisionDto> getPremiumDecisionList(UtiDecisionConditionDto input) throws Exception {
        return productService.getPremiumDecisionList(input);
    }

    @Override
    public UtiFormulaDto getPremiumFormula(UtiFormulaConditionDto input) throws Exception {
        return productService.getPremiumFormula(input);
    }
}
