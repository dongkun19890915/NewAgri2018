package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPheadService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class PrpPheadServiceImpl extends BaseServiceImpl implements PrpPheadService {
    @Autowired
    private PrpPheadDao prpPheadDao;

    @PersistenceContext
    private EntityManager entityManager;
    public String queryEndorseNo(String strWhere) throws Exception{
        StringBuilder builder=new StringBuilder();
        builder.append(" select endorseNo from prpphead ");
        builder.append( strWhere );
        Query query=entityManager.createNativeQuery(builder.toString());
        List<Object> objectList=query.getResultList();
        String billno=null;
        if(objectList!=null && objectList.size()>0){
            billno=objectList.get(0).toString();
        }
        return billno;
    }

    public  Integer queryMaxEndorseNo(String strWhere) throws Exception{
        StringBuilder builder=new StringBuilder();
        builder.append(" select Max(length(endorseNo))  from prpphead ");
        builder.append( strWhere );
        Query query=entityManager.createNativeQuery(builder.toString());
        Integer intEndorsenoMaxLength=null;
         intEndorsenoMaxLength=query.getFirstResult();
         return intEndorsenoMaxLength;
    }
    /**
    * 通过主键查询PrpPhead对象的实现方法
    * @param policyNo   保单号
    * @return PrpPheadDto
    * @throws Exception
    * @author 李冬松
    * @date 16:47 2017/11/23
    */
    @Override
    public List<PrpPheadDto> queryAllByPolicyNo(String policyNo) throws Exception {
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号为空！");
        }
        List<PrpPhead> prpPheadList=prpPheadDao.queryAllByByPolicyNo(policyNo);
        List<PrpPheadDto> prpPheadDtoList=new ArrayList<>();
        convertCollection(prpPheadList,prpPheadDtoList,PrpPheadDto.class);
        return prpPheadDtoList;
    }
    /**
    * 通过保单号，出险小时，出险日期查询批单头表信息，返回List
    * @param policyNo,保单号
     * @param validDate,出险日期
     * @param validHour，出险小时
    * @return java.util.List<com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto>
    * @throws Exception
    * @author 李冬松
    * @date 17:10 2017/12/15
    */
    @Override
    public List<PrpPheadDto> queryByPolicyNoAndDamagerDate(String policyNo, String validDate, String  validHour) throws Exception {
        if(StringUtils.isEmpty(policyNo)||validDate==null||validHour==null){
            throw new DataVerifyException("入参不能为空！");
        }
        if(!validHour.matches("^\\d*$")){
            throw new DataVerifyException("小时不合法！");
        }
        Date date;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try{
            date=sdf.parse(validDate);
        }catch (Exception e){
            throw new DataVerifyException("出险日期不规范！");
        }
        int hour=Integer.parseInt(validHour);
        if(hour>24){
            throw new DataVerifyException("小时不合法！");
        }
        List<PrpPhead> prpPheadList=prpPheadDao.queryByPolicyNoAndDamagerDate(policyNo,date,hour);
        List<PrpPheadDto> prpPheadDtoList=new ArrayList<>();
        convertCollection(prpPheadList,prpPheadDtoList,PrpPheadDto.class);
        return prpPheadDtoList;
    }

    /**
     * 根据policyNo和时间条件查询PrpPheadDto集合
     * @author: 刘曼曼
     * @date: 2017/12/23 14:34
     * @param policyNo 保单号
     * @param damageDate 生效日期
     * @param damageHour 生效小时
     * @return List<PrpPheadDto>批单表集合
     * @throws Exception
     */
    @Override
    public List<PrpPheadDto> queryPrpPheadDtoByNoANDTime(String policyNo, String damageDate, String damageHour) throws Exception {
        if(StringUtils.isEmpty(policyNo)||StringUtils.isEmpty(damageDate)|| StringUtils.isEmpty(damageHour)){
            throw new DataVerifyException("入参不能为空！");
        }
        if(!damageHour.matches("^\\d*$")){
            throw new DataVerifyException("小时不合法！");
        }
        Date date;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try{
            date=sdf.parse(damageDate);
        }catch (Exception e){
            throw new DataVerifyException("生效日期不规范！");
        }

        int hour=Integer.parseInt(damageHour);
        if(hour>24){
            throw new DataVerifyException("小时不合法！");
        }
        List<PrpPhead> prpPheadList=prpPheadDao.queryPrpPheadDtoByNoANDTime(policyNo,date,hour);
        List<PrpPheadDto> prpPheadDtoList=new ArrayList<>();
        convertCollection(prpPheadList,prpPheadDtoList,PrpPheadDto.class);
        return prpPheadDtoList;
    }

    /**
     * （通过保单号查询批单信息）
     * @author: 王志文
     * @date: 2017/11/16 17:30
     * @param policyNo
     * @return
     */
    @Override
    public List<PrpPheadDto> queryByPolicyNo(String policyNo) {
        List<PrpPhead> prpPheads = prpPheadDao.queryPrpPheadByPolicyNo(policyNo);
        List<PrpPheadDto> prpPheadDtoList = new ArrayList<PrpPheadDto>();
        for (PrpPhead prp: prpPheads
                ) {
            prpPheadDtoList.add(this.convert(prp,PrpPheadDto.class));
        }
        return prpPheadDtoList;
    }

    @Override
    public List<PrpPheadDto> queryByCondition(String policyNo, Date startDate) throws Exception {
        if(StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不可为空！");
        }
        List<PrpPheadDto> prpPheadDtoList=new ArrayList<>();
        List<PrpPhead> prpPheadList=prpPheadDao.queryByCondition(policyNo,startDate);
        convertCollection(prpPheadList,prpPheadDtoList,PrpPheadDto.class);
        return prpPheadDtoList;
    }
}
