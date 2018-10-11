package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.pms.api.kernel.PrpDclauseApi;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseDto;
import com.sinosoft.pms.api.kernel.dto.ResponsePrpDclauseDto;
import com.sinosoft.pms.core.kernel.entity.PrpDclause;
import com.sinosoft.pms.core.kernel.service.PrpDclauseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 06:20:36.415
 * @description 条款代码表controller层
 */
@RestController
@RequestMapping(value = PrpDclauseController.PATH)
public class PrpDclauseController implements PrpDclauseApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDclauseController.class);

    @Autowired
    private PrpDclauseService prpDclauseService;
    /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDclauseDto prpDclauseDto) {
        prpDclauseService.save(prpDclauseDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String clauseCode,Integer lineNo) {
        prpDclauseService.remove(clauseCode,lineNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDclauseDto prpDclauseDto) {
        prpDclauseService.modify(prpDclauseDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpDclauseDto queryByPK(@RequestBody String clauseCode,Integer lineNo) {
        return prpDclauseService.queryByPK(clauseCode,lineNo);
    }
    /**
     * 根据条款代码查询条款代码表的风险等级说明，第三方识别说明
     * @author: 宋振振
     * @date: 2017/10/23 15:26
     * @param clauseCode 条款代码
     * @return List<PrpDclauseDto> 返回相应条款代码的条款信息
     */
    public @ResponseBody List<PrpDclauseDto> queryClauseByClauseCode(@RequestParam(value = "clauseCode") String clauseCode) throws Exception{
        return prpDclauseService.queryClauseByClauseCode(clauseCode);
    }

    /**
     * 按险种查询CLauseDto(特约及附加信息双击域)
     * @param map 键为riskCode 险种代码
     * @return ResponseDto(List<PrpDclauseDto>) 返回PrpDclauseDto整个对象
     * @author 王保良
     * @throws Exception
     * @date 2017年10月12日 下午3:20:00
     */
    @Override
    public @ResponseBody List<PrpDclauseDto> queryClauseByRiskCode(@RequestBody Map<String,String> map) throws Exception {
        List<PrpDclauseDto> clauseDtoList=prpDclauseService.queryClauseByRiskCode(map.get("riskCode"));
        return clauseDtoList;
    }

    /**
     *  根据clauseCode 条款代码查询PrpDclause条款信息表信息
     * @author: 田慧
     * @date: 2017/12/2 12:50
     * @param map 包括clauseCode 条款代码
     * @return PrpDclauseDto的集合
     */
    @Override
    public List<PrpDclauseDto> queryPrpdclauseInfoByCondition(@RequestBody Map<String,String> map)throws Exception{
        String clauseCode = map.get("clauseCode");
        String insuranceCode=map.get("insuranceCode");
        return prpDclauseService.queryPrpdclauseInfoByCondition(clauseCode,insuranceCode);

    }

    /**
     * 根据codeCode查询条款代码和条款名称
     * @author: 刘曼曼
     * @date: 2017/12/19 15:16
     * @param map riskCode 险种
     * @return List<ResponsePrpDclauseDto> 保险代码和保险名称集合
     * @throws Exception
     */
    public @ResponseBody List<ResponsePrpDclauseDto> queryPrpdclauseInfo(@RequestBody Map<String,String> map)throws Exception{
        String riskCode=map.get("riskCode");
        return prpDclauseService.queryPrpdclauseInfo(riskCode);
    }

    /**
     * 根据条款代码查询条款内容
     * @author: 刘曼曼
     * @date: 2017/12/19 17:33
     * @param map riskCode 险种代码
     * @return List<String> 条款内容集合
     * @throws Exception
     */

    @Override
    public @ResponseBody List<PrpDclauseDto>  queryByKindContext(@RequestBody Map<String,String> map)throws Exception{
        String clauseCode=map.get("clauseCode");
        String itemCode=map.get("itemCode");
       return prpDclauseService.queryByKindContext(clauseCode,itemCode);
    }

}
