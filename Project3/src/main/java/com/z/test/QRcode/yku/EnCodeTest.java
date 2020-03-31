package com.z.test.QRcode.yku;

import java.awt.*;
import java.awt.image.*;

import com.z.test.QRcode.yku.util.Qrcode;

//import javax.imageio.*;
public class EnCodeTest {
	private String str ;
	public EnCodeTest(String str) {
		this.str = str;
	}
	
	public BufferedImage makeqrcode() {
		
		// 設定圖檔寬度 140*140
		BufferedImage bi = new BufferedImage(200, 200,
				BufferedImage.TYPE_INT_RGB);
		try {

			// Constructor Qrcode Object
			Qrcode testQrcode = new Qrcode();
			//容錯率 M Q H 
			testQrcode.setQrcodeErrorCorrect('M');
			//字元模式,N A 或其它的A是英文,N是數字,其它是8 byte
			testQrcode.setQrcodeEncodeMode('B');
			//可使用的字串長短跟所設定的QrcodeVersion有關,越大可設定的字越多
			//0-40,0是自動
			testQrcode.setQrcodeVersion(11);

			// 設定QR Code 編碼內容
			if(str ==null){
			str = "123\r\n";
			str = str + "������ .\n";
			str = str + "�ݪ���ڼg�����\n";
			str = str + "�ڬOyku��";
			}
			// 把字串變成byte陣列
			byte[] d = str.getBytes("Utf-8");

			// createGraphics
			Graphics2D g = (Graphics2D) bi.getGraphics();

			// set background
			g.setBackground(Color.WHITE);
			g.clearRect(0, 0, 200, 200);

			// 設定字型顏色 => BLACK
			g.setColor(Color.BLACK);

			// 轉出 Bytes
			
			if (d.length > 0 && d.length < 500) {
				boolean[][] s = testQrcode.calQrcode(d);
				for (int i = 0; i < s.length; i++) {
					for (int j = 0; j < s.length; j++) {
						if (s[j][i]) {
							g.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);
						}
					}
				}
			}

			g.dispose();
			// bi.flush();

			// 如需輸出成檔案可利用以下方式
						// 設定 產生檔案路徑
						// String FilePath="c:\\TestQRCode.svg";
						// File f = new File(FilePath);

			// 產生TestQRCode JPG File
						// ImageIO.write(bi, "jpg", f);

		} // end try
		catch (Exception e) {
			e.printStackTrace();
		} // end catch
		return bi;
	}
}
