package com.sinosoft.dms.web.customer;

import com.sinosoft.dms.api.customer.PrpDcustomerIdvApi;
import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.dms.core.customer.service.PrpDcustomerIdvService;
import com.sinosoft.dms.core.customer.service.PrpDcustomerUnitService;
import com.sinosoft.ims.api.kernel.UserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-09 11:34:12.554 
 * @description 个人客户代码表controller层
 */
@RestController
@RequestMapping(value = PrpDcustomerIdvController.PATH)
public class PrpDcustomerIdvController implements PrpDcustomerIdvApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDcustomerIdvController.class);
    @Resource
    private PrpDcustomerIdvService prpDcustomerIdvService;
    @Resource
    private PrpDcustomerUnitService prpDcustomerUnitService;
    @Resource
    private UserApi userApi;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpDcustomerIdvDto prpDcustomerIdvDto) {
        prpDcustomerIdvService.save(prpDcustomerIdvDto);
    }
    /**
     * 保存个体客户信息
     * @author: 田健
     * @date: 2017/12/28 11:01
     * @param prpDcustomerIdvDtos 个体客户信息集合
     * @Return 返回成功
     */
    @Override
    public String saveByList(@RequestBody List<PrpDcustomerIdvDto> prpDcustomerIdvDtos) {
        prpDcustomerIdvService.saveByList(prpDcustomerIdvDtos);
        return "Success";
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestParam("customercode") String customercode) {
        prpDcustomerIdvService.remove(customercode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDcustomerIdvDto prpDcustomerIdvDto) {
        prpDcustomerIdvService.modify(prpDcustomerIdvDto);
    }
    /**
     * @description:（查询个人客户风险等级信息）
     * @author: 董坤
     * @date: 2017/10/16 8:33
     * @param requestDto
     * @return List<PrpDCustomerIdvDto>
     */
    @Override
    public List<ResponseCustomerRiskLevelDto> queryRiskLevelByCondition(@RequestBody RequestDto requestDto) throws Exception{
        return prpDcustomerIdvService.queryRiskLevelByCondition(requestDto);
    }

    @Override
    public String saveByCondition(RequestSaveDto requestSaveDto) throws Exception {
        return null;
    }
    /**
     * （查询个人客户风险等级信息）
     * @author: 赵鹏
     * @date: 2017/12/16 13:42
     * @param requestDto RequestUnitAndldvDto（查询的条件客户代码，身份证件类型，身份证件类型）
     * @return List<ResponseCustomerRiskLevelDto>（客户列表信息）
     * @throws Exception
     */
    @Override
    public List<ResponseCustomerRiskLevelDto> queryAllUnitAndIdv(@RequestBody RequestUnitAndldvDto requestDto) throws Exception {
        return prpDcustomerIdvService.queryAllUnitAndIdv(requestDto);
    }
    /**
     * （修改保存客户风险等级数据）
     * @author: 赵鹏
     * @date:  2017/12/16 13:35
     * @param PrpDcustomerIdv （要更新或保存的参数）
     * @return Map<String ,String >返回操作码，操作信息
     * @throws Exception
     */
    @Override
    public Map<String,String> saveByCustomerRiskLevel(@RequestBody PrpDcustomerIdvAndUnitDto PrpDcustomerIdv) throws Exception {
        return prpDcustomerIdvService.saveByCustomerRiskLevel(PrpDcustomerIdv);
    }
    /**
     * （根据客户代码查询个体和团体对象）
     * @author: 赵鹏
     * @date: 2017/12/16 16:07
     * @param map
     * @return  PrpDcustomerIdvDto （如果是个体直接返回，如果是团体转换为PrpDcustomerIdvDto对象返回）
     */
    @Override
    public PrpDcustomerIdvAndUnitDto queryByPK(@RequestBody Map<String, String> map) {
        String customerType = map.get("customerType");
        String customerCode = map.get("customerCode");
        PrpDcustomerIdvAndUnitDto prpDcustomerIdvAndUnitDto=new PrpDcustomerIdvAndUnitDto();
        PrpDcustomerUnitDto requestSaveDto= new PrpDcustomerUnitDto();
        PrpDcustomerIdvDto prpDCustomerIdvSaveDto =new PrpDcustomerIdvDto();
        PrpDuserDto PrpDuserDto=new PrpDuserDto();
        if("1".equals(customerType)){
            prpDCustomerIdvSaveDto=prpDcustomerIdvService.queryByPK(customerCode);
            PrpDuserDto= userApi.queryUserInfo(prpDCustomerIdvSaveDto.getOperatorCode());
            prpDcustomerIdvAndUnitDto.setCustomerCode(prpDCustomerIdvSaveDto.getCustomerCode());//客户代码
            prpDcustomerIdvAndUnitDto.setAddressCName(prpDCustomerIdvSaveDto.getAddressCName());//客户地址
            prpDcustomerIdvAndUnitDto.setPostCode(prpDCustomerIdvSaveDto.getPostCode());//邮编
            prpDcustomerIdvAndUnitDto.setCustomerCName(prpDCustomerIdvSaveDto.getCustomerCName());//客户名称
            prpDcustomerIdvAndUnitDto.setNewCustomerCode(prpDCustomerIdvSaveDto.getNewCustomerCode());//客户新代码
            prpDcustomerIdvAndUnitDto.setValidStatus(prpDCustomerIdvSaveDto.getValidStatus());//状态
            prpDcustomerIdvAndUnitDto.setIdentifyType(prpDCustomerIdvSaveDto.getIdentifyType());//证件类型
            prpDcustomerIdvAndUnitDto.setCustomerKind(prpDCustomerIdvSaveDto.getCustomerKind());//客户类型
            prpDcustomerIdvAndUnitDto.setRiskLevel(prpDCustomerIdvSaveDto.getRiskLevel());//风险等级
            prpDcustomerIdvAndUnitDto.setOperatorCode(prpDCustomerIdvSaveDto.getOperatorCode());//操作者代码
            prpDcustomerIdvAndUnitDto.setInputDate(prpDCustomerIdvSaveDto.getInputDate());//输入日期
            prpDcustomerIdvAndUnitDto.setUpdaterCode(prpDCustomerIdvSaveDto.getOperatorCode());//修改人
            prpDcustomerIdvAndUnitDto.setUserName(PrpDuserDto.getUserName());//修改人姓名
            prpDcustomerIdvAndUnitDto.setUpdate_Date(prpDCustomerIdvSaveDto.getUpdateDate());//修改日期
            prpDcustomerIdvAndUnitDto.setComCode(prpDCustomerIdvSaveDto.getComCode());//归属机构代码
            prpDcustomerIdvAndUnitDto.setLinkAddress(prpDCustomerIdvSaveDto.getLinkAddress());//通讯地址
            prpDcustomerIdvAndUnitDto.setCustomerCName(prpDCustomerIdvSaveDto.getCustomerCName());//客户简称
            prpDcustomerIdvAndUnitDto.setPhoneNumber(prpDCustomerIdvSaveDto.getPhoneNumber());//电话
            prpDcustomerIdvAndUnitDto.setValidPeriod3(prpDCustomerIdvSaveDto.getValidPeriod3());//证件有效日期
            prpDcustomerIdvAndUnitDto.setIsCareClaim(prpDCustomerIdvSaveDto.getIsCareClaim());//客户是否关注审计、理赔、退保信息
            prpDcustomerIdvAndUnitDto.setCashFocus(prpDCustomerIdvSaveDto.getCashFocus());//现金密度
            prpDcustomerIdvAndUnitDto.setIdentifyNumber(prpDCustomerIdvSaveDto.getIdentifyNumber());//证件号码
            prpDcustomerIdvAndUnitDto.setNationality(prpDCustomerIdvSaveDto.getNationality());//国籍
            prpDcustomerIdvAndUnitDto.setJobTitle(prpDCustomerIdvSaveDto.getJobTitle());//职业名称
            prpDcustomerIdvAndUnitDto.setSex(prpDCustomerIdvSaveDto.getSex());//性别
        }else{
            requestSaveDto=  prpDcustomerUnitService.queryByPK(customerCode);
            PrpDuserDto= userApi.queryUserInfo(requestSaveDto.getOperatorCode());
            prpDcustomerIdvAndUnitDto.setCustomerCode(requestSaveDto.getCustomerCode());//客户代码
            prpDcustomerIdvAndUnitDto.setAddressCName(requestSaveDto.getAddressCName());//客户地址
            prpDcustomerIdvAndUnitDto.setPostCode(requestSaveDto.getPostCode());//邮编
            prpDcustomerIdvAndUnitDto.setCustomerKind(requestSaveDto.getCustomerKind());//客户类型
            prpDcustomerIdvAndUnitDto.setCustomerCName(requestSaveDto.getCustomerCName());//客户名称
            prpDcustomerIdvAndUnitDto.setNewCustomerCode(requestSaveDto.getNewCustomerCode());//客户新代码
            prpDcustomerIdvAndUnitDto.setValidStatus(requestSaveDto.getValidStatus());//状态
            prpDcustomerIdvAndUnitDto.setIdentifyType(requestSaveDto.getIdentifyType());//证件类型
            prpDcustomerIdvAndUnitDto.setRiskLevel(requestSaveDto.getRiskLevel());//风险等级
            prpDcustomerIdvAndUnitDto.setOperatorCode(requestSaveDto.getOperatorCode());//操作者代码
            prpDcustomerIdvAndUnitDto.setInputDate(requestSaveDto.getInputDate());//输入日期
            prpDcustomerIdvAndUnitDto.setUpdaterCode(requestSaveDto.getOperatorCode());//修改人
            prpDcustomerIdvAndUnitDto.setUserName(PrpDuserDto.getUserName());//修改人姓名
            prpDcustomerIdvAndUnitDto.setUpdate_Date(requestSaveDto.getUpdateDate());//修改日期
            prpDcustomerIdvAndUnitDto.setComCode(requestSaveDto.getComCode());//归属机构代码
            prpDcustomerIdvAndUnitDto.setLinkAddress(requestSaveDto.getPostAddress());//通讯地址
            prpDcustomerIdvAndUnitDto.setCustomerCName(requestSaveDto.getCustomerCName());//客户简称
            prpDcustomerIdvAndUnitDto.setPhoneNumber(requestSaveDto.getPhoneNumber());//电话
            prpDcustomerIdvAndUnitDto.setValidPeriod3(requestSaveDto.getIdentifyValidPeriod());//证件有效日期
            prpDcustomerIdvAndUnitDto.setIsCareClaim(requestSaveDto.getIsCareClaim());//客户是否关注审计、理赔、退保信息
            prpDcustomerIdvAndUnitDto.setCashFocus(requestSaveDto.getCashFocus());//行业现金密度
            prpDcustomerIdvAndUnitDto.setBusinessLicenceNo(requestSaveDto.getBusinessLicenceNo());//营业执照
            prpDcustomerIdvAndUnitDto.setRevenuePeriod(requestSaveDto.getRevenuePeriod());//税务登记有效期
            prpDcustomerIdvAndUnitDto.setBusinessLicenceValidPeriod(requestSaveDto.getBusinessLicenceValidPeriod());//工商营业执照登记号有效期
            prpDcustomerIdvAndUnitDto.setRevenueCode(requestSaveDto.getRevenueCode());//税务登记证
            prpDcustomerIdvAndUnitDto.setOtherCodeNo(requestSaveDto.getOtherCodeNo());//其他证件号码
            prpDcustomerIdvAndUnitDto.setOtherCodeValidPeriod(requestSaveDto.getOtherCodeValidPeriod());//其他证件有效日期
            prpDcustomerIdvAndUnitDto.setComType(requestSaveDto.getComType());//公司性质
            prpDcustomerIdvAndUnitDto.setOrganizeCode(requestSaveDto.getOrganizeCode());//法人机构代码
        }
        return prpDcustomerIdvAndUnitDto;
    }

    /**
     * 根据证件类型和证件号去基础表中查询是否有该大户的信息
     * @param map  key:"identifyType","identifyNumber"
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 2017/12/1 17:39
     */
    @Override
    public List<PrpDcustomerIdvDto> queryPrpDcustomerByIndentity(@RequestBody Map<String, String> map) throws Exception {
        return prpDcustomerIdvService.queryPrpDcustomerByIndentity(map.get("identifyType"),map.get("identifyNumber"));
    }

}
