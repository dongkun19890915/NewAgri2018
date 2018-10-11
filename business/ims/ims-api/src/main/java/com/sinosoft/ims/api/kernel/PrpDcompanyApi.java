package com.sinosoft.ims.api.kernel;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.SubComDto;
import com.sinosoft.ims.api.kernel.dto.CompanyListDto;
import com.sinosoft.ims.api.kernel.dto.DTreeDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyTurnTaskDto;
import com.sinosoft.ims.api.kernel.dto.QueryComCodeInfoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 机构代码表Api接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = PrpDcompanyApi.PATH)
public interface  PrpDcompanyApi {

    public static final String PATH = "prpDcompany";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    public void save(@RequestBody PrpDcompanyDto prpDcompanyDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    public void remove(@RequestParam("comCode") String comCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    public void modify(@RequestBody PrpDcompanyDto prpDcompanyDto);
    /**
     * 根据主键查询
     * @author: 宋振振
     * @date: 2017/11/14 10:00
     * @param comCode 机构代码
     * @return PrpDcompanyDto 机构代码表信息
     * @throws Exception
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    public @ResponseBody PrpDcompanyDto queryByPK(@RequestParam("comCode") String comCode)throws Exception;
    /**
     * 根据主键查询(map)
     * @author: 宋振振
     * @date: 2017/11/14 10:00
     * @param map 中的comCode 机构代码
     * @return PrpDcompanyDto 机构代码表信息
     * @throws Exception
     */
    @RequestMapping(value = "queryByPKByMap",method = {RequestMethod.POST})
    public @ResponseBody PrpDcompanyDto queryByPKByMap(@RequestBody Map<String,String> map) throws Exception;
    /**
     *  按照comCode查询该机构的上级省级机构
     * @author: 何伟东
     * @date: 2017/10/31 10:33
     * @param comCode 机构代码
     * @return
     */
    @GetMapping(value = "queryProvinceComByComCode")
    public @ResponseBody PrpDcompanyDto queryProvinceComByComCode(@RequestParam(value = "comCode") String comCode);


    /**
     * 根据传入的机构代码查询该机构下所有子机构信息集合
     * @param map 键为comCode 机构代码
     * @return 传入机构下得所有子机构信息集合
     * @throws Exception
     */
    @RequestMapping(value = "queryDownCompany",method = {RequestMethod.POST})
    List<PrpDcompanyDto> queryDownCompany(@RequestBody Map<String,String> map) throws Exception;

    /**
    * 投保单录入归属机构查询
    * @param queryComCodeInfoDto
    * @return com.sinosoft.framework.dto.ResponseDto 归属机构的集合
    * @throws Exception
    * @author 李冬松
    * @date 15:54 2017/11/18
    */
    @RequestMapping(value = "queryComCodeInfo",method = RequestMethod.POST)
    public @ResponseBody List<PrpDcompanyDto> queryComCodeInfo(@RequestBody QueryComCodeInfoDto queryComCodeInfoDto) throws Exception;

    /**
    * @description
    * @param comCode
    * @return java.util.List<com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto>
    * @throws
    * @author 李冬松
    * @date 14:40 2017/11/27
    */
    @RequestMapping(value = "queryByComCode",method = {RequestMethod.POST})
    public List<PrpDcompanyDto> queryByComCode(@RequestParam(value = "comCode") String comCode)throws Exception;
    /**
      * @description 理赔任务转交查询所有符合条件的二级机构
      * @author 杨航
      * @date 2017年12月11日 下午4:04:46
      * @param
      * @return prpDcompanyTurnTaskDtoList 机构集合
      */
	@RequestMapping(value = "queryTurnTaskTwoLevelCompany", method = { RequestMethod.POST })
	public @ResponseBody List<PrpDcompanyTurnTaskDto> queryTurnTaskTwoLevelCompany() throws Exception;
	/**
     * @description 理赔任务转交查询所有符合条件的下级机构
     * @author 杨航
     * @date 2017年12月11日 下午4:04:46
     * @param
     * @return prpDcompanyTurnTaskDtoList 机构集合
     */
	@RequestMapping(value = "queryTurnTaskDownLevelCompany", method = { RequestMethod.POST })
	public @ResponseBody List<PrpDcompanyTurnTaskDto> queryTurnTaskDownLevelCompany(@RequestBody PrpDcompanyDto prpDcompanyDto) throws Exception;

    /**
     * （根据机构代码查询对应中文名称）
     * @author: 董坤
     * @date: 2017/11/18 10:50
     * @param comCode 机构代码
     * @return 中文名称
     */
    @RequestMapping(value = "translateCodeByPK",method = {RequestMethod.POST})
    @ResponseBody String translateCodeByPK(@RequestParam("comCode") String comCode);
    /**
     * 查询作业区域
     * 根据班表机构查询表PrpDcompany回显到区域设置页面
     * @author: 孙朋飞
     * @date: 2017/11/9 11:44
     * @param prpDcompanyDto 获取班表机构 （comcode）
     * @return 机构代码表的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpDcompanyByHandleDept",method = {RequestMethod.POST})
    @ResponseBody
    List<PrpDcompanyDto> queryPrpDcompanyByHandleDept(@RequestBody PrpDcompanyDto prpDcompanyDto) throws Exception;
    /**
     * （查询所有的班表机构）
     * @author: 孙朋飞
     * @date: 2017/11/19 21:22
     * @param prpDcompanyDto 总公司的机构代码
     * @return 所有的班表机构
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpDcompanyByComCodePrivate",method = {RequestMethod.POST})
    public @ResponseBody List<PrpDcompanyDto> queryPrpDcompanyByComCodePrivate(@RequestBody PrpDcompanyDto prpDcompanyDto) throws Exception;
    /**
     *（查询该机构及其下属机构）
     * @author: 孙朋飞
     * @date: 2017/12/12 17:41
     * @param comCode 班表机构
     * @return 机构代码集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpDcompanyByComCode",method = {RequestMethod.POST})
    public @ResponseBody List<String> queryPrpDcompanyByComCode(@RequestParam(value="comCode")String comCode  ) throws Exception;


    /**
     * 机构树实现逻辑
     *
     * @param queryComCodeInfoDto 入参
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/27 下午 14:06
     */
    @RequestMapping(value = "queryCompanyTree", method = {RequestMethod.POST})
    public @ResponseBody
    List<CompanyListDto> queryCompanyTree(@RequestBody QueryComCodeInfoDto queryComCodeInfoDto) throws Exception;

    /**
     * 查询核算单位下的政策性农险机构的下的有效机构，Flag =’1’时校验的是归属机构不可选择中支公司
     Flag =’2’时，校验的是归属机构为政策性农险部时，政策/商业标志应选择“中央政策性
     * @param map key中的 comCode 归属机构代码
     * @return 机构信息集合
     * @throws Exception
     */
    @RequestMapping(value = "CheckBusinessComCodeInfo",method = {RequestMethod.POST})
    public @ResponseBody Boolean CheckBusinessComCodeInfo(@RequestBody Map<String,String> map)throws Exception;
    /**
     * 根据多个机构代码查询对应的名称
     *
     * @param comCodes 多个comCode的List
     * @return comCode -> comCName 的键值对
     * @author: 何伟东
     * @date: 2017/12/21 11:56
     */
    @RequestMapping(value = "queryComCNameByComCodes", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> queryComCNameByComCodes(@RequestBody List<String> comCodes);

    /**
     * 根据机构代码查询该机构的直接子级机构
     *
     * @param param comCode 机构代码
     * @return 该机构的所有有效子机构信息
     * @author: 何伟东
     * @date: 2018/1/6 15:04
     */
    @RequestMapping(value = "querySubComInfo", method = RequestMethod.POST)
    @ResponseBody
    List<SubComDto> querySubComInfo(@RequestBody Map<String, String> param);
    
    /**
     * 
      * @description 调度页面查询查勘调度双击域
      * @author yk
      * @date 2017年12月22日 上午10:18:26
      *@param map 对象，里面有查询机构的种类
      * @return DTreeDto树状对象
     */
    @RequestMapping(value = "queryUnit",method = {RequestMethod.POST})
    @ResponseBody List<DTreeDto> queryUnit(@RequestBody Map<String, String> map);

    /**
     *
     * @description 根据机构代码查询模糊查询和机构级别查询
     * @author 周柯宇
     * @date 2018年1月18日 下午3:27:03
     * @param
     * @return List<PrpDcompanyDto>
     * @Throws Exception
     */
    @RequestMapping(value = "queryLikeComcodeAndComlevel", method = RequestMethod.POST)
    @ResponseBody
    List<PrpDcompanyDto> queryLikeComcodeAndComlevel(@RequestBody Map<String, String> map) throws Exception;

    /**
     * 根据机构名称查询机构代码
     * @author 刘曼曼
     * @date 2018年3月1日 下午15:46:03
     * @param map  机构名称comCName
     * @return List<PrpDcompanyDto>
     * @throws Exception
     */
    @RequestMapping(value = "queryComCode", method = RequestMethod.POST)
    public @ResponseBody List<PrpDcompanyDto> queryComCode(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 查询指定机构的所有子级机构
     *
     * @param map comCode - 机构代码
     * @author: 何伟东
     * @date: 2018/4/23 15:49
     */
    @RequestMapping(value = "querySubordinateCompany", method = {RequestMethod.POST})
    @ResponseBody
    List<PrpDcompanyDto> querySubordinateCompany(@RequestBody Map<String, String> map) throws Exception;

}