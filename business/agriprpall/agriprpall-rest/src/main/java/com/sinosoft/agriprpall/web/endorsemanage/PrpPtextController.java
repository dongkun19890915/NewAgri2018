package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.PrpPtextApi;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPtextService;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPtextDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 01:44:37.955 
 * @description 批改文字信息表controller层
 */
@RestController
@RequestMapping(value = PrpPtextController.PATH)
public class PrpPtextController implements PrpPtextApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpPtextController.class);

    @Autowired
    private PrpPtextService prpPtextService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpPtextDto prpPtextDto) {
        prpPtextService.save(prpPtextDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String endorseNo,String policyNo,java.lang.Integer lineNo) {
        prpPtextService.remove(endorseNo,policyNo,lineNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpPtextDto prpPtextDto) {
        prpPtextService.modify(prpPtextDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpPtextDto queryByPK(@RequestBody String endorseNo,String policyNo,java.lang.Integer lineNo) {
        return prpPtextService.queryByPK(endorseNo,policyNo,lineNo);
    }
    /**
     * 根据批单号查询批文信息
     * @author: 宋振振
     * @date: 2017/11/20 10:02
     * @param map endorseNo批单号
     * @return List<PrpPtextDto> 返回批文信息
     * @throws Exception
     */
    public @ResponseBody List<PrpPtextDto> queryPrpPtextByEndorseNo(@RequestBody Map<String,String> map)throws Exception{
        String endorseNo=map.get("endorseNo");//批单号
        return prpPtextService.queryPrpPtextByEndorseNo(endorseNo);
    }
    /**
     * 修改批文
     * @author: 宋振振
     * @date: 2017/11/20 18:01
     * @param map endorseNo批单号 strPtext批文 fromPage是否该页从批单修改处进入的标志
     * @throws Exception
     */
    public void modifyPrpPtext(@RequestBody Map<String,String> map)throws Exception{
        String endorseNo=map.get("endorseNo");//批单号
        String strPtext=map.get("strPtext");//批文
        String fromPage=map.get("fromPage");//是否该页从批单修改处进入的标志
        prpPtextService.modifyPrpPtext(endorseNo,strPtext,fromPage);
    }
}
