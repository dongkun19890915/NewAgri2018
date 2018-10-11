package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.HerdInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.MiddleHerdInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdInsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.MiddleHerdInsuranceListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdInsuranceListService;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.MiddleHerdInsuranceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * @description 投保明细表controller层
 */
@RestController
@RequestMapping(value = MiddleHerdInsuranceListApi.PATH)
public class  MiddleHerdInsuranceListController implements MiddleHerdInsuranceListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(MiddleHerdInsuranceListController.class);
    @Autowired
    private MiddleHerdInsuranceListService middleHerdInsuranceListService;

    /**
     * 保存
     * @author: 田健
     * @date: 2018/3/19 12:02
     * @param middleHerdInsuranceListDto 养殖险Dto
     */
    @Override
    public void save(@RequestBody MiddleHerdInsuranceListDto middleHerdInsuranceListDto) {
        middleHerdInsuranceListService.save(middleHerdInsuranceListDto);
    }
    /**
     *根据主键删除
     * @author: 田健
     * @date: 2018/3/19 14:13
     * @param map 中的key为inusreListCode 清单编号 ，fCode 农户代码，kindCode 险别代码
     */
    @Override
    public void remove(@RequestBody Map<String,String> map) {
        String inusreListCode = map.get("inusreListCode");
        String fCode = map.get("fCode");
        String kindCode = map.get("kindCode");
        middleHerdInsuranceListService.remove(inusreListCode, fCode, kindCode);
    }
    /**
     *修改
     * @author: 田健
     * @date: 2018/3/19 14:14
     * @param middleHerdInsuranceListDto 养殖险Dto
     */
    @Override
    public void modify(@RequestBody MiddleHerdInsuranceListDto middleHerdInsuranceListDto) {
        middleHerdInsuranceListService.modify(middleHerdInsuranceListDto);
    }
    /**
     * 根据主键查询
     * @author: 田健
     * @date: 2018/3/19 14:15
     * @param map 中的key为inusreListCode 清单编号 ，fCode 农户代码，kindCode 险别代码
     * @return 养殖险对象
     */
    @Override
    public @ResponseBody
    MiddleHerdInsuranceListDto queryByPK(@RequestBody Map<String,String> map) {
        String inusreListCode = map.get("inusreListCode");
        String fCode = map.get("fCode");
        String kindCode = map.get("kindCode");
        return middleHerdInsuranceListService.queryByPK(inusreListCode, fCode, kindCode);
    }
    /**
     * 根据清单号查询HerdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/19 14:39
     * @param map 中的key为 inusreListCode 清单编号
     * @return 清单表信息集合
     */
    @Override
    public @ResponseBody List<MiddleHerdInsuranceListDto> queryByInusreListCode(@RequestBody Map<String,String> map){
        String inusreListCode = map.get("inusreListCode");
        return middleHerdInsuranceListService.queryByInusreListCode(inusreListCode);
    }
}
