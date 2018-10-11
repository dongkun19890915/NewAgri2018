package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLMessageApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestPrpLMessageDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestSavePrpLMessageDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponsePrpLMessageDto;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLMessageService;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLMessageDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔流转讨论留言表controller层
 */
@RestController
@RequestMapping(value = PrpLMessageController.PATH)
public class PrpLMessageController implements PrpLMessageApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLMessageController.class);

    @Autowired
    private PrpLMessageService prpLMessageService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLMessageDto prpLMessageDto) {
        prpLMessageService.save(prpLMessageDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,java.lang.Integer serialNo,java.lang.Integer lineNo) {
        prpLMessageService.remove(registNo,serialNo,lineNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLMessageDto prpLMessageDto) {
        prpLMessageService.modify(prpLMessageDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLMessageDto queryByPK(@RequestBody String registNo,java.lang.Integer serialNo,java.lang.Integer lineNo) {
        return prpLMessageService.queryByPK(registNo,serialNo,lineNo);
    }

    /**
     * （查看理赔沟通页面信息）
     * @param requestPrpLMessageDto 查询理赔沟通页面所需条件
     * @return 理赔沟通页面显示信息
     * @author: 董坤
     * @date: 2017/11/15 19:56
     */
    @Override
    public @ResponseBody
    ResponsePrpLMessageDto queryClaimCommunicationByCondition(@RequestBody RequestPrpLMessageDto requestPrpLMessageDto) {
        return prpLMessageService.queryClaimCommunicationByCondition(requestPrpLMessageDto);
    }

    /**
     * （保存理赔沟通页面信息）
     * @param requestSavePrpLMessageDto 理赔沟通保存的页面信息
     * @return 保存成功与否信息
     * @author: 董坤
     * @date: 2017/11/15 21:11
     */
    @Override
    public @ResponseBody Map<String,String> saveClaimCommunicationInfo(@RequestBody RequestSavePrpLMessageDto requestSavePrpLMessageDto) throws Exception{
        String message = prpLMessageService.saveClaimCommunicationInfo(requestSavePrpLMessageDto);
        Map<String,String> map = new HashMap<>();
        map.put("message",message);
        return map;
    }
    /**
     * 查询留言列表
     * @author: 孙朋飞
     * @date: 2018/4/3 9:30
     * @param map registNo 报案号
     * @return 各节点留言
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PrpLMessageDto> queryPrpLMessageByRegistNo(@RequestBody Map<String, String> map) throws Exception {
        return prpLMessageService.queryPrpLMessageByRegistNo(map.get("registNo"));
    }

}
