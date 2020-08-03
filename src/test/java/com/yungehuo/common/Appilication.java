package com.yungehuo.common;

import com.yungehuo.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.yungehuo.page.BasePage;


public class Appilication extends BasePage {

    private Appilication(){

    }

    private static class AppilicationHolder{
        private static Appilication appilication=new Appilication();
    }

    public static Appilication getInstance(){
        return AppilicationHolder.appilication;
    }

    public void start(){
        if(driver==null){
             driver=getDriver();
        }
    }

    public void quit(){
        if(driver!=null){
            driver.close();
            driver.quit();
        }
    }


    private String getBrowser(){

        Properties prop = new Properties();
        String browser=null;
        String path=this.getClass().getCanonicalName().toString();
        Log.info("-----------path-------"+path);
        try {
            prop.load(new FileInputStream(this.getClass().getResource("/driver_info.properties").getPath()));
            browser=prop.getProperty("browser");
            Log.info("-----------browser-------"+browser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return browser;
    }

    private WebDriver getDriver(){
        String browser=getBrowser();

        if(browser!=null){
            if(browser.equals(Browser.CHROME)){
                System.setProperty("webdriver.chrome.driver",this.getClass().getResource("/chromedriver.exe").getPath());
                driver=new ChromeDriver();
            }
        }else{
            if(browser.equals(Browser.CHROME)){
//                System.setProperty("webdriver.chrome.driver",this.getClass().getResource("/chromedriver.exe").getPath());
                driver=new ChromeDriver();
            }
            Log.info("-----------打开默认浏览器Chrome---------");
        }
        driver.manage().window().maximize();
        driver.get("http://test-pro.yungehuo.com/");
        return driver;
    }


    public LoginPage toLogin(){
        Log.info("-----------toLogin----start-----");
        driver.findElement(By.linkText("企业用户登录")).click();
        Log.info("-----------toLogin------end---");
        return new LoginPage();
    }
}
