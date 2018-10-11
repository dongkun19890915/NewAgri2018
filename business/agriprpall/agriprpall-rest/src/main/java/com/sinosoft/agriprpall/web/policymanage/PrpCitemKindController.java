package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PrpCitemKindApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCitemKindService;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * @description 标的子险信息controller层
 */
@RestController
@RequestMapping(value = PrpCitemKindController.PATH)
public class PrpCitemKindController implements PrpCitemKindApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpCitemKindController.class);

    @Autowired
    private PrpCitemKindService prpCitemKindService;

    /**
     * 标的子险信息表保存
     * @author: 田健
     * @date: 2017/12/25 16:25
     * @param prpCitemKindDto 标的子险信息Dto
     */
    @Override
    public void save(@RequestBody PrpCitemKindDto prpCitemKindDto) {
        prpCitemKindService.save(prpCitemKindDto);
    }

    /**
     * 根据主键删除标的子险信息表数据
     * @author: 田健
     * @date: 2017/12/25 16:27
     * @param map policyNo保单号,itemKindNo 序号
     */
    @Override
    public void remove(@RequestBody Map<String,Object> map) {
        String policyNo = (String) map.get("policyNo");
        Integer itemKindNo = (Integer) map.get("itemKindNo");
        prpCitemKindService.remove(policyNo,itemKindNo);
    }
    /**
     * 更新标的子险信息表信息
     * @author: 田健
     * @date: 2017/12/25 16:29
     * @param prpCitemKindDto 标的子险信息Dto
     */
    @Override
    public void modify(@RequestBody PrpCitemKindDto prpCitemKindDto) {
        prpCitemKindService.modify(prpCitemKindDto);
    }
    /**
     * 根据主键查询标的子险信息表数据
     * @author: 田健
     * @date: 2017/12/25 16:27
     * @param map policyNo保单号,itemKindNo 序号
     */
    @Override
    public @ResponseBody PrpCitemKindDto queryByPK(@RequestBody Map<String,Object> map) {
        String policyNo = (String) map.get("policyNo");
        Integer itemKindNo = (Integer) map.get("itemKindNo");
        return prpCitemKindService.queryByPK(policyNo,itemKindNo);
    }
    /**
     * 根据传来的条件查询PrpCitemKind表，返回List<PrpCitemKindDto>给服务调用
     * @author: 宋振振
     * @date: 2017/11/11 16:39
     * @param statement
     * @return List<PrpCitemKindDto>
     * @throws Exception
     */
    public @ResponseBody List<PrpCitemKindDto> queryPrpCitemKindByCondition(@RequestParam("statement") String statement)throws Exception{
        return prpCitemKindService.queryPrpCitemKindByCondition(statement);
    }
    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param map policyNo 保单号
     * @return List<PrpCitemKind>
     */
    @Override
    public List<PrpCitemKindDto> queryItemByPolicyNo(@RequestBody Map<String, String> map) throws Exception {
        String policyNo = map.get("policyNo");
        return prpCitemKindService.findItemByPolicyNo(policyNo);
    }
    /**
     *  根据条件查询标的子险信息表信息
     * @author: 田慧
     * @date: 2017/11/22 17:16
     * @param prpCitemKindDto 保单标的子险信息表Dto
     * @return 返回PrpCitemKindDto的集合
     * @throws Exception
     */
    @Override
    public List<PrpCitemKindDto> queryByConditions(@RequestBody PrpCitemKindDto prpCitemKindDto)throws Exception{
        return prpCitemKindService.queryByConditions(prpCitemKindDto);
    }
    /**
     * @description: （理赔打印查询itemCode）
     * @author: 王志文
     * @date: 2017/11/11 9:20
     * @param policyNo
     * @return
     */
    @Override
    public List<PrpCitemKindDto> queryItemCodeByPolicyNo(String policyNo) {
        return prpCitemKindService.queryItemCodeByPolicyNo(policyNo);
    }

    /**
     * @description: （理赔打印查询itemCode）
     * @author: 王志文
     * @date: 2017/11/11 9:20
     * @param map
     * @return
     */
    @Override
    public List<PrpDcodeDto> queryPrpCitemKind(@RequestBody Map<String,String> map) {
        return prpCitemKindService.queryItemCodeList(map.get("policyNo"));
    }
    /**
     * 根据PolicyNo保单号和FamilyNo分户序号查询PrpCitemKindDto险别信息的集合
     * @author: 宋振振
     * @date: 2017/12/15 14:16
     * @param map PolicyNo保单号,FamilyNo分户序号
     * @return List<PrpCitemKindDto> 险别信息的集合
     * @throws Exception
     */
    public @ResponseBody List<PrpCitemKindDto> queryPrpCitemKindByPolicyNoAndFamilyNo(@RequestBody Map<String,String> map)throws Exception{
        String policyNo= map.get("policyNo");
        String familyNo= map.get("familyNo");
        return prpCitemKindService.queryPrpCitemKindByPolicyNoAndFamilyNo(policyNo,familyNo);
    }

    /**
     * （赔款金额计算通过保单号和险别查询损失率）
     * @author: 王志文
     * @date: 2018/1/8 10:49
     * @param map
     * @return List<PrpCitemKindDto> 险别信息集合
     */
    @Override
    public List<PrpCitemKindDto> queryAllByPolicyNoAndKindCodeAndItemCode(@RequestBody Map<String,Object> map)throws Exception {
        String policyNo = (String)map.get("policyNo");
        String kindCode = (String)map.get("kindCode");
        String itemCode = (String)map.get("itemCode");
        return prpCitemKindService.queryAllByPolicyNoAndKindCode(policyNo,kindCode,itemCode);
    }

    /**
     * 批量查询险别标的信息
     * @param map policyNos 保单号集合
     * @return List<PrpCitemKindDto>
     * @date: 2018/4/12 11:42
     * @author: 何伟东
     */
    @Override
    public @ResponseBody List<PrpCitemKindDto> queryItemKindByPolicyNos(@RequestBody Map<String, List<String>> map) throws Exception {
        return prpCitemKindService.queryItemKindByPolicyNos(map.get("policyNos"));
    }
}
