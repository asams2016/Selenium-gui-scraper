import java.sql.Driver;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class scrapper {
	
	public static void main(String[]args) {
		int index = 0;
		LinkedList tasks=new LinkedList();
		String url="https://pdsm.service-now.com/nav_to.do?uri=%2Fsys_report_template.do%3Fjvar_report_id%3Dbe2519d913a0a380a81630d18144b00a%26jvar_selected_tab%3DallReports%26jvar_list_order_by%3D%26jvar_list_sort_direction%3D%26sysparm_reportquery%3D%26jvar_search_created_by%3D%26jvar_search_table%3D%26jvar_search_report_sys_id%3Dbe2519d913a0a380a81630d18144b00a%26jvar_report_home_query%3D";
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\3665697\\Desktop\\geckodriver.exe");
		FirefoxOptions fox = new FirefoxOptions();
		fox.setCapability("marionette", true);
		WebDriver d = new FirefoxDriver(fox);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(d)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		//open browser and go to url
		d.get(url);
		//if SSO is displayed log in
		if(d.findElement(By.id("username")).isDisplayed()) {
			d.findElement(By.id("username")).sendKeys("3665697");
			d.findElement(By.id("password")).sendKeys("Onieye11");
			d.findElement(By.className("ping-button")).click();
		}
		//else wait till table is loaded
		System.out.println("Accessed the site");
		new WebDriverWait(d, 30).until(
		          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		
		
		WebElement temp = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver ) {
				System.out.print("checking... ");
				 return driver.findElement(By.xpath("//tbody[contains(@class='list2_body')]"));	
			}
		});
		WebElement table= d.findElement(By.xpath("//table[contains(@class='data_list_table'])"));
		System.out.println(temp.getAttribute("innerHTML").toString());
		//List<WebElement> TotalRowCount=table.findElements(By.className("list_row"));
		//System.out.println(TotalRowCount);
		//*[@class="list_row listodd"]
		//WebElement table = d.(By.className("list2_body"));
		//System.out.println(table.getText());
		//		for(WebElement row : tableRows) {
//			System.out.println("got table rows "+row.getText());
//			  List<WebElement> cols = row.findElements(By.tagName("td"));
//		        for (WebElement col : cols) {
//		            System.out.print(col.getText() + "\t");
//		        }
//			
//		}
	
		
		
	}
	
	
}
 