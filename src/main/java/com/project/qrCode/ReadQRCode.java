package com.project.qrCode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class ReadQRCode {
	public static void main(String[] args) {
		File file = new File("D:/qrcode.png");
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			QRCodeDecoder codeDecoder = new QRCodeDecoder();
			String result=new String(codeDecoder.decode(new MYQRCodeImage(bufferedImage)),"utf-8");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
