package lk.ijse;

import lk.ijse.bean.Boy;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
    //Dependcy injection
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        lk.ijse.ci.Boy boy = (lk.ijse.ci.Boy) context.getBean("boy");
        boy.chatWithGirl();



        context.registerShutdownHook();


    }
}