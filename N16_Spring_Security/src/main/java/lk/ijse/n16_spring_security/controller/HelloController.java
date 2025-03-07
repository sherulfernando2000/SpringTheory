package lk.ijse.n16_spring_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping
    public String sayHello(HttpServletRequest request){
        return "Hello Spring Security - " + request.getSession().getId();

    }


}
