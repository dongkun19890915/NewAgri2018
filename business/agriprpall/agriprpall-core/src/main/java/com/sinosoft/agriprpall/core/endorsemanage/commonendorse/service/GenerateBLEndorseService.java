package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * 普通批改数据保存service接口类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
public interface GenerateBLEndorseService {
    /**
     * 普通批改数据更新
     * @param policyEndorseDto 保单批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 10:27 2017/12/7
     */
    public PolicyEndorseDto updateBLEndorse(PolicyEndorseDto policyEndorseDto) throws Exception;
    /**
     * 普通批改数据保存
     * @param policyEndorseDto 保单批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 10:27 2017/12/7
     */
    public Map<String, String> saveEndorse(PolicyEndorseDto policyEndorseDto) throws Exception;

    /**
     * 普通批改数据保存
     * @param policyEndorseDtoList 保单批单大对象集合
     * @return void
     * @throws Exception
     * @author 王心洋
     * @date 2017/12/19
     */
    public Map<String, Object> saveEndorseList(List<PolicyEndorseDto> policyEndorseDtoList)throws Exception;
}
