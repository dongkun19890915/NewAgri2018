package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.PrpXpColApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpXpColDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpXpColService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 06:23:40.452 
 * @description 批文数据字典表controller层
 */
@RestController
@RequestMapping(value = PrpXpColApi.PATH)
public class PrpXpColController implements PrpXpColApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpXpColController.class);

    @Autowired
    private PrpXpColService prpXpColService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpXpColDto prpXpColDto) {
        prpXpColService.save(prpXpColDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String riskCode,String tableName,java.lang.Integer colSeq,java.lang.Integer disSeq) {
        prpXpColService.remove(riskCode,tableName,colSeq,disSeq);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpXpColDto prpXpColDto) {
        prpXpColService.modify(prpXpColDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpXpColDto queryByPK(@RequestBody String riskCode,String tableName,java.lang.Integer colSeq,java.lang.Integer disSeq) {
        return prpXpColService.queryByPK(riskCode,tableName,colSeq,disSeq);
    }
}
