package com.sinosoft.demo.core.printpdf.service.impl;

import com.sinosoft.demo.core.printpdf.dto.PrpDuserDto;
import com.sinosoft.demo.core.printpdf.service.PrintService;
import com.sinosoft.demo.core.util.PrintUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 单证打印service实现类
 * @Author mayibo
 * @Since 2017/8/29 16:28
 */
@Service
@Transactional
public class PrintServiceImpl extends BaseServiceImpl implements PrintService {

    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintServiceImpl.class);

    private static final String TEXT_NONE = "无";



    @Override
    public void testPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("打印测试服务开始");

//        String templetPath = this.getClass().getResource("/").getPath() + "template/";
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream=null;
        try {
            List<Map<String,Object>> listMap = getOfferParamsForProposal(request,classLoader,inputStream);
            PrintUtil.printReportPdfMore(listMap,1,response);
        }catch (Exception e){
            LOGGER.info("打印测试服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("打印测试服务报错");
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        LOGGER.info("打印测试服务结束");
    }



    public List<Map<String, Object>> getOfferParamsForProposal(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream) throws Exception {
        inputStream = classLoader.getResourceAsStream("template/testPrint.jrxml");
        String userName = request.getParameter("userName");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String weight = request.getParameter("weight");

        List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("userName",userName);
        paramMap.put("sex",sex);
        paramMap.put("age",age);
        paramMap.put("weight",weight);

        List<PrpDuserDto> prpDuserDtoList = getPrpDuser();

        paramMap.put("list",prpDuserDtoList);

        paramMap.put("logoPath","template/001.jpg");

        paramMap.put("templetPath",inputStream);
        paramMap.put("isShowImage","true");

        listMap.add(paramMap);
        return listMap;
    }

    private List<PrpDuserDto> getPrpDuser() {
        List<PrpDuserDto> prpDuserDtoList = new ArrayList<>();
        prpDuserDtoList.add(new PrpDuserDto("0000","张三","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0001","李四","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0002","王五","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0003","周三","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0000","张三","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0001","李四","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0002","王五","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0003","周三","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0000","张三","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0001","李四","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0002","王五","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0003","周三","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0000","张三","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0001","李四","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0002","王五","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0003","周三","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0000","张三","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0001","李四","男","20"));
//        prpDuserDtoList.add(new PrpDuserDto("0002","王五","男","20"));
        prpDuserDtoList.add(new PrpDuserDto("0003","周三","男","20"));

        return prpDuserDtoList;
    }


}
