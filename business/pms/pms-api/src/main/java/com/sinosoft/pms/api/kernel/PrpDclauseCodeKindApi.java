package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseCodeKindDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * @description 条款险别配置表Api接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDclauseCodeKindApi.PATH)
public interface PrpDclauseCodeKindApi {

    public static final String PATH = "prpDclauseCodeKind";


    /**
     * 根据clauseCode条款代码和calculateFlag主险标识代码查询险别
     * @author: 田慧
     * @date: 2017/12/14 14:16
     * @param map 键为clauseCodeclauseCode,calculateFlag主险标识
     * @return kindCode的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryKindCodeByClauseCode",method = {RequestMethod.POST})
     List<String> queryKindCodeByClauseCode(@RequestBody Map<String,String> map)throws Exception;

    /**
     *  根据clauseCode条款代码和kindCode险别代码查询标的
     * @author: 田慧
     * @date: 2017/12/16 10:38
     * @param map 键为clauseCode条款代码,kindCode险别代码
     * @return itemCode的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryItemCodeByClauseCodeAndKindCode",method = {RequestMethod.POST})
     List<String> queryItemCodeByClauseCodeAndKindCode(@RequestBody Map<String,String> map)throws Exception;
    /**
     * 根据条款代码查询条款险别配置
     * @author: 宋振振
     * @date: 2018/4/14 14:20
     * @param map clauseCode
     * @return  List<PrpDclauseCodeKindDto>
     */
    @RequestMapping(value = "queryPrpDclauseCodeKindByClauseCode",method = {RequestMethod.POST})
    public List<PrpDclauseCodeKindDto> queryPrpDclauseCodeKindByClauseCode(@RequestBody Map<String,String> map)throws Exception;
}