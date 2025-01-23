package lk.ijse.bean;

import org.springframework.stereotype.Component;

//@Component - ibject ekak hadala context ekata danawa...
@Component
public class SpringBean {

    public SpringBean() {
        System.out.println("SpringBean constructor");
    }

    public void sayHello(){
        System.out.println("Hello spring bean");
    }
}
