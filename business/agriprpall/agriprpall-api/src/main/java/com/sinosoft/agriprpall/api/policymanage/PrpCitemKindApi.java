package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * @description 标的子险信息Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCitemKindApi.PATH)
public interface PrpCitemKindApi {

    public static final String PATH = "prpCitemKind";

    /**
     * 标的子险信息表保存
     * @author: 田健
     * @date: 2017/12/25 16:25
     * @param prpCitemKindDto 标的子险信息Dto
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpCitemKindDto prpCitemKindDto);

    /**
     * 根据主键删除标的子险信息表数据
     * @author: 田健
     * @date: 2017/12/25 16:27
     * @param map policyNo保单号,itemKindNo 序号
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestBody Map<String,Object> map);

    /**
     * 更新标的子险信息表信息
     * @author: 田健
     * @date: 2017/12/25 16:29
     * @param prpCitemKindDto 标的子险信息Dto
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpCitemKindDto prpCitemKindDto);
    /**
     * 根据主键查询标的子险信息表数据
     * @author: 田健
     * @date: 2017/12/25 16:27
     * @param map policyNo保单号,itemKindNo 序号
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody PrpCitemKindDto queryByPK(@RequestBody Map<String,Object> map);

    /**
     * 根据传来的条件查询PrpCitemKind表，返回List<PrpCitemKindDto>给服务调用
     * @author: 宋振振
     * @date: 2017/11/11 16:39
     * @param statement
     * @return List<PrpCitemKindDto>
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpCitemKindByCondition",method = {RequestMethod.POST})
    public @ResponseBody List<PrpCitemKindDto> queryPrpCitemKindByCondition(@RequestParam("statement") String statement)throws Exception;

    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @param map policyNo 保单号
     * @return List<PrpCitemKind>
     * @author 王心洋
     * @time 2017-11-09
     */
    @RequestMapping(value = "queryItemByPolicyNo", method = RequestMethod.POST)
    List<PrpCitemKindDto> queryItemByPolicyNo(@RequestBody Map<String, String> map) throws Exception;

    /**
     *  根据条件查询标的子险信息表信息
     * @author: 田慧
     * @date: 2017/11/22 17:16
     * @param prpCitemKindDto 保单标的子险信息表Dto
     * @return 返回PrpCitemKindDto的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByConditions",method = RequestMethod.POST)
    public List<PrpCitemKindDto> queryByConditions(@RequestBody PrpCitemKindDto prpCitemKindDto)throws Exception;

    /**
     * @description: （理赔打印查询itemCode）
     * @author: 王志文
     * @date: 2017/11/10 18:02
     * @param policyNo
     * @return
     */
    @RequestMapping(value = "queryItemCodeByPolicyNo",method = {RequestMethod.POST})
    List<PrpCitemKindDto> queryItemCodeByPolicyNo(@RequestParam("policyNo") String policyNo);

    /**
     * @description: （理赔打印查询itemCode）
     * @author: 王保良
     * @date: 2017/11/10 18:02
     * @param policyNo
     * @return
     */
    @RequestMapping(value = "queryPrpCitemKind",method = {RequestMethod.POST})
    List<PrpDcodeDto> queryPrpCitemKind(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 根据PolicyNo保单号和FamilyNo分户序号查询PrpCitemKindDto险别信息的集合
     * @author: 宋振振
     * @date: 2017/12/15 14:16
     * @param map PolicyNo保单号,FamilyNo分户序号
     * @return List<PrpCitemKindDto> 险别信息的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpCitemKindByPolicyNoAndFamilyNo",method = RequestMethod.POST)
    public @ResponseBody List<PrpCitemKindDto> queryPrpCitemKindByPolicyNoAndFamilyNo(@RequestBody Map<String,String> map)throws Exception;

    /**
     * （赔款金额计算通过保单号和险别查询损失率）
     * @author: 王志文
     * @date: 2018/1/8 10:55
     * @param map PolicyNo 保单号 kindCode 险别代码
     * @return List<PrpCitemKindDto> 险别信息集合
     */
    @RequestMapping(value = "queryAllByPolicyNoAndKindCode",method = {RequestMethod.POST})
    List<PrpCitemKindDto> queryAllByPolicyNoAndKindCodeAndItemCode(@RequestBody Map<String,Object> map)throws Exception;

    /**
     * 批量查询险别标的信息
     * @param map policyNos 保单号集合
     * @return List<PrpCitemKindDto>
     * @date: 2018/4/12 11:42
     * @author: 何伟东
     */
    @RequestMapping(value = "queryItemKindByPolicyNos",method = {RequestMethod.POST})
    @ResponseBody List<PrpCitemKindDto> queryItemKindByPolicyNos(@RequestBody Map<String, List<String>> map)throws Exception;
}