package lk.ijse.config;

import lk.ijse.bean.MyConnection;
import lk.ijse.bean.TestBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
//@ComponentScan(basePackageClasses = TestBean1.class)
public class AppConfig {
    /*public AppConfig() {
        System.out.println("AppConfig Constructor");
    }*/

    /*@Bean("hisConnection")
    public MyConnection myConnection(){
        return new MyConnection();
    }*/




}
