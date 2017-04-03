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
 * 通过zxing生成二维码
 * @author xiangzi
 *
 */
public class CreateQRCode {
	public static void main(String[] args) {
		//宽度
		int width = 300;
		//高度
		int height = 300;
		//文件类型
		String format = "png";
		//内容
		String content = "http://www.baidu.com";
		//定义二维码的参数
		HashMap hints = new HashMap();

		//字符集
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		//纠错等级
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		//边框
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
