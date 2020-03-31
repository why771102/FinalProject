package com.z.test.QRcode.C;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;




@Service
public class QRCodeZServiceImpl implements QRCodeService {
	
	private static final int QRCOLOR = 0xFF000000; // 預設是黑色
    private static final int BGWHITE = 0xFFFFFFFF; // 背景顏色

    private static final int WIDTH = 200; // 二維碼寬
    private static final int HEIGHT = 200; // 二維碼高
    
    
    private  Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>() {
        private static final long serialVersionUID = 1L;
        {
            put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);// 設定QR二維碼的糾錯級別（H為最高級別）具體級別資訊
            put(EncodeHintType.CHARACTER_SET, "utf-8");// 設定編碼方式
            put(EncodeHintType.MARGIN, 0);
        }
    };

	@Override
	public void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

	}

	@Override
	public byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
		 QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
	        
	        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
	        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
	        byte[] pngData = pngOutputStream.toByteArray();
	        return pngData;
	}

	@Override
	public String decodeQRCode(File qrCodeimage) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            System.out.println("There is no QR code in the image");
            return null;
        }
	}
	
	
	@Override
    public BufferedImage drawLogoQRCode(File logoFile, File codeFile, String qrUrl, String note, HttpServletResponse response) {//圖片檔案   二維碼儲存地址  網頁路徑                    二維碼說明 
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            // 引數順序分別為：編碼內容，編碼型別，生成圖片寬度，生成圖片高度，設定引數
            BitMatrix bm = multiFormatWriter.encode(qrUrl, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
            BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

            // 開始利用二維碼資料建立Bitmap圖片，分別設為黑（0xFFFFFFFF）白（0xFF000000）兩色
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    image.setRGB(x, y, bm.get(x, y) ? QRCOLOR : BGWHITE);
                }
            }
            int width = image.getWidth();
            int height = image.getHeight();
            if (Objects.nonNull(logoFile) && logoFile.exists()) {
                // 構建繪圖物件
                Graphics2D g = image.createGraphics();
                // 讀取Logo圖片
                BufferedImage logo = ImageIO.read(logoFile);
                // 開始繪製logo圖片
                g.drawImage(logo, width * 2 / 5, height * 2 / 5, width * 2 / 10, height * 2 / 10, null);
                g.dispose();
                logo.flush();
            }

            // 自定義文字描述
            if (note != null) {
                // 新的圖片，把帶logo的二維碼下面加上文字
                BufferedImage outImage = new BufferedImage(200, 240, BufferedImage.TYPE_INT_ARGB_PRE);
                Graphics2D outg = outImage.createGraphics();
                
                // 畫二維碼到新的面板
                outg.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
                outg.setBackground(Color.RED);
                // 畫文字到新的面板
                outg.setColor(Color.BLACK);
                outg.setFont(new Font("楷體", Font.BOLD, 20)); // 字型、字型、字號
                
                int strWidth = outg.getFontMetrics().stringWidth(note);
                System.out.println("strWidth : " + strWidth);
                if (strWidth > WIDTH) {
                    // //長度過長就擷取前面部分
                    // 長度過長就換行
                    String note1 = note.substring(0, note.length() / 2);
                    String note2 = note.substring(note.length() / 2, note.length());
                    int strWidth1 = outg.getFontMetrics().stringWidth(note1);
                    int strWidth2 = outg.getFontMetrics().stringWidth(note2);
                    outg.drawString(note1, 200 - strWidth1 / 2, height + (outImage.getHeight() - height) / 2 + 12);
                    BufferedImage outImage2 = new BufferedImage(400, 485, BufferedImage.TYPE_4BYTE_ABGR);
                    Graphics2D outg2 = outImage2.createGraphics();
                    outg2.drawImage(outImage, 0, 0, outImage.getWidth(), outImage.getHeight(), null);
                    outg2.setColor(Color.BLACK);
                    outg2.setFont(new Font("宋體", Font.BOLD, 30)); // 字型、字型、字號
                    outg2.drawString(note2, 200 - strWidth2 / 2,outImage.getHeight() + (outImage2.getHeight() - outImage.getHeight()) / 2 + 5);
                    outg2.dispose();
                    outImage2.flush();
                    outImage = outImage2;
                } else {
                	System.out.println("X : " + ((WIDTH / 2) - strWidth / 2));
                	System.out.println("Y : " + (height + (outImage.getHeight() - height) / 2 + 12));
                    outg.drawString(note, (WIDTH / 2) - strWidth / 2, height + (outImage.getHeight() - height) / 2 + 12); // 畫文字
                }
                outg.dispose();
                outImage.flush();
                image = outImage;
            }
//            return image;

//            image.flush();
            ServletOutputStream os = response.getOutputStream();
            
            ImageIO.write(image, "png", os); // TODO
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public void drawLogoQRCode(File logoFile, File codeFile, String qrUrl, String note) {
		// TODO Auto-generated method stub
		
	}

}
