package com.sinosoft.ims.core.kernel.service.impl;


import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.dto.CompanyConditionDto;
import com.sinosoft.ims.api.kernel.dto.PrpDCompanyDto;
import com.sinosoft.ims.core.kernel.dao.PrpDCompanyDao;
import com.sinosoft.ims.core.kernel.entity.PrpDCompany;
import com.sinosoft.ims.core.kernel.entity.PrpDCompanyKey;
import com.sinosoft.ims.core.kernel.service.CompanyService;
import com.sinosoft.ims.core.kernel.service.PowerService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzhongkai
 * @description 机构相关服务实现类
 * @date 2016年9月27日下午7:06:17
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl implements CompanyService {
    private static Log LOGGER = LogFactory.getLog(CompanyServiceImpl.class);

    @Autowired
    private PrpDCompanyDao prpDCompanyDao;

    @Autowired
    private PowerService powerService;

    /**
     * @param companyConditionDto
     * @return PageInfo
     * @description 机构查询列表服务
     * @
     * @author hzhongkai
     * @date 2016年9月28日下午4:46:06
     */
    @Override
    public PageInfo<PrpDCompanyDto> queryCompanyPage(CompanyConditionDto companyConditionDto)

    {
        Assert.notNull(companyConditionDto, " 机构查询列表服务 入参 CompanyConditionDto 不允许为空！");
        LOGGER.error("机构查询列表服务开始  ComCName = " + companyConditionDto.getComCName()
                + "  UpperComCode= " + companyConditionDto.getUpperComCode());
        PageInfo<PrpDCompanyDto> pageInfo = new PageInfo<>();
        Pageable page = new PageRequest(companyConditionDto.getPageNo(),companyConditionDto.getPageSize());
        Page<PrpDCompany> list = prpDCompanyDao.findAll(genCondition(companyConditionDto),page);
        List<PrpDCompanyDto> prpdcompanyDtoList = new ArrayList<PrpDCompanyDto>(list.getSize());
        convertCollection(list.getContent(), prpdcompanyDtoList, PrpDCompanyDto.class);
        pageInfo.setContent(prpdcompanyDtoList);
        pageInfo.setTotalCount(list.getTotalElements());
        pageInfo.setPages(list.getTotalPages());
        return pageInfo;
    }

    /**
     * @param prpDCompanyDto
     * @return ResponseDto
     * @description 新增机构服务
     * @
     * @author hzhongkai
     * @date 2016年9月28日下午4:46:32
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveCompany(PrpDCompanyDto prpDCompanyDto) {
        PrpDCompany prpdnewcode = convert(prpDCompanyDto, PrpDCompany.class);
        prpdnewcode.setValidStatus("1");
        prpDCompanyDao.save(prpdnewcode);
    }

    /**
     * @param prpDCompanyDto
     * @return ResponseDto
     * @description 机构管理修改服务
     * @
     * @author hzhongkai
     * @date 2016年9月28日下午4:46:53
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCompany(PrpDCompanyDto prpDCompanyDto)

    {
        PrpDCompany prpdnewcode = convert(prpDCompanyDto, PrpDCompany.class);
        prpdnewcode.setValidStatus("1");
        prpDCompanyDao.save(prpdnewcode);
    }

    /**
     * @param prpDCompanyDto
     * @return
     * @description 省级下拉机构查询接口
     * @
     * @author hzhongkai
     * @date 2016年9月28日下午4:47:21
     */
    @Override
    public List<PrpDCompanyDto> qeuryPrpDCompanyList(PrpDCompanyDto prpDCompanyDto)

    {
        List<PrpDCompany> list = prpDCompanyDao.findAll(genfuzzyCondition(prpDCompanyDto));
        if (list == null) {
            return new ArrayList<PrpDCompanyDto>();
        }
        List<PrpDCompanyDto> prpdnewcodeDtoList = new ArrayList<PrpDCompanyDto>(list.size());
        convertCollection(list, prpdnewcodeDtoList, PrpDCompanyDto.class);
        return prpdnewcodeDtoList;
    }


    /**
     * @param prpDCompany
     * @return
     * @description 对象转换
     * @author dongyingchun
     * @date 2016年9月20日上午11:39:52
     */
    private PrpDCompanyDto prpDCompanyTOPrpDCompanyDto(PrpDCompany prpDCompany)

    {
        PrpDCompanyDto prpDCompanyDto = convert(prpDCompany, PrpDCompanyDto.class);
        return prpDCompanyDto;
    }

    /**
     * @param condition
     * @return PrpDCompanyExample
     * @description 封装机构查询对象
     * @author hzhongkai
     * @date 2016年9月28日下午4:50:25
     */
    private Specification<PrpDCompany> genCondition(CompanyConditionDto condition) {
        return Specifications.<PrpDCompany>and()
                .eq("validStatus", "1")
                .eq(StringUtils.isNotEmpty(condition.getCertificateType()), "certificateType", condition.getCertificateType())
                .eq(StringUtils.isNotEmpty(condition.getComCode()), "comCode", condition.getComCode())
                .eq(StringUtils.isNotEmpty(condition.getUpperComCode()), "upperComCode", condition.getUpperComCode())
                .build();
        //TODO:orm 复杂业务关系 后期处理
//        //查询有效数据
//        //companyConditionDto.setValidStatus("1");
//
//        PrpDCompanyExample prpDCompanyExample = new PrpDCompanyExample();
//        PrpDCompanyExample.Criteria companyCriteria = prpDCompanyExample.createCriteria();
//
//        //如果录入证件类型为空，并且证件号码不为空，使用查询各个证件类型匹配号码
//        if (StringUtils.isBlank(companyConditionDto.getCertificateType()) && !StringUtils.isBlank(companyConditionDto.getIdNo()))
//        {
//            companyCriteria.andUnSocialCreditCodeEqualTo(companyConditionDto.getIdNo());
//            prpDCompanyExample.or().andBusinessLicenseNoEqualTo(companyConditionDto.getIdNo());
//            prpDCompanyExample.or().andOrganizationCodeEqualTo(companyConditionDto.getIdNo());
//            prpDCompanyExample.or().andTaxRegistCertiNoEqualTo(companyConditionDto.getIdNo());
//        }
//        //如果录入证件类型不为空，证件号码为空，则查询该证件类型号码不为空的数据
//        else if (!StringUtils.isBlank(companyConditionDto.getCertificateType()) &&  StringUtils.isBlank(companyConditionDto.getIdNo()))
//        {
//            // 71 组织机构代码证
//            if ("71".equals(companyConditionDto.getCertificateType())  )
//            {
//                companyCriteria.andOrganizationCodeIsNotNull();
//            }
//            // 72 税务登记证
//            else if ("72".equals(companyConditionDto.getCertificateType()))
//            {
//                companyCriteria.andTaxRegistCertiNoIsNotNull();
//            }
//            // 73 营业执照
//            else if ("73".equals(companyConditionDto.getCertificateType()))
//            {
//                companyCriteria.andBusinessLicenseNoIsNotNull();
//            }
//            // 74 社会信用代码
//            else if ("74".equals(companyConditionDto.getCertificateType()))
//            {
//                companyCriteria.andUnSocialCreditCodeIsNotNull();
//            }
//        }
//        // 如果录入证件类型 ,证件号码均不为空
//        else if(!StringUtils.isBlank(companyConditionDto.getCertificateType()) &&  !StringUtils.isBlank(companyConditionDto.getIdNo())){
//            // 71 组织机构代码证
//            if ("71".equals(companyConditionDto.getCertificateType())  )
//            {
//                companyConditionDto.setOrganizationCode(companyConditionDto.getIdNo());
//            }
//            // 72 税务登记证
//            else if ("72".equals(companyConditionDto.getCertificateType()))
//            {
//                companyConditionDto.setTaxRegistCertiNo(companyConditionDto.getIdNo());
//            }
//            // 73 营业执照
//            else if ("73".equals(companyConditionDto.getCertificateType()))
//            {
//                companyConditionDto.setBusinessLicenseNo(companyConditionDto.getIdNo());
//            }
//            // 74 社会信用代码
//            else if ("74".equals(companyConditionDto.getCertificateType()))
//            {
//                companyConditionDto.setUnSocialCreditCode(companyConditionDto.getIdNo());
//            }
//        }
//
//        if (!StringUtils.isBlank(companyConditionDto.getComCode()))
//        {
//            companyCriteria.andComCodeEqualTo(companyConditionDto.getComCode());
//        }
//        if (!StringUtils.isBlank(companyConditionDto.getUpperComCode()))
//        {
//            companyCriteria.andUpperComCodeEqualTo(companyConditionDto.getUpperComCode());
//        }
//        // 上级机构列表查询
//        if (companyConditionDto.getUpperComCodes()!=null && companyConditionDto.getUpperComCodes().size()>0)
//        {
//            companyCriteria.andUpperComCodeIn(companyConditionDto.getUpperComCodes());
//        }
//        if (!StringUtils.isBlank(companyConditionDto.getComType()))
//        {
//            companyCriteria.andComTypeEqualTo(companyConditionDto.getComType());
//        }
//        //机构名称模糊查询
//        if (!StringUtils.isBlank(companyConditionDto.getComCName()))
//        {
//            companyCriteria.andComCNameLike("%" + companyConditionDto.getComCName() + "%");
//        }
//        if (!StringUtils.isBlank(companyConditionDto.getIdType()))
//        {
//            companyCriteria.andIdTypeEqualTo(companyConditionDto.getIdType());
//        }
//        if (!StringUtils.isBlank(companyConditionDto.getOrganizationCode()))
//        {
//            companyCriteria.andOrganizationCodeEqualTo(companyConditionDto.getOrganizationCode());
//        }
//        if (!StringUtils.isBlank(companyConditionDto.getBusinessLicenseNo()))
//        {
//            companyCriteria.andBusinessLicenseNoEqualTo(companyConditionDto.getBusinessLicenseNo());
//        }
//        if (!StringUtils.isBlank(companyConditionDto.getUnSocialCreditCode()))
//        {
//            companyCriteria.andUnSocialCreditCodeEqualTo(companyConditionDto.getUnSocialCreditCode());
//        }
//        if (!StringUtils.isBlank(companyConditionDto.getTaxRegistCertiNo()))
//        {
//            companyCriteria.andTaxRegistCertiNoEqualTo(companyConditionDto.getTaxRegistCertiNo());
//        }
//        if (!StringUtils.isBlank(companyConditionDto.getValidStatus()))
//        {
//            companyCriteria.andValidStatusEqualTo(companyConditionDto.getValidStatus());
//        }
//        prpDCompanyExample.setOrderByClause("comCode asc");
//        return prpDCompanyExample;
    }

    /**
     * @param prpDcompanyDto
     * @return
     * @description 检查机构代码是否重复
     * @
     * @author hzhongkai
     * @date 2016年9月28日下午4:47:21
     */
    @Override
    public boolean checkComCode(PrpDCompanyDto prpDcompanyDto)

    {
        if (StringUtils.isEmpty(prpDcompanyDto.getComCode())) {
            return false;
        }
        PrpDCompanyKey prpDCompany = new PrpDCompanyKey();
        prpDCompany.setComCode(prpDcompanyDto.getComCode());
        // 判断机构代码是否重复
        PrpDCompany companyTemp = prpDCompanyDao.findOne(prpDCompany);
        if (companyTemp != null) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public PrpDCompanyDto queryCompanyByComcode(CompanyConditionDto companyConditionDto)

    {
        PrpDCompanyKey prpDCompanyKey = new PrpDCompanyKey();
        prpDCompanyKey.setComCode(companyConditionDto.getComCode());
        PrpDCompany prpDCompany = prpDCompanyDao.findOne(prpDCompanyKey);
        return convert(prpDCompany,PrpDCompanyDto.class);
    }


    /**
     * @param queryDto
     * @return
     * @description 查询机构列表，增加权限控制
     * @
     * @author hzhongkai
     * @date 2016年10月22日上午10:00:50
     */
    @Override
    public PageInfo<PrpDCompanyDto> queryPowerCompanyPage(CompanyConditionDto queryDto) {
        //增加权限查询条件
//        PowerConditionDto powerConditionDto = new PowerConditionDto();
//        powerConditionDto.setBaseDto(queryDto);
//        powerConditionDto.setUserCode(queryDto.getGlobalUserCode());
//        powerConditionDto.setTableName(PowerConstants.PRPDCOMPANY);
//        powerConditionDto.setOuterTableName("c");
//        String powerSql = powerService.getPowerCompanyCondition(powerConditionDto);
//        queryDto.setPowerCondition(powerSql);
        //分页查询
        PageInfo<PrpDCompanyDto> pageInfo = queryPageInfoByCondition(queryDto);

        return pageInfo;

    }

    /**
     * @param queryDto
     * @return
     * @description 机构分页查询
     * @author hzhongkai
     * @date 2016年10月22日上午9:53:17
     */
    private PageInfo<PrpDCompanyDto> queryPageInfoByCondition(CompanyConditionDto queryDto) {
        // 设置排序
        if (StringUtils.isEmpty(queryDto.getOrderByClause())) {
            queryDto.setOrderByClause("c.comcode asc");
        } else {
            String orderBy = queryDto.getOrderByClause();
            String[] arr = orderBy.split(",");
            for (int i = 0; i < arr.length; i++) {
                orderBy += "c." + arr[i];
                if (i == arr.length - 1) {

                } else {
                    orderBy += ",";
                }
            }
            queryDto.setOrderByClause(orderBy);
        }
        Pageable page = new PageRequest(queryDto.getPageNo(),queryDto.getPageSize());
        Page<PrpDCompany> list = prpDCompanyDao.findAll(genCondition(queryDto),page);

        PageInfo<PrpDCompanyDto> pageInfo = new PageInfo<>();
        List<PrpDCompanyDto> prpDCompanyDtos = new ArrayList<>(list.getSize());
        convertCollection(list.getContent(), prpDCompanyDtos, PrpDCompanyDto.class);
        pageInfo.setContent(prpDCompanyDtos);
        pageInfo.setTotalCount(list.getTotalElements());
        pageInfo.setPages(list.getTotalPages());
        return pageInfo;
    }

    private Specification<PrpDCompany> genfuzzyCondition(PrpDCompanyDto condition) {
        return Specifications.<PrpDCompany>and()
                .eq(StringUtils.isNotEmpty(condition.getUpperComCode()), "upperComCode", condition.getUpperComCode())
                .eq(StringUtils.isNotEmpty(condition.getComCode()), "comCode", condition.getComCode())
                .eq(StringUtils.isNotEmpty(condition.getComType()), "comType", condition.getComType())
                .eq(StringUtils.isNotEmpty(condition.getValidStatus()), "validStatus", condition.getValidStatus())
                .build();
    }
}
