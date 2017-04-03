package com.project.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * ͨ��zxing���ɶ�ά��
 * @author xiangzi
 *
 */
public class CreateQRCode {
	public static void main(String[] args) {
		//���
		int width = 300;
		//�߶�
		int height = 300;
		//�ļ�����
		String format = "png";
		//����
		String content = "http://www.baidu.com";
		//�����ά��Ĳ���
		HashMap hints = new HashMap();

		//�ַ���
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		//����ȼ�
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		//�߿�
		hints.put(EncodeHintType.MARGIN, 0);
		
		
		try {
			BitMatrix  bitmatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
			Path file=new File("D:/img.png").toPath();
			MatrixToImageWriter.writeToPath(bitmatrix, format, file);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
