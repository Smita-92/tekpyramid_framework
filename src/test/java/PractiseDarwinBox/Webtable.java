package PractiseDarwinBox;

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

public class Webtable {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.sportskeeda.com/go/international-league-t20/points-table");
		List<WebElement> alldata = driver.findElements(By.xpath("//div[@class='keeda-data-table-container']/descendant::tr/*"));
		int rowcount = driver.findElements(By.xpath("//table[@class='keeda-data-table']/descendant::td")).size();
		int column = driver.findElements(By.xpath("//table[@class='keeda-data-table']/descendant::tr/th")).size();
		int datacount=0;
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\OneDrive\\Desktop\\SportsSkeeda.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		for(int i=0;i<rowcount;i++) {
			Row row = wb.getSheet("Sheet2").createRow(i);
			for(int j=0;j<column;j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(alldata.get(datacount).getText()+" ");
				System.out.println();
				datacount++;
			}
			
		}
		FileOutputStream fos=new FileOutputStream("C:\\Users\\admin\\OneDrive\\Desktop\\SportsSkeeda.xlsx");
		wb.write(fos);
		wb.close();
		driver.quit();
		

	}

}
