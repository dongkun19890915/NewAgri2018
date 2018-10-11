package com.sinosoft.agriprpall.core.common.impl;


import com.sinosoft.agriprpall.api.common.dto.RequestParameterDto;
import com.sinosoft.agriprpall.api.common.dto.ResponseParameterDto;
import com.sinosoft.agriprpall.core.common.SelectParameterService;
import com.sinosoft.dms.api.customer.PrpDcustomerApi;
import com.sinosoft.dms.api.customer.dto.RCustomerInfoDto;
import com.sinosoft.dms.api.dict.AreasApi;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.dto.AreasDto;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDagentApi;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDagentDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDitemAgriApi;
import com.sinosoft.pms.api.kernel.PrpDitemApi;
import com.sinosoft.pms.api.kernel.PrpDkindAgriApi;
import com.sinosoft.pms.api.kernel.dto.PrpDitemAgriDto;
import com.sinosoft.pms.api.kernel.dto.PrpDkindAgriDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SelectParameterServiceImpl extends BaseServiceImpl implements SelectParameterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectParameterServiceImpl.class);

    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDagentApi prpDagentApi;
    @Autowired
    private PrpDcustomerApi prpDcustomerApi;
    @Autowired
    private PrpDcurrencyApi prpDcurrencyApi;
    @Autowired
    private AreasApi areasApi;
    @Autowired
    private PrpDitemApi prpDitemApi;
    @Autowired
    private PrpDkindAgriApi prpDkindAgriApi;
    @Autowired
    private PrpDitemAgriApi prpDitemAgriApi;



    /**
     *   双击域公共入口
     * @author: 钱浩
     * @date: 2017/11/27 上午 9:13
     * @param requestParameterDto 参数大对象
     * @return requestParameterDto返参大对象
     * @throws Exception
     */
    @Override
    public ResponseParameterDto queryFindSelect(RequestParameterDto requestParameterDto) throws Exception {
        if (StringUtils.isEmpty(requestParameterDto.getSelectType())){
            throw new DataVerifyException("判断类型不能为空");
        }
        //类型判断
        String selectType=requestParameterDto.getSelectType();
        ResponseParameterDto responseParameterDto=new ResponseParameterDto();
        //归属业务员查询
        if("Handler2Code".equals(selectType)){
            List<PrpDuserDto> prpDuserDtoList=prpDuserApi.queryHandler1CodeInfo(requestParameterDto.getRequestPrpDuserDto());
            responseParameterDto.setPrpDuserDtoList(prpDuserDtoList);
        }
        //归属区域查询
        if("Business".equals(selectType)){
            Map<String,String> map = new HashMap<>();
            map.put("codeType",requestParameterDto.getCodeType());

            map.put("fieldExt",requestParameterDto.getFieldExt());
            Object object=prpDcodeApi.queryAreasProvinceInfo(map);
            responseParameterDto.setObject(object);
        }
        //归属机构代码
        if("ComCode".equals(selectType)){
            List<PrpDcompanyDto> prpDcompanyDtoList=prpDcompanyApi.queryComCodeInfo(requestParameterDto.getQueryComCodeInfoDto());
            responseParameterDto.setPrpDcompanyDtoList(prpDcompanyDtoList);
        }
        //代理人/经纪人信息
        if("AgentCode".equals(selectType)){
            List<PrpDagentDto> prpDagentDtoList=prpDagentApi.queryAgentInfo(requestParameterDto.getAgentReqDto());
            responseParameterDto.setPrpDagentDtoList(prpDagentDtoList);
        }
        //客户查询
        if("InsuredCode1".equals(selectType)){
            PageInfo<RCustomerInfoDto>  rCustomerInfoDtoPageInfo=prpDcustomerApi.queryCustomerInfo(requestParameterDto.getCustomerInfoDto());
            responseParameterDto.setrCustomerInfoDtoPageInfo(rCustomerInfoDtoPageInfo);
        }
        //币别查询
        if("Currency1".equals(selectType)){
            List<PrpDcurrencyDto> prpDcurrencyDtoList=prpDcurrencyApi.queryPrpDcurrencyByCondition(requestParameterDto.getPrpDcurrencyRequestDto());
            responseParameterDto.setPrpDcurrencyDtoList(prpDcurrencyDtoList);
        }
        //承保清单归属区域信息查询
        if("Areas".equals(selectType)){
            List<AreasDto> areasDtoList=areasApi.queryAreasByCondition(requestParameterDto.getAreasParamsDto());
            responseParameterDto.setAreasDtoList(areasDtoList);
        }
        //特约及附加信息查询
//        if("ClauseCode".equals(selectType)){
//           List<PrpDclauseDto> prpDclauseDtoList=prpDclauseApi.queryClauseByRiskCode(requestParameterDto.getRiskCode());
//            List<PrpDclauseDto> prpDclauseDtoList=prpDclauseApi.queryClauseByRiskCode(requestParameterDto.getRiskCode());
//            responseParameterDto.setPrpDclauseDtoList(prpDclauseDtoList);
//        }
        //查询主险附加险别信息
        if("KindCode".equals(selectType)){
            Map<String, String> map = new HashMap<String, String>();
            map.put("riskCode", requestParameterDto.getRiskCode());
            map.put("kindCName", requestParameterDto.getKindCName());//借用reserve1存放险别中文名称
            map.put("codeType", requestParameterDto.getCodeType());
            List<PrpDkindAgriDto> prpDkindDtoList = prpDkindAgriApi.queryKindCodeInfo(map);
            responseParameterDto.setPrpDkindDtoList(prpDkindDtoList);
        }
        //查询主险标的信息
        if("ItemCode0".equals(selectType)){
            List<PrpDitemAgriDto>  prpDitemDtoList= prpDitemAgriApi.queryMainUnderlyingType(requestParameterDto.getPrpDItemRequestParamsDto());
            responseParameterDto.setPrpDitemDtoList0(prpDitemDtoList);
        }
        //查询附加险标的信息
        if("ItemCode1".equals(selectType)){
            List<PrpDitemAgriDto> prpDitemDtoList=prpDitemAgriApi.querySubUnderlyingType(requestParameterDto.getPrpDItemRequestParamsDto());
            responseParameterDto.setPrpDitemDtoList1(prpDitemDtoList);
        }
        return responseParameterDto;
    }
}
