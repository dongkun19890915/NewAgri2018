package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxCpEndorChgDetailDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEndorChgDetailDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestEndorseListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 批改清单操作Api
 *
 * @Author: 陈道洋
 * @Date: 2017/11/14 10:30
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = EndorseListApi.PATH)
public interface EndorseListApi {
    String PATH = "endorselist";

    /**
     * 种植险：批改清单持久化接口(农险一期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/14 11:03
     */
    @RequestMapping(value = "savePlantingEndorseList", method = RequestMethod.POST)
    void savePlantingEndorseList(@RequestBody RequestEndorseListDto requestEndorseListDto) throws Exception;

    /**
     * 养殖险：批改清单持久化接口(农险一期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @author: 何伟东
     * @date: 2017/12/8 9:58
     */
    @RequestMapping(value = "saveHerdEndorseList", method = RequestMethod.POST)
    void saveHerdEndorseList(@RequestBody RequestEndorseListDto requestEndorseListDto) throws Exception;


    /**
     * 农业险：批改清单持久化接口(农险二期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @author: 何伟东
     * @date: 2017/12/8 11:55
     */
    @RequestMapping(value = "saveNyxEndorseList", method = RequestMethod.POST)
    void saveNyxEndorseList(@RequestBody RequestEndorseListDto requestEndorseListDto) throws Exception;

    /**
     * 删除批改清单（逻辑删除）
     *
     * @param param endorseNo 批单号码,listType 清单类型（planting-种植险，herd-养殖险，nyx-农业险）
     * @return lineNo 修改的行数
     * @author: 何伟东
     * @date: 2017/12/11 15:37
     */
    @RequestMapping(value = "deleteEndorseList", method = RequestMethod.POST)
    @ResponseBody
    Map<String, Integer> deleteEndorseList(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 取消删除批改清单
     *
     * @param param endorseNo 批单号码,listType 清单类型（planting-种植险，herd-养殖险，nyx-农业险）
     * @return lineNo 修改的行数
     * @author: 何伟东
     * @date: 2017/12/11 15:37
     */
    @RequestMapping(value = "unDeleteEndorseList", method = RequestMethod.POST)
    @ResponseBody
    Map<String, Integer> unDeleteEndorseList(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 根据批单号码查询批改过的农户代码和农户变化保费
     *
     * @param param endorseNo-批单号
     * @return key-农户代码；value-变化的保费
     * @author: 何伟东
     * @date: 2017/12/23 12:08
     */
    @RequestMapping(value = "getCountFarmer", method = RequestMethod.POST)
    @ResponseBody
    Map<String, Double> getFarmerInfo(@RequestBody Map<String, String> param) throws Exception;

    /**
     * 根据批单号码查询批减保费的农户信息(支持分页)
     *
     * @param param endorseNo-批单号码;pageNo-页数;pageSize-每页数量
     * @return List<NyxEndorChgDetailDto> 符合条件的数据
     * @author: 何伟东
     * @date: 2017/12/25 16:01
     */
    @RequestMapping(value = "queryNyxEndorChgDetail", method = RequestMethod.POST)
    @ResponseBody
    PageInfo<NyxEndorChgDetailDto> queryNyxEndorChgDetail(@RequestBody Map<String, Object> param);

    /**
     * 根据批单号码查询批改后的分户清单
     *
     * @param param endorseNo-批单号码
     * @return List<NyxCpEndorChgDetailDto> 符合条件的数据
     * @author: 何伟东
     * @date: 2017/12/25 16:01
     */
    @RequestMapping(value = "queryNyxCpEndorChgDetail", method = RequestMethod.POST)
    @ResponseBody
    List<NyxCpEndorChgDetailDto> queryNyxCpEndorChgDetail(@RequestBody Map<String, String> param);
}
