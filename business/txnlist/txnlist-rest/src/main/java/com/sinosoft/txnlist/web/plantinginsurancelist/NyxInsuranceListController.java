package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.NyxInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxInsuranceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * *查询投保清单
 * @Author: 田慧
 * @Date: 2017/12/11 16:11
 */
@RestController
@RequestMapping(value = NyxInsuranceListController.PATH)
public class NyxInsuranceListController implements NyxInsuranceListApi{
    private static Logger LOGGER = LoggerFactory.getLogger(NyxInsuranceListController.class);

    @Autowired
    private NyxInsuranceListService nyxInsuranceListService;
    /**
     * 批量保存清单表信息
     * @author: 田健
     * @date: 2017/12/20 17:01
     * @param nyxInsuranceListDtos 清单信息集合
     */
    @Override
    public String saveByList(@RequestBody List<NyxInsuranceListDto> nyxInsuranceListDtos)throws Exception {
         nyxInsuranceListService.saveByList(nyxInsuranceListDtos);
         return "success";
    }

    /**
     * @param inusreListcode
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:50
     */
    public void removeByInusreListcode(@RequestParam("inusrelistcode") String inusreListcode) {
        nyxInsuranceListService.removeByInusreListcode(inusreListcode);
    }

    /**
     *  根据条件查询投保清单中农户户次
     * @author: 田慧
     * @date: 2017/12/11 19:33
     * @param map 包括inusrelistCode 投保清单编号
     * @return 返回FIdCard的总条数
     * @throws Exception
     */
    @Override
    public Map<String,Long> queryFIdCardByInusrelistCode(@RequestBody Map<String,String> map)throws Exception{
        String inusrelistCode = map.get("inusrelistCode");
        return nyxInsuranceListService.queryFIdCardByInusrelistCode(inusrelistCode);
    }
    /**
     * （根据inreListcode根据查询各项补贴金额与农户自缴份额）
     * @author: 田健
     * @date: 2017/10/20 11:57
     * @param map key值是清单号
     * @return nyxInsuranceListDto 返回各项补贴金额
     */
    @Override
    public NyxInsuranceListDto getSumFee(@RequestBody Map<String,String> map){
        String inusreListCode = map.get("inusreListCode");
        return nyxInsuranceListService.getSumFee(inusreListCode);
    }
    /**
     * 根据条件查询投保清单中总户数
     * @author: 田慧
     * @date: 2017/12/11 20:00
     * @param map 包括inusrelistCode 投保清单编号
     * @return 返回areaNumber总数
     * @throws Exception
     */
    @Override
    public Map<String,Double> queryAreaNumberByInusrelistCode(@RequestBody Map<String,String> map) throws Exception{
        String inusreListCode = map.get("inusreListCode");
        return nyxInsuranceListService.queryAreaNumberByInusrelistCode(inusreListCode);
    }
    /**
     * 根据清单号查询NyxInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/19 14:39
     * @param map 中的key 为inusreListCode 清单编号
     * @return 清单表信息集合
     */
    public @ResponseBody List<NyxInsuranceListDto> queryByInusreListCode(@RequestBody Map<String,String> map){
        String inusreListCode = map.get("inusreListCode");
        return nyxInsuranceListService.queryByInusreListCode(inusreListCode);
    }
    /**
     * 根据保单号查询NyxInsuranceList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param map 中的key为保单号
     * @return NyxInsuranceListDto集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<NyxInsuranceListDto> queryNyxInsuranceListDtoByPolicyNo(@RequestBody Map<String, String> map) throws Exception{
        String policyNo = map.get("policyNo");
        return nyxInsuranceListService.queryNyxInsuranceListDtoByPolicyNo(policyNo);
    }
}
