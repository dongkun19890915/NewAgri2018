package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.DeleteEndorseApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.DeleteEndorseRequestDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.DeleteEndorseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = DeleteEndorseController.PATH)
public class DeleteEndorseController implements DeleteEndorseApi{

    private static Logger LOGGER = LoggerFactory.getLogger(DeleteEndorseController.class);
    @Autowired
    private DeleteEndorseService deleteEndorseService;
    /**
     * 批单批量删除（先校验批单号，然后再删除相关的表的数据）
     * @author: 宋振振
     * @date: 2017/11/24 15:16
     * @param deleteEndorseRequestDto 批单批量删除请求的Dto
     * @return HashMap 返回删除成功或失败的信息
     * @throws Exception
     */
    public @ResponseBody HashMap deleteEndorse(@RequestBody DeleteEndorseRequestDto deleteEndorseRequestDto) throws Exception{
        return deleteEndorseService.deleteEndorse(deleteEndorseRequestDto);
    }
    /**
     * 批单批量删除校验（用查询批单列表的逻辑校验）
     * @author: 宋振振
     * @date: 2017/11/24 15:19
     * @param deleteEndorseRequestDto 批单批量删除请求的Dto
     * @return HashMap 批单号集合
     * @throws Exception
     */
    public @ResponseBody HashMap getEndorseNoMap(@RequestBody DeleteEndorseRequestDto deleteEndorseRequestDto) throws Exception{
        return deleteEndorseService.getEndorseNoMap(deleteEndorseRequestDto);
    }
}
