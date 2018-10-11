package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTcoinsDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 05:54:45.680 
 *  共保信息表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpTcoinsApi.PATH)
public interface PrpTcoinsApi {

    public static final String PATH = "prpTcoins";

    /**
     * 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpTcoinsDto prpTcoinsDto);

    /**
     * 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String proposalNo, Integer serialNo);
    /**
     * 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpTcoinsDto prpTcoinsDto);
    /**
     * 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpTcoinsDto queryByPK(String proposalNo, Integer serialNo);
    /**
     * 按proposalNo查询实体集合
     * @author 王心洋
     *@param proposalNo 投保单号
     * @return PrpTcoinsDto 共保信息list集合
     */
    @RequestMapping(value = "findByProposalNo",method = {RequestMethod.POST})
    List<PrpTcoinsDto> findByProposalNo(String proposalNo);
}