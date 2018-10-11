package com.sinosoft.ims.core.kernel.service;


import java.util.List;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.kernel.dto.GradeQueryConditionDto;
import com.sinosoft.ims.api.kernel.dto.SaaGradeDto;
import com.sinosoft.ims.api.kernel.dto.UserGradeConditionDto;


/**
 * @description 岗位服务接口
 * @author hzhongkai
 * @date 2016年9月19日下午2:51:12
 */
public interface GradeService
{

    /**
     * @description 用户岗位配置服务
     * @return ResponseDto
     * @
     * @author hzhongkai
     * @date 2016年9月21日下午4:36:52
     */
    boolean configUserGrade(UserGradeConditionDto userGradeConditionDto)
        ;
    
    /**
     * @description 岗位查询服务,只返回用户拥有的岗位列表 ，不传usercode，则返回所有岗位
     * @return GradeReturnDto
     * @
     * @author hzhongkai
     * @date 2016年9月21日下午4:36:52
     */
    List<SaaGradeDto> queryGradeList(GradeQueryConditionDto gradeQueryConditionDto)
        ;
    
    /**
     * @description 岗位查询服务,返回所有岗位，并将用户拥有的岗位checked属性置为true
     * @return GradeReturnDto
     * @
     * @author hzhongkai
     * @date 2016年9月21日下午4:36:52
     */
    List<SaaGradeDto> queryUserGradeList(GradeQueryConditionDto gradeQueryConditionDto) ;
}
