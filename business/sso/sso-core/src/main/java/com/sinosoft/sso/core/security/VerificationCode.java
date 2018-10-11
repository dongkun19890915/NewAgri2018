package com.sinosoft.sso.core.security;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by bin on 14/12/11.
 */

public class VerificationCode {

    public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";//�ŵ�session�е�key
    private static  Random random = new Random();
    private static String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//��������ַ�

    private static int width = 80;//ͼƬ��
    private static int height = 26;//ͼƬ��
    private static int lineSize = 40;//����������
    private static int stringNum = 4;//�������ַ�����
    /*
     * �������
     */
    private static Font getFont(){
        return new Font("Fixedsys",Font.CENTER_BASELINE,18);
    }
    /*
     * �����ɫ
     */
    private static Color getRandColor(int fc,int bc){
        if(fc > 255)
            fc = 255;
        if(bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc-fc-16);
        int g = fc + random.nextInt(bc-fc-14);
        int b = fc + random.nextInt(bc-fc-18);
        return new Color(r,g,b);
    }
    /**
     * ������ͼƬ
     */
    public static void getRandcode(HttpServletRequest request,
                                   HttpServletResponse response) {
        HttpSession session = request.getSession();
        //BufferedImage���Ǿ��л������Image��,Image������������ͼ����Ϣ����
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();//����Image�����Graphics����,�Ķ��������ͼ���Ͻ��и��ֻ��Ʋ���
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,18));
        g.setColor(getRandColor(110, 133));
        //���Ƹ�����
        for(int i=0;i<=lineSize;i++){
            drowLine(g);
        }
        //��������ַ�
        String randomString = "";
        for(int i=1;i<=stringNum;i++){
            randomString= drawString(g, randomString, i);
        }
        session.removeAttribute(RANDOMCODEKEY);
        session.setAttribute(RANDOMCODEKEY, randomString);
        
        System.out.println("Image Session : " + session.getId());
        g.dispose();
        try {
            ImageIO.write(image, "JPEG", response.getOutputStream());//���ڴ��е�ͼƬͨ��������ʽ������ͻ���
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * �����ַ�
     */
    private static String drawString(Graphics g, String randomString, int i){
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101),random.nextInt(111),random.nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(randString.length())));
        randomString +=rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13*i, 16);
        return randomString;
    }
    /*
     * ���Ƹ�����
     */
    private static void drowLine(Graphics g){
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x+xl, y+yl);
    }
    /*
     * ��ȡ�����ַ�
     */
    public static String getRandomString(int num){
        return String.valueOf(randString.charAt(num));
    }
}