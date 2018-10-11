package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTitemKindDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 标的子险信息Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpTitemKindApi.PATH)
public interface PrpTitemKindApi {

    public static final String PATH = "prpTitemKind";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpTitemKindDto prpTitemKindDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("proposalNo") String proposalNo, @RequestParam("itemkindNo") Integer itemkindNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpTitemKindDto prpTitemKindDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpTitemKindDto queryByPK(@RequestParam("proposalNo") String proposalNo, @RequestParam("itemkindNo") Integer itemkindNo);

    /**
     * 根据投保单号查询PrpTitemKind
     *
     * @param proposalNo
     * @return List<PrpTitemKindDto>
     * @author: 钱浩
     * @date: 2017/12/5 上午 11:47
     */
    @RequestMapping(value = "queryByConnection", method = {RequestMethod.POST})
    @ResponseBody
    List<PrpTitemKindDto> queryByConnection(@RequestParam("proposalNo") String proposalNo) throws Exception;
}