package lk.ijse.config;

import lk.ijse.bean.SpringBean1;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackageClasses = SpringBean1.class)
public class AppConfig1 {
    public AppConfig1() {
        System.out.println("AppConfig1 constructor");
    }
}

