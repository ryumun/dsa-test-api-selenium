package com.example.demo;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class NaverTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() throws MalformedURLException {
	
	ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--headless", "--no-sandbox", "--single-process", "--disable-dev-shm-usage");
    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void naver() {
    driver.get("https://www.naver.com/");
    driver.manage().window().setSize(new Dimension(1267, 1039));
    driver.switchTo().frame(0);
    driver.switchTo().defaultContent();
    {
      WebElement element = driver.findElement(By.cssSelector(".link_login"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".link_login")).click();
    driver.findElement(By.id("id")).sendKeys("ryumun");
    driver.findElement(By.id("pw")).click();
    driver.findElement(By.id("pw")).sendKeys("ryu864212");
    driver.findElement(By.cssSelector(".btn_text")).click();
    driver.close();
  }
}
