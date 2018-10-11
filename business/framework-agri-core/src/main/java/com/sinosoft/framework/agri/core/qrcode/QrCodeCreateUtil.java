package com.sinosoft.framework.agri.core.qrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Hashtable;

/**
 * description:二维码生成读取类
 * @outhor wq
 * @create 2018-01-15 10:08
 */
public class QrCodeCreateUtil {
    /**
     * 生成包含字符串信息的二维码图片
     *
     * @param outputStream 文件输出流路径
     * @param content      二维码携带信息
     * @param qrCodeSize   二维码图片大小
     * @param imageFormat  二维码的格式
     * @throws WriterException
     * @throws IOException
     */
    public static boolean createQrCode(OutputStream outputStream, String content, int qrCodeSize, String imageFormat) throws WriterException, IOException {
        BufferedImage image=createImage(content,qrCodeSize,imageFormat);
        return ImageIO.write(image, imageFormat, outputStream);
    }

    /**
     * 创建二维码，返回文件流
     * @param content
     * @param qrCodeSize
     * @return
     * @throws Exception
     */
    public static InputStream createQrCode(String content, int qrCodeSize) throws Exception {
        String imageFormat="png";
        BufferedImage image=createImage(content,qrCodeSize,imageFormat);
        //BufferedImage 转 InputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
        ImageIO.write(image, imageFormat, imageOutput);
        InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return inputStream;
    }


    /**
     * 生成二维码图片公共方法
     * @param content
     * @param qrCodeSize
     * @param imageFormat
     * @return BufferedImage
     * @throws WriterException
     * @throws IOException
     */
    public static BufferedImage createImage(String content, int qrCodeSize, String imageFormat)throws WriterException, IOException{
        //设置二维码纠错级别ＭＡＰ
        Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
        //矫错级别
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        //修改字作编码
        content = new String(content.getBytes("UTF-8"), "ISO-8859-1");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        qrCodeSize=qrCodeSize+100;
        //创建比特矩阵(位矩阵)的QR码编码的字符串
        BitMatrix byteMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize, hintMap);
        // 使BufferedImage勾画QRCode  (matrixWidth 是行二维码像素点)
        int matrixWidth = byteMatrix.getWidth();
        BufferedImage image = new BufferedImage(matrixWidth - 100, matrixWidth - 100, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);
        // 使用比特矩阵画并保存图像
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i - 50, j - 50, 1, 1);
                }
            }
        }
        return image;
    }


    public static BufferedImage createQrCodes(String content, int qrCodeSize) throws Exception {
        String imageFormat="png";
        BufferedImage image=createImage(content,qrCodeSize,imageFormat);
        return image;
    }

    public static InputStream addQRCodeLogo(BufferedImage image , BufferedImage logo, QrLogoConfig logoConfig) {
        try {
            Graphics2D g = image.createGraphics();
            //设置logo的大小,本人设置为二维码图片的20%,因为过大会盖掉二维码
            int widthLogo = logo.getWidth(null) > image.getWidth() * 2 / 10 ? (image.getWidth() * 2 / 10) : logo.getWidth(null);
            int heightLogo = logo.getHeight(null) > image.getHeight() * 2 / 10 ? (image.getHeight() * 2 / 10) : logo.getHeight(null);

            // 计算图片放置位置
            //logo放在中心
            int x = (image.getWidth() - widthLogo) / 2;
            int y = (image.getHeight() - heightLogo) / 2;
            //logo放在右下角
//            int x = (image.getWidth() - widthLogo);
//            int y = (image.getHeight() - heightLogo);
            //开始绘制图片
            g.drawImage(logo, x, y, widthLogo, heightLogo, null);
            g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
            g.setStroke(new BasicStroke(logoConfig.getBorder()));
            g.setColor(logoConfig.getBorderColor());
            g.drawRect(x, y, widthLogo, heightLogo);

            g.dispose();
            logo.flush();
            image.flush();

            //BufferedImage 转 InputStream
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
            ImageIO.write(image, "png", imageOutput);
            InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            //ImageIO.write(image, "jpg", new File("/Users/apple/Documents/developer/qrcodeUserInfo.jpg"));
            return inputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    /**
     * 读二维码并输出携带的信息
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String readQrCode(InputStream inputStream) throws IOException {
        //从输入流中获取字符串信息
        BufferedImage image = ImageIO.read(inputStream);
        //将图像转换为二进制位图源
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        QRCodeReader reader = new QRCodeReader();

        Result result = null;
        try {
            result = reader.decode(bitmap);
            return result.getText();
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        return  null;
    }



    /**
     * 生成条形码
     * @param contents  条形码内容
     * @param width  宽度
     * @param height  高度
     */
    public static BufferedImage createEancodeEncode(String contents, int width, int height) {
        int codeWidth = 3 + (7 * 6) + 5 +  (7 * 6) +3;
        codeWidth = Math.max(codeWidth, width);
        try {

            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,BarcodeFormat.CODE_128, codeWidth, height, null);
            BufferedImage image= MatrixToImageWriter.toBufferedImage(bitMatrix);
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 创建条形码
     * @param contents  条形码内容
     * @param width  宽度
     * @param height  高度
     * @return
     */
    public static InputStream eancodeEncode(String contents, int width, int height) {
        try {
            BufferedImage image = createEancodeEncode(contents, width, height);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
            ImageIO.write(image, "png", imageOutput);
            InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            return inputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成条形码带数字信息
     * @param contents    条形码内容
     * @param width  宽度
     * @param height  高度
     */
    public static InputStream eancodeEncodeAddInfo(String contents, int width, int height) {
        try {
            BufferedImage image=createEancodeEncode(contents,  width,  height);
            // 2、得到画笔对象
            Graphics2D g = image.createGraphics();
            //扩展数字区域
            g.setColor(Color.WHITE);
            g.fillRect(0,height-20,width,20);

            //设置水印文字颜色
            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            //g.drawImage(img.getScaledInstance(width,height, Image.SCALE_DEFAULT), 0, 0, null);

            g.drawImage(image,0,0,null);

            g.setColor(Color.BLACK);
            g.setFont(new Font("arial", Font.PLAIN, 18));
            //居中字符
            drawString(g,contents,width/2, height-3);

            // 9、释放资源
            g.dispose();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
            ImageIO.write(image, "png", imageOutput);
            InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            return inputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void drawString(Graphics g, String str, int xPos, int yPos) {
        int strWidth = g.getFontMetrics().stringWidth(str);
        System.out.println(strWidth);
        g.drawString(str, xPos - strWidth / 2, yPos);
    }
}
