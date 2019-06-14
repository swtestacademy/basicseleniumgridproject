package com.swtestacademy;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicGridTest {
    public WebDriver driver;

    //Setup Driver
    @BeforeClass
    public void setupTest() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setPlatform(Platform.MAC);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
    }

    @Test
    public void facebookLoginButtonClick() {
        //Navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();

        //Login Button
        WebElement loginButton = driver.findElement(By.id("loginbutton"));

        //Actions example
        loginButton.click();
    }

    //Close Driver
    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}