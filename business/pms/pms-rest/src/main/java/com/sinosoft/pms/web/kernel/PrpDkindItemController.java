package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.PrpDkindItemApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindItemDto;
import com.sinosoft.pms.api.kernel.dto.QueryItemCodePmsDto;
import com.sinosoft.pms.core.kernel.service.PrpDkindItemService;
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
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDkindItemcontroller层
 */
@RestController
@RequestMapping(value = PrpDkindItemController.PATH)
public class PrpDkindItemController implements PrpDkindItemApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDkindItemController.class);

    @Autowired
    private PrpDkindItemService prpDkindItemService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpDkindItemDto prpDkindItemDto) {
        prpDkindItemService.save(prpDkindItemDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestParam("riskCode") String riskCode, @RequestParam("kindCode") String kindCode, @RequestParam("itemCode") String itemCode) {
        prpDkindItemService.remove(riskCode,kindCode,itemCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDkindItemDto prpDkindItemDto) {
        prpDkindItemService.modify(prpDkindItemDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDkindItemDto queryByPK(@RequestParam("riskCode") String riskCode, @RequestParam("kindCode") String kindCode, @RequestParam("itemCode") String itemCode) {
        return prpDkindItemService.queryByPK(riskCode,kindCode,itemCode);
    }
    /**
     * * 根据险种代码和险别代码查询标的代码
     * @author: 田慧
     * *@param queryItemCodePmsDto  险种代码和险别代码
     * @date: 13:22
     * @return itemCodeList 标的代码集合
     */
   @Override
   public List<String> queryItemCode(@RequestBody QueryItemCodePmsDto queryItemCodePmsDto) throws Exception{
       String riskCode = queryItemCodePmsDto.getRiskCode();
       List<String> kindCodeList= queryItemCodePmsDto.getKindCodeList();
       return prpDkindItemService.queryItemCode(riskCode,kindCodeList);

   }

    /**
     * 根据险别和险种及标的代码查询险别标的关联表
     * @author: 刘曼曼
     * @date: 10:29 10:29
     * @param queryItemCodePmsDto 险种代码,险别代码，标的代码
     * @return List<PrpDkindItemDto> 询险别标的关联表集合
     */
    public List<PrpDkindItemDto> queryFlag(@RequestBody QueryItemCodePmsDto queryItemCodePmsDto)throws Exception{
        String riskCode = queryItemCodePmsDto.getRiskCode();
        List<String> kindCodeList= queryItemCodePmsDto.getKindCodeList();
        List<String> itemCodeList= queryItemCodePmsDto.getItemCodeList();
        return prpDkindItemService.queryFlag(riskCode,kindCodeList,itemCodeList);
    }
}
