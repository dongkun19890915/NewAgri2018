package com.sinosoft.agriprpall.api.endorsemanage;


import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpXpColDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 06:23:40.452 
 * @description 批文数据字典表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpXpColApi.PATH)
public interface PrpXpColApi {

    public static final String PATH = "prpXpCol";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpXpColDto prpXpColDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String riskCode,String tableName,java.lang.Integer colSeq,java.lang.Integer disSeq);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpXpColDto prpXpColDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpXpColDto queryByPK(String riskCode,String tableName,java.lang.Integer colSeq,java.lang.Integer disSeq);
}