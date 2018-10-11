package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDkindAgriDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@FeignClient(name = PMSConstant.PMS_SERVICE_NAME,path =PrpDkindAgriApi.PATH )
public interface PrpDkindAgriApi {
    public static String PATH="prpdkindagri";

    @RequestMapping(value = "queryByPk",method = RequestMethod.POST)
    public PrpDkindAgriDto queryByPk(@RequestBody Map<String,String> map) throws Exception;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(@RequestBody PrpDkindAgriDto prpDkindAgriDto) throws Exception;

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public void delete(@RequestBody Map<String,String > map)throws Exception;

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@RequestBody PrpDkindAgriDto prpDkindAgriDto)throws Exception;

    /**
     * 根据riskCode查询prpdkind表
     * @author: 何伟东
     * @date: 2017/10/31 16:28
     * @param param riskCode 险种代码
     * @return 包含所有险别信息的list
     */
    @RequestMapping(value = "queryByRiskCode",method = {RequestMethod.POST})
    @ResponseBody
    List<PrpDkindAgriDto> queryByRiskCode(@RequestBody Map<String,String> param);

    /**
     * 查询主险附加险别信息
     * @author: 何伟东
     * @date: 2017/11/4 16:04
     * @param parme
     * @return 险别信息对象
     */
    @RequestMapping(value = "queryKindCodeInfo",method = {RequestMethod.POST})
    @ResponseBody List<PrpDkindAgriDto> queryKindCodeInfo(@RequestBody Map<String,String> parme)  throws Exception;

    /**
     * （根据险别代码查询prpdkindagri表返回中文或英文名称）
     * @author: 刘曼曼
     * @date: 2018/1/22 15:47
     * @param map riskCode 险种代码 kindCode险别代码 isChinese 中文标识
     * @return 中文或英文名称
     */
    @RequestMapping(value = "translateCode",method = {RequestMethod.POST})
    public @ResponseBody String translateCode(@RequestBody Map<String,String> map) throws Exception;
}
