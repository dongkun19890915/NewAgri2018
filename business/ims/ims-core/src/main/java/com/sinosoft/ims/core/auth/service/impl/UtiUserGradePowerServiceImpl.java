package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.ims.api.auth.dto.UtiUserGradePowerDto;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.UserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.core.auth.dao.UtiUserGradePowerDao;
import com.sinosoft.ims.core.auth.entity.UtiUserGradePower;
import com.sinosoft.ims.core.auth.entity.UtiUserGradePowerKey;
import com.sinosoft.ims.core.auth.service.UtiUserGradePowerService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 机构员工岗位业务权限表Core接口实现
 */
@Service
public class UtiUserGradePowerServiceImpl extends BaseServiceImpl implements UtiUserGradePowerService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUserGradePowerServiceImpl.class);
    
    @Autowired
    private UtiUserGradePowerDao utiUserGradePowerDao;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private EntityManager entityManager;
    /**
     *@description 新增
     *@param
     */
    public void save(UtiUserGradePowerDto utiUserGradePowerDto) {
        UtiUserGradePower utiUserGradePower = this.convert(utiUserGradePowerDto, UtiUserGradePower.class);
        utiUserGradePowerDao.save(utiUserGradePower);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String comCode,String userCode,String gradeCode,Integer serialNo) {
        UtiUserGradePowerKey utiUserGradePowerKey = new UtiUserGradePowerKey(comCode,userCode,gradeCode,serialNo);
        utiUserGradePowerDao.delete(utiUserGradePowerKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiUserGradePowerDto utiUserGradePowerDto) {
        UtiUserGradePower utiUserGradePower = this.convert(utiUserGradePowerDto, UtiUserGradePower.class);
        utiUserGradePowerDao.save(utiUserGradePower);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUserGradePowerDto queryByPK(String comCode,String userCode,String gradeCode,Integer serialNo) {
        UtiUserGradePowerKey utiUserGradePowerKey = new UtiUserGradePowerKey(comCode,userCode,gradeCode,serialNo);
        UtiUserGradePower utiUserGradePower = utiUserGradePowerDao.findOne(utiUserGradePowerKey);
        return this.convert(utiUserGradePower,UtiUserGradePowerDto.class);
    }

    /**
     * 根据comCode、userCode、gradeCode查询UtiUserGradePower表信息
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @return UtiUserGradePowerDto集合
     * @throws Exception
     */
    @Override
    public List<UtiUserGradePowerDto> queryAllByCondition(String comCode, String userCode) throws Exception {
        List<UtiUserGradePower> utiUserGradePowerList = utiUserGradePowerDao.findAllByCondition(comCode,userCode);
        List<UtiUserGradePowerDto> utiUserGradePowerDtoList = new ArrayList<>();
        convertCollection(utiUserGradePowerList,utiUserGradePowerDtoList,UtiUserGradePowerDto.class);
        return utiUserGradePowerDtoList;
    }
    /**
     * 业务员特殊批改查询所属机构的业务员
     * @author: 宋振振
     * @date: 2018/3/17 17:22
     * @param comCode
     * @param policyNos
     * @return 业务员名称和代码
     * @throws Exception
     */
    public List<PrpDuserDto> queryUserCode(String comCode, List<String> policyNos)throws Exception{
        List<String> uselist=new ArrayList<>();
        StringBuilder sql=new StringBuilder("SELECT p FROM UtiUserGradePower p WHERE p.comCode = :comCode and p.userCode in (select a.userCode from UtiUserGrade a where a.gradeCode = '111')");
        Query dataResult=entityManager.createQuery(sql.toString());
        dataResult.setParameter("comCode",comCode);
        List<UtiUserGradePower> utiUserGradePowerList=dataResult.getResultList();
        for (UtiUserGradePower utiUserGradePower:utiUserGradePowerList){
            String riskCode="";
            for(int i=0;i<policyNos.size();i++){
                riskCode=policyNos.get(i).substring(1,5);
                if(utiUserGradePower.getPermitRiskCode().equals("*")||utiUserGradePower.getPermitRiskCode().indexOf(riskCode)>0){
                    uselist.add(utiUserGradePower.getUserCode());
                }
            }
        }
        List<PrpDuserDto> prpDuserDtoList=prpDuserApi.queryByUserCodeList(uselist);
        return prpDuserDtoList;
    }
}