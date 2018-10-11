package com.sinosoft.ims.core.kernel.service;


import com.sinosoft.ims.api.auth.dto.SubComDto;
import com.sinosoft.ims.api.kernel.dto.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 机构代码表Core接口
 */
public interface PrpDcompanyService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDcompanyDto prpDcompanyDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String comCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDcompanyDto prpDcompanyDto);
    /**
     * 根据主键查询
     * @author: 宋振振
     * @date: 2017/11/14 10:00
     * @param comCode 机构代码
     * @return PrpDcompanyDto 机构代码表信息
     * @throws Exception
     */
    public PrpDcompanyDto queryByPK(String comCode)throws Exception;

    /**
     *  按照comCode查询该机构的上级省级机构
     * @author: 何伟东
     * @date: 2017/10/31 10:33
     * @param comCode 机构代码
     * @return 省级机构信息
     */
    public PrpDcompanyDto queryProvinceComByComCode(String comCode);

    /**
     * 根据机构查询该机构下的所有子机构信息集合
     * @param comCode 机构代码
     * @return 传入机构下得所有子机构信息集合
     * @throws Exception
     */
    List<PrpDcompanyDto> queryDownCompany(String comCode) throws Exception;

    /**
     * 投保单录入归属机构查询的service接口
     * @param queryComCodeInfoDto
     * @return com.sinosoft.framework.dto.ResponseDto
     * @throws Exception
     * @author 李冬松
     * @date 15:54 2017/11/18
     */
    public List<PrpDcompanyDto> findCompany(QueryComCodeInfoDto queryComCodeInfoDto)throws Exception;
    /**
    *
    * @param comCode
    * @return java.util.List<com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto>
    * @throws
    * @author 李冬松
    * @date 14:40 2017/11/27
    */
    public List<PrpDcompanyDto> findByComCode(String comCode)throws Exception;
    /**
     * @description 理赔任务转交查询所有符合条件的二级机构
     * @author 杨航
     * @date 2017年12月11日 下午4:04:46
     * @param
     * @return prpDcompanyDtoList 机构集合
     */
	List<PrpDcompanyTurnTaskDto> queryTurnTaskTwoLevelCompany() ;
	/**
	  * @description 理赔任务转交查询所有符合条件的下级机构
	  * @author 杨航
	  * @date 2017年12月12日 下午2:58:30
	  * @param prpDcompanyDto 入参对象
	  * @return prpDcompanyDtoList 机构集合
	  */
	List<PrpDcompanyTurnTaskDto> queryTurnTaskDownLevelCompany(PrpDcompanyDto prpDcompanyDto) ;
    /**
     * （根据机构代码查询对应中文名称）
     * @param comCode 机构代码
     * @return 中文名称
     * @author: 董坤
     * @date: 2017/11/18 10:50
     */
    public String translateCodeByPK(String comCode);
    /**
     * 查询作业区域
     * 根据班表机构查询表PrpDcompany回显到区域设置页面
     * @author: 孙朋飞
     * @date: 2017/11/9 14:14
     * @param prpdDto 获取班表机构
     * @return 机构代码表的集合
     * @throws Exception
     */
    public List<PrpDcompanyDto> queryPrpDcompanyByHandleDept(PrpDcompanyDto prpdDto) throws Exception;
    /**
     * （查询所有的班表机构）
     * @author: 孙朋飞
     * @date: 2017/11/19 21:22
     * @param prpdDto 总公司的机构代码
     * @return 所有的班表机构
     * @throws Exception
     */
    public List<PrpDcompanyDto> queryPrpDcompanyByComCodePrivate(PrpDcompanyDto prpdDto) throws Exception;
    /**
     *（查询该机构及其下属机构）
     * @author: 孙朋飞
     * @date: 2017/12/12 17:41
     * @param comCode 班表机构
     * @return 机构代码集合
     * @throws Exception
     */
    public List<String> queryPrpDcompanyByComCode(String comCode) throws Exception;


    /**
     * 机构树实现逻辑
     *
     * @param queryComCodeInfoDto 入参
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/27 下午 14:06
     */
    public List<CompanyListDto> queryCompanyTree(QueryComCodeInfoDto queryComCodeInfoDto) throws Exception;
    /**
     * 根据多个机构代码查询对应的名称
     *
     * @param comCodes 多个comCode的List
     * @return comCode -> comCName 的键值对
     * @author: 何伟东
     * @date: 2017/12/21 11:56
     */
    Map<String, String> queryComCNameByComCodes(List<String> comCodes);

    /**
     * 根据机构代码查询该机构的直接子级机构
     *
     * @param comCode 机构代码
     * @return 该机构的所有有效子机构信息
     * @author: 何伟东
     * @date: 2018/1/6 15:04
     */
    List<SubComDto> querySubComInfo(String comCode);

    /**
     * 查询核算单位下的政策性农险机构的下的有效机构，Flag =’1’时校验的是归属机构不可选择中支公司
     Flag =’2’时，校验的是归属机构为政策性农险部时，政策/商业标志应选择“中央政策性
     * @param comCode 归属机构代码
     * @return 机构信息集合
     * @throws Exception
     */
    public Boolean CheckBusinessComCodeInfo(String comCode,String flag)throws Exception;
    /**
     * 
      * @description 调度页面查询查勘调度双击域
      * @author yk
      * @date 2017年12月22日 上午10:18:26
      * @param map对象，里面有查询机构的种类
      * @return DTreeDto树状对象
     */
	List<DTreeDto> queryUnit(String type,String upperComCode);
    /**
     *
     * @description 根据机构代码查询模糊查询和机构级别查询
     * @author 周柯宇
     * @date 2018年1月18日 下午3:27:03
     * @param
     * @return List<PrpDcompanyDto>
     * @Throws Exception
     */
    List<PrpDcompanyDto> queryLikeComcodeAndComlevel(String string, String string2) throws Exception;

    /**
     * 根据机构名称查询机构代码
     * @author 刘曼曼
     * @date 2018年3月1日 下午15:46:03
     * @param comCName 机构名称
     * @return List<PrpDcompanyDto>
     * @throws Exception
     */
    public  List<PrpDcompanyDto> queryComCode(String comCName)throws Exception;


    /**
     * 查询指定机构的所有子级机构
     *
     * @param comCode - 机构代码
     * @author: 何伟东
     * @date: 2018/4/23 15:49
     */
    List<PrpDcompanyDto> querySubordinateCompany(String comCode) throws Exception;
    
}

