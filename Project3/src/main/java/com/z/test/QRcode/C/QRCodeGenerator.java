package com.z.test.QRcode.C;

import java.io.File;
import java.io.IOException;

import com.google.zxing.WriterException;

public class QRCodeGenerator {
	static QRCodeService qr = new QRCodeZServiceImpl();
    private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

    public static void main(String[] args) {
    	String text = "Dennis!!!";
        //            qr.generateQRCodeImage(text, 700, 700, QR_CODE_IMAGE_PATH);
		            File a = new File("D:\\1.jpg");
		            File codeFile =new File("D:\\1.jpg");
		            String qrUrl = "https://www.youtube.com/";
		            String note = "76666";
		            qr.drawLogoQRCode(a, codeFile, qrUrl, note);
        
//        try {
//            File file = new File("MyQRCode.png");
//            String decodedText = qr.decodeQRCode(file);
//            if(decodedText == null) {
//                System.out.println("No QR Code found in the image");
//            } else {
//                System.out.println("Decoded text = " + decodedText);
//                String[] dt = decodedText.split(",");
//                for(int i = 0; i < dt.length; i++) {
//                	System.out.println(dt[i]);
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
//        }
    }
}