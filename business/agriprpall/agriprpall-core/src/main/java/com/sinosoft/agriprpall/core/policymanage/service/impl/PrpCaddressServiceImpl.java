package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPaddressDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPaddressDto;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTaddressDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCaddressDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.dao.specification.PrpAddressSpecBuilder;
import com.sinosoft.agriprpall.core.policymanage.entity.*;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCaddressService;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTaddressDao;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTaddress;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmain;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainKey;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
* 保单保险地址表Core接口实现
* @Author: 宋振振
* @Date: 9:00 2017/10/17
*/
@Service
public class PrpCaddressServiceImpl extends BaseServiceImpl implements PrpCaddressService {
   /** log日志 */
   private static final Logger LOGGER = LoggerFactory.getLogger(PrpCaddressServiceImpl.class);

   @Autowired
   private PrpCaddressDao prpCaddressDao;
   @Autowired
   private PrpTaddressDao prpTaddressDao;
   @Autowired
   private PrpCmainDao prpCMainDao;
   @Autowired
   private PrpTmainDao prpTmainDao;
    /**
     *@description 新增
     *@param
     */
    public void save(PrpCaddressDto prpCaddressDto) {
        PrpCaddress prpCaddress = this.convert(prpCaddressDto, PrpCaddress.class);
        prpCaddressDao.save(prpCaddress);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String policyNo,java.lang.Integer addressNo) {
        PrpCaddressKey prpCaddressKey = new PrpCaddressKey(policyNo,addressNo);
        prpCaddressDao.delete(prpCaddressKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpCaddressDto prpCaddressDto) {
        PrpCaddress prpCaddress = this.convert(prpCaddressDto, PrpCaddress.class);
        prpCaddressDao.save(prpCaddress);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpCaddressDto queryByPK(String policyNo,java.lang.Integer addressNo) {
        PrpCaddressKey prpCaddressKey = new PrpCaddressKey(policyNo,addressNo);
        PrpCaddress prpCaddress = prpCaddressDao.findOne(prpCaddressKey);
        return this.convert(prpCaddress,PrpCaddressDto.class);
    }
   /**
     * 根据投保单号或保单号查询标的地址打印信息
     * @author: 宋振振
     * @date: 2017/10/17 9:00
     * @param bizType 保单类型（PROPOSAL或POLICY）
     * @param bizNo 数据号（投保单号或保单号）
     * @return PrpAddressRespDto 返回标的地址打印信息
     * @throws Exception
     */
   public PrpAddressRespDto queryPrpaddressPrintByCondition( String bizType,  String bizNo) throws Exception{
       PrpAddressRespDto prpAddressRespDto=new PrpAddressRespDto();
       String  signDate = "";
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       if(StringUtils.isEmpty(bizType)){
           throw new DataVerifyException("保单类型（PROPOSAL或POLICY）不能为空！");
       }
       if(StringUtils.isEmpty(bizNo)){
           throw new DataVerifyException("数据号（投保单号或保单号）不能为空！");
       }
        //根据PROPOSAL或POLICY查询投保单保险地址表或保单保险地址表
       if((AgriPrpallConstant.AGRI_PRPALL_SERVICE_PROPOSAL).equals(bizType))
       {
           List<PrpTaddress> prpTaddressList=prpTaddressDao.findAll(PrpAddressSpecBuilder.prpTaddressSpecification(bizNo));
           convertCollection(prpTaddressList,prpAddressRespDto.getPrpTaddressDtoList(), PrpTaddressDto.class);
           //查询签单日期
           PrpTmain prpTmain=prpTmainDao.findOne(new PrpTmainKey(bizNo));
           PrpTmainDto prpTmainDto=convert(prpTmain,PrpTmainDto.class);
           if(prpTmainDto!=null){
               signDate = formatter.format(prpTmainDto.getOperateDate());
           }
       }else if(AgriPrpallConstant.AGRI_PRPALL_SERVICE_POLICY.equals(bizType)){
           List<PrpCaddress> prpCaddressList = prpCaddressDao.findAll(PrpAddressSpecBuilder.prpCaddressSpecification(bizNo));
           convertCollection(prpCaddressList,prpAddressRespDto.getPrpCaddressDtoList(),PrpCaddressDto.class);
           //查询签单日期
           PrpCmain prpCMain=prpCMainDao.findOne(new PrpCmainKey(bizNo));
           PrpCmainDto prpCmainDto=convert(prpCMain,PrpCmainDto.class);
           if(prpCmainDto!=null) {
               signDate = formatter.format(prpCmainDto.getOperateDate());
           }
       }

       prpAddressRespDto.setPolicyNo(bizNo);
       prpAddressRespDto.setSignDate(signDate);
       return prpAddressRespDto;
   }

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPaddressDto
     * @return prpCaddressDto
     * @throws Exception
     */
    @Override
    public PrpCaddressDto PEvaluateC(PrpPaddressDto prpPaddressDto) throws Exception {
       PrpCaddressDto prpCaddressDto=new PrpCaddressDto();
        prpCaddressDto.setPolicyNo (prpPaddressDto.getPolicyNo());
        prpCaddressDto.setRiskCode (prpPaddressDto.getRiskCode());
        prpCaddressDto.setAddressNo(prpPaddressDto.getAddressNo());
        prpCaddressDto.setAddressCode(prpPaddressDto.getAddressCode());
        prpCaddressDto.setAddressName(prpPaddressDto.getAddressName());
        prpCaddressDto.setFlag(prpPaddressDto.getFlag());
        prpCaddressDto.setProjectName(prpPaddressDto.getProjectName());
        return prpCaddressDto;
    }


    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPaddressDto
     * @return PrpCaddressDto
     * @throws Exception
     */
    public PrpCaddressDto generatePrpCaddress(PrpCPaddressDto prpCPaddressDto) throws Exception{
        PrpCaddressDto prpCaddressDto=new PrpCaddressDto();
        prpCaddressDto.setPolicyNo(prpCPaddressDto.getPolicyNo());
        prpCaddressDto.setRiskCode(prpCPaddressDto.getRiskCode());
        prpCaddressDto.setAddressNo(prpCPaddressDto.getAddressNo());
        prpCaddressDto.setAddressCode(prpCPaddressDto.getAddressCode());
        prpCaddressDto.setAddressName(prpCPaddressDto.getAddressName());
        prpCaddressDto.setFlag(prpCPaddressDto.getFlag());
        prpCaddressDto.setProjectName(prpCPaddressDto.getProjectName());
        return prpCaddressDto;
        
    }
}