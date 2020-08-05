package com.yungehuo.common;

import com.yungehuo.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.yungehuo.page.BasePage;


public class Application extends BasePage {

    private Application(){

    }

    private static class AppilicationHolder{
        private static Application application =new Application();
    }

    public static Application getInstance(){
        return AppilicationHolder.application;
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://test-pro.yungehuo.com/");
        return driver;
    }


    public LoginPage toLogin(){
        Log.info("-----------toLogin----start-----");
        parseSteps("toLogin");

        Log.info("-----------toLogin------end---");
        return new LoginPage();
    }
}
