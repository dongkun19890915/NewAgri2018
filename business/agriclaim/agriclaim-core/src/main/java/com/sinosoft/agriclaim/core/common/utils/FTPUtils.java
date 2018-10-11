package com.sinosoft.agriclaim.core.common.utils;

import com.sinosoft.agriclaim.core.businessutilmanage.utils.FileUtil;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.core.context.SinoRequestContext;
import org.apache.commons.net.ftp.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.SocketException;
@Component
public class FTPUtils extends FTPClient {

    @Value("${fileService.url}")
    private String fileServiceUrl;

    private OutputStream out;
    /**
     * 获取FTPClient对象
     *
     * @param ftpHost     FTP主机服务器
     * @param ftpPassword FTP 登录密码
     * @param ftpUserName FTP登录用户名
     * @param ftpPort     FTP端口 默认为21
     * @return
     */
    public static FTPClient getFTPClient(String ftpHost, String ftpUserName,
                                         String ftpPassword, int ftpPort) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器
            ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                System.out.println("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                System.out.println("FTP连接成功。");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }

    /*
     * 从FTP服务器下载文件
     *
     * @param ftpHost FTP IP地址
     * @param ftpUserName FTP 用户名
     * @param ftpPassword FTP用户名密码
     * @param ftpPort FTP端口
     * @param ftpPath FTP服务器中文件所在路径 格式： ftptest/aa
     * @param localPath 下载到本地的位置 格式：H:/download
     * @param fileName 文件名称
     */
    public String downloadFtpFile(String ftpHost, String ftpUserName,
                                       String ftpPassword, int ftpPort, String ftpPath, String localPath,
                                       String fileName) throws Exception{

        FTPClient ftpClient = null;
        String shortLink = "";
        try {
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);

            File localFile = new File(localPath + File.separatorChar + fileName);
            OutputStream os = new FileOutputStream(localFile);
            ftpClient.retrieveFile(fileName, os);
            os.close();
            ftpClient.logout();
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_paymentmanage";//项目名_模块名
            FileUtil fileUtil = new FileUtil();
            shortLink = fileUtil.uploadFile(fileServiceUrl,localFile,userCode,systemId,bussType);
        } catch (FileNotFoundException e) {
            System.out.println("没有找到" + ftpPath + "文件");
            e.printStackTrace();
        } catch (SocketException e) {
            System.out.println("连接FTP失败.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取错误。");
            e.printStackTrace();
        }
        return shortLink;
    }

    /**
     * Description: 向FTP服务器上传文件
     * @param ftpHost FTP服务器hostname
     * @param ftpUserName 账号
     * @param ftpPassword 密码
     * @param ftpPort 端口
     * @param ftpPath  FTP服务器中文件所在路径 格式： ftptest/aa
     * @param fileName ftp文件名称
     * @param input 文件流
     * @return 成功返回true，否则返回false
     */
    public boolean uploadFile(String ftpHost, String ftpUserName,
                                     String ftpPassword, int ftpPort, String ftpPath,
                                     String fileName,InputStream input) {
        boolean success = false;
        FTPClient ftpClient = null;
        try {
            int reply;
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return success;
            }
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);

            ftpClient.storeFile(fileName, input);

            input.close();
            ftpClient.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }


    public File AllinPayreceiptFile(String filePath,String ftpUrl,int ftpPort,String ftpUser,String ftpPass,String ftpDir) {
        InputStream input = null;
        File file = null;
        try {
            String [] strings = StringGyUtils.split(filePath,"/");
            String fileName = "";
            String name = "";
            if (strings.length>0){
                fileName = strings[strings.length-1];
                name = fileName.substring(fileName.length()-4,fileName.length());
            }

            file = File.createTempFile(name, ".pdf");
            FTPClient ftp = new FTPClient();

            int reply;
            ftp.connect(ftpUrl, ftpPort);// 加载IP,端口号
            ftp.login(ftpUser, ftpPass);// 账号密码登录

            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                throw new Exception("FTP服务报错");
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            String ftpPath = ftpDir;
            if (ftpPath != null && !"".equals(ftpPath)) {
                ftp.changeWorkingDirectory("/");
                String[] rootPaths = ftpPath.split("/");
                for (int i = 0; i < rootPaths.length; i++) {
                    if (!"".equals(rootPaths[i])) {
                        ftp.changeWorkingDirectory(rootPaths[i]);
                    }
                }
            }
            String path = filePath;
            String separator = "/";
            int lastIndex = filePath.lastIndexOf("/");
            if (lastIndex == -1) {
                lastIndex = filePath.lastIndexOf("\\");
                separator = "\\\\";
            }
            String dir = path.substring(0, lastIndex);
            String[] dirs = dir.split(separator);
            for (String direct : dirs) {
                ftp.changeWorkingDirectory(direct);
            }
            String[] listName = ftp.listNames();
            boolean ifUse = false;
            if (null != listName && listName.length > 0) {
                for (int i = 0; i < listName.length; i++) {
                    System.err.println("****" + listName[i]);
                    if (fileName.equals(listName[i])) {
                        ifUse = true;
                    }
                }
            }

            if (!ifUse) {
            } else {
                input = ftp.retrieveFileStream(fileName);
                out = new FileOutputStream(file);
                int len = 0;
                byte buffer[] = new byte[1024];
                while ((len = input.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                ftp.logout();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                return file;
            }
        }
    }
}
