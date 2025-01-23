package lk.ijse.ci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Boy implements In{

    Aggrement girl ;

    /*@Autowired //constructor injection
    public Boy(Aggrement girl) {
        this.girl = girl;
        System.out.println("Boy constructor");
    }*/

    @Autowired
    public void setter(Aggrement girl){
        this.girl = girl;
    }

    //tight coupling
    public void chatWithGirl(){
        girl.chat();
    }

    public static void main(String[] args) {

    }

    @Override
    public void setInjextion(Aggrement girl) {
        this.girl = girl;
    }
}
