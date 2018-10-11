package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpMmodelComDto;
import com.sinosoft.dms.core.model.dao.PrpMmodelComDao;
import com.sinosoft.dms.core.model.entity.PrpMmodelCom;
import com.sinosoft.dms.core.model.entity.PrpMmodelComKey;
import com.sinosoft.dms.core.model.service.PrpMmodelComService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:35:35.009 
 * @description 模板机构配置表Core接口实现
 */
@Service
public class PrpMmodelComServiceImpl extends BaseServiceImpl implements PrpMmodelComService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpMmodelComServiceImpl.class);

    @Autowired
    private PrpMmodelComDao prpMmodelComDao;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @PersistenceContext
    private EntityManager entityManager;
    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(List<PrpMmodelComDto> prpMmodelComDtos) {
        List<PrpMmodelCom> prpMmodelComList = new ArrayList<>(prpMmodelComDtos.size());
        this.convertCollection(prpMmodelComDtos, prpMmodelComList, PrpMmodelCom.class);
        prpMmodelComDao.save(prpMmodelComList);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String modelCode,String comCode) {
        PrpMmodelComKey prpMmodelComKey = new PrpMmodelComKey(modelCode,comCode);
        prpMmodelComDao.delete(prpMmodelComKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpMmodelComDto prpMmodelComDto) {
        PrpMmodelCom prpMmodelCom = this.convert(prpMmodelComDto, PrpMmodelCom.class);
        prpMmodelComDao.save(prpMmodelCom);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public PrpMmodelComDto queryByPK(String modelCode,String comCode) {
        PrpMmodelComKey prpMmodelComKey = new PrpMmodelComKey(modelCode,comCode);
        PrpMmodelCom prpMmodelCom = prpMmodelComDao.findOne(prpMmodelComKey);
        return this.convert(prpMmodelCom,PrpMmodelComDto.class);
    }

    /**
     * 根据机构代码和模板代码模糊查询模板机构配置表信息
     * @author: 田慧
     * @date: 2017/11/7 17:55
     * @param map 模板代码和机构代码
     * @return PrpMmodelComDto模板机构配置表的集合
   */
    @Override
    public List<PrpMmodelComDto> queryCodeListByComcode(Map<String,String> map)throws Exception{
        String modelCode = map.get("modelCode");
        String comCode = map.get("comCode");
        String flag = map.get("flag");
        List<PrpMmodelCom> prpMmodelComList = null;
        if(StringUtils.isEmpty(comCode))
        {
            throw new DataVerifyException("机构代码不能为空");
        }
        //99代表短信模板的功能
        if ("99".equals(flag)) {
//            prpMmodelComList = prpMmodelComDao.findByComCodeAndFlag(comCode, flag);

            List<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<PrpDcompanyDto>();
            Map<String,String> map1 = new HashMap<>();
            map1.put("comCode",comCode);
            prpDcompanyDtoList = prpDcompanyApi.queryDownCompany(map1);
            //TODO 原生sql
            String sql="select * from PrpMmodelCom p where  p.flag='"+flag+"'";
            StringBuilder strWhere = new StringBuilder();
            //拼接查询该机构下包含所有子机构下的 所有条款信息
            if (prpDcompanyDtoList.size() > 0) {
                strWhere.append(" AND p.comCode in (");
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
                        strWhere.append(" ) OR p.comCode In ( '"+ prpDcompanyDto.getComCode()+"'");
                    }else{
                        strWhere.append(" ) OR p.comCode In ( '"+ prpDcompanyDto.getComCode()+"',");
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
            sql+=strWhere;
            javax.persistence.Query dataQuery= entityManager.createNativeQuery(sql,PrpMmodelCom.class);
            prpMmodelComList=dataQuery.getResultList();
        } else {
            modelCode = "%" + modelCode + "%";
            prpMmodelComList = prpMmodelComDao.findByComCodeModelCode(modelCode, comCode);
        }


        List<PrpMmodelComDto> prpMmodelComDtoList = new ArrayList<PrpMmodelComDto>();
        this.convertCollection(prpMmodelComList,prpMmodelComDtoList,PrpMmodelComDto.class);
        return prpMmodelComDtoList;
    }

    @Override
    public List<PrpMmodelComDto> findByModelCode(String modelCode) {
        List<PrpMmodelCom> prpMmodelComList = prpMmodelComDao.findByModelCode(modelCode);
        List<PrpMmodelComDto> prpMmodelComDtoList = new ArrayList<>(prpMmodelComList.size());
        this.convertCollection(prpMmodelComList, prpMmodelComDtoList, PrpMmodelComDto.class);
        return prpMmodelComDtoList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByModelCode(String modelCode) {
        prpMmodelComDao.deleteByModelCode(modelCode);
    }


}