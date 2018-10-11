package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel.PrpDkindAgriApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindAgriDto;
import com.sinosoft.pms.core.kernel.service.PrpDkindAgriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = PrpDkindAgriApi.PATH)
public class PrpDkindAgriController implements PrpDkindAgriApi {
    @Autowired
    private PrpDkindAgriService prpDkindAgriService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpDkindAgriDto queryByPk(@RequestBody Map<String, String> map) throws Exception {
        return prpDkindAgriService.queryByPK(map.get("riskCode"),map.get("kindCode"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(@RequestBody PrpDkindAgriDto prpDkindAgriDto) throws Exception {
        prpDkindAgriService.save(prpDkindAgriDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(@RequestBody Map<String, String> map) throws Exception {
        prpDkindAgriService.remove(map.get("riskCode"),map.get("kindCode"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(@RequestBody PrpDkindAgriDto prpDkindAgriDto) throws Exception {
        prpDkindAgriService.modify(prpDkindAgriDto);
    }

    /**
     * 根据riskCode查询prpdkind表
     * @author: 何伟东
     * @date: 2017/10/31 16:28
     * @param parme riskCode 险种代码
     * @return 包含所有险别信息的list
     */
    @Override
    public @ResponseBody
    List<PrpDkindAgriDto> queryByRiskCode(@RequestBody Map<String,String> parme) {
        return prpDkindAgriService.queryByRiskCode(parme.get("riskCode"));
    }

    /**
     * 查询主险附加险别信息
     * @author: 何伟东
     * @date: 2017/11/4 16:04
     * @param parme
     * @return 险别信息对象
     */
    @Override
    public @ResponseBody List<PrpDkindAgriDto> queryKindCodeInfo(@RequestBody Map<String,String> parme )  throws Exception {
        return prpDkindAgriService.queryKindCodeInfo(parme.get("riskCode"),parme.get("kindCName") ,parme.get("codeType") );
    }

    /**
     * （根据险别代码查询prpdkindagri表返回中文或英文名称）
     * @author: 刘曼曼
     * @date: 2018/1/22 15:47
     * @param map riskCode 险种代码 kindCode险别代码 isChinese 中文标识
     * @return 中文或英文名称
     */
    @Override
    public @ResponseBody String translateCode(@RequestBody Map<String,String> map) throws Exception{
        String kindCode=map.get("kindCode");
        String riskCode=map.get("riskCode");
        String isChinese=map.get("isChinese");
        return prpDkindAgriService.translateCode(kindCode,riskCode,isChinese);
    }
}
