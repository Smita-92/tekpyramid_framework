package PractiseDarwinBox;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StockScraper {
    public static void main(String[] args)
    {
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://example.com/stock-exchange");

        try {
            while (true) {
                List<WebElement> stockRows = driver.findElements(By.cssSelector(".stock-row"));
                
                for (int i = 0; i < Math.min(10, stockRows.size()); i++) {
                    WebElement row = stockRows.get(i);
                    String stockName = row.findElement(By.cssSelector(".stock-name")).getText();
                    String stockChange = row.findElement(By.cssSelector(".stock-change")).getText();
                    String arrow = row.findElement(By.cssSelector(".stock-arrow")).getAttribute("class");
                    
                    String trend = arrow.contains("up") ? "Gaining" : "Losing";
                    System.out.println(stockName + " | " + stockChange + " | " + trend);
                }
                
                System.out.println("---------------------------------");
                Thread.sleep(180000); // Wait for 3 minutes
                driver.navigate().refresh(); // Refresh the page to get updated data
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}