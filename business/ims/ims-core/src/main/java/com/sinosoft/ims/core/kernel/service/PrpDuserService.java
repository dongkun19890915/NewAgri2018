package com.sinosoft.ims.core.kernel.service;


import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.RequestPrpDuserDto;
import com.sinosoft.ims.core.kernel.entity.PrpDuser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 员工代码表Core接口
 */
public interface PrpDuserService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDuserDto prpDuserDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String userCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDuserDto prpDuserDto);

    /**
     * 修改当前用户信息
     * @author: 汪强
     * @date: 2018/01/17 10:17
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     */
    void modifyUserInfo(PrpDuserDto prpDuserDto);
    /**
     * 按主键查询实体
     * @author: 宋振振
     * @date: 2017/11/17 10:17
     * @param userCode 员工代码
     * @return PrpDuserDto 员工代码表信息
     * @throws Exception
     */
    public PrpDuserDto queryByPK(String userCode)throws Exception;
    /**
     * @description:（归属业务员查询）
     * @author: 陈道洋
     * @date: 2017/11/2 9:22
     * @param requestPrpDuserDto 请求参数Dto
     * @return 业务员查询结果
     * @throws Exception
     */
    public List<PrpDuserDto> queryHandler1CodeInfo(RequestPrpDuserDto requestPrpDuserDto)throws Exception;

    /**
     *
     * @author: 刘曼曼 根据操作人代码查询操作人名称
     * @date: 2017/11/15 12:10
     * @param userCode 操作人代码
     * @param isChinese 中文标识
     * @return 中文或英文
     */
    String translateCode(String userCode, String isChinese) throws Exception;
    /**
     * （根据员工代码代码查询对应中文名称）
     * @param userCode 员工代码
     * @return 对应中文名称
     * @author: 董坤
     * @date: 2017/11/18 11:03
     */
    public String translateCodeByPK(String userCode);

    /**
     *  根据用户代码查询用户名称
     * @author: 刘曼曼
     * @date: 2017/11/24 14:11
     * @param operatorCodes 用户代码集合
     * @return List<String>用户名称集合
     */
    public List<String> queryOperatorName(List<String> operatorCodes)throws Exception;

    /**
     * * 根据用户代码查询用户名称
     * @author: 田慧
     * @date: 20:09
     * @param operatorCodes 用户代码集合
     * @return  List<String> 用户信息集合
     * @throws Exception
     */
    List<PrpDuserDto> getOperatorCode(@RequestBody List<String> operatorCodes)throws Exception;

    /**
     * 根据多个userCode查询得到list<prpDuser>
     * @author: 何伟东
     * @date: 2017/11/23 14:17
     * @param userCodeList usercode集合
     * @return list<prpDuser>
     */
    public List<PrpDuserDto> queryByUserCodeList(List<String> userCodeList);
    /**
     *  根据员工名称获取员工代码
     * @author: 田慧
     * @date: 2017/12/4 14:46
     * @param userName 员工名称
     * @return PrpDuserDto的集合
     * @throws Exception
     */
    public List<String> queryByUserName(String userName)throws Exception;
    /**
     * @description:方法功能简述: 根据机构查询查勘、核损处理人员
     * @author 安齐崇
     * @date 2017年12月14日下午9:17:16
     * @param comCode 机构编码
     * @return
     */
	List<PrpDuserDto> queryCheckPerson(String comCode);
    /**
     * （查询被维护人）
     * 根据班表机构查询被维护人
     * @author: 孙朋飞
     * @date: 2017/11/20 16:19
     * @param handleDept 班表机构
     * @param queryType 查询类型"1"是查询被维护人，不填查询所有
     * @return 被维护人的集合
     * @throws Exception
     */
    public List<PrpDuserDto> queryPrpDuserByHandleDept(String handleDept,String queryType) throws Exception;

    /**
     * 
      * @description 调度页面查询查勘和定损人员双击域
      * @author yk
      * @date 2017年12月22日 上午10:25:59
      * @param map里面有comCode和taskCode
      * @return List<PrpDuserDto>用户集合
     */
    List<Map<String, String>> queryCheckAndLossPeople(String comCode,String taskCode);
}