package com.sinosoft.agriclaim.core.common.impl;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.common.dto.SelectClaimCodeDto;
import com.sinosoft.agriclaim.api.common.dto.SelectClaimListDto;
import com.sinosoft.agriclaim.api.common.dto.SelectClaimRetuenDto;
import com.sinosoft.agriclaim.core.businessutilmanage.utils.UsuallyUseUtils;
import com.sinosoft.agriclaim.core.common.InitSelectClaimService;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 双击域公共封装
 * @Author: 孙朋飞
 * @Date: 2018/1/18 11:30
 */
@Service
public class InitSelectClaimServiceImpl implements InitSelectClaimService {
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    /**
     * codeType为"JobComCode"查询机构树，codeType为"CertaJobCode"查询被维护人，codeType为"AreaCode"查询作业区域
     * codeType为"StaffNameCode"查询人员姓名
     * @author: 孙朋飞
     * @date: 2018/1/18 11:26
     * @param selectClaimListDto 入参dto,codeType-业务类型，riskCode-险种代码，comCode-机构代码，codeCode英文代码，
     *                           codeCName机构代码，userCode用户代码，upperCode上级代码，methodCode查询代码
     * @return SelectClaimRetuenDto 返回dto
     * @throws Exception
     */
    @Override
    public SelectClaimRetuenDto initSelectClaim(SelectClaimListDto selectClaimListDto) throws Exception {
        SelectClaimRetuenDto selectClaimRetuenDto = new SelectClaimRetuenDto();
        if(AgriClaimConstant.AGRI_CLAIM_SERVICE_JOBCOMCODE.equals(selectClaimListDto.getCodeType())){
            PrpDcompanyDto prpDcompanyDto = new PrpDcompanyDto();
            prpDcompanyDto.setComCode(selectClaimListDto.getComCode());
            List<PrpDcompanyDto> prpDcompanyDtoList = prpDcompanyApi.queryPrpDcompanyByComCodePrivate(prpDcompanyDto);
            List<SelectClaimCodeDto> selectClaimCodeList=new ArrayList<>();
            for(int i=0;i<prpDcompanyDtoList.size();i++) {
                SelectClaimCodeDto selectClaimCodeDto = new SelectClaimCodeDto();
                selectClaimCodeDto.setCodeCode(prpDcompanyDtoList.get(i).getComCode());
                selectClaimCodeDto.setCodeName(prpDcompanyDtoList.get(i).getComCName());
                selectClaimCodeDto.setComLevel(prpDcompanyDtoList.get(i).getComLevel());
                selectClaimCodeDto.setUpperComCode(prpDcompanyDtoList.get(i).getUpperComCode());
                selectClaimCodeList.add(selectClaimCodeDto);
            }
            SelectClaimCodeDto selectClaimCodeDto = UsuallyUseUtils.createComCodeTree(selectClaimListDto.getComCode(), selectClaimCodeList);
            selectClaimRetuenDto.getCodeData().add(selectClaimCodeDto);
        }else if(AgriClaimConstant.AGRI_CLAIM_SERVICE_CERTAJOBCODE.equals(selectClaimListDto.getCodeType())){
            List<PrpDuserDto> prpDuserDtoList = prpDuserApi.queryPrpDuserByHandleDept(selectClaimListDto.getComCode(), "1");
            for(int i=0;i<prpDuserDtoList.size();i++){
                SelectClaimCodeDto selectClaimCodeDto = new SelectClaimCodeDto();
                selectClaimCodeDto.setCodeCode(prpDuserDtoList.get(i).getUserCode());
                selectClaimCodeDto.setCodeName(prpDuserDtoList.get(i).getUserName());
                selectClaimRetuenDto.getCodeData().add(selectClaimCodeDto);
            }
        }else if(AgriClaimConstant.AGRI_CLAIM_SERVICE_AREACODE.equals(selectClaimListDto.getCodeType())){
            PrpDcompanyDto prpDcompanyDto = new PrpDcompanyDto();
            prpDcompanyDto.setComCode(selectClaimListDto.getComCode());
            List<PrpDcompanyDto> prpDcompanyDtoList = prpDcompanyApi.queryPrpDcompanyByHandleDept(prpDcompanyDto);
            for(int i=0;i<prpDcompanyDtoList.size();i++) {
                SelectClaimCodeDto selectClaimCodeDto = new SelectClaimCodeDto();
                selectClaimCodeDto.setCodecode(prpDcompanyDtoList.get(i).getComCode());
                selectClaimCodeDto.setCodecname(prpDcompanyDtoList.get(i).getComCName());
                selectClaimRetuenDto.getCodeData().add(selectClaimCodeDto);
            }
        }else if(AgriClaimConstant.AGRI_CLAIM_SERVICE_STAFFNAMECODE.equals(selectClaimListDto.getCodeType())){
            List<PrpDuserDto> prpDuserDtoList = prpDuserApi.queryPrpDuserByHandleDept(selectClaimListDto.getComCode(), "");
            for(int i=0;i<prpDuserDtoList.size();i++){
                SelectClaimCodeDto selectClaimCodeDto = new SelectClaimCodeDto();
                selectClaimCodeDto.setCodeCode(prpDuserDtoList.get(i).getUserCode());
                selectClaimCodeDto.setCodeName(prpDuserDtoList.get(i).getUserName());
                selectClaimRetuenDto.getCodeData().add(selectClaimCodeDto);
            }
        }
        return selectClaimRetuenDto;
    }

    /**
     * 查询报案方法列表的后端
     * @author: 王保良
     * @date: 2018/1/18 11:26
     * @return PrpDcodeDto 返回dto
     * @throws Exception
     */
    @Override
    public List<PrpDcodeDto> queryReportType() throws Exception {

        List<PrpDcodeDto> prpDcodeDtoList=prpDcodeApi.queryReportType();

        return prpDcodeDtoList;
    }
}
