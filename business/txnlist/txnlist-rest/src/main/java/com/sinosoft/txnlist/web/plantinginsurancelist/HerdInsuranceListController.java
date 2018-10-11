package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.HerdInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdInsuranceListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdInsuranceListService;
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
@RequestMapping(value = HerdInsuranceListApi.PATH)
public class HerdInsuranceListController implements HerdInsuranceListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(HerdInsuranceListController.class);
    @Autowired
    private HerdInsuranceListService herdInsuranceListService;

    /**
     * 保存
     * @author: 田健
     * @date: 2018/3/19 12:02
     * @param herdInsuranceListDto 养殖险Dto
     */
    @Override
    public void save(@RequestBody HerdInsuranceListDto herdInsuranceListDto) {
        herdInsuranceListService.save(herdInsuranceListDto);
    }
    /**
     *根据主键删除
     * @author: 田健
     * @date: 2018/3/19 14:13
     * @param map 中的key为inusreListCode 清单编号,earlAbel ，fCode 农户代码，kindCode 险别代码
     */
    @Override
    public void remove(@RequestBody Map<String,String> map) {
        String inusreListCode = map.get("inusreListCode");
        String earlAbel = map.get("earlAbel");
        String fCode = map.get("fCode");
        String kindCode = map.get("kindCode");
        herdInsuranceListService.remove(inusreListCode, earlAbel, fCode, kindCode);
    }
    /**
     *修改
     * @author: 田健
     * @date: 2018/3/19 14:14
     * @param herdInsuranceListDto 养殖险Dto
     */
    @Override
    public void modify(@RequestBody HerdInsuranceListDto herdInsuranceListDto) {
        herdInsuranceListService.modify(herdInsuranceListDto);
    }
    /**
     * 根据主键查询
     * @author: 田健
     * @date: 2018/3/19 14:15
     * @param map 中的key为inusreListCode 清单编号,earlAbel ，fCode 农户代码，kindCode 险别代码
     * @return 养殖险对象
     */
    @Override
    public @ResponseBody HerdInsuranceListDto queryByPK(@RequestBody Map<String,String> map) {
        String inusreListCode = map.get("inusreListCode");
        String earlAbel = map.get("earlAbel");
        String fCode = map.get("fCode");
        String kindCode = map.get("kindCode");
        return herdInsuranceListService.queryByPK(inusreListCode, earlAbel, fCode, kindCode);
    }
    /**
     * 根据清单号查询HerdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/19 14:39
     * @param map 中的key为 inusreListCode 清单编号
     * @return 清单表信息集合
     */
    @Override
    public @ResponseBody List<HerdInsuranceListDto> queryByInusreListCode(@RequestBody Map<String,String> map){
        String inusreListCode = map.get("inusreListCode");
        return herdInsuranceListService.queryByInusreListCode(inusreListCode);
    }

    /**
     * 查询count
     *
     * @param map
     * @return
     */
    @Override
    public @ResponseBody
    long countByInusreListCode(@RequestBody Map<String, String> map) {
        String inusreListCode = map.get("inusreListCode");
        return herdInsuranceListService.countByInusreListCode(inusreListCode);
    }
    /**
     * 根据保单号查询HerdInsuranceList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param map 中的key为保单号
     * @return HerdInsuranceListDto集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<HerdInsuranceListDto> queryNyxInsuranceListDtoByPolicyNo(@RequestBody Map<String, String> map) throws Exception{
        String policyNo = map.get("policyNo");
        return herdInsuranceListService.queryNyxInsuranceListDtoByPolicyNo(policyNo);
    }
}
