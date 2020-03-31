package com.z.test.QRcode.C;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.google.zxing.WriterException;

public interface QRCodeService {

	public void generateQRCodeImage(String text, 
			int width, int height, String filePath) throws WriterException, IOException;
	
	public byte[] getQRCodeImage(String text, int width, 
			int height) throws WriterException, IOException;
	
	public String decodeQRCode(File qrCodeimage) throws IOException;
	
	public void drawLogoQRCode(File logoFile, File codeFile, String qrUrl, String note);

	BufferedImage drawLogoQRCode(File logoFile, File codeFile, String qrUrl, String note, HttpServletResponse response);
}
