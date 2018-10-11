package com.sinosoft.ims.api.auth;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.UtiUserGradeDto;
/**
 * @author 韩雨怀
 * @mail hanyuhuai@sinsoft.com.cn
 * @time  2017-12-21 16:50.902 
 * @description 用户权限表Api接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UtiUserGradeApi.PATH)
public interface UtiUserGradeApi {
	public static final String PATH = "utiUserGrade";
	
	/**
     *  根据comCode、userCode查询UtiUserGradeDto集合,用于支付信息修改页面,判断权限
     * @author: 韩雨怀
     * @date: 2017/12/21 16:54
     * @param map 包括comCode和userCode
     * @return UtiUserGradeDto集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPayEdit",method = {RequestMethod.POST})
    @ResponseBody List<UtiUserGradeDto> findAllByConditionbyPayEdit(@RequestBody Map<String, String> map) throws Exception;
    /**
     *  根据comCode、userCode查询UtiUserGradeDto集合,用于支付信息修改页面,判断权限
     * @author: 韩雨怀
     * @date: 2017/12/21 16:54
     * @param map 包括comCode和userCode
     * @return UtiUserGradeDto集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPayFind",method = {RequestMethod.POST})
	@ResponseBody List<UtiUserGradeDto> findAllByConditionbyPayFind(@RequestBody Map<String, String> map) throws Exception;
}
