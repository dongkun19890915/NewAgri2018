package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.pms.core.kernel.dao.PrpDitemAgriDao;
import com.sinosoft.pms.core.kernel.dao.PrpDriskDao;
import com.sinosoft.pms.core.kernel.entity.PrpDrisk;
import com.sinosoft.pms.core.kernel.entity.PrpDriskKey;
import com.sinosoft.pms.core.kernel.service.PrpDriskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 12:48:22.282
 * @description 险种代码表Core接口实现
 */
@Service
public class PrpDriskServiceImpl extends BaseServiceImpl implements PrpDriskService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDriskServiceImpl.class);

    @Autowired
    private PrpDriskDao prpDriskDao;
    @Autowired
    private PrpDitemAgriDao prpDitemAgriDao;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDriskDto prpdriskDto) {
        PrpDrisk prpdrisk = this.convert(prpdriskDto, PrpDrisk.class);
        prpDriskDao.save(prpdrisk);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String riskCode) {
        PrpDriskKey prpdriskKey = new PrpDriskKey(riskCode);
        prpDriskDao.delete(prpdriskKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDriskDto prpdriskDto) {
        PrpDrisk prpdrisk = this.convert(prpdriskDto, PrpDrisk.class);
        prpDriskDao.save(prpdrisk);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public PrpDriskDto queryByPK(String riskCode) {
        PrpDriskKey prpdriskKey = new PrpDriskKey(riskCode);
        PrpDrisk prpdrisk = prpDriskDao.findOne(prpdriskKey);
        return this.convert(prpdrisk,PrpDriskDto.class);
    }

    /**
     * （根据险种代码查询prpdrisk表返回中文或英文名称）
     * @author: 田健
     * @date: 2017/10/22 14:49
     * @param riskCode 险种代码
     * @param isChinese 中文标识
     * @return 中文或英文名称
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String translateCode(String riskCode, String isChinese) throws Exception{
        if(StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("险种代码不能为空");
        }
        PrpDriskKey prpdriskKey = new PrpDriskKey(riskCode);
        PrpDrisk prpdrisk = prpDriskDao.findOne(prpdriskKey);
        if(prpdrisk != null) {
            if (LanguageFlagConstant.CHINESE.equals(isChinese)) {//isChinese是true则返回中文名称否则返回英文名称
                return prpdrisk.getRiskCName();
            } else {
                if ("".equals(prpdrisk.getRiskEName()) || prpdrisk.getRiskEName() == null) {//如果英文名称为空则返回中文名称
                    return prpdrisk.getRiskCName();
                } else {
                    return prpdrisk.getRiskEName();
                }
            }
        }
        return " ";
    }
    /**
     * 根据险类、标的集合代码查询prpdrisk表返回该险类下的所有数据(快速出单)
     * @author: 王保良
     * @date: 2017/10/22 14:49
     * @param classCode
     * @return List<PrpDriskDto>
     */
    @Override
    public List<PrpDriskDto> queryRiskCodeInfoQuick(String classCode,List<String> itemCodeList) throws Exception {
        List<PrpDrisk> prpDriskList=new ArrayList<>();
        if(itemCodeList==null || itemCodeList.size()==0){
            prpDriskList = prpDriskDao.queryAllByClassCode(classCode);
        }else{//快速出单查询
            prpDriskList = prpDriskDao.queryAllByClassCodeAndItemCodeList(classCode,itemCodeList);
        }
        List<PrpDriskDto> prpDriskDtoList=new ArrayList<>();
        convertCollection(prpDriskList,prpDriskDtoList,PrpDriskDto.class);
        return prpDriskDtoList;
    }
    /**
     * 根据险类查询该险类下的所有险种
     * @author: 王保良
     * @date: 2017/10/22 14:49
     * @param classCode
     * @return List<PrpDriskDto>
     */
    @Override
    public List<PrpDriskDto> queryRiskCodeInfo(String classCode) throws Exception {
        List<PrpDrisk> prpDriskList=new ArrayList<>();
        //如果不传险类 则默认查询所有31 32下的险种
        if (StringUtils.isEmpty(classCode)){
            prpDriskList=prpDriskDao.queryByCondition();
        }else {
            prpDriskList = prpDriskDao.queryAllByClassCode(classCode);
        }
        List<PrpDriskDto> prpDriskDtoList=new ArrayList<>();
        convertCollection(prpDriskList,prpDriskDtoList,PrpDriskDto.class);
        return prpDriskDtoList;
    }
    /**
     * 根据险类代码查询该险类下的所有险种
     * @author: 王心洋
     * @date: 2018/03/16
     * @param riskType
     * @return List<PrpDriskDto>
     */
    @Override
    public List<Map<String, String>> queryRiskByRiskType(String riskType) throws Exception {
        List<PrpDrisk> prpDriskList;
        StringBuffer sql = new StringBuffer("select r.* from prpdrisk r where ");
        //如果不传险类 则默认查询所有险种
        if (StringUtils.isEmpty(riskType)||"all".equals(riskType)){
            prpDriskList=prpDriskDao.queryByCondition();
        }else {
            sql.append("r.classcode in (select c.classcode from prpdclass c where c.riskcategory=:riskType)");
            Query agentQuery = entityManager.createNativeQuery(sql.toString(), PrpDrisk.class);
            agentQuery.setParameter("riskType", riskType);
            prpDriskList = agentQuery.getResultList();
        }
        List<PrpDriskDto> prpDriskDtoList=new ArrayList<>();
        convertCollection(prpDriskList,prpDriskDtoList,PrpDriskDto.class);
        List<Map<String, String>> returnList = new ArrayList<>();
        for(PrpDriskDto prpDriskDto:prpDriskDtoList){
            Map<String, String> map = new HashMap<>();
            map.put("codecode", prpDriskDto.getRiskCode());
            map.put("codecname", prpDriskDto.getRiskCName());
            returnList.add(map);
        }
        return returnList;
    }

    /**
     * 根据多个riskCode查询得到List<PrpDrisk>
     * @author: 何伟东
     * @date: 2017/11/23 15:18
     * @param riskCodeList 多个riskCode的list集合
     * @return List<PrpDriskDto>
     */
    @Override
    public List<PrpDriskDto> queryByRiskCodeList(List<String> riskCodeList) {
        if (riskCodeList == null || riskCodeList.size()<1) {
            throw new DataVerifyException("用户代码不能为空");
        }
        StringBuilder dataSql = new StringBuilder();
        dataSql.append("SELECT p FROM PrpDrisk p WHERE p.riskCode in (:riskCodeList)");
        Query dataQuery = entityManager.createQuery(dataSql.toString());
        dataQuery.setParameter("riskCodeList",riskCodeList);
        List<PrpDrisk> prpDriskList = dataQuery.getResultList();
        List<PrpDriskDto> prpDriskDtoList = new ArrayList<>();
        convertCollection(prpDriskList,prpDriskDtoList,PrpDriskDto.class);
        return prpDriskDtoList;
    }


    /**
     * 根据险种代码查询险种名称
     * @author: 刘曼曼
     * @date: 2017/12/19 11:52
     * @param riskCodes 险种代码集合
     * @return List<String>险种名称集合
     * @throws Exception
     */
    @Override
    public List<String> translateCodeName(List<String> riskCodes) throws Exception{
        if(riskCodes.size()==0){
            throw new DataVerifyException("险种代码不能为空！");
        }
        List<String> riskCodeNames=prpDriskDao.queryAllByRiskName(riskCodes);
        return riskCodeNames;
    }

    /**
     * 根据险种代码查询保费计算方式
     * @author: 刘曼曼
     * @date: 2017/12/19 11:52
     * @param riskCode 险种代码
     * @return Double 费率分位
     * @throws Exception
     */
    @Override
    public Double queryByRiskCode(String riskCode)throws Exception{
        if(StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("险种能为空！");
        }
        Double calculator=prpDriskDao.queryByRiskCode(riskCode);
        return calculator;
    }
    /**
     * @param riskCode 险种代码
     * @return 中文名称
     * @description:（根据险种代码查询prpdrisk表返回名称）
     * @author: 董坤
     * @date: 2017/10/22 14:49
     */
    @Override
    public String translateCodeByPK(String riskCode) {
        PrpDriskKey prpDriskKey = new PrpDriskKey(riskCode);
        PrpDrisk prpDrisk = prpDriskDao.findOne(prpDriskKey);
        if(prpDrisk != null){
           return prpDrisk.getRiskCName();
        }else{
            return "";
        }
    }
    /**
     * 根据validStatus查询险种表
     * @author: 王保良
     * @date: 2017/12/10 15:18
     * @return String[]
     */
    @Override
    public String[] queryByValidStatus() throws Exception {
        String[] riskcode=prpDriskDao.findByValidStatus();
        return riskcode;
    }
    /**
     * 根据validStatus和Flag表示符查询险种表
     * @author: 王保良
     * @date: 2017/12/10 15:18
     * @return String[]
     */
    @Override
    public String[] queryByValidStatusAndFlag() throws Exception {
        String[] riskCode=prpDriskDao.findByValidStatusAndFlag();
        return riskCode;
    }
    /**
     *  根据标的查询险种（快速出单带出险种、险类）
     * @author: 田健
     * @date: 2018/4/8 20:23
     * @param itemCodeList 标的代码集合
     * @return 标的对象集合
     */
    @Override
    public List<PrpDriskDto> queryByItemCode(List<String> itemCodeList){
        //根据标的代码查询险种代码
        List<String> riskCodes = prpDitemAgriDao.queryByItemCode(itemCodeList);
        //根据险种代码查询险种表
        List<PrpDrisk> prpDriskList = prpDriskDao.findAllByRiskCodes(riskCodes);
        List<PrpDriskDto> prpDriskDtoList = new ArrayList<>();
        convertCollection(prpDriskList,prpDriskDtoList,PrpDriskDto.class);
        return prpDriskDtoList;
    }

    /**
     * 险种（）
     *
     * @return
     * @author: qianhao
     * @date: 2018/4/8 20:23
     */
    public Map<String, String> queryByRiskName() {
        List<PrpDrisk> prpDriskList = prpDriskDao.queryByriskName();
        Map<String, String> stringMap = new HashMap<>();
        for (PrpDrisk prpDrisk : prpDriskList) {
            stringMap.put(prpDrisk.getRiskCode(), prpDrisk.getRiskCName());
        }
        return stringMap;
    }
}