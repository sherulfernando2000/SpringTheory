package lk.ijse.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

//@Component
public class MyConnection implements DisposableBean {
    public MyConnection() {
        System.out.println("my connection constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("My connection destroy");
    }
}
