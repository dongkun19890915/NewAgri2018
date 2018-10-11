package com.sinosoft.agriclaim.web.recasemanage;

import com.sinosoft.agriclaim.api.recasemanage.PrpLRecaseApi;
import com.sinosoft.agriclaim.api.recasemanage.dto.*;
import com.sinosoft.agriclaim.core.recasemanage.service.PrpLRecaseService;
import com.sinosoft.framework.dto.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:45.570 
 * @description 重开赔案表controller层
 */
@RestController
@RequestMapping(value = PrpLRecaseController.PATH)
public class PrpLRecaseController implements PrpLRecaseApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLRecaseController.class);

    @Autowired
    private PrpLRecaseService prpLRecaseService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLRecaseDto prpLRecaseDto) {
        prpLRecaseService.save(prpLRecaseDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("claimNo") String claimNo,@RequestParam("serialNo")Integer serialNo) {
        prpLRecaseService.remove(claimNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLRecaseDto prpLRecaseDto) {
        prpLRecaseService.modify(prpLRecaseDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRecaseDto queryByPK(@RequestParam("claimNo") String claimNo,@RequestParam("serialNo")Integer serialNo) {
        return prpLRecaseService.queryByPK(claimNo,serialNo);
    }

    /**
     *  重开赔案列表查询
     * @author: 王志文
     * @date: 2017/11/3 15:28
     * @param reCaseDto 重开赔案查询页面输入框信息
     * @return 列表信息 集合
     */
    @Override
    public PageInfo queryReCaseByReCaseDto(@RequestBody ReCaseDto reCaseDto)
            throws Exception {
        return prpLRecaseService.queryBySql(reCaseDto);
    }

    /**
     * （报案号超链接查询 实现方法）
     * @author: 王志文
     * @date: 2017/11/3 10:39
     * @param claimNo 立案号
     * @return 页面显示信息，报案号超链接查询后所需信息
     */
    @Override
    public ReCaseViewDto queryReCaseByClaimNo(String claimNo) throws Exception {
        //查询serialNo最大值的赔款计算书号及重开赔案原因 返回
        return prpLRecaseService.queryReCaseReasonByClaimNo(claimNo);
    }

    /**
     *  重开赔案申请提交双核
     * @author: 王志文
     * @date: 2017/11/3 10:40
     * @param reCaseCommitDto 包含险种名称、立案号、保单号、报案号等基本信息
     * @return 返回提交结果，成功或其他失败信息
     */
    @Override
    public Map<String,String> saveReCaseCommittedByReCaseDto(@RequestBody ReCaseCommitDto reCaseCommitDto) throws Exception {
        return prpLRecaseService.saveReCaseCommittedByReCaseDto(reCaseCommitDto);
    }

    /**
     * （双核审核重开赔案后调用，将审核状态写入到理赔表中）
     * @author: 王志文
     * @date: 2017/11/17 15:18
     * @param undwrtWriteBackReCaseDto 包含流程编号、序号、业务号、审核结果
     * @return int  返回回写结果信息，大于0 则回写成功
     * @throws Exception
     */
    @Override
    public String saveCaseTypeByUndwrt(@RequestBody UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception {
        return prpLRecaseService.saveCaseTypeByUndwrt(undwrtWriteBackReCaseDto);
    }

    /**
     * （重开赔案成功后重新生成理算节点，将新的赔款计算书号写入到重开赔案表中）
     * @author: 王志文
     * @date: 2017/11/17 17:04
     * @param compensateNo 计算书号
     * @return 写入结果，成功或失败
     * @throws Exception
     */
    @Override
    public Map<String,String> saveCompensateNoByRecase(String compensateNo,String claimNo) throws Exception {
        return prpLRecaseService.saveCompensateNoByRecase(compensateNo,claimNo);
    }

    /**
     *  根据投保单号查询PrpLRecase表信息
     * @author: 汪钊
     * @date: 2017/11/20 15:50
     * @param map 包括claimNo立案号
     * @return prpLRecaseDtoList 返回PrpLRecaseDto的集合
     */
    @RequestMapping(value = "queryByClaimNo", method = { RequestMethod.POST })
    public @ResponseBody
    List<PrpLRecaseDto> queryByClaimNo(@RequestBody Map<String, String> map){
        String claimNo = map.get("claimNo");
        return prpLRecaseService.queryByClaimNo(claimNo);
    }
}
