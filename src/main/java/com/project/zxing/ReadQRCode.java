package com.project.zxing;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

/**读取二维码
 * @author xiangzi
 *
 */
public class ReadQRCode {

	public static void main(String[] args) {
		MultiFormatReader formatReader = new MultiFormatReader();
		File file = new File("D:/qrcode.png");
		
		try {
			BufferedImage image = ImageIO.read(file);
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			//定义二维码的参数
			HashMap hints = new HashMap();
			//字符集
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			Result result=formatReader.decode(binaryBitmap, hints);
			System.out.println("解析结果："+result);
			System.out.println(result.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
