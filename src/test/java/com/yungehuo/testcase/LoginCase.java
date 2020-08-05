package com.yungehuo.testcase;

import com.yungehuo.common.Application;
import com.yungehuo.common.Log;
import com.yungehuo.page.HomePage;
import com.yungehuo.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginCase  {

    LoginPage loginPage;
    HomePage homePage;
    @BeforeTest
    public void  open(){
        Log.info("--------BeforeClass---------");
        Application.getInstance().start();
    }

    @BeforeClass
    public void toLogin(){

        Log.info("--------BeforeTest---------");
        loginPage=Application.getInstance().toLogin();
    }
    @Test
    public void login(){
        homePage=loginPage.Login();

        String loginInfo=homePage.getLoginInfo();

        Assert.assertNotNull(loginInfo);
        Log.info("--------loginInfo---------"+loginInfo);
    }

    @AfterClass
    public void quit(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.info("--------quit---------");
        Application.getInstance().quit();
    }

    @AfterTest
    public void afterTest(){
        Log.info("--------afterTest---------");
    }

}
