package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.PrpMaxNoApi;
import com.sinosoft.dms.api.dict.dto.PrpMaxNoDto;
import com.sinosoft.dms.core.dict.service.PrpMaxNoService;
import java.lang.Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * @description PrpMaxNocontroller层
 */
@RestController
@RequestMapping(value = PrpMaxNoController.PATH)
public class PrpMaxNoController implements PrpMaxNoApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpMaxNoController.class);

    @Autowired
    private PrpMaxNoService prpMaxNoService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpMaxNoDto prpMaxNoDto) {
        prpMaxNoService.save(prpMaxNoDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("groupNo") String groupNo, @RequestParam("tableName")String tableName,@RequestParam("maxNo") String maxNo) {
        prpMaxNoService.remove(groupNo,tableName,maxNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpMaxNoDto prpMaxNoDto) {
        prpMaxNoService.modify(prpMaxNoDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpMaxNoDto queryByPK(@RequestParam("groupNo") String groupNo, @RequestParam("tableName")String tableName,@RequestParam("maxNo") String maxNo) {
        return prpMaxNoService.queryByPK(groupNo,tableName,maxNo);
    }

    /**
     * （通过分组号，表名 查询最大序号和最小序号和个数）
     * @author: 王志文
     * @date: 2017/12/14 20:06
     * @param groupNo
     * @param tableName
     * @return
     */
    @Override
    public List<Object[]> queryMaxNoByGroupNoAndTableName(String groupNo, String tableName) {
        return prpMaxNoService.queryMaxNoByGroupNoAndTableName(groupNo,tableName);
    }
}
