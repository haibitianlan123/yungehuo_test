import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.yungehuo.common.PageObjectModel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestApp {
    private String name;
    private String sex;
    public static void main(String[] args) {

        String path=TestApp.class.getResource("/qiye/app/com.yungehuo.page/test.yaml").getPath();
        System.out.println(TestApp.class.getCanonicalName());
        System.out.println(path);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        try {
//            Object[][] test=mapper.readValue(TestApp.class.getResourceAsStream("/qiye/app/test/SearchPage.yaml"),Object[][].class);
//            System.out.println(test[0][0]);
//            System.out.println(test[0][1]);
//        }catch (Exception e){
//            System.out.println("error-----"+e.toString());
//
//        }
//        TypeReference<HashMap<String, com.yungehuo.common.PageObjectModel>> typeReference = new TypeReference<HashMap<String, com.yungehuo.common.PageObjectModel>>();



        HashMap<String,String> step1=new HashMap<String, String>();
        step1.put("id1","xxxxx");
        step1.put("sendkey","gggg");
        HashMap<String,String> step2=new HashMap<String, String>();
        step2.put("id2","xxxxx");
        step2.put("sendkey","gggg");
        List<HashMap<String,String>> stp1=new ArrayList<HashMap<String, String>>();
        stp1.add(step1);
        stp1.add(step2);
        List<HashMap<String,String>> stp2=new ArrayList<HashMap<String, String>>();
        stp2.add(step1);
        stp2.add(step2);

        PageObjectModel model=new PageObjectModel();


        HashMap<String,List<HashMap<String,String>>> method=new HashMap<String, List<HashMap<String, String>>>();
        method.put("search",stp1);
        method.put("cancel",stp2);
        model.setMethod(method);




        String test=null;
        try {
            mapper.writeValue(new File("t.yaml"),model);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("---------");
        }

//        try {
//            com.yungehuo.common.PageObjectModel i=mapper.readValue(new File(path), com.yungehuo.common.PageObjectModel.class);
//            List<HashMap<String,String>> steps=i.getMethod().get("search");
//            for (HashMap<String,String> step:steps){
//                String elments=step.get("elments");
//                String name=step.get("name");
//                System.out.println("----name-----"+name);
//                if(elments!=null){
//                    if(elments.equals("id")){
//                        System.out.println("---id-----");
//                    }else if(elments.equals("xpath")){
//                        System.out.println("---xpath-----");
//                    }else if(elments.equals("link")){
//                        System.out.println("---link-----");
//                    }
//                }
//                String action=step.get("action");
//                System.out.println("action-----"+action);
//                String value=step.get("value");
//                if(action!=null){
//                    if(action.equals("sendkey")){
//                        System.out.println("------sendkey----");
//                        for(Map.Entry<String, Object> kv: data.entrySet()){
//                            String matcher="${"+kv.getKey()+"}";
//                            System.out.println("------matcher----"+matcher);
//                            if(value.contains(matcher)) {
//                                System.out.println(kv);
//                                value = value.replace(matcher, kv.getValue().toString());
//                                System.out.println(value);
//                            }
//                        }
//                    }else if(action.equals("click")){
//                        System.out.println("----click----");
//                    }
//                }
//
//
//
//            }
//
//        } catch (IOException e) {
//            System.out.println("error-----");
//            e.printStackTrace();
//        }


    }
}
