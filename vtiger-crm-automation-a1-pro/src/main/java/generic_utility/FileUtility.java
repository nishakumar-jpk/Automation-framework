package generic_utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj;

		InputStream inputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("commondata.json");
		if (inputStream != null) {
			obj = parser.parse(new InputStreamReader(inputStream));
		} else {
			FileReader fr = new FileReader("./src/test/resources/commondata.json");
			obj = parser.parse(fr);
		}

		JSONObject jObj = (JSONObject) obj;
		String value = jObj.get(key).toString();
		return value;
	}
	
	public String getDataFromExcelFile(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		String value = cell.getStringCellValue();
		return value;		
	}
}
