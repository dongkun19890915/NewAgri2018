package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.customer.PrpDcustomerApi;
import com.sinosoft.dms.api.customer.PrpDcustomerIdvApi;
import com.sinosoft.dms.api.customer.PrpDcustomerUnitApi;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerDto;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerIdvDto;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.dms.api.model.PrpModelCustomerTaxPayInfoSubApi;
import com.sinosoft.dms.api.model.dto.*;
import com.sinosoft.dms.core.model.dao.*;
import com.sinosoft.dms.core.model.entity.*;
import com.sinosoft.dms.core.model.service.*;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.QueryComCodeInfoDto;
import com.sinosoft.pms.api.kernel.PrpDitemApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.PrpdclassApi;
import com.sinosoft.pms.api.kernel.dto.CompanyListDto;
import com.sinosoft.pms.api.kernel.dto.PrpDclassDto;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.txnlist.api.gisinsurelist.GisInsureListApi;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:35:35.009 
 * @description 模板配置主表Core接口实现
 */
@Service
public class PrpMmodelMainServiceImpl extends BaseCustomServiceImpl implements PrpMmodelMainService {
    /**
     * log日志
     */

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpMmodelMainServiceImpl.class);

    @Autowired
    private PrpMmodelMainDao prpMmodelMainDao;
    @Autowired
    private PrpMmodelComDao prpMmodelComDao;
    @Autowired
    private PrpModelAddressSubDao prpModelAddressSubDao;
    @Autowired
    private PrpModelCoinsSubDao prpModelCoinsSubDao;
    @Autowired
    private PrpModelCustomerTaxPayInfoSubService prpModelCustomerTaxPayInfoSubService;
    @Autowired
    private PrpModelEngageSubDao prpModelEngageSubDao;
    @Autowired
    private PrpModelInsuredSubDao prpModelInsuredSubDao;
    @Autowired
    private PrpModelMainAgriSubDao prpModelMainAgriSubDao;
    @Autowired
    private PrpModelMainAgriSubService prpModelMainAgriSubService;
    @Autowired
    private PrpModelMainSubDao prpModelMainSubDao;
    @Autowired
    private PrpModelMainSubService prpModelMainSubService;
    @Autowired
    private PrpModelItemKindAgriDao prpModelItemKindAgriDao;
    @Autowired
    private PrpModelItemKindDao prpModelItemKindDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDitemApi prpDitemApi;
    @Autowired
    private PrpModelCoinsDetailDao prpModelCoinsDetailDao;
    @Autowired
    private PrpModelFeeSubDao prpModelFeeSubDao;
    @Autowired
    private PrpModelPlanCoinsDao prpModelPlanCoinsDao;
    @Autowired
    private PrpModelPlanSubDao prpModelPlanSubDao;
    @Autowired
    private PrpModelSubsidyDao prpModelSubsidyDao;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    private PrpDcustomerApi prpDcustomerApi;
    @Autowired
    private PrpDcustomerIdvApi prpDcustomerIdvApi;
    @Autowired
    private PrpDcustomerUnitApi prpDcustomerUnitApi;
    @Autowired
    private PrpModelCustomerTaxPayInfoSubApi prpModelCustomerTaxPayInfoSubApi;
    @Autowired
    private PrpdclassApi prpdclassApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private GisInsureListApi gisInsureListApi;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private  PrpModelCustomerTaxPayInfoSubDao prpModelCustomerTaxPayInfoSubDao;
    /**
     * @param
     * @description 新增
     */
    @Override
    public void save(PrpMmodelMainDto prpMmodelMainDto) {
        PrpMmodelMain prpMmodelMain = this.convert(prpMmodelMainDto, PrpMmodelMain.class);
        prpMmodelMainDao.save(prpMmodelMain);
    }

    /**
     *  获取客户号
     * @author: 田慧
     * @date: 2018/1/23 15:34
     * @param prpMmodelMainInfoDto 模板保存大对象
     * @return  客户代码
     * @throws Exception
     */
    private String getCustomerCode(PrpMmodelMainInfoDto prpMmodelMainInfoDto) throws Exception{
        String makeCom=prpMmodelMainInfoDto.getPrpModelMainSubDto().getMakeCom();
        String customerType=prpMmodelMainInfoDto.getAppliInsuredDto().getInsuredType();
        Map<String,String> map= new HashMap<>();
        map.put("iCustomerType",customerType);
        map.put("iMakeCom",makeCom);
        //生成客户号
        String customerCode=billNoApi.apply(map);
        return customerCode;

    }

    /**
     *  保存客户信息及发票信息
     * @author: 田慧
     * @date: 2018/1/23 16:08
     * @param prpMmodelMainInfoDto 模板保存大对象
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void SaveCustomerInfo(PrpMmodelMainInfoDto prpMmodelMainInfoDto) throws Exception{
        //获取客户代码(投保人的)
        String appliCustomerCode=prpMmodelMainInfoDto.getAppliInsuredDto().getInsuredCode();
        //获取客户代码(被保险人的)
        String insureCustomerCode=prpMmodelMainInfoDto.getInsuredDto().getInsuredCode();


    PrpModelInsuredSubDto appliInsuredDto = prpMmodelMainInfoDto.getAppliInsuredDto();
    PrpModelInsuredSubDto insuredDto = prpMmodelMainInfoDto.getInsuredDto();

        //发票信息  发票信息中就不用保存金禾的客户代码了
        PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto = new PrpModelCustomerTaxPayInfoSubDto();
        prpModelCustomerTaxPayInfoSubDto = prpMmodelMainInfoDto.getPrpModelCustomerTaxPayInfoSubDto();
        String customerCode1 = "";
        String InsuredType = "";
        if(prpModelCustomerTaxPayInfoSubDto!= null){
            if("1".equals(prpModelCustomerTaxPayInfoSubDto.getPayInfoObject())){
                //投保人类型
                InsuredType = appliInsuredDto.getInsuredType();//投保人客户类型
                customerCode1 = appliCustomerCode;//投保人客户代码
            }else{
                //被保险人类型
                InsuredType = insuredDto.getInsuredType();//被保人客户类型
                customerCode1 = insureCustomerCode;//被保人客户代码
            }
            prpModelCustomerTaxPayInfoSubDto.setCustomerCode(customerCode1);
            prpModelCustomerTaxPayInfoSubDto.setCustomerType(InsuredType);
        }else{
            throw new BusinessException("发票购货方信息为空!");
        }
//
        //保存发票信息systemflag
         prpModelCustomerTaxPayInfoSubApi.save(prpModelCustomerTaxPayInfoSubDto);
    }



    /**
     * 保存模板信息
     * @author: 田慧
     * @date: 2017/11/11 15:51
     * @param prpMmodelMainInfoDto 模板配置主表Dto、模板机构配置表Dto、模板保险地址表Dto、模板共保信息表Dto、模板客户纳税人信息表Dto、
     *         模板特别约定表Dto、模板保险关系人表Dto、 模板农业险保单信息Dto、保单基本信息表Dto、模板农险标的附加表Dto、标的子险信息Dto
     * @return   成功success
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String,String> saveButton(PrpMmodelMainInfoDto prpMmodelMainInfoDto)throws Exception {
        //模板配置主表Dto
        PrpMmodelMainDto prpMmodelMainDto = prpMmodelMainInfoDto.getPrpMmodelMainDto();
        //模板机构配置表Dto
        List<PrpMmodelComDto> prpMmodelComDtoList = prpMmodelMainInfoDto.getPrpMmodelComDtoList();
        //模板保险地址表Dto
        PrpModelAddressSubDto prpModelAddressSubDto = prpMmodelMainInfoDto.getPrpModelAddressSubDto();
        //模板共保信息表Dto
        List<PrpModelCoinsSubDto> prpModelCoinsSubDtoList = prpMmodelMainInfoDto.getPrpModelCoinsSubDtoList();
        //模板客户纳税人信息表Dto
        PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto = prpMmodelMainInfoDto.getPrpModelCustomerTaxPayInfoSubDto();
        //模板特别约定表Dto
        List<PrpModelEngageSubDto> prpModelEngageSubDtoList = prpMmodelMainInfoDto.getPrpModelEngageSubDtoList();
        //模板保险关系人表Dto(投保人)
        PrpModelInsuredSubDto appliInsuredDto=prpMmodelMainInfoDto.getAppliInsuredDto();
        //模板保险关系人表Dto(投保人)
        PrpModelInsuredSubDto insuredDto=prpMmodelMainInfoDto.getInsuredDto();
        //模板农业险保单信息Dto
        PrpModelMainAgriSubDto prpModelMainAgriSubDto = prpMmodelMainInfoDto.getPrpModelMainAgriSubDto();
        //保单基本信息表Dto
        PrpModelMainSubDto prpModelMainSubDto = prpMmodelMainInfoDto.getPrpModelMainSubDto();

        //模板农险标的附加表Dto
        List<PrpModelItemKindAgriDto> prpModelItemKindAgriDtoList = prpMmodelMainInfoDto.getPrpModelItemKindAgriDtoList();
        //标的子险信息Dto
        List<PrpModelItemKindDto> prpModelItemKindDtoList = prpMmodelMainInfoDto.getPrpModelItemKindDtoList();

        //共保细节表
        List<PrpModelCoinsDetailDto> prpModelCoinsDetailDtoList = prpMmodelMainInfoDto.getPrpModelCoinsDetailDtoList();
        //保单保额保费表
        PrpModelFeeSubDto prpModelFeeSubDto = prpMmodelMainInfoDto.getPrpModelFeeSubDto();
        //共保方收费信息表
        List<PrpModelPlanCoinsDto> prpModelPlanCoinsDtoList = prpMmodelMainInfoDto.getPrpModelPlanCoinsDtoList();
        //收费计划表
        List<PrpModelPlanSubDto> prpModelPlanSubDtoList = prpMmodelMainInfoDto.getPrpModelPlanSubDtoList();
        //补贴信息表
        List<PrpModelSubsidyDto> prpModelSubsidyDtoList = prpMmodelMainInfoDto.getPrpModelSubsidyDtoList();
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//        String Date = format1.format(new Date());
//        java.util.Date createDate = format1.parse(Date);
//        prpMmodelMainDto.setCreateDate(createDate);


        /**将客户号放入业务表prpmodelinsuredsub 通过insureCode判断投保人和被保险人是不是同一个人
         * 如果是同一个人,则只要生成一个customerCode并保存到投保人和被投保人中,如果不是同一个人
         * ,则生成两个customerCode分别放入到投保人和被投保人信息中*/
        /** 获取清单类型 判断是散户还是大户 D是大户,S是散户*/
        String customerType = prpMmodelMainInfoDto.getAppliInsuredDto().getInsuredType();
        //初始化客户代码
        String customerCode;
        /** 如果是散户 (投保人和被投保人是同一个人) */
        if ("3".equals(customerType)) {
            /** 获取客户名  */
            String insureName = appliInsuredDto.getInsuredName();
            Map<String, String> map1 = new HashMap<>();
            map1.put("insureName", insureName);
            //是散户的情况下 用用户名去查询是否已经有相关的数据了
            List<PrpDcustomerDto> prpDcustomerDtoList = prpDcustomerApi.queryPrpDcustomerByInsureName(map1);
            //如果已经有相关的数据了
            if (prpDcustomerDtoList != null && prpDcustomerDtoList.size()>0) {
                customerCode = prpDcustomerDtoList.get(0).getCustomerCode();
                prpMmodelMainInfoDto.getAppliInsuredDto().setInsuredCode(customerCode);
                prpMmodelMainInfoDto.getInsuredDto().setInsuredCode(customerCode);
            }
            //如果没有查到以前的相关数据 则生成新的customerCode
            else {
                customerCode = this.getCustomerCode(prpMmodelMainInfoDto);
                prpMmodelMainInfoDto.getAppliInsuredDto().setInsuredCode(customerCode);
                prpMmodelMainInfoDto.getInsuredDto().setInsuredCode(customerCode);
            }
        }
        /** 如果是大户 则投保人和被投保人可能出现不是同一个人的情况 */
        else if ("1".equals(customerType) || "2".equals(customerType)) {
            /** 如果是大户 则投保人和被投保人可能出现不是同一个人的情况 根据insureCode判断他们是否是同一个人 */
            //这是同一个人的情况下
            if (appliInsuredDto.getInsuredCode().equals(insuredDto.getInsuredCode())) {
                //如果是同一个人 ,先去判断这个大户在基础表中是不是已经存在了
                Map<String, String> appliMap = new HashMap<>();
                appliMap.put("identifyType", appliInsuredDto.getIdentifyType());
                appliMap.put("identifyNumber", appliInsuredDto.getIdentifyNumber());
                List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList = prpDcustomerIdvApi.queryPrpDcustomerByIndentity(appliMap);
                //如果已经存在了 则直接用老的客户代码放入即可
                if (prpDcustomerIdvDtoList!=null && prpDcustomerIdvDtoList.size()>0) {
                    customerCode = prpDcustomerIdvDtoList.get(0).getCustomerCode();
                    prpMmodelMainInfoDto.getAppliInsuredDto().setInsuredCode(customerCode);
                    prpMmodelMainInfoDto.getInsuredDto().setInsuredCode(customerCode);
                } else {
                    //如果不存在,则用新生成的客户代码
                    /** 获取新生成的客户代码 */
                    customerCode = this.getCustomerCode(prpMmodelMainInfoDto);
                    prpMmodelMainInfoDto.getAppliInsuredDto().setInsuredCode(customerCode);
                    prpMmodelMainInfoDto.getInsuredDto().setInsuredCode(customerCode);
                }
            }
            /** 如果他们不是同一个人 */
            else {
                //先处理投保人的 去查询是不是已经有投保人的相关信息了(根据证件类型和证件号码去匹配)
                Map<String, String> appliMap = new HashMap<>();
                appliMap.put("identifyType", appliInsuredDto.getIdentifyType());
                appliMap.put("identifyNumber", appliInsuredDto.getIdentifyNumber());
                List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList = prpDcustomerIdvApi.queryPrpDcustomerByIndentity(appliMap);
                //如果已经有相关的了 则直接用老的customerCode
                if (prpDcustomerIdvDtoList!=null && prpDcustomerIdvDtoList.size()>0) {
                    customerCode = prpDcustomerIdvDtoList.get(0).getCustomerCode();
                    appliInsuredDto.setInsuredCode(customerCode);
                } else {
                    //如果不存在,则用新生成的客户代码
                    /**获取客户号*/
                    customerCode = this.getCustomerCode(prpMmodelMainInfoDto);
                    appliInsuredDto.setInsuredCode(customerCode);
                }
                //此处处理被保险人的
                Map<String, String> insureMap = new HashMap<>();
                insureMap.put("identifyType", insuredDto.getIdentifyType());
                insureMap.put("identifyNumber", insuredDto.getIdentifyNumber());
                List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList1 = prpDcustomerIdvApi.queryPrpDcustomerByIndentity(insureMap);
                //如果已经有了相关的信息 则就用老的customerCode
                if (prpDcustomerIdvDtoList1 != null && prpDcustomerIdvDtoList1.size()>0) {
                    customerCode = prpDcustomerIdvDtoList1.get(0).getCustomerCode();
                    insuredDto.setInsuredCode(customerCode);
                } else {
                    //再生成被保险人的客户代码,再放入被保险人的信息中
                    customerCode = this.getCustomerCode(prpMmodelMainInfoDto);
                    insuredDto.setInsuredCode(customerCode);
                }
            }
        }





        //将模板配置主表Dto转成模板配置主表实体
        PrpMmodelMain prpMmodelMain = this.convert(prpMmodelMainDto, PrpMmodelMain.class);
        //模板机构配置表Dto转成模板机构配置表实体
        List<PrpMmodelCom> prpMmodelComList1 = new ArrayList<>();
        this.convertCollection(prpMmodelComDtoList,prpMmodelComList1,PrpMmodelCom.class);
        //模板保险地址表Dto转成模板保险地址表实体
        PrpModelAddressSub prpModelAddressSub = this.convert(prpModelAddressSubDto, PrpModelAddressSub.class);
        //模板共保信息表Dto转成模板共保信息表实体
//        PrpModelCoinsSub prpModelCoinsSub = this.convert(prpModelCoinsSubDto,PrpModelCoinsSub.class);
//        PrpModelEngageSub prpModelEngageSub = this.convert(prpModelEngageSubDto,PrpModelEngageSub.class);
        List<PrpModelCoinsSub> prpModelCoinsSubList = new ArrayList<>();
        this.convertCollection(prpModelCoinsSubDtoList, prpModelCoinsSubList, PrpModelCoinsSub.class);
//        //模板客户纳税人信息表Dto模板客户纳税人信息表实体
//        PrpModelCustomerTaxPayInfoSub prpModelCustomerTaxPayInfoSub = this.convert(prpModelCustomerTaxPayInfoSubDto, PrpModelCustomerTaxPayInfoSub.class);
        //模板特别约定表Dto转成模板特别约定表实体
        List<PrpModelEngageSub> prpModelEngageSubList = new ArrayList<>();
        this.convertCollection(prpModelEngageSubDtoList, prpModelEngageSubList, PrpModelEngageSub.class);
        //模板保险关系人表Dto模板保险关系人表实体
        PrpModelInsuredSub appliInsured=this.convert(appliInsuredDto,PrpModelInsuredSub.class);
        //模板保险人关系人表被保险人表
        PrpModelInsuredSub insured=this.convert(insuredDto,PrpModelInsuredSub.class);
        //模板农业险保单信息Dto转成模板农业险保单信息实体
        PrpModelMainAgriSub prpModelMainAgriSub = convert(prpModelMainAgriSubDto, PrpModelMainAgriSub.class);
        //保单基本信息表Dto转成保单基本信息表实体
        PrpModelMainSub prpModelMainSub = this.convert(prpModelMainSubDto, PrpModelMainSub.class);
        //模板农险标的附加表Dto转成模板农险标的附加表实体
//        PrpModelItemKindAgri prpModelItemKindAgri =this.convert(prpModelItemKindAgriDto,PrpModelItemKindAgri.class);
        List<PrpModelItemKindAgri> prpModelItemKindAgriList = new ArrayList<>(prpModelItemKindAgriDtoList.size());
        this.convertCollection(prpModelItemKindAgriDtoList, prpModelItemKindAgriList, PrpModelItemKindAgri.class);
//        PrpModelItemKind prpModelItemKind = this.convert(prpModelItemKindDto,PrpModelItemKind.class);
        List<PrpModelItemKind> prpModelItemKindList = new ArrayList<>(prpModelItemKindDtoList.size());
        this.convertCollection(prpModelItemKindDtoList, prpModelItemKindList, PrpModelItemKind.class);
        //共保信息表Dto转化为Entity
        List<PrpModelCoinsDetail> prpModelCoinsDetailList = new ArrayList<>();
        convertCollection(prpModelCoinsDetailDtoList, prpModelCoinsDetailList, PrpModelCoinsDetail.class);
        //保单保额保费表Dto转化为Entity
        PrpModelFeeSub prpModelFeeSub = convert(prpModelFeeSubDto, PrpModelFeeSub.class);
        //共保方收费信息表Dto转化为Entity
        List<PrpModelPlanCoins> prpModelPlanCoinsList = new ArrayList<>();
        convertCollection(prpModelPlanCoinsDtoList, prpModelPlanCoinsList, PrpModelPlanCoins.class);
        //收费计划表Dto转化为Entity
        List<PrpModelPlanSub> prpModelPlanSubList = new ArrayList<>();
        convertCollection(prpModelPlanSubDtoList, prpModelPlanSubList, PrpModelPlanSub.class);
        //补贴信息表Dto转化为Entity
        List<PrpModelSubsidy> prpModelSubsidyList = new ArrayList<>();
        convertCollection(prpModelSubsidyDtoList, prpModelSubsidyList, PrpModelSubsidy.class);
        Date date1 =new Date();
        System.out.println(date1.getTime()+"=====start");
            //现将查到的数据删除
        String modelCode = prpMmodelMainInfoDto.getPrpMmodelMainDto().getModelCode();
        //删除补贴信息表信息
        List<PrpModelSubsidy> prpModelSubsidyDeleList = prpModelSubsidyDao.queryByModelCode(modelCode);
        if (prpModelSubsidyDeleList.size()>0){
            prpModelSubsidyDao.delete(prpModelSubsidyDeleList);
        }
        //删除收费计划表信息
        List<PrpModelPlanSub> prpModelPlanSubDeleList = prpModelPlanSubDao.queryByModelCode(modelCode);
        if (prpModelPlanSubDeleList.size()>0){
            prpModelPlanSubDao.delete(prpModelPlanSubDeleList);
        }
        //删除共保方收费信息表信息
        List<PrpModelPlanCoins> prpModelPlanCoinsDeleList = prpModelPlanCoinsDao.queryByModelCode(modelCode);
        if (prpModelPlanCoinsDeleList.size()>0){
            prpModelPlanCoinsDao.delete(prpModelPlanCoinsDeleList);
        }
        //删除保额保费表信息
        List<PrpModelFeeSub> prpModelFeeSubDeleList = prpModelFeeSubDao.queryByModelCode(modelCode);
        if (prpModelFeeSubDeleList.size()>0){
            prpModelFeeSubDao.delete(prpModelFeeSubDeleList);
        }

        //删除共保细节表信息
        List<PrpModelCoinsDetail> prpModelCoinsDetailDeleList = prpModelCoinsDetailDao.queryByModelCode(modelCode);
        if (prpModelCoinsDetailDeleList.size()>0){
            prpModelCoinsDetailDao.delete(prpModelCoinsDetailDeleList);
        }
        //删除模板农险标的附加表信息
        List<PrpModelItemKindAgri> prpModelItemKindAgriDeleList = prpModelItemKindAgriDao.findByModelCode(modelCode);
        if (prpModelItemKindAgriDeleList.size()>0){
            prpModelItemKindAgriDao.delete(prpModelItemKindAgriDeleList);
        }

        //删除标的子险信息表信息
        List<PrpModelItemKind> prpModelItemKindDeleList= prpModelItemKindDao.findByModelCode(modelCode);
        if (prpModelItemKindDeleList.size()>0){
            prpModelItemKindDao.delete(prpModelItemKindDeleList);
        }
        //删除模板农业险保单信息
        PrpModelMainAgriSubDto prpModelMainAgriSubDtoDele = prpModelMainAgriSubService.queryByPK(modelCode);
        if (prpModelMainAgriSubDtoDele!=null){
            PrpModelMainAgriSub prpModelMainAgriSubDele = this.convert(prpModelMainAgriSubDtoDele,PrpModelMainAgriSub.class);
            prpModelMainAgriSubDao.delete(prpModelMainAgriSubDele);
        }
        //删除保单基本信息表信息
        PrpModelMainSubDto prpModelMainSubDtoDele = prpModelMainSubService.queryByPK(modelCode);
        if (prpModelMainSubDtoDele!=null){
            PrpModelMainSub prpModelMainSubDele = this.convert(prpModelMainSubDtoDele,PrpModelMainSub.class);
            prpModelMainSubDao.delete(prpModelMainSubDele);
        }
        //删除客户纳税人信息表信息
        PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDtoDele = prpModelCustomerTaxPayInfoSubService.queryByPK(modelCode);
        if (prpModelCustomerTaxPayInfoSubDtoDele != null){
            PrpModelCustomerTaxPayInfoSub prpModelCustomerTaxPayInfoSubDele = this.convert(prpModelCustomerTaxPayInfoSubDtoDele,PrpModelCustomerTaxPayInfoSub.class);
            prpModelCustomerTaxPayInfoSubDao.delete(prpModelCustomerTaxPayInfoSubDele);
        }
        //删除模板保险关系人表信息
        List<PrpModelInsuredSub> prpModelInsuredSubDeleList = prpModelInsuredSubDao.findByModelCode(modelCode);
        if (prpModelInsuredSubDeleList.size()>0){
            prpModelInsuredSubDao.delete(prpModelInsuredSubDeleList);
        }
        // 删除特别约定信息
        List<PrpModelEngageSub> prpModelEngageSubDeleteList = prpModelEngageSubDao.findByModelCode(modelCode);
        if (prpModelEngageSubDeleteList.size()>0){
            prpModelEngageSubDao.delete(prpModelEngageSubDeleteList);
        }
        //删除模板共保信息表
        List<PrpModelCoinsSub> prpModelCoinsSubList1 = prpModelCoinsSubDao.findByModelCode(modelCode);
        if (prpModelCoinsSubList1.size()>0){
            prpModelCoinsSubDao.delete(prpModelCoinsSubList1);
        }
        //删除模板保险地址表
        List<PrpModelAddressSub> prpModelAddressSubList = prpModelAddressSubDao.findByModelCode(modelCode);
        if (prpModelAddressSubList.size()>0){
            prpModelAddressSubDao.delete(prpModelAddressSubList);
        }
        //删除模板机构配置表
        List<PrpMmodelCom> prpMmodelComList = prpMmodelComDao.findByModelCode(modelCode);
        if (prpMmodelComList.size()>0){
            prpMmodelComDao.delete(prpMmodelComList);
        }
        //删除主表信息
        PrpMmodelMainDto prpMmodelMainDto1 = this.queryByPK(prpMmodelMainInfoDto.getPrpMmodelMainDto().getModelCode());
        if (prpMmodelMainDto1 !=null){
            PrpMmodelMain prpMmodelMain1 = this.convert(prpMmodelMainDto1,PrpMmodelMain.class);
            prpMmodelMainDao.delete(prpMmodelMain1);
        }
        //保存主表信息begin
        //保存模板配置主表
        if (prpMmodelMain != null) {
            prpMmodelMainDao.saveAndFlush(prpMmodelMain);
        }
        //保存模板机构配置表
        if (prpMmodelComList1.size()>0) {
            prpMmodelComDao.save(prpMmodelComList1);
        }
        //保存主表信息end
        //保存字表begin
        //保存模板保险地址表
        if (prpModelAddressSub != null) {
            prpModelAddressSubDao.saveAndFlush(prpModelAddressSub);
        }
        //保存模板共保信息表
        if (prpModelCoinsSubList != null) {
            for (PrpModelCoinsSub prpModelCoinsSub: prpModelCoinsSubList) {
                prpModelCoinsSubDao.saveAndFlush(prpModelCoinsSub);
            }
        }
//        //保存模板客户纳税人信息表
//        if (prpModelCustomerTaxPayInfoSub != null) {
//            prpModelCustomerTaxPayInfoSubDao.save(prpModelCustomerTaxPayInfoSub);
//        }
        //拆分特约信息
        if (prpModelEngageSubDtoList != null) {
            if (prpModelEngageSubDtoList.size() != 0) {
                prpMmodelMainInfoDto=ungroup(prpMmodelMainInfoDto);
            }
        }
        // 特别约定信息保存
        List<PrpModelEngageSubDto> prpModelEngageSubDtoList1 = prpMmodelMainInfoDto.getPrpModelEngageSubDtoList();
        if (prpModelEngageSubDtoList1 != null && prpModelEngageSubDtoList1.size() > 0) {
            List<PrpModelEngageSub> prpModelEngageSubList1 = new ArrayList<>();
            convertCollection(prpModelEngageSubDtoList1, prpModelEngageSubList1, PrpModelEngageSub.class);
            List<PrpModelEngageSub> prpModelEngageSubs = prpModelEngageSubDao.save(prpModelEngageSubList1);
            if (prpModelEngageSubs == null || prpModelEngageSubs.size() == 0) {
                throw new BusinessException("特别约定信息保存失败！");
            }

        }

        List<PrpModelInsuredSub> prpModelInsuredSubList=new ArrayList<>();
        prpModelInsuredSubList.add(appliInsured);
        prpModelInsuredSubList.add(insured);

            //保存模板保险关系人表
            if (prpModelInsuredSubList != null) {
                prpModelInsuredSubDao.save(prpModelInsuredSubList);
            }
            // 发票购货方信息保存start
            this.SaveCustomerInfo(prpMmodelMainInfoDto);
            // 发票购货方信息保存end

            //保存保单基本信息表
            if (prpModelMainSub != null) {
                prpModelMainSubDao.saveAndFlush(prpModelMainSub);
            }
            //保存模板农业险保单信息
            if (prpModelMainAgriSub != null) {
                prpModelMainAgriSubDao.saveAndFlush(prpModelMainAgriSub);
            }
            //保存标的子险信息表
            if (prpModelItemKindList != null) {
                prpModelItemKindDao.save(prpModelItemKindList);
            }

            //保存模板农险标的附加表
            if (prpModelItemKindAgriList != null) {
                prpModelItemKindAgriDao.save(prpModelItemKindAgriList);
            }

            //保存共保细节表
            if (prpModelCoinsDetailList != null) {
                prpModelCoinsDetailDao.save(prpModelCoinsDetailList);
            }

            //保存保额保费表
            if (prpModelFeeSub != null) {
                prpModelFeeSubDao.saveAndFlush(prpModelFeeSub);
            }

            //保存共保方收费信息表
            if (prpModelPlanCoinsList != null) {
                prpModelPlanCoinsDao.save(prpModelPlanCoinsList);
            }

            //保存收费计划表
            if (prpModelPlanSubList != null) {
                prpModelPlanSubDao.save(prpModelPlanSubList);
            }

            //保存补贴信息表
            if (prpModelSubsidyList != null) {
                prpModelSubsidyDao.save(prpModelSubsidyList);
            }


            //保存字表end
            Map<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("message", "success");
        Date date2 = new Date();
        System.out.println(date2.getTime()+"------end");
            return hashMap;
        }


    /**
     *  根据模板代码修改模板详细信息
     * @author: 田慧
     * @date: 2017/11/9 19:25
     * @param prpMmodelMainInfoDto 模板配置主表Dto、模板机构配置表Dto、模板保险地址表Dto、模板共保信息表Dto、模板客户纳税人信息表Dto、
     *         模板特别约定表Dto、模板保险关系人表Dto、 模板农业险保单信息Dto、保单基本信息表Dto、模板农险标的附加表Dto、标的子险信息Dto
     * @return 成功success
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String,String>  modifyByModelCode(PrpMmodelMainInfoDto prpMmodelMainInfoDto)throws Exception{
        //模板配置主表Dto
        PrpMmodelMainDto prpMmodelMainDto = prpMmodelMainInfoDto.getPrpMmodelMainDto();
        //模板机构配置表Dto
        List<PrpMmodelComDto> prpMmodelComDtoList = prpMmodelMainInfoDto.getPrpMmodelComDtoList();
        //模板保险地址表Dto
        PrpModelAddressSubDto prpModelAddressSubDto = prpMmodelMainInfoDto.getPrpModelAddressSubDto();
        //模板共保信息表Dto
//        PrpModelCoinsSubDto prpModelCoinsSubDto = prpMmodelMainInfoDto.getPrpModelCoinsSubDto();
        List<PrpModelCoinsSubDto> prpModelCoinsSubDtoList = prpMmodelMainInfoDto.getPrpModelCoinsSubDtoList();
        //模板客户纳税人信息表Dto
        PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto = prpMmodelMainInfoDto.getPrpModelCustomerTaxPayInfoSubDto();
        //模板特别约定表Dto
//        PrpModelEngageSubDto prpModelEngageSubDto = prpMmodelMainInfoDto.getPrpModelEngageSubDto();
        List<PrpModelEngageSubDto> prpModelEngageSubDtoList = prpMmodelMainInfoDto.getPrpModelEngageSubDtoList();
        //模板保险关系人表Dto
        PrpModelInsuredSubDto appliInsuredDto=prpMmodelMainInfoDto.getAppliInsuredDto();
        PrpModelInsuredSubDto insuredDto=prpMmodelMainInfoDto.getInsuredDto();
        //模板农业险保单信息Dto
        PrpModelMainAgriSubDto prpModelMainAgriSubDto = prpMmodelMainInfoDto.getPrpModelMainAgriSubDto();
        //保单基本信息表Dto
        PrpModelMainSubDto prpModelMainSubDto = prpMmodelMainInfoDto.getPrpModelMainSubDto();
        //模板农险标的附加表Dto
//        PrpModelItemKindAgriDto prpModelItemKindAgriDto = prpMmodelMainInfoDto.getPrpModelItemKindAgriDto();
        List<PrpModelItemKindAgriDto> prpModelItemKindAgriDtoList = prpMmodelMainInfoDto.getPrpModelItemKindAgriDtoList();
        //标的子险信息Dto
//        PrpModelItemKindDto prpModelItemKindDto = prpMmodelMainInfoDto.getPrpModelItemKindDto();
        List<PrpModelItemKindDto> prpModelItemKindDtoList = prpMmodelMainInfoDto.getPrpModelItemKindDtoList();
        //补贴信息表
        List<PrpModelSubsidyDto> prpModelSubsidyDtoList=prpMmodelMainInfoDto.getPrpModelSubsidyDtoList();
        //共保细节表
        List<PrpModelCoinsDetailDto> prpModelCoinsDetailDtoList=prpMmodelMainInfoDto.getPrpModelCoinsDetailDtoList();
        //保单保额保费表
        PrpModelFeeSubDto prpModelFeeSubDto=prpMmodelMainInfoDto.getPrpModelFeeSubDto();
        //共保方收费信息表
        List<PrpModelPlanCoinsDto> prpModelPlanCoinsDtoList=prpMmodelMainInfoDto.getPrpModelPlanCoinsDtoList();
        //收费计划表
        List<PrpModelPlanSubDto> prpModelPlanSubDtoList=prpMmodelMainInfoDto.getPrpModelPlanSubDtoList();

        /**将客户号放入业务表prpmodelinsuredsub 通过insureCode判断投保人和被保险人是不是同一个人
         * 如果是同一个人,则只要生成一个customerCode并保存到投保人和被投保人中,如果不是同一个人
         * ,则生成两个customerCode分别放入到投保人和被投保人信息中*/
        /** 获取清单类型 判断是散户还是大户 D是大户,S是散户*/
        String customerType = prpMmodelMainInfoDto.getAppliInsuredDto().getInsuredType();
        //初始化客户代码
        String customerCode;
        /** 如果是散户 (投保人和被投保人是同一个人) */
        if ("3".equals(customerType)) {
            /** 获取客户名  */
            String insureName = appliInsuredDto.getInsuredName();
            Map<String, String> map1 = new HashMap<>();
            map1.put("insureName", insureName);
            //是散户的情况下 用用户名去查询是否已经有相关的数据了
            List<PrpDcustomerDto> prpDcustomerDtoList = prpDcustomerApi.queryPrpDcustomerByInsureName(map1);
            //如果已经有相关的数据了
            if (prpDcustomerDtoList != null) {
                customerCode = prpDcustomerDtoList.get(0).getCustomerCode();
                prpMmodelMainInfoDto.getAppliInsuredDto().setInsuredCode(customerCode);
                prpMmodelMainInfoDto.getInsuredDto().setInsuredCode(customerCode);
            }
            //如果没有查到以前的相关数据 则生成新的customerCode
            else {
                customerCode = this.getCustomerCode(prpMmodelMainInfoDto);
                prpMmodelMainInfoDto.getAppliInsuredDto().setInsuredCode(customerCode);
                prpMmodelMainInfoDto.getInsuredDto().setInsuredCode(customerCode);
            }
        }
        /** 如果是大户 则投保人和被投保人可能出现不是同一个人的情况 */
        else if ("1".equals(customerType) || "2".equals(customerType)) {
            /** 如果是大户 则投保人和被投保人可能出现不是同一个人的情况 根据insureCode判断他们是否是同一个人 */
            //这是同一个人的情况下
            if (appliInsuredDto.getInsuredCode().equals(insuredDto.getInsuredCode())) {
                //如果是同一个人 ,先去判断这个大户在基础表中是不是已经存在了
                Map<String, String> appliMap = new HashMap<>();
                appliMap.put("identifyType", appliInsuredDto.getIdentifyType());
                appliMap.put("identifyNumber", appliInsuredDto.getIdentifyNumber());
                List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList = prpDcustomerIdvApi.queryPrpDcustomerByIndentity(appliMap);
                //如果已经存在了 则直接用老的客户代码放入即可
                if (prpDcustomerIdvDtoList.size()!=0) {
                    customerCode = prpDcustomerIdvDtoList.get(0).getCustomerCode();
                    prpMmodelMainInfoDto.getAppliInsuredDto().setInsuredCode(customerCode);
                    prpMmodelMainInfoDto.getInsuredDto().setInsuredCode(customerCode);
                } else {
                    //如果不存在,则用新生成的客户代码
                    /** 获取新生成的客户代码 */
                    customerCode = this.getCustomerCode(prpMmodelMainInfoDto);
                    prpMmodelMainInfoDto.getAppliInsuredDto().setInsuredCode(customerCode);
                    prpMmodelMainInfoDto.getInsuredDto().setInsuredCode(customerCode);
                }
            }
            /** 如果他们不是同一个人 */
            else {
                //先处理投保人的 去查询是不是已经有投保人的相关信息了(根据证件类型和证件号码去匹配)
                Map<String, String> appliMap = new HashMap<>();
                appliMap.put("identifyType", appliInsuredDto.getIdentifyType());
                appliMap.put("identifyNumber", appliInsuredDto.getIdentifyNumber());
                List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList = prpDcustomerIdvApi.queryPrpDcustomerByIndentity(appliMap);
                //如果已经有相关的了 则直接用老的customerCode
                if (prpDcustomerIdvDtoList != null) {
                    customerCode = prpDcustomerIdvDtoList.get(0).getCustomerCode();
                    appliInsuredDto.setInsuredCode(customerCode);
                } else {
                    //如果不存在,则用新生成的客户代码
                    /**获取客户号*/
                    customerCode = this.getCustomerCode(prpMmodelMainInfoDto);
                    appliInsuredDto.setInsuredCode(customerCode);
                }
                //此处处理被保险人的
                Map<String, String> insureMap = new HashMap<>();
                insureMap.put("identifyType", insuredDto.getIdentifyType());
                insureMap.put("identifyNumber", insuredDto.getIdentifyNumber());
                List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList1 = prpDcustomerIdvApi.queryPrpDcustomerByIndentity(insureMap);
                //如果已经有了相关的信息 则就用老的customerCode
                if (prpDcustomerIdvDtoList1 != null) {
                    customerCode = prpDcustomerIdvDtoList1.get(0).getCustomerCode();
                    insuredDto.setInsuredCode(customerCode);
                } else {
                    //再生成被保险人的客户代码,再放入被保险人的信息中
                    customerCode = this.getCustomerCode(prpMmodelMainInfoDto);
                    insuredDto.setInsuredCode(customerCode);
                }
            }
        }

        //将模板配置主表Dto转成模板配置主表实体
        PrpMmodelMain prpMmodelMain = this.convert(prpMmodelMainDto, PrpMmodelMain.class);
        //模板机构配置表Dto转成模板机构配置表实体
        List<PrpMmodelCom> prpMmodelComList=new ArrayList<>();
        convertCollection(prpMmodelComDtoList,prpMmodelComList,PrpMmodelCom.class);
//        PrpMmodelCom prpMmodelCom = this.convert(prpMmodelComDto, PrpMmodelCom.class);
        //模板保险地址表Dto转成模板保险地址表实体
        PrpModelAddressSub prpModelAddressSub = this.convert(prpModelAddressSubDto, PrpModelAddressSub.class);
        //模板共保信息表Dto转成模板共保信息表实体
//        PrpModelCoinsSub prpModelCoinsSub = this.convert(prpModelCoinsSubDto,PrpModelCoinsSub.class);
//        PrpModelEngageSub prpModelEngageSub = this.convert(prpModelEngageSubDto,PrpModelEngageSub.class);
        List<PrpModelCoinsSub> prpModelCoinsSubList = new ArrayList<>();
        this.convertCollection(prpModelCoinsSubDtoList, prpModelCoinsSubList, PrpModelCoinsSub.class);
//        //模板客户纳税人信息表Dto模板客户纳税人信息表实体
//        PrpModelCustomerTaxPayInfoSub prpModelCustomerTaxPayInfoSub = this.convert(prpModelCustomerTaxPayInfoSubDto, PrpModelCustomerTaxPayInfoSub.class);
        //模板保险关系人表Dto模板保险关系人表实体
        PrpModelInsuredSub appliInsured=this.convert(appliInsuredDto,PrpModelInsuredSub.class);
        //模板保险人关系人表被保险人表
        PrpModelInsuredSub insured=this.convert(insuredDto,PrpModelInsuredSub.class);
        //模板农业险保单信息Dto转成模板农业险保单信息实体
        PrpModelMainAgriSub prpModelMainAgriSub = convert(prpModelMainAgriSubDto, PrpModelMainAgriSub.class);
        //保单基本信息表Dto转成保单基本信息表实体
        PrpModelMainSub prpModelMainSub = this.convert(prpModelMainSubDto, PrpModelMainSub.class);
        //模板农险标的附加表Dto转成模板农险标的附加表实体
//        PrpModelItemKindAgri prpModelItemKindAgri =this.convert(prpModelItemKindAgriDto,PrpModelItemKindAgri.class);
        List<PrpModelItemKindAgri> prpModelItemKindAgriList = new ArrayList<>(prpModelItemKindAgriDtoList.size());
        this.convertCollection(prpModelItemKindAgriDtoList, prpModelItemKindAgriList, PrpModelItemKindAgri.class);
//        PrpModelItemKind prpModelItemKind = this.convert(prpModelItemKindDto,PrpModelItemKind.class);
        List<PrpModelItemKind> prpModelItemKindList = new ArrayList<>(prpModelItemKindDtoList.size());
        this.convertCollection(prpModelItemKindDtoList, prpModelItemKindList, PrpModelItemKind.class);
        //共保信息表Dto转化为Entity
        List<PrpModelCoinsDetail> prpModelCoinsDetailList = new ArrayList<>();
        convertCollection(prpModelCoinsDetailDtoList, prpModelCoinsDetailList, PrpModelCoinsDetail.class);
        //保单保额保费表Dto转化为Entity
        PrpModelFeeSub prpModelFeeSub = convert(prpModelFeeSubDto, PrpModelFeeSub.class);
        //共保方收费信息表Dto转化为Entity
        List<PrpModelPlanCoins> prpModelPlanCoinsList = new ArrayList<>();
        convertCollection(prpModelPlanCoinsDtoList, prpModelPlanCoinsList, PrpModelPlanCoins.class);
        //收费计划表Dto转化为Entity
        List<PrpModelPlanSub> prpModelPlanSubList = new ArrayList<>();
        convertCollection(prpModelPlanSubDtoList, prpModelPlanSubList, PrpModelPlanSub.class);
        //补贴信息表Dto转化为Entity
        List<PrpModelSubsidy> prpModelSubsidyList = new ArrayList<>();
        convertCollection(prpModelSubsidyDtoList, prpModelSubsidyList, PrpModelSubsidy.class);


        //修改模板配置主表信息
        if (prpMmodelMain != null) {
            prpMmodelMainDao.save(prpMmodelMain);
        }
        //修改模板机构配置表信息
        if(prpMmodelComList.size()!=0){
            //预防主键变化
            prpMmodelComDao.deleteByModelCode(prpMmodelComList.get(0).getModelCode());
            prpMmodelComDao.save(prpMmodelComList);
        }
        //修改模板保险地址表信息
        if(prpModelAddressSub!=null){
            prpModelAddressSubDao.save(prpModelAddressSub);
        }
        //修改模板共保信息表信息
        if (prpModelCoinsSubList != null) {
            for (PrpModelCoinsSub prpModelCoinsSub: prpModelCoinsSubList) {
                prpModelCoinsSubDao.saveAndFlush(prpModelCoinsSub);
            }
        }
        //拆分特约信息信息
        if (prpModelEngageSubDtoList != null) {
            if (prpModelEngageSubDtoList.size() != 0) {
                prpMmodelMainInfoDto=ungroup(prpMmodelMainInfoDto);
            }
        }
        // 修改特别约定信息信息
        List<PrpModelEngageSubDto> prpModelEngageSubDtoList1 = prpMmodelMainInfoDto.getPrpModelEngageSubDtoList();
        if (prpModelEngageSubDtoList1 != null && prpModelEngageSubDtoList1.size() > 0) {
            List<PrpModelEngageSub> prpModelEngageSubList1 = new ArrayList<>();
            convertCollection(prpModelEngageSubDtoList1, prpModelEngageSubList1, PrpModelEngageSub.class);
            List<PrpModelEngageSub> prpModelEngageSubs = prpModelEngageSubDao.save(prpModelEngageSubList1);
            if (prpModelEngageSubs == null || prpModelEngageSubs.size() == 0) {
                throw new BusinessException("特别约定信息保存失败！");
            }
        }
            List<PrpModelInsuredSub> prpModelInsuredSubList=new ArrayList<>();
            prpModelInsuredSubList.add(appliInsured);
            prpModelInsuredSubList.add(insured);

            //修改模板保险关系人表信息
            if (prpModelInsuredSubList != null) {
                prpModelInsuredSubDao.save(prpModelInsuredSubList);
            }
            // 客户信息保存start
            this.SaveCustomerInfo(prpMmodelMainInfoDto);
            // 客户信息保存end

        //修改保单基本信息表信息
        if (prpModelMainSub != null) {
            prpModelMainSubDao.save(prpModelMainSub);
        }
        //修改模板农业险保单信息
        if (prpModelMainAgriSub != null) {
            prpModelMainAgriSubDao.save(prpModelMainAgriSub);
        }
        //修改标的子险信息表信息
        if (prpModelItemKindList != null) {
            prpModelItemKindDao.save(prpModelItemKindList);
        }
        //修改模板农险标的附加表信息
        if(prpModelItemKindAgriList!=null){
            prpModelItemKindAgriDao.save(prpModelItemKindAgriList);
        }
        //修改共保细节表信息
        if (prpModelCoinsDetailList!=null){
            prpModelCoinsDetailDao.save(prpModelCoinsDetailList);
        }
        //修改保额保费表信息
        if (prpModelFeeSub!=null){
            prpModelFeeSubDao.save(prpModelFeeSub);
        }
        //修改保方收费信息表信息
        if (prpModelPlanCoinsList!=null){
            prpModelPlanCoinsDao.save(prpModelPlanCoinsList);
        }
        //修改收费计划表信息
        if (prpModelPlanSubList!=null){
            prpModelPlanSubDao.save(prpModelPlanSubList);
        }
        //修改补贴信息表信息
        if (prpModelSubsidyList!=null){
            prpModelSubsidyDao.save(prpModelSubsidyList);
        }


        Map<String,String> map = new HashMap<String,String>();
        map.put("message","success");
        return map;
    }
    /**
     *  根据模板代码删除模板信息，将 PrpMmodelMain 模板配置主表的flag 置为0 表示模板被删除。
     * @author: 田慧
     * @date: 2017/11/14 15:05
     * @param modelCodeList 模板代码集合
     * @return 成功success
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String,String> removeAllByModelCode(List<String> modelCodeList)throws Exception {
        //判断模板代码集合是否为空
        if (modelCodeList==null||modelCodeList.size()<=0){
            throw new DataVerifyException("入参不完整");
        }
        prpMmodelMainDao.modifyByModelCode(modelCodeList);


        Map<String,String> map = new HashMap<String,String>();
        map.put("message","success");
        return map;
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String modelcode) {
        PrpMmodelMainKey prpMmodelMainKey = new PrpMmodelMainKey(modelcode);
        prpMmodelMainDao.delete(prpMmodelMainKey);
    }
    /**
     *
     *  根据模板代码停用启用模板
     * @author: 田慧
     * @date: 2017/11/9 15:53
     * @param prpMmodelMainDto 模板配置主表Dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String,String>  modifyValidstatusByModelCode(PrpMmodelMainDto prpMmodelMainDto)throws Exception{
        //判断模板代码和模板状态是否为空
        if (StringUtils.isEmpty(prpMmodelMainDto.getModelCode())){
            throw new DataVerifyException("模板代码不能为空！");
        }
        if (StringUtils.isEmpty(prpMmodelMainDto.getValidStatus())){
            throw new DataVerifyException("模板状态不能为空！");
        }
        //根据主键查询到所有的字段存到实体类中
        PrpMmodelMain prpMmodelMain= prpMmodelMainDao.findOne(new PrpMmodelMainKey(prpMmodelMainDto.getModelCode()));
        prpMmodelMain.setValidStatus(prpMmodelMainDto.getValidStatus());
        prpMmodelMainDao.save(prpMmodelMain);
        Map<String,String> map = new HashMap<String,String>();
        map.put("message","success");
        return map;
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpMmodelMainDto prpMmodelMainDto) {
        PrpMmodelMain prpMmodelMain = this.convert(prpMmodelMainDto, PrpMmodelMain.class);
        prpMmodelMainDao.save(prpMmodelMain);
    }


    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public PrpMmodelMainDto queryByPK(String modelCode) {
        PrpMmodelMainKey prpMmodelMainKey = new PrpMmodelMainKey(modelCode);
        PrpMmodelMain prpMmodelMain = prpMmodelMainDao.findOne(prpMmodelMainKey);
        return this.convert(prpMmodelMain,PrpMmodelMainDto.class);
    }

    /**
     *  根据条件查询模板列表信息
     * @author: 田慧
     * @date: 2017/11/9 8:51
     * @param prpMmodelMainRequestDto 自定义的toD包括模板代码、模板机构、
     *                              被保险人名称、模板创建有效起期、模板创建有效止期
     *                                险种、标的、创建人名称、政策/商业标志、有效字段
     * @return 返回分页信息
     * @throws Exception
     */
    @Override
    public PageInfo<QueryPrpMmodelMainDto> queryPrpMmodelMainByCondition(PrpMmodelMainRequestDto prpMmodelMainRequestDto)throws Exception{
        int pageNo=prpMmodelMainRequestDto.getPageNo();
        int pageSize=prpMmodelMainRequestDto.getPageSize();
        if (pageNo < 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new DataVerifyException("每页数量不能小于1");
        }
        Map<String,Object> paraMap=new HashMap<String,Object>();
        //判断查询条件是否为空
        if(prpMmodelMainRequestDto==null){
            throw new DataVerifyException("入参不能为空！");
        }
//        String dataCondition;
//        List<String> list = new ArrayList<String>();
        StringBuilder strWhere = new StringBuilder();
        //拼接SQL
        StringBuilder countSql =new StringBuilder("SELECT count(1) FROM PrpMmodelMain p where p.logicdelete = '1'");
        StringBuilder stringBuilder = new StringBuilder("SELECT p FROM PrpMmodelMain p where p.logicdelete = '1'");
        //模板名称
        if(StringUtils.isNotEmpty(prpMmodelMainRequestDto.getModelName())){
            strWhere.append(" AND p.modelName=:modelName");
            paraMap.put("modelName",prpMmodelMainRequestDto.getModelName());
        }
        //模板代码
        if(StringUtils.isNotEmpty(prpMmodelMainRequestDto.getModelCode())){
            strWhere.append(" AND p.modelCode like :modelCode");
            paraMap.put("modelCode","%"+prpMmodelMainRequestDto.getModelCode()+"%");
        }

        //模板创建有效起期
        if (prpMmodelMainRequestDto.getStartDate()!=null){
            strWhere.append(" and  p.createDate >=TRUNC(:startDate)");
            paraMap.put("startDate",prpMmodelMainRequestDto.getStartDate());
        }
        //模板创建有效止期
        if (prpMmodelMainRequestDto.getEndDate()!=null){
            strWhere.append(" AND p.createDate <=TRUNC(:endDate)");
            paraMap.put("endDate",prpMmodelMainRequestDto.getEndDate());
        }
        //适用机构
        if(StringUtils.isNotEmpty(prpMmodelMainRequestDto.getComCode())){
            strWhere.append(" AND p.modelCode in (SELECT pp.modelCode FROM PrpMmodelCom pp WHERE pp.comCode=:comCode)");
            paraMap.put("comCode",prpMmodelMainRequestDto.getComCode());
        }
        //险种
        if (StringUtils.isNotEmpty(prpMmodelMainRequestDto.getRiskCode())){
            strWhere.append(" AND p.riskCode=:riskCode");
            paraMap.put("riskCode",prpMmodelMainRequestDto.getRiskCode());

        }
        //标的
        if(StringUtils.isNotEmpty(prpMmodelMainRequestDto.getItemCName())) {
            //获取标的代码
            Map<String,String> map = new HashMap<>();
            map.put("itemCName",prpMmodelMainRequestDto.getItemCName());
            List<String> itemCodeList = prpDitemApi.queryItemCode(map);
            if (itemCodeList!=null && itemCodeList.size()>0){
                strWhere.append(" AND p.modelCode in (SELECT pp.modelCode FROM PrpModelItemKind pp WHERE pp.itemCode in:itemCodeList)");
            paraMap.put("itemCodeList", itemCodeList);
            }else {
                return null;
            }
        }

        //创建人名称
        if (StringUtils.isNotEmpty(prpMmodelMainRequestDto.getUserName())){
           List<String> operatorCodeList = prpDuserApi.queryByUserName(prpMmodelMainRequestDto.getUserName());
           if (operatorCodeList!=null && operatorCodeList.size()>0){
               strWhere.append(" AND p.operatorCode in :operatorCodeList");
               paraMap.put("operatorCodeList",operatorCodeList);
           }else {
               return null;
           }

        }
        //投保人名称
        if (StringUtils.isNotEmpty(prpMmodelMainRequestDto.getAppledName())){
            strWhere.append(" AND p.modelCode in (SELECT pp.modelCode FROM PrpModelInsuredSub pp WHERE pp.insuredFlag=2 AND pp.insuredName like :appledName)");
            paraMap.put("appledName","%" + prpMmodelMainRequestDto.getAppledName() + "%");
        }
        //被保险人名称
        if (StringUtils.isNotEmpty(prpMmodelMainRequestDto.getInsuredName())){
            strWhere.append(" AND p.modelCode in (SELECT pp.modelCode FROM PrpModelInsuredSub pp WHERE pp.insuredFlag=1 AND pp.insuredName like :insuredName)");
            paraMap.put("insuredName","%"+prpMmodelMainRequestDto.getInsuredName()+"%");

        }
        //政策商业标志
        if (StringUtils.isNotEmpty(prpMmodelMainRequestDto.getBusinessType1())){
            strWhere.append(" AND p.modelCode in(SELECT pp.modelCode FROM PrpModelMainSub pp where pp.businessType1=:businessType1)");
            paraMap.put("businessType1",prpMmodelMainRequestDto.getBusinessType1());
        }
        //有效标志字段
        if (StringUtils.isNotEmpty(prpMmodelMainRequestDto.getValidStatus())){
            if ("1".equals(prpMmodelMainRequestDto.getValidStatus())){
                strWhere.append(" AND p.validStatus='1' AND TRUNC(p.startDate)<=TRUNC(sysdate) AND TRUNC(p.endDate)>=TRUNC(sysdate) AND p.flag='1'");
            }else if ("0".equals(prpMmodelMainRequestDto.getValidStatus())){
                strWhere.append(" AND (p.validStatus='0' OR TRUNC(p.startDate)>TRUNC(sysdate) OR TRUNC(p.endDate)<TRUNC(sysdate) or p.flag='0')");
            }
        }
//        if(list.size()>0){
//            dataCondition = this.joinCondition(list);
//
//            countSql.append(" where ");
//            countSql.append(dataCondition);
//
//            stringBuilder.append(" where ");
//            stringBuilder.append(dataCondition);
//        }

        countSql.append(strWhere.append(" order by p.modelCode desc"));
        stringBuilder.append(strWhere);
        Query dataResult = entityManager.createQuery(stringBuilder.toString());
        Query countResult= entityManager.createQuery(countSql.toString());
        this.setQueryParam(dataResult,pageNo,pageSize,paraMap);
        this.setQueryParam(countResult,paraMap);
        //查询总条数
        Long totalSize = (Long)countResult.getSingleResult();
        //查询结果
        List<QueryPrpMmodelMainDto> queryPrpMmodelMainDtoList = new ArrayList<>();
        List<PrpMmodelMain>  PrpMmodelMainList = dataResult.getResultList();
        List<PrpMmodelMainDto>  PrpMmodelMainDtoList = new ArrayList<PrpMmodelMainDto>();
        this.convertCollection(PrpMmodelMainList,PrpMmodelMainDtoList,PrpMmodelMainDto.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String current= sdf.format(new Date());
        Date currentTime = sdf.parse(current);
        Long currentDate = currentTime.getTime();

        for (PrpMmodelMainDto p:PrpMmodelMainDtoList) {
            QueryPrpMmodelMainDto queryPrpMmodelMainDto = new QueryPrpMmodelMainDto();
            queryPrpMmodelMainDto.setModelCode(p.getModelCode());
            queryPrpMmodelMainDto.setModelName(p.getModelName());
            queryPrpMmodelMainDto.setCreateDate(p.getCreateDate());
            queryPrpMmodelMainDto.setValidStatus(p.getValidStatus());
            queryPrpMmodelMainDto.setStartDate(p.getStartDate());//模板有效起期
            queryPrpMmodelMainDto.setEndDate(p.getEndDate());//模板有效止期
            queryPrpMmodelMainDto.setFlag(p.getFlag());
            Long startDate =p.getStartDate().getTime();
            Long endDate = p.getEndDate().getTime();

            if ("1".equals(p.getValidStatus())&& startDate<=currentDate && endDate>=currentDate && "1".equals(p.getFlag())){
                queryPrpMmodelMainDto.setValidStatus1("1");
            }
            else {
                queryPrpMmodelMainDto.setValidStatus1("0");
            }

            if (StringUtils.isEmpty(p.getOperatorCode())){
                queryPrpMmodelMainDto.setUserName("");
            }else{
                queryPrpMmodelMainDto.setUserName(this.getUserName(p.getOperatorCode()));
            }

            queryPrpMmodelMainDtoList.add(queryPrpMmodelMainDto);

        }
        PageInfo<QueryPrpMmodelMainDto> pageInfo=this.setPageInfo(queryPrpMmodelMainDtoList,pageNo,totalSize,QueryPrpMmodelMainDto.class);
        return  pageInfo;
    }

    public String getUserName(String userCode) throws Exception{
        Map<String,String> map = new HashMap<>();
        map.put("userCode",userCode);
        map.put("isChinese",LanguageFlagConstant.CHINESE);
      return prpDuserApi.translateCode(map);
}

    /**
     * * （查询机构树）
     * @author: 田慧
     * @date: 19:19
     * @param modelCode 模板号码
     * @param userCode 用户代码
     * @param comCode 机构代码
     * @return companyListDtoList
     * @throws Exception
     */
    public PrpMmodelMainInfoDto getCompanyTree (String modelCode,String userCode,String comCode) throws Exception{
        PrpMmodelMainInfoDto prpMmodelMainInfoDto = new PrpMmodelMainInfoDto();
        if (StringUtils.isEmpty(modelCode)){
            throw new DataVerifyException("模板代码不能为空！");
        }
        if(StringUtils.isEmpty(userCode)){
            throw new DataVerifyException("用户代码不能为空");
        }
        if(StringUtils.isEmpty(comCode)){
            throw new DataVerifyException("机构代码不能为空");
        }
        //根据模板代码查询模板机构配置表信息
        List<PrpMmodelCom> prpMmodelComList = prpMmodelComDao.findByModelCode(modelCode);
        List<PrpMmodelComDto> prpMmodelComDtoList = new ArrayList<PrpMmodelComDto>();
        convertCollection(prpMmodelComList,prpMmodelComDtoList,PrpMmodelComDto.class);

        List<String> selectList=new ArrayList<>();
        for(PrpMmodelComDto prpMmodelComDto : prpMmodelComDtoList){
            selectList.add(prpMmodelComDto.getComCode());
        }
        //调用机构数方法
        QueryComCodeInfoDto queryComCodeInfoDto = new QueryComCodeInfoDto();
        queryComCodeInfoDto.setSelectList(selectList);

        queryComCodeInfoDto.setUserCode(userCode);
        queryComCodeInfoDto.setLoginComCode(comCode);
        List<CompanyListDto> companyListDtoList = new ArrayList<>();
        List<com.sinosoft.ims.api.kernel.dto.CompanyListDto> companyListDtos=prpDcompanyApi.queryCompanyTree(queryComCodeInfoDto);
        this.convertCollection(companyListDtos,companyListDtoList,CompanyListDto.class);
        prpMmodelMainInfoDto.setCompanyListDtoList(companyListDtoList);
        return prpMmodelMainInfoDto;
    }
    /**
     *  根据模板代码查询模板详细信息
     * @author: 田慧
     * @date: 2017/11/15 9:03
     * @param  modelCode  模板代码,addressNo
     * @return 返回模板信息
     * @throws Exception
     */

    public PrpMmodelMainInfoDto queryPrpMmodelMainByHyperLink(String modelCode,String userCode,String comCode) throws Exception{
        PrpMmodelMainInfoDto prpMmodelMainInfoDto = new PrpMmodelMainInfoDto();
        Date date1 = new Date();
        System.out.println("------start"+date1.getTime()+"------start");
        if (StringUtils.isEmpty(modelCode)){
            throw new DataVerifyException("模板代码不能为空！");
        }
        if(StringUtils.isEmpty(userCode)){
            throw new DataVerifyException("用户代码不能为空");
        }
        if(StringUtils.isEmpty(comCode)){
            throw new DataVerifyException("机构代码不能为空");
        }
        HashMap<String,String>  mapModel = new HashMap<>();
        mapModel.put("message","");
        prpMmodelMainInfoDto.setMap(mapModel);
        PrpMmodelMainDto dto = queryByPK(modelCode);
        if (dto==null){
        HashMap<String,String>  map = new HashMap<>();
            mapModel.put("message","输入的模板号不存在，请输入正确的模板号");
        prpMmodelMainInfoDto.setMap(mapModel);
        return prpMmodelMainInfoDto;
        }
        //根据模板代码查询模板配置主表信息
        PrpMmodelMainDto prpMmodelMainDto = this.queryByPK(modelCode);
        prpMmodelMainInfoDto.setPrpMmodelMainDto(prpMmodelMainDto);
        //根据模板代码查询模板机构配置表信息
        List<PrpMmodelCom> prpMmodelComList = prpMmodelComDao.findByModelCode(modelCode);
        List<PrpMmodelComDto> prpMmodelComDtoList = new ArrayList<PrpMmodelComDto>();
        convertCollection(prpMmodelComList,prpMmodelComDtoList,PrpMmodelComDto.class);
        prpMmodelMainInfoDto.setPrpMmodelComDtoList(prpMmodelComDtoList);

//        List<String> selectList=new ArrayList<>();
//        for(PrpMmodelComDto prpMmodelComDto : prpMmodelComDtoList){
//            selectList.add(prpMmodelComDto.getComCode());
//        }
//        //调用机构数方法
//        QueryComCodeInfoDto queryComCodeInfoDto = new QueryComCodeInfoDto();
//        queryComCodeInfoDto.setSelectList(selectList);
//
//        queryComCodeInfoDto.setUserCode(userCode);
//        queryComCodeInfoDto.setLoginComCode(comCode);
//       List<CompanyListDto> companyListDtoList = new ArrayList<>();
//        List<com.sinosoft.ims.api.kernel.dto.CompanyListDto> companyListDtos=prpDcompanyApi.queryCompanyTree(queryComCodeInfoDto);
//        this.convertCollection(companyListDtos,companyListDtoList,CompanyListDto.class);
//        prpMmodelMainInfoDto.setCompanyListDtoList(companyListDtoList);
        //根据模板代码查询模板保险地址表信息
        List<PrpModelAddressSub> prpModelAddressSubList = prpModelAddressSubDao.findByModelCode(modelCode);
        List<PrpModelAddressSubDto> prpModelAddressSubDtoList = new ArrayList<>();
        this.convertCollection(prpModelAddressSubList,prpModelAddressSubDtoList,PrpModelAddressSubDto.class);
        if(prpModelAddressSubDtoList.size()>0){
            prpMmodelMainInfoDto.setPrpModelAddressSubDto(prpModelAddressSubDtoList.get(0));
        }
        //根据模板代码查询模板共保信息信息
//        PrpModelCoinsSubDto prpModelCoinsSubDto = prpModelCoinsSubService.queryByPK(modelCode);
//        prpMmodelMainModifyDto.setPrpModelCoinsSubDto(prpModelCoinsSubDto);
        List<PrpModelCoinsSub> prpModelCoinsSubList = prpModelCoinsSubDao.findByModelCode(modelCode);
        List<PrpModelCoinsSubDto> prpModelCoinsSubDtoList = new ArrayList<>(prpModelCoinsSubList.size());
        this.convertCollection(prpModelCoinsSubList,prpModelCoinsSubDtoList,PrpModelCoinsSubDto.class);
        prpMmodelMainInfoDto.setPrpModelCoinsSubDtoList(prpModelCoinsSubDtoList);
        //根据模板代码查询模板客户纳税人信息表信息
        PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto = prpModelCustomerTaxPayInfoSubService.queryByPK(modelCode);
        prpMmodelMainInfoDto.setPrpModelCustomerTaxPayInfoSubDto(prpModelCustomerTaxPayInfoSubDto);
        //根据模板代码查询模板特别约定表信息
//        PrpModelEngageSubDto prpModelEngageSubDto = prpModelEngageSubService.queryByPK(modelCode);
//        prpMmodelMainModifyDto.setPrpModelEngageSubDto(prpModelEngageSubDto);
        List<PrpModelEngageSub> prpModelEngageSubList = prpModelEngageSubDao.findByModelCode(modelCode);

        // 特别约定信息
        List<QueryModelPrpTengageDto> queryModelPrpTengageDtoList = new ArrayList<>();
        QueryModelPrpTengageDto queryModelPrpTengageDto = null;
        for (PrpModelEngageSub prpModelEngageSub : prpModelEngageSubList) {
            if (queryModelPrpTengageDto == null || !prpModelEngageSub.getClauseCode().equals(queryModelPrpTengageDto.getClauseCode())) {
                queryModelPrpTengageDto = new QueryModelPrpTengageDto();
                queryModelPrpTengageDto.setClauseCode(prpModelEngageSub.getClauseCode());
                queryModelPrpTengageDto.setSerialNo(prpModelEngageSub.getSerialNo());
                queryModelPrpTengageDtoList.add(queryModelPrpTengageDto);
            }
            // 条款标题名称
            if ("0".equals(prpModelEngageSub.getTitleFlag())) {
                queryModelPrpTengageDto.setClauseName(prpModelEngageSub.getClauses());
            } else {
                if (StringUtils.isEmpty(queryModelPrpTengageDto.getClausesContent())) {
                    queryModelPrpTengageDto.setClausesContent(prpModelEngageSub.getClauses());
                } else {
                    queryModelPrpTengageDto.setClausesContent(queryModelPrpTengageDto.getClausesContent() + prpModelEngageSub.getClauses());
                }
            }
        }
        prpMmodelMainInfoDto.setQueryModelPrpTengageDtoList(queryModelPrpTengageDtoList);

        List<PrpModelEngageSubDto> prpModelEngageSubDtoList = new ArrayList<>();
        this.convertCollection(prpModelEngageSubList,prpModelEngageSubDtoList,PrpModelEngageSubDto.class);
        prpMmodelMainInfoDto.setPrpModelEngageSubDtoList(prpModelEngageSubDtoList);
        //根据模板代码查询模板保险关系人表信息
        List<PrpModelInsuredSub> prpModelInsuredSubList = prpModelInsuredSubDao.findByModelCode(modelCode);
        List<PrpModelInsuredSubDto> prpModelInsuredSubDtoList = new ArrayList<PrpModelInsuredSubDto>();
        convertCollection(prpModelInsuredSubList,prpModelInsuredSubDtoList,PrpModelInsuredSubDto.class);
        if(prpModelInsuredSubList.size()>0){
            if ("2".equals(prpModelInsuredSubDtoList.get(0).getInsuredFlag())){
                prpMmodelMainInfoDto.setAppliInsuredDto(prpModelInsuredSubDtoList.get(0));
            }else {
                prpMmodelMainInfoDto.setInsuredDto(prpModelInsuredSubDtoList.get(0));
            }

            if ("2".equals(prpModelInsuredSubDtoList.get(1).getInsuredFlag())){
                prpMmodelMainInfoDto.setAppliInsuredDto(prpModelInsuredSubDtoList.get(1));
            }
            else {
                prpMmodelMainInfoDto.setInsuredDto(prpModelInsuredSubDtoList.get(1));
            }

        }

        //根据模板代码查询模板农业险保单信息表信息
        PrpModelMainAgriSubDto prpModelMainAgriSubDto = prpModelMainAgriSubService.queryByPK(modelCode);
        prpMmodelMainInfoDto.setPrpModelMainAgriSubDto(prpModelMainAgriSubDto);
        //根据模板代码查询保单基本信息表信息
        PrpModelMainSubDto prpModelMainSubDto = prpModelMainSubService.queryByPK(modelCode);
        prpMmodelMainInfoDto.setPrpModelMainSubDto(prpModelMainSubDto);
        if(StringUtils.isNotEmpty(prpModelMainSubDto.getUpdaterCode())){
            PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(prpModelMainSubDto.getUpdaterCode());
            if(prpDuserDto!=null){
                prpMmodelMainInfoDto.setUpdaterName(prpDuserDto.getUserName());
            }
        }
        if(StringUtils.isNotEmpty(prpModelMainSubDto.getOperatorCode())){
            PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(prpModelMainSubDto.getOperatorCode());
            if(prpDuserDto!=null){
                prpMmodelMainInfoDto.setOperatorName(prpDuserDto.getUserName());
            }
        }
        //险类代码转成险类名称
        PrpDclassDto prpDclassDto=prpdclassApi.queryByPK(prpModelMainSubDto.getClassCode());
        if (prpDclassDto!=null){
            prpMmodelMainInfoDto.setClassName(prpDclassDto.getClassName());
        }
        //险种代码转成险类名称
        Map<String,String> riskMap= new HashMap<>();
        riskMap.put("riskCode",prpModelMainSubDto.getRiskCode());
        PrpDriskDto prpDriskDto=prpDriskApi.queryByPK(riskMap);
        if (prpDriskDto!=null){
            prpMmodelMainInfoDto.setRiskCname(prpDriskDto.getRiskCName());
        }
           // 根据模板代码查询标的子险信息
//           PrpModelItemKind prpModelItemKind = prpModelItemKindDao.findByModelCode(modelCode);
//           PrpModelItemKindDto prpModelItemKindDto = convert(prpModelItemKind,PrpModelItemKindDto.class);
//           prpMmodelMainModifyDto.setPrpModelItemKindDto(prpModelItemKindDto);
        List<PrpModelItemKind> prpModelItemKindList = prpModelItemKindDao.findByModelCode(modelCode);
        List<PrpModelItemKindDto> prpModelItemKindDtoList = new ArrayList<>(prpModelItemKindList.size());
        this.convertCollection(prpModelItemKindList,prpModelItemKindDtoList,PrpModelItemKindDto.class);
        prpMmodelMainInfoDto.setPrpModelItemKindDtoList(prpModelItemKindDtoList);
        //根据模板代码查询模板农险标的附加表
        List<PrpModelItemKindAgri> prpModelItemKindAgriList = prpModelItemKindAgriDao.findByModelCode(modelCode);
        List<PrpModelItemKindAgriDto> prpModelItemKindAgriDtoList = new ArrayList<>(prpModelItemKindAgriList.size());
        this.convertCollection(prpModelItemKindAgriList,prpModelItemKindAgriDtoList,PrpModelItemKindAgriDto.class);
//           PrpModelItemKindAgriDto prpModelItemKindAgriDto =convert(prpModelItemKindAgri,PrpModelItemKindAgriDto.class);
        prpMmodelMainInfoDto.setPrpModelItemKindAgriDtoList(prpModelItemKindAgriDtoList);

        //根据模板代码查询模板补贴信息表
        List<PrpModelSubsidy> prpModelSubsidyList=prpModelSubsidyDao.queryByModelCode(modelCode);
        List<PrpModelSubsidyDto> prpModelSubsidyDtoList=new ArrayList<>();
        convertCollection(prpModelSubsidyList,prpModelSubsidyDtoList,PrpModelSubsidyDto.class);
        prpMmodelMainInfoDto.setPrpModelSubsidyDtoList(prpModelSubsidyDtoList);
        //根据模板代码查询模板共保细节表
        List<PrpModelCoinsDetail> prpModelCoinsDetailList=prpModelCoinsDetailDao.queryByModelCode(modelCode);
        List<PrpModelCoinsDetailDto> prpModelCoinsDetailDtoList=new ArrayList<>();
        convertCollection(prpModelCoinsDetailList,prpModelCoinsDetailDtoList,PrpModelCoinsDetailDto.class);
        prpMmodelMainInfoDto.setPrpModelCoinsDetailDtoList(prpModelCoinsDetailDtoList);
        //根据模板代码查询保单保额保费信息表
        List<PrpModelFeeSub> prpModelFeeSubList=prpModelFeeSubDao.queryByModelCode(modelCode);
        List<PrpModelFeeSubDto> prpModelFeeSubDtoList=new ArrayList<>();
        convertCollection(prpModelFeeSubList,prpModelFeeSubDtoList,PrpModelFeeSubDto.class);
        if (prpModelFeeSubList.size()>0){
            prpMmodelMainInfoDto.setPrpModelFeeSubDto(prpModelFeeSubDtoList.get(0));
        }
        String currency2Name="";
        if(prpModelFeeSubDtoList.size()>0){
            PrpDcodeDto prpDcodeDto = prpDcodeApi.queryByPK("CURRENCY_CI",prpModelFeeSubDtoList.get(0).getCurrency2());
            if(prpDcodeDto!=null){
                currency2Name=prpDcodeDto.getCodeCName();
            }
        }
        prpMmodelMainInfoDto.setCurrency2Name(currency2Name);
        //根据模板代码查询共保方收费信息表
        List<PrpModelPlanCoins> prpModelPlanCoinsList=prpModelPlanCoinsDao.queryByModelCode(modelCode);
        List<PrpModelPlanCoinsDto> prpModelPlanCoinsDtoList=new ArrayList<>();
        convertCollection(prpModelPlanCoinsList,prpModelPlanCoinsDtoList,PrpModelPlanCoinsDto.class);
        prpMmodelMainInfoDto.setPrpModelPlanCoinsDtoList(prpModelPlanCoinsDtoList);
        //根据模板代码查询收费计划表
        List<PrpModelPlanSub> prpModelPlanSubList=prpModelPlanSubDao.queryByModelCode(modelCode);
        List<PrpModelPlanSubDto> prpModelPlanSubDtoList=new ArrayList<>();
        convertCollection(prpModelPlanSubList,prpModelPlanSubDtoList,PrpModelPlanSubDto.class);
        prpMmodelMainInfoDto.setPrpModelPlanSubDtoList(prpModelPlanSubDtoList);
        //清单信息
        // 调用清单系统查询insureMainList表
        List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByProposalNo(modelCode);
        if (insureMainListDtoList.size() > 0) {
            InsureMainListDto insureMainListDto = insureMainListDtoList.get(0);
            String gisInsureMainListCode = insureMainListDto.getGisInsureListCode();
            Integer serialNo = insureMainListDto.getSerialNo();
            String serial = String.valueOf(serialNo);
            Map<String, String> map1 = new HashMap<>();
            map1.put("gisInsureMainListCode", gisInsureMainListCode);
            map1.put("serialNo", serial);
            map1.get("serialNo");
            GisInsureMainListDto gisInsureMainListDto=gisInsureListApi.queryByPk(map1);
            if(gisInsureMainListDto!=null){
                //清单类型(D:大户 S:散户)
                String listTypeFlag = gisInsureMainListDto.getListType();
                // 属性清单归属区域（省级）名称
                prpMmodelMainInfoDto.setfProvinceName(gisInsureMainListDto.getfProvinceName());
                //属性清单归属区域（市级）名称
                prpMmodelMainInfoDto.setfCityName(gisInsureMainListDto.getfCityName());
                //属性清单归属区域（县/区级）名称
                prpMmodelMainInfoDto.setfCountyName(gisInsureMainListDto.getpCountyName());
                //属性清单归属区域（镇级）名称
                prpMmodelMainInfoDto.setfTownName(gisInsureMainListDto.getfTownName());
                //属性清单归属区域（村级）名称
                prpMmodelMainInfoDto.setfVillageName(gisInsureMainListDto.getfVillageName());
                prpMmodelMainInfoDto.setListTypeFlag(listTypeFlag);
                // 承保清单归属区域
                prpMmodelMainInfoDto.setFareaCode(insureMainListDto.getfAreaCode());
                // 清单编号
                prpMmodelMainInfoDto.setInsureListCode(insureMainListDto.getInusreListCode());
                // 金禾清单编号
                prpMmodelMainInfoDto.setGisInsureListCode(insureMainListDto.getGisInsureListCode());
                // 清单备注
                prpMmodelMainInfoDto.setRemark(insureMainListDto.getRemark());
                // 清单类型
                prpMmodelMainInfoDto.setValicity(insureMainListDto.getValidity());
            }
        }
        //清单序列号
        if (StringUtils.isNotEmpty(prpMmodelMainInfoDto.getInsureListCode())){
            InsureMainListDto insureMainListDto = insureMainListApi.queryByPK(prpMmodelMainInfoDto.getInsureListCode());
            if (insureMainListDto!=null){
                Integer  serialNo = insureMainListDto.getSerialNo();
                prpMmodelMainInfoDto.setSerialNo(serialNo);
            }
        }
        Date date2 = new Date();
        System.out.println("------end"+date2.getTime()+"------end");
        return prpMmodelMainInfoDto;
    }

    /**
     *  根据险种代码和机构代码查询 PrpMmodelMain模板配置主表信息
     * @author: 田慧
     * @date: 2017/12/11 11:45
     * @param riskCode 险种代码
     * @param comCode  机构代码
     * @return PrpMmodelMainDto的集合
     * @throws Exception
     */
    @Override
    public List<PrpMmodelMainDto> queryPrpMmodelMainByRiskCodeAndComCode(String riskCode, String comCode) throws Exception {
        if (StringUtils.isEmpty(comCode)) {
            throw new DataVerifyException("机构代码不能为空!");
        }
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空!");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("comCode",comCode);
        List<PrpDcompanyDto> prpDcompanyDtoList = prpDcompanyApi.queryDownCompany(paraMap);
        String sql ="select distinct(p) from PrpMmodelMain p,PrpMmodelCom pp where p.validStatus='1' and p.logicdelete='1' and TRUNC(startDate) <= TRUNC(sysdate) and TRUNC(endDate) >= TRUNC(sysdate) and p.flag='1' and p.modelCode = pp.modelCode";
        StringBuilder strWhere = new StringBuilder();
        //拼接查询该机构下包含所有子机构下的 所有模板信息
        if (prpDcompanyDtoList.size() > 0) {
            strWhere.append(" AND pp.comCode in (");
        }
        for (int i = 0; i < prpDcompanyDtoList.size(); i++) {
            PrpDcompanyDto prpDcompanyDto = prpDcompanyDtoList.get(i);
            //机构大于1000个 处理方式是 拼接 or comCode in ()
            if(i <1000){
                if (i == prpDcompanyDtoList.size()-1 || i==999) {
                    strWhere.append("'" + prpDcompanyDto.getComCode() + "'");
                } else {
                    strWhere.append("'"+prpDcompanyDto.getComCode() +"'"+ ",");
                }
            }else if(i==1000){
                if(i == prpDcompanyDtoList.size()-1){
                    strWhere.append(" ) OR comCode In ( '"+ prpDcompanyDto.getComCode()+"'");
                }else{
                    strWhere.append(" ) OR comCode In ( '"+ prpDcompanyDto.getComCode()+"',");
                }
            }else{
                if(i == prpDcompanyDtoList.size()-1){
                    strWhere.append(" '"+ prpDcompanyDto.getComCode()+"'");
                }else{
                    strWhere.append("'"+ prpDcompanyDto.getComCode()+"',");
                }
            }
        }
        if (prpDcompanyDtoList.size() > 0) {
            strWhere.append(" )");
        }
        strWhere.append(" and p.riskCode = :riskCode");
        map.put("riskCode",riskCode);
        sql+=strWhere;
        Query dataResult = entityManager.createQuery(sql);
        this.setQueryParam(dataResult, map);
        List<PrpMmodelMain> prpMmodelMainList = dataResult.getResultList();
        List<PrpMmodelMainDto> prpMmodelMainDtoList = new ArrayList<PrpMmodelMainDto>();
        this.convertCollection(prpMmodelMainList, prpMmodelMainDtoList, PrpMmodelMainDto.class);
        return prpMmodelMainDtoList;
    }

    /**
     * 将PrpModelEngage中对象按照FIELDLENGHT长度拆分成多个PrpModelEngage对象信息
     * @author: 田慧
     * @date: 2018/1/8 10:18
     * @param prpMmodelMainInfoDto
     * @return
     */
    public PrpMmodelMainInfoDto ungroup(PrpMmodelMainInfoDto prpMmodelMainInfoDto){
        PrpModelEngageSubDto prpModelEngageSubDto = null;//原有Dto
        PrpModelEngageSubDto prpModelEngageSubAddDto = null;//新增Dto
        List<PrpModelEngageSubDto> prpModelEngageSubDtoList = new ArrayList<PrpModelEngageSubDto>();
        String[] arrClauses = {}; //拆分的条款数组
        int intLineNo = 0; //行号
        int intSerialNo = 0; //序号
        int intSetSeriNo = 1;
        int i, j = 0; //循环变量
        intLineNo = 0;
        intSerialNo = prpMmodelMainInfoDto.getPrpModelEngageSubDtoList().get(0).getSerialNo();
        //循环拆分
        for (i = 0; i < prpMmodelMainInfoDto.getPrpModelEngageSubDtoList().size(); i++) {
            prpModelEngageSubDto = prpMmodelMainInfoDto.getPrpModelEngageSubDtoList().get(i);
            //拆分
            if (StringUtils.isEmpty(prpModelEngageSubDto.getClauses())) {
                String[] arrTemp = new String[1];
                arrTemp[0] = "";
                arrClauses = arrTemp;
            } else {
                arrClauses = StringGyUtils.split(prpModelEngageSubDto.getClauses(), AgriPrpallConstant.FIELDLENGHT);
            }

            //判断是否重新计算行号
            if (intSerialNo != prpModelEngageSubDto.getSerialNo()) {
                intLineNo = 0;
                intSerialNo = prpModelEngageSubDto.getSerialNo();
                intSetSeriNo++;
            }
            //赋值
            for (j = 0; j<arrClauses.length; j++) {
                //长度校验
                if(arrClauses[j].getBytes().length > AgriPrpallConstant.FIELDLENGHT) {
                    LOGGER.error("ungroup() - length>FIELDLENGHT:" + arrClauses[j]);
                }

                intLineNo++; //行号加一
                prpModelEngageSubAddDto = new PrpModelEngageSubDto();
                prpModelEngageSubAddDto.setModelCode(prpModelEngageSubDto.getModelCode());
                prpModelEngageSubAddDto.setSerialNo(intSetSeriNo);
                prpModelEngageSubAddDto.setLineNo(intLineNo);
                prpModelEngageSubAddDto.setClauseCode(prpModelEngageSubDto.getClauseCode());
                prpModelEngageSubAddDto.setClauses(arrClauses[j]); //节FIELDLENGHT长
                prpModelEngageSubAddDto.setTitleFlag(prpModelEngageSubDto.getTitleFlag());
                prpModelEngageSubAddDto.setFlag(prpModelEngageSubDto.getFlag());
                prpModelEngageSubAddDto.setRiskCode(prpModelEngageSubDto.getRiskCode());
                prpModelEngageSubDtoList.add(prpModelEngageSubAddDto);
            }
        }
        prpMmodelMainInfoDto.getPrpModelEngageSubDtoList().clear();
        prpMmodelMainInfoDto.setPrpModelEngageSubDtoList(prpModelEngageSubDtoList);
        return prpMmodelMainInfoDto;
    }
    /**
     * * 根据模板代码查询模板配置主表信息
     * @author: 田慧
     * @date: 10:25
     * @param map modelCode 模板代码
     * @return PrpMmodelMainDto
     * @throws Exception
     */
    @Override
    public PrpMmodelMainDto getPrpmmodelmainInfo(Map<String,String> map) throws Exception{
        String modelCode=map.get("modelCode");
        Date date = new Date();
        PrpMmodelMain prpMmodelMain = prpMmodelMainDao.getPrpmmodelmainInfo(modelCode,date);
        PrpMmodelMainDto prpMmodelMainDto = this.convert(prpMmodelMain,PrpMmodelMainDto.class);
        return prpMmodelMainDto;
    }
}