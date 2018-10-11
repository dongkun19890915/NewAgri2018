package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.HerdEndorChgDetailApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdEndorChgDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-14 07:07:05.012 
 * @description 养殖险保单清单最新数据表controller层
 */
@RestController
@RequestMapping(value = HerdEndorChgDetailController.PATH)
public class HerdEndorChgDetailController implements HerdEndorChgDetailApi {

    private static Logger LOGGER = LoggerFactory.getLogger(HerdEndorChgDetailController.class);

    @Autowired
    private HerdEndorChgDetailService herdEndorChgDetailService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody HerdEndorChgDetailDto herdEndorChgDetailDto) {
        herdEndorChgDetailService.save(herdEndorChgDetailDto);
    }

    /**
     * 按照清单号删除
     *@param inusreListCode 清单号
     *@author 王心洋
     *@time 2017-11-18
     */
    public void removeByInusreListCode(String inusreListCode){
        herdEndorChgDetailService.removeByInusreListCode(inusreListCode);
    }
    /**
     * 按照清单号删除
     *@param inusreListCode 清单号
     *@author 王心洋
     *@time 2017-11-18
     */
    @RequestMapping(value = "getSumInsured",method = {RequestMethod.POST})
    public int getSumInsured(String inusreListCode){
        return herdEndorChgDetailService.getSumInsured(inusreListCode);
    }
    /**
     * 批改保存前删除
     * @param endorseNo 批单号
     * @return void
     * @throws
     * @author 李冬松
     * @date 17:10 2018/4/12
     */
    public void removeByEndorseNo(@RequestParam String endorseNo)throws Exception{
        herdEndorChgDetailService.removeByEndorseNo(endorseNo);
    }

    @Override
    public void saveList(@RequestBody List<HerdEndorChgDetailDto> herdEndorChgDetailDtoList) throws Exception {
        herdEndorChgDetailService.saveList(herdEndorChgDetailDtoList);
    }
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    public @ResponseBody Map<String,List<HerdEndorChgDetailDto>> queryByEndorseNoList(@RequestBody List<String> endorseNoList){
        return herdEndorChgDetailService.queryByEndorseNoList(endorseNoList);
    }

    /**
     * 根据批单号码查询herd的批改变化量清单
     *
     * @param param endorseNo-批单号码
     * @return List<HerdEndorChgDetailDto>
     * @date: 2018/4/13 17:57
     * @author: 何伟东
     */
    @Override
    public @ResponseBody
    List<HerdEndorChgDetailDto> queryByEndorseNo(@RequestBody Map<String, String> param) {
        return herdEndorChgDetailService.queryByEndorseNo(param.get("endorseNo"));
    }
}
