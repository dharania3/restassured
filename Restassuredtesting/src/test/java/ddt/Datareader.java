package ddt;

import java.util.List;

public class Datareader {

	public static void main(String[] args) {
		readxl();
	}


	public static void readxl() {
		String fn ="C:\\Users\\HP\\eclipse-workspace\\Restassuredtesting\\src\\test\\java\\ddt\\empdata.xls";
		String[][] records = ddt.ReadXl.get(fn);
		for (String[] record : records){

				System.out.println(record[0]+" "+record[1]+" "+record[2]);
				
			}}

	
}
