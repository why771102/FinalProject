package com.c.qrcode;

import java.io.File;
import java.io.IOException;

import com.google.zxing.WriterException;

public interface QRCodeService {

	public void generateQRCodeImage(String text, 
			int width, int height, String filePath) throws WriterException, IOException;
	
	public byte[] getQRCodeImage(String text, int width, 
			int height) throws WriterException, IOException;
	
	public String decodeQRCode(File qrCodeimage) throws IOException;
}
