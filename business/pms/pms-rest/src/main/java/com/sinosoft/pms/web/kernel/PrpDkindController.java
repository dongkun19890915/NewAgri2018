package com.sinosoft.pms.web.kernel;


import com.sinosoft.pms.api.kernel.PrpDkindApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;
import com.sinosoft.pms.core.kernel.service.PrpDkindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 08:08:33.126
 *  险别代码表controller层
 */
@RestController
@RequestMapping(value = PrpDkindController.PATH)
public class PrpDkindController implements PrpDkindApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDkindController.class);

    @Autowired
    private PrpDkindService prpDkindService;

    /**
     * 新增
     *@param
     */
    @Override
    public void save(@RequestBody PrpDkindDto prpDkindDto) {
        prpDkindService.save(prpDkindDto);
    }

    /**
     * 删除
     *@param
     */
    @Override
    public void remove(@RequestParam(value = "riskCode") String riskCode,@RequestParam(value = "kindCode") String kindCode) {
        prpDkindService.remove(riskCode,kindCode);
    }
    /**
     * 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDkindDto prpDkindDto) {
        prpDkindService.modify(prpDkindDto);
    }
    /**
     * 按主键查询实体
     *@param
     */
    @Override
    public @ResponseBody PrpDkindDto queryByPK(@RequestParam(value = "riskCode") String riskCode,@RequestParam(value = "kindCode") String kindCode) {
        return prpDkindService.queryByPK(riskCode,kindCode);
    }

    /**
     * 根据riskCode查询prpdkind表
     * @author: 何伟东
     * @date: 2017/10/31 16:28
     * @param parme riskCode 险种代码
     * @return 包含所有险别信息的list
     */
    @Override
    public @ResponseBody List<PrpDkindDto> queryByRiskCode(@RequestBody Map<String,String> parme) {
        return prpDkindService.queryByRiskCode(parme.get("riskCode"));
    }

    /**
     * 查询主险附加险别信息
     * @author: 何伟东
     * @date: 2017/11/4 16:04
     * @param parme
     * @return 险别信息对象
     */
    @Override
    public @ResponseBody List<PrpDkindDto> queryKindCodeInfo(@RequestBody Map<String,String> parme )  throws Exception {
        return prpDkindService.queryKindCodeInfo(parme.get("riskCode"),parme.get("kindCName") ,parme.get("codeType") );
    }

    /**
     * 根据多个险别序号查询该险种下的险别信息
     *
     * @param parme riskCode-险种代码；kindCodes-险别代码集合（list）
     * @return 险别代码-险别中文名称
     * @author: 何伟东
     * @date: 2018/1/11 18:01
     */
    @Override
    public @ResponseBody Map<String, String> queryByKindCodes(@RequestBody Map<String, Object> parme) throws Exception {
        return prpDkindService.queryByKindCodes((String) parme.get("riskCode"),(List<String>) parme.get("kindCodes"));
    }


}
