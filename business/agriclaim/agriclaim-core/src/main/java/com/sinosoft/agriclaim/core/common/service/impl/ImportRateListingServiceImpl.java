package com.sinosoft.agriclaim.core.common.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.GYLossRateMainApi;
import com.sinosoft.agriclaim.api.checkmanage.CheckApi;
import com.sinosoft.agriclaim.api.checkmanage.dto.EarNoCheckRequestDto;
import com.sinosoft.agriclaim.api.checkmanage.dto.EarNoCheckResponseDto;
import com.sinosoft.agriclaim.api.common.dto.RequestImportDto;
import com.sinosoft.agriclaim.api.common.dto.SaveBleedingRateImportDto;
import com.sinosoft.agriclaim.api.common.dto.SavePlantingRateListImportDto;
import com.sinosoft.agriclaim.core.common.service.ImportRateListingService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriprpall.api.policymanage.dto.AcceptInsuranceDto;
import com.sinosoft.agriprpall.api.proposalmanage.PlantingExcelApi;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.fileserver.client.FileServerHelper;
import com.sinosoft.framework.agri.core.excel.ExcelConst;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.PrpDkindApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;
import com.sinosoft.txnlist.api.claiminsurancelist.BreedLossRateListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.LossRateListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.LossRateMainListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.PlantingLossRateListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.HerdPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingInsuranceListDto;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ImportRateListingServiceImpl implements ImportRateListingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImportRateListingServiceImpl.class);
    @Value("${fileService.url}")
    private String fileServiceUrl;
    @Value("${fileService.plantFileId}")
    private String plantFileId;
    @Value("${fileService.herdFileId}")
    private String herdFileId;
    @Autowired
    private BreedLossRateListApi breedLossRateListApi;

    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private LossRateListApi lossRateListApi;
    @Autowired
    private PlantingLossRateListApi plantingLossRateListApi;
    @Autowired
    private CheckApi checkApi;
    @Autowired
    private PrpDkindApi prpDkindApi;
    @Autowired
    private HerdPolicyListApi herdPolicyListApi;
    @Autowired
    private PlantingInsuranceListApi plantingInsuranceListApi;
    @Autowired
    InsureMainListApi insureMainListApi;
    @Autowired
    GYLossRateMainApi gyLossRateMainApi;
    @Autowired
    LossRateMainListApi lossRateMainListApi;
    @Autowired
    private PlantingExcelApi plantingExcelApi;
    @Autowired
    private PrpLRegistDao prpLRegistDao;

    /**
     * 上传文件到文件服务器
     *
     * @return
     * @author 杨璐
     * @date 2018年01月02日
     */
    @Override
    public Map<String, String> uploadFile(MultipartFile multipartFile) throws Exception {
//		if (multipartFile == null) {
//			throw new DataVerifyException("文件不能为空");
//
//		}
//		File file = null;
//		Map<String, String> resultMap = null;
//		Map<String, String> otherParams = null;
//			resultMap = new HashMap<>();
//		try {
//			FileItemFactory factory = new DiskFileItemFactory();
//
//			ServletFileUpload fileload = new ServletFileUpload(factory);
//
//			fileload.setHeaderEncoding("utf-8");
//			// 获取文件原名
//			String fileName = multipartFile.getOriginalFilename();
//			fileName = fileName.substring(0, fileName.indexOf("."));
//			fileName = "清单文件"+System.currentTimeMillis();
//			file = File.createTempFile(fileName, ExcelConst.XLS_SUFFIX);
//			multipartFile.transferTo(file);
//			otherParams = new HashMap<String, String>();
//			otherParams.put("userCode", "00000000");
//			otherParams.put("systemId", "agriclaim");
//			otherParams.put("bussType", "tmp");
//			FileServerHelper helper = new FileServerHelper();
//			// 上传文件到文件服务器
//			Map<String, String> fileResult = FileServerHelper.uploadFile(fileServiceUrl + "/uploadFile", file,
//					otherParams);
//			if (fileResult != null && StringUtils.isNotEmpty(fileResult.get("fileId"))) {
//				resultMap.put("fileId", fileResult.get("fileId"));
//				resultMap.put("fileName", "理赔定损清单");
//			} else {
//				throw new BusinessException("未获取到文件号码");
//			}
//		} finally {
//			// 删除本地的临时文件
//			if (file != null) {
//				file.delete();
//			}
//	}
//		return resultMap;
        if (multipartFile == null) {
            throw new DataVerifyException("文件不能为空");
        }
        File file = null;
        Map<String, String> resultMap = null;
        Map<String, String> otherParams = null;
        String fileName = multipartFile.getOriginalFilename();
        try {
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
            file = File.createTempFile(fileName, ExcelConst.XLS_SUFFIX);
            resultMap = new HashMap<>();
            multipartFile.transferTo(file);
            otherParams = new HashMap<String, String>();
            otherParams.put("userCode", "00000000");
            otherParams.put("systemId", "agri/tempfile");
            otherParams.put("bussType", "tmp");
            // 上传文件到文件服务器
            Map<String, String> fileResult = FileServerHelper.uploadFile(fileServiceUrl + "/uploadFile", file, otherParams);
            if (fileResult != null && StringUtils.isNotEmpty(fileResult.get("fileId"))) {
                resultMap.put("fileId", fileResult.get("fileId"));
                resultMap.put("fileName", "预投保清单");
            } else {
                throw new BusinessException("未获取到文件号码");
            }
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return resultMap;
    }

    /**
     * 解析养殖险excel文件
     *
     * @author: 杨璐
     * @date: 2018年01月03日
     * @param：map @return：
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String,Object> readBreedExcelContent(RequestImportDto requestImportDto) throws Exception {
        Map<String, String> message = new HashMap<>();
        File file = null;
        Map<String, String> otherParams = new HashMap<>();
        Map<String,Object> map=new HashMap<>();
        SaveBleedingRateImportDto saveBleedingRateImportDto = null;
        Map<String, String> paramMap = new HashMap<>();
        PageInfo<BreedLossRateListDto> queryBreedLossRateListDtoByListNo = null;
        try {
            file = File.createTempFile(requestImportDto.getFileName(), ExcelConst.XLS_SUFFIX);
            otherParams.put("fileId", requestImportDto.getFileId());
            FileServerHelper.dowloadFileByFileId(fileServiceUrl + "/downloadFile", file, otherParams);
            if(requestImportDto.getRegistNo()!=null){
                lossRateMainListApi.queryByPolicyNo(requestImportDto.getPolicyNo(), requestImportDto.getNodeOrigin(),requestImportDto.getRegistNo());
            }
            saveBleedingRateImportDto = this.readBreedExcelUtils(requestImportDto, file);
            LossRateListDto lossRateListDto = saveBleedingRateImportDto.getLossRateListDto();
            LossRateWholeListDto requestGYLossRateAllListDto = saveBleedingRateImportDto.getRequestGYLossRateAllListDto();
            gyLossRateMainApi.saveLossRateAllList(requestGYLossRateAllListDto);
            lossRateListApi.save(lossRateListDto);
            /*for (BreedLossRateListDto breedRateDto : saveBleedingRateImportDto.getBreedLossRateListDto()) {
                breedLossRateListApi.save(breedRateDto);
            }*/
            String listNo = saveBleedingRateImportDto.getLossRateListDto().getListNo();
            /*paramMap.put("listNo", listNo);
            paramMap.put("pageNo", requestImportDto.getPageNo());
            paramMap.put("pageSize", requestImportDto.getPageSize());
            queryBreedLossRateListDtoByListNo = breedLossRateListApi.queryBreedLossRateListDtoByListNo(paramMap);*/
            //统计lossrateitemlist里面农户代码的数量
            List<LossRateLossListDto> lossRateLossListDtoList = requestGYLossRateAllListDto.getLossRateLossListDtoList();
            //多少个农户出险户次即为多少
            List<String> list=new ArrayList<>();
            for (LossRateLossListDto lossRateLossListDto : lossRateLossListDtoList) {
                list.add(lossRateLossListDto.getfCode());
            }
            Set set = new  HashSet();
            List newList = new  ArrayList();
            for (String cd:list) {
                if(set.add(cd)){
                    newList.add(cd);
                }
            }
            map.put("listNo",listNo);
            //出险户次
            map.put("damageInsured",newList.size());
        } finally {
            if (file != null) {
                file.delete();
            }
        }
        return map;
    }

    /**
     * 解析excel文件
     *
     * @author: 杨璐
     * @date: 2017/11/27 上午 9:13
     * @param：requestDto @return：
     * @throws：Exception
     */
    private SaveBleedingRateImportDto readBreedExcelUtils(RequestImportDto requestImportDto, File file)
            throws Exception {
        String filepath = file.getCanonicalPath();
        //String ext = filepath.substring(filepath.lastIndexOf("."));
        SaveBleedingRateImportDto saveBleedingRateImportDto = null;

        InputStream is = null;
        Workbook wb = null;
        try {
            try{
                is = new FileInputStream(filepath);
                wb = new HSSFWorkbook(is);
            }catch (Exception e){
                is = new FileInputStream(filepath);
                wb = new XSSFWorkbook(is);
            }
            saveBleedingRateImportDto = this.readBreedingExcelContent(wb, requestImportDto);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        return saveBleedingRateImportDto;
    }

    /**
     * 解析养殖险excel文件
     *
     * @author: 杨璐
     * @date: 2018年01月03日 @param： wb
     * @param：map @return：
     * @throws：Exception
     */
    private SaveBleedingRateImportDto readBreedingExcelContent(Workbook wb, RequestImportDto requestImportDto)
            throws Exception {
        if (wb == null) {
            throw new Exception("wb对象为空");
        }
        SaveBleedingRateImportDto saveBleedingRateImportDto = new SaveBleedingRateImportDto();
        List<BreedLossRateListDto> breedLossDtoRateList = new ArrayList<>();
        List<EarNoCheckRequestDto> EarNoCheckRequestDtoList = new ArrayList<>();
        LossRateWholeListDto lossRateWholeListDto = new LossRateWholeListDto();
        List<LossRateItemListDto> lossRateItemListDtos = new ArrayList<>();//标的表
        List<LossRateLossListDto> lossRateLossListDtos = new ArrayList<>();//损失数量
        List<LossRateHerdListDto> lossRateHerdListDtos = new ArrayList<>();//耳标号
        LossRateMainListDto lossRateMainListDto = new LossRateMainListDto();//主表
        Sheet sheetAt = wb.getSheetAt(0);
        LossRateListDto lossRateListDto = new LossRateListDto();
        lossRateListDto.setListName(StringUtils.substringBeforeLast(requestImportDto.getFileName(), "."));
        int lastRowNum = sheetAt.getLastRowNum();
        Row row = sheetAt.getRow(0);
        int column = row.getPhysicalNumberOfCells();
        String createTempBizNo=null;
         createTempBizNo = this.createTempBizNo(requestImportDto);
        lossRateListDto.setListNo(createTempBizNo);
        lossRateMainListDto.setListCreateTime(new Date());
        lossRateMainListDto.setOpCode(requestImportDto.getUserCode());
        lossRateMainListDto.setOpName(requestImportDto.getUserName());
        lossRateMainListDto.setAffirmOpCode(requestImportDto.getUserCode());
        lossRateMainListDto.setAffirmOpName(requestImportDto.getUserName());
        lossRateMainListDto.setPolicyNo(requestImportDto.getPolicyNo());
//		lossRateMainListDto.setCheckBoxFlag("1");
        lossRateMainListDto.setNodeOrigin(requestImportDto.getNodeOrigin());
        Map<String, String> lossRateMainListMap = new HashMap<>();
        List<LossRateMainListDto> lossRateMainListDto1=new ArrayList<>();
        if(requestImportDto.getRegistNo()!=null){
            lossRateMainListDto1 = lossRateMainListApi.queryByregistNo(requestImportDto.getRegistNo());
        }
        Integer serial=null;
        if(lossRateMainListDto1.size()>0 && lossRateMainListDto1!=null){
            createTempBizNo = lossRateMainListDto1.get(0).getLossListCode();
            lossRateMainListMap.put("lossListCode", createTempBizNo);
            serial = lossRateMainListApi.queryMaxSerialByLossListCode(lossRateMainListMap);
            lossRateMainListDto.setLossListCode(createTempBizNo);
        }else{
            lossRateMainListDto.setLossListCode(createTempBizNo);
        }
        if (serial != null) {
            lossRateMainListDto.setSerialNo(serial + 1);
        } else {
            lossRateMainListDto.setSerialNo(1);
        }
        Map<String, String> map = new HashMap<>();
        map.put("riskCode", requestImportDto.getRiskCode());
        List<PrpDkindDto> kinds = prpDkindApi.queryByRiskCode(map);
        for (int i = 3; i <= lastRowNum; i++) {
            row = sheetAt.getRow(i);
            BreedLossRateListDto breedLossRateDto = new BreedLossRateListDto();
            EarNoCheckRequestDto earNoCheckRequestDto = new EarNoCheckRequestDto();
            LossRateItemListDto lossRateItemListDto = new LossRateItemListDto();//标的
            LossRateLossListDto lossRateLossListDto = new LossRateLossListDto();//损失数量
            LossRateHerdListDto lossRateHerdListDto = new LossRateHerdListDto();//耳标号
            breedLossRateDto.setListNo(createTempBizNo);
            lossRateItemListDto.setLossListCode(createTempBizNo);
            lossRateLossListDto.setLossListCode(createTempBizNo);
            lossRateHerdListDto.setLossListCode(createTempBizNo);
            lossRateListDto.setPolicyNo(requestImportDto.getPolicyNo());
            breedLossRateDto.setPolicyNo(requestImportDto.getPolicyNo());
            lossRateListDto.setRegistNo(requestImportDto.getRegistNo());
            breedLossRateDto.setRegistNo(requestImportDto.getRegistNo());
            earNoCheckRequestDto.setPolicyNo(requestImportDto.getPolicyNo());
            if(serial!=null){
                lossRateItemListDto.setSerialNo(serial+1);
                lossRateLossListDto.setSerialNo(serial+1);
                lossRateHerdListDto.setSerialNo(serial+1);
            }else{
                lossRateItemListDto.setSerialNo(1);
                lossRateLossListDto.setSerialNo(1);
                lossRateHerdListDto.setSerialNo(1);
            }
            earNoCheckRequestDto.setKindCode(kinds != null && kinds.size() > 0 ? kinds.get(0).getKindCode() : "");
            earNoCheckRequestDto.setDamageStartDate(requestImportDto.getDamageStartDate());
            if (StringUtils.isNotEmpty(requestImportDto.getDamageStartHour())) {
                earNoCheckRequestDto.setDamageStartHour(requestImportDto.getDamageStartHour().split(":")[0]);
            }
            String policyNo = null;
            String fCode = null;
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                Cell cell = row.getCell(j);
                switch (j) {
                    case 0:
                        String serialNo = cell.getStringCellValue();
                        if (StringUtils.isNotEmpty(serialNo)) {
                            lossRateLossListDto.setLossSerialNo(Integer.parseInt(serialNo));
                            lossRateHerdListDto.setLossSerialNo(Integer.parseInt(serialNo));
                            breedLossRateDto.setSerialNo(serialNo);
                            break;
                        } else {
                            throw new BusinessException("序号不能为空");

                        }
                    case 1:
                        String lossListCode = cell.getStringCellValue();
                        break;
                    case 2:
                        policyNo = cell.getStringCellValue();
                        if (StringUtils.isNotEmpty(policyNo)) {

                            breedLossRateDto.setPolicyNo(policyNo);
                            break;
                        } else {
                            throw new BusinessException("保单号不能为空");

                        }
                    case 3:
                        String registNo = cell.getStringCellValue();
                        if (StringUtils.isNotEmpty(registNo)) {
                            lossRateMainListDto.setBizNo(registNo);
                            breedLossRateDto.setRegistNo(registNo);
                        }else if(requestImportDto.getRegistNo()!=null&&StringUtils.isEmpty(registNo)){
                            throw new BusinessException("报案号不能为空!");
                        }
                        break;
//						else {
//							throw new BusinessException("报案号不能为空");
//
//						}

                    case 4:
                        fCode = cell.getStringCellValue();
                        if (StringUtils.isNotEmpty(fCode)) {
                            breedLossRateDto.setfCode(fCode);
                            lossRateItemListDto.setfCode(fCode);
                            lossRateLossListDto.setfCode(fCode);
                            lossRateHerdListDto.setfCode(fCode);
                            break;
                        } else {
                            throw new BusinessException("农户代码不能为空");
                        }
                    case 5:
                        String fName = cell.getStringCellValue();
                        if (StringUtils.isNotEmpty(fName)) {
                            breedLossRateDto.setfName(fName);
                            lossRateItemListDto.setfName(fName);
                            break;
                        } else {
                            throw new BusinessException("农户姓名不能为空");
                        }
                    case 6:
                        String fIdCard = cell.getStringCellValue();
                        if (StringUtils.isNotEmpty(fIdCard)) {
                            lossRateItemListDto.setfIdCard(fIdCard);
                            break;
                        } else {
                            throw new BusinessException("证件号码不能为空");
                        }
                    case 7:
                        String itemCode = cell.getStringCellValue();
                        if(StringUtils.isNotEmpty(itemCode)){
                            String[] split = itemCode.split("-");
                            lossRateItemListDto.setItemCode(split[0]);
                            lossRateLossListDto.setItemCode(split[0]);
                            lossRateHerdListDto.setItemCode(split[0]);
                        }else{
                            throw new BusinessException("标的代码不能为空！");
                        }
                    case 8:
                        String earConNo = cell.getStringCellValue();
                        if (StringUtils.isNotEmpty(earConNo)) {
                            breedLossRateDto.setEarConNo(earConNo);
                            earNoCheckRequestDto.setEarNo(earConNo);
                            lossRateHerdListDto.setEarLabel(earConNo);
                            break;
                        } else {
                            throw new BusinessException("耳标号不能为空");
                        }
                    case 9:
                        String payAmount = cell.getStringCellValue();
                        if (StringUtils.isNotEmpty(payAmount)) {
                            breedLossRateDto.setPayAmount(Double.valueOf(payAmount));
                            lossRateLossListDto.setLossMoney(Double.valueOf(payAmount));
                            break;
                        } else {
                            throw new BusinessException("赔偿金额不能为空");
                        }
                    case 10:
                        String remark = cell.getStringCellValue();
                        if (StringUtils.isNotEmpty(remark)) {
                            breedLossRateDto.setRemark(remark);
                            lossRateMainListDto.setRemark(remark);
                            break;
                        }
                }

            }


            //标的代码查询
            /*List<InsureMainListDto> insureMainListDtos = insureMainListApi.queryByPolicyNo(policyNo);
            String inusreListCode = insureMainListDtos.get(0).getInusreListCode();
            if (StringUtils.isNotEmpty(inusreListCode)) {
                HerdPolicyListDto herdPolicyListDto = herdPolicyListApi.queryByInusreListCodeAndFcode(inusreListCode, fCode);
                if (herdPolicyListDto != null) {
                    lossRateItemListDto.setItemCode(herdPolicyListDto.getItemCode());
                    lossRateLossListDto.setItemCode(herdPolicyListDto.getItemCode());
                    lossRateHerdListDto.setItemCode(herdPolicyListDto.getItemCode());
                }
            }*/
            lossRateLossListDto.setLossAmount(Double.valueOf(lastRowNum) - 1);
            breedLossDtoRateList.add(breedLossRateDto);
            EarNoCheckRequestDtoList.add(earNoCheckRequestDto);
            lossRateItemListDtos.add(lossRateItemListDto);
            lossRateLossListDtos.add(lossRateLossListDto);
            lossRateHerdListDtos.add(lossRateHerdListDto);
        }

        //校验定损清单要和承保清单的一致性
        //根据保单号查询承保清单
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,String> param=new HashMap<>();
        param.put("policyNo",requestImportDto.getPolicyNo());
        List<AcceptInsuranceDto> acceptInsuranceDtos =null;
        if(StringUtils.isEmpty(lossRateMainListDto.getBizNo())){
            //报案登记的时候取出险时间为当前时间
            param.put("validDate",simpleDateFormat.format(new Date()));
            acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(param);
        }else{
            //查询出险时间
            PrpLRegist prplRegist = prpLRegistDao.findByRegistNo(lossRateMainListDto.getBizNo());
            param.put("validDate",simpleDateFormat.format(prplRegist.getDamageStartDate()));
            acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(param);
        }
        //组装养殖险的定损清单数据
        if(acceptInsuranceDtos==null||acceptInsuranceDtos.size()==0){
            throw new Exception("无保单清单!");
        }
        /*比较农户代码，农户名称，耳标号。 */
        for (BreedLossRateListDto breedLossRateListDto : breedLossDtoRateList) {
            boolean flag1=true;
            for (AcceptInsuranceDto acceptInsuranceDto : acceptInsuranceDtos) {
                if(breedLossRateListDto.getfCode().equals(acceptInsuranceDto.getfCode())&&
                        breedLossRateListDto.getfName().equals(acceptInsuranceDto.getfName())&&
                        breedLossRateListDto.getEarConNo().equals(acceptInsuranceDto.getEarlAbel())
                        ){
                    flag1=false;
                    break;
                }
            }
            if(flag1){
                throw new BusinessException("耳标号"+breedLossRateListDto.getEarConNo()+"农户代码、农户名称、耳标号与承保清单不一致！");
            }
        }
        /*if(flag1){
            throw new BusinessException("耳标号"+earConNo+"农户代码、农户名称、耳标号与承保清单不一致！");
        }*/

        lossRateWholeListDto.setLossRateMainListDto(lossRateMainListDto);
        lossRateWholeListDto.setLossRateItemListDtoList(lossRateItemListDtos);
        lossRateWholeListDto.setLossRateLossListDtoList(lossRateLossListDtos);
        lossRateWholeListDto.setLossRateHerdListDtoList(lossRateHerdListDtos);
        // 耳标号校验
        /*for (EarNoCheckRequestDto earNoCheckRequestDto : EarNoCheckRequestDtoList) {
            EarNoCheckResponseDto earNoCheck = checkApi.earNoCheck(earNoCheckRequestDto);
            if (StringUtils.isEmpty(earNoCheck.toString())) {
                throw new DataVerifyException(earNoCheckRequestDto.getEarNo() + "没有找到相应的数据");

            }

        }*/

        saveBleedingRateImportDto.setBreedLossRateListDto(breedLossDtoRateList);
        saveBleedingRateImportDto.setLossRateListDto(lossRateListDto);
        saveBleedingRateImportDto.setRequestGYLossRateAllListDto(lossRateWholeListDto);
        return saveBleedingRateImportDto;
    }

    /**
     * 生成理赔预确认清单清单号
     *
     * @author: 杨璐
     * @date: 2017/11/27 上午 9:13
     * @param： riskCode
     * @param： comCode
     * @param： userCode
     * @return：
     * @throws： Exception
     */
    private String createTempBizNo(RequestImportDto requestImportDto) throws Exception {
        BillNoDto billNoDto = new BillNoDto();
        String intYear = new DateTime(new Date(), DateTime.YEAR_TO_YEAR).toString();
        billNoDto.setTableName("lossRateMainList");
        billNoDto.setRiskCode(requestImportDto.getRiskCode());
        billNoDto.setiComCode(SinoRequestContext.getCurrentContext().getUser().getLoginComCode());
        billNoDto.setiYear(intYear);
        billNoDto.setUserCode(SinoRequestContext.getCurrentContext().getUser().getUserCode());
        if (StringUtils.isEmpty(billNoDto.getUserCode())) {
            billNoDto.setUserCode("00000000");
        }
        if (StringUtils.isEmpty(billNoDto.getiComCode())) {
            billNoDto.setiComCode("00000000");

        }
        billNoDto.setiYear(intYear);
        Map<String, String> map = billNoApi.getBillNo(billNoDto);
        String strTempBizNo = map.get("billNo");
        return strTempBizNo;
    }

    /**
     * 解析种植险excel文件
     *
     * @author: 杨璐
     * @date: 2018年01月04日 @param： wb
     * @param：requestDto @return：
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String,Object> readPlantingExcelContent(RequestImportDto requestImportDto) throws Exception {
        File file = null;
        Map<String, String> otherParams = new HashMap<>();
        Map<String, String> paramMap = new HashMap<>();

        SavePlantingRateListImportDto savePlantingRateListImportDto = null;
        file = File.createTempFile(requestImportDto.getFileName(), ExcelConst.XLS_SUFFIX);
        otherParams.put("fileId", requestImportDto.getFileId());
        if(requestImportDto.getRegistNo()!=null){
            lossRateMainListApi.queryByPolicyNo(requestImportDto.getPolicyNo(), requestImportDto.getNodeOrigin(),requestImportDto.getRegistNo());
        }
        FileServerHelper.dowloadFileByFileId(fileServiceUrl + "/downloadFile", file, otherParams);
        savePlantingRateListImportDto = this.readPlantingExcelUtils(requestImportDto, file);
        String listNo = savePlantingRateListImportDto.getLossRateListDto().getListNo();
        LossRateWholeListDto lossRateWholeListDto = savePlantingRateListImportDto.getRequestGYLossRateAllListDto();

        gyLossRateMainApi.saveLossRateAllList(lossRateWholeListDto);
        lossRateListApi.save(savePlantingRateListImportDto.getLossRateListDto());
        /*Map<String, String> savePlantingLossRateList = plantingLossRateListApi
                .savePlantingLossRateList(savePlantingRateListImportDto.getPlantingLossRateListDto());

        if (savePlantingLossRateList == null) {
            throw new BusinessException("种殖险定损清单保存失败");
        }*/
        /*paramMap.put("listNo", listNo);
        paramMap.put("pageNo", requestImportDto.getPageNo());
        paramMap.put("pageSize", requestImportDto.getPageSize());
        PageInfo<PlantingLossRateListDto> pageInfo = plantingLossRateListApi.queryPlantingLossRateListByListNo(paramMap);*/
        //统计lossrateitemlist里面农户代码的数量
        List<LossRateLossListDto> lossRateLossListDtoList = lossRateWholeListDto.getLossRateLossListDtoList();
        //多少个农户出险户次即为多少
        List<String> list=new ArrayList<>();
        for (LossRateLossListDto lossRateLossListDto : lossRateLossListDtoList) {
            list.add(lossRateLossListDto.getfCode());
        }
        Set set = new  HashSet();
        List newList = new  ArrayList();
        for (String cd:list) {
            if(set.add(cd)){
                newList.add(cd);
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("listNo",listNo);
        //出险户次
        map.put("damageInsured",newList.size());
        return map;
    }

    /**
     * 解析种植险excel文件
     *
     * @author: 杨璐
     * @date: 2018年01月03日 @param： wb
     * @param：map @return：
     * @throws：Exception
     */
    private SavePlantingRateListImportDto readPlantingExcelUtils(RequestImportDto requestImportDto, File file)
            throws Exception {
        String filepath = file.getCanonicalPath();
        String ext = filepath.substring(filepath.lastIndexOf("."));
        SavePlantingRateListImportDto savePlantingRateListImportDto = null;
        InputStream is = null;
        Workbook wb = null;
        try {
            try{
                is = new FileInputStream(filepath);
                wb = new HSSFWorkbook(is);
            }catch (Exception e){
                is = new FileInputStream(filepath);
                wb = new XSSFWorkbook(is);
            }
            savePlantingRateListImportDto = this.readPlantingingExcelContent(wb, requestImportDto);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        return savePlantingRateListImportDto;
    }

    /**
     * 解析种植险excel文件
     *
     * @author: 杨璐
     * @date: 2018年01月04日 @param： wb
     * @param：map @return：
     * @throws：Exception
     */
    private SavePlantingRateListImportDto readPlantingingExcelContent(Workbook wb, RequestImportDto requestImportDto)
            throws Exception {
        if (wb == null) {
            throw new Exception("wb对象为空");
        }
        SavePlantingRateListImportDto savePlantingRateListImportDto = new SavePlantingRateListImportDto();
        List<PlantingLossRateListDto> PlantingLossRateListDtoLists = new ArrayList<>();
        LossRateWholeListDto lossRateWholeListDto = new LossRateWholeListDto();
        List<LossRateItemListDto> lossRateItemListDtos = new ArrayList<>();//标的表
        List<LossRateLossListDto> lossRateLossListDtos = new ArrayList<>();//损失数量
        LossRateMainListDto lossRateMainListDto = new LossRateMainListDto();//主表
        List<LossRatePersListDto> lossRatePersListDtos=null;//连带被保险人人物明细表
        List<PlantingLossRateListCheckDto> plantingLossRateListCheckDtos=new ArrayList<>();//种植险定损清单校验的dto
        if("3129".equals(requestImportDto.getRiskCode())){
            lossRatePersListDtos=new ArrayList<>();
        }
        //理赔清单信息主表Api操作对象
        LossRateListDto lossRateListDto = new LossRateListDto();
        Sheet sheetAt = wb.getSheetAt(0);
        // 总行数
        int lastRowNum = sheetAt.getLastRowNum();
        Row row = sheetAt.getRow(0);
        lossRateListDto.setListName(StringUtils.substringBeforeLast(requestImportDto.getFileName(), "."));
        int column = row.getPhysicalNumberOfCells();
        String createTempBizNo = this.createTempBizNo(requestImportDto);
        lossRateListDto.setListNo(createTempBizNo);
        lossRateMainListDto.setLossListCode(createTempBizNo);
        lossRateMainListDto.setListCreateTime(new Date());
        lossRateMainListDto.setOpCode(requestImportDto.getUserCode());
        lossRateMainListDto.setOpName(requestImportDto.getUserName());
        lossRateMainListDto.setAffirmOpCode(requestImportDto.getUserCode());
        lossRateMainListDto.setAffirmOpName(requestImportDto.getUserName());
        lossRateMainListDto.setPolicyNo(requestImportDto.getPolicyNo());
//		lossRateMainListDto.setCheckBoxFlag("1");
        lossRateMainListDto.setNodeOrigin(requestImportDto.getNodeOrigin());
        Map<String, String> lossRateMainListMap = new HashMap<>();
        List<LossRateMainListDto> lossRateMainListDto1=new ArrayList<>();
        if(requestImportDto.getRegistNo()!=null){
            lossRateMainListDto1 = lossRateMainListApi.queryByregistNo(requestImportDto.getRegistNo());
        }
        Integer serial=null;
        if(lossRateMainListDto1.size()>0 && lossRateMainListDto1!=null){
            createTempBizNo = lossRateMainListDto1.get(0).getLossListCode();
            lossRateMainListMap.put("lossListCode", createTempBizNo);
            serial = lossRateMainListApi.queryMaxSerialByLossListCode(lossRateMainListMap);
            lossRateMainListDto.setLossListCode(createTempBizNo);
        }else{
            lossRateMainListDto.setLossListCode(createTempBizNo);
        }
        if (serial != null) {
            lossRateMainListDto.setSerialNo(serial + 1);
        } else {
            lossRateMainListDto.setSerialNo(1);
        }
        if (serial != null) {
            lossRateMainListDto.setSerialNo(serial + 1);
        } else {
            lossRateMainListDto.setSerialNo(1);
        }
        for (int i = 3; i <= lastRowNum; i++) {
            row = sheetAt.getRow(i);
            //定损清单信息表Api操作对象
            PlantingLossRateListDto plantingLossRateListDto = new PlantingLossRateListDto();
            LossRateItemListDto lossRateItemListDto = new LossRateItemListDto();//标的
            LossRateLossListDto lossRateLossListDto = new LossRateLossListDto();//损失数量
            PlantingLossRateListCheckDto plantingLossRateListCheckDto = new PlantingLossRateListCheckDto();//定损清单校验的dto
            LossRatePersListDto lossRatePersListDto=null;
            if("3129".equals(requestImportDto.getRiskCode())){
                lossRatePersListDto=new LossRatePersListDto();
                lossRatePersListDto.setLossListCode(createTempBizNo);
            }
            lossRateItemListDto.setLossListCode(createTempBizNo);
            lossRateLossListDto.setLossListCode(createTempBizNo);
            plantingLossRateListDto.setListNo(createTempBizNo);
            lossRateListDto.setPolicyNo(requestImportDto.getPolicyNo());
            plantingLossRateListDto.setPolicyNo(requestImportDto.getPolicyNo());
            lossRateListDto.setRegistNo(requestImportDto.getRegistNo());
            plantingLossRateListDto.setRegistNo(requestImportDto.getRegistNo());
            plantingLossRateListDto.setListNo(createTempBizNo);
            if(serial!=null){
                lossRateItemListDto.setSerialNo(serial+1);
                lossRateLossListDto.setSerialNo(serial+1);
                if("3129".equals(requestImportDto.getRiskCode())){
                    lossRatePersListDto.setSerialNo(serial+1);
                }
            }else{
                lossRateItemListDto.setSerialNo(1);
                lossRateLossListDto.setSerialNo(1);
                if("3129".equals(requestImportDto.getRiskCode())){
                    lossRatePersListDto.setSerialNo(1);
                }
            }
            String policyNo = null;
            String fCode = null;
            String kindCode=null;
            if("3129".equals(requestImportDto.getRiskCode())){
                //草莓组合保险
                for (int j = 0; j < column; j++) {
                    Cell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    switch (j) {
                        case 0:
                            String serialNo = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(serialNo)) {
                                lossRateLossListDto.setLossSerialNo(Integer.parseInt(serialNo));
                                plantingLossRateListDto.setSerialNo(serialNo);
                                lossRatePersListDto.setLossSerialNo(Integer.parseInt(serialNo));
                                plantingLossRateListCheckDto.setSerialNo(serialNo);
                                break;
                            } else {
                                throw new BusinessException("序号不能为空");
                            }

                        case 1:
                            String lossListCode = cell.getStringCellValue();//清单号
                            break;
                        case 2:
                            policyNo = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(policyNo)) {
                                plantingLossRateListDto.setPolicyNo(policyNo);
                                ;
                                break;
                            } else {
                                throw new BusinessException("保单号不能为空");
                            }
                        case 3:
                            String registNo = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(registNo)) {
                                plantingLossRateListDto.setRegistNo(registNo);
                                ;
                                lossRateMainListDto.setBizNo(registNo);

                            }else if(requestImportDto.getRegistNo()!=null&&StringUtils.isEmpty(registNo)){
                                throw new BusinessException("报案号不能为空");
                            }
                            break;
//						else {
//							throw new BusinessException("报案号号不能为空");
//						}

                        case 4:
                            fCode = cell.getRichStringCellValue().getString().trim();
                            if (StringUtils.isNotEmpty(fCode)) {
                                plantingLossRateListDto.setfCode(fCode);
                                lossRateItemListDto.setfCode(fCode);
                                lossRateLossListDto.setfCode(fCode);
                                lossRatePersListDto.setfCode(fCode);
                                plantingLossRateListCheckDto.setfCode(fCode);
                                break;
                            } else {
                                throw new BusinessException("农户代码不能为空");
                            }
                        case 5:
                            String fName = cell.getRichStringCellValue().getString().trim();
                            if (StringUtils.isNotEmpty(fName)) {
                                plantingLossRateListDto.setfName(fName);
                                lossRateItemListDto.setfName(fName);
                                plantingLossRateListCheckDto.setfName(fName);
                                break;
                            } else {
                                throw new BusinessException("农户姓名不能为空");
                            }
                        case 6:
                            String fidCard = cell.getRichStringCellValue().getString().trim();
                            if (StringUtils.isNotEmpty(fidCard)) {
                                lossRateItemListDto.setfIdCard(fidCard);
                                break;
                            } else {
                                throw new BusinessException("证件号码不能为空");
                            }
                        case 7:
                            plantingLossRateListDto.setFieldNo("1");//plantingLossRateList表田块代码不能为空，但是这个表不需要
                            String itemCode = cell.getStringCellValue().trim();
                            if (StringUtils.isNotEmpty(itemCode)) {
                                String[] split = itemCode.split("-");
                                lossRateItemListDto.setItemCode(split[0]);
                                lossRateLossListDto.setItemCode(split[0]);
                                lossRatePersListDto.setItemCode(split[0]);
                                plantingLossRateListCheckDto.setItemCode(split[0]);
                                break;
                            } else {
                                throw new BusinessException("标的不能为空");
                            }
                        case 8:
                            String insureArea = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(insureArea)) {
                                plantingLossRateListDto.setInsureArea(Double.valueOf(insureArea));
                                plantingLossRateListCheckDto.setInsureArea(Double.valueOf(insureArea));
                                break;
                            } else {
                                throw new BusinessException("承保面积不能为空");
                            }
                        case 9:
                            String lossArea = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(lossArea)) {
                                plantingLossRateListDto.setLossArea(Double.valueOf(lossArea));
                                lossRateLossListDto.setLossAmount(Double.valueOf(lossArea));
                                plantingLossRateListCheckDto.setLossArea(Double.valueOf(lossArea));
                                break;
                            } else {
                                throw new BusinessException("损失面积不能为空");
                            }
                        case 10:
                            String lossRate = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(lossRate)) {
                                plantingLossRateListDto.setLossRate(Double.valueOf(lossRate));
                                lossRateLossListDto.setLossRate(Double.valueOf(lossRate));
                                plantingLossRateListCheckDto.setLossRate(Double.valueOf(lossRate));
                                break;
                            } else {
                                throw new BusinessException("损失率不能为空");
                            }
                        case 11:
                            String name = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(name)) {
                                lossRatePersListDto.setName(name);
                                break;
                            }
                        case 12:
                            String idCard=cell.getRichStringCellValue().getString();
                            if(StringUtils.isNotEmpty(idCard)){
                                lossRatePersListDto.setIdCard(idCard);
                                break;
                            }else{
                                throw new BusinessException("连带被保险人证件号不能为空");
                            }
                        case 13:
                            String lossMoney = cell.getStringCellValue();//赔偿金额
                            if (StringUtils.isNotEmpty(lossMoney)) {
                                lossRateLossListDto.setLossMoney(Double.valueOf(lossMoney));
                                break;
                            }
                        case 14:
                            String versionNo = cell.getStringCellValue();//合同编号
                            if (StringUtils.isNotEmpty(versionNo)) {
                                lossRateLossListDto.setVersionNo(versionNo);
                                break;
                            }
                        case 15:
                            String remark = cell.getRichStringCellValue().getString().trim();
                            if (StringUtils.isNotEmpty(remark)) {
                                plantingLossRateListDto.setRemark(remark);
                                lossRateMainListDto.setRemark(remark);
                            }
                            break;
                    }
                }
            }else{
                //其它
                for (int j = 0; j < column; j++) {
                    Cell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    switch (j) {
                        case 0:
                            String serialNo = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(serialNo)) {
                                lossRateLossListDto.setLossSerialNo(Integer.parseInt(serialNo));
                                plantingLossRateListDto.setSerialNo(serialNo);
                                plantingLossRateListCheckDto.setSerialNo(serialNo);
                                break;
                            } else {
                                throw new BusinessException("序号不能为空");
                            }

                        case 1:
                            String lossListCode = cell.getStringCellValue();//清单号
                            break;
                        case 2:
                            policyNo = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(policyNo)) {
                                plantingLossRateListDto.setPolicyNo(policyNo);
                                ;
                                break;
                            } else {
                                throw new BusinessException("保单号不能为空");
                            }
                        case 3:
                            String registNo = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(registNo)) {
                                plantingLossRateListDto.setRegistNo(registNo);
                                ;
                                lossRateMainListDto.setBizNo(registNo);

                            }else if(requestImportDto.getRegistNo()!=null&&StringUtils.isEmpty(registNo)){
                                throw new BusinessException("报案号不能为空");
                            }
                            break;
//						else {
//							throw new BusinessException("报案号号不能为空");
//						}

                        case 4:
                            fCode = cell.getRichStringCellValue().getString().trim();
                            if (StringUtils.isNotEmpty(fCode)) {
                                plantingLossRateListDto.setfCode(fCode);
                                lossRateItemListDto.setfCode(fCode);
                                lossRateLossListDto.setfCode(fCode);
                                plantingLossRateListCheckDto.setfCode(fCode);
                                break;
                            } else {
                                throw new BusinessException("农户代码不能为空");
                            }
                        case 5:
                            String fName = cell.getRichStringCellValue().getString().trim();
                            if (StringUtils.isNotEmpty(fName)) {
                                plantingLossRateListDto.setfName(fName);
                                lossRateItemListDto.setfName(fName);
                                plantingLossRateListCheckDto.setfName(fName);
                                break;
                            } else {
                                throw new BusinessException("农户姓名不能为空");
                            }
                        case 6:
                            String fidCard = cell.getRichStringCellValue().getString().trim();
                            if (StringUtils.isNotEmpty(fidCard)) {
                                lossRateItemListDto.setfIdCard(fidCard);
                                break;
                            } else {
                                throw new BusinessException("证件号码不能为空");
                            }
                    /*case 7:
                        String fieldNo = cell.getRichStringCellValue().getString().trim();
                        if (StringUtils.isNotEmpty(fieldNo)) {
                            plantingLossRateListDto.setFieldNo(fieldNo);
                            ;
                        }
                        break;*/
                        case 7:
                            plantingLossRateListDto.setFieldNo("1");//plantingLossRateList表田块代码不能为空，但是这个表不需要
                            String itemCode = cell.getStringCellValue().trim();
                            if (StringUtils.isNotEmpty(itemCode)) {
                                String[] split = itemCode.split("-");
                                lossRateItemListDto.setItemCode(split[0]);
                                lossRateLossListDto.setItemCode(split[0]);
                                plantingLossRateListCheckDto.setItemCode(split[0]);
                                break;
                            } else {
                                throw new BusinessException("标的不能为空");
                            }
                        case 8:
                            String insureArea = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(insureArea)) {
                                plantingLossRateListDto.setInsureArea(Double.valueOf(insureArea));
                                plantingLossRateListCheckDto.setInsureArea(Double.valueOf(insureArea));
                                break;
                            } else {
                                throw new BusinessException("承保面积不能为空");
                            }
                        case 9:
                            String lossArea = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(lossArea)) {
                                plantingLossRateListDto.setLossArea(Double.valueOf(lossArea));
                                lossRateLossListDto.setLossAmount(Double.valueOf(lossArea));
                                plantingLossRateListCheckDto.setLossArea(Double.valueOf(lossArea));
                                break;
                            } else {
                                throw new BusinessException("损失面积不能为空");
                            }
                        case 10:
                            String lossRate = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(lossRate)) {
                                plantingLossRateListDto.setLossRate(Double.valueOf(lossRate));
                                lossRateLossListDto.setLossRate(Double.valueOf(lossRate));
                                plantingLossRateListCheckDto.setLossRate(Double.valueOf(lossRate));
                                break;
                            } else {
                                throw new BusinessException("损失率不能为空");
                            }
                        case 11:
                            String remark = cell.getRichStringCellValue().getString().trim();
                            if (StringUtils.isNotEmpty(remark)) {
                                plantingLossRateListDto.setRemark(remark);
                                lossRateMainListDto.setRemark(remark);
                            }
                            break;
                    }



                }
            }

            //标的代码查询
            /*List<InsureMainListDto> insureMainListDtos = insureMainListApi.queryByPolicyNo(policyNo);
            String inusreListCode = insureMainListDtos.get(0).getInusreListCode();
            if (StringUtils.isNotEmpty(inusreListCode)) {
                PlantingInsuranceListDto plantingInsuranceListDto = plantingInsuranceListApi.queryByInusreListCodeAndFcode(inusreListCode, fCode);
                if (plantingInsuranceListDto != null) {
                    lossRateItemListDto.setItemCode(plantingInsuranceListDto.getItemCode());
                    lossRateLossListDto.setItemCode(plantingInsuranceListDto.getItemCode());
                }
            }*/
            if("3129".equals(requestImportDto.getRiskCode())){
                lossRatePersListDtos.add(lossRatePersListDto);
            }
            plantingLossRateListCheckDtos.add(plantingLossRateListCheckDto);
            lossRateItemListDtos.add(lossRateItemListDto);
            lossRateLossListDtos.add(lossRateLossListDto);
            PlantingLossRateListDtoLists.add(plantingLossRateListDto);
            savePlantingRateListImportDto.setLossRateListDto(lossRateListDto);
            savePlantingRateListImportDto.setPlantingLossRateListDto(PlantingLossRateListDtoLists);

        }
        //校验定损清单要和承保清单的一致性
        //根据保单号查询承保清单
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,String> map=new HashMap<>();
        map.put("policyNo",requestImportDto.getPolicyNo());
        List<AcceptInsuranceDto> acceptInsuranceDtos =null;
        if(StringUtils.isEmpty(lossRateMainListDto.getBizNo())){
            //报案登记的时候取出险时间为当前时间
            map.put("validDate",simpleDateFormat.format(new Date()));
            acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(map);
        }else{
            //查询出险时间
            PrpLRegist prplRegist = prpLRegistDao.findByRegistNo(lossRateMainListDto.getBizNo());
            map.put("validDate",simpleDateFormat.format(prplRegist.getDamageStartDate()));
            acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(map);
        }
        //组装养殖险的定损清单数据
        if(acceptInsuranceDtos==null||acceptInsuranceDtos.size()==0){
            throw new Exception("无保单清单!");
        }
        for (PlantingLossRateListCheckDto plantingLossRateListCheckDto : plantingLossRateListCheckDtos) {
            boolean flag1=true;
            boolean flag2=true;
            boolean flag3=true;
            for (AcceptInsuranceDto acceptInsuranceDto : acceptInsuranceDtos) {
                    /*比较农户代码，农户名称，险别，标的。
                    损失面积是否大于承保面积，
                    承保面积是否和承保的一致。*/
                if(acceptInsuranceDto.getfCode().equals(plantingLossRateListCheckDto.getfCode())&&
                        acceptInsuranceDto.getfName().equals(plantingLossRateListCheckDto.getfName())&&
                        plantingLossRateListCheckDto.getItemCode().equals(acceptInsuranceDto.getItemCode())&&
                        acceptInsuranceDto.getInsureArea().equals(String.valueOf(plantingLossRateListCheckDto.getInsureArea()))
                        ){
                    flag1=false;
                    if(plantingLossRateListCheckDto.getLossArea()<=Double.valueOf(acceptInsuranceDto.getInsureArea())){
                        flag2=false;
                    }
                    if(plantingLossRateListCheckDto.getLossRate()<=100){
                        flag3=false;
                    }

                }
            }
            if(flag1){
                throw new BusinessException("序号:"+plantingLossRateListCheckDto.getSerialNo()+",农户代码、农户名称、标的、承保面积与承保清单不一致！");
            }
            if(flag2){
                throw new BusinessException("序号:"+plantingLossRateListCheckDto.getSerialNo()+",损失面积不能大于承保面积！");
            }
            if(flag3){
                throw new BusinessException("序号:"+plantingLossRateListCheckDto.getSerialNo()+",损失率不能大于100");
            }
        }

        if("3129".equals(requestImportDto.getRiskCode())){
            lossRateWholeListDto.setLossRatePersListDtoList(lossRatePersListDtos);
        }
        lossRateWholeListDto.setLossRateMainListDto(lossRateMainListDto);
        lossRateWholeListDto.setLossRateItemListDtoList(lossRateItemListDtos);
        lossRateWholeListDto.setLossRateLossListDtoList(lossRateLossListDtos);
        savePlantingRateListImportDto.setRequestGYLossRateAllListDto(lossRateWholeListDto);
        return savePlantingRateListImportDto;
    }

    /**
     * 文件模板下载
     *
     * @param map
     * @return
     * @throws Exception
     * @author 杨璐
     * @date 2018/01/19
     */
    @Override
    public Map<String, String> exportExcel(Map<String, String> map) throws IOException {
        String riskCode = map.get("riskCode");
        String fileId = herdFileId;
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种不能为空");
        }
        // 种植险
        if ("28".equals(riskCode.substring(0, 2))) {
            fileId = plantFileId;
        }
        Map<String, String> otherParams = new HashMap<String, String>();
        otherParams.put("userCode", "00000000");
        otherParams.put("fileId", fileId);
        otherParams.put("validWhenLong", "3600000");
        // 此参数默认不加，默认使用文件id作为文件存储名
        // otherParams.put("invalidTime", "2018-10-20 22:24:30");
        Map<String, String> res = FileServerHelper.sendPost(fileServiceUrl + "/generateFileShortLink", otherParams);
        String url = fileServiceUrl + "/downloadFileByShortLinkId?shortLinkId=" + res.get("shortLinkId");
        if (LOGGER.isInfoEnabled()) {
            LOGGER.error("点击以下地址下载文件：" + url);
        }
        Map<String, String> returnMap = new HashMap<String, String>();
        returnMap.put("url", url);
        return returnMap;
    }

    /**
     * 理算清单撤销
     *
     * @param map
     * @return
     * @throws Exception
     * @author 杨璐
     * @date 2018/01/24
     */
    @Override
    public Map<String, String> delete(Map<String, String> map) throws Exception {

//		String listNo = map.get("listNo");
//		String  riskCode=map.get("riskCode");
//		Map<String, String> paraMap=new HashMap<>();
//		Map<String, String> result =new HashMap<>();
//		if(StringUtils.isEmpty(listNo)) {
//			throw new DataVerifyException("理算清单号不能为空");
//		}
//		if(StringUtils.isEmpty(riskCode)) {
//			throw new DataVerifyException("险种代码不能为空");
//		}
//		paraMap.put("listNo", listNo);
//		if(riskCode.startsWith("28")) {
//			 plantingLossRateListApi.deleteLossRateListByListNo(paraMap);
//
//		}
//		else {
//			breedLossRateListApi.deleteBreedLossRateListByListNo(paraMap);
//		}
//		lossRateListApi.remove(listNo);
//		result.put("message", "success");
        return null;
    }

}
