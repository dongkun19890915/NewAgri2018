package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxCpEndorChgDetailDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEndorChgDetailDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestEndorseListDto;

import java.util.List;
import java.util.Map;

/**
 * 批改清单操作Service
 *
 * @Author: 陈道洋
 * @Date: 2017/11/14 11:34
 */
public interface EndorseListService {
    /**
     * 种植险：批改清单持久化接口(农险一期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/14 11:03
     */
    void savePlantingEndorseList(RequestEndorseListDto requestEndorseListDto) throws Exception;

    /**
     * 养殖险：批改清单持久化接口(农险一期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @author: 何伟东
     * @date: 2017/12/8 9:58
     */
    void saveHerdEndorseList(RequestEndorseListDto requestEndorseListDto) throws Exception;

    /**
     * 农业险：批改清单持久化接口(农险二期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @author: 何伟东
     * @date: 2017/12/8 9:58
     */
    void saveNyxEndorseList(RequestEndorseListDto requestEndorseListDto) throws Exception;

    /**
     * 修改批改清单是否删除字段
     *
     * @param endorseNo 批单号码
     * @param listType  清单类型（planting-种植险，herd-养殖险，nyx-农业险）
     * @param isDelete  是否删除true删除false取消删除
     * @return lineNo 修改的行数
     * @author: 何伟东
     * @date: 2017/12/11 15:37
     */
    int updateIsDeleteFlag(String endorseNo, String listType, boolean isDelete) throws Exception;

    /**
     * 根据批单号码查询批改过的农户代码和农户变化保费
     *
     * @param endorseNo 批单号
     * @param column    字段名
     * @return key-农户代码；value-变化的保费
     * @author: 何伟东
     * @date: 2017/12/23 12:08
     */
    Map<String, Double> getFarmerInfo(String column, String endorseNo,String riskCode) throws NoSuchFieldException, Exception;

    /**
     * 根据批单号码查询批减保费的农户信息(支持分页)
     *
     * @param endorseNo  批单号码
     * @param pageNo     页数
     * @param pageSize   每页数量
     * @param pagination 是否分页
     * @return List<NyxEndorChgDetailDto> 符合条件的数据
     * @author: 何伟东
     * @date: 2017/12/25 16:01
     */
    PageInfo<NyxEndorChgDetailDto> queryNyxEndorChgDetail(String endorseNo, int pageNo, int pageSize, boolean pagination);

    /**
     * 根据批单号码查询批改后的分户清单
     *
     * @param endorseNo 批单号码
     * @return List<NyxCpEndorChgDetailDto> 符合条件的数据
     * @author: 何伟东
     * @date: 2017/12/25 16:01
     */
    List<NyxCpEndorChgDetailDto> queryNyxCpEndorChgDetail(String endorseNo);
}
