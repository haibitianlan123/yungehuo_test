package com.yungehuo.testcase;

import com.yungehuo.common.Appilication;
import com.yungehuo.common.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginCase  {


    @BeforeTest
    public void  open(){
        Log.info("--------BeforeClass---------");
        Appilication.getInstance().start();
    }

    @BeforeClass
    public void toLogin(){
        Log.info("--------BeforeTest---------");
        Appilication.getInstance().toLogin();
    }
    @Test
    public void login(){

    }

    @AfterClass
    public void quit(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.info("--------quit---------");
        Appilication.getInstance().quit();
    }

}
