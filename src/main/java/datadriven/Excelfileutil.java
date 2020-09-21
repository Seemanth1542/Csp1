package datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelfileutil {

	Workbook wb;
	
	public void ExcelFileUtil() throws Throwable
    {
      //FileInputStream fis = new FileInputStream("C:\\Users\\dnandan\\appiumtesting\\Rcm\\src\\main\\resources\\ExcelInput\\RCMInput.xlsx");
        //FileInputStream fis = new FileInputStream("C:\\Project-mobile\\Hybrid-mobile\\src\\main\\resources\\ExcelInput\\DemoInput.xlsx");
          
		FileInputStream fis = new FileInputStream("C:\\Any path");
        
		wb = WorkbookFactory.create(fis);
    }

    public int rowcount(String sheetname)
    {
        return wb.getSheet(sheetname).getLastRowNum();
    }

    public int cellCount(String sheetname,int row)
    {
        return wb.getSheet(sheetname).getRow(row).getLastCellNum();
    }

    public String getData(String sheetname,int row,int column)
    {
        String cellData="";
        if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()== CellType.NUMERIC)
        {
            int data =(int)(wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue());
            cellData = String.valueOf(data);
        }
        else
        {
            cellData = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
        }

        return cellData;
    }

    public void setData(String sheetname,int row,int column,String Status) throws Throwable
    {
        Sheet sh = wb.getSheet(sheetname);
        Row rownum = sh.getRow(row);
        Cell cell = rownum.createCell(column);
        cell.setCellValue(Status);

        if(Status.equalsIgnoreCase("Pass"))
        {
            //create cell style
            CellStyle style = wb.createCellStyle();

            //Create Font
            Font font = wb.createFont();

            //Apply color ot the text
            font.setColor(IndexedColors.GREEN.getIndex());

            //Apply Bold to the Text
            //font.setBold(font.);

            //set font
            style.setFont(font);

            //set cell style
            rownum.getCell(column).setCellStyle(style);
        }
        else if(Status.equalsIgnoreCase("Fail"))
        {
            CellStyle style = wb.createCellStyle();

            Font font = wb.createFont();

            font.setColor(IndexedColors.RED.getIndex());

            // font.setBoldweight(font.BOLDWEIGHT_BOLD);

            style.setFont(font);

            rownum.getCell(column).setCellStyle(style);
        }
        else if(Status.equalsIgnoreCase("Skip"))
        {
            CellStyle style = wb.createCellStyle();

            Font font = wb.createFont();

            font.setColor(IndexedColors.BLUE.getIndex());

            // font.setBoldweight(font.BOLDWEIGHT_BOLD);

            style.setFont(font);

            rownum.getCell(column).setCellStyle(style);
        }
        else if(Status.equalsIgnoreCase("Not Executed"))
        {
            CellStyle style = wb.createCellStyle();

            Font font = wb.createFont();

            font.setColor(IndexedColors.BLUE.getIndex());

            // font.setBoldweight(font.BOLDWEIGHT_BOLD);

            style.setFont(font);

            rownum.getCell(column).setCellStyle(style);
        }

        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelOutput\\OutputExcel.xlsx");
        wb.write(fos);
        fos.close();
    }
	

	
	
}


