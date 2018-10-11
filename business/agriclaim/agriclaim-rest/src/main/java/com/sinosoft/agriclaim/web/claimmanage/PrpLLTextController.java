package com.sinosoft.agriclaim.web.claimmanage;

import com.sinosoft.agriclaim.api.claimmanage.PrpLLTextApi;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLLTextService;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案文字表controller层
 */
@RestController
@RequestMapping(value = PrpLLTextController.PATH)
public class PrpLLTextController implements PrpLLTextApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLLTextController.class);

    @Autowired
    private PrpLLTextService prpLLTextService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLLTextDto prpLLTextDto) {
        prpLLTextService.save(prpLLTextDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String claimNo,String textType,java.lang.Integer lineNo) {
        prpLLTextService.remove(claimNo,textType,lineNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLLTextDto prpLLTextDto) {
        prpLLTextService.modify(prpLLTextDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLLTextDto queryByPK(@RequestBody String claimNo,String textType,java.lang.Integer lineNo) {
        return prpLLTextService.queryByPK(claimNo,textType,lineNo);
    }
    /**
     * （理赔打印结案报告获取文本信息）
     * @author: 王志文
     * @date: 2017/11/30 17:15
     * @param claimNo
     * @param textType
     * @return
     */
    @Override
    public List<PrpLLTextDto> queryListByClaimNoAndTextType(String claimNo, String textType) {
        return prpLLTextService.queryListByClaimNoAndTextType(claimNo,textType);
    }
}
