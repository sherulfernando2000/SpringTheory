package lk.ijse;

import lk.ijse.bean.SpringBeanTwo;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);

        context.refresh();

        SpringBeanTwo ref1 = (SpringBeanTwo) context.getBean(SpringBeanTwo.class);
        SpringBeanTwo ref2 = (SpringBeanTwo) context.getBean(SpringBeanTwo.class);

        System.out.println(ref1);
        System.out.println(ref2);


        context.registerShutdownHook();
    }
}