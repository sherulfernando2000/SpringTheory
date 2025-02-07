package lk.ijse;

import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Properties;


public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);

        Map<String, String> getenv = System.getenv();
        for (String key : getenv.keySet()) {
            System.out.println(key + "=" + getenv.get(key) );
        }
        System.out.println("PROCESSOR_LEVEL");

        //Access predefined properties from java
        Properties properties = System.getProperties();

        for (String key : properties.stringPropertyNames()) {
            System.out.println(key + "=" + properties.getProperty(key));
        }

       // System.out.println(System.getProperty("os.name"));

        context.refresh();
        context.registerShutdownHook();
    }
}