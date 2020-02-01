package com._root.config.restful;
  
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.m.model.ProductSaleEarnBean;

public class ProductSale2ExcelView extends AbstractXlsView  {
	
	Sheet sheet;	
	String sheetName = "productSaleDetail";
	HSSFFont chiTextFont = null;
	HSSFFont engTextFont = null;
	HSSFFont titleFont = null;
	int rowCount = 0;
	int colCount = 0;
	short fontSize = 16;
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		rowCount = 0;
		colCount = 0;
		setSheetProperties(workbook);
        createExcelHeaders(model, workbook);
		populateExcelCells(model, workbook);
		System.out.println("finished!!!!!");
	}

	private void setSheetProperties(Workbook workbook) {
		// 由 workbook產生Sheet物件
		sheet = workbook.createSheet(sheetName);
		// 由 workbook產生HSSFont物件
		chiTextFont= (HSSFFont)workbook.createFont();
		// 設定字型名稱
		chiTextFont.setFontName("新細明體");
		// 設定字號		
		chiTextFont.setFontHeightInPoints(fontSize);
		//--------------------------------------
		// 由 workbook產生HSSFont物件
		engTextFont= (HSSFFont)workbook.createFont();
		// 設定字型名稱
		engTextFont.setFontName("Arial");
		// 設定字號
		engTextFont.setFontHeightInPoints(fontSize);
		
		
		titleFont = chiTextFont;
	}

	private void populateExcelCells(Map<String, Object> model, Workbook workbook) {
		Sheet sheet = workbook.getSheet(sheetName);
		
		
		HSSFCellStyle styleCenter = (HSSFCellStyle)workbook.createCellStyle();
		styleCenter.setFont(engTextFont);
		
		styleCenter.setFillForegroundColor(IndexedColors.WHITE.index);
		
		CellStyle styleName = workbook.createCellStyle();
		styleName.setFillForegroundColor(IndexedColors.WHITE.index);
		styleName.setFont(chiTextFont);
		
		
		CellStyle styleRight = workbook.createCellStyle();
		styleRight.setFillForegroundColor(IndexedColors.WHITE.index);
		styleRight.setFont(engTextFont);
		
        HSSFCellStyle styleDate = (HSSFCellStyle)workbook.createCellStyle();
		
		CreationHelper createHelper = workbook.getCreationHelper();
		styleDate.setDataFormat(
		    createHelper.createDataFormat().getFormat("yyyy/mm/dd"));
		styleDate.setFont(engTextFont);
		

		
		
//		System.out.println("------>55555 ");

        List<ProductSaleEarnBean> psebList = (List<ProductSaleEarnBean>) model.get("psebDetailList");
//      System.out.println("------> " + psebList.get(0).getPrice());
		Set<String> set = model.keySet();
		Row row = null;
		Cell cell = null;
		for(ProductSaleEarnBean hsb : psebList) {
			colCount = 0;
			
			row = sheet.createRow(rowCount++);
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleName);
			cell.setCellValue(hsb.getOrderDate());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleName);
			cell.setCellValue(hsb.getPrice());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleName);
			cell.setCellValue(hsb.getQtyTotal());
			
			cell = row.createCell(colCount++);
			cell.setCellStyle(styleName);
			cell.setCellValue(hsb.getSubtotal());
			
		}
		int columnCount = sheet.getRow(0).getLastCellNum();
		for (int i=0; i < columnCount; i++){
			sheet.autoSizeColumn(i);
		}
	}

	private void createExcelHeaders(Map<String, Object> model, Workbook workbook) {
        List<ProductSaleEarnBean> psebList = (List<ProductSaleEarnBean>) model.get("psebDetailList");
		String[] labels = {"日期", "單價", "數量", "小計"};
		
		CellStyle titleStyle = workbook.createCellStyle();
		
		titleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
		titleStyle.setFont(titleFont);
		
		HSSFCellStyle styleCenter = (HSSFCellStyle)workbook.createCellStyle();
		styleCenter.setFont(engTextFont);
		styleCenter.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
		styleCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styleCenter.setAlignment(HorizontalAlignment.CENTER);
		// 建立Excel表的標頭
//		Row row = null;
//		Cell cell = null;
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(sheet.addMergedRegion(new CellRangeAddress(0,0,0,3)));
		cell.setCellStyle(styleCenter);
		cell.setCellValue(psebList.get(0).getProductsBean().getProductName());
		
		rowCount = 1;
		row = sheet.createRow(rowCount++);
		
		colCount = 0;
		// Create header cells
		for(int n =0; n < labels.length; n++) {
			cell = row.createCell(colCount++);
			cell.setCellStyle(titleStyle);
			cell.setCellValue(labels[n]);
		}
	}

}
