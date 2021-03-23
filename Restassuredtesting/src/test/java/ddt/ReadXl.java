package ddt;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadXl {
	
	public static String[][] get(String f){
		String[][] data =null;
		File file= new File(f);
		
		try {
			FileInputStream xl = new FileInputStream(file);
			HSSFWorkbook xlWb=new HSSFWorkbook(xl);
			HSSFSheet xsh = xlWb.getSheetAt(0);
			
			int nR=xsh.getLastRowNum()+1;
			int nC=xsh.getRow(0).getLastCellNum();
			data = new String[nR][nC];
			
			for (int i = 0 ; i<nR;i++) {
				HSSFRow xR=xsh.getRow(i);
				for (int j = 0 ; j<nC;j++) {
					HSSFCell xcell =xR.getCell(j);
					data[i][j]=xcell.toString();
					}}}
		catch(Exception e) {
			System.out.println("EXCEL ERROR");
		}
		return data;
	}

}
