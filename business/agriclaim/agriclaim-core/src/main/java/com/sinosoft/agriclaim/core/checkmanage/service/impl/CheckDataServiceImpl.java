package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import com.sinosoft.agriclaim.api.checkmanage.dto.*;
import com.sinosoft.agriclaim.api.docmanage.dto.*;
import com.sinosoft.agriclaim.api.docmanage.dto.PrplCertifyDirectDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLextDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLext;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLextKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLclaimStatusService;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrplQualityCheckDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrplQualityCheck;
import com.sinosoft.agriclaim.core.checkmanage.service.CheckDataService;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckExtService;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckLossService;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckService;
import com.sinosoft.agriclaim.core.docmanage.dao.PrplCertifyDirectDao;
import com.sinosoft.agriclaim.core.docmanage.entity.PrplCertifyDirect;
import com.sinosoft.agriclaim.core.docmanage.service.PrpLCertifyCollectService;
import com.sinosoft.agriclaim.core.docmanage.service.PrpLCertifyImgService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistExtDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistExt;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistExtService;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistTextService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description: 类功能简述：查勘大对象查询服务类
 * @author chong
 * @date 2017年11月22日上午9:29:19
 */
@Service
public class CheckDataServiceImpl extends BaseServiceImpl implements CheckDataService {
	@Autowired
	private PrpLCertifyCollectService prpLCertifyCollectService;
	@Autowired
	private PrpLCertifyImgService prpLCertifyImgService;
	@Autowired
	private PrpLRegistExtService prpLRegistExtService;
	@Autowired
	private PrpLclaimStatusService prpLclaimStatusService;
	@Autowired
	private PrpLCheckService prpLCheckService;
	@Autowired
	private PrpLRegistTextService prpLRegistTextService;
	@Autowired
	private PrpLCheckExtService prpLCheckExtService;
	@Autowired
	private PrpLCheckLossService prpLCheckLossService;
	@Autowired
	private PrpLextDao prpLextDao;
	@Autowired
	private PrpLRegistExtDao prpLRegistExtDao;
	@Autowired
	private PrplCertifyDirectDao prplCertifyDirectDao;
	@Autowired
	private PrplQualityCheckDao prplQualityCheckDao;
	/**
	 * @description:方法功能简述:根据报案号查询查勘大对象
	 * @author 安齐崇
	 * @date 2017年11月9日下午2:56:35
	 * @param registNo 报案号
	 * @return checkDto 查勘大对象
	 */
	@Override
	public CheckDto findCheckDtoByRegistNo(String checkNo) {
		String registNo = "";
		if (checkNo.length() > 21) {
			registNo = checkNo.substring(0, 21);
		} else {
			registNo = checkNo;
		}
		CheckDto checkDto = new CheckDto();
		/* 查勘主信息 */
		PrpLCheckDto prpLCheckDto = prpLCheckService.queryByPK(checkNo, 1);
		checkDto.setPrpLcheckDto(prpLCheckDto);
		/* 报案文本信息textType1出险摘要2拒赔文字3查勘报告 */
		List<PrpLRegistTextDto> registTextDtoList = prpLRegistTextService.queryByRegistNoAndTextType(registNo, "3");
		checkDto.setPrpLregistTextDtoList(registTextDtoList);
		/* 查勘扩展信息 */
		List<PrpLCheckExtDto> checkExtDtoList = prpLCheckExtService.queryByRegistNo(registNo);
		checkDto.setPrpLCheckExtDtoList(checkExtDtoList);
		/* 事故估损金额信息 */
		List<PrpLCheckLossDto> checkLossDtoList = prpLCheckLossService.queryByRegistNo(registNo);
		checkDto.setPrpLCheckLossDtoList(checkLossDtoList);
		/* 报案状态信息 */
		PrpLclaimStatusDto claimStatusDto = prpLclaimStatusService.queryByPK(registNo, "check", 0);
		checkDto.setPrpLclaimStatusDto(claimStatusDto);
		/* 报案扩展信息 */
		List<PrpLRegistExtDto> prpLRegistExtDtoList = prpLRegistExtService.queryByRegistNo(registNo);
		checkDto.setPrpLRegistExtDtoList(prpLRegistExtDtoList);

		PrpLext prpLext = prpLextDao.findOne(new PrpLextKey(registNo, "2"));
		checkDto.setPrpLextDto(this.convert(prpLext, PrpLextDto.class));
		return checkDto;
	}
	/**
     * @description:方法功能简述: 单证相关大对象
     * @author 安齐崇
     * @date 2017年11月9日下午2:56:35
     * @param registNo 报案号
     * @return certifyDto 单证相关大对象
    */
	@Override
	public CertifyDto findCertifyDtoByRegistNo(String registNo) {
		CertifyDto certifyDto = new CertifyDto();
		/*单证收集表信息,lossItemCode默认设为1*/
		PrpLCertifyCollectDto collectDto = prpLCertifyCollectService.queryByPK(registNo, "1");
		certifyDto.setPrpLcertifyCollectDtoExt(this.convert(collectDto, PrpLcertifyCollectDtoExt.class));
        /*单证及影像表信息*/
		List<PrpLCertifyImgDto> certifyImgDtoList = prpLCertifyImgService.queryByConditionAndOrder(registNo, "1");
		certifyDto.setPrpLcertifyImgDtoList(certifyImgDtoList);
		/*理赔节点状态表信息*/
		PrpLclaimStatusDto claimStatusDto = prpLclaimStatusService.queryByPK(registNo, "certi", 0);
		certifyDto.setPrpLclaimStatusDto(claimStatusDto);
		/*报案信息补充说明*/
		Specification<PrpLRegistExt> specification = Specifications.<PrpLRegistExt> and().eq("registNo", registNo)
				.build();
		List<PrpLRegistExt> prpLRegistExtList = prpLRegistExtDao.findAll(specification);
		List<PrpLRegistExtDto> prpLRegistExtDtoList = new ArrayList<PrpLRegistExtDto>();
		this.convertCollection(prpLRegistExtList, prpLRegistExtDtoList, PrpLRegistExtDto.class);
		certifyDto.setPrpLregistExtDtoList(prpLRegistExtDtoList);
		/** 索赔指引表查询:自定义的单证类型和非自定义的单证类型排序字段不同,非自定义的单证类型按typecode排序 */
		List<PrplCertifyDirect> noneDefineCertifyDirectList = prplCertifyDirectDao.findNoneDefine(registNo);
		List<PrplCertifyDirect> defineCertifyDirectList = prplCertifyDirectDao.findDefine(registNo);
		noneDefineCertifyDirectList.addAll(defineCertifyDirectList);
		List<PrplCertifyDirectDto> certifyDirectDtoList = new ArrayList<PrplCertifyDirectDto>();
		this.convertCollection(noneDefineCertifyDirectList, certifyDirectDtoList, PrplCertifyDirectDto.class);
		certifyDto.setPrpLcertifyDirectDtoList(certifyDirectDtoList);
		Specification<PrplQualityCheck> specification1 = Specifications.<PrplQualityCheck> and()
				.eq("registNo", registNo).eq("qualityCheckType", "certi").build();
		/*质量评审内容表查询*/
		List<PrplQualityCheck> qualityCheckList = prplQualityCheckDao.findAll(specification1);
		List<PrplQualityCheckDto> qualityCheckDtoList = new ArrayList<PrplQualityCheckDto>();
		this.convertCollection(qualityCheckList, qualityCheckDtoList, PrplQualityCheckDto.class);
		certifyDto.setPrpLqualityCheckDtoList(qualityCheckDtoList);
		return certifyDto;
	}

}
