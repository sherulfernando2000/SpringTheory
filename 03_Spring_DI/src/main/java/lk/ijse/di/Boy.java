package lk.ijse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Boy{

    @Qualifier("girl")
    @Autowired
    Aggrement girl ;
    public Boy() {
        System.out.println("Boy constructor");
    }

    //tight coupling
    public void chatWithGirl(){

        girl.chat();
    }

    public static void main(String[] args) {

    }
}
