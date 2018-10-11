package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.QueryCommonEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryCommonEndorseService;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCinsuredDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCinsured;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainKey;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description （普通批单查询服务层接口实现类）
 * @author 王保良
 * @date 2017年11月1日
 */
@Service
public class QueryCommonEndorseServiceImpl extends BaseServiceImpl implements QueryCommonEndorseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShowPrPoEnServiceImpl.class);


    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpCinsuredDao prpCinsuredDao;
    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;//新农险标识

    /**
     * 根据保单号查询出其批改申请人(一般就是投保人)以及批改申请日期(用起保日期startDate和批改生效日期validDate对比返回的结果）
     * @param policyNo 保单号
     * @return 返回投保人以及批改生效日期和起保日期比较的结果
     * @author 王保良
     * @date 2017年10月28日
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public QueryCommonEndorseDto queryCommonEndorse(String policyNo, String validDate) throws Exception {
        policyNo=policyNo.trim();
        if (StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空");
        }
        if (policyNo.length() != 21 && policyNo.length() != 19){
            int i=policyNo.length();
            throw new DataVerifyException("保单号不对");
        }
        if (validDate == null){
            throw new DataVerifyException("批改生效日期不能为空");
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date validDate1=simpleDateFormat.parse(validDate);
//        insuredName是批改申请人(一般是投保人)
        String insuredName="";
        int intCompareResult=0;
//        message中放置转换为字符串后的日期()
        String message="";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        PrpCmainKey prpCmainKey=new PrpCmainKey(policyNo);
        PrpCmain prpCmain=prpCmainDao.findOne(prpCmainKey);

//        其实这个循环没什么意义,因为根据这个两个参数能查出来的就应该只有一条数据
//        只不过Dao层他们定的返回值就是List,所以循环了只有个一PrpCinsured的list
        List<PrpCinsured> prpCinsuredList=prpCinsuredDao.findByPolicyNoAndInsuredFlag(policyNo,"2");
        if (prpCmain == null){
            throw new BusinessException("保单号"+policyNo+"经查询后不存在");
        }else if(StringUtils.isEmpty(prpCmain.getSystemFlag()) || !systemFlag.equals(prpCmain.getSystemFlag())){
            throw new BusinessException("保单号"+policyNo+"非新系统保单");
        }else {
            for (PrpCinsured prpCinsured:prpCinsuredList){
                insuredName=prpCinsured.getInsuredName();
            }
        }

//        如果批改生效日期在起保日期之前,则返回保单起保日期
        Date startDate=prpCmain.getStartDate();
        if (validDate1.before(startDate)){
            message=sdf.format(startDate);
        }else {
            message=sdf.format(validDate1);
        }

//        QueryCommonEndorseDto是封装的对象,包括批改申请人(一般是投保人)和message(批改生效日期和起保日期比较的结果)
        QueryCommonEndorseDto queryCommonEndorseDto=new QueryCommonEndorseDto();
        queryCommonEndorseDto.setInsuredName(insuredName);
        queryCommonEndorseDto.setMessage(message);
        queryCommonEndorseDto.setPrintNo(prpCmain.getPrintNo());
        return queryCommonEndorseDto;
    }
}
