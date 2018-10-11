package com.sinosoft.agriprpall.core.printPdf.service.impl;

import com.sinosoft.agriprpall.api.client.dto.RequestQueryVisaCodesAndVisaSerialNosDto;
import com.sinosoft.agriprpall.api.client.dto.RequestVisaStatusWriteBackDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryVisaCodesAndVisaSerialNosDto;
import com.sinosoft.agriprpall.api.endorsemanage.PrpPheadApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorsePrintDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.policymanage.PaymentNoticeApi;
import com.sinosoft.agriprpall.api.policymanage.PolicyQueryApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCaddressApi;
import com.sinosoft.agriprpall.api.policymanage.VisaApi;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.api.printPdf.dto.PolicyPrintStatusDto;
import com.sinosoft.agriprpall.api.proposalmanage.ProposalNoPrintApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.InsuraneItemsDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.InsuredInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ItemKingAgriDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.*;
import com.sinosoft.agriprpall.core.common.util.file.FileUtil;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyPrintService;
import com.sinosoft.agriprpall.core.printPdf.service.PrintService;
import com.sinosoft.agriprpall.core.printPdf.util.NumberToCN;
import com.sinosoft.agriprpall.core.printPdf.util.PrintUtil;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainDao;
import com.sinosoft.framework.agri.core.qrcode.QrCodeCreateUtil;
import com.sinosoft.framework.agri.core.seal.SealServiceUtils;
import com.sinosoft.framework.agri.core.seal.entity.SealDocRequestTreeNode;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 缴费通知书打印页面
 *
 * @Author: 陈道洋
 * @Date: 2017/11/27 16:41
 */
@Service
public class PrintServiceImpl extends BaseServiceImpl implements PrintService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintService.class);
    @Autowired
    private PaymentNoticeApi paymentNoticeApi;
    @Autowired
    private PrpCaddressApi prpCaddressApi;
    @Autowired
    private PolicyPrintService policyPrintService;
    @Autowired
    private PolicyQueryApi policyQueryApi;
    @Autowired
    private PrpPheadApi prpPheadApi;
    @Autowired
    private ProposalNoPrintApi proposalNoPrintApi;

    @PersistenceContext
    private EntityManager entityManager;
    /**
     * fileService的服务器地址
     */
    @Value("${fileService.url}")
    private String fileServiceUrl;
    //    @Value("${fileService.url1}")
//    private String fileServiceUrl1;
    //签章地址
    @Value("${webservice.seal.url}")
    private String SERVICEADDRESS;
    @Value("${webservice.seal.sysId}")
    private String SYSID;
    @Value("${webservice.seal.userId}")
    private String USERID;
    @Value("${webservice.seal.userPsd}")
    private String USERPSD;
    //指定签章位置模版
    @Value("${webservice.seal.ruleNos.rule1}")
    private String RULENO1;
    @Value("${webservice.seal.ruleNos.rule2}")
    private String RULENO2;//盖章
    @Value("${webservice.seal.ruleNos.rule3}")
    private String RULENO3;//国元公司
    private FileUtil fileUtil = new FileUtil();
    @Autowired
    private VisaApi visaApi;
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpPheadDao prpPheadDao;
    @Autowired
    private PrpTmainDao prpTmainDao;

    /**
     * 使用反射，将Dto属性添加到map中
     *
     * @param className  Dto的class类
     * @param object     Dto对象
     * @param map        接受参数的map
     * @param ignoreList 是否忽略List属性
     * @param <T>        Dto的类型
     * @throws IllegalAccessException
     * @author: 陈道洋
     * @date: 2017/11/30 9:06
     */
    private <T> void setParameterToMap(Class<T> className, T object, Map<String, Object> map, boolean ignoreList) throws IllegalAccessException {
        Field[] fields = className.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (ignoreList && field.getType() == List.class) {
                continue;
            }
            if (field.getType() == List.class) {
                map.put("list", field.get(object));
            } else {
                map.put(field.getName(), field.get(object));
            }
        }
    }

    /**
     * 缴费通知书打印页面
     *
     * @param request  获取保单号
     * @param response
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    @Override
    public void PaymentNoticePrint(HttpServletRequest request, HttpServletResponse response, String[] policyNo) throws Exception {
        LOGGER.error("缴费通知书打印测试服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        File file = null;
        FileOutputStream fileOutputStream = null;
        SealServiceUtils sealServiceUtils = new SealServiceUtils(SERVICEADDRESS, SYSID, USERID, USERPSD);
        try {
            List<Map<String, Object>> listMap = new ArrayList<>();

            for (int j = 0; j < policyNo.length; j++) {


                ResponsePaymentNoticeDto responsePaymentNoticeDto = null;
                if (StringUtils.isNotEmpty(request.getParameter("endorseNo"))) {
                    PrpPhead prpPhead = prpPheadDao.queryByEndorseNo(policyNo[j]);
                    responsePaymentNoticeDto = paymentNoticeApi.queryPaymentNoticeByCondition(prpPhead.getPolicyNo());
                } else {
                    responsePaymentNoticeDto = paymentNoticeApi.queryPaymentNoticeByCondition(policyNo[j]);
                }
                List<PaymentContentDto> list = responsePaymentNoticeDto.getPaymentContentlist();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                double sumPlanFee = 0;
                int no = 1;
                for (PaymentContentDto paymentContentDto : list) {
                    paymentContentDto.setDataFlag("true");
                    paymentContentDto.setSumFlag("false");
                    sumPlanFee += Double.parseDouble(paymentContentDto.getPlanFee());
                    paymentContentDto.setNo(no++);
                }
                BigDecimal bigDecimal = new BigDecimal(sumPlanFee);
                double doubleValue = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                String montrayUnit = NumberToCN.number2CNMontrayUnit(bigDecimal);
                PaymentContentDto paymentContentDto = new PaymentContentDto();
                paymentContentDto.setSumPlanFee(doubleValue);
                paymentContentDto.setDataFlag("false");
                paymentContentDto.setSumFlag("true");
                list.add(paymentContentDto);
                PaymentContentDto paymentContentDto1 = new PaymentContentDto();
                paymentContentDto1.setSumPlanFeeCapital(montrayUnit);
                paymentContentDto1.setOneFlag("true");
                paymentContentDto1.setTwoFlag("false");
                paymentContentDto1.setThreeFlag("false");
                paymentContentDto1.setFourFlag("false");
                paymentContentDto1.setFiveFlag("false");
                paymentContentDto1.setSixFlag("false");
                list.add(paymentContentDto1);
                PaymentContentDto paymentContentDto2 = new PaymentContentDto();
                paymentContentDto2.setOneFlag("false");
                paymentContentDto2.setTwoFlag("true");
                paymentContentDto2.setThreeFlag("false");
                paymentContentDto2.setFourFlag("false");
                paymentContentDto2.setFiveFlag("false");
                paymentContentDto2.setSixFlag("false");
                list.add(paymentContentDto2);
                PaymentContentDto paymentContentDto3 = new PaymentContentDto();
                paymentContentDto3.setOneFlag("false");
                paymentContentDto3.setTwoFlag("fales");
                paymentContentDto3.setThreeFlag("true");
                paymentContentDto3.setFourFlag("false");
                paymentContentDto3.setFiveFlag("false");
                paymentContentDto3.setSixFlag("false");
                list.add(paymentContentDto3);
                PaymentContentDto paymentContentDto4 = new PaymentContentDto();
                paymentContentDto4.setOneFlag("false");
                paymentContentDto4.setTwoFlag("fales");
                paymentContentDto4.setThreeFlag("fales");
                paymentContentDto4.setFourFlag("true");
                paymentContentDto4.setFiveFlag("false");
                paymentContentDto4.setSixFlag("false");
                list.add(paymentContentDto4);
                PaymentContentDto paymentContentDto5 = new PaymentContentDto();
                paymentContentDto5.setOneFlag("false");
                paymentContentDto5.setTwoFlag("fales");
                paymentContentDto5.setThreeFlag("fales");
                paymentContentDto5.setFourFlag("false");
                paymentContentDto5.setFiveFlag("true");
                paymentContentDto5.setSixFlag("false");
                list.add(paymentContentDto5);
                PaymentContentDto paymentContentDto6 = new PaymentContentDto();
                paymentContentDto6.setComCName(responsePaymentNoticeDto.getComCName());
                paymentContentDto6.setOneFlag("false");
                paymentContentDto6.setTwoFlag("fales");
                paymentContentDto6.setThreeFlag("fales");
                paymentContentDto6.setFourFlag("false");
                paymentContentDto6.setFiveFlag("false");
                paymentContentDto6.setSixFlag("true");
                list.add(paymentContentDto6);
                Map<String, Object> paramMap = new HashMap<>();
                inputStream = classLoader.getResourceAsStream("template/PaymentNotice.jrxml");
                this.<ResponsePaymentNoticeDto>setParameterToMap(ResponsePaymentNoticeDto.class, responsePaymentNoticeDto, paramMap, false);
                paramMap.put("templetPath", inputStream);//jasper地址
                paramMap.put("date", simpleDateFormat.format(new Date()));
                InputStream inputStream1 = QrCodeCreateUtil.eancodeEncode(policyNo[j], 600, 100);
                paramMap.put("barcode", inputStream1);
                listMap.add(paramMap);
            }
            PrintUtil.printReportPdfMore(listMap, 1, response.getOutputStream());
//            file = File.createTempFile("PaymentNotice", ".pdf");
//            fileOutputStream = new FileOutputStream(file);
//            PrintUtil.printReportPdfMore(listMap, 1, fileOutputStream);
//            String shortLinkId = fileUtil.uploadFile(fileServiceUrl1, file, SinoRequestContext.getCurrentContext().getUserCode(), "tempfile", "agriprpall_printPdf");
//            SealDocRequestTreeNode treeNode = PrintServiceImpl.gettreeNode("PaymentNotice", shortLinkId,RULENO3);
//            InputStream inputStream1 = null;
//            ServletOutputStream outputStream = null;
//            try {
//                inputStream1 = sealServiceUtils.sendSealService(treeNode);
//                outputStream = response.getOutputStream();
//                byte[] bytes = new byte[1024];
//                int i = 0;
//                while ((i = inputStream1.read(bytes)) != -1) {
//                    outputStream.write(bytes, 0, i);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (inputStream1 != null) {
//                    inputStream1.close();
//                }
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//                if (fileOutputStream != null) {
//                    fileOutputStream.close();
//                }
//            }
        } catch (Exception e) {
            LOGGER.error("缴费通知书打印测试服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("缴费通知书打印测试服务报错");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (file != null) {
                file.delete();
            }
        }
        LOGGER.error("缴费通知书打印测试服务结束");

    }

    public static SealDocRequestTreeNode gettreeNode(String fileNo, String filePath, String ruleNo) {
        SealDocRequestTreeNode treeNode = new SealDocRequestTreeNode();
        treeNode.setFileNo(fileNo + ".pdf");
        treeNode.setUserCode(SinoRequestContext.getCurrentContext().getUser().getUserCode());
        treeNode.setUserName(SinoRequestContext.getCurrentContext().getUser().getUserName());
        treeNode.setId("A05300050");
        treeNode.setUpUser("34000040");
        treeNode.setAppCode("UW010");
        treeNode.setCodebar(false);
        treeNode.setCertCodebar("");
        treeNode.setCodebarType("0");
        treeNode.setCodebarData("000000000000000000");
        treeNode.setxCoordinate("3000");
        treeNode.setyCoordinate("5000");
        treeNode.setCodebarSize("100");
        treeNode.setCodebarPage("0");
        treeNode.setSealType("0");
        treeNode.setRuleType("0");
        treeNode.setRuleNo(ruleNo);
        treeNode.setCjType("file");
        treeNode.setRequestType("0");
        treeNode.setFilePath(filePath);
        treeNode.setModelName("rsyw");
        treeNode.setAreaSeal(false);
        treeNode.setFtpSavepath("");
        return treeNode;
    }

    /**
     * 使用反射，将List中的Dto属性添加到map中，并且key顺序递增
     *
     * @param className Dto的class类
     * @param list      list集合
     * @param map       接受参数的map
     * @param <T>       Dto的类型
     * @throws IllegalAccessException
     * @author: 陈道洋
     * @date: 2017/12/5 10:19
     */
    private <T> void setParameterListToMap(Class<T> className, List<T> list, Map<String, Object> map) throws IllegalAccessException {
        Field[] fields = className.getDeclaredFields();
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName() + (i + 1), field.get(t));
            }
        }
    }

    /**
     * 标的地址打印
     *
     * @param request  获取保单号
     * @param response
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    @Override
    public void PrpaddressPrint(HttpServletRequest request, HttpServletResponse response, String[] policyNo) throws Exception {
        LOGGER.error("标的地址打印测试服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        try {
            List<Map<String, Object>> listMap = new ArrayList<>();
            for (int j = 0; j < policyNo.length; j++) {
                List<Map<String, Object>> paramMap = getPolicy(request, classLoader, inputStream, policyNo[j]);
                listMap.add(paramMap.get(0));
            }
            PrintUtil.printReportPdfMore(listMap, 1, response.getOutputStream());
        } catch (Exception e) {
            LOGGER.error("标的地址打印测试服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("标的地址打印测试服务报错");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        LOGGER.error("标的地址打印测试服务结束");
    }

    /**
     * 标的地址打印子方法
     *
     * @param request 获取保单号
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    public List<Map<String, Object>> getPolicy(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream, String policyNo) throws Exception {
        inputStream = classLoader.getResourceAsStream("template/PrpAddress.jrxml");
        PrpAddressRespDto prpAddressRespDto = prpCaddressApi.queryPrpaddressPrintByCondition("POLICY", policyNo);
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("policyNo", prpAddressRespDto.getPolicyNo());
        List<PrpCaddressDto> prpCaddressDtoList = prpAddressRespDto.getPrpCaddressDtoList();
        int no = 1;
        for (PrpCaddressDto prpCaddressDto : prpCaddressDtoList) {
            prpCaddressDto.setDataFlag("true");
            prpCaddressDto.setNo(no++);
        }
        PrpCaddressDto prpCaddressDto3 = new PrpCaddressDto();
        prpCaddressDto3.setThreeFlag("true");
        prpCaddressDtoList.add(prpCaddressDto3);
        PrpCaddressDto prpCaddressDto2 = new PrpCaddressDto();
        prpCaddressDto2.setOneFlag("true");
        prpCaddressDto2.setTwoFlag("fales");
        prpCaddressDtoList.add(prpCaddressDto2);
        PrpCaddressDto prpCaddressDto1 = new PrpCaddressDto();
        prpCaddressDto1.setOneFlag("fales");
        prpCaddressDto1.setTwoFlag("true");
        String[] signDates = prpAddressRespDto.getSignDate().split("-");
        String signDate = signDates[0] + "年" + signDates[1] + "月" + signDates[2] + "日";
        prpCaddressDto1.setSignDate(signDate);
        prpCaddressDtoList.add(prpCaddressDto1);
        paramMap.put("list", prpCaddressDtoList);
        paramMap.put("templetPath", inputStream);//jasper地址
        listMap.add(paramMap);
        return listMap;
    }

    /**
     * 主险，附加险清单打印
     *
     * @param request  获取保单号
     * @param response
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/30 8:52
     */
    @Override
    public void MainSubPrint(HttpServletRequest request, HttpServletResponse response, String type, String[] policyNo) throws Exception {
        LOGGER.error("主险，附加险清单打印测试服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        File file = null;
        FileOutputStream fileOutputStream = null;
        SealServiceUtils sealServiceUtils = new SealServiceUtils(SERVICEADDRESS, SYSID, USERID, USERPSD);
        try {
            List<Map<String, Object>> listMap = new ArrayList<>();
            for (int j = 0; j < policyNo.length; j++) {
                List<Map<String, Object>> paramMap = getMainSubPrint(request, classLoader, inputStream, type, policyNo[j]);
                listMap.add(paramMap.get(0));
            }
            PrintUtil.printReportPdfMore(listMap, 1, response.getOutputStream());
//            file = File.createTempFile("MainSubPrint", ".pdf");
//            fileOutputStream = new FileOutputStream(file);
//            PrintUtil.printReportPdfMore(listMap, 1, fileOutputStream);
//            String shortLinkId = fileUtil.uploadFile(fileServiceUrl1, file, SinoRequestContext.getCurrentContext().getUserCode(), "tempfile", "agriprpall_printPdf");
//            SealDocRequestTreeNode treeNode = PrintServiceImpl.gettreeNode("MainSubPrint", shortLinkId,RULENO2);
//            InputStream inputStream1 = null;
//            ServletOutputStream outputStream = null;
//            try {
//                inputStream1 = sealServiceUtils.sendSealService(treeNode);
//                outputStream = response.getOutputStream();
//                byte[] bytes = new byte[1024];
//                int i = 0;
//                while ((i = inputStream1.read(bytes)) != -1) {
//                    outputStream.write(bytes, 0, i);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (inputStream1 != null) {
//                    inputStream1.close();
//                }
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//                if (fileOutputStream != null) {
//                    fileOutputStream.close();
//                }
//            }
        } catch (Exception e) {
            LOGGER.error("主险，附加险清单打印测试服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("主险，附加险清单打印测试服务报错");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (file != null) {
                file.delete();
            }
        }
        LOGGER.error("主险，附加险清单打印测试服务结束");
    }

    /**
     * 主险，附件险清单打印子方法
     *
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/30 8:52
     */
    public List<Map<String, Object>> getMainSubPrint(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream, String type, String policyNo) throws Exception {
        inputStream = classLoader.getResourceAsStream("template/MainSubPrint.jrxml");
        ResItemKindDto resItemKindDto = policyPrintService.queryItemKindListByPolicyNo(policyNo, type);
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("policyNo", resItemKindDto.getPolicyNo());
        String title = "";
        if ("main".equals(type)) {
            title = "种植业保险主险清单";
        } else {
            title = "种植业保险附加险清单";
        }
        paramMap.put("title", title);
        List<ResponseItemKindDto> responseItemKindDtos = resItemKindDto.getResponseItemKindDtoList();
        for (ResponseItemKindDto responseItemKindDto : responseItemKindDtos) {
            responseItemKindDto.setDataFlag("true");
        }
        ResponseItemKindDto responseItemKindDtoList3 = new ResponseItemKindDto();
        responseItemKindDtoList3.setThreeFlag("true");
        responseItemKindDtos.add(responseItemKindDtoList3);
        ResponseItemKindDto responseItemKindDtoList = new ResponseItemKindDto();
        responseItemKindDtoList.setOneFlag("true");
        responseItemKindDtoList.setTwoFlag("fales");
        responseItemKindDtos.add(responseItemKindDtoList);

        ResponseItemKindDto responseItemKindDtoList1 = new ResponseItemKindDto();
        responseItemKindDtoList1.setOneFlag("fales");
        responseItemKindDtoList1.setTwoFlag("true");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String operateDate = simpleDateFormat.format(resItemKindDto.getOperateDate());
        responseItemKindDtoList1.setOperateDate(operateDate);
        responseItemKindDtos.add(responseItemKindDtoList1);
        InputStream inputStream1 = QrCodeCreateUtil.eancodeEncode(policyNo, 600, 100);
        paramMap.put("barcode", inputStream1);
        paramMap.put("list", responseItemKindDtos);
        paramMap.put("templetPath", inputStream);//jasper地址
        listMap.add(paramMap);
        return listMap;
    }

    /**
     * 承保卷宗打印打印
     *
     * @param request  获取保单号
     * @param response
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    @Override
    public void FilePrint(HttpServletRequest request, HttpServletResponse response, String[] policyNo) throws Exception {
        LOGGER.error("承保卷宗打印测试服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        File file = null;
        FileOutputStream fileOutputStream = null;
        SealServiceUtils sealServiceUtils = new SealServiceUtils(SERVICEADDRESS, SYSID, USERID, USERPSD);
        try {
            List<Map<String, Object>> listMap = new ArrayList<>();
            for (int j = 0; j < policyNo.length; j++) {
                List<Map<String, Object>> paramMap = getFilePrint(request, classLoader, inputStream, policyNo[j]);
                listMap.add(paramMap.get(0));
            }
            PrintUtil.printReportPdfMore(listMap, 1, response.getOutputStream());
//            file = File.createTempFile("FilePrint", ".pdf");
//            fileOutputStream = new FileOutputStream(file);
//            PrintUtil.printReportPdfMore(listMap, 1, fileOutputStream);
//            String shortLinkId = fileUtil.uploadFile(fileServiceUrl1, file, SinoRequestContext.getCurrentContext().getUserCode(), "tempfile", "agriprpall_printPdf");
//            SealDocRequestTreeNode treeNode = PrintServiceImpl.gettreeNode("FilePrint", shortLinkId,RULENO1);
//            InputStream inputStream1 = null;
//            ServletOutputStream outputStream = null;
//            try {
//                inputStream1 = sealServiceUtils.sendSealService(treeNode);
//                outputStream = response.getOutputStream();
//                byte[] bytes = new byte[1024];
//                int i = 0;
//                while ((i = inputStream1.read(bytes)) != -1) {
//                    outputStream.write(bytes, 0, i);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (inputStream1 != null) {
//                    inputStream1.close();
//                }
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//                if (fileOutputStream != null) {
//                    fileOutputStream.close();
//                }
//            }
        } catch (Exception e) {
            LOGGER.error("承保卷宗打印测试服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("承保卷宗打印测试服务报错");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (file != null) {
                file.delete();
            }
        }
        LOGGER.error("承保卷宗打印测试服务结束");
    }

    /**
     * 承保卷宗打印打印子方法
     *
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    public List<Map<String, Object>> getFilePrint(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream, String policyNo) throws Exception {
        inputStream = classLoader.getResourceAsStream("template/FilePrint.jrxml");
        ResponseFileCoverPrintDto responseFileCoverPrintDto = policyQueryApi.fileCoverPrint(policyNo);
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        InputStream url = classLoader.getResourceAsStream("template/image/agriPrintLogo.gif");
//        String s =File.separator+"agriprpall"+File.separator+"agriprpall-rest"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"template"+File.separator+"image"+File.separator+"agriPrintLogo.gif";
        paramMap.put("gylogo", url);
        paramMap.put("policyNo", responseFileCoverPrintDto.getPolicyNo());
        paramMap.put("insuredName", responseFileCoverPrintDto.getInsuredName());
        paramMap.put("riskName", responseFileCoverPrintDto.getRiskName());
        paramMap.put("comName", responseFileCoverPrintDto.getComName());
        paramMap.put("statQuantity", responseFileCoverPrintDto.getStatQuantity());
        paramMap.put("sumPremium", responseFileCoverPrintDto.getSumPremium());
        paramMap.put("sumAmount", responseFileCoverPrintDto.getSumAmount());
        paramMap.put("codeCName", responseFileCoverPrintDto.getCodeCName());
        paramMap.put("templetPath", inputStream);
        listMap.add(paramMap);
        return listMap;
    }

    /**
     * 缴费计划打印
     *
     * @param request  获取保单号
     * @param response
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    @Override
    public void PaymentPlanPrint(HttpServletRequest request, HttpServletResponse response, String[] policyNo) throws Exception {
        LOGGER.error("缴费计划打印测试服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        File file = null;
        FileOutputStream fileOutputStream = null;
        SealServiceUtils sealServiceUtils = new SealServiceUtils(SERVICEADDRESS, SYSID, USERID, USERPSD);
        try {
            List<Map<String, Object>> listMap = new ArrayList<>();
            for (int j = 0; j < policyNo.length; j++) {
                List<Map<String, Object>> paramMap = getPaymentPlanPrint(request, classLoader, inputStream, policyNo[j]);
                listMap.add(paramMap.get(0));
            }
            PrintUtil.printReportPdfMore(listMap, 1, response.getOutputStream());
            //电子签章
//            file = File.createTempFile("PaymentPlanPrint", ".pdf");
//            fileOutputStream = new FileOutputStream(file);
//            PrintUtil.printReportPdfMore(listMap, 1, fileOutputStream);
//            String shortLinkId = fileUtil.uploadFile(fileServiceUrl1, file, SinoRequestContext.getCurrentContext().getUserCode(), "tempfile", "agriprpall_printPdf");
//            SealDocRequestTreeNode treeNode = PrintServiceImpl.gettreeNode("PaymentPlanPrint", shortLinkId,RULENO2);
//            InputStream inputStream1 = null;
//            ServletOutputStream outputStream = null;
//            try {
//                inputStream1 = sealServiceUtils.sendSealService(treeNode);
//                outputStream = response.getOutputStream();
//                byte[] bytes = new byte[1024];
//                int i = 0;
//                while ((i = inputStream1.read(bytes)) != -1) {
//                    outputStream.write(bytes, 0, i);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (inputStream1 != null) {
//                    inputStream1.close();
//                }
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//                if (fileOutputStream != null) {
//                    fileOutputStream.close();
//                }
//            }
        } catch (Exception e) {
            LOGGER.error("缴费计划打印测试服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("缴费计划打印测试服务报错");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (file != null) {
                file.delete();
            }
        }
        LOGGER.error("缴费计划打印测试服务结束");
    }

    /**
     * 缴费计划打印子方法
     *
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    public List<Map<String, Object>> getPaymentPlanPrint(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream, String policyNo1) throws Exception {
        inputStream = classLoader.getResourceAsStream("template/PaymentPlanPrint.jrxml");

        List<ResponsePaymentPlanPrintDto> responsePaymentPlanPrintDtoList = policyQueryApi.paymentPlanPrint(policyNo1);

        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        String policyNo = "";
        String operateDate = null;
        for (ResponsePaymentPlanPrintDto responsePaymentPlanPrintDto : responsePaymentPlanPrintDtoList) {
            policyNo = responsePaymentPlanPrintDto.getPolicyNo();
            operateDate = responsePaymentPlanPrintDto.getStrOperateDate();
            responsePaymentPlanPrintDto.setDataFlag("true");
        }
        ResponsePaymentPlanPrintDto responsePaymentPlanPrintDto3 = new ResponsePaymentPlanPrintDto();
        responsePaymentPlanPrintDto3.setThreeFlag("true");
        responsePaymentPlanPrintDtoList.add(responsePaymentPlanPrintDto3);
        ResponsePaymentPlanPrintDto responsePaymentPlanPrintDto1 = new ResponsePaymentPlanPrintDto();
        responsePaymentPlanPrintDto1.setOneFlag("true");
        responsePaymentPlanPrintDto1.setTwoFlag("fales");
        responsePaymentPlanPrintDtoList.add(responsePaymentPlanPrintDto1);

        ResponsePaymentPlanPrintDto responsePaymentPlanPrintDto2 = new ResponsePaymentPlanPrintDto();
        responsePaymentPlanPrintDto2.setOneFlag("fales");
        responsePaymentPlanPrintDto2.setTwoFlag("true");
        responsePaymentPlanPrintDto2.setStrOperateDate(operateDate);
        responsePaymentPlanPrintDtoList.add(responsePaymentPlanPrintDto2);
        InputStream inputStream1 = QrCodeCreateUtil.eancodeEncode(policyNo, 600, 100);
        paramMap.put("barcode", inputStream1);
        paramMap.put("policyNo", policyNo);
        paramMap.put("templetPath", inputStream);
        paramMap.put("list", responsePaymentPlanPrintDtoList);
        listMap.add(paramMap);
        return listMap;
    }

    /**
     * 批单正本打印
     *
     * @param request  获取批单号
     * @param response
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    @Override
    public void OriginalPrint(HttpServletRequest request, HttpServletResponse response, String[] endorseNos, String comCode, String visaCode, String visaSerialNo, String userCode) throws Exception {
        LOGGER.error("批单打印测试服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        try {
            List<Map<String, Object>> listMap = new ArrayList<>();
            for (int j = 0; j < endorseNos.length; j++) {
                List<Map<String, Object>> paramMap = getOriginalPrint(request, classLoader, inputStream, endorseNos[j]);
                listMap.add(paramMap.get(0));
            }
            PrintUtil.printReportPdfMore(listMap, 1, response.getOutputStream());
            //回写数据
            if (StringUtils.isNotEmpty(visaSerialNo) && StringUtils.isNotEmpty(userCode)) {
                RequestQueryVisaCodesAndVisaSerialNosDto requestQDto = new RequestQueryVisaCodesAndVisaSerialNosDto();
                requestQDto.setUserCode(userCode);
                requestQDto.setComCode(comCode);
                requestQDto.setBusinessNo(endorseNos[0] + "," + endorseNos.length + "");
                List<ResponseQueryVisaCodesAndVisaSerialNosDto> responseQDtos = visaApi.queryVisaCodesAndVisaSerialNos(requestQDto);
                int i = 0;
                List<RequestVisaStatusWriteBackDto> requestVisaStatusWriteBackDtos = new ArrayList<>();
                for (ResponseQueryVisaCodesAndVisaSerialNosDto dto : responseQDtos) {
                    RequestVisaStatusWriteBackDto requestVisaStatusWriteBackDto = new RequestVisaStatusWriteBackDto();
                    requestVisaStatusWriteBackDto.setComCode(comCode);
                    requestVisaStatusWriteBackDto.setVisaCode(dto.getVisaCode());
                    requestVisaStatusWriteBackDto.setVisaSerialNo(dto.getVisaSerisal());
                    requestVisaStatusWriteBackDto.setUserCode(userCode);
                    requestVisaStatusWriteBackDto.setBusinessNo(endorseNos[i]);
                    i++;
                    requestVisaStatusWriteBackDtos.add(requestVisaStatusWriteBackDto);
                }
                visaApi.visaStatusWriteBack(requestVisaStatusWriteBackDtos);
            }

        } catch (Exception e) {
            LOGGER.error("批单打印测试服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("批单打印测试服务报错");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        LOGGER.error("批单打印测试服务结束");
    }

    /**
     * 批单正本打印子方法
     *
     * @param request 获取批单号
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    public List<Map<String, Object>> getOriginalPrint(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream, String endorseNo) throws Exception {
        inputStream = classLoader.getResourceAsStream("template/EndorsePrint1.jrxml");
        PrpPheadDto prpPheadDto = prpPheadApi.endorsementPrint(endorseNo);
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("riskName", prpDriskApi.translateCodeByPK(prpPheadDto.getRiskCode()));
        paramMap.put("endorseNo", prpPheadDto.getEndorseNo());
        paramMap.put("insuredName", prpPheadDto.getInsuredName());
        paramMap.put("policyNo", prpPheadDto.getPolicyNo());
        paramMap.put("underwriteName", prpPheadDto.getUnderwriteName());
        paramMap.put("operatorName", prpPheadDto.getOperatorName());
        InputStream inputStream1 = QrCodeCreateUtil.eancodeEncode(endorseNo, 600, 100);
        paramMap.put("barcode", inputStream1);
        Date date = prpPheadDto.getEndorDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        paramMap.put("endorDate", simpleDateFormat.format(prpPheadDto.getEndorDate()));
        List<EndorsePrintDto> endorsePrintDtoList = new ArrayList<>();
        String endorseTexts = prpPheadDto.getEndorseTexts();
        String text[] = null;
        if (StringUtils.isNotEmpty(endorseTexts)) {
            if (endorseTexts.indexOf("\n") > -1) {
                text = prpPheadDto.getEndorseTexts().split("\n");
            } else if (endorseTexts.indexOf("\r\n") > -1) {
                text = prpPheadDto.getEndorseTexts().split("\r\n");
            }
        }
        if (text != null && text.length > 11) {
            paramMap.put("endorseTexts", "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t批文太长，详见批单抄件");
        } else {
            paramMap.put("endorseTexts", endorseTexts);
        }
        EndorsePrintDto emdorsePrintDto3 = new EndorsePrintDto();
        if (StringUtils.isNotEmpty(prpPheadDto.getOperatorCode())) {
            emdorsePrintDto3.setOperatorName(prpDuserApi.translateCodeByPK(prpPheadDto.getOperatorCode()));
        }
        emdorsePrintDto3.setUnderwriteName(prpPheadDto.getUnderwriteName());
        emdorsePrintDto3.setHandlerName(prpDuserApi.translateCodeByPK(prpPheadDto.getHandlerCode()));
        endorsePrintDtoList.add(emdorsePrintDto3);
        paramMap.put("templetPath", inputStream);
        paramMap.put("list", endorsePrintDtoList);
        listMap.add(paramMap);
        return listMap;
    }

    /**
     * 批单抄件打印
     *
     * @param request  获取批单号
     * @param response
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    @Override
    public void EndorsePrint(HttpServletRequest request, HttpServletResponse response, String[] endorseNos) throws Exception {
        LOGGER.error("批单抄件打印测试服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        try {
            List<Map<String, Object>> listMap = new ArrayList<>();
            for (int j = 0; j < endorseNos.length; j++) {
                List<Map<String, Object>> paramMap = getEndorsePrint(request, classLoader, inputStream, endorseNos[j]);
                listMap.add(paramMap.get(0));
            }

            PrintUtil.printReportPdfMore(listMap, 1, response.getOutputStream());
        } catch (Exception e) {
            LOGGER.error("批单抄件打印测试服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("批单抄件打印测试服务报错");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        LOGGER.error("批单抄件打印测试服务结束");
    }

    /**
     * 批单抄件打印子方法
     *
     * @param request 获取批单号
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    public List<Map<String, Object>> getEndorsePrint(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream, String endorseNo) throws Exception {
        inputStream = classLoader.getResourceAsStream("template/EndorsePrint.jrxml");
        PrpPheadDto prpPheadDto = prpPheadApi.endorsementPrint(endorseNo);
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("riskName", prpDriskApi.translateCodeByPK(prpPheadDto.getRiskCode()));
        paramMap.put("endorseNo", prpPheadDto.getEndorseNo());
        paramMap.put("insuredName", prpPheadDto.getInsuredName());
        paramMap.put("policyNo", prpPheadDto.getPolicyNo());
        InputStream inputStream1 = QrCodeCreateUtil.eancodeEncode(endorseNo, 600, 100);
        paramMap.put("barcode", inputStream1);
        List<EndorsePrintDto> endorsePrintDtoList = new ArrayList<>();
        String endorseTexts = prpPheadDto.getEndorseTexts();
        String text[] = null;
        if (StringUtils.isNotEmpty(endorseTexts)) {
            if (endorseTexts.indexOf("\n") > -1) {
                text = prpPheadDto.getEndorseTexts().split("\n");
            } else if (endorseTexts.indexOf("\r\n") > -1) {
                text = prpPheadDto.getEndorseTexts().split("\r\n");
            }
        }
        if (text != null) {
            for (int i = 0; i < text.length; i++) {
                EndorsePrintDto emdorsePrintDto = new EndorsePrintDto();
                emdorsePrintDto.setDataFlag("true");
                emdorsePrintDto.setEndorseTexts(text[i]);
                endorsePrintDtoList.add(emdorsePrintDto);
            }
        }
        EndorsePrintDto emdorsePrintDto1 = new EndorsePrintDto();
        emdorsePrintDto1.setOneFlag("true");
        emdorsePrintDto1.setTwoFlag("fales");
        emdorsePrintDto1.setThreeFlag("fales");
        endorsePrintDtoList.add(emdorsePrintDto1);

        EndorsePrintDto emdorsePrintDto2 = new EndorsePrintDto();
        Date date = prpPheadDto.getEndorDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        emdorsePrintDto2.setOneFlag("fales");
        emdorsePrintDto2.setTwoFlag("true");
        emdorsePrintDto2.setThreeFlag("fales");
        emdorsePrintDto2.setEndorDate(simpleDateFormat.format(prpPheadDto.getEndorDate()));
        endorsePrintDtoList.add(emdorsePrintDto2);

        EndorsePrintDto emdorsePrintDto3 = new EndorsePrintDto();
        emdorsePrintDto3.setOneFlag("fales");
        emdorsePrintDto3.setTwoFlag("fales");
        emdorsePrintDto3.setThreeFlag("true");
        emdorsePrintDto3.setUnderwriteName(prpPheadDto.getUnderwriteName());
        emdorsePrintDto3.setOperatorName(prpDuserApi.translateCodeByPK(prpPheadDto.getOperatorCode()));
        emdorsePrintDto3.setHandlerName(prpDuserApi.translateCodeByPK(prpPheadDto.getHandlerCode()));
        endorsePrintDtoList.add(emdorsePrintDto3);
        paramMap.put("templetPath", inputStream);
        paramMap.put("list", endorsePrintDtoList);
        listMap.add(paramMap);
        return listMap;
    }

    /**
     * 特别约定打印
     *
     * @param request  获取保单号
     * @param response
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    @Override
    public void SpecialyAgreedPrint(HttpServletRequest request, HttpServletResponse response, String[] policyNo) throws Exception {
        LOGGER.error("特别约定打印测试服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            List<Map<String, Object>> listMap = new ArrayList<>();
            for (int j = 0; j < policyNo.length; j++) {
                List<Map<String, Object>> paramMap = getSpecialyAgreedPrint(request, classLoader, inputStream, policyNo[j]);
                listMap.add(paramMap.get(0));
            }
            PrintUtil.printReportPdfMore(listMap, 1, response.getOutputStream());
        } catch (Exception e) {
            LOGGER.error("特别约定打印测试服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("特别约定打印测试服务报错");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        LOGGER.error("特别约定打印测试服务结束");
    }

    /**
     * 特别约定打印子方法
     *
     * @param request 获取保单号
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     */
    public List<Map<String, Object>> getSpecialyAgreedPrint(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream, String policyNo) throws Exception {
        inputStream = classLoader.getResourceAsStream("template/SpecialyAgreedPrint.jrxml");
        ResponseSpecificallyAgreedPrintDto responseSpecificallyAgreedPrintDto = policyQueryApi.specificallyAgreedPrint(policyNo);
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<ResponseSpecificallyAgreedPrintDto> responseSpecificallyAgreedPrintDtoList = new ArrayList<>();
        paramMap.put("policyNo", responseSpecificallyAgreedPrintDto.getPolicyNo());
        InputStream inputStream1 = QrCodeCreateUtil.eancodeEncode(policyNo, 600, 100);
        paramMap.put("barcode", inputStream1);
        String clauses = responseSpecificallyAgreedPrintDto.getClauses();
        String text[] = null;
        if (StringUtils.isNotEmpty(clauses)) {
            text = responseSpecificallyAgreedPrintDto.getClauses().split("\n");
        }
        if (text != null) {
            for (int i = 0; i < text.length; i++) {
                ResponseSpecificallyAgreedPrintDto specificallyAgreedPrintDto = new ResponseSpecificallyAgreedPrintDto();

                specificallyAgreedPrintDto.setDataFlag("true");
                specificallyAgreedPrintDto.setClauses(text[i]);
                responseSpecificallyAgreedPrintDtoList.add(specificallyAgreedPrintDto);
            }
        }
        ResponseSpecificallyAgreedPrintDto specificallyAgreedPrintDto1 = new ResponseSpecificallyAgreedPrintDto();
        specificallyAgreedPrintDto1.setOneFlag("true");
        specificallyAgreedPrintDto1.setTwoFlag("fales");
        responseSpecificallyAgreedPrintDtoList.add(specificallyAgreedPrintDto1);

        ResponseSpecificallyAgreedPrintDto specificallyAgreedPrintDto2 = new ResponseSpecificallyAgreedPrintDto();
        specificallyAgreedPrintDto2.setOneFlag("fales");
        specificallyAgreedPrintDto2.setTwoFlag("true");
        specificallyAgreedPrintDto2.setStrOperateDate(responseSpecificallyAgreedPrintDto.getStrOperateDate());
        responseSpecificallyAgreedPrintDtoList.add(specificallyAgreedPrintDto2);
        paramMap.put("templetPath", inputStream);
        paramMap.put("list", responseSpecificallyAgreedPrintDtoList);
        listMap.add(paramMap);
        return listMap;
    }

    /**
     * 投保单单页打印
     *
     * @param request
     * @param classLoader
     * @param inputStream
     * @param proposalNo
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2018/1/16 18:19
     */
    public List<Map<String, Object>> getPrintProposalNo(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream, String proposalNo, String riskCode) throws Exception {
        if ("3107".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3107.jrxml");
        } else if ("3101".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3101.jrxml");
        } else if ("3114".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3114.jrxml");
        } else if ("3122".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3122.jrxml");
        } else if ("3126".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3126.jrxml");
        } else if ("3161".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3161.jrxml");
        } else if ("3102".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3102.jrxml");
        } else if ("3162".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3162.jrxml");
        } else if ("3147".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3147.jrxml");
        } else if ("3141".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3141.jrxml");
        } else if ("3155".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3155.jrxml");
        } else if ("3108".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3108.jrxml");
        } else if ("3134".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3134.jrxml");
        } else if ("3220".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3220.jrxml");
        } else if ("3233".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3233.jrxml");
        } else if ("3224".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3224.jrxml");
        } else if ("3237".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3237.jrxml");
        } else if ("3129".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3129.jrxml");
        } else if ("3130".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3130.jrxml");
        } else if ("3149".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/ProposalPrint3149.jrxml");
        }
        Map<String, Object> paramMap = new HashMap<>();
        List<Map<String, Object>> listMap = new ArrayList<>();
        ResponseInsuranceFormPrintDto responseInsuranceFormPrintDto = proposalNoPrintApi.queryInsuranceFormPrintByCondition(proposalNo);
        InsuraneItemsDto insuraneItemDto = responseInsuranceFormPrintDto.getInsuraneItemDto();
        InsuredInfoDto insuredInfoDto = responseInsuranceFormPrintDto.getInsuredInfoDto();
        PremiumConDto premiumConDto = responseInsuranceFormPrintDto.getPremiumConDto();
        com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriccDto itemKingAgriccDto = responseInsuranceFormPrintDto.getItemKingAgriccDto();
        this.<com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriccDto>setParameterToMap(com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriccDto.class, itemKingAgriccDto, paramMap, false);
        this.<ResponseInsuranceFormPrintDto>setParameterToMap(ResponseInsuranceFormPrintDto.class, responseInsuranceFormPrintDto, paramMap, true);
        this.<InsuraneItemsDto>setParameterToMap(InsuraneItemsDto.class, insuraneItemDto, paramMap, false);
        String sumAmount = insuraneItemDto.getSumAmount();
        if (insuraneItemDto.getClauses() != null) {
            String[] clauses = insuraneItemDto.getClauses().split("\n");
            String text = "";
            if (clauses.length > 3) {
                paramMap.put("clauses", "详见特别约定清单");
            } else {
                for (int i = 0; i < clauses.length; i++) {
                    text += clauses[i];
                }
                paramMap.put("clauses", text);
            }
        }
        String sumPremium = insuraneItemDto.getSumPremium();
        BigDecimal bigDecimal = new BigDecimal(sumAmount.replace(",", ""));
        BigDecimal bigDecima2 = new BigDecimal(sumPremium.replace(",", ""));
        String upSumAmount = NumberToCN.number2CNMontrayUnit(bigDecimal);
        String upSumPremium = NumberToCN.number2CNMontrayUnit(bigDecima2);
        InputStream url = classLoader.getResourceAsStream("template/image/guoyuanPrintLOGO.jpg");
        String No = proposalNo;
        InputStream inputStream1 = QrCodeCreateUtil.eancodeEncode(No, 600, 100);
        paramMap.put("barcode", inputStream1);
        paramMap.put("gylogo", url);
        List<ItemKingAgriDto> itemKingAgriDtoList = responseInsuranceFormPrintDto.getItemKindAgriList();
        BigDecimal bigDecima3 = null;
        BigDecimal bigDecima4 = null;
        if (itemKingAgriDtoList.size() > 0) {
            if(!"详见主险清单".equals(itemKingAgriDtoList.get(0).getItemDetailName())){
                bigDecima3 = new BigDecimal(itemKingAgriDtoList.get(0).getAmount().replace(",", ""));
                bigDecima4 = new BigDecimal(itemKingAgriDtoList.get(0).getAdjuStrate().replace(",", ""));
            }
        }
//        if ("3130".equals(riskCode)) {
//            paramMap.put("upAmount1", NumberToCN.number2CNMontrayUnit(bigDecima3));
//            paramMap.put("upAdjuStrate1", NumberToCN.number2CNMontrayUnit(bigDecima4));
//        } else {
            paramMap.put("upSumAmount", upSumAmount);
            paramMap.put("upSumPremium", upSumPremium);
//        }
        this.<InsuredInfoDto>setParameterToMap(InsuredInfoDto.class, insuredInfoDto, paramMap, false);
        this.<PremiumConDto>setParameterToMap(PremiumConDto.class, premiumConDto, paramMap, false);
        List<ItemKingAgriDto> itemKindAgriList = responseInsuranceFormPrintDto.getItemKindAgriList();
        List<ItemKingAgriSubDto> itemKindAgriSubList = responseInsuranceFormPrintDto.getItemKindAgriSubList();
        List<ItemKingAgriccDto> itemKingAgriccDtoList = responseInsuranceFormPrintDto.getItemKingAgriccDtoList();
        this.setParameterListToMap(ItemKingAgriccDto.class, itemKingAgriccDtoList, paramMap);
        this.setParameterListToMap(ItemKingAgriDto.class, itemKindAgriList, paramMap);
        this.setParameterListToMap(ItemKingAgriSubDto.class, itemKindAgriSubList, paramMap);
        paramMap.put("templetPath", inputStream);//jasper地址
        listMap.add(paramMap);
        return listMap;
    }

    /**
     * 投保单打印
     *
     * @param request  获取投保单号
     * @param response
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/12/5 16:34
     */
    @Override
    public void InsuranceFormPrint(HttpServletRequest request, HttpServletResponse response, String[] proposalNo) throws Exception {
        LOGGER.error("投保单打印测试服务开始");
        String riskCode = proposalNo[0].substring(1, 5);
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        File file = null;
        FileOutputStream fileOutputStream = null;
        SealServiceUtils sealServiceUtils = new SealServiceUtils(SERVICEADDRESS, SYSID, USERID, USERPSD);
        try {
            //工作台待处理保单里投保单打印时传的是保单号，这里转成投保单号
            if (proposalNo.length == 1) {
                if (proposalNo[0].substring(0, 1).equals("2")) {
                    PrpCmain prpCmain = prpCmainDao.findByPolicyNo(proposalNo[0]);
                    proposalNo[0] = prpCmain.getProposalNo();
                }
            }
            List<Map<String, Object>> listMap = new ArrayList<>();
            for (int j = 0; j < proposalNo.length; j++) {
                List<Map<String, Object>> paramMap = getPrintProposalNo(request, classLoader, inputStream, proposalNo[j], riskCode);
                listMap.add(paramMap.get(0));
            }
            PrintUtil.printReportPdfMore(listMap, 1, response.getOutputStream());
//            file = File.createTempFile("InsuranceFormPrint", ".pdf");
//            fileOutputStream = new FileOutputStream(file);
//            PrintUtil.printReportPdfMore(listMap, 1, fileOutputStream);
//            String shortLinkId = fileUtil.uploadFile(fileServiceUrl1, file, SinoRequestContext.getCurrentContext().getUserCode(), "tempfile", "agriprpall_printPdf");
//            SealDocRequestTreeNode treeNode = PrintServiceImpl.gettreeNode("InsnranceFormprint", shortLinkId,RULENO2);
//
//            InputStream inputStream1 = null;
//            ServletOutputStream outputStream = null;
//            try {
//                inputStream1 = sealServiceUtils.sendSealService(treeNode);
//                outputStream = response.getOutputStream();
//                byte[] bytes = new byte[1024];
//                int i = 0;
//                while ((i = inputStream1.read(bytes)) != -1) {
//                    outputStream.write(bytes, 0, i);
//                }
            //回写打印状态
            for (int j = 0; j < proposalNo.length; j++) {
                prpTmainDao.updatePrintNo(proposalNo[j], proposalNo[j]);
            }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (inputStream1 != null) {
//                    inputStream1.close();
//                }
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//            }
        } catch (Exception e) {
            LOGGER.error("投保单打印测试服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("投保单打印测试服务报错");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (file != null) {
                file.delete();
            }
        }
        LOGGER.error("投保单打印测试服务结束");
    }

    /**
     * 保单单页打印
     *
     * @param request
     * @param classLoader
     * @param inputStream
     * @param policyNo
     * @return
     * @throws Exception
     * @author: 陈道洋
     * @date: 2018/1/16 18:19
     */
    public List<Map<String, Object>> getPrintPolicyNo(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream, String policyNo, String riskCode) throws Exception {
        List<Map<String, Object>> listMap = new ArrayList<>();
        ResponsePolicyPrintDto responsePolicyPrintDto = policyQueryApi.queryPolicyPrintByCondition(policyNo);
        com.sinosoft.agriprpall.api.policymanage.dto.InsuraneItemsDto insuraneItemsDto = responsePolicyPrintDto.getInsuraneitems();
        com.sinosoft.agriprpall.api.policymanage.dto.InsuredInfoDto insuredInfoDto = responsePolicyPrintDto.getInsuredInfo();
        com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriccDto itemKingAgriccDto = responsePolicyPrintDto.getItemKingAgriccDto();
        PremiumConDto premiumConDto = responsePolicyPrintDto.getPremiumConDto();
        Map<String, Object> paramMap = new HashMap<>();
        this.<ResponsePolicyPrintDto>setParameterToMap(ResponsePolicyPrintDto.class, responsePolicyPrintDto, paramMap, true);
        this.<com.sinosoft.agriprpall.api.policymanage.dto.InsuraneItemsDto>setParameterToMap(com.sinosoft.agriprpall.api.policymanage.dto.InsuraneItemsDto.class, insuraneItemsDto, paramMap, false);
        String sumAmount = insuraneItemsDto.getSumAmount();
        if (StringUtils.isNotEmpty(insuraneItemsDto.getClauses())) {
            String[] clauses = insuraneItemsDto.getClauses().split("\n");
            String text = "";
            if (clauses.length > 3) {
                paramMap.put("clauses", "详见特别约定清单");
            } else {
                for (int i = 0; i < clauses.length; i++) {
                    text += clauses[i];
                }
                paramMap.put("clauses", text);
            }
        }
        String sumPremium = insuraneItemsDto.getSumPremium();
        BigDecimal bigDecimal = new BigDecimal(sumAmount.replace(",", ""));
        BigDecimal bigDecima2 = new BigDecimal(sumPremium.replace(",", ""));
        String upSumAmount = NumberToCN.number2CNMontrayUnit(bigDecimal);
        String upSumPremium = NumberToCN.number2CNMontrayUnit(bigDecima2);
        String No = policyNo;
        InputStream is = QrCodeCreateUtil.createQrCode(No, 300);
        InputStream inputStream1 = QrCodeCreateUtil.eancodeEncode(No, 600, 100);
        //打印logo
        BufferedImage image = ImageIO.read(classLoader.getResourceAsStream("template/image/guoyuanPrintLOGO.jpg"));
        //BufferedImage 转 InputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
        ImageIO.write(image, "jpg", imageOutput);
        InputStream inputStreamImage = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        paramMap.put("gylogo", inputStreamImage);
        paramMap.put("barcode", inputStream1);
        paramMap.put("qrcode", is);
        List<com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriDto> itemKindAgriList1 = responsePolicyPrintDto.getItemKindAgriList();
        BigDecimal bigDecima3 = null;
        BigDecimal bigDecima4 = null;
        if (itemKindAgriList1.size() > 0) {
            if(!"详见主险清单".equals(itemKindAgriList1.get(0).getItemDetailName())){
                bigDecima3 = new BigDecimal(itemKindAgriList1.get(0).getAmount().replace(",", ""));
                bigDecima4 = new BigDecimal(itemKindAgriList1.get(0).getAdjuStrate().replace(",", ""));
            }
        }
//        if ("3130".equals(riskCode)) {
//            paramMap.put("upAmount1", NumberToCN.number2CNMontrayUnit(bigDecima3));
//            paramMap.put("upAdjuStrate1", NumberToCN.number2CNMontrayUnit(bigDecima4));
//        } else {
            paramMap.put("upSumAmount", upSumAmount);
            paramMap.put("upSumPremium", upSumPremium);
//        }
        this.<com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriccDto>setParameterToMap(com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriccDto.class, itemKingAgriccDto, paramMap, false);
        this.<com.sinosoft.agriprpall.api.policymanage.dto.InsuredInfoDto>setParameterToMap(com.sinosoft.agriprpall.api.policymanage.dto.InsuredInfoDto.class, insuredInfoDto, paramMap, false);
        this.<PremiumConDto>setParameterToMap(PremiumConDto.class, premiumConDto, paramMap, false);
        List<com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriDto> itemKindAgriList = responsePolicyPrintDto.getItemKindAgriList();
        List<ItemKingAgriSubDto> itemKindAgriSubList = responsePolicyPrintDto.getItemKindAgriSubList();
        List<ItemKingAgriccDto> itemKingAgriccDtoList = responsePolicyPrintDto.getItemKingAgriccDtoList();
        this.setParameterListToMap(com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriDto.class, itemKindAgriList, paramMap);
        this.setParameterListToMap(ItemKingAgriSubDto.class, itemKindAgriSubList, paramMap);
        this.setParameterListToMap(ItemKingAgriccDto.class, itemKingAgriccDtoList, paramMap);
        if ("3107".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint1.jrxml");
        } else if ("3101".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3101.jrxml");
        } else if ("3114".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3114.jrxml");
        } else if ("3122".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3122.jrxml");
        } else if ("3126".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3126.jrxml");
        } else if ("3161".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3161.jrxml");
        } else if ("3102".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3102.jrxml");
        } else if ("3162".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3162.jrxml");
        } else if ("3147".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3147.jrxml");
        } else if ("3141".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3141.jrxml");
        } else if ("3155".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3155.jrxml");
        } else if ("3108".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3108.jrxml");
        } else if ("3134".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3134.jrxml");
        } else if ("3220".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3220.jrxml");
        } else if ("3233".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3233.jrxml");
        } else if ("3224".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3224.jrxml");
        } else if ("3237".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3237.jrxml");
        } else if ("3129".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3129.jrxml");
        } else if ("3130".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3130.jrxml");
        }else if ("3149".equals(riskCode)) {
            inputStream = classLoader.getResourceAsStream("template/PolicyPrint3149.jrxml");
        }
        paramMap.put("templetPath", inputStream);//jasper地址
        listMap.add(paramMap);
        return listMap;
    }

    /**
     * 保单打印
     *
     * @param request  获取保单号
     * @param response
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/12/5 16:34
     */
    @Override
    public void PolicyPrint(HttpServletRequest request, HttpServletResponse response, String[] policyNo, String comCode, String visaCode, String visaSerialNo, String userCode) throws Exception {

        String strTemplate = "";
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        File file = null;
        FileOutputStream fileOutputStream = null;
        String riskCode = policyNo[0].substring(1, 5);
        SealServiceUtils sealServiceUtils = new SealServiceUtils(SERVICEADDRESS, SYSID, USERID, USERPSD);
        try {
            List<Map<String, Object>> listMap = new ArrayList<>();
            for (int j = 0; j < policyNo.length; j++) {
                List<Map<String, Object>> paramMap = getPrintPolicyNo(request, classLoader, inputStream, policyNo[j], riskCode);
                listMap.add(paramMap.get(0));
            }
            PrintUtil.printReportPdfMore(listMap, 1, response.getOutputStream());
            //不同的险种用不同的保单打印模板,批量打印只允许选同一个险种
//            if("3107".equals(riskCode)||"3162".equals(riskCode)){
//                strTemplate="PolicyPrint1";
//            }else if("3102".equals(riskCode)||"3147".equals(riskCode)){
//                strTemplate="PolicyPrint3102";
//            }else if("3108".equals(riskCode)){
//                strTemplate="PolicyPrint3108";
//            }else if("3155".equals(riskCode)){
//                strTemplate="PolicyPrint3155";
//            }else if("3141".equals(riskCode)){
//                strTemplate="PolicyPrint3141";
//            }else if("3134".equals(riskCode)){
//                strTemplate="PolicyPrint3134";
//            }else if("3220".equals(riskCode)){
//                strTemplate="PolicyPrint3220";
//            }else if("3224".equals(riskCode)){
//                strTemplate="PolicyPrint3224";
//            }else if("3233".equals(riskCode)){
//                strTemplate="PolicyPrint3233";
//            }else if("3237".equals(riskCode)){
//                strTemplate="PolicyPrint3237";
//            }else if("3129".equals(riskCode)){
//                strTemplate="PolicyPrint3129";
//            }else if("3130".equals(riskCode)){
//                strTemplate="PolicyPrint3130";
//            }
//            file = File.createTempFile(strTemplate, ".pdf");
//            fileOutputStream = new FileOutputStream(file);
//            PrintUtil.printReportPdfMore(listMap, 1, fileOutputStream);
//            String shortLinkId = fileUtil.uploadFile(fileServiceUrl1, file, SinoRequestContext.getCurrentContext().getUserCode(), "tempfile", "agriprpall_printPdf");
//            SealDocRequestTreeNode treeNode = PrintServiceImpl.gettreeNode(strTemplate, shortLinkId,RULENO2);
//            InputStream inputStream1 = null;
//            ServletOutputStream outputStream = null;
//            try {
//                inputStream1 = sealServiceUtils.sendSealService(treeNode);
//                outputStream = response.getOutputStream();
//                byte[] bytes = new byte[1024];
//                int i = 0;
//                while ((i = inputStream1.read(bytes)) != -1) {
//                    outputStream.write(bytes, 0, i);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (inputStream1 != null) {
//                    inputStream1.close();
//                }
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//                if (fileOutputStream != null) {
//                    fileOutputStream.close();
//                }
//
//            }
            //回写数据
            if (StringUtils.isNotEmpty(visaSerialNo) && StringUtils.isNotEmpty(userCode)) {
                RequestQueryVisaCodesAndVisaSerialNosDto requestQDto = new RequestQueryVisaCodesAndVisaSerialNosDto();
                requestQDto.setUserCode(userCode);
                requestQDto.setComCode(comCode);
                requestQDto.setBusinessNo(policyNo[0].substring(1, 5) + "," + policyNo.length + "");
                List<ResponseQueryVisaCodesAndVisaSerialNosDto> responseQDtos = visaApi.queryVisaCodesAndVisaSerialNos(requestQDto);
                int i = 0;
                List<RequestVisaStatusWriteBackDto> requestVisaStatusWriteBackDtos = new ArrayList<>();
                for (ResponseQueryVisaCodesAndVisaSerialNosDto dto : responseQDtos) {
                    RequestVisaStatusWriteBackDto requestVisaStatusWriteBackDto = new RequestVisaStatusWriteBackDto();
                    requestVisaStatusWriteBackDto.setComCode(comCode);
                    requestVisaStatusWriteBackDto.setVisaCode(dto.getVisaCode());
                    requestVisaStatusWriteBackDto.setVisaSerialNo(dto.getVisaSerisal());
                    requestVisaStatusWriteBackDto.setUserCode(userCode);
                    requestVisaStatusWriteBackDto.setBusinessNo(policyNo[i]);
                    i++;
                    requestVisaStatusWriteBackDtos.add(requestVisaStatusWriteBackDto);
                }
                visaApi.visaStatusWriteBack(requestVisaStatusWriteBackDtos);
            }
        } catch (Exception e) {
            LOGGER.error("保单打印测试服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("保单打印测试服务报错");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (file != null) {
                file.delete();
            }
        }
        LOGGER.error("保单打印测试服务结束");
    }

    /**
     * 凭证打印
     *
     * @param request  获取保单号
     * @param response
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/12/5 16:34
     */
    @Override
    public void voucherPrinting(HttpServletRequest request, HttpServletResponse response, String[] policyNo) throws Exception {
        LOGGER.error("凭证打印测试服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        try {
            List<Map<String, Object>> listMap = new ArrayList<>();
            for (int j = 0; j < policyNo.length; j++) {
                ResponsePolicyPrintDto responsePolicyPrintDto = policyQueryApi.queryPolicyPrintByCondition(policyNo[j]);
                com.sinosoft.agriprpall.api.policymanage.dto.InsuraneItemsDto insuraneItemsDto = responsePolicyPrintDto.getInsuraneitems();
                com.sinosoft.agriprpall.api.policymanage.dto.InsuredInfoDto insuredInfoDto = responsePolicyPrintDto.getInsuredInfo();
                PremiumConDto premiumConDto = responsePolicyPrintDto.getPremiumConDto();
                Map<String, Object> paramMap = new HashMap<>();
                this.<ResponsePolicyPrintDto>setParameterToMap(ResponsePolicyPrintDto.class, responsePolicyPrintDto, paramMap, true);
                this.<com.sinosoft.agriprpall.api.policymanage.dto.InsuraneItemsDto>setParameterToMap(com.sinosoft.agriprpall.api.policymanage.dto.InsuraneItemsDto.class, insuraneItemsDto, paramMap, false);
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                String insureAddress = insuredInfoDto.getInsureAddress();
                String postCode = responsePolicyPrintDto.getPostCode();
                String reportPhone = responsePolicyPrintDto.getReportPhone();
                String text1 = responsePolicyPrintDto.getText1();
                List<ResponsePolicyPrintDto> responsePolicyPrintDtoList = new ArrayList<>();
                if (StringUtils.isNotEmpty(responsePolicyPrintDto.getText())) {
                    String[] clauses = responsePolicyPrintDto.getText().split("\n");
//                        String text = "保险责任简介：" + responsePolicyPrintDto.getText().replaceAll(" ", "");
//                        if (text.length() > 30) {
//                            list.add(text.substring(0, 30));
//                            int sum = 30;
//                            for (int i = 30; i < text.length(); i = i + 30) {
//                                if (sum < (text.length() - i)) {
//                                    list.add(text.substring(i, i + 30));
//                                } else {
//                                    list.add(text.substring(i));
//
//                                }
//                            }
//                        }
                    for (int i = 0; i < clauses.length; i++) {
                        ResponsePolicyPrintDto responsePolicyPrintDto1 = new ResponsePolicyPrintDto();
                        responsePolicyPrintDto1.setOneFlag("true");
                        responsePolicyPrintDto1.setText(clauses[i]);
                        responsePolicyPrintDtoList.add(responsePolicyPrintDto1);
                    }
                }
                if (StringUtils.isNotEmpty(responsePolicyPrintDto.getText1())) {
                    String[] clauses = responsePolicyPrintDto.getText1().split("\n");
//                        responsePolicyPrintDto2.setText1Flag("true");
                        for (int i = 0; i < clauses.length; i++) {
                            ResponsePolicyPrintDto responsePolicyPrintDto2 = new ResponsePolicyPrintDto();
                            responsePolicyPrintDto2.setTwoFlag("true");
                            responsePolicyPrintDto2.setText1(clauses[i]);
                            responsePolicyPrintDtoList.add(responsePolicyPrintDto2);
                        }
                    }
                    ResponsePolicyPrintDto responsePolicyPrintDto3 = new ResponsePolicyPrintDto();
                    responsePolicyPrintDto3.setThreeFlag("true");
                    responsePolicyPrintDtoList.add(responsePolicyPrintDto3);
                    ResponsePolicyPrintDto responsePolicyPrintDto4 = new ResponsePolicyPrintDto();
                    responsePolicyPrintDto4.setFourFlag("true");
                    responsePolicyPrintDto4.setInsureAddress(insureAddress);
                    responsePolicyPrintDtoList.add(responsePolicyPrintDto4);
                    ResponsePolicyPrintDto responsePolicyPrintDto5 = new ResponsePolicyPrintDto();
                    responsePolicyPrintDto5.setFiveFlag("true");
                    responsePolicyPrintDto5.setPostCode(postCode);
                    responsePolicyPrintDto5.setDate(simpleDateFormat.format(date));
                    responsePolicyPrintDtoList.add(responsePolicyPrintDto5);
                    ResponsePolicyPrintDto responsePolicyPrintDto6 = new ResponsePolicyPrintDto();
                    responsePolicyPrintDto6.setSixFlag("true");
                    responsePolicyPrintDto6.setReportPhone(reportPhone);
                    responsePolicyPrintDtoList.add(responsePolicyPrintDto6);
                    this.<com.sinosoft.agriprpall.api.policymanage.dto.InsuredInfoDto>setParameterToMap(com.sinosoft.agriprpall.api.policymanage.dto.InsuredInfoDto.class, insuredInfoDto, paramMap, false);
                    this.<PremiumConDto>setParameterToMap(PremiumConDto.class, premiumConDto, paramMap, false);
                    List<com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriDto> itemKindAgriList = responsePolicyPrintDto.getItemKindAgriList();
                    this.setParameterListToMap(com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriDto.class, itemKindAgriList, paramMap);
                    inputStream = classLoader.getResourceAsStream("template/voucherprinting.jrxml");
                    String No = request.getParameter("policyNo");
                    InputStream is = QrCodeCreateUtil.createQrCode(No, 600);
                    InputStream inputStream1 = QrCodeCreateUtil.eancodeEncode(No, 400, 100);
                    paramMap.put("barcode", inputStream1);
                    paramMap.put("qrcode", is);
                    paramMap.put("templetPath", inputStream);//jasper地址
                    paramMap.put("list", responsePolicyPrintDtoList);
                    listMap.add(paramMap);
                }
                PrintUtil.printReportPdfMore(listMap, 1, response.getOutputStream());
            } catch (Exception e) {
                LOGGER.error("凭证打印测试服务报错：" + e.getMessage());
                e.printStackTrace();
                throw new BusinessException("凭证打印测试服务报错");
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            LOGGER.error("凭证打印测试服务结束");
        }
        /**
         * 查询保单打印状态
         * @author: 宋振振
         * @date: 2018/3/14 17:59
         * @param  policyNos 保单号数组
         * @return 返回已打印的保单号
         * @throws Exception
         */
        public PolicyPrintStatusDto policyPrintStatus (List<String> policyNos)throws Exception {
            List<String> policyNoList = new ArrayList<>();
            List<String> policyNoListUpload = new ArrayList<>();
            PolicyPrintStatusDto policyPrintStatusDto=new PolicyPrintStatusDto();
            List<PrpCmain> prpCmainList = prpCmainDao.findPrpCmainByPolicyNos(policyNos);
            for (PrpCmain prpCmain : prpCmainList) {
                if (StringUtils.isNotEmpty(prpCmain.getPrintNo())) {
                    if(prpCmain.getPrintNo().length()>20){//已电子单证下载
                        policyPrintStatusDto.getPolicyPrintUploadList().put(prpCmain.getPolicyNo(),prpCmain.getPrintNo());
                    }else {//已正本打印
                        policyPrintStatusDto.getPolicyPrintList().add(prpCmain.getPolicyNo());
                    }
                }else{
                    //未打印的保单
                    policyPrintStatusDto.getPolicyPrintNo().add(prpCmain.getPolicyNo());
                }
            }
            return policyPrintStatusDto;
        }

    /**
     * 查看批单打印状态
     *
     * @param endorseNos
     * @return 打印状态
     * @throws Exception
     * @author: 宋振振
     * @date: 2018/4/4 9:45
     */
    public List<String> endorsePrintStatus(List<String> endorseNos) throws Exception {
        List<String> prpPheads = new ArrayList<>();
        List<PrpPhead> prpPheadList = prpPheadDao.findPrpPheadByPolicyNos(endorseNos);
        for (PrpPhead prpPhead : prpPheadList) {
            if (StringUtils.isNotEmpty(prpPhead.getPrintNo())) {
                prpPheads.add(prpPhead.getEndorseNo());
            }
        }
        return prpPheads;
    }


    /**
     * 保单下载
     *
     * @param request  获取保单号
     * @param response
     * @throws Exception
     * @author: 汪强
     * @date: 2017/12/5 16:34
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void policyDownLoad(HttpServletRequest request, HttpServletResponse response, String[] policyNo, String[] fileIds) throws Exception {

        if (policyNo.length != fileIds.length) {
            throw new BusinessException("参数错误：保单号与文件不一致 ");
        }
        String ua=request.getHeader("User-Agent");

        String strTemplate = "";
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = null;
        File file = null;
        FileOutputStream fileOutputStream = null;
        String riskCode = policyNo[0].substring(1, 5);
        SealServiceUtils sealServiceUtils = new SealServiceUtils(SERVICEADDRESS, SYSID, USERID, USERPSD);

        try {
//            List<Map<String, Object>> listMap = new ArrayList<>();
//            for (int j = 0; j < policyNo.length; j++) {
//                if (fileIds[j].isEmpty() || fileIds[j].equals("0")) {
//                    List<Map<String, Object>> paramMap = getPrintPolicyNo(request, classLoader, inputStream, policyNo[j], riskCode);
//                    listMap.add(paramMap.get(0));
//                }else{
//                    listMap.add(null);
//                }
//            }
            //endregion
            //List<String> fileIds=new ArrayList<>();
            List<String> shortLinkIds = new ArrayList<>();

            String shortLinkId = "";
            ServletOutputStream outputStream = null;
            String fileId = "";
            List<SealDocRequestTreeNode> treeNodes = new ArrayList<>();
            List<InputStream> inputStreamList = new ArrayList<>();
            //需要批量回写
            List<String> newPolicyNos = new ArrayList<>();
            List<String> newFileIds = new ArrayList<>();
            for (int i = 0; i < policyNo.length; i++) {
                inputStreamList.add(null);
                //文件id不存在，需要调用签章
                if (fileIds[i].isEmpty() || fileIds[i].equals("0")) {
                    //TODO 批量生成fileId、shortLinkId
                    file = File.createTempFile("policy", ".pdf");
                    fileOutputStream = new FileOutputStream(file);
                    List<Map<String, Object>> paramMap = getPrintPolicyNo(request, classLoader, inputStream, policyNo[i], riskCode);
                    PrintUtil.printReportPdfSingle(paramMap.get(0), 1, fileOutputStream);

                    fileId = fileUtil.uploadFileServer(fileServiceUrl, file, SinoRequestContext.getCurrentContext().getUserCode(), "agri/tempfile", "agriprpall_printPdf");
                    shortLinkId = fileUtil.createShortId(fileId, SinoRequestContext.getCurrentContext().getUserCode(), fileServiceUrl);
                    //初始化签章系统参数
                    SealDocRequestTreeNode treeNode = PrintServiceImpl.gettreeNode(fileId, shortLinkId, RULENO2);
                    //fileIds[i] = fileId;
                    treeNodes.add(treeNode);
                    newPolicyNos.add(policyNo[i]);
                } else {
                    //文件id已经存在，直接读取ftp
                    inputStreamList.set(i, fileUtil.downFile(fileServiceUrl, ".pdf", fileIds[i]));
                }
            }
            //调用签章系统
            List<InputStream> inputStreamsSeal = new ArrayList<>();
            if (treeNodes != null && treeNodes.size() > 0) {
                inputStreamsSeal = sealServiceUtils.sendSealServices(treeNodes);
            }
            //合并两种类的文件
            int j = 0;
            for (int i = 0; i < policyNo.length; i++) {
                //文件id不存在
                if (fileIds[i].isEmpty() || fileIds[i].equals("0")) {
                    if (j < inputStreamsSeal.size()) {

                        //复制inputstream流
                        ByteArrayOutputStream baos = fileUtil.cloneInputStream(inputStreamsSeal.get(j));
                        InputStream isClone = new ByteArrayInputStream(baos.toByteArray());
                        InputStream isClone2 = new ByteArrayInputStream(baos.toByteArray());

                        inputStreamList.set(i, isClone);

                        //将盖完章的保单存到ftp服务器，并将fileId回写到printid
                        String newFileId = "";
                        File filetemp = File.createTempFile("policyinputstrm", ".pdf");
                        fileUtil.inputstreamtofile(isClone2, filetemp);
                        newFileId = fileUtil.uploadFileServer(fileServiceUrl, filetemp, SinoRequestContext.getCurrentContext().getUserCode(), "agri/agriprpall", "printPdf");

                        newFileIds.add(newFileId);
                        j++;
                    }
                }
            }

            //回写printId
            batchUpdateFileId(newFileIds, newPolicyNos);

            File zipFile = fileUtil.zipCompire(inputStreamList, policyNo, "pdf");
            downloadFile(zipFile, response, policyNo,ua);

        } catch (Exception e) {
            LOGGER.error("保单打印测试服务报错：", e);
            e.printStackTrace();
            throw new BusinessException("保单打印测试服务报错");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (file != null) {
                file.delete();
            }
        }
    }

    /**
     * 回写fileid
     */
    @Transactional(rollbackFor = Exception.class)
    public void batchUpdateFileId(List<String> printNo, List<String> policyNo) {
        if (printNo == null || policyNo == null || policyNo.size() == 0 || policyNo.size() == 0 || printNo.size() != policyNo.size()) {
            //LOGGER.warn("保单打印测试服务报错，回写printid失败，printNo或policyNo为空");
            return;
        }
        String str = "";
        javax.persistence.Query query = null;
        String p1, p2;
        for (int i = 0; i < policyNo.size(); i++) {
            p1 = printNo.get(i);
            p2 = policyNo.get(i);
            p1 = p1.replace("'", "");
            p2 = p2.replace("'", "");

            str = "update PrpCmain p set  p.printNo='" + p1 + "' where p.policyNo='" + p2 + "'";
            query = entityManager.createNativeQuery(str);
            query.executeUpdate();
        }
    }

    /**
     * 下载文件
     * @param file 文件
     * @param response 输出流
     * @param policyNo  保单号
     * @param ua
     */
    private void downloadFile(File file, HttpServletResponse response, String[] policyNo,String ua) {
        //保单命名规则
        String filename = "";
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        String date = sim.format(new Date());
        if (policyNo.length == 1) {
            filename = date + "-" + policyNo[0];
        } else {
            filename = date + "-" + policyNo[0] + "等" + policyNo.length + "张电子保单";
        }
        filename += ".zip";
        try {

            String contentDisposition="attachment;filename="+filename;
            // ie
            if(ua.indexOf("MSIE")>=0 || ua.indexOf("Trident")>=0 || ua.indexOf("Chrome")>=0){
                filename= java.net.URLEncoder.encode(filename,"utf-8");
                contentDisposition="attachment;filename="+filename;
            }else if(ua.indexOf("Firefox")>=0){
                filename = "=?utf-8?b?"+new BASE64Encoder().encode(filename.getBytes("utf-8"))+"?=";
                contentDisposition="attachment;filename="+filename;
//                filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
            }else if( ua.indexOf("Safari")>=0){
                filename= java.net.URLEncoder.encode(filename,"utf-8");
                contentDisposition="attachment;filename*=UTF-8''"+filename;
            }

            // 以流的形式下载文件。
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", contentDisposition);
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private static String encodeURIComponent(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
