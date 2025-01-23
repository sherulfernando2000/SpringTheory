package lk.ijse.bean;

import org.springframework.stereotype.Component;

@Component

public class Girl1 implements Aggrement {

    public Girl1() {
        System.out.println("Girl constructor");
    }

    public void chat(){
        System.out.println("GIRL1 CHATTING");
    }
}
