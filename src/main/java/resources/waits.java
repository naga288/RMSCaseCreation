package resources;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import com.google.common.base.Function;

public class waits {
	public void WaitForElement(final WebDriver driver, final WebElement element) {
        FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>((RemoteWebDriver) driver);

        wait.withTimeout(Duration.ofSeconds(200));
        wait.pollingEvery(Duration.ofSeconds(3));
        
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(WebDriverException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(ElementNotVisibleException.class);
        
        List<WebElement> targetElements = wait.until(new Function<RemoteWebDriver, List<WebElement>>() {
        	String[] a = element.toString().split("xpath:");
        	   int count = driver.findElements(By.xpath(a[a.length-1])).size();

               public List<WebElement> apply(RemoteWebDriver driver) {

                      List<WebElement> elements = driver.findElements(By.xpath(a[a.length-1]));
                      int length = elements.size();

                      if (length >= 1 || count > 0) {

                            try {
                                   Thread.sleep(750);
                            } catch (InterruptedException e) {
                                   e.printStackTrace();
                            }
                            return elements;

                      }
                      return null;
               }

        });
  }

}