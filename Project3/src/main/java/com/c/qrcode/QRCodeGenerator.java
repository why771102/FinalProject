package com.c.qrcode;

import java.io.File;
import java.io.IOException;

import com.google.zxing.WriterException;

public class QRCodeGenerator {
	static QRCodeService qr = new QRCodeServiceImpl();
    private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

    public static void main(String[] args) {
    	Integer ticketno = 1;
    	Integer showTimeID = 1;
    	String seatID = "AA01";
//    	String text = ticketno + "," + showTimeID + "," + seatID;
    	String text = "Dennis!!!";
        try {
            
            qr.generateQRCodeImage(text, 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
        
        try {
            File file = new File("MyQRCode.png");
            String decodedText = qr.decodeQRCode(file);
            if(decodedText == null) {
                System.out.println("No QR Code found in the image");
            } else {
                System.out.println("Decoded text = " + decodedText);
                String[] dt = decodedText.split(",");
                for(int i = 0; i < dt.length; i++) {
                	System.out.println(dt[i]);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
        }
    }
}