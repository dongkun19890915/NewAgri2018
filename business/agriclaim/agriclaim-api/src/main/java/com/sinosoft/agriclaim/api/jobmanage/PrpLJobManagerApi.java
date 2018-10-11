package com.sinosoft.agriclaim.api.jobmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.jobmanage.dto.*;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981 
 * @description 班表管理主表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLJobManagerApi.PATH)
public interface PrpLJobManagerApi {

    public static final String PATH = "prpLJobManager";

    /**
     * @Description: 根据条件查询是否存在该月班表主表信息
     * @throws Exception
     * @Author: 李文刚
     * @Date： 2017/11/13 9:08
     * @Param prpLJobManagerDto 班表机构handleDept，班表月份month，险类classCode,当班人handlerName
     * @Return prpLJobManagerDtoList 班表主表信息集合
     */
    @RequestMapping (value="queryJobManagerByCondition",method = {RequestMethod.POST})
    public @ResponseBody List<PrpLJobManagerDto> queryJobManagerByCondition(@RequestBody PrpLJobManagerDto prpLJobManagerDto)throws Exception;

    /**
     * @Description: 根据班表机构handleDept，班表月份month，险类classCode,当班人handlerName查询班表主表，班表从表，联系表信息
     * 此服务接口为班表管理模块的上个月班表查询，机构查询，个人查询所公用.具体由prpLJobManagerDto中queryType前端赋值判断查询方式
     * queryType:copy查询上个月班表信息，queryType:institution为机构查询queryType:personal个人查询
     * @throws  Exception
     * @author: 李文刚
     * @date: 2017/11/22 14:16
     * @Param prpLJobManagerDto 封装查询条件参数：班表机构handleDept，班表月份month，险类classCode,当班人handlerName,queryType为查询方式判断
     * @Return PrpLJobManagerSaveDto 班表主表结果集，从表结果集，联系人表结果集封装成DTO对象
     */
    @RequestMapping (value="queryJobManagerDetailByCondition",method = {RequestMethod.POST})
    public @ResponseBody PrpLJobManagerSaveDto queryJobManagerDetailByCondition(@RequestBody PrpLJobManagerDto prpLJobManagerDto)throws Exception;

   /**
     * @Description: 新增和修改班表主表信息
     * @Author:李文刚
     * @Date：2017/11/2 20:13
     * @Param PrpLJobManagerSaveDto 新增和修改班表信息的对象
     * @Return String   保存成功与否字符串提示
     * @throws Exception`
     */
    @RequestMapping(value="savePrpLJobManager",method = {RequestMethod.POST})
    public  @ResponseBody Map<String,String> savePrpLJobManager(@RequestBody PrpLJobManagerSaveDto prpLJobManagerSaveDto)throws Exception;

    /**
     * @Description: 分页查询班表主表信息
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/11/13 17:02
     * @Param queryPrpLJobManagerDto  month  handleDept  classCode  handlerName 封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */
    @RequestMapping (value="queryPrpLJobManagerByCondition",method = {RequestMethod.POST})
    public @ResponseBody
    PageInfo<PrpLJobManagerDto> queryPrpLJobManagerByCondition(@RequestBody QueryPrpLJobManagerDto queryPrpLJobManagerDto)throws Exception;


    /**
     * @Description: 调度环节需要的班表查询按钮信息查询
     * @throws Exception
     * @Author: 李文刚
     * @date: 2017/12/14 16:26
     * @Param queryPrpLJobManagerDto   handleDept  classCode  time1  time2 封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */
    @RequestMapping (value="queryDispatcherPrpLJobManagerByCondition",method = {RequestMethod.POST})
    public @ResponseBody
    PageInfo<PrpManagerDto> queryDispatcherPrpLJobManagerByCondition(@RequestBody QueryPrpLJobManagerDto queryPrpLJobManagerDto)throws Exception;
    /**
     *查询当天班表信息
     * @author: 孙朋飞
     * @date: 2017/12/13 17:26
     * @param requestPrpLJobManagerDto （policyNo保单号（必传），handleDept班表机构（必传））
     * @return 班表信息列表集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpLJobManagerByPolicyNoAndHandleDept",method = {RequestMethod.POST})
    public @ResponseBody
    List<ResponsePrpLJobManagerDto> queryPrpLJobManagerByPolicyNoAndHandleDept(@RequestBody RequestPrpLJobManagerDto requestPrpLJobManagerDto) throws Exception;


}