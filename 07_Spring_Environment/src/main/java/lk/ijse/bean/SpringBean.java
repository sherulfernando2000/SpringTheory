package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean{

    @Value("${os.name}")
    private String osName;

    @Value("${USERNAME}")
    private String username;

    @Value("${db.user}")
    private String dbUser;

    @Value("${db.password}")
    private String dbPassword;
    public SpringBean() {
        System.out.println("SpringBean constructed");
        System.out.println("OS Name:"+ osName);
        System.out.println("USERNAME:"+ username);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("OS Name:"+ osName);
        System.out.println("USERNAME:"+ username);
        System.out.println("DB User:"+ dbUser);
        System.out.println("DB Password:"+ dbPassword);
    }
}
