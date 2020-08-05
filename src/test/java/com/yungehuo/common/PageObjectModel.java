package com.yungehuo.common;

import java.util.HashMap;
import java.util.List;

public class PageObjectModel {


    public HashMap<String, List<HashMap<String, String>>> getMethod() {
        return method;
    }

    public void setMethod(HashMap<String, List<HashMap<String, String>>> method) {
        this.method = method;
    }

    private  HashMap<String,List<HashMap<String,String>>> method=new HashMap<String, List<HashMap<String, String>>>();


}
