package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.*;

import java.util.List;

/**
 * Settle (P表标志置C表标志处理(里面包含每个小方法的处理))服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
public interface SettleService {
    /**
     * P表标志置C表标志处理(里面包含每个小方法的处理)
     * @param  blEndorseDto 批单大对象
     * @param  responseQueryPolicyInfoDto 保单大对象
     * @return boolean
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public boolean settle(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception;

    /**
     * 根据地址序号查询下标
     * @param  addressNo
     * @param  prpCaddressDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public Integer prpCaddressSearch(Integer addressNo, List<PrpCaddressDto> prpCaddressDtoList) throws Exception;

    /**
     * 根据序号和行号查询下标
     * @param serialNo
     * @param lineNo
     * @param prpCaddressDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public Integer PrpCengageSearch(Integer serialNo, Integer lineNo, List<PrpCengageDto> prpCengageDtoList) throws Exception;

    /**
     * 根据保单号查询下标
     * @param  policyNo
     * @param  prpCexpenseDto
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public Integer PrpCexpenseSearch(String policyNo, PrpCexpenseDto prpCexpenseDto) throws Exception;

    /**
     * 根据币别信息查询下标
     * @param  currency
     * @param  prpCfeeDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public Integer PrpCfeeSearch(String currency, List<PrpCfeeDto> prpCfeeDtoList) throws  Exception;

    /**
     * 根据序号查询下标
     * @param  serialNo
     * @param  prpCinsuredDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public Integer PrpCinsuredSearch(Integer serialNo, List<PrpCinsuredDto> prpCinsuredDtoList) throws  Exception;

    /**
     * 根据标的序号查询下标
     * @param  itemKindNo
     * @param  prpCitemKindDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public Integer PrpCitemKindSearch(Integer itemKindNo, List<PrpCitemKindDto> prpCitemKindDtoList) throws Exception;

    /**
     * 根据付款序号和序号查询下标
     * @param  payNo
     * @param  serialNo
     * @param  prpCplanDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public Integer PrpCplanSearch(Integer payNo, Integer serialNo, List<PrpCplanDto> prpCplanDtoList) throws Exception;

    /**
     * 根据序号和付款原因查询下标
     * @param  serialNo
     * @param  payReason
     * @param  prpCplanCoinsDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public Integer PrpCplanCoinsSearch(Integer serialNo, String payReason, List<PrpCplanCoinsDto> prpCplanCoinsDtoList) throws Exception;

    /**
     * 根据补贴代码和补贴类型查询下标
     * @param  subsidyCode
     * @param  subsidyType
     * @param  prpCsubsidyDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public Integer PrpCsubsidySearch(String subsidyCode, String subsidyType, List<PrpCsubsidyDto> prpCsubsidyDtoList) throws Exception;

    /**
     * 根据田块序号查询下标
     * @param  FeildNo
     * @param  prpCfeildDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public Integer PrpCfeildSearch(String FeildNo, List<PrpCfeildDto> prpCfeildDtoList) throws Exception;





    }
