package com.yungehuo.page;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.yungehuo.common.Log;
import com.yungehuo.common.PageObjectModel;
import com.yungehuo.common.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class BasePage {

    public static WebDriver driver;
    public static HashMap<String, Object> getResults() {
        return results;
    }

    private static HashMap<String, Object> results=new HashMap<String, Object>();

    public void
    parseSteps(String method){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        String path="/"+this.getClass().getCanonicalName().replace(".","/")+".yaml";
        Log.info("--------path---"+this.getClass().getResource(path).getPath());
        try {
            PageObjectModel model=mapper.readValue(new File(this.getClass().getResource(path).getPath()),PageObjectModel.class);
            List<HashMap<String, String>> steps = model.getMethod().get(method);

            for(int i=0;i<steps.size();i++){
                WebElement element=null;
                String m=steps.get(i).get("method");
                Log.info("--------method---"+m);
                if(m==null){
                    continue;
                }
                String m_value=steps.get(i).get("m_value");
                Log.info("--------m_value---"+m_value);

                if(m.equals(Steps.ID)){
                    element = driver.findElement(By.id(m_value));
                }else if(m.equals(Steps.XPATH)){
                    element = driver.findElement(By.xpath(m_value));
                }else if(m.equals(Steps.CLASS)){
                    element = driver.findElement(By.className(m_value));
                }else if(m.equals(Steps.CLASSES)){
                    String m_location=steps.get(i).get("m_location");
                    int location=Integer.parseInt(m_location);
                    element = driver.findElements(By.className(m_value)).get(location);
                    Log.info("--------m_location---"+m_location);
                }else if(m.equals(Steps.LINKTEXT)){
                    element = driver.findElement(By.linkText(m_value));
                }
                String action=steps.get(i).get("action");
                Log.info("--------action---"+action);
                if(action.equals(Steps.SENDKEY)){
                    String a_value=steps.get(i).get("a_value");
                    Log.info("--------a_value---"+a_value);
                    element.sendKeys(a_value);
                }else if(action.equals(Steps.CLICK)){
                    element.click();
                }else if(action.equals(Steps.GETTEXT)){
                    String text=element.getText();
                    String key=steps.get(i).get("dump");
                    getResults().put(key,text);
                }
            }
            Log.info("========method=====");
        }catch (Exception e){
            Log.error("========Exception====="+e.toString());
        }
    }


}
