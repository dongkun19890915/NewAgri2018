package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTplanApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTplanDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTplanDto;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTplan;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 收费计划表controller层
 */
@RestController
@RequestMapping(value = PrpTplanController.PATH)
public class PrpTplanController implements PrpTplanApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTplanController.class);

    @Autowired
    private PrpTplanService prpTplanService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTplanDto prpTplanDto) {
        prpTplanService.save(prpTplanDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String proposalNo,Integer serialNo) {
        prpTplanService.remove(proposalNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTplanDto prpTplanDto) {
        prpTplanService.modify(prpTplanDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTplanDto queryByPK(@RequestBody String proposalNo, Integer serialNo) {
        return prpTplanService.queryByPK(proposalNo,serialNo);
    }

    /**
     *  根据投保单号查询prpTplan 收费计划表详细信息
     * @author: 田慧
     * @date: 2017/11/20 9:37
     * @param map 包括proposalNo投保单号
     * @return prpTplanDtoList  返回收费计划表Dto的集合
     */
    @Override
    public List<PrpTplanDto> queryByProposalNo(@RequestBody Map<String,String> map) throws Exception{
        String proposalNo = map.get("proposalNo");
        return prpTplanService.queryByProposalNo(proposalNo);
    }

}
