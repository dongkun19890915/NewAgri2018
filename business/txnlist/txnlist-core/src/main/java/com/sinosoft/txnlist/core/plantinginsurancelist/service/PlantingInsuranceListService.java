package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingInsuranceListDto;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178 
 * @description 投保明细表Core接口
 */
public interface PlantingInsuranceListService {

    /**
     *@description 新增
     *@param
     */
    void save(PlantingInsuranceListDto plantingInsuranceListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String inusrelistcode, String fcode, String kindcode);
    /**
     *@description 修改
     *@param
     */
    void modify(PlantingInsuranceListDto plantingInsuranceListDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PlantingInsuranceListDto queryByPK(String inusrelistcode, String fcode, String kindcode);

    /**
     * @description:（根据inusreListCode查询PlantingInsuranceList）
     * @author: 田健
     * @date: 2017/10/20 11:53
     * @param inusreListCode
     * @return List<PlantingInsuranceListDto>
     */
    List<PlantingInsuranceListDto> queryByInusreListCode(String inusreListCode);

     /**
     * @description:（批量保存）
     * @author: 田健
     * @date: 2017/10/20 11:53
     * @param plantingInsuranceListDtoList
     */
    public void saveByList(List<PlantingInsuranceListDto> plantingInsuranceListDtoList);

    /**
     * @description:（批量修改）
     * @author: 田健
     * @date: 2017/10/20 11:53
     * @param plantingInsuranceListDtoList
     */
    public void modifyBylist(List<PlantingInsuranceListDto> plantingInsuranceListDtoList);

    /**
     * @description:（根据inusreListcode汇总查询获取投保清单中总户数）
     * @author: 田健
     * @date: 2017/10/20 11:54
     * @param inusreListcode
     * @return int
     */
    public int getSumInsured(String inusreListcode);

    /**
     * @description:（根据inreListcode根据查询各项补贴金额与农户自缴份额）
     * @author: 田健
     * @date: 2017/10/20 11:54
     * @param inusreListcode
     * @return PlantingInsuranceListDto
     */
    public PlantingInsuranceListDto getSumFee(String inusreListcode);

    /**
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:54
     * @param inusreListcode
     */
    void removeByInusreListcode(String inusreListcode);
    /**
     * @description:PlantingInsuranceList分页查询
     * @author: 陈道洋
     * @date: 2017/10/31 11:46
     */
    public  PageInfo<PlantingInsuranceListDto>  queryPlantingInsuranceInfo(String inusreListCode, int pageNo, int pageSize) throws Exception;

    /**
     * @description:根据inusrelistcode查询PlantingInsuranceList表
     * @author: 陈道洋
     * @date: 2017/10/31 16:02
     * @param inusreListCode 清单编号
     * @return  PlantingInsuranceList 表的数据
     * @throws Exception
     */
    public List<PlantingInsuranceListDto> queryPlantingInsuranceListInfo(String inusreListCode) throws Exception;
    /**
     * 根据清单号和农户代查询标的代码
     *
     * @param prarm  policyNo-保单号码
     * @return 承保分户清单数据
     * @author: 陈道洋
     * @date: 2018/02/26 15:34
     */
    @ResponseBody
    PlantingInsuranceListDto queryByInusreListCodeAndFcode(String inusreListCode,String fCode  )throws Exception;

    }