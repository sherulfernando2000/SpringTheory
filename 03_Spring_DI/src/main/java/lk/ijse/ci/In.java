package lk.ijse.ci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public interface In {

    @Autowired
    public void setInjextion(Aggrement aggrement);
}
