package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PrpCplanApi;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCplanService;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-24 07:46:04.010
 * @description 收费计划表controller层
 */
@RestController
@RequestMapping(value = PrpCplanController.PATH)
public class PrpCplanController implements PrpCplanApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpCplanController.class);

    @Autowired
    private PrpCplanService prpCplanService;

    /**
     * @param
     * @description 新增
     */
    @Override
    public void save(@RequestBody PrpCplanDto prpCplanDto) {
        prpCplanService.save(prpCplanDto);
    }

    /**
     * @param
     * @description 修改
     */
    @Override
    public void modify(@RequestBody PrpCplanDto prpCplanDto) {
        prpCplanService.modify(prpCplanDto);
    }

    /**
     * 理赔调用服务，查询未缴费的条数
     *
     * @param policyNo 保单号
     * @return 查询到的数量（int)
     * @author: 田健
     * @date: 2017/11/10 17:16
     */
    @Override
    public long queryPays(@RequestParam("policyNo") String policyNo) {
        return prpCplanService.queryPays(policyNo);
    }

    /**
     * 根据保单号查询收费计划表PrpCplan
     *
     * @param policyNo
     * @return Map<String,String>返回应交费金额总数，拖欠金额总数
     * @throws Exception
     * @author: 宋振振
     * @date: 2017/11/11 14:38
     */
    @Override
    public @ResponseBody
    Map<String, String> queryPrpCplanByPolicyNo(@RequestParam("policyNo") String policyNo) throws Exception {
        return prpCplanService.queryPrpCplanByPolicyNo(policyNo);
    }

    /**
     * 理赔调用服务，查询计划缴费和已缴费
     *
     * @param policyNo 保单号
     * @return int[] 期数
     * @author: 田健
     * @date: 2017/11/11 11:11
     */
    @Override
    public @ResponseBody
    int[] getDelinquentfeeTime(@RequestParam("policyNo") String policyNo) {
        return prpCplanService.getDelinquentfeeTime(policyNo);
    }
    /**
     *  根据保单号查询prpCplan表（收费计划表）信息
     * @author: 田慧
     * @date: 2017/11/20 9:54
     * @param map 包括policyNo保单号
     * @return prpCplanDtoList 返回PrpCplanDto的集合
     */
    @Override
    public List<PrpCplanDto> queryByPolicyNo(@RequestBody Map<String,String> map)throws Exception{
        String policyNo = map.get("policyNo");
        return prpCplanService.queryByPolicyNo(policyNo);
    }

    /**
     * @description: （按保单号查询所有的数据，保单抄件用）
     * @author: 王志文
     * @date: 2017/11/16 9:27
     * @param policyNo
     * @return
     */
    @Override
    public List<PrpCplanDto> queryPrpCplanListByPolicyNo(String policyNo) throws Exception{
        return prpCplanService.queryPrpCplanListByPolicyNo(policyNo) ;
    }

}
