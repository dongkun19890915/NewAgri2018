package com.sinosoft.ims.core.auth.service;


import com.sinosoft.ims.api.auth.dto.UtiUserGradePowerDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 机构员工岗位业务权限表Core接口
 */
public interface UtiUserGradePowerService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiUserGradePowerDto utiUserGradePowerDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String comCode, String userCode, String gradeCode, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiUserGradePowerDto utiUserGradePowerDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiUserGradePowerDto queryByPK(String comCode, String userCode, String gradeCode, Integer serialNo);

    /**
     * 根据comCode、userCode、gradeCode查询UtiUserGradePower表信息
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @return UtiUserGradePowerDto集合
     * @throws Exception
     */
    List<UtiUserGradePowerDto> queryAllByCondition(String comCode, String userCode) throws Exception;
    /**
     * 业务员特殊批改查询所属机构的业务员
     * @author: 宋振振
     * @date: 2018/3/17 17:22
     * @param comCode
     * @param   policyNos
     * @return 业务员名称和代码
     * @throws Exception
     */
    public List<PrpDuserDto> queryUserCode(String comCode, List<String> policyNos)throws Exception;


}