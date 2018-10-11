package com.sinosoft.agriclaim.web.docmanage;

import com.sinosoft.agriclaim.api.docmanage.PrpLDocApi;
import com.sinosoft.agriclaim.api.docmanage.dto.ClaimListDto;
import com.sinosoft.agriclaim.api.docmanage.dto.ClaimListRequestDto;
import com.sinosoft.agriclaim.api.docmanage.dto.SaveCertifyDto;
import com.sinosoft.agriclaim.core.docmanage.service.PrpLDocService;
import com.sinosoft.agriclaim.api.docmanage.dto.PrpLDocDto;
import com.sinosoft.framework.dto.PageInfo;
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
 * @time  2017-11-08 05:41:23.407 
 * @description 索赔单证信息表controller层
 */
@RestController
@RequestMapping(value = PrpLDocController.PATH)
public class PrpLDocController implements PrpLDocApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLDocController.class);

    @Autowired
    private PrpLDocService prpLDocService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLDocDto prpLDocDto) {
        prpLDocService.save(prpLDocDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String claimNo,String docCode) {
        prpLDocService.remove(claimNo,docCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLDocDto prpLDocDto) {
        prpLDocService.modify(prpLDocDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLDocDto queryByPK(@RequestBody String claimNo,String docCode) {
        return prpLDocService.queryByPK(claimNo,docCode);
    }
    /**
     * @description:方法功能简述:索赔清单查询服务
     * @author 安齐崇
     * @date 2017年11月13日下午1:55:28
     * @param requestDto 参数接收类
     * @return responseDto 组装数据类
     * @throws Exception
     */
    @Override
    public ClaimListDto queryClaimList(@RequestBody ClaimListRequestDto requestDto) throws Exception {
        return prpLDocService.findClaimList(requestDto);
    }
    @Override
    @ResponseBody
    public Map<String, String> saveCertify(@RequestBody SaveCertifyDto requestDto) {
        return prpLDocService.saveCertify(requestDto);
    }

}
