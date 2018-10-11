package com.sinosoft.framework.agri.core.seal;

import com.sinosoft.framework.agri.core.seal.entity.*;
import com.sinosoft.framework.agri.core.seal.webservice.SealServicePortType;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-01-26 15:10
 */
public class SealServiceUtils {
    private  final Logger LOGGER = LoggerFactory.getLogger(SealServiceUtils.class);

    private  XStream xstream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
    //private static final String ServiceAddress="http://121.42.226.56:9236/Seal/services/SealService?wsdl";;
    private final String SUCCESSFLAG="0";
    private String SERVICEADDRESS;
    private String SYSID;
    private String USERID;
    private String USERPSD;

//    public SealServiceUtils(){
//
//    }

    /**
     *
     * @param serviceaddress 接口地址
     * @param sysId 应用系统ID，用于此次业务由那个系统发起
     * @param userId    电子印章系统存在的用户
     * @param userPsd   电子印章系统存在的用户密码
     */
    public SealServiceUtils(String serviceaddress,String sysId,String userId,String userPsd){
        SERVICEADDRESS=serviceaddress;
        SYSID=sysId;
        USERID=userId;
        USERPSD=userPsd;
    }

    /**
     * 签章系统发送验证请求，并返回文件流
     * @param treeNode
     * @return 返回文件流
     */
    public  InputStream sendSealService(SealDocRequestTreeNode treeNode){
        List<SealDocRequestTreeNode> treeNodes=new ArrayList<>();
        treeNodes.add(treeNode);
        List<InputStream> inputStreamList= sendSealServices(treeNodes);
        if(inputStreamList==null || inputStreamList.size()==0){
            return null;
        }else{
            return inputStreamList.get(0);
        }
    }

    /**
     * 批量调用签章系统发送验证请求，并返回文件流
     * @param treeNodes
     * @return 返回文件流
     */
    public  List<InputStream> sendSealServices(List<SealDocRequestTreeNode> treeNodes){
        //自动检测注解
        xstream.autodetectAnnotations(true);
        //创建webservice请求
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(SealServicePortType.class);
        factory.setAddress(SERVICEADDRESS);
        SealServicePortType port = (SealServicePortType) factory.create();

        //生成xml报文
        String requestXml=parseRequestXml(treeNodes);

        String result=null;
        try {
            result=  port.sealAutoPdf(requestXml);
            LOGGER.debug("签章调用成功:"+result);
        } catch (Exception e) {
            LOGGER.error("签章调用失败:"+requestXml,e);
            e.printStackTrace();
        }
        //解析返回报文字符串
        List<String> fileDownUrls=parseResponseXml(result);

        List<InputStream> inputStreamList=new ArrayList<>();
        try {
            for(String url:fileDownUrls) {
                LOGGER.debug("下载url "+url);
                inputStreamList.add(new URL(url).openStream());
            }
        } catch (IOException e) {
            LOGGER.error("签章 下载文件失败:",e);
            e.printStackTrace();
        }
        return inputStreamList;
    }

    /**
     * 根据对象生成报文xml字符串
     * @param treeNodes
     * @return
     */
    private  String parseRequestXml(List<SealDocRequestTreeNode> treeNodes){
        //basedata
        //初始化基础信息 后期从配置文件读取
        //TODO 改成读取配置文件
        BaseData baseData=new BaseData(SYSID,USERID,USERPSD);

        //filelist treenode
//        List<SealDocRequestTreeNode> list=new ArrayList<SealDocRequestTreeNode>();
//        list.add(treeNode);

        SealDocRequest sealDocRequest=new SealDocRequest();
        sealDocRequest.setBaseData(baseData);
        sealDocRequest.setFileList(treeNodes);

        //添加xml头信息
        String xmlHead="<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>\r\n";
        String xml=xstream.toXML(sealDocRequest);

        LOGGER.debug("签章请求："+xml);
        return xmlHead+xml;
    }

    /**
     * 获取文件下载地址
     * @param xml
     * @return
     */
    private  List<String> parseResponseXml(String xml){
        if(StringUtils.isEmpty(xml)){
            return null;
        }

        xstream.alias("SealDocResponse",SealDocResponse.class);
        SealDocResponse sealDocResponse=(SealDocResponse) xstream.fromXML(xml);

        if(sealDocResponse==null){
            return null;
        }
        List<SealDocResponseTreeNode> treeNodeList=sealDocResponse.getTreeNodes();
        if(treeNodeList==null || treeNodeList.size()==0){
            return null;
        }
        List<String> urlList=new ArrayList<>();

        for(SealDocResponseTreeNode treeNode:treeNodeList){
            if(SUCCESSFLAG.equals(treeNode.getRetCode())){
                urlList.add(treeNode.getFileMsg());
            }else{
                urlList.add(null);
                LOGGER.warn("seal请求失败:"+treeNode.getFileMsg());
            }
        }
        return urlList;
    }

    //对象转xml
    public  String toSealDocResponse() {
        SealDocResponse sealDocResponse = new SealDocResponse();
        SealDocResponseTreeNode treeNode = new SealDocResponseTreeNode("1", "327063400002018000009.pdf", "http://121.42.226.56:9236/Seal/doc/download.jsp?name=327063400002018000001.pdf");
        List<SealDocResponseTreeNode> list = new ArrayList<SealDocResponseTreeNode>();
        list.add(treeNode);
        sealDocResponse.setTreeNodes(list);

        String xmlHead = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n";
        String xml = xstream.toXML(sealDocResponse);
        return xmlHead + xml;
    }

}
