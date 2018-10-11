package com.sinosoft.agriclaim.core.compensatemanage.service.impl;

import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensateKey;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLCompensateService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.proposalmanage.PlantingExcelApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PlantingExcelDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225
 * @description 赔款计算书表Core接口实现
 */
@Service
public class PrpLCompensateServiceImpl extends BaseServiceImpl implements PrpLCompensateService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCompensateServiceImpl.class);

    @Autowired
    private PrpLCompensateDao prpLCompensateDao;
    @Value("${fileService.url}")
    private String fileServiceUrl;
    @Value("${exportExcelType}")
    private String exportExcelType;
    @Autowired
    private PlantingExcelApi plantingExcelApi;
    @Autowired
    private PrpCmainApi prpCmainApi;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private PrpLRegistDao prpLRegistDao;
    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCompensateDto prpLCompensateDto) {
        PrpLCompensate prpLCompensate = this.convert(prpLCompensateDto, PrpLCompensate.class);
        prpLCompensateDao.save(prpLCompensate);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String compensateNo) {
        PrpLCompensateKey prpLCompensateKey = new PrpLCompensateKey(compensateNo);
        prpLCompensateDao.delete(prpLCompensateKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCompensateDto prpLCompensateDto) {
        PrpLCompensate prpLCompensate = this.convert(prpLCompensateDto, PrpLCompensate.class);
        prpLCompensateDao.save(prpLCompensate);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpLCompensateDto queryByPK(String compensateNo) {
        PrpLCompensateKey prpLCompensateKey = new PrpLCompensateKey(compensateNo);
        PrpLCompensate prpLCompensate = prpLCompensateDao.findOne(prpLCompensateKey);
        return this.convert(prpLCompensate,PrpLCompensateDto.class);
    }
    /**
     * 承保清单的下载
     * @author: 孙朋飞
     * @date: 2017/12/28 17:47
     * @param param 保单号
     * @return 下载链接
     * @throws Exception
     */
    @Override
    public Map<String, String> expNyxPolicyList(Map<String, String> param) throws Exception{
        String policyNo=param.get("policyNo");
        if(StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空!");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, String> insureListInfoFileId;
        if(StringUtils.isEmpty(param.get("registNo"))){
            //报案登记的时候取出险时间为当前时间
            param.put("validDate",simpleDateFormat.format(new Date()));
            insureListInfoFileId = plantingExcelApi.getInsureListInfoFileId(param);
        }else{
            //查询出险时间
            PrpLRegist prplRegist = prpLRegistDao.findByRegistNo(param.get("registNo"));
            param.put("validDate",simpleDateFormat.format(prplRegist.getDamageStartDate()));
            insureListInfoFileId = plantingExcelApi.getInsureListInfoFileId(param);
        }
        Map<String, String> returnMap=new HashMap<>();
        returnMap.put("shortLink",insureListInfoFileId.get("fileId"));
        return returnMap;
    }

    /**
     *  根据立案号查询PrpLCompensate信息
     * @author: 周柯宇
     * @date: 2017-12-7 17:02:49
     * @param claimNo 立案号
     * @return prpLCompensateDtoList  返回赔款计算书表表Dto集合
     */
    @Override
    public List<PrpLCompensateDto> queryClaimNo(String claimNo) throws Exception {
        if(StringUtils.isEmpty(claimNo)){
            throw new DataVerifyException("立案号不能为空");
        }
        List<PrpLCompensate> prpLCompensateList = prpLCompensateDao.findAll(Specifications.<PrpLCompensate>and()
                .eq(StringUtils.isNotEmpty(claimNo), "claimNo", claimNo)
                .build());
        List<PrpLCompensateDto> PrpLCompensateDtoList = new ArrayList<PrpLCompensateDto>();
        this.convertCollection(prpLCompensateList,PrpLCompensateDtoList,PrpLCompensateDto.class);
        return PrpLCompensateDtoList;
    }

    /**
     * （按险种代码查询理算数据）
     * @author: 王志文
     * @date: 2018/3/28 16:02
     * @param riskCode
     * @return
     * @throws Exception
     */
    @Override
    public List<PrpLCompensateDto> queryByRiskCode(String riskCode) throws Exception {
        List<PrpLCompensateDto> prpLCompensateDtoList = new ArrayList<>();
        List<PrpLCompensate> prpLCompensateList = prpLCompensateDao.queryByRiskCode(riskCode);
        this.convertCollection(prpLCompensateList,prpLCompensateDtoList,PrpLCompensateDto.class);
        return prpLCompensateDtoList;
    }
}