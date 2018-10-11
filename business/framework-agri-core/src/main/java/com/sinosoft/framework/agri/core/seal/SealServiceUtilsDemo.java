package com.sinosoft.framework.agri.core.seal;

import com.sinosoft.framework.agri.core.seal.entity.SealDocRequestTreeNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * 签章系统调用demo
 * @outhor wq
 * @create 2018-01-26 16:44
 */
public class SealServiceUtilsDemo {

    private static String SERVICEADDRESS="http://121.42.226.56:9236/Seal/services/SealService?wsdl";
    private static String SYSID="sysId";
    private static String USERID="userId";
    private static String USERPSD="123456";
    public static void main(String[] args) {

        testSendSealService();
    }

    public static void testSendSealServices() {

        List<SealDocRequestTreeNode> treeNodeList = new ArrayList<>();
        //1、初始化文件信息。 方法入参
        for (int i = 0; i < 2; i++) {
            SealDocRequestTreeNode treeNode = new SealDocRequestTreeNode();
            treeNode.setFileNo("327063400002018000001"+i+".pdf");
            treeNode.setUserCode("34000040");
            treeNode.setUserName("安徽业务员-李婉");
            treeNode.setId("A05300050");
            treeNode.setUpUser("34000040");
            treeNode.setAppCode("UW010");
            treeNode.setCodebar(false);
            treeNode.setCertCodebar("");
            treeNode.setCodebarType("0");
            treeNode.setCodebarData("000000000000000000");
            treeNode.setxCoordinate("8000");
            treeNode.setyCoordinate("10000");
            treeNode.setCodebarSize("100");
            treeNode.setCodebarPage("0");
            treeNode.setSealType("0");
            treeNode.setRuleType("1");
            treeNode.setRuleNo("99");
//            treeNode.setRuleInfo("0,3000,4,3000,");
            treeNode.setCjType("file");
            treeNode.setRequestType("0");
            treeNode.setFilePath("http://files.cnblogs.com/files/web369/PolicyPrint.pdf");
            //treeNode.setFilePath("http://www.sinosoft-hf.cn:8088/fileserver-server/downloadFileByShortLinkId?shortLinkId=d9df3e98f8cb458a9f4806b5c624e50d");
            treeNode.setModelName("rsyw");
            treeNode.setAreaSeal(false);
            treeNode.setFtpSavepath("");
            treeNodeList.add(treeNode);
        }
        try {
            SealServiceUtils sealServiceUtils=new SealServiceUtils(SERVICEADDRESS,SYSID,USERID,USERPSD);
            List<InputStream> inputStreams= sealServiceUtils.sendSealServices(treeNodeList);

            int i=0;
            for(InputStream stream:inputStreams) {
                downfile(stream, "/Users/apple/Documents/3278000001"+i+".pdf");
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void testSendSealService(){
        //1、初始化文件信息。 方法入参
        SealDocRequestTreeNode treeNode=new SealDocRequestTreeNode();
        treeNode.setFileNo("327063400002018000001.pdf");
        treeNode.setUserCode("34000040");
        treeNode.setUserName("安徽业务员-李婉");
//        treeNode.setId("A05300050");
//        treeNode.setUpUser("34000040");
//        treeNode.setAppCode("UW010");
//        treeNode.setCodebar(false);
//        treeNode.setCertCodebar("");
        treeNode.setCodebarType("0");
        treeNode.setCodebarData("000000000000000000");
        treeNode.setxCoordinate("8000");
        treeNode.setyCoordinate("10000");
        treeNode.setCodebarSize("100");
        treeNode.setCodebarPage("0");
        treeNode.setSealType("0");
        treeNode.setRuleType("0");
        //treeNode.setRuleInfo("0,60,0,60");
        treeNode.setRuleNo("1");
        treeNode.setCjType("file");
        treeNode.setRequestType("0");
        treeNode.setFilePath("http://files.cnblogs.com/files/web369/PolicyPrint.pdf");
        treeNode.setModelName("rsyw");
        treeNode.setAreaSeal(false);
        treeNode.setFtpSavepath("");

        try {
            SealServiceUtils sealServiceUtils=new SealServiceUtils(SERVICEADDRESS,SYSID,USERID,USERPSD);
            InputStream inputStream= sealServiceUtils.sendSealService(treeNode);
            System.out.println(inputStream.available());
            downfile(inputStream,"/Users/apple/Documents/3278000001.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downfile(InputStream inputStream,String filename)throws IOException{
        FileOutputStream fileOut = new FileOutputStream(new File(filename));
        byte[] buf = new byte[1024 * 8];
        while (true) {
            int read = 0;
            if (inputStream != null) {
                read = inputStream.read(buf);
            }
            if (read == -1) {
                break;
            }
            fileOut.write(buf, 0, read);
        }
        fileOut.close();
    }
}
