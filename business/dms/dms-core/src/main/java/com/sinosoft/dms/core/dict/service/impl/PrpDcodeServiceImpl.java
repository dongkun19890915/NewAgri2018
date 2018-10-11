package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.*;
import com.sinosoft.dms.core.dict.dao.PrpDcodeDao;
import com.sinosoft.dms.core.dict.dao.specification.PrpDCodeSpecBuilder;
import com.sinosoft.dms.core.dict.entity.PrpDcode;
import com.sinosoft.dms.core.dict.entity.PrpDcodeKey;
import com.sinosoft.dms.core.dict.service.PrpDcodeService;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
 * @time  2017-10-10 08:34:23.982 
 * @description 通用代码表Core接口实现
 */
@Service
public class PrpDcodeServiceImpl extends BaseCustomServiceImpl implements PrpDcodeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDcodeServiceImpl.class);
    
    @Autowired
    private PrpDcodeDao prpDcodeDao;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDcodeDto prpDcodeDto) {
        PrpDcode prpDcode = this.convert(prpDcodeDto, PrpDcode.class);
        prpDcodeDao.save(prpDcode);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String codeType,String codeCode) {
        PrpDcodeKey prpDcodeKey = new PrpDcodeKey(codeType,codeCode);
        prpDcodeDao.delete(prpDcodeKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDcodeDto prpDcodeDto) {
        PrpDcode prpDcode = this.convert(prpDcodeDto, PrpDcode.class);
        prpDcodeDao.save(prpDcode);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDcodeDto queryByPK(String codeType,String codeCode)
    {
        PrpDcodeKey prpDcodeKey = new PrpDcodeKey(codeType,codeCode);
        PrpDcode prpDcode = prpDcodeDao.findOne(prpDcodeKey);
        return this.convert(prpDcode,PrpDcodeDto.class);
    }

    /**
     * @description 根据codeType,codeCode,languageFlag 查询一条中文或英文名称
     * @author 王心洋
     * @param codeType,codeCode,languageFlag
     * @return 币种名称
     * @time 2017-10-29
     */
    @Override
    public String translateCode(String codeType,String codeCode,String languageFlag){
        if (codeCode ==null || codeCode.equals("")) {
            return ""; //代码空直接返回空字符串
        }
        PrpDcodeKey prpDcodeKey = new PrpDcodeKey(codeType,codeCode);
        PrpDcode prpDcode = prpDcodeDao.findOne(prpDcodeKey);
        if(prpDcode!= null) {
            if (LanguageFlagConstant.CHINESE.equals(languageFlag)) {
                return prpDcode.getCodeCName();
            } else {
                if (prpDcode.getCodeEName() == null || prpDcode.getCodeEName().equals("")) {
                    return prpDcode.getCodeCName();
                } else {
                    return prpDcode.getCodeEName();
                }
            }
        }
        return "";
    }

    /**
     * 根据codeType查询prpDCode实体
     * @author: 田健
     * @date: 2017/11/5 15:33
     * @param codeType 代码类型
     * @return prpDcodeDto 集合
     */
    @Override
    public List<PrpDcodeDto> queryCodeInfoByCodeType(String codeType,String riskCode){
        StringBuffer sql = new StringBuffer("SELECT p FROM PrpDcode p WHERE");
        Map<String,Object> map=new HashMap<String,Object>();
        sql.append(" p.validStatus = '1' ");
        sql.append(" and p.codeType = :codeType");
        if(codeType.equals("EndorType")){
            sql.append(" and p.flag='AG' ");
        }
        if(StringUtils.isNotEmpty(riskCode)){
            sql.append(" and p.codeCode in (select a.codeCode from PrpDcodeRisk a where a.codeType = :codeType");
            sql.append(" and (a.riskCode = :riskCode or a.riskCode = '0000'))");
            map.put("riskCode",riskCode);
        }
        map.put("codeType",codeType);
//        String sql ="SELECT * FROM PrpDcode WHERE" +
//                " codetype = '"+codeType+"' AND validstatus = '1' AND codecode in" +
//                " (SELECT codecode FROM prpdcoderisk WHERE codetype = '"+codeType+"'" +
//                " AND (riskcode = '"+riskCode+"' OR riskcode = '0000'))";
        Query dataQuery= entityManager.createQuery(sql.toString());
        this.setQueryParam(dataQuery,map);
        List<PrpDcode> prpDcodeList = dataQuery.getResultList();
        List<PrpDcodeDto> prpDcodeDtoList = new ArrayList<PrpDcodeDto>();
        this.convertCollection(prpDcodeList,prpDcodeDtoList,PrpDcodeDto.class);
         return prpDcodeDtoList;
    }

    /**
     * 根据codeType,codeCName,riskCode获取业务代码中文含义业务代码的codeCode
     * @author: 田健
     * @date: 2017/11/5 15:30
     * @param codeType 代码类型
     * @param codeCName 业务名称
     * @param riskCode 险种代码
     * @return 业务代码
     */
    @Override
    public String translateName(String codeType,String codeCName,String riskCode){
        PrpDcode prpDcode = new PrpDcode();
        prpDcode = prpDcodeDao.translateName(codeType,codeCName,riskCode);
        if(!"".equals(prpDcode) && prpDcode!=null){
            return prpDcode.getCodeCode();
        }else{
            return null;
        }
    }

    /**
     * @description:（根据iCodeType，iRiskCode，hpFlag查询prpdcode表获取列表数据）
     * @author: 田健
     * @date: 2017/10/21 16:29
     * @param codeType 代码类型
     * @param riskCode 险种代码
     * @param hpFlag 贫困标志
     * @return  prpDcodeDto 集合
     */
    //TODO 原生sql 老系统在sql中将codetype写死为PolicyType。
    @Override
    @Deprecated
    public  List<PrpDcodeDto> getOptionCode(String codeType, String riskCode, int hpFlag){
        StringBuilder strWhere = new StringBuilder(" SELECT q.* FROM PrpDcode q WHERE ");
        Map<String,Object> map=new HashMap<String,Object>();
        if(hpFlag == 1){
            strWhere.append(" q.validStatus = '1' ");
            strWhere.append(" and q.codeType = :codeType");
            strWhere.append(" and q.codeCode in (select a.codeCode from prpDcodeRiskAgri a where a.codeType = :codeType");
            map.put("codeType",codeType);
            strWhere.append(" and a.codeCode in ('H23', 'I27', 'Q1', 'E1') ");
            strWhere.append(" and (a.riskCode =:riskCode or a.riskCode = '0000'))");
            map.put("riskCode",riskCode);
        }else if(hpFlag == 2){
            strWhere.append(" q.validStatus = '1' ");
            strWhere.append(" and q.codeType = :codeType");
            strWhere.append(" and q.codeCode in (select a.codeCode from prpDcodeRiskAgri a where a.codeType = :codeType");
            strWhere.append(" and a.codeCode in ('H24', 'I28', 'Q2', 'E2') ");
            strWhere.append(" and (a.riskCode = :riskCode or a.riskCode = '0000'))");
            map.put("codeType",codeType);
            map.put("riskCode",riskCode);
//            strWhere.append(" codetype = '"+codeType+"' AND validstatus = '1' AND codecode in " +
//                    "(SELECT codecode FROM prpdcoderisk WHERE codetype = '"+codeType+"' and codecode in " +
//                    "('H24', 'I28', 'Q2', 'E2') AND (riskcode = '"+riskCode+"' OR riskcode = '0000'))");
        }else{
            strWhere.append(" q.validStatus = '1' ");
            strWhere.append(" and q.codeType = :codeType");
            strWhere.append(" and q.codeCode in (select a.codeCode from prpDcodeRiskAgri a where a.codeType = :codeType");
            strWhere.append(" and (a.riskCode = :riskCode or a.riskCode = '0000'))");
            strWhere.append(" and q.codeCode not in ('H23', 'I27', 'H24', 'I28', 'Q1', 'E1', 'Q2', 'E2')");
            map.put("codeType",codeType);
            map.put("riskCode",riskCode);
//            strWhere.append(" codetype = '"+codeType+"' AND validstatus = '1' AND codecode in " +
//                    "(SELECT codecode FROM prpdcoderisk WHERE codetype = '"+codeType+"' AND " +
//                    "(riskcode = '"+riskCode+"' OR riskcode = '0000')) AND codecode not in('H23', 'I27', 'H24', 'I28', 'Q1', 'E1', 'Q2', 'E2')");
        }
        Query dataQuery= entityManager.createNativeQuery(strWhere.toString(),PrpDcode.class);
        this.setQueryParam(dataQuery,map);
        List<PrpDcode> prpDcodeList = dataQuery.getResultList();
        List<PrpDcodeDto> prpDcodeDtoList = new ArrayList<PrpDcodeDto>();
        convertCollection(prpDcodeList,prpDcodeDtoList,PrpDcodeDto.class);
        return prpDcodeDtoList;
    }
    /**
     * @description:（根据codeType，riskCode查询prpdcode列表信息）
     * @author: 田健
     * @date: 2017/10/21 17:46
     * @param requestPrpDcodeListDto 查询 prpDcode大Dto 包含 codeType 代码类型 和riskCode 险种代码
     * @return ResponsePrpDcodeListDto 返回大对象，包含codeType与实体集合
     */
    @Override
    public ResponsePrpDcodeListDto getOptionCode(RequestPrpDcodeListDto requestPrpDcodeListDto)throws Exception{
        ResponsePrpDcodeListDto responsePrpDcodeListDto = new ResponsePrpDcodeListDto();
        List<PrpDcodeListDto> prpDcodeListDtoList1 = new ArrayList<PrpDcodeListDto>();
        Map<String,Object> map ;
        if(requestPrpDcodeListDto==null){
            throw new DataVerifyException("请求对象不能为空");
        }
        List<PrpDcodeListDto> prpDcodeListDtoList= requestPrpDcodeListDto.getPrpDcodeListDtoList();
        for(PrpDcodeListDto prpDcodeListDto : prpDcodeListDtoList){
            map = new HashMap<String,Object>();
            StringBuffer sql = new StringBuffer("SELECT p FROM PrpDcode p WHERE ");
            if(StringUtils.isEmpty(prpDcodeListDto.getCodeType())){
                throw new DataVerifyException("代码类型不能为空");
            }
            if(StringUtils.isNotEmpty(prpDcodeListDto.getRiskCode())){
                sql.append(" p.validStatus = '1' ");
                sql.append(" and p.codeType = :codeType");
                sql.append(" and p.codeCode in (select a.codeCode from PrpDcodeRisk a where a.codeType = :codeType");
                map.put("codeType",prpDcodeListDto.getCodeType());
                sql.append(" and (a.riskCode = :riskCode or a.riskCode = '0000'))");
                map.put("riskCode",prpDcodeListDto.getRiskCode());
            }else{
                sql.append(" p.validStatus = '1' ");
                sql.append(" and p.codeType = :codeType");
                map.put("codeType",prpDcodeListDto.getCodeType());
            }
            sql.append(" order by p.serialNo");
            Query dataQuery= entityManager.createQuery(sql.toString());
            this.setQueryParam(dataQuery,map);
            List<PrpDcode> prpDcodeList = dataQuery.getResultList();
            List<PrpDcodeDto> prpDcodeDtoList = new ArrayList<PrpDcodeDto>();
            convertCollection(prpDcodeList,prpDcodeDtoList,PrpDcodeDto.class);
            PrpDcodeListDto prpDcodeListDto1 = new PrpDcodeListDto();
            //将CodeType 与查询到的实体放到prpDcodeListDto1中
            prpDcodeListDto1.setCodeType(prpDcodeListDto.getCodeType());
            prpDcodeListDto1.setPrpDcodeDtoList(prpDcodeDtoList);
            // 将prpDcodeListDto1对象放到prpDcodeListDtoList1集合中
            prpDcodeListDtoList1.add(prpDcodeListDto1);
        }
        responsePrpDcodeListDto.setPrpDcodeListDtoList(prpDcodeListDtoList1);
        return responsePrpDcodeListDto;
    }

    /**
     * codeType和feildExt查询归属机构信息
     * @author: 王保良
     * @date: 2017/11/16 17:46
     * @param codeType 代码种类
     * @param fieldExt 上级区域代码
     * @return 返回的是满足条件的PrpDcode实体类对象
     * @throws Exception
     */
    @Override
    @Transactional
    public List<PrpDcodeDto> queryAreasProvinceInfo(String codeType,String fieldExt) throws Exception{
        if (StringUtils.isEmpty(codeType)){
            throw new Exception("代码种类不能为空");
        }
        List<PrpDcode> prpDcodeList =new ArrayList<>();
        Specification<PrpDcode> specification=PrpDCodeSpecBuilder.queryAreasProvinceInfo(codeType,fieldExt);
        prpDcodeList = prpDcodeDao.findAll(specification);
        List<PrpDcodeDto> prpDcodeDtoList=new ArrayList<PrpDcodeDto>();
        convertCollection(prpDcodeList,prpDcodeDtoList,PrpDcodeDto.class);
        return prpDcodeDtoList;
    }

    /**
     * 根据险种、编辑类型、业务名称、业务代码查询业务代码表数据集
     * @author: 杨成程
     * @date: 2017/12/03 15:30
     * @param requestDto 
     * @return 业务代码
     */
	@Override
	public List<PrpDcodeDto> queryCodeInfoByCodeName(RequestQueryCodeInfoDto requestDto) throws Exception{         
        if (StringUtils.isEmpty(requestDto.getCodeType())){
            throw new DataVerifyException("业务代码类型不能为空");
        }
        if (StringUtils.isEmpty(requestDto.getRiskCode())){
            throw new DataVerifyException("险种代码不能为空");
        }
        if (StringUtils.isEmpty(requestDto.getCodeCode())){
        	requestDto.setCodeCode("");
        }
        if (StringUtils.isEmpty(requestDto.getCodeCName())){
        	requestDto.setCodeCName("");
        }
		List<PrpDcodeDto> prpDcodeDtoList=new ArrayList<>();
		List<PrpDcode> prpDcodeList =new ArrayList<>();
		prpDcodeList = prpDcodeDao.queryCodeInfoByCodeName(requestDto.getCodeType(),"%"+requestDto.getCodeCode()+"%","%"+requestDto.getCodeCName()+"%",requestDto.getRiskCode());
        convertCollection(prpDcodeList,prpDcodeDtoList,PrpDcodeDto.class);
	    return prpDcodeDtoList;
	}

	/**
	 * @description: 根据类型 和code编码的集合查询信息，如投保数量对应的单位信息
	 *               codeCodeList是codecode字符串由"-"拼接而成
	 * @author 安齐崇
	 * @date 2017年11月3日下午5:37:04
	 * @param codeType
	 *            险种类型
	 * @param codeCodeList
	 * @return
	 */
	@Override
	public List<PrpDcodeDto> queryByCondition(String codeType, String codeCodeList) {
		Specification<PrpDcode> specification = Specifications.<PrpDcode>and().eq("codeType", codeType)
				.eq("validStatus", "1").in("codeCode", codeCodeList.split("-")).build();
		List<PrpDcode> prpDcodeList = prpDcodeDao.findAll(specification);
		List<PrpDcodeDto> prpDcodeDtoList = new ArrayList<PrpDcodeDto>();
		this.convertCollection(prpDcodeList, prpDcodeDtoList, PrpDcodeDto.class);
		return prpDcodeDtoList;
	}

    /**
     * （根据主键查询代码对应中文）
     * @param codeType 代码类别
     * @param codeCode 代码
     * @return 代码对应中文
     * @author: 董坤
     * @date: 2017/11/18 10:09
     */
    @Override
    public String translateCodeByPK(String codeType, String codeCode) {
        PrpDcodeKey prpDcodeKey =new PrpDcodeKey(codeType,codeCode);
        PrpDcode prpDcode = prpDcodeDao.findOne(prpDcodeKey);
        return prpDcode.getCodeCName();
    }
    /**
     *  根据客户类型查询证件类型
     * @author: 田慧
     * @date: 2017/12/23 11:25
     * @param flag flag 为1是个人，flag为2 是集体
     * @return dentifyType 证件类型
     * @throws Exception
     */
    @Override
    public PrpDcodeRetuenDto queryIdentifyType(String flag)throws Exception{
        if (StringUtils.isEmpty(flag)) {
            throw new DataVerifyException("客户类型不能为空");
        }
        PrpDcodeRetuenDto prpDcodeRetuenDto = new PrpDcodeRetuenDto();
        List<PrpDcode> prpDcodeList = prpDcodeDao.queryIdentifyType(flag);
        for (PrpDcode p : prpDcodeList) {
            QueryPrpDcodeDto queryPrpDcodeDto = new QueryPrpDcodeDto();
            queryPrpDcodeDto.setCodeCode(p.getCodeCode());
            queryPrpDcodeDto.setCodeName(p.getCodeCName());
            prpDcodeRetuenDto.getQueryPrpDcodeDtoList().add(queryPrpDcodeDto);
        }
        return prpDcodeRetuenDto;
    }

    /**
     * @description:方法功能简述:根据类型和险种编码查询下下拉信息
     * @author 安齐崇
     * @date 2017年11月10日下午7:06:37
     * @param codeType 查询类型
     * @param riskCode 险种编码
     */
	@Override
	public List<PrpDcodeDto> queryOptionBox(String codeType, String riskCode) {
		String sql ="select * from prpdcode where codeType =:codeType and codecode in (select codecode from prpDcodeRiskAgri where riskCode=:riskCode and codeType=:codeType)"+
				  " order by codecode";
		Query query = entityManager.createNativeQuery(sql,PrpDcode.class);
		query.setParameter("codeType", codeType);
		query.setParameter("riskCode", riskCode);
		LOGGER.error("查询sql:{}", sql);
		List<PrpDcode> result = query.getResultList();
		List<PrpDcodeDto> prpDcodeDtoList = new ArrayList<>();
		this.convertCollection(result, prpDcodeDtoList, PrpDcodeDto.class);
		return prpDcodeDtoList;
	}
    /**
     * 根据多个代码查询对应的证件类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 证件类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public Map<String, String> queryCertifyTypeByCodes(List<String> codes) {
        if (codes == null || codes.size() < 1) {
            throw new DataVerifyException("至少需要一个证件类型代码");
        }
        List<PrpDcode> prpDcodes = prpDcodeDao.queryCertifyTypeByCodes(codes);
        Map<String, String> returnMap = new HashMap<>(prpDcodes.size());
        prpDcodes.forEach(prpDcode -> returnMap.put(prpDcode.getCodeCode(), prpDcode.getCodeCName()));
        return returnMap;
    }

    /**
     * 根据多个代码查询对应的领款人类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 领款人类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public Map<String, String> queryReceiverTypesByCodes(List<String> codes) {
        if (codes == null || codes.size() < 1) {
            throw new DataVerifyException("至少需要一个证件类型代码");
        }
        List<PrpDcode> prpDcodes = prpDcodeDao.queryReceiverTypeByCodes(codes);
        Map<String, String> returnMap = new HashMap<>(prpDcodes.size());
        prpDcodes.forEach(prpDcode -> returnMap.put(prpDcode.getCodeCode(), prpDcode.getCodeCName()));
        return returnMap;
    }

    /**
     * 根据多个代码查询对应的银行账号属性中文名称键值对
     *
     * @param codes 代码集合
     * @return 银行账号属性代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public Map<String, String> queryAccountTypeByCodes(List<String> codes) {
        if (codes == null || codes.size() < 1) {
            throw new DataVerifyException("至少需要一个证件类型代码");
        }
        List<PrpDcode> prpDcodes = prpDcodeDao.queryAccountTypeByCodes(codes);
        Map<String, String> returnMap = new HashMap<>(prpDcodes.size());
        prpDcodes.forEach(prpDcode -> returnMap.put(prpDcode.getCodeCode(), prpDcode.getCodeCName()));
        return returnMap;
    }

    /**
     * 根据多个代码查询对应的银行账号类型中文名称键值对
     *
     * @param codes 代码集合
     * @return 银行账号类型代码-证件类型名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public Map<String, String> queryAccountFlagByCodes(List<String> codes) {
        if (codes == null || codes.size() < 1) {
            throw new DataVerifyException("至少需要一个证件类型代码");
        }
        List<PrpDcode> prpDcodes = prpDcodeDao.queryAccountFlagByCodes(codes);
        Map<String, String> returnMap = new HashMap<>(prpDcodes.size());
        prpDcodes.forEach(prpDcode -> returnMap.put(prpDcode.getCodeCode(), prpDcode.getCodeCName()));
        return returnMap;
    }

    /**
     * 根据多个代码查询对应的费用类型中文名
     *
     * @param costType 费用类型
     * @return 费用类型名称
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public String queryCostTypeByCode(String costType) {
        if (StringUtils.isEmpty(costType)) {
            throw new DataVerifyException("费用类型代码不能为空！");
        }
        PrpDcode prpDcode = prpDcodeDao.queryCostTypeByCode(costType);
        if (prpDcode == null) {
            throw new DataVerifyException("未查询到" + costType + "对应的中文名称！");
        }
        return prpDcode.getCodeCName();
    }

    /**
     * 根据多个代码查询对应的短期费率方式中文名称键值对
     *
     * @param codes 代码集合
     * @return 短期费率方式代码-短期费率方式名称的键值对
     * @author: 何伟东
     * @date: 2017/12/28 14:28
     */
    @Override
    public Map<String, String> queryShortRateFlagByCodes(List<String> codes) {
        if (codes == null || codes.size() < 1) {
            throw new DataVerifyException("至少需要一个短期费率方式代码");
        }
        List<PrpDcode> prpDcodes = prpDcodeDao.queryShortRateFlagByCodes(codes);
        Map<String, String> returnMap = new HashMap<>(prpDcodes.size());
        prpDcodes.forEach(prpDcode -> returnMap.put(prpDcode.getCodeCode(), prpDcode.getCodeCName()));
        return returnMap;
    }

    /**
     * 根据代码类型和代码查出对应的代码数据，代码可以为空
     *
     * @param codeType 代码类型
     * @param codeCode 代码
     * @return prpdcode的集合
     * @date: 2018/2/12 11:17
     * @author: 何伟东
     */
    @Override
    public List<PrpDcodeDto> queryCodeInfoByTypeAndCode(String codeType, String codeCode) {
        List<PrpDcodeDto> prpDcodeDtos = new ArrayList<>();
        if (StringUtils.isEmpty(codeType)) {
            throw new DataVerifyException("cdeType不能为空");
        }
        if (StringUtils.isEmpty(codeCode)) {
            List<PrpDcode> prpDcodes = prpDcodeDao.queryCodeListByCodeType(codeType);
            convertCollection(prpDcodes, prpDcodeDtos, PrpDcodeDto.class);
        } else {
            PrpDcode prpDcodeDaoOne = prpDcodeDao.findOne(new PrpDcodeKey(codeType, codeCode));
            prpDcodeDtos.add(this.convert(prpDcodeDaoOne, PrpDcodeDto.class));
        }
        return prpDcodeDtos;
    }

    @Override
    public List<PrpDcodeDto> queryReportType() throws Exception {
        List<PrpDcode> prpDcodeList=prpDcodeDao.queryReportType();
        List<PrpDcodeDto> prpDcodeDtoList=new ArrayList<>();
        convertCollection(prpDcodeList,prpDcodeDtoList,PrpDcodeDto.class);
        return prpDcodeDtoList;
    }
}