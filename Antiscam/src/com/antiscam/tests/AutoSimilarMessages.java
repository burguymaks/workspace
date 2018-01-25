package com.antiscam.tests;



import java.util.regex.Pattern;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoSimilarMessages {

String pathToGeckoDriver = Paths.get("path to your executable driver here").toAbsolutePath().toString();
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);
    driver = new FirefoxDriver();
    baseUrl = "https://www-benaughty-com-rel-stage.platformphoenix.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/site/autologin/key/6f0d5e0f5e5a1ce442cae7c2966b784c");
    driver.get(baseUrl + "/user/view/id/086d86b2e90a11e79536441ea14ed80c/block/3/onlineStatus/1/element/1");
    driver.findElement(By.xpath("//div[@id='frm-user']/div[2]/div[2]/div[1]/div[4]/div[1]/a")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.name("//div[@id='cTalksInputMessage']")).clear();
    driver.findElement(By.name("//div[@id='cTalksInputMessage']")).sendKeys("asdasdasdasda");
    driver.findElement(By.id("cTalksInputSubmit")).click();
  }

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
