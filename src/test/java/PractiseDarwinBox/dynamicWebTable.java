package PractiseDarwinBox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicWebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.sportskeeda.com/go/international-league-t20/points-table");
		List<WebElement> alldata = driver
				.findElements(By.xpath("//table[@class='keeda-data-table']/tbody/tr[position()<=5]"));
		for (WebElement data : alldata) {

			System.out.print(data.getText());

		}

		List<WebElement> alldata1 = driver
				.findElements(By.xpath("//table[@class='keeda-data-table']/tbody/tr[position()>=last()-5]"));
		System.out.println("==================================");
		for (WebElement data1 : alldata) {

			System.out.print(data1.getText());
			

		}
		driver.quit();
	}
}