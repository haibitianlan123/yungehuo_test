package com.yungehuo.page;

public class HomePage extends BasePage{


    public String getLoginInfo(){
        parseSteps("getLoginInfo");
        return getResults().get("loginInfo").toString();
    }

}
