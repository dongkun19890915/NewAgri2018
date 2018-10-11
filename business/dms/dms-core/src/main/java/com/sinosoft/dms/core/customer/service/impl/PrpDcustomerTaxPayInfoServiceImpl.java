package com.sinosoft.dms.core.customer.service.impl;

import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.dms.core.customer.dao.PrpDcustomerIdvDao;
import com.sinosoft.dms.core.customer.dao.PrpDcustomerTaxPayInfoDao;
import com.sinosoft.dms.core.customer.dao.PrpDcustomerUnitDao;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerTaxPayInfo;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerTaxPayInfoKey;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerIdv;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerUnit;
import com.sinosoft.dms.core.customer.service.PrpDcustomerTaxPayInfoService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 客户纳税人信息表Core接口实现
 * @Author: 宋振振
 * @Date: 21:15 2017/10/17
 */
@Service
public class PrpDcustomerTaxPayInfoServiceImpl extends BaseServiceImpl implements PrpDcustomerTaxPayInfoService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDcustomerTaxPayInfoServiceImpl.class);
    
    @Autowired
    private PrpDcustomerTaxPayInfoDao prpDcustomerTaxPayInfoDao;
    @Autowired
    private PrpDcustomerIdvDao prpDcustomerIdvDao;
    @Autowired
    private PrpDcustomerUnitDao prpDcustomerUnitDao;
    /**
     *  保存发票信息
     * @author: 田健
     * @date: 2017/12/28 11:28
     * @param prpDcustomerTaxPayInfoDto 发票信息dto
     */
    @Override
    public void save(PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto) {
        PrpDcustomerTaxPayInfo prpDcustomerTaxPayInfo = this.convert(prpDcustomerTaxPayInfoDto, PrpDcustomerTaxPayInfo.class);
        prpDcustomerTaxPayInfoDao.save(prpDcustomerTaxPayInfo);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String customerCode) {
        PrpDcustomerTaxPayInfoKey prpDCustomerTaxPayInfoKey = new PrpDcustomerTaxPayInfoKey(customerCode);
        prpDcustomerTaxPayInfoDao.delete(prpDCustomerTaxPayInfoKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDcustomerTaxPayInfoDto prpDCustomerTaxPayInfoDto) {
        PrpDcustomerTaxPayInfo prpDcustomerTaxPayInfo = this.convert(prpDCustomerTaxPayInfoDto, PrpDcustomerTaxPayInfo.class);
        prpDcustomerTaxPayInfoDao.save(prpDcustomerTaxPayInfo);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpDcustomerTaxPayInfoDto queryByPK(String customerCode) {
        PrpDcustomerTaxPayInfoKey prpDCustomerTaxPayInfoKey = new PrpDcustomerTaxPayInfoKey(customerCode);
        PrpDcustomerTaxPayInfo prpDcustomerTaxPayInfo = prpDcustomerTaxPayInfoDao.findOne(prpDCustomerTaxPayInfoKey);
        return this.convert(prpDcustomerTaxPayInfo,PrpDcustomerTaxPayInfoDto.class);
    }
    /**
     * 根据条件查询发票购货方信息
     * @author: 宋振振
     * @date: 2017/10/17 21:15
     * @param prpDcustomerRequestDto 查询发票购货方请求参数的Dto
     * @return PrpDcustomerResponseDto 返回客户信息
     * @throws Exception
     */
    public PrpDcustomerResponseDto queryPayInfo(PrpDcustomerRequestDto prpDcustomerRequestDto) {
        if(prpDcustomerRequestDto==null)
        {
            throw new DataVerifyException("发票购货方请求参数的prpDcustomerRequestDto不能为null！");
        }
        String strFlag =prpDcustomerRequestDto.getFlag();
        String strCustomerType=prpDcustomerRequestDto.getCustomerType();
        int intCustomerCount = 0;
        PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto=null;
        PrpDcustomerResponseDto prpDcustomerResponseDto=new PrpDcustomerResponseDto();
        if ("c01".equals(strFlag.trim())) {//查询客户总数
            if (("1").equals(strCustomerType.trim())) {//客户类型，1代表自然人，2代表法人
                List<PrpDcustomerIdv> prpDcustomerIdvList= prpDcustomerIdvDao.findPrpDcustomerIdvByCustomerCName(prpDcustomerRequestDto.getPrpDcustomerIdvCustomerCName());
                intCustomerCount = prpDcustomerIdvList.size();
            } else {
                List<PrpDcustomerUnit> prpDcustomerUnitList = prpDcustomerUnitDao.findPrpDcustomerUnitByCustomerCName(prpDcustomerRequestDto.getPrpDcustomerUnitCustomerCName());
                intCustomerCount = prpDcustomerUnitList.size();
            }
            prpDcustomerResponseDto.setCustomerCount(intCustomerCount);
        } else if ("c02".equals(strFlag.trim())) {
            //根据customerCode查询发票购货方信息
            PrpDcustomerTaxPayInfo prpDcustomerTaxPayInfo = prpDcustomerTaxPayInfoDao.findPrpDCustomerTaxPayInfoByCustomerCode(prpDcustomerRequestDto.getCustomerCode());
            prpDcustomerTaxPayInfoDto = convert(prpDcustomerTaxPayInfo, PrpDcustomerTaxPayInfoDto.class);

            if (prpDcustomerTaxPayInfoDto == null) {
                throw new DataVerifyException("没查询到纳税人信息");
            }
            //查询个体或集体的信息并且根据1-自然人或2-法人查询邮编
            if ("1".equals(prpDcustomerTaxPayInfoDto.getCustomerType())) {
                PrpDcustomerIdv prpDcustomerIdv = prpDcustomerIdvDao.findPrpDcustomerIdvByCustomerCode(prpDcustomerTaxPayInfoDto.getCustomerCode());
                PrpDcustomerIdvDto prpDcustomerIdvDto = convert(prpDcustomerIdv, PrpDcustomerIdvDto.class);
                if (prpDcustomerIdvDto != null) {
                    prpDcustomerTaxPayInfoDto.setPostCode(prpDcustomerIdvDto.getPostCode());
                }
                prpDcustomerResponseDto.setPrpDcustomerIdvDto(prpDcustomerIdvDto);
            } else if ("2".equals(prpDcustomerTaxPayInfoDto.getCustomerType())) {
                PrpDcustomerUnit prpDcustomerUnit = prpDcustomerUnitDao.findPrpDcustomerIdvByCustomerCode(prpDcustomerTaxPayInfoDto.getCustomerCode());
                PrpDcustomerUnitDto prpDcustomerUnitDto = convert(prpDcustomerUnit, PrpDcustomerUnitDto.class);
                if (prpDcustomerUnit != null) {
                    prpDcustomerTaxPayInfoDto.setPostCode(prpDcustomerUnitDto.getPostCode());
                }
                prpDcustomerResponseDto.setPrpDcustomerUnitDto(prpDcustomerUnitDto);
            }
            prpDcustomerResponseDto.setPrpDcustomerTaxPayInfoDto(prpDcustomerTaxPayInfoDto);
        }

        return prpDcustomerResponseDto;
    }
}