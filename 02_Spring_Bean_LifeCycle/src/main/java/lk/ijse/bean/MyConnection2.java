package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


public class MyConnection2 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public MyConnection2() {
        System.out.println("MyConnection2 constructor");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("MyConnection2 setBeanName setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyConnection2 destroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyConnection2 setApplicationContext setApplicationContext");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyConnection2 setBeanFactory setBeanFactory");
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyConnection2 afterPropertiesSet");
    }


}
