package com.sinosoft.ims.api.auth;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.UtiGradeDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description UtiGradeApi接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UtiGradeApi.PATH)
public interface UtiGradeApi {

    public static final String PATH = "utiGrade";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(UtiGradeDto utiGradeDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String gradeCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(UtiGradeDto utiGradeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    UtiGradeDto queryByPK(String gradeCode);
}