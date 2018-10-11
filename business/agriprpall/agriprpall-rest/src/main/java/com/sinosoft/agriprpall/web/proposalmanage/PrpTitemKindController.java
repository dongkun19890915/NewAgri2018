package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTitemKindApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTitemKindDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTitemKindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 标的子险信息controller层
 */
@RestController
@RequestMapping(value = PrpTitemKindController.PATH)
public class PrpTitemKindController implements PrpTitemKindApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpTitemKindController.class);

    @Autowired
    private PrpTitemKindService prpTitemKindService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpTitemKindDto prpTitemKindDto) {
        prpTitemKindService.save(prpTitemKindDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("proposalNo") String proposalNo, @RequestParam("itemkindNo") Integer itemkindNo) {
        prpTitemKindService.remove(proposalNo,itemkindNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpTitemKindDto prpTitemKindDto) {
        prpTitemKindService.modify(prpTitemKindDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTitemKindDto queryByPK(@RequestParam("proposalNo") String proposalNo, @RequestParam("itemkindNo") Integer itemkindNo) {
        return prpTitemKindService.queryByPK(proposalNo,itemkindNo);
    }

    /**
     * 根据投保单号查询PrpTitemKind
     *
     * @param proposalNo
     * @return List<PrpTitemKindDto>
     * @author: 钱浩
     * @date: 2017/12/5 上午 11:47
     */
    public @ResponseBody
    List<PrpTitemKindDto> queryByConnection(@RequestParam("proposalNo") String proposalNo) throws Exception {

        return prpTitemKindService.queryByConnection(proposalNo);
    }
}
