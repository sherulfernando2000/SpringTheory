package lk.ijse.di;

import org.springframework.stereotype.Component;

@Component

public class Girl implements Aggrement {

    public Girl() {
        System.out.println("Girl constructor");
    }

    public void chat(){
        System.out.println("GIRL1 CHATTING");
    }
}
