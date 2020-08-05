package com.yungehuo.page;

public class LoginPage extends BasePage{


    public HomePage Login(){
        parseSteps("login");
        return new HomePage();
    }


}
