package lk.ijse.config;

import lk.ijse.bean.SpringBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackageClasses = SpringBean.class)
@Import(AppConfig1.class)
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig Constructor");
    }
}





