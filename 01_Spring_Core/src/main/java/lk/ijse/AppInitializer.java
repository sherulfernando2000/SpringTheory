package lk.ijse;

import lk.ijse.bean.*;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();


        context.registerShutdownHook();




        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
       *//* SpringBean springBean = new SpringBean();
        springBean.sayHello();*//*

        *//*SpringBean bean = context.getBean(SpringBean.class);
        bean.sayHello();

        SpringBean bean = context.getBean(SpringBean.class);
        System.out.println(bean);*//*

        TestBean1 testBean1 = context.getBean(TestBean1.class);
        System.out.println(testBean1);

        TestBean2 testBean2 = context.getBean(TestBean2.class);
        System.out.println(testBean2);

       //4. // context.close(); // org.springframework.context.annotation.AnnotationConfigApplicationContext@bebdb06 has been closed already

       //5.
        *//*Runtime.getRuntime().addShutdownHook(new Thread() {           //jvm eka stop wena welawe context eka close wenne
            public void run() {
                System.out.println("Shutting down");
                context.close();
            }
        });*//*


        //6.
        context.registerShutdownHook();


        *//*Object springBean = context.getBean("springBean");
        System.out.println("bean");


        TestBean3 testBean3 = context.getBean(TestBean3.class);
         System.out.println(testBean3);*//*


        //1st  latter is simple
        // springBean bean eke identification eka
        //by default name enna class eke name eka 1st latter eka simple karala
        //component eke component("bean")
        //  Object bean=context.getBean("bean");
       *//* Object bean = context.getBean("springBean");
        Object bean1 = context.getBean("testBean1");
        System.out.println(bean1);
        System.out.println(bean);
        TestBean1 testBean1 = (TestBean1) context.getBean("testBean1");
        System.out.println(testBean1);*//*



        *//*Object springBean1 = context.getBean("springBean");
        System.out.println(springBean);*//*

       *//* MyConnection connection = context.getBean(MyConnection.class);
        System.out.println(connection);*//*

        //myConnection kiyala id eka enne api eka wenas nokoroth wenas karapu eka hisConnection

        *//*MyConnection myConnection = (MyConnection) context.getBean("myConnection");
        System.out.println(myConnection);*//*

        *//*MyConnection myConnection = (MyConnection) context.getBean("hisConnection");
        System.out.println(myConnection);*//*

        *//*Object bean1 = context.getBean("TestBean1.class");
        System.out.println(bean1);

        Object bean2 = context.getBean("TestBean1.class");
        System.out.println(bean2);*//*

        *//*Object bean1 = context.getBean("prototype");
        System.out.println(bean1);

        Object bean2 = context.getBean("prototype");
        System.out.println(bean2);*//*


       *//* Object prototype = context.getBean("prototype");
        System.out.println(prototype);*//*

        context.registerShutdownHook();*/


    }
}