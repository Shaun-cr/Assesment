package utility;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Data {
	//Must map path to your work environment for this to run
	static String excellPath = "C:\\Users\\shauncr\\eclipse-workspace\\Assesment\\src\\Excell\\StaticData.xls";
	static String sheetName = "Sheet1";
	
	 public static String[][] getTableArrayFromSpreadsheet(String tableName) throws Exception{
	      String[][] tableArray=null;
	      
	          Workbook workbook = Workbook.getWorkbook(new File(excellPath));
	          Sheet sheet = workbook.getSheet(sheetName); 
	          int startOfRow,startOfCol, endOfRow, endOfCol,coli,colj;
	          Cell tableStart=sheet.findCell(tableName);
	          startOfRow=tableStart.getRow();
	          startOfCol=tableStart.getColumn();

	          Cell tableEnd= sheet.findCell(tableName, startOfCol+1,startOfRow+1, 100, 64000,  false);                

	          endOfRow = tableEnd.getRow();
	          endOfCol = tableEnd.getColumn();
	          tableArray = new String[endOfRow-startOfRow-1][endOfCol-startOfCol-1];
	          coli=0;
              
	          for (int i=startOfRow+1;i<endOfRow;i++,coli++){
	              colj=0;
	              for (int j=startOfCol+1;j<endOfCol;j++,colj++){
	                  tableArray[coli][colj]=sheet.getCell(j,i).getContents();
	              }
	          }
	      
	      return(tableArray);
	  }

}
