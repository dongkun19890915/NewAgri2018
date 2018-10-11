package com.sinosoft.ims.web.auth;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.ims.api.auth.UtiUserGradeApi;
import com.sinosoft.ims.api.auth.dto.UtiUserGradeDto;
import com.sinosoft.ims.core.auth.service.UtiUserGradeService;
/**
 * @author 韩雨怀
 * @mail hanyuhuai@sinosoft.com.cn
 * @time  2017-12-21 17:11:27.902 
 * @description 用户权限表Controller层
 */
@RestController
@RequestMapping(value = UtiUserGradeApi.PATH)
public class UtiUserGradeController implements UtiUserGradeApi{
	
	@Autowired
	private UtiUserGradeService utiUserGradeService;
	/**
     *  根据comCode、userCode查询UtiUserGradeDto集合,用于支付信息修改页面,判断权限
     * @author: 韩雨怀
     * @date: 2017/12/21 16:54
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @return UtiUserGradeDto集合
     * @throws Exception
     */
	@Override
	@ResponseBody
	public List<UtiUserGradeDto> findAllByConditionbyPayEdit(@RequestBody Map<String,String> map) throws Exception{
		String comCode = map.get("comCode");
		String userCode = map.get("userCode");
		return utiUserGradeService.queryAllByConditon(comCode, userCode);
	}
	/**
     *  根据comCode、userCode查询UtiUserGradeDto集合,用于支付信息查询页面,判断权限
     * @author: 韩雨怀
     * @date: 2017/12/21 16:54
     * @param map
     * @return UtiUserGradeDto集合
     * @throws Exception
     */
	@Override
	@ResponseBody
	public List<UtiUserGradeDto> findAllByConditionbyPayFind(@RequestBody Map<String,String> map) throws Exception{
		String comCode = map.get("comCode");
		String userCode = map.get("userCode");
		return utiUserGradeService.queryAllByConditon(comCode, userCode);
	}
}
