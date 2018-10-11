package com.sinosoft.notice.core.common.service.impl;

import com.sinosoft.notice.core.common.service.SendMailService;
import com.sinosoft.notice.core.common.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class SendMailServiceImpl implements SendMailService{

    //发送邮件人账户
    @Value("${mailService.mail_username}")
    private String mail_username;

    //ftp服务地址
    @Value("${fileService.url}")
    private String fileServiceUrl;

    @Value("${mailService.mail_Host}")
    private String mail_Host;

    @Value("${mailService.mail_ServerPort}")
    private String mail_ServerPort;

    @Value("${mailService.mail_Password}")
    private String mail_Password;




    /**
     * 电子保单邮件发送
     *
     * @param map  获取收件人 以及 filed(从ftp服务器上获取电子保单邮件)
     * @throws Exception
     * @author: 祝凯
     * @date: 2018/05/18 16:34
     */
    public boolean sendMail(Map map) {

        FileUtil fileUtil = new FileUtil();
        List<InputStream> inputStreamList = new ArrayList<>();
        String[] rescivers = new String[map.size()];
        ArrayList list = (ArrayList)map.get("rescivers");
        for(int j=0;j<list.size();j++){
            rescivers[j] = (String) list.get(j);
        }
        String fileld = (String)map.get("fileld");
        String policyNo=(String)map.get("policyNo");
        Properties pro = new Properties();
        pro.setProperty("mail.smtp.host",mail_Host);
        pro.setProperty("mail.smtp.port",mail_ServerPort);
        pro.setProperty("mail.smtp.auth", "ture");
        pro.setProperty("mail.transport.protocol", "smtp");//协议
        Session sendMailSession =Session.getDefaultInstance(pro);
        sendMailSession .setDebug(false);
        Multipart multipart = new MimeMultipart();
        BASE64Encoder enc = new BASE64Encoder();
        //电子保单未下载不允许发送，必须先点击电子保单下载
        if("".equals(fileld)){
            return false;
        }
        try{
            Message mailMessage = new MimeMessage(sendMailSession);

            Address[] address=new Address[list.size()];
            for(int i=0;i< list.size();i++ ){
                address[i] = new InternetAddress(rescivers[i]);
            }
            //设置收件人 默认多个
            mailMessage.setRecipients(Message.RecipientType.TO,address);
            mailMessage.setSentDate(new Date());
            mailMessage.setFrom(new InternetAddress(mail_username));
            mailMessage.addHeader("charset", "UTF-8");
            mailMessage.setSubject("主题：电子保单");
            //ftp服务器下载带签章的电子保单
            InputStream inputStream = fileUtil.downFile(this.fileServiceUrl,".pdf",fileld);
            inputStreamList.add(inputStream);
//            File filetemp= File.createTempFile("policyinputstrm", ".pdf");
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            File filetemp=new File(format.format(new Date())+"-"+policyNo+".pdf");
            fileUtil.inputstreamtofile(inputStream,filetemp);
            //File zipFile = fileUtil.zipCompire(inputStreamList, policyno, "pdf");


            MimeBodyPart fileBody = new MimeBodyPart();
            DataSource source = new FileDataSource(filetemp);
            fileBody.setDataHandler(new DataHandler(source));

            fileBody.setFileName(filetemp.getName());
            multipart.addBodyPart(fileBody);

            //添加正文
            mailMessage.setContent(multipart);
            Transport transport = sendMailSession.getTransport();
            transport.connect(mail_Host,mail_username,mail_Password);
            transport.sendMessage(mailMessage,mailMessage.getAllRecipients());
            transport.close();
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
        return true;
    }

}
