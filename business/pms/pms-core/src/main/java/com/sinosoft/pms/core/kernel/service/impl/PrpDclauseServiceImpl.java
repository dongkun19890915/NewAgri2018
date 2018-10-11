package com.sinosoft.pms.core.kernel.service.impl;


import com.sinosoft.dms.api.dict.PrpDcodeRiskApi;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseDto;
import com.sinosoft.pms.api.kernel.dto.ResponsePrpDclauseDto;
import com.sinosoft.pms.core.kernel.dao.PrpDclauseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDclause;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseKey;
import com.sinosoft.pms.core.kernel.entity.PrpDkindClauseAgri;
import com.sinosoft.pms.core.kernel.service.PrpDclauseService;
import com.sinosoft.pms.core.kernel.service.PrpDkindClauseAgriService;
import com.sinosoft.pms.core.kernel.service.PrpDkindClauseService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 06:20:36.415 
 * @description 条款代码表Core接口实现
 */
@Service
public class PrpDclauseServiceImpl extends BaseCustomServiceImpl implements PrpDclauseService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDclauseServiceImpl.class);

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
    @Autowired
    private PrpDclauseDao prpDclauseDao;
    @Autowired
    private PrpDcodeRiskApi prpDcodeRiskApi;
    @Autowired
    private PrpDkindClauseAgriService prpDkindClauseAgriService;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDclauseDto prpDclauseDto) {
        PrpDclause prpDclause = this.convert(prpDclauseDto, PrpDclause.class);
        prpDclauseDao.save(prpDclause);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,Integer lineNo) {
        PrpDclauseKey prpDclauseKey = new PrpDclauseKey(clauseCode,lineNo);
        prpDclauseDao.delete(prpDclauseKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDclauseDto prpDclauseDto) {
        PrpDclause prpDclause = this.convert(prpDclauseDto, PrpDclause.class);
        prpDclauseDao.save(prpDclause);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpDclauseDto queryByPK(String clauseCode,Integer lineNo) {
        PrpDclauseKey prpDclauseKey = new PrpDclauseKey(clauseCode,lineNo);
        PrpDclause prpDclause = prpDclauseDao.findOne(prpDclauseKey);
        return this.convert(prpDclause,PrpDclauseDto.class);
    }
    /**
     * 根据条款代码查询条款代码表的风险等级说明，第三方识别说明
     * @author: 宋振振
     * @date: 2017/10/23 15:26
     * @param clauseCode 条款代码
     * @return List<PrpDclauseDto> 返回相应条款代码的条款信息
     */
    @Override
    public List<PrpDclauseDto> queryClauseByClauseCode(String clauseCode) throws Exception{
        if(StringUtils.isEmpty(clauseCode)){
            throw new DataVerifyException("条款代码clauseCode不能为空!");
        }
        List<PrpDclause> prpDclauseList=prpDclauseDao.findPrpDclauseByClauseCode(clauseCode);
        List<PrpDclauseDto> prpDclauseDtoList=new ArrayList<PrpDclauseDto>();
        convertCollection(prpDclauseList,prpDclauseDtoList,PrpDclauseDto.class);
        return prpDclauseDtoList;
    }

    /**
     * 按险种查询CLauseDto(特约及附加信息双击域)
     * @param riskCode 险种代码
     * @return List<PrpDclauseDto> 返回PrpDclauseDto的实体类对象
     * @author 王保良
     * @throws Exception
     * @date 2017年10月12日 下午3:20:00
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpDclauseDto> queryClauseByRiskCode(String riskCode) throws Exception {
        if(com.sinosoft.framework.core.utils.StringUtils.isEmpty(riskCode)){
            throw new Exception("险种代码不能为空");
        }
        List clauseCode=new ArrayList();
        clauseCode=prpDcodeRiskApi.queryCodeCode(riskCode);
        List<PrpDclause> list = prpDclauseDao.findPrpDclauseByRiskCode(clauseCode);
        List<PrpDclauseDto> clauseDtoList = new ArrayList<>(list.size());
        convertCollection(list, clauseDtoList, PrpDclauseDto.class);
        return clauseDtoList;
    }
    /**
     *  根据clauseCode 条款代码查询PrpDclause条款信息表信息
     * @author: 田慧
     * @date: 2017/12/2 12:50
     * @param clauseCode 条款代码
     * @return PrpDclauseDto的集合
     */
    @Override
    public List<PrpDclauseDto> queryPrpdclauseInfoByCondition(String clauseCode,String insuranceCode)throws Exception{
        if (StringUtils.isEmpty(clauseCode)){
            throw new DataVerifyException("条款代码不能为空!");
        }
//        Map<String,Object> map = new HashMap<String,Object>();
//        StringBuilder stringBuilder = new StringBuilder("select p from PrpDclause p where p.clauseCode=:clauseCode ");
//        map.put("clauseCode",clauseCode);
//        stringBuilder.append(" AND p.validStatus='1' and p.titleFlag='0' order by p.lineNo ");
//        System.out.println(stringBuilder);
//        Query dataQuery = entityManager.createQuery(stringBuilder.toString());
//        this.setQueryParam(dataQuery,map);

        List<PrpDclause> prpDclauseList = prpDclauseDao.queryPrpdclauseInfoByCondition(clauseCode,insuranceCode);
        List<PrpDclauseDto> prpDclauseDtoList = new ArrayList<PrpDclauseDto>();
        convertCollection(prpDclauseList,prpDclauseDtoList,PrpDclauseDto.class);
        return prpDclauseDtoList;
    }

    /**
     * 根据条款代码集合查询条款代码和条款名称
     * @author: 刘曼曼
     * @date: 2017/12/19 15:17
     * @param riskCode 险种
     * @return List<ResponsePrpDclauseDto> 保险代码和保险名称集合
     * @throws Exception
     */
    public List<ResponsePrpDclauseDto> queryPrpdclauseInfo(String riskCode)throws Exception{
        if(StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("险种不能为空！");
        }
        List<String> clauseCodeList=prpDcodeRiskApi.queryCodeCode(riskCode);
        List<ResponsePrpDclauseDto> responsePrpDclauseDtoList=prpDclauseDao.queryCluseCodeAndClauseName(clauseCodeList);
        return responsePrpDclauseDtoList;
    }


    /**
     * 根据条款代码查询险种内容
     * @author: 刘曼曼
     * @date: 2017/12/19 17:49
     * @param riskCode 险种代码
     * @return List<String> 险种内容集合
     * @throws Exception
     */
    public List<PrpDclauseDto> queryByKindContext(String clauseCode,String itemCode)throws Exception{
        if(StringUtils.isEmpty(clauseCode)){
            throw new DataVerifyException("险种不能为空！");
        }
//        List<String> clauseCodes=prpDkindClauseAgriService.queryClauseCode(riskCode);
        List<PrpDclauseDto> prpDclauseDtoList=new ArrayList<PrpDclauseDto>();
//        if(clauseCodes.size()!=0){
            List<PrpDclause> prpDclauseList=prpDclauseDao.queryKindContext(clauseCode,itemCode);
            convertCollection(prpDclauseList,prpDclauseDtoList,PrpDclauseDto.class);
//        }
        return prpDclauseDtoList;
    }

}