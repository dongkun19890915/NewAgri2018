package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyRequestDto;
import com.sinosoft.dms.core.dict.service.PrpDcurrencyService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447
 * @description 币别代码表controller层
 */
@RestController
@RequestMapping(value = PrpDcurrencyController.PATH)
public class PrpDcurrencyController implements PrpDcurrencyApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDcurrencyController.class);

    @Autowired
    private PrpDcurrencyService prpDcurrencyService;
    private String validStatus="1";

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDcurrencyDto prpDcurrencyDto) {
        prpDcurrencyService.save(prpDcurrencyDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("currencyCode") String currencyCode) {
        prpDcurrencyService.remove(currencyCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDcurrencyDto prpDcurrencyDto) {
        prpDcurrencyService.modify(prpDcurrencyDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpDcurrencyDto queryByPK(@RequestParam("currencyCode") String currencyCode) {
        return prpDcurrencyService.queryByPK(currencyCode);
    }
    /**
     * 根据条件查询币别信息
     * @author: 宋振振
     * @date: 2017/10/29 11:53
     * @param prpDcurrencyRequestDto 币别查询请求参数的Dto
     * @return List<PrpDcurrencyDto>返回币别信息
     * @throws Exception
     */
    public @ResponseBody List<PrpDcurrencyDto> queryPrpDcurrencyByCondition(@RequestBody PrpDcurrencyRequestDto prpDcurrencyRequestDto)throws Exception{
        return prpDcurrencyService.queryPrpDcurrencyByCondition(prpDcurrencyRequestDto,validStatus);
    }

    /**
     * @description: 查询币别
     * @author: 王心洋
     * @date: 2017/10/29
     * @param currencyCode,languageFlag
     * @return 币别名称
     * @throws Exception
     */
    @Override
    public String translateCode(@RequestParam("currencyCode") String currencyCode,@RequestParam("languageFlag") String languageFlag) {
        return prpDcurrencyService.translateCode(currencyCode,languageFlag);
    }
    /**
     * @description:方法功能简述: 查询所有的币别信息，进行下拉框初始化
     * @author 安齐崇
     * @date 2017年12月13日下午11:56:23
     * @return
     */
    @Override
	public @ResponseBody List<PrpDcurrencyDto> queryAll() {
		return prpDcurrencyService.queryAll();
	}
}
