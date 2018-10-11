package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.PrpDsubsidyApi;
import com.sinosoft.pms.api.kernel.dto.PrpDsubsidyDto;
import com.sinosoft.pms.core.kernel.service.PrpDsubsidyService;
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
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDsubsidycontroller层
 */
@RestController
@RequestMapping(value = PrpDsubsidyController.PATH)
public class PrpDsubsidyController implements PrpDsubsidyApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDsubsidyController.class);

    @Autowired
    private PrpDsubsidyService prpDsubsidyService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpDsubsidyDto prpDsubsidyDto) {
        prpDsubsidyService.save(prpDsubsidyDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody String riskCode,String comCode,String subsidyYear,String validStatus,String subsidyCode,String subsidyType) {
        prpDsubsidyService.remove(riskCode,comCode,subsidyYear,validStatus,subsidyCode,subsidyType);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDsubsidyDto prpDsubsidyDto) {
        prpDsubsidyService.modify(prpDsubsidyDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDsubsidyDto queryByPK(@RequestBody String riskCode,String comCode,String subsidyYear,String validStatus,String subsidyCode,String subsidyType) {
        return prpDsubsidyService.queryByPK(riskCode,comCode,subsidyYear,validStatus,subsidyCode,subsidyType);
    }
    /**
     * 根据条件查询PrpDsubsidy补贴信息表信息(此方法只针对3218险种)
     * @author: 田健
     * @date: 2017/12/1 18:41
     * @param map 集合，存放 riskCode险种，comCode归属机构，subsidyYear年份
     * @return 返回List<PrpDsubsidyDto>补贴信息表信息集合
     * @throws Exception
     */
    @Override
    public List<PrpDsubsidyDto> findPrpDsubsidyDtoListByCondition(@RequestBody Map<String,String> map)throws Exception{
        String riskCode = map.get("riskCode");
        String comCode =  map.get("comCode");
        String subsidyYear =  map.get("subsidyYear");
        return prpDsubsidyService.findPrpDsubsidyDtoListByCondition(riskCode,comCode,subsidyYear);
    }
}
