package PracticeTestng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicWebTable {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.sportskeeda.com/go/international-league-t20/points-table");
		List<WebElement> alldata = driver.findElements(By.xpath("//div[@class='keeda-data-table-container']/tbody/tr[*]"));

FileInputStream fis= new FileInputStream("C:\\Users\\admin\\OneDrive\\Desktop\\SportsSkeeda.xlsx");
Workbook w=WorkbookFactory.create(fis);
for(int i=0;i<alldata.size();i++) {
Row row = w.getSheet("Sheet1").createRow(i);
	List<WebElement> alldata1 = driver.findElements(By.tagName("td"));
	for(int col=0;col<alldata1.size();i++) {
	Cell cell = row.createCell(col);
	cell.setCellValue(alldata1.get(col).getText());
	}
}
FileOutputStream fos=new FileOutputStream("C:\\Users\\admin\\OneDrive\\Desktop\\SportsSkeeda.xlsx");
w.write(fos);
w.close();
	
	
	
}

	}


