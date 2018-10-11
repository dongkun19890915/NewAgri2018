package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTinsuredApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTinsuredDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTinsuredService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = PrpTinsuredController.PATH)
public class PrpTinsuredController implements PrpTinsuredApi {
    private static Logger LOGGER = LoggerFactory.getLogger(PrpTitemKindAgriController.class);
    @Autowired
    private PrpTinsuredService prpTinsuredService;

    @Override
    public void save(PrpTinsuredDto prpTinsuredDto) {

    }

    @Override
    public void remove(String proposalNo, Integer serialNo) {

    }

    @Override
    public void modify(PrpTinsuredDto prpTinsuredDto) {

    }

    @Override
    public PrpTinsuredDto queryByPK(String proposalNo, Integer serialNo) {
        return null;
    }

    /**
     *  根据投保单号查询prpTinsured表信息
     * @author: 田慧
     * @date: 2017/11/20 15:50
     * @param map 包括proposalNo投保单号
     * @return prpTinsuredDtoList 返回PrpTinsuredDto的集合
     * @throws Exception
     */
    @Override
    public List<PrpTinsuredDto> queryByPolicyNo(@RequestBody Map<String,String> map)throws Exception{
        String proposalNo = map.get("proposalNo");
        return prpTinsuredService.queryByPolicyNo(proposalNo);
    }
    /**
     *  根据投保单号、关系人标识查询prpTinsured保险关系人表表信息
     * @author: 田慧
     * @date: 2017/11/20 13:49
     * @param map 包括 proposalNo 投保单号\insuredFlag 关系人标识
     * @return prpTinsuredDtoList 返回保险关系人表Dto的集合
     * @throws Exception
     */
    @Override
    public List<PrpTinsuredDto> queryByCondition(@RequestBody Map<String,String> map) throws Exception{
        String proposalNo = map.get("proposalNo");
        String insuredFlag= map.get("insuredFlag");
        return prpTinsuredService.queryByCondition(proposalNo,insuredFlag);
    }

}
