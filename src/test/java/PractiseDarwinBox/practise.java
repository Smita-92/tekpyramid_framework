package PractiseDarwinBox;

import java.io.FileInputStream;
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

public class practise {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.sportskeeda.com/go/international-league-t20/points-table");
		List<WebElement> alldata = driver.findElements(By.xpath("//div[@class='keeda-data-table-container']/descendant::tr/*"));
		
		int rowCount = driver.findElements(By.xpath("//div[@class='keeda-data-table-container']/descendant::tr")).size();
		int colCount = driver.findElements(By.xpath("//div[@class='keeda-data-table-container']/descendant::tr/th")).size();
		
		int dataCount=0;
		FileInputStream fis= new FileInputStream("C:\\Users\\admin\\OneDrive\\Desktop\\SportsSkeeda.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		for (int i = 0; i < rowCount; i++) {
			Row row = w.getSheet("Sheet1").createRow(i);

			for (int col = 0; col <colCount; col++) {
					Cell cell = row.createCell(col);
					cell.setCellValue(alldata.get(dataCount).getText());
				System.out.print(alldata.get(dataCount).getText()+" ");
				dataCount++;
			}
			System.out.println();
		}
		FileOutputStream fos=new FileOutputStream("C:\\Users\\admin\\OneDrive\\Desktop\\SportsSkeeda.xlsx");
		w.write(fos);
		w.close();
	}

}
