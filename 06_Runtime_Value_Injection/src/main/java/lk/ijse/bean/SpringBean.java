package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.spec.RSAOtherPrimeInfo;

@Component
public class SpringBean implements InitializingBean {

    @Value("Sherul-Dhanushka")
    private String name;

    public SpringBean(){
        System.out.println("SpringBean constructed");
        System.out.println(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
    }




  /*  public SpringBean(@Value("sherul_dhanushka") String name) {
        System.out.println("SpringBean constructor");
        System.out.println(name);
    }


    @Autowired
    public SpringBean(@Value("udara-san") String name, @Value("1") int id )  {
        System.out.println("SpringBean constructor");
        System.out.println(name);
        System.out.println("id");
    }*/
}
