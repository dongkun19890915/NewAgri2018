package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.alibaba.fastjson.JSON;
import com.sinosoft.agriprpall.api.policymanage.dto.AcceptInsuranceDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.GetHerdInsuranceListExcelDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PlantingExcelDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ResponsePlantingExcelDto;
import com.sinosoft.agriprpall.core.common.util.file.FileUtil;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPmainDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.paymanage.service.PayInfoService;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainAgriDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainAgri;
import com.sinosoft.agriprpall.core.proposalmanage.service.PlantingExcelService;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.fileserver.client.FileServerHelper;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.agri.core.excel.ExcelConst;
import com.sinosoft.framework.agri.core.excel.headstyle.HSSFDefaultHeadCellStyle;
import com.sinosoft.framework.agri.core.excel.headstyle.SXSSFDefaultHeadCellStyle;
import com.sinosoft.framework.agri.core.utils.ExcelUtil;
import com.sinosoft.framework.agri.core.utils.QuicklyExportExcel;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.pms.api.kernel.*;
import com.sinosoft.pms.api.kernel.dto.PrpDitemAgriDto;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.pms.api.kernel.dto.QueryItemCodePmsDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.*;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-24 12:54:07.447
 * @description 清单下载Core接口实现
 */
@Service
public class PlantingExcelServiceImpl extends BaseServiceImpl implements PlantingExcelService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlantingExcelServiceImpl.class);
    @Autowired
    private PlantingInsuranceListApi plantingInsuranceListApi;
    @Value("${fileService.url}")
    private String fileServiceUrl;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpPheadDao prpPheadDao;
    @Autowired
    private PrpDkindItemApi prpDkindItemApi;
    @Autowired
    private PrpDitemAgriApi prpDitemAgriApi;
    @Autowired
    private PrpDkindApi prpDkindApi;
    @Autowired
    private NyxPolicyListApi nyxPolicyListApi;
    @Autowired
    private HerdPolicyListApi herdPolicyListApi;
    @Autowired
    private HerdInsuranceListApi herdInsuranceListApi;
    @Autowired
    private MiddleHerdInsuranceListApi middleHerdInsuranceListApi;
    @Autowired
    private Planting31InsuranceListApi planting31InsuranceListApi;
    @Autowired
    private NyxInsuranceListApi nyxInsuranceListApi;
    @Autowired
    private Planting31PolicyListApi planting31PolicyListApi;
    @Autowired
    private PlantingPolicyListApi plantingPolicyListApi;
    @Autowired
    private PlantingEndorChgDetailApi plantingEndorChgDetailApi;
    @Autowired
    private NyxEndorChgDetailApi nyxEndorChgDetailApi;
    @Autowired
    private NyxEffectiveAmountApi nyxEffectiveAmountApi;
    @Autowired
    private Planting31EndorChgDetailApi planting31EndorChgDetailApi;
    @Autowired
    private HerdEndorChgDetailApi herdEndorChgDetailApi;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpPmainDao prpPmainDao;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    private PrpDitemApi prpDitemApi;
    @Autowired
    private PlantingCpEndorChgDetailApi plantingCpEndorChgDetailApi;
    @Autowired
    private Planting31CpEndorChgDetailApi planting31CpEndorChgDetailApi;
    @Autowired
    private HerdcEndorChgDetailApi herdcEndorChgDetailApi;
    @Autowired
    private NyxCpEndorChgDetailApi nyxCpEndorChgDetailApi;
    @Autowired
    private PrpCmainAgriDao prpCmainAgriDao;
    /**
     * 快速导出excel工具类
     */
    private static QuicklyExportExcel quicklyExportExcel;

    /**
     * 文件工具类
     */
    private static FileUtil fileUtil;
    @Autowired
    private PayInfoService payInfoService;
    @Value("${exportExcelType}")
    private String exportExcelType;
    // @Value("${sysconfig.insureListRsk.planting}")
    private String plantingRiskcode;
    //  @Value("${sysconfig.insureListRsk.planting31}")
    private String planting31Riskcode;
    // @Value("${sysconfig.insureListRsk.nyx}")
    private String nyxRiskcode;
    // @Value("${sysconfig.insureListRsk.herd}")
    private String herdRiskcode;

    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;

    public void inint() {
        this.plantingRiskcode = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING", 1).getRule();
        this.planting31Riskcode = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING31", 1).getRule();
        this.nyxRiskcode = utiPlatConfigRuleApi.queryByPK("newagriprpall", "NYX", 1).getRule();
        this.herdRiskcode = utiPlatConfigRuleApi.queryByPK("newagriprpall", "HERD", 1).getRule();
    }

    /**
     * 分户清单查询
     *
     * @param inusreListCode 清单号
     * @param pageNo         页数
     * @param pageSize       每页条数
     * @return ResponseDto：
     * @author: 钱浩
     * @date: 2017/10/31 11:14
     */
    public PageInfo<PlantingInsuranceListDto> queryPlantingExcelByConnection(String inusreListCode, Integer pageNo, Integer pageSize) throws Exception {

        if (StringUtils.isEmpty(inusreListCode)) {
            throw new DataVerifyException("清单号不能为空");
        }
        if (pageNo < 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new DataVerifyException("每页条数不能小于1");
        }
        PageInfo<PlantingInsuranceListDto> pageInfo = plantingInsuranceListApi.queryPlantingInsuranceInfo(inusreListCode, pageNo, pageSize);
        return pageInfo;
    }
    @Override
    public Map<String, String> getFileId(PlantingExcelDto plantingExcelDto) throws Exception {
        inint();
        String proposalNo = plantingExcelDto.getProposalNo();
        String policyNo = plantingExcelDto.getPolicyNo();
        String inusreListCode = plantingExcelDto.getInusreListCode();
        String userCode = plantingExcelDto.getUserCode();
        String riskCode = plantingExcelDto.getRiskCode();
        String fileId="";
        if (plantingRiskcode.contains(riskCode)) {
            fileId = getPlantingToExcel(riskCode,proposalNo,policyNo,inusreListCode,userCode);
        } else if (herdRiskcode.contains(riskCode)) {
            fileId = getHerdInsuranceListExcel(riskCode,proposalNo,policyNo,inusreListCode,userCode);
        } else if (nyxRiskcode.contains(riskCode)) {
            fileId = getNyxInsuranceListExcel(riskCode,proposalNo,policyNo,inusreListCode,userCode);
        } else if (planting31Riskcode.contains(riskCode)) {
            fileId = getPlanting31ToExcel(riskCode,proposalNo,policyNo,inusreListCode,userCode);
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("fileId", fileId);
        return map;
    }
    /**
     * 分户清单下载 暂不使用
     * @author: 钱浩
     * @param proposalNo     投保单号
     * @param policyNo       保单号
     * @param inusreListCode 清单号
     * @param userCode       用户编码
     * @return ResponseDto ：下载链接地址
     * @throws Exception
     * @date: 2017/11/1 11:35
     */
    @Deprecated
    public Map<String, String> getPlantingExcel(String riskCode, String proposalNo, String policyNo, String inusreListCode, String userCode) throws Exception {
        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号不能为空");
        }
        if (StringUtils.isEmpty(inusreListCode)) {
            throw new DataVerifyException("清单号不能为空");
        }
        if (StringUtils.isEmpty(userCode)) {
            throw new DataVerifyException("用户代码不能为空");
        }
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空");
        }
        Map<String,String> riskCodemap = new HashMap<>();
        riskCodemap.put("riskCode",riskCode);
        PrpDriskDto prpDriskDto = prpDriskApi.queryByPK(riskCodemap);
        String riskCname = prpDriskDto.getRiskCName();
        String itemName = "";
        List<PlantingInsuranceListDto> plantingInsuranceListDtos = plantingInsuranceListApi.queryByInusreListCode(inusreListCode);
        List<String> kindCodeList = new ArrayList<>();
        for(int i=0;i<plantingInsuranceListDtos.size()-1;i++){
            kindCodeList.add(plantingInsuranceListDtos.get(i).getKindCode());
        }
        QueryItemCodePmsDto queryItemCodePmsDto= new QueryItemCodePmsDto();
        queryItemCodePmsDto.setRiskCode(riskCode);
        queryItemCodePmsDto.setKindCodeList(kindCodeList);
        List<String> itemCodeList= prpDkindItemApi.queryItemCode(queryItemCodePmsDto);
        queryItemCodePmsDto.setItemCodeList(itemCodeList);
        List<PrpDitemAgriDto> prpDitemAgriDtoList= prpDitemAgriApi.queryItemName(queryItemCodePmsDto);
        for (PrpDitemAgriDto p: prpDitemAgriDtoList) {
            itemName += p.getItemCode() + "-" + p.getItemCName() + ",";
        }
//        List<PrpTitemKindDto> prpTitemKindDtoList = prpTitemKindApi.queryByConnection(proposalNo);
//        if (prpTitemKindDtoList != null && prpTitemKindDtoList.size() > 0) {
//            for (PrpTitemKindDto prpTitemKindDto : prpTitemKindDtoList) {
//                itemName += prpTitemKindDto.getItemCode() + "-" + prpTitemKindDto.getItemDetailName() + ",";
//            }
//        }
        if (!"".equals(itemName) && itemName.length() > 1) {
            itemName = itemName.substring(0, itemName.length() - 1);
        }
        String fileid = "";
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        int index = 0;
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("分户清单");
        hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 21));
        HSSFRow headRow2 = hssfSheet.createRow((short) 0);
        HSSFCell hssfCell0 = headRow2.createCell(0);
        hssfCell0.setCellValue("国元农业保险分户清单" + "(" + riskCname + ")");
        setStyleHead(hssfCell0, hssfWorkbook);
        setStyleHead2(headRow2.createCell(22), hssfWorkbook);
        //添加表头
        HSSFRow hssfRow = hssfSheet.createRow((short) 1);
        HSSFCell hssfCel0 = hssfRow.createCell(0);
        hssfCel0.setCellValue("序号");
        setStyle(hssfCel0, hssfWorkbook); //样式
        HSSFCell hssfCell1 = hssfRow.createCell(1);
        hssfCell1.setCellValue("投保单号");
        setStyle(hssfCell1, hssfWorkbook);
        HSSFCell hssfCell2 = hssfRow.createCell(2);
        hssfCell2.setCellValue("保单号");
        setStyle(hssfCell2, hssfWorkbook);
        HSSFCell hssfCell3 = hssfRow.createCell(3);
        hssfCell3.setCellValue("农户代码");
        setStyle(hssfCell3, hssfWorkbook);
        HSSFCell hssfCell4 = hssfRow.createCell(4);
        hssfCell4.setCellValue("农户姓名");
        setStyle(hssfCell4, hssfWorkbook);
        HSSFCell hssfCell8 = hssfRow.createCell(8);
        hssfCell8.setCellValue("投保面积(亩)");
        setStyle(hssfCell8, hssfWorkbook);
        HSSFCell hssfCell5 = hssfRow.createCell(5);
        hssfCell5.setCellValue("身份证号码");
        setStyle(hssfCell5, hssfWorkbook);
        HSSFCell hssfCell6 = hssfRow.createCell(6);
        hssfCell6.setCellValue("银行卡号");
        setStyle(hssfCell6, hssfWorkbook);
        HSSFCell hssfCell7 = hssfRow.createCell(7);
        hssfCell7.setCellValue("联系电话");
        setStyle(hssfCell7, hssfWorkbook);
        HSSFCell hssfCell9 = hssfRow.createCell(9);
        hssfCell9.setCellValue("险别");
        setStyle(hssfCell9, hssfWorkbook);
        HSSFCell hssfCell10 = hssfRow.createCell(10);
        hssfCell10.setCellValue("标的");
        setStyle(hssfCell10, hssfWorkbook);
        HSSFCell hssfCell11 = hssfRow.createCell(11);
        hssfCell11.setCellValue("总保额(元)");
        setStyle(hssfCell11, hssfWorkbook);
        HSSFCell hssfCell12 = hssfRow.createCell(12);
        hssfCell12.setCellValue("总保费(元)");
        setStyle(hssfCell12, hssfWorkbook);
//        HSSFCell hssfCell12 = hssfRow.createCell(12);
//        hssfCell12.setCellValue("实际承保面积");
        HSSFCell hssfCell13 = hssfRow.createCell(13);
        hssfCell13.setCellValue("自缴保费(元)");
        setStyle(hssfCell13, hssfWorkbook);
        HSSFCell hssfCell14 = hssfRow.createCell(14);
        hssfCell14.setCellValue("中央财政补贴(元)");
        setStyle(hssfCell14, hssfWorkbook);
        HSSFCell hssfCell15 = hssfRow.createCell(15);
        hssfCell15.setCellValue("省级财政补贴(元)");
        setStyle(hssfCell15, hssfWorkbook);
        HSSFCell hssfCell16 = hssfRow.createCell(16);
        hssfCell16.setCellValue("地市财政补贴(元)");
        setStyle(hssfCell16, hssfWorkbook);
        HSSFCell hssfCell17 = hssfRow.createCell(17);
        hssfCell17.setCellValue("区(县)财政(元)");
        setStyle(hssfCell17, hssfWorkbook);
        HSSFCell hssfCell18 = hssfRow.createCell(18);
        hssfCell18.setCellValue("其他来源补贴(元)");
        setStyle(hssfCell18, hssfWorkbook);
        HSSFCell hssfCell19 = hssfRow.createCell(19);
        hssfCell19.setCellValue("粮补面积");
        setStyle(hssfCell19, hssfWorkbook);
        HSSFCell hssfCell20 = hssfRow.createCell(20);
        hssfCell20.setCellValue("土地来源");
        setStyle(hssfCell20, hssfWorkbook);
        HSSFCell hssfCell21 = hssfRow.createCell(21);
        hssfCell21.setCellValue("备注");
        setStyle(hssfCell21, hssfWorkbook);
        //遍历添加数据
        for (short i = 1; i < plantingInsuranceListDtos.size() + 1; i++) {
            PlantingInsuranceListDto plantingInsuranceListDto = plantingInsuranceListDtos.get(i - 1);
            HSSFRow row = hssfSheet.createRow(i + 1);
            hssfSheet.autoSizeColumn(1, true);
            hssfSheet.autoSizeColumn(2, true);
            hssfSheet.autoSizeColumn(3, true);
            hssfSheet.autoSizeColumn(4, true);
            hssfSheet.autoSizeColumn(5, true);
            hssfSheet.autoSizeColumn(6, true);
            hssfSheet.autoSizeColumn(7, true);
            hssfSheet.autoSizeColumn(8, true);
            hssfSheet.autoSizeColumn(9, true);
            hssfSheet.autoSizeColumn(10, true);
            hssfSheet.autoSizeColumn(21, true);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(index++);//序号
            HSSFCell cell0 = row.createCell(1);
            cell0.setCellValue(proposalNo);//投保单号
            HSSFCell cell1 = row.createCell(2);
            cell1.setCellValue(policyNo);//投保单号
            HSSFCell cell2 = row.createCell(3);
            cell2.setCellValue(plantingInsuranceListDto.getfCode());//农户代码
            HSSFCell cell3 = row.createCell(4);
            cell3.setCellValue(plantingInsuranceListDto.getfName());//农户姓名
            HSSFCell cell7 = row.createCell(8);
            cell7.setCellValue(plantingInsuranceListDto.getTaxArea());//面积
            HSSFCell cell4 = row.createCell(5);
            cell4.setCellValue(plantingInsuranceListDto.getfIdCard());//身份证
            HSSFCell cell5 = row.createCell(6);
            cell5.setCellValue(plantingInsuranceListDto.getZhiBuKa());//银行卡号
            HSSFCell cell6 = row.createCell(7);
            setStyle1(cell6, hssfWorkbook);
            cell6.setCellValue(plantingInsuranceListDto.getPhone());//联系电话
            HSSFCell cell8 = row.createCell(9);
            //   cell8.setCellValue(plantingInsuranceListDto.getRiskCode());//险别
            cell8.setCellValue(riskCode + "-" + riskCname);//险别
            HSSFCell cell9 = row.createCell(10);
            cell9.setCellValue(itemName);//标的
            HSSFCell cell10 = row.createCell(11);
            cell10.setCellValue(plantingInsuranceListDto.getSumAmount());//总保额
            HSSFCell cell11 = row.createCell(12);
            cell11.setCellValue(plantingInsuranceListDto.getSumPremium());//总保费
//            HSSFCell cell12 = row.createCell(12);
//            cell12.setCellValue(plantingInsuranceListDto.getInsureArea());//实际承保面积
            HSSFCell cell12 = row.createCell(13);
            cell12.setCellValue(plantingInsuranceListDto.getfPremium());//自缴保费
            HSSFCell cell13 = row.createCell(14);
            cell13.setCellValue(plantingInsuranceListDto.getCentralPremium());//中央财政补贴
            HSSFCell cell14 = row.createCell(15);
            cell14.setCellValue(plantingInsuranceListDto.getProvincePremium());//省级财政补贴
            HSSFCell cell15 = row.createCell(16);
            cell15.setCellValue(plantingInsuranceListDto.getCityPremium());//地市财政补贴+
            HSSFCell cell16 = row.createCell(17);
            cell16.setCellValue(plantingInsuranceListDto.getTownPremium());//区(县)财政
            HSSFCell cell17 = row.createCell(18);
            cell17.setCellValue(plantingInsuranceListDto.getOtherPremium());//其他来源补贴
            HSSFCell cell18 = row.createCell(19);
            cell18.setCellValue(plantingInsuranceListDto.getAtArea());//粮补面积
            HSSFCell cell19 = row.createCell(20);
            cell19.setCellValue(plantingInsuranceListDto.getFieldSource());//土地来源
            HSSFCell cell20 = row.createCell(21);
            cell20.setCellValue(plantingInsuranceListDto.getRemark());//土地来源
            setStyle1(cell, hssfWorkbook);
            setStyle1(cell0, hssfWorkbook);
            setStyle1(cell1, hssfWorkbook);
            setStyle1(cell2, hssfWorkbook);
            setStyle1(cell3, hssfWorkbook);
            setStyle1(cell4, hssfWorkbook);
            setStyle1(cell5, hssfWorkbook);
            setStyle1(cell6, hssfWorkbook);
            setStyle1(cell7, hssfWorkbook);
            setStyle1(cell8, hssfWorkbook);
            setStyle1(cell9, hssfWorkbook);
            setStyle1(cell10, hssfWorkbook);
            setStyle1(cell11, hssfWorkbook);
            setStyle1(cell12, hssfWorkbook);
            setStyle1(cell13, hssfWorkbook);
            setStyle1(cell14, hssfWorkbook);
            setStyle1(cell15, hssfWorkbook);
            setStyle1(cell16, hssfWorkbook);
            setStyle1(cell17, hssfWorkbook);
            setStyle1(cell18, hssfWorkbook);
            setStyle1(cell19, hssfWorkbook);
            setStyle1(cell20, hssfWorkbook);
        }
        //生成.xls文件开始
        FileOutputStream fileOut = null;
        try {
            // 生成临时文件
            String fileName = proposalNo + "分户清单";
            File tempFile = File.createTempFile(fileName, ".xls");
            tempFile.deleteOnExit();
            fileOut = new FileOutputStream(tempFile);
            hssfWorkbook.write(fileOut);
            // 上传文件到fileserver
            Map<String, String> otherParams = new HashMap<String, String>();
            otherParams.put("userCode", "00000000");
            otherParams.put("systemId", "agri/tempfile");
            otherParams.put("bussType", "test");
            //otherParams.put("filePath","/test6.txt");
            FileServerHelper helper = new FileServerHelper();
            Map<String, String> fileResult = helper.uploadFile(fileServiceUrl + "/uploadFile", tempFile, otherParams);
            if (fileResult != null && fileResult.get("fileId") != null) {
                fileid = fileResult.get("fileId");
            }
            System.out.println(JSON.toJSONString(fileResult));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOut.close();
                hssfWorkbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 生成短链接
        Map<String, String> otherParams2 = new HashMap<String, String>();
        otherParams2.put("userCode", "00000000");
        otherParams2.put("fileId", fileid);
        otherParams2.put("validWhenLong", "3600000");
//			otherParams.put("invalidTime", "2018-10-20 22:24:30");  //此参数默认不加，默认使用文件id作为文件存储名
        Map<String, String> res = FileServerHelper.sendPost(fileServiceUrl + "/generateFileShortLink", otherParams2);
        System.out.println(res);
        System.out.println("点击以下地址下载文件：");
        //todo
        String url = fileServiceUrl + "/downloadFileByShortLinkId?shortLinkId=" + res.get("shortLinkId");
        System.out.println(url);
        System.out.println(res);
        Map<String, String> map = new HashMap<String, String>();
        map.put("url", url);
        return map;
    }

    /**
     * 设置数据样式
     */
    public void setStyle(HSSFCell headCel, HSSFWorkbook hssfWorkbook) {
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 11); //字体高度
        font.setColor(HSSFFont.COLOR_NORMAL); //字体颜色
        font.setFontName("宋体"); //字体
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //宽度
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setFont(font);
        //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平布局：居中
        cellStyle.setFillBackgroundColor(HSSFColor.AQUA.index);
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        cellStyle.setLocked(true);
        cellStyle.setWrapText(true);// 自动换行
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);// 左边框的颜色
        cellStyle.setBorderLeft((short) 1);// 边框的大小
        cellStyle.setBorderTop((short) 1);// 边框的大小
        cellStyle.setBorderBottom((short) 1);
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);// 右边框的颜色
        cellStyle.setBorderRight((short) 1);// 边框的大小
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色
        headCel.setCellStyle(cellStyle);
    }

    /**
     * 设置数据样式
     *
     * @param headCel
     * @param hssfWorkbook
     * @author: 钱浩
     * @date: 2017/11/10 16:30
     */
    public void setStyleHead(HSSFCell headCel, HSSFWorkbook hssfWorkbook) {
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 11); //字体高度
        font.setColor(HSSFFont.COLOR_NORMAL); //字体颜色
        font.setFontName("宋体"); //字体
        HSSFFont font2 = hssfWorkbook.createFont();
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平布局：居中
        cellStyle.setLocked(true);
        cellStyle.setWrapText(true);// 自动换行
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        cellStyle.setBorderTop((short) 1);// 边框的大小
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
        cellStyle.setBorderRight((short) 1);// 边框的大小
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色
        cellStyle.setWrapText(true);
        cellStyle.setFillBackgroundColor(HSSFColor.AQUA.index);
        headCel.setCellStyle(cellStyle);
    }

    public void setStyleHead2(HSSFCell headCel, HSSFWorkbook hssfWorkbook) {
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setBorderLeft((short) 1);// 边框的大小
        headCel.setCellStyle(cellStyle);
    }

    /**
     * 设置边框
     *
     * @param headCel
     * @param hssfWorkbook
     */
    public void setStyle1(HSSFCell headCel, HSSFWorkbook hssfWorkbook) {
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 11); //字体高度
        font.setColor(HSSFFont.COLOR_NORMAL); //字体颜色
        font.setFontName("宋体"); //字体
        cellStyle.setFont(font);
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);// 左边框的颜色
        cellStyle.setBorderLeft((short) 1);// 边框的大小
        cellStyle.setBorderTop((short) 1);// 边框的大小
        cellStyle.setBorderBottom((short) 1);
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);// 右边框的颜色
        cellStyle.setBorderRight((short) 1);// 边框的大小
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        headCel.setCellStyle(cellStyle);
    }

    /**
     * 种植分户清单下载
     *
     * @param proposalNo     投保单号
     * @param policyNo       保单号
     * @param inusreListCode 清单号
     * @param userCode       用户编码
     * @return ResponseDto ：下载链接地址
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/1 11:35
     */
    public String getPlantingToExcel(String riskCode, String proposalNo, String policyNo, String inusreListCode, String userCode) throws Exception {
        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号不能为空");
        }
        if (StringUtils.isEmpty(inusreListCode)) {
            throw new DataVerifyException("清单号不能为空");
        }
        if (StringUtils.isEmpty(userCode)) {
            throw new DataVerifyException("用户代码不能为空");
        }
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空");
        }
        //获取反射对象
        Class<ResponsePlantingExcelDto> businessListClass = ResponsePlantingExcelDto.class;
        //获取险别-名称
        Map<String,String> riskCodemap = new HashMap<>();
        riskCodemap.put("riskCode",riskCode);
        PrpDriskDto prpDriskDto = prpDriskApi.queryByPK(riskCodemap);
        String riskCname = prpDriskDto.getRiskCName();
        List<ResponsePlantingExcelDto> responsePlantingExcelDtoList = null;

        //获取清单数据
        List<PlantingInsuranceListDto> plantingInsuranceListDtos = plantingInsuranceListApi.queryByInusreListCode(inusreListCode);
        responsePlantingExcelDtoList = getResponsePlantingExcelDto(plantingInsuranceListDtos, proposalNo, riskCode, policyNo, riskCname);
        //数据转换
        String titleName = "国元农业保险分户清单(" + riskCname + ")";
        String excelName = "投(承)保分户清单";
        //生成短连接
        String fileId = this.<ResponsePlantingExcelDto>getFileId(businessListClass, titleName, excelName, responsePlantingExcelDtoList);
        return fileId;
    }
    /**
     * 种植分户清单下载
     *
     * @param proposalNo     投保单号
     * @param policyNo       保单号
     * @param inusreListCode 清单号
     * @param userCode       用户编码
     * @return ResponseDto ：下载链接地址
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/1 11:35
     */
    public String getPlanting31ToExcel(String riskCode, String proposalNo, String policyNo, String inusreListCode, String userCode) throws Exception {
        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号不能为空");
        }
        if (StringUtils.isEmpty(inusreListCode)) {
            throw new DataVerifyException("清单号不能为空");
        }
        if (StringUtils.isEmpty(userCode)) {
            throw new DataVerifyException("用户代码不能为空");
        }
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空");
        }
        //获取反射对象
        Class<ResponsePlantingExcelDto> businessListClass = ResponsePlantingExcelDto.class;
        //获取险别-名称
        Map<String,String> riskCodemap = new HashMap<>();
        riskCodemap.put("riskCode",riskCode);
        PrpDriskDto prpDriskDto = prpDriskApi.queryByPK(riskCodemap);
        String riskCname = prpDriskDto.getRiskCName();
        List<ResponsePlantingExcelDto> responsePlantingExcelDtoList = null;
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("inusreListCode",inusreListCode);
        //获取清单数据
        List<Planting31InsuranceListDto> planting31InsuranceListDtos = planting31InsuranceListApi.queryByInusreListCode(stringMap);
        responsePlantingExcelDtoList = getResponsePlanting31ExcelDto(planting31InsuranceListDtos, proposalNo, riskCode, policyNo, riskCname);
        //数据转换
        String titleName = "国元农业保险分户清单(" + riskCname + ")";
        String excelName = "投(承)保分户清单";
        //生成短连接
        String fileId = this.<ResponsePlantingExcelDto>getFileId(businessListClass, titleName, excelName, responsePlantingExcelDtoList);
        return fileId;
    }

    /**
     * 生成短连接
     *
     * @param businessListClass            反射对象
     * @param titleName                    表头名
     * @param excelName                    sheet页名
     * @param responsePlantingExcelDtoList 大对象
     * @return 短连接
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/6 下午 17:55
     */
    public <T> String getFileId(Class<T> businessListClass, String titleName, String excelName, List<T> responsePlantingExcelDtoList) throws Exception {
        String shortLinkId = null;
        File file = null;
        try {
            ExcelUtil excelUtil = ExcelUtil.initBuilder(businessListClass);
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            if (ExcelConst.XLS_SUFFIX.equalsIgnoreCase(exportExcelType)) {
                file = File.createTempFile(excelName, ExcelConst.XLS_SUFFIX);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                // 导出Excel 97-2003 版本 方法
                excelUtil.toHSSFExcel(responsePlantingExcelDtoList, excelName, new HSSFDefaultHeadCellStyle(titleName, 0, 21), fileOutputStream);
            }
            //Excel导出类型判断：.xlsx 2007 及以上版本版本 Excel
            else if (ExcelConst.XLSX_SUFFIX.equalsIgnoreCase(exportExcelType)) {
                file = File.createTempFile(excelName, ExcelConst.XLSX_SUFFIX);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                // 导出Excel 2007 以上版本 方法
                excelUtil.toSXSSFExcel(responsePlantingExcelDtoList, excelName, new SXSSFDefaultHeadCellStyle(titleName, 0, 21), fileOutputStream);
            } else {
                throw new DataVerifyException("导出Excel类型配置不正确:exportExcelType:" + exportExcelType);
            }
            String fileId = null;
            // 上传文件到fileServer
            Map<String, String> uploadFileMap = new HashMap<>(3);
            uploadFileMap.put("userCode", "00000000");
            uploadFileMap.put("systemId", "agri/tempfile");
            uploadFileMap.put("bussType", "test");
            Map<String, String> uploadFileResult = FileServerHelper.uploadFile(fileServiceUrl + "/uploadFile", file, uploadFileMap);
            if (uploadFileResult != null && StringUtils.isNotEmpty(uploadFileResult.get("fileId"))) {
                fileId = uploadFileResult.get("fileId");
            }
            // 生成短链接服务调用
            if (StringUtils.isNotEmpty(fileId)) {
                Map<String, String> shortLinkMap = new HashMap<>(3);
                shortLinkMap.put("userCode", "00000000");
                shortLinkMap.put("fileId", fileId);
                shortLinkMap.put("validWhenLong", "3600000");
                Map<String, String> shortLinkResult = FileServerHelper.sendPost(fileServiceUrl + "/generateFileShortLink", shortLinkMap);
                shortLinkId = fileServiceUrl + "/downloadFileByShortLinkId?shortLinkId=" + shortLinkResult.get("shortLinkId");
            }
            if (StringUtils.isEmpty(shortLinkId)) {
                throw new BusinessException("生成文件下载短链接失败！");
            }
            System.out.println(shortLinkId);
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }

        return shortLinkId;
    }

    /**
     * 农险分户清单下载 数据转换
     *
     * @param plantingInsuranceListDtos 分户清单数据
     * @param proposalNo                投保单
     * @param riskCode                  险种
     * @param policyNo                  保单
     * @param riskCname                 险种名称
     * @return excel数据对象
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/6 下午 17:57
     */
    public List<ResponsePlantingExcelDto> getResponsePlantingExcelDto(List<PlantingInsuranceListDto> plantingInsuranceListDtos, String proposalNo, String riskCode, String policyNo, String riskCname) throws Exception {
        List<ResponsePlantingExcelDto> responsePlantingExcelDtos = new ArrayList<ResponsePlantingExcelDto>();
        ResponsePlantingExcelDto responsePlantingExcelDto1 = new ResponsePlantingExcelDto();
        String itemName = "";
        List<String> kindCodeList = new ArrayList<>();
        QueryItemCodePmsDto queryItemCodePmsDto= new QueryItemCodePmsDto();
        queryItemCodePmsDto.setRiskCode(riskCode);
        List<String> itemCodeList= new ArrayList<>();
        plantingInsuranceListDtos.forEach(plantingInsuranceListDto -> {
            String kindCode = plantingInsuranceListDto.getKindCode();
            if (!kindCodeList.contains(kindCode)) {
                kindCodeList.add(kindCode);
            }
            String itemCode = plantingInsuranceListDto.getItemCode();
            if (!itemCodeList.contains(itemCode)) {
                itemCodeList.add(itemCode);
            }
        });
        queryItemCodePmsDto.setItemCodeList(itemCodeList);
        List<PrpDitemAgriDto> prpDitemAgriDtoList= prpDitemAgriApi.queryItemName(queryItemCodePmsDto);
        Map<String,String> itemNameMap = new HashMap<>();
        for (PrpDitemAgriDto p: prpDitemAgriDtoList) {
            itemName = p.getItemCode() + "-" + p.getItemCName();
            itemNameMap.put( p.getItemCode(),itemName);
        }
        Map<String,Object> kindMap = new HashMap<>();
        kindMap.put("kindCodes",kindCodeList);
        kindMap.put("riskCode",riskCode);
        Map<String,String> mapKindCnames = prpDkindApi.queryByKindCodes(kindMap);
        Boolean flse = false;
        List<PrpCmain> byProposalNo = prpCmainDao.findByProposalNo(proposalNo);
        String policyNo1 = "";
        if (byProposalNo == null || (byProposalNo != null && byProposalNo.size() <= 0)) {
            flse = true;
        } else {
            policyNo1 = byProposalNo.get(0).getPolicyNo();
        }
        Map<String, Double> hash = new HashMap<String, Double>();
        if (!flse) {
            hash = nyxEffectiveAmountApi.queryNyxEffectiveAmount(true, riskCode, "", policyNo1);
        }
        int index = 0;
        //循环转换数据
        DecimalFormat format = new DecimalFormat("0.00");
        for (PlantingInsuranceListDto plantingInsuranceListDto : plantingInsuranceListDtos) {
            index++;
            ResponsePlantingExcelDto responsePlantingExcelDto = responsePlantingExcelDto1.getResponsePlantingExcelDto(plantingInsuranceListDto);
            responsePlantingExcelDto.setProposalNo(proposalNo);
            responsePlantingExcelDto.setPolicyNo(policyNo1);
            if (flse) {
                responsePlantingExcelDto.setEffAmount(format.format(plantingInsuranceListDto.getSumAmount()));
            } else {
                responsePlantingExcelDto.setEffAmount(format.format(hash.get(plantingInsuranceListDto.getRiskCode() + plantingInsuranceListDto.getKindCode() + plantingInsuranceListDto.getItemCode() + plantingInsuranceListDto.getfCode())));
            }
            responsePlantingExcelDto.setRiskName(plantingInsuranceListDto.getKindCode()+"-"+mapKindCnames.get(plantingInsuranceListDto.getKindCode()));
            responsePlantingExcelDto.setiTemName(itemNameMap.get(plantingInsuranceListDto.getItemCode()));
            responsePlantingExcelDto.setId(index + "");
            responsePlantingExcelDtos.add(responsePlantingExcelDto);
        }

        return responsePlantingExcelDtos;
    }
    /**
     * 农险分户清单下载 数据转换
     *
     * @param planting31InsuranceListDtos 分户清单数据
     * @param proposalNo                投保单
     * @param riskCode                  险种
     * @param policyNo                  保单
     * @param riskCname                 险种名称
     * @return excel数据对象
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/6 下午 17:57
     */
    public List<ResponsePlantingExcelDto> getResponsePlanting31ExcelDto(List<Planting31InsuranceListDto> planting31InsuranceListDtos, String proposalNo, String riskCode, String policyNo, String riskCname) throws Exception {
        List<ResponsePlantingExcelDto> responsePlantingExcelDtos = new ArrayList<ResponsePlantingExcelDto>();
        ResponsePlantingExcelDto responsePlantingExcelDto1 = new ResponsePlantingExcelDto();
        String itemName = "";
        List<String> kindCodeList = new ArrayList<>();
        QueryItemCodePmsDto queryItemCodePmsDto= new QueryItemCodePmsDto();
        queryItemCodePmsDto.setRiskCode(riskCode);
        List<String> itemCodeList= new ArrayList<>();
        planting31InsuranceListDtos.forEach(plantingInsuranceListDto -> {
            String kindCode = plantingInsuranceListDto.getKindCode();
            if (!kindCodeList.contains(kindCode)) {
                kindCodeList.add(kindCode);
            }
            String itemCode = plantingInsuranceListDto.getItemCode();
            if (!itemCodeList.contains(itemCode)) {
                itemCodeList.add(itemCode);
            }
        });
        queryItemCodePmsDto.setItemCodeList(itemCodeList);
        List<PrpDitemAgriDto> prpDitemAgriDtoList= prpDitemAgriApi.queryItemName(queryItemCodePmsDto);
        Map<String,String> itemNameMap = new HashMap<>();
        for (PrpDitemAgriDto p: prpDitemAgriDtoList) {
            itemName = p.getItemCode() + "-" + p.getItemCName();
            itemNameMap.put( p.getItemCode(),itemName);
        }
        Map<String,Object> kindMap = new HashMap<>();
        kindMap.put("kindCodes",kindCodeList);
        kindMap.put("riskCode",riskCode);
        Map<String,String> mapKindCnames = prpDkindApi.queryByKindCodes(kindMap);
        Boolean flse = false;
        String policyNo1 = "";
        List<PrpCmain> byProposalNo = prpCmainDao.findByProposalNo(proposalNo);
        if (byProposalNo == null || (byProposalNo != null && byProposalNo.size() <= 0)) {
            flse = true;
        } else {
            policyNo1 = byProposalNo.get(0).getPolicyNo();
        }
        Map<String, Double> hash = new HashMap<String, Double>();
        if (!flse) {
            hash = nyxEffectiveAmountApi.queryNyxEffectiveAmount(true, riskCode, "", policyNo1);
        }
        DecimalFormat format = new DecimalFormat("0.00");
        int index = 0;
        //循环转换数据
        for (Planting31InsuranceListDto planting31InsuranceListDto : planting31InsuranceListDtos) {
            index++;
            ResponsePlantingExcelDto responsePlantingExcelDto = responsePlantingExcelDto1.getResponsePlanting31ExcelDto(planting31InsuranceListDto);
            responsePlantingExcelDto.setProposalNo(proposalNo);
            if (flse) {
                responsePlantingExcelDto.setEffAmount(format.format(planting31InsuranceListDto.getSumAmount()));
            } else {
                responsePlantingExcelDto.setEffAmount(format.format(hash.get(riskCode + planting31InsuranceListDto.getKindCode() + planting31InsuranceListDto.getItemCode() + planting31InsuranceListDto.getfCode())));
            }
            responsePlantingExcelDto.setPolicyNo(policyNo1);
            responsePlantingExcelDto.setRiskName(planting31InsuranceListDto.getKindCode()+"-"+mapKindCnames.get(planting31InsuranceListDto.getKindCode()));
            responsePlantingExcelDto.setiTemName(itemNameMap.get(planting31InsuranceListDto.getItemCode()));
            responsePlantingExcelDto.setId(index + "");
            responsePlantingExcelDtos.add(responsePlantingExcelDto);
        }

        return responsePlantingExcelDtos;
    }
    /**
     *  养殖险分户清单的下载
     * @author: 田慧
     * @date: 2017/12/5 10:04
     * @param riskCode 险种代码
     * @param proposalNo 投保单号
     * @param policyNo 保单号
     * @param inusreListCode  清单号
     * @param userCode  用户编码
     * @return  下载链接地址
     * @throws Exception
     */
    @Override
    public String getHerdInsuranceListExcel(String riskCode, String proposalNo, String policyNo, String inusreListCode, String userCode)throws Exception {

        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号不能为空");
        }
        if (StringUtils.isEmpty(inusreListCode)) {
            throw new DataVerifyException("清单号不能为空");
        }
        if (StringUtils.isEmpty(userCode)) {
            throw new DataVerifyException("用户代码不能为空");
        }
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空");
        }
        Class<GetHerdInsuranceListExcelDto> getHerdInsuranceListExcelDtoClass = GetHerdInsuranceListExcelDto.class;
        Map<String,String> stringStringMap = new HashMap<>();
        stringStringMap.put("inusreListCode",inusreListCode);
        List<HerdInsuranceListDto> herdInsuranceListDtoList;
        herdInsuranceListDtoList = herdInsuranceListApi.queryByInusreListCode(stringStringMap);
        if (herdInsuranceListDtoList.size()==0){//如果herdInsuranceListDtoList还有可能是耳标号没传，存临时表
            List<MiddleHerdInsuranceListDto> middleHerdInsuranceListDtoList = middleHerdInsuranceListApi.queryByInusreListCode(stringStringMap);
            this.convertCollection(middleHerdInsuranceListDtoList,herdInsuranceListDtoList,HerdInsuranceListDto.class);
        }
        if(herdInsuranceListDtoList.size()==0){
            throw new DataVerifyException("清单信息为空！");
        }
        Map<String,String> riskCodemap = new HashMap<>();
        riskCodemap.put("riskCode",riskCode);
        PrpDriskDto prpDriskDto = prpDriskApi.queryByPK(riskCodemap);
        String riskCname = prpDriskDto.getRiskCName();
        List<GetHerdInsuranceListExcelDto> getHerdInsuranceListExcelDtoList = getGetHerdInsuranceListExcelDto(herdInsuranceListDtoList, proposalNo, riskCode, policyNo, riskCname, inusreListCode);
        String titleName = "国元农业保险分户清单("+riskCname+")";
        String excelName = "投(承)保分户清单";
        String fileId=this.<GetHerdInsuranceListExcelDto>getFileId(getHerdInsuranceListExcelDtoClass,titleName,excelName,getHerdInsuranceListExcelDtoList);
        return fileId;
    }
    /**
     *  养殖险分户清单的下载
     * @author: 田健
     * @date: 2017/12/5 10:04
     * @param riskCode 险种代码
     * @param proposalNo 投保单号
     * @param policyNo 保单号
     * @param inusreListCode  清单号
     * @param userCode  用户编码
     * @return  下载链接地址
     * @throws Exception
     */
    @Override
    public String getNyxInsuranceListExcel(String riskCode, String proposalNo, String policyNo, String inusreListCode, String userCode)throws Exception {

        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号不能为空");
        }
        if (StringUtils.isEmpty(inusreListCode)) {
            throw new DataVerifyException("清单号不能为空");
        }
        if (StringUtils.isEmpty(userCode)) {
            throw new DataVerifyException("用户代码不能为空");
        }
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空");
        }
        Map<String,String> stringStringMap = new HashMap<>();
        List<NyxInsuranceListDto> nyxInsuranceListDtoList;
        stringStringMap.put("inusreListCode",inusreListCode);
        nyxInsuranceListDtoList = nyxInsuranceListApi.queryByInusreListCode(stringStringMap);
        if(nyxInsuranceListDtoList.size()==0){
            List<MiddleHerdInsuranceListDto> middleHerdInsuranceListDtoList = middleHerdInsuranceListApi.queryByInusreListCode(stringStringMap);
            this.convertCollection(middleHerdInsuranceListDtoList,nyxInsuranceListDtoList,NyxInsuranceListDto.class);
        }
        if(nyxInsuranceListDtoList.size()==0){
            throw new DataVerifyException("清单信息为空！");
        }
        Map<String,String> riskCodemap = new HashMap<>();
        riskCodemap.put("riskCode",riskCode);
        PrpDriskDto prpDriskDto = prpDriskApi.queryByPK(riskCodemap);
        String riskCname = prpDriskDto.getRiskCName();
        String titleName = "国元农业保险分户清单("+riskCname+")";
        String excelName = "投(承)保分户清单";
        String fileId ="";
        //获取反射对象
        if ("32".equals(riskCode.substring(0, 2)) && !"3224".equals(riskCode)) {//养殖险
            Class<GetHerdInsuranceListExcelDto> getHerdInsuranceListExcelDtoClass = GetHerdInsuranceListExcelDto.class;
            List<GetHerdInsuranceListExcelDto> getHerdInsuranceListExcelDtoList = getBreedNyxInsuranceListExcelDto(nyxInsuranceListDtoList, proposalNo, riskCode, policyNo,riskCname);
            fileId=this.<GetHerdInsuranceListExcelDto>getFileId(getHerdInsuranceListExcelDtoClass,titleName,excelName,getHerdInsuranceListExcelDtoList);
        } else {//种植险或养鱼
            Class<ResponsePlantingExcelDto> businessListClass = ResponsePlantingExcelDto.class;
            List<ResponsePlantingExcelDto> responsePlantingExcelDtoList = getPlantingNyxINsuranceListExcelDto(nyxInsuranceListDtoList, proposalNo, riskCode, policyNo, riskCname);
            fileId = this.<ResponsePlantingExcelDto>getFileId(businessListClass, titleName, excelName, responsePlantingExcelDtoList);
        }
        return fileId;
    }

    /**
     *  农险分户清单下载 数据转换
     * @author: 田慧
     * @date: 2017/12/8 下午 17:14
     * @param herdInsuranceListDtoList 分户清单数据
     * @param proposalNo 投保单
     * @param riskCode 险种
     * @param policyNo 保单
     * @param riskCname 险种名称
     * @return excel数据对象
     * @throws Exception
     */
    public List<GetHerdInsuranceListExcelDto> getGetHerdInsuranceListExcelDto(List<HerdInsuranceListDto> herdInsuranceListDtoList, String proposalNo, String riskCode, String policyNo, String riskCname, String inusreListCode) throws Exception {
        List<GetHerdInsuranceListExcelDto> getHerdInsuranceListExcelDtoList = new ArrayList<GetHerdInsuranceListExcelDto>();
        GetHerdInsuranceListExcelDto getHerdInsuranceListExcelDto1 = new GetHerdInsuranceListExcelDto();
        String itemName = "";
        List<String> kindCodeList = new ArrayList<>();
        QueryItemCodePmsDto queryItemCodePmsDto= new QueryItemCodePmsDto();
        queryItemCodePmsDto.setRiskCode(riskCode);
        List<String> itemCodeList= new ArrayList<>();
        herdInsuranceListDtoList.forEach(herdInsuranceListDto -> {
            String kindCode = herdInsuranceListDto.getKindCode();
            if (!kindCodeList.contains(kindCode)) {
                kindCodeList.add(kindCode);
            }
            String itemCode = herdInsuranceListDto.getItemCode();
            if (!itemCodeList.contains(itemCode)) {
                itemCodeList.add(itemCode);
            }
        });
        String breedingKind = herdInsuranceListDtoList.get(0).getBreedingKind();
        String breedingKindName = "";
        if(StringUtils.isNotEmpty(breedingKind)){
            breedingKindName = prpDcodeApi.translateCode("RaiseType",breedingKind, LanguageFlagConstant.CHINESE);
        }
        queryItemCodePmsDto.setItemCodeList(itemCodeList);
        List<PrpDitemAgriDto> prpDitemAgriDtoList= prpDitemAgriApi.queryItemName(queryItemCodePmsDto);
        Map<String,String> itemNameMap = new HashMap<>();
        for (PrpDitemAgriDto p: prpDitemAgriDtoList) {
            itemName = p.getItemCode() + "-" + p.getItemCName();
            itemNameMap.put( p.getItemCode(),itemName);
        }
        Map<String,Object> kindMap = new HashMap<>();
        kindMap.put("kindCodes",kindCodeList);
        kindMap.put("riskCode",riskCode);
        Map<String,String> mapKindCnames = prpDkindApi.queryByKindCodes(kindMap);
        Boolean flse = false;
        List<PrpCmain> byProposalNo = prpCmainDao.findByProposalNo(proposalNo);
        String policyNo1 = "";
        if (byProposalNo == null || (byProposalNo != null && byProposalNo.size() <= 0)) {
            flse = true;
        } else {
            policyNo1 = byProposalNo.get(0).getPolicyNo();
        }
        Map<String, Double> hash = new HashMap<String, Double>();
        if (!flse) {
            hash = nyxEffectiveAmountApi.queryNyxEffectiveAmount(true, riskCode, inusreListCode, policyNo1);
        }
        DecimalFormat format = new DecimalFormat("0.00");
        int index = 0;
        for (HerdInsuranceListDto herdInsuranceListDto : herdInsuranceListDtoList) {
            index++;
            GetHerdInsuranceListExcelDto getHerdInsuranceListExcelDto=getHerdInsuranceListExcelDto1.getGetHerdInsuranceListExcelDto(herdInsuranceListDto);
            getHerdInsuranceListExcelDto.setProposalNo(proposalNo);
            getHerdInsuranceListExcelDto.setPolicyNo(policyNo1);
            if (flse) {
                getHerdInsuranceListExcelDto.setEffAmount(format.format(herdInsuranceListDto.getSumAmount()));
            } else {
                getHerdInsuranceListExcelDto.setEffAmount(format.format(hash.get(riskCode + herdInsuranceListDto.getKindCode() + herdInsuranceListDto.getItemCode() + herdInsuranceListDto.getfCode())));
            }
            getHerdInsuranceListExcelDto.setRiskName(herdInsuranceListDto.getKindCode()+"-"+mapKindCnames.get(herdInsuranceListDto.getKindCode()));
            getHerdInsuranceListExcelDto.setBreedingKind(breedingKindName);
            getHerdInsuranceListExcelDto.setiTemName(itemNameMap.get(herdInsuranceListDto.getItemCode()));
            getHerdInsuranceListExcelDto.setId(index + "");
            getHerdInsuranceListExcelDtoList.add(getHerdInsuranceListExcelDto);
        }

        return getHerdInsuranceListExcelDtoList;
    }
    /**
     *  农险分户清单下载 数据转换--养殖险多险别多标的
     * @author: 田慧
     * @date: 2017/12/8 下午 17:14
     * @param nyxInsuranceListDtoList 分户清单数据
     * @param proposalNo 投保单
     * @param riskCode 险种
     * @param policyNo 保单
     * @param riskCname 险种名称
     * @return excel数据对象
     * @throws Exception
     */
    public List<GetHerdInsuranceListExcelDto> getBreedNyxInsuranceListExcelDto(List<NyxInsuranceListDto> nyxInsuranceListDtoList, String proposalNo, String riskCode, String policyNo,String riskCname) throws Exception {
        List<GetHerdInsuranceListExcelDto> getHerdInsuranceListExcelDtoList = new ArrayList<GetHerdInsuranceListExcelDto>();
        GetHerdInsuranceListExcelDto getHerdInsuranceListExcelDto1 = new GetHerdInsuranceListExcelDto();
        String itemName = "";
        List<String> kindCodeList = new ArrayList<>();
        QueryItemCodePmsDto queryItemCodePmsDto= new QueryItemCodePmsDto();
        queryItemCodePmsDto.setRiskCode(riskCode);
        List<String> itemCodeList= new ArrayList<>();
        nyxInsuranceListDtoList.forEach(plantingInsuranceListDto -> {
            String kindCode = plantingInsuranceListDto.getKindCode();
            if (!kindCodeList.contains(kindCode)) {
                kindCodeList.add(kindCode);
            }
            String itemCode = plantingInsuranceListDto.getItemCode();
            if (!itemCodeList.contains(itemCode)) {
                itemCodeList.add(itemCode);
            }
        });
        queryItemCodePmsDto.setItemCodeList(itemCodeList);
        List<PrpDitemAgriDto> prpDitemAgriDtoList= prpDitemAgriApi.queryItemName(queryItemCodePmsDto);
        Map<String,String> itemNameMap = new HashMap<>();
        for (PrpDitemAgriDto p: prpDitemAgriDtoList) {
            itemName = p.getItemCode() + "-" + p.getItemCName();
            itemNameMap.put( p.getItemCode(),itemName);
        }
        Boolean flse = false;
        String policyNo1 = "";
        String breedingKind = nyxInsuranceListDtoList.get(0).getBreedingKind();
        String breedingKindName = "";
        if(StringUtils.isNotEmpty(breedingKind)){
            breedingKindName = prpDcodeApi.translateCode("RaiseType",breedingKind, LanguageFlagConstant.CHINESE);
        }
        List<PrpCmain> byProposalNo = prpCmainDao.findByProposalNo(proposalNo);
        if (byProposalNo == null || (byProposalNo != null && byProposalNo.size() <= 0)) {
            flse = true;
        } else {
            policyNo1 = byProposalNo.get(0).getPolicyNo();
        }
        Map<String, Double> hash = new HashMap<String, Double>();
        if (!flse) {
            hash = nyxEffectiveAmountApi.queryNyxEffectiveAmount(true, riskCode, "", policyNo1);
        }
        Map<String,Object> kindMap = new HashMap<>();
        kindMap.put("kindCodes",kindCodeList);
        kindMap.put("riskCode",riskCode);
        Map<String,String> mapKindCnames = prpDkindApi.queryByKindCodes(kindMap);
        DecimalFormat format = new DecimalFormat("0.00");
        int index = 0;
        for (NyxInsuranceListDto nyxInsuranceListDto : nyxInsuranceListDtoList) {
            index++;
            GetHerdInsuranceListExcelDto getHerdInsuranceListExcelDto=getHerdInsuranceListExcelDto1.getGetHerdInsuranceListExcelDto(nyxInsuranceListDto);
            getHerdInsuranceListExcelDto.setProposalNo(proposalNo);
            getHerdInsuranceListExcelDto.setPolicyNo(policyNo);
            if (flse) {
                getHerdInsuranceListExcelDto.setEffAmount(format.format(nyxInsuranceListDto.getSumAmount()));
            } else {
                getHerdInsuranceListExcelDto.setEffAmount(format.format(hash.get(nyxInsuranceListDto.getRiskCode() + nyxInsuranceListDto.getKindCode() + nyxInsuranceListDto.getItemCode() + nyxInsuranceListDto.getfCode())));
            }
            getHerdInsuranceListExcelDto.setRiskName(nyxInsuranceListDto.getKindCode()+"-"+mapKindCnames.get(nyxInsuranceListDto.getKindCode()));
            getHerdInsuranceListExcelDto.setBreedingKind(breedingKindName);
            getHerdInsuranceListExcelDto.setiTemName(itemNameMap.get(nyxInsuranceListDto.getItemCode()));
            getHerdInsuranceListExcelDto.setId(index + "");
            getHerdInsuranceListExcelDtoList.add(getHerdInsuranceListExcelDto);
        }

        return getHerdInsuranceListExcelDtoList;
    }
    /**
     * 农险分户清单下载 数据转换
     *
     * @param nyxInsuranceListDtoList 分户清单数据
     * @param proposalNo                投保单
     * @param riskCode                  险种
     * @param policyNo                  保单
     * @param riskCname                 险种名称
     * @return excel数据对象
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/6 下午 17:57
     */
    public List<ResponsePlantingExcelDto> getPlantingNyxINsuranceListExcelDto(List<NyxInsuranceListDto> nyxInsuranceListDtoList, String proposalNo, String riskCode, String policyNo, String riskCname) throws Exception {
        List<ResponsePlantingExcelDto> responsePlantingExcelDtos = new ArrayList<ResponsePlantingExcelDto>();
        ResponsePlantingExcelDto responsePlantingExcelDto1 = new ResponsePlantingExcelDto();
        String itemName = "";
        List<String> kindCodeList = new ArrayList<>();
        QueryItemCodePmsDto queryItemCodePmsDto= new QueryItemCodePmsDto();
        queryItemCodePmsDto.setRiskCode(riskCode);
        List<String> itemCodeList= new ArrayList<>();
        nyxInsuranceListDtoList.forEach(plantingInsuranceListDto -> {
            String kindCode = plantingInsuranceListDto.getKindCode();
            if (!kindCodeList.contains(kindCode)) {
                kindCodeList.add(kindCode);
            }
            String itemCode = plantingInsuranceListDto.getItemCode();
            if (!itemCodeList.contains(itemCode)) {
                itemCodeList.add(itemCode);
            }
        });
        queryItemCodePmsDto.setItemCodeList(itemCodeList);
        List<PrpDitemAgriDto> prpDitemAgriDtoList= prpDitemAgriApi.queryItemName(queryItemCodePmsDto);
        Map<String,String> itemNameMap = new HashMap<>();
        for (PrpDitemAgriDto p: prpDitemAgriDtoList) {
            itemName = p.getItemCode() + "-" + p.getItemCName();
            itemNameMap.put( p.getItemCode(),itemName);
        }
        Map<String,Object> kindMap = new HashMap<>();
        kindMap.put("kindCodes",kindCodeList);
        kindMap.put("riskCode",riskCode);
        Map<String,String> mapKindCnames = prpDkindApi.queryByKindCodes(kindMap);
        Boolean flse = false;
        List<PrpCmain> byProposalNo = prpCmainDao.findByProposalNo(proposalNo);
        String policyNo1 = "";
        if (byProposalNo == null || (byProposalNo != null && byProposalNo.size() <= 0)) {
            flse = true;
        } else {
            policyNo1 = byProposalNo.get(0).getPolicyNo();
        }
        Map<String, Double> hash = new HashMap<String, Double>();
        if (!flse) {
            hash = nyxEffectiveAmountApi.queryNyxEffectiveAmount(true, riskCode, null, policyNo1);
        }
        DecimalFormat format = new DecimalFormat("0.00");
        int index = 0;
        //循环转换数据
        for (NyxInsuranceListDto nyxInsuranceListDto : nyxInsuranceListDtoList) {
            index++;
            ResponsePlantingExcelDto responsePlantingExcelDto = responsePlantingExcelDto1.getResponsePlantingExcelDto(nyxInsuranceListDto);
            responsePlantingExcelDto.setProposalNo(proposalNo);
            if (flse) {
                responsePlantingExcelDto.setEffAmount(format.format(nyxInsuranceListDto.getSumAmount()));
            } else {
                responsePlantingExcelDto.setEffAmount(format.format(hash.get(nyxInsuranceListDto.getRiskCode() + nyxInsuranceListDto.getKindCode() + nyxInsuranceListDto.getItemCode() + nyxInsuranceListDto.getfCode())));
            }
            responsePlantingExcelDto.setPolicyNo(policyNo1);
            responsePlantingExcelDto.setRiskName(nyxInsuranceListDto.getKindCode()+"-"+mapKindCnames.get(nyxInsuranceListDto.getKindCode()));
            responsePlantingExcelDto.setiTemName(itemNameMap.get(nyxInsuranceListDto.getItemCode()));
            responsePlantingExcelDto.setId(index + "");
            responsePlantingExcelDtos.add(responsePlantingExcelDto);
        }
        return responsePlantingExcelDtos;
    }

    /**
     * 根据出险时间、保单号查询清单信息
     * @author: 田健
     * @date: 2018/4/11 9:36
     * @param policyNo 保单号
     * @param validDate 出险时间
     * @return 承保分户清单dto集合
     * @throws Exception
     */
    public List<AcceptInsuranceDto> queryInsureListInfo(String policyNo, Date validDate) throws Exception {
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空！");
        }
        if (validDate == null) {
            throw new DataVerifyException("出险时间不能为空！");
        }
        String businessNo = policyNo;
        //第一步 判断此保单是否做过批改
        List<PrpPhead> prpPheadList = prpPheadDao.queryByCondition(policyNo, validDate);
        Map<String, String> map = new HashMap<>();
        map.put("policyNo", policyNo);
        List<PlantingPolicyListDto> plantingPolicyListDtoList = plantingPolicyListApi.queryPlantingPolicyListByPolicyNO(map);
        List<NyxPolicyListDto> nyxPolicyListDtoList = nyxPolicyListApi.queryInsuranceListDtoByPolicyNo(map);
        List<HerdPolicyListDto> herdPolicyListDtoList = herdPolicyListApi.queryInsuranceListDtoByPolicyNo(map);
        List<Planting31PolicyListDto> planting31PolicyListDtoList = planting31PolicyListApi.queryInsuranceListDtoByPolicyNo(map);
        List<AcceptInsuranceDto> acceptInsuranceDtoList = null;
        AcceptInsuranceDto acceptInsuranceDto = null;
        if (plantingPolicyListDtoList!=null && plantingPolicyListDtoList.size() > 0) {
            acceptInsuranceDtoList = new ArrayList<>();
            for (PlantingPolicyListDto plantingPolicyListDto : plantingPolicyListDtoList) {
                acceptInsuranceDto = new AcceptInsuranceDto();
                acceptInsuranceDto = this.convert(plantingPolicyListDto, AcceptInsuranceDto.class);
                acceptInsuranceDto.setPolicyNo(policyNo);
                acceptInsuranceDtoList.add(acceptInsuranceDto);
            }
        }
        if (nyxPolicyListDtoList!=null && nyxPolicyListDtoList.size() > 0) {
            acceptInsuranceDtoList = new ArrayList<>();
            for (NyxPolicyListDto nyxPolicyListDto : nyxPolicyListDtoList) {
                acceptInsuranceDto = new AcceptInsuranceDto();
                acceptInsuranceDto = this.convert(nyxPolicyListDto, AcceptInsuranceDto.class);
                acceptInsuranceDto.setEarlAbel(nyxPolicyListDto.getBusinessNo());
                acceptInsuranceDtoList.add(acceptInsuranceDto);
            }
        }
        if (herdPolicyListDtoList!=null && herdPolicyListDtoList.size() > 0) {
            acceptInsuranceDtoList = new ArrayList<>();
            for (HerdPolicyListDto herdPolicyListDto : herdPolicyListDtoList) {
                acceptInsuranceDto = new AcceptInsuranceDto();
                acceptInsuranceDto = this.convert(herdPolicyListDto, AcceptInsuranceDto.class);
                acceptInsuranceDto.setZhiBuKa(herdPolicyListDto.getBankCard());
                acceptInsuranceDto.setfPremium(String.valueOf(herdPolicyListDto.getInsurePremium()));
                acceptInsuranceDto.setInsureArea(String.valueOf(herdPolicyListDto.getInsureNumber()));
                acceptInsuranceDtoList.add(acceptInsuranceDto);
            }
        }
        if (planting31PolicyListDtoList!=null && planting31PolicyListDtoList.size() > 0) {
            acceptInsuranceDtoList = new ArrayList<>();
            for (Planting31PolicyListDto planting31PolicyListDto : planting31PolicyListDtoList) {
                acceptInsuranceDto = new AcceptInsuranceDto();
                acceptInsuranceDto = this.convert(planting31PolicyListDto, AcceptInsuranceDto.class);
                acceptInsuranceDtoList.add(acceptInsuranceDto);
            }
        }
        //无批单信息或者批单生效日期不在出险时间内，直接取保单信息即可
        //如果存在批单信息，则走下面条件
        List<String> endorseNoList = new ArrayList<>();
        if (prpPheadList.size() > 0) {
            for (PrpPhead prpPhead : prpPheadList) {
                endorseNoList.add(prpPhead.getEndorseNo());
            }
            Map<String, List<PlantingEndorChgDetailDto>> plantingEndorChgDetailDtoListMap = plantingEndorChgDetailApi.queryByEndorseNoList(endorseNoList);
            Map<String, List<NyxEndorChgDetailDto>> nyxEndorChgDetailDtoListMap = nyxEndorChgDetailApi.queryByEndorseNoList(endorseNoList);
            Map<String, List<Planting31EndorChgDetailDto>> planting31EndorChgDetailDtoListMap = planting31EndorChgDetailApi.queryByEndorseNoList(endorseNoList);
            Map<String, List<HerdEndorChgDetailDto>> herdEndorChgDetailDtoListMap = herdEndorChgDetailApi.queryByEndorseNoList(endorseNoList);
            for (PrpPhead prpPhead : prpPheadList) {
                //获取每个批单下的清单信息
                if (plantingEndorChgDetailDtoListMap.size() > 0) {
                    List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtoList = plantingEndorChgDetailDtoListMap.get(prpPhead.getEndorseNo());
                    if (plantingEndorChgDetailDtoList!=null && plantingEndorChgDetailDtoList.size() > 0) {
                        acceptInsuranceDtoList = new ArrayList<>();
                        for (PlantingEndorChgDetailDto plantingEndorChgDetailDto : plantingEndorChgDetailDtoList) {
                            acceptInsuranceDto = this.convert(plantingEndorChgDetailDto, AcceptInsuranceDto.class);
                            acceptInsuranceDto.setInsureArea(String.valueOf(plantingEndorChgDetailDto.getInsureArea()));
                            acceptInsuranceDto.setfPremium(String.valueOf(plantingEndorChgDetailDto.getfPremium() + plantingEndorChgDetailDto.getChgFPremium()));
                            acceptInsuranceDto.setCentralPremium(String.valueOf(plantingEndorChgDetailDto.getCentralPremium() + plantingEndorChgDetailDto.getChgCentralPremium()));
                            acceptInsuranceDto.setProvincePremium(String.valueOf(plantingEndorChgDetailDto.getProvincePremium() + plantingEndorChgDetailDto.getChgProvincePremium()));
                            acceptInsuranceDto.setTownPremium(String.valueOf(plantingEndorChgDetailDto.getTownPremium() + plantingEndorChgDetailDto.getChgTownPremium()));
                            acceptInsuranceDto.setCityPremium(String.valueOf(plantingEndorChgDetailDto.getCityPremium() + plantingEndorChgDetailDto.getChgCityPremium()));
                            acceptInsuranceDto.setOtherPremium(String.valueOf(plantingEndorChgDetailDto.getOtherPremium() + plantingEndorChgDetailDto.getChgOtherPremium()));
                            acceptInsuranceDtoList.add(acceptInsuranceDto);
                        }
                    }
                }
                if (nyxEndorChgDetailDtoListMap.size() > 0) {
                    List<NyxEndorChgDetailDto> nyxEndorChgDetailDtoList = nyxEndorChgDetailDtoListMap.get(prpPhead.getEndorseNo());
                    if (nyxEndorChgDetailDtoList!=null && nyxEndorChgDetailDtoList.size() > 0) {
                        acceptInsuranceDtoList = new ArrayList<>();
                        for (NyxEndorChgDetailDto nyxEndorChgDetailDto : nyxEndorChgDetailDtoList) {
                            acceptInsuranceDto = this.convert(nyxEndorChgDetailDto, AcceptInsuranceDto.class);
                            acceptInsuranceDto.setInsureArea(String.valueOf(nyxEndorChgDetailDto.getInsureArea()));
                            acceptInsuranceDto.setfPremium(String.valueOf(nyxEndorChgDetailDto.getfPremium() + nyxEndorChgDetailDto.getChgFPremium()));
                            acceptInsuranceDto.setCentralPremium(String.valueOf(nyxEndorChgDetailDto.getCentralPremium() + nyxEndorChgDetailDto.getChgCentralPremium()));
                            acceptInsuranceDto.setProvincePremium(String.valueOf(nyxEndorChgDetailDto.getProvincePremium() + nyxEndorChgDetailDto.getChgProvincePremium()));
                            acceptInsuranceDto.setTownPremium(String.valueOf(nyxEndorChgDetailDto.getTownPremium() + nyxEndorChgDetailDto.getChgTownPremium()));
                            acceptInsuranceDto.setCityPremium(String.valueOf(nyxEndorChgDetailDto.getCityPremium() + nyxEndorChgDetailDto.getChgCityPremium()));
                            acceptInsuranceDto.setOtherPremium(String.valueOf(nyxEndorChgDetailDto.getOtherPremium() + nyxEndorChgDetailDto.getChgOtherPremium()));
                            acceptInsuranceDto.setEarlAbel(nyxEndorChgDetailDto.getBusinessNo());
                            acceptInsuranceDtoList.add(acceptInsuranceDto);
                        }
                    }

                }
                if (planting31EndorChgDetailDtoListMap.size() > 0) {
                    List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtoList = planting31EndorChgDetailDtoListMap.get(prpPhead.getEndorseNo());
                    if (planting31EndorChgDetailDtoList!=null && planting31EndorChgDetailDtoList.size() > 0) {
                        acceptInsuranceDtoList = new ArrayList<>();
                        for (Planting31EndorChgDetailDto planting31EndorChgDetailDto : planting31EndorChgDetailDtoList) {
                            acceptInsuranceDto = this.convert(planting31EndorChgDetailDto, AcceptInsuranceDto.class);
                            acceptInsuranceDto.setInsureArea(String.valueOf(planting31EndorChgDetailDto.getInsureArea()));
                            acceptInsuranceDto.setfPremium(String.valueOf(planting31EndorChgDetailDto.getfPremium() + planting31EndorChgDetailDto.getChgFPremium()));
                            acceptInsuranceDto.setCentralPremium(String.valueOf(planting31EndorChgDetailDto.getCentralPremium() + planting31EndorChgDetailDto.getChgCentralPremium()));
                            acceptInsuranceDto.setProvincePremium(String.valueOf(planting31EndorChgDetailDto.getProvincePremium() + planting31EndorChgDetailDto.getChgProvincePremium()));
                            acceptInsuranceDto.setTownPremium(String.valueOf(planting31EndorChgDetailDto.getTownPremium() + planting31EndorChgDetailDto.getChgTownPremium()));
                            acceptInsuranceDto.setCityPremium(String.valueOf(planting31EndorChgDetailDto.getCityPremium() + planting31EndorChgDetailDto.getChgCityPremium()));
                            acceptInsuranceDtoList.add(acceptInsuranceDto);
                        }
                    }
                }
                if (herdEndorChgDetailDtoListMap.size() > 0) {
                    List<HerdEndorChgDetailDto> herdEndorChgDetailDtoList = herdEndorChgDetailDtoListMap.get(prpPhead.getEndorseNo());
                    if (herdEndorChgDetailDtoList!=null && herdEndorChgDetailDtoList.size() > 0) {
                        acceptInsuranceDtoList = new ArrayList<>();
                        for (HerdEndorChgDetailDto herdEndorChgDetailDto : herdEndorChgDetailDtoList) {
                            acceptInsuranceDto = this.convert(herdEndorChgDetailDto, AcceptInsuranceDto.class);
                            acceptInsuranceDto.setEarlAbel(herdEndorChgDetailDto.getEarLabel());
                            acceptInsuranceDto.setInsureArea(String.valueOf(herdEndorChgDetailDto.getInsureNumber()));
                            acceptInsuranceDto.setfPremium(String.valueOf(herdEndorChgDetailDto.getInsurePremium() + herdEndorChgDetailDto.getChgFPremium()));
                            acceptInsuranceDto.setCentralPremium(String.valueOf(herdEndorChgDetailDto.getCentralPremium() + herdEndorChgDetailDto.getChgCentralPremium()));
                            acceptInsuranceDto.setProvincePremium(String.valueOf(herdEndorChgDetailDto.getProvincePremium() + herdEndorChgDetailDto.getChgProvincePremium()));
                            acceptInsuranceDto.setTownPremium(String.valueOf(herdEndorChgDetailDto.getTownPremium() + herdEndorChgDetailDto.getChgTownPremium()));
                            acceptInsuranceDto.setCityPremium(String.valueOf(herdEndorChgDetailDto.getCityPremium() + herdEndorChgDetailDto.getChgCityPremium()));
                            acceptInsuranceDto.setOtherPremium(String.valueOf(herdEndorChgDetailDto.getOtherPremium() + herdEndorChgDetailDto.getChgOtherPremium()));
                            acceptInsuranceDto.setEarlAbel(herdEndorChgDetailDto.getEarLabel());
                            acceptInsuranceDtoList.add(acceptInsuranceDto);
                        }
                    }
                }
            }
        }
        //查找最大的批单号
        if(endorseNoList.size()==1){
            businessNo = endorseNoList.get(0);
        }
        for (int i = 0; i < endorseNoList.size(); i++) {
            for (int j = i+1; j < endorseNoList.size(); j++) {
                System.out.println(businessNo.compareTo(endorseNoList.get(j)));
                if(businessNo.compareTo(endorseNoList.get(j))<0){
                    businessNo=endorseNoList.get(j);
                }
            }
        }
        //查询prpCmainAgri获取清单险别信息
        PrpCmainAgri prpCmainAgri = prpCmainAgriDao.queryByPolicyNo(policyNo);
        String riskCode = prpCmainAgri.getRiskCode();
        String inusreListCode = prpCmainAgri.getRelationListNo();
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("riskCode",riskCode);
        stringMap.put("inusreListCode",inusreListCode);
        stringMap.put("businessNo",businessNo);
        Map<String, Double> effAmountMap = nyxEffectiveAmountApi.queryNyxEffectiveAmountByBusinessNo(stringMap);
        for(AcceptInsuranceDto acceptInsuranceDto1:acceptInsuranceDtoList){
            acceptInsuranceDto1.setEffAmount(String.valueOf(effAmountMap.get(riskCode+acceptInsuranceDto1.getKindCode()+acceptInsuranceDto1.getItemCode()+acceptInsuranceDto1.getfCode())));
        }
        return acceptInsuranceDtoList;
    }
    /**
     * 根据出险时间、保单号查询清单信息并下载
     * @author: 田健
     * @date: 2018/4/11 9:36
     * @param policyNo 保单号
     * @param validDate 出险时间
     * @return 承保分户清单dto集合
     * @throws Exception
     */
    @Override
    public Map<String, String> getInsureListInfoFileId(String policyNo, Date validDate) throws Exception {
        //查询清单信息
        List<AcceptInsuranceDto> acceptInsuranceDtoList = new ArrayList<>();
        try {
            acceptInsuranceDtoList = this.queryInsureListInfo(policyNo, validDate);
        } catch (DataVerifyException de) {
            throw de;
        } catch (BusinessException e) {
            throw new BusinessException("查询清单信息失败！");
        }
        if (acceptInsuranceDtoList == null) {
            throw new BusinessException("清单信息为空！");
        }
        PrpCmain prpCmain = prpCmainDao.findByPolicyNo(policyNo);
        String proposalNo = prpCmain.getProposalNo();
        String riskCode = prpCmain.getRiskCode();

        //获取险别-名称
        Map<String, String> riskCodemap = new HashMap<>();
        riskCodemap.put("riskCode", riskCode);
        PrpDriskDto prpDriskDto = prpDriskApi.queryByPK(riskCodemap);
        String riskCname = prpDriskDto.getRiskCName();
        List<ResponsePlantingExcelDto> responsePlantingExcelDtoList = null;
        String itemName = "";
        List<String> kindCodeList = new ArrayList<>();
        QueryItemCodePmsDto queryItemCodePmsDto = new QueryItemCodePmsDto();
        queryItemCodePmsDto.setRiskCode(riskCode);
        List<String> itemCodeList = new ArrayList<>();
        acceptInsuranceDtoList.forEach(acceptInsuranceDto -> {
            String kindCode = acceptInsuranceDto.getKindCode();
            if (!kindCodeList.contains(kindCode)) {
                kindCodeList.add(kindCode);
            }
            String itemCode = acceptInsuranceDto.getItemCode();
            if (!itemCodeList.contains(itemCode)) {
                itemCodeList.add(itemCode);
            }
        });

        queryItemCodePmsDto.setItemCodeList(itemCodeList);
        List<PrpDitemAgriDto> prpDitemAgriDtoList = new ArrayList<>();
        try {
            prpDitemAgriDtoList = prpDitemAgriApi.queryItemName(queryItemCodePmsDto);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new BusinessException("查询标的失败！");
        }
        Map<String, String> itemNameMap = new HashMap<>();
        for (PrpDitemAgriDto p : prpDitemAgriDtoList) {
            itemName = p.getItemCode() + "-" + p.getItemCName();
            itemNameMap.put(p.getItemCode(), itemName);
        }
        Map<String, Object> kindMap = new HashMap<>();
        kindMap.put("kindCodes", kindCodeList);
        kindMap.put("riskCode", riskCode);
        Map<String, String> mapKindCnames = new HashMap<>();
        try {
            mapKindCnames = prpDkindApi.queryByKindCodes(kindMap);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new BusinessException("查询险别失败！");
        }
        String breedingKind = acceptInsuranceDtoList.get(0).getBreedingKind();
        String breedingKindName = "";
        if(StringUtils.isNotEmpty(breedingKind)){
            breedingKindName = prpDcodeApi.translateCode("RaiseType",breedingKind, LanguageFlagConstant.CHINESE);
        }
        int index = 0;
        //数据转换
        String titleName = "国元农业保险分户清单(" + riskCname + ")";
        String excelName = "投(承)保分户清单";
        //生成短连接
        String fileId = "";
        try {
            //获取反射对象
            if ("31".equals(riskCode.substring(0, 2))) {//种植险
                Class<ResponsePlantingExcelDto> businessListClass = ResponsePlantingExcelDto.class;
                ResponsePlantingExcelDto responsePlantingExcelDto1 = new ResponsePlantingExcelDto();
                List<ResponsePlantingExcelDto> responsePlantingExcelDtos = new ArrayList<>();
                //循环转换数据
                for (AcceptInsuranceDto acceptInsuranceDto : acceptInsuranceDtoList) {
                    index++;
                    ResponsePlantingExcelDto responsePlantingExcelDto = responsePlantingExcelDto1.getInsureListInfoExcelDto(acceptInsuranceDto);
                    responsePlantingExcelDto.setProposalNo(proposalNo);
                    responsePlantingExcelDto.setPolicyNo(policyNo);
                    responsePlantingExcelDto.setRiskName(acceptInsuranceDto.getKindCode() + "-" + mapKindCnames.get(acceptInsuranceDto.getKindCode()));
                    responsePlantingExcelDto.setiTemName(itemNameMap.get(acceptInsuranceDto.getItemCode()));
                    responsePlantingExcelDto.setId(index + "");
                    responsePlantingExcelDtos.add(responsePlantingExcelDto);
                }
                fileId = this.<ResponsePlantingExcelDto>getFileId(businessListClass, titleName, excelName, responsePlantingExcelDtos);
            } else {//养殖险
                List<GetHerdInsuranceListExcelDto> getHerdInsuranceListExcelDtoList = new ArrayList<GetHerdInsuranceListExcelDto>();
                Class<GetHerdInsuranceListExcelDto> getHerdInsuranceListExcelDtoClass = GetHerdInsuranceListExcelDto.class;
                GetHerdInsuranceListExcelDto getHerdInsuranceListExcelDto1 = new GetHerdInsuranceListExcelDto();
                for (AcceptInsuranceDto acceptInsuranceDto : acceptInsuranceDtoList) {
                    index++;
                    GetHerdInsuranceListExcelDto getHerdInsuranceListExcelDto = getHerdInsuranceListExcelDto1.getInsureListInfoExcelDto(acceptInsuranceDto);
                    getHerdInsuranceListExcelDto.setBreedingKind(breedingKindName);
                    getHerdInsuranceListExcelDto.setProposalNo(proposalNo);
                    getHerdInsuranceListExcelDto.setPolicyNo(policyNo);
                    getHerdInsuranceListExcelDto.setRiskName(acceptInsuranceDto.getKindCode() + "-" + mapKindCnames.get(acceptInsuranceDto.getKindCode()));
                    getHerdInsuranceListExcelDto.setiTemName(itemNameMap.get(acceptInsuranceDto.getItemCode()));
                    getHerdInsuranceListExcelDto.setId(index + "");
                    getHerdInsuranceListExcelDtoList.add(getHerdInsuranceListExcelDto);
                }
                fileId = this.<GetHerdInsuranceListExcelDto>getFileId(getHerdInsuranceListExcelDtoClass, titleName, excelName, getHerdInsuranceListExcelDtoList);
            }
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new BusinessException("下载失败！");
        }


        Map<String, String> map = new HashMap<String, String>();
        map.put("fileId", fileId);
        return map;
    }
    /**
    * 批改前清单下载
    * @param plantingExcelDto
    * @return java.util.Map<java.lang.String,java.lang.String>
    * @throws
    * @author 李冬松
    * @date 9:29 2018/4/17
    */
    @Override
    public Map<String ,String> endorExcel(PlantingExcelDto plantingExcelDto)throws Exception{
        String pollicyNo=plantingExcelDto.getPolicyNo();
        Map<String,String> map1=new HashMap<>();
        map1.put("policyNo",pollicyNo);
        List<InsureMainListDto>  insureMainListDtoList=insureMainListApi.queryByPolicyNo(pollicyNo);
        plantingExcelDto.setProposalNo(insureMainListDtoList.get(0).getProposalNo());
        plantingExcelDto.setInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
        plantingExcelDto.setRiskCode(insureMainListDtoList.get(0).getRiskCode());

        Map<String,String> map=getFileId(plantingExcelDto);
        Map<String,String> returnMap=new HashMap<>();
        returnMap.put("fileId",map.get("fileId"));
        return returnMap;
    }
    @Override
    public Map<String ,String> chgEndorExcel(String policyNo)throws Exception{
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号码不能为空！");
        }
        List<PrpPhead> prpPheadList=prpPheadDao.findPrpPheadByPolicyNo(policyNo);
        String endorseNo=prpPheadList.get(0).getEndorseNo();
        Map<String,String> map=payInfoService.exportEndorseList(endorseNo);
        return map;
    }
    /**
     * 下载批改变化量清单excel文件
     *
     * @param endorseNo 批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    @Override
    public Map<String, String> afterEndorExcel(String endorseNo) throws Exception {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        inint();
        String shortLink = null;
        List<PrpPhead> prpPheadList = prpPheadDao.queryOnlyByEndorseNo(endorseNo);
        String policyNo=prpPheadList.get(0).getPolicyNo();
        String riskCode = prpPheadList.get(0).getRiskCode();
        if (plantingRiskcode.contains(riskCode)) {
            List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList = this.getExportPlantingList(riskCode, policyNo, endorseNo);
            shortLink = exportExcel(endorseNo, plantingCpEndorChgDetailDtoList, PlantingCpEndorChgDetailDto.class);
        } else if (planting31Riskcode.contains(riskCode)) {
            List<Planting31CpEndorChgDetailDto> planting31CpEndorChgDetailDtos = this.getExportPlanting31List(riskCode, policyNo, endorseNo);
            shortLink = exportExcel(endorseNo, planting31CpEndorChgDetailDtos, Planting31CpEndorChgDetailDto.class);
        } else if (herdRiskcode.contains(riskCode)) {
            List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtos = this.getExportHerdList(riskCode, policyNo, endorseNo);
            shortLink = exportExcel(endorseNo, herdcEndorChgDetailDtos, HerdcEndorChgDetailDto.class);
        } else if (nyxRiskcode.contains(riskCode)) {
            List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtos = this.getExportNyxList(riskCode, policyNo, endorseNo);
            shortLink = exportExcel(endorseNo, nyxCpEndorChgDetailDtos, NyxCpEndorChgDetailDto.class);
        }
        Map<String, String> returnMap = new HashMap<>(1);
        returnMap.put("shortLink", shortLink);
        return returnMap;
    }

    /**
     * 获取planting表的数据
     *
     * @param riskCode  险种代码
     * @param policyNo  保单号
     * @param endorseNo 批单号
     * @param
     * @return List<PlantingEndorChgDetailDto>
     * @date: 2018/4/13 17:01
     * @author: 何伟东
     */
    private List<PlantingCpEndorChgDetailDto> getExportPlantingList(String riskCode, String policyNo, String endorseNo) throws Exception {
        Map<String, String> param = new HashMap<>(1);
        param.put("endorseNo", endorseNo);
        List<InsureMainListDto> insureMainListDtoList=insureMainListApi.queryByPolicyNo(policyNo);
        String insureListCode=insureMainListDtoList.get(0).getInusreListCode();
        Map<String,String> map=new HashMap<>();
        map.put("insureListCode",insureListCode);
        List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList = plantingCpEndorChgDetailApi.queryByInsureListCode(map);
        List<String> kindCodes = new ArrayList<>();
        List<String> itemCodes = new ArrayList<>();
        List<String> shortRateFlags = new ArrayList<>();
        for (int i = 0; i < plantingCpEndorChgDetailDtoList.size(); i++) {
            PlantingCpEndorChgDetailDto plantingCpEndorChgDetailDto = plantingCpEndorChgDetailDtoList.get(i);
            plantingCpEndorChgDetailDto.setSerialNo(i + 1);
            plantingCpEndorChgDetailDto.setPolicyNo(policyNo);
            plantingCpEndorChgDetailDto.setEndorseNo(endorseNo);
            // 险别代码
            String kindCode = plantingCpEndorChgDetailDto.getKindCode();
            if (kindCodes.indexOf(kindCode) < 0) {
                kindCodes.add(kindCode);
            }
            // 标的代吗
            String itemCode = plantingCpEndorChgDetailDto.getItemCode();
            if (itemCodes.indexOf(itemCode) < 0) {
                itemCodes.add(itemCode);
            }
            // 短期费率方式
            String shortRateFlag = plantingCpEndorChgDetailDto.getShortRateFlag();
            if (shortRateFlags.indexOf(shortRateFlag) < 0) {
                shortRateFlags.add(shortRateFlag);
            }
        }
        Map<String, String> shortRateNames = prpDcodeApi.queryShortRateFlagByCodes(shortRateFlags);
        Map<String, Object> queryKind = new HashMap<>(2);
        queryKind.put("riskCode", riskCode);
        queryKind.put("kindCodes", kindCodes);
        Map<String, String> kindNames = prpDkindApi.queryByKindCodes(queryKind);
        Map<String, Object> queryItem = new HashMap<>(2);
        queryItem.put("riskCode", riskCode);
        queryItem.put("itemCodes", itemCodes);
        Map<String, String> itemName = prpDitemApi.queryByItemCodes(queryItem);
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日");
        plantingCpEndorChgDetailDtoList.forEach(plantingCpEndorChgDetailDto -> {
            String kindCode = plantingCpEndorChgDetailDto.getKindCode();
            plantingCpEndorChgDetailDto.setKindName(kindCode + "-" + kindNames.get(kindCode));
            String itemCode = plantingCpEndorChgDetailDto.getItemCode();
            plantingCpEndorChgDetailDto.setItemName(itemCode + "-" + itemName.get(itemCode));
//            String shortRateFlag = plantingEndorChgDetailDto.getShortRateFlag();
//            plantingEndorChgDetailDto.setShortRateFlag(shortRateNames.get(shortRateFlag));
//            Date startDate = plantingEndorChgDetailDto.getStartDate();
//            plantingEndorChgDetailDto.setStartDateStr(dateFormater.format(startDate));
//            Date endDate = plantingEndorChgDetailDto.getEndDate();
//            plantingEndorChgDetailDto.setEndDateStr(dateFormater.format(endDate));
        });
        return plantingCpEndorChgDetailDtoList;
    }

    /**
     * 获取planting31表的数据
     *
     * @param riskCode  险种代码
     * @param policyNo  保单号
     * @param endorseNo 批单号
     * @param
     * @return List<PlantingEndorChgDetailDto>
     * @date: 2018/4/13 17:01
     * @author: 何伟东
     */
    private List<Planting31CpEndorChgDetailDto> getExportPlanting31List(String riskCode, String policyNo, String endorseNo) throws Exception {
        Map<String, String> param = new HashMap<>(1);
        param.put("endorseNo", endorseNo);
        List<InsureMainListDto> insureMainListDtoList=insureMainListApi.queryByPolicyNo(policyNo);
        String insureListCode=insureMainListDtoList.get(0).getInusreListCode();
        Map<String,String> map=new HashMap<>();
        map.put("insureListCode",insureListCode);
        List<Planting31CpEndorChgDetailDto> planting31CpEndorChgDetailDtoList = planting31CpEndorChgDetailApi.queryByInsureListCode(map);
        List<String> kindCodes = new ArrayList<>();
        List<String> itemCodes = new ArrayList<>();
        List<String> shortRateFlags = new ArrayList<>();
        for (int i = 0; i < planting31CpEndorChgDetailDtoList.size(); i++) {
            Planting31CpEndorChgDetailDto planting31CpEndorChgDetailDto = planting31CpEndorChgDetailDtoList.get(i);
            planting31CpEndorChgDetailDto.setSerialNo(i + 1);
            planting31CpEndorChgDetailDto.setPolicyNo(policyNo);
            planting31CpEndorChgDetailDto.setEndorseNo(endorseNo);

            // 险别代码
            String kindCode = planting31CpEndorChgDetailDto.getKindCode();
            if (kindCodes.indexOf(kindCode) < 0) {
                kindCodes.add(kindCode);
            }
            // 标的代吗
            String itemCode = planting31CpEndorChgDetailDto.getItemCode();
            if (itemCodes.indexOf(itemCode) < 0) {
                itemCodes.add(itemCode);
            }
            // 短期费率方式
            String shortRateFlag = planting31CpEndorChgDetailDto.getShortRateFlag();
            if (shortRateFlags.indexOf(shortRateFlag) < 0) {
                shortRateFlags.add(shortRateFlag);
            }
        }
        Map<String, String> shortRateNames = prpDcodeApi.queryShortRateFlagByCodes(shortRateFlags);
        Map<String, Object> queryKind = new HashMap<>(2);
        queryKind.put("riskCode", riskCode);
        queryKind.put("kindCodes", kindCodes);
        Map<String, String> kindNames = prpDkindApi.queryByKindCodes(queryKind);
        Map<String, Object> queryItem = new HashMap<>(2);
        queryItem.put("riskCode", riskCode);
        queryItem.put("itemCodes", itemCodes);
        Map<String, String> itemName = prpDitemApi.queryByItemCodes(queryItem);
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日");
        planting31CpEndorChgDetailDtoList.forEach(planting31CpEndorChgDetailDto -> {
            String kindCode = planting31CpEndorChgDetailDto.getKindCode();
            planting31CpEndorChgDetailDto.setKindName(kindCode + "-" + kindNames.get(kindCode));
            String itemCode = planting31CpEndorChgDetailDto.getItemCode();
            planting31CpEndorChgDetailDto.setItemName(itemCode + "-" + itemName.get(itemCode));
//            String shortRateFlag = planting31EndorChgDetailDto.getShortRateFlag();
//            planting31EndorChgDetailDto.setShortRateFlag(shortRateNames.get(shortRateFlag));
//            Date startDate = planting31EndorChgDetailDto.getStartDate();
//            planting31EndorChgDetailDto.setStartDateStr(dateFormater.format(startDate));
//            Date endDate = planting31EndorChgDetailDto.getEndDate();
//            planting31EndorChgDetailDto.setEndDateStr(dateFormater.format(endDate));
        });
        return planting31CpEndorChgDetailDtoList;
    }

    /**
     * 获取herd表的数据
     *
     * @param riskCode  险种代码
     * @param policyNo  保单号
     * @param endorseNo 批单号
     * @param
     * @return List<PlantingEndorChgDetailDto>
     * @date: 2018/4/13 17:01
     * @author: 何伟东
     */
    private List<HerdcEndorChgDetailDto> getExportHerdList(String riskCode, String policyNo, String endorseNo) throws Exception {
        Map<String, String> param = new HashMap<>(1);
        param.put("endorseNo", endorseNo);
        List<InsureMainListDto> insureMainListDtoList=insureMainListApi.queryByPolicyNo(policyNo);
        String insureListCode=insureMainListDtoList.get(0).getInusreListCode();
        Map<String,String> map=new HashMap<>();
        map.put("insureListCode",insureListCode);
        List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList = herdcEndorChgDetailApi.queryByInsureListCode(map);
        List<String> kindCodes = new ArrayList<>();
        List<String> itemCodes = new ArrayList<>();
        List<String> shortRateFlags = new ArrayList<>();
        for (int i = 0; i < herdcEndorChgDetailDtoList.size(); i++) {
            HerdcEndorChgDetailDto herdcEndorChgDetailDto = herdcEndorChgDetailDtoList.get(i);
            herdcEndorChgDetailDto.setSerialNo(i + 1);
            herdcEndorChgDetailDto.setPolicyNo(policyNo);
            herdcEndorChgDetailDto.setEndorseNo(endorseNo);
            // 险别代码
            String kindCode = herdcEndorChgDetailDto.getKindCode();
            if (kindCodes.indexOf(kindCode) < 0) {
                kindCodes.add(kindCode);
            }
            // 标的代吗
            String itemCode = herdcEndorChgDetailDto.getItemCode();
            if (itemCodes.indexOf(itemCode) < 0) {
                itemCodes.add(itemCode);
            }
            // 短期费率方式
            String shortRateFlag = herdcEndorChgDetailDto.getShortRateFlag();
            if (shortRateFlags.indexOf(shortRateFlag) < 0) {
                shortRateFlags.add(shortRateFlag);
            }
        }
        Map<String, String> shortRateNames = prpDcodeApi.queryShortRateFlagByCodes(shortRateFlags);
        Map<String, Object> queryKind = new HashMap<>(2);
        queryKind.put("riskCode", riskCode);
        queryKind.put("kindCodes", kindCodes);
        Map<String, String> kindNames = prpDkindApi.queryByKindCodes(queryKind);
        Map<String, Object> queryItem = new HashMap<>(2);
        queryItem.put("riskCode", riskCode);
        queryItem.put("itemCodes", itemCodes);
        Map<String, String> itemName = prpDitemApi.queryByItemCodes(queryItem);
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日");
        herdcEndorChgDetailDtoList.forEach(herdEndorChgDetailDto -> {
            String kindCode = herdEndorChgDetailDto.getKindCode();
            herdEndorChgDetailDto.setKindName(kindCode + "-" + kindNames.get(kindCode));
            String itemCode = herdEndorChgDetailDto.getItemCode();
            herdEndorChgDetailDto.setItemName(itemCode + "-" + itemName.get(itemCode));
//            String shortRateFlag = herdEndorChgDetailDto.getShortRateFlag();
//            herdEndorChgDetailDto.setShortRateFlag(shortRateNames.get(shortRateFlag));
//            Date startDate = herdEndorChgDetailDto.getStartDate();
//            herdEndorChgDetailDto.setStartDateStr(dateFormater.format(startDate));
//            Date endDate = herdEndorChgDetailDto.getEndDate();
//            herdEndorChgDetailDto.setEndDateStr(dateFormater.format(endDate));
        });
        return herdcEndorChgDetailDtoList;
    }

    /**
     * 获取nyx表的数据
     *
     * @param riskCode  险种代码
     * @param policyNo  保单号
     * @param endorseNo 批单号
     * @param
     * @return List<PlantingEndorChgDetailDto>
     * @date: 2018/4/13 17:01
     * @author: 何伟东
     */
    private List<NyxCpEndorChgDetailDto> getExportNyxList(String riskCode, String policyNo, String endorseNo) throws Exception {
        Map<String, String> param = new HashMap<>(1);
        param.put("endorseNo", endorseNo);
        List<InsureMainListDto> insureMainListDtoList=insureMainListApi.queryByPolicyNo(policyNo);
        String insureListCode=insureMainListDtoList.get(0).getInusreListCode();
        Map<String,String> map=new HashMap<>();
        map.put("insureListCode",insureListCode);
        List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtos = nyxCpEndorChgDetailApi.queryByInsureListCode(map);
        List<String> kindCodes = new ArrayList<>();
        List<String> itemCodes = new ArrayList<>();
        List<String> shortRateFlags = new ArrayList<>();
        for (int i = 0; i < nyxCpEndorChgDetailDtos.size(); i++) {
            NyxCpEndorChgDetailDto nyxCpEndorChgDetailDto = nyxCpEndorChgDetailDtos.get(i);
            nyxCpEndorChgDetailDto.setSerialNo(i + 1);
            nyxCpEndorChgDetailDto.setPolicyNo(policyNo);
            // 险别代码
            String kindCode = nyxCpEndorChgDetailDto.getKindCode();
            if (kindCodes.indexOf(kindCode) < 0) {
                kindCodes.add(kindCode);
            }
            // 标的代吗
            String itemCode = nyxCpEndorChgDetailDto.getItemCode();
            if (itemCodes.indexOf(itemCode) < 0) {
                itemCodes.add(itemCode);
            }
            // 短期费率方式
            String shortRateFlag = nyxCpEndorChgDetailDto.getShortRateFlag();
            if (shortRateFlags.indexOf(shortRateFlag) < 0) {
                shortRateFlags.add(shortRateFlag);
            }
        }
        Map<String, String> shortRateNames = prpDcodeApi.queryShortRateFlagByCodes(shortRateFlags);
        Map<String, Object> queryKind = new HashMap<>(2);
        queryKind.put("riskCode", riskCode);
        queryKind.put("kindCodes", kindCodes);
        Map<String, String> kindNames = prpDkindApi.queryByKindCodes(queryKind);
        Map<String, Object> queryItem = new HashMap<>(2);
        queryItem.put("riskCode", riskCode);
        queryItem.put("itemCodes", itemCodes);
        Map<String, String> itemName = prpDitemApi.queryByItemCodes(queryItem);
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日");
        nyxCpEndorChgDetailDtos.forEach(nyxEndorChgDetailDto -> {
            String kindCode = nyxEndorChgDetailDto.getKindCode();
            nyxEndorChgDetailDto.setKindName(kindCode + "-" + kindNames.get(kindCode));
            String itemCode = nyxEndorChgDetailDto.getItemCode();
            nyxEndorChgDetailDto.setItemName(itemCode + "-" + itemName.get(itemCode));
//            String shortRateFlag = nyxEndorChgDetailDto.getShortRateFlag();
//            nyxEndorChgDetailDto.setShortRateFlag(shortRateNames.get(shortRateFlag));
//            Date startDate = nyxEndorChgDetailDto.getStartDate();
//            nyxEndorChgDetailDto.setStartDateStr(dateFormater.format(startDate));
//            Date endDate = nyxEndorChgDetailDto.getEndDate();
//            nyxEndorChgDetailDto.setEndDateStr(dateFormater.format(endDate));
        });
        return nyxCpEndorChgDetailDtos;
    }
    /**
     * 导出excel
     *
     * @param endorseNo 批单号
     * @param dataList  数据集合
     * @param aClass    存放数据的dto
     * @return shortLink
     * @date: 2018/4/13 16:43
     * @author: 何伟东
     */
    private <T> String exportExcel(String endorseNo, List<T> dataList, Class<T> aClass) throws Exception {
        File file = null;
        String shortLink;
        try {
            String excelName = endorseNo+"批改后清单信息";

            // 生成Excel文件到本地并获取改文件的File对象
            file = this.getQuicklyExportExcel().quicklyExport(exportExcelType, excelName, "批改后清单信息", "国元农业保险分户清单（小麦种植保险）", dataList, 1, 31, aClass);
            // 将文件上传到fileserver服务器并生成文件下载的短链接地址
            shortLink = this.getFileUtil().setValidWhenLong(3600000).uploadFile(fileServiceUrl, file, SinoRequestContext.getCurrentContext().getUserCode(), "agri/tempfile", "agriprpall_paymanage");
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return shortLink;
    }
    /**
     * 获取快速导出excel实例
     *
     * @return quicklyExportExcel
     * @author: 何伟东
     * @date: 2018/1/11 11:06
     */
    private QuicklyExportExcel getQuicklyExportExcel() {
        if (quicklyExportExcel == null) {
            quicklyExportExcel = new QuicklyExportExcel();
        }
        return quicklyExportExcel;
    }

    /**
     * 获取文件操作类实例
     *
     * @return fileUtil
     * @author: 何伟东
     * @date: 2018/1/11 11:06
     */
    private FileUtil getFileUtil() {
        if (fileUtil == null) {
            fileUtil = new FileUtil();
        }
        return fileUtil;
    }
}

