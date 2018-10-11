package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.plantinginsurancelist.EndorseListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxCpEndorChgDetailDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEndorChgDetailDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestEndorseListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.EndorseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 批改清单操作Controller
 *
 * @Author: 陈道洋
 * @Date: 2017/11/14 10:58
 */
@RestController
@RequestMapping(value = EndorseListApi.PATH)
public class EndorseListController implements EndorseListApi {
    @Autowired
    private EndorseListService endorseListService;

    /**
     * 种植险：批改清单持久化接口(农险一期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/14 11:03
     */
    @Override
    public void savePlantingEndorseList(@RequestBody RequestEndorseListDto requestEndorseListDto) throws Exception {
        endorseListService.savePlantingEndorseList(requestEndorseListDto);
    }

    /**
     * 养殖险：批改清单持久化接口(农险一期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @author: 何伟东
     * @date: 2017/12/8 9:58
     */
    @Override
    public void saveHerdEndorseList(@RequestBody RequestEndorseListDto requestEndorseListDto) throws Exception {
        endorseListService.saveHerdEndorseList(requestEndorseListDto);

    }

    /**
     * 农业险：批改清单持久化接口(农险二期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @author: 何伟东
     * @date: 2017/12/8 11:55
     */
    @Override
    public void saveNyxEndorseList(@RequestBody RequestEndorseListDto requestEndorseListDto) throws Exception {
        endorseListService.saveNyxEndorseList(requestEndorseListDto);
    }

    /**
     * 删除批改清单（逻辑删除）
     *
     * @param param endorseNo 批单号码,listType 清单类型（planting-种植险，herd-养殖险，nyx-农业险）
     * @return lineNo 修改的行数
     * @author: 何伟东
     * @date: 2017/12/11 15:37
     */
    @Override
    public @ResponseBody
    Map<String, Integer> deleteEndorseList(@RequestBody Map<String, String> param) throws Exception {
        int lineNo = endorseListService.updateIsDeleteFlag(param.get("endorseNo"), param.get("listType"), true);
        Map<String, Integer> returnMap = new HashMap<>(1);
        returnMap.put("lineNo", lineNo);
        return returnMap;
    }

    /**
     * 取消删除批改清单
     *
     * @param param endorseNo 批单号码,listType 清单类型（planting-种植险，herd-养殖险，nyx-农业险）
     * @return lineNo 修改的行数
     * @author: 何伟东
     * @date: 2017/12/11 15:37
     */
    @Override
    public @ResponseBody
    Map<String, Integer> unDeleteEndorseList(@RequestBody Map<String, String> param) throws Exception {
        int lineNo = endorseListService.updateIsDeleteFlag(param.get("endorseNo"), param.get("listType"), false);
        Map<String, Integer> returnMap = new HashMap<>(1);
        returnMap.put("lineNo", lineNo);
        return returnMap;
    }

    /**
     * 根据批单号码查询批改过的农户代码和农户变化保费
     *
     * @param param column-费用类型字段名，endorseNo-批单号
     * @return key-农户代码；value-变化的保费
     * @author: 何伟东
     * @date: 2017/12/23 12:08
     */
    @Override
    public Map<String, Double> getFarmerInfo(@RequestBody Map<String, String> param) throws Exception {
        return endorseListService.getFarmerInfo(param.get("column"), param.get("endorseNo"), param.get("riskCode"));
    }

    /**
     * 根据批单号码查询批减保费的农户信息(支持分页)
     *
     * @param param endorseNo-批单号码;pageNo-页数;pageSize-每页数量
     * @return List<NyxEndorChgDetailDto> 符合条件的数据
     * @author: 何伟东
     * @date: 2017/12/25 16:01
     */
    @Override
    public @ResponseBody PageInfo<NyxEndorChgDetailDto> queryNyxEndorChgDetail(@RequestBody Map<String, Object> param) {
        return endorseListService.queryNyxEndorChgDetail((String) param.get("endorseNo"), (int) param.get("pageNo"), (int) param.get("pageSize"), true);
    }

    /**
     * 根据批单号码查询批改后的分户清单
     *
     * @param param endorseNo-批单号码
     * @return List<NyxCpEndorChgDetailDto> 符合条件的数据
     * @author: 何伟东
     * @date: 2017/12/25 16:01
     */
    @Override
    public @ResponseBody List<NyxCpEndorChgDetailDto> queryNyxCpEndorChgDetail(@RequestBody Map<String, String> param) {
        return endorseListService.queryNyxCpEndorChgDetail(param.get("endorseNo"));
    }
}
