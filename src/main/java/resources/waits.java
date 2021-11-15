/*package resources;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class waits {
	public static void WaitForElement(WebDriver driver, final List<WebElement> webElement) {
		
        FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>((RemoteWebDriver) driver);

        wait.withTimeout(Duration.ofSeconds(200));
        wait.pollingEvery(Duration.ofSeconds(3));
        
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(WebDriverException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(ElementNotVisibleException.class);
        
          List<WebElement> targetElements = wait.until(new Function<RemoteWebDriver, List<WebElement>>() {
              int count = targetElements.size();

               public List<WebElement> apply(RemoteWebDriver driver) {

                      List<WebElement> elements =  webElement;
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

}*/