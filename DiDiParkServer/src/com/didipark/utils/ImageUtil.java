package com.didipark.utils;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {

    /**
     * ��������ͼ
     * @param srcImageFile ԴͼƬ�ļ���Fileʵ��      File file = new File("�ļ���");
     * @param dstImageFileName �����ɵ�����ͼƬ����·��(���ɵĸ�ʽΪ��image/jpeg);
     * @throws Exception
     */
    public static void makeSmallImage(File srcImageFile,String dstImageFileName) throws Exception {
    	FileOutputStream fileOutputStream = null;
        JPEGImageEncoder encoder = null;
        BufferedImage tagImage = null;
        Image srcImage = null;
        try{
            srcImage = ImageIO.read(srcImageFile);
            int srcWidth = srcImage.getWidth(null);//ԭͼƬ���
            int srcHeight = srcImage.getHeight(null);//ԭͼƬ�߶�
            int dstMaxSize = 80;//Ŀ������ͼ�������/�߶ȣ������߶Ƚ���������д
            int dstWidth = srcWidth;//����ͼ���
            int dstHeight = srcHeight;//����ͼ�߶�
            float scale = 0;
            //��������ͼ�Ŀ�͸�
            if(srcWidth>dstMaxSize){
                dstWidth = dstMaxSize;
                scale = (float)srcWidth/(float)dstMaxSize;
                dstHeight = Math.round((float)srcHeight/scale);
            }
            srcHeight = dstHeight;
            if(srcHeight>dstMaxSize){
                dstHeight = dstMaxSize;
                scale = (float)srcHeight/(float)dstMaxSize;
                dstWidth = Math.round((float)dstWidth/scale);
            }
            //��������ͼ
            tagImage = new BufferedImage(dstWidth,dstHeight,BufferedImage.TYPE_INT_RGB);
            tagImage.getGraphics().drawImage(srcImage,0,0,dstWidth,dstHeight,null);
            fileOutputStream = new FileOutputStream(dstImageFileName);
            encoder = JPEGCodec.createJPEGEncoder(fileOutputStream);
            encoder.encode(tagImage);
            fileOutputStream.close();
            fileOutputStream = null;
        }finally{
            if(fileOutputStream!=null){
                try{
                    fileOutputStream.close();
                }catch(Exception e){
                }
                fileOutputStream = null;
            }
            encoder = null;
            tagImage = null;
            srcImage = null;
            System.gc();
        }
    }
}