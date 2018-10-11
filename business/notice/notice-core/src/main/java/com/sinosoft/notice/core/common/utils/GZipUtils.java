package com.sinosoft.notice.core.common.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.sinosoft.framework.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GZipUtils
{
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(GZipUtils.class);

    
    /**
     * @description 文件解压处理
     * @param buf
     * @return
     * @throws IOException
     * @author zkr10
     * @date 2016年10月13日下午1:48:47
     */
    public static byte[] unGzip(byte[] buf) throws IOException {
        GZIPInputStream gzi = null;
        ByteArrayOutputStream bos = null;
        try {
            gzi = new GZIPInputStream(new ByteArrayInputStream(buf));
            bos = new ByteArrayOutputStream(buf.length);
            byte[] buffer = new byte[1024];
            int count;
            while ((count = gzi.read(buffer)) != -1) {
                bos.write(buffer, 0, count);
            }
            buf = bos.toByteArray();
        }catch(EOFException e){
            throw new BusinessException(e.getMessage());
        }finally {
            if (bos != null) {
                bos.flush();
                bos.close();
            }
            if (gzi != null)
                gzi.close();
        }
        return buf;
    }

    
    
    /**
     * @description 文件压缩处理
     * @param val
     * @return
     * @throws IOException
     * @author zkr10
     * @date 2016年10月13日下午1:48:59
     */
    public static byte[] gzip(byte[] val) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(val.length);
        GZIPOutputStream gos = null;
        try {
            gos = new GZIPOutputStream(bos);
            gos.write(val, 0, val.length);
            gos.finish();
            gos.flush();
            bos.flush();
            val = bos.toByteArray();
        } finally {
            if (gos != null)
                gos.close();
            if (bos != null)
                bos.close();
        }
        return val;
    }
    
    
  
    
    /**
     * @description 对文件进行压缩
     * @param source 源文件
     * @param target 目标文件
     * @throws IOException
     * @author zkr10
     * @date 2016年10月13日下午1:49:10
     */
    public static void zipFile(String source, String target) throws IOException {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        GZIPOutputStream gzout = null;
        try {
            fin = new FileInputStream(source);
            fout = new FileOutputStream(target);
            gzout = new GZIPOutputStream(fout);
            byte[] buf = new byte[1024];
            int num;
            while ((num = fin.read(buf)) != -1) {
                gzout.write(buf, 0, num);
            }
        } finally {
            if (gzout != null)
                gzout.close();
            if (fout != null)
                fout.close();
            if (fin != null)
                fin.close();
        }
    }
    
    
   
    /**
     * @description 对文件进行压缩
     * @param source 源文件
     * @return
     * @throws IOException
     * @author zkr10
     * @date 2016年10月13日下午1:49:25
     */
    public static byte[] zipFile(String source) throws IOException {
        FileInputStream fin = null;
        ByteArrayOutputStream bout = null;
        GZIPOutputStream gzout = null;
        byte[] buf = new byte[1024];
        try {
            fin = new FileInputStream(source);
            bout = new ByteArrayOutputStream();
            gzout = new GZIPOutputStream(bout);
            int num;
            while ((num = fin.read(buf)) != -1) {
                gzout.write(buf, 0, num);
            }
            gzout.finish();
            gzout.flush();
            bout.flush();
            buf = bout.toByteArray();
        } finally {
            if (gzout != null)
                gzout.close();
            if (bout != null)
                bout.close();
            if (fin != null)
                fin.close();
        }
        return buf;
    }

    
    
    /**
     * @description 解压文件
     * @param source
     * @param target
     * @throws IOException
     * @author zkr10
     * @date 2016年10月13日下午1:49:41
     */
    public static void unZipFile(String source, String target)
            throws IOException {
        FileInputStream fin = null;
        GZIPInputStream gzin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream(source);
            gzin = new GZIPInputStream(fin);
            fout = new FileOutputStream(target);
            byte[] buf = new byte[1024];
            int num;
            while ((num = gzin.read(buf, 0, buf.length)) != -1) {
                fout.write(buf, 0, num);
            }
        } finally {
            if (fout != null)
                fout.close();
            if (gzin != null)
                gzin.close();
            if (fin != null)
                fin.close();
        }
    }
    
  
    /**
     * @description 文件转换为字节
     * @param file
     * @return
     * @throws IOException
     * @author zkr10
     * @date 2016年10月13日下午1:49:53
     */
    public static byte[] File2byte (File file) throws IOException 
    {  
        byte[] buffer = null;  
        try  
        {  
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
            byte[] b = new byte[1024];  
            int n;  
            while ((n = fis.read(b)) != -1)  
            {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        }  
        catch (FileNotFoundException e)  
        {
            throw new BusinessException(e.getMessage());
        }  
        catch (IOException e)  
        {
            throw new BusinessException(e.getMessage());
        }  
        return buffer;  
    }  
  
    
    
    /**
     * @description 字节转换为文件
     * @param buf
     * @param filePath
     * @param fileName
     * @return
     * @throws IOException
     * @author zkr10
     * @date 2016年10月13日下午1:50:03
     */
    public static File byte2File(byte[] buf, String filePath, String fileName) throws IOException
    {  
        BufferedOutputStream bos = null;  
        FileOutputStream fos = null;  
        File file = null;  
        try  
        {  
            File dir = new File(filePath);  
            if (!dir.exists())  
            {  
                dir.mkdirs();  
            }  
            file = new File(filePath + File.separator + fileName); 
            fos = new FileOutputStream(file);  
            bos = new BufferedOutputStream(fos);  
            bos.write(buf);  
        }  
        catch (Exception e)  
        {
            throw new BusinessException(e.getMessage());
        }  
        finally  
        {  
            if (bos != null)  
            {  
                bos.close();
            }  
            if (fos != null)  
            {  
                bos.close();
            }  
        }
        return file;
    }
}
