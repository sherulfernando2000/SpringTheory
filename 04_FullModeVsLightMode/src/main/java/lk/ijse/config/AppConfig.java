package lk.ijse.config;

import lk.ijse.bean.SpringBeanOne;
import lk.ijse.bean.SpringBeanThree;
import lk.ijse.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {

        @Bean
        public SpringBeanTwo getSpringBeanTwo () {
            SpringBeanThree springBeanThree1 = getSpringBeanThree();
            SpringBeanThree springBeanThree2 = getSpringBeanThree();

            System.out.println(springBeanThree1);
            System.out.println(springBeanThree2);
            return new SpringBeanTwo();
        }

        @Bean
        public SpringBeanThree getSpringBeanThree(){
            return new SpringBeanThree();
        }

}





