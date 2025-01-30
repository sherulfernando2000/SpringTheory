package lk.ijse.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Girl1 implements Aggrement {

    public Girl1() {
        System.out.println("Girl1 constructor");
    }

    public void chat(){
        System.out.println("GIRL1 CHATTING");
    }
}
