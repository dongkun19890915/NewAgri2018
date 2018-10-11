package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPtextDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 01:44:37.955 
 * @description 批改文字信息表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpPtextApi.PATH)
public interface PrpPtextApi {

    public static final String PATH = "prpPtext";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpPtextDto prpPtextDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String endorseNo,String policyNo,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpPtextDto prpPtextDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpPtextDto queryByPK(String endorseNo,String policyNo,java.lang.Integer lineNo);

    /**
     * 根据批单号查询批文信息
     * @author: 宋振振
     * @date: 2017/11/20 10:02
     * @param map endorseNo批单号
     * @return List<PrpPtextDto> 返回批文信息
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpPtextByEndorseNo",method = {RequestMethod.POST})
    public @ResponseBody List<PrpPtextDto> queryPrpPtextByEndorseNo(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 修改批文
     * @author: 宋振振
     * @date: 2017/11/20 18:01
     * @param map endorseNo批单号 strPtext批文 fromPage是否该页从批单修改处进入的标志
     * @throws Exception
     */
    @RequestMapping(value = "modifyPrpPtext",method = {RequestMethod.POST})
    public void modifyPrpPtext(@RequestBody Map<String,String> map)throws Exception;
}