package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiGradeApi;
import com.sinosoft.ims.api.auth.dto.UtiGradeDto;
import com.sinosoft.ims.core.auth.service.UtiGradeService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description UtiGradecontroller层
 */
@RestController
@RequestMapping(value = UtiGradeController.PATH)
public class UtiGradeController implements UtiGradeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiGradeController.class);

    @Autowired
    private UtiGradeService utiGradeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiGradeDto utiGradeDto) {
        utiGradeService.save(utiGradeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String gradeCode) {
        utiGradeService.remove(gradeCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiGradeDto utiGradeDto) {
        utiGradeService.modify(utiGradeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiGradeDto queryByPK(@RequestBody String gradeCode) {
        return utiGradeService.queryByPK(gradeCode);
    }
}
