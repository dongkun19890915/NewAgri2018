package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel.PrpDclauseCodeKindApi;
import com.sinosoft.pms.core.kernel.service.PrpDclauseCodeKindService;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseCodeKindDto;
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
 * @time  2017-11-07 03:36:19.515 
 * @description 条款险别配置表controller层
 */
@RestController
@RequestMapping(value = PrpDclauseCodeKindController.PATH)
public class PrpDclauseCodeKindController implements PrpDclauseCodeKindApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDclauseCodeKindController.class);

    @Autowired
    private PrpDclauseCodeKindService prpDclauseCodeKindService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDclauseCodeKindDto prpDclauseCodeKindDto) {
        prpDclauseCodeKindService.save(prpDclauseCodeKindDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String clauseCode,java.lang.Double serialNo,String kindCode) {
        prpDclauseCodeKindService.remove(clauseCode,serialNo,kindCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDclauseCodeKindDto prpDclauseCodeKindDto) {
        prpDclauseCodeKindService.modify(prpDclauseCodeKindDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDclauseCodeKindDto queryByPK(@RequestBody String clauseCode,java.lang.Double serialNo,String kindCode) {
        return prpDclauseCodeKindService.queryByPK(clauseCode,serialNo,kindCode);
    }
    /**
     * 根据clauseCode条款代码和calculateFlag主险标识代码查询险别
     * @author: 田慧
     * @date: 2017/12/14 14:16
     * @param map 键为clauseCodeclauseCode,calculateFlag主险标识
     * @return kindCode的集合
     * @throws Exception
     */
    @Override
    public List<String> queryKindCodeByClauseCode(@RequestBody Map<String,String> map)throws Exception{
        String clauseCode = map.get("clauseCode");
        String calculateFlag = map.get("calculateFlag");
        return prpDclauseCodeKindService.queryKindCodeByClauseCode(clauseCode,calculateFlag);
    }
    /**
     *  根据clauseCode条款代码和kindCode险别代码查询标的
     * @author: 田慧
     * @date: 2017/12/16 10:38
     * @param map 键为clauseCode条款代码,kindCode险别代码
     * @return itemCode的集合
     * @throws Exception
     */
    @Override
    public List<String> queryItemCodeByClauseCodeAndKindCode(@RequestBody Map<String, String> map) throws Exception {
        String clauseCode = map.get("clauseCode");
        String kindCode = map.get("kindCode");
        return prpDclauseCodeKindService.queryItemCodeByClauseCodeAndKindCode(clauseCode,kindCode);
    }
    /**
     * 根据条款代码查询条款险别配置
     * @author: 宋振振
     * @date: 2018/4/14 14:20
     * @param map clauseCode
     * @return  List<PrpDclauseCodeKindDto>
     */
    @Override
    public List<PrpDclauseCodeKindDto> queryPrpDclauseCodeKindByClauseCode(@RequestBody Map<String,String> map)throws Exception{
        return prpDclauseCodeKindService.queryPrpDclauseCodeKindByClauseCode(map.get("clauseCode"));
    }
}
