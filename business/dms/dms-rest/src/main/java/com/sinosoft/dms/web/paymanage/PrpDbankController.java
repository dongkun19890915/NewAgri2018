package com.sinosoft.dms.web.paymanage;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.dms.api.paymanage.PrpDbankApi;
import com.sinosoft.dms.api.paymanage.dto.PrpDbankDto;
import com.sinosoft.dms.core.paymanage.service.PrpDbankService;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-02-13 03:08:45.046 
 * @description 银行定义表controller层
 */
@RestController
@RequestMapping(value = PrpDbankController.PATH)
public class PrpDbankController implements PrpDbankApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDbankController.class);

    @Autowired
    private PrpDbankService prpDbankService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDbankDto prpDbankDto) {
        prpDbankService.save(prpDbankDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("bankCode") String bankCode) {
        prpDbankService.remove(bankCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDbankDto prpDbankDto) {
        prpDbankService.modify(prpDbankDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @ResponseBody
    public PrpDbankDto queryByPK(@RequestParam("bankCode") String bankCode) {
        return prpDbankService.queryByPK(bankCode);
    }

	@Override
	@ResponseBody
	public List<PrpDbankDto> getBanklist(@RequestBody Map<String, String> map_banklist) {
		 return prpDbankService.getBanklist( map_banklist);
	}
}
