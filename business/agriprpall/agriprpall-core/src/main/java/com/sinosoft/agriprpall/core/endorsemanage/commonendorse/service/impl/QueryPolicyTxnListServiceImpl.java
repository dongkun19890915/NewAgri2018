package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.QueryPolicyTxnListService;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyQueryService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.gisinsurelist.GisInsureListApi;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureListDto;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.HerdPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.Planting31PolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingPolicyListApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QueryPolicyTxnListServiceImpl extends BaseServiceImpl implements QueryPolicyTxnListService {
    @Autowired
    private PolicyQueryService policyQueryService;
    @Autowired
    private PlantingPolicyListApi plantingPolicyListApi;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private GisInsureListApi gisInsureListApi;
    @Autowired
    private NyxPolicyListApi nyxPolicyListApi;
    @Autowired
    private HerdPolicyListApi herdPolicyListApi;
    @Autowired
    private Planting31PolicyListApi planting31PolicyListApi;
    /**
     * 保单和清单信息查询
     * @param policyNo 保单号
     * @return com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto 保单大对象
     * @throws Exception
     * @author 李冬松
     * @date 16:42 2017/12/22
     */
    @Override
    public ResponseQueryPolicyInfoDto queryPolicyAndTxnListInfo(String policyNo) throws Exception {
        ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto=policyQueryService.queryPolicyInfoByPolicyNo(policyNo,"zh-CN",null,null);
        List<InsureMainListDto> insureMainListDtoList=insureMainListApi.queryByPolicyNo(policyNo);
        String listTypeFlag="";
        String insureListCode="";
        GisInsureMainListDto gisInsureMainListDto=new GisInsureMainListDto();
        /** 获取金禾清单号，添加金禾清单对象 add by 王心洋 20180104 */
        if (insureMainListDtoList!=null && insureMainListDtoList.size()!=0) {
            String gisInsureListCode = "";
            Map<String, String> map = new HashMap<>();
            gisInsureListCode = insureMainListDtoList.get(0).getGisInsureListCode();
            Integer serialNo = insureMainListDtoList.get(0).getSerialNo();

            String serialNo1 = String.valueOf(serialNo);
            Map<String, String> map5 = new HashMap<>();
            map5.put("gisInsureMainListCode", gisInsureListCode);
            map5.put("serialNo", serialNo1);
            map5.get("serialNo");
            gisInsureMainListDto=gisInsureListApi.queryByPk(map5);
            listTypeFlag = gisInsureListApi.queryByPk(map5).getListType();
            //insureListCode = gisInsureListApi.queryByPk(map5).getInsureListCode();
            gisInsureMainListDto.setListTypeFlag(listTypeFlag);
            responseQueryPolicyInfoDto.getGisInsureListDto().setGisInsureMainListDto(gisInsureMainListDto);
        }
        responseQueryPolicyInfoDto.setInsureMainListDtoList(insureMainListDtoList);
        String insureListCode1=insureMainListDtoList.get(0).getInusreListCode();
        responseQueryPolicyInfoDto.setPlantingPolicyListDtoList(plantingPolicyListApi.queryPlantingPolicyListByInsureListCode(insureListCode1));
        responseQueryPolicyInfoDto.setNyxPolicyListDtoList(nyxPolicyListApi.queryByInusreListCode(insureListCode1));
        responseQueryPolicyInfoDto.setHerdPolicyListDtoList(herdPolicyListApi.queryByInusreListCode(insureListCode1));
        responseQueryPolicyInfoDto.setPlanting31PolicyListDtoList(planting31PolicyListApi.queryByInusreListCode(insureListCode1));
        return responseQueryPolicyInfoDto;
    }
}
