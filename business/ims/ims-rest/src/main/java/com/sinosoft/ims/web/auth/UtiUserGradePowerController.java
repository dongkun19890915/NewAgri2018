package com.sinosoft.ims.web.auth;

import com.sinosoft.ims.api.auth.UtiUserGradePowerApi;
import com.sinosoft.ims.api.auth.dto.UtiUserGradePowerDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.core.auth.service.UtiUserGradePowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = UtiUserGradePowerController.PATH)
public class UtiUserGradePowerController implements UtiUserGradePowerApi{
    private static Logger LOGGER = LoggerFactory.getLogger(UtiUserGradePowerController.class);
    @Autowired
    private UtiUserGradePowerService utiUserGradePowerService;
    @Override
    public void save(UtiUserGradePowerDto utiUserGradePowerDto) {

    }

    @Override
    public void remove(String comCode, String userCode, String gradeCode, Integer serialNo) {

    }

    @Override
    public void modify(UtiUserGradePowerDto utiUserGradePowerDto) {

    }

    @Override
    public UtiUserGradePowerDto queryByPK(String comCode, String userCode, String gradeCode, Integer serialNo) {
        return null;
    }

    /**
     * 业务员特殊批改查询所属机构的业务员
     * @author: 宋振振
     * @date: 2018/3/17 17:22
     * @param  map 机构代码和保单号
     * @return 业务员名称和代码
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PrpDuserDto> queryUserCode(@RequestBody Map map)throws Exception{
        String comCode=(String)map.get("comCode");
        List<String> policyNos=(List<String>)map.get("policyNos");
        return utiUserGradePowerService.queryUserCode(comCode,policyNos);
    }
}
