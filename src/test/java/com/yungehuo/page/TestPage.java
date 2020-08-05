package com.yungehuo.page;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.yungehuo.common.PageObjectModel;

public class TestPage {

    public static void main(String[] args) {
        PageObjectModel model=null;
//        HashMap<String, List<HashMap<String,String>>> methods=new HashMap<String, List<HashMap<String, String>>>();
//        List<HashMap<String,String>> mapList1=new ArrayList<HashMap<String, String>>();
//        HashMap<String,String> m1=new HashMap<String,String>();
//        m1.put("method","id1");
//        m1.put("m_value","login1");
//        HashMap<String,String> m2=new HashMap<String,String>();
//        m2.put("method","id2");
//        m2.put("m_value","login2");
//
//        mapList1.add(m1);
//        mapList1.add(m2);
//        methods.put("login",mapList1);
//
//        List<HashMap<String,String>> mapList2=new ArrayList<HashMap<String, String>>();
//
//        mapList2.add(m1);
//        mapList2.add(m2);
//        methods.put("sign_out",mapList2);
//
//        model.setMethod(methods);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        try {
//            mapper.writeValue(new File("demo.yaml"), model);
//        }catch (Exception e){
//            Log.error("========Exception=====");
//        }

        String path= TestPage.class.getResource("/com/yungehuo/page/TestWeb.yaml").getPath();
        System.out.println("------path--="+path);
        System.out.println(TestPage.class.getCanonicalName());
//        try {
//            model=mapper.readValue(new File("demo.yaml"),
//                    model.getClass());
//
//        }catch (Exception e){
//            Log.error("========Exception====="+e.getMessage());
//        }

        mapper.toString();




    }
}
