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
public class SeleniumTestTest {
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
  public void seleniumTest() {
    driver.get("http://54.180.192.54:8080/login?from=%2F");
    driver.findElement(By.id("j_username")).sendKeys("admin");
    driver.findElement(By.name("j_password")).sendKeys("admin1!");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.cssSelector("#job_test .jenkins-table__link > span")).click();
    driver.findElement(By.linkText("Rename")).click();
  }
}
