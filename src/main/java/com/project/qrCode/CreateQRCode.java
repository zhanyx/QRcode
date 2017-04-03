package com.project.qrCode;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CreateQRCode {

	public static void main(String[] args) throws Exception {
		Qrcode qrCode = new Qrcode();
		qrCode.setQrcodeErrorCorrect('M');// 纠错等级
		qrCode.setQrcodeEncodeMode('B');// N代表数字 A代表a-Z B代表其他字符
		qrCode.setQrcodeVersion(7);
		String qrData = "张玉祥";
		int width = 67 + 12 * (7 - 1);
		int height = 67 + 12 * (7 - 1);
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.GREEN);
		gs.clearRect(0, 0, width, height);
		int pixoff = 2;
		byte[] d = qrData.getBytes("utf-8");
		if (d.length > 0 && d.length < 120) {
			boolean[][] s = qrCode.calQrcode(d);
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[j][i]) {
						gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
					}
				}
			}
			gs.dispose();
			bufferedImage.flush();
			ImageIO.write(bufferedImage, "png", new File("D:/qrcode.png"));
			
		}

	}

}
