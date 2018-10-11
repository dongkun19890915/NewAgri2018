package com.sinosoft.demo.core.webservice;

/**
 *@Description: webservice接口调用验证
 *@Author:汪强
 *@Since:2017年10月20日
 */
public class WebServiceTest {


    public static void main(String[] args)throws Exception{
        wsimport();
    }

    /**
     * @description wsimport命令根据wsdl文件生成客户端代码
     * @return
     * @throws Exception
     * @author 汪强
     * @date 2017年10月20日
     */
    public static void wsimport()throws Exception{
        //"http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL";
        //生成命令
        //wsimport -p com.sinosoft.demo.core.webservice -s /Users/apple/Documents  -keep http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL


        //1、声名ws服务
        MobileCodeWS mobileCodeWS = new MobileCodeWS();
        //2、创建端口服务
        MobileCodeWSSoap mobileCodeWSSoap = mobileCodeWS.getMobileCodeWSSoap();
        //3、调用接口服务
        ArrayOfString list=mobileCodeWSSoap.getDatabaseInfo();
        System.out.println(list.getString());

        //4、测试试用有参数接口
        String result=mobileCodeWSSoap.getMobileCodeInfo("1380551",null);
        System.out.println(result);


    }
}
