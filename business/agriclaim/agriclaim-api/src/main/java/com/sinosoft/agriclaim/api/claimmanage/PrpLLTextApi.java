package com.sinosoft.agriclaim.api.claimmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案文字表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLLTextApi.PATH)
public interface PrpLLTextApi {

    public static final String PATH = "prpLLText";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLLTextDto prpLLTextDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String claimNo,String textType,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLLTextDto prpLLTextDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLLTextDto queryByPK(String claimNo,String textType,java.lang.Integer lineNo);

    /**
     * （理赔打印结案报告获取文本信息）
     * @author: 王志文
     * @date: 2017/11/30 17:15
     * @param claimNo
     * @param textType
     * @return
     */
    @RequestMapping(value = "",method = {RequestMethod.POST})
    List<PrpLLTextDto> queryListByClaimNoAndTextType(@RequestParam("claimNo") String claimNo, @RequestParam("textType")String textType);

}