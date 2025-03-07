package lk.ijse.n16_spring_security.controller;

import lk.ijse.n16_spring_security.entity.Users;
import lk.ijse.n16_spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public Users saveUser(@RequestBody Users user){

        return userService.saveUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody Users user){
        //System.out.println(user);
        //return "Success";
        return userService.verifyUser(user);
    }
}
