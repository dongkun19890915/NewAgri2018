package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.GenerateBLEndorseApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GenerateBLEndorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 普通批改数据保存Controller层
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
@RestController
@RequestMapping(value = GenerateBLEndorseController.PATH)
public class GenerateBLEndorseController implements GenerateBLEndorseApi{
    @Autowired
    private GenerateBLEndorseService generateBLEndorseService;
    /**
     * 普通批改数据更新
     * @param policyEndorseDto 保单批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 10:27 2017/12/7
     */
    @Override
    public @ResponseBody PolicyEndorseDto dealEndorseInfo(@RequestBody PolicyEndorseDto policyEndorseDto) throws Exception {
        return generateBLEndorseService.updateBLEndorse(policyEndorseDto);
    }
    /**
     * 普通批改数据保存
     * @param policyEndorseDto 保单批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 10:27 2017/12/7
     */
    @Override
    public @ResponseBody
    Map<String, String> saveEndorseInfo(@RequestBody PolicyEndorseDto policyEndorseDto) throws Exception {
        return generateBLEndorseService.saveEndorse(policyEndorseDto);
    }

    /**
     * 特殊批改数据批量保存
     * @param policyEndorseDtoList 保单批单大对象集合
     * @return batchNo 批次号
     * @throws Exception
     * @author 王心洋
     * @date 2017/12/19
     */
    public @ResponseBody Map<String, Object> saveEndorseList(@RequestBody List<PolicyEndorseDto> policyEndorseDtoList)throws Exception{
        return generateBLEndorseService.saveEndorseList(policyEndorseDtoList);
    }
}
