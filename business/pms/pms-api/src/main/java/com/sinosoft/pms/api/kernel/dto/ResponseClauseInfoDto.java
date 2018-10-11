package com.sinosoft.pms.api.kernel.dto;
import com.sinosoft.framework.dto.BaseRequest;
import java.io.Serializable;
import java.util.List;

/**
 * @description 根据条款代码查询PrpDclauseCode，PrpDclauseCodeCom，PrpDclauseCodeKindDto列表信息
 * @Author: 刘曼曼
 * @Date: 2017/11/7 18:41
 */

public class ResponseClauseInfoDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;

    /*条款配置主表Dto*/
    private PrpDclauseCodeDto prpDclauseCodeDto;
    /*条款机构配置表Dto*/
    private   List<PrpDclauseCodeComDto> prpDclauseCodeComDtoList;
    /*条款险别配置表Dto*/
    private List<PrpDclauseCodeKindDto> prpDclauseCodeKindDtoList;
    /*条款与保险责任关系表*/
    private List<PrpDrelationClauseCodeDto> prpDrelationClauseCodeDtoList;
    /*险别内容*/
    private List<String> kindContextList;
    /*条款表*/
    List<PrpDclauseDto> prpdclauseDtoListClause;
    /*条款表*/
    List<PrpDclauseDto> prpdclauseDtoListKind;
    /*费率分位*/
    private Double calculator;
    /*机构数*/
    private List<CompanyListDto> companyListDtoList;


    public List<CompanyListDto> getCompanyListDtoList() {
        return companyListDtoList;
    }

    public void setCompanyListDtoList(List<CompanyListDto> companyListDtoList) {
        this.companyListDtoList = companyListDtoList;
    }

    public Double getCalculator() {
        return calculator;
    }

    public void setCalculator(Double calculator) {
        this.calculator = calculator;
    }

    public List<String> getKindContextList() {
        return kindContextList;
    }

    public void setKindContextList(List<String> kindContextList) {
        this.kindContextList = kindContextList;
    }

    public List<PrpDclauseDto> getPrpdclauseDtoListClause() {
        return prpdclauseDtoListClause;
    }

    public void setPrpdclauseDtoListClause(List<PrpDclauseDto> prpdclauseDtoListClause) {
        this.prpdclauseDtoListClause = prpdclauseDtoListClause;
    }

    public List<PrpDclauseDto> getPrpdclauseDtoListKind() {
        return prpdclauseDtoListKind;
    }

    public void setPrpdclauseDtoListKind(List<PrpDclauseDto> prpdclauseDtoListKind) {
        this.prpdclauseDtoListKind = prpdclauseDtoListKind;
    }


    public List<PrpDrelationClauseCodeDto> getPrpDrelationClauseCodeDtoList() {
        return prpDrelationClauseCodeDtoList;
    }

    public void setPrpDrelationClauseCodeDtoList(List<PrpDrelationClauseCodeDto> prpDrelationClauseCodeDtoList) {
        this.prpDrelationClauseCodeDtoList = prpDrelationClauseCodeDtoList;
    }

    public PrpDclauseCodeDto getPrpDclauseCodeDto() {
        return prpDclauseCodeDto;
    }

    public void setPrpDclauseCodeDto(PrpDclauseCodeDto prpDclauseCodeDto) {
        this.prpDclauseCodeDto = prpDclauseCodeDto;
    }

    public List<PrpDclauseCodeComDto> getPrpDclauseCodeComDtoList() {
        return prpDclauseCodeComDtoList;
    }

    public void setPrpDclauseCodeComDtoList(List<PrpDclauseCodeComDto> prpDclauseCodeComDtoList) {
        this.prpDclauseCodeComDtoList = prpDclauseCodeComDtoList;
    }

    public List<PrpDclauseCodeKindDto> getPrpDclauseCodeKindDtoList() {
        return prpDclauseCodeKindDtoList;
    }

    public void setPrpDclauseCodeKindDtoList(List<PrpDclauseCodeKindDto> prpDclauseCodeKindDtoList) {
        this.prpDclauseCodeKindDtoList = prpDclauseCodeKindDtoList;
    }

}
